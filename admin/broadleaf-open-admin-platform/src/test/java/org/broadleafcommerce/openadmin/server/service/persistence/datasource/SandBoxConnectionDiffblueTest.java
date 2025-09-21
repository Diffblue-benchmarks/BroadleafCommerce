/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.openadmin.server.service.persistence.datasource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import javax.sql.rowset.serial.SerialArray;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialClob;
import javax.sql.rowset.serial.SerialStruct;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class SandBoxConnectionDiffblueTest {
  @Mock private Connection connection;

  @InjectMocks private SandBoxConnection sandBoxConnection;

  /**
   * Test {@link SandBoxConnection#SandBoxConnection(Connection, GenericObjectPool)}.
   *
   * <p>Method under test: {@link SandBoxConnection#SandBoxConnection(Connection,
   * GenericObjectPool)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SandBoxConnection.<init>(Connection, GenericObjectPool)"})
  public void testNewSandBoxConnection() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);

    // Act
    SandBoxConnection actualSandBoxConnection =
        new SandBoxConnection(delegate, new GenericObjectPool());

    // Assert
    assertNull(actualSandBoxConnection.getCatalog());
    assertNull(actualSandBoxConnection.getMetaData());
    assertNull(actualSandBoxConnection.getWarnings());
    assertNull(actualSandBoxConnection.getClientInfo());
    assertEquals(0, actualSandBoxConnection.getHoldability());
    assertEquals(0, actualSandBoxConnection.getNetworkTimeout());
    assertEquals(0, actualSandBoxConnection.getTransactionIsolation());
    assertFalse(actualSandBoxConnection.getAutoCommit());
    assertFalse(actualSandBoxConnection.isClosed());
    assertFalse(actualSandBoxConnection.isReadOnly());
    assertTrue(actualSandBoxConnection.getTypeMap().isEmpty());
  }

  /**
   * Test {@link SandBoxConnection#unwrap(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#unwrap(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SandBoxConnection.unwrap(Class)"})
  public void testUnwrap_whenJavaLangObject_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());
    Class<Object> iface = Object.class;

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.unwrap(iface));
  }

  /**
   * Test {@link SandBoxConnection#isWrapperFor(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#isWrapperFor(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SandBoxConnection.isWrapperFor(Class)"})
  public void testIsWrapperFor_whenJavaLangObject_thenReturnFalse() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());
    Class<Object> iface = Object.class;

    // Act and Assert
    assertFalse(sandBoxConnection.isWrapperFor(iface));
  }

  /**
   * Test {@link SandBoxConnection#isWrapperFor(Class)}.
   *
   * <ul>
   *   <li>When {@code Connection}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#isWrapperFor(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SandBoxConnection.isWrapperFor(Class)"})
  public void testIsWrapperFor_whenJavaSqlConnection_thenReturnTrue() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());
    Class<Connection> iface = Connection.class;

    // Act and Assert
    assertTrue(sandBoxConnection.isWrapperFor(iface));
  }

  /**
   * Test {@link SandBoxConnection#createStatement(int, int)} with {@code resultSetType}, {@code
   * resultSetConcurrency}.
   *
   * <p>Method under test: {@link SandBoxConnection#createStatement(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Statement SandBoxConnection.createStatement(int, int)"})
  public void testCreateStatementWithResultSetTypeResultSetConcurrency() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createStatement(anyInt(), anyInt())).thenReturn(mock(Statement.class));
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    sandBoxConnection.createStatement(1, 1);

    // Assert
    verify(delegate).createStatement(1, 1);
  }

  /**
   * Test {@link SandBoxConnection#createStatement(int, int, int)} with {@code resultSetType},
   * {@code resultSetConcurrency}, {@code resultSetHoldability}.
   *
   * <p>Method under test: {@link SandBoxConnection#createStatement(int, int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Statement SandBoxConnection.createStatement(int, int, int)"})
  public void testCreateStatementWithResultSetTypeResultSetConcurrencyResultSetHoldability()
      throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createStatement(anyInt(), anyInt(), anyInt())).thenReturn(mock(Statement.class));
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    sandBoxConnection.createStatement(1, 1, 1);

    // Assert
    verify(delegate).createStatement(1, 1, 1);
  }

  /**
   * Test {@link SandBoxConnection#createStatement(int, int, int)} with {@code resultSetType},
   * {@code resultSetConcurrency}, {@code resultSetHoldability}.
   *
   * <p>Method under test: {@link SandBoxConnection#createStatement(int, int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Statement SandBoxConnection.createStatement(int, int, int)"})
  public void testCreateStatementWithResultSetTypeResultSetConcurrencyResultSetHoldability2()
      throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createStatement(anyInt(), anyInt(), anyInt())).thenThrow(new SQLException());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.createStatement(1, 1, 1));
    verify(delegate).createStatement(1, 1, 1);
  }

  /**
   * Test {@link SandBoxConnection#createStatement(int, int)} with {@code resultSetType}, {@code
   * resultSetConcurrency}.
   *
   * <ul>
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#createStatement(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Statement SandBoxConnection.createStatement(int, int)"})
  public void testCreateStatementWithResultSetTypeResultSetConcurrency_thenThrowSQLException()
      throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createStatement(anyInt(), anyInt())).thenThrow(new SQLException());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.createStatement(1, 1));
    verify(delegate).createStatement(1, 1);
  }

  /**
   * Test {@link SandBoxConnection#createStatement()}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#createStatement()} return {@link Statement}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#createStatement()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Statement SandBoxConnection.createStatement()"})
  public void testCreateStatement_givenConnectionCreateStatementReturnStatement()
      throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createStatement()).thenReturn(mock(Statement.class));
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    sandBoxConnection.createStatement();

    // Assert
    verify(delegate).createStatement();
  }

  /**
   * Test {@link SandBoxConnection#createStatement()}.
   *
   * <ul>
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#createStatement()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Statement SandBoxConnection.createStatement()"})
  public void testCreateStatement_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createStatement()).thenThrow(new SQLException());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.createStatement());
    verify(delegate).createStatement();
  }

  /**
   * Test {@link SandBoxConnection#prepareStatement(String)} with {@code sql}.
   *
   * <p>Method under test: {@link SandBoxConnection#prepareStatement(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PreparedStatement SandBoxConnection.prepareStatement(String)"})
  public void testPrepareStatementWithSql() throws SQLException {
    // Arrange
    when(connection.prepareStatement(Mockito.<String>any()))
        .thenReturn(mock(PreparedStatement.class));

    // Act
    sandBoxConnection.prepareStatement("Sql");

    // Assert
    verify(connection).prepareStatement("Sql");
  }

  /**
   * Test {@link SandBoxConnection#prepareStatement(String, int)} with {@code sql}, {@code
   * autoGeneratedKeys}.
   *
   * <p>Method under test: {@link SandBoxConnection#prepareStatement(String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PreparedStatement SandBoxConnection.prepareStatement(String, int)"})
  public void testPrepareStatementWithSqlAutoGeneratedKeys() throws SQLException {
    // Arrange
    when(connection.prepareStatement(Mockito.<String>any(), anyInt()))
        .thenReturn(mock(PreparedStatement.class));

    // Act
    sandBoxConnection.prepareStatement("Sql", 1);

    // Assert
    verify(connection).prepareStatement("Sql", 1);
  }

  /**
   * Test {@link SandBoxConnection#prepareStatement(String, int)} with {@code sql}, {@code
   * autoGeneratedKeys}.
   *
   * <ul>
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#prepareStatement(String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PreparedStatement SandBoxConnection.prepareStatement(String, int)"})
  public void testPrepareStatementWithSqlAutoGeneratedKeys_thenThrowSQLException()
      throws SQLException {
    // Arrange
    when(connection.prepareStatement(Mockito.<String>any(), anyInt()))
        .thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.prepareStatement("Sql", 1));
    verify(connection).prepareStatement("Sql", 1);
  }

  /**
   * Test {@link SandBoxConnection#prepareStatement(String, int[])} with {@code sql}, {@code
   * columnIndexes}.
   *
   * <p>Method under test: {@link SandBoxConnection#prepareStatement(String, int[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PreparedStatement SandBoxConnection.prepareStatement(String, int[])"})
  public void testPrepareStatementWithSqlColumnIndexes() throws SQLException {
    // Arrange
    when(connection.prepareStatement(Mockito.<String>any(), Mockito.<int[]>any()))
        .thenReturn(mock(PreparedStatement.class));

    // Act
    sandBoxConnection.prepareStatement("Sql", new int[] {1, -1, 1, -1});

    // Assert
    verify(connection).prepareStatement(eq("Sql"), isA(int[].class));
  }

  /**
   * Test {@link SandBoxConnection#prepareStatement(String, int[])} with {@code sql}, {@code
   * columnIndexes}.
   *
   * <ul>
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#prepareStatement(String, int[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PreparedStatement SandBoxConnection.prepareStatement(String, int[])"})
  public void testPrepareStatementWithSqlColumnIndexes_thenThrowSQLException() throws SQLException {
    // Arrange
    when(connection.prepareStatement(Mockito.<String>any(), Mockito.<int[]>any()))
        .thenThrow(new SQLException());

    // Act and Assert
    assertThrows(
        SQLException.class,
        () -> sandBoxConnection.prepareStatement("Sql", new int[] {1, -1, 1, -1}));
    verify(connection).prepareStatement(eq("Sql"), isA(int[].class));
  }

  /**
   * Test {@link SandBoxConnection#prepareStatement(String, String[])} with {@code sql}, {@code
   * columnNames}.
   *
   * <p>Method under test: {@link SandBoxConnection#prepareStatement(String, String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PreparedStatement SandBoxConnection.prepareStatement(String, String[])"})
  public void testPrepareStatementWithSqlColumnNames() throws SQLException {
    // Arrange
    when(connection.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(mock(PreparedStatement.class));

    // Act
    sandBoxConnection.prepareStatement("Sql", new String[] {"Column Names"});

    // Assert
    verify(connection).prepareStatement(eq("Sql"), isA(String[].class));
  }

  /**
   * Test {@link SandBoxConnection#prepareStatement(String, String[])} with {@code sql}, {@code
   * columnNames}.
   *
   * <ul>
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#prepareStatement(String, String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PreparedStatement SandBoxConnection.prepareStatement(String, String[])"})
  public void testPrepareStatementWithSqlColumnNames_thenThrowSQLException() throws SQLException {
    // Arrange
    when(connection.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenThrow(new SQLException());

    // Act and Assert
    assertThrows(
        SQLException.class,
        () -> sandBoxConnection.prepareStatement("Sql", new String[] {"Column Names"}));
    verify(connection).prepareStatement(eq("Sql"), isA(String[].class));
  }

  /**
   * Test {@link SandBoxConnection#prepareStatement(String, int, int)} with {@code sql}, {@code
   * resultSetType}, {@code resultSetConcurrency}.
   *
   * <p>Method under test: {@link SandBoxConnection#prepareStatement(String, int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PreparedStatement SandBoxConnection.prepareStatement(String, int, int)"})
  public void testPrepareStatementWithSqlResultSetTypeResultSetConcurrency() throws SQLException {
    // Arrange
    when(connection.prepareStatement(Mockito.<String>any(), anyInt(), anyInt()))
        .thenReturn(mock(PreparedStatement.class));

    // Act
    sandBoxConnection.prepareStatement("Sql", 1, 1);

    // Assert
    verify(connection).prepareStatement("Sql", 1, 1);
  }

  /**
   * Test {@link SandBoxConnection#prepareStatement(String, int, int)} with {@code sql}, {@code
   * resultSetType}, {@code resultSetConcurrency}.
   *
   * <p>Method under test: {@link SandBoxConnection#prepareStatement(String, int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PreparedStatement SandBoxConnection.prepareStatement(String, int, int)"})
  public void testPrepareStatementWithSqlResultSetTypeResultSetConcurrency2() throws SQLException {
    // Arrange
    when(connection.prepareStatement(Mockito.<String>any(), anyInt(), anyInt()))
        .thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.prepareStatement("Sql", 1, 1));
    verify(connection).prepareStatement("Sql", 1, 1);
  }

  /**
   * Test {@link SandBoxConnection#prepareStatement(String, int, int, int)} with {@code sql}, {@code
   * resultSetType}, {@code resultSetConcurrency}, {@code resultSetHoldability}.
   *
   * <p>Method under test: {@link SandBoxConnection#prepareStatement(String, int, int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PreparedStatement SandBoxConnection.prepareStatement(String, int, int, int)"})
  public void testPrepareStatementWithSqlResultSetTypeResultSetConcurrencyResultSetHoldability()
      throws SQLException {
    // Arrange
    when(connection.prepareStatement(Mockito.<String>any(), anyInt(), anyInt(), anyInt()))
        .thenReturn(mock(PreparedStatement.class));

    // Act
    sandBoxConnection.prepareStatement("Sql", 1, 1, 1);

    // Assert
    verify(connection).prepareStatement("Sql", 1, 1, 1);
  }

  /**
   * Test {@link SandBoxConnection#prepareStatement(String, int, int, int)} with {@code sql}, {@code
   * resultSetType}, {@code resultSetConcurrency}, {@code resultSetHoldability}.
   *
   * <p>Method under test: {@link SandBoxConnection#prepareStatement(String, int, int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PreparedStatement SandBoxConnection.prepareStatement(String, int, int, int)"})
  public void testPrepareStatementWithSqlResultSetTypeResultSetConcurrencyResultSetHoldability2()
      throws SQLException {
    // Arrange
    when(connection.prepareStatement(Mockito.<String>any(), anyInt(), anyInt(), anyInt()))
        .thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.prepareStatement("Sql", 1, 1, 1));
    verify(connection).prepareStatement("Sql", 1, 1, 1);
  }

  /**
   * Test {@link SandBoxConnection#prepareStatement(String)} with {@code sql}.
   *
   * <ul>
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#prepareStatement(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PreparedStatement SandBoxConnection.prepareStatement(String)"})
  public void testPrepareStatementWithSql_thenThrowSQLException() throws SQLException {
    // Arrange
    when(connection.prepareStatement(Mockito.<String>any())).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.prepareStatement("Sql"));
    verify(connection).prepareStatement("Sql");
  }

  /**
   * Test {@link SandBoxConnection#prepareCall(String, int, int)} with {@code sql}, {@code
   * resultSetType}, {@code resultSetConcurrency}.
   *
   * <p>Method under test: {@link SandBoxConnection#prepareCall(String, int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CallableStatement SandBoxConnection.prepareCall(String, int, int)"})
  public void testPrepareCallWithSqlResultSetTypeResultSetConcurrency() throws SQLException {
    // Arrange
    when(connection.prepareCall(Mockito.<String>any(), anyInt(), anyInt()))
        .thenReturn(mock(CallableStatement.class));

    // Act
    sandBoxConnection.prepareCall("Sql", 1, 1);

    // Assert
    verify(connection).prepareCall("Sql", 1, 1);
  }

  /**
   * Test {@link SandBoxConnection#prepareCall(String, int, int, int)} with {@code sql}, {@code
   * resultSetType}, {@code resultSetConcurrency}, {@code resultSetHoldability}.
   *
   * <p>Method under test: {@link SandBoxConnection#prepareCall(String, int, int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CallableStatement SandBoxConnection.prepareCall(String, int, int, int)"})
  public void testPrepareCallWithSqlResultSetTypeResultSetConcurrencyResultSetHoldability()
      throws SQLException {
    // Arrange
    when(connection.prepareCall(Mockito.<String>any(), anyInt(), anyInt(), anyInt()))
        .thenReturn(mock(CallableStatement.class));

    // Act
    sandBoxConnection.prepareCall("Sql", 1, 1, 1);

    // Assert
    verify(connection).prepareCall("Sql", 1, 1, 1);
  }

  /**
   * Test {@link SandBoxConnection#prepareCall(String, int, int, int)} with {@code sql}, {@code
   * resultSetType}, {@code resultSetConcurrency}, {@code resultSetHoldability}.
   *
   * <p>Method under test: {@link SandBoxConnection#prepareCall(String, int, int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CallableStatement SandBoxConnection.prepareCall(String, int, int, int)"})
  public void testPrepareCallWithSqlResultSetTypeResultSetConcurrencyResultSetHoldability2()
      throws SQLException {
    // Arrange
    when(connection.prepareCall(Mockito.<String>any(), anyInt(), anyInt(), anyInt()))
        .thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.prepareCall("Sql", 1, 1, 1));
    verify(connection).prepareCall("Sql", 1, 1, 1);
  }

  /**
   * Test {@link SandBoxConnection#prepareCall(String, int, int)} with {@code sql}, {@code
   * resultSetType}, {@code resultSetConcurrency}.
   *
   * <ul>
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#prepareCall(String, int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CallableStatement SandBoxConnection.prepareCall(String, int, int)"})
  public void testPrepareCallWithSqlResultSetTypeResultSetConcurrency_thenThrowSQLException()
      throws SQLException {
    // Arrange
    when(connection.prepareCall(Mockito.<String>any(), anyInt(), anyInt()))
        .thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.prepareCall("Sql", 1, 1));
    verify(connection).prepareCall("Sql", 1, 1);
  }

  /**
   * Test {@link SandBoxConnection#prepareCall(String)} with {@code sql}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#prepareCall(String)} return {@link
   *       CallableStatement}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#prepareCall(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CallableStatement SandBoxConnection.prepareCall(String)"})
  public void testPrepareCallWithSql_givenConnectionPrepareCallReturnCallableStatement()
      throws SQLException {
    // Arrange
    when(connection.prepareCall(Mockito.<String>any())).thenReturn(mock(CallableStatement.class));

    // Act
    sandBoxConnection.prepareCall("Sql");

    // Assert
    verify(connection).prepareCall("Sql");
  }

  /**
   * Test {@link SandBoxConnection#prepareCall(String)} with {@code sql}.
   *
   * <ul>
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#prepareCall(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CallableStatement SandBoxConnection.prepareCall(String)"})
  public void testPrepareCallWithSql_thenThrowSQLException() throws SQLException {
    // Arrange
    when(connection.prepareCall(Mockito.<String>any())).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.prepareCall("Sql"));
    verify(connection).prepareCall("Sql");
  }

  /**
   * Test {@link SandBoxConnection#nativeSQL(String)}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#nativeSQL(String)} return {@code Native SQL}.
   *   <li>Then return {@code Native SQL}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#nativeSQL(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SandBoxConnection.nativeSQL(String)"})
  public void testNativeSQL_givenConnectionNativeSQLReturnNativeSql_thenReturnNativeSql()
      throws SQLException {
    // Arrange
    when(connection.nativeSQL(Mockito.<String>any())).thenReturn("Native SQL");

    // Act
    String actualNativeSQLResult = sandBoxConnection.nativeSQL("Sql");

    // Assert
    verify(connection).nativeSQL("Sql");
    assertEquals("Native SQL", actualNativeSQLResult);
  }

  /**
   * Test {@link SandBoxConnection#nativeSQL(String)}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#nativeSQL(String)} throw {@link
   *       SQLException#SQLException()}.
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#nativeSQL(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SandBoxConnection.nativeSQL(String)"})
  public void testNativeSQL_givenConnectionNativeSQLThrowSQLException_thenThrowSQLException()
      throws SQLException {
    // Arrange
    when(connection.nativeSQL(Mockito.<String>any())).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.nativeSQL("Sql"));
    verify(connection).nativeSQL("Sql");
  }

  /**
   * Test {@link SandBoxConnection#setAutoCommit(boolean)}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#setAutoCommit(boolean)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#setAutoCommit(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SandBoxConnection.setAutoCommit(boolean)"})
  public void testSetAutoCommit_givenConnectionSetAutoCommitDoesNothing() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doNothing().when(delegate).setAutoCommit(anyBoolean());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    sandBoxConnection.setAutoCommit(true);

    // Assert
    verify(delegate).setAutoCommit(true);
  }

  /**
   * Test {@link SandBoxConnection#setAutoCommit(boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#setAutoCommit(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SandBoxConnection.setAutoCommit(boolean)"})
  public void testSetAutoCommit_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doThrow(new SQLException()).when(delegate).setAutoCommit(anyBoolean());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.setAutoCommit(true));
    verify(delegate).setAutoCommit(true);
  }

  /**
   * Test {@link SandBoxConnection#getTypeMap()}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#getTypeMap()} return {@link
   *       HashMap#HashMap()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#getTypeMap()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map SandBoxConnection.getTypeMap()"})
  public void testGetTypeMap_givenConnectionGetTypeMapReturnHashMap_thenReturnEmpty()
      throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    Mockito.<Map<String, Class<?>>>when(delegate.getTypeMap()).thenReturn(new HashMap<>());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    Map<String, Class<?>> actualTypeMap = sandBoxConnection.getTypeMap();

    // Assert
    verify(delegate).getTypeMap();
    assertTrue(actualTypeMap.isEmpty());
  }

  /**
   * Test {@link SandBoxConnection#getTypeMap()}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#getTypeMap()} throw {@link
   *       SQLException#SQLException()}.
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#getTypeMap()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map SandBoxConnection.getTypeMap()"})
  public void testGetTypeMap_givenConnectionGetTypeMapThrowSQLException_thenThrowSQLException()
      throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    Mockito.<Map<String, Class<?>>>when(delegate.getTypeMap()).thenThrow(new SQLException());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.getTypeMap());
    verify(delegate).getTypeMap();
  }

  /**
   * Test {@link SandBoxConnection#setHoldability(int)}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#setHoldability(int)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#setHoldability(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SandBoxConnection.setHoldability(int)"})
  public void testSetHoldability_givenConnectionSetHoldabilityDoesNothing() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doNothing().when(delegate).setHoldability(anyInt());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    sandBoxConnection.setHoldability(1);

    // Assert
    verify(delegate).setHoldability(1);
  }

  /**
   * Test {@link SandBoxConnection#setHoldability(int)}.
   *
   * <ul>
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#setHoldability(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SandBoxConnection.setHoldability(int)"})
  public void testSetHoldability_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doThrow(new SQLException()).when(delegate).setHoldability(anyInt());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.setHoldability(1));
    verify(delegate).setHoldability(1);
  }

  /**
   * Test {@link SandBoxConnection#getHoldability()}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#getHoldability()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#getHoldability()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int SandBoxConnection.getHoldability()"})
  public void testGetHoldability_givenConnectionGetHoldabilityReturnOne_thenReturnOne()
      throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getHoldability()).thenReturn(1);
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    int actualHoldability = sandBoxConnection.getHoldability();

    // Assert
    verify(delegate).getHoldability();
    assertEquals(1, actualHoldability);
  }

  /**
   * Test {@link SandBoxConnection#getHoldability()}.
   *
   * <ul>
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#getHoldability()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int SandBoxConnection.getHoldability()"})
  public void testGetHoldability_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getHoldability()).thenThrow(new SQLException());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.getHoldability());
    verify(delegate).getHoldability();
  }

  /**
   * Test {@link SandBoxConnection#setSavepoint(String)} with {@code String}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#setSavepoint(String)} return {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#setSavepoint(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Savepoint SandBoxConnection.setSavepoint(String)"})
  public void testSetSavepointWithString_givenConnectionSetSavepointReturnNull_thenReturnNull()
      throws SQLException {
    // Arrange
    when(connection.setSavepoint(Mockito.<String>any())).thenReturn(null);

    // Act
    Savepoint actualSetSavepointResult = sandBoxConnection.setSavepoint("Name");

    // Assert
    verify(connection).setSavepoint("Name");
    assertNull(actualSetSavepointResult);
  }

  /**
   * Test {@link SandBoxConnection#setSavepoint(String)} with {@code String}.
   *
   * <ul>
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#setSavepoint(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Savepoint SandBoxConnection.setSavepoint(String)"})
  public void testSetSavepointWithString_thenThrowSQLException() throws SQLException {
    // Arrange
    when(connection.setSavepoint(Mockito.<String>any())).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.setSavepoint("Name"));
    verify(connection).setSavepoint("Name");
  }

  /**
   * Test {@link SandBoxConnection#setSavepoint()}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#setSavepoint()} return {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#setSavepoint()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Savepoint SandBoxConnection.setSavepoint()"})
  public void testSetSavepoint_givenConnectionSetSavepointReturnNull_thenReturnNull()
      throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.setSavepoint()).thenReturn(null);
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    Savepoint actualSetSavepointResult = sandBoxConnection.setSavepoint();

    // Assert
    verify(delegate).setSavepoint();
    assertNull(actualSetSavepointResult);
  }

  /**
   * Test {@link SandBoxConnection#setSavepoint()}.
   *
   * <ul>
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#setSavepoint()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Savepoint SandBoxConnection.setSavepoint()"})
  public void testSetSavepoint_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.setSavepoint()).thenThrow(new SQLException());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.setSavepoint());
    verify(delegate).setSavepoint();
  }

  /**
   * Test {@link SandBoxConnection#releaseSavepoint(Savepoint)}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#releaseSavepoint(Savepoint)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#releaseSavepoint(Savepoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SandBoxConnection.releaseSavepoint(Savepoint)"})
  public void testReleaseSavepoint_givenConnectionReleaseSavepointDoesNothing()
      throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doNothing().when(delegate).releaseSavepoint(Mockito.<Savepoint>any());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    sandBoxConnection.releaseSavepoint(null);

    // Assert
    verify(delegate).releaseSavepoint(isNull());
  }

  /**
   * Test {@link SandBoxConnection#releaseSavepoint(Savepoint)}.
   *
   * <ul>
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#releaseSavepoint(Savepoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SandBoxConnection.releaseSavepoint(Savepoint)"})
  public void testReleaseSavepoint_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doThrow(new SQLException()).when(delegate).releaseSavepoint(Mockito.<Savepoint>any());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.releaseSavepoint(null));
    verify(delegate).releaseSavepoint(isNull());
  }

  /**
   * Test {@link SandBoxConnection#getAutoCommit()}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#getAutoCommit()} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#getAutoCommit()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SandBoxConnection.getAutoCommit()"})
  public void testGetAutoCommit_givenConnectionGetAutoCommitReturnFalse_thenReturnFalse()
      throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getAutoCommit()).thenReturn(false);
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    boolean actualAutoCommit = sandBoxConnection.getAutoCommit();

    // Assert
    verify(delegate).getAutoCommit();
    assertFalse(actualAutoCommit);
  }

  /**
   * Test {@link SandBoxConnection#getAutoCommit()}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#getAutoCommit()} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#getAutoCommit()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SandBoxConnection.getAutoCommit()"})
  public void testGetAutoCommit_givenConnectionGetAutoCommitReturnTrue_thenReturnTrue()
      throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getAutoCommit()).thenReturn(true);
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    boolean actualAutoCommit = sandBoxConnection.getAutoCommit();

    // Assert
    verify(delegate).getAutoCommit();
    assertTrue(actualAutoCommit);
  }

  /**
   * Test {@link SandBoxConnection#getAutoCommit()}.
   *
   * <ul>
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#getAutoCommit()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SandBoxConnection.getAutoCommit()"})
  public void testGetAutoCommit_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getAutoCommit()).thenThrow(new SQLException());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.getAutoCommit());
    verify(delegate).getAutoCommit();
  }

  /**
   * Test {@link SandBoxConnection#commit()}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#commit()} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#commit()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SandBoxConnection.commit()"})
  public void testCommit_givenConnectionCommitDoesNothing() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doNothing().when(delegate).commit();
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    sandBoxConnection.commit();

    // Assert
    verify(delegate).commit();
  }

  /**
   * Test {@link SandBoxConnection#commit()}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#commit()} throw {@link
   *       SQLException#SQLException()}.
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#commit()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SandBoxConnection.commit()"})
  public void testCommit_givenConnectionCommitThrowSQLException_thenThrowSQLException()
      throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doThrow(new SQLException()).when(delegate).commit();
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.commit());
    verify(delegate).commit();
  }

  /**
   * Test {@link SandBoxConnection#rollback(Savepoint)} with {@code Savepoint}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#rollback(Savepoint)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#rollback(Savepoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SandBoxConnection.rollback(Savepoint)"})
  public void testRollbackWithSavepoint_givenConnectionRollbackDoesNothing() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doNothing().when(delegate).rollback(Mockito.<Savepoint>any());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    sandBoxConnection.rollback(null);

    // Assert
    verify(delegate).rollback(isNull());
  }

  /**
   * Test {@link SandBoxConnection#rollback(Savepoint)} with {@code Savepoint}.
   *
   * <ul>
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#rollback(Savepoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SandBoxConnection.rollback(Savepoint)"})
  public void testRollbackWithSavepoint_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doThrow(new SQLException()).when(delegate).rollback(Mockito.<Savepoint>any());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.rollback(null));
    verify(delegate).rollback(isNull());
  }

  /**
   * Test {@link SandBoxConnection#rollback()}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#rollback()} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#rollback()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SandBoxConnection.rollback()"})
  public void testRollback_givenConnectionRollbackDoesNothing() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doNothing().when(delegate).rollback();
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    sandBoxConnection.rollback();

    // Assert
    verify(delegate).rollback();
  }

  /**
   * Test {@link SandBoxConnection#rollback()}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#rollback()} throw {@link
   *       SQLException#SQLException()}.
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#rollback()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SandBoxConnection.rollback()"})
  public void testRollback_givenConnectionRollbackThrowSQLException_thenThrowSQLException()
      throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doThrow(new SQLException()).when(delegate).rollback();
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.rollback());
    verify(delegate).rollback();
  }

  /**
   * Test {@link SandBoxConnection#isClosed()}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#isClosed()} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#isClosed()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SandBoxConnection.isClosed()"})
  public void testIsClosed_givenConnectionIsClosedReturnFalse_thenReturnFalse()
      throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.isClosed()).thenReturn(false);
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    boolean actualIsClosedResult = sandBoxConnection.isClosed();

    // Assert
    verify(delegate).isClosed();
    assertFalse(actualIsClosedResult);
  }

  /**
   * Test {@link SandBoxConnection#isClosed()}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#isClosed()} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#isClosed()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SandBoxConnection.isClosed()"})
  public void testIsClosed_givenConnectionIsClosedReturnTrue_thenReturnTrue() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.isClosed()).thenReturn(true);
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    boolean actualIsClosedResult = sandBoxConnection.isClosed();

    // Assert
    verify(delegate).isClosed();
    assertTrue(actualIsClosedResult);
  }

  /**
   * Test {@link SandBoxConnection#isClosed()}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#isClosed()} throw {@link
   *       SQLException#SQLException()}.
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#isClosed()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SandBoxConnection.isClosed()"})
  public void testIsClosed_givenConnectionIsClosedThrowSQLException_thenThrowSQLException()
      throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.isClosed()).thenThrow(new SQLException());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.isClosed());
    verify(delegate).isClosed();
  }

  /**
   * Test {@link SandBoxConnection#getMetaData()}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#getMetaData()} return {@link
   *       DatabaseMetaData}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#getMetaData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DatabaseMetaData SandBoxConnection.getMetaData()"})
  public void testGetMetaData_givenConnectionGetMetaDataReturnDatabaseMetaData()
      throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getMetaData()).thenReturn(mock(DatabaseMetaData.class));
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    sandBoxConnection.getMetaData();

    // Assert
    verify(delegate).getMetaData();
  }

  /**
   * Test {@link SandBoxConnection#getMetaData()}.
   *
   * <ul>
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#getMetaData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DatabaseMetaData SandBoxConnection.getMetaData()"})
  public void testGetMetaData_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getMetaData()).thenThrow(new SQLException());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.getMetaData());
    verify(delegate).getMetaData();
  }

  /**
   * Test {@link SandBoxConnection#setReadOnly(boolean)}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#setReadOnly(boolean)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#setReadOnly(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SandBoxConnection.setReadOnly(boolean)"})
  public void testSetReadOnly_givenConnectionSetReadOnlyDoesNothing() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doNothing().when(delegate).setReadOnly(anyBoolean());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    sandBoxConnection.setReadOnly(true);

    // Assert
    verify(delegate).setReadOnly(true);
  }

  /**
   * Test {@link SandBoxConnection#setReadOnly(boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#setReadOnly(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SandBoxConnection.setReadOnly(boolean)"})
  public void testSetReadOnly_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doThrow(new SQLException()).when(delegate).setReadOnly(anyBoolean());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.setReadOnly(true));
    verify(delegate).setReadOnly(true);
  }

  /**
   * Test {@link SandBoxConnection#isReadOnly()}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#isReadOnly()} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#isReadOnly()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SandBoxConnection.isReadOnly()"})
  public void testIsReadOnly_givenConnectionIsReadOnlyReturnFalse_thenReturnFalse()
      throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.isReadOnly()).thenReturn(false);
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    boolean actualIsReadOnlyResult = sandBoxConnection.isReadOnly();

    // Assert
    verify(delegate).isReadOnly();
    assertFalse(actualIsReadOnlyResult);
  }

  /**
   * Test {@link SandBoxConnection#isReadOnly()}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#isReadOnly()} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#isReadOnly()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SandBoxConnection.isReadOnly()"})
  public void testIsReadOnly_givenConnectionIsReadOnlyReturnTrue_thenReturnTrue()
      throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.isReadOnly()).thenReturn(true);
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    boolean actualIsReadOnlyResult = sandBoxConnection.isReadOnly();

    // Assert
    verify(delegate).isReadOnly();
    assertTrue(actualIsReadOnlyResult);
  }

  /**
   * Test {@link SandBoxConnection#isReadOnly()}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#isReadOnly()} throw {@link
   *       SQLException#SQLException()}.
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#isReadOnly()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SandBoxConnection.isReadOnly()"})
  public void testIsReadOnly_givenConnectionIsReadOnlyThrowSQLException_thenThrowSQLException()
      throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.isReadOnly()).thenThrow(new SQLException());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.isReadOnly());
    verify(delegate).isReadOnly();
  }

  /**
   * Test {@link SandBoxConnection#setCatalog(String)}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#setCatalog(String)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#setCatalog(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SandBoxConnection.setCatalog(String)"})
  public void testSetCatalog_givenConnectionSetCatalogDoesNothing() throws SQLException {
    // Arrange
    doNothing().when(connection).setCatalog(Mockito.<String>any());

    // Act
    sandBoxConnection.setCatalog("Catalog");

    // Assert
    verify(connection).setCatalog("Catalog");
  }

  /**
   * Test {@link SandBoxConnection#setCatalog(String)}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#setCatalog(String)} throw {@link
   *       SQLException#SQLException()}.
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#setCatalog(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SandBoxConnection.setCatalog(String)"})
  public void testSetCatalog_givenConnectionSetCatalogThrowSQLException_thenThrowSQLException()
      throws SQLException {
    // Arrange
    doThrow(new SQLException()).when(connection).setCatalog(Mockito.<String>any());

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.setCatalog("Catalog"));
    verify(connection).setCatalog("Catalog");
  }

  /**
   * Test {@link SandBoxConnection#getCatalog()}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#getCatalog()} return {@code Catalog}.
   *   <li>Then return {@code Catalog}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#getCatalog()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SandBoxConnection.getCatalog()"})
  public void testGetCatalog_givenConnectionGetCatalogReturnCatalog_thenReturnCatalog()
      throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getCatalog()).thenReturn("Catalog");
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    String actualCatalog = sandBoxConnection.getCatalog();

    // Assert
    verify(delegate).getCatalog();
    assertEquals("Catalog", actualCatalog);
  }

  /**
   * Test {@link SandBoxConnection#getCatalog()}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#getCatalog()} throw {@link
   *       SQLException#SQLException()}.
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#getCatalog()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SandBoxConnection.getCatalog()"})
  public void testGetCatalog_givenConnectionGetCatalogThrowSQLException_thenThrowSQLException()
      throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getCatalog()).thenThrow(new SQLException());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.getCatalog());
    verify(delegate).getCatalog();
  }

  /**
   * Test {@link SandBoxConnection#setTransactionIsolation(int)}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#setTransactionIsolation(int)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#setTransactionIsolation(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SandBoxConnection.setTransactionIsolation(int)"})
  public void testSetTransactionIsolation_givenConnectionSetTransactionIsolationDoesNothing()
      throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doNothing().when(delegate).setTransactionIsolation(anyInt());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    sandBoxConnection.setTransactionIsolation(1);

    // Assert
    verify(delegate).setTransactionIsolation(1);
  }

  /**
   * Test {@link SandBoxConnection#setTransactionIsolation(int)}.
   *
   * <ul>
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#setTransactionIsolation(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SandBoxConnection.setTransactionIsolation(int)"})
  public void testSetTransactionIsolation_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doThrow(new SQLException()).when(delegate).setTransactionIsolation(anyInt());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.setTransactionIsolation(1));
    verify(delegate).setTransactionIsolation(1);
  }

  /**
   * Test {@link SandBoxConnection#getTransactionIsolation()}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#getTransactionIsolation()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int SandBoxConnection.getTransactionIsolation()"})
  public void testGetTransactionIsolation_thenReturnOne() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getTransactionIsolation()).thenReturn(1);
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    int actualTransactionIsolation = sandBoxConnection.getTransactionIsolation();

    // Assert
    verify(delegate).getTransactionIsolation();
    assertEquals(1, actualTransactionIsolation);
  }

  /**
   * Test {@link SandBoxConnection#getTransactionIsolation()}.
   *
   * <ul>
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#getTransactionIsolation()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int SandBoxConnection.getTransactionIsolation()"})
  public void testGetTransactionIsolation_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getTransactionIsolation()).thenThrow(new SQLException());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.getTransactionIsolation());
    verify(delegate).getTransactionIsolation();
  }

  /**
   * Test {@link SandBoxConnection#getWarnings()}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#getWarnings()} return {@link
   *       SQLWarning#SQLWarning()}.
   *   <li>Then return {@link SQLWarning#SQLWarning()}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#getWarnings()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SQLWarning SandBoxConnection.getWarnings()"})
  public void testGetWarnings_givenConnectionGetWarningsReturnSQLWarning_thenReturnSQLWarning()
      throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    SQLWarning sqlWarning = new SQLWarning();
    when(delegate.getWarnings()).thenReturn(sqlWarning);
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    SQLWarning actualWarnings = sandBoxConnection.getWarnings();

    // Assert
    verify(delegate).getWarnings();
    assertSame(sqlWarning, actualWarnings);
  }

  /**
   * Test {@link SandBoxConnection#getWarnings()}.
   *
   * <ul>
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#getWarnings()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SQLWarning SandBoxConnection.getWarnings()"})
  public void testGetWarnings_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getWarnings()).thenThrow(new SQLException());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.getWarnings());
    verify(delegate).getWarnings();
  }

  /**
   * Test {@link SandBoxConnection#clearWarnings()}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#clearWarnings()} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#clearWarnings()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SandBoxConnection.clearWarnings()"})
  public void testClearWarnings_givenConnectionClearWarningsDoesNothing() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doNothing().when(delegate).clearWarnings();
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    sandBoxConnection.clearWarnings();

    // Assert
    verify(delegate).clearWarnings();
  }

  /**
   * Test {@link SandBoxConnection#clearWarnings()}.
   *
   * <ul>
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#clearWarnings()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SandBoxConnection.clearWarnings()"})
  public void testClearWarnings_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doThrow(new SQLException()).when(delegate).clearWarnings();
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.clearWarnings());
    verify(delegate).clearWarnings();
  }

  /**
   * Test {@link SandBoxConnection#createClob()}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#createClob()} throw {@link
   *       SQLException#SQLException()}.
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#createClob()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Clob SandBoxConnection.createClob()"})
  public void testCreateClob_givenConnectionCreateClobThrowSQLException_thenThrowSQLException()
      throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createClob()).thenThrow(new SQLException());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.createClob());
    verify(delegate).createClob();
  }

  /**
   * Test {@link SandBoxConnection#createClob()}.
   *
   * <ul>
   *   <li>Then return {@link SerialClob#SerialClob(char[])} with ch is {@code AZAZ} toCharArray.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#createClob()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Clob SandBoxConnection.createClob()"})
  public void testCreateClob_thenReturnSerialClobWithChIsAzazToCharArray() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    SerialClob serialClob = new SerialClob("AZAZ".toCharArray());
    when(delegate.createClob()).thenReturn(serialClob);
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    Clob actualCreateClobResult = sandBoxConnection.createClob();

    // Assert
    verify(delegate).createClob();
    assertSame(serialClob, actualCreateClobResult);
  }

  /**
   * Test {@link SandBoxConnection#createBlob()}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#createBlob()} throw {@link
   *       SQLException#SQLException()}.
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#createBlob()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Blob SandBoxConnection.createBlob()"})
  public void testCreateBlob_givenConnectionCreateBlobThrowSQLException_thenThrowSQLException()
      throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createBlob()).thenThrow(new SQLException());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.createBlob());
    verify(delegate).createBlob();
  }

  /**
   * Test {@link SandBoxConnection#createBlob()}.
   *
   * <ul>
   *   <li>Then return {@link SerialBlob#SerialBlob(byte[])} with b is {@code AXAXAXAX} Bytes is
   *       {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#createBlob()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Blob SandBoxConnection.createBlob()"})
  public void testCreateBlob_thenReturnSerialBlobWithBIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    SerialBlob serialBlob = new SerialBlob("AXAXAXAX".getBytes("UTF-8"));
    when(delegate.createBlob()).thenReturn(serialBlob);
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    Blob actualCreateBlobResult = sandBoxConnection.createBlob();

    // Assert
    verify(delegate).createBlob();
    assertSame(serialBlob, actualCreateBlobResult);
  }

  /**
   * Test {@link SandBoxConnection#createNClob()}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#createNClob()} return {@link NClob}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#createNClob()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NClob SandBoxConnection.createNClob()"})
  public void testCreateNClob_givenConnectionCreateNClobReturnNClob() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createNClob()).thenReturn(mock(NClob.class));
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    sandBoxConnection.createNClob();

    // Assert
    verify(delegate).createNClob();
  }

  /**
   * Test {@link SandBoxConnection#createNClob()}.
   *
   * <ul>
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#createNClob()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NClob SandBoxConnection.createNClob()"})
  public void testCreateNClob_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createNClob()).thenThrow(new SQLException());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.createNClob());
    verify(delegate).createNClob();
  }

  /**
   * Test {@link SandBoxConnection#createSQLXML()}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#createSQLXML()} return {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#createSQLXML()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SQLXML SandBoxConnection.createSQLXML()"})
  public void testCreateSQLXML_givenConnectionCreateSQLXMLReturnNull_thenReturnNull()
      throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createSQLXML()).thenReturn(null);
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    SQLXML actualCreateSQLXMLResult = sandBoxConnection.createSQLXML();

    // Assert
    verify(delegate).createSQLXML();
    assertNull(actualCreateSQLXMLResult);
  }

  /**
   * Test {@link SandBoxConnection#createSQLXML()}.
   *
   * <ul>
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#createSQLXML()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SQLXML SandBoxConnection.createSQLXML()"})
  public void testCreateSQLXML_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createSQLXML()).thenThrow(new SQLException());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.createSQLXML());
    verify(delegate).createSQLXML();
  }

  /**
   * Test {@link SandBoxConnection#isValid(int)}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#isValid(int)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#isValid(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SandBoxConnection.isValid(int)"})
  public void testIsValid_givenConnectionIsValidReturnFalse_thenReturnFalse() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.isValid(anyInt())).thenReturn(false);
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    boolean actualIsValidResult = sandBoxConnection.isValid(10);

    // Assert
    verify(delegate).isValid(10);
    assertFalse(actualIsValidResult);
  }

  /**
   * Test {@link SandBoxConnection#isValid(int)}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#isValid(int)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#isValid(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SandBoxConnection.isValid(int)"})
  public void testIsValid_givenConnectionIsValidReturnTrue_thenReturnTrue() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.isValid(anyInt())).thenReturn(true);
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    boolean actualIsValidResult = sandBoxConnection.isValid(10);

    // Assert
    verify(delegate).isValid(10);
    assertTrue(actualIsValidResult);
  }

  /**
   * Test {@link SandBoxConnection#isValid(int)}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#isValid(int)} throw {@link
   *       SQLException#SQLException()}.
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#isValid(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SandBoxConnection.isValid(int)"})
  public void testIsValid_givenConnectionIsValidThrowSQLException_thenThrowSQLException()
      throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.isValid(anyInt())).thenThrow(new SQLException());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.isValid(10));
    verify(delegate).isValid(10);
  }

  /**
   * Test {@link SandBoxConnection#setClientInfo(String, String)} with {@code name}, {@code value}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#setClientInfo(String, String)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#setClientInfo(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SandBoxConnection.setClientInfo(String, String)"})
  public void testSetClientInfoWithNameValue_givenConnectionSetClientInfoDoesNothing()
      throws SQLClientInfoException {
    // Arrange
    doNothing().when(connection).setClientInfo(Mockito.<String>any(), Mockito.<String>any());

    // Act
    sandBoxConnection.setClientInfo("Name", "42");

    // Assert
    verify(connection).setClientInfo("Name", "42");
  }

  /**
   * Test {@link SandBoxConnection#setClientInfo(String, String)} with {@code name}, {@code value}.
   *
   * <ul>
   *   <li>Then throw {@link SecurityException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#setClientInfo(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SandBoxConnection.setClientInfo(String, String)"})
  public void testSetClientInfoWithNameValue_thenThrowSecurityException()
      throws SQLClientInfoException {
    // Arrange
    doThrow(new SecurityException())
        .when(connection)
        .setClientInfo(Mockito.<String>any(), Mockito.<String>any());

    // Act and Assert
    assertThrows(SecurityException.class, () -> sandBoxConnection.setClientInfo("Name", "42"));
    verify(connection).setClientInfo("Name", "42");
  }

  /**
   * Test {@link SandBoxConnection#setClientInfo(Properties)} with {@code properties}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#setClientInfo(Properties)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#setClientInfo(Properties)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SandBoxConnection.setClientInfo(Properties)"})
  public void testSetClientInfoWithProperties_givenConnectionSetClientInfoDoesNothing()
      throws SQLClientInfoException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doNothing().when(delegate).setClientInfo(Mockito.<Properties>any());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    sandBoxConnection.setClientInfo(new Properties());

    // Assert
    verify(delegate).setClientInfo(isA(Properties.class));
  }

  /**
   * Test {@link SandBoxConnection#setClientInfo(Properties)} with {@code properties}.
   *
   * <ul>
   *   <li>Then throw {@link SecurityException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#setClientInfo(Properties)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SandBoxConnection.setClientInfo(Properties)"})
  public void testSetClientInfoWithProperties_thenThrowSecurityException()
      throws SQLClientInfoException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doThrow(new SecurityException()).when(delegate).setClientInfo(Mockito.<Properties>any());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act and Assert
    assertThrows(SecurityException.class, () -> sandBoxConnection.setClientInfo(new Properties()));
    verify(delegate).setClientInfo(isA(Properties.class));
  }

  /**
   * Test {@link SandBoxConnection#getClientInfo(String)} with {@code String}.
   *
   * <ul>
   *   <li>Then return {@code Client Info}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#getClientInfo(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SandBoxConnection.getClientInfo(String)"})
  public void testGetClientInfoWithString_thenReturnClientInfo() throws SQLException {
    // Arrange
    when(connection.getClientInfo(Mockito.<String>any())).thenReturn("Client Info");

    // Act
    String actualClientInfo = sandBoxConnection.getClientInfo("Name");

    // Assert
    verify(connection).getClientInfo("Name");
    assertEquals("Client Info", actualClientInfo);
  }

  /**
   * Test {@link SandBoxConnection#getClientInfo(String)} with {@code String}.
   *
   * <ul>
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#getClientInfo(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SandBoxConnection.getClientInfo(String)"})
  public void testGetClientInfoWithString_thenThrowSQLException() throws SQLException {
    // Arrange
    when(connection.getClientInfo(Mockito.<String>any())).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.getClientInfo("Name"));
    verify(connection).getClientInfo("Name");
  }

  /**
   * Test {@link SandBoxConnection#getClientInfo()}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#getClientInfo()} return {@link
   *       Properties#Properties()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#getClientInfo()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Properties SandBoxConnection.getClientInfo()"})
  public void testGetClientInfo_givenConnectionGetClientInfoReturnProperties_thenReturnEmpty()
      throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    Properties properties = new Properties();
    when(delegate.getClientInfo()).thenReturn(properties);
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    Properties actualClientInfo = sandBoxConnection.getClientInfo();

    // Assert
    verify(delegate).getClientInfo();
    assertTrue(actualClientInfo.isEmpty());
    assertSame(properties, actualClientInfo);
  }

  /**
   * Test {@link SandBoxConnection#getClientInfo()}.
   *
   * <ul>
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#getClientInfo()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Properties SandBoxConnection.getClientInfo()"})
  public void testGetClientInfo_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getClientInfo()).thenThrow(new SQLException());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.getClientInfo());
    verify(delegate).getClientInfo();
  }

  /**
   * Test {@link SandBoxConnection#createArrayOf(String, Object[])}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#createArrayOf(String, Object[])} return {@link
   *       SerialArray}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#createArrayOf(String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.sql.Array SandBoxConnection.createArrayOf(String, Object[])"})
  public void testCreateArrayOf_givenConnectionCreateArrayOfReturnSerialArray()
      throws SQLException {
    // Arrange
    when(connection.createArrayOf(Mockito.<String>any(), Mockito.<Object[]>any()))
        .thenReturn(mock(SerialArray.class));

    // Act
    sandBoxConnection.createArrayOf("Type Name", new Object[] {"Elements"});

    // Assert
    verify(connection).createArrayOf(eq("Type Name"), isA(Object[].class));
  }

  /**
   * Test {@link SandBoxConnection#createArrayOf(String, Object[])}.
   *
   * <ul>
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#createArrayOf(String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.sql.Array SandBoxConnection.createArrayOf(String, Object[])"})
  public void testCreateArrayOf_thenThrowSQLException() throws SQLException {
    // Arrange
    when(connection.createArrayOf(Mockito.<String>any(), Mockito.<Object[]>any()))
        .thenThrow(new SQLException());

    // Act and Assert
    assertThrows(
        SQLException.class,
        () -> sandBoxConnection.createArrayOf("Type Name", new Object[] {"Elements"}));
    verify(connection).createArrayOf(eq("Type Name"), isA(Object[].class));
  }

  /**
   * Test {@link SandBoxConnection#createStruct(String, Object[])}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#createStruct(String, Object[])} return {@link
   *       SerialStruct}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#createStruct(String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.sql.Struct SandBoxConnection.createStruct(String, Object[])"})
  public void testCreateStruct_givenConnectionCreateStructReturnSerialStruct() throws SQLException {
    // Arrange
    when(connection.createStruct(Mockito.<String>any(), Mockito.<Object[]>any()))
        .thenReturn(mock(SerialStruct.class));

    // Act
    sandBoxConnection.createStruct("Type Name", new Object[] {"Attributes"});

    // Assert
    verify(connection).createStruct(eq("Type Name"), isA(Object[].class));
  }

  /**
   * Test {@link SandBoxConnection#createStruct(String, Object[])}.
   *
   * <ul>
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#createStruct(String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.sql.Struct SandBoxConnection.createStruct(String, Object[])"})
  public void testCreateStruct_thenThrowSQLException() throws SQLException {
    // Arrange
    when(connection.createStruct(Mockito.<String>any(), Mockito.<Object[]>any()))
        .thenThrow(new SQLException());

    // Act and Assert
    assertThrows(
        SQLException.class,
        () -> sandBoxConnection.createStruct("Type Name", new Object[] {"Attributes"}));
    verify(connection).createStruct(eq("Type Name"), isA(Object[].class));
  }

  /**
   * Test {@link SandBoxConnection#setSchema(String)}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#setSchema(String)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#setSchema(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SandBoxConnection.setSchema(String)"})
  public void testSetSchema_givenConnectionSetSchemaDoesNothing() throws SQLException {
    // Arrange
    doNothing().when(connection).setSchema(Mockito.<String>any());

    // Act
    sandBoxConnection.setSchema("Schema");

    // Assert
    verify(connection).setSchema("Schema");
  }

  /**
   * Test {@link SandBoxConnection#setSchema(String)}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#setSchema(String)} throw {@link
   *       SQLException#SQLException()}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#setSchema(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SandBoxConnection.setSchema(String)"})
  public void testSetSchema_givenConnectionSetSchemaThrowSQLException() throws SQLException {
    // Arrange
    doThrow(new SQLException()).when(connection).setSchema(Mockito.<String>any());

    // Act
    sandBoxConnection.setSchema("Schema");

    // Assert
    verify(connection).setSchema("Schema");
  }

  /**
   * Test {@link SandBoxConnection#getSchema()}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#getSchema()} return {@code Schema}.
   *   <li>Then return {@code Schema}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#getSchema()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SandBoxConnection.getSchema()"})
  public void testGetSchema_givenConnectionGetSchemaReturnSchema_thenReturnSchema()
      throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getSchema()).thenReturn("Schema");
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    String actualSchema = sandBoxConnection.getSchema();

    // Assert
    verify(delegate).getSchema();
    assertEquals("Schema", actualSchema);
  }

  /**
   * Test {@link SandBoxConnection#getSchema()}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#getSchema()} throw {@link
   *       SQLException#SQLException()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#getSchema()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SandBoxConnection.getSchema()"})
  public void testGetSchema_givenConnectionGetSchemaThrowSQLException_thenReturnNull()
      throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getSchema()).thenThrow(new SQLException());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    String actualSchema = sandBoxConnection.getSchema();

    // Assert
    verify(delegate).getSchema();
    assertNull(actualSchema);
  }

  /**
   * Test {@link SandBoxConnection#abort(Executor)}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#abort(Executor)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#abort(Executor)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SandBoxConnection.abort(Executor)"})
  public void testAbort_givenConnectionAbortDoesNothing() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doNothing().when(delegate).abort(Mockito.<Executor>any());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    sandBoxConnection.abort(mock(Executor.class));

    // Assert
    verify(delegate).abort(isA(Executor.class));
  }

  /**
   * Test {@link SandBoxConnection#abort(Executor)}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#abort(Executor)} throw {@link
   *       SQLException#SQLException()}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#abort(Executor)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SandBoxConnection.abort(Executor)"})
  public void testAbort_givenConnectionAbortThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doThrow(new SQLException()).when(delegate).abort(Mockito.<Executor>any());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    sandBoxConnection.abort(mock(Executor.class));

    // Assert
    verify(delegate).abort(isA(Executor.class));
  }

  /**
   * Test {@link SandBoxConnection#setNetworkTimeout(Executor, int)}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#setNetworkTimeout(Executor, int)} does
   *       nothing.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#setNetworkTimeout(Executor, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SandBoxConnection.setNetworkTimeout(Executor, int)"})
  public void testSetNetworkTimeout_givenConnectionSetNetworkTimeoutDoesNothing()
      throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doNothing().when(delegate).setNetworkTimeout(Mockito.<Executor>any(), anyInt());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    sandBoxConnection.setNetworkTimeout(mock(Executor.class), 1000);

    // Assert
    verify(delegate).setNetworkTimeout(isA(Executor.class), eq(1000));
  }

  /**
   * Test {@link SandBoxConnection#setNetworkTimeout(Executor, int)}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#setNetworkTimeout(Executor, int)} throw {@link
   *       SQLException#SQLException()}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#setNetworkTimeout(Executor, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SandBoxConnection.setNetworkTimeout(Executor, int)"})
  public void testSetNetworkTimeout_givenConnectionSetNetworkTimeoutThrowSQLException()
      throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doThrow(new SQLException()).when(delegate).setNetworkTimeout(Mockito.<Executor>any(), anyInt());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    sandBoxConnection.setNetworkTimeout(mock(Executor.class), 1000);

    // Assert
    verify(delegate).setNetworkTimeout(isA(Executor.class), eq(1000));
  }

  /**
   * Test {@link SandBoxConnection#getNetworkTimeout()}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#getNetworkTimeout()} return ten.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#getNetworkTimeout()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int SandBoxConnection.getNetworkTimeout()"})
  public void testGetNetworkTimeout_givenConnectionGetNetworkTimeoutReturnTen_thenReturnTen()
      throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getNetworkTimeout()).thenReturn(10);
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    int actualNetworkTimeout = sandBoxConnection.getNetworkTimeout();

    // Assert
    verify(delegate).getNetworkTimeout();
    assertEquals(10, actualNetworkTimeout);
  }

  /**
   * Test {@link SandBoxConnection#getNetworkTimeout()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxConnection#getNetworkTimeout()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int SandBoxConnection.getNetworkTimeout()"})
  public void testGetNetworkTimeout_thenReturnZero() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getNetworkTimeout()).thenThrow(new SQLException());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    int actualNetworkTimeout = sandBoxConnection.getNetworkTimeout();

    // Assert
    verify(delegate).getNetworkTimeout();
    assertEquals(0, actualNetworkTimeout);
  }
}

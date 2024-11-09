/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Array;
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
import java.sql.Struct;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.junit.Test;
import org.mockito.Mockito;

public class SandBoxConnectionDiffblueTest {
  /**
   * Test
   * {@link SandBoxConnection#SandBoxConnection(Connection, GenericObjectPool)}.
   * <p>
   * Method under test:
   * {@link SandBoxConnection#SandBoxConnection(Connection, GenericObjectPool)}
   */
  @Test
  public void testNewSandBoxConnection() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);

    // Act
    SandBoxConnection actualSandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

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
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#unwrap(Class)}
   */
  @Test
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
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#isWrapperFor(Class)}
   */
  @Test
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
   * <ul>
   *   <li>When {@code java.sql.Connection}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#isWrapperFor(Class)}
   */
  @Test
  public void testIsWrapperFor_whenJavaSqlConnection_thenReturnTrue() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());
    Class<Connection> iface = Connection.class;

    // Act and Assert
    assertTrue(sandBoxConnection.isWrapperFor(iface));
  }

  /**
   * Test {@link SandBoxConnection#createStatement(int, int)} with
   * {@code resultSetType}, {@code resultSetConcurrency}.
   * <p>
   * Method under test: {@link SandBoxConnection#createStatement(int, int)}
   */
  @Test
  public void testCreateStatementWithResultSetTypeResultSetConcurrency() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createStatement(anyInt(), anyInt())).thenReturn(mock(Statement.class));

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).createStatement(1, 1);

    // Assert
    verify(delegate).createStatement(eq(1), eq(1));
  }

  /**
   * Test {@link SandBoxConnection#createStatement(int, int, int)} with
   * {@code resultSetType}, {@code resultSetConcurrency},
   * {@code resultSetHoldability}.
   * <p>
   * Method under test: {@link SandBoxConnection#createStatement(int, int, int)}
   */
  @Test
  public void testCreateStatementWithResultSetTypeResultSetConcurrencyResultSetHoldability() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createStatement(anyInt(), anyInt(), anyInt())).thenReturn(mock(Statement.class));

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).createStatement(1, 1, 1);

    // Assert
    verify(delegate).createStatement(eq(1), eq(1), eq(1));
  }

  /**
   * Test {@link SandBoxConnection#createStatement(int, int, int)} with
   * {@code resultSetType}, {@code resultSetConcurrency},
   * {@code resultSetHoldability}.
   * <p>
   * Method under test: {@link SandBoxConnection#createStatement(int, int, int)}
   */
  @Test
  public void testCreateStatementWithResultSetTypeResultSetConcurrencyResultSetHoldability2() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createStatement(anyInt(), anyInt(), anyInt())).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class,
        () -> (new SandBoxConnection(delegate, new GenericObjectPool())).createStatement(1, 1, 1));
    verify(delegate).createStatement(eq(1), eq(1), eq(1));
  }

  /**
   * Test {@link SandBoxConnection#createStatement(int, int)} with
   * {@code resultSetType}, {@code resultSetConcurrency}.
   * <ul>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#createStatement(int, int)}
   */
  @Test
  public void testCreateStatementWithResultSetTypeResultSetConcurrency_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createStatement(anyInt(), anyInt())).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class,
        () -> (new SandBoxConnection(delegate, new GenericObjectPool())).createStatement(1, 1));
    verify(delegate).createStatement(eq(1), eq(1));
  }

  /**
   * Test {@link SandBoxConnection#createStatement()}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#createStatement()} return
   * {@link Statement}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#createStatement()}
   */
  @Test
  public void testCreateStatement_givenConnectionCreateStatementReturnStatement() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createStatement()).thenReturn(mock(Statement.class));

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).createStatement();

    // Assert
    verify(delegate).createStatement();
  }

  /**
   * Test {@link SandBoxConnection#createStatement()}.
   * <ul>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#createStatement()}
   */
  @Test
  public void testCreateStatement_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createStatement()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class,
        () -> (new SandBoxConnection(delegate, new GenericObjectPool())).createStatement());
    verify(delegate).createStatement();
  }

  /**
   * Test {@link SandBoxConnection#prepareStatement(String)} with {@code sql}.
   * <p>
   * Method under test: {@link SandBoxConnection#prepareStatement(String)}
   */
  @Test
  public void testPrepareStatementWithSql() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.prepareStatement(Mockito.<String>any())).thenReturn(mock(PreparedStatement.class));

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).prepareStatement("Sql");

    // Assert
    verify(delegate).prepareStatement(eq("Sql"));
  }

  /**
   * Test {@link SandBoxConnection#prepareStatement(String, int)} with
   * {@code sql}, {@code autoGeneratedKeys}.
   * <p>
   * Method under test: {@link SandBoxConnection#prepareStatement(String, int)}
   */
  @Test
  public void testPrepareStatementWithSqlAutoGeneratedKeys() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.prepareStatement(Mockito.<String>any(), anyInt())).thenReturn(mock(PreparedStatement.class));

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).prepareStatement("Sql", 1);

    // Assert
    verify(delegate).prepareStatement(eq("Sql"), eq(1));
  }

  /**
   * Test {@link SandBoxConnection#prepareStatement(String, int)} with
   * {@code sql}, {@code autoGeneratedKeys}.
   * <ul>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#prepareStatement(String, int)}
   */
  @Test
  public void testPrepareStatementWithSqlAutoGeneratedKeys_thenThrowSQLException() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.prepareStatement(Mockito.<String>any(), anyInt())).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class,
        () -> (new SandBoxConnection(delegate, new GenericObjectPool())).prepareStatement("Sql", 1));
    verify(delegate).prepareStatement(eq("Sql"), eq(1));
  }

  /**
   * Test {@link SandBoxConnection#prepareStatement(String, int[])} with
   * {@code sql}, {@code columnIndexes}.
   * <p>
   * Method under test: {@link SandBoxConnection#prepareStatement(String, int[])}
   */
  @Test
  public void testPrepareStatementWithSqlColumnIndexes() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.prepareStatement(Mockito.<String>any(), Mockito.<int[]>any()))
        .thenReturn(mock(PreparedStatement.class));

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).prepareStatement("Sql", new int[]{1, -1, 1, -1});

    // Assert
    verify(delegate).prepareStatement(eq("Sql"), isA(int[].class));
  }

  /**
   * Test {@link SandBoxConnection#prepareStatement(String, int[])} with
   * {@code sql}, {@code columnIndexes}.
   * <ul>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#prepareStatement(String, int[])}
   */
  @Test
  public void testPrepareStatementWithSqlColumnIndexes_thenThrowSQLException() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.prepareStatement(Mockito.<String>any(), Mockito.<int[]>any())).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool()))
        .prepareStatement("Sql", new int[]{1, -1, 1, -1}));
    verify(delegate).prepareStatement(eq("Sql"), isA(int[].class));
  }

  /**
   * Test {@link SandBoxConnection#prepareStatement(String, String[])} with
   * {@code sql}, {@code columnNames}.
   * <p>
   * Method under test:
   * {@link SandBoxConnection#prepareStatement(String, String[])}
   */
  @Test
  public void testPrepareStatementWithSqlColumnNames() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(mock(PreparedStatement.class));

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).prepareStatement("Sql", new String[]{"Column Names"});

    // Assert
    verify(delegate).prepareStatement(eq("Sql"), isA(String[].class));
  }

  /**
   * Test {@link SandBoxConnection#prepareStatement(String, String[])} with
   * {@code sql}, {@code columnNames}.
   * <ul>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SandBoxConnection#prepareStatement(String, String[])}
   */
  @Test
  public void testPrepareStatementWithSqlColumnNames_thenThrowSQLException() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any())).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool()))
        .prepareStatement("Sql", new String[]{"Column Names"}));
    verify(delegate).prepareStatement(eq("Sql"), isA(String[].class));
  }

  /**
   * Test {@link SandBoxConnection#prepareStatement(String, int, int)} with
   * {@code sql}, {@code resultSetType}, {@code resultSetConcurrency}.
   * <p>
   * Method under test:
   * {@link SandBoxConnection#prepareStatement(String, int, int)}
   */
  @Test
  public void testPrepareStatementWithSqlResultSetTypeResultSetConcurrency() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.prepareStatement(Mockito.<String>any(), anyInt(), anyInt()))
        .thenReturn(mock(PreparedStatement.class));

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).prepareStatement("Sql", 1, 1);

    // Assert
    verify(delegate).prepareStatement(eq("Sql"), eq(1), eq(1));
  }

  /**
   * Test {@link SandBoxConnection#prepareStatement(String, int, int)} with
   * {@code sql}, {@code resultSetType}, {@code resultSetConcurrency}.
   * <p>
   * Method under test:
   * {@link SandBoxConnection#prepareStatement(String, int, int)}
   */
  @Test
  public void testPrepareStatementWithSqlResultSetTypeResultSetConcurrency2() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.prepareStatement(Mockito.<String>any(), anyInt(), anyInt())).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class,
        () -> (new SandBoxConnection(delegate, new GenericObjectPool())).prepareStatement("Sql", 1, 1));
    verify(delegate).prepareStatement(eq("Sql"), eq(1), eq(1));
  }

  /**
   * Test {@link SandBoxConnection#prepareStatement(String, int, int, int)} with
   * {@code sql}, {@code resultSetType}, {@code resultSetConcurrency},
   * {@code resultSetHoldability}.
   * <p>
   * Method under test:
   * {@link SandBoxConnection#prepareStatement(String, int, int, int)}
   */
  @Test
  public void testPrepareStatementWithSqlResultSetTypeResultSetConcurrencyResultSetHoldability() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.prepareStatement(Mockito.<String>any(), anyInt(), anyInt(), anyInt()))
        .thenReturn(mock(PreparedStatement.class));

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).prepareStatement("Sql", 1, 1, 1);

    // Assert
    verify(delegate).prepareStatement(eq("Sql"), eq(1), eq(1), eq(1));
  }

  /**
   * Test {@link SandBoxConnection#prepareStatement(String, int, int, int)} with
   * {@code sql}, {@code resultSetType}, {@code resultSetConcurrency},
   * {@code resultSetHoldability}.
   * <p>
   * Method under test:
   * {@link SandBoxConnection#prepareStatement(String, int, int, int)}
   */
  @Test
  public void testPrepareStatementWithSqlResultSetTypeResultSetConcurrencyResultSetHoldability2() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.prepareStatement(Mockito.<String>any(), anyInt(), anyInt(), anyInt())).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class,
        () -> (new SandBoxConnection(delegate, new GenericObjectPool())).prepareStatement("Sql", 1, 1, 1));
    verify(delegate).prepareStatement(eq("Sql"), eq(1), eq(1), eq(1));
  }

  /**
   * Test {@link SandBoxConnection#prepareStatement(String)} with {@code sql}.
   * <ul>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#prepareStatement(String)}
   */
  @Test
  public void testPrepareStatementWithSql_thenThrowSQLException() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.prepareStatement(Mockito.<String>any())).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class,
        () -> (new SandBoxConnection(delegate, new GenericObjectPool())).prepareStatement("Sql"));
    verify(delegate).prepareStatement(eq("Sql"));
  }

  /**
   * Test {@link SandBoxConnection#prepareCall(String, int, int)} with
   * {@code sql}, {@code resultSetType}, {@code resultSetConcurrency}.
   * <p>
   * Method under test: {@link SandBoxConnection#prepareCall(String, int, int)}
   */
  @Test
  public void testPrepareCallWithSqlResultSetTypeResultSetConcurrency() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.prepareCall(Mockito.<String>any(), anyInt(), anyInt())).thenReturn(mock(CallableStatement.class));

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).prepareCall("Sql", 1, 1);

    // Assert
    verify(delegate).prepareCall(eq("Sql"), eq(1), eq(1));
  }

  /**
   * Test {@link SandBoxConnection#prepareCall(String, int, int, int)} with
   * {@code sql}, {@code resultSetType}, {@code resultSetConcurrency},
   * {@code resultSetHoldability}.
   * <p>
   * Method under test:
   * {@link SandBoxConnection#prepareCall(String, int, int, int)}
   */
  @Test
  public void testPrepareCallWithSqlResultSetTypeResultSetConcurrencyResultSetHoldability() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.prepareCall(Mockito.<String>any(), anyInt(), anyInt(), anyInt()))
        .thenReturn(mock(CallableStatement.class));

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).prepareCall("Sql", 1, 1, 1);

    // Assert
    verify(delegate).prepareCall(eq("Sql"), eq(1), eq(1), eq(1));
  }

  /**
   * Test {@link SandBoxConnection#prepareCall(String, int, int, int)} with
   * {@code sql}, {@code resultSetType}, {@code resultSetConcurrency},
   * {@code resultSetHoldability}.
   * <p>
   * Method under test:
   * {@link SandBoxConnection#prepareCall(String, int, int, int)}
   */
  @Test
  public void testPrepareCallWithSqlResultSetTypeResultSetConcurrencyResultSetHoldability2() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.prepareCall(Mockito.<String>any(), anyInt(), anyInt(), anyInt())).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class,
        () -> (new SandBoxConnection(delegate, new GenericObjectPool())).prepareCall("Sql", 1, 1, 1));
    verify(delegate).prepareCall(eq("Sql"), eq(1), eq(1), eq(1));
  }

  /**
   * Test {@link SandBoxConnection#prepareCall(String, int, int)} with
   * {@code sql}, {@code resultSetType}, {@code resultSetConcurrency}.
   * <ul>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#prepareCall(String, int, int)}
   */
  @Test
  public void testPrepareCallWithSqlResultSetTypeResultSetConcurrency_thenThrowSQLException() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.prepareCall(Mockito.<String>any(), anyInt(), anyInt())).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class,
        () -> (new SandBoxConnection(delegate, new GenericObjectPool())).prepareCall("Sql", 1, 1));
    verify(delegate).prepareCall(eq("Sql"), eq(1), eq(1));
  }

  /**
   * Test {@link SandBoxConnection#prepareCall(String)} with {@code sql}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#prepareCall(String)} return
   * {@link CallableStatement}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#prepareCall(String)}
   */
  @Test
  public void testPrepareCallWithSql_givenConnectionPrepareCallReturnCallableStatement() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.prepareCall(Mockito.<String>any())).thenReturn(mock(CallableStatement.class));

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).prepareCall("Sql");

    // Assert
    verify(delegate).prepareCall(eq("Sql"));
  }

  /**
   * Test {@link SandBoxConnection#prepareCall(String)} with {@code sql}.
   * <ul>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#prepareCall(String)}
   */
  @Test
  public void testPrepareCallWithSql_thenThrowSQLException() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.prepareCall(Mockito.<String>any())).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class,
        () -> (new SandBoxConnection(delegate, new GenericObjectPool())).prepareCall("Sql"));
    verify(delegate).prepareCall(eq("Sql"));
  }

  /**
   * Test {@link SandBoxConnection#nativeSQL(String)}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#nativeSQL(String)} return
   * {@code Native SQL}.</li>
   *   <li>Then return {@code Native SQL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#nativeSQL(String)}
   */
  @Test
  public void testNativeSQL_givenConnectionNativeSQLReturnNativeSql_thenReturnNativeSql() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.nativeSQL(Mockito.<String>any())).thenReturn("Native SQL");

    // Act
    String actualNativeSQLResult = (new SandBoxConnection(delegate, new GenericObjectPool())).nativeSQL("Sql");

    // Assert
    verify(delegate).nativeSQL(eq("Sql"));
    assertEquals("Native SQL", actualNativeSQLResult);
  }

  /**
   * Test {@link SandBoxConnection#nativeSQL(String)}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#nativeSQL(String)} throw
   * {@link SQLException#SQLException()}.</li>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#nativeSQL(String)}
   */
  @Test
  public void testNativeSQL_givenConnectionNativeSQLThrowSQLException_thenThrowSQLException() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.nativeSQL(Mockito.<String>any())).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool())).nativeSQL("Sql"));
    verify(delegate).nativeSQL(eq("Sql"));
  }

  /**
   * Test {@link SandBoxConnection#setAutoCommit(boolean)}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#setAutoCommit(boolean)} does
   * nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#setAutoCommit(boolean)}
   */
  @Test
  public void testSetAutoCommit_givenConnectionSetAutoCommitDoesNothing() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doNothing().when(delegate).setAutoCommit(anyBoolean());

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).setAutoCommit(true);

    // Assert that nothing has changed
    verify(delegate).setAutoCommit(eq(true));
  }

  /**
   * Test {@link SandBoxConnection#setAutoCommit(boolean)}.
   * <ul>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#setAutoCommit(boolean)}
   */
  @Test
  public void testSetAutoCommit_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doThrow(new SQLException()).when(delegate).setAutoCommit(anyBoolean());

    // Act and Assert
    assertThrows(SQLException.class,
        () -> (new SandBoxConnection(delegate, new GenericObjectPool())).setAutoCommit(true));
    verify(delegate).setAutoCommit(eq(true));
  }

  /**
   * Test {@link SandBoxConnection#getTypeMap()}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#getTypeMap()} return
   * {@link HashMap#HashMap()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#getTypeMap()}
   */
  @Test
  public void testGetTypeMap_givenConnectionGetTypeMapReturnHashMap_thenReturnEmpty() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    Mockito.<Map<String, Class<?>>>when(delegate.getTypeMap()).thenReturn(new HashMap<>());

    // Act
    Map<String, Class<?>> actualTypeMap = (new SandBoxConnection(delegate, new GenericObjectPool())).getTypeMap();

    // Assert
    verify(delegate).getTypeMap();
    assertTrue(actualTypeMap.isEmpty());
  }

  /**
   * Test {@link SandBoxConnection#getTypeMap()}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#getTypeMap()} throw
   * {@link SQLException#SQLException()}.</li>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#getTypeMap()}
   */
  @Test
  public void testGetTypeMap_givenConnectionGetTypeMapThrowSQLException_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    Mockito.<Map<String, Class<?>>>when(delegate.getTypeMap()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool())).getTypeMap());
    verify(delegate).getTypeMap();
  }

  /**
   * Test {@link SandBoxConnection#setHoldability(int)}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#setHoldability(int)} does
   * nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#setHoldability(int)}
   */
  @Test
  public void testSetHoldability_givenConnectionSetHoldabilityDoesNothing() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doNothing().when(delegate).setHoldability(anyInt());

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).setHoldability(1);

    // Assert that nothing has changed
    verify(delegate).setHoldability(eq(1));
  }

  /**
   * Test {@link SandBoxConnection#setHoldability(int)}.
   * <ul>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#setHoldability(int)}
   */
  @Test
  public void testSetHoldability_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doThrow(new SQLException()).when(delegate).setHoldability(anyInt());

    // Act and Assert
    assertThrows(SQLException.class,
        () -> (new SandBoxConnection(delegate, new GenericObjectPool())).setHoldability(1));
    verify(delegate).setHoldability(eq(1));
  }

  /**
   * Test {@link SandBoxConnection#getHoldability()}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#getHoldability()} return
   * one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#getHoldability()}
   */
  @Test
  public void testGetHoldability_givenConnectionGetHoldabilityReturnOne_thenReturnOne() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getHoldability()).thenReturn(1);

    // Act
    int actualHoldability = (new SandBoxConnection(delegate, new GenericObjectPool())).getHoldability();

    // Assert
    verify(delegate).getHoldability();
    assertEquals(1, actualHoldability);
  }

  /**
   * Test {@link SandBoxConnection#getHoldability()}.
   * <ul>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#getHoldability()}
   */
  @Test
  public void testGetHoldability_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getHoldability()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool())).getHoldability());
    verify(delegate).getHoldability();
  }

  /**
   * Test {@link SandBoxConnection#setSavepoint(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#setSavepoint(String)} return
   * {@link Savepoint}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#setSavepoint(String)}
   */
  @Test
  public void testSetSavepointWithString_givenConnectionSetSavepointReturnSavepoint() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.setSavepoint(Mockito.<String>any())).thenReturn(mock(Savepoint.class));

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).setSavepoint("Name");

    // Assert
    verify(delegate).setSavepoint(eq("Name"));
  }

  /**
   * Test {@link SandBoxConnection#setSavepoint(String)} with {@code String}.
   * <ul>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#setSavepoint(String)}
   */
  @Test
  public void testSetSavepointWithString_thenThrowSQLException() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.setSavepoint(Mockito.<String>any())).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class,
        () -> (new SandBoxConnection(delegate, new GenericObjectPool())).setSavepoint("Name"));
    verify(delegate).setSavepoint(eq("Name"));
  }

  /**
   * Test {@link SandBoxConnection#setSavepoint()}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#setSavepoint()} return
   * {@link Savepoint}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#setSavepoint()}
   */
  @Test
  public void testSetSavepoint_givenConnectionSetSavepointReturnSavepoint() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.setSavepoint()).thenReturn(mock(Savepoint.class));

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).setSavepoint();

    // Assert
    verify(delegate).setSavepoint();
  }

  /**
   * Test {@link SandBoxConnection#setSavepoint()}.
   * <ul>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#setSavepoint()}
   */
  @Test
  public void testSetSavepoint_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.setSavepoint()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool())).setSavepoint());
    verify(delegate).setSavepoint();
  }

  /**
   * Test {@link SandBoxConnection#releaseSavepoint(Savepoint)}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#releaseSavepoint(Savepoint)}
   * does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#releaseSavepoint(Savepoint)}
   */
  @Test
  public void testReleaseSavepoint_givenConnectionReleaseSavepointDoesNothing() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doNothing().when(delegate).releaseSavepoint(Mockito.<Savepoint>any());

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).releaseSavepoint(mock(Savepoint.class));

    // Assert that nothing has changed
    verify(delegate).releaseSavepoint(isA(Savepoint.class));
  }

  /**
   * Test {@link SandBoxConnection#releaseSavepoint(Savepoint)}.
   * <ul>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#releaseSavepoint(Savepoint)}
   */
  @Test
  public void testReleaseSavepoint_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doThrow(new SQLException()).when(delegate).releaseSavepoint(Mockito.<Savepoint>any());

    // Act and Assert
    assertThrows(SQLException.class,
        () -> (new SandBoxConnection(delegate, new GenericObjectPool())).releaseSavepoint(mock(Savepoint.class)));
    verify(delegate).releaseSavepoint(isA(Savepoint.class));
  }

  /**
   * Test {@link SandBoxConnection#getAutoCommit()}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#getAutoCommit()} return
   * {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#getAutoCommit()}
   */
  @Test
  public void testGetAutoCommit_givenConnectionGetAutoCommitReturnFalse_thenReturnFalse() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getAutoCommit()).thenReturn(false);

    // Act
    boolean actualAutoCommit = (new SandBoxConnection(delegate, new GenericObjectPool())).getAutoCommit();

    // Assert
    verify(delegate).getAutoCommit();
    assertFalse(actualAutoCommit);
  }

  /**
   * Test {@link SandBoxConnection#getAutoCommit()}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#getAutoCommit()} return
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#getAutoCommit()}
   */
  @Test
  public void testGetAutoCommit_givenConnectionGetAutoCommitReturnTrue_thenReturnTrue() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getAutoCommit()).thenReturn(true);

    // Act
    boolean actualAutoCommit = (new SandBoxConnection(delegate, new GenericObjectPool())).getAutoCommit();

    // Assert
    verify(delegate).getAutoCommit();
    assertTrue(actualAutoCommit);
  }

  /**
   * Test {@link SandBoxConnection#getAutoCommit()}.
   * <ul>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#getAutoCommit()}
   */
  @Test
  public void testGetAutoCommit_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getAutoCommit()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool())).getAutoCommit());
    verify(delegate).getAutoCommit();
  }

  /**
   * Test {@link SandBoxConnection#commit()}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#commit()} does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#commit()}
   */
  @Test
  public void testCommit_givenConnectionCommitDoesNothing() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doNothing().when(delegate).commit();

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).commit();

    // Assert that nothing has changed
    verify(delegate).commit();
  }

  /**
   * Test {@link SandBoxConnection#commit()}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#commit()} throw
   * {@link SQLException#SQLException()}.</li>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#commit()}
   */
  @Test
  public void testCommit_givenConnectionCommitThrowSQLException_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doThrow(new SQLException()).when(delegate).commit();

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool())).commit());
    verify(delegate).commit();
  }

  /**
   * Test {@link SandBoxConnection#rollback(Savepoint)} with {@code Savepoint}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#rollback(Savepoint)} does
   * nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#rollback(Savepoint)}
   */
  @Test
  public void testRollbackWithSavepoint_givenConnectionRollbackDoesNothing() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doNothing().when(delegate).rollback(Mockito.<Savepoint>any());

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).rollback(mock(Savepoint.class));

    // Assert that nothing has changed
    verify(delegate).rollback(isA(Savepoint.class));
  }

  /**
   * Test {@link SandBoxConnection#rollback(Savepoint)} with {@code Savepoint}.
   * <ul>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#rollback(Savepoint)}
   */
  @Test
  public void testRollbackWithSavepoint_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doThrow(new SQLException()).when(delegate).rollback(Mockito.<Savepoint>any());

    // Act and Assert
    assertThrows(SQLException.class,
        () -> (new SandBoxConnection(delegate, new GenericObjectPool())).rollback(mock(Savepoint.class)));
    verify(delegate).rollback(isA(Savepoint.class));
  }

  /**
   * Test {@link SandBoxConnection#rollback()}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#rollback()} does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#rollback()}
   */
  @Test
  public void testRollback_givenConnectionRollbackDoesNothing() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doNothing().when(delegate).rollback();

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).rollback();

    // Assert that nothing has changed
    verify(delegate).rollback();
  }

  /**
   * Test {@link SandBoxConnection#rollback()}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#rollback()} throw
   * {@link SQLException#SQLException()}.</li>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#rollback()}
   */
  @Test
  public void testRollback_givenConnectionRollbackThrowSQLException_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doThrow(new SQLException()).when(delegate).rollback();

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool())).rollback());
    verify(delegate).rollback();
  }

  /**
   * Test {@link SandBoxConnection#isClosed()}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#isClosed()} return
   * {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#isClosed()}
   */
  @Test
  public void testIsClosed_givenConnectionIsClosedReturnFalse_thenReturnFalse() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.isClosed()).thenReturn(false);

    // Act
    boolean actualIsClosedResult = (new SandBoxConnection(delegate, new GenericObjectPool())).isClosed();

    // Assert
    verify(delegate).isClosed();
    assertFalse(actualIsClosedResult);
  }

  /**
   * Test {@link SandBoxConnection#isClosed()}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#isClosed()} return
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#isClosed()}
   */
  @Test
  public void testIsClosed_givenConnectionIsClosedReturnTrue_thenReturnTrue() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.isClosed()).thenReturn(true);

    // Act
    boolean actualIsClosedResult = (new SandBoxConnection(delegate, new GenericObjectPool())).isClosed();

    // Assert
    verify(delegate).isClosed();
    assertTrue(actualIsClosedResult);
  }

  /**
   * Test {@link SandBoxConnection#isClosed()}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#isClosed()} throw
   * {@link SQLException#SQLException()}.</li>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#isClosed()}
   */
  @Test
  public void testIsClosed_givenConnectionIsClosedThrowSQLException_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.isClosed()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool())).isClosed());
    verify(delegate).isClosed();
  }

  /**
   * Test {@link SandBoxConnection#getMetaData()}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#getMetaData()} return
   * {@link DatabaseMetaData}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#getMetaData()}
   */
  @Test
  public void testGetMetaData_givenConnectionGetMetaDataReturnDatabaseMetaData() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getMetaData()).thenReturn(mock(DatabaseMetaData.class));

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).getMetaData();

    // Assert
    verify(delegate).getMetaData();
  }

  /**
   * Test {@link SandBoxConnection#getMetaData()}.
   * <ul>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#getMetaData()}
   */
  @Test
  public void testGetMetaData_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getMetaData()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool())).getMetaData());
    verify(delegate).getMetaData();
  }

  /**
   * Test {@link SandBoxConnection#setReadOnly(boolean)}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#setReadOnly(boolean)} does
   * nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#setReadOnly(boolean)}
   */
  @Test
  public void testSetReadOnly_givenConnectionSetReadOnlyDoesNothing() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doNothing().when(delegate).setReadOnly(anyBoolean());

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).setReadOnly(true);

    // Assert that nothing has changed
    verify(delegate).setReadOnly(eq(true));
  }

  /**
   * Test {@link SandBoxConnection#setReadOnly(boolean)}.
   * <ul>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#setReadOnly(boolean)}
   */
  @Test
  public void testSetReadOnly_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doThrow(new SQLException()).when(delegate).setReadOnly(anyBoolean());

    // Act and Assert
    assertThrows(SQLException.class,
        () -> (new SandBoxConnection(delegate, new GenericObjectPool())).setReadOnly(true));
    verify(delegate).setReadOnly(eq(true));
  }

  /**
   * Test {@link SandBoxConnection#isReadOnly()}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#isReadOnly()} return
   * {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#isReadOnly()}
   */
  @Test
  public void testIsReadOnly_givenConnectionIsReadOnlyReturnFalse_thenReturnFalse() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.isReadOnly()).thenReturn(false);

    // Act
    boolean actualIsReadOnlyResult = (new SandBoxConnection(delegate, new GenericObjectPool())).isReadOnly();

    // Assert
    verify(delegate).isReadOnly();
    assertFalse(actualIsReadOnlyResult);
  }

  /**
   * Test {@link SandBoxConnection#isReadOnly()}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#isReadOnly()} return
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#isReadOnly()}
   */
  @Test
  public void testIsReadOnly_givenConnectionIsReadOnlyReturnTrue_thenReturnTrue() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.isReadOnly()).thenReturn(true);

    // Act
    boolean actualIsReadOnlyResult = (new SandBoxConnection(delegate, new GenericObjectPool())).isReadOnly();

    // Assert
    verify(delegate).isReadOnly();
    assertTrue(actualIsReadOnlyResult);
  }

  /**
   * Test {@link SandBoxConnection#isReadOnly()}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#isReadOnly()} throw
   * {@link SQLException#SQLException()}.</li>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#isReadOnly()}
   */
  @Test
  public void testIsReadOnly_givenConnectionIsReadOnlyThrowSQLException_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.isReadOnly()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool())).isReadOnly());
    verify(delegate).isReadOnly();
  }

  /**
   * Test {@link SandBoxConnection#setCatalog(String)}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#setCatalog(String)} does
   * nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#setCatalog(String)}
   */
  @Test
  public void testSetCatalog_givenConnectionSetCatalogDoesNothing() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Connection delegate = mock(Connection.class);
    doNothing().when(delegate).setCatalog(Mockito.<String>any());

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).setCatalog("Catalog");

    // Assert that nothing has changed
    verify(delegate).setCatalog(eq("Catalog"));
  }

  /**
   * Test {@link SandBoxConnection#setCatalog(String)}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#setCatalog(String)} throw
   * {@link SQLException#SQLException()}.</li>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#setCatalog(String)}
   */
  @Test
  public void testSetCatalog_givenConnectionSetCatalogThrowSQLException_thenThrowSQLException() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Connection delegate = mock(Connection.class);
    doThrow(new SQLException()).when(delegate).setCatalog(Mockito.<String>any());

    // Act and Assert
    assertThrows(SQLException.class,
        () -> (new SandBoxConnection(delegate, new GenericObjectPool())).setCatalog("Catalog"));
    verify(delegate).setCatalog(eq("Catalog"));
  }

  /**
   * Test {@link SandBoxConnection#getCatalog()}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#getCatalog()} return
   * {@code Catalog}.</li>
   *   <li>Then return {@code Catalog}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#getCatalog()}
   */
  @Test
  public void testGetCatalog_givenConnectionGetCatalogReturnCatalog_thenReturnCatalog() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getCatalog()).thenReturn("Catalog");

    // Act
    String actualCatalog = (new SandBoxConnection(delegate, new GenericObjectPool())).getCatalog();

    // Assert
    verify(delegate).getCatalog();
    assertEquals("Catalog", actualCatalog);
  }

  /**
   * Test {@link SandBoxConnection#getCatalog()}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#getCatalog()} throw
   * {@link SQLException#SQLException()}.</li>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#getCatalog()}
   */
  @Test
  public void testGetCatalog_givenConnectionGetCatalogThrowSQLException_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getCatalog()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool())).getCatalog());
    verify(delegate).getCatalog();
  }

  /**
   * Test {@link SandBoxConnection#setTransactionIsolation(int)}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#setTransactionIsolation(int)}
   * does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#setTransactionIsolation(int)}
   */
  @Test
  public void testSetTransactionIsolation_givenConnectionSetTransactionIsolationDoesNothing() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doNothing().when(delegate).setTransactionIsolation(anyInt());

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).setTransactionIsolation(1);

    // Assert that nothing has changed
    verify(delegate).setTransactionIsolation(eq(1));
  }

  /**
   * Test {@link SandBoxConnection#setTransactionIsolation(int)}.
   * <ul>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#setTransactionIsolation(int)}
   */
  @Test
  public void testSetTransactionIsolation_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doThrow(new SQLException()).when(delegate).setTransactionIsolation(anyInt());

    // Act and Assert
    assertThrows(SQLException.class,
        () -> (new SandBoxConnection(delegate, new GenericObjectPool())).setTransactionIsolation(1));
    verify(delegate).setTransactionIsolation(eq(1));
  }

  /**
   * Test {@link SandBoxConnection#getTransactionIsolation()}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#getTransactionIsolation()}
   */
  @Test
  public void testGetTransactionIsolation_thenReturnOne() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getTransactionIsolation()).thenReturn(1);

    // Act
    int actualTransactionIsolation = (new SandBoxConnection(delegate, new GenericObjectPool()))
        .getTransactionIsolation();

    // Assert
    verify(delegate).getTransactionIsolation();
    assertEquals(1, actualTransactionIsolation);
  }

  /**
   * Test {@link SandBoxConnection#getTransactionIsolation()}.
   * <ul>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#getTransactionIsolation()}
   */
  @Test
  public void testGetTransactionIsolation_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getTransactionIsolation()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class,
        () -> (new SandBoxConnection(delegate, new GenericObjectPool())).getTransactionIsolation());
    verify(delegate).getTransactionIsolation();
  }

  /**
   * Test {@link SandBoxConnection#getWarnings()}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#getWarnings()} return
   * {@link SQLWarning#SQLWarning()}.</li>
   *   <li>Then return {@link SQLWarning#SQLWarning()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#getWarnings()}
   */
  @Test
  public void testGetWarnings_givenConnectionGetWarningsReturnSQLWarning_thenReturnSQLWarning() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    SQLWarning sqlWarning = new SQLWarning();
    when(delegate.getWarnings()).thenReturn(sqlWarning);

    // Act
    SQLWarning actualWarnings = (new SandBoxConnection(delegate, new GenericObjectPool())).getWarnings();

    // Assert
    verify(delegate).getWarnings();
    assertSame(sqlWarning, actualWarnings);
  }

  /**
   * Test {@link SandBoxConnection#getWarnings()}.
   * <ul>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#getWarnings()}
   */
  @Test
  public void testGetWarnings_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getWarnings()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool())).getWarnings());
    verify(delegate).getWarnings();
  }

  /**
   * Test {@link SandBoxConnection#clearWarnings()}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#clearWarnings()} does
   * nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#clearWarnings()}
   */
  @Test
  public void testClearWarnings_givenConnectionClearWarningsDoesNothing() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doNothing().when(delegate).clearWarnings();

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).clearWarnings();

    // Assert that nothing has changed
    verify(delegate).clearWarnings();
  }

  /**
   * Test {@link SandBoxConnection#clearWarnings()}.
   * <ul>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#clearWarnings()}
   */
  @Test
  public void testClearWarnings_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doThrow(new SQLException()).when(delegate).clearWarnings();

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool())).clearWarnings());
    verify(delegate).clearWarnings();
  }

  /**
   * Test {@link SandBoxConnection#createClob()}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#createClob()} return
   * {@link Clob}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#createClob()}
   */
  @Test
  public void testCreateClob_givenConnectionCreateClobReturnClob() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createClob()).thenReturn(mock(Clob.class));

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).createClob();

    // Assert
    verify(delegate).createClob();
  }

  /**
   * Test {@link SandBoxConnection#createClob()}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#createClob()} throw
   * {@link SQLException#SQLException()}.</li>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#createClob()}
   */
  @Test
  public void testCreateClob_givenConnectionCreateClobThrowSQLException_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createClob()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool())).createClob());
    verify(delegate).createClob();
  }

  /**
   * Test {@link SandBoxConnection#createBlob()}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#createBlob()} return
   * {@link Blob}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#createBlob()}
   */
  @Test
  public void testCreateBlob_givenConnectionCreateBlobReturnBlob() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createBlob()).thenReturn(mock(Blob.class));

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).createBlob();

    // Assert
    verify(delegate).createBlob();
  }

  /**
   * Test {@link SandBoxConnection#createBlob()}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#createBlob()} throw
   * {@link SQLException#SQLException()}.</li>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#createBlob()}
   */
  @Test
  public void testCreateBlob_givenConnectionCreateBlobThrowSQLException_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createBlob()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool())).createBlob());
    verify(delegate).createBlob();
  }

  /**
   * Test {@link SandBoxConnection#createNClob()}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#createNClob()} return
   * {@link NClob}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#createNClob()}
   */
  @Test
  public void testCreateNClob_givenConnectionCreateNClobReturnNClob() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createNClob()).thenReturn(mock(NClob.class));

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).createNClob();

    // Assert
    verify(delegate).createNClob();
  }

  /**
   * Test {@link SandBoxConnection#createNClob()}.
   * <ul>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#createNClob()}
   */
  @Test
  public void testCreateNClob_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createNClob()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool())).createNClob());
    verify(delegate).createNClob();
  }

  /**
   * Test {@link SandBoxConnection#createSQLXML()}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#createSQLXML()} return
   * {@link SQLXML}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#createSQLXML()}
   */
  @Test
  public void testCreateSQLXML_givenConnectionCreateSQLXMLReturnSqlxml() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createSQLXML()).thenReturn(mock(SQLXML.class));

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).createSQLXML();

    // Assert
    verify(delegate).createSQLXML();
  }

  /**
   * Test {@link SandBoxConnection#createSQLXML()}.
   * <ul>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#createSQLXML()}
   */
  @Test
  public void testCreateSQLXML_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createSQLXML()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool())).createSQLXML());
    verify(delegate).createSQLXML();
  }

  /**
   * Test {@link SandBoxConnection#isValid(int)}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#isValid(int)} return
   * {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#isValid(int)}
   */
  @Test
  public void testIsValid_givenConnectionIsValidReturnFalse_thenReturnFalse() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.isValid(anyInt())).thenReturn(false);

    // Act
    boolean actualIsValidResult = (new SandBoxConnection(delegate, new GenericObjectPool())).isValid(10);

    // Assert
    verify(delegate).isValid(eq(10));
    assertFalse(actualIsValidResult);
  }

  /**
   * Test {@link SandBoxConnection#isValid(int)}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#isValid(int)} return
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#isValid(int)}
   */
  @Test
  public void testIsValid_givenConnectionIsValidReturnTrue_thenReturnTrue() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.isValid(anyInt())).thenReturn(true);

    // Act
    boolean actualIsValidResult = (new SandBoxConnection(delegate, new GenericObjectPool())).isValid(10);

    // Assert
    verify(delegate).isValid(eq(10));
    assertTrue(actualIsValidResult);
  }

  /**
   * Test {@link SandBoxConnection#isValid(int)}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#isValid(int)} throw
   * {@link SQLException#SQLException()}.</li>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#isValid(int)}
   */
  @Test
  public void testIsValid_givenConnectionIsValidThrowSQLException_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.isValid(anyInt())).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool())).isValid(10));
    verify(delegate).isValid(eq(10));
  }

  /**
   * Test {@link SandBoxConnection#setClientInfo(String, String)} with
   * {@code name}, {@code value}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#setClientInfo(String, String)}
   * does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#setClientInfo(String, String)}
   */
  @Test
  public void testSetClientInfoWithNameValue_givenConnectionSetClientInfoDoesNothing() throws SQLClientInfoException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Connection delegate = mock(Connection.class);
    doNothing().when(delegate).setClientInfo(Mockito.<String>any(), Mockito.<String>any());

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).setClientInfo("Name", "42");

    // Assert that nothing has changed
    verify(delegate).setClientInfo(eq("Name"), eq("42"));
  }

  /**
   * Test {@link SandBoxConnection#setClientInfo(String, String)} with
   * {@code name}, {@code value}.
   * <ul>
   *   <li>Then throw {@link SecurityException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#setClientInfo(String, String)}
   */
  @Test
  public void testSetClientInfoWithNameValue_thenThrowSecurityException() throws SQLClientInfoException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Connection delegate = mock(Connection.class);
    doThrow(new SecurityException("foo")).when(delegate).setClientInfo(Mockito.<String>any(), Mockito.<String>any());

    // Act and Assert
    assertThrows(SecurityException.class,
        () -> (new SandBoxConnection(delegate, new GenericObjectPool())).setClientInfo("Name", "42"));
    verify(delegate).setClientInfo(eq("Name"), eq("42"));
  }

  /**
   * Test {@link SandBoxConnection#setClientInfo(Properties)} with
   * {@code properties}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#setClientInfo(Properties)}
   * does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#setClientInfo(Properties)}
   */
  @Test
  public void testSetClientInfoWithProperties_givenConnectionSetClientInfoDoesNothing() throws SQLClientInfoException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doNothing().when(delegate).setClientInfo(Mockito.<Properties>any());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act
    sandBoxConnection.setClientInfo(new Properties());

    // Assert that nothing has changed
    verify(delegate).setClientInfo(isA(Properties.class));
  }

  /**
   * Test {@link SandBoxConnection#setClientInfo(Properties)} with
   * {@code properties}.
   * <ul>
   *   <li>Then throw {@link SecurityException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#setClientInfo(Properties)}
   */
  @Test
  public void testSetClientInfoWithProperties_thenThrowSecurityException() throws SQLClientInfoException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doThrow(new SecurityException("foo")).when(delegate).setClientInfo(Mockito.<Properties>any());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act and Assert
    assertThrows(SecurityException.class, () -> sandBoxConnection.setClientInfo(new Properties()));
    verify(delegate).setClientInfo(isA(Properties.class));
  }

  /**
   * Test {@link SandBoxConnection#getClientInfo(String)} with {@code String}.
   * <ul>
   *   <li>Then return {@code Client Info}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#getClientInfo(String)}
   */
  @Test
  public void testGetClientInfoWithString_thenReturnClientInfo() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getClientInfo(Mockito.<String>any())).thenReturn("Client Info");

    // Act
    String actualClientInfo = (new SandBoxConnection(delegate, new GenericObjectPool())).getClientInfo("Name");

    // Assert
    verify(delegate).getClientInfo(eq("Name"));
    assertEquals("Client Info", actualClientInfo);
  }

  /**
   * Test {@link SandBoxConnection#getClientInfo(String)} with {@code String}.
   * <ul>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#getClientInfo(String)}
   */
  @Test
  public void testGetClientInfoWithString_thenThrowSQLException() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getClientInfo(Mockito.<String>any())).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class,
        () -> (new SandBoxConnection(delegate, new GenericObjectPool())).getClientInfo("Name"));
    verify(delegate).getClientInfo(eq("Name"));
  }

  /**
   * Test {@link SandBoxConnection#getClientInfo()}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#getClientInfo()} return
   * {@link Properties#Properties()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#getClientInfo()}
   */
  @Test
  public void testGetClientInfo_givenConnectionGetClientInfoReturnProperties_thenReturnEmpty() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    Properties properties = new Properties();
    when(delegate.getClientInfo()).thenReturn(properties);

    // Act
    Properties actualClientInfo = (new SandBoxConnection(delegate, new GenericObjectPool())).getClientInfo();

    // Assert
    verify(delegate).getClientInfo();
    assertTrue(actualClientInfo.isEmpty());
    assertSame(properties, actualClientInfo);
  }

  /**
   * Test {@link SandBoxConnection#getClientInfo()}.
   * <ul>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#getClientInfo()}
   */
  @Test
  public void testGetClientInfo_thenThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getClientInfo()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool())).getClientInfo());
    verify(delegate).getClientInfo();
  }

  /**
   * Test {@link SandBoxConnection#createArrayOf(String, Object[])}.
   * <ul>
   *   <li>Given {@link Connection}
   * {@link Connection#createArrayOf(String, Object[])} return {@link Array}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#createArrayOf(String, Object[])}
   */
  @Test
  public void testCreateArrayOf_givenConnectionCreateArrayOfReturnArray() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createArrayOf(Mockito.<String>any(), Mockito.<Object[]>any())).thenReturn(mock(Array.class));

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).createArrayOf("Type Name", new Object[]{"Elements"});

    // Assert
    verify(delegate).createArrayOf(eq("Type Name"), isA(Object[].class));
  }

  /**
   * Test {@link SandBoxConnection#createArrayOf(String, Object[])}.
   * <ul>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#createArrayOf(String, Object[])}
   */
  @Test
  public void testCreateArrayOf_thenThrowSQLException() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createArrayOf(Mockito.<String>any(), Mockito.<Object[]>any())).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool()))
        .createArrayOf("Type Name", new Object[]{"Elements"}));
    verify(delegate).createArrayOf(eq("Type Name"), isA(Object[].class));
  }

  /**
   * Test {@link SandBoxConnection#createStruct(String, Object[])}.
   * <ul>
   *   <li>Given {@link Connection}
   * {@link Connection#createStruct(String, Object[])} return {@link Struct}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#createStruct(String, Object[])}
   */
  @Test
  public void testCreateStruct_givenConnectionCreateStructReturnStruct() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createStruct(Mockito.<String>any(), Mockito.<Object[]>any())).thenReturn(mock(Struct.class));

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).createStruct("Type Name", new Object[]{"Attributes"});

    // Assert
    verify(delegate).createStruct(eq("Type Name"), isA(Object[].class));
  }

  /**
   * Test {@link SandBoxConnection#createStruct(String, Object[])}.
   * <ul>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#createStruct(String, Object[])}
   */
  @Test
  public void testCreateStruct_thenThrowSQLException() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createStruct(Mockito.<String>any(), Mockito.<Object[]>any())).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool()))
        .createStruct("Type Name", new Object[]{"Attributes"}));
    verify(delegate).createStruct(eq("Type Name"), isA(Object[].class));
  }

  /**
   * Test {@link SandBoxConnection#setSchema(String)}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#setSchema(String)} does
   * nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#setSchema(String)}
   */
  @Test
  public void testSetSchema_givenConnectionSetSchemaDoesNothing() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Connection delegate = mock(Connection.class);
    doNothing().when(delegate).setSchema(Mockito.<String>any());

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).setSchema("Schema");

    // Assert
    verify(delegate).setSchema(eq("Schema"));
  }

  /**
   * Test {@link SandBoxConnection#setSchema(String)}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#setSchema(String)} throw
   * {@link SQLException#SQLException()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#setSchema(String)}
   */
  @Test
  public void testSetSchema_givenConnectionSetSchemaThrowSQLException() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Connection delegate = mock(Connection.class);
    doThrow(new SQLException()).when(delegate).setSchema(Mockito.<String>any());

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).setSchema("Schema");

    // Assert
    verify(delegate).setSchema(eq("Schema"));
  }

  /**
   * Test {@link SandBoxConnection#getSchema()}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#getSchema()} return
   * {@code Schema}.</li>
   *   <li>Then return {@code Schema}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#getSchema()}
   */
  @Test
  public void testGetSchema_givenConnectionGetSchemaReturnSchema_thenReturnSchema() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getSchema()).thenReturn("Schema");

    // Act
    String actualSchema = (new SandBoxConnection(delegate, new GenericObjectPool())).getSchema();

    // Assert
    verify(delegate).getSchema();
    assertEquals("Schema", actualSchema);
  }

  /**
   * Test {@link SandBoxConnection#getSchema()}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#getSchema()} throw
   * {@link SQLException#SQLException()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#getSchema()}
   */
  @Test
  public void testGetSchema_givenConnectionGetSchemaThrowSQLException_thenReturnNull() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getSchema()).thenThrow(new SQLException());

    // Act
    String actualSchema = (new SandBoxConnection(delegate, new GenericObjectPool())).getSchema();

    // Assert
    verify(delegate).getSchema();
    assertNull(actualSchema);
  }

  /**
   * Test {@link SandBoxConnection#abort(Executor)}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#abort(Executor)} does
   * nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#abort(Executor)}
   */
  @Test
  public void testAbort_givenConnectionAbortDoesNothing() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doNothing().when(delegate).abort(Mockito.<Executor>any());

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).abort(mock(Executor.class));

    // Assert
    verify(delegate).abort(isA(Executor.class));
  }

  /**
   * Test {@link SandBoxConnection#abort(Executor)}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#abort(Executor)} throw
   * {@link SQLException#SQLException()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#abort(Executor)}
   */
  @Test
  public void testAbort_givenConnectionAbortThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doThrow(new SQLException()).when(delegate).abort(Mockito.<Executor>any());

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).abort(mock(Executor.class));

    // Assert
    verify(delegate).abort(isA(Executor.class));
  }

  /**
   * Test {@link SandBoxConnection#setNetworkTimeout(Executor, int)}.
   * <ul>
   *   <li>Given {@link Connection}
   * {@link Connection#setNetworkTimeout(Executor, int)} does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#setNetworkTimeout(Executor, int)}
   */
  @Test
  public void testSetNetworkTimeout_givenConnectionSetNetworkTimeoutDoesNothing() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doNothing().when(delegate).setNetworkTimeout(Mockito.<Executor>any(), anyInt());

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).setNetworkTimeout(mock(Executor.class), 1000);

    // Assert
    verify(delegate).setNetworkTimeout(isA(Executor.class), eq(1000));
  }

  /**
   * Test {@link SandBoxConnection#setNetworkTimeout(Executor, int)}.
   * <ul>
   *   <li>Given {@link Connection}
   * {@link Connection#setNetworkTimeout(Executor, int)} throw
   * {@link SQLException#SQLException()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#setNetworkTimeout(Executor, int)}
   */
  @Test
  public void testSetNetworkTimeout_givenConnectionSetNetworkTimeoutThrowSQLException() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doThrow(new SQLException()).when(delegate).setNetworkTimeout(Mockito.<Executor>any(), anyInt());

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).setNetworkTimeout(mock(Executor.class), 1000);

    // Assert
    verify(delegate).setNetworkTimeout(isA(Executor.class), eq(1000));
  }

  /**
   * Test {@link SandBoxConnection#getNetworkTimeout()}.
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#getNetworkTimeout()} return
   * ten.</li>
   *   <li>Then return ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#getNetworkTimeout()}
   */
  @Test
  public void testGetNetworkTimeout_givenConnectionGetNetworkTimeoutReturnTen_thenReturnTen() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getNetworkTimeout()).thenReturn(10);

    // Act
    int actualNetworkTimeout = (new SandBoxConnection(delegate, new GenericObjectPool())).getNetworkTimeout();

    // Assert
    verify(delegate).getNetworkTimeout();
    assertEquals(10, actualNetworkTimeout);
  }

  /**
   * Test {@link SandBoxConnection#getNetworkTimeout()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxConnection#getNetworkTimeout()}
   */
  @Test
  public void testGetNetworkTimeout_thenReturnZero() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getNetworkTimeout()).thenThrow(new SQLException());

    // Act
    int actualNetworkTimeout = (new SandBoxConnection(delegate, new GenericObjectPool())).getNetworkTimeout();

    // Assert
    verify(delegate).getNetworkTimeout();
    assertEquals(0, actualNetworkTimeout);
  }
}

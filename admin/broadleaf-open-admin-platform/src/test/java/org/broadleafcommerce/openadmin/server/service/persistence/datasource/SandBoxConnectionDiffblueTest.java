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
   * Method under test: {@link SandBoxConnection#unwrap(Class)}
   */
  @Test
  public void testUnwrap() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());
    Class<Object> iface = Object.class;

    // Act and Assert
    assertThrows(SQLException.class, () -> sandBoxConnection.unwrap(iface));
  }

  /**
   * Method under test: {@link SandBoxConnection#isWrapperFor(Class)}
   */
  @Test
  public void testIsWrapperFor() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());
    Class<Object> iface = Object.class;

    // Act and Assert
    assertFalse(sandBoxConnection.isWrapperFor(iface));
  }

  /**
   * Method under test: {@link SandBoxConnection#isWrapperFor(Class)}
   */
  @Test
  public void testIsWrapperFor2() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());
    Class<Connection> iface = Connection.class;

    // Act and Assert
    assertTrue(sandBoxConnection.isWrapperFor(iface));
  }

  /**
   * Method under test: {@link SandBoxConnection#createStatement()}
   */
  @Test
  public void testCreateStatement() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createStatement()).thenReturn(mock(Statement.class));

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).createStatement();

    // Assert
    verify(delegate).createStatement();
  }

  /**
   * Method under test: {@link SandBoxConnection#createStatement()}
   */
  @Test
  public void testCreateStatement2() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createStatement()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class,
        () -> (new SandBoxConnection(delegate, new GenericObjectPool())).createStatement());
    verify(delegate).createStatement();
  }

  /**
   * Method under test: {@link SandBoxConnection#createStatement(int, int)}
   */
  @Test
  public void testCreateStatement3() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createStatement(anyInt(), anyInt())).thenReturn(mock(Statement.class));

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).createStatement(1, 1);

    // Assert
    verify(delegate).createStatement(eq(1), eq(1));
  }

  /**
   * Method under test: {@link SandBoxConnection#createStatement(int, int)}
   */
  @Test
  public void testCreateStatement4() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createStatement(anyInt(), anyInt())).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class,
        () -> (new SandBoxConnection(delegate, new GenericObjectPool())).createStatement(1, 1));
    verify(delegate).createStatement(eq(1), eq(1));
  }

  /**
   * Method under test: {@link SandBoxConnection#createStatement(int, int, int)}
   */
  @Test
  public void testCreateStatement5() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createStatement(anyInt(), anyInt(), anyInt())).thenReturn(mock(Statement.class));

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).createStatement(1, 1, 1);

    // Assert
    verify(delegate).createStatement(eq(1), eq(1), eq(1));
  }

  /**
   * Method under test: {@link SandBoxConnection#createStatement(int, int, int)}
   */
  @Test
  public void testCreateStatement6() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createStatement(anyInt(), anyInt(), anyInt())).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class,
        () -> (new SandBoxConnection(delegate, new GenericObjectPool())).createStatement(1, 1, 1));
    verify(delegate).createStatement(eq(1), eq(1), eq(1));
  }

  /**
   * Method under test: {@link SandBoxConnection#prepareStatement(String)}
   */
  @Test
  public void testPrepareStatement() throws SQLException {
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
   * Method under test: {@link SandBoxConnection#prepareStatement(String)}
   */
  @Test
  public void testPrepareStatement2() throws SQLException {
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
   * Method under test: {@link SandBoxConnection#prepareStatement(String, int)}
   */
  @Test
  public void testPrepareStatement3() throws SQLException {
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
   * Method under test: {@link SandBoxConnection#prepareStatement(String, int)}
   */
  @Test
  public void testPrepareStatement4() throws SQLException {
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
   * Method under test:
   * {@link SandBoxConnection#prepareStatement(String, int, int)}
   */
  @Test
  public void testPrepareStatement5() throws SQLException {
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
   * Method under test:
   * {@link SandBoxConnection#prepareStatement(String, int, int)}
   */
  @Test
  public void testPrepareStatement6() throws SQLException {
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
   * Method under test:
   * {@link SandBoxConnection#prepareStatement(String, int, int, int)}
   */
  @Test
  public void testPrepareStatement7() throws SQLException {
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
   * Method under test:
   * {@link SandBoxConnection#prepareStatement(String, int, int, int)}
   */
  @Test
  public void testPrepareStatement8() throws SQLException {
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
   * Method under test: {@link SandBoxConnection#prepareStatement(String, int[])}
   */
  @Test
  public void testPrepareStatement9() throws SQLException {
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
   * Method under test: {@link SandBoxConnection#prepareStatement(String, int[])}
   */
  @Test
  public void testPrepareStatement10() throws SQLException {
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
   * Method under test:
   * {@link SandBoxConnection#prepareStatement(String, String[])}
   */
  @Test
  public void testPrepareStatement11() throws SQLException {
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
   * Method under test:
   * {@link SandBoxConnection#prepareStatement(String, String[])}
   */
  @Test
  public void testPrepareStatement12() throws SQLException {
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
   * Method under test: {@link SandBoxConnection#prepareCall(String)}
   */
  @Test
  public void testPrepareCall() throws SQLException {
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
   * Method under test: {@link SandBoxConnection#prepareCall(String)}
   */
  @Test
  public void testPrepareCall2() throws SQLException {
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
   * Method under test: {@link SandBoxConnection#prepareCall(String, int, int)}
   */
  @Test
  public void testPrepareCall3() throws SQLException {
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
   * Method under test: {@link SandBoxConnection#prepareCall(String, int, int)}
   */
  @Test
  public void testPrepareCall4() throws SQLException {
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
   * Method under test:
   * {@link SandBoxConnection#prepareCall(String, int, int, int)}
   */
  @Test
  public void testPrepareCall5() throws SQLException {
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
   * Method under test:
   * {@link SandBoxConnection#prepareCall(String, int, int, int)}
   */
  @Test
  public void testPrepareCall6() throws SQLException {
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
   * Method under test: {@link SandBoxConnection#nativeSQL(String)}
   */
  @Test
  public void testNativeSQL() throws SQLException {
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
   * Method under test: {@link SandBoxConnection#nativeSQL(String)}
   */
  @Test
  public void testNativeSQL2() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.nativeSQL(Mockito.<String>any())).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool())).nativeSQL("Sql"));
    verify(delegate).nativeSQL(eq("Sql"));
  }

  /**
   * Method under test: {@link SandBoxConnection#setAutoCommit(boolean)}
   */
  @Test
  public void testSetAutoCommit() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doNothing().when(delegate).setAutoCommit(anyBoolean());

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).setAutoCommit(true);

    // Assert that nothing has changed
    verify(delegate).setAutoCommit(eq(true));
  }

  /**
   * Method under test: {@link SandBoxConnection#setAutoCommit(boolean)}
   */
  @Test
  public void testSetAutoCommit2() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doThrow(new SQLException()).when(delegate).setAutoCommit(anyBoolean());

    // Act and Assert
    assertThrows(SQLException.class,
        () -> (new SandBoxConnection(delegate, new GenericObjectPool())).setAutoCommit(true));
    verify(delegate).setAutoCommit(eq(true));
  }

  /**
   * Method under test: {@link SandBoxConnection#getTypeMap()}
   */
  @Test
  public void testGetTypeMap() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    HashMap<String, Class<?>> stringResultClassMap = new HashMap<>();
    Mockito.<Map<String, Class<?>>>when(delegate.getTypeMap()).thenReturn(stringResultClassMap);

    // Act
    Map<String, Class<?>> actualTypeMap = (new SandBoxConnection(delegate, new GenericObjectPool())).getTypeMap();

    // Assert
    verify(delegate).getTypeMap();
    assertTrue(actualTypeMap.isEmpty());
    assertSame(stringResultClassMap, actualTypeMap);
  }

  /**
   * Method under test: {@link SandBoxConnection#getTypeMap()}
   */
  @Test
  public void testGetTypeMap2() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    Mockito.<Map<String, Class<?>>>when(delegate.getTypeMap()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool())).getTypeMap());
    verify(delegate).getTypeMap();
  }

  /**
   * Method under test: {@link SandBoxConnection#setHoldability(int)}
   */
  @Test
  public void testSetHoldability() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doNothing().when(delegate).setHoldability(anyInt());

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).setHoldability(1);

    // Assert that nothing has changed
    verify(delegate).setHoldability(eq(1));
  }

  /**
   * Method under test: {@link SandBoxConnection#setHoldability(int)}
   */
  @Test
  public void testSetHoldability2() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doThrow(new SQLException()).when(delegate).setHoldability(anyInt());

    // Act and Assert
    assertThrows(SQLException.class,
        () -> (new SandBoxConnection(delegate, new GenericObjectPool())).setHoldability(1));
    verify(delegate).setHoldability(eq(1));
  }

  /**
   * Method under test: {@link SandBoxConnection#getHoldability()}
   */
  @Test
  public void testGetHoldability() throws SQLException {
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
   * Method under test: {@link SandBoxConnection#getHoldability()}
   */
  @Test
  public void testGetHoldability2() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getHoldability()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool())).getHoldability());
    verify(delegate).getHoldability();
  }

  /**
   * Method under test: {@link SandBoxConnection#setSavepoint()}
   */
  @Test
  public void testSetSavepoint() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.setSavepoint()).thenReturn(mock(Savepoint.class));

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).setSavepoint();

    // Assert
    verify(delegate).setSavepoint();
  }

  /**
   * Method under test: {@link SandBoxConnection#setSavepoint()}
   */
  @Test
  public void testSetSavepoint2() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.setSavepoint()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool())).setSavepoint());
    verify(delegate).setSavepoint();
  }

  /**
   * Method under test: {@link SandBoxConnection#setSavepoint(String)}
   */
  @Test
  public void testSetSavepoint3() throws SQLException {
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
   * Method under test: {@link SandBoxConnection#setSavepoint(String)}
   */
  @Test
  public void testSetSavepoint4() throws SQLException {
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
   * Method under test: {@link SandBoxConnection#releaseSavepoint(Savepoint)}
   */
  @Test
  public void testReleaseSavepoint() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doNothing().when(delegate).releaseSavepoint(Mockito.<Savepoint>any());

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).releaseSavepoint(mock(Savepoint.class));

    // Assert that nothing has changed
    verify(delegate).releaseSavepoint(isA(Savepoint.class));
  }

  /**
   * Method under test: {@link SandBoxConnection#releaseSavepoint(Savepoint)}
   */
  @Test
  public void testReleaseSavepoint2() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doThrow(new SQLException()).when(delegate).releaseSavepoint(Mockito.<Savepoint>any());

    // Act and Assert
    assertThrows(SQLException.class,
        () -> (new SandBoxConnection(delegate, new GenericObjectPool())).releaseSavepoint(mock(Savepoint.class)));
    verify(delegate).releaseSavepoint(isA(Savepoint.class));
  }

  /**
   * Method under test: {@link SandBoxConnection#getAutoCommit()}
   */
  @Test
  public void testGetAutoCommit() throws SQLException {
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
   * Method under test: {@link SandBoxConnection#getAutoCommit()}
   */
  @Test
  public void testGetAutoCommit2() throws SQLException {
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
   * Method under test: {@link SandBoxConnection#getAutoCommit()}
   */
  @Test
  public void testGetAutoCommit3() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getAutoCommit()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool())).getAutoCommit());
    verify(delegate).getAutoCommit();
  }

  /**
   * Method under test: {@link SandBoxConnection#commit()}
   */
  @Test
  public void testCommit() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doNothing().when(delegate).commit();

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).commit();

    // Assert that nothing has changed
    verify(delegate).commit();
  }

  /**
   * Method under test: {@link SandBoxConnection#commit()}
   */
  @Test
  public void testCommit2() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doThrow(new SQLException()).when(delegate).commit();

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool())).commit());
    verify(delegate).commit();
  }

  /**
   * Method under test: {@link SandBoxConnection#rollback()}
   */
  @Test
  public void testRollback() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doNothing().when(delegate).rollback();

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).rollback();

    // Assert that nothing has changed
    verify(delegate).rollback();
  }

  /**
   * Method under test: {@link SandBoxConnection#rollback()}
   */
  @Test
  public void testRollback2() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doThrow(new SQLException()).when(delegate).rollback();

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool())).rollback());
    verify(delegate).rollback();
  }

  /**
   * Method under test: {@link SandBoxConnection#rollback(Savepoint)}
   */
  @Test
  public void testRollback3() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doNothing().when(delegate).rollback(Mockito.<Savepoint>any());

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).rollback(mock(Savepoint.class));

    // Assert that nothing has changed
    verify(delegate).rollback(isA(Savepoint.class));
  }

  /**
   * Method under test: {@link SandBoxConnection#rollback(Savepoint)}
   */
  @Test
  public void testRollback4() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doThrow(new SQLException()).when(delegate).rollback(Mockito.<Savepoint>any());

    // Act and Assert
    assertThrows(SQLException.class,
        () -> (new SandBoxConnection(delegate, new GenericObjectPool())).rollback(mock(Savepoint.class)));
    verify(delegate).rollback(isA(Savepoint.class));
  }

  /**
   * Method under test: {@link SandBoxConnection#isClosed()}
   */
  @Test
  public void testIsClosed() throws SQLException {
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
   * Method under test: {@link SandBoxConnection#isClosed()}
   */
  @Test
  public void testIsClosed2() throws SQLException {
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
   * Method under test: {@link SandBoxConnection#isClosed()}
   */
  @Test
  public void testIsClosed3() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.isClosed()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool())).isClosed());
    verify(delegate).isClosed();
  }

  /**
   * Method under test: {@link SandBoxConnection#getMetaData()}
   */
  @Test
  public void testGetMetaData() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getMetaData()).thenReturn(mock(DatabaseMetaData.class));

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).getMetaData();

    // Assert
    verify(delegate).getMetaData();
  }

  /**
   * Method under test: {@link SandBoxConnection#getMetaData()}
   */
  @Test
  public void testGetMetaData2() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getMetaData()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool())).getMetaData());
    verify(delegate).getMetaData();
  }

  /**
   * Method under test: {@link SandBoxConnection#setReadOnly(boolean)}
   */
  @Test
  public void testSetReadOnly() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doNothing().when(delegate).setReadOnly(anyBoolean());

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).setReadOnly(true);

    // Assert that nothing has changed
    verify(delegate).setReadOnly(eq(true));
  }

  /**
   * Method under test: {@link SandBoxConnection#setReadOnly(boolean)}
   */
  @Test
  public void testSetReadOnly2() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doThrow(new SQLException()).when(delegate).setReadOnly(anyBoolean());

    // Act and Assert
    assertThrows(SQLException.class,
        () -> (new SandBoxConnection(delegate, new GenericObjectPool())).setReadOnly(true));
    verify(delegate).setReadOnly(eq(true));
  }

  /**
   * Method under test: {@link SandBoxConnection#isReadOnly()}
   */
  @Test
  public void testIsReadOnly() throws SQLException {
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
   * Method under test: {@link SandBoxConnection#isReadOnly()}
   */
  @Test
  public void testIsReadOnly2() throws SQLException {
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
   * Method under test: {@link SandBoxConnection#isReadOnly()}
   */
  @Test
  public void testIsReadOnly3() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.isReadOnly()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool())).isReadOnly());
    verify(delegate).isReadOnly();
  }

  /**
   * Method under test: {@link SandBoxConnection#setCatalog(String)}
   */
  @Test
  public void testSetCatalog() throws SQLException {
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
   * Method under test: {@link SandBoxConnection#setCatalog(String)}
   */
  @Test
  public void testSetCatalog2() throws SQLException {
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
   * Method under test: {@link SandBoxConnection#getCatalog()}
   */
  @Test
  public void testGetCatalog() throws SQLException {
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
   * Method under test: {@link SandBoxConnection#getCatalog()}
   */
  @Test
  public void testGetCatalog2() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getCatalog()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool())).getCatalog());
    verify(delegate).getCatalog();
  }

  /**
   * Method under test: {@link SandBoxConnection#setTransactionIsolation(int)}
   */
  @Test
  public void testSetTransactionIsolation() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doNothing().when(delegate).setTransactionIsolation(anyInt());

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).setTransactionIsolation(1);

    // Assert that nothing has changed
    verify(delegate).setTransactionIsolation(eq(1));
  }

  /**
   * Method under test: {@link SandBoxConnection#setTransactionIsolation(int)}
   */
  @Test
  public void testSetTransactionIsolation2() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doThrow(new SQLException()).when(delegate).setTransactionIsolation(anyInt());

    // Act and Assert
    assertThrows(SQLException.class,
        () -> (new SandBoxConnection(delegate, new GenericObjectPool())).setTransactionIsolation(1));
    verify(delegate).setTransactionIsolation(eq(1));
  }

  /**
   * Method under test: {@link SandBoxConnection#getTransactionIsolation()}
   */
  @Test
  public void testGetTransactionIsolation() throws SQLException {
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
   * Method under test: {@link SandBoxConnection#getTransactionIsolation()}
   */
  @Test
  public void testGetTransactionIsolation2() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getTransactionIsolation()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class,
        () -> (new SandBoxConnection(delegate, new GenericObjectPool())).getTransactionIsolation());
    verify(delegate).getTransactionIsolation();
  }

  /**
   * Method under test: {@link SandBoxConnection#getWarnings()}
   */
  @Test
  public void testGetWarnings() throws SQLException {
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
   * Method under test: {@link SandBoxConnection#getWarnings()}
   */
  @Test
  public void testGetWarnings2() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getWarnings()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool())).getWarnings());
    verify(delegate).getWarnings();
  }

  /**
   * Method under test: {@link SandBoxConnection#clearWarnings()}
   */
  @Test
  public void testClearWarnings() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doNothing().when(delegate).clearWarnings();

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).clearWarnings();

    // Assert that nothing has changed
    verify(delegate).clearWarnings();
  }

  /**
   * Method under test: {@link SandBoxConnection#clearWarnings()}
   */
  @Test
  public void testClearWarnings2() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doThrow(new SQLException()).when(delegate).clearWarnings();

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool())).clearWarnings());
    verify(delegate).clearWarnings();
  }

  /**
   * Method under test: {@link SandBoxConnection#createClob()}
   */
  @Test
  public void testCreateClob() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createClob()).thenReturn(mock(Clob.class));

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).createClob();

    // Assert
    verify(delegate).createClob();
  }

  /**
   * Method under test: {@link SandBoxConnection#createClob()}
   */
  @Test
  public void testCreateClob2() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createClob()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool())).createClob());
    verify(delegate).createClob();
  }

  /**
   * Method under test: {@link SandBoxConnection#createBlob()}
   */
  @Test
  public void testCreateBlob() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createBlob()).thenReturn(mock(Blob.class));

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).createBlob();

    // Assert
    verify(delegate).createBlob();
  }

  /**
   * Method under test: {@link SandBoxConnection#createBlob()}
   */
  @Test
  public void testCreateBlob2() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createBlob()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool())).createBlob());
    verify(delegate).createBlob();
  }

  /**
   * Method under test: {@link SandBoxConnection#createNClob()}
   */
  @Test
  public void testCreateNClob() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createNClob()).thenReturn(mock(NClob.class));

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).createNClob();

    // Assert
    verify(delegate).createNClob();
  }

  /**
   * Method under test: {@link SandBoxConnection#createNClob()}
   */
  @Test
  public void testCreateNClob2() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createNClob()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool())).createNClob());
    verify(delegate).createNClob();
  }

  /**
   * Method under test: {@link SandBoxConnection#createSQLXML()}
   */
  @Test
  public void testCreateSQLXML() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createSQLXML()).thenReturn(mock(SQLXML.class));

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).createSQLXML();

    // Assert
    verify(delegate).createSQLXML();
  }

  /**
   * Method under test: {@link SandBoxConnection#createSQLXML()}
   */
  @Test
  public void testCreateSQLXML2() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.createSQLXML()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool())).createSQLXML());
    verify(delegate).createSQLXML();
  }

  /**
   * Method under test: {@link SandBoxConnection#isValid(int)}
   */
  @Test
  public void testIsValid() throws SQLException {
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
   * Method under test: {@link SandBoxConnection#isValid(int)}
   */
  @Test
  public void testIsValid2() throws SQLException {
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
   * Method under test: {@link SandBoxConnection#isValid(int)}
   */
  @Test
  public void testIsValid3() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.isValid(anyInt())).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool())).isValid(10));
    verify(delegate).isValid(eq(10));
  }

  /**
   * Method under test: {@link SandBoxConnection#setClientInfo(Properties)}
   */
  @Test
  public void testSetClientInfo() throws SQLClientInfoException {
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
   * Method under test: {@link SandBoxConnection#setClientInfo(Properties)}
   */
  @Test
  public void testSetClientInfo2() throws SQLClientInfoException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doThrow(new SecurityException("foo")).when(delegate).setClientInfo(Mockito.<Properties>any());
    SandBoxConnection sandBoxConnection = new SandBoxConnection(delegate, new GenericObjectPool());

    // Act and Assert
    assertThrows(SecurityException.class, () -> sandBoxConnection.setClientInfo(new Properties()));
    verify(delegate).setClientInfo(isA(Properties.class));
  }

  /**
   * Method under test: {@link SandBoxConnection#setClientInfo(String, String)}
   */
  @Test
  public void testSetClientInfo3() throws SQLClientInfoException {
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
   * Method under test: {@link SandBoxConnection#setClientInfo(String, String)}
   */
  @Test
  public void testSetClientInfo4() throws SQLClientInfoException {
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
   * Method under test: {@link SandBoxConnection#getClientInfo()}
   */
  @Test
  public void testGetClientInfo() throws SQLException {
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
   * Method under test: {@link SandBoxConnection#getClientInfo()}
   */
  @Test
  public void testGetClientInfo2() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getClientInfo()).thenThrow(new SQLException());

    // Act and Assert
    assertThrows(SQLException.class, () -> (new SandBoxConnection(delegate, new GenericObjectPool())).getClientInfo());
    verify(delegate).getClientInfo();
  }

  /**
   * Method under test: {@link SandBoxConnection#getClientInfo(String)}
   */
  @Test
  public void testGetClientInfo3() throws SQLException {
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
   * Method under test: {@link SandBoxConnection#getClientInfo(String)}
   */
  @Test
  public void testGetClientInfo4() throws SQLException {
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
   * Method under test: {@link SandBoxConnection#createArrayOf(String, Object[])}
   */
  @Test
  public void testCreateArrayOf() throws SQLException {
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
   * Method under test: {@link SandBoxConnection#createArrayOf(String, Object[])}
   */
  @Test
  public void testCreateArrayOf2() throws SQLException {
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
   * Method under test: {@link SandBoxConnection#createStruct(String, Object[])}
   */
  @Test
  public void testCreateStruct() throws SQLException {
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
   * Method under test: {@link SandBoxConnection#createStruct(String, Object[])}
   */
  @Test
  public void testCreateStruct2() throws SQLException {
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
   * Method under test: {@link SandBoxConnection#setSchema(String)}
   */
  @Test
  public void testSetSchema() throws SQLException {
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
   * Method under test: {@link SandBoxConnection#setSchema(String)}
   */
  @Test
  public void testSetSchema2() throws SQLException {
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
   * Method under test: {@link SandBoxConnection#getSchema()}
   */
  @Test
  public void testGetSchema() throws SQLException {
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
   * Method under test: {@link SandBoxConnection#getSchema()}
   */
  @Test
  public void testGetSchema2() throws SQLException {
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
   * Method under test: {@link SandBoxConnection#abort(Executor)}
   */
  @Test
  public void testAbort() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doNothing().when(delegate).abort(Mockito.<Executor>any());

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).abort(mock(Executor.class));

    // Assert
    verify(delegate).abort(isA(Executor.class));
  }

  /**
   * Method under test: {@link SandBoxConnection#abort(Executor)}
   */
  @Test
  public void testAbort2() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doThrow(new SQLException()).when(delegate).abort(Mockito.<Executor>any());

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).abort(mock(Executor.class));

    // Assert
    verify(delegate).abort(isA(Executor.class));
  }

  /**
   * Method under test: {@link SandBoxConnection#setNetworkTimeout(Executor, int)}
   */
  @Test
  public void testSetNetworkTimeout() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doNothing().when(delegate).setNetworkTimeout(Mockito.<Executor>any(), anyInt());

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).setNetworkTimeout(mock(Executor.class), 1000);

    // Assert
    verify(delegate).setNetworkTimeout(isA(Executor.class), eq(1000));
  }

  /**
   * Method under test: {@link SandBoxConnection#setNetworkTimeout(Executor, int)}
   */
  @Test
  public void testSetNetworkTimeout2() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    doThrow(new SQLException()).when(delegate).setNetworkTimeout(Mockito.<Executor>any(), anyInt());

    // Act
    (new SandBoxConnection(delegate, new GenericObjectPool())).setNetworkTimeout(mock(Executor.class), 1000);

    // Assert
    verify(delegate).setNetworkTimeout(isA(Executor.class), eq(1000));
  }

  /**
   * Method under test: {@link SandBoxConnection#getNetworkTimeout()}
   */
  @Test
  public void testGetNetworkTimeout() throws SQLException {
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
   * Method under test: {@link SandBoxConnection#getNetworkTimeout()}
   */
  @Test
  public void testGetNetworkTimeout2() throws SQLException {
    // Arrange
    Connection delegate = mock(Connection.class);
    when(delegate.getNetworkTimeout()).thenThrow(new SQLException());

    // Act
    int actualNetworkTimeout = (new SandBoxConnection(delegate, new GenericObjectPool())).getNetworkTimeout();

    // Assert
    verify(delegate).getNetworkTimeout();
    assertEquals(0, actualNetworkTimeout);
  }

  /**
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
}

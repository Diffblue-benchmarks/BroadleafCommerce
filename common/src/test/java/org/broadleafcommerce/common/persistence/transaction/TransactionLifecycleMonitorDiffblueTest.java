/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.persistence.transaction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.FactoryBeanNotInitializedException;

public class TransactionLifecycleMonitorDiffblueTest {
  /**
   * Method under test: {@link TransactionLifecycleMonitor#stop(Runnable)}
   */
  @Test
  public void testStop() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransactionLifecycleMonitor transactionLifecycleMonitor = new TransactionLifecycleMonitor();
    Runnable callback = mock(Runnable.class);
    doNothing().when(callback).run();

    // Act
    transactionLifecycleMonitor.stop(callback);

    // Assert that nothing has changed
    verify(callback).run();
  }

  /**
   * Method under test: {@link TransactionLifecycleMonitor#stop(Runnable)}
   */
  @Test
  public void testStop2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransactionLifecycleMonitor transactionLifecycleMonitor = new TransactionLifecycleMonitor();
    Runnable callback = mock(Runnable.class);
    doThrow(new UnsupportedOperationException("foo")).when(callback).run();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> transactionLifecycleMonitor.stop(callback));
    verify(callback).run();
  }

  /**
   * Method under test:
   * {@link TransactionLifecycleMonitor#decompressLogLine(String)}
   */
  @Test
  public void testDecompressLogLine() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new TransactionLifecycleMonitor()).decompressLogLine(":"));
  }

  /**
   * Method under test:
   * {@link TransactionLifecycleMonitor#detectLeakage(List, Integer, long, TransactionInfo)}
   */
  @Test
  public void testDetectLeakage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransactionLifecycleMonitor transactionLifecycleMonitor = new TransactionLifecycleMonitor();
    ArrayList<Integer> infosToRemove = new ArrayList<>();

    // Act and Assert
    assertFalse(transactionLifecycleMonitor.detectLeakage(infosToRemove, 1, 1L, new TransactionInfo()));
    assertTrue(infosToRemove.isEmpty());
  }

  /**
   * Method under test:
   * {@link TransactionLifecycleMonitor#detectLeakage(List, Integer, long, TransactionInfo)}
   */
  @Test
  public void testDetectLeakage2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransactionLifecycleMonitor transactionLifecycleMonitor = new TransactionLifecycleMonitor();
    ArrayList<Integer> infosToRemove = new ArrayList<>();
    TransactionInfo info = mock(TransactionInfo.class);
    when(info.getLastLogTime()).thenReturn(1L);

    // Act
    boolean actualDetectLeakageResult = transactionLifecycleMonitor.detectLeakage(infosToRemove, 1, 1L, info);

    // Assert
    verify(info).getLastLogTime();
    assertFalse(actualDetectLeakageResult);
    assertTrue(infosToRemove.isEmpty());
  }

  /**
   * Method under test:
   * {@link TransactionLifecycleMonitor#detectLeakage(List, Integer, long, TransactionInfo)}
   */
  @Test
  public void testDetectLeakage3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransactionLifecycleMonitor transactionLifecycleMonitor = new TransactionLifecycleMonitor();
    ArrayList<Integer> infosToRemove = new ArrayList<>();
    TransactionInfo info = mock(TransactionInfo.class);
    when(info.getStartTime()).thenReturn(1L);
    doNothing().when(info).setFaultStateDetected(Mockito.<Boolean>any());
    when(info.getLastLogTime()).thenReturn(1L);

    // Act
    boolean actualDetectLeakageResult = transactionLifecycleMonitor.detectLeakage(infosToRemove, 1, Long.MAX_VALUE,
        info);

    // Assert
    verify(info, atLeast(1)).getLastLogTime();
    verify(info).getStartTime();
    verify(info).setFaultStateDetected(eq(true));
    assertEquals(1, infosToRemove.size());
    assertEquals(1, infosToRemove.get(0).intValue());
    assertTrue(actualDetectLeakageResult);
  }

  /**
   * Method under test:
   * {@link TransactionLifecycleMonitor#detectLeakage(List, Integer, long, TransactionInfo)}
   */
  @Test
  public void testDetectLeakage4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransactionLifecycleMonitor transactionLifecycleMonitor = new TransactionLifecycleMonitor();
    ArrayList<Integer> infosToRemove = new ArrayList<>();
    TransactionInfo info = mock(TransactionInfo.class);
    doThrow(new FactoryBeanNotInitializedException(
        "TRANSACTIONMONITOR(1) - The thread associated with the tested TransactionInfo is not considered stuck,"
            + " but the TransactionInfo has been alive for %s milliseconds and a SQL statement has not been reported"
            + " against the tracked EntityManager in %s milliseconds. This could indicate the thread has moved on and"
            + " the transaction was not properly finalized. Logging TransactionInfo: \n" + "%s"))
        .when(info)
        .setFaultStateDetected(Mockito.<Boolean>any());
    when(info.getLastLogTime()).thenReturn(1L);

    // Act and Assert
    assertThrows(FactoryBeanNotInitializedException.class,
        () -> transactionLifecycleMonitor.detectLeakage(infosToRemove, 1, Long.MAX_VALUE, info));
    verify(info).getLastLogTime();
    verify(info).setFaultStateDetected(eq(true));
  }

  /**
   * Method under test:
   * {@link TransactionLifecycleMonitor#detectExpiry(List, Integer, long, TransactionInfo, StackTraceElement[])}
   */
  @Test
  public void testDetectExpiry() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransactionLifecycleMonitor transactionLifecycleMonitor = new TransactionLifecycleMonitor();
    ArrayList<Integer> infosToRemove = new ArrayList<>();
    TransactionInfo info = new TransactionInfo();

    // Act and Assert
    assertFalse(transactionLifecycleMonitor.detectExpiry(infosToRemove, 1, 1L, info,
        new StackTraceElement[]{new StackTraceElement("foo", "foo", "foo", 1)}));
    assertTrue(infosToRemove.isEmpty());
  }

  /**
   * Method under test:
   * {@link TransactionLifecycleMonitor#detectExpiry(List, Integer, long, TransactionInfo, StackTraceElement[])}
   */
  @Test
  public void testDetectExpiry2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransactionLifecycleMonitor transactionLifecycleMonitor = new TransactionLifecycleMonitor();
    ArrayList<Integer> infosToRemove = new ArrayList<>();
    TransactionInfo info = mock(TransactionInfo.class);
    when(info.getStartTime()).thenReturn(1L);

    // Act
    boolean actualDetectExpiryResult = transactionLifecycleMonitor.detectExpiry(infosToRemove, 1, 1L, info,
        new StackTraceElement[]{new StackTraceElement("foo", "foo", "foo", 1)});

    // Assert
    verify(info).getStartTime();
    assertFalse(actualDetectExpiryResult);
    assertTrue(infosToRemove.isEmpty());
  }

  /**
   * Method under test:
   * {@link TransactionLifecycleMonitor#detectExpiry(List, Integer, long, TransactionInfo, StackTraceElement[])}
   */
  @Test
  public void testDetectExpiry3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransactionLifecycleMonitor transactionLifecycleMonitor = new TransactionLifecycleMonitor();
    ArrayList<Integer> infosToRemove = new ArrayList<>();
    TransactionInfo info = mock(TransactionInfo.class);
    when(info.getStuckThreadStartTime()).thenReturn(1L);
    doNothing().when(info).setFaultStateDetected(Mockito.<Boolean>any());
    when(info.getStartTime()).thenReturn(1L);

    // Act
    boolean actualDetectExpiryResult = transactionLifecycleMonitor.detectExpiry(infosToRemove, 1, Long.MAX_VALUE, info,
        new StackTraceElement[]{new StackTraceElement("foo", "foo", "foo", 1)});

    // Assert
    verify(info, atLeast(1)).getStartTime();
    verify(info, atLeast(1)).getStuckThreadStartTime();
    verify(info).setFaultStateDetected(eq(true));
    assertEquals(1, infosToRemove.size());
    assertEquals(1, infosToRemove.get(0).intValue());
    assertTrue(actualDetectExpiryResult);
  }

  /**
   * Method under test:
   * {@link TransactionLifecycleMonitor#detectExpiry(List, Integer, long, TransactionInfo, StackTraceElement[])}
   */
  @Test
  public void testDetectExpiry4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransactionLifecycleMonitor transactionLifecycleMonitor = new TransactionLifecycleMonitor();
    ArrayList<Integer> infosToRemove = new ArrayList<>();
    TransactionInfo info = mock(TransactionInfo.class);
    when(info.getStuckThreadStartTime()).thenReturn(-2L);
    doNothing().when(info).setFaultStateDetected(Mockito.<Boolean>any());
    when(info.getStartTime()).thenReturn(1L);

    // Act
    boolean actualDetectExpiryResult = transactionLifecycleMonitor.detectExpiry(infosToRemove, 1, Long.MAX_VALUE, info,
        new StackTraceElement[]{new StackTraceElement("foo", "foo", "foo", 1)});

    // Assert
    verify(info).getStartTime();
    verify(info, atLeast(1)).getStuckThreadStartTime();
    verify(info).setFaultStateDetected(eq(true));
    assertFalse(actualDetectExpiryResult);
    assertTrue(infosToRemove.isEmpty());
  }

  /**
   * Method under test:
   * {@link TransactionLifecycleMonitor#detectExpiry(List, Integer, long, TransactionInfo, StackTraceElement[])}
   */
  @Test
  public void testDetectExpiry5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransactionLifecycleMonitor transactionLifecycleMonitor = new TransactionLifecycleMonitor();
    ArrayList<Integer> infosToRemove = new ArrayList<>();
    TransactionInfo info = mock(TransactionInfo.class);
    when(info.getFaultStateDetected()).thenReturn(true);
    when(info.getStuckThreadStartTime()).thenReturn(null);
    doNothing().when(info).setFaultStateDetected(Mockito.<Boolean>any());
    when(info.getStartTime()).thenReturn(1L);

    // Act
    boolean actualDetectExpiryResult = transactionLifecycleMonitor.detectExpiry(infosToRemove, 1, Long.MAX_VALUE, info,
        new StackTraceElement[]{new StackTraceElement("foo", "foo", "foo", 1)});

    // Assert
    verify(info).getFaultStateDetected();
    verify(info).getStartTime();
    verify(info).getStuckThreadStartTime();
    verify(info).setFaultStateDetected(eq(true));
    assertFalse(actualDetectExpiryResult);
    assertTrue(infosToRemove.isEmpty());
  }

  /**
   * Method under test:
   * {@link TransactionLifecycleMonitor#detectExpiry(List, Integer, long, TransactionInfo, StackTraceElement[])}
   */
  @Test
  public void testDetectExpiry6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransactionLifecycleMonitor transactionLifecycleMonitor = new TransactionLifecycleMonitor();
    ArrayList<Integer> infosToRemove = new ArrayList<>();
    TransactionInfo info = mock(TransactionInfo.class);
    when(info.getFaultStateDetected()).thenReturn(false);
    when(info.getStuckThreadStartTime()).thenReturn(null);
    doNothing().when(info).setFaultStateDetected(Mockito.<Boolean>any());
    when(info.getStartTime()).thenReturn(1L);

    // Act
    boolean actualDetectExpiryResult = transactionLifecycleMonitor.detectExpiry(infosToRemove, 1, Long.MAX_VALUE, info,
        new StackTraceElement[]{new StackTraceElement("foo", "foo", "foo", 1)});

    // Assert
    verify(info).getFaultStateDetected();
    verify(info, atLeast(1)).getStartTime();
    verify(info).getStuckThreadStartTime();
    verify(info).setFaultStateDetected(eq(true));
    assertFalse(actualDetectExpiryResult);
    assertTrue(infosToRemove.isEmpty());
  }

  /**
   * Method under test:
   * {@link TransactionLifecycleMonitor#compileThreadInformation(long, TransactionInfo, Thread)}
   */
  @Test
  public void testCompileThreadInformation() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransactionLifecycleMonitor transactionLifecycleMonitor = new TransactionLifecycleMonitor();
    TransactionInfo info = new TransactionInfo();

    // Act and Assert
    assertNull(transactionLifecycleMonitor.compileThreadInformation(1L, info, new Thread()));
  }

  /**
   * Method under test:
   * {@link TransactionLifecycleMonitor#compileThreadInformation(long, TransactionInfo, Thread)}
   */
  @Test
  public void testCompileThreadInformation2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransactionLifecycleMonitor transactionLifecycleMonitor = new TransactionLifecycleMonitor();

    // Act and Assert
    assertNull(transactionLifecycleMonitor.compileThreadInformation(1L, new TransactionInfo(), null));
  }

  /**
   * Method under test:
   * {@link TransactionLifecycleMonitor#getCurrentTransactionInfo()}
   */
  @Test
  public void testGetCurrentTransactionInfo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new TransactionLifecycleMonitor()).getCurrentTransactionInfo());
  }

  /**
   * Method under test:
   * {@link TransactionLifecycleMonitor#isAtLeastOneTransactionManagerEnabled()}
   */
  @Test
  public void testIsAtLeastOneTransactionManagerEnabled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new TransactionLifecycleMonitor()).isAtLeastOneTransactionManagerEnabled());
  }

  /**
   * Method under test: {@link TransactionLifecycleMonitor#getInstance()}
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertNull(TransactionLifecycleMonitor.getInstance().getInstance());
  }
}

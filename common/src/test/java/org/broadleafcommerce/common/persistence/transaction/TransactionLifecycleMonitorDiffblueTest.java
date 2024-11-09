/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
   * Test {@link TransactionLifecycleMonitor#stop(Runnable)} with
   * {@code Runnable}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionLifecycleMonitor#stop(Runnable)}
   */
  @Test
  public void testStopWithRunnable_thenThrowUnsupportedOperationException() {
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
   * Test {@link TransactionLifecycleMonitor#stop(Runnable)} with
   * {@code Runnable}.
   * <ul>
   *   <li>When {@link Runnable} {@link Runnable#run()} does nothing.</li>
   *   <li>Then calls {@link Runnable#run()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionLifecycleMonitor#stop(Runnable)}
   */
  @Test
  public void testStopWithRunnable_whenRunnableRunDoesNothing_thenCallsRun() {
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
   * Test {@link TransactionLifecycleMonitor#decompressLogLine(String)}.
   * <ul>
   *   <li>When {@code :}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransactionLifecycleMonitor#decompressLogLine(String)}
   */
  @Test
  public void testDecompressLogLine_whenColon_thenReturnEmptyString() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new TransactionLifecycleMonitor()).decompressLogLine(":"));
  }

  /**
   * Test
   * {@link TransactionLifecycleMonitor#detectLeakage(List, Integer, long, TransactionInfo)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransactionLifecycleMonitor#detectLeakage(List, Integer, long, TransactionInfo)}
   */
  @Test
  public void testDetectLeakage_thenArrayListSizeIsOne() {
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
   * Test
   * {@link TransactionLifecycleMonitor#detectLeakage(List, Integer, long, TransactionInfo)}.
   * <ul>
   *   <li>Then throw {@link FactoryBeanNotInitializedException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransactionLifecycleMonitor#detectLeakage(List, Integer, long, TransactionInfo)}
   */
  @Test
  public void testDetectLeakage_thenThrowFactoryBeanNotInitializedException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransactionLifecycleMonitor transactionLifecycleMonitor = new TransactionLifecycleMonitor();
    ArrayList<Integer> infosToRemove = new ArrayList<>();
    TransactionInfo info = mock(TransactionInfo.class);
    doThrow(new FactoryBeanNotInitializedException(
        "TRANSACTIONMONITOR(1) - The thread associated with the tested TransactionInfo is not considered stuck,"
            + " but the TransactionInfo has been alive for %s milliseconds and a SQL statement has not been reported"
            + " against the tracked EntityManager in %s milliseconds. This could indicate the thread has moved on and"
            + " the transaction was not properly finalized. Logging TransactionInfo: \n" + "%s")).when(info)
                .setFaultStateDetected(Mockito.<Boolean>any());
    when(info.getLastLogTime()).thenReturn(1L);

    // Act and Assert
    assertThrows(FactoryBeanNotInitializedException.class,
        () -> transactionLifecycleMonitor.detectLeakage(infosToRemove, 1, Long.MAX_VALUE, info));
    verify(info).getLastLogTime();
    verify(info).setFaultStateDetected(eq(true));
  }

  /**
   * Test
   * {@link TransactionLifecycleMonitor#detectLeakage(List, Integer, long, TransactionInfo)}.
   * <ul>
   *   <li>When {@link TransactionInfo} {@link TransactionInfo#getLastLogTime()}
   * return one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransactionLifecycleMonitor#detectLeakage(List, Integer, long, TransactionInfo)}
   */
  @Test
  public void testDetectLeakage_whenTransactionInfoGetLastLogTimeReturnOne_thenReturnFalse() {
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
   * Test
   * {@link TransactionLifecycleMonitor#detectLeakage(List, Integer, long, TransactionInfo)}.
   * <ul>
   *   <li>When {@link TransactionInfo#TransactionInfo()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransactionLifecycleMonitor#detectLeakage(List, Integer, long, TransactionInfo)}
   */
  @Test
  public void testDetectLeakage_whenTransactionInfo_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransactionLifecycleMonitor transactionLifecycleMonitor = new TransactionLifecycleMonitor();
    ArrayList<Integer> infosToRemove = new ArrayList<>();

    // Act and Assert
    assertFalse(transactionLifecycleMonitor.detectLeakage(infosToRemove, 1, 1L, new TransactionInfo()));
    assertTrue(infosToRemove.isEmpty());
  }

  /**
   * Test
   * {@link TransactionLifecycleMonitor#detectExpiry(List, Integer, long, TransactionInfo, StackTraceElement[])}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link TransactionInfo}
   * {@link TransactionInfo#getFaultStateDetected()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransactionLifecycleMonitor#detectExpiry(List, Integer, long, TransactionInfo, StackTraceElement[])}
   */
  @Test
  public void testDetectExpiry_givenFalse_whenTransactionInfoGetFaultStateDetectedReturnFalse() {
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
   * Test
   * {@link TransactionLifecycleMonitor#detectExpiry(List, Integer, long, TransactionInfo, StackTraceElement[])}.
   * <ul>
   *   <li>Given minus two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransactionLifecycleMonitor#detectExpiry(List, Integer, long, TransactionInfo, StackTraceElement[])}
   */
  @Test
  public void testDetectExpiry_givenMinusTwo() {
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
   * Test
   * {@link TransactionLifecycleMonitor#detectExpiry(List, Integer, long, TransactionInfo, StackTraceElement[])}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link TransactionInfo}
   * {@link TransactionInfo#getFaultStateDetected()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransactionLifecycleMonitor#detectExpiry(List, Integer, long, TransactionInfo, StackTraceElement[])}
   */
  @Test
  public void testDetectExpiry_givenTrue_whenTransactionInfoGetFaultStateDetectedReturnTrue() {
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
   * Test
   * {@link TransactionLifecycleMonitor#detectExpiry(List, Integer, long, TransactionInfo, StackTraceElement[])}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransactionLifecycleMonitor#detectExpiry(List, Integer, long, TransactionInfo, StackTraceElement[])}
   */
  @Test
  public void testDetectExpiry_thenArrayListSizeIsOne() {
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
   * Test
   * {@link TransactionLifecycleMonitor#detectExpiry(List, Integer, long, TransactionInfo, StackTraceElement[])}.
   * <ul>
   *   <li>When {@link TransactionInfo} {@link TransactionInfo#getStartTime()}
   * return one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransactionLifecycleMonitor#detectExpiry(List, Integer, long, TransactionInfo, StackTraceElement[])}
   */
  @Test
  public void testDetectExpiry_whenTransactionInfoGetStartTimeReturnOne_thenReturnFalse() {
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
   * Test
   * {@link TransactionLifecycleMonitor#detectExpiry(List, Integer, long, TransactionInfo, StackTraceElement[])}.
   * <ul>
   *   <li>When {@link TransactionInfo#TransactionInfo()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransactionLifecycleMonitor#detectExpiry(List, Integer, long, TransactionInfo, StackTraceElement[])}
   */
  @Test
  public void testDetectExpiry_whenTransactionInfo_thenReturnFalse() {
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
   * Test
   * {@link TransactionLifecycleMonitor#compileThreadInformation(long, TransactionInfo, Thread)}.
   * <ul>
   *   <li>Given {@link TransactionLifecycleMonitor} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransactionLifecycleMonitor#compileThreadInformation(long, TransactionInfo, Thread)}
   */
  @Test
  public void testCompileThreadInformation_givenTransactionLifecycleMonitor_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransactionLifecycleMonitor transactionLifecycleMonitor = new TransactionLifecycleMonitor();
    TransactionInfo info = new TransactionInfo();

    // Act and Assert
    assertNull(transactionLifecycleMonitor.compileThreadInformation(1L, info, new Thread()));
  }

  /**
   * Test
   * {@link TransactionLifecycleMonitor#compileThreadInformation(long, TransactionInfo, Thread)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransactionLifecycleMonitor#compileThreadInformation(long, TransactionInfo, Thread)}
   */
  @Test
  public void testCompileThreadInformation_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransactionLifecycleMonitor transactionLifecycleMonitor = new TransactionLifecycleMonitor();

    // Act and Assert
    assertNull(transactionLifecycleMonitor.compileThreadInformation(1L, new TransactionInfo(), null));
  }

  /**
   * Test {@link TransactionLifecycleMonitor#getCurrentTransactionInfo()}.
   * <ul>
   *   <li>Given {@link TransactionLifecycleMonitor} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransactionLifecycleMonitor#getCurrentTransactionInfo()}
   */
  @Test
  public void testGetCurrentTransactionInfo_givenTransactionLifecycleMonitor_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new TransactionLifecycleMonitor()).getCurrentTransactionInfo());
  }

  /**
   * Test
   * {@link TransactionLifecycleMonitor#isAtLeastOneTransactionManagerEnabled()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransactionLifecycleMonitor#isAtLeastOneTransactionManagerEnabled()}
   */
  @Test
  public void testIsAtLeastOneTransactionManagerEnabled_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new TransactionLifecycleMonitor()).isAtLeastOneTransactionManagerEnabled());
  }
}

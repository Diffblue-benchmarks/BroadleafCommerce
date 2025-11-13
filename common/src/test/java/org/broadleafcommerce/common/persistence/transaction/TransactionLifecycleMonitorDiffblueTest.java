package org.broadleafcommerce.common.persistence.transaction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.engine.spi.SessionFactoryDelegatingImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {TransactionLifecycleMonitor.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class TransactionLifecycleMonitorDiffblueTest {
  @MockBean private LifecycleAwareJpaTransactionManager lifecycleAwareJpaTransactionManager;

  @Autowired private List<TransactionInfoCustomModifier> list;

  @Autowired private List<LifecycleAwareJpaTransactionManager> list2;

  @MockBean private TransactionInfoCustomModifier transactionInfoCustomModifier;

  @Autowired private TransactionLifecycleMonitor transactionLifecycleMonitor;

  /**
   * Test {@link TransactionLifecycleMonitor#init()}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>Then Instance Running.
   * </ul>
   *
   * <p>Method under test: {@link TransactionLifecycleMonitor#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionLifecycleMonitor.init()"})
  public void testInit_givenInstance_thenInstanceRunning() {
    // Arrange
    TransactionLifecycleMonitor instance = TransactionLifecycleMonitor.getInstance();

    // Act
    instance.init();

    // Assert that nothing has changed
    assertTrue(instance.isRunning());
  }

  /**
   * Test {@link TransactionLifecycleMonitor#init()}.
   *
   * <ul>
   *   <li>Given {@link TransactionLifecycleMonitor} (default constructor).
   *   <li>Then {@link TransactionLifecycleMonitor} (default constructor) Running.
   * </ul>
   *
   * <p>Method under test: {@link TransactionLifecycleMonitor#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionLifecycleMonitor.init()"})
  public void testInit_givenTransactionLifecycleMonitor_thenTransactionLifecycleMonitorRunning() {
    // Arrange
    TransactionLifecycleMonitor transactionLifecycleMonitor = new TransactionLifecycleMonitor();

    // Act
    transactionLifecycleMonitor.init();

    // Assert
    assertTrue(transactionLifecycleMonitor.isRunning());
  }

  /**
   * Test {@link TransactionLifecycleMonitor#stop(Runnable)} with {@code Runnable}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionLifecycleMonitor#stop(Runnable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionLifecycleMonitor.stop(Runnable)"})
  public void testStopWithRunnable_thenThrowUnsupportedOperationException() {
    // Arrange
    Runnable callback = mock(Runnable.class);
    doThrow(new UnsupportedOperationException()).when(callback).run();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> transactionLifecycleMonitor.stop(callback));
    verify(callback).run();
  }

  /**
   * Test {@link TransactionLifecycleMonitor#stop(Runnable)} with {@code Runnable}.
   *
   * <ul>
   *   <li>When {@link Runnable} {@link Runnable#run()} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link TransactionLifecycleMonitor#stop(Runnable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionLifecycleMonitor.stop(Runnable)"})
  public void testStopWithRunnable_whenRunnableRunDoesNothing() {
    // Arrange
    Runnable callback = mock(Runnable.class);
    doNothing().when(callback).run();

    // Act
    transactionLifecycleMonitor.stop(callback);

    // Assert
    verify(callback).run();
  }

  /**
   * Test {@link TransactionLifecycleMonitor#decompressLogLine(String)}.
   *
   * <ul>
   *   <li>When {@code :}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link TransactionLifecycleMonitor#decompressLogLine(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TransactionLifecycleMonitor.decompressLogLine(String)"})
  public void testDecompressLogLine_whenColon_thenReturnEmptyString() throws IOException {
    // Arrange, Act and Assert
    assertEquals("", transactionLifecycleMonitor.decompressLogLine(":"));
  }

  /**
   * Test {@link TransactionLifecycleMonitor#decompressLogLine(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link TransactionLifecycleMonitor#decompressLogLine(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TransactionLifecycleMonitor.decompressLogLine(String)"})
  public void testDecompressLogLine_whenEmptyString_thenReturnEmptyString() throws IOException {
    // Arrange, Act and Assert
    assertEquals("", transactionLifecycleMonitor.decompressLogLine(""));
  }

  /**
   * Test {@link TransactionLifecycleMonitor#detectLeakage(List, Integer, long, TransactionInfo)}.
   *
   * <ul>
   *   <li>Given {@code 300000}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 300000}.
   *   <li>Then {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link TransactionLifecycleMonitor#detectLeakage(List, Integer, long,
   * TransactionInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TransactionLifecycleMonitor.detectLeakage(List, Integer, long, TransactionInfo)"
  })
  public void testDetectLeakage_given300000_whenArrayListAdd300000_thenArrayListSizeIsTwo() {
    // Arrange
    ArrayList<Integer> infosToRemove = new ArrayList<>();
    infosToRemove.add(300000);
    infosToRemove.add(2);

    TransactionInfo info = mock(TransactionInfo.class);
    when(info.getLastLogTime()).thenReturn(1L);

    // Act
    boolean actualDetectLeakageResult =
        transactionLifecycleMonitor.detectLeakage(infosToRemove, 1, 1L, info);

    // Assert
    verify(info).getLastLogTime();
    assertEquals(2, infosToRemove.size());
    assertEquals(300000, infosToRemove.get(0).intValue());
    assertFalse(actualDetectLeakageResult);
  }

  /**
   * Test {@link TransactionLifecycleMonitor#detectLeakage(List, Integer, long, TransactionInfo)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link TransactionLifecycleMonitor#detectLeakage(List, Integer, long,
   * TransactionInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TransactionLifecycleMonitor.detectLeakage(List, Integer, long, TransactionInfo)"
  })
  public void testDetectLeakage_givenOne_whenArrayList_thenArrayListEmpty() {
    // Arrange
    ArrayList<Integer> infosToRemove = new ArrayList<>();

    TransactionInfo info = mock(TransactionInfo.class);
    when(info.getLastLogTime()).thenReturn(1L);

    // Act
    boolean actualDetectLeakageResult =
        transactionLifecycleMonitor.detectLeakage(infosToRemove, 1, 1L, info);

    // Assert
    verify(info).getLastLogTime();
    assertFalse(actualDetectLeakageResult);
    assertTrue(infosToRemove.isEmpty());
  }

  /**
   * Test {@link TransactionLifecycleMonitor#detectLeakage(List, Integer, long, TransactionInfo)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link ArrayList#ArrayList()} add two.
   *   <li>Then {@link ArrayList#ArrayList()} first intValue is two.
   * </ul>
   *
   * <p>Method under test: {@link TransactionLifecycleMonitor#detectLeakage(List, Integer, long,
   * TransactionInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TransactionLifecycleMonitor.detectLeakage(List, Integer, long, TransactionInfo)"
  })
  public void testDetectLeakage_givenTwo_whenArrayListAddTwo_thenArrayListFirstIntValueIsTwo() {
    // Arrange
    ArrayList<Integer> infosToRemove = new ArrayList<>();
    infosToRemove.add(2);

    TransactionInfo info = mock(TransactionInfo.class);
    when(info.getLastLogTime()).thenReturn(1L);

    // Act
    boolean actualDetectLeakageResult =
        transactionLifecycleMonitor.detectLeakage(infosToRemove, 1, 1L, info);

    // Assert
    verify(info).getLastLogTime();
    assertEquals(1, infosToRemove.size());
    assertEquals(2, infosToRemove.get(0).intValue());
    assertFalse(actualDetectLeakageResult);
  }

  /**
   * Test {@link TransactionLifecycleMonitor#detectLeakage(List, Integer, long, TransactionInfo)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionLifecycleMonitor#detectLeakage(List, Integer, long,
   * TransactionInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TransactionLifecycleMonitor.detectLeakage(List, Integer, long, TransactionInfo)"
  })
  public void testDetectLeakage_thenArrayListFirstIntValueIsOne() {
    // Arrange
    ArrayList<Integer> infosToRemove = new ArrayList<>();

    TransactionInfo info = mock(TransactionInfo.class);
    when(info.getStartTime()).thenReturn(1L);
    doNothing().when(info).setFaultStateDetected(Mockito.<Boolean>any());
    when(info.getLastLogTime()).thenReturn(1L);

    // Act
    boolean actualDetectLeakageResult =
        transactionLifecycleMonitor.detectLeakage(infosToRemove, 1, Long.MAX_VALUE, info);

    // Assert
    verify(info, atLeast(1)).getLastLogTime();
    verify(info).getStartTime();
    verify(info).setFaultStateDetected(true);
    assertEquals(1, infosToRemove.size());
    assertEquals(1, infosToRemove.get(0).intValue());
    assertTrue(actualDetectLeakageResult);
  }

  /**
   * Test {@link TransactionLifecycleMonitor#detectLeakage(List, Integer, long, TransactionInfo)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionLifecycleMonitor#detectLeakage(List, Integer, long,
   * TransactionInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TransactionLifecycleMonitor.detectLeakage(List, Integer, long, TransactionInfo)"
  })
  public void testDetectLeakage_thenThrowUnsupportedOperationException() {
    // Arrange
    ArrayList<Integer> infosToRemove = new ArrayList<>();

    TransactionInfo info = mock(TransactionInfo.class);
    doThrow(new UnsupportedOperationException())
        .when(info)
        .setFaultStateDetected(Mockito.<Boolean>any());
    when(info.getLastLogTime()).thenReturn(1L);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> transactionLifecycleMonitor.detectLeakage(infosToRemove, 1, Long.MAX_VALUE, info));
    verify(info).getLastLogTime();
    verify(info).setFaultStateDetected(true);
  }

  /**
   * Test {@link TransactionLifecycleMonitor#detectLeakage(List, Integer, long, TransactionInfo)}.
   *
   * <ul>
   *   <li>When {@link TransactionInfo#TransactionInfo()}.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link TransactionLifecycleMonitor#detectLeakage(List, Integer, long,
   * TransactionInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TransactionLifecycleMonitor.detectLeakage(List, Integer, long, TransactionInfo)"
  })
  public void testDetectLeakage_whenTransactionInfo_thenArrayListEmpty() {
    // Arrange
    ArrayList<Integer> infosToRemove = new ArrayList<>();

    // Act and Assert
    assertFalse(
        transactionLifecycleMonitor.detectLeakage(infosToRemove, 1, 1L, new TransactionInfo()));
    assertTrue(infosToRemove.isEmpty());
  }

  /**
   * Test {@link TransactionLifecycleMonitor#detectExpiry(List, Integer, long, TransactionInfo,
   * StackTraceElement[])}.
   *
   * <ul>
   *   <li>Given {@code 600000}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 600000}.
   *   <li>Then {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link TransactionLifecycleMonitor#detectExpiry(List, Integer, long,
   * TransactionInfo, StackTraceElement[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TransactionLifecycleMonitor.detectExpiry(List, Integer, long, TransactionInfo, StackTraceElement[])"
  })
  public void testDetectExpiry_given600000_whenArrayListAdd600000_thenArrayListSizeIsTwo() {
    // Arrange
    ArrayList<Integer> infosToRemove = new ArrayList<>();
    infosToRemove.add(600000);
    infosToRemove.add(2);

    TransactionInfo info = mock(TransactionInfo.class);
    when(info.getStartTime()).thenReturn(1L);
    StackTraceElement stackTraceElement = new StackTraceElement("foo", "foo", "foo", 1);

    // Act
    boolean actualDetectExpiryResult =
        transactionLifecycleMonitor.detectExpiry(
            infosToRemove, 1, 1L, info, new StackTraceElement[] {stackTraceElement});

    // Assert
    verify(info).getStartTime();
    assertEquals(2, infosToRemove.size());
    assertEquals(600000, infosToRemove.get(0).intValue());
    assertFalse(actualDetectExpiryResult);
  }

  /**
   * Test {@link TransactionLifecycleMonitor#detectExpiry(List, Integer, long, TransactionInfo,
   * StackTraceElement[])}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link TransactionInfo} {@link TransactionInfo#getFaultStateDetected()} return
   *       {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionLifecycleMonitor#detectExpiry(List, Integer, long,
   * TransactionInfo, StackTraceElement[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TransactionLifecycleMonitor.detectExpiry(List, Integer, long, TransactionInfo, StackTraceElement[])"
  })
  public void testDetectExpiry_givenFalse_whenTransactionInfoGetFaultStateDetectedReturnFalse() {
    // Arrange
    ArrayList<Integer> infosToRemove = new ArrayList<>();

    TransactionInfo info = mock(TransactionInfo.class);
    when(info.getFaultStateDetected()).thenReturn(false);
    when(info.getStuckThreadStartTime()).thenReturn(null);
    doNothing().when(info).setFaultStateDetected(Mockito.<Boolean>any());
    when(info.getStartTime()).thenReturn(1L);
    StackTraceElement stackTraceElement = new StackTraceElement("foo", "foo", "foo", 1);

    // Act
    boolean actualDetectExpiryResult =
        transactionLifecycleMonitor.detectExpiry(
            infosToRemove, 1, Long.MAX_VALUE, info, new StackTraceElement[] {stackTraceElement});

    // Assert
    verify(info).getFaultStateDetected();
    verify(info, atLeast(1)).getStartTime();
    verify(info).getStuckThreadStartTime();
    verify(info).setFaultStateDetected(true);
    assertFalse(actualDetectExpiryResult);
    assertTrue(infosToRemove.isEmpty());
  }

  /**
   * Test {@link TransactionLifecycleMonitor#detectExpiry(List, Integer, long, TransactionInfo,
   * StackTraceElement[])}.
   *
   * <ul>
   *   <li>Given minus two.
   * </ul>
   *
   * <p>Method under test: {@link TransactionLifecycleMonitor#detectExpiry(List, Integer, long,
   * TransactionInfo, StackTraceElement[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TransactionLifecycleMonitor.detectExpiry(List, Integer, long, TransactionInfo, StackTraceElement[])"
  })
  public void testDetectExpiry_givenMinusTwo() {
    // Arrange
    ArrayList<Integer> infosToRemove = new ArrayList<>();

    TransactionInfo info = mock(TransactionInfo.class);
    when(info.getStuckThreadStartTime()).thenReturn(-2L);
    doNothing().when(info).setFaultStateDetected(Mockito.<Boolean>any());
    when(info.getStartTime()).thenReturn(1L);
    StackTraceElement stackTraceElement = new StackTraceElement("foo", "foo", "foo", 1);

    // Act
    boolean actualDetectExpiryResult =
        transactionLifecycleMonitor.detectExpiry(
            infosToRemove, 1, Long.MAX_VALUE, info, new StackTraceElement[] {stackTraceElement});

    // Assert
    verify(info).getStartTime();
    verify(info, atLeast(1)).getStuckThreadStartTime();
    verify(info).setFaultStateDetected(true);
    assertFalse(actualDetectExpiryResult);
    assertTrue(infosToRemove.isEmpty());
  }

  /**
   * Test {@link TransactionLifecycleMonitor#detectExpiry(List, Integer, long, TransactionInfo,
   * StackTraceElement[])}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionLifecycleMonitor#detectExpiry(List, Integer, long,
   * TransactionInfo, StackTraceElement[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TransactionLifecycleMonitor.detectExpiry(List, Integer, long, TransactionInfo, StackTraceElement[])"
  })
  public void testDetectExpiry_givenOne_thenReturnFalse() {
    // Arrange
    ArrayList<Integer> infosToRemove = new ArrayList<>();

    TransactionInfo info = mock(TransactionInfo.class);
    when(info.getStartTime()).thenReturn(1L);
    StackTraceElement stackTraceElement = new StackTraceElement("foo", "foo", "foo", 1);

    // Act
    boolean actualDetectExpiryResult =
        transactionLifecycleMonitor.detectExpiry(
            infosToRemove, 1, 1L, info, new StackTraceElement[] {stackTraceElement});

    // Assert
    verify(info).getStartTime();
    assertFalse(actualDetectExpiryResult);
    assertTrue(infosToRemove.isEmpty());
  }

  /**
   * Test {@link TransactionLifecycleMonitor#detectExpiry(List, Integer, long, TransactionInfo,
   * StackTraceElement[])}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link TransactionInfo} {@link TransactionInfo#getFaultStateDetected()} return
   *       {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionLifecycleMonitor#detectExpiry(List, Integer, long,
   * TransactionInfo, StackTraceElement[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TransactionLifecycleMonitor.detectExpiry(List, Integer, long, TransactionInfo, StackTraceElement[])"
  })
  public void testDetectExpiry_givenTrue_whenTransactionInfoGetFaultStateDetectedReturnTrue() {
    // Arrange
    ArrayList<Integer> infosToRemove = new ArrayList<>();

    TransactionInfo info = mock(TransactionInfo.class);
    when(info.getFaultStateDetected()).thenReturn(true);
    when(info.getStuckThreadStartTime()).thenReturn(null);
    doNothing().when(info).setFaultStateDetected(Mockito.<Boolean>any());
    when(info.getStartTime()).thenReturn(1L);
    StackTraceElement stackTraceElement = new StackTraceElement("foo", "foo", "foo", 1);

    // Act
    boolean actualDetectExpiryResult =
        transactionLifecycleMonitor.detectExpiry(
            infosToRemove, 1, Long.MAX_VALUE, info, new StackTraceElement[] {stackTraceElement});

    // Assert
    verify(info).getFaultStateDetected();
    verify(info).getStartTime();
    verify(info).getStuckThreadStartTime();
    verify(info).setFaultStateDetected(true);
    assertFalse(actualDetectExpiryResult);
    assertTrue(infosToRemove.isEmpty());
  }

  /**
   * Test {@link TransactionLifecycleMonitor#detectExpiry(List, Integer, long, TransactionInfo,
   * StackTraceElement[])}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link ArrayList#ArrayList()} add two.
   *   <li>Then {@link ArrayList#ArrayList()} first intValue is two.
   * </ul>
   *
   * <p>Method under test: {@link TransactionLifecycleMonitor#detectExpiry(List, Integer, long,
   * TransactionInfo, StackTraceElement[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TransactionLifecycleMonitor.detectExpiry(List, Integer, long, TransactionInfo, StackTraceElement[])"
  })
  public void testDetectExpiry_givenTwo_whenArrayListAddTwo_thenArrayListFirstIntValueIsTwo() {
    // Arrange
    ArrayList<Integer> infosToRemove = new ArrayList<>();
    infosToRemove.add(2);

    TransactionInfo info = mock(TransactionInfo.class);
    when(info.getStartTime()).thenReturn(1L);
    StackTraceElement stackTraceElement = new StackTraceElement("foo", "foo", "foo", 1);

    // Act
    boolean actualDetectExpiryResult =
        transactionLifecycleMonitor.detectExpiry(
            infosToRemove, 1, 1L, info, new StackTraceElement[] {stackTraceElement});

    // Assert
    verify(info).getStartTime();
    assertEquals(1, infosToRemove.size());
    assertEquals(2, infosToRemove.get(0).intValue());
    assertFalse(actualDetectExpiryResult);
  }

  /**
   * Test {@link TransactionLifecycleMonitor#detectExpiry(List, Integer, long, TransactionInfo,
   * StackTraceElement[])}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionLifecycleMonitor#detectExpiry(List, Integer, long,
   * TransactionInfo, StackTraceElement[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TransactionLifecycleMonitor.detectExpiry(List, Integer, long, TransactionInfo, StackTraceElement[])"
  })
  public void testDetectExpiry_thenArrayListFirstIntValueIsOne() {
    // Arrange
    ArrayList<Integer> infosToRemove = new ArrayList<>();

    TransactionInfo info = mock(TransactionInfo.class);
    when(info.getStuckThreadStartTime()).thenReturn(1L);
    doNothing().when(info).setFaultStateDetected(Mockito.<Boolean>any());
    when(info.getStartTime()).thenReturn(1L);
    StackTraceElement stackTraceElement = new StackTraceElement("foo", "foo", "foo", 1);

    // Act
    boolean actualDetectExpiryResult =
        transactionLifecycleMonitor.detectExpiry(
            infosToRemove, 1, Long.MAX_VALUE, info, new StackTraceElement[] {stackTraceElement});

    // Assert
    verify(info, atLeast(1)).getStartTime();
    verify(info, atLeast(1)).getStuckThreadStartTime();
    verify(info).setFaultStateDetected(true);
    assertEquals(1, infosToRemove.size());
    assertEquals(1, infosToRemove.get(0).intValue());
    assertTrue(actualDetectExpiryResult);
  }

  /**
   * Test {@link TransactionLifecycleMonitor#detectExpiry(List, Integer, long, TransactionInfo,
   * StackTraceElement[])}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionLifecycleMonitor#detectExpiry(List, Integer, long,
   * TransactionInfo, StackTraceElement[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TransactionLifecycleMonitor.detectExpiry(List, Integer, long, TransactionInfo, StackTraceElement[])"
  })
  public void testDetectExpiry_thenArrayListFirstIntValueIsOne2() {
    // Arrange
    ArrayList<Integer> infosToRemove = new ArrayList<>();

    TransactionInfo info = mock(TransactionInfo.class);
    when(info.getStuckThreadStartTime()).thenReturn(1L);
    doNothing().when(info).setFaultStateDetected(Mockito.<Boolean>any());
    when(info.getStartTime()).thenReturn(1L);

    // Act
    boolean actualDetectExpiryResult =
        transactionLifecycleMonitor.detectExpiry(infosToRemove, 1, Long.MAX_VALUE, info, null);

    // Assert
    verify(info, atLeast(1)).getStartTime();
    verify(info, atLeast(1)).getStuckThreadStartTime();
    verify(info).setFaultStateDetected(true);
    assertEquals(1, infosToRemove.size());
    assertEquals(1, infosToRemove.get(0).intValue());
    assertTrue(actualDetectExpiryResult);
  }

  /**
   * Test {@link TransactionLifecycleMonitor#detectExpiry(List, Integer, long, TransactionInfo,
   * StackTraceElement[])}.
   *
   * <ul>
   *   <li>When {@link TransactionInfo#TransactionInfo()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionLifecycleMonitor#detectExpiry(List, Integer, long,
   * TransactionInfo, StackTraceElement[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TransactionLifecycleMonitor.detectExpiry(List, Integer, long, TransactionInfo, StackTraceElement[])"
  })
  public void testDetectExpiry_whenTransactionInfo_thenReturnFalse() {
    // Arrange
    ArrayList<Integer> infosToRemove = new ArrayList<>();
    TransactionInfo info = new TransactionInfo();
    StackTraceElement stackTraceElement = new StackTraceElement("foo", "foo", "foo", 1);

    // Act and Assert
    assertFalse(
        transactionLifecycleMonitor.detectExpiry(
            infosToRemove, 1, 1L, info, new StackTraceElement[] {stackTraceElement}));
    assertTrue(infosToRemove.isEmpty());
  }

  /**
   * Test {@link TransactionLifecycleMonitor#compileThreadInformation(long, TransactionInfo,
   * Thread)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionLifecycleMonitor#compileThreadInformation(long,
   * TransactionInfo, Thread)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "StackTraceElement[] TransactionLifecycleMonitor.compileThreadInformation(long, TransactionInfo, Thread)"
  })
  public void testCompileThreadInformation_whenNull() {
    // Arrange, Act and Assert
    assertNull(
        transactionLifecycleMonitor.compileThreadInformation(1L, new TransactionInfo(), null));
  }

  /**
   * Test {@link TransactionLifecycleMonitor#compileThreadInformation(long, TransactionInfo,
   * Thread)}.
   *
   * <ul>
   *   <li>When {@link Thread#Thread()}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionLifecycleMonitor#compileThreadInformation(long,
   * TransactionInfo, Thread)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "StackTraceElement[] TransactionLifecycleMonitor.compileThreadInformation(long, TransactionInfo, Thread)"
  })
  public void testCompileThreadInformation_whenThread() {
    // Arrange
    TransactionInfo info = new TransactionInfo();

    // Act and Assert
    assertNull(transactionLifecycleMonitor.compileThreadInformation(1L, info, new Thread()));
  }

  /**
   * Test {@link TransactionLifecycleMonitor#getCurrentTransactionInfo()}.
   *
   * <p>Method under test: {@link TransactionLifecycleMonitor#getCurrentTransactionInfo()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TransactionInfo TransactionLifecycleMonitor.getCurrentTransactionInfo()"})
  public void testGetCurrentTransactionInfo() {
    // Arrange
    when(lifecycleAwareJpaTransactionManager.isEnabled())
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> transactionLifecycleMonitor.getCurrentTransactionInfo());
    verify(lifecycleAwareJpaTransactionManager).isEnabled();
  }

  /**
   * Test {@link TransactionLifecycleMonitor#getCurrentTransactionInfo()}.
   *
   * <p>Method under test: {@link TransactionLifecycleMonitor#getCurrentTransactionInfo()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TransactionInfo TransactionLifecycleMonitor.getCurrentTransactionInfo()"})
  public void testGetCurrentTransactionInfo2() {
    // Arrange
    when(lifecycleAwareJpaTransactionManager.getEntityManagerFactory())
        .thenThrow(new UnsupportedOperationException());
    when(lifecycleAwareJpaTransactionManager.isEnabled()).thenReturn(true);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> transactionLifecycleMonitor.getCurrentTransactionInfo());
    verify(lifecycleAwareJpaTransactionManager).isEnabled();
    verify(lifecycleAwareJpaTransactionManager).getEntityManagerFactory();
  }

  /**
   * Test {@link TransactionLifecycleMonitor#getCurrentTransactionInfo()}.
   *
   * <p>Method under test: {@link TransactionLifecycleMonitor#getCurrentTransactionInfo()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TransactionInfo TransactionLifecycleMonitor.getCurrentTransactionInfo()"})
  public void testGetCurrentTransactionInfo3() {
    // Arrange
    when(lifecycleAwareJpaTransactionManager.getEntityManagerFactory())
        .thenReturn(new SessionFactoryDelegatingImpl(null));
    when(lifecycleAwareJpaTransactionManager.isEnabled()).thenReturn(true);

    // Act
    TransactionInfo actualCurrentTransactionInfo =
        transactionLifecycleMonitor.getCurrentTransactionInfo();

    // Assert
    verify(lifecycleAwareJpaTransactionManager).isEnabled();
    verify(lifecycleAwareJpaTransactionManager).getEntityManagerFactory();
    assertNull(actualCurrentTransactionInfo);
  }

  /**
   * Test {@link TransactionLifecycleMonitor#getCurrentTransactionInfo()}.
   *
   * <p>Method under test: {@link TransactionLifecycleMonitor#getCurrentTransactionInfo()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TransactionInfo TransactionLifecycleMonitor.getCurrentTransactionInfo()"})
  public void testGetCurrentTransactionInfo4() {
    // Arrange
    when(lifecycleAwareJpaTransactionManager.isEnabled()).thenReturn(false);

    // Act
    TransactionInfo actualCurrentTransactionInfo =
        transactionLifecycleMonitor.getCurrentTransactionInfo();

    // Assert
    verify(lifecycleAwareJpaTransactionManager).isEnabled();
    assertNull(actualCurrentTransactionInfo);
  }

  /**
   * Test {@link TransactionLifecycleMonitor#getCurrentTransactionInfo()}.
   *
   * <ul>
   *   <li>Given {@link TransactionLifecycleMonitor} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionLifecycleMonitor#getCurrentTransactionInfo()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TransactionInfo TransactionLifecycleMonitor.getCurrentTransactionInfo()"})
  public void testGetCurrentTransactionInfo_givenTransactionLifecycleMonitor_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new TransactionLifecycleMonitor().getCurrentTransactionInfo());
  }

  /**
   * Test {@link TransactionLifecycleMonitor#isAtLeastOneTransactionManagerEnabled()}.
   *
   * <p>Method under test: {@link
   * TransactionLifecycleMonitor#isAtLeastOneTransactionManagerEnabled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TransactionLifecycleMonitor.isAtLeastOneTransactionManagerEnabled()"})
  public void testIsAtLeastOneTransactionManagerEnabled() {
    // Arrange
    when(lifecycleAwareJpaTransactionManager.isEnabled()).thenReturn(false);

    // Act
    boolean actualIsAtLeastOneTransactionManagerEnabledResult =
        transactionLifecycleMonitor.isAtLeastOneTransactionManagerEnabled();

    // Assert
    verify(lifecycleAwareJpaTransactionManager).isEnabled();
    assertFalse(actualIsAtLeastOneTransactionManagerEnabledResult);
  }

  /**
   * Test {@link TransactionLifecycleMonitor#isAtLeastOneTransactionManagerEnabled()}.
   *
   * <ul>
   *   <li>Given {@link TransactionLifecycleMonitor} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * TransactionLifecycleMonitor#isAtLeastOneTransactionManagerEnabled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TransactionLifecycleMonitor.isAtLeastOneTransactionManagerEnabled()"})
  public void testIsAtLeastOneTransactionManagerEnabled_givenTransactionLifecycleMonitor() {
    // Arrange, Act and Assert
    assertFalse(new TransactionLifecycleMonitor().isAtLeastOneTransactionManagerEnabled());
  }

  /**
   * Test {@link TransactionLifecycleMonitor#isAtLeastOneTransactionManagerEnabled()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TransactionLifecycleMonitor#isAtLeastOneTransactionManagerEnabled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TransactionLifecycleMonitor.isAtLeastOneTransactionManagerEnabled()"})
  public void testIsAtLeastOneTransactionManagerEnabled_thenReturnTrue() {
    // Arrange
    when(lifecycleAwareJpaTransactionManager.isEnabled()).thenReturn(true);

    // Act
    boolean actualIsAtLeastOneTransactionManagerEnabledResult =
        transactionLifecycleMonitor.isAtLeastOneTransactionManagerEnabled();

    // Assert
    verify(lifecycleAwareJpaTransactionManager).isEnabled();
    assertTrue(actualIsAtLeastOneTransactionManagerEnabledResult);
  }

  /**
   * Test {@link TransactionLifecycleMonitor#isAtLeastOneTransactionManagerEnabled()}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TransactionLifecycleMonitor#isAtLeastOneTransactionManagerEnabled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TransactionLifecycleMonitor.isAtLeastOneTransactionManagerEnabled()"})
  public void testIsAtLeastOneTransactionManagerEnabled_thenThrowUnsupportedOperationException() {
    // Arrange
    when(lifecycleAwareJpaTransactionManager.isEnabled())
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> transactionLifecycleMonitor.isAtLeastOneTransactionManagerEnabled());
    verify(lifecycleAwareJpaTransactionManager).isEnabled();
  }
}

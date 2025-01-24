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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import javax.persistence.EntityManager;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

@ContextConfiguration(classes = {TransactionInfo.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class TransactionInfoDiffblueTest {
  @Autowired
  private TransactionInfo transactionInfo;

  /**
   * Test {@link TransactionInfo#TransactionInfo()}.
   * <p>
   * Method under test: {@link TransactionInfo#TransactionInfo()}
   */
  @Test
  public void testNewTransactionInfo() throws IOException {
    // Arrange and Act
    TransactionInfo actualTransactionInfo = new TransactionInfo();

    // Assert
    CompressedItem compressedBeginStack = actualTransactionInfo.getCompressedBeginStack();
    assertEquals("java.lang.RuntimeException\n"
        + "\tat org.broadleafcommerce.common.persistence.transaction.TransactionInfo.initialize(TransactionInfo.java:278)"
        + "\n"
        + "\tat org.broadleafcommerce.common.persistence.transaction.TransactionInfo.<init>(TransactionInfo.java:44)"
        + "\n" + "\tat jdk.internal.reflect.GeneratedConstructorAccessor219.newInstance(Unknown Source)\n"
        + "\tat java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstruct"
        + "orAccessorImpl.java:45)\n"
        + "\tat java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:490)\n"
        + "\tat com.diffblue.tir.b.h.a(SourceFile:136)\n" + "\tat com.diffblue.tir.b.h.a(SourceFile:72)\n"
        + "\tat com.diffblue.tir.b.a.e.a(SourceFile:773)\n" + "\tat com.diffblue.tir.b.f.a(SourceFile:427)\n"
        + "\tat com.diffblue.tir.b.f.b(SourceFile:96)\n" + "\tat com.diffblue.tir.g.d.a(SourceFile:28)\n"
        + "\tat com.diffblue.tir.b.g.a(SourceFile:239)\n" + "\tat com.diffblue.tir.b.g.b(SourceFile:95)\n"
        + "\tat com.diffblue.cover.sandbox.execution.TimedCallableExecutor$CallableFuture.executeTask(SourceFile:28)"
        + "\n" + "\tat com.diffblue.cover.sandbox.execution.TimedExecutor$TaskQueueRunner.run(SourceFile:78)\n"
        + "\tat com.diffblue.cover.sandbox.execution.WorkerThread.run(SourceFile:224)\n",
        compressedBeginStack.decompress());
    assertEquals(
        "{\"ignoreSite\":\"false\",\"sandBox\":\"null\",\"nonPersistentSite\":\"null\",\"enforceEnterpriseCollectionBehaviorState"
            + "\":\"UNDEFINED\",\"admin\":\"false\",\"adminUserId\":\"null\",\"broadleafCurrency\":\"null\",\"currentCatalog\":\"null"
            + "\",\"currentProfile\":\"null\",\"deployBehavior\":\"UNDEFINED\",\"deployState\":\"UNDEFINED\",\"internalIgnoreFilters"
            + "\":\"false\",\"locale\":\"null\",\"validateProductionChangesState\":\"UNDEFINED\",\"timeZone\":\"null\"}",
        actualTransactionInfo.requestContext);
    assertNull(actualTransactionInfo.getAbbreviated());
    assertNull(actualTransactionInfo.getDecompressStatementForLog());
    assertNull(actualTransactionInfo.getAbbreviatedLength());
    assertNull(actualTransactionInfo.getMaxQueryListLength());
    assertNull(actualTransactionInfo.getStuckThreadStartTime());
    assertNull(actualTransactionInfo.getBeginStack());
    assertNull(actualTransactionInfo.getCurrentStackElement());
    assertNull(actualTransactionInfo.entityManager);
    assertNull(actualTransactionInfo.definition);
    assertNull(actualTransactionInfo.getQueries());
    assertNull(actualTransactionInfo.getCompressedQueries());
    byte[] compressed = compressedBeginStack.getCompressed();
    assertEquals((byte) -100, compressed[388]);
    assertEquals((byte) -101, compressed[391]);
    assertEquals((byte) -108, compressed[11]);
    assertEquals((byte) -108, compressed[382]);
    assertEquals((byte) -114, compressed[390]);
    assertEquals((byte) -117, compressed[1]);
    assertEquals((byte) -122, compressed[17]);
    assertEquals((byte) -32, compressed[23]);
    assertEquals((byte) -33, compressed[386]);
    assertEquals((byte) -39, compressed[389]);
    assertEquals((byte) -49, compressed[18]);
    assertEquals((byte) -63, compressed[12]);
    assertEquals((byte) -67, compressed[377]);
    assertEquals((byte) -6, compressed[19]);
    assertEquals((byte) -74, compressed[380]);
    assertEquals((byte) -79, compressed[373]);
    assertEquals((byte) -83, compressed[10]);
    assertEquals(0, actualTransactionInfo.totalQueries.intValue());
    assertEquals((byte) 0, compressed[3]);
    assertEquals((byte) 0, compressed[394]);
    assertEquals((byte) 0, compressed[395]);
    assertEquals((byte) 0, compressed[4]);
    assertEquals((byte) 0, compressed[5]);
    assertEquals((byte) 0, compressed[6]);
    assertEquals((byte) 0, compressed[7]);
    assertEquals((byte) 0, compressed[8]);
    assertEquals((byte) 0, compressed[9]);
    assertEquals((byte) 16, compressed[Short.SIZE]);
    assertEquals((byte) 1, compressed[387]);
    assertEquals((byte) 20, compressed[20]);
    assertEquals((byte) 25, compressed[376]);
    assertEquals((byte) 25, compressed[381]);
    assertEquals((byte) 2, compressed[14]);
    assertEquals((byte) 2, compressed[385]);
    assertEquals((byte) 30, compressed[21]);
    assertEquals((byte) 31, compressed[0]);
    assertEquals(396, compressed.length);
    assertEquals((byte) 4, compressed[393]);
    assertFalse(actualTransactionInfo.thread.isEnqueued());
    assertFalse(actualTransactionInfo.getFaultStateDetected());
    assertTrue(actualTransactionInfo.getAdditionalParams().isEmpty());
    assertTrue(compressedBeginStack.isDecompressInToString());
    assertTrue(actualTransactionInfo.isCompressed);
    assertEquals('!', compressed[375]);
    assertEquals('$', compressed[383]);
    assertEquals('1', compressed[15]);
    assertEquals('2', compressed[374]);
    assertEquals('<', compressed[22]);
    assertEquals('I', compressed[371]);
    assertEquals('N', compressed[13]);
    assertEquals('\b', compressed[2]);
    assertEquals('\n', compressed[378]);
    assertEquals('a', compressed[379]);
    assertEquals('e', compressed[24]);
    assertEquals('q', compressed[384]);
    assertEquals('t', compressed[392]);
    assertEquals('~', compressed[372]);
  }

  /**
   * Test
   * {@link TransactionInfo#TransactionInfo(EntityManager, TransactionDefinition, boolean, boolean, int, boolean, int)}.
   * <ul>
   *   <li>Then return MaxQueryListLength intValue is minus one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransactionInfo#TransactionInfo(EntityManager, TransactionDefinition, boolean, boolean, int, boolean, int)}
   */
  @Test
  public void testNewTransactionInfo_thenReturnMaxQueryListLengthIntValueIsMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1,
        (new TransactionInfo(null, new DefaultTransactionAttribute(), true, true, 3, true, -1)).getMaxQueryListLength()
            .intValue());
  }

  /**
   * Test
   * {@link TransactionInfo#TransactionInfo(EntityManager, TransactionDefinition, boolean, boolean, int, boolean, int)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return BeginStack is a string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransactionInfo#TransactionInfo(EntityManager, TransactionDefinition, boolean, boolean, int, boolean, int)}
   */
  @Test
  public void testNewTransactionInfo_whenFalse_thenReturnBeginStackIsAString() {
    // Arrange and Act
    TransactionInfo actualTransactionInfo = new TransactionInfo(null, new DefaultTransactionAttribute(), false, true, 3,
        true, 3);

    // Assert
    assertEquals("java.lang.RuntimeException\n"
        + "\tat org.broadleafcommerce.common.persistence.transaction.TransactionInfo.initialize(TransactionInfo.java:278)"
        + "\n"
        + "\tat org.broadleafcommerce.common.persistence.transaction.TransactionInfo.<init>(TransactionInfo.java:58)"
        + "\n" + "\tat jdk.internal.reflect.GeneratedConstructorAccessor238.newInstance(Unknown Source)\n"
        + "\tat java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstruct"
        + "orAccessorImpl.java:45)\n"
        + "\tat java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:490)\n"
        + "\tat com.diffblue.tir.b.h.a(SourceFile:136)\n" + "\tat com.diffblue.tir.b.h.a(SourceFile:72)\n"
        + "\tat com.diffblue.tir.b.a.e.a(SourceFile:773)\n" + "\tat com.diffblue.tir.b.f.a(SourceFile:427)\n"
        + "\tat com.diffblue.tir.b.f.b(SourceFile:96)\n" + "\tat com.diffblue.tir.g.d.a(SourceFile:28)\n"
        + "\tat com.diffblue.tir.b.g.a(SourceFile:239)\n" + "\tat com.diffblue.tir.b.g.b(SourceFile:95)\n"
        + "\tat com.diffblue.cover.sandbox.execution.TimedCallableExecutor$CallableFuture.executeTask(SourceFile:28)"
        + "\n" + "\tat com.diffblue.cover.sandbox.execution.TimedExecutor$TaskQueueRunner.run(SourceFile:78)\n"
        + "\tat com.diffblue.cover.sandbox.execution.WorkerThread.run(SourceFile:224)\n",
        actualTransactionInfo.getBeginStack());
    assertNull(actualTransactionInfo.getCompressedBeginStack());
    assertFalse(actualTransactionInfo.isCompressed);
  }

  /**
   * Test {@link TransactionInfo#getEntityManager()}.
   * <p>
   * Method under test: {@link TransactionInfo#getEntityManager()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetEntityManager() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.persistence.transaction.TransactionInfo.getEntityManager(TransactionInfo.java:85)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new TransactionInfo()).getEntityManager();
  }

  /**
   * Test {@link TransactionInfo#setEntityManager(EntityManager)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link TransactionInfo#TransactionInfo()}
   * {@link TransactionInfo#entityManager} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfo#setEntityManager(EntityManager)}
   */
  @Test
  public void testSetEntityManager_whenNull_thenTransactionInfoEntityManagerIsNull() {
    // Arrange
    TransactionInfo transactionInfo = new TransactionInfo();

    // Act
    transactionInfo.setEntityManager(null);

    // Assert
    WeakReference<EntityManager> weakReference = transactionInfo.entityManager;
    assertNull(weakReference.get());
    assertNull(transactionInfo.getEntityManager());
    assertFalse(weakReference.isEnqueued());
  }

  /**
   * Test {@link TransactionInfo#getDefinition()}.
   * <ul>
   *   <li>Then return
   * {@link DefaultTransactionAttribute#DefaultTransactionAttribute()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfo#getDefinition()}
   */
  @Test
  public void testGetDefinition_thenReturnDefaultTransactionAttribute() {
    // Arrange
    TransactionInfo transactionInfo = new TransactionInfo();
    DefaultTransactionAttribute definition = new DefaultTransactionAttribute();
    transactionInfo.setDefinition(definition);

    // Act and Assert
    assertSame(definition, transactionInfo.getDefinition());
  }

  /**
   * Test {@link TransactionInfo#setDefinition(TransactionDefinition)}.
   * <p>
   * Method under test:
   * {@link TransactionInfo#setDefinition(TransactionDefinition)}
   */
  @Test
  public void testSetDefinition() {
    // Arrange
    TransactionInfo transactionInfo = new TransactionInfo();
    DefaultTransactionAttribute definition = new DefaultTransactionAttribute();

    // Act
    transactionInfo.setDefinition(definition);

    // Assert
    WeakReference<TransactionDefinition> weakReference = transactionInfo.definition;
    assertFalse(weakReference.isEnqueued());
    assertSame(definition, weakReference.get());
    assertSame(definition, transactionInfo.getDefinition());
  }

  /**
   * Test {@link TransactionInfo#getThread()}.
   * <p>
   * Method under test: {@link TransactionInfo#getThread()}
   */
  @Test
  public void testGetThread() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new TransactionInfo()).getThread();
  }

  /**
   * Test {@link TransactionInfo#setThread(Thread)}.
   * <p>
   * Method under test: {@link TransactionInfo#setThread(Thread)}
   */
  @Test
  public void testSetThread() {
    // Arrange
    TransactionInfo transactionInfo = new TransactionInfo();
    Thread thread = new Thread();

    // Act
    transactionInfo.setThread(thread);

    // Assert
    assertSame(thread, transactionInfo.thread.get());
    assertSame(thread, transactionInfo.getThread());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransactionInfo#setAbbreviated(Boolean)}
   *   <li>{@link TransactionInfo#setAbbreviatedLength(Integer)}
   *   <li>{@link TransactionInfo#setAdditionalParams(Map)}
   *   <li>{@link TransactionInfo#setBeginStack(String)}
   *   <li>{@link TransactionInfo#setCompressedBeginStack(CompressedItem)}
   *   <li>{@link TransactionInfo#setCompressedQueries(LinkedBlockingQueue)}
   *   <li>{@link TransactionInfo#setCurrentStackElement(String)}
   *   <li>{@link TransactionInfo#setDecompressStatementForLog(Boolean)}
   *   <li>{@link TransactionInfo#setFaultStateDetected(Boolean)}
   *   <li>{@link TransactionInfo#setLastLogTime(Long)}
   *   <li>{@link TransactionInfo#setMaxQueryListLength(Integer)}
   *   <li>{@link TransactionInfo#setQueries(LinkedBlockingQueue)}
   *   <li>{@link TransactionInfo#setStartTime(Long)}
   *   <li>{@link TransactionInfo#setStuckThreadStartTime(Long)}
   *   <li>{@link TransactionInfo#setThreadId(String)}
   *   <li>{@link TransactionInfo#setThreadName(String)}
   *   <li>{@link TransactionInfo#getAbbreviated()}
   *   <li>{@link TransactionInfo#getAbbreviatedLength()}
   *   <li>{@link TransactionInfo#getAdditionalParams()}
   *   <li>{@link TransactionInfo#getBeginStack()}
   *   <li>{@link TransactionInfo#getCompressedBeginStack()}
   *   <li>{@link TransactionInfo#getCompressedQueries()}
   *   <li>{@link TransactionInfo#getCurrentStackElement()}
   *   <li>{@link TransactionInfo#getDecompressStatementForLog()}
   *   <li>{@link TransactionInfo#getFaultStateDetected()}
   *   <li>{@link TransactionInfo#getLastLogTime()}
   *   <li>{@link TransactionInfo#getMaxQueryListLength()}
   *   <li>{@link TransactionInfo#getQueries()}
   *   <li>{@link TransactionInfo#getStartTime()}
   *   <li>{@link TransactionInfo#getStuckThreadStartTime()}
   *   <li>{@link TransactionInfo#getThreadId()}
   *   <li>{@link TransactionInfo#getThreadName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws IOException {
    // Arrange
    TransactionInfo transactionInfo = new TransactionInfo();

    // Act
    transactionInfo.setAbbreviated(true);
    transactionInfo.setAbbreviatedLength(3);
    HashMap<String, String> additionalParams = new HashMap<>();
    transactionInfo.setAdditionalParams(additionalParams);
    transactionInfo.setBeginStack("Begin Stack");
    CompressedItem compressedBeginStack = new CompressedItem("Start", true);

    transactionInfo.setCompressedBeginStack(compressedBeginStack);
    LinkedBlockingQueue<CompressedItem> compressedQueries = new LinkedBlockingQueue<>();
    transactionInfo.setCompressedQueries(compressedQueries);
    transactionInfo.setCurrentStackElement("Current Stack Element");
    transactionInfo.setDecompressStatementForLog(true);
    transactionInfo.setFaultStateDetected(true);
    transactionInfo.setLastLogTime(1L);
    transactionInfo.setMaxQueryListLength(3);
    LinkedBlockingQueue<String> queries = new LinkedBlockingQueue<>();
    transactionInfo.setQueries(queries);
    transactionInfo.setStartTime(1L);
    transactionInfo.setStuckThreadStartTime(1L);
    transactionInfo.setThreadId("42");
    transactionInfo.setThreadName("Thread Name");
    Boolean actualAbbreviated = transactionInfo.getAbbreviated();
    Integer actualAbbreviatedLength = transactionInfo.getAbbreviatedLength();
    Map<String, String> actualAdditionalParams = transactionInfo.getAdditionalParams();
    String actualBeginStack = transactionInfo.getBeginStack();
    CompressedItem actualCompressedBeginStack = transactionInfo.getCompressedBeginStack();
    LinkedBlockingQueue<CompressedItem> actualCompressedQueries = transactionInfo.getCompressedQueries();
    String actualCurrentStackElement = transactionInfo.getCurrentStackElement();
    Boolean actualDecompressStatementForLog = transactionInfo.getDecompressStatementForLog();
    Boolean actualFaultStateDetected = transactionInfo.getFaultStateDetected();
    Long actualLastLogTime = transactionInfo.getLastLogTime();
    Integer actualMaxQueryListLength = transactionInfo.getMaxQueryListLength();
    LinkedBlockingQueue<String> actualQueries = transactionInfo.getQueries();
    Long actualStartTime = transactionInfo.getStartTime();
    Long actualStuckThreadStartTime = transactionInfo.getStuckThreadStartTime();
    String actualThreadId = transactionInfo.getThreadId();

    // Assert that nothing has changed
    assertEquals("42", actualThreadId);
    assertEquals("Begin Stack", actualBeginStack);
    assertEquals("Current Stack Element", actualCurrentStackElement);
    assertEquals("Thread Name", transactionInfo.getThreadName());
    assertEquals(1L, actualLastLogTime.longValue());
    assertEquals(1L, actualStartTime.longValue());
    assertEquals(1L, actualStuckThreadStartTime.longValue());
    assertEquals(3, actualAbbreviatedLength.intValue());
    assertEquals(3, actualMaxQueryListLength.intValue());
    assertTrue(actualAdditionalParams.isEmpty());
    assertTrue(actualAbbreviated);
    assertTrue(actualDecompressStatementForLog);
    assertTrue(actualFaultStateDetected);
    assertSame(additionalParams, actualAdditionalParams);
    assertSame(compressedQueries, actualCompressedQueries);
    assertSame(queries, actualQueries);
    assertSame(compressedBeginStack, actualCompressedBeginStack);
  }

  /**
   * Test {@link TransactionInfo#clear()}.
   * <p>
   * Method under test: {@link TransactionInfo#clear()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testClear() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.persistence.transaction.TransactionInfo.clear(TransactionInfo.java:237)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new TransactionInfo()).clear();
  }

  /**
   * Test {@link TransactionInfo#logStatement(String)}.
   * <p>
   * Method under test: {@link TransactionInfo#logStatement(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testLogStatement() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.persistence.transaction.TransactionInfo.logStatement(TransactionInfo.java:244)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    transactionInfo.logStatement("MD");
  }

  /**
   * Test {@link TransactionInfo#logStatement(String)}.
   * <ul>
   *   <li>Then {@link TransactionInfo#TransactionInfo()}
   * {@link TransactionInfo#totalQueries} intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfo#logStatement(String)}
   */
  @Test
  public void testLogStatement_thenTransactionInfoTotalQueriesIntValueIsOne() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LinkedBlockingQueue<CompressedItem> compressedQueries = new LinkedBlockingQueue<>();
    compressedQueries.add(new CompressedItem("\n", true));

    TransactionInfo transactionInfo = new TransactionInfo();
    transactionInfo.setDecompressStatementForLog(true);
    transactionInfo.setCompressedQueries(compressedQueries);
    transactionInfo.setAbbreviated(false);

    // Act
    transactionInfo.logStatement("MD");

    // Assert
    assertEquals(1, transactionInfo.totalQueries.intValue());
    assertSame(compressedQueries, transactionInfo.getCompressedQueries());
  }

  /**
   * Test {@link TransactionInfo#initialize()}.
   * <p>
   * Method under test: {@link TransactionInfo#initialize()}
   */
  @Test
  public void testInitialize() throws IOException {
    // Arrange
    TransactionInfo transactionInfo = new TransactionInfo();

    // Act
    transactionInfo.initialize();

    // Assert
    CompressedItem compressedBeginStack = transactionInfo.getCompressedBeginStack();
    assertEquals("java.lang.RuntimeException\n"
        + "\tat org.broadleafcommerce.common.persistence.transaction.TransactionInfo.initialize(TransactionInfo.java:278)"
        + "\n" + "\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n"
        + "\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)" + "\n"
        + "\tat java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)"
        + "\n" + "\tat java.base/java.lang.reflect.Method.invoke(Method.java:566)\n"
        + "\tat com.diffblue.tir.b.h.a(SourceFile:134)\n" + "\tat com.diffblue.tir.b.h.a(SourceFile:72)\n"
        + "\tat com.diffblue.tir.b.a.e.a(SourceFile:773)\n" + "\tat com.diffblue.tir.b.f.a(SourceFile:460)\n"
        + "\tat com.diffblue.tir.b.f.b(SourceFile:96)\n" + "\tat com.diffblue.tir.g.e.a(SourceFile:51)\n"
        + "\tat com.diffblue.tir.b.g.a(SourceFile:239)\n" + "\tat com.diffblue.tir.b.g.b(SourceFile:95)\n"
        + "\tat com.diffblue.cover.sandbox.execution.TimedCallableExecutor$CallableFuture.executeTask(SourceFile:28)"
        + "\n" + "\tat com.diffblue.cover.sandbox.execution.TimedExecutor$TaskQueueRunner.run(SourceFile:78)\n"
        + "\tat com.diffblue.cover.sandbox.execution.WorkerThread.run(SourceFile:224)\n",
        compressedBeginStack.decompress());
    byte[] compressed = compressedBeginStack.getCompressed();
    assertEquals((byte) -100, compressed[371]);
    assertEquals((byte) -109, compressed[11]);
    assertEquals((byte) -121, compressed[370]);
    assertEquals((byte) -122, compressed[17]);
    assertEquals((byte) -14, compressed[373]);
    assertEquals((byte) -18, compressed[366]);
    assertEquals((byte) -28, compressed[364]);
    assertEquals((byte) -2, compressed[354]);
    assertEquals((byte) -5, compressed[365]);
    assertEquals((byte) -62, compressed[23]);
    assertEquals((byte) -62, compressed[361]);
    assertEquals((byte) -65, compressed[367]);
    assertEquals((byte) -67, compressed[358]);
    assertEquals((byte) -7, compressed[368]);
    assertEquals((byte) -88, compressed[362]);
    assertEquals((byte) -8, compressed[19]);
    assertEquals((byte) 0, compressed[376]);
    assertEquals((byte) 0, compressed[377]);
    assertEquals((byte) 16, compressed[Short.SIZE]);
    assertEquals((byte) 21, compressed[20]);
    assertEquals((byte) 24, compressed[22]);
    assertEquals((byte) 29, compressed[21]);
    assertEquals((byte) 29, compressed[363]);
    assertEquals((byte) 2, compressed[369]);
    assertEquals(378, compressed.length);
    assertEquals((byte) 4, compressed[375]);
    assertEquals('%', compressed[357]);
    assertEquals(':', compressed[356]);
    assertEquals('=', compressed[12]);
    assertEquals('I', compressed[353]);
    assertEquals('P', compressed[355]);
    assertEquals('P', compressed[374]);
    assertEquals('Z', compressed[359]);
    assertEquals('d', compressed[372]);
    assertEquals('g', compressed[18]);
    assertEquals('k', compressed[360]);
    assertEquals('r', compressed[24]);
  }

  /**
   * Test {@link TransactionInfo#toString()}.
   * <p>
   * Method under test: {@link TransactionInfo#toString()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testToString() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.persistence.transaction.TransactionInfo.getEntityManager(TransactionInfo.java:85)
    //       at org.broadleafcommerce.common.persistence.transaction.TransactionInfo.toString(TransactionInfo.java:311)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new TransactionInfo()).toString();
  }
}

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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import javax.persistence.EntityManager;
import org.junit.Test;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

public class TransactionInfoDiffblueTest {
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
}

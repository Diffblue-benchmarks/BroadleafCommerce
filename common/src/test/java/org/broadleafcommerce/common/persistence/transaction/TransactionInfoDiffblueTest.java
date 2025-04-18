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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import javax.persistence.EntityManager;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class TransactionInfoDiffblueTest {
  /**
   * Test {@link TransactionInfo#TransactionInfo()}.
   * <p>
   * Method under test: {@link TransactionInfo#TransactionInfo()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfo.<init>()"})
  public void testNewTransactionInfo() {
    // Arrange and Act
    TransactionInfo actualTransactionInfo = new TransactionInfo();

    // Assert
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
    assertEquals(0, actualTransactionInfo.totalQueries.intValue());
    assertFalse(actualTransactionInfo.getFaultStateDetected());
    assertTrue(actualTransactionInfo.getAdditionalParams().isEmpty());
    assertTrue(actualTransactionInfo.isCompressed);
  }

  /**
   * Test {@link TransactionInfo#getEntityManager()}.
   * <ul>
   *   <li>Given {@link TransactionInfo#TransactionInfo()} EntityManager is {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfo#getEntityManager()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityManager TransactionInfo.getEntityManager()"})
  public void testGetEntityManager_givenTransactionInfoEntityManagerIsNull_thenReturnNull() {
    // Arrange
    TransactionInfo transactionInfo = new TransactionInfo();
    transactionInfo.setEntityManager(null);

    // Act and Assert
    assertNull(transactionInfo.getEntityManager());
  }

  /**
   * Test {@link TransactionInfo#setEntityManager(EntityManager)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link TransactionInfo#TransactionInfo()} {@link TransactionInfo#entityManager} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfo#setEntityManager(EntityManager)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfo.setEntityManager(EntityManager)"})
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
   *   <li>Then return {@link DefaultTransactionAttribute#DefaultTransactionAttribute()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfo#getDefinition()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransactionDefinition TransactionInfo.getDefinition()"})
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
   * Method under test: {@link TransactionInfo#setDefinition(TransactionDefinition)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfo.setDefinition(TransactionDefinition)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfo.setThread(Thread)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean TransactionInfo.getAbbreviated()", "Integer TransactionInfo.getAbbreviatedLength()",
      "Map TransactionInfo.getAdditionalParams()", "String TransactionInfo.getBeginStack()",
      "CompressedItem TransactionInfo.getCompressedBeginStack()",
      "LinkedBlockingQueue TransactionInfo.getCompressedQueries()", "String TransactionInfo.getCurrentStackElement()",
      "Boolean TransactionInfo.getDecompressStatementForLog()", "Boolean TransactionInfo.getFaultStateDetected()",
      "Long TransactionInfo.getLastLogTime()", "Integer TransactionInfo.getMaxQueryListLength()",
      "LinkedBlockingQueue TransactionInfo.getQueries()", "Long TransactionInfo.getStartTime()",
      "Long TransactionInfo.getStuckThreadStartTime()", "String TransactionInfo.getThreadId()",
      "String TransactionInfo.getThreadName()", "void TransactionInfo.setAbbreviated(Boolean)",
      "void TransactionInfo.setAbbreviatedLength(Integer)", "void TransactionInfo.setAdditionalParams(Map)",
      "void TransactionInfo.setBeginStack(String)", "void TransactionInfo.setCompressedBeginStack(CompressedItem)",
      "void TransactionInfo.setCompressedQueries(LinkedBlockingQueue)",
      "void TransactionInfo.setCurrentStackElement(String)",
      "void TransactionInfo.setDecompressStatementForLog(Boolean)",
      "void TransactionInfo.setFaultStateDetected(Boolean)", "void TransactionInfo.setLastLogTime(Long)",
      "void TransactionInfo.setMaxQueryListLength(Integer)", "void TransactionInfo.setQueries(LinkedBlockingQueue)",
      "void TransactionInfo.setStartTime(Long)", "void TransactionInfo.setStuckThreadStartTime(Long)",
      "void TransactionInfo.setThreadId(String)", "void TransactionInfo.setThreadName(String)"})
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

    // Assert
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
   * <ul>
   *   <li>Then {@link TransactionInfo#TransactionInfo()} {@link TransactionInfo#thread} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfo#clear()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfo.clear()"})
  public void testClear_thenTransactionInfoThreadIsNull() {
    // Arrange
    TransactionInfo transactionInfo = new TransactionInfo();
    transactionInfo.setDefinition(new DefaultTransactionAttribute());
    transactionInfo.setEntityManager(null);

    // Act
    transactionInfo.clear();

    // Assert
    assertNull(transactionInfo.thread.get());
    assertNull(transactionInfo.getThread());
    assertNull(transactionInfo.definition.get());
    assertNull(transactionInfo.getDefinition());
  }

  /**
   * Test {@link TransactionInfo#logStatement(String)}.
   * <ul>
   *   <li>Then {@link TransactionInfo#TransactionInfo()} {@link TransactionInfo#totalQueries} intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfo#logStatement(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfo.logStatement(String)"})
  public void testLogStatement_thenTransactionInfoTotalQueriesIntValueIsOne() throws IOException {
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
   * Test {@link TransactionInfo#toString()}.
   * <ul>
   *   <li>Given {@link CompressedItem} {@link CompressedItem#decompress()} return {@code Decompress}.</li>
   *   <li>Then calls {@link CompressedItem#decompress()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfo#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TransactionInfo.toString()"})
  public void testToString_givenCompressedItemDecompressReturnDecompress_thenCallsDecompress() throws IOException {
    // Arrange
    CompressedItem compressedItem = mock(CompressedItem.class);
    when(compressedItem.decompress()).thenReturn("Decompress");

    LinkedBlockingQueue<CompressedItem> compressedQueries = new LinkedBlockingQueue<>();
    compressedQueries.add(compressedItem);

    TransactionInfo transactionInfo = new TransactionInfo();
    transactionInfo.setCompressedQueries(compressedQueries);
    transactionInfo.setDecompressStatementForLog(false);
    transactionInfo.setEntityManager(null);

    // Act
    transactionInfo.toString();

    // Assert
    verify(compressedItem).decompress();
  }

  /**
   * Test {@link TransactionInfo#toString()}.
   * <ul>
   *   <li>Given {@link CompressedItem} {@link CompressedItem#decompress()} throw {@link IOException#IOException(String)} with {@code TransactionInfo{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfo#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TransactionInfo.toString()"})
  public void testToString_givenCompressedItemDecompressThrowIOExceptionWithTransactionInfo() throws IOException {
    // Arrange
    CompressedItem compressedItem = mock(CompressedItem.class);
    when(compressedItem.decompress()).thenThrow(new IOException("TransactionInfo{"));

    LinkedBlockingQueue<CompressedItem> compressedQueries = new LinkedBlockingQueue<>();
    compressedQueries.add(compressedItem);

    TransactionInfo transactionInfo = new TransactionInfo();
    transactionInfo.setCompressedQueries(compressedQueries);
    transactionInfo.setDecompressStatementForLog(false);
    transactionInfo.setEntityManager(null);

    // Act
    transactionInfo.toString();

    // Assert
    verify(compressedItem).decompress();
  }

  /**
   * Test {@link TransactionInfo#toString()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfo#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TransactionInfo.toString()"})
  public void testToString_thenThrowRuntimeException() throws IOException {
    // Arrange
    CompressedItem compressedItem = mock(CompressedItem.class);
    when(compressedItem.decompress()).thenThrow(new RuntimeException("TransactionInfo{"));

    LinkedBlockingQueue<CompressedItem> compressedQueries = new LinkedBlockingQueue<>();
    compressedQueries.add(compressedItem);

    TransactionInfo transactionInfo = new TransactionInfo();
    transactionInfo.setCompressedQueries(compressedQueries);
    transactionInfo.setDecompressStatementForLog(false);
    transactionInfo.setEntityManager(null);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> transactionInfo.toString());
    verify(compressedItem).decompress();
  }
}

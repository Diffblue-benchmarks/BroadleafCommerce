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
package org.broadleafcommerce.common.persistence;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager;
import org.broadleafcommerce.common.service.PersistenceService;
import org.broadleafcommerce.common.util.StreamCapableTransactionalOperation;
import org.broadleafcommerce.common.util.StreamingTransactionCapableUtil;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.transaction.PlatformTransactionManager;

@RunWith(MockitoJUnitRunner.class)
public class SequenceGeneratorCorruptionDetectionDiffblueTest {
  @Mock
  private List<Map<String, Map<String, Object>>> list;

  @InjectMocks
  private SequenceGeneratorCorruptionDetection sequenceGeneratorCorruptionDetection;

  @Mock
  private PersistenceService persistenceService;

  @Mock
  private StreamingTransactionCapableUtil streamingTransactionCapableUtil;

  /**
   * Test {@link SequenceGeneratorCorruptionDetection#onApplicationEvent(ContextRefreshedEvent)} with {@code ContextRefreshedEvent}.
   * <p>
   * Method under test: {@link SequenceGeneratorCorruptionDetection#onApplicationEvent(ContextRefreshedEvent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SequenceGeneratorCorruptionDetection.onApplicationEvent(ContextRefreshedEvent)"})
  public void testOnApplicationEventWithContextRefreshedEvent() throws Throwable {
    // Arrange
    when(persistenceService.getTransactionManager(Mockito.<Map<String, Object>>any()))
        .thenReturn(new LifecycleAwareJpaTransactionManager());

    HashMap<String, Map<String, Object>> stringMapMap = new HashMap<>();
    stringMapMap.put("foo", new HashMap<>());

    ArrayList<Map<String, Map<String, Object>>> mapList = new ArrayList<>();
    mapList.add(stringMapMap);
    when(list.iterator()).thenReturn(mapList.iterator());
    doNothing().when(streamingTransactionCapableUtil)
        .runTransactionalOperation(Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any(), Mockito.<PlatformTransactionManager>any());

    // Act
    sequenceGeneratorCorruptionDetection
        .onApplicationEvent(new ContextRefreshedEvent(new AnnotationConfigReactiveWebApplicationContext()));

    // Assert
    verify(list).iterator();
    verify(persistenceService).getTransactionManager(isA(Map.class));
    verify(streamingTransactionCapableUtil).runTransactionalOperation(isA(StreamCapableTransactionalOperation.class),
        isA(Class.class), isA(PlatformTransactionManager.class));
  }

  /**
   * Test {@link SequenceGeneratorCorruptionDetection#onApplicationEvent(ContextRefreshedEvent)} with {@code ContextRefreshedEvent}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SequenceGeneratorCorruptionDetection#onApplicationEvent(ContextRefreshedEvent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SequenceGeneratorCorruptionDetection.onApplicationEvent(ContextRefreshedEvent)"})
  public void testOnApplicationEventWithContextRefreshedEvent_givenArrayListAddHashMap() {
    // Arrange
    ArrayList<Map<String, Map<String, Object>>> mapList = new ArrayList<>();
    mapList.add(new HashMap<>());
    when(list.iterator()).thenReturn(mapList.iterator());

    // Act
    sequenceGeneratorCorruptionDetection
        .onApplicationEvent(new ContextRefreshedEvent(new AnnotationConfigReactiveWebApplicationContext()));

    // Assert
    verify(list).iterator();
  }

  /**
   * Test {@link SequenceGeneratorCorruptionDetection#onApplicationEvent(ContextRefreshedEvent)} with {@code ContextRefreshedEvent}.
   * <ul>
   *   <li>Then calls {@link List#iterator()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SequenceGeneratorCorruptionDetection#onApplicationEvent(ContextRefreshedEvent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SequenceGeneratorCorruptionDetection.onApplicationEvent(ContextRefreshedEvent)"})
  public void testOnApplicationEventWithContextRefreshedEvent_thenCallsIterator() {
    // Arrange
    ArrayList<Map<String, Map<String, Object>>> mapList = new ArrayList<>();
    when(list.iterator()).thenReturn(mapList.iterator());

    // Act
    sequenceGeneratorCorruptionDetection
        .onApplicationEvent(new ContextRefreshedEvent(new AnnotationConfigReactiveWebApplicationContext()));

    // Assert
    verify(list).iterator();
  }

  /**
   * Test {@link SequenceGeneratorCorruptionDetection#onApplicationEvent(ContextRefreshedEvent)} with {@code ContextRefreshedEvent}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SequenceGeneratorCorruptionDetection#onApplicationEvent(ContextRefreshedEvent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SequenceGeneratorCorruptionDetection.onApplicationEvent(ContextRefreshedEvent)"})
  public void testOnApplicationEventWithContextRefreshedEvent_thenThrowRuntimeException() throws Throwable {
    // Arrange
    when(persistenceService.getTransactionManager(Mockito.<Map<String, Object>>any()))
        .thenReturn(new LifecycleAwareJpaTransactionManager());

    HashMap<String, Map<String, Object>> stringMapMap = new HashMap<>();
    stringMapMap.put("foo", new HashMap<>());

    ArrayList<Map<String, Map<String, Object>>> mapList = new ArrayList<>();
    mapList.add(stringMapMap);
    when(list.iterator()).thenReturn(mapList.iterator());
    doThrow(new RuntimeException("foo")).when(streamingTransactionCapableUtil)
        .runTransactionalOperation(Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any(), Mockito.<PlatformTransactionManager>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> sequenceGeneratorCorruptionDetection
        .onApplicationEvent(new ContextRefreshedEvent(new AnnotationConfigReactiveWebApplicationContext())));
    verify(list).iterator();
    verify(persistenceService).getTransactionManager(isA(Map.class));
    verify(streamingTransactionCapableUtil).runTransactionalOperation(isA(StreamCapableTransactionalOperation.class),
        isA(Class.class), isA(PlatformTransactionManager.class));
  }
}

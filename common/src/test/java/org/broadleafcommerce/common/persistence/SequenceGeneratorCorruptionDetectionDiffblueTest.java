package org.broadleafcommerce.common.persistence;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.transaction.PlatformTransactionManager;

@RunWith(MockitoJUnitRunner.class)
public class SequenceGeneratorCorruptionDetectionDiffblueTest {
  @Mock private List<Map<String, Map<String, Object>>> list;

  @Mock private PersistenceService persistenceService;

  @InjectMocks private SequenceGeneratorCorruptionDetection sequenceGeneratorCorruptionDetection;

  @Mock private StreamingTransactionCapableUtil streamingTransactionCapableUtil;

  /**
   * Test {@link SequenceGeneratorCorruptionDetection#onApplicationEvent(ContextRefreshedEvent)}
   * with {@code ContextRefreshedEvent}.
   *
   * <p>Method under test: {@link
   * SequenceGeneratorCorruptionDetection#onApplicationEvent(ContextRefreshedEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SequenceGeneratorCorruptionDetection.onApplicationEvent(ContextRefreshedEvent)"
  })
  public void testOnApplicationEventWithContextRefreshedEvent() throws Throwable {
    // Arrange
    when(persistenceService.getTransactionManager(Mockito.<Map<String, Object>>any()))
        .thenReturn(new LifecycleAwareJpaTransactionManager());

    HashMap<String, Map<String, Object>> stringMapMap = new HashMap<>();
    stringMapMap.put("foo", new HashMap<>());

    ArrayList<Map<String, Map<String, Object>>> mapList = new ArrayList<>();
    mapList.add(stringMapMap);
    when(list.iterator()).thenReturn(mapList.iterator());
    doNothing()
        .when(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any(),
            Mockito.<PlatformTransactionManager>any());

    // Act
    sequenceGeneratorCorruptionDetection.onApplicationEvent(
        new ContextRefreshedEvent(mock(ApplicationContext.class)));

    // Assert
    verify(list).iterator();
    verify(persistenceService).getTransactionManager(isA(Map.class));
    verify(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            isA(StreamCapableTransactionalOperation.class),
            isA(Class.class),
            isA(PlatformTransactionManager.class));
  }

  /**
   * Test {@link SequenceGeneratorCorruptionDetection#onApplicationEvent(ContextRefreshedEvent)}
   * with {@code ContextRefreshedEvent}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SequenceGeneratorCorruptionDetection#onApplicationEvent(ContextRefreshedEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SequenceGeneratorCorruptionDetection.onApplicationEvent(ContextRefreshedEvent)"
  })
  public void testOnApplicationEventWithContextRefreshedEvent_givenArrayListAddHashMap() {
    // Arrange
    ArrayList<Map<String, Map<String, Object>>> mapList = new ArrayList<>();
    mapList.add(new HashMap<>());
    when(list.iterator()).thenReturn(mapList.iterator());

    // Act
    sequenceGeneratorCorruptionDetection.onApplicationEvent(
        new ContextRefreshedEvent(mock(ApplicationContext.class)));

    // Assert
    verify(list).iterator();
  }

  /**
   * Test {@link SequenceGeneratorCorruptionDetection#onApplicationEvent(ContextRefreshedEvent)}
   * with {@code ContextRefreshedEvent}.
   *
   * <ul>
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SequenceGeneratorCorruptionDetection#onApplicationEvent(ContextRefreshedEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SequenceGeneratorCorruptionDetection.onApplicationEvent(ContextRefreshedEvent)"
  })
  public void testOnApplicationEventWithContextRefreshedEvent_thenCallsIterator() {
    // Arrange
    ArrayList<Map<String, Map<String, Object>>> mapList = new ArrayList<>();
    when(list.iterator()).thenReturn(mapList.iterator());

    // Act
    sequenceGeneratorCorruptionDetection.onApplicationEvent(
        new ContextRefreshedEvent(mock(ApplicationContext.class)));

    // Assert
    verify(list).iterator();
  }

  /**
   * Test {@link SequenceGeneratorCorruptionDetection#onApplicationEvent(ContextRefreshedEvent)}
   * with {@code ContextRefreshedEvent}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SequenceGeneratorCorruptionDetection#onApplicationEvent(ContextRefreshedEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SequenceGeneratorCorruptionDetection.onApplicationEvent(ContextRefreshedEvent)"
  })
  public void testOnApplicationEventWithContextRefreshedEvent_thenThrowRuntimeException() {
    // Arrange
    when(persistenceService.getTransactionManager(Mockito.<Map<String, Object>>any()))
        .thenThrow(new RuntimeException());

    HashMap<String, Map<String, Object>> stringMapMap = new HashMap<>();
    stringMapMap.put("foo", new HashMap<>());

    ArrayList<Map<String, Map<String, Object>>> mapList = new ArrayList<>();
    mapList.add(stringMapMap);
    when(list.iterator()).thenReturn(mapList.iterator());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            sequenceGeneratorCorruptionDetection.onApplicationEvent(
                new ContextRefreshedEvent(mock(ApplicationContext.class))));
    verify(list).iterator();
    verify(persistenceService).getTransactionManager(isA(Map.class));
  }
}

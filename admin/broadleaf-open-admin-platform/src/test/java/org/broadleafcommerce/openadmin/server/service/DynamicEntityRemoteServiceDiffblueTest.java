package org.broadleafcommerce.openadmin.server.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.persistence.TargetModeType;
import org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager;
import org.broadleafcommerce.common.security.service.CleanStringException;
import org.broadleafcommerce.common.security.service.ExploitProtectionService;
import org.broadleafcommerce.common.service.PersistenceService;
import org.broadleafcommerce.common.util.StreamCapableTransactionalOperation;
import org.broadleafcommerce.common.util.StreamingTransactionCapableUtil;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.Persistable;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceResponse;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceThreadManager;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.owasp.validator.html.CleanResults;
import org.springframework.transaction.PlatformTransactionManager;

@RunWith(MockitoJUnitRunner.class)
public class DynamicEntityRemoteServiceDiffblueTest {
  @InjectMocks private DynamicEntityRemoteService dynamicEntityRemoteService;

  @Mock private ExploitProtectionService exploitProtectionService;

  @Mock private PersistenceService persistenceService;

  @Mock private PersistenceThreadManager persistenceThreadManager;

  @Mock private StreamingTransactionCapableUtil streamingTransactionCapableUtil;

  /**
   * Test {@link DynamicEntityRemoteService#recreateSpecificServiceException(ServiceException,
   * String, Throwable)}.
   *
   * <ul>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicEntityRemoteService#recreateSpecificServiceException(ServiceException, String,
   * Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ServiceException DynamicEntityRemoteService.recreateSpecificServiceException(ServiceException, String, Throwable)"
  })
  public void testRecreateSpecificServiceException_thenReturnCauseIsThrowable() {
    // Arrange
    DynamicEntityRemoteService dynamicEntityRemoteService = new DynamicEntityRemoteService();
    ServiceException e = new ServiceException("An error occurred");
    Throwable cause = new Throwable();

    // Act and Assert
    assertSame(
        cause,
        dynamicEntityRemoteService
            .recreateSpecificServiceException(e, "An error occurred", cause)
            .getCause());
  }

  /**
   * Test {@link DynamicEntityRemoteService#recreateSpecificServiceException(ServiceException,
   * String, Throwable)}.
   *
   * <ul>
   *   <li>Then return LocalizedMessage is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicEntityRemoteService#recreateSpecificServiceException(ServiceException, String,
   * Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ServiceException DynamicEntityRemoteService.recreateSpecificServiceException(ServiceException, String, Throwable)"
  })
  public void testRecreateSpecificServiceException_thenReturnLocalizedMessageIsAnErrorOccurred() {
    // Arrange
    DynamicEntityRemoteService dynamicEntityRemoteService = new DynamicEntityRemoteService();

    // Act
    ServiceException actualRecreateSpecificServiceExceptionResult =
        dynamicEntityRemoteService.recreateSpecificServiceException(
            new ServiceException("An error occurred"), "An error occurred", null);

    // Assert
    assertEquals(
        "An error occurred", actualRecreateSpecificServiceExceptionResult.getLocalizedMessage());
    assertEquals("An error occurred", actualRecreateSpecificServiceExceptionResult.getMessage());
    assertNull(actualRecreateSpecificServiceExceptionResult.getCause());
    assertEquals(0, actualRecreateSpecificServiceExceptionResult.getSuppressed().length);
  }

  /**
   * Test {@link DynamicEntityRemoteService#recreateSpecificServiceException(ServiceException,
   * String, Throwable)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicEntityRemoteService#recreateSpecificServiceException(ServiceException, String,
   * Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ServiceException DynamicEntityRemoteService.recreateSpecificServiceException(ServiceException, String, Throwable)"
  })
  public void testRecreateSpecificServiceException_thenThrowRuntimeException() {
    // Arrange
    DynamicEntityRemoteService dynamicEntityRemoteService = new DynamicEntityRemoteService();
    ValidationException e = new ValidationException(new Entity());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            dynamicEntityRemoteService.recreateSpecificServiceException(
                e, "An error occurred", new Throwable()));
  }

  /**
   * Test {@link DynamicEntityRemoteService#recreateSpecificServiceException(ServiceException,
   * String, Throwable)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicEntityRemoteService#recreateSpecificServiceException(ServiceException, String,
   * Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ServiceException DynamicEntityRemoteService.recreateSpecificServiceException(ServiceException, String, Throwable)"
  })
  public void testRecreateSpecificServiceException_thenThrowRuntimeException2() {
    // Arrange
    DynamicEntityRemoteService dynamicEntityRemoteService = new DynamicEntityRemoteService();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            dynamicEntityRemoteService.recreateSpecificServiceException(
                new ValidationException(new Entity()), "An error occurred", null));
  }

  /**
   * Test {@link DynamicEntityRemoteService#nonTransactionalInspect(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then return {@link PersistenceResponse} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicEntityRemoteService#nonTransactionalInspect(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse DynamicEntityRemoteService.nonTransactionalInspect(PersistencePackage)"
  })
  public void testNonTransactionalInspect_thenReturnPersistenceResponse() throws Throwable {
    // Arrange
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(persistenceThreadManager.operation(
            Mockito.<TargetModeType>any(),
            Mockito.<PersistencePackage>any(),
            Mockito.<Persistable<PersistenceResponse, ServiceException>>any()))
        .thenReturn(persistenceResponse);

    // Act
    PersistenceResponse actualNonTransactionalInspectResult =
        dynamicEntityRemoteService.nonTransactionalInspect(new PersistencePackage());

    // Assert
    verify(persistenceThreadManager)
        .operation(
            isA(TargetModeType.class), isA(PersistencePackage.class), isA(Persistable.class));
    assertSame(persistenceResponse, actualNonTransactionalInspectResult);
  }

  /**
   * Test {@link DynamicEntityRemoteService#nonTransactionalInspect(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicEntityRemoteService#nonTransactionalInspect(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse DynamicEntityRemoteService.nonTransactionalInspect(PersistencePackage)"
  })
  public void testNonTransactionalInspect_thenThrowServiceException() throws Throwable {
    // Arrange
    when(persistenceThreadManager.operation(
            Mockito.<TargetModeType>any(),
            Mockito.<PersistencePackage>any(),
            Mockito.<Persistable<PersistenceResponse, ServiceException>>any()))
        .thenThrow(new ServiceException("An error occurred"));

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () -> dynamicEntityRemoteService.nonTransactionalInspect(new PersistencePackage()));
    verify(persistenceThreadManager)
        .operation(
            isA(TargetModeType.class), isA(PersistencePackage.class), isA(Persistable.class));
  }

  /**
   * Test {@link DynamicEntityRemoteService#nonTransactionalFetch(PersistencePackage,
   * CriteriaTransferObject)}.
   *
   * <ul>
   *   <li>Then return {@link PersistenceResponse} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicEntityRemoteService#nonTransactionalFetch(PersistencePackage, CriteriaTransferObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse DynamicEntityRemoteService.nonTransactionalFetch(PersistencePackage, CriteriaTransferObject)"
  })
  public void testNonTransactionalFetch_thenReturnPersistenceResponse() throws Throwable {
    // Arrange
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(persistenceThreadManager.operation(
            Mockito.<TargetModeType>any(),
            Mockito.<PersistencePackage>any(),
            Mockito.<Persistable<PersistenceResponse, ServiceException>>any()))
        .thenReturn(persistenceResponse);
    PersistencePackage persistencePackage = new PersistencePackage();

    // Act
    PersistenceResponse actualNonTransactionalFetchResult =
        dynamicEntityRemoteService.nonTransactionalFetch(
            persistencePackage, new CriteriaTransferObject());

    // Assert
    verify(persistenceThreadManager)
        .operation(
            isA(TargetModeType.class), isA(PersistencePackage.class), isA(Persistable.class));
    assertSame(persistenceResponse, actualNonTransactionalFetchResult);
  }

  /**
   * Test {@link DynamicEntityRemoteService#nonTransactionalFetch(PersistencePackage,
   * CriteriaTransferObject)}.
   *
   * <ul>
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicEntityRemoteService#nonTransactionalFetch(PersistencePackage, CriteriaTransferObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse DynamicEntityRemoteService.nonTransactionalFetch(PersistencePackage, CriteriaTransferObject)"
  })
  public void testNonTransactionalFetch_thenThrowServiceException() throws Throwable {
    // Arrange
    when(persistenceThreadManager.operation(
            Mockito.<TargetModeType>any(),
            Mockito.<PersistencePackage>any(),
            Mockito.<Persistable<PersistenceResponse, ServiceException>>any()))
        .thenThrow(new ServiceException("An error occurred"));
    PersistencePackage persistencePackage = new PersistencePackage();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            dynamicEntityRemoteService.nonTransactionalFetch(
                persistencePackage, new CriteriaTransferObject()));
    verify(persistenceThreadManager)
        .operation(
            isA(TargetModeType.class), isA(PersistencePackage.class), isA(Persistable.class));
  }

  /**
   * Test {@link DynamicEntityRemoteService#cleanEntity(Entity)}.
   *
   * <p>Method under test: {@link DynamicEntityRemoteService#cleanEntity(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DynamicEntityRemoteService.cleanEntity(Entity)"})
  public void testCleanEntity() throws ServiceException {
    // Arrange
    when(exploitProtectionService.cleanStringWithResults(Mockito.<String>any()))
        .thenReturn("Clean String With Results");

    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[] {new Property()});

    // Act
    dynamicEntityRemoteService.cleanEntity(entity);

    // Assert
    verify(exploitProtectionService).cleanStringWithResults(null);
    verify(entity).getProperties();
  }

  /**
   * Test {@link DynamicEntityRemoteService#cleanEntity(Entity)}.
   *
   * <ul>
   *   <li>Given {@link DynamicEntityRemoteService} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityRemoteService#cleanEntity(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DynamicEntityRemoteService.cleanEntity(Entity)"})
  public void testCleanEntity_givenDynamicEntityRemoteService() throws ServiceException {
    // Arrange
    DynamicEntityRemoteService dynamicEntityRemoteService = new DynamicEntityRemoteService();

    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[] {});

    // Act
    dynamicEntityRemoteService.cleanEntity(entity);

    // Assert
    verify(entity).getProperties();
  }

  /**
   * Test {@link DynamicEntityRemoteService#cleanEntity(Entity)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityRemoteService#cleanEntity(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DynamicEntityRemoteService.cleanEntity(Entity)"})
  public void testCleanEntity_givenRuntimeException_thenThrowRuntimeException()
      throws ServiceException {
    // Arrange
    when(exploitProtectionService.cleanStringWithResults(Mockito.<String>any()))
        .thenThrow(new CleanStringException(new CleanResults()));

    Entity entity = mock(Entity.class);
    doThrow(new RuntimeException())
        .when(entity)
        .addValidationError(Mockito.<String>any(), Mockito.<String>any());
    when(entity.getProperties()).thenReturn(new Property[] {new Property()});

    // Act and Assert
    assertThrows(RuntimeException.class, () -> dynamicEntityRemoteService.cleanEntity(entity));
    verify(exploitProtectionService).cleanStringWithResults(null);
    verify(entity)
        .addValidationError(
            null,
            "\nNote - Antisamy policy in effect. Set a new policy file to modify validation behavior/strictness.");
    verify(entity).getProperties();
  }

  /**
   * Test {@link DynamicEntityRemoteService#cleanEntity(Entity)}.
   *
   * <ul>
   *   <li>Then calls {@link Entity#addValidationError(String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityRemoteService#cleanEntity(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DynamicEntityRemoteService.cleanEntity(Entity)"})
  public void testCleanEntity_thenCallsAddValidationError() throws ServiceException {
    // Arrange
    when(exploitProtectionService.cleanStringWithResults(Mockito.<String>any()))
        .thenThrow(new CleanStringException(new CleanResults()));

    Entity entity = mock(Entity.class);
    doNothing().when(entity).addValidationError(Mockito.<String>any(), Mockito.<String>any());
    when(entity.getProperties()).thenReturn(new Property[] {new Property()});

    // Act
    dynamicEntityRemoteService.cleanEntity(entity);

    // Assert
    verify(exploitProtectionService).cleanStringWithResults(null);
    verify(entity)
        .addValidationError(
            null,
            "\nNote - Antisamy policy in effect. Set a new policy file to modify validation behavior/strictness.");
    verify(entity).getProperties();
  }

  /**
   * Test {@link DynamicEntityRemoteService#cleanEntity(Entity)}.
   *
   * <ul>
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityRemoteService#cleanEntity(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DynamicEntityRemoteService.cleanEntity(Entity)"})
  public void testCleanEntity_thenThrowServiceException() throws ServiceException {
    // Arrange
    when(exploitProtectionService.cleanStringWithResults(Mockito.<String>any()))
        .thenThrow(new ServiceException("An error occurred"));

    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[] {new Property()});

    // Act and Assert
    assertThrows(ServiceException.class, () -> dynamicEntityRemoteService.cleanEntity(entity));
    verify(exploitProtectionService).cleanStringWithResults(null);
    verify(entity).getProperties();
  }

  /**
   * Test {@link DynamicEntityRemoteService#add(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityRemoteService#add(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PersistenceResponse DynamicEntityRemoteService.add(PersistencePackage)"})
  public void testAdd_thenReturnNull() throws Throwable {
    // Arrange
    when(persistenceService.identifyTransactionManager(
            Mockito.<String>any(), Mockito.<TargetModeType>any()))
        .thenReturn(new LifecycleAwareJpaTransactionManager());
    doNothing()
        .when(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any(),
            Mockito.<PlatformTransactionManager>any());

    // Act
    PersistenceResponse actualAddResult = dynamicEntityRemoteService.add(new PersistencePackage());

    // Assert
    verify(persistenceService).identifyTransactionManager(isNull(), isA(TargetModeType.class));
    verify(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            isA(StreamCapableTransactionalOperation.class),
            isA(Class.class),
            isA(PlatformTransactionManager.class));
    assertNull(actualAddResult);
  }

  /**
   * Test {@link DynamicEntityRemoteService#add(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityRemoteService#add(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PersistenceResponse DynamicEntityRemoteService.add(PersistencePackage)"})
  public void testAdd_thenThrowRuntimeException() throws ServiceException {
    // Arrange
    when(persistenceService.identifyTransactionManager(
            Mockito.<String>any(), Mockito.<TargetModeType>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> dynamicEntityRemoteService.add(new PersistencePackage()));
    verify(persistenceService).identifyTransactionManager(isNull(), isA(TargetModeType.class));
  }

  /**
   * Test {@link DynamicEntityRemoteService#update(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityRemoteService#update(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PersistenceResponse DynamicEntityRemoteService.update(PersistencePackage)"})
  public void testUpdate_thenReturnNull() throws Throwable {
    // Arrange
    when(persistenceService.identifyTransactionManager(
            Mockito.<String>any(), Mockito.<TargetModeType>any()))
        .thenReturn(new LifecycleAwareJpaTransactionManager());
    doNothing()
        .when(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any(),
            Mockito.<PlatformTransactionManager>any());

    // Act
    PersistenceResponse actualUpdateResult =
        dynamicEntityRemoteService.update(new PersistencePackage());

    // Assert
    verify(persistenceService).identifyTransactionManager(isNull(), isA(TargetModeType.class));
    verify(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            isA(StreamCapableTransactionalOperation.class),
            isA(Class.class),
            isA(PlatformTransactionManager.class));
    assertNull(actualUpdateResult);
  }

  /**
   * Test {@link DynamicEntityRemoteService#update(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityRemoteService#update(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PersistenceResponse DynamicEntityRemoteService.update(PersistencePackage)"})
  public void testUpdate_thenThrowRuntimeException() throws ServiceException {
    // Arrange
    when(persistenceService.identifyTransactionManager(
            Mockito.<String>any(), Mockito.<TargetModeType>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> dynamicEntityRemoteService.update(new PersistencePackage()));
    verify(persistenceService).identifyTransactionManager(isNull(), isA(TargetModeType.class));
  }

  /**
   * Test {@link DynamicEntityRemoteService#remove(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityRemoteService#remove(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PersistenceResponse DynamicEntityRemoteService.remove(PersistencePackage)"})
  public void testRemove_thenReturnNull() throws Throwable {
    // Arrange
    when(persistenceService.identifyTransactionManager(
            Mockito.<String>any(), Mockito.<TargetModeType>any()))
        .thenReturn(new LifecycleAwareJpaTransactionManager());
    doNothing()
        .when(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any(),
            Mockito.<PlatformTransactionManager>any());

    // Act
    PersistenceResponse actualRemoveResult =
        dynamicEntityRemoteService.remove(new PersistencePackage());

    // Assert
    verify(persistenceService).identifyTransactionManager(isNull(), isA(TargetModeType.class));
    verify(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            isA(StreamCapableTransactionalOperation.class),
            isA(Class.class),
            isA(PlatformTransactionManager.class));
    assertNull(actualRemoveResult);
  }

  /**
   * Test {@link DynamicEntityRemoteService#remove(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityRemoteService#remove(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PersistenceResponse DynamicEntityRemoteService.remove(PersistencePackage)"})
  public void testRemove_thenThrowRuntimeException() throws ServiceException {
    // Arrange
    when(persistenceService.identifyTransactionManager(
            Mockito.<String>any(), Mockito.<TargetModeType>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> dynamicEntityRemoteService.remove(new PersistencePackage()));
    verify(persistenceService).identifyTransactionManager(isNull(), isA(TargetModeType.class));
  }

  /**
   * Test {@link DynamicEntityRemoteService#nonTransactionalAdd(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then return {@link PersistenceResponse} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicEntityRemoteService#nonTransactionalAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse DynamicEntityRemoteService.nonTransactionalAdd(PersistencePackage)"
  })
  public void testNonTransactionalAdd_thenReturnPersistenceResponse() throws Throwable {
    // Arrange
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(persistenceThreadManager.operation(
            Mockito.<TargetModeType>any(),
            Mockito.<PersistencePackage>any(),
            Mockito.<Persistable<PersistenceResponse, ServiceException>>any()))
        .thenReturn(persistenceResponse);

    // Act
    PersistenceResponse actualNonTransactionalAddResult =
        dynamicEntityRemoteService.nonTransactionalAdd(new PersistencePackage());

    // Assert
    verify(persistenceThreadManager)
        .operation(
            isA(TargetModeType.class), isA(PersistencePackage.class), isA(Persistable.class));
    assertSame(persistenceResponse, actualNonTransactionalAddResult);
  }

  /**
   * Test {@link DynamicEntityRemoteService#nonTransactionalAdd(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicEntityRemoteService#nonTransactionalAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse DynamicEntityRemoteService.nonTransactionalAdd(PersistencePackage)"
  })
  public void testNonTransactionalAdd_thenThrowServiceException() throws Throwable {
    // Arrange
    when(persistenceThreadManager.operation(
            Mockito.<TargetModeType>any(),
            Mockito.<PersistencePackage>any(),
            Mockito.<Persistable<PersistenceResponse, ServiceException>>any()))
        .thenThrow(new ServiceException("An error occurred"));

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () -> dynamicEntityRemoteService.nonTransactionalAdd(new PersistencePackage()));
    verify(persistenceThreadManager)
        .operation(
            isA(TargetModeType.class), isA(PersistencePackage.class), isA(Persistable.class));
  }

  /**
   * Test {@link DynamicEntityRemoteService#nonTransactionalUpdate(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then return {@link PersistenceResponse} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicEntityRemoteService#nonTransactionalUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse DynamicEntityRemoteService.nonTransactionalUpdate(PersistencePackage)"
  })
  public void testNonTransactionalUpdate_thenReturnPersistenceResponse() throws Throwable {
    // Arrange
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(persistenceThreadManager.operation(
            Mockito.<TargetModeType>any(),
            Mockito.<PersistencePackage>any(),
            Mockito.<Persistable<PersistenceResponse, ServiceException>>any()))
        .thenReturn(persistenceResponse);

    // Act
    PersistenceResponse actualNonTransactionalUpdateResult =
        dynamicEntityRemoteService.nonTransactionalUpdate(new PersistencePackage());

    // Assert
    verify(persistenceThreadManager)
        .operation(
            isA(TargetModeType.class), isA(PersistencePackage.class), isA(Persistable.class));
    assertSame(persistenceResponse, actualNonTransactionalUpdateResult);
  }

  /**
   * Test {@link DynamicEntityRemoteService#nonTransactionalUpdate(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicEntityRemoteService#nonTransactionalUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse DynamicEntityRemoteService.nonTransactionalUpdate(PersistencePackage)"
  })
  public void testNonTransactionalUpdate_thenThrowServiceException() throws Throwable {
    // Arrange
    when(persistenceThreadManager.operation(
            Mockito.<TargetModeType>any(),
            Mockito.<PersistencePackage>any(),
            Mockito.<Persistable<PersistenceResponse, ServiceException>>any()))
        .thenThrow(new ServiceException("An error occurred"));

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () -> dynamicEntityRemoteService.nonTransactionalUpdate(new PersistencePackage()));
    verify(persistenceThreadManager)
        .operation(
            isA(TargetModeType.class), isA(PersistencePackage.class), isA(Persistable.class));
  }

  /**
   * Test {@link DynamicEntityRemoteService#nonTransactionalRemove(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then return {@link PersistenceResponse} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicEntityRemoteService#nonTransactionalRemove(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse DynamicEntityRemoteService.nonTransactionalRemove(PersistencePackage)"
  })
  public void testNonTransactionalRemove_thenReturnPersistenceResponse() throws Throwable {
    // Arrange
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(persistenceThreadManager.operation(
            Mockito.<TargetModeType>any(),
            Mockito.<PersistencePackage>any(),
            Mockito.<Persistable<PersistenceResponse, ServiceException>>any()))
        .thenReturn(persistenceResponse);

    // Act
    PersistenceResponse actualNonTransactionalRemoveResult =
        dynamicEntityRemoteService.nonTransactionalRemove(new PersistencePackage());

    // Assert
    verify(persistenceThreadManager)
        .operation(
            isA(TargetModeType.class), isA(PersistencePackage.class), isA(Persistable.class));
    assertSame(persistenceResponse, actualNonTransactionalRemoveResult);
  }

  /**
   * Test {@link DynamicEntityRemoteService#nonTransactionalRemove(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicEntityRemoteService#nonTransactionalRemove(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse DynamicEntityRemoteService.nonTransactionalRemove(PersistencePackage)"
  })
  public void testNonTransactionalRemove_thenThrowServiceException() throws Throwable {
    // Arrange
    when(persistenceThreadManager.operation(
            Mockito.<TargetModeType>any(),
            Mockito.<PersistencePackage>any(),
            Mockito.<Persistable<PersistenceResponse, ServiceException>>any()))
        .thenThrow(new ServiceException("An error occurred"));

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () -> dynamicEntityRemoteService.nonTransactionalRemove(new PersistencePackage()));
    verify(persistenceThreadManager)
        .operation(
            isA(TargetModeType.class), isA(PersistencePackage.class), isA(Persistable.class));
  }

  /**
   * Test {@link DynamicEntityRemoteService#isShouldClean()}.
   *
   * <p>Method under test: {@link DynamicEntityRemoteService#isShouldClean()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DynamicEntityRemoteService.isShouldClean()"})
  public void testIsShouldClean() {
    // Arrange, Act and Assert
    assertTrue(new DynamicEntityRemoteService().isShouldClean());
  }

  /**
   * Test {@link DynamicEntityRemoteService#identifyTransactionManager(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then return {@link LifecycleAwareJpaTransactionManager} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicEntityRemoteService#identifyTransactionManager(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PlatformTransactionManager DynamicEntityRemoteService.identifyTransactionManager(PersistencePackage)"
  })
  public void testIdentifyTransactionManager_thenReturnLifecycleAwareJpaTransactionManager()
      throws ServiceException {
    // Arrange
    LifecycleAwareJpaTransactionManager lifecycleAwareJpaTransactionManager =
        new LifecycleAwareJpaTransactionManager();
    when(persistenceService.identifyTransactionManager(
            Mockito.<String>any(), Mockito.<TargetModeType>any()))
        .thenReturn(lifecycleAwareJpaTransactionManager);

    // Act
    PlatformTransactionManager actualIdentifyTransactionManagerResult =
        dynamicEntityRemoteService.identifyTransactionManager(new PersistencePackage());

    // Assert
    verify(persistenceService).identifyTransactionManager(isNull(), isA(TargetModeType.class));
    assertSame(lifecycleAwareJpaTransactionManager, actualIdentifyTransactionManagerResult);
  }

  /**
   * Test {@link DynamicEntityRemoteService#identifyTransactionManager(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicEntityRemoteService#identifyTransactionManager(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PlatformTransactionManager DynamicEntityRemoteService.identifyTransactionManager(PersistencePackage)"
  })
  public void testIdentifyTransactionManager_thenThrowRuntimeException() throws ServiceException {
    // Arrange
    when(persistenceService.identifyTransactionManager(
            Mockito.<String>any(), Mockito.<TargetModeType>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> dynamicEntityRemoteService.identifyTransactionManager(new PersistencePackage()));
    verify(persistenceService).identifyTransactionManager(isNull(), isA(TargetModeType.class));
  }
}

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
package org.broadleafcommerce.openadmin.server.service.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.persistence.Status;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerEventHandlerResponse.PersistenceManagerEventHandlerResponseStatus;
import org.broadleafcommerce.openadmin.server.service.persistence.extension.ArchiveStatusPersistenceEventHandlerExtensionHandler;
import org.broadleafcommerce.openadmin.server.service.persistence.extension.ArchiveStatusPersistenceEventHandlerExtensionManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FieldPath;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FilterMapping;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ArchiveStatusPersistenceEventHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ArchiveStatusPersistenceEventHandlerDiffblueTest {
  @Autowired
  private ArchiveStatusPersistenceEventHandler archiveStatusPersistenceEventHandler;

  @MockBean(name = "blArchiveStatusPersistenceEventHandlerExtensionManager")
  private ArchiveStatusPersistenceEventHandlerExtensionManager archiveStatusPersistenceEventHandlerExtensionManager;

  /**
   * Test {@link ArchiveStatusPersistenceEventHandler#preFetch(PersistenceManager, PersistencePackage, CriteriaTransferObject)}.
   * <ul>
   *   <li>Given {@link DynamicEntityDaoImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ArchiveStatusPersistenceEventHandler#preFetch(PersistenceManager, PersistencePackage, CriteriaTransferObject)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceManagerEventHandlerResponse ArchiveStatusPersistenceEventHandler.preFetch(PersistenceManager, PersistencePackage, CriteriaTransferObject)"})
  public void testPreFetch_givenDynamicEntityDaoImpl() throws ServiceException {
    // Arrange
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(new DynamicEntityDaoImpl());
    Entity entity = new Entity();
    PersistencePackage persistencePackage = new PersistencePackage("java.util.List", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123");

    CriteriaTransferObject cto = new CriteriaTransferObject();

    // Act
    PersistenceManagerEventHandlerResponse actualPreFetchResult = archiveStatusPersistenceEventHandler
        .preFetch(persistenceManager, persistencePackage, cto);

    // Assert
    verify(persistenceManager).getDynamicEntityDao();
    assertNull(actualPreFetchResult.getDynamicResultSet());
    assertNull(actualPreFetchResult.getEntity());
    assertEquals(PersistenceManagerEventHandlerResponseStatus.HANDLED, actualPreFetchResult.getStatus());
    assertTrue(cto.getAdditionalFilterMappings().isEmpty());
    assertTrue(actualPreFetchResult.getAdditionalData().isEmpty());
  }

  /**
   * Test {@link ArchiveStatusPersistenceEventHandler#preFetch(PersistenceManager, PersistencePackage, CriteriaTransferObject)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   *   <li>Then return Status is {@code HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArchiveStatusPersistenceEventHandler#preFetch(PersistenceManager, PersistencePackage, CriteriaTransferObject)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceManagerEventHandlerResponse ArchiveStatusPersistenceEventHandler.preFetch(PersistenceManager, PersistencePackage, CriteriaTransferObject)"})
  public void testPreFetch_givenJavaLangObject_thenReturnStatusIsHandled() throws ServiceException {
    // Arrange
    ArchiveStatusPersistenceEventHandlerExtensionHandler archiveStatusPersistenceEventHandlerExtensionHandler = mock(
        ArchiveStatusPersistenceEventHandlerExtensionHandler.class);
    when(archiveStatusPersistenceEventHandlerExtensionHandler.isArchivable(Mockito.<Class<Object>>any(),
        Mockito.<AtomicBoolean>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(archiveStatusPersistenceEventHandlerExtensionManager.getProxy())
        .thenReturn(archiveStatusPersistenceEventHandlerExtensionHandler);
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    Class<Object> forNameResult = Object.class;
    when(dynamicEntityDaoImpl.getAllPolymorphicEntitiesFromCeiling(Mockito.<Class<Object>>any()))
        .thenReturn(new Class[]{forNameResult});
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);
    Entity entity = new Entity();
    PersistencePackage persistencePackage = new PersistencePackage("java.util.List", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123");

    CriteriaTransferObject cto = new CriteriaTransferObject();

    // Act
    PersistenceManagerEventHandlerResponse actualPreFetchResult = archiveStatusPersistenceEventHandler
        .preFetch(persistenceManager, persistencePackage, cto);

    // Assert
    verify(archiveStatusPersistenceEventHandlerExtensionManager).getProxy();
    verify(dynamicEntityDaoImpl).getAllPolymorphicEntitiesFromCeiling(isA(Class.class));
    verify(persistenceManager).getDynamicEntityDao();
    verify(archiveStatusPersistenceEventHandlerExtensionHandler).isArchivable(isA(Class.class),
        isA(AtomicBoolean.class));
    assertNull(actualPreFetchResult.getDynamicResultSet());
    assertNull(actualPreFetchResult.getEntity());
    assertEquals(PersistenceManagerEventHandlerResponseStatus.HANDLED, actualPreFetchResult.getStatus());
    assertTrue(cto.getAdditionalFilterMappings().isEmpty());
    assertTrue(actualPreFetchResult.getAdditionalData().isEmpty());
  }

  /**
   * Test {@link ArchiveStatusPersistenceEventHandler#preFetch(PersistenceManager, PersistencePackage, CriteriaTransferObject)}.
   * <ul>
   *   <li>Then {@link CriteriaTransferObject} (default constructor) AdditionalFilterMappings size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArchiveStatusPersistenceEventHandler#preFetch(PersistenceManager, PersistencePackage, CriteriaTransferObject)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceManagerEventHandlerResponse ArchiveStatusPersistenceEventHandler.preFetch(PersistenceManager, PersistencePackage, CriteriaTransferObject)"})
  public void testPreFetch_thenCriteriaTransferObjectAdditionalFilterMappingsSizeIsOne() throws ServiceException {
    // Arrange
    ArchiveStatusPersistenceEventHandlerExtensionHandler archiveStatusPersistenceEventHandlerExtensionHandler = mock(
        ArchiveStatusPersistenceEventHandlerExtensionHandler.class);
    when(archiveStatusPersistenceEventHandlerExtensionHandler.isArchivable(Mockito.<Class<Object>>any(),
        Mockito.<AtomicBoolean>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(archiveStatusPersistenceEventHandlerExtensionManager.getProxy())
        .thenReturn(archiveStatusPersistenceEventHandlerExtensionHandler);
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    Class<Status> forNameResult = Status.class;
    when(dynamicEntityDaoImpl.getAllPolymorphicEntitiesFromCeiling(Mockito.<Class<Object>>any()))
        .thenReturn(new Class[]{forNameResult});
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);
    Entity entity = new Entity();
    PersistencePackage persistencePackage = new PersistencePackage("java.util.List", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123");

    CriteriaTransferObject cto = new CriteriaTransferObject();

    // Act
    archiveStatusPersistenceEventHandler.preFetch(persistenceManager, persistencePackage, cto);

    // Assert
    verify(archiveStatusPersistenceEventHandlerExtensionManager).getProxy();
    verify(dynamicEntityDaoImpl).getAllPolymorphicEntitiesFromCeiling(isA(Class.class));
    verify(persistenceManager).getDynamicEntityDao();
    verify(archiveStatusPersistenceEventHandlerExtensionHandler).isArchivable(isA(Class.class),
        isA(AtomicBoolean.class));
    List<FilterMapping> additionalFilterMappings = cto.getAdditionalFilterMappings();
    assertEquals(1, additionalFilterMappings.size());
    FilterMapping getResult = additionalFilterMappings.get(0);
    FieldPath fieldPath = getResult.getFieldPath();
    assertEquals("archiveStatus.archived", fieldPath.getTargetProperty());
    assertNull(getResult.getInheritedFromClass());
    assertNull(getResult.getOrder());
    assertNull(getResult.getFullPropertyName());
    assertNull(getResult.getSortDirection());
    assertNull(getResult.getRestriction().getFilterValueConverter());
    assertTrue(fieldPath.getAssociationPath().isEmpty());
    assertTrue(fieldPath.getTargetPropertyPieces().isEmpty());
    assertTrue(getResult.getDirectFilterValues().isEmpty());
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getNullsLast());
  }

  /**
   * Test {@link ArchiveStatusPersistenceEventHandler#preFetch(PersistenceManager, PersistencePackage, CriteriaTransferObject)}.
   * <ul>
   *   <li>Then return Status is {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArchiveStatusPersistenceEventHandler#preFetch(PersistenceManager, PersistencePackage, CriteriaTransferObject)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceManagerEventHandlerResponse ArchiveStatusPersistenceEventHandler.preFetch(PersistenceManager, PersistencePackage, CriteriaTransferObject)"})
  public void testPreFetch_thenReturnStatusIsNotHandled() throws ServiceException {
    // Arrange
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    Entity entity = new Entity();
    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria"}, "ABC123");

    CriteriaTransferObject cto = new CriteriaTransferObject();

    // Act
    PersistenceManagerEventHandlerResponse actualPreFetchResult = archiveStatusPersistenceEventHandler
        .preFetch(persistenceManager, persistencePackage, cto);

    // Assert
    assertNull(actualPreFetchResult.getDynamicResultSet());
    assertNull(actualPreFetchResult.getEntity());
    assertEquals(PersistenceManagerEventHandlerResponseStatus.NOT_HANDLED, actualPreFetchResult.getStatus());
    assertTrue(cto.getAdditionalFilterMappings().isEmpty());
    assertTrue(actualPreFetchResult.getAdditionalData().isEmpty());
  }

  /**
   * Test {@link ArchiveStatusPersistenceEventHandler#getOrder()}.
   * <p>
   * Method under test: {@link ArchiveStatusPersistenceEventHandler#getOrder()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArchiveStatusPersistenceEventHandler.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(Integer.MIN_VALUE, (new ArchiveStatusPersistenceEventHandler()).getOrder());
  }
}

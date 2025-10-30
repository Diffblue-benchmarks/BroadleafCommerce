/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.admin.server.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StructuredContentTypeCustomPersistenceHandlerDiffblueTest {
  @InjectMocks
  private StructuredContentTypeCustomPersistenceHandler structuredContentTypeCustomPersistenceHandler;

  /**
   * Test {@link StructuredContentTypeCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentTypeCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean StructuredContentTypeCustomPersistenceHandler.canHandleFetch(PersistencePackage)"})
  public void testCanHandleFetch_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(structuredContentTypeCustomPersistenceHandler.canHandleFetch(new PersistencePackage()));
  }

  /**
   * Test {@link StructuredContentTypeCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentTypeCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean StructuredContentTypeCustomPersistenceHandler.canHandleAdd(PersistencePackage)"})
  public void testCanHandleAdd_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(structuredContentTypeCustomPersistenceHandler.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Test {@link StructuredContentTypeCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentTypeCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean StructuredContentTypeCustomPersistenceHandler.canHandleInspect(PersistencePackage)"})
  public void testCanHandleInspect_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(structuredContentTypeCustomPersistenceHandler.canHandleInspect(new PersistencePackage()));
  }

  /**
   * Test {@link StructuredContentTypeCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <p>
   * Method under test: {@link StructuredContentTypeCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean StructuredContentTypeCustomPersistenceHandler.canHandleRemove(PersistencePackage)"})
  public void testCanHandleRemove() {
    // Arrange, Act and Assert
    assertFalse(structuredContentTypeCustomPersistenceHandler.canHandleRemove(new PersistencePackage()));
  }

  /**
   * Test {@link StructuredContentTypeCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentTypeCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean StructuredContentTypeCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"})
  public void testCanHandleUpdate_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(structuredContentTypeCustomPersistenceHandler.canHandleUpdate(new PersistencePackage()));
  }

  /**
   * Test {@link StructuredContentTypeCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@code Unable to perform fetch for entity:}.</li>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentTypeCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.openadmin.dto.DynamicResultSet StructuredContentTypeCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"})
  public void testFetch_givenUnableToPerformFetchForEntity_thenThrowServiceException() throws ServiceException {
    // Arrange
    Entity entity = new Entity();

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Unable to perform fetch for entity: "}, "ABC123");
    persistencePackage.addCustomCriteria("Unable to perform fetch for entity: ");
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> structuredContentTypeCustomPersistenceHandler.fetch(persistencePackage,
        cto, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
  }

  /**
   * Test {@link StructuredContentTypeCustomPersistenceHandler#getFieldContainerClassName()}.
   * <p>
   * Method under test: {@link StructuredContentTypeCustomPersistenceHandler#getFieldContainerClassName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StructuredContentTypeCustomPersistenceHandler.getFieldContainerClassName()"})
  public void testGetFieldContainerClassName() {
    // Arrange, Act and Assert
    assertEquals("org.broadleafcommerce.cms.structure.domain.StructuredContent",
        structuredContentTypeCustomPersistenceHandler.getFieldContainerClassName());
  }

  /**
   * Test {@link StructuredContentTypeCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentTypeCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity StructuredContentTypeCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testUpdate_thenThrowServiceException() throws ServiceException {
    // Arrange
    Entity entity = new Entity();

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Unable to perform fetch for entity: "}, "ABC123");
    persistencePackage.addCustomCriteria("Unable to perform fetch for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> structuredContentTypeCustomPersistenceHandler.update(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
  }

  /**
   * Test {@link StructuredContentTypeCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentTypeCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity StructuredContentTypeCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testAdd_thenThrowServiceException() throws ServiceException {
    // Arrange
    Entity entity = new Entity();

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Unable to perform fetch for entity: "}, "ABC123");
    persistencePackage.addCustomCriteria("Unable to perform fetch for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> structuredContentTypeCustomPersistenceHandler.add(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
  }

  /**
   * Test {@link StructuredContentTypeCustomPersistenceHandler#addOrUpdate(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentTypeCustomPersistenceHandler#addOrUpdate(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity StructuredContentTypeCustomPersistenceHandler.addOrUpdate(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testAddOrUpdate_thenThrowServiceException() throws ServiceException {
    // Arrange
    Entity entity = new Entity();

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Unable to perform fetch for entity: "}, "ABC123");
    persistencePackage.addCustomCriteria("Unable to perform fetch for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> structuredContentTypeCustomPersistenceHandler
        .addOrUpdate(persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
  }
}

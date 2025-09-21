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
package org.broadleafcommerce.openadmin.server.service.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.ForeignKey;
import org.broadleafcommerce.openadmin.dto.OperationTypes;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.security.handler.AdminUserCustomPersistenceHandler;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManager;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.InspectHelper;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {CustomPersistenceHandlerAdapter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomPersistenceHandlerAdapterDiffblueTest {
  @Autowired private CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter;

  /**
   * Test {@link CustomPersistenceHandlerAdapter#canHandleInspect(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * CustomPersistenceHandlerAdapter#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean CustomPersistenceHandlerAdapter.canHandleInspect(PersistencePackage)"
  })
  public void testCanHandleInspect() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter =
        new CustomPersistenceHandlerAdapter();

    // Act and Assert
    assertFalse(customPersistenceHandlerAdapter.canHandleInspect(new PersistencePackage()));
  }

  /**
   * Test {@link CustomPersistenceHandlerAdapter#canHandleFetch(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * CustomPersistenceHandlerAdapter#canHandleFetch(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean CustomPersistenceHandlerAdapter.canHandleFetch(PersistencePackage)"
  })
  public void testCanHandleFetch() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter =
        new CustomPersistenceHandlerAdapter();

    // Act and Assert
    assertFalse(customPersistenceHandlerAdapter.canHandleFetch(new PersistencePackage()));
  }

  /**
   * Test {@link CustomPersistenceHandlerAdapter#canHandleAdd(PersistencePackage)}.
   *
   * <p>Method under test: {@link CustomPersistenceHandlerAdapter#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean CustomPersistenceHandlerAdapter.canHandleAdd(PersistencePackage)"
  })
  public void testCanHandleAdd() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter =
        new CustomPersistenceHandlerAdapter();

    // Act and Assert
    assertFalse(customPersistenceHandlerAdapter.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Test {@link CustomPersistenceHandlerAdapter#canHandleRemove(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * CustomPersistenceHandlerAdapter#canHandleRemove(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean CustomPersistenceHandlerAdapter.canHandleRemove(PersistencePackage)"
  })
  public void testCanHandleRemove() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter =
        new CustomPersistenceHandlerAdapter();

    // Act and Assert
    assertFalse(customPersistenceHandlerAdapter.canHandleRemove(new PersistencePackage()));
  }

  /**
   * Test {@link CustomPersistenceHandlerAdapter#canHandleUpdate(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * CustomPersistenceHandlerAdapter#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean CustomPersistenceHandlerAdapter.canHandleUpdate(PersistencePackage)"
  })
  public void testCanHandleUpdate() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter =
        new CustomPersistenceHandlerAdapter();

    // Act and Assert
    assertFalse(customPersistenceHandlerAdapter.canHandleUpdate(new PersistencePackage()));
  }

  /**
   * Test {@link CustomPersistenceHandlerAdapter#inspect(PersistencePackage, DynamicEntityDao,
   * InspectHelper)}.
   *
   * <p>Method under test: {@link CustomPersistenceHandlerAdapter#inspect(PersistencePackage,
   * DynamicEntityDao, InspectHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DynamicResultSet CustomPersistenceHandlerAdapter.inspect(PersistencePackage, DynamicEntityDao, InspectHelper)"
  })
  public void testInspect() throws ServiceException {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter =
        new CustomPersistenceHandlerAdapter();
    PersistencePackage persistencePackage = new PersistencePackage();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            customPersistenceHandlerAdapter.inspect(
                persistencePackage, dynamicEntityDao, new PersistenceManagerImpl()));
  }

  /**
   * Test {@link CustomPersistenceHandlerAdapter#fetch(PersistencePackage, CriteriaTransferObject,
   * DynamicEntityDao, RecordHelper)}.
   *
   * <p>Method under test: {@link CustomPersistenceHandlerAdapter#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DynamicResultSet CustomPersistenceHandlerAdapter.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"
  })
  public void testFetch() throws ServiceException {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter =
        new CustomPersistenceHandlerAdapter();
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            customPersistenceHandlerAdapter.fetch(
                persistencePackage,
                cto,
                dynamicEntityDao,
                new AdornedTargetListPersistenceModule()));
  }

  /**
   * Test {@link CustomPersistenceHandlerAdapter#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <p>Method under test: {@link CustomPersistenceHandlerAdapter#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity CustomPersistenceHandlerAdapter.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd() throws ServiceException {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter =
        new CustomPersistenceHandlerAdapter();
    PersistencePackage persistencePackage = new PersistencePackage();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            customPersistenceHandlerAdapter.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
  }

  /**
   * Test {@link CustomPersistenceHandlerAdapter#remove(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <p>Method under test: {@link CustomPersistenceHandlerAdapter#remove(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CustomPersistenceHandlerAdapter.remove(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testRemove() throws ServiceException {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter =
        new CustomPersistenceHandlerAdapter();
    PersistencePackage persistencePackage = new PersistencePackage();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            customPersistenceHandlerAdapter.remove(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
  }

  /**
   * Test {@link CustomPersistenceHandlerAdapter#update(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <p>Method under test: {@link CustomPersistenceHandlerAdapter#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity CustomPersistenceHandlerAdapter.update(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testUpdate() throws ServiceException {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter =
        new CustomPersistenceHandlerAdapter();
    PersistencePackage persistencePackage = new PersistencePackage();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            customPersistenceHandlerAdapter.update(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
  }

  /**
   * Test {@link CustomPersistenceHandlerAdapter#willHandleSecurity(PersistencePackage)}.
   *
   * <ul>
   *   <li>Given {@link AdminUserCustomPersistenceHandler} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomPersistenceHandlerAdapter#willHandleSecurity(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean CustomPersistenceHandlerAdapter.willHandleSecurity(PersistencePackage)"
  })
  public void testWillHandleSecurity_givenAdminUserCustomPersistenceHandler_thenReturnTrue() {
    // Arrange
    AdminUserCustomPersistenceHandler adminUserCustomPersistenceHandler =
        new AdminUserCustomPersistenceHandler();

    // Act and Assert
    assertTrue(adminUserCustomPersistenceHandler.willHandleSecurity(new PersistencePackage()));
  }

  /**
   * Test {@link CustomPersistenceHandlerAdapter#willHandleSecurity(PersistencePackage)}.
   *
   * <ul>
   *   <li>Given {@link CustomPersistenceHandlerAdapter} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomPersistenceHandlerAdapter#willHandleSecurity(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean CustomPersistenceHandlerAdapter.willHandleSecurity(PersistencePackage)"
  })
  public void testWillHandleSecurity_givenCustomPersistenceHandlerAdapter_thenReturnFalse() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter =
        new CustomPersistenceHandlerAdapter();

    // Act and Assert
    assertFalse(customPersistenceHandlerAdapter.willHandleSecurity(new PersistencePackage()));
  }

  /**
   * Test {@link CustomPersistenceHandlerAdapter#getMetadata(PersistencePackage, InspectHelper)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CustomPersistenceHandlerAdapter#getMetadata(PersistencePackage,
   * InspectHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map CustomPersistenceHandlerAdapter.getMetadata(PersistencePackage, InspectHelper)"
  })
  public void testGetMetadata_givenHashMap_thenReturnEmpty() throws ServiceException {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter =
        new CustomPersistenceHandlerAdapter();
    PersistencePackage persistencePackage = new PersistencePackage();

    PersistenceManagerImpl helper = mock(PersistenceManagerImpl.class);
    when(helper.getSimpleMergedProperties(
            Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());

    // Act
    Map<String, FieldMetadata> actualMetadata =
        customPersistenceHandlerAdapter.getMetadata(persistencePackage, helper);

    // Assert
    verify(helper).getSimpleMergedProperties(isNull(), isNull());
    assertTrue(actualMetadata.isEmpty());
  }

  /**
   * Test {@link CustomPersistenceHandlerAdapter#getResultSet(PersistencePackage, InspectHelper,
   * Map)}.
   *
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomPersistenceHandlerAdapter#getResultSet(PersistencePackage,
   * InspectHelper, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DynamicResultSet CustomPersistenceHandlerAdapter.getResultSet(PersistencePackage, InspectHelper, Map)"
  })
  public void testGetResultSet_givenDrJaneDoe_thenThrowServiceException() throws ServiceException {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter =
        new CustomPersistenceHandlerAdapter();

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setCeilingEntityFullyQualifiedClassname("Dr Jane Doe");
    PersistenceManagerImpl helper = new PersistenceManagerImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            customPersistenceHandlerAdapter.getResultSet(
                persistencePackage, helper, new HashMap<>()));
  }

  /**
   * Test {@link CustomPersistenceHandlerAdapter#getResultSet(PersistencePackage, InspectHelper,
   * Map)}.
   *
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.
   *   <li>Then return PromptSearch is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CustomPersistenceHandlerAdapter#getResultSet(PersistencePackage,
   * InspectHelper, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DynamicResultSet CustomPersistenceHandlerAdapter.getResultSet(PersistencePackage, InspectHelper, Map)"
  })
  public void testGetResultSet_whenPersistencePackage_thenReturnPromptSearchIsNull()
      throws ServiceException {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter =
        new CustomPersistenceHandlerAdapter();
    PersistencePackage persistencePackage = new PersistencePackage();

    // Act
    DynamicResultSet actualResultSet =
        customPersistenceHandlerAdapter.getResultSet(persistencePackage, null, new HashMap<>());

    // Assert
    assertNull(actualResultSet.getPromptSearch());
    assertNull(actualResultSet.getTotalCountLessThanPageSize());
    assertNull(actualResultSet.getBatchId());
    assertNull(actualResultSet.getLowerCount());
    assertNull(actualResultSet.getUpperCount());
    assertNull(actualResultSet.getFirstId());
    assertNull(actualResultSet.getLastId());
    assertNull(actualResultSet.getClassMetaData());
    assertNull(actualResultSet.getFetchType());
    assertEquals(0, actualResultSet.getPageSize().intValue());
    assertEquals(0, actualResultSet.getStartIndex().intValue());
    assertEquals(0, actualResultSet.getTotalRecords().intValue());
    assertEquals(0, actualResultSet.getRecords().length);
    assertTrue(actualResultSet.getUnselectedTabMetadata().isEmpty());
  }

  /**
   * Test {@link CustomPersistenceHandlerAdapter#getPolymorphicClasses(Class, EntityManager,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link CustomPersistenceHandlerAdapter#getPolymorphicClasses(Class,
   * EntityManager, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String[] CustomPersistenceHandlerAdapter.getPolymorphicClasses(Class, EntityManager, boolean)"
  })
  public void testGetPolymorphicClasses_whenFalse_thenReturnArrayLengthIsZero() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter =
        new CustomPersistenceHandlerAdapter();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(
        0, customPersistenceHandlerAdapter.getPolymorphicClasses(clazz, null, false).length);
  }

  /**
   * Test {@link CustomPersistenceHandlerAdapter#getPolymorphicClasses(Class, EntityManager,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link CustomPersistenceHandlerAdapter#getPolymorphicClasses(Class,
   * EntityManager, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String[] CustomPersistenceHandlerAdapter.getPolymorphicClasses(Class, EntityManager, boolean)"
  })
  public void testGetPolymorphicClasses_whenJavaLangObject_thenReturnArrayLengthIsZero() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter =
        new CustomPersistenceHandlerAdapter();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(
        0, customPersistenceHandlerAdapter.getPolymorphicClasses(clazz, null, true).length);
  }

  /**
   * Test {@link CustomPersistenceHandlerAdapter#getPolymorphicClasses(Class, EntityManager,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link CustomPersistenceHandlerAdapter#getPolymorphicClasses(Class,
   * EntityManager, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String[] CustomPersistenceHandlerAdapter.getPolymorphicClasses(Class, EntityManager, boolean)"
  })
  public void testGetPolymorphicClasses_whenJavaLangObject_thenReturnArrayLengthIsZero2() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter =
        new CustomPersistenceHandlerAdapter();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(
        0, customPersistenceHandlerAdapter.getPolymorphicClasses(clazz, null, true).length);
  }

  /**
   * Test {@link CustomPersistenceHandlerAdapter#getClassForName(String)}.
   *
   * <ul>
   *   <li>Then return {@link PersistenceManager}.
   * </ul>
   *
   * <p>Method under test: {@link CustomPersistenceHandlerAdapter#getClassForName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class CustomPersistenceHandlerAdapter.getClassForName(String)"})
  public void testGetClassForName_thenReturnPersistenceManager() {
    // Arrange and Act
    Class actualClassForName =
        customPersistenceHandlerAdapter.getClassForName(
            "org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManager");

    // Assert
    Class<PersistenceManager> expectedClassForName = PersistenceManager.class;
    assertEquals(expectedClassForName, actualClassForName);
  }

  /**
   * Test {@link CustomPersistenceHandlerAdapter#getClassForName(String)}.
   *
   * <ul>
   *   <li>When {@code Dr Jane Doe}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CustomPersistenceHandlerAdapter#getClassForName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class CustomPersistenceHandlerAdapter.getClassForName(String)"})
  public void testGetClassForName_whenDrJaneDoe_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(customPersistenceHandlerAdapter.getClassForName("Dr Jane Doe"));
  }

  /**
   * Test {@link CustomPersistenceHandlerAdapter#isAssignableFrom(String, Class)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CustomPersistenceHandlerAdapter#isAssignableFrom(String, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomPersistenceHandlerAdapter.isAssignableFrom(String, Class)"})
  public void testIsAssignableFrom_thenReturnTrue() {
    // Arrange
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertTrue(
        customPersistenceHandlerAdapter.isAssignableFrom(
            "org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManager",
            targetClass));
  }

  /**
   * Test {@link CustomPersistenceHandlerAdapter#isAssignableFrom(String, Class)}.
   *
   * <ul>
   *   <li>When {@code Dr Jane Doe}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CustomPersistenceHandlerAdapter#isAssignableFrom(String, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomPersistenceHandlerAdapter.isAssignableFrom(String, Class)"})
  public void testIsAssignableFrom_whenDrJaneDoe_thenReturnFalse() {
    // Arrange
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertFalse(customPersistenceHandlerAdapter.isAssignableFrom("Dr Jane Doe", targetClass));
  }

  /**
   * Test {@link CustomPersistenceHandlerAdapter#meetsCustomCriteria(PersistencePackage, String[])}.
   *
   * <p>Method under test: {@link
   * CustomPersistenceHandlerAdapter#meetsCustomCriteria(PersistencePackage, String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomPersistenceHandlerAdapter.meetsCustomCriteria(PersistencePackage, String[])"
  })
  public void testMeetsCustomCriteria() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter =
        new CustomPersistenceHandlerAdapter();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {null};

    PersistencePackage pkg =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act
    boolean actualMeetsCustomCriteriaResult =
        customPersistenceHandlerAdapter.meetsCustomCriteria(pkg, new String[] {"Custom Criteria"});

    // Assert
    assertFalse(actualMeetsCustomCriteriaResult);
  }

  /**
   * Test {@link CustomPersistenceHandlerAdapter#meetsCustomCriteria(PersistencePackage, String[])}.
   *
   * <ul>
   *   <li>Given {@code Criteria}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomPersistenceHandlerAdapter#meetsCustomCriteria(PersistencePackage, String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomPersistenceHandlerAdapter.meetsCustomCriteria(PersistencePackage, String[])"
  })
  public void testMeetsCustomCriteria_givenCriteria() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter =
        new CustomPersistenceHandlerAdapter();

    PersistencePackage pkg = new PersistencePackage();
    pkg.addCustomCriteria("Criteria");

    // Act and Assert
    assertFalse(
        customPersistenceHandlerAdapter.meetsCustomCriteria(pkg, new String[] {"Custom Criteria"}));
  }

  /**
   * Test {@link CustomPersistenceHandlerAdapter#meetsCustomCriteria(PersistencePackage, String[])}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomPersistenceHandlerAdapter#meetsCustomCriteria(PersistencePackage, String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomPersistenceHandlerAdapter.meetsCustomCriteria(PersistencePackage, String[])"
  })
  public void testMeetsCustomCriteria_thenReturnTrue() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter =
        new CustomPersistenceHandlerAdapter();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage pkg =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act
    boolean actualMeetsCustomCriteriaResult =
        customPersistenceHandlerAdapter.meetsCustomCriteria(pkg, new String[] {"Custom Criteria"});

    // Assert
    assertTrue(actualMeetsCustomCriteriaResult);
  }

  /**
   * Test {@link CustomPersistenceHandlerAdapter#meetsCustomCriteria(PersistencePackage, String[])}.
   *
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomPersistenceHandlerAdapter#meetsCustomCriteria(PersistencePackage, String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomPersistenceHandlerAdapter.meetsCustomCriteria(PersistencePackage, String[])"
  })
  public void testMeetsCustomCriteria_whenPersistencePackage_thenReturnFalse() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter =
        new CustomPersistenceHandlerAdapter();

    // Act and Assert
    assertFalse(
        customPersistenceHandlerAdapter.meetsCustomCriteria(
            new PersistencePackage(), new String[] {"Custom Criteria"}));
  }

  /**
   * Test {@link CustomPersistenceHandlerAdapter#isBasicOperation(PersistencePackage)}.
   *
   * <ul>
   *   <li>Given {@link PersistencePerspective#PersistencePerspective()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomPersistenceHandlerAdapter#isBasicOperation(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomPersistenceHandlerAdapter.isBasicOperation(PersistencePackage)"
  })
  public void testIsBasicOperation_givenPersistencePerspective_thenReturnTrue() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter =
        new CustomPersistenceHandlerAdapter();

    PersistencePackage pkg = new PersistencePackage();
    pkg.setPersistencePerspective(new PersistencePerspective());

    // Act and Assert
    assertTrue(customPersistenceHandlerAdapter.isBasicOperation(pkg));
  }

  /**
   * Test {@link CustomPersistenceHandlerAdapter#isBasicOperation(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomPersistenceHandlerAdapter#isBasicOperation(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomPersistenceHandlerAdapter.isBasicOperation(PersistencePackage)"
  })
  public void testIsBasicOperation_thenReturnFalse() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter =
        new CustomPersistenceHandlerAdapter();

    PersistencePackage pkg = new PersistencePackage();
    OperationTypes operationTypes =
        new OperationTypes(
            OperationType.NONDESTRUCTIVEREMOVE,
            OperationType.NONDESTRUCTIVEREMOVE,
            OperationType.NONDESTRUCTIVEREMOVE,
            OperationType.NONDESTRUCTIVEREMOVE,
            OperationType.NONDESTRUCTIVEREMOVE);
    String[] additionalNonPersistentProperties =
        new String[] {"Additional Non Persistent Properties"};
    ForeignKey[] additionalForeignKeys = new ForeignKey[] {new ForeignKey()};

    PersistencePerspective persistencePerspective =
        new PersistencePerspective(
            operationTypes, additionalNonPersistentProperties, additionalForeignKeys);
    pkg.setPersistencePerspective(persistencePerspective);

    // Act and Assert
    assertFalse(customPersistenceHandlerAdapter.isBasicOperation(pkg));
  }

  /**
   * Test {@link CustomPersistenceHandlerAdapter#isMapOperation(PersistencePackage)}.
   *
   * <ul>
   *   <li>Given {@link PersistencePerspective#PersistencePerspective()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomPersistenceHandlerAdapter#isMapOperation(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomPersistenceHandlerAdapter.isMapOperation(PersistencePackage)"})
  public void testIsMapOperation_givenPersistencePerspective_thenReturnFalse() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter =
        new CustomPersistenceHandlerAdapter();

    PersistencePackage pkg = new PersistencePackage();
    pkg.setPersistencePerspective(new PersistencePerspective());

    // Act and Assert
    assertFalse(customPersistenceHandlerAdapter.isMapOperation(pkg));
  }

  /**
   * Test {@link CustomPersistenceHandlerAdapter#isAdornedListOperation(PersistencePackage)}.
   *
   * <ul>
   *   <li>Given {@link PersistencePerspective#PersistencePerspective()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomPersistenceHandlerAdapter#isAdornedListOperation(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomPersistenceHandlerAdapter.isAdornedListOperation(PersistencePackage)"
  })
  public void testIsAdornedListOperation_givenPersistencePerspective_thenReturnFalse() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter =
        new CustomPersistenceHandlerAdapter();

    PersistencePackage pkg = new PersistencePackage();
    pkg.setPersistencePerspective(new PersistencePerspective());

    // Act and Assert
    assertFalse(customPersistenceHandlerAdapter.isAdornedListOperation(pkg));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link CustomPersistenceHandlerAdapter}
   *   <li>{@link CustomPersistenceHandlerAdapter#getOrder()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CustomPersistenceHandlerAdapter.<init>()",
    "int CustomPersistenceHandlerAdapter.getOrder()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        CustomPersistenceHandler.DEFAULT_ORDER, new CustomPersistenceHandlerAdapter().getOrder());
  }
}

/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.service.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
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
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {CustomPersistenceHandlerAdapter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomPersistenceHandlerAdapterDiffblueTest {
  @Autowired
  private CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter;

  /**
   * Test
   * {@link CustomPersistenceHandlerAdapter#canHandleInspect(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter = new CustomPersistenceHandlerAdapter();

    // Act and Assert
    assertFalse(customPersistenceHandlerAdapter.canHandleInspect(new PersistencePackage()));
  }

  /**
   * Test
   * {@link CustomPersistenceHandlerAdapter#canHandleFetch(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter = new CustomPersistenceHandlerAdapter();

    // Act and Assert
    assertFalse(customPersistenceHandlerAdapter.canHandleFetch(new PersistencePackage()));
  }

  /**
   * Test
   * {@link CustomPersistenceHandlerAdapter#canHandleAdd(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter = new CustomPersistenceHandlerAdapter();

    // Act and Assert
    assertFalse(customPersistenceHandlerAdapter.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Test
   * {@link CustomPersistenceHandlerAdapter#canHandleRemove(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#canHandleRemove(PersistencePackage)}
   */
  @Test
  public void testCanHandleRemove() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter = new CustomPersistenceHandlerAdapter();

    // Act and Assert
    assertFalse(customPersistenceHandlerAdapter.canHandleRemove(new PersistencePackage()));
  }

  /**
   * Test
   * {@link CustomPersistenceHandlerAdapter#canHandleUpdate(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter = new CustomPersistenceHandlerAdapter();

    // Act and Assert
    assertFalse(customPersistenceHandlerAdapter.canHandleUpdate(new PersistencePackage()));
  }

  /**
   * Test
   * {@link CustomPersistenceHandlerAdapter#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}.
   * <p>
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}
   */
  @Test
  public void testInspect() throws ServiceException {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter = new CustomPersistenceHandlerAdapter();
    PersistencePackage persistencePackage = new PersistencePackage();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> customPersistenceHandlerAdapter.inspect(persistencePackage,
        dynamicEntityDao, new PersistenceManagerImpl()));
  }

  /**
   * Test
   * {@link CustomPersistenceHandlerAdapter#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link CustomPersistenceHandlerAdapter} (default constructor).</li>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testFetch_givenCustomPersistenceHandlerAdapter_thenThrowServiceException() throws ServiceException {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter = new CustomPersistenceHandlerAdapter();
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> customPersistenceHandlerAdapter.fetch(persistencePackage, cto,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
  }

  /**
   * Test
   * {@link CustomPersistenceHandlerAdapter#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link CustomPersistenceHandlerAdapter} (default constructor).</li>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testAdd_givenCustomPersistenceHandlerAdapter_thenThrowServiceException() throws ServiceException {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter = new CustomPersistenceHandlerAdapter();
    PersistencePackage persistencePackage = new PersistencePackage();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> customPersistenceHandlerAdapter.add(persistencePackage, dynamicEntityDao,
        new AdornedTargetListPersistenceModule()));
  }

  /**
   * Test
   * {@link CustomPersistenceHandlerAdapter#remove(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link CustomPersistenceHandlerAdapter} (default constructor).</li>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#remove(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testRemove_givenCustomPersistenceHandlerAdapter_thenThrowServiceException() throws ServiceException {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter = new CustomPersistenceHandlerAdapter();
    PersistencePackage persistencePackage = new PersistencePackage();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> customPersistenceHandlerAdapter.remove(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
  }

  /**
   * Test
   * {@link CustomPersistenceHandlerAdapter#update(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link CustomPersistenceHandlerAdapter} (default constructor).</li>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testUpdate_givenCustomPersistenceHandlerAdapter_thenThrowServiceException() throws ServiceException {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter = new CustomPersistenceHandlerAdapter();
    PersistencePackage persistencePackage = new PersistencePackage();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> customPersistenceHandlerAdapter.update(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
  }

  /**
   * Test
   * {@link CustomPersistenceHandlerAdapter#willHandleSecurity(PersistencePackage)}.
   * <ul>
   *   <li>Given {@link AdminUserCustomPersistenceHandler} (default
   * constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#willHandleSecurity(PersistencePackage)}
   */
  @Test
  public void testWillHandleSecurity_givenAdminUserCustomPersistenceHandler_thenReturnTrue() {
    // Arrange
    AdminUserCustomPersistenceHandler adminUserCustomPersistenceHandler = new AdminUserCustomPersistenceHandler();

    // Act and Assert
    assertTrue(adminUserCustomPersistenceHandler.willHandleSecurity(new PersistencePackage()));
  }

  /**
   * Test
   * {@link CustomPersistenceHandlerAdapter#willHandleSecurity(PersistencePackage)}.
   * <ul>
   *   <li>Given {@link CustomPersistenceHandlerAdapter} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#willHandleSecurity(PersistencePackage)}
   */
  @Test
  public void testWillHandleSecurity_givenCustomPersistenceHandlerAdapter_thenReturnFalse() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter = new CustomPersistenceHandlerAdapter();

    // Act and Assert
    assertFalse(customPersistenceHandlerAdapter.willHandleSecurity(new PersistencePackage()));
  }

  /**
   * Test
   * {@link CustomPersistenceHandlerAdapter#getMetadata(PersistencePackage, InspectHelper)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#getMetadata(PersistencePackage, InspectHelper)}
   */
  @Test
  public void testGetMetadata_givenHashMap_thenReturnEmpty() throws ServiceException {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter = new CustomPersistenceHandlerAdapter();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    InspectHelper helper = mock(InspectHelper.class);
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());

    // Act
    Map<String, FieldMetadata> actualMetadata = customPersistenceHandlerAdapter.getMetadata(persistencePackage, helper);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getPersistencePerspective();
    verify(helper).getSimpleMergedProperties(eq("Dr Jane Doe"), isA(PersistencePerspective.class));
    assertTrue(actualMetadata.isEmpty());
  }

  /**
   * Test
   * {@link CustomPersistenceHandlerAdapter#getResultSet(PersistencePackage, InspectHelper, Map)}.
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.</li>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#getResultSet(PersistencePackage, InspectHelper, Map)}
   */
  @Test
  public void testGetResultSet_givenDrJaneDoe_thenThrowServiceException() throws ServiceException {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter = new CustomPersistenceHandlerAdapter();

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setCeilingEntityFullyQualifiedClassname("Dr Jane Doe");
    PersistenceManagerImpl helper = new PersistenceManagerImpl();

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> customPersistenceHandlerAdapter.getResultSet(persistencePackage, helper, new HashMap<>()));
  }

  /**
   * Test
   * {@link CustomPersistenceHandlerAdapter#getResultSet(PersistencePackage, InspectHelper, Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return PromptSearch is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#getResultSet(PersistencePackage, InspectHelper, Map)}
   */
  @Test
  public void testGetResultSet_whenNull_thenReturnPromptSearchIsNull() throws ServiceException {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter = new CustomPersistenceHandlerAdapter();
    PersistencePackage persistencePackage = new PersistencePackage();

    // Act
    DynamicResultSet actualResultSet = customPersistenceHandlerAdapter.getResultSet(persistencePackage, null,
        new HashMap<>());

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
   * Test
   * {@link CustomPersistenceHandlerAdapter#getPolymorphicClasses(Class, EntityManager, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#getPolymorphicClasses(Class, EntityManager, boolean)}
   */
  @Test
  public void testGetPolymorphicClasses_whenFalse_thenReturnArrayLengthIsZero() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter = new CustomPersistenceHandlerAdapter();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(0, customPersistenceHandlerAdapter.getPolymorphicClasses(clazz, null, false).length);
  }

  /**
   * Test
   * {@link CustomPersistenceHandlerAdapter#getPolymorphicClasses(Class, EntityManager, boolean)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#getPolymorphicClasses(Class, EntityManager, boolean)}
   */
  @Test
  public void testGetPolymorphicClasses_whenNull_thenReturnArrayLengthIsZero() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter = new CustomPersistenceHandlerAdapter();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(0, customPersistenceHandlerAdapter.getPolymorphicClasses(clazz, null, true).length);
  }

  /**
   * Test
   * {@link CustomPersistenceHandlerAdapter#getPolymorphicClasses(Class, EntityManager, boolean)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#getPolymorphicClasses(Class, EntityManager, boolean)}
   */
  @Test
  public void testGetPolymorphicClasses_whenNull_thenReturnArrayLengthIsZero2() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter = new CustomPersistenceHandlerAdapter();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(0, customPersistenceHandlerAdapter.getPolymorphicClasses(clazz, null, true).length);
  }

  /**
   * Test {@link CustomPersistenceHandlerAdapter#getClassForName(String)}.
   * <ul>
   *   <li>Then return {@link PersistenceManager}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#getClassForName(String)}
   */
  @Test
  public void testGetClassForName_thenReturnPersistenceManager() {
    // Arrange and Act
    Class actualClassForName = customPersistenceHandlerAdapter
        .getClassForName("org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManager");

    // Assert
    Class<PersistenceManager> expectedClassForName = PersistenceManager.class;
    assertEquals(expectedClassForName, actualClassForName);
  }

  /**
   * Test {@link CustomPersistenceHandlerAdapter#getClassForName(String)}.
   * <ul>
   *   <li>When {@code Dr Jane Doe}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#getClassForName(String)}
   */
  @Test
  public void testGetClassForName_whenDrJaneDoe_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(customPersistenceHandlerAdapter.getClassForName("Dr Jane Doe"));
  }

  /**
   * Test {@link CustomPersistenceHandlerAdapter#isAssignableFrom(String, Class)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#isAssignableFrom(String, Class)}
   */
  @Test
  public void testIsAssignableFrom_thenReturnTrue() {
    // Arrange
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertTrue(customPersistenceHandlerAdapter.isAssignableFrom(
        "org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManager", targetClass));
  }

  /**
   * Test {@link CustomPersistenceHandlerAdapter#isAssignableFrom(String, Class)}.
   * <ul>
   *   <li>When {@code Dr Jane Doe}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#isAssignableFrom(String, Class)}
   */
  @Test
  public void testIsAssignableFrom_whenDrJaneDoe_thenReturnFalse() {
    // Arrange
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertFalse(customPersistenceHandlerAdapter.isAssignableFrom("Dr Jane Doe", targetClass));
  }

  /**
   * Test
   * {@link CustomPersistenceHandlerAdapter#meetsCustomCriteria(PersistencePackage, String[])}.
   * <p>
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#meetsCustomCriteria(PersistencePackage, String[])}
   */
  @Test
  public void testMeetsCustomCriteria() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter = new CustomPersistenceHandlerAdapter();
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(customPersistenceHandlerAdapter.meetsCustomCriteria(
        new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(), new String[]{null}, "ABC123"),
        new String[]{"Custom Criteria"}));
  }

  /**
   * Test
   * {@link CustomPersistenceHandlerAdapter#meetsCustomCriteria(PersistencePackage, String[])}.
   * <ul>
   *   <li>Given {@code Criteria}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#meetsCustomCriteria(PersistencePackage, String[])}
   */
  @Test
  public void testMeetsCustomCriteria_givenCriteria() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter = new CustomPersistenceHandlerAdapter();

    PersistencePackage pkg = new PersistencePackage();
    pkg.addCustomCriteria("Criteria");

    // Act and Assert
    assertFalse(customPersistenceHandlerAdapter.meetsCustomCriteria(pkg, new String[]{"Custom Criteria"}));
  }

  /**
   * Test
   * {@link CustomPersistenceHandlerAdapter#meetsCustomCriteria(PersistencePackage, String[])}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#meetsCustomCriteria(PersistencePackage, String[])}
   */
  @Test
  public void testMeetsCustomCriteria_thenReturnTrue() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter = new CustomPersistenceHandlerAdapter();
    Entity entity = new Entity();

    // Act and Assert
    assertTrue(customPersistenceHandlerAdapter.meetsCustomCriteria(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123"), new String[]{"Custom Criteria"}));
  }

  /**
   * Test
   * {@link CustomPersistenceHandlerAdapter#meetsCustomCriteria(PersistencePackage, String[])}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#meetsCustomCriteria(PersistencePackage, String[])}
   */
  @Test
  public void testMeetsCustomCriteria_whenPersistencePackage_thenReturnFalse() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter = new CustomPersistenceHandlerAdapter();

    // Act and Assert
    assertFalse(
        customPersistenceHandlerAdapter.meetsCustomCriteria(new PersistencePackage(), new String[]{"Custom Criteria"}));
  }

  /**
   * Test
   * {@link CustomPersistenceHandlerAdapter#isBasicOperation(PersistencePackage)}.
   * <ul>
   *   <li>Given {@link PersistencePerspective#PersistencePerspective()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#isBasicOperation(PersistencePackage)}
   */
  @Test
  public void testIsBasicOperation_givenPersistencePerspective_thenReturnTrue() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter = new CustomPersistenceHandlerAdapter();

    PersistencePackage pkg = new PersistencePackage();
    pkg.setPersistencePerspective(new PersistencePerspective());

    // Act and Assert
    assertTrue(customPersistenceHandlerAdapter.isBasicOperation(pkg));
  }

  /**
   * Test
   * {@link CustomPersistenceHandlerAdapter#isMapOperation(PersistencePackage)}.
   * <ul>
   *   <li>Given {@link PersistencePerspective#PersistencePerspective()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#isMapOperation(PersistencePackage)}
   */
  @Test
  public void testIsMapOperation_givenPersistencePerspective_thenReturnFalse() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter = new CustomPersistenceHandlerAdapter();

    PersistencePackage pkg = new PersistencePackage();
    pkg.setPersistencePerspective(new PersistencePerspective());

    // Act and Assert
    assertFalse(customPersistenceHandlerAdapter.isMapOperation(pkg));
  }

  /**
   * Test
   * {@link CustomPersistenceHandlerAdapter#isAdornedListOperation(PersistencePackage)}.
   * <ul>
   *   <li>Given {@link PersistencePerspective#PersistencePerspective()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#isAdornedListOperation(PersistencePackage)}
   */
  @Test
  public void testIsAdornedListOperation_givenPersistencePerspective_thenReturnFalse() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter = new CustomPersistenceHandlerAdapter();

    PersistencePackage pkg = new PersistencePackage();
    pkg.setPersistencePerspective(new PersistencePerspective());

    // Act and Assert
    assertFalse(customPersistenceHandlerAdapter.isAdornedListOperation(pkg));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link CustomPersistenceHandlerAdapter}
   *   <li>{@link CustomPersistenceHandlerAdapter#getOrder()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(CustomPersistenceHandler.DEFAULT_ORDER, (new CustomPersistenceHandlerAdapter()).getOrder());
  }
}

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
import static org.junit.Assert.assertSame;
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
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testFetch() throws ServiceException {
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
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testAdd() throws ServiceException {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter = new CustomPersistenceHandlerAdapter();
    PersistencePackage persistencePackage = new PersistencePackage();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> customPersistenceHandlerAdapter.add(persistencePackage, dynamicEntityDao,
        new AdornedTargetListPersistenceModule()));
  }

  /**
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#remove(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testRemove() throws ServiceException {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter = new CustomPersistenceHandlerAdapter();
    PersistencePackage persistencePackage = new PersistencePackage();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> customPersistenceHandlerAdapter.remove(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
  }

  /**
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testUpdate() throws ServiceException {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter = new CustomPersistenceHandlerAdapter();
    PersistencePackage persistencePackage = new PersistencePackage();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> customPersistenceHandlerAdapter.update(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
  }

  /**
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#willHandleSecurity(PersistencePackage)}
   */
  @Test
  public void testWillHandleSecurity() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter = new CustomPersistenceHandlerAdapter();

    // Act and Assert
    assertFalse(customPersistenceHandlerAdapter.willHandleSecurity(new PersistencePackage()));
  }

  /**
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#willHandleSecurity(PersistencePackage)}
   */
  @Test
  public void testWillHandleSecurity2() {
    // Arrange
    AdminUserCustomPersistenceHandler adminUserCustomPersistenceHandler = new AdminUserCustomPersistenceHandler();

    // Act and Assert
    assertTrue(adminUserCustomPersistenceHandler.willHandleSecurity(new PersistencePackage()));
  }

  /**
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#getMetadata(PersistencePackage, InspectHelper)}
   */
  @Test
  public void testGetMetadata() throws ServiceException {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter = new CustomPersistenceHandlerAdapter();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    InspectHelper helper = mock(InspectHelper.class);
    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(stringFieldMetadataMap);

    // Act
    Map<String, FieldMetadata> actualMetadata = customPersistenceHandlerAdapter.getMetadata(persistencePackage, helper);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getPersistencePerspective();
    verify(helper).getSimpleMergedProperties(eq("Dr Jane Doe"), isA(PersistencePerspective.class));
    assertTrue(actualMetadata.isEmpty());
    assertSame(stringFieldMetadataMap, actualMetadata);
  }

  /**
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#getResultSet(PersistencePackage, InspectHelper, Map)}
   */
  @Test
  public void testGetResultSet() throws ServiceException {
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
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#getResultSet(PersistencePackage, InspectHelper, Map)}
   */
  @Test
  public void testGetResultSet2() throws ServiceException {
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
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#getPolymorphicClasses(Class, EntityManager, boolean)}
   */
  @Test
  public void testGetPolymorphicClasses() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter = new CustomPersistenceHandlerAdapter();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(0, customPersistenceHandlerAdapter.getPolymorphicClasses(clazz, null, true).length);
  }

  /**
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#getPolymorphicClasses(Class, EntityManager, boolean)}
   */
  @Test
  public void testGetPolymorphicClasses2() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter = new CustomPersistenceHandlerAdapter();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(0, customPersistenceHandlerAdapter.getPolymorphicClasses(clazz, null, true).length);
  }

  /**
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#getPolymorphicClasses(Class, EntityManager, boolean)}
   */
  @Test
  public void testGetPolymorphicClasses3() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter = new CustomPersistenceHandlerAdapter();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(0, customPersistenceHandlerAdapter.getPolymorphicClasses(clazz, null, false).length);
  }

  /**
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#getClassForName(String)}
   */
  @Test
  public void testGetClassForName() {
    // Arrange, Act and Assert
    assertNull(customPersistenceHandlerAdapter.getClassForName("Dr Jane Doe"));
  }

  /**
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#getClassForName(String)}
   */
  @Test
  public void testGetClassForName2() {
    // Arrange and Act
    Class actualClassForName = customPersistenceHandlerAdapter
        .getClassForName("org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManager");

    // Assert
    Class<PersistenceManager> expectedClassForName = PersistenceManager.class;
    assertEquals(expectedClassForName, actualClassForName);
  }

  /**
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#isAssignableFrom(String, Class)}
   */
  @Test
  public void testIsAssignableFrom() {
    // Arrange
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertFalse(customPersistenceHandlerAdapter.isAssignableFrom("Dr Jane Doe", targetClass));
  }

  /**
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#isAssignableFrom(String, Class)}
   */
  @Test
  public void testIsAssignableFrom2() {
    // Arrange
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertTrue(customPersistenceHandlerAdapter.isAssignableFrom(
        "org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManager", targetClass));
  }

  /**
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#meetsCustomCriteria(PersistencePackage, String[])}
   */
  @Test
  public void testMeetsCustomCriteria() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter = new CustomPersistenceHandlerAdapter();

    // Act and Assert
    assertFalse(
        customPersistenceHandlerAdapter.meetsCustomCriteria(new PersistencePackage(), new String[]{"Custom Criteria"}));
  }

  /**
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#meetsCustomCriteria(PersistencePackage, String[])}
   */
  @Test
  public void testMeetsCustomCriteria2() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter = new CustomPersistenceHandlerAdapter();
    Entity entity = new Entity();

    // Act and Assert
    assertTrue(customPersistenceHandlerAdapter.meetsCustomCriteria(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123"), new String[]{"Custom Criteria"}));
  }

  /**
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#meetsCustomCriteria(PersistencePackage, String[])}
   */
  @Test
  public void testMeetsCustomCriteria3() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter = new CustomPersistenceHandlerAdapter();

    PersistencePackage pkg = new PersistencePackage();
    pkg.addCustomCriteria("Criteria");

    // Act and Assert
    assertFalse(customPersistenceHandlerAdapter.meetsCustomCriteria(pkg, new String[]{"Custom Criteria"}));
  }

  /**
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#meetsCustomCriteria(PersistencePackage, String[])}
   */
  @Test
  public void testMeetsCustomCriteria4() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter = new CustomPersistenceHandlerAdapter();
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(customPersistenceHandlerAdapter.meetsCustomCriteria(
        new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(), new String[]{null}, "ABC123"),
        new String[]{"Custom Criteria"}));
  }

  /**
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#isBasicOperation(PersistencePackage)}
   */
  @Test
  public void testIsBasicOperation() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter = new CustomPersistenceHandlerAdapter();

    PersistencePackage pkg = new PersistencePackage();
    pkg.setPersistencePerspective(new PersistencePerspective());

    // Act and Assert
    assertTrue(customPersistenceHandlerAdapter.isBasicOperation(pkg));
  }

  /**
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#isMapOperation(PersistencePackage)}
   */
  @Test
  public void testIsMapOperation() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter = new CustomPersistenceHandlerAdapter();

    PersistencePackage pkg = new PersistencePackage();
    pkg.setPersistencePerspective(new PersistencePerspective());

    // Act and Assert
    assertFalse(customPersistenceHandlerAdapter.isMapOperation(pkg));
  }

  /**
   * Method under test:
   * {@link CustomPersistenceHandlerAdapter#isAdornedListOperation(PersistencePackage)}
   */
  @Test
  public void testIsAdornedListOperation() {
    // Arrange
    CustomPersistenceHandlerAdapter customPersistenceHandlerAdapter = new CustomPersistenceHandlerAdapter();

    PersistencePackage pkg = new PersistencePackage();
    pkg.setPersistencePerspective(new PersistencePerspective());

    // Act and Assert
    assertFalse(customPersistenceHandlerAdapter.isAdornedListOperation(pkg));
  }

  /**
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

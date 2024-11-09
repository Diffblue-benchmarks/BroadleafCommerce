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
package org.broadleafcommerce.openadmin.server.service.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.exception.NoPossibleResultsException;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.persistence.TargetModeType;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.common.presentation.client.PersistencePerspectiveItemType;
import org.broadleafcommerce.openadmin.dto.AdornedTargetList;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.ForeignKey;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.security.handler.AdminPermissionCustomPersistenceHandler;
import org.broadleafcommerce.openadmin.server.security.remote.AdminSecurityServiceRemote;
import org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier;
import org.broadleafcommerce.openadmin.server.service.handler.ClassCustomPersistenceHandlerAdapter;
import org.broadleafcommerce.openadmin.server.service.handler.CustomPersistenceHandler;
import org.broadleafcommerce.openadmin.server.service.handler.CustomPersistenceHandlerFilter;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.PersistenceModule;
import org.broadleafcommerce.openadmin.server.service.type.ChangeType;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;

public class PersistenceManagerImplDiffblueTest {
  /**
   * Test
   * {@link PersistenceManagerImpl#getAllPolymorphicEntitiesFromCeiling(Class)}.
   * <ul>
   *   <li>Then return array length is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#getAllPolymorphicEntitiesFromCeiling(Class)}
   */
  @Test
  public void testGetAllPolymorphicEntitiesFromCeiling_thenReturnArrayLengthIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    Class<Object> forNameResult = Object.class;
    when(dynamicEntityDao.getAllPolymorphicEntitiesFromCeiling(Mockito.<Class<Object>>any()))
        .thenReturn(new Class[]{forNameResult});

    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setDynamicEntityDao(dynamicEntityDao);
    Class<Object> ceilingClass = Object.class;

    // Act
    Class<?>[] actualAllPolymorphicEntitiesFromCeiling = persistenceManagerImpl
        .getAllPolymorphicEntitiesFromCeiling(ceilingClass);

    // Assert
    verify(dynamicEntityDao).getAllPolymorphicEntitiesFromCeiling(isA(Class.class));
    assertEquals(1, actualAllPolymorphicEntitiesFromCeiling.length);
    Class<Object> expectedResultClass = Object.class;
    assertEquals(expectedResultClass, actualAllPolymorphicEntitiesFromCeiling[0]);
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#getAllPolymorphicEntitiesFromCeiling(Class)}.
   * <ul>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#getAllPolymorphicEntitiesFromCeiling(Class)}
   */
  @Test
  public void testGetAllPolymorphicEntitiesFromCeiling_thenReturnArrayLengthIsZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setDynamicEntityDao(new DynamicEntityDaoImpl());
    Class<Object> ceilingClass = Object.class;

    // Act and Assert
    assertEquals(0, persistenceManagerImpl.getAllPolymorphicEntitiesFromCeiling(ceilingClass).length);
  }

  /**
   * Test {@link PersistenceManagerImpl#getUpDownInheritance(Class)} with
   * {@code testClass}.
   * <ul>
   *   <li>Then return array length is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistenceManagerImpl#getUpDownInheritance(Class)}
   */
  @Test
  public void testGetUpDownInheritanceWithTestClass_thenReturnArrayLengthIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    Class<Object> forNameResult = Object.class;
    when(dynamicEntityDao.getUpDownInheritance(Mockito.<Class<Object>>any())).thenReturn(new Class[]{forNameResult});

    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setDynamicEntityDao(dynamicEntityDao);
    Class<Object> testClass = Object.class;

    // Act
    Class<?>[] actualUpDownInheritance = persistenceManagerImpl.getUpDownInheritance(testClass);

    // Assert
    verify(dynamicEntityDao).getUpDownInheritance(isA(Class.class));
    assertEquals(1, actualUpDownInheritance.length);
    Class<Object> expectedResultClass = Object.class;
    assertEquals(expectedResultClass, actualUpDownInheritance[0]);
  }

  /**
   * Test {@link PersistenceManagerImpl#getUpDownInheritance(Class)} with
   * {@code testClass}.
   * <ul>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistenceManagerImpl#getUpDownInheritance(Class)}
   */
  @Test
  public void testGetUpDownInheritanceWithTestClass_thenReturnArrayLengthIsZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setDynamicEntityDao(new DynamicEntityDaoImpl());
    Class<Object> testClass = Object.class;

    // Act and Assert
    assertEquals(0, persistenceManagerImpl.getUpDownInheritance(testClass).length);
  }

  /**
   * Test {@link PersistenceManagerImpl#getUpDownInheritance(String)} with
   * {@code testClassname}.
   * <ul>
   *   <li>Then return array length is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#getUpDownInheritance(String)}
   */
  @Test
  public void testGetUpDownInheritanceWithTestClassname_thenReturnArrayLengthIsOne() throws ClassNotFoundException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    Class<Object> forNameResult = Object.class;
    when(dynamicEntityDao.getUpDownInheritance(Mockito.<Class<Object>>any())).thenReturn(new Class[]{forNameResult});

    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setDynamicEntityDao(dynamicEntityDao);

    // Act
    Class<?>[] actualUpDownInheritance = persistenceManagerImpl.getUpDownInheritance("java.lang.String");

    // Assert
    verify(dynamicEntityDao).getUpDownInheritance(isA(Class.class));
    assertEquals(1, actualUpDownInheritance.length);
    Class<Object> expectedResultClass = Object.class;
    assertEquals(expectedResultClass, actualUpDownInheritance[0]);
  }

  /**
   * Test {@link PersistenceManagerImpl#getUpDownInheritance(String)} with
   * {@code testClassname}.
   * <ul>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#getUpDownInheritance(String)}
   */
  @Test
  public void testGetUpDownInheritanceWithTestClassname_thenReturnArrayLengthIsZero() throws ClassNotFoundException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setDynamicEntityDao(new DynamicEntityDaoImpl());

    // Act and Assert
    assertEquals(0, persistenceManagerImpl.getUpDownInheritance("java.lang.String").length);
  }

  /**
   * Test {@link PersistenceManagerImpl#getPolymorphicEntities(String)}.
   * <ul>
   *   <li>Given {@code java.lang.Object}.</li>
   *   <li>Then return array length is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#getPolymorphicEntities(String)}
   */
  @Test
  public void testGetPolymorphicEntities_givenJavaLangObject_thenReturnArrayLengthIsOne()
      throws ClassNotFoundException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    Class<Object> forNameResult = Object.class;
    when(dynamicEntityDao.getAllPolymorphicEntitiesFromCeiling(Mockito.<Class<Object>>any()))
        .thenReturn(new Class[]{forNameResult});

    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setDynamicEntityDao(dynamicEntityDao);

    // Act
    Class<?>[] actualPolymorphicEntities = persistenceManagerImpl.getPolymorphicEntities("java.lang.String");

    // Assert
    verify(dynamicEntityDao).getAllPolymorphicEntitiesFromCeiling(isA(Class.class));
    assertEquals(1, actualPolymorphicEntities.length);
    Class<Object> expectedResultClass = Object.class;
    assertEquals(expectedResultClass, actualPolymorphicEntities[0]);
  }

  /**
   * Test {@link PersistenceManagerImpl#getPolymorphicEntities(String)}.
   * <ul>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#getPolymorphicEntities(String)}
   */
  @Test
  public void testGetPolymorphicEntities_thenReturnArrayLengthIsZero() throws ClassNotFoundException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setDynamicEntityDao(new DynamicEntityDaoImpl());

    // Act and Assert
    assertEquals(0, persistenceManagerImpl.getPolymorphicEntities("java.lang.String").length);
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#getSimpleMergedProperties(String, PersistencePerspective)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#getSimpleMergedProperties(String, PersistencePerspective)}
   */
  @Test
  public void testGetSimpleMergedProperties_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDao = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDao.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());

    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setDynamicEntityDao(dynamicEntityDao);

    // Act
    Map<String, FieldMetadata> actualSimpleMergedProperties = persistenceManagerImpl
        .getSimpleMergedProperties("Entity Name", new PersistencePerspective());

    // Assert
    verify(dynamicEntityDao).getSimpleMergedProperties(eq("Entity Name"), isA(PersistencePerspective.class));
    assertTrue(actualSimpleMergedProperties.isEmpty());
  }

  /**
   * Test {@link PersistenceManagerImpl#processMergedProperties(Class[], Map)}.
   * <ul>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#processMergedProperties(Class[], Map)}
   */
  @Test
  public void testProcessMergedProperties_thenReturnArrayLengthIsZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setModules(new PersistenceModule[]{new AdornedTargetListPersistenceModule()});
    Class<Object> forNameResult = Object.class;

    // Act and Assert
    assertEquals(0, persistenceManagerImpl.processMergedProperties(new Class[]{forNameResult}, new HashMap<>()).length);
  }

  /**
   * Test {@link PersistenceManagerImpl#getIdPropertyName(String)}.
   * <p>
   * Method under test: {@link PersistenceManagerImpl#getIdPropertyName(String)}
   */
  @Test
  public void testGetIdPropertyName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setDynamicEntityDao(new DynamicEntityDaoImpl());

    // Act and Assert
    assertNull(persistenceManagerImpl.getIdPropertyName("java.lang.String"));
  }

  /**
   * Test {@link PersistenceManagerImpl#getIdPropertyName(String)}.
   * <ul>
   *   <li>Given {@link DynamicEntityDao}
   * {@link DynamicEntityDao#getIdMetadata(Class)} return
   * {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistenceManagerImpl#getIdPropertyName(String)}
   */
  @Test
  public void testGetIdPropertyName_givenDynamicEntityDaoGetIdMetadataReturnHashMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());
    Class<Object> forNameResult = Object.class;
    when(dynamicEntityDao.getUpDownInheritance(Mockito.<Class<Object>>any())).thenReturn(new Class[]{forNameResult});

    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setDynamicEntityDao(dynamicEntityDao);

    // Act
    String actualIdPropertyName = persistenceManagerImpl.getIdPropertyName("java.lang.String");

    // Assert
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(dynamicEntityDao).getUpDownInheritance(isA(Class.class));
    assertNull(actualIdPropertyName);
  }

  /**
   * Test {@link PersistenceManagerImpl#getIdPropertyName(String)}.
   * <ul>
   *   <li>Given {@link DynamicEntityDao}
   * {@link DynamicEntityDao#getUpDownInheritance(Class)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistenceManagerImpl#getIdPropertyName(String)}
   */
  @Test
  public void testGetIdPropertyName_givenDynamicEntityDaoGetUpDownInheritanceReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getUpDownInheritance(Mockito.<Class<Object>>any())).thenReturn(null);

    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setDynamicEntityDao(dynamicEntityDao);

    // Act
    String actualIdPropertyName = persistenceManagerImpl.getIdPropertyName("java.lang.String");

    // Assert
    verify(dynamicEntityDao).getUpDownInheritance(isA(Class.class));
    assertNull(actualIdPropertyName);
  }

  /**
   * Test {@link PersistenceManagerImpl#getIdPropertyName(String)}.
   * <ul>
   *   <li>Then throw {@link NoPossibleResultsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistenceManagerImpl#getIdPropertyName(String)}
   */
  @Test
  public void testGetIdPropertyName_thenThrowNoPossibleResultsException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any()))
        .thenThrow(new NoPossibleResultsException("An error occurred"));
    Class<Object> forNameResult = Object.class;
    when(dynamicEntityDao.getUpDownInheritance(Mockito.<Class<Object>>any())).thenReturn(new Class[]{forNameResult});

    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setDynamicEntityDao(dynamicEntityDao);

    // Act and Assert
    assertThrows(NoPossibleResultsException.class, () -> persistenceManagerImpl.getIdPropertyName("java.lang.String"));
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    verify(dynamicEntityDao).getUpDownInheritance(isA(Class.class));
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#executePostFetchHandlers(PersistencePackage, CriteriaTransferObject, PersistenceResponse)}.
   * <ul>
   *   <li>Then throw {@link NoPossibleResultsException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#executePostFetchHandlers(PersistencePackage, CriteriaTransferObject, PersistenceResponse)}
   */
  @Test
  public void testExecutePostFetchHandlers_thenThrowNoPossibleResultsException() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getPersistencePerspectiveItems()).thenReturn(new HashMap<>());

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setSectionCrumbs(new SectionCrumb[]{sectionCrumb});
    persistencePackage.setPersistencePerspective(persistencePerspective);
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicResultSet dynamicResultSet = mock(DynamicResultSet.class);
    when(dynamicResultSet.getRecords()).thenThrow(new NoPossibleResultsException("An error occurred"));
    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getDynamicResultSet()).thenReturn(dynamicResultSet);

    // Act and Assert
    assertThrows(NoPossibleResultsException.class,
        () -> persistenceManagerImpl.executePostFetchHandlers(persistencePackage, cto, persistenceResponse));
    verify(dynamicResultSet).getRecords();
    verify(persistencePerspective).getPersistencePerspectiveItems();
    verify(persistenceResponse).getDynamicResultSet();
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#postFetchValidation(PersistencePackage, PersistenceResponse)}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#postFetchValidation(PersistencePackage, PersistenceResponse)}
   */
  @Test
  public void testPostFetchValidation() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getPersistencePerspective()).thenReturn(persistencePerspective);
    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getDynamicResultSet()).thenReturn(new DynamicResultSet());

    // Act
    persistenceManagerImpl.postFetchValidation(persistencePackage, persistenceResponse);

    // Assert
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(persistenceResponse).getDynamicResultSet();
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#postFetchValidation(PersistencePackage, PersistenceResponse)}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#postFetchValidation(PersistencePackage, PersistenceResponse)}
   */
  @Test
  public void testPostFetchValidation2() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.MAPSTRUCTURE,
        new AdornedTargetList());

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getPersistencePerspective()).thenReturn(persistencePerspective);
    DynamicResultSet dynamicResultSet = mock(DynamicResultSet.class);
    when(dynamicResultSet.getRecords()).thenReturn(new Entity[]{new Entity()});
    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getDynamicResultSet()).thenReturn(dynamicResultSet);

    // Act
    persistenceManagerImpl.postFetchValidation(persistencePackage, persistenceResponse);

    // Assert
    verify(dynamicResultSet, atLeast(1)).getRecords();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(persistenceResponse).getDynamicResultSet();
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#postFetchValidation(PersistencePackage, PersistenceResponse)}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#postFetchValidation(PersistencePackage, PersistenceResponse)}
   */
  @Test
  public void testPostFetchValidation3() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    DynamicResultSet dynamicResultSet = mock(DynamicResultSet.class);
    when(dynamicResultSet.getRecords()).thenThrow(new NoPossibleResultsException("An error occurred"));
    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getDynamicResultSet()).thenReturn(dynamicResultSet);

    // Act and Assert
    assertThrows(NoPossibleResultsException.class,
        () -> persistenceManagerImpl.postFetchValidation(persistencePackage, persistenceResponse));
    verify(dynamicResultSet).getRecords();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(persistenceResponse).getDynamicResultSet();
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#postFetchValidation(PersistencePackage, PersistenceResponse)}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#postFetchValidation(PersistencePackage, PersistenceResponse)}
   */
  @Test
  public void testPostFetchValidation4() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.MAPSTRUCTURE,
        new AdornedTargetList());

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getPersistencePerspective()).thenReturn(persistencePerspective);
    DynamicResultSet dynamicResultSet = mock(DynamicResultSet.class);
    when(dynamicResultSet.getRecords()).thenReturn(new Entity[]{new Entity()});
    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getDynamicResultSet()).thenReturn(dynamicResultSet);

    // Act
    persistenceManagerImpl.postFetchValidation(persistencePackage, persistenceResponse);

    // Assert
    verify(dynamicResultSet, atLeast(1)).getRecords();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(persistenceResponse).getDynamicResultSet();
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#postFetchValidation(PersistencePackage, PersistenceResponse)}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#postFetchValidation(PersistencePackage, PersistenceResponse)}
   */
  @Test
  public void testPostFetchValidation5() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.MAPSTRUCTURE, new ForeignKey());

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getPersistencePerspective()).thenReturn(persistencePerspective);
    DynamicResultSet dynamicResultSet = mock(DynamicResultSet.class);
    when(dynamicResultSet.getRecords()).thenReturn(new Entity[]{new Entity()});
    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getDynamicResultSet()).thenReturn(dynamicResultSet);

    // Act
    persistenceManagerImpl.postFetchValidation(persistencePackage, persistenceResponse);

    // Assert
    verify(dynamicResultSet, atLeast(1)).getRecords();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(persistenceResponse).getDynamicResultSet();
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#postFetchValidation(PersistencePackage, PersistenceResponse)}.
   * <ul>
   *   <li>Given {@link DynamicResultSet#DynamicResultSet()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#postFetchValidation(PersistencePackage, PersistenceResponse)}
   */
  @Test
  public void testPostFetchValidation_givenDynamicResultSet() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getDynamicResultSet()).thenReturn(new DynamicResultSet());

    // Act
    persistenceManagerImpl.postFetchValidation(persistencePackage, persistenceResponse);

    // Assert
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(persistenceResponse).getDynamicResultSet();
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#postFetchValidation(PersistencePackage, PersistenceResponse)}.
   * <ul>
   *   <li>Given {@link DynamicResultSet} {@link DynamicResultSet#getRecords()}
   * return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#postFetchValidation(PersistencePackage, PersistenceResponse)}
   */
  @Test
  public void testPostFetchValidation_givenDynamicResultSetGetRecordsReturnNull() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.MAPSTRUCTURE,
        mock(ForeignKey.class));

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getPersistencePerspective()).thenReturn(persistencePerspective);
    DynamicResultSet dynamicResultSet = mock(DynamicResultSet.class);
    when(dynamicResultSet.getRecords()).thenReturn(null);
    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getDynamicResultSet()).thenReturn(dynamicResultSet);

    // Act
    persistenceManagerImpl.postFetchValidation(persistencePackage, persistenceResponse);

    // Assert
    verify(dynamicResultSet).getRecords();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(persistenceResponse).getDynamicResultSet();
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#postFetchValidation(PersistencePackage, PersistenceResponse)}.
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#getPMap()} return
   * {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link Entity#getPMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#postFetchValidation(PersistencePackage, PersistenceResponse)}
   */
  @Test
  public void testPostFetchValidation_givenEntityGetPMapReturnHashMap_thenCallsGetPMap() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    ForeignKey item = mock(ForeignKey.class);
    when(item.getManyToField()).thenThrow(new NoPossibleResultsException("An error occurred"));

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.MAPSTRUCTURE, item);

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getPersistencePerspective()).thenReturn(persistencePerspective);
    Entity entity = mock(Entity.class);
    when(entity.getPMap()).thenReturn(new HashMap<>());
    DynamicResultSet dynamicResultSet = mock(DynamicResultSet.class);
    when(dynamicResultSet.getRecords()).thenReturn(new Entity[]{entity});
    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getDynamicResultSet()).thenReturn(dynamicResultSet);

    // Act and Assert
    assertThrows(NoPossibleResultsException.class,
        () -> persistenceManagerImpl.postFetchValidation(persistencePackage, persistenceResponse));
    verify(dynamicResultSet, atLeast(1)).getRecords();
    verify(entity).getPMap();
    verify(item).getManyToField();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(persistenceResponse).getDynamicResultSet();
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#postFetchValidation(PersistencePackage, PersistenceResponse)}.
   * <ul>
   *   <li>Given {@link PersistencePerspective#PersistencePerspective()}.</li>
   *   <li>When {@link PersistenceResponse} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#postFetchValidation(PersistencePackage, PersistenceResponse)}
   */
  @Test
  public void testPostFetchValidation_givenPersistencePerspective_whenPersistenceResponse() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());

    // Act
    persistenceManagerImpl.postFetchValidation(persistencePackage, new PersistenceResponse());

    // Assert
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#postFetchValidation(PersistencePackage, PersistenceResponse)}.
   * <ul>
   *   <li>Then calls {@link ForeignKey#getManyToField()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#postFetchValidation(PersistencePackage, PersistenceResponse)}
   */
  @Test
  public void testPostFetchValidation_thenCallsGetManyToField() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    ForeignKey item = mock(ForeignKey.class);
    when(item.getManyToField()).thenThrow(new NoPossibleResultsException("An error occurred"));

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.MAPSTRUCTURE, item);

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getPersistencePerspective()).thenReturn(persistencePerspective);
    DynamicResultSet dynamicResultSet = mock(DynamicResultSet.class);
    when(dynamicResultSet.getRecords()).thenReturn(new Entity[]{new Entity()});
    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getDynamicResultSet()).thenReturn(dynamicResultSet);

    // Act and Assert
    assertThrows(NoPossibleResultsException.class,
        () -> persistenceManagerImpl.postFetchValidation(persistencePackage, persistenceResponse));
    verify(dynamicResultSet, atLeast(1)).getRecords();
    verify(item).getManyToField();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(persistenceResponse).getDynamicResultSet();
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#postFetch(DynamicResultSet, PersistencePackage, CriteriaTransferObject)}.
   * <ul>
   *   <li>When {@link DynamicResultSet#DynamicResultSet()}.</li>
   *   <li>Then return {@link DynamicResultSet#DynamicResultSet()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#postFetch(DynamicResultSet, PersistencePackage, CriteriaTransferObject)}
   */
  @Test
  public void testPostFetch_whenDynamicResultSet_thenReturnDynamicResultSet() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    DynamicResultSet resultSet = new DynamicResultSet();
    PersistencePackage persistencePackage = new PersistencePackage();

    // Act and Assert
    assertSame(resultSet,
        persistenceManagerImpl.postFetch(resultSet, persistencePackage, new CriteriaTransferObject()));
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#postFetch(DynamicResultSet, PersistencePackage, CriteriaTransferObject)}.
   * <ul>
   *   <li>When {@link DynamicResultSet}.</li>
   *   <li>Then return {@link DynamicResultSet}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#postFetch(DynamicResultSet, PersistencePackage, CriteriaTransferObject)}
   */
  @Test
  public void testPostFetch_whenDynamicResultSet_thenReturnDynamicResultSet2() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    DynamicResultSet resultSet = mock(DynamicResultSet.class);
    PersistencePackage persistencePackage = new PersistencePackage();

    // Act and Assert
    assertSame(resultSet,
        persistenceManagerImpl.postFetch(resultSet, persistencePackage, new CriteriaTransferObject()));
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#executePostAddHandlers(PersistencePackage, PersistenceResponse)}.
   * <ul>
   *   <li>Then throw {@link NoPossibleResultsException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#executePostAddHandlers(PersistencePackage, PersistenceResponse)}
   */
  @Test
  public void testExecutePostAddHandlers_thenThrowNoPossibleResultsException() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDao = mock(DynamicEntityDaoImpl.class);
    doNothing().when(dynamicEntityDao).flush();

    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setDynamicEntityDao(dynamicEntityDao);
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getRequestingEntityName()).thenReturn("");
    Property property = mock(Property.class);
    when(property.getValue()).thenThrow(new NoPossibleResultsException("An error occurred"));

    HashMap<String, Property> stringPropertyMap = new HashMap<>();
    stringPropertyMap.put("__adminMainEntity", property);
    Entity entity = mock(Entity.class);
    when(entity.getPMap()).thenReturn(stringPropertyMap);
    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getEntity()).thenReturn(entity);

    // Act and Assert
    assertThrows(NoPossibleResultsException.class,
        () -> persistenceManagerImpl.executePostAddHandlers(persistencePackage, persistenceResponse));
    verify(entity).getPMap();
    verify(persistencePackage).getRequestingEntityName();
    verify(property).getValue();
    verify(dynamicEntityDao).flush();
    verify(persistenceResponse).getEntity();
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#executeDeferredOperations(PersistencePackage)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code ADD} is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#executeDeferredOperations(PersistencePackage)}
   */
  @Test
  public void testExecuteDeferredOperations_givenHashMapAddIsArrayList() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();

    HashMap<ChangeType, List<PersistencePackage>> changeTypeListMap = new HashMap<>();
    changeTypeListMap.put(ChangeType.ADD, new ArrayList<>());
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getDeferredOperations()).thenReturn(changeTypeListMap);
    when(persistencePackage.getSubPackages()).thenReturn(new HashMap<>());

    // Act
    persistenceManagerImpl.executeDeferredOperations(persistencePackage);

    // Assert
    verify(persistencePackage, atLeast(1)).getDeferredOperations();
    verify(persistencePackage).getSubPackages();
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#executeDeferredOperations(PersistencePackage)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link PersistencePackage#getDeferredOperations()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#executeDeferredOperations(PersistencePackage)}
   */
  @Test
  public void testExecuteDeferredOperations_givenHashMap_thenCallsGetDeferredOperations() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getDeferredOperations()).thenReturn(new HashMap<>());
    when(persistencePackage.getSubPackages()).thenReturn(new HashMap<>());

    // Act
    persistenceManagerImpl.executeDeferredOperations(persistencePackage);

    // Assert
    verify(persistencePackage).getDeferredOperations();
    verify(persistencePackage).getSubPackages();
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#executeDeferredOperations(PersistencePackage)}.
   * <ul>
   *   <li>Then calls {@link PersistencePackage#getDeferredOperations()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#executeDeferredOperations(PersistencePackage)}
   */
  @Test
  public void testExecuteDeferredOperations_thenCallsGetDeferredOperations() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();

    HashMap<String, PersistencePackage> stringPersistencePackageMap = new HashMap<>();
    stringPersistencePackageMap.put("foo", new PersistencePackage());
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getDeferredOperations()).thenReturn(new HashMap<>());
    when(persistencePackage.getSubPackages()).thenReturn(stringPersistencePackageMap);

    // Act
    persistenceManagerImpl.executeDeferredOperations(persistencePackage);

    // Assert
    verify(persistencePackage).getDeferredOperations();
    verify(persistencePackage).getSubPackages();
  }

  /**
   * Test {@link PersistenceManagerImpl#postAdd(Entity, PersistencePackage)}.
   * <ul>
   *   <li>When {@link Entity} (default constructor).</li>
   *   <li>Then return {@link Entity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#postAdd(Entity, PersistencePackage)}
   */
  @Test
  public void testPostAdd_whenEntity_thenReturnEntity() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    Entity entity = new Entity();

    // Act and Assert
    assertSame(entity, persistenceManagerImpl.postAdd(entity, new PersistencePackage()));
  }

  /**
   * Test {@link PersistenceManagerImpl#postAdd(Entity, PersistencePackage)}.
   * <ul>
   *   <li>When {@link Entity}.</li>
   *   <li>Then return {@link Entity}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#postAdd(Entity, PersistencePackage)}
   */
  @Test
  public void testPostAdd_whenEntity_thenReturnEntity2() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    Entity entity = mock(Entity.class);

    // Act and Assert
    assertSame(entity, persistenceManagerImpl.postAdd(entity, new PersistencePackage()));
  }

  /**
   * Test {@link PersistenceManagerImpl#logValidationError(Entity)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link Entity#getPropertyValidationErrors()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistenceManagerImpl#logValidationError(Entity)}
   */
  @Test
  public void testLogValidationError_givenHashMap_thenCallsGetPropertyValidationErrors() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    Entity response = mock(Entity.class);
    when(response.getPropertyValidationErrors()).thenReturn(new HashMap<>());

    // Act
    persistenceManagerImpl.logValidationError(response);

    // Assert
    verify(response).getPropertyValidationErrors();
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#executePostUpdateHandlers(PersistencePackage, PersistenceResponse)}.
   * <ul>
   *   <li>Then throw {@link NoPossibleResultsException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#executePostUpdateHandlers(PersistencePackage, PersistenceResponse)}
   */
  @Test
  public void testExecutePostUpdateHandlers_thenThrowNoPossibleResultsException() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDao = mock(DynamicEntityDaoImpl.class);
    doNothing().when(dynamicEntityDao).flush();

    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setDynamicEntityDao(dynamicEntityDao);
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getRequestingEntityName()).thenReturn("");
    Property property = mock(Property.class);
    when(property.getValue()).thenThrow(new NoPossibleResultsException("An error occurred"));

    HashMap<String, Property> stringPropertyMap = new HashMap<>();
    stringPropertyMap.put("__adminMainEntity", property);
    Entity entity = mock(Entity.class);
    when(entity.getPMap()).thenReturn(stringPropertyMap);
    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getEntity()).thenReturn(entity);

    // Act and Assert
    assertThrows(NoPossibleResultsException.class,
        () -> persistenceManagerImpl.executePostUpdateHandlers(persistencePackage, persistenceResponse));
    verify(entity).getPMap();
    verify(persistencePackage).getRequestingEntityName();
    verify(property).getValue();
    verify(dynamicEntityDao).flush();
    verify(persistenceResponse).getEntity();
  }

  /**
   * Test {@link PersistenceManagerImpl#postUpdate(Entity, PersistencePackage)}.
   * <ul>
   *   <li>When {@link Entity} (default constructor).</li>
   *   <li>Then return {@link Entity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#postUpdate(Entity, PersistencePackage)}
   */
  @Test
  public void testPostUpdate_whenEntity_thenReturnEntity() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    Entity entity = new Entity();

    // Act and Assert
    assertSame(entity, persistenceManagerImpl.postUpdate(entity, new PersistencePackage()));
  }

  /**
   * Test {@link PersistenceManagerImpl#postUpdate(Entity, PersistencePackage)}.
   * <ul>
   *   <li>When {@link Entity}.</li>
   *   <li>Then return {@link Entity}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#postUpdate(Entity, PersistencePackage)}
   */
  @Test
  public void testPostUpdate_whenEntity_thenReturnEntity2() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    Entity entity = mock(Entity.class);

    // Act and Assert
    assertSame(entity, persistenceManagerImpl.postUpdate(entity, new PersistencePackage()));
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#executePostRemoveHandlers(PersistencePackage, PersistenceResponse)}.
   * <ul>
   *   <li>Then throw {@link NoPossibleResultsException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#executePostRemoveHandlers(PersistencePackage, PersistenceResponse)}
   */
  @Test
  public void testExecutePostRemoveHandlers_thenThrowNoPossibleResultsException() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDao = mock(DynamicEntityDaoImpl.class);
    doNothing().when(dynamicEntityDao).flush();

    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setDynamicEntityDao(dynamicEntityDao);
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getRequestingEntityName()).thenReturn("");
    Property property = mock(Property.class);
    when(property.getValue()).thenThrow(new NoPossibleResultsException("An error occurred"));

    HashMap<String, Property> stringPropertyMap = new HashMap<>();
    stringPropertyMap.put("__adminMainEntity", property);
    Entity entity = mock(Entity.class);
    when(entity.getPMap()).thenReturn(stringPropertyMap);
    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getEntity()).thenReturn(entity);

    // Act and Assert
    assertThrows(NoPossibleResultsException.class,
        () -> persistenceManagerImpl.executePostRemoveHandlers(persistencePackage, persistenceResponse));
    verify(entity).getPMap();
    verify(persistencePackage).getRequestingEntityName();
    verify(property).getValue();
    verify(dynamicEntityDao).flush();
    verify(persistenceResponse).getEntity();
  }

  /**
   * Test {@link PersistenceManagerImpl#getCompatibleModule(OperationType)}.
   * <ul>
   *   <li>Then calls
   * {@link AdornedTargetListPersistenceModule#isCompatible(OperationType)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#getCompatibleModule(OperationType)}
   */
  @Test
  public void testGetCompatibleModule_thenCallsIsCompatible() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.isCompatible(Mockito.<OperationType>any())).thenReturn(true);

    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setModules(new PersistenceModule[]{adornedTargetListPersistenceModule});

    // Act
    persistenceManagerImpl.getCompatibleModule(OperationType.NONDESTRUCTIVEREMOVE);

    // Assert
    verify(adornedTargetListPersistenceModule).isCompatible(eq(OperationType.NONDESTRUCTIVEREMOVE));
  }

  /**
   * Test {@link PersistenceManagerImpl#getCompatibleModule(OperationType)}.
   * <ul>
   *   <li>Then return {@link BasicPersistenceModule} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#getCompatibleModule(OperationType)}
   */
  @Test
  public void testGetCompatibleModule_thenReturnBasicPersistenceModule() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    persistenceManagerImpl.setModules(new PersistenceModule[]{basicPersistenceModule});

    // Act and Assert
    assertSame(basicPersistenceModule, persistenceManagerImpl.getCompatibleModule(OperationType.NONDESTRUCTIVEREMOVE));
  }

  /**
   * Test {@link PersistenceManagerImpl#getCompatibleModule(OperationType)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#getCompatibleModule(OperationType)}
   */
  @Test
  public void testGetCompatibleModule_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setModules(new PersistenceModule[]{new AdornedTargetListPersistenceModule()});

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> persistenceManagerImpl.getCompatibleModule(OperationType.NONDESTRUCTIVEREMOVE));
  }

  /**
   * Test {@link PersistenceManagerImpl#getCustomPersistenceHandlers()}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#getCustomPersistenceHandlers()}
   */
  @Test
  public void testGetCustomPersistenceHandlers() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setCustomPersistenceHandlerFilters(null);

    // Act and Assert
    assertTrue(persistenceManagerImpl.getCustomPersistenceHandlers().isEmpty());
  }

  /**
   * Test {@link PersistenceManagerImpl#getCustomPersistenceHandlers()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link CustomPersistenceHandlerFilter}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#getCustomPersistenceHandlers()}
   */
  @Test
  public void testGetCustomPersistenceHandlers_givenArrayListAddCustomPersistenceHandlerFilter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<CustomPersistenceHandlerFilter> customPersistenceHandlerFilters = new ArrayList<>();
    customPersistenceHandlerFilters.add(mock(CustomPersistenceHandlerFilter.class));

    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setCustomPersistenceHandlerFilters(customPersistenceHandlerFilters);

    // Act and Assert
    assertTrue(persistenceManagerImpl.getCustomPersistenceHandlers().isEmpty());
  }

  /**
   * Test {@link PersistenceManagerImpl#getCustomPersistenceHandlers()}.
   * <ul>
   *   <li>Given {@link PersistenceManagerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#getCustomPersistenceHandlers()}
   */
  @Test
  public void testGetCustomPersistenceHandlers_givenPersistenceManagerImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new PersistenceManagerImpl()).getCustomPersistenceHandlers().isEmpty());
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#setMainEntityName(PersistencePackage, Entity)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code __adminMainEntity} is
   * {@link Property#Property()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#setMainEntityName(PersistencePackage, Entity)}
   */
  @Test
  public void testSetMainEntityName_givenHashMapAdminMainEntityIsProperty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();

    PersistencePackage pp = new PersistencePackage();
    pp.setRequestingEntityName(null);

    HashMap<String, Property> stringPropertyMap = new HashMap<>();
    stringPropertyMap.put("__adminMainEntity", new Property());
    Entity entity = mock(Entity.class);
    when(entity.getPMap()).thenReturn(stringPropertyMap);

    // Act
    persistenceManagerImpl.setMainEntityName(pp, entity);

    // Assert
    verify(entity).getPMap();
    assertNull(pp.getRequestingEntityName());
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#setMainEntityName(PersistencePackage, Entity)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>When {@link Entity} {@link Entity#getPMap()} return
   * {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#setMainEntityName(PersistencePackage, Entity)}
   */
  @Test
  public void testSetMainEntityName_givenHashMap_whenEntityGetPMapReturnHashMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();

    PersistencePackage pp = new PersistencePackage();
    pp.setRequestingEntityName(null);
    Entity entity = mock(Entity.class);
    when(entity.getPMap()).thenReturn(new HashMap<>());

    // Act
    persistenceManagerImpl.setMainEntityName(pp, entity);

    // Assert
    verify(entity).getPMap();
    assertNull(pp.getRequestingEntityName());
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#setMainEntityName(PersistencePackage, Entity)}.
   * <ul>
   *   <li>Given {@code Pp}.</li>
   *   <li>Then {@link PersistencePackage#PersistencePackage()} RequestingEntityName
   * is {@code Pp}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#setMainEntityName(PersistencePackage, Entity)}
   */
  @Test
  public void testSetMainEntityName_givenPp_thenPersistencePackageRequestingEntityNameIsPp() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();

    PersistencePackage pp = new PersistencePackage();
    pp.setRequestingEntityName("Pp");

    // Act
    persistenceManagerImpl.setMainEntityName(pp, null);

    // Assert that nothing has changed
    assertEquals("Pp", pp.getRequestingEntityName());
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#setMainEntityName(PersistencePackage, Entity)}.
   * <ul>
   *   <li>Given {@code Requesting Entity Name}.</li>
   *   <li>Then calls {@link PersistencePackage#getRequestingEntityName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#setMainEntityName(PersistencePackage, Entity)}
   */
  @Test
  public void testSetMainEntityName_givenRequestingEntityName_thenCallsGetRequestingEntityName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    PersistencePackage pp = mock(PersistencePackage.class);
    when(pp.getRequestingEntityName()).thenReturn("Requesting Entity Name");

    // Act
    persistenceManagerImpl.setMainEntityName(pp, new Entity());

    // Assert
    verify(pp).getRequestingEntityName();
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#setMainEntityName(PersistencePackage, Entity)}.
   * <ul>
   *   <li>Then {@link PersistencePackage#PersistencePackage()} RequestingEntityName
   * is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#setMainEntityName(PersistencePackage, Entity)}
   */
  @Test
  public void testSetMainEntityName_thenPersistencePackageRequestingEntityNameIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();

    PersistencePackage pp = new PersistencePackage();
    pp.setRequestingEntityName(null);
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    HashMap<String, Property> stringPropertyMap = new HashMap<>();
    stringPropertyMap.put("__adminMainEntity", property);
    Entity entity = mock(Entity.class);
    when(entity.getPMap()).thenReturn(stringPropertyMap);

    // Act
    persistenceManagerImpl.setMainEntityName(pp, entity);

    // Assert
    verify(entity).getPMap();
    verify(property).getValue();
    assertEquals("42", pp.getRequestingEntityName());
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#setMainEntityName(PersistencePackage, Entity)}.
   * <ul>
   *   <li>Then throw {@link NoPossibleResultsException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#setMainEntityName(PersistencePackage, Entity)}
   */
  @Test
  public void testSetMainEntityName_thenThrowNoPossibleResultsException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();

    PersistencePackage pp = new PersistencePackage();
    pp.setRequestingEntityName(null);
    Property property = mock(Property.class);
    when(property.getValue()).thenThrow(new NoPossibleResultsException("An error occurred"));

    HashMap<String, Property> stringPropertyMap = new HashMap<>();
    stringPropertyMap.put("__adminMainEntity", property);
    Entity entity = mock(Entity.class);
    when(entity.getPMap()).thenReturn(stringPropertyMap);

    // Act and Assert
    assertThrows(NoPossibleResultsException.class, () -> persistenceManagerImpl.setMainEntityName(pp, entity));
    verify(entity).getPMap();
    verify(property).getValue();
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#setMainEntityName(PersistencePackage, Entity)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PersistencePackage#PersistencePackage()} RequestingEntityName
   * is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#setMainEntityName(PersistencePackage, Entity)}
   */
  @Test
  public void testSetMainEntityName_whenNull_thenPersistencePackageRequestingEntityNameIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();

    PersistencePackage pp = new PersistencePackage();
    pp.setRequestingEntityName(null);

    // Act
    persistenceManagerImpl.setMainEntityName(pp, null);

    // Assert that nothing has changed
    assertNull(pp.getRequestingEntityName());
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#setMainEntityName(PersistencePackage, Entity)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#setMainEntityName(PersistencePackage, Entity)}
   */
  @Test
  public void testSetMainEntityName_whenPersistencePackage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    PersistencePackage pp = new PersistencePackage();

    // Act
    persistenceManagerImpl.setMainEntityName(pp, new Entity());

    // Assert
    assertNull(pp.getRequestingEntityName());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PersistenceManagerImpl#setAdminRemoteSecurityService(AdminSecurityServiceRemote)}
   *   <li>{@link PersistenceManagerImpl#setApplicationContext(ApplicationContext)}
   *   <li>{@link PersistenceManagerImpl#setCustomPersistenceHandlerFilters(List)}
   *   <li>{@link PersistenceManagerImpl#setCustomPersistenceHandlers(List)}
   *   <li>{@link PersistenceManagerImpl#setDynamicEntityDao(DynamicEntityDao)}
   *   <li>{@link PersistenceManagerImpl#setModules(PersistenceModule[])}
   *   <li>{@link PersistenceManagerImpl#setTargetMode(TargetModeType)}
   *   <li>{@link PersistenceManagerImpl#getAdminRemoteSecurityService()}
   *   <li>{@link PersistenceManagerImpl#getCustomPersistenceHandlerFilters()}
   *   <li>{@link PersistenceManagerImpl#getDynamicEntityDao()}
   *   <li>{@link PersistenceManagerImpl#getModules()}
   *   <li>{@link PersistenceManagerImpl#getTargetMode()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws BeansException {
    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    AdminSecurityServiceRemote adminRemoteSecurityService = new AdminSecurityServiceRemote();

    // Act
    persistenceManagerImpl.setAdminRemoteSecurityService(adminRemoteSecurityService);
    persistenceManagerImpl.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());
    ArrayList<CustomPersistenceHandlerFilter> customPersistenceHandlerFilters = new ArrayList<>();
    persistenceManagerImpl.setCustomPersistenceHandlerFilters(customPersistenceHandlerFilters);
    persistenceManagerImpl.setCustomPersistenceHandlers(new ArrayList<>());
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    persistenceManagerImpl.setDynamicEntityDao(dynamicEntityDao);
    PersistenceModule[] modules = new PersistenceModule[]{new AdornedTargetListPersistenceModule()};
    persistenceManagerImpl.setModules(modules);
    TargetModeType targetMode = new TargetModeType("Type", "Friendly Type");

    persistenceManagerImpl.setTargetMode(targetMode);
    SecurityVerifier actualAdminRemoteSecurityService = persistenceManagerImpl.getAdminRemoteSecurityService();
    List<CustomPersistenceHandlerFilter> actualCustomPersistenceHandlerFilters = persistenceManagerImpl
        .getCustomPersistenceHandlerFilters();
    DynamicEntityDao actualDynamicEntityDao = persistenceManagerImpl.getDynamicEntityDao();
    PersistenceModule[] actualModules = persistenceManagerImpl.getModules();
    TargetModeType actualTargetMode = persistenceManagerImpl.getTargetMode();

    // Assert that nothing has changed
    assertTrue(actualCustomPersistenceHandlerFilters.isEmpty());
    assertSame(customPersistenceHandlerFilters, actualCustomPersistenceHandlerFilters);
    assertSame(targetMode, actualTargetMode);
    assertSame(dynamicEntityDao, actualDynamicEntityDao);
    assertSame(adminRemoteSecurityService, actualAdminRemoteSecurityService);
    assertSame(modules, actualModules);
  }

  /**
   * Test {@link PersistenceManagerImpl#honorExplicitPersistenceHandlerSorting()}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#honorExplicitPersistenceHandlerSorting()}
   */
  @Test
  public void testHonorExplicitPersistenceHandlerSorting() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<CustomPersistenceHandler> customPersistenceHandlers = new ArrayList<>();
    AdminPermissionCustomPersistenceHandler adminPermissionCustomPersistenceHandler = new AdminPermissionCustomPersistenceHandler();
    customPersistenceHandlers.add(adminPermissionCustomPersistenceHandler);

    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setCustomPersistenceHandlers(customPersistenceHandlers);

    // Act
    persistenceManagerImpl.honorExplicitPersistenceHandlerSorting();

    // Assert
    assertEquals(1, persistenceManagerImpl.getCustomPersistenceHandlers().size());
    List<CustomPersistenceHandler> customPersistenceHandlerList = persistenceManagerImpl.customPersistenceHandlers;
    assertEquals(1, customPersistenceHandlerList.size());
    assertSame(adminPermissionCustomPersistenceHandler, customPersistenceHandlerList.get(0));
  }

  /**
   * Test {@link PersistenceManagerImpl#honorExplicitPersistenceHandlerSorting()}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#honorExplicitPersistenceHandlerSorting()}
   */
  @Test
  public void testHonorExplicitPersistenceHandlerSorting2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ClassCustomPersistenceHandlerAdapter classCustomPersistenceHandlerAdapter = mock(
        ClassCustomPersistenceHandlerAdapter.class);
    when(classCustomPersistenceHandlerAdapter.getOrder()).thenReturn(1);

    ArrayList<CustomPersistenceHandler> customPersistenceHandlers = new ArrayList<>();
    customPersistenceHandlers.add(classCustomPersistenceHandlerAdapter);

    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setCustomPersistenceHandlers(customPersistenceHandlers);

    // Act
    persistenceManagerImpl.honorExplicitPersistenceHandlerSorting();

    // Assert
    verify(classCustomPersistenceHandlerAdapter).getOrder();
    assertTrue(persistenceManagerImpl.getCustomPersistenceHandlers().isEmpty());
    assertTrue(persistenceManagerImpl.customPersistenceHandlers.isEmpty());
  }

  /**
   * Test {@link PersistenceManagerImpl#honorExplicitPersistenceHandlerSorting()}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#honorExplicitPersistenceHandlerSorting()}
   */
  @Test
  public void testHonorExplicitPersistenceHandlerSorting3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ClassCustomPersistenceHandlerAdapter classCustomPersistenceHandlerAdapter = mock(
        ClassCustomPersistenceHandlerAdapter.class);
    when(classCustomPersistenceHandlerAdapter.getOrder()).thenReturn(1);

    ArrayList<CustomPersistenceHandler> customPersistenceHandlers = new ArrayList<>();
    AdminPermissionCustomPersistenceHandler adminPermissionCustomPersistenceHandler = new AdminPermissionCustomPersistenceHandler();
    customPersistenceHandlers.add(adminPermissionCustomPersistenceHandler);
    customPersistenceHandlers.add(classCustomPersistenceHandlerAdapter);

    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setCustomPersistenceHandlers(customPersistenceHandlers);

    // Act
    persistenceManagerImpl.honorExplicitPersistenceHandlerSorting();

    // Assert
    verify(classCustomPersistenceHandlerAdapter, atLeast(1)).getOrder();
    List<CustomPersistenceHandler> customPersistenceHandlerList = persistenceManagerImpl.customPersistenceHandlers;
    assertEquals(2, customPersistenceHandlerList.size());
    List<CustomPersistenceHandler> expectedCustomPersistenceHandlers = persistenceManagerImpl.customPersistenceHandlers;
    assertEquals(expectedCustomPersistenceHandlers, persistenceManagerImpl.getCustomPersistenceHandlers());
    assertSame(adminPermissionCustomPersistenceHandler, customPersistenceHandlerList.get(1));
  }

  /**
   * Test {@link PersistenceManagerImpl#honorExplicitPersistenceHandlerSorting()}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#honorExplicitPersistenceHandlerSorting()}
   */
  @Test
  public void testHonorExplicitPersistenceHandlerSorting4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ClassCustomPersistenceHandlerAdapter classCustomPersistenceHandlerAdapter = mock(
        ClassCustomPersistenceHandlerAdapter.class);
    when(classCustomPersistenceHandlerAdapter.getOrder()).thenReturn(1);

    ArrayList<CustomPersistenceHandler> customPersistenceHandlers = new ArrayList<>();
    AdminPermissionCustomPersistenceHandler adminPermissionCustomPersistenceHandler = new AdminPermissionCustomPersistenceHandler();
    customPersistenceHandlers.add(adminPermissionCustomPersistenceHandler);
    AdminPermissionCustomPersistenceHandler adminPermissionCustomPersistenceHandler2 = new AdminPermissionCustomPersistenceHandler();
    customPersistenceHandlers.add(adminPermissionCustomPersistenceHandler2);
    customPersistenceHandlers.add(classCustomPersistenceHandlerAdapter);

    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setCustomPersistenceHandlers(customPersistenceHandlers);

    // Act
    persistenceManagerImpl.honorExplicitPersistenceHandlerSorting();

    // Assert
    verify(classCustomPersistenceHandlerAdapter, atLeast(1)).getOrder();
    List<CustomPersistenceHandler> customPersistenceHandlers2 = persistenceManagerImpl.getCustomPersistenceHandlers();
    assertEquals(3, customPersistenceHandlers2.size());
    List<CustomPersistenceHandler> customPersistenceHandlerList = persistenceManagerImpl.customPersistenceHandlers;
    assertEquals(3, customPersistenceHandlerList.size());
    assertSame(adminPermissionCustomPersistenceHandler, customPersistenceHandlerList.get(1));
    assertSame(adminPermissionCustomPersistenceHandler2, customPersistenceHandlerList.get(2));
    assertSame(customPersistenceHandlers2.get(0), customPersistenceHandlerList.get(0));
  }

  /**
   * Test {@link PersistenceManagerImpl#honorExplicitPersistenceHandlerSorting()}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#honorExplicitPersistenceHandlerSorting()}
   */
  @Test
  public void testHonorExplicitPersistenceHandlerSorting5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ClassCustomPersistenceHandlerAdapter classCustomPersistenceHandlerAdapter = mock(
        ClassCustomPersistenceHandlerAdapter.class);
    when(classCustomPersistenceHandlerAdapter.getOrder()).thenReturn(1);
    ClassCustomPersistenceHandlerAdapter classCustomPersistenceHandlerAdapter2 = mock(
        ClassCustomPersistenceHandlerAdapter.class);
    when(classCustomPersistenceHandlerAdapter2.getOrder()).thenReturn(1);

    ArrayList<CustomPersistenceHandler> customPersistenceHandlers = new ArrayList<>();
    customPersistenceHandlers.add(classCustomPersistenceHandlerAdapter2);
    AdminPermissionCustomPersistenceHandler adminPermissionCustomPersistenceHandler = new AdminPermissionCustomPersistenceHandler();
    customPersistenceHandlers.add(adminPermissionCustomPersistenceHandler);
    customPersistenceHandlers.add(classCustomPersistenceHandlerAdapter);

    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setCustomPersistenceHandlers(customPersistenceHandlers);

    // Act
    persistenceManagerImpl.honorExplicitPersistenceHandlerSorting();

    // Assert
    verify(classCustomPersistenceHandlerAdapter2, atLeast(1)).getOrder();
    verify(classCustomPersistenceHandlerAdapter, atLeast(1)).getOrder();
    List<CustomPersistenceHandler> customPersistenceHandlerList = persistenceManagerImpl.customPersistenceHandlers;
    assertEquals(3, customPersistenceHandlerList.size());
    List<CustomPersistenceHandler> expectedCustomPersistenceHandlers = persistenceManagerImpl.customPersistenceHandlers;
    assertEquals(expectedCustomPersistenceHandlers, persistenceManagerImpl.getCustomPersistenceHandlers());
    assertSame(adminPermissionCustomPersistenceHandler, customPersistenceHandlerList.get(2));
  }

  /**
   * Test {@link PersistenceManagerImpl#honorExplicitPersistenceHandlerSorting()}.
   * <ul>
   *   <li>Given {@link PersistenceManagerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#honorExplicitPersistenceHandlerSorting()}
   */
  @Test
  public void testHonorExplicitPersistenceHandlerSorting_givenPersistenceManagerImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();

    // Act
    persistenceManagerImpl.honorExplicitPersistenceHandlerSorting();

    // Assert that nothing has changed
    assertTrue(persistenceManagerImpl.getCustomPersistenceHandlers().isEmpty());
    assertTrue(persistenceManagerImpl.customPersistenceHandlers.isEmpty());
  }
}

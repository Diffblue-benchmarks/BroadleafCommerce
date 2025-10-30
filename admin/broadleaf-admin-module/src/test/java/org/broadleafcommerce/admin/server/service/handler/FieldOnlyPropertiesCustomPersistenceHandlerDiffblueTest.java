/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.server.service.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.MergedPropertyType;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.InspectHelper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {FieldOnlyPropertiesCustomPersistenceHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FieldOnlyPropertiesCustomPersistenceHandlerDiffblueTest {
  @Autowired
  private FieldOnlyPropertiesCustomPersistenceHandler fieldOnlyPropertiesCustomPersistenceHandler;

  /**
   * Test {@link FieldOnlyPropertiesCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code fieldImplOnly}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldOnlyPropertiesCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean FieldOnlyPropertiesCustomPersistenceHandler.canHandleInspect(PersistencePackage)"})
  public void testCanHandleInspect_givenArrayOfStringWithFieldImplOnly_thenReturnTrue() {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setCustomCriteria(new String[]{"fieldImplOnly"});

    // Act and Assert
    assertTrue(fieldOnlyPropertiesCustomPersistenceHandler.canHandleInspect(persistencePackage));
  }

  /**
   * Test {@link FieldOnlyPropertiesCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code java.text}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldOnlyPropertiesCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean FieldOnlyPropertiesCustomPersistenceHandler.canHandleInspect(PersistencePackage)"})
  public void testCanHandleInspect_givenArrayOfStringWithJavaText() {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setCustomCriteria(new String[]{"java.text"});

    // Act and Assert
    assertFalse(fieldOnlyPropertiesCustomPersistenceHandler.canHandleInspect(persistencePackage));
  }

  /**
   * Test {@link FieldOnlyPropertiesCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>Given empty array of {@link String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldOnlyPropertiesCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean FieldOnlyPropertiesCustomPersistenceHandler.canHandleInspect(PersistencePackage)"})
  public void testCanHandleInspect_givenEmptyArrayOfString() {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setCustomCriteria(new String[]{});

    // Act and Assert
    assertFalse(fieldOnlyPropertiesCustomPersistenceHandler.canHandleInspect(persistencePackage));
  }

  /**
   * Test {@link FieldOnlyPropertiesCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldOnlyPropertiesCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean FieldOnlyPropertiesCustomPersistenceHandler.canHandleInspect(PersistencePackage)"})
  public void testCanHandleInspect_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(fieldOnlyPropertiesCustomPersistenceHandler.canHandleInspect(new PersistencePackage()));
  }

  /**
   * Test {@link FieldOnlyPropertiesCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}.
   * <p>
   * Method under test: {@link FieldOnlyPropertiesCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet FieldOnlyPropertiesCustomPersistenceHandler.inspect(PersistencePackage, DynamicEntityDao, InspectHelper)"})
  public void testInspect() throws ServiceException {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getInheritedFromType()).thenReturn("jane.doe@example.org");

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);

    ClassMetadata classMetadata = new ClassMetadata();
    classMetadata.setCeilingType("Type");
    classMetadata.setCurrencyCode("GBP");
    classMetadata.setPolymorphicEntities(new ClassTree());
    classMetadata.setProperties(new Property[]{new Property()});
    classMetadata.setSecurityCeilingType("Security Ceiling Type");
    classMetadata.setTabAndGroupMetadata(new HashMap<>());
    PersistenceManagerImpl helper = mock(PersistenceManagerImpl.class);
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(stringFieldMetadataMap);
    when(helper.buildClassMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PersistencePackage>any(),
        Mockito.<Map<MergedPropertyType, Map<String, FieldMetadata>>>any())).thenReturn(classMetadata);

    // Act
    DynamicResultSet actualInspectResult = fieldOnlyPropertiesCustomPersistenceHandler.inspect(persistencePackage,
        dynamicEntityDao, helper);

    // Assert
    verify(adornedTargetCollectionMetadata).getInheritedFromType();
    verify(helper).buildClassMetadata(isA(Class[].class), isA(PersistencePackage.class), isA(Map.class));
    verify(helper).getSimpleMergedProperties(isNull(), isNull());
    assertNull(actualInspectResult.getPromptSearch());
    assertNull(actualInspectResult.getTotalCountLessThanPageSize());
    assertNull(actualInspectResult.getBatchId());
    assertNull(actualInspectResult.getLowerCount());
    assertNull(actualInspectResult.getUpperCount());
    assertNull(actualInspectResult.getFirstId());
    assertNull(actualInspectResult.getLastId());
    assertNull(actualInspectResult.getFetchType());
    assertEquals(0, actualInspectResult.getPageSize().intValue());
    assertEquals(0, actualInspectResult.getStartIndex().intValue());
    assertEquals(0, actualInspectResult.getTotalRecords().intValue());
    assertEquals(0, actualInspectResult.getRecords().length);
    assertTrue(actualInspectResult.getUnselectedTabMetadata().isEmpty());
    assertSame(classMetadata, actualInspectResult.getClassMetaData());
  }

  /**
   * Test {@link FieldOnlyPropertiesCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}.
   * <p>
   * Method under test: {@link FieldOnlyPropertiesCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet FieldOnlyPropertiesCustomPersistenceHandler.inspect(PersistencePackage, DynamicEntityDao, InspectHelper)"})
  public void testInspect2() throws ServiceException {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getInheritedFromType())
        .thenReturn("org.broadleafcommerce.core.search.domain.FieldImpl");

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);

    ClassMetadata classMetadata = new ClassMetadata();
    classMetadata.setCeilingType("Type");
    classMetadata.setCurrencyCode("GBP");
    classMetadata.setPolymorphicEntities(new ClassTree());
    classMetadata.setProperties(new Property[]{new Property()});
    classMetadata.setSecurityCeilingType("Security Ceiling Type");
    classMetadata.setTabAndGroupMetadata(new HashMap<>());
    PersistenceManagerImpl helper = mock(PersistenceManagerImpl.class);
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(stringFieldMetadataMap);
    when(helper.buildClassMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PersistencePackage>any(),
        Mockito.<Map<MergedPropertyType, Map<String, FieldMetadata>>>any())).thenReturn(classMetadata);

    // Act
    DynamicResultSet actualInspectResult = fieldOnlyPropertiesCustomPersistenceHandler.inspect(persistencePackage,
        dynamicEntityDao, helper);

    // Assert
    verify(adornedTargetCollectionMetadata).getInheritedFromType();
    verify(helper).buildClassMetadata(isA(Class[].class), isA(PersistencePackage.class), isA(Map.class));
    verify(helper).getSimpleMergedProperties(isNull(), isNull());
    assertNull(actualInspectResult.getPromptSearch());
    assertNull(actualInspectResult.getTotalCountLessThanPageSize());
    assertNull(actualInspectResult.getBatchId());
    assertNull(actualInspectResult.getLowerCount());
    assertNull(actualInspectResult.getUpperCount());
    assertNull(actualInspectResult.getFirstId());
    assertNull(actualInspectResult.getLastId());
    assertNull(actualInspectResult.getFetchType());
    assertEquals(0, actualInspectResult.getPageSize().intValue());
    assertEquals(0, actualInspectResult.getStartIndex().intValue());
    assertEquals(0, actualInspectResult.getTotalRecords().intValue());
    assertEquals(0, actualInspectResult.getRecords().length);
    assertTrue(actualInspectResult.getUnselectedTabMetadata().isEmpty());
    assertSame(classMetadata, actualInspectResult.getClassMetaData());
  }

  /**
   * Test {@link FieldOnlyPropertiesCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>When {@link DynamicEntityDaoImpl} (default constructor).</li>
   *   <li>Then return PromptSearch is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldOnlyPropertiesCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet FieldOnlyPropertiesCustomPersistenceHandler.inspect(PersistencePackage, DynamicEntityDao, InspectHelper)"})
  public void testInspect_givenHashMap_whenDynamicEntityDaoImpl_thenReturnPromptSearchIsNull() throws ServiceException {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    ClassMetadata classMetadata = new ClassMetadata();
    classMetadata.setCeilingType("Type");
    classMetadata.setCurrencyCode("GBP");
    classMetadata.setPolymorphicEntities(new ClassTree());
    classMetadata.setProperties(new Property[]{new Property()});
    classMetadata.setSecurityCeilingType("Security Ceiling Type");
    classMetadata.setTabAndGroupMetadata(new HashMap<>());
    PersistenceManagerImpl helper = mock(PersistenceManagerImpl.class);
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    when(helper.buildClassMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PersistencePackage>any(),
        Mockito.<Map<MergedPropertyType, Map<String, FieldMetadata>>>any())).thenReturn(classMetadata);

    // Act
    DynamicResultSet actualInspectResult = fieldOnlyPropertiesCustomPersistenceHandler.inspect(persistencePackage,
        dynamicEntityDao, helper);

    // Assert
    verify(helper).buildClassMetadata(isA(Class[].class), isA(PersistencePackage.class), isA(Map.class));
    verify(helper).getSimpleMergedProperties(isNull(), isNull());
    assertNull(actualInspectResult.getPromptSearch());
    assertNull(actualInspectResult.getTotalCountLessThanPageSize());
    assertNull(actualInspectResult.getBatchId());
    assertNull(actualInspectResult.getLowerCount());
    assertNull(actualInspectResult.getUpperCount());
    assertNull(actualInspectResult.getFirstId());
    assertNull(actualInspectResult.getLastId());
    assertNull(actualInspectResult.getFetchType());
    assertEquals(0, actualInspectResult.getPageSize().intValue());
    assertEquals(0, actualInspectResult.getStartIndex().intValue());
    assertEquals(0, actualInspectResult.getTotalRecords().intValue());
    assertEquals(0, actualInspectResult.getRecords().length);
    assertTrue(actualInspectResult.getUnselectedTabMetadata().isEmpty());
    assertSame(classMetadata, actualInspectResult.getClassMetaData());
  }
}

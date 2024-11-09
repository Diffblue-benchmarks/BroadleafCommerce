/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.server.service.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.broadleafcommerce.openadmin.server.service.persistence.module.InspectHelper;
import org.junit.Test;
import org.mockito.Mockito;

public class FieldOnlyPropertiesCustomPersistenceHandlerDiffblueTest {
  /**
   * Test
   * {@link FieldOnlyPropertiesCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code Custom Criteria}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldOnlyPropertiesCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect_givenArrayOfStringWithCustomCriteria() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldOnlyPropertiesCustomPersistenceHandler fieldOnlyPropertiesCustomPersistenceHandler = new FieldOnlyPropertiesCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});

    // Act
    Boolean actualCanHandleInspectResult = fieldOnlyPropertiesCustomPersistenceHandler
        .canHandleInspect(persistencePackage);

    // Assert
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    assertFalse(actualCanHandleInspectResult);
  }

  /**
   * Test
   * {@link FieldOnlyPropertiesCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code fieldImplOnly}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldOnlyPropertiesCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect_givenArrayOfStringWithFieldImplOnly_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldOnlyPropertiesCustomPersistenceHandler fieldOnlyPropertiesCustomPersistenceHandler = new FieldOnlyPropertiesCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"fieldImplOnly"});

    // Act
    Boolean actualCanHandleInspectResult = fieldOnlyPropertiesCustomPersistenceHandler
        .canHandleInspect(persistencePackage);

    // Assert
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    assertTrue(actualCanHandleInspectResult);
  }

  /**
   * Test
   * {@link FieldOnlyPropertiesCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code java.text}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldOnlyPropertiesCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect_givenArrayOfStringWithJavaText() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldOnlyPropertiesCustomPersistenceHandler fieldOnlyPropertiesCustomPersistenceHandler = new FieldOnlyPropertiesCustomPersistenceHandler();

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setCustomCriteria(new String[]{"java.text"});

    // Act and Assert
    assertFalse(fieldOnlyPropertiesCustomPersistenceHandler.canHandleInspect(persistencePackage));
  }

  /**
   * Test
   * {@link FieldOnlyPropertiesCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>Given empty array of {@link String}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldOnlyPropertiesCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect_givenEmptyArrayOfString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldOnlyPropertiesCustomPersistenceHandler fieldOnlyPropertiesCustomPersistenceHandler = new FieldOnlyPropertiesCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{});

    // Act
    Boolean actualCanHandleInspectResult = fieldOnlyPropertiesCustomPersistenceHandler
        .canHandleInspect(persistencePackage);

    // Assert
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualCanHandleInspectResult);
  }

  /**
   * Test
   * {@link FieldOnlyPropertiesCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldOnlyPropertiesCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldOnlyPropertiesCustomPersistenceHandler fieldOnlyPropertiesCustomPersistenceHandler = new FieldOnlyPropertiesCustomPersistenceHandler();

    // Act and Assert
    assertFalse(fieldOnlyPropertiesCustomPersistenceHandler.canHandleInspect(new PersistencePackage()));
  }

  /**
   * Test
   * {@link FieldOnlyPropertiesCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}.
   * <p>
   * Method under test:
   * {@link FieldOnlyPropertiesCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}
   */
  @Test
  public void testInspect() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldOnlyPropertiesCustomPersistenceHandler fieldOnlyPropertiesCustomPersistenceHandler = new FieldOnlyPropertiesCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
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
    InspectHelper helper = mock(InspectHelper.class);
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(stringFieldMetadataMap);
    when(helper.buildClassMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PersistencePackage>any(),
        Mockito.<Map<MergedPropertyType, Map<String, FieldMetadata>>>any())).thenReturn(classMetadata);

    // Act
    DynamicResultSet actualInspectResult = fieldOnlyPropertiesCustomPersistenceHandler.inspect(persistencePackage,
        dynamicEntityDao, helper);

    // Assert
    verify(adornedTargetCollectionMetadata).getInheritedFromType();
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getPersistencePerspective();
    verify(helper).buildClassMetadata(isA(Class[].class), isA(PersistencePackage.class), isA(Map.class));
    verify(helper).getSimpleMergedProperties(eq("Dr Jane Doe"), isA(PersistencePerspective.class));
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
   * Test
   * {@link FieldOnlyPropertiesCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}.
   * <p>
   * Method under test:
   * {@link FieldOnlyPropertiesCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}
   */
  @Test
  public void testInspect2() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldOnlyPropertiesCustomPersistenceHandler fieldOnlyPropertiesCustomPersistenceHandler = new FieldOnlyPropertiesCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
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
    InspectHelper helper = mock(InspectHelper.class);
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(stringFieldMetadataMap);
    when(helper.buildClassMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PersistencePackage>any(),
        Mockito.<Map<MergedPropertyType, Map<String, FieldMetadata>>>any())).thenReturn(classMetadata);

    // Act
    DynamicResultSet actualInspectResult = fieldOnlyPropertiesCustomPersistenceHandler.inspect(persistencePackage,
        dynamicEntityDao, helper);

    // Assert
    verify(adornedTargetCollectionMetadata).getInheritedFromType();
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getPersistencePerspective();
    verify(helper).buildClassMetadata(isA(Class[].class), isA(PersistencePackage.class), isA(Map.class));
    verify(helper).getSimpleMergedProperties(eq("Dr Jane Doe"), isA(PersistencePerspective.class));
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
   * Test
   * {@link FieldOnlyPropertiesCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then return PromptSearch is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldOnlyPropertiesCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}
   */
  @Test
  public void testInspect_givenHashMap_thenReturnPromptSearchIsNull() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldOnlyPropertiesCustomPersistenceHandler fieldOnlyPropertiesCustomPersistenceHandler = new FieldOnlyPropertiesCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    ClassMetadata classMetadata = new ClassMetadata();
    classMetadata.setCeilingType("Type");
    classMetadata.setCurrencyCode("GBP");
    classMetadata.setPolymorphicEntities(new ClassTree());
    classMetadata.setProperties(new Property[]{new Property()});
    classMetadata.setSecurityCeilingType("Security Ceiling Type");
    classMetadata.setTabAndGroupMetadata(new HashMap<>());
    InspectHelper helper = mock(InspectHelper.class);
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    when(helper.buildClassMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PersistencePackage>any(),
        Mockito.<Map<MergedPropertyType, Map<String, FieldMetadata>>>any())).thenReturn(classMetadata);

    // Act
    DynamicResultSet actualInspectResult = fieldOnlyPropertiesCustomPersistenceHandler.inspect(persistencePackage,
        dynamicEntityDao, helper);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getPersistencePerspective();
    verify(helper).buildClassMetadata(isA(Class[].class), isA(PersistencePackage.class), isA(Map.class));
    verify(helper).getSimpleMergedProperties(eq("Dr Jane Doe"), isA(PersistencePerspective.class));
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

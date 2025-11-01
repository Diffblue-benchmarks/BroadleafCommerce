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
package org.broadleafcommerce.openadmin.server.service.persistence.module;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.exception.SecurityServiceException;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.common.presentation.client.PersistencePerspectiveItemType;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.AdornedTargetList;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.FilterAndSortCriteria;
import org.broadleafcommerce.openadmin.dto.ForeignKey;
import org.broadleafcommerce.openadmin.dto.MergedPropertyType;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.PersistencePerspectiveItem;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FieldPath;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FieldPathBuilder;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FilterMapping;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.Restriction;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.RestrictionFactory;
import org.junit.Test;
import org.mockito.Mockito;

public class AdornedTargetListPersistenceModuleDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AdornedTargetListPersistenceModule.AdornedTargetRetrieval#getFilterMappings()}
   *   <li>
   * {@link AdornedTargetListPersistenceModule.AdornedTargetRetrieval#getIndex()}
   *   <li>
   * {@link AdornedTargetListPersistenceModule.AdornedTargetRetrieval#getMergedProperties()}
   *   <li>
   * {@link AdornedTargetListPersistenceModule.AdornedTargetRetrieval#getRecords()}
   * </ul>
   */
  @Test
  public void testAdornedTargetRetrievalGettersAndSetters() {
    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = new AdornedTargetListPersistenceModule();
    PersistencePackage persistencePackage = new PersistencePackage();
    AdornedTargetList adornedTargetList = new AdornedTargetList();
    AdornedTargetListPersistenceModule.AdornedTargetRetrieval adornedTargetRetrieval = adornedTargetListPersistenceModule.new AdornedTargetRetrieval(
        persistencePackage, adornedTargetList, new CriteriaTransferObject());

    // Act
    List<FilterMapping> actualFilterMappings = adornedTargetRetrieval.getFilterMappings();
    int actualIndex = adornedTargetRetrieval.getIndex();
    Map<String, FieldMetadata> actualMergedProperties = adornedTargetRetrieval.getMergedProperties();

    // Assert
    assertNull(adornedTargetRetrieval.getRecords());
    assertNull(actualFilterMappings);
    assertNull(actualMergedProperties);
    assertEquals(0, actualIndex);
  }

  /**
   * Method under test:
   * {@link AdornedTargetListPersistenceModule.AdornedTargetRetrieval#AdornedTargetRetrieval(AdornedTargetListPersistenceModule, PersistencePackage, AdornedTargetList, CriteriaTransferObject)}
   */
  @Test
  public void testAdornedTargetRetrievalNewAdornedTargetRetrieval() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = new AdornedTargetListPersistenceModule();
    PersistencePackage persistencePackage = new PersistencePackage();
    AdornedTargetList adornedTargetList = new AdornedTargetList();

    // Act
    AdornedTargetListPersistenceModule.AdornedTargetRetrieval actualAdornedTargetRetrieval = adornedTargetListPersistenceModule.new AdornedTargetRetrieval(
        persistencePackage, adornedTargetList, new CriteriaTransferObject());

    // Assert
    assertNull(actualAdornedTargetRetrieval.getRecords());
    assertNull(actualAdornedTargetRetrieval.getFilterMappings());
    assertNull(actualAdornedTargetRetrieval.getMergedProperties());
    assertEquals(0, actualAdornedTargetRetrieval.getIndex());
  }

  /**
   * Method under test:
   * {@link AdornedTargetListPersistenceModule.AdornedTargetRetrieval#AdornedTargetRetrieval(AdornedTargetListPersistenceModule, PersistencePackage, AdornedTargetList, CriteriaTransferObject)}
   */
  @Test
  public void testAdornedTargetRetrievalNewAdornedTargetRetrieval2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    PersistencePackage persistencePackage = new PersistencePackage();
    AdornedTargetList adornedTargetList = new AdornedTargetList();

    // Act
    AdornedTargetListPersistenceModule.AdornedTargetRetrieval actualAdornedTargetRetrieval = adornedTargetListPersistenceModule.new AdornedTargetRetrieval(
        persistencePackage, adornedTargetList, new CriteriaTransferObject());

    // Assert
    assertNull(actualAdornedTargetRetrieval.getRecords());
    assertNull(actualAdornedTargetRetrieval.getFilterMappings());
    assertNull(actualAdornedTargetRetrieval.getMergedProperties());
    assertEquals(0, actualAdornedTargetRetrieval.getIndex());
  }

  /**
   * Method under test:
   * {@link AdornedTargetListPersistenceModule.AdornedTargetRetrieval#AdornedTargetRetrieval(AdornedTargetListPersistenceModule, PersistencePackage, Entity, AdornedTargetList)}
   */
  @Test
  public void testAdornedTargetRetrievalNewAdornedTargetRetrieval3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = new AdornedTargetListPersistenceModule();
    PersistencePackage persistencePackage = new PersistencePackage();
    Entity entity = new Entity();

    // Act
    AdornedTargetListPersistenceModule.AdornedTargetRetrieval actualAdornedTargetRetrieval = adornedTargetListPersistenceModule.new AdornedTargetRetrieval(
        persistencePackage, entity, new AdornedTargetList());

    // Assert
    assertNull(actualAdornedTargetRetrieval.getRecords());
    assertNull(actualAdornedTargetRetrieval.getFilterMappings());
    assertNull(actualAdornedTargetRetrieval.getMergedProperties());
    assertEquals(0, actualAdornedTargetRetrieval.getIndex());
  }

  /**
   * Method under test:
   * {@link AdornedTargetListPersistenceModule.AdornedTargetRetrieval#AdornedTargetRetrieval(AdornedTargetListPersistenceModule, PersistencePackage, Entity, AdornedTargetList)}
   */
  @Test
  public void testAdornedTargetRetrievalNewAdornedTargetRetrieval4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    PersistencePackage persistencePackage = new PersistencePackage();
    Entity entity = new Entity();

    // Act
    AdornedTargetListPersistenceModule.AdornedTargetRetrieval actualAdornedTargetRetrieval = adornedTargetListPersistenceModule.new AdornedTargetRetrieval(
        persistencePackage, entity, new AdornedTargetList());

    // Assert
    assertNull(actualAdornedTargetRetrieval.getRecords());
    assertNull(actualAdornedTargetRetrieval.getFilterMappings());
    assertNull(actualAdornedTargetRetrieval.getMergedProperties());
    assertEquals(0, actualAdornedTargetRetrieval.getIndex());
  }

  /**
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#isCompatible(OperationType)}
   */
  @Test
  public void testIsCompatible() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new AdornedTargetListPersistenceModule()).isCompatible(OperationType.NONDESTRUCTIVEREMOVE));
    assertTrue((new AdornedTargetListPersistenceModule()).isCompatible(OperationType.ADORNEDTARGETLIST));
  }

  /**
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#isCompatible(OperationType)}
   */
  @Test
  public void testIsCompatible2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = new AdornedTargetListPersistenceModule();
    adornedTargetListPersistenceModule.setRestrictionFactory(mock(RestrictionFactory.class));

    // Act and Assert
    assertFalse(adornedTargetListPersistenceModule.isCompatible(OperationType.NONDESTRUCTIVEREMOVE));
  }

  /**
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties() throws NumberFormatException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = new AdornedTargetListPersistenceModule();
    Class<Object> forNameResult = Object.class;
    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    adornedTargetListPersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert that nothing has changed
    assertTrue(properties.isEmpty());
  }

  /**
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties2() throws NumberFormatException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = new AdornedTargetListPersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.ADORNEDTARGETLIST, new HashMap<>());
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    adornedTargetListPersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert
    assertTrue(properties.isEmpty());
  }

  /**
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties3() throws NumberFormatException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = new AdornedTargetListPersistenceModule();
    Class<Object> forNameResult = Object.class;
    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();

    ArrayList<Property> properties = new ArrayList<>();
    Property property = new Property();
    properties.add(property);

    // Act
    adornedTargetListPersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert that nothing has changed
    assertEquals(1, properties.size());
    assertSame(property, properties.get(0));
  }

  /**
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties4() throws NumberFormatException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = new AdornedTargetListPersistenceModule();
    Class<Object> forNameResult = Object.class;
    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();

    ArrayList<Property> properties = new ArrayList<>();
    Property property = new Property();
    properties.add(property);
    Property property2 = new Property();
    properties.add(property2);

    // Act
    adornedTargetListPersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert that nothing has changed
    assertEquals(2, properties.size());
    assertSame(property, properties.get(0));
    assertSame(property2, properties.get(1));
  }

  /**
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties5() throws NumberFormatException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = new AdornedTargetListPersistenceModule();
    adornedTargetListPersistenceModule.setRestrictionFactory(mock(RestrictionFactory.class));
    Class<Object> forNameResult = Object.class;
    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    adornedTargetListPersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert that nothing has changed
    assertTrue(properties.isEmpty());
  }

  /**
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties6() throws NumberFormatException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = new AdornedTargetListPersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.ADORNEDTARGETLIST, stringFieldMetadataMap);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    adornedTargetListPersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert
    assertEquals(1, properties.size());
    Property getResult = properties.get(0);
    assertEquals("foo", getResult.getName());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult.getRawValue());
    assertNull(getResult.getUnHtmlEncodedValue());
    assertNull(getResult.getValue());
    assertNull(getResult.getDeployDate());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertTrue(getResult.getEnabled());
    assertSame(adornedTargetCollectionMetadata, getResult.getMetadata());
  }

  /**
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties7() throws NumberFormatException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = new AdornedTargetListPersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("42", adornedTargetCollectionMetadata);
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata2 = new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata2);

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.ADORNEDTARGETLIST, stringFieldMetadataMap);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    adornedTargetListPersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert
    assertEquals(2, properties.size());
    Property getResult = properties.get(0);
    assertEquals("42", getResult.getName());
    Property getResult2 = properties.get(1);
    assertEquals("foo", getResult2.getName());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult2.getDisplayValue());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult2.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult2.getOriginalValue());
    assertNull(getResult.getRawValue());
    assertNull(getResult2.getRawValue());
    assertNull(getResult.getUnHtmlEncodedValue());
    assertNull(getResult2.getUnHtmlEncodedValue());
    assertNull(getResult.getValue());
    assertNull(getResult2.getValue());
    assertNull(getResult.getDeployDate());
    assertNull(getResult2.getDeployDate());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult2.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertFalse(getResult2.isAdvancedCollection());
    assertTrue(getResult.getEnabled());
    assertTrue(getResult2.getEnabled());
    assertSame(adornedTargetCollectionMetadata, getResult.getMetadata());
    assertSame(adornedTargetCollectionMetadata2, getResult2.getMetadata());
  }

  /**
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#getBasicFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, String)}
   */
  @Test
  public void testGetBasicFilterMappings() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = new AdornedTargetListPersistenceModule();
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject cto = new CriteriaTransferObject();

    // Act and Assert
    assertTrue(adornedTargetListPersistenceModule
        .getBasicFilterMappings(persistencePerspective, cto, new HashMap<>(), "java.lang.Class")
        .isEmpty());
  }

  /**
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#getBasicFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, String)}
   */
  @Test
  public void testGetBasicFilterMappings2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = new AdornedTargetListPersistenceModule();
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    CriteriaTransferObject cto = new CriteriaTransferObject();

    // Act and Assert
    assertTrue(adornedTargetListPersistenceModule
        .getBasicFilterMappings(persistencePerspective, cto, new HashMap<>(), "java.lang.Class")
        .isEmpty());
  }

  /**
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#getBasicFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, String)}
   */
  @Test
  public void testGetBasicFilterMappings3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = new AdornedTargetListPersistenceModule();
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());

    // Act
    List<FilterMapping> actualBasicFilterMappings = adornedTargetListPersistenceModule
        .getBasicFilterMappings(persistencePerspective, cto, new HashMap<>(), "java.lang.Class");

    // Assert
    verify(cto).getCriteriaMap();
    assertTrue(actualBasicFilterMappings.isEmpty());
  }

  /**
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#getAdornedTargetFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, AdornedTargetList)}
   */
  @Test
  public void testGetAdornedTargetFilterMappings() throws ClassNotFoundException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = new AdornedTargetListPersistenceModule();
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject cto = new CriteriaTransferObject();
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();

    // Act
    List<FilterMapping> actualAdornedTargetFilterMappings = adornedTargetListPersistenceModule
        .getAdornedTargetFilterMappings(persistencePerspective, cto, mergedProperties, new AdornedTargetList());

    // Assert
    assertEquals(2, actualAdornedTargetFilterMappings.size());
    FilterMapping getResult = actualAdornedTargetFilterMappings.get(0);
    FieldPath fieldPath = getResult.getFieldPath();
    assertEquals("null.null", fieldPath.getTargetProperty());
    FilterMapping getResult2 = actualAdornedTargetFilterMappings.get(1);
    FieldPath fieldPath2 = getResult2.getFieldPath();
    assertEquals("null.null", fieldPath2.getTargetProperty());
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(2, criteriaMap.size());
    FilterAndSortCriteria getResult3 = criteriaMap.get("nullTarget");
    assertEquals("nullTarget", getResult3.getPropertyId());
    assertNull(getResult3.getSortAscending());
    FilterAndSortCriteria getResult4 = criteriaMap.get(null);
    assertNull(getResult4.getSortAscending());
    assertNull(getResult.getInheritedFromClass());
    assertNull(getResult2.getInheritedFromClass());
    assertNull(getResult3.getOrder());
    assertNull(getResult4.getOrder());
    assertNull(getResult.getOrder());
    assertNull(getResult2.getOrder());
    assertNull(getResult4.getPropertyId());
    assertNull(getResult.getFullPropertyName());
    assertNull(getResult2.getFullPropertyName());
    Restriction restriction = getResult.getRestriction();
    FieldPathBuilder fieldPathBuilder = restriction.getFieldPathBuilder();
    assertNull(fieldPathBuilder.getRestrictions());
    Restriction restriction2 = getResult2.getRestriction();
    FieldPathBuilder fieldPathBuilder2 = restriction2.getFieldPathBuilder();
    assertNull(fieldPathBuilder2.getRestrictions());
    assertNull(fieldPathBuilder.getCriteria());
    assertNull(fieldPathBuilder2.getCriteria());
    assertNull(getResult3.getSortDirection());
    assertNull(getResult4.getSortDirection());
    assertNull(getResult.getSortDirection());
    assertNull(getResult2.getSortDirection());
    assertNull(getResult3.getRestrictionType());
    assertNull(getResult4.getRestrictionType());
    assertNull(restriction.getFilterValueConverter());
    assertNull(restriction2.getFilterValueConverter());
    assertTrue(getResult3.getFilterValues().isEmpty());
    assertTrue(getResult4.getFilterValues().isEmpty());
    assertTrue(getResult3.getSpecialFilterValues().isEmpty());
    assertTrue(getResult4.getSpecialFilterValues().isEmpty());
    assertTrue(fieldPath.getAssociationPath().isEmpty());
    assertTrue(fieldPath2.getAssociationPath().isEmpty());
    assertTrue(fieldPath.getTargetPropertyPieces().isEmpty());
    assertTrue(fieldPath2.getTargetPropertyPieces().isEmpty());
    assertTrue(getResult.getDirectFilterValues().isEmpty());
    assertTrue(getResult2.getDirectFilterValues().isEmpty());
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult2.getFilterValues().isEmpty());
    assertTrue(getResult3.isNullsLast());
    assertTrue(getResult4.isNullsLast());
    assertTrue(getResult.getNullsLast());
    assertTrue(getResult2.getNullsLast());
  }

  /**
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#getAdornedTargetFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, AdornedTargetList)}
   */
  @Test
  public void testGetAdornedTargetFilterMappings2() throws ClassNotFoundException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = new AdornedTargetListPersistenceModule();
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    CriteriaTransferObject cto = new CriteriaTransferObject();
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();

    // Act
    List<FilterMapping> actualAdornedTargetFilterMappings = adornedTargetListPersistenceModule
        .getAdornedTargetFilterMappings(persistencePerspective, cto, mergedProperties, new AdornedTargetList());

    // Assert
    assertEquals(2, actualAdornedTargetFilterMappings.size());
    FilterMapping getResult = actualAdornedTargetFilterMappings.get(0);
    FieldPath fieldPath = getResult.getFieldPath();
    assertEquals("null.null", fieldPath.getTargetProperty());
    FilterMapping getResult2 = actualAdornedTargetFilterMappings.get(1);
    FieldPath fieldPath2 = getResult2.getFieldPath();
    assertEquals("null.null", fieldPath2.getTargetProperty());
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(2, criteriaMap.size());
    FilterAndSortCriteria getResult3 = criteriaMap.get("nullTarget");
    assertEquals("nullTarget", getResult3.getPropertyId());
    assertNull(getResult3.getSortAscending());
    FilterAndSortCriteria getResult4 = criteriaMap.get(null);
    assertNull(getResult4.getSortAscending());
    assertNull(getResult.getInheritedFromClass());
    assertNull(getResult2.getInheritedFromClass());
    assertNull(getResult3.getOrder());
    assertNull(getResult4.getOrder());
    assertNull(getResult.getOrder());
    assertNull(getResult2.getOrder());
    assertNull(getResult4.getPropertyId());
    assertNull(getResult.getFullPropertyName());
    assertNull(getResult2.getFullPropertyName());
    Restriction restriction = getResult.getRestriction();
    FieldPathBuilder fieldPathBuilder = restriction.getFieldPathBuilder();
    assertNull(fieldPathBuilder.getRestrictions());
    Restriction restriction2 = getResult2.getRestriction();
    FieldPathBuilder fieldPathBuilder2 = restriction2.getFieldPathBuilder();
    assertNull(fieldPathBuilder2.getRestrictions());
    assertNull(fieldPathBuilder.getCriteria());
    assertNull(fieldPathBuilder2.getCriteria());
    assertNull(getResult3.getSortDirection());
    assertNull(getResult4.getSortDirection());
    assertNull(getResult.getSortDirection());
    assertNull(getResult2.getSortDirection());
    assertNull(getResult3.getRestrictionType());
    assertNull(getResult4.getRestrictionType());
    assertNull(restriction.getFilterValueConverter());
    assertNull(restriction2.getFilterValueConverter());
    assertTrue(getResult3.getFilterValues().isEmpty());
    assertTrue(getResult4.getFilterValues().isEmpty());
    assertTrue(getResult3.getSpecialFilterValues().isEmpty());
    assertTrue(getResult4.getSpecialFilterValues().isEmpty());
    assertTrue(fieldPath.getAssociationPath().isEmpty());
    assertTrue(fieldPath2.getAssociationPath().isEmpty());
    assertTrue(fieldPath.getTargetPropertyPieces().isEmpty());
    assertTrue(fieldPath2.getTargetPropertyPieces().isEmpty());
    assertTrue(getResult.getDirectFilterValues().isEmpty());
    assertTrue(getResult2.getDirectFilterValues().isEmpty());
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult2.getFilterValues().isEmpty());
    assertTrue(getResult3.isNullsLast());
    assertTrue(getResult4.isNullsLast());
    assertTrue(getResult.getNullsLast());
    assertTrue(getResult2.getNullsLast());
  }

  /**
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#getAdornedTargetFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, AdornedTargetList)}
   */
  @Test
  public void testGetAdornedTargetFilterMappings3() throws ClassNotFoundException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = new AdornedTargetListPersistenceModule();
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(new FilterAndSortCriteria("42"));
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();

    // Act
    List<FilterMapping> actualAdornedTargetFilterMappings = adornedTargetListPersistenceModule
        .getAdornedTargetFilterMappings(persistencePerspective, cto, mergedProperties, new AdornedTargetList());

    // Assert
    verify(cto, atLeast(1)).get(Mockito.<String>any());
    verify(cto).getCriteriaMap();
    assertEquals(2, actualAdornedTargetFilterMappings.size());
    FilterMapping getResult = actualAdornedTargetFilterMappings.get(0);
    FieldPath fieldPath = getResult.getFieldPath();
    assertEquals("null.null", fieldPath.getTargetProperty());
    FilterMapping getResult2 = actualAdornedTargetFilterMappings.get(1);
    FieldPath fieldPath2 = getResult2.getFieldPath();
    assertEquals("null.null", fieldPath2.getTargetProperty());
    assertNull(getResult.getInheritedFromClass());
    assertNull(getResult2.getInheritedFromClass());
    assertNull(getResult.getOrder());
    assertNull(getResult2.getOrder());
    assertNull(getResult.getFullPropertyName());
    assertNull(getResult2.getFullPropertyName());
    Restriction restriction = getResult.getRestriction();
    FieldPathBuilder fieldPathBuilder = restriction.getFieldPathBuilder();
    assertNull(fieldPathBuilder.getRestrictions());
    Restriction restriction2 = getResult2.getRestriction();
    FieldPathBuilder fieldPathBuilder2 = restriction2.getFieldPathBuilder();
    assertNull(fieldPathBuilder2.getRestrictions());
    assertNull(fieldPathBuilder.getCriteria());
    assertNull(fieldPathBuilder2.getCriteria());
    assertNull(getResult.getSortDirection());
    assertNull(getResult2.getSortDirection());
    assertNull(restriction.getFilterValueConverter());
    assertNull(restriction2.getFilterValueConverter());
    assertTrue(fieldPath.getAssociationPath().isEmpty());
    assertTrue(fieldPath2.getAssociationPath().isEmpty());
    assertTrue(fieldPath.getTargetPropertyPieces().isEmpty());
    assertTrue(fieldPath2.getTargetPropertyPieces().isEmpty());
    assertTrue(getResult.getDirectFilterValues().isEmpty());
    assertTrue(getResult2.getDirectFilterValues().isEmpty());
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult2.getFilterValues().isEmpty());
    assertTrue(getResult.getNullsLast());
    assertTrue(getResult2.getNullsLast());
  }

  /**
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#getAdornedTargetFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, AdornedTargetList)}
   */
  @Test
  public void testGetAdornedTargetFilterMappings4() throws ClassNotFoundException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = new AdornedTargetListPersistenceModule();
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(new FilterAndSortCriteria("42", "42"));
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();

    // Act
    List<FilterMapping> actualAdornedTargetFilterMappings = adornedTargetListPersistenceModule
        .getAdornedTargetFilterMappings(persistencePerspective, cto, mergedProperties, new AdornedTargetList());

    // Assert
    verify(cto, atLeast(1)).get(Mockito.<String>any());
    verify(cto).getCriteriaMap();
    assertEquals(2, actualAdornedTargetFilterMappings.size());
    FilterMapping getResult = actualAdornedTargetFilterMappings.get(0);
    List<String> filterValues = getResult.getFilterValues();
    assertEquals(1, filterValues.size());
    assertEquals("42", filterValues.get(0));
    FilterMapping getResult2 = actualAdornedTargetFilterMappings.get(1);
    List<String> filterValues2 = getResult2.getFilterValues();
    assertEquals(1, filterValues2.size());
    assertEquals("42", filterValues2.get(0));
    FieldPath fieldPath = getResult.getFieldPath();
    assertEquals("null.null", fieldPath.getTargetProperty());
    FieldPath fieldPath2 = getResult2.getFieldPath();
    assertEquals("null.null", fieldPath2.getTargetProperty());
    assertNull(getResult.getInheritedFromClass());
    assertNull(getResult2.getInheritedFromClass());
    assertNull(getResult.getOrder());
    assertNull(getResult2.getOrder());
    assertNull(getResult.getFullPropertyName());
    assertNull(getResult2.getFullPropertyName());
    Restriction restriction = getResult.getRestriction();
    FieldPathBuilder fieldPathBuilder = restriction.getFieldPathBuilder();
    assertNull(fieldPathBuilder.getRestrictions());
    Restriction restriction2 = getResult2.getRestriction();
    FieldPathBuilder fieldPathBuilder2 = restriction2.getFieldPathBuilder();
    assertNull(fieldPathBuilder2.getRestrictions());
    assertNull(fieldPathBuilder.getCriteria());
    assertNull(fieldPathBuilder2.getCriteria());
    assertNull(getResult.getSortDirection());
    assertNull(getResult2.getSortDirection());
    assertNull(restriction.getFilterValueConverter());
    assertNull(restriction2.getFilterValueConverter());
    assertTrue(fieldPath.getAssociationPath().isEmpty());
    assertTrue(fieldPath2.getAssociationPath().isEmpty());
    assertTrue(fieldPath.getTargetPropertyPieces().isEmpty());
    assertTrue(fieldPath2.getTargetPropertyPieces().isEmpty());
    assertTrue(getResult.getDirectFilterValues().isEmpty());
    assertTrue(getResult2.getDirectFilterValues().isEmpty());
    assertTrue(getResult.getNullsLast());
    assertTrue(getResult2.getNullsLast());
  }

  /**
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#getAdornedTargetFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, AdornedTargetList)}
   */
  @Test
  public void testGetAdornedTargetFilterMappings5() throws ClassNotFoundException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = new AdornedTargetListPersistenceModule();
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    FilterAndSortCriteria filterAndSortCriteria = mock(FilterAndSortCriteria.class);
    when(filterAndSortCriteria.getFilterValues()).thenReturn(new ArrayList<>());
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(filterAndSortCriteria);
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();

    // Act
    List<FilterMapping> actualAdornedTargetFilterMappings = adornedTargetListPersistenceModule
        .getAdornedTargetFilterMappings(persistencePerspective, cto, mergedProperties, new AdornedTargetList());

    // Assert
    verify(cto, atLeast(1)).get(Mockito.<String>any());
    verify(cto).getCriteriaMap();
    verify(filterAndSortCriteria, atLeast(1)).getFilterValues();
    assertEquals(2, actualAdornedTargetFilterMappings.size());
    FilterMapping getResult = actualAdornedTargetFilterMappings.get(0);
    FieldPath fieldPath = getResult.getFieldPath();
    assertEquals("null.null", fieldPath.getTargetProperty());
    FilterMapping getResult2 = actualAdornedTargetFilterMappings.get(1);
    FieldPath fieldPath2 = getResult2.getFieldPath();
    assertEquals("null.null", fieldPath2.getTargetProperty());
    assertNull(getResult.getInheritedFromClass());
    assertNull(getResult2.getInheritedFromClass());
    assertNull(getResult.getOrder());
    assertNull(getResult2.getOrder());
    assertNull(getResult.getFullPropertyName());
    assertNull(getResult2.getFullPropertyName());
    Restriction restriction = getResult.getRestriction();
    FieldPathBuilder fieldPathBuilder = restriction.getFieldPathBuilder();
    assertNull(fieldPathBuilder.getRestrictions());
    Restriction restriction2 = getResult2.getRestriction();
    FieldPathBuilder fieldPathBuilder2 = restriction2.getFieldPathBuilder();
    assertNull(fieldPathBuilder2.getRestrictions());
    assertNull(fieldPathBuilder.getCriteria());
    assertNull(fieldPathBuilder2.getCriteria());
    assertNull(getResult.getSortDirection());
    assertNull(getResult2.getSortDirection());
    assertNull(restriction.getFilterValueConverter());
    assertNull(restriction2.getFilterValueConverter());
    assertTrue(fieldPath.getAssociationPath().isEmpty());
    assertTrue(fieldPath2.getAssociationPath().isEmpty());
    assertTrue(fieldPath.getTargetPropertyPieces().isEmpty());
    assertTrue(fieldPath2.getTargetPropertyPieces().isEmpty());
    assertTrue(getResult.getDirectFilterValues().isEmpty());
    assertTrue(getResult2.getDirectFilterValues().isEmpty());
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult2.getFilterValues().isEmpty());
    assertTrue(getResult.getNullsLast());
    assertTrue(getResult2.getNullsLast());
  }

  /**
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#updateMergedProperties(PersistencePackage, Map)}
   */
  @Test
  public void testUpdateMergedProperties() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = new AdornedTargetListPersistenceModule();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());

    // Act
    adornedTargetListPersistenceModule.updateMergedProperties(persistencePackage, new HashMap<>());

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getPersistencePerspective();
  }

  /**
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#add(PersistencePackage)}
   */
  @Test
  public void testAdd() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = new AdornedTargetListPersistenceModule();
    AdornedTargetList adornedTargetList = mock(AdornedTargetList.class);
    when(adornedTargetList.getMutable()).thenReturn(false);
    doNothing().when(adornedTargetList).setSortField(Mockito.<String>any());
    adornedTargetList.setSortField(null);

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = new HashMap<>();
    persistencePerspectiveItems.put(PersistencePerspectiveItemType.ADORNEDTARGETLIST, adornedTargetList);

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setPersistencePerspectiveItems(persistencePerspectiveItems);

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setCustomCriteria(null);
    persistencePackage.setPersistencePerspective(persistencePerspective);

    // Act and Assert
    assertThrows(SecurityServiceException.class, () -> adornedTargetListPersistenceModule.add(persistencePackage));
    verify(adornedTargetList).getMutable();
    verify(adornedTargetList).setSortField(isNull());
  }

  /**
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#update(PersistencePackage)}
   */
  @Test
  public void testUpdate() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = new AdornedTargetListPersistenceModule();
    AdornedTargetList adornedTargetList = mock(AdornedTargetList.class);
    when(adornedTargetList.getSortAscending()).thenThrow(new NumberFormatException(
        "custom persistence handlers and custom criteria not supported for update types other than BASIC"));
    when(adornedTargetList.getCollectionFieldName()).thenReturn("Collection Field Name");
    when(adornedTargetList.getLinkedIdProperty()).thenReturn("Linked Id Property");
    when(adornedTargetList.getLinkedObjectPath()).thenReturn("Linked Object Path");
    when(adornedTargetList.getSortField()).thenReturn("Sort Field");
    when(adornedTargetList.getMutable()).thenReturn(true);

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItemTypePersistencePerspectiveItemMap = new HashMap<>();
    persistencePerspectiveItemTypePersistencePerspectiveItemMap.put(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        adornedTargetList);
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getPersistencePerspectiveItems())
        .thenReturn(persistencePerspectiveItemTypePersistencePerspectiveItemMap);
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria"}, "ABC123");
    persistencePackage.setPersistencePerspective(persistencePerspective);

    // Act and Assert
    assertThrows(ServiceException.class, () -> adornedTargetListPersistenceModule.update(persistencePackage));
    verify(adornedTargetList).getCollectionFieldName();
    verify(adornedTargetList).getLinkedIdProperty();
    verify(adornedTargetList).getLinkedObjectPath();
    verify(adornedTargetList).getMutable();
    verify(adornedTargetList).getSortAscending();
    verify(adornedTargetList, atLeast(1)).getSortField();
    verify(entity).findProperty(eq("Linked Object Path.Linked Id Property"));
    verify(persistencePerspective).getPersistencePerspectiveItems();
    verify(property).getValue();
  }

  /**
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#update(PersistencePackage)}
   */
  @Test
  public void testUpdate2() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = new AdornedTargetListPersistenceModule();
    AdornedTargetList adornedTargetList = mock(AdornedTargetList.class);
    when(adornedTargetList.getMutable()).thenReturn(false);

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItemTypePersistencePerspectiveItemMap = new HashMap<>();
    persistencePerspectiveItemTypePersistencePerspectiveItemMap.put(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        adornedTargetList);
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getPersistencePerspectiveItems())
        .thenReturn(persistencePerspectiveItemTypePersistencePerspectiveItemMap);
    Entity entity = mock(Entity.class);

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria"}, "ABC123");
    persistencePackage.setPersistencePerspective(persistencePerspective);

    // Act and Assert
    assertThrows(SecurityServiceException.class, () -> adornedTargetListPersistenceModule.update(persistencePackage));
    verify(adornedTargetList).getMutable();
    verify(persistencePerspective).getPersistencePerspectiveItems();
  }

  /**
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#remove(PersistencePackage)}
   */
  @Test
  public void testRemove() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = new AdornedTargetListPersistenceModule();
    AdornedTargetList adornedTargetList = mock(AdornedTargetList.class);
    when(adornedTargetList.getAdornedTargetEntityClassname()).thenThrow(new NumberFormatException("foo"));
    when(adornedTargetList.getMutable()).thenReturn(true);

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItemTypePersistencePerspectiveItemMap = new HashMap<>();
    persistencePerspectiveItemTypePersistencePerspectiveItemMap.put(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        adornedTargetList);
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getPersistencePerspectiveItems())
        .thenReturn(persistencePerspectiveItemTypePersistencePerspectiveItemMap);
    Entity entity = new Entity();

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Problem removing entity : "}, "ABC123");
    persistencePackage.setPersistencePerspective(persistencePerspective);

    // Act and Assert
    assertThrows(ServiceException.class, () -> adornedTargetListPersistenceModule.remove(persistencePackage));
    verify(adornedTargetList).getAdornedTargetEntityClassname();
    verify(adornedTargetList).getMutable();
    verify(persistencePerspective).getPersistencePerspectiveItems();
  }

  /**
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#remove(PersistencePackage)}
   */
  @Test
  public void testRemove2() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = new AdornedTargetListPersistenceModule();
    AdornedTargetList adornedTargetList = mock(AdornedTargetList.class);
    when(adornedTargetList.getMutable()).thenReturn(false);

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItemTypePersistencePerspectiveItemMap = new HashMap<>();
    persistencePerspectiveItemTypePersistencePerspectiveItemMap.put(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        adornedTargetList);
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getPersistencePerspectiveItems())
        .thenReturn(persistencePerspectiveItemTypePersistencePerspectiveItemMap);
    Entity entity = new Entity();

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Problem removing entity : "}, "ABC123");
    persistencePackage.setPersistencePerspective(persistencePerspective);

    // Act and Assert
    assertThrows(ServiceException.class, () -> adornedTargetListPersistenceModule.remove(persistencePackage));
    verify(adornedTargetList).getMutable();
    verify(persistencePerspective).getPersistencePerspectiveItems();
  }

  /**
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#fetch(PersistencePackage, AdornedTargetList, CriteriaTransferObject)}
   */
  @Test
  public void testFetch() throws ClassNotFoundException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getMergedProperties(Mockito.<String>any(), Mockito.<Class<Object>[]>any(),
        Mockito.<ForeignKey>any(), Mockito.<String[]>any(), Mockito.<ForeignKey[]>any(),
        Mockito.<MergedPropertyType>any(), Mockito.<Boolean>any(), Mockito.<String[]>any(), Mockito.<String[]>any(),
        Mockito.<String>any(), Mockito.<String>any())).thenReturn(new HashMap<>());
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    Class<Object> forNameResult = Object.class;
    when(persistenceManager.getPolymorphicEntities(Mockito.<String>any())).thenReturn(new Class[]{forNameResult});
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = new AdornedTargetListPersistenceModule();
    adornedTargetListPersistenceModule.setPersistenceManager(persistenceManager);
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    AdornedTargetList adornedTargetList = mock(AdornedTargetList.class);
    when(adornedTargetList.getCollectionFieldName()).thenReturn("Collection Field Name");
    when(adornedTargetList.getLinkedIdProperty()).thenReturn("Linked Id Property");
    when(adornedTargetList.getLinkedObjectPath()).thenReturn("Linked Object Path");
    when(adornedTargetList.getSortAscending()).thenReturn(true);
    when(adornedTargetList.getAdornedTargetEntityClassname()).thenReturn("Adorned Target Entity Classname");
    when(adornedTargetList.getSortField()).thenReturn("Sort Field");
    FilterAndSortCriteria filterAndSortCriteria = mock(FilterAndSortCriteria.class);
    when(filterAndSortCriteria.getFilterValues()).thenThrow(new NumberFormatException("."));
    doNothing().when(filterAndSortCriteria).setSortAscending(Mockito.<Boolean>any());
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(filterAndSortCriteria);

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> adornedTargetListPersistenceModule.fetch(persistencePackage, adornedTargetList, cto));
    verify(adornedTargetList, atLeast(1)).getAdornedTargetEntityClassname();
    verify(adornedTargetList).getCollectionFieldName();
    verify(adornedTargetList).getLinkedIdProperty();
    verify(adornedTargetList).getLinkedObjectPath();
    verify(adornedTargetList).getSortAscending();
    verify(adornedTargetList, atLeast(1)).getSortField();
    verify(cto, atLeast(1)).get(Mockito.<String>any());
    verify(cto).getCriteriaMap();
    verify(filterAndSortCriteria).getFilterValues();
    verify(filterAndSortCriteria).setSortAscending(eq(true));
    verify(persistencePackage).getPersistencePerspective();
    verify(dynamicEntityDaoImpl).getMergedProperties(eq("Adorned Target Entity Classname"), isA(Class[].class),
        isNull(), isA(String[].class), isA(ForeignKey[].class), eq(MergedPropertyType.ADORNEDTARGETLIST), eq(false),
        isA(String[].class), isA(String[].class), isNull(), eq(""));
    verify(persistenceManager).getDynamicEntityDao();
    verify(persistenceManager).getPolymorphicEntities(eq("Adorned Target Entity Classname"));
  }
}

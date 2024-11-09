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
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
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
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule.AdornedTargetRetrieval;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FilterMapping;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.RestrictionFactory;
import org.junit.Test;
import org.mockito.Mockito;

public class AdornedTargetListPersistenceModuleDiffblueTest {
  /**
   * Test AdornedTargetRetrieval getters and setters.
   * <p>
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
   * Test AdornedTargetRetrieval
   * {@link AdornedTargetRetrieval#AdornedTargetRetrieval(AdornedTargetListPersistenceModule, PersistencePackage, AdornedTargetList, CriteriaTransferObject)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetListPersistenceModule.AdornedTargetRetrieval#AdornedTargetRetrieval(AdornedTargetListPersistenceModule, PersistencePackage, AdornedTargetList, CriteriaTransferObject)}
   */
  @Test
  public void testAdornedTargetRetrievalNewAdornedTargetRetrieval() {
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
   * Test AdornedTargetRetrieval
   * {@link AdornedTargetRetrieval#AdornedTargetRetrieval(AdornedTargetListPersistenceModule, PersistencePackage, Entity, AdornedTargetList)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetListPersistenceModule.AdornedTargetRetrieval#AdornedTargetRetrieval(AdornedTargetListPersistenceModule, PersistencePackage, Entity, AdornedTargetList)}
   */
  @Test
  public void testAdornedTargetRetrievalNewAdornedTargetRetrieval2() {
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
   * Test AdornedTargetRetrieval
   * {@link AdornedTargetRetrieval#AdornedTargetRetrieval(AdornedTargetListPersistenceModule, PersistencePackage, AdornedTargetList, CriteriaTransferObject)}.
   * <ul>
   *   <li>Then return Records is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdornedTargetListPersistenceModule.AdornedTargetRetrieval#AdornedTargetRetrieval(AdornedTargetListPersistenceModule, PersistencePackage, AdornedTargetList, CriteriaTransferObject)}
   */
  @Test
  public void testAdornedTargetRetrievalNewAdornedTargetRetrieval_thenReturnRecordsIsNull() {
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
   * Test AdornedTargetRetrieval
   * {@link AdornedTargetRetrieval#AdornedTargetRetrieval(AdornedTargetListPersistenceModule, PersistencePackage, Entity, AdornedTargetList)}.
   * <ul>
   *   <li>Then return Records is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdornedTargetListPersistenceModule.AdornedTargetRetrieval#AdornedTargetRetrieval(AdornedTargetListPersistenceModule, PersistencePackage, Entity, AdornedTargetList)}
   */
  @Test
  public void testAdornedTargetRetrievalNewAdornedTargetRetrieval_thenReturnRecordsIsNull2() {
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
   * Test {@link AdornedTargetListPersistenceModule#isCompatible(OperationType)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#isCompatible(OperationType)}
   */
  @Test
  public void testIsCompatible() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = new AdornedTargetListPersistenceModule();
    adornedTargetListPersistenceModule.setRestrictionFactory(mock(RestrictionFactory.class));

    // Act and Assert
    assertFalse(adornedTargetListPersistenceModule.isCompatible(OperationType.NONDESTRUCTIVEREMOVE));
  }

  /**
   * Test {@link AdornedTargetListPersistenceModule#isCompatible(OperationType)}.
   * <ul>
   *   <li>Given {@link AdornedTargetListPersistenceModule} (default
   * constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#isCompatible(OperationType)}
   */
  @Test
  public void testIsCompatible_givenAdornedTargetListPersistenceModule_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new AdornedTargetListPersistenceModule()).isCompatible(OperationType.NONDESTRUCTIVEREMOVE));
  }

  /**
   * Test {@link AdornedTargetListPersistenceModule#isCompatible(OperationType)}.
   * <ul>
   *   <li>When {@code ADORNEDTARGETLIST}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#isCompatible(OperationType)}
   */
  @Test
  public void testIsCompatible_whenAdornedtargetlist_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new AdornedTargetListPersistenceModule()).isCompatible(OperationType.ADORNEDTARGETLIST));
  }

  /**
   * Test
   * {@link AdornedTargetListPersistenceModule#extractProperties(Class[], Map, List)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties() throws NumberFormatException {
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
   * Test
   * {@link AdornedTargetListPersistenceModule#extractProperties(Class[], Map, List)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties_givenHashMap_thenArrayListEmpty() throws NumberFormatException {
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
   * Test
   * {@link AdornedTargetListPersistenceModule#extractProperties(Class[], Map, List)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties_givenProperty_thenArrayListSizeIsOne() throws NumberFormatException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = new AdornedTargetListPersistenceModule();
    Class<Object> forNameResult = Object.class;
    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();

    ArrayList<Property> properties = new ArrayList<>();
    properties.add(new Property());

    // Act
    adornedTargetListPersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert that nothing has changed
    assertEquals(1, properties.size());
    Property getResult = properties.get(0);
    assertTrue(getResult.getMetadata() instanceof BasicFieldMetadata);
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertTrue(getResult.getEnabled());
  }

  /**
   * Test
   * {@link AdornedTargetListPersistenceModule#extractProperties(Class[], Map, List)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties_givenProperty_thenArrayListSizeIsTwo() throws NumberFormatException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = new AdornedTargetListPersistenceModule();
    Class<Object> forNameResult = Object.class;
    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();

    ArrayList<Property> properties = new ArrayList<>();
    properties.add(new Property());
    properties.add(new Property());

    // Act
    adornedTargetListPersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert that nothing has changed
    assertEquals(2, properties.size());
    Property getResult = properties.get(0);
    assertTrue(getResult.getMetadata() instanceof BasicFieldMetadata);
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertTrue(getResult.getEnabled());
  }

  /**
   * Test
   * {@link AdornedTargetListPersistenceModule#extractProperties(Class[], Map, List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Name is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties_thenArrayListFirstNameIs42() throws NumberFormatException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = new AdornedTargetListPersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("42", new AdornedTargetCollectionMetadata());
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.ADORNEDTARGETLIST, stringFieldMetadataMap);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    adornedTargetListPersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert
    assertEquals(2, properties.size());
    assertEquals("42", properties.get(0).getName());
    Property getResult = properties.get(1);
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
   * Test
   * {@link AdornedTargetListPersistenceModule#extractProperties(Class[], Map, List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Name is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties_thenArrayListFirstNameIsFoo() throws NumberFormatException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = new AdornedTargetListPersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("foo", new AdornedTargetCollectionMetadata());

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.ADORNEDTARGETLIST, stringFieldMetadataMap);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    adornedTargetListPersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert
    assertEquals(1, properties.size());
    assertEquals("foo", properties.get(0).getName());
  }

  /**
   * Test
   * {@link AdornedTargetListPersistenceModule#extractProperties(Class[], Map, List)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties_whenHashMap_thenArrayListEmpty() throws NumberFormatException {
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
   * Test
   * {@link AdornedTargetListPersistenceModule#getBasicFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, String)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link CriteriaTransferObject#getCriteriaMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#getBasicFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, String)}
   */
  @Test
  public void testGetBasicFilterMappings_givenHashMap_thenCallsGetCriteriaMap() {
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
   * Test
   * {@link AdornedTargetListPersistenceModule#getBasicFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, String)}.
   * <ul>
   *   <li>When {@link CriteriaTransferObject} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#getBasicFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, String)}
   */
  @Test
  public void testGetBasicFilterMappings_whenCriteriaTransferObject_thenReturnEmpty() {
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
   * Test
   * {@link AdornedTargetListPersistenceModule#getBasicFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, String)}.
   * <ul>
   *   <li>When {@link PersistencePerspective}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#getBasicFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, String)}
   */
  @Test
  public void testGetBasicFilterMappings_whenPersistencePerspective_thenReturnEmpty() {
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
   * Test
   * {@link AdornedTargetListPersistenceModule#getAdornedTargetFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, AdornedTargetList)}.
   * <p>
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
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(2, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("nullTarget");
    assertEquals("nullTarget", getResult.getPropertyId());
    assertNull(getResult.getSortAscending());
    FilterAndSortCriteria getResult2 = criteriaMap.get(null);
    assertNull(getResult2.getSortAscending());
    assertNull(getResult.getOrder());
    assertNull(getResult2.getOrder());
    assertNull(getResult2.getPropertyId());
    assertNull(getResult.getSortDirection());
    assertNull(getResult2.getSortDirection());
    assertNull(getResult.getRestrictionType());
    assertNull(getResult2.getRestrictionType());
    assertEquals(2, actualAdornedTargetFilterMappings.size());
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult2.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(getResult2.getSpecialFilterValues().isEmpty());
    assertTrue(getResult.isNullsLast());
    assertTrue(getResult2.isNullsLast());
  }

  /**
   * Test
   * {@link AdornedTargetListPersistenceModule#getAdornedTargetFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, AdornedTargetList)}.
   * <ul>
   *   <li>Then return first FilterValues Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#getAdornedTargetFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, AdornedTargetList)}
   */
  @Test
  public void testGetAdornedTargetFilterMappings_thenReturnFirstFilterValuesEmpty() throws ClassNotFoundException {
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
    assertTrue(actualAdornedTargetFilterMappings.get(0).getFilterValues().isEmpty());
    assertTrue(actualAdornedTargetFilterMappings.get(1).getFilterValues().isEmpty());
  }

  /**
   * Test
   * {@link AdornedTargetListPersistenceModule#getAdornedTargetFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, AdornedTargetList)}.
   * <ul>
   *   <li>Then return first FilterValues size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#getAdornedTargetFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, AdornedTargetList)}
   */
  @Test
  public void testGetAdornedTargetFilterMappings_thenReturnFirstFilterValuesSizeIsOne() throws ClassNotFoundException {
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
    List<String> filterValues = actualAdornedTargetFilterMappings.get(0).getFilterValues();
    assertEquals(1, filterValues.size());
    assertEquals("42", filterValues.get(0));
  }

  /**
   * Test
   * {@link AdornedTargetListPersistenceModule#getAdornedTargetFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, AdornedTargetList)}.
   * <ul>
   *   <li>Then return second DirectFilterValues Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#getAdornedTargetFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, AdornedTargetList)}
   */
  @Test
  public void testGetAdornedTargetFilterMappings_thenReturnSecondDirectFilterValuesEmpty()
      throws ClassNotFoundException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = new AdornedTargetListPersistenceModule();
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    FilterAndSortCriteria filterAndSortCriteria = mock(FilterAndSortCriteria.class);
    ArrayList<String> stringList = new ArrayList<>();
    when(filterAndSortCriteria.getFilterValues()).thenReturn(stringList);
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
    assertTrue(actualAdornedTargetFilterMappings.get(1).getDirectFilterValues().isEmpty());
    assertEquals(stringList, actualAdornedTargetFilterMappings.get(0).getDirectFilterValues());
  }

  /**
   * Test
   * {@link AdornedTargetListPersistenceModule#getAdornedTargetFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, AdornedTargetList)}.
   * <ul>
   *   <li>When {@link PersistencePerspective}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#getAdornedTargetFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, AdornedTargetList)}
   */
  @Test
  public void testGetAdornedTargetFilterMappings_whenPersistencePerspective() throws ClassNotFoundException {
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
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(2, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("nullTarget");
    assertEquals("nullTarget", getResult.getPropertyId());
    assertNull(getResult.getSortAscending());
    FilterAndSortCriteria getResult2 = criteriaMap.get(null);
    assertNull(getResult2.getSortAscending());
    assertNull(getResult.getOrder());
    assertNull(getResult2.getOrder());
    assertNull(getResult2.getPropertyId());
    assertNull(getResult.getSortDirection());
    assertNull(getResult2.getSortDirection());
    assertNull(getResult.getRestrictionType());
    assertNull(getResult2.getRestrictionType());
    assertEquals(2, actualAdornedTargetFilterMappings.size());
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult2.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(getResult2.getSpecialFilterValues().isEmpty());
    assertTrue(getResult.isNullsLast());
    assertTrue(getResult2.isNullsLast());
  }

  /**
   * Test
   * {@link AdornedTargetListPersistenceModule#updateMergedProperties(PersistencePackage, Map)}.
   * <ul>
   *   <li>Then calls
   * {@link PersistencePackage#getCeilingEntityFullyQualifiedClassname()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#updateMergedProperties(PersistencePackage, Map)}
   */
  @Test
  public void testUpdateMergedProperties_thenCallsGetCeilingEntityFullyQualifiedClassname() throws ServiceException {
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
   * Test {@link AdornedTargetListPersistenceModule#add(PersistencePackage)} with
   * {@code persistencePackage}.
   * <ul>
   *   <li>Then throw {@link SecurityServiceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#add(PersistencePackage)}
   */
  @Test
  public void testAddWithPersistencePackage_thenThrowSecurityServiceException() throws ServiceException {
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
   * Test {@link AdornedTargetListPersistenceModule#update(PersistencePackage)}
   * with {@code persistencePackage}.
   * <ul>
   *   <li>Then throw {@link SecurityServiceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#update(PersistencePackage)}
   */
  @Test
  public void testUpdateWithPersistencePackage_thenThrowSecurityServiceException() throws ServiceException {
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
   * Test {@link AdornedTargetListPersistenceModule#update(PersistencePackage)}
   * with {@code persistencePackage}.
   * <ul>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#update(PersistencePackage)}
   */
  @Test
  public void testUpdateWithPersistencePackage_thenThrowServiceException() throws ServiceException {
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
   * Test {@link AdornedTargetListPersistenceModule#remove(PersistencePackage)}.
   * <ul>
   *   <li>Given {@link AdornedTargetList} {@link AdornedTargetList#getMutable()}
   * return {@code false}.</li>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#remove(PersistencePackage)}
   */
  @Test
  public void testRemove_givenAdornedTargetListGetMutableReturnFalse_thenThrowServiceException()
      throws ServiceException {
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
   * Test {@link AdornedTargetListPersistenceModule#remove(PersistencePackage)}.
   * <ul>
   *   <li>Then calls
   * {@link AdornedTargetList#getAdornedTargetEntityClassname()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#remove(PersistencePackage)}
   */
  @Test
  public void testRemove_thenCallsGetAdornedTargetEntityClassname() throws ServiceException {
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
   * Test
   * {@link AdornedTargetListPersistenceModule#fetch(PersistencePackage, AdornedTargetList, CriteriaTransferObject)}
   * with {@code persistencePackage}, {@code adornedTargetList}, {@code cto}.
   * <p>
   * Method under test:
   * {@link AdornedTargetListPersistenceModule#fetch(PersistencePackage, AdornedTargetList, CriteriaTransferObject)}
   */
  @Test
  public void testFetchWithPersistencePackageAdornedTargetListCto() throws ClassNotFoundException {
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

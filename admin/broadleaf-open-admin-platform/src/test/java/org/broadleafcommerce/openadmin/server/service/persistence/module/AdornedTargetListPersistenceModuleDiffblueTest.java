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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.exception.SecurityServiceException;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.locale.service.LocaleService;
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
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.CriteriaTranslator;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FilterMapping;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.RestrictionFactory;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.FieldPersistenceProvider;
import org.broadleafcommerce.openadmin.server.service.persistence.validation.EntityValidatorService;
import org.broadleafcommerce.openadmin.server.service.persistence.validation.PopulateValueRequestValidator;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AdornedTargetListPersistenceModuleDiffblueTest {
  @InjectMocks
  private AdornedTargetListPersistenceModule adornedTargetListPersistenceModule;

  @Mock
  private CriteriaTranslator criteriaTranslator;

  @Mock
  private EntityValidatorService entityValidatorService;

  @Mock
  private FetchWrapper fetchWrapper;

  @Mock
  private FieldPersistenceProvider fieldPersistenceProvider;

  @Mock
  private List<FieldPersistenceProvider> list;

  @Mock
  private List<PopulateValueRequestValidator> list2;

  @Mock
  private LocaleService localeService;

  @Mock
  private RestrictionFactory restrictionFactory;

  /**
   * Test AdornedTargetRetrieval getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdornedTargetRetrieval#getFilterMappings()}
   *   <li>{@link AdornedTargetRetrieval#getIndex()}
   *   <li>{@link AdornedTargetRetrieval#getMergedProperties()}
   *   <li>{@link AdornedTargetRetrieval#getRecords()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AdornedTargetRetrieval.getFilterMappings()", "int AdornedTargetRetrieval.getIndex()",
      "Map AdornedTargetRetrieval.getMergedProperties()", "List AdornedTargetRetrieval.getRecords()"})
  public void testAdornedTargetRetrievalGettersAndSetters() {
    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = new AdornedTargetListPersistenceModule();
    PersistencePackage persistencePackage = new PersistencePackage();
    AdornedTargetList adornedTargetList = new AdornedTargetList();
    AdornedTargetRetrieval adornedTargetRetrieval = adornedTargetListPersistenceModule.new AdornedTargetRetrieval(
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
   * Test AdornedTargetRetrieval {@link AdornedTargetRetrieval#AdornedTargetRetrieval(AdornedTargetListPersistenceModule, PersistencePackage, AdornedTargetList, CriteriaTransferObject)}.
   * <ul>
   *   <li>Then return Records is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetRetrieval#AdornedTargetRetrieval(AdornedTargetListPersistenceModule, PersistencePackage, AdornedTargetList, CriteriaTransferObject)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void AdornedTargetRetrieval.<init>(AdornedTargetListPersistenceModule, PersistencePackage, AdornedTargetList, CriteriaTransferObject)"})
  public void testAdornedTargetRetrievalNewAdornedTargetRetrieval_thenReturnRecordsIsNull() {
    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = new AdornedTargetListPersistenceModule();
    PersistencePackage persistencePackage = new PersistencePackage();
    AdornedTargetList adornedTargetList = new AdornedTargetList();

    // Act
    AdornedTargetRetrieval actualAdornedTargetRetrieval = adornedTargetListPersistenceModule.new AdornedTargetRetrieval(
        persistencePackage, adornedTargetList, new CriteriaTransferObject());

    // Assert
    assertNull(actualAdornedTargetRetrieval.getRecords());
    assertNull(actualAdornedTargetRetrieval.getFilterMappings());
    assertNull(actualAdornedTargetRetrieval.getMergedProperties());
    assertEquals(0, actualAdornedTargetRetrieval.getIndex());
  }

  /**
   * Test AdornedTargetRetrieval {@link AdornedTargetRetrieval#AdornedTargetRetrieval(AdornedTargetListPersistenceModule, PersistencePackage, Entity, AdornedTargetList)}.
   * <ul>
   *   <li>Then return Records is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetRetrieval#AdornedTargetRetrieval(AdornedTargetListPersistenceModule, PersistencePackage, Entity, AdornedTargetList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void AdornedTargetRetrieval.<init>(AdornedTargetListPersistenceModule, PersistencePackage, Entity, AdornedTargetList)"})
  public void testAdornedTargetRetrievalNewAdornedTargetRetrieval_thenReturnRecordsIsNull2() {
    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = new AdornedTargetListPersistenceModule();
    PersistencePackage persistencePackage = new PersistencePackage();
    Entity entity = new Entity();

    // Act
    AdornedTargetRetrieval actualAdornedTargetRetrieval = adornedTargetListPersistenceModule.new AdornedTargetRetrieval(
        persistencePackage, entity, new AdornedTargetList());

    // Assert
    assertNull(actualAdornedTargetRetrieval.getRecords());
    assertNull(actualAdornedTargetRetrieval.getFilterMappings());
    assertNull(actualAdornedTargetRetrieval.getMergedProperties());
    assertEquals(0, actualAdornedTargetRetrieval.getIndex());
  }

  /**
   * Test {@link AdornedTargetListPersistenceModule#isCompatible(OperationType)}.
   * <ul>
   *   <li>When {@code ADORNEDTARGETLIST}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetListPersistenceModule#isCompatible(OperationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdornedTargetListPersistenceModule.isCompatible(OperationType)"})
  public void testIsCompatible_whenAdornedtargetlist_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(adornedTargetListPersistenceModule.isCompatible(OperationType.ADORNEDTARGETLIST));
  }

  /**
   * Test {@link AdornedTargetListPersistenceModule#isCompatible(OperationType)}.
   * <ul>
   *   <li>When {@code NONDESTRUCTIVEREMOVE}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetListPersistenceModule#isCompatible(OperationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdornedTargetListPersistenceModule.isCompatible(OperationType)"})
  public void testIsCompatible_whenNondestructiveremove_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(adornedTargetListPersistenceModule.isCompatible(OperationType.NONDESTRUCTIVEREMOVE));
  }

  /**
   * Test {@link AdornedTargetListPersistenceModule#extractProperties(Class[], Map, List)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetListPersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdornedTargetListPersistenceModule.extractProperties(Class[], Map, List)"})
  public void testExtractProperties_givenHashMap_thenArrayListEmpty() throws NumberFormatException {
    // Arrange
    Class<Object> forNameResult = Object.class;

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.ADORNEDTARGETLIST, new HashMap<>());
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    adornedTargetListPersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert that nothing has changed
    assertTrue(properties.isEmpty());
  }

  /**
   * Test {@link AdornedTargetListPersistenceModule#extractProperties(Class[], Map, List)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetListPersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdornedTargetListPersistenceModule.extractProperties(Class[], Map, List)"})
  public void testExtractProperties_givenProperty_whenHashMap_thenArrayListSizeIsOne() throws NumberFormatException {
    // Arrange
    Class<Object> forNameResult = Object.class;
    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();

    ArrayList<Property> properties = new ArrayList<>();
    properties.add(new Property());

    // Act
    adornedTargetListPersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert that nothing has changed
    assertEquals(1, properties.size());
    assertTrue(properties.get(0).getMetadata() instanceof BasicFieldMetadata);
  }

  /**
   * Test {@link AdornedTargetListPersistenceModule#extractProperties(Class[], Map, List)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetListPersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdornedTargetListPersistenceModule.extractProperties(Class[], Map, List)"})
  public void testExtractProperties_givenProperty_whenHashMap_thenArrayListSizeIsTwo() throws NumberFormatException {
    // Arrange
    Class<Object> forNameResult = Object.class;
    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();

    ArrayList<Property> properties = new ArrayList<>();
    properties.add(new Property());
    properties.add(new Property());

    // Act
    adornedTargetListPersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert that nothing has changed
    assertEquals(2, properties.size());
    assertTrue(properties.get(0).getMetadata() instanceof BasicFieldMetadata);
  }

  /**
   * Test {@link AdornedTargetListPersistenceModule#extractProperties(Class[], Map, List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Name is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetListPersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdornedTargetListPersistenceModule.extractProperties(Class[], Map, List)"})
  public void testExtractProperties_thenArrayListFirstNameIs42() throws NumberFormatException {
    // Arrange
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
   * Test {@link AdornedTargetListPersistenceModule#extractProperties(Class[], Map, List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Name is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetListPersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdornedTargetListPersistenceModule.extractProperties(Class[], Map, List)"})
  public void testExtractProperties_thenArrayListFirstNameIsFoo() throws NumberFormatException {
    // Arrange
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
   * Test {@link AdornedTargetListPersistenceModule#extractProperties(Class[], Map, List)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetListPersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdornedTargetListPersistenceModule.extractProperties(Class[], Map, List)"})
  public void testExtractProperties_whenHashMap_thenArrayListEmpty() throws NumberFormatException {
    // Arrange
    Class<Object> forNameResult = Object.class;
    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    adornedTargetListPersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert that nothing has changed
    assertTrue(properties.isEmpty());
  }

  /**
   * Test {@link AdornedTargetListPersistenceModule#getBasicFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, String)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link CriteriaTransferObject#getCriteriaMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetListPersistenceModule#getBasicFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List AdornedTargetListPersistenceModule.getBasicFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, String)"})
  public void testGetBasicFilterMappings_givenHashMap_thenCallsGetCriteriaMap() {
    // Arrange
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
   * Test {@link AdornedTargetListPersistenceModule#getBasicFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, String)}.
   * <ul>
   *   <li>When {@link CriteriaTransferObject} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetListPersistenceModule#getBasicFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List AdornedTargetListPersistenceModule.getBasicFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, String)"})
  public void testGetBasicFilterMappings_whenCriteriaTransferObject_thenReturnEmpty() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject cto = new CriteriaTransferObject();

    // Act and Assert
    assertTrue(adornedTargetListPersistenceModule
        .getBasicFilterMappings(persistencePerspective, cto, new HashMap<>(), "java.lang.Class")
        .isEmpty());
  }

  /**
   * Test {@link AdornedTargetListPersistenceModule#getAdornedTargetFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, AdornedTargetList)}.
   * <p>
   * Method under test: {@link AdornedTargetListPersistenceModule#getAdornedTargetFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, AdornedTargetList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List AdornedTargetListPersistenceModule.getAdornedTargetFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, AdornedTargetList)"})
  public void testGetAdornedTargetFilterMappings() throws ClassNotFoundException {
    // Arrange
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
   * Test {@link AdornedTargetListPersistenceModule#getAdornedTargetFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, AdornedTargetList)}.
   * <ul>
   *   <li>Then return first FilterValues size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetListPersistenceModule#getAdornedTargetFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, AdornedTargetList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List AdornedTargetListPersistenceModule.getAdornedTargetFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, AdornedTargetList)"})
  public void testGetAdornedTargetFilterMappings_thenReturnFirstFilterValuesSizeIsOne() throws ClassNotFoundException {
    // Arrange
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
   * Test {@link AdornedTargetListPersistenceModule#getAdornedTargetFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, AdornedTargetList)}.
   * <ul>
   *   <li>Then return first InheritedFromClass is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetListPersistenceModule#getAdornedTargetFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, AdornedTargetList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List AdornedTargetListPersistenceModule.getAdornedTargetFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, AdornedTargetList)"})
  public void testGetAdornedTargetFilterMappings_thenReturnFirstInheritedFromClassIsNull()
      throws ClassNotFoundException {
    // Arrange
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
    assertNull(getResult.getInheritedFromClass());
    FilterMapping getResult2 = actualAdornedTargetFilterMappings.get(1);
    assertNull(getResult2.getInheritedFromClass());
    assertNull(getResult.getOrder());
    assertNull(getResult2.getOrder());
    assertNull(getResult.getFullPropertyName());
    assertNull(getResult2.getFullPropertyName());
    assertNull(getResult.getSortDirection());
    assertNull(getResult2.getSortDirection());
    assertTrue(getResult.getDirectFilterValues().isEmpty());
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult2.getFilterValues().isEmpty());
    assertTrue(getResult.getNullsLast());
    assertTrue(getResult2.getNullsLast());
  }

  /**
   * Test {@link AdornedTargetListPersistenceModule#getAdornedTargetFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, AdornedTargetList)}.
   * <ul>
   *   <li>Then return second DirectFilterValues Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetListPersistenceModule#getAdornedTargetFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, AdornedTargetList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List AdornedTargetListPersistenceModule.getAdornedTargetFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, AdornedTargetList)"})
  public void testGetAdornedTargetFilterMappings_thenReturnSecondDirectFilterValuesEmpty()
      throws ClassNotFoundException {
    // Arrange
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
   * Test {@link AdornedTargetListPersistenceModule#updateMergedProperties(PersistencePackage, Map)}.
   * <ul>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetListPersistenceModule#updateMergedProperties(PersistencePackage, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdornedTargetListPersistenceModule.updateMergedProperties(PersistencePackage, Map)"})
  public void testUpdateMergedProperties_thenThrowServiceException() throws ServiceException {
    // Arrange
    AdornedTargetList adornedTargetList = mock(AdornedTargetList.class);
    when(adornedTargetList.getAdornedTargetEntityClassname()).thenThrow(new NumberFormatException("foo"));

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = new HashMap<>();
    persistencePerspectiveItems.put(PersistencePerspectiveItemType.ADORNEDTARGETLIST, adornedTargetList);

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setPersistencePerspectiveItems(persistencePerspectiveItems);

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(persistencePerspective);

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> adornedTargetListPersistenceModule.updateMergedProperties(persistencePackage, new HashMap<>()));
    verify(adornedTargetList).getAdornedTargetEntityClassname();
  }

  /**
   * Test {@link AdornedTargetListPersistenceModule#add(PersistencePackage)} with {@code persistencePackage}.
   * <ul>
   *   <li>Then throw {@link SecurityServiceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetListPersistenceModule#add(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Entity AdornedTargetListPersistenceModule.add(PersistencePackage)"})
  public void testAddWithPersistencePackage_thenThrowSecurityServiceException() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link AdornedTargetListPersistenceModule#update(PersistencePackage)} with {@code persistencePackage}.
   * <ul>
   *   <li>Then throw {@link SecurityServiceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetListPersistenceModule#update(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Entity AdornedTargetListPersistenceModule.update(PersistencePackage)"})
  public void testUpdateWithPersistencePackage_thenThrowSecurityServiceException() throws ServiceException {
    // Arrange
    AdornedTargetList item = mock(AdornedTargetList.class);
    when(item.getMutable()).thenReturn(false);

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST, item);
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(persistencePerspective);

    // Act and Assert
    assertThrows(SecurityServiceException.class, () -> adornedTargetListPersistenceModule.update(persistencePackage));
    verify(item).getMutable();
  }

  /**
   * Test {@link AdornedTargetListPersistenceModule#update(PersistencePackage)} with {@code persistencePackage}.
   * <ul>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetListPersistenceModule#update(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Entity AdornedTargetListPersistenceModule.update(PersistencePackage)"})
  public void testUpdateWithPersistencePackage_thenThrowServiceException() throws ServiceException {
    // Arrange
    AdornedTargetList item = mock(AdornedTargetList.class);
    when(item.getCollectionFieldName()).thenThrow(new NumberFormatException("foo"));
    when(item.getMutable()).thenReturn(true);

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST, item);
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(persistencePerspective);

    // Act and Assert
    assertThrows(ServiceException.class, () -> adornedTargetListPersistenceModule.update(persistencePackage));
    verify(item).getCollectionFieldName();
    verify(item).getMutable();
  }

  /**
   * Test {@link AdornedTargetListPersistenceModule#remove(PersistencePackage)}.
   * <ul>
   *   <li>Given {@link AdornedTargetList} {@link AdornedTargetList#getMutable()} return {@code false}.</li>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetListPersistenceModule#remove(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdornedTargetListPersistenceModule.remove(PersistencePackage)"})
  public void testRemove_givenAdornedTargetListGetMutableReturnFalse_thenThrowServiceException()
      throws ServiceException {
    // Arrange
    AdornedTargetList item = mock(AdornedTargetList.class);
    when(item.getMutable()).thenReturn(false);

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST, item);
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(persistencePerspective);

    // Act and Assert
    assertThrows(ServiceException.class, () -> adornedTargetListPersistenceModule.remove(persistencePackage));
    verify(item).getMutable();
  }

  /**
   * Test {@link AdornedTargetListPersistenceModule#remove(PersistencePackage)}.
   * <ul>
   *   <li>Then calls {@link AdornedTargetList#getAdornedTargetEntityClassname()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetListPersistenceModule#remove(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdornedTargetListPersistenceModule.remove(PersistencePackage)"})
  public void testRemove_thenCallsGetAdornedTargetEntityClassname() throws ServiceException {
    // Arrange
    AdornedTargetList item = mock(AdornedTargetList.class);
    when(item.getAdornedTargetEntityClassname()).thenThrow(new NumberFormatException("foo"));
    when(item.getMutable()).thenReturn(true);

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST, item);
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(persistencePerspective);

    // Act and Assert
    assertThrows(ServiceException.class, () -> adornedTargetListPersistenceModule.remove(persistencePackage));
    verify(item).getAdornedTargetEntityClassname();
    verify(item).getMutable();
  }

  /**
   * Test {@link AdornedTargetListPersistenceModule#fetch(PersistencePackage, AdornedTargetList, CriteriaTransferObject)} with {@code persistencePackage}, {@code adornedTargetList}, {@code cto}.
   * <p>
   * Method under test: {@link AdornedTargetListPersistenceModule#fetch(PersistencePackage, AdornedTargetList, CriteriaTransferObject)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List AdornedTargetListPersistenceModule.fetch(PersistencePackage, AdornedTargetList, CriteriaTransferObject)"})
  public void testFetchWithPersistencePackageAdornedTargetListCto() throws ClassNotFoundException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getMergedProperties(Mockito.<String>any(), Mockito.<Class<Object>[]>any(),
        Mockito.<ForeignKey>any(), Mockito.<String[]>any(), Mockito.<ForeignKey[]>any(),
        Mockito.<MergedPropertyType>any(), Mockito.<Boolean>any(), Mockito.<String[]>any(), Mockito.<String[]>any(),
        Mockito.<String>any(), Mockito.<String>any())).thenReturn(new HashMap<>());
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>[]>when(persistenceManager.getPolymorphicEntities(Mockito.<String>any()))
        .thenReturn(new Class[]{forNameResult});
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = new AdornedTargetListPersistenceModule();
    adornedTargetListPersistenceModule.setPersistenceManager(persistenceManager);
    Entity entity = new Entity();
    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria"}, "ABC123");

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
    verify(dynamicEntityDaoImpl).getMergedProperties(eq("Adorned Target Entity Classname"), isA(Class[].class),
        isNull(), isA(String[].class), isA(ForeignKey[].class), eq(MergedPropertyType.ADORNEDTARGETLIST), eq(false),
        isA(String[].class), isA(String[].class), isNull(), eq(""));
    verify(persistenceManager).getDynamicEntityDao();
    verify(persistenceManager).getPolymorphicEntities(eq("Adorned Target Entity Classname"));
  }
}

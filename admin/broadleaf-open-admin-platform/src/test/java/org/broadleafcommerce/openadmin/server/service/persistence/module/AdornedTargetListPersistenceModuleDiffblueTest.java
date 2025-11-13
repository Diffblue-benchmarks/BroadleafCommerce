package org.broadleafcommerce.openadmin.server.service.persistence.module;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.broadleafcommerce.openadmin.dto.OperationTypes;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.PersistencePerspectiveItem;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule.AdornedTargetRetrieval;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FilterMapping;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class AdornedTargetListPersistenceModuleDiffblueTest {
  /**
   * Test AdornedTargetRetrieval getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AdornedTargetRetrieval#getFilterMappings()}
   *   <li>{@link AdornedTargetRetrieval#getIndex()}
   *   <li>{@link AdornedTargetRetrieval#getMergedProperties()}
   *   <li>{@link AdornedTargetRetrieval#getRecords()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AdornedTargetRetrieval.getFilterMappings()",
    "int AdornedTargetRetrieval.getIndex()",
    "Map AdornedTargetRetrieval.getMergedProperties()",
    "List AdornedTargetRetrieval.getRecords()"
  })
  public void testAdornedTargetRetrievalGettersAndSetters() {
    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        new AdornedTargetListPersistenceModule();
    PersistencePackage persistencePackage = new PersistencePackage();
    AdornedTargetList adornedTargetList = new AdornedTargetList();

    AdornedTargetRetrieval adornedTargetRetrieval =
        adornedTargetListPersistenceModule
        .new AdornedTargetRetrieval(
            persistencePackage, adornedTargetList, new CriteriaTransferObject());

    // Act
    List<FilterMapping> actualFilterMappings = adornedTargetRetrieval.getFilterMappings();
    int actualIndex = adornedTargetRetrieval.getIndex();
    Map<String, FieldMetadata> actualMergedProperties =
        adornedTargetRetrieval.getMergedProperties();

    // Assert
    assertNull(adornedTargetRetrieval.getRecords());
    assertNull(actualFilterMappings);
    assertNull(actualMergedProperties);
    assertEquals(0, actualIndex);
  }

  /**
   * Test AdornedTargetRetrieval {@link
   * AdornedTargetRetrieval#AdornedTargetRetrieval(AdornedTargetListPersistenceModule,
   * PersistencePackage, AdornedTargetList, CriteriaTransferObject)}.
   *
   * <ul>
   *   <li>Then return Records is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdornedTargetRetrieval#AdornedTargetRetrieval(AdornedTargetListPersistenceModule,
   * PersistencePackage, AdornedTargetList, CriteriaTransferObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdornedTargetRetrieval.<init>(AdornedTargetListPersistenceModule, PersistencePackage, AdornedTargetList, CriteriaTransferObject)"
  })
  public void testAdornedTargetRetrievalNewAdornedTargetRetrieval_thenReturnRecordsIsNull() {
    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        new AdornedTargetListPersistenceModule();
    PersistencePackage persistencePackage = new PersistencePackage();
    AdornedTargetList adornedTargetList = new AdornedTargetList();

    // Act
    AdornedTargetRetrieval actualAdornedTargetRetrieval =
        adornedTargetListPersistenceModule
        .new AdornedTargetRetrieval(
            persistencePackage, adornedTargetList, new CriteriaTransferObject());

    // Assert
    assertNull(actualAdornedTargetRetrieval.getRecords());
    assertNull(actualAdornedTargetRetrieval.getFilterMappings());
    assertNull(actualAdornedTargetRetrieval.getMergedProperties());
    assertEquals(0, actualAdornedTargetRetrieval.getIndex());
  }

  /**
   * Test AdornedTargetRetrieval {@link
   * AdornedTargetRetrieval#AdornedTargetRetrieval(AdornedTargetListPersistenceModule,
   * PersistencePackage, Entity, AdornedTargetList)}.
   *
   * <ul>
   *   <li>Then return Records is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdornedTargetRetrieval#AdornedTargetRetrieval(AdornedTargetListPersistenceModule,
   * PersistencePackage, Entity, AdornedTargetList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdornedTargetRetrieval.<init>(AdornedTargetListPersistenceModule, PersistencePackage, Entity, AdornedTargetList)"
  })
  public void testAdornedTargetRetrievalNewAdornedTargetRetrieval_thenReturnRecordsIsNull2() {
    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        new AdornedTargetListPersistenceModule();
    PersistencePackage persistencePackage = new PersistencePackage();
    Entity entity = new Entity();

    // Act
    AdornedTargetRetrieval actualAdornedTargetRetrieval =
        adornedTargetListPersistenceModule
        .new AdornedTargetRetrieval(persistencePackage, entity, new AdornedTargetList());

    // Assert
    assertNull(actualAdornedTargetRetrieval.getRecords());
    assertNull(actualAdornedTargetRetrieval.getFilterMappings());
    assertNull(actualAdornedTargetRetrieval.getMergedProperties());
    assertEquals(0, actualAdornedTargetRetrieval.getIndex());
  }

  /**
   * Test {@link AdornedTargetListPersistenceModule#isCompatible(OperationType)}.
   *
   * <ul>
   *   <li>When {@code ADORNEDTARGETLIST}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AdornedTargetListPersistenceModule#isCompatible(OperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdornedTargetListPersistenceModule.isCompatible(OperationType)"})
  public void testIsCompatible_whenAdornedtargetlist_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new AdornedTargetListPersistenceModule().isCompatible(OperationType.ADORNEDTARGETLIST));
  }

  /**
   * Test {@link AdornedTargetListPersistenceModule#isCompatible(OperationType)}.
   *
   * <ul>
   *   <li>When {@code NONDESTRUCTIVEREMOVE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AdornedTargetListPersistenceModule#isCompatible(OperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdornedTargetListPersistenceModule.isCompatible(OperationType)"})
  public void testIsCompatible_whenNondestructiveremove_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new AdornedTargetListPersistenceModule().isCompatible(OperationType.NONDESTRUCTIVEREMOVE));
  }

  /**
   * Test {@link AdornedTargetListPersistenceModule#extractProperties(Class[], Map, List)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdornedTargetListPersistenceModule#extractProperties(Class[], Map,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdornedTargetListPersistenceModule.extractProperties(Class[], Map, List)"
  })
  public void testExtractProperties_givenHashMap_thenArrayListEmpty() throws NumberFormatException {
    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        new AdornedTargetListPersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.ADORNEDTARGETLIST, new HashMap<>());
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    adornedTargetListPersistenceModule.extractProperties(
        new Class[] {forNameResult}, mergedProperties, properties);

    // Assert that nothing has changed
    assertTrue(properties.isEmpty());
  }

  /**
   * Test {@link AdornedTargetListPersistenceModule#extractProperties(Class[], Map, List)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link AdornedTargetListPersistenceModule#extractProperties(Class[], Map,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdornedTargetListPersistenceModule.extractProperties(Class[], Map, List)"
  })
  public void testExtractProperties_thenArrayListSizeIsOne() throws NumberFormatException {
    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        new AdornedTargetListPersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.ADORNEDTARGETLIST, stringFieldMetadataMap);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    adornedTargetListPersistenceModule.extractProperties(
        new Class[] {forNameResult}, mergedProperties, properties);

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
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link AdornedTargetListPersistenceModule#extractProperties(Class[], Map,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdornedTargetListPersistenceModule.extractProperties(Class[], Map, List)"
  })
  public void testExtractProperties_thenArrayListSizeIsTwo() throws NumberFormatException {
    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        new AdornedTargetListPersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("42", new AdornedTargetCollectionMetadata());
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.ADORNEDTARGETLIST, stringFieldMetadataMap);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    adornedTargetListPersistenceModule.extractProperties(
        new Class[] {forNameResult}, mergedProperties, properties);

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
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdornedTargetListPersistenceModule#extractProperties(Class[], Map,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdornedTargetListPersistenceModule.extractProperties(Class[], Map, List)"
  })
  public void testExtractProperties_whenHashMap_thenArrayListEmpty() throws NumberFormatException {
    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        new AdornedTargetListPersistenceModule();
    Class<Object> forNameResult = Object.class;
    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    adornedTargetListPersistenceModule.extractProperties(
        new Class[] {forNameResult}, mergedProperties, properties);

    // Assert that nothing has changed
    assertTrue(properties.isEmpty());
  }

  /**
   * Test {@link AdornedTargetListPersistenceModule#getBasicFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, Map, String)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then calls {@link CriteriaTransferObject#getCriteriaMap()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdornedTargetListPersistenceModule#getBasicFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AdornedTargetListPersistenceModule.getBasicFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, String)"
  })
  public void testGetBasicFilterMappings_givenHashMap_thenCallsGetCriteriaMap() {
    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        new AdornedTargetListPersistenceModule();
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());

    // Act
    List<FilterMapping> actualBasicFilterMappings =
        adornedTargetListPersistenceModule.getBasicFilterMappings(
            persistencePerspective, cto, new HashMap<>(), "java.lang.Class");

    // Assert
    verify(cto).getCriteriaMap();
    assertTrue(actualBasicFilterMappings.isEmpty());
  }

  /**
   * Test {@link AdornedTargetListPersistenceModule#getBasicFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, Map, String)}.
   *
   * <ul>
   *   <li>When {@link CriteriaTransferObject} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdornedTargetListPersistenceModule#getBasicFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AdornedTargetListPersistenceModule.getBasicFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, String)"
  })
  public void testGetBasicFilterMappings_whenCriteriaTransferObject_thenReturnEmpty() {
    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        new AdornedTargetListPersistenceModule();
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject cto = new CriteriaTransferObject();

    // Act and Assert
    assertTrue(
        adornedTargetListPersistenceModule
            .getBasicFilterMappings(persistencePerspective, cto, new HashMap<>(), "java.lang.Class")
            .isEmpty());
  }

  /**
   * Test {@link
   * AdornedTargetListPersistenceModule#getAdornedTargetFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, Map, AdornedTargetList)}.
   *
   * <p>Method under test: {@link
   * AdornedTargetListPersistenceModule#getAdornedTargetFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, Map, AdornedTargetList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AdornedTargetListPersistenceModule.getAdornedTargetFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, AdornedTargetList)"
  })
  public void testGetAdornedTargetFilterMappings() throws ClassNotFoundException {
    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        new AdornedTargetListPersistenceModule();
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject cto = new CriteriaTransferObject();
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();

    // Act
    List<FilterMapping> actualAdornedTargetFilterMappings =
        adornedTargetListPersistenceModule.getAdornedTargetFilterMappings(
            persistencePerspective, cto, mergedProperties, new AdornedTargetList());

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
   * Test {@link
   * AdornedTargetListPersistenceModule#getAdornedTargetFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, Map, AdornedTargetList)}.
   *
   * <ul>
   *   <li>Then return first FilterValues size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdornedTargetListPersistenceModule#getAdornedTargetFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, Map, AdornedTargetList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AdornedTargetListPersistenceModule.getAdornedTargetFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, AdornedTargetList)"
  })
  public void testGetAdornedTargetFilterMappings_thenReturnFirstFilterValuesSizeIsOne()
      throws ClassNotFoundException {
    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        new AdornedTargetListPersistenceModule();
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(new FilterAndSortCriteria("42", "42"));
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();

    // Act
    List<FilterMapping> actualAdornedTargetFilterMappings =
        adornedTargetListPersistenceModule.getAdornedTargetFilterMappings(
            persistencePerspective, cto, mergedProperties, new AdornedTargetList());

    // Assert
    verify(cto, atLeast(1)).get(Mockito.<String>any());
    verify(cto).getCriteriaMap();
    assertEquals(2, actualAdornedTargetFilterMappings.size());
    List<String> filterValues = actualAdornedTargetFilterMappings.get(0).getFilterValues();
    assertEquals(1, filterValues.size());
    assertEquals("42", filterValues.get(0));
  }

  /**
   * Test {@link
   * AdornedTargetListPersistenceModule#getAdornedTargetFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, Map, AdornedTargetList)}.
   *
   * <ul>
   *   <li>Then return first InheritedFromClass is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdornedTargetListPersistenceModule#getAdornedTargetFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, Map, AdornedTargetList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AdornedTargetListPersistenceModule.getAdornedTargetFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, AdornedTargetList)"
  })
  public void testGetAdornedTargetFilterMappings_thenReturnFirstInheritedFromClassIsNull()
      throws ClassNotFoundException {
    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        new AdornedTargetListPersistenceModule();
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(new FilterAndSortCriteria("42"));
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();

    // Act
    List<FilterMapping> actualAdornedTargetFilterMappings =
        adornedTargetListPersistenceModule.getAdornedTargetFilterMappings(
            persistencePerspective, cto, mergedProperties, new AdornedTargetList());

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
   * Test {@link
   * AdornedTargetListPersistenceModule#getAdornedTargetFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, Map, AdornedTargetList)}.
   *
   * <ul>
   *   <li>Then return second DirectFilterValues Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdornedTargetListPersistenceModule#getAdornedTargetFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, Map, AdornedTargetList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AdornedTargetListPersistenceModule.getAdornedTargetFilterMappings(PersistencePerspective, CriteriaTransferObject, Map, AdornedTargetList)"
  })
  public void testGetAdornedTargetFilterMappings_thenReturnSecondDirectFilterValuesEmpty()
      throws ClassNotFoundException {
    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        new AdornedTargetListPersistenceModule();
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    FilterAndSortCriteria filterAndSortCriteria = mock(FilterAndSortCriteria.class);
    ArrayList<String> stringList = new ArrayList<>();
    when(filterAndSortCriteria.getFilterValues()).thenReturn(stringList);

    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(filterAndSortCriteria);
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();

    // Act
    List<FilterMapping> actualAdornedTargetFilterMappings =
        adornedTargetListPersistenceModule.getAdornedTargetFilterMappings(
            persistencePerspective, cto, mergedProperties, new AdornedTargetList());

    // Assert
    verify(cto, atLeast(1)).get(Mockito.<String>any());
    verify(cto).getCriteriaMap();
    verify(filterAndSortCriteria, atLeast(1)).getFilterValues();
    assertEquals(2, actualAdornedTargetFilterMappings.size());
    assertTrue(actualAdornedTargetFilterMappings.get(1).getDirectFilterValues().isEmpty());
    assertEquals(stringList, actualAdornedTargetFilterMappings.get(0).getDirectFilterValues());
  }

  /**
   * Test {@link AdornedTargetListPersistenceModule#updateMergedProperties(PersistencePackage,
   * Map)}.
   *
   * <ul>
   *   <li>Given {@link PersistencePerspective#PersistencePerspective()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdornedTargetListPersistenceModule#updateMergedProperties(PersistencePackage, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdornedTargetListPersistenceModule.updateMergedProperties(PersistencePackage, Map)"
  })
  public void testUpdateMergedProperties_givenPersistencePerspective_thenDoesNotThrow()
      throws ServiceException {
    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        new AdornedTargetListPersistenceModule();

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(new PersistencePerspective());

    // Act and Assert
    adornedTargetListPersistenceModule.updateMergedProperties(persistencePackage, new HashMap<>());
  }

  /**
   * Test {@link AdornedTargetListPersistenceModule#updateMergedProperties(PersistencePackage,
   * Map)}.
   *
   * <ul>
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdornedTargetListPersistenceModule#updateMergedProperties(PersistencePackage, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdornedTargetListPersistenceModule.updateMergedProperties(PersistencePackage, Map)"
  })
  public void testUpdateMergedProperties_thenThrowServiceException() throws ServiceException {
    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        new AdornedTargetListPersistenceModule();

    AdornedTargetList adornedTargetList = mock(AdornedTargetList.class);
    when(adornedTargetList.getAdornedTargetEntityClassname())
        .thenThrow(new NumberFormatException());

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItems = new HashMap<>();
    persistencePerspectiveItems.put(
        PersistencePerspectiveItemType.ADORNEDTARGETLIST, adornedTargetList);
    OperationTypes operationTypes = new OperationTypes();
    String[] additionalNonPersistentProperties =
        new String[] {"Additional Non Persistent Properties"};
    ForeignKey[] additionalForeignKeys = new ForeignKey[] {new ForeignKey()};

    PersistencePerspective persistencePerspective =
        new PersistencePerspective(
            operationTypes, additionalNonPersistentProperties, additionalForeignKeys);
    persistencePerspective.setPersistencePerspectiveItems(persistencePerspectiveItems);
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", new Entity(), persistencePerspective, customCriteria, "ABC123");

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> allMergedProperties = new HashMap<>();
    allMergedProperties.put(MergedPropertyType.ADORNEDTARGETLIST, new HashMap<>());

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            adornedTargetListPersistenceModule.updateMergedProperties(
                persistencePackage, allMergedProperties));
    verify(adornedTargetList).getAdornedTargetEntityClassname();
  }

  /**
   * Test {@link AdornedTargetListPersistenceModule#add(PersistencePackage)} with {@code
   * persistencePackage}.
   *
   * <ul>
   *   <li>Then throw {@link SecurityServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link AdornedTargetListPersistenceModule#add(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity AdornedTargetListPersistenceModule.add(PersistencePackage)"})
  public void testAddWithPersistencePackage_thenThrowSecurityServiceException()
      throws ServiceException {
    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        new AdornedTargetListPersistenceModule();

    AdornedTargetList adornedTargetList = mock(AdornedTargetList.class);
    when(adornedTargetList.getMutable()).thenReturn(false);
    doNothing().when(adornedTargetList).setSortField(Mockito.<String>any());
    adornedTargetList.setSortField(null);

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItems = new HashMap<>();
    persistencePerspectiveItems.put(
        PersistencePerspectiveItemType.ADORNEDTARGETLIST, adornedTargetList);
    OperationTypes operationTypes = new OperationTypes();
    String[] additionalNonPersistentProperties =
        new String[] {"Additional Non Persistent Properties"};
    ForeignKey[] additionalForeignKeys = new ForeignKey[] {new ForeignKey()};

    PersistencePerspective persistencePerspective =
        new PersistencePerspective(
            operationTypes, additionalNonPersistentProperties, additionalForeignKeys);
    persistencePerspective.setPersistencePerspectiveItems(persistencePerspectiveItems);
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", new Entity(), persistencePerspective, customCriteria, "ABC123");

    // Act and Assert
    assertThrows(
        SecurityServiceException.class,
        () -> adornedTargetListPersistenceModule.add(persistencePackage));
    verify(adornedTargetList).getMutable();
    verify(adornedTargetList).setSortField(null);
  }

  /**
   * Test {@link AdornedTargetListPersistenceModule#update(PersistencePackage)} with {@code
   * persistencePackage}.
   *
   * <p>Method under test: {@link AdornedTargetListPersistenceModule#update(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity AdornedTargetListPersistenceModule.update(PersistencePackage)"})
  public void testUpdateWithPersistencePackage() throws ServiceException {
    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        new AdornedTargetListPersistenceModule();

    AdornedTargetList item = mock(AdornedTargetList.class);
    when(item.getCollectionFieldName()).thenThrow(new NumberFormatException());
    when(item.getMutable()).thenReturn(true);

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(
        PersistencePerspectiveItemType.ADORNEDTARGETLIST, item);
    persistencePerspective.addPersistencePerspectiveItem(
        PersistencePerspectiveItemType.FOREIGNKEY, new AdornedTargetList());
    Entity entity = new Entity();

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), new String[] {}, "ABC123");
    persistencePackage.setPersistencePerspective(persistencePerspective);

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () -> adornedTargetListPersistenceModule.update(persistencePackage));
    verify(item).getCollectionFieldName();
    verify(item).getMutable();
  }

  /**
   * Test {@link AdornedTargetListPersistenceModule#update(PersistencePackage)} with {@code
   * persistencePackage}.
   *
   * <ul>
   *   <li>Then throw {@link SecurityServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link AdornedTargetListPersistenceModule#update(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity AdornedTargetListPersistenceModule.update(PersistencePackage)"})
  public void testUpdateWithPersistencePackage_thenThrowSecurityServiceException()
      throws ServiceException {
    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        new AdornedTargetListPersistenceModule();

    AdornedTargetList item = mock(AdornedTargetList.class);
    when(item.getMutable()).thenReturn(false);

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(
        PersistencePerspectiveItemType.ADORNEDTARGETLIST, item);
    persistencePerspective.addPersistencePerspectiveItem(
        PersistencePerspectiveItemType.FOREIGNKEY, new AdornedTargetList());

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(persistencePerspective);

    // Act and Assert
    assertThrows(
        SecurityServiceException.class,
        () -> adornedTargetListPersistenceModule.update(persistencePackage));
    verify(item).getMutable();
  }

  /**
   * Test {@link AdornedTargetListPersistenceModule#update(PersistencePackage)} with {@code
   * persistencePackage}.
   *
   * <ul>
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link AdornedTargetListPersistenceModule#update(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity AdornedTargetListPersistenceModule.update(PersistencePackage)"})
  public void testUpdateWithPersistencePackage_thenThrowServiceException() throws ServiceException {
    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        new AdornedTargetListPersistenceModule();

    AdornedTargetList item = mock(AdornedTargetList.class);
    when(item.getCollectionFieldName()).thenThrow(new NumberFormatException());
    when(item.getMutable()).thenReturn(true);

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(
        PersistencePerspectiveItemType.ADORNEDTARGETLIST, item);
    persistencePerspective.addPersistencePerspectiveItem(
        PersistencePerspectiveItemType.FOREIGNKEY, new AdornedTargetList());

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(persistencePerspective);

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () -> adornedTargetListPersistenceModule.update(persistencePackage));
    verify(item).getCollectionFieldName();
    verify(item).getMutable();
  }

  /**
   * Test {@link AdornedTargetListPersistenceModule#remove(PersistencePackage)}.
   *
   * <p>Method under test: {@link AdornedTargetListPersistenceModule#remove(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdornedTargetListPersistenceModule.remove(PersistencePackage)"})
  public void testRemove() throws ServiceException {
    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        new AdornedTargetListPersistenceModule();

    AdornedTargetList adornedTargetList = mock(AdornedTargetList.class);
    when(adornedTargetList.getAdornedTargetEntityClassname())
        .thenThrow(new NumberFormatException());
    when(adornedTargetList.getMutable()).thenReturn(true);

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItemTypePersistencePerspectiveItemMap = new HashMap<>();
    persistencePerspectiveItemTypePersistencePerspectiveItemMap.put(
        PersistencePerspectiveItemType.ADORNEDTARGETLIST, adornedTargetList);

    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getPersistencePerspectiveItems())
        .thenReturn(persistencePerspectiveItemTypePersistencePerspectiveItemMap);
    Entity entity = new Entity();

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), new String[] {}, "ABC123");
    persistencePackage.setPersistencePerspective(persistencePerspective);

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () -> adornedTargetListPersistenceModule.remove(persistencePackage));
    verify(adornedTargetList).getAdornedTargetEntityClassname();
    verify(adornedTargetList).getMutable();
    verify(persistencePerspective).getPersistencePerspectiveItems();
  }

  /**
   * Test {@link AdornedTargetListPersistenceModule#remove(PersistencePackage)}.
   *
   * <ul>
   *   <li>Given {@link AdornedTargetList} {@link AdornedTargetList#getMutable()} return {@code
   *       false}.
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link AdornedTargetListPersistenceModule#remove(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdornedTargetListPersistenceModule.remove(PersistencePackage)"})
  public void testRemove_givenAdornedTargetListGetMutableReturnFalse_thenThrowServiceException()
      throws ServiceException {
    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        new AdornedTargetListPersistenceModule();

    AdornedTargetList adornedTargetList = mock(AdornedTargetList.class);
    when(adornedTargetList.getMutable()).thenReturn(false);

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItemTypePersistencePerspectiveItemMap = new HashMap<>();
    persistencePerspectiveItemTypePersistencePerspectiveItemMap.put(
        PersistencePerspectiveItemType.ADORNEDTARGETLIST, adornedTargetList);

    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getPersistencePerspectiveItems())
        .thenReturn(persistencePerspectiveItemTypePersistencePerspectiveItemMap);

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(persistencePerspective);

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () -> adornedTargetListPersistenceModule.remove(persistencePackage));
    verify(adornedTargetList).getMutable();
    verify(persistencePerspective).getPersistencePerspectiveItems();
  }

  /**
   * Test {@link AdornedTargetListPersistenceModule#remove(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then calls {@link AdornedTargetList#getAdornedTargetEntityClassname()}.
   * </ul>
   *
   * <p>Method under test: {@link AdornedTargetListPersistenceModule#remove(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdornedTargetListPersistenceModule.remove(PersistencePackage)"})
  public void testRemove_thenCallsGetAdornedTargetEntityClassname() throws ServiceException {
    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        new AdornedTargetListPersistenceModule();

    AdornedTargetList adornedTargetList = mock(AdornedTargetList.class);
    when(adornedTargetList.getAdornedTargetEntityClassname())
        .thenThrow(new NumberFormatException());
    when(adornedTargetList.getMutable()).thenReturn(true);

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItemTypePersistencePerspectiveItemMap = new HashMap<>();
    persistencePerspectiveItemTypePersistencePerspectiveItemMap.put(
        PersistencePerspectiveItemType.ADORNEDTARGETLIST, adornedTargetList);

    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getPersistencePerspectiveItems())
        .thenReturn(persistencePerspectiveItemTypePersistencePerspectiveItemMap);

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(persistencePerspective);

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () -> adornedTargetListPersistenceModule.remove(persistencePackage));
    verify(adornedTargetList).getAdornedTargetEntityClassname();
    verify(adornedTargetList).getMutable();
    verify(persistencePerspective).getPersistencePerspectiveItems();
  }
}

package org.broadleafcommerce.admin.server.service.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.FilterAndSortCriteria;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SkuLookupByProductCustomPersistenceHandlerDiffblueTest {
  @Mock private CatalogService catalogService;

  @Mock private SkuCustomPersistenceHandler skuCustomPersistenceHandler;

  @InjectMocks
  private SkuLookupByProductCustomPersistenceHandler skuLookupByProductCustomPersistenceHandler;

  /**
   * Test {@link SkuLookupByProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * SkuLookupByProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean SkuLookupByProductCustomPersistenceHandler.canHandleFetch(PersistencePackage)"
  })
  public void testCanHandleFetch() {
    // Arrange
    SkuLookupByProductCustomPersistenceHandler skuLookupByProductCustomPersistenceHandler =
        new SkuLookupByProductCustomPersistenceHandler();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act
    Boolean actualCanHandleFetchResult =
        skuLookupByProductCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    assertFalse(actualCanHandleFetchResult);
  }

  /**
   * Test {@link SkuLookupByProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then calls {@link PersistencePackage#getCeilingEntityFullyQualifiedClassname()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SkuLookupByProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean SkuLookupByProductCustomPersistenceHandler.canHandleFetch(PersistencePackage)"
  })
  public void testCanHandleFetch_thenCallsGetCeilingEntityFullyQualifiedClassname() {
    // Arrange
    SkuLookupByProductCustomPersistenceHandler skuLookupByProductCustomPersistenceHandler =
        new SkuLookupByProductCustomPersistenceHandler();

    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[] {"Custom Criteria"});

    // Act
    Boolean actualCanHandleFetchResult =
        skuLookupByProductCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualCanHandleFetchResult);
  }

  /**
   * Test {@link SkuLookupByProductCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Given array of {@link Entity} with {@link Entity} (default constructor).
   *   <li>Then calls {@link FilterAndSortCriteria#getFilterValues()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SkuLookupByProductCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DynamicResultSet SkuLookupByProductCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"
  })
  public void testFetch_givenArrayOfEntityWithEntity_thenCallsGetFilterValues()
      throws ServiceException {
    // Arrange
    doNothing()
        .when(skuCustomPersistenceHandler)
        .updateProductOptionFieldsForFetch(
            Mockito.<List<Serializable>>any(), Mockito.<Entity[]>any());

    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());

    FilterAndSortCriteria filterAndSortCriteria = mock(FilterAndSortCriteria.class);
    when(filterAndSortCriteria.getFilterValues()).thenReturn(new ArrayList<>());

    HashMap<String, FilterAndSortCriteria> stringFilterAndSortCriteriaMap = new HashMap<>();
    stringFilterAndSortCriteriaMap.put("productId", filterAndSortCriteria);

    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(stringFilterAndSortCriteriaMap);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getSimpleMergedProperties(
            Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    when(helper.getRecords(
            Mockito.<Map<String, FieldMetadata>>any(), Mockito.<List<Serializable>>any()))
        .thenReturn(new Entity[] {new Entity()});

    // Act
    DynamicResultSet actualFetchResult =
        skuLookupByProductCustomPersistenceHandler.fetch(
            persistencePackage, cto, dynamicEntityDao, helper);

    // Assert
    verify(skuCustomPersistenceHandler)
        .updateProductOptionFieldsForFetch(isA(List.class), isA(Entity[].class));
    verify(cto).getCriteriaMap();
    verify(filterAndSortCriteria).getFilterValues();
    verify(persistencePackage).getPersistencePerspective();
    verify(helper).getRecords(isA(Map.class), isA(List.class));
    verify(helper)
        .getSimpleMergedProperties(
            eq("org.broadleafcommerce.core.catalog.domain.Sku"), isA(PersistencePerspective.class));
    assertNull(actualFetchResult.getPromptSearch());
    assertNull(actualFetchResult.getTotalCountLessThanPageSize());
    assertNull(actualFetchResult.getBatchId());
    assertNull(actualFetchResult.getLowerCount());
    assertNull(actualFetchResult.getUpperCount());
    assertNull(actualFetchResult.getFirstId());
    assertNull(actualFetchResult.getLastId());
    assertNull(actualFetchResult.getClassMetaData());
    assertNull(actualFetchResult.getFetchType());
    assertEquals(0, actualFetchResult.getPageSize().intValue());
    assertEquals(0, actualFetchResult.getStartIndex().intValue());
    assertEquals(1, actualFetchResult.getTotalRecords().intValue());
    assertEquals(1, actualFetchResult.getRecords().length);
    assertTrue(actualFetchResult.getUnselectedTabMetadata().isEmpty());
  }

  /**
   * Test {@link SkuLookupByProductCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} All is {@link HashMap#HashMap()}.
   *   <li>Then calls {@link CatalogService#findProductById(Long)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SkuLookupByProductCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DynamicResultSet SkuLookupByProductCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"
  })
  public void testFetch_givenHashMapAllIsHashMap_thenCallsFindProductById()
      throws ServiceException {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    doNothing()
        .when(skuCustomPersistenceHandler)
        .updateProductOptionFieldsForFetch(
            Mockito.<List<Serializable>>any(), Mockito.<Entity[]>any());

    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("42");

    FilterAndSortCriteria filterAndSortCriteria = mock(FilterAndSortCriteria.class);
    when(filterAndSortCriteria.getFilterValues()).thenReturn(stringList);

    HashMap<String, FilterAndSortCriteria> stringFilterAndSortCriteriaMap = new HashMap<>();
    stringFilterAndSortCriteriaMap.putAll(new HashMap<>());
    stringFilterAndSortCriteriaMap.put("productId", filterAndSortCriteria);

    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(stringFilterAndSortCriteriaMap);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getSimpleMergedProperties(
            Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    when(helper.getRecords(
            Mockito.<Map<String, FieldMetadata>>any(), Mockito.<List<Serializable>>any()))
        .thenReturn(new Entity[] {new Entity()});

    // Act
    DynamicResultSet actualFetchResult =
        skuLookupByProductCustomPersistenceHandler.fetch(
            persistencePackage, cto, dynamicEntityDao, helper);

    // Assert
    verify(skuCustomPersistenceHandler)
        .updateProductOptionFieldsForFetch(isA(List.class), isA(Entity[].class));
    verify(catalogService).findProductById(42L);
    verify(cto).getCriteriaMap();
    verify(filterAndSortCriteria, atLeast(1)).getFilterValues();
    verify(persistencePackage).getPersistencePerspective();
    verify(helper).getRecords(isA(Map.class), isA(List.class));
    verify(helper)
        .getSimpleMergedProperties(
            eq("org.broadleafcommerce.core.catalog.domain.Sku"), isA(PersistencePerspective.class));
    assertNull(actualFetchResult.getPromptSearch());
    assertNull(actualFetchResult.getTotalCountLessThanPageSize());
    assertNull(actualFetchResult.getBatchId());
    assertNull(actualFetchResult.getLowerCount());
    assertNull(actualFetchResult.getUpperCount());
    assertNull(actualFetchResult.getFirstId());
    assertNull(actualFetchResult.getLastId());
    assertNull(actualFetchResult.getClassMetaData());
    assertNull(actualFetchResult.getFetchType());
    assertEquals(0, actualFetchResult.getPageSize().intValue());
    assertEquals(0, actualFetchResult.getStartIndex().intValue());
    assertEquals(1, actualFetchResult.getTotalRecords().intValue());
    assertEquals(1, actualFetchResult.getRecords().length);
    assertTrue(actualFetchResult.getUnselectedTabMetadata().isEmpty());
  }

  /**
   * Test {@link SkuLookupByProductCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link FilterAndSortCriteria}.
   *   <li>Then return PromptSearch is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SkuLookupByProductCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DynamicResultSet SkuLookupByProductCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"
  })
  public void testFetch_givenHashMapFooIsFilterAndSortCriteria_thenReturnPromptSearchIsNull()
      throws ServiceException {
    // Arrange
    doNothing()
        .when(skuCustomPersistenceHandler)
        .updateProductOptionFieldsForFetch(
            Mockito.<List<Serializable>>any(), Mockito.<Entity[]>any());

    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());

    HashMap<String, FilterAndSortCriteria> stringFilterAndSortCriteriaMap = new HashMap<>();
    stringFilterAndSortCriteriaMap.put("foo", mock(FilterAndSortCriteria.class));

    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(stringFilterAndSortCriteriaMap);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getSimpleMergedProperties(
            Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    when(helper.getRecords(
            Mockito.<Map<String, FieldMetadata>>any(), Mockito.<List<Serializable>>any()))
        .thenReturn(new Entity[] {new Entity()});

    // Act
    DynamicResultSet actualFetchResult =
        skuLookupByProductCustomPersistenceHandler.fetch(
            persistencePackage, cto, dynamicEntityDao, helper);

    // Assert
    verify(skuCustomPersistenceHandler)
        .updateProductOptionFieldsForFetch(isA(List.class), isA(Entity[].class));
    verify(cto).getCriteriaMap();
    verify(persistencePackage).getPersistencePerspective();
    verify(helper).getRecords(isA(Map.class), isA(List.class));
    verify(helper)
        .getSimpleMergedProperties(
            eq("org.broadleafcommerce.core.catalog.domain.Sku"), isA(PersistencePerspective.class));
    assertNull(actualFetchResult.getPromptSearch());
    assertNull(actualFetchResult.getTotalCountLessThanPageSize());
    assertNull(actualFetchResult.getBatchId());
    assertNull(actualFetchResult.getLowerCount());
    assertNull(actualFetchResult.getUpperCount());
    assertNull(actualFetchResult.getFirstId());
    assertNull(actualFetchResult.getLastId());
    assertNull(actualFetchResult.getClassMetaData());
    assertNull(actualFetchResult.getFetchType());
    assertEquals(0, actualFetchResult.getPageSize().intValue());
    assertEquals(0, actualFetchResult.getStartIndex().intValue());
    assertEquals(1, actualFetchResult.getTotalRecords().intValue());
    assertEquals(1, actualFetchResult.getRecords().length);
    assertTrue(actualFetchResult.getUnselectedTabMetadata().isEmpty());
  }

  /**
   * Test {@link
   * SkuLookupByProductCustomPersistenceHandler#isRequestForSkusFilteredByProduct(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * SkuLookupByProductCustomPersistenceHandler#isRequestForSkusFilteredByProduct(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuLookupByProductCustomPersistenceHandler.isRequestForSkusFilteredByProduct(PersistencePackage)"
  })
  public void testIsRequestForSkusFilteredByProduct() {
    // Arrange
    SkuLookupByProductCustomPersistenceHandler skuLookupByProductCustomPersistenceHandler =
        new SkuLookupByProductCustomPersistenceHandler();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act
    boolean actualIsRequestForSkusFilteredByProductResult =
        skuLookupByProductCustomPersistenceHandler.isRequestForSkusFilteredByProduct(
            persistencePackage);

    // Assert
    assertFalse(actualIsRequestForSkusFilteredByProductResult);
  }

  /**
   * Test {@link
   * SkuLookupByProductCustomPersistenceHandler#isRequestForSkusFilteredByProduct(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then calls {@link PersistencePackage#getCustomCriteria()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SkuLookupByProductCustomPersistenceHandler#isRequestForSkusFilteredByProduct(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuLookupByProductCustomPersistenceHandler.isRequestForSkusFilteredByProduct(PersistencePackage)"
  })
  public void testIsRequestForSkusFilteredByProduct_thenCallsGetCustomCriteria() {
    // Arrange
    SkuLookupByProductCustomPersistenceHandler skuLookupByProductCustomPersistenceHandler =
        new SkuLookupByProductCustomPersistenceHandler();

    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[] {"Custom Criteria"});

    // Act
    boolean actualIsRequestForSkusFilteredByProductResult =
        skuLookupByProductCustomPersistenceHandler.isRequestForSkusFilteredByProduct(
            persistencePackage);

    // Assert
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualIsRequestForSkusFilteredByProductResult);
  }

  /**
   * Test {@link
   * SkuLookupByProductCustomPersistenceHandler#isRequestForSkusFilteredByProduct(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SkuLookupByProductCustomPersistenceHandler#isRequestForSkusFilteredByProduct(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuLookupByProductCustomPersistenceHandler.isRequestForSkusFilteredByProduct(PersistencePackage)"
  })
  public void testIsRequestForSkusFilteredByProduct_thenReturnTrue() {
    // Arrange
    SkuLookupByProductCustomPersistenceHandler skuLookupByProductCustomPersistenceHandler =
        new SkuLookupByProductCustomPersistenceHandler();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"productFilterForSkus"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act
    boolean actualIsRequestForSkusFilteredByProductResult =
        skuLookupByProductCustomPersistenceHandler.isRequestForSkusFilteredByProduct(
            persistencePackage);

    // Assert
    assertTrue(actualIsRequestForSkusFilteredByProductResult);
  }

  /**
   * Test {@link
   * SkuLookupByProductCustomPersistenceHandler#isRequestForSkusFilteredByProduct(PersistencePackage)}.
   *
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SkuLookupByProductCustomPersistenceHandler#isRequestForSkusFilteredByProduct(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuLookupByProductCustomPersistenceHandler.isRequestForSkusFilteredByProduct(PersistencePackage)"
  })
  public void testIsRequestForSkusFilteredByProduct_whenPersistencePackage_thenReturnFalse() {
    // Arrange
    SkuLookupByProductCustomPersistenceHandler skuLookupByProductCustomPersistenceHandler =
        new SkuLookupByProductCustomPersistenceHandler();

    // Act and Assert
    assertFalse(
        skuLookupByProductCustomPersistenceHandler.isRequestForSkusFilteredByProduct(
            new PersistencePackage()));
  }

  /**
   * Test {@link SkuLookupByProductCustomPersistenceHandler#getOrder()}.
   *
   * <p>Method under test: {@link SkuLookupByProductCustomPersistenceHandler#getOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int SkuLookupByProductCustomPersistenceHandler.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(2147483645, new SkuLookupByProductCustomPersistenceHandler().getOrder());
  }
}

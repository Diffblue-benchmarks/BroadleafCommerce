/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.catalog.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.persistence.ArchiveStatus;
import org.broadleafcommerce.core.catalog.service.type.ProductBundlePricingModelType;
import org.broadleafcommerce.core.search.domain.FieldEntity;
import org.junit.Test;
import org.mockito.Mockito;

public class CategoryProductXrefImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CategoryProductXrefImpl#setCategory(Category)}
   *   <li>{@link CategoryProductXrefImpl#setDefaultReference(Boolean)}
   *   <li>{@link CategoryProductXrefImpl#setDisplayOrder(BigDecimal)}
   *   <li>{@link CategoryProductXrefImpl#setId(Long)}
   *   <li>{@link CategoryProductXrefImpl#setProduct(Product)}
   *   <li>{@link CategoryProductXrefImpl#getCategory()}
   *   <li>{@link CategoryProductXrefImpl#getDefaultReference()}
   *   <li>{@link CategoryProductXrefImpl#getDisplayOrder()}
   *   <li>{@link CategoryProductXrefImpl#getId()}
   *   <li>{@link CategoryProductXrefImpl#getProduct()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();
    CategoryImpl category = new CategoryImpl();

    // Act
    categoryProductXrefImpl.setCategory(category);
    categoryProductXrefImpl.setDefaultReference(true);
    BigDecimal displayOrder = new BigDecimal("2.3");
    categoryProductXrefImpl.setDisplayOrder(displayOrder);
    categoryProductXrefImpl.setId(1L);
    ProductBundleImpl product = new ProductBundleImpl();
    categoryProductXrefImpl.setProduct(product);
    Category actualCategory = categoryProductXrefImpl.getCategory();
    Boolean actualDefaultReference = categoryProductXrefImpl.getDefaultReference();
    BigDecimal actualDisplayOrder = categoryProductXrefImpl.getDisplayOrder();
    Long actualId = categoryProductXrefImpl.getId();
    Product actualProduct = categoryProductXrefImpl.getProduct();

    // Assert that nothing has changed
    assertEquals(1L, actualId.longValue());
    assertTrue(actualDefaultReference);
    assertEquals(new BigDecimal("2.3"), actualDisplayOrder);
    assertSame(displayOrder, actualDisplayOrder);
    assertSame(category, actualCategory);
    assertSame(product, actualProduct);
  }

  /**
   * Test {@link CategoryProductXrefImpl#equals(Object)}, and
   * {@link CategoryProductXrefImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CategoryProductXrefImpl#equals(Object)}
   *   <li>{@link CategoryProductXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();
    categoryProductXrefImpl.setCategory(new CategoryImpl());
    categoryProductXrefImpl.setDefaultReference(true);
    categoryProductXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl.setId(1L);
    categoryProductXrefImpl.setProduct(new ProductBundleImpl());

    CategoryProductXrefImpl categoryProductXrefImpl2 = new CategoryProductXrefImpl();
    categoryProductXrefImpl2.setCategory(new CategoryImpl());
    categoryProductXrefImpl2.setDefaultReference(true);
    categoryProductXrefImpl2.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl2.setId(1L);
    categoryProductXrefImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertEquals(categoryProductXrefImpl, categoryProductXrefImpl2);
    int expectedHashCodeResult = categoryProductXrefImpl.hashCode();
    assertEquals(expectedHashCodeResult, categoryProductXrefImpl2.hashCode());
  }

  /**
   * Test {@link CategoryProductXrefImpl#equals(Object)}, and
   * {@link CategoryProductXrefImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CategoryProductXrefImpl#equals(Object)}
   *   <li>{@link CategoryProductXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();
    categoryProductXrefImpl.setCategory(null);
    categoryProductXrefImpl.setDefaultReference(true);
    categoryProductXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl.setId(1L);
    categoryProductXrefImpl.setProduct(new ProductBundleImpl());

    CategoryProductXrefImpl categoryProductXrefImpl2 = new CategoryProductXrefImpl();
    categoryProductXrefImpl2.setCategory(null);
    categoryProductXrefImpl2.setDefaultReference(true);
    categoryProductXrefImpl2.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl2.setId(1L);
    categoryProductXrefImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertEquals(categoryProductXrefImpl, categoryProductXrefImpl2);
    int expectedHashCodeResult = categoryProductXrefImpl.hashCode();
    assertEquals(expectedHashCodeResult, categoryProductXrefImpl2.hashCode());
  }

  /**
   * Test {@link CategoryProductXrefImpl#equals(Object)}, and
   * {@link CategoryProductXrefImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CategoryProductXrefImpl#equals(Object)}
   *   <li>{@link CategoryProductXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();
    categoryProductXrefImpl.setCategory(new CategoryImpl());
    categoryProductXrefImpl.setDefaultReference(true);
    categoryProductXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl.setId(1L);
    categoryProductXrefImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertEquals(categoryProductXrefImpl, categoryProductXrefImpl);
    int expectedHashCodeResult = categoryProductXrefImpl.hashCode();
    assertEquals(expectedHashCodeResult, categoryProductXrefImpl.hashCode());
  }

  /**
   * Test {@link CategoryProductXrefImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryProductXrefImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();
    categoryProductXrefImpl.setCategory(null);
    categoryProductXrefImpl.setDefaultReference(true);
    categoryProductXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl.setId(1L);
    categoryProductXrefImpl.setProduct(new ProductBundleImpl());

    CategoryProductXrefImpl categoryProductXrefImpl2 = new CategoryProductXrefImpl();
    categoryProductXrefImpl2.setCategory(new CategoryImpl());
    categoryProductXrefImpl2.setDefaultReference(true);
    categoryProductXrefImpl2.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl2.setId(1L);
    categoryProductXrefImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNotEquals(categoryProductXrefImpl, categoryProductXrefImpl2);
  }

  /**
   * Test {@link CategoryProductXrefImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryProductXrefImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();
    categoryProductXrefImpl.setCategory(mock(CategoryImpl.class));
    categoryProductXrefImpl.setDefaultReference(true);
    categoryProductXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl.setId(1L);
    categoryProductXrefImpl.setProduct(new ProductBundleImpl());

    CategoryProductXrefImpl categoryProductXrefImpl2 = new CategoryProductXrefImpl();
    categoryProductXrefImpl2.setCategory(new CategoryImpl());
    categoryProductXrefImpl2.setDefaultReference(true);
    categoryProductXrefImpl2.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl2.setId(1L);
    categoryProductXrefImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNotEquals(categoryProductXrefImpl, categoryProductXrefImpl2);
  }

  /**
   * Test {@link CategoryProductXrefImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryProductXrefImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ProductBundleImpl product = new ProductBundleImpl();
    product.setPricingModel(ProductBundlePricingModelType.BUNDLE);

    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();
    categoryProductXrefImpl.setCategory(new CategoryImpl());
    categoryProductXrefImpl.setDefaultReference(true);
    categoryProductXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl.setId(1L);
    categoryProductXrefImpl.setProduct(product);

    CategoryProductXrefImpl categoryProductXrefImpl2 = new CategoryProductXrefImpl();
    categoryProductXrefImpl2.setCategory(new CategoryImpl());
    categoryProductXrefImpl2.setDefaultReference(true);
    categoryProductXrefImpl2.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl2.setId(1L);
    categoryProductXrefImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNotEquals(categoryProductXrefImpl, categoryProductXrefImpl2);
  }

  /**
   * Test {@link CategoryProductXrefImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryProductXrefImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();
    categoryProductXrefImpl.setCategory(new CategoryImpl());
    categoryProductXrefImpl.setDefaultReference(true);
    categoryProductXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl.setId(1L);
    categoryProductXrefImpl.setProduct(null);

    CategoryProductXrefImpl categoryProductXrefImpl2 = new CategoryProductXrefImpl();
    categoryProductXrefImpl2.setCategory(new CategoryImpl());
    categoryProductXrefImpl2.setDefaultReference(true);
    categoryProductXrefImpl2.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl2.setId(1L);
    categoryProductXrefImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNotEquals(categoryProductXrefImpl, categoryProductXrefImpl2);
  }

  /**
   * Test {@link CategoryProductXrefImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryProductXrefImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();
    categoryProductXrefImpl.setCategory(new CategoryImpl());
    categoryProductXrefImpl.setDefaultReference(true);
    categoryProductXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl.setId(1L);
    categoryProductXrefImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNotEquals(categoryProductXrefImpl, null);
  }

  /**
   * Test {@link CategoryProductXrefImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryProductXrefImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();
    categoryProductXrefImpl.setCategory(new CategoryImpl());
    categoryProductXrefImpl.setDefaultReference(true);
    categoryProductXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl.setId(1L);
    categoryProductXrefImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNotEquals(categoryProductXrefImpl, "Different type to CategoryProductXrefImpl");
  }

  /**
   * Test
   * {@link CategoryProductXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link CategoryProductXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<CategoryProductXref> actualCreateOrRetrieveCopyInstanceResult = categoryProductXrefImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link CategoryProductXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then calls {@link CreateResponse#getClone()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryProductXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCallsGetClone() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();

    CategoryProductXrefImpl categoryProductXrefImpl2 = new CategoryProductXrefImpl();
    categoryProductXrefImpl2.setCategory(new CategoryImpl());
    categoryProductXrefImpl2.setDefaultReference(true);
    categoryProductXrefImpl2.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl2.setId(1L);
    categoryProductXrefImpl2.setProduct(new ProductBundleImpl());
    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(categoryProductXrefImpl2);

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("MANUAL_DUPLICATION", "MANUAL_DUPLICATION");
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.getCopyHints()).thenReturn(stringStringMap);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    categoryProductXrefImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(context).getCopyHints();
  }

  /**
   * Test new {@link CategoryProductXrefImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link CategoryProductXrefImpl}
   */
  @Test
  public void testNewCategoryProductXrefImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    CategoryProductXrefImpl actualCategoryProductXrefImpl = new CategoryProductXrefImpl();

    // Assert
    Category category = actualCategoryProductXrefImpl.getCategory();
    assertTrue(category instanceof CategoryImpl);
    Product product = actualCategoryProductXrefImpl.getProduct();
    assertTrue(product instanceof ProductImpl);
    FieldEntity fieldEntityType = product.getFieldEntityType();
    List<String> allLookupTypes = fieldEntityType.getAllLookupTypes();
    assertEquals(1, allLookupTypes.size());
    assertEquals("PRODUCT", allLookupTypes.get(0));
    assertEquals("PRODUCT", fieldEntityType.getType());
    assertEquals("Product", fieldEntityType.getFriendlyType());
    assertEquals("null", category.getGeneratedUrl());
    ArchiveStatus archiveStatus = ((CategoryImpl) category).archiveStatus;
    assertEquals('N', archiveStatus.getArchived().charValue());
    assertEquals('N', ((CategoryImpl) category).getArchived().charValue());
    assertEquals('N', ((ProductImpl) product).getArchived().charValue());
    assertNull(actualCategoryProductXrefImpl.getDefaultReference());
    assertNull(category.getId());
    assertNull(actualCategoryProductXrefImpl.getId());
    assertNull(product.getId());
    assertNull(category.getDescription());
    assertNull(category.getDisplayTemplate());
    assertNull(category.getExternalId());
    assertNull(category.getLongDescription());
    assertNull(category.getMetaDescription());
    assertNull(category.getMetaTitle());
    assertNull(category.getName());
    assertNull(category.getProductDescriptionPatternOverride());
    assertNull(category.getProductTitlePatternOverride());
    assertNull(category.getTaxCode());
    assertNull(category.getUrl());
    assertNull(category.getUrlKey());
    assertNull(((CategoryImpl) category).getLocation());
    assertNull(((CategoryImpl) category).getMainEntityName());
    assertNull(product.getCanonicalUrl());
    assertNull(product.getDisplayTemplate());
    assertNull(product.getGeneratedUrl());
    assertNull(product.getManufacturer());
    assertNull(product.getMetaDescription());
    assertNull(product.getMetaTitle());
    assertNull(product.getModel());
    assertNull(product.getPromoMessage());
    assertNull(product.getUrl());
    assertNull(((ProductImpl) product).getLocation());
    assertNull(((CategoryImpl) category).description);
    assertNull(((CategoryImpl) category).fulfillmentType);
    assertNull(((CategoryImpl) category).inventoryType);
    assertNull(((CategoryImpl) category).longDescription);
    assertNull(((CategoryImpl) category).name);
    assertNull(((CategoryImpl) category).url);
    assertNull(((CategoryImpl) category).urlKey);
    assertNull(((ProductImpl) product).url);
    assertNull(((ProductImpl) product).urlKey);
    assertNull(category.getRootDisplayOrder());
    assertNull(actualCategoryProductXrefImpl.getDisplayOrder());
    assertNull(category.getActiveEndDate());
    assertNull(category.getActiveStartDate());
    assertNull(((CategoryImpl) category).activeStartDate);
    assertNull(((CategoryImpl) category).childCategoryIds);
    assertNull(((CategoryImpl) category).filteredFeaturedProducts);
    assertNull(((CategoryImpl) category).filteredCrossSales);
    assertNull(((CategoryImpl) category).filteredUpSales);
    assertNull(((CategoryImpl) category).childCategoryURLMap);
    assertNull(product.getPrice());
    assertNull(product.getRetailPrice());
    assertNull(product.getSalePrice());
    assertNull(((ProductImpl) product).getRetailPriceInternal());
    assertNull(((ProductImpl) product).getSalePriceInternal());
    assertNull(category.getDefaultParentCategory());
    assertNull(category.getParentCategory());
    assertNull(product.getCategory());
    assertNull(product.getDefaultCategory());
    assertNull(((CategoryImpl) category).defaultParentCategory);
    assertNull(((ProductImpl) product).defaultCategory);
    assertNull(category.getParentCategoryXref());
    List<Sku> allSellableSkus = product.getAllSellableSkus();
    assertEquals(1, allSellableSkus.size());
    assertNull(allSellableSkus.get(0));
    assertNull(product.getDefaultSku());
    assertNull(category.getInventoryType());
    assertNull(category.getFulfillmentType());
    assertFalse(category.getOverrideGeneratedUrl());
    assertFalse(category.hasAllChildCategories());
    assertFalse(category.hasChildCategories());
    assertFalse(product.getCanSellWithoutOptions());
    assertFalse(product.getOverrideGeneratedUrl());
    assertFalse(product.hasRetailPrice());
    assertFalse(((CategoryImpl) category).overrideGeneratedUrl);
    assertFalse(((ProductImpl) product).canSellWithoutOptions);
    assertFalse(((ProductImpl) product).isFeaturedProduct);
    assertFalse(((ProductImpl) product).overrideGeneratedUrl);
    assertTrue(category.getActiveProductXrefs().isEmpty());
    assertTrue(category.getActiveProducts().isEmpty());
    assertTrue(category.getAllChildCategories().isEmpty());
    assertTrue(category.getAllChildCategoryXrefs().isEmpty());
    assertTrue(category.getAllParentCategories().isEmpty());
    assertTrue(category.getAllParentCategoryXrefs().isEmpty());
    assertTrue(category.getAllProductXrefs().isEmpty());
    assertTrue(category.getAllProducts().isEmpty());
    assertTrue(category.getCategoryAttributes().isEmpty());
    assertTrue(category.getChildCategories().isEmpty());
    assertTrue(category.getChildCategoryXrefs().isEmpty());
    assertTrue(category.getCrossSaleProducts().isEmpty());
    assertTrue(category.getCumulativeCrossSaleProducts().isEmpty());
    assertTrue(category.getCumulativeFeaturedProducts().isEmpty());
    assertTrue(category.getCumulativeSearchFacets().isEmpty());
    assertTrue(category.getCumulativeUpSaleProducts().isEmpty());
    assertTrue(category.getExcludedSearchFacets().isEmpty());
    assertTrue(category.getFeaturedProducts().isEmpty());
    assertTrue(category.getSearchFacets().isEmpty());
    assertTrue(category.getUpSaleProducts().isEmpty());
    assertTrue(product.getAdditionalSkus().isEmpty());
    assertTrue(product.getAllParentCategories().isEmpty());
    assertTrue(product.getAllParentCategoryIds().isEmpty());
    assertTrue(product.getAllParentCategoryXrefs().isEmpty());
    List<RelatedProduct> crossSaleProducts = product.getCrossSaleProducts();
    assertTrue(crossSaleProducts.isEmpty());
    List<RelatedProduct> cumulativeUpSaleProducts = product.getCumulativeUpSaleProducts();
    assertTrue(cumulativeUpSaleProducts.isEmpty());
    assertTrue(product.getParentCategoryHierarchyIds().isEmpty());
    assertTrue(product.getProductOptionXrefs().isEmpty());
    assertTrue(product.getProductOptions().isEmpty());
    assertTrue(product.getSkus().isEmpty());
    assertTrue(fieldEntityType.getAdditionalLookupTypes().isEmpty());
    assertTrue(((CategoryImpl) category).allLegacyChildCategories.isEmpty());
    assertTrue(((CategoryImpl) category).childCategoryXrefs.isEmpty());
    assertTrue(((CategoryImpl) category).legacyChildCategories.isEmpty());
    assertTrue(((ProductImpl) product).productAttributes.isEmpty());
    assertTrue(((ProductImpl) product).productOptions.isEmpty());
    assertTrue(((ProductImpl) product).skus.isEmpty());
    assertTrue(category.getCategoryAttributesMap().isEmpty());
    assertTrue(category.getCategoryMedia().isEmpty());
    assertTrue(category.getCategoryMediaXref().isEmpty());
    assertTrue(category.getMappedCategoryAttributes().isEmpty());
    assertTrue(category.getMultiValueCategoryAttributes().isEmpty());
    assertTrue(product.getMultiValueProductAttributes().isEmpty());
    assertTrue(product.getProductAttributes().isEmpty());
    assertTrue(product.getProductOptionValuesMap().isEmpty());
    assertTrue(((CategoryImpl) category).legacyCategoryMedia.isEmpty());
    assertEquals(allSellableSkus, product.getAllSkus());
    assertEquals(archiveStatus, ((ProductImpl) product).archiveStatus);
    assertSame(crossSaleProducts, product.getCumulativeCrossSaleProducts());
    assertSame(cumulativeUpSaleProducts, product.getUpSaleProducts());
  }
}

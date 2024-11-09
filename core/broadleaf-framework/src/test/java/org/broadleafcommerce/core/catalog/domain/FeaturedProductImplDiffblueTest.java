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
import java.util.List;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.persistence.ArchiveStatus;
import org.broadleafcommerce.core.catalog.service.type.ProductBundlePricingModelType;
import org.broadleafcommerce.core.search.domain.FieldEntity;
import org.junit.Test;
import org.mockito.Mockito;

public class FeaturedProductImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FeaturedProductImpl#setCategory(Category)}
   *   <li>{@link FeaturedProductImpl#setId(Long)}
   *   <li>{@link FeaturedProductImpl#setProduct(Product)}
   *   <li>{@link FeaturedProductImpl#setPromotionMessage(String)}
   *   <li>{@link FeaturedProductImpl#setSequence(BigDecimal)}
   *   <li>{@link FeaturedProductImpl#getCategory()}
   *   <li>{@link FeaturedProductImpl#getId()}
   *   <li>{@link FeaturedProductImpl#getProduct()}
   *   <li>{@link FeaturedProductImpl#getPromotionMessage()}
   *   <li>{@link FeaturedProductImpl#getRelatedProduct()}
   *   <li>{@link FeaturedProductImpl#getSequence()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    CategoryImpl category = new CategoryImpl();

    // Act
    featuredProductImpl.setCategory(category);
    featuredProductImpl.setId(1L);
    ProductBundleImpl product = new ProductBundleImpl();
    featuredProductImpl.setProduct(product);
    featuredProductImpl.setPromotionMessage("Promotion Message");
    BigDecimal sequence = new BigDecimal("2.3");
    featuredProductImpl.setSequence(sequence);
    Category actualCategory = featuredProductImpl.getCategory();
    Long actualId = featuredProductImpl.getId();
    Product actualProduct = featuredProductImpl.getProduct();
    String actualPromotionMessage = featuredProductImpl.getPromotionMessage();
    Product actualRelatedProduct = featuredProductImpl.getRelatedProduct();
    BigDecimal actualSequence = featuredProductImpl.getSequence();

    // Assert that nothing has changed
    assertEquals("Promotion Message", actualPromotionMessage);
    assertEquals(1L, actualId.longValue());
    assertEquals(new BigDecimal("2.3"), actualSequence);
    assertSame(sequence, actualSequence);
    assertSame(category, actualCategory);
    assertSame(product, actualProduct);
    assertSame(product, actualRelatedProduct);
  }

  /**
   * Test {@link FeaturedProductImpl#equals(Object)}, and
   * {@link FeaturedProductImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FeaturedProductImpl#equals(Object)}
   *   <li>{@link FeaturedProductImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProductImpl.setCategory(new CategoryImpl());
    featuredProductImpl.setId(1L);
    featuredProductImpl.setProduct(new ProductBundleImpl());
    featuredProductImpl.setPromotionMessage("Promotion Message");
    featuredProductImpl.setSequence(new BigDecimal("2.3"));

    FeaturedProductImpl featuredProductImpl2 = new FeaturedProductImpl();
    featuredProductImpl2.setCategory(new CategoryImpl());
    featuredProductImpl2.setId(1L);
    featuredProductImpl2.setProduct(new ProductBundleImpl());
    featuredProductImpl2.setPromotionMessage("Promotion Message");
    featuredProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(featuredProductImpl, featuredProductImpl2);
    int expectedHashCodeResult = featuredProductImpl.hashCode();
    assertEquals(expectedHashCodeResult, featuredProductImpl2.hashCode());
  }

  /**
   * Test {@link FeaturedProductImpl#equals(Object)}, and
   * {@link FeaturedProductImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FeaturedProductImpl#equals(Object)}
   *   <li>{@link FeaturedProductImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProductImpl.setCategory(null);
    featuredProductImpl.setId(1L);
    featuredProductImpl.setProduct(new ProductBundleImpl());
    featuredProductImpl.setPromotionMessage("Promotion Message");
    featuredProductImpl.setSequence(new BigDecimal("2.3"));

    FeaturedProductImpl featuredProductImpl2 = new FeaturedProductImpl();
    featuredProductImpl2.setCategory(null);
    featuredProductImpl2.setId(1L);
    featuredProductImpl2.setProduct(new ProductBundleImpl());
    featuredProductImpl2.setPromotionMessage("Promotion Message");
    featuredProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(featuredProductImpl, featuredProductImpl2);
    int expectedHashCodeResult = featuredProductImpl.hashCode();
    assertEquals(expectedHashCodeResult, featuredProductImpl2.hashCode());
  }

  /**
   * Test {@link FeaturedProductImpl#equals(Object)}, and
   * {@link FeaturedProductImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FeaturedProductImpl#equals(Object)}
   *   <li>{@link FeaturedProductImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProductImpl.setCategory(new CategoryImpl());
    featuredProductImpl.setId(1L);
    featuredProductImpl.setProduct(new ProductBundleImpl());
    featuredProductImpl.setPromotionMessage("Promotion Message");
    featuredProductImpl.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(featuredProductImpl, featuredProductImpl);
    int expectedHashCodeResult = featuredProductImpl.hashCode();
    assertEquals(expectedHashCodeResult, featuredProductImpl.hashCode());
  }

  /**
   * Test {@link FeaturedProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FeaturedProductImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProductImpl.setCategory(null);
    featuredProductImpl.setId(1L);
    featuredProductImpl.setProduct(new ProductBundleImpl());
    featuredProductImpl.setPromotionMessage("Promotion Message");
    featuredProductImpl.setSequence(new BigDecimal("2.3"));

    FeaturedProductImpl featuredProductImpl2 = new FeaturedProductImpl();
    featuredProductImpl2.setCategory(new CategoryImpl());
    featuredProductImpl2.setId(1L);
    featuredProductImpl2.setProduct(new ProductBundleImpl());
    featuredProductImpl2.setPromotionMessage("Promotion Message");
    featuredProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(featuredProductImpl, featuredProductImpl2);
  }

  /**
   * Test {@link FeaturedProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FeaturedProductImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProductImpl.setCategory(mock(CategoryImpl.class));
    featuredProductImpl.setId(1L);
    featuredProductImpl.setProduct(new ProductBundleImpl());
    featuredProductImpl.setPromotionMessage("Promotion Message");
    featuredProductImpl.setSequence(new BigDecimal("2.3"));

    FeaturedProductImpl featuredProductImpl2 = new FeaturedProductImpl();
    featuredProductImpl2.setCategory(new CategoryImpl());
    featuredProductImpl2.setId(1L);
    featuredProductImpl2.setProduct(new ProductBundleImpl());
    featuredProductImpl2.setPromotionMessage("Promotion Message");
    featuredProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(featuredProductImpl, featuredProductImpl2);
  }

  /**
   * Test {@link FeaturedProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FeaturedProductImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ProductBundleImpl product = new ProductBundleImpl();
    product.setPricingModel(ProductBundlePricingModelType.BUNDLE);

    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProductImpl.setCategory(new CategoryImpl());
    featuredProductImpl.setId(1L);
    featuredProductImpl.setProduct(product);
    featuredProductImpl.setPromotionMessage("Promotion Message");
    featuredProductImpl.setSequence(new BigDecimal("2.3"));

    FeaturedProductImpl featuredProductImpl2 = new FeaturedProductImpl();
    featuredProductImpl2.setCategory(new CategoryImpl());
    featuredProductImpl2.setId(1L);
    featuredProductImpl2.setProduct(new ProductBundleImpl());
    featuredProductImpl2.setPromotionMessage("Promotion Message");
    featuredProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(featuredProductImpl, featuredProductImpl2);
  }

  /**
   * Test {@link FeaturedProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FeaturedProductImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProductImpl.setCategory(new CategoryImpl());
    featuredProductImpl.setId(1L);
    featuredProductImpl.setProduct(null);
    featuredProductImpl.setPromotionMessage("Promotion Message");
    featuredProductImpl.setSequence(new BigDecimal("2.3"));

    FeaturedProductImpl featuredProductImpl2 = new FeaturedProductImpl();
    featuredProductImpl2.setCategory(new CategoryImpl());
    featuredProductImpl2.setId(1L);
    featuredProductImpl2.setProduct(new ProductBundleImpl());
    featuredProductImpl2.setPromotionMessage("Promotion Message");
    featuredProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(featuredProductImpl, featuredProductImpl2);
  }

  /**
   * Test {@link FeaturedProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FeaturedProductImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProductImpl.setCategory(new CategoryImpl());
    featuredProductImpl.setId(1L);
    featuredProductImpl.setProduct(new ProductBundleImpl());
    featuredProductImpl.setPromotionMessage(null);
    featuredProductImpl.setSequence(new BigDecimal("2.3"));

    FeaturedProductImpl featuredProductImpl2 = new FeaturedProductImpl();
    featuredProductImpl2.setCategory(new CategoryImpl());
    featuredProductImpl2.setId(1L);
    featuredProductImpl2.setProduct(new ProductBundleImpl());
    featuredProductImpl2.setPromotionMessage("Promotion Message");
    featuredProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(featuredProductImpl, featuredProductImpl2);
  }

  /**
   * Test {@link FeaturedProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FeaturedProductImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProductImpl.setCategory(new CategoryImpl());
    featuredProductImpl.setId(1L);
    featuredProductImpl.setProduct(new ProductBundleImpl());
    featuredProductImpl.setPromotionMessage("42");
    featuredProductImpl.setSequence(new BigDecimal("2.3"));

    FeaturedProductImpl featuredProductImpl2 = new FeaturedProductImpl();
    featuredProductImpl2.setCategory(new CategoryImpl());
    featuredProductImpl2.setId(1L);
    featuredProductImpl2.setProduct(new ProductBundleImpl());
    featuredProductImpl2.setPromotionMessage("Promotion Message");
    featuredProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(featuredProductImpl, featuredProductImpl2);
  }

  /**
   * Test {@link FeaturedProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FeaturedProductImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProductImpl.setCategory(new CategoryImpl());
    featuredProductImpl.setId(1L);
    featuredProductImpl.setProduct(new ProductBundleImpl());
    featuredProductImpl.setPromotionMessage("Promotion Message");
    featuredProductImpl.setSequence(new BigDecimal("4.5"));

    FeaturedProductImpl featuredProductImpl2 = new FeaturedProductImpl();
    featuredProductImpl2.setCategory(new CategoryImpl());
    featuredProductImpl2.setId(1L);
    featuredProductImpl2.setProduct(new ProductBundleImpl());
    featuredProductImpl2.setPromotionMessage("Promotion Message");
    featuredProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(featuredProductImpl, featuredProductImpl2);
  }

  /**
   * Test {@link FeaturedProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FeaturedProductImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProductImpl.setCategory(new CategoryImpl());
    featuredProductImpl.setId(1L);
    featuredProductImpl.setProduct(new ProductBundleImpl());
    featuredProductImpl.setPromotionMessage("Promotion Message");
    featuredProductImpl.setSequence(null);

    FeaturedProductImpl featuredProductImpl2 = new FeaturedProductImpl();
    featuredProductImpl2.setCategory(new CategoryImpl());
    featuredProductImpl2.setId(1L);
    featuredProductImpl2.setProduct(new ProductBundleImpl());
    featuredProductImpl2.setPromotionMessage("Promotion Message");
    featuredProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(featuredProductImpl, featuredProductImpl2);
  }

  /**
   * Test {@link FeaturedProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FeaturedProductImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProductImpl.setCategory(new CategoryImpl());
    featuredProductImpl.setId(1L);
    featuredProductImpl.setProduct(new ProductBundleImpl());
    featuredProductImpl.setPromotionMessage("Promotion Message");
    featuredProductImpl.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(featuredProductImpl, null);
  }

  /**
   * Test {@link FeaturedProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FeaturedProductImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProductImpl.setCategory(new CategoryImpl());
    featuredProductImpl.setId(1L);
    featuredProductImpl.setProduct(new ProductBundleImpl());
    featuredProductImpl.setPromotionMessage("Promotion Message");
    featuredProductImpl.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(featuredProductImpl, "Different type to FeaturedProductImpl");
  }

  /**
   * Test
   * {@link FeaturedProductImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link FeaturedProductImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<FeaturedProduct> actualCreateOrRetrieveCopyInstanceResult = featuredProductImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test new {@link FeaturedProductImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link FeaturedProductImpl}
   */
  @Test
  public void testNewFeaturedProductImpl() {
    // Arrange and Act
    FeaturedProductImpl actualFeaturedProductImpl = new FeaturedProductImpl();

    // Assert
    Category category = actualFeaturedProductImpl.getCategory();
    assertTrue(category instanceof CategoryImpl);
    Product product = actualFeaturedProductImpl.getProduct();
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
    assertNull(category.getId());
    assertNull(actualFeaturedProductImpl.getId());
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
    assertNull(actualFeaturedProductImpl.getPromotionMessage());
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
    assertNull(actualFeaturedProductImpl.getSequence());
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
    assertSame(product, actualFeaturedProductImpl.getRelatedProduct());
  }
}

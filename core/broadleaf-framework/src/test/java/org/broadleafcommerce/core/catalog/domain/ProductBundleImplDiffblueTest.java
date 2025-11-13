package org.broadleafcommerce.core.catalog.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductBundleImplDiffblueTest {
  @Autowired private ProductBundleImpl productBundleImpl;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductBundleImpl#setBundlePromotable(Boolean)}
   *   <li>{@link ProductBundleImpl#setItemsPromotable(Boolean)}
   *   <li>{@link ProductBundleImpl#setPriority(Integer)}
   *   <li>{@link ProductBundleImpl#setSkuBundleItems(List)}
   *   <li>{@link ProductBundleImpl#setAutoBundle(Boolean)}
   *   <li>{@link ProductBundleImpl#getPriority()}
   *   <li>{@link ProductBundleImpl#getSkuBundleItems()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Integer ProductBundleImpl.getPriority()",
    "List ProductBundleImpl.getSkuBundleItems()",
    "void ProductBundleImpl.setAutoBundle(Boolean)",
    "void ProductBundleImpl.setBundlePromotable(Boolean)",
    "void ProductBundleImpl.setItemsPromotable(Boolean)",
    "void ProductBundleImpl.setPriority(Integer)",
    "void ProductBundleImpl.setSkuBundleItems(List)"
  })
  public void testGettersAndSetters() {
    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();

    // Act
    productBundleImpl.setBundlePromotable(true);
    productBundleImpl.setItemsPromotable(true);
    productBundleImpl.setPriority(1);
    ArrayList<SkuBundleItem> skuBundleItems = new ArrayList<>();
    productBundleImpl.setSkuBundleItems(skuBundleItems);
    productBundleImpl.setAutoBundle(true);
    Integer actualPriority = productBundleImpl.getPriority();
    List<SkuBundleItem> actualSkuBundleItems = productBundleImpl.getSkuBundleItems();

    // Assert
    assertEquals(1, actualPriority.intValue());
    assertTrue(actualSkuBundleItems.isEmpty());
    assertSame(skuBundleItems, actualSkuBundleItems);
  }

  /**
   * Test new {@link ProductBundleImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ProductBundleImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProductBundleImpl.<init>()"})
  public void testNewProductBundleImpl() {
    // Arrange and Act
    ProductBundleImpl actualProductBundleImpl = new ProductBundleImpl();

    // Assert
    assertEquals('N', actualProductBundleImpl.getArchived().charValue());
    assertNull(actualProductBundleImpl.getId());
    assertNull(actualProductBundleImpl.getCanonicalUrl());
    assertNull(actualProductBundleImpl.getDisplayTemplate());
    assertNull(actualProductBundleImpl.getGeneratedUrl());
    assertNull(actualProductBundleImpl.getLocation());
    assertNull(actualProductBundleImpl.getManufacturer());
    assertNull(actualProductBundleImpl.getMetaDescription());
    assertNull(actualProductBundleImpl.getMetaTitle());
    assertNull(actualProductBundleImpl.getModel());
    assertNull(actualProductBundleImpl.getPromoMessage());
    assertNull(actualProductBundleImpl.getUrl());
    assertNull(actualProductBundleImpl.pricingModel);
    assertNull(actualProductBundleImpl.url);
    assertNull(actualProductBundleImpl.urlKey);
    assertNull(actualProductBundleImpl.getRetailPrice());
    assertNull(actualProductBundleImpl.getSalePrice());
    assertNull(actualProductBundleImpl.getPrice());
    assertNull(actualProductBundleImpl.getRetailPriceInternal());
    assertNull(actualProductBundleImpl.getSalePriceInternal());
    assertNull(actualProductBundleImpl.getCategory());
    assertNull(actualProductBundleImpl.getDefaultCategory());
    assertNull(actualProductBundleImpl.defaultCategory);
    assertNull(actualProductBundleImpl.getDefaultSku());
    assertNull(actualProductBundleImpl.getPricingModel());
    List<Sku> allSellableSkus = actualProductBundleImpl.getAllSellableSkus();
    assertEquals(1, allSellableSkus.size());
    assertEquals(99, actualProductBundleImpl.getPriority().intValue());
    assertFalse(actualProductBundleImpl.getAutoBundle());
    assertFalse(actualProductBundleImpl.getBundlePromotable());
    assertFalse(actualProductBundleImpl.getItemsPromotable());
    assertFalse(actualProductBundleImpl.getCanSellWithoutOptions());
    assertFalse(actualProductBundleImpl.getOverrideGeneratedUrl());
    assertFalse(actualProductBundleImpl.hasRetailPrice());
    assertFalse(actualProductBundleImpl.autoBundle);
    assertFalse(actualProductBundleImpl.bundlePromotable);
    assertFalse(actualProductBundleImpl.itemsPromotable);
    assertFalse(actualProductBundleImpl.canSellWithoutOptions);
    assertFalse(actualProductBundleImpl.isFeaturedProduct);
    assertFalse(actualProductBundleImpl.overrideGeneratedUrl);
    assertTrue(actualProductBundleImpl.getSkuBundleItems().isEmpty());
    assertTrue(actualProductBundleImpl.getAdditionalSkus().isEmpty());
    assertTrue(actualProductBundleImpl.getAllParentCategories().isEmpty());
    assertTrue(actualProductBundleImpl.getAllParentCategoryIds().isEmpty());
    assertTrue(actualProductBundleImpl.getAllParentCategoryXrefs().isEmpty());
    List<RelatedProduct> crossSaleProducts = actualProductBundleImpl.getCrossSaleProducts();
    assertTrue(crossSaleProducts.isEmpty());
    List<RelatedProduct> cumulativeUpSaleProducts =
        actualProductBundleImpl.getCumulativeUpSaleProducts();
    assertTrue(cumulativeUpSaleProducts.isEmpty());
    assertTrue(actualProductBundleImpl.getParentCategoryHierarchyIds().isEmpty());
    assertTrue(actualProductBundleImpl.getProductOptionXrefs().isEmpty());
    assertTrue(actualProductBundleImpl.getProductOptions().isEmpty());
    assertTrue(actualProductBundleImpl.getSkus().isEmpty());
    assertTrue(actualProductBundleImpl.productAttributes.isEmpty());
    assertTrue(actualProductBundleImpl.productOptions.isEmpty());
    assertTrue(actualProductBundleImpl.skus.isEmpty());
    assertTrue(actualProductBundleImpl.getMultiValueProductAttributes().isEmpty());
    assertTrue(actualProductBundleImpl.getProductAttributes().isEmpty());
    Map<String, Set<String>> productOptionValuesMap =
        actualProductBundleImpl.getProductOptionValuesMap();
    assertTrue(productOptionValuesMap.isEmpty());
    assertEquals(new BigDecimal("0.00"), actualProductBundleImpl.getPotentialSavings());
    assertEquals(allSellableSkus, actualProductBundleImpl.getAllSkus());
    assertSame(crossSaleProducts, actualProductBundleImpl.getCumulativeCrossSaleProducts());
    assertSame(cumulativeUpSaleProducts, actualProductBundleImpl.getUpSaleProducts());
    assertSame(productOptionValuesMap, actualProductBundleImpl.productOptionMap);
  }
}

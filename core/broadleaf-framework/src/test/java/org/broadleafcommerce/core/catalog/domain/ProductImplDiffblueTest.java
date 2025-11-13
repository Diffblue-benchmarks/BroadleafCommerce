package org.broadleafcommerce.core.catalog.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.search.domain.FieldEntity;
import org.junit.Test;

public class ProductImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductImpl#setCanSellWithoutOptions(Boolean)}
   *   <li>{@link ProductImpl#setCanonicalUrl(String)}
   *   <li>{@link ProductImpl#setDefaultCategory(Category)}
   *   <li>{@link ProductImpl#setDisplayTemplate(String)}
   *   <li>{@link ProductImpl#setId(Long)}
   *   <li>{@link ProductImpl#setManufacturer(String)}
   *   <li>{@link ProductImpl#setMetaDescription(String)}
   *   <li>{@link ProductImpl#setMetaTitle(String)}
   *   <li>{@link ProductImpl#setModel(String)}
   *   <li>{@link ProductImpl#setProductOptionXrefs(List)}
   *   <li>{@link ProductImpl#setPromoMessage(String)}
   *   <li>{@link ProductImpl#setUrl(String)}
   *   <li>{@link ProductImpl#setUrlKey(String)}
   *   <li>{@link ProductImpl#getAdditionalSkus()}
   *   <li>{@link ProductImpl#getAllParentCategoryXrefs()}
   *   <li>{@link ProductImpl#getCanonicalUrl()}
   *   <li>{@link ProductImpl#getCrossSaleProducts()}
   *   <li>{@link ProductImpl#getDefaultSku()}
   *   <li>{@link ProductImpl#getDisplayTemplate()}
   *   <li>{@link ProductImpl#getFieldEntityType()}
   *   <li>{@link ProductImpl#getId()}
   *   <li>{@link ProductImpl#getManufacturer()}
   *   <li>{@link ProductImpl#getMetaDescription()}
   *   <li>{@link ProductImpl#getMetaTitle()}
   *   <li>{@link ProductImpl#getModel()}
   *   <li>{@link ProductImpl#getPromoMessage()}
   *   <li>{@link ProductImpl#getUpSaleProducts()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ProductImpl.getAdditionalSkus()",
    "List ProductImpl.getAllParentCategoryXrefs()",
    "String ProductImpl.getCanonicalUrl()",
    "List ProductImpl.getCrossSaleProducts()",
    "Sku ProductImpl.getDefaultSku()",
    "String ProductImpl.getDisplayTemplate()",
    "FieldEntity ProductImpl.getFieldEntityType()",
    "Long ProductImpl.getId()",
    "String ProductImpl.getManufacturer()",
    "String ProductImpl.getMetaDescription()",
    "String ProductImpl.getMetaTitle()",
    "String ProductImpl.getModel()",
    "String ProductImpl.getPromoMessage()",
    "List ProductImpl.getUpSaleProducts()",
    "void ProductImpl.setCanSellWithoutOptions(Boolean)",
    "void ProductImpl.setCanonicalUrl(String)",
    "void ProductImpl.setDefaultCategory(Category)",
    "void ProductImpl.setDisplayTemplate(String)",
    "void ProductImpl.setId(Long)",
    "void ProductImpl.setManufacturer(String)",
    "void ProductImpl.setMetaDescription(String)",
    "void ProductImpl.setMetaTitle(String)",
    "void ProductImpl.setModel(String)",
    "void ProductImpl.setProductOptionXrefs(List)",
    "void ProductImpl.setPromoMessage(String)",
    "void ProductImpl.setUrl(String)",
    "void ProductImpl.setUrlKey(String)"
  })
  public void testGettersAndSetters() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();

    // Act
    productImpl.setCanSellWithoutOptions(true);
    productImpl.setCanonicalUrl("https://example.org/example");
    productImpl.setDefaultCategory(new CategoryImpl());
    productImpl.setDisplayTemplate("Display Template");
    productImpl.setId(1L);
    productImpl.setManufacturer("Manufacturer");
    productImpl.setMetaDescription("Meta Description");
    productImpl.setMetaTitle("Dr");
    productImpl.setModel("Model");
    productImpl.setProductOptionXrefs(new ArrayList<>());
    productImpl.setPromoMessage("Promo Message");
    productImpl.setUrl("https://example.org/example");
    productImpl.setUrlKey("https://example.org/example");
    List<Sku> actualAdditionalSkus = productImpl.getAdditionalSkus();
    List<CategoryProductXref> actualAllParentCategoryXrefs =
        productImpl.getAllParentCategoryXrefs();
    String actualCanonicalUrl = productImpl.getCanonicalUrl();
    List<RelatedProduct> actualCrossSaleProducts = productImpl.getCrossSaleProducts();
    Sku actualDefaultSku = productImpl.getDefaultSku();
    String actualDisplayTemplate = productImpl.getDisplayTemplate();
    FieldEntity actualFieldEntityType = productImpl.getFieldEntityType();
    Long actualId = productImpl.getId();
    String actualManufacturer = productImpl.getManufacturer();
    String actualMetaDescription = productImpl.getMetaDescription();
    String actualMetaTitle = productImpl.getMetaTitle();
    String actualModel = productImpl.getModel();
    String actualPromoMessage = productImpl.getPromoMessage();
    List<RelatedProduct> actualUpSaleProducts = productImpl.getUpSaleProducts();

    // Assert
    assertEquals("Display Template", actualDisplayTemplate);
    assertEquals("Dr", actualMetaTitle);
    assertEquals("Manufacturer", actualManufacturer);
    assertEquals("Meta Description", actualMetaDescription);
    assertEquals("Model", actualModel);
    assertEquals("Promo Message", actualPromoMessage);
    assertEquals("https://example.org/example", actualCanonicalUrl);
    assertNull(actualDefaultSku);
    assertEquals(1L, actualId.longValue());
    assertTrue(actualAdditionalSkus.isEmpty());
    assertTrue(actualAllParentCategoryXrefs.isEmpty());
    assertTrue(actualCrossSaleProducts.isEmpty());
    assertTrue(actualUpSaleProducts.isEmpty());
    assertSame(FieldEntity.PRODUCT, actualFieldEntityType);
  }
}

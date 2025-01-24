package org.broadleafcommerce.core.web.expression;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.catalog.domain.CrossSaleProductImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductImpl;
import org.broadleafcommerce.core.catalog.domain.PromotableProduct;
import org.broadleafcommerce.core.catalog.domain.RelatedProduct;
import org.broadleafcommerce.core.catalog.domain.RelatedProductDTO;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.service.RelatedProductsService;
import org.broadleafcommerce.core.search.domain.FieldEntity;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml",
    "/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
@ExtendWith(SpringExtension.class)
class RelatedProductsVariableExpressionDiffblueTest {
  @Autowired
  private RelatedProductsVariableExpression relatedProductsVariableExpression;

  /**
   * Test {@link RelatedProductsVariableExpression#getName()}.
   * <p>
   * Method under test: {@link RelatedProductsVariableExpression#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("related_products",
        (new RelatedProductsVariableExpression(mock(RelatedProductsService.class))).getName());
  }

  /**
   * Test {@link RelatedProductsVariableExpression#findByProduct(Long)} with
   * {@code productId}.
   * <p>
   * Method under test:
   * {@link RelatedProductsVariableExpression#findByProduct(Long)}
   */
  @Test
  @DisplayName("Test findByProduct(Long) with 'productId'")
  @Disabled("TODO: Complete this test")
  void testFindByProductWithProductId() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3160 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.RelatedProductsVariableExpression relatedProductsVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new RelatedProductsVariableExpression(mock(RelatedProductsService.class))).findByProduct(1L);
  }

  /**
   * Test {@link RelatedProductsVariableExpression#findByProduct(Long, Integer)}
   * with {@code productId}, {@code quantity}.
   * <p>
   * Method under test:
   * {@link RelatedProductsVariableExpression#findByProduct(Long, Integer)}
   */
  @Test
  @DisplayName("Test findByProduct(Long, Integer) with 'productId', 'quantity'")
  @Disabled("TODO: Complete this test")
  void testFindByProductWithProductIdQuantity() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3178 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.RelatedProductsVariableExpression relatedProductsVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new RelatedProductsVariableExpression(mock(RelatedProductsService.class))).findByProduct(1L, 1);
  }

  /**
   * Test
   * {@link RelatedProductsVariableExpression#findByProduct(Long, Integer, String)}
   * with {@code productId}, {@code quantity}, {@code type}.
   * <p>
   * Method under test:
   * {@link RelatedProductsVariableExpression#findByProduct(Long, Integer, String)}
   */
  @Test
  @DisplayName("Test findByProduct(Long, Integer, String) with 'productId', 'quantity', 'type'")
  @Disabled("TODO: Complete this test")
  void testFindByProductWithProductIdQuantityType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3199 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.RelatedProductsVariableExpression relatedProductsVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new RelatedProductsVariableExpression(mock(RelatedProductsService.class))).findByProduct(1L, 1, "Type");
  }

  /**
   * Test
   * {@link RelatedProductsVariableExpression#findByProduct(Long, Integer, String)}
   * with {@code productId}, {@code quantity}, {@code type}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsVariableExpression#findByProduct(Long, Integer, String)}
   */
  @Test
  @DisplayName("Test findByProduct(Long, Integer, String) with 'productId', 'quantity', 'type'; then return size is one")
  void testFindByProductWithProductIdQuantityType_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<PromotableProduct> promotableProductList = new ArrayList<>();
    promotableProductList.add(new CrossSaleProductImpl());
    RelatedProductsService relatedProductsService = mock(RelatedProductsService.class);
    Mockito
        .<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(promotableProductList);

    // Act
    List<Product> actualFindByProductResult = (new RelatedProductsVariableExpression(relatedProductsService))
        .findByProduct(1L, 1, "Type");

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertEquals(1, actualFindByProductResult.size());
    Product getResult = actualFindByProductResult.get(0);
    assertTrue(getResult instanceof ProductImpl);
    FieldEntity fieldEntityType = getResult.getFieldEntityType();
    List<String> allLookupTypes = fieldEntityType.getAllLookupTypes();
    assertEquals(1, allLookupTypes.size());
    assertEquals("PRODUCT", allLookupTypes.get(0));
    assertEquals("PRODUCT", fieldEntityType.getType());
    assertEquals("Product", fieldEntityType.getFriendlyType());
    assertEquals('N', ((ProductImpl) getResult).getArchived().charValue());
    assertNull(getResult.getId());
    assertNull(getResult.getCanonicalUrl());
    assertNull(getResult.getDisplayTemplate());
    assertNull(getResult.getGeneratedUrl());
    assertNull(getResult.getManufacturer());
    assertNull(getResult.getMetaDescription());
    assertNull(getResult.getMetaTitle());
    assertNull(getResult.getModel());
    assertNull(getResult.getPromoMessage());
    assertNull(getResult.getUrl());
    assertNull(((ProductImpl) getResult).getLocation());
    assertNull(getResult.getPrice());
    assertNull(getResult.getRetailPrice());
    assertNull(getResult.getSalePrice());
    assertNull(getResult.getCategory());
    assertNull(getResult.getDefaultCategory());
    List<Sku> allSellableSkus = getResult.getAllSellableSkus();
    assertEquals(1, allSellableSkus.size());
    assertNull(allSellableSkus.get(0));
    assertNull(getResult.getDefaultSku());
    assertFalse(getResult.getCanSellWithoutOptions());
    assertFalse(getResult.getOverrideGeneratedUrl());
    assertFalse(getResult.hasRetailPrice());
    assertTrue(getResult.getAdditionalSkus().isEmpty());
    assertTrue(getResult.getAllParentCategories().isEmpty());
    assertTrue(getResult.getAllParentCategoryIds().isEmpty());
    assertTrue(getResult.getAllParentCategoryXrefs().isEmpty());
    List<RelatedProduct> crossSaleProducts = getResult.getCrossSaleProducts();
    assertTrue(crossSaleProducts.isEmpty());
    List<RelatedProduct> cumulativeUpSaleProducts = getResult.getCumulativeUpSaleProducts();
    assertTrue(cumulativeUpSaleProducts.isEmpty());
    assertTrue(getResult.getParentCategoryHierarchyIds().isEmpty());
    assertTrue(getResult.getProductOptionXrefs().isEmpty());
    assertTrue(getResult.getProductOptions().isEmpty());
    assertTrue(getResult.getSkus().isEmpty());
    assertTrue(fieldEntityType.getAdditionalLookupTypes().isEmpty());
    assertTrue(getResult.getMultiValueProductAttributes().isEmpty());
    assertTrue(getResult.getProductAttributes().isEmpty());
    assertTrue(getResult.getProductOptionValuesMap().isEmpty());
    assertSame(crossSaleProducts, getResult.getCumulativeCrossSaleProducts());
    assertSame(cumulativeUpSaleProducts, getResult.getUpSaleProducts());
  }

  /**
   * Test
   * {@link RelatedProductsVariableExpression#findByProduct(Long, Integer, String)}
   * with {@code productId}, {@code quantity}, {@code type}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsVariableExpression#findByProduct(Long, Integer, String)}
   */
  @Test
  @DisplayName("Test findByProduct(Long, Integer, String) with 'productId', 'quantity', 'type'; when 'null'; then return Empty")
  void testFindByProductWithProductIdQuantityType_whenNull_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsService relatedProductsService = mock(RelatedProductsService.class);
    Mockito
        .<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Product> actualFindByProductResult = (new RelatedProductsVariableExpression(relatedProductsService))
        .findByProduct(1L, null, "Type");

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertTrue(actualFindByProductResult.isEmpty());
  }

  /**
   * Test
   * {@link RelatedProductsVariableExpression#findByProduct(Long, Integer, String)}
   * with {@code productId}, {@code quantity}, {@code type}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsVariableExpression#findByProduct(Long, Integer, String)}
   */
  @Test
  @DisplayName("Test findByProduct(Long, Integer, String) with 'productId', 'quantity', 'type'; when 'null'; then return Empty")
  void testFindByProductWithProductIdQuantityType_whenNull_thenReturnEmpty2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsService relatedProductsService = mock(RelatedProductsService.class);
    Mockito
        .<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Product> actualFindByProductResult = (new RelatedProductsVariableExpression(relatedProductsService))
        .findByProduct(1L, 1, null);

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertTrue(actualFindByProductResult.isEmpty());
  }

  /**
   * Test
   * {@link RelatedProductsVariableExpression#findByProduct(Long, Integer, String)}
   * with {@code productId}, {@code quantity}, {@code type}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsVariableExpression#findByProduct(Long, Integer, String)}
   */
  @Test
  @DisplayName("Test findByProduct(Long, Integer, String) with 'productId', 'quantity', 'type'; when 'Type'; then return Empty")
  void testFindByProductWithProductIdQuantityType_whenType_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsService relatedProductsService = mock(RelatedProductsService.class);
    Mockito
        .<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Product> actualFindByProductResult = (new RelatedProductsVariableExpression(relatedProductsService))
        .findByProduct(1L, 1, "Type");

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertTrue(actualFindByProductResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsVariableExpression#findByProduct(Long, Integer)}
   * with {@code productId}, {@code quantity}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsVariableExpression#findByProduct(Long, Integer)}
   */
  @Test
  @DisplayName("Test findByProduct(Long, Integer) with 'productId', 'quantity'; then return size is one")
  void testFindByProductWithProductIdQuantity_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<PromotableProduct> promotableProductList = new ArrayList<>();
    promotableProductList.add(new CrossSaleProductImpl());
    RelatedProductsService relatedProductsService = mock(RelatedProductsService.class);
    Mockito
        .<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(promotableProductList);

    // Act
    List<Product> actualFindByProductResult = (new RelatedProductsVariableExpression(relatedProductsService))
        .findByProduct(1L, 1);

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertEquals(1, actualFindByProductResult.size());
    Product getResult = actualFindByProductResult.get(0);
    assertTrue(getResult instanceof ProductImpl);
    FieldEntity fieldEntityType = getResult.getFieldEntityType();
    List<String> allLookupTypes = fieldEntityType.getAllLookupTypes();
    assertEquals(1, allLookupTypes.size());
    assertEquals("PRODUCT", allLookupTypes.get(0));
    assertEquals("PRODUCT", fieldEntityType.getType());
    assertEquals("Product", fieldEntityType.getFriendlyType());
    assertEquals('N', ((ProductImpl) getResult).getArchived().charValue());
    assertNull(getResult.getId());
    assertNull(getResult.getCanonicalUrl());
    assertNull(getResult.getDisplayTemplate());
    assertNull(getResult.getGeneratedUrl());
    assertNull(getResult.getManufacturer());
    assertNull(getResult.getMetaDescription());
    assertNull(getResult.getMetaTitle());
    assertNull(getResult.getModel());
    assertNull(getResult.getPromoMessage());
    assertNull(getResult.getUrl());
    assertNull(((ProductImpl) getResult).getLocation());
    assertNull(getResult.getPrice());
    assertNull(getResult.getRetailPrice());
    assertNull(getResult.getSalePrice());
    assertNull(getResult.getCategory());
    assertNull(getResult.getDefaultCategory());
    List<Sku> allSellableSkus = getResult.getAllSellableSkus();
    assertEquals(1, allSellableSkus.size());
    assertNull(allSellableSkus.get(0));
    assertNull(getResult.getDefaultSku());
    assertFalse(getResult.getCanSellWithoutOptions());
    assertFalse(getResult.getOverrideGeneratedUrl());
    assertFalse(getResult.hasRetailPrice());
    assertTrue(getResult.getAdditionalSkus().isEmpty());
    assertTrue(getResult.getAllParentCategories().isEmpty());
    assertTrue(getResult.getAllParentCategoryIds().isEmpty());
    assertTrue(getResult.getAllParentCategoryXrefs().isEmpty());
    List<RelatedProduct> crossSaleProducts = getResult.getCrossSaleProducts();
    assertTrue(crossSaleProducts.isEmpty());
    List<RelatedProduct> cumulativeUpSaleProducts = getResult.getCumulativeUpSaleProducts();
    assertTrue(cumulativeUpSaleProducts.isEmpty());
    assertTrue(getResult.getParentCategoryHierarchyIds().isEmpty());
    assertTrue(getResult.getProductOptionXrefs().isEmpty());
    assertTrue(getResult.getProductOptions().isEmpty());
    assertTrue(getResult.getSkus().isEmpty());
    assertTrue(fieldEntityType.getAdditionalLookupTypes().isEmpty());
    assertTrue(getResult.getMultiValueProductAttributes().isEmpty());
    assertTrue(getResult.getProductAttributes().isEmpty());
    assertTrue(getResult.getProductOptionValuesMap().isEmpty());
    assertSame(crossSaleProducts, getResult.getCumulativeCrossSaleProducts());
    assertSame(cumulativeUpSaleProducts, getResult.getUpSaleProducts());
  }

  /**
   * Test {@link RelatedProductsVariableExpression#findByProduct(Long, Integer)}
   * with {@code productId}, {@code quantity}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsVariableExpression#findByProduct(Long, Integer)}
   */
  @Test
  @DisplayName("Test findByProduct(Long, Integer) with 'productId', 'quantity'; when 'null'; then return Empty")
  void testFindByProductWithProductIdQuantity_whenNull_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsService relatedProductsService = mock(RelatedProductsService.class);
    Mockito
        .<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Product> actualFindByProductResult = (new RelatedProductsVariableExpression(relatedProductsService))
        .findByProduct(1L, null);

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertTrue(actualFindByProductResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsVariableExpression#findByProduct(Long, Integer)}
   * with {@code productId}, {@code quantity}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsVariableExpression#findByProduct(Long, Integer)}
   */
  @Test
  @DisplayName("Test findByProduct(Long, Integer) with 'productId', 'quantity'; when one; then return Empty")
  void testFindByProductWithProductIdQuantity_whenOne_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsService relatedProductsService = mock(RelatedProductsService.class);
    Mockito
        .<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Product> actualFindByProductResult = (new RelatedProductsVariableExpression(relatedProductsService))
        .findByProduct(1L, 1);

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertTrue(actualFindByProductResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsVariableExpression#findByProduct(Long)} with
   * {@code productId}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsVariableExpression#findByProduct(Long)}
   */
  @Test
  @DisplayName("Test findByProduct(Long) with 'productId'; then return Empty")
  void testFindByProductWithProductId_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsService relatedProductsService = mock(RelatedProductsService.class);
    Mockito
        .<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Product> actualFindByProductResult = (new RelatedProductsVariableExpression(relatedProductsService))
        .findByProduct(1L);

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertTrue(actualFindByProductResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsVariableExpression#findByProduct(Long)} with
   * {@code productId}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsVariableExpression#findByProduct(Long)}
   */
  @Test
  @DisplayName("Test findByProduct(Long) with 'productId'; then return size is one")
  void testFindByProductWithProductId_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<PromotableProduct> promotableProductList = new ArrayList<>();
    promotableProductList.add(new CrossSaleProductImpl());
    RelatedProductsService relatedProductsService = mock(RelatedProductsService.class);
    Mockito
        .<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(promotableProductList);

    // Act
    List<Product> actualFindByProductResult = (new RelatedProductsVariableExpression(relatedProductsService))
        .findByProduct(1L);

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertEquals(1, actualFindByProductResult.size());
    Product getResult = actualFindByProductResult.get(0);
    assertTrue(getResult instanceof ProductImpl);
    FieldEntity fieldEntityType = getResult.getFieldEntityType();
    List<String> allLookupTypes = fieldEntityType.getAllLookupTypes();
    assertEquals(1, allLookupTypes.size());
    assertEquals("PRODUCT", allLookupTypes.get(0));
    assertEquals("PRODUCT", fieldEntityType.getType());
    assertEquals("Product", fieldEntityType.getFriendlyType());
    assertEquals('N', ((ProductImpl) getResult).getArchived().charValue());
    assertNull(getResult.getId());
    assertNull(getResult.getCanonicalUrl());
    assertNull(getResult.getDisplayTemplate());
    assertNull(getResult.getGeneratedUrl());
    assertNull(getResult.getManufacturer());
    assertNull(getResult.getMetaDescription());
    assertNull(getResult.getMetaTitle());
    assertNull(getResult.getModel());
    assertNull(getResult.getPromoMessage());
    assertNull(getResult.getUrl());
    assertNull(((ProductImpl) getResult).getLocation());
    assertNull(getResult.getPrice());
    assertNull(getResult.getRetailPrice());
    assertNull(getResult.getSalePrice());
    assertNull(getResult.getCategory());
    assertNull(getResult.getDefaultCategory());
    List<Sku> allSellableSkus = getResult.getAllSellableSkus();
    assertEquals(1, allSellableSkus.size());
    assertNull(allSellableSkus.get(0));
    assertNull(getResult.getDefaultSku());
    assertFalse(getResult.getCanSellWithoutOptions());
    assertFalse(getResult.getOverrideGeneratedUrl());
    assertFalse(getResult.hasRetailPrice());
    assertTrue(getResult.getAdditionalSkus().isEmpty());
    assertTrue(getResult.getAllParentCategories().isEmpty());
    assertTrue(getResult.getAllParentCategoryIds().isEmpty());
    assertTrue(getResult.getAllParentCategoryXrefs().isEmpty());
    List<RelatedProduct> crossSaleProducts = getResult.getCrossSaleProducts();
    assertTrue(crossSaleProducts.isEmpty());
    List<RelatedProduct> cumulativeUpSaleProducts = getResult.getCumulativeUpSaleProducts();
    assertTrue(cumulativeUpSaleProducts.isEmpty());
    assertTrue(getResult.getParentCategoryHierarchyIds().isEmpty());
    assertTrue(getResult.getProductOptionXrefs().isEmpty());
    assertTrue(getResult.getProductOptions().isEmpty());
    assertTrue(getResult.getSkus().isEmpty());
    assertTrue(fieldEntityType.getAdditionalLookupTypes().isEmpty());
    assertTrue(getResult.getMultiValueProductAttributes().isEmpty());
    assertTrue(getResult.getProductAttributes().isEmpty());
    assertTrue(getResult.getProductOptionValuesMap().isEmpty());
    assertSame(crossSaleProducts, getResult.getCumulativeCrossSaleProducts());
    assertSame(cumulativeUpSaleProducts, getResult.getUpSaleProducts());
  }

  /**
   * Test {@link RelatedProductsVariableExpression#findByCategory(Long, Integer)}
   * with {@code categoryId}, {@code quantity}.
   * <p>
   * Method under test:
   * {@link RelatedProductsVariableExpression#findByCategory(Long, Integer)}
   */
  @Test
  @DisplayName("Test findByCategory(Long, Integer) with 'categoryId', 'quantity'")
  @Disabled("TODO: Complete this test")
  void testFindByCategoryWithCategoryIdQuantity() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3115 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.RelatedProductsVariableExpression relatedProductsVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new RelatedProductsVariableExpression(mock(RelatedProductsService.class))).findByCategory(1L, 1);
  }

  /**
   * Test
   * {@link RelatedProductsVariableExpression#findByCategory(Long, Integer, String)}
   * with {@code categoryId}, {@code quantity}, {@code type}.
   * <p>
   * Method under test:
   * {@link RelatedProductsVariableExpression#findByCategory(Long, Integer, String)}
   */
  @Test
  @DisplayName("Test findByCategory(Long, Integer, String) with 'categoryId', 'quantity', 'type'")
  @Disabled("TODO: Complete this test")
  void testFindByCategoryWithCategoryIdQuantityType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3136 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.RelatedProductsVariableExpression relatedProductsVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new RelatedProductsVariableExpression(mock(RelatedProductsService.class))).findByCategory(1L, 1, "Type");
  }

  /**
   * Test
   * {@link RelatedProductsVariableExpression#findByCategory(Long, Integer, String)}
   * with {@code categoryId}, {@code quantity}, {@code type}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsVariableExpression#findByCategory(Long, Integer, String)}
   */
  @Test
  @DisplayName("Test findByCategory(Long, Integer, String) with 'categoryId', 'quantity', 'type'; then return size is one")
  void testFindByCategoryWithCategoryIdQuantityType_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<PromotableProduct> promotableProductList = new ArrayList<>();
    promotableProductList.add(new CrossSaleProductImpl());
    RelatedProductsService relatedProductsService = mock(RelatedProductsService.class);
    Mockito
        .<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(promotableProductList);

    // Act
    List<Product> actualFindByCategoryResult = (new RelatedProductsVariableExpression(relatedProductsService))
        .findByCategory(1L, 1, "Type");

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertEquals(1, actualFindByCategoryResult.size());
    Product getResult = actualFindByCategoryResult.get(0);
    assertTrue(getResult instanceof ProductImpl);
    FieldEntity fieldEntityType = getResult.getFieldEntityType();
    List<String> allLookupTypes = fieldEntityType.getAllLookupTypes();
    assertEquals(1, allLookupTypes.size());
    assertEquals("PRODUCT", allLookupTypes.get(0));
    assertEquals("PRODUCT", fieldEntityType.getType());
    assertEquals("Product", fieldEntityType.getFriendlyType());
    assertEquals('N', ((ProductImpl) getResult).getArchived().charValue());
    assertNull(getResult.getId());
    assertNull(getResult.getCanonicalUrl());
    assertNull(getResult.getDisplayTemplate());
    assertNull(getResult.getGeneratedUrl());
    assertNull(getResult.getManufacturer());
    assertNull(getResult.getMetaDescription());
    assertNull(getResult.getMetaTitle());
    assertNull(getResult.getModel());
    assertNull(getResult.getPromoMessage());
    assertNull(getResult.getUrl());
    assertNull(((ProductImpl) getResult).getLocation());
    assertNull(getResult.getPrice());
    assertNull(getResult.getRetailPrice());
    assertNull(getResult.getSalePrice());
    assertNull(getResult.getCategory());
    assertNull(getResult.getDefaultCategory());
    List<Sku> allSellableSkus = getResult.getAllSellableSkus();
    assertEquals(1, allSellableSkus.size());
    assertNull(allSellableSkus.get(0));
    assertNull(getResult.getDefaultSku());
    assertFalse(getResult.getCanSellWithoutOptions());
    assertFalse(getResult.getOverrideGeneratedUrl());
    assertFalse(getResult.hasRetailPrice());
    assertTrue(getResult.getAdditionalSkus().isEmpty());
    assertTrue(getResult.getAllParentCategories().isEmpty());
    assertTrue(getResult.getAllParentCategoryIds().isEmpty());
    assertTrue(getResult.getAllParentCategoryXrefs().isEmpty());
    List<RelatedProduct> crossSaleProducts = getResult.getCrossSaleProducts();
    assertTrue(crossSaleProducts.isEmpty());
    List<RelatedProduct> cumulativeUpSaleProducts = getResult.getCumulativeUpSaleProducts();
    assertTrue(cumulativeUpSaleProducts.isEmpty());
    assertTrue(getResult.getParentCategoryHierarchyIds().isEmpty());
    assertTrue(getResult.getProductOptionXrefs().isEmpty());
    assertTrue(getResult.getProductOptions().isEmpty());
    assertTrue(getResult.getSkus().isEmpty());
    assertTrue(fieldEntityType.getAdditionalLookupTypes().isEmpty());
    assertTrue(getResult.getMultiValueProductAttributes().isEmpty());
    assertTrue(getResult.getProductAttributes().isEmpty());
    assertTrue(getResult.getProductOptionValuesMap().isEmpty());
    assertSame(crossSaleProducts, getResult.getCumulativeCrossSaleProducts());
    assertSame(cumulativeUpSaleProducts, getResult.getUpSaleProducts());
  }

  /**
   * Test
   * {@link RelatedProductsVariableExpression#findByCategory(Long, Integer, String)}
   * with {@code categoryId}, {@code quantity}, {@code type}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsVariableExpression#findByCategory(Long, Integer, String)}
   */
  @Test
  @DisplayName("Test findByCategory(Long, Integer, String) with 'categoryId', 'quantity', 'type'; when 'null'; then return Empty")
  void testFindByCategoryWithCategoryIdQuantityType_whenNull_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsService relatedProductsService = mock(RelatedProductsService.class);
    Mockito
        .<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Product> actualFindByCategoryResult = (new RelatedProductsVariableExpression(relatedProductsService))
        .findByCategory(1L, null, "Type");

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertTrue(actualFindByCategoryResult.isEmpty());
  }

  /**
   * Test
   * {@link RelatedProductsVariableExpression#findByCategory(Long, Integer, String)}
   * with {@code categoryId}, {@code quantity}, {@code type}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsVariableExpression#findByCategory(Long, Integer, String)}
   */
  @Test
  @DisplayName("Test findByCategory(Long, Integer, String) with 'categoryId', 'quantity', 'type'; when 'null'; then return Empty")
  void testFindByCategoryWithCategoryIdQuantityType_whenNull_thenReturnEmpty2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsService relatedProductsService = mock(RelatedProductsService.class);
    Mockito
        .<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Product> actualFindByCategoryResult = (new RelatedProductsVariableExpression(relatedProductsService))
        .findByCategory(1L, 1, null);

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertTrue(actualFindByCategoryResult.isEmpty());
  }

  /**
   * Test
   * {@link RelatedProductsVariableExpression#findByCategory(Long, Integer, String)}
   * with {@code categoryId}, {@code quantity}, {@code type}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsVariableExpression#findByCategory(Long, Integer, String)}
   */
  @Test
  @DisplayName("Test findByCategory(Long, Integer, String) with 'categoryId', 'quantity', 'type'; when 'Type'; then return Empty")
  void testFindByCategoryWithCategoryIdQuantityType_whenType_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsService relatedProductsService = mock(RelatedProductsService.class);
    Mockito
        .<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Product> actualFindByCategoryResult = (new RelatedProductsVariableExpression(relatedProductsService))
        .findByCategory(1L, 1, "Type");

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertTrue(actualFindByCategoryResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsVariableExpression#findByCategory(Long, Integer)}
   * with {@code categoryId}, {@code quantity}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsVariableExpression#findByCategory(Long, Integer)}
   */
  @Test
  @DisplayName("Test findByCategory(Long, Integer) with 'categoryId', 'quantity'; then return size is one")
  void testFindByCategoryWithCategoryIdQuantity_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<PromotableProduct> promotableProductList = new ArrayList<>();
    promotableProductList.add(new CrossSaleProductImpl());
    RelatedProductsService relatedProductsService = mock(RelatedProductsService.class);
    Mockito
        .<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(promotableProductList);

    // Act
    List<Product> actualFindByCategoryResult = (new RelatedProductsVariableExpression(relatedProductsService))
        .findByCategory(1L, 1);

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertEquals(1, actualFindByCategoryResult.size());
    Product getResult = actualFindByCategoryResult.get(0);
    assertTrue(getResult instanceof ProductImpl);
    FieldEntity fieldEntityType = getResult.getFieldEntityType();
    List<String> allLookupTypes = fieldEntityType.getAllLookupTypes();
    assertEquals(1, allLookupTypes.size());
    assertEquals("PRODUCT", allLookupTypes.get(0));
    assertEquals("PRODUCT", fieldEntityType.getType());
    assertEquals("Product", fieldEntityType.getFriendlyType());
    assertEquals('N', ((ProductImpl) getResult).getArchived().charValue());
    assertNull(getResult.getId());
    assertNull(getResult.getCanonicalUrl());
    assertNull(getResult.getDisplayTemplate());
    assertNull(getResult.getGeneratedUrl());
    assertNull(getResult.getManufacturer());
    assertNull(getResult.getMetaDescription());
    assertNull(getResult.getMetaTitle());
    assertNull(getResult.getModel());
    assertNull(getResult.getPromoMessage());
    assertNull(getResult.getUrl());
    assertNull(((ProductImpl) getResult).getLocation());
    assertNull(getResult.getPrice());
    assertNull(getResult.getRetailPrice());
    assertNull(getResult.getSalePrice());
    assertNull(getResult.getCategory());
    assertNull(getResult.getDefaultCategory());
    List<Sku> allSellableSkus = getResult.getAllSellableSkus();
    assertEquals(1, allSellableSkus.size());
    assertNull(allSellableSkus.get(0));
    assertNull(getResult.getDefaultSku());
    assertFalse(getResult.getCanSellWithoutOptions());
    assertFalse(getResult.getOverrideGeneratedUrl());
    assertFalse(getResult.hasRetailPrice());
    assertTrue(getResult.getAdditionalSkus().isEmpty());
    assertTrue(getResult.getAllParentCategories().isEmpty());
    assertTrue(getResult.getAllParentCategoryIds().isEmpty());
    assertTrue(getResult.getAllParentCategoryXrefs().isEmpty());
    List<RelatedProduct> crossSaleProducts = getResult.getCrossSaleProducts();
    assertTrue(crossSaleProducts.isEmpty());
    List<RelatedProduct> cumulativeUpSaleProducts = getResult.getCumulativeUpSaleProducts();
    assertTrue(cumulativeUpSaleProducts.isEmpty());
    assertTrue(getResult.getParentCategoryHierarchyIds().isEmpty());
    assertTrue(getResult.getProductOptionXrefs().isEmpty());
    assertTrue(getResult.getProductOptions().isEmpty());
    assertTrue(getResult.getSkus().isEmpty());
    assertTrue(fieldEntityType.getAdditionalLookupTypes().isEmpty());
    assertTrue(getResult.getMultiValueProductAttributes().isEmpty());
    assertTrue(getResult.getProductAttributes().isEmpty());
    assertTrue(getResult.getProductOptionValuesMap().isEmpty());
    assertSame(crossSaleProducts, getResult.getCumulativeCrossSaleProducts());
    assertSame(cumulativeUpSaleProducts, getResult.getUpSaleProducts());
  }

  /**
   * Test {@link RelatedProductsVariableExpression#findByCategory(Long, Integer)}
   * with {@code categoryId}, {@code quantity}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsVariableExpression#findByCategory(Long, Integer)}
   */
  @Test
  @DisplayName("Test findByCategory(Long, Integer) with 'categoryId', 'quantity'; when 'null'; then return Empty")
  void testFindByCategoryWithCategoryIdQuantity_whenNull_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsService relatedProductsService = mock(RelatedProductsService.class);
    Mockito
        .<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Product> actualFindByCategoryResult = (new RelatedProductsVariableExpression(relatedProductsService))
        .findByCategory(1L, null);

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertTrue(actualFindByCategoryResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsVariableExpression#findByCategory(Long, Integer)}
   * with {@code categoryId}, {@code quantity}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsVariableExpression#findByCategory(Long, Integer)}
   */
  @Test
  @DisplayName("Test findByCategory(Long, Integer) with 'categoryId', 'quantity'; when one; then return Empty")
  void testFindByCategoryWithCategoryIdQuantity_whenOne_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsService relatedProductsService = mock(RelatedProductsService.class);
    Mockito
        .<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Product> actualFindByCategoryResult = (new RelatedProductsVariableExpression(relatedProductsService))
        .findByCategory(1L, 1);

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertTrue(actualFindByCategoryResult.isEmpty());
  }

  /**
   * Test
   * {@link RelatedProductsVariableExpression#getRelatedProducts(Long, Long, Integer, String)}.
   * <p>
   * Method under test:
   * {@link RelatedProductsVariableExpression#getRelatedProducts(Long, Long, Integer, String)}
   */
  @Test
  @DisplayName("Test getRelatedProducts(Long, Long, Integer, String)")
  @Disabled("TODO: Complete this test")
  void testGetRelatedProducts() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3223 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.RelatedProductsVariableExpression relatedProductsVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new RelatedProductsVariableExpression(mock(RelatedProductsService.class))).getRelatedProducts(1L, 1L, 1, "Type");
  }

  /**
   * Test
   * {@link RelatedProductsVariableExpression#getRelatedProducts(Long, Long, Integer, String)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CrossSaleProductImpl}
   * (default constructor).</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsVariableExpression#getRelatedProducts(Long, Long, Integer, String)}
   */
  @Test
  @DisplayName("Test getRelatedProducts(Long, Long, Integer, String); given ArrayList() add CrossSaleProductImpl (default constructor); then return size is one")
  void testGetRelatedProducts_givenArrayListAddCrossSaleProductImpl_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<PromotableProduct> promotableProductList = new ArrayList<>();
    promotableProductList.add(new CrossSaleProductImpl());
    RelatedProductsService relatedProductsService = mock(RelatedProductsService.class);
    Mockito
        .<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(promotableProductList);

    // Act
    List<Product> actualRelatedProducts = (new RelatedProductsVariableExpression(relatedProductsService))
        .getRelatedProducts(1L, 1L, 1, "Type");

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertEquals(1, actualRelatedProducts.size());
    Product getResult = actualRelatedProducts.get(0);
    assertTrue(getResult instanceof ProductImpl);
    FieldEntity fieldEntityType = getResult.getFieldEntityType();
    List<String> allLookupTypes = fieldEntityType.getAllLookupTypes();
    assertEquals(1, allLookupTypes.size());
    assertEquals("PRODUCT", allLookupTypes.get(0));
    assertEquals("PRODUCT", fieldEntityType.getType());
    assertEquals("Product", fieldEntityType.getFriendlyType());
    assertEquals('N', ((ProductImpl) getResult).getArchived().charValue());
    assertNull(getResult.getId());
    assertNull(getResult.getCanonicalUrl());
    assertNull(getResult.getDisplayTemplate());
    assertNull(getResult.getGeneratedUrl());
    assertNull(getResult.getManufacturer());
    assertNull(getResult.getMetaDescription());
    assertNull(getResult.getMetaTitle());
    assertNull(getResult.getModel());
    assertNull(getResult.getPromoMessage());
    assertNull(getResult.getUrl());
    assertNull(((ProductImpl) getResult).getLocation());
    assertNull(getResult.getPrice());
    assertNull(getResult.getRetailPrice());
    assertNull(getResult.getSalePrice());
    assertNull(getResult.getCategory());
    assertNull(getResult.getDefaultCategory());
    List<Sku> allSellableSkus = getResult.getAllSellableSkus();
    assertEquals(1, allSellableSkus.size());
    assertNull(allSellableSkus.get(0));
    assertNull(getResult.getDefaultSku());
    assertFalse(getResult.getCanSellWithoutOptions());
    assertFalse(getResult.getOverrideGeneratedUrl());
    assertFalse(getResult.hasRetailPrice());
    assertTrue(getResult.getAdditionalSkus().isEmpty());
    assertTrue(getResult.getAllParentCategories().isEmpty());
    assertTrue(getResult.getAllParentCategoryIds().isEmpty());
    assertTrue(getResult.getAllParentCategoryXrefs().isEmpty());
    List<RelatedProduct> crossSaleProducts = getResult.getCrossSaleProducts();
    assertTrue(crossSaleProducts.isEmpty());
    List<RelatedProduct> cumulativeUpSaleProducts = getResult.getCumulativeUpSaleProducts();
    assertTrue(cumulativeUpSaleProducts.isEmpty());
    assertTrue(getResult.getParentCategoryHierarchyIds().isEmpty());
    assertTrue(getResult.getProductOptionXrefs().isEmpty());
    assertTrue(getResult.getProductOptions().isEmpty());
    assertTrue(getResult.getSkus().isEmpty());
    assertTrue(fieldEntityType.getAdditionalLookupTypes().isEmpty());
    assertTrue(getResult.getMultiValueProductAttributes().isEmpty());
    assertTrue(getResult.getProductAttributes().isEmpty());
    assertTrue(getResult.getProductOptionValuesMap().isEmpty());
    assertSame(crossSaleProducts, getResult.getCumulativeCrossSaleProducts());
    assertSame(cumulativeUpSaleProducts, getResult.getUpSaleProducts());
  }

  /**
   * Test
   * {@link RelatedProductsVariableExpression#getRelatedProducts(Long, Long, Integer, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsVariableExpression#getRelatedProducts(Long, Long, Integer, String)}
   */
  @Test
  @DisplayName("Test getRelatedProducts(Long, Long, Integer, String); when 'null'; then return Empty")
  void testGetRelatedProducts_whenNull_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsService relatedProductsService = mock(RelatedProductsService.class);
    Mockito
        .<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Product> actualRelatedProducts = (new RelatedProductsVariableExpression(relatedProductsService))
        .getRelatedProducts(1L, 1L, null, "Type");

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertTrue(actualRelatedProducts.isEmpty());
  }

  /**
   * Test
   * {@link RelatedProductsVariableExpression#getRelatedProducts(Long, Long, Integer, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsVariableExpression#getRelatedProducts(Long, Long, Integer, String)}
   */
  @Test
  @DisplayName("Test getRelatedProducts(Long, Long, Integer, String); when 'null'; then return Empty")
  void testGetRelatedProducts_whenNull_thenReturnEmpty2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsService relatedProductsService = mock(RelatedProductsService.class);
    Mockito
        .<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Product> actualRelatedProducts = (new RelatedProductsVariableExpression(relatedProductsService))
        .getRelatedProducts(1L, 1L, 1, null);

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertTrue(actualRelatedProducts.isEmpty());
  }

  /**
   * Test
   * {@link RelatedProductsVariableExpression#getRelatedProducts(Long, Long, Integer, String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsVariableExpression#getRelatedProducts(Long, Long, Integer, String)}
   */
  @Test
  @DisplayName("Test getRelatedProducts(Long, Long, Integer, String); when 'Type'; then return Empty")
  void testGetRelatedProducts_whenType_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsService relatedProductsService = mock(RelatedProductsService.class);
    Mockito
        .<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Product> actualRelatedProducts = (new RelatedProductsVariableExpression(relatedProductsService))
        .getRelatedProducts(1L, 1L, 1, "Type");

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertTrue(actualRelatedProducts.isEmpty());
  }

  /**
   * Test {@link RelatedProductsVariableExpression#buildProductList(List)}.
   * <p>
   * Method under test:
   * {@link RelatedProductsVariableExpression#buildProductList(List)}
   */
  @Test
  @DisplayName("Test buildProductList(List)")
  @Disabled("TODO: Complete this test")
  void testBuildProductList() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3107 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.RelatedProductsVariableExpression relatedProductsVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RelatedProductsVariableExpression relatedProductsVariableExpression2 = new RelatedProductsVariableExpression(
        mock(RelatedProductsService.class));

    // Act
    relatedProductsVariableExpression2.buildProductList(new ArrayList<>());
  }

  /**
   * Test {@link RelatedProductsVariableExpression#buildProductList(List)}.
   * <ul>
   *   <li>Given {@link CrossSaleProductImpl} (default constructor).</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsVariableExpression#buildProductList(List)}
   */
  @Test
  @DisplayName("Test buildProductList(List); given CrossSaleProductImpl (default constructor); then return size is one")
  void testBuildProductList_givenCrossSaleProductImpl_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsVariableExpression relatedProductsVariableExpression = new RelatedProductsVariableExpression(
        mock(RelatedProductsService.class));

    ArrayList<? extends PromotableProduct> relatedProducts = new ArrayList<>();
    relatedProducts.add(new CrossSaleProductImpl());

    // Act
    List<Product> actualBuildProductListResult = relatedProductsVariableExpression.buildProductList(relatedProducts);

    // Assert
    assertEquals(1, actualBuildProductListResult.size());
    assertTrue(actualBuildProductListResult.get(0) instanceof ProductImpl);
  }

  /**
   * Test {@link RelatedProductsVariableExpression#buildProductList(List)}.
   * <ul>
   *   <li>Given {@link CrossSaleProductImpl} (default constructor).</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsVariableExpression#buildProductList(List)}
   */
  @Test
  @DisplayName("Test buildProductList(List); given CrossSaleProductImpl (default constructor); then return size is two")
  void testBuildProductList_givenCrossSaleProductImpl_thenReturnSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsVariableExpression relatedProductsVariableExpression = new RelatedProductsVariableExpression(
        mock(RelatedProductsService.class));

    ArrayList<PromotableProduct> relatedProducts = new ArrayList<>();
    relatedProducts.add(new CrossSaleProductImpl());
    relatedProducts.add(new CrossSaleProductImpl());

    // Act
    List<Product> actualBuildProductListResult = relatedProductsVariableExpression.buildProductList(relatedProducts);

    // Assert
    assertEquals(2, actualBuildProductListResult.size());
    Product getResult = actualBuildProductListResult.get(0);
    assertTrue(getResult instanceof ProductImpl);
    Product getResult2 = actualBuildProductListResult.get(1);
    assertTrue(getResult2 instanceof ProductImpl);
    assertEquals(getResult, getResult2);
  }

  /**
   * Test {@link RelatedProductsVariableExpression#buildProductList(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsVariableExpression#buildProductList(List)}
   */
  @Test
  @DisplayName("Test buildProductList(List); when ArrayList(); then return Empty")
  void testBuildProductList_whenArrayList_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsVariableExpression relatedProductsVariableExpression = new RelatedProductsVariableExpression(
        mock(RelatedProductsService.class));

    // Act and Assert
    assertTrue(relatedProductsVariableExpression.buildProductList(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link RelatedProductsVariableExpression#buildProductList(List)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsVariableExpression#buildProductList(List)}
   */
  @Test
  @DisplayName("Test buildProductList(List); when 'null'; then return Empty")
  void testBuildProductList_whenNull_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue(
        (new RelatedProductsVariableExpression(mock(RelatedProductsService.class))).buildProductList(null).isEmpty());
  }
}

/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.expression;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.catalog.domain.CrossSaleProductImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductImpl;
import org.broadleafcommerce.core.catalog.domain.PromotableProduct;
import org.broadleafcommerce.core.catalog.domain.RelatedProductDTO;
import org.broadleafcommerce.core.catalog.service.RelatedProductsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {RelatedProductsVariableExpression.class})
@ExtendWith(SpringExtension.class)
class RelatedProductsVariableExpressionDiffblueTest {
  @MockBean private RelatedProductsService relatedProductsService;

  @Autowired private RelatedProductsVariableExpression relatedProductsVariableExpression;

  /**
   * Test {@link RelatedProductsVariableExpression#getName()}.
   *
   * <p>Method under test: {@link RelatedProductsVariableExpression#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String RelatedProductsVariableExpression.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals(
        "related_products",
        new RelatedProductsVariableExpression(mock(RelatedProductsService.class)).getName());
  }

  /**
   * Test {@link RelatedProductsVariableExpression#findByProduct(Long, Integer, String)} with {@code
   * productId}, {@code quantity}, {@code type}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsVariableExpression#findByProduct(Long, Integer,
   * String)}
   */
  @Test
  @DisplayName(
      "Test findByProduct(Long, Integer, String) with 'productId', 'quantity', 'type'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsVariableExpression.findByProduct(Long, Integer, String)"})
  void testFindByProductWithProductIdQuantityType_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<PromotableProduct> promotableProductList = new ArrayList<>();
    promotableProductList.add(new CrossSaleProductImpl());
    Mockito.<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(promotableProductList);

    // Act
    List<Product> actualFindByProductResult =
        relatedProductsVariableExpression.findByProduct(1L, 1, "Type");

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertEquals(1, actualFindByProductResult.size());
    assertTrue(actualFindByProductResult.get(0) instanceof ProductImpl);
  }

  /**
   * Test {@link RelatedProductsVariableExpression#findByProduct(Long, Integer, String)} with {@code
   * productId}, {@code quantity}, {@code type}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsVariableExpression#findByProduct(Long, Integer,
   * String)}
   */
  @Test
  @DisplayName(
      "Test findByProduct(Long, Integer, String) with 'productId', 'quantity', 'type'; when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsVariableExpression.findByProduct(Long, Integer, String)"})
  void testFindByProductWithProductIdQuantityType_whenNull_thenReturnEmpty() {
    // Arrange
    Mockito.<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Product> actualFindByProductResult =
        relatedProductsVariableExpression.findByProduct(1L, null, "Type");

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertTrue(actualFindByProductResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsVariableExpression#findByProduct(Long, Integer, String)} with {@code
   * productId}, {@code quantity}, {@code type}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsVariableExpression#findByProduct(Long, Integer,
   * String)}
   */
  @Test
  @DisplayName(
      "Test findByProduct(Long, Integer, String) with 'productId', 'quantity', 'type'; when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsVariableExpression.findByProduct(Long, Integer, String)"})
  void testFindByProductWithProductIdQuantityType_whenNull_thenReturnEmpty2() {
    // Arrange
    Mockito.<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Product> actualFindByProductResult =
        relatedProductsVariableExpression.findByProduct(1L, 1, null);

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertTrue(actualFindByProductResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsVariableExpression#findByProduct(Long, Integer, String)} with {@code
   * productId}, {@code quantity}, {@code type}.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsVariableExpression#findByProduct(Long, Integer,
   * String)}
   */
  @Test
  @DisplayName(
      "Test findByProduct(Long, Integer, String) with 'productId', 'quantity', 'type'; when 'Type'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsVariableExpression.findByProduct(Long, Integer, String)"})
  void testFindByProductWithProductIdQuantityType_whenType_thenReturnEmpty() {
    // Arrange
    Mockito.<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Product> actualFindByProductResult =
        relatedProductsVariableExpression.findByProduct(1L, 1, "Type");

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertTrue(actualFindByProductResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsVariableExpression#findByProduct(Long, Integer)} with {@code
   * productId}, {@code quantity}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsVariableExpression#findByProduct(Long, Integer)}
   */
  @Test
  @DisplayName(
      "Test findByProduct(Long, Integer) with 'productId', 'quantity'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsVariableExpression.findByProduct(Long, Integer)"})
  void testFindByProductWithProductIdQuantity_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<PromotableProduct> promotableProductList = new ArrayList<>();
    promotableProductList.add(new CrossSaleProductImpl());
    Mockito.<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(promotableProductList);

    // Act
    List<Product> actualFindByProductResult =
        relatedProductsVariableExpression.findByProduct(1L, 1);

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertEquals(1, actualFindByProductResult.size());
    assertTrue(actualFindByProductResult.get(0) instanceof ProductImpl);
  }

  /**
   * Test {@link RelatedProductsVariableExpression#findByProduct(Long, Integer)} with {@code
   * productId}, {@code quantity}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsVariableExpression#findByProduct(Long, Integer)}
   */
  @Test
  @DisplayName(
      "Test findByProduct(Long, Integer) with 'productId', 'quantity'; when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsVariableExpression.findByProduct(Long, Integer)"})
  void testFindByProductWithProductIdQuantity_whenNull_thenReturnEmpty() {
    // Arrange
    Mockito.<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Product> actualFindByProductResult =
        relatedProductsVariableExpression.findByProduct(1L, null);

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertTrue(actualFindByProductResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsVariableExpression#findByProduct(Long, Integer)} with {@code
   * productId}, {@code quantity}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsVariableExpression#findByProduct(Long, Integer)}
   */
  @Test
  @DisplayName(
      "Test findByProduct(Long, Integer) with 'productId', 'quantity'; when one; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsVariableExpression.findByProduct(Long, Integer)"})
  void testFindByProductWithProductIdQuantity_whenOne_thenReturnEmpty() {
    // Arrange
    Mockito.<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Product> actualFindByProductResult =
        relatedProductsVariableExpression.findByProduct(1L, 1);

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertTrue(actualFindByProductResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsVariableExpression#findByProduct(Long)} with {@code productId}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsVariableExpression#findByProduct(Long)}
   */
  @Test
  @DisplayName("Test findByProduct(Long) with 'productId'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsVariableExpression.findByProduct(Long)"})
  void testFindByProductWithProductId_thenReturnEmpty() {
    // Arrange
    Mockito.<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Product> actualFindByProductResult = relatedProductsVariableExpression.findByProduct(1L);

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertTrue(actualFindByProductResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsVariableExpression#findByProduct(Long)} with {@code productId}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsVariableExpression#findByProduct(Long)}
   */
  @Test
  @DisplayName("Test findByProduct(Long) with 'productId'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsVariableExpression.findByProduct(Long)"})
  void testFindByProductWithProductId_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<PromotableProduct> promotableProductList = new ArrayList<>();
    promotableProductList.add(new CrossSaleProductImpl());
    Mockito.<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(promotableProductList);

    // Act
    List<Product> actualFindByProductResult = relatedProductsVariableExpression.findByProduct(1L);

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertEquals(1, actualFindByProductResult.size());
    assertTrue(actualFindByProductResult.get(0) instanceof ProductImpl);
  }

  /**
   * Test {@link RelatedProductsVariableExpression#findByCategory(Long, Integer, String)} with
   * {@code categoryId}, {@code quantity}, {@code type}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsVariableExpression#findByCategory(Long, Integer,
   * String)}
   */
  @Test
  @DisplayName(
      "Test findByCategory(Long, Integer, String) with 'categoryId', 'quantity', 'type'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RelatedProductsVariableExpression.findByCategory(Long, Integer, String)"
  })
  void testFindByCategoryWithCategoryIdQuantityType_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<PromotableProduct> promotableProductList = new ArrayList<>();
    promotableProductList.add(new CrossSaleProductImpl());
    Mockito.<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(promotableProductList);

    // Act
    List<Product> actualFindByCategoryResult =
        relatedProductsVariableExpression.findByCategory(1L, 1, "Type");

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertEquals(1, actualFindByCategoryResult.size());
    assertTrue(actualFindByCategoryResult.get(0) instanceof ProductImpl);
  }

  /**
   * Test {@link RelatedProductsVariableExpression#findByCategory(Long, Integer, String)} with
   * {@code categoryId}, {@code quantity}, {@code type}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsVariableExpression#findByCategory(Long, Integer,
   * String)}
   */
  @Test
  @DisplayName(
      "Test findByCategory(Long, Integer, String) with 'categoryId', 'quantity', 'type'; when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RelatedProductsVariableExpression.findByCategory(Long, Integer, String)"
  })
  void testFindByCategoryWithCategoryIdQuantityType_whenNull_thenReturnEmpty() {
    // Arrange
    Mockito.<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Product> actualFindByCategoryResult =
        relatedProductsVariableExpression.findByCategory(1L, null, "Type");

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertTrue(actualFindByCategoryResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsVariableExpression#findByCategory(Long, Integer, String)} with
   * {@code categoryId}, {@code quantity}, {@code type}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsVariableExpression#findByCategory(Long, Integer,
   * String)}
   */
  @Test
  @DisplayName(
      "Test findByCategory(Long, Integer, String) with 'categoryId', 'quantity', 'type'; when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RelatedProductsVariableExpression.findByCategory(Long, Integer, String)"
  })
  void testFindByCategoryWithCategoryIdQuantityType_whenNull_thenReturnEmpty2() {
    // Arrange
    Mockito.<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Product> actualFindByCategoryResult =
        relatedProductsVariableExpression.findByCategory(1L, 1, null);

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertTrue(actualFindByCategoryResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsVariableExpression#findByCategory(Long, Integer, String)} with
   * {@code categoryId}, {@code quantity}, {@code type}.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsVariableExpression#findByCategory(Long, Integer,
   * String)}
   */
  @Test
  @DisplayName(
      "Test findByCategory(Long, Integer, String) with 'categoryId', 'quantity', 'type'; when 'Type'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RelatedProductsVariableExpression.findByCategory(Long, Integer, String)"
  })
  void testFindByCategoryWithCategoryIdQuantityType_whenType_thenReturnEmpty() {
    // Arrange
    Mockito.<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Product> actualFindByCategoryResult =
        relatedProductsVariableExpression.findByCategory(1L, 1, "Type");

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertTrue(actualFindByCategoryResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsVariableExpression#findByCategory(Long, Integer)} with {@code
   * categoryId}, {@code quantity}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsVariableExpression#findByCategory(Long, Integer)}
   */
  @Test
  @DisplayName(
      "Test findByCategory(Long, Integer) with 'categoryId', 'quantity'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsVariableExpression.findByCategory(Long, Integer)"})
  void testFindByCategoryWithCategoryIdQuantity_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<PromotableProduct> promotableProductList = new ArrayList<>();
    promotableProductList.add(new CrossSaleProductImpl());
    Mockito.<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(promotableProductList);

    // Act
    List<Product> actualFindByCategoryResult =
        relatedProductsVariableExpression.findByCategory(1L, 1);

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertEquals(1, actualFindByCategoryResult.size());
    assertTrue(actualFindByCategoryResult.get(0) instanceof ProductImpl);
  }

  /**
   * Test {@link RelatedProductsVariableExpression#findByCategory(Long, Integer)} with {@code
   * categoryId}, {@code quantity}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsVariableExpression#findByCategory(Long, Integer)}
   */
  @Test
  @DisplayName(
      "Test findByCategory(Long, Integer) with 'categoryId', 'quantity'; when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsVariableExpression.findByCategory(Long, Integer)"})
  void testFindByCategoryWithCategoryIdQuantity_whenNull_thenReturnEmpty() {
    // Arrange
    Mockito.<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Product> actualFindByCategoryResult =
        relatedProductsVariableExpression.findByCategory(1L, null);

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertTrue(actualFindByCategoryResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsVariableExpression#findByCategory(Long, Integer)} with {@code
   * categoryId}, {@code quantity}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsVariableExpression#findByCategory(Long, Integer)}
   */
  @Test
  @DisplayName(
      "Test findByCategory(Long, Integer) with 'categoryId', 'quantity'; when one; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsVariableExpression.findByCategory(Long, Integer)"})
  void testFindByCategoryWithCategoryIdQuantity_whenOne_thenReturnEmpty() {
    // Arrange
    Mockito.<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Product> actualFindByCategoryResult =
        relatedProductsVariableExpression.findByCategory(1L, 1);

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertTrue(actualFindByCategoryResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsVariableExpression#getRelatedProducts(Long, Long, Integer, String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CrossSaleProductImpl} (default
   *       constructor).
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsVariableExpression#getRelatedProducts(Long, Long,
   * Integer, String)}
   */
  @Test
  @DisplayName(
      "Test getRelatedProducts(Long, Long, Integer, String); given ArrayList() add CrossSaleProductImpl (default constructor); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RelatedProductsVariableExpression.getRelatedProducts(Long, Long, Integer, String)"
  })
  void testGetRelatedProducts_givenArrayListAddCrossSaleProductImpl_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<PromotableProduct> promotableProductList = new ArrayList<>();
    promotableProductList.add(new CrossSaleProductImpl());
    Mockito.<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(promotableProductList);

    // Act
    List<Product> actualRelatedProducts =
        relatedProductsVariableExpression.getRelatedProducts(1L, 1L, 1, "Type");

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertEquals(1, actualRelatedProducts.size());
    assertTrue(actualRelatedProducts.get(0) instanceof ProductImpl);
  }

  /**
   * Test {@link RelatedProductsVariableExpression#getRelatedProducts(Long, Long, Integer, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsVariableExpression#getRelatedProducts(Long, Long,
   * Integer, String)}
   */
  @Test
  @DisplayName(
      "Test getRelatedProducts(Long, Long, Integer, String); when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RelatedProductsVariableExpression.getRelatedProducts(Long, Long, Integer, String)"
  })
  void testGetRelatedProducts_whenNull_thenReturnEmpty() {
    // Arrange
    Mockito.<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Product> actualRelatedProducts =
        relatedProductsVariableExpression.getRelatedProducts(1L, 1L, null, "Type");

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertTrue(actualRelatedProducts.isEmpty());
  }

  /**
   * Test {@link RelatedProductsVariableExpression#getRelatedProducts(Long, Long, Integer, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsVariableExpression#getRelatedProducts(Long, Long,
   * Integer, String)}
   */
  @Test
  @DisplayName(
      "Test getRelatedProducts(Long, Long, Integer, String); when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RelatedProductsVariableExpression.getRelatedProducts(Long, Long, Integer, String)"
  })
  void testGetRelatedProducts_whenNull_thenReturnEmpty2() {
    // Arrange
    Mockito.<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Product> actualRelatedProducts =
        relatedProductsVariableExpression.getRelatedProducts(1L, 1L, 1, null);

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertTrue(actualRelatedProducts.isEmpty());
  }

  /**
   * Test {@link RelatedProductsVariableExpression#getRelatedProducts(Long, Long, Integer, String)}.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsVariableExpression#getRelatedProducts(Long, Long,
   * Integer, String)}
   */
  @Test
  @DisplayName(
      "Test getRelatedProducts(Long, Long, Integer, String); when 'Type'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RelatedProductsVariableExpression.getRelatedProducts(Long, Long, Integer, String)"
  })
  void testGetRelatedProducts_whenType_thenReturnEmpty() {
    // Arrange
    Mockito.<List<? extends PromotableProduct>>when(
            relatedProductsService.findRelatedProducts(Mockito.<RelatedProductDTO>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Product> actualRelatedProducts =
        relatedProductsVariableExpression.getRelatedProducts(1L, 1L, 1, "Type");

    // Assert
    verify(relatedProductsService).findRelatedProducts(isA(RelatedProductDTO.class));
    assertTrue(actualRelatedProducts.isEmpty());
  }

  /**
   * Test {@link RelatedProductsVariableExpression#buildProductList(List)}.
   *
   * <ul>
   *   <li>Given {@link CrossSaleProductImpl} (default constructor).
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsVariableExpression#buildProductList(List)}
   */
  @Test
  @DisplayName(
      "Test buildProductList(List); given CrossSaleProductImpl (default constructor); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsVariableExpression.buildProductList(List)"})
  void testBuildProductList_givenCrossSaleProductImpl_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<PromotableProduct> relatedProducts = new ArrayList<>();
    relatedProducts.add(new CrossSaleProductImpl());
    relatedProducts.add(new CrossSaleProductImpl());

    // Act
    List<Product> actualBuildProductListResult =
        relatedProductsVariableExpression.buildProductList(relatedProducts);

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
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsVariableExpression#buildProductList(List)}
   */
  @Test
  @DisplayName("Test buildProductList(List); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsVariableExpression.buildProductList(List)"})
  void testBuildProductList_whenArrayList_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(relatedProductsVariableExpression.buildProductList(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link RelatedProductsVariableExpression#buildProductList(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsVariableExpression#buildProductList(List)}
   */
  @Test
  @DisplayName("Test buildProductList(List); when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsVariableExpression.buildProductList(List)"})
  void testBuildProductList_whenNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(relatedProductsVariableExpression.buildProductList(null).isEmpty());
  }
}

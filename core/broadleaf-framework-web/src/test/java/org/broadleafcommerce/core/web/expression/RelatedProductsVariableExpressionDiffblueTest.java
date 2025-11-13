package org.broadleafcommerce.core.web.expression;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
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
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {RelatedProductsVariableExpression.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class RelatedProductsVariableExpressionDiffblueTest {
  @MockBean private RelatedProductsService relatedProductsService;

  @Autowired private RelatedProductsVariableExpression relatedProductsVariableExpression;

  /**
   * Test {@link RelatedProductsVariableExpression#getName()}.
   *
   * <p>Method under test: {@link RelatedProductsVariableExpression#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String RelatedProductsVariableExpression.getName()"})
  public void testGetName() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsVariableExpression.findByProduct(Long, Integer, String)"})
  public void testFindByProductWithProductIdQuantityType_thenReturnSizeIsOne() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsVariableExpression.findByProduct(Long, Integer, String)"})
  public void testFindByProductWithProductIdQuantityType_whenNull_thenReturnEmpty() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsVariableExpression.findByProduct(Long, Integer, String)"})
  public void testFindByProductWithProductIdQuantityType_whenNull_thenReturnEmpty2() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsVariableExpression.findByProduct(Long, Integer, String)"})
  public void testFindByProductWithProductIdQuantityType_whenType_thenReturnEmpty() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsVariableExpression.findByProduct(Long, Integer)"})
  public void testFindByProductWithProductIdQuantity_thenReturnSizeIsOne() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsVariableExpression.findByProduct(Long, Integer)"})
  public void testFindByProductWithProductIdQuantity_whenNull_thenReturnEmpty() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsVariableExpression.findByProduct(Long, Integer)"})
  public void testFindByProductWithProductIdQuantity_whenOne_thenReturnEmpty() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsVariableExpression.findByProduct(Long)"})
  public void testFindByProductWithProductId_thenReturnEmpty() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsVariableExpression.findByProduct(Long)"})
  public void testFindByProductWithProductId_thenReturnSizeIsOne() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RelatedProductsVariableExpression.findByCategory(Long, Integer, String)"
  })
  public void testFindByCategoryWithCategoryIdQuantityType_thenReturnSizeIsOne() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RelatedProductsVariableExpression.findByCategory(Long, Integer, String)"
  })
  public void testFindByCategoryWithCategoryIdQuantityType_whenNull_thenReturnEmpty() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RelatedProductsVariableExpression.findByCategory(Long, Integer, String)"
  })
  public void testFindByCategoryWithCategoryIdQuantityType_whenNull_thenReturnEmpty2() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RelatedProductsVariableExpression.findByCategory(Long, Integer, String)"
  })
  public void testFindByCategoryWithCategoryIdQuantityType_whenType_thenReturnEmpty() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsVariableExpression.findByCategory(Long, Integer)"})
  public void testFindByCategoryWithCategoryIdQuantity_thenReturnSizeIsOne() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsVariableExpression.findByCategory(Long, Integer)"})
  public void testFindByCategoryWithCategoryIdQuantity_whenNull_thenReturnEmpty() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsVariableExpression.findByCategory(Long, Integer)"})
  public void testFindByCategoryWithCategoryIdQuantity_whenOne_thenReturnEmpty() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RelatedProductsVariableExpression.getRelatedProducts(Long, Long, Integer, String)"
  })
  public void testGetRelatedProducts_givenArrayListAddCrossSaleProductImpl_thenReturnSizeIsOne() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RelatedProductsVariableExpression.getRelatedProducts(Long, Long, Integer, String)"
  })
  public void testGetRelatedProducts_whenNull_thenReturnEmpty() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RelatedProductsVariableExpression.getRelatedProducts(Long, Long, Integer, String)"
  })
  public void testGetRelatedProducts_whenNull_thenReturnEmpty2() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RelatedProductsVariableExpression.getRelatedProducts(Long, Long, Integer, String)"
  })
  public void testGetRelatedProducts_whenType_thenReturnEmpty() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsVariableExpression.buildProductList(List)"})
  public void testBuildProductList_givenCrossSaleProductImpl_thenReturnSizeIsTwo() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsVariableExpression.buildProductList(List)"})
  public void testBuildProductList_whenArrayList_thenReturnEmpty() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsVariableExpression.buildProductList(List)"})
  public void testBuildProductList_whenNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(relatedProductsVariableExpression.buildProductList(null).isEmpty());
  }
}

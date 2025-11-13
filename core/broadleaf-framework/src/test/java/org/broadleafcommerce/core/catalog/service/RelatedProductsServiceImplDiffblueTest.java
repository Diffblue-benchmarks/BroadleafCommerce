package org.broadleafcommerce.core.catalog.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.catalog.dao.CategoryDao;
import org.broadleafcommerce.core.catalog.dao.ProductDao;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.CrossSaleProductImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.PromotableProduct;
import org.broadleafcommerce.core.catalog.domain.RelatedProduct;
import org.broadleafcommerce.core.catalog.domain.RelatedProductDTO;
import org.broadleafcommerce.core.catalog.domain.RelatedProductTypeEnum;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RelatedProductsServiceImplDiffblueTest {
  @Mock private CategoryDao categoryDao;

  @Mock private ProductDao productDao;

  @InjectMocks private RelatedProductsServiceImpl relatedProductsServiceImpl;

  /**
   * Test {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsServiceImpl.findRelatedProducts(RelatedProductDTO)"})
  public void testFindRelatedProducts() {
    // Arrange
    when(productDao.readProductById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException());

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> relatedProductsServiceImpl.findRelatedProducts(relatedProductDTO));
    verify(productDao).readProductById(1L);
  }

  /**
   * Test {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsServiceImpl.findRelatedProducts(RelatedProductDTO)"})
  public void testFindRelatedProducts2() {
    // Arrange
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());

    Product product = mock(Product.class);
    when(product.getDefaultCategory()).thenThrow(new IllegalArgumentException());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(product);

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.FEATURED);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> relatedProductsServiceImpl.findRelatedProducts(relatedProductDTO));
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    verify(product).getDefaultCategory();
  }

  /**
   * Test {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link RelatedProductDTO} (default constructor) ProductId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsServiceImpl.findRelatedProducts(RelatedProductDTO)"})
  public void testFindRelatedProducts_givenNull_whenRelatedProductDTOProductIdIsNull() {
    // Arrange
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setProductId(null);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualFindRelatedProductsResult =
        relatedProductsServiceImpl.findRelatedProducts(relatedProductDTO);

    // Assert
    verify(categoryDao).readCategoryById(1L);
    assertTrue(actualFindRelatedProductsResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link RelatedProductDTO} (default constructor) ProductId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsServiceImpl.findRelatedProducts(RelatedProductDTO)"})
  public void testFindRelatedProducts_givenNull_whenRelatedProductDTOProductIdIsNull2() {
    // Arrange
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setProductId(null);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.UP_SALE);

    // Act
    List<? extends PromotableProduct> actualFindRelatedProductsResult =
        relatedProductsServiceImpl.findRelatedProducts(relatedProductDTO);

    // Assert
    verify(categoryDao).readCategoryById(1L);
    assertTrue(actualFindRelatedProductsResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor) Id is one.
   *   <li>Then calls {@link RelatedProduct#getRelatedProduct()}.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsServiceImpl.findRelatedProducts(RelatedProductDTO)"})
  public void testFindRelatedProducts_givenProductBundleImplIdIsOne_thenCallsGetRelatedProduct() {
    // Arrange
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setId(1L);

    RelatedProduct relatedProduct = mock(RelatedProduct.class);
    when(relatedProduct.getRelatedProduct()).thenReturn(productBundleImpl);

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(relatedProduct);

    Product product = mock(Product.class);
    when(product.getId()).thenReturn(1L);
    when(product.getUpSaleProducts()).thenReturn(relatedProductList);
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(product);

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.UP_SALE);

    // Act
    List<? extends PromotableProduct> actualFindRelatedProductsResult =
        relatedProductsServiceImpl.findRelatedProducts(relatedProductDTO);

    // Assert
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    verify(product).getId();
    verify(product).getUpSaleProducts();
    verify(relatedProduct).getRelatedProduct();
    assertTrue(actualFindRelatedProductsResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Given {@link ProductDao} {@link ProductDao#readProductById(Long)} return {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsServiceImpl.findRelatedProducts(RelatedProductDTO)"})
  public void testFindRelatedProducts_givenProductDaoReadProductByIdReturnNull_thenReturnEmpty() {
    // Arrange
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(null);

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualFindRelatedProductsResult =
        relatedProductsServiceImpl.findRelatedProducts(relatedProductDTO);

    // Assert
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    assertTrue(actualFindRelatedProductsResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Given {@link ProductDao} {@link ProductDao#readProductById(Long)} return {@link
   *       ProductBundleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsServiceImpl.findRelatedProducts(RelatedProductDTO)"})
  public void testFindRelatedProducts_givenProductDaoReadProductByIdReturnProductBundleImpl() {
    // Arrange
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualFindRelatedProductsResult =
        relatedProductsServiceImpl.findRelatedProducts(relatedProductDTO);

    // Assert
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    assertTrue(actualFindRelatedProductsResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Given {@link ProductDao} {@link ProductDao#readProductById(Long)} return {@link
   *       ProductBundleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsServiceImpl.findRelatedProducts(RelatedProductDTO)"})
  public void testFindRelatedProducts_givenProductDaoReadProductByIdReturnProductBundleImpl2() {
    // Arrange
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualFindRelatedProductsResult =
        relatedProductsServiceImpl.findRelatedProducts(relatedProductDTO);

    // Assert
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    assertTrue(actualFindRelatedProductsResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Given {@link ProductDao} {@link ProductDao#readProductById(Long)} return {@link
   *       ProductBundleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsServiceImpl.findRelatedProducts(RelatedProductDTO)"})
  public void testFindRelatedProducts_givenProductDaoReadProductByIdReturnProductBundleImpl3() {
    // Arrange
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.UP_SALE);

    // Act
    List<? extends PromotableProduct> actualFindRelatedProductsResult =
        relatedProductsServiceImpl.findRelatedProducts(relatedProductDTO);

    // Assert
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    assertTrue(actualFindRelatedProductsResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Given {@link Product} {@link Product#getId()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsServiceImpl.findRelatedProducts(RelatedProductDTO)"})
  public void testFindRelatedProducts_givenProductGetIdThrowIllegalArgumentException() {
    // Arrange
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(new CrossSaleProductImpl());

    Product product = mock(Product.class);
    when(product.getId()).thenThrow(new IllegalArgumentException());
    when(product.getUpSaleProducts()).thenReturn(relatedProductList);
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(product);

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.UP_SALE);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> relatedProductsServiceImpl.findRelatedProducts(relatedProductDTO));
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    verify(product).getId();
    verify(product).getUpSaleProducts();
  }

  /**
   * Test {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Given {@link RelatedProductTypeEnum#RelatedProductTypeEnum()}.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsServiceImpl.findRelatedProducts(RelatedProductDTO)"})
  public void testFindRelatedProducts_givenRelatedProductTypeEnum() {
    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(null);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(null);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(new RelatedProductTypeEnum());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> relatedProductsServiceImpl.findRelatedProducts(relatedProductDTO));
  }

  /**
   * Test {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Given {@link RelatedProductsServiceImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsServiceImpl.findRelatedProducts(RelatedProductDTO)"})
  public void testFindRelatedProducts_givenRelatedProductsServiceImpl_thenReturnNull() {
    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(null);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(null);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act and Assert
    assertNull(relatedProductsServiceImpl.findRelatedProducts(relatedProductDTO));
  }

  /**
   * Test {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Given {@link RelatedProductsServiceImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsServiceImpl.findRelatedProducts(RelatedProductDTO)"})
  public void testFindRelatedProducts_givenRelatedProductsServiceImpl_thenReturnNull2() {
    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(null);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(null);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.FEATURED);

    // Act and Assert
    assertNull(relatedProductsServiceImpl.findRelatedProducts(relatedProductDTO));
  }

  /**
   * Test {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Given {@link RelatedProductsServiceImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsServiceImpl.findRelatedProducts(RelatedProductDTO)"})
  public void testFindRelatedProducts_givenRelatedProductsServiceImpl_thenReturnNull3() {
    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(null);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(null);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.UP_SALE);

    // Act and Assert
    assertNull(relatedProductsServiceImpl.findRelatedProducts(relatedProductDTO));
  }

  /**
   * Test {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Then calls {@link Product#getCrossSaleProducts()}.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsServiceImpl.findRelatedProducts(RelatedProductDTO)"})
  public void testFindRelatedProducts_thenCallsGetCrossSaleProducts() {
    // Arrange
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());

    Product product = mock(Product.class);
    when(product.getCrossSaleProducts()).thenThrow(new IllegalArgumentException());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(product);

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> relatedProductsServiceImpl.findRelatedProducts(relatedProductDTO));
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    verify(product).getCrossSaleProducts();
  }

  /**
   * Test {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Then calls {@link Product#getCumulativeCrossSaleProducts()}.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsServiceImpl.findRelatedProducts(RelatedProductDTO)"})
  public void testFindRelatedProducts_thenCallsGetCumulativeCrossSaleProducts() {
    // Arrange
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());

    Product product = mock(Product.class);
    when(product.getCumulativeCrossSaleProducts()).thenThrow(new IllegalArgumentException());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(product);

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> relatedProductsServiceImpl.findRelatedProducts(relatedProductDTO));
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    verify(product).getCumulativeCrossSaleProducts();
  }

  /**
   * Test {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Then calls {@link Product#getDefaultCategory()}.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsServiceImpl.findRelatedProducts(RelatedProductDTO)"})
  public void testFindRelatedProducts_thenCallsGetDefaultCategory() {
    // Arrange
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());

    Product product = mock(Product.class);
    when(product.getDefaultCategory()).thenReturn(new CategoryImpl());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(product);

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.FEATURED);

    // Act
    List<? extends PromotableProduct> actualFindRelatedProductsResult =
        relatedProductsServiceImpl.findRelatedProducts(relatedProductDTO);

    // Assert
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    verify(product).getDefaultCategory();
    assertTrue(actualFindRelatedProductsResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Then calls {@link Product#getDefaultCategory()}.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsServiceImpl.findRelatedProducts(RelatedProductDTO)"})
  public void testFindRelatedProducts_thenCallsGetDefaultCategory2() {
    // Arrange
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());

    Product product = mock(Product.class);
    when(product.getDefaultCategory()).thenReturn(new CategoryImpl());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(product);

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.FEATURED);

    // Act
    List<? extends PromotableProduct> actualFindRelatedProductsResult =
        relatedProductsServiceImpl.findRelatedProducts(relatedProductDTO);

    // Assert
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    verify(product).getDefaultCategory();
    assertTrue(actualFindRelatedProductsResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Then calls {@link Product#getUpSaleProducts()}.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsServiceImpl.findRelatedProducts(RelatedProductDTO)"})
  public void testFindRelatedProducts_thenCallsGetUpSaleProducts() {
    // Arrange
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());

    Product product = mock(Product.class);
    when(product.getUpSaleProducts()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(product);

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.UP_SALE);

    // Act
    List<? extends PromotableProduct> actualFindRelatedProductsResult =
        relatedProductsServiceImpl.findRelatedProducts(relatedProductDTO);

    // Assert
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    verify(product).getUpSaleProducts();
    assertTrue(actualFindRelatedProductsResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsServiceImpl.findRelatedProducts(RelatedProductDTO)"})
  public void testFindRelatedProducts_thenReturnArrayList() {
    // Arrange
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(new CrossSaleProductImpl());

    Product product = mock(Product.class);
    when(product.getId()).thenReturn(1L);
    when(product.getUpSaleProducts()).thenReturn(relatedProductList);
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(product);

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.UP_SALE);

    // Act
    List<? extends PromotableProduct> actualFindRelatedProductsResult =
        relatedProductsServiceImpl.findRelatedProducts(relatedProductDTO);

    // Assert
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    verify(product).getId();
    verify(product).getUpSaleProducts();
    assertSame(relatedProductList, actualFindRelatedProductsResult);
  }

  /**
   * Test {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsServiceImpl.findRelatedProducts(RelatedProductDTO)"})
  public void testFindRelatedProducts_thenReturnArrayList2() {
    // Arrange
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(new CrossSaleProductImpl());
    relatedProductList.add(new CrossSaleProductImpl());

    Product product = mock(Product.class);
    when(product.getId()).thenReturn(1L);
    when(product.getUpSaleProducts()).thenReturn(relatedProductList);
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(product);

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.UP_SALE);

    // Act
    List<? extends PromotableProduct> actualFindRelatedProductsResult =
        relatedProductsServiceImpl.findRelatedProducts(relatedProductDTO);

    // Assert
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    verify(product, atLeast(1)).getId();
    verify(product).getUpSaleProducts();
    assertSame(relatedProductList, actualFindRelatedProductsResult);
  }

  /**
   * Test {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsServiceImpl.findRelatedProducts(RelatedProductDTO)"})
  public void testFindRelatedProducts_thenReturnNull() {
    // Arrange
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.FEATURED);

    // Act
    List<? extends PromotableProduct> actualFindRelatedProductsResult =
        relatedProductsServiceImpl.findRelatedProducts(relatedProductDTO);

    // Assert
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    assertNull(actualFindRelatedProductsResult);
  }

  /**
   * Test {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsServiceImpl.findRelatedProducts(RelatedProductDTO)"})
  public void testFindRelatedProducts_thenReturnSizeIsOne() {
    // Arrange
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());

    RelatedProduct relatedProduct = mock(RelatedProduct.class);
    when(relatedProduct.getRelatedProduct()).thenReturn(new ProductBundleImpl());

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    CrossSaleProductImpl crossSaleProductImpl = new CrossSaleProductImpl();
    relatedProductList.add(crossSaleProductImpl);
    relatedProductList.add(relatedProduct);

    Product product = mock(Product.class);
    when(product.getId()).thenReturn(1L);
    when(product.getUpSaleProducts()).thenReturn(relatedProductList);
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(product);

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.UP_SALE);

    // Act
    List<? extends PromotableProduct> actualFindRelatedProductsResult =
        relatedProductsServiceImpl.findRelatedProducts(relatedProductDTO);

    // Assert
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
    verify(product, atLeast(1)).getId();
    verify(product).getUpSaleProducts();
    verify(relatedProduct, atLeast(1)).getRelatedProduct();
    assertEquals(1, actualFindRelatedProductsResult.size());
    assertSame(crossSaleProductImpl, actualFindRelatedProductsResult.get(0));
  }

  /**
   * Test {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   *
   * <ul>
   *   <li>When {@link RelatedProductDTO} (default constructor) Quantity is {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsServiceImpl.findRelatedProducts(RelatedProductDTO)"})
  public void testFindRelatedProducts_whenRelatedProductDTOQuantityIsNull_thenReturnNull() {
    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(null);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(null);
    relatedProductDTO.setQuantity(null);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act and Assert
    assertNull(relatedProductsServiceImpl.findRelatedProducts(relatedProductDTO));
  }

  /**
   * Test {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   *
   * <ul>
   *   <li>When {@link RelatedProductDTO} (default constructor) Type is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsServiceImpl.findRelatedProducts(RelatedProductDTO)"})
  public void testFindRelatedProducts_whenRelatedProductDTOTypeIsNull() {
    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(null);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(null);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> relatedProductsServiceImpl.findRelatedProducts(relatedProductDTO));
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product,
   * org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RelatedProductsServiceImpl.buildFeaturedProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"
  })
  public void testBuildFeaturedProductsList_givenCategoryImpl() {
    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultCategory()).thenReturn(new CategoryImpl());
    CategoryImpl category = new CategoryImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualBuildFeaturedProductsListResult =
        relatedProductsServiceImpl.buildFeaturedProductsList(product, category, relatedProductDTO);

    // Assert
    verify(product).getDefaultCategory();
    assertTrue(actualBuildFeaturedProductsListResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product,
   * org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RelatedProductsServiceImpl.buildFeaturedProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"
  })
  public void testBuildFeaturedProductsList_givenFalse_whenNull_thenReturnEmpty() {
    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();
    CategoryImpl category = new CategoryImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setQuantity(1);

    // Act and Assert
    assertTrue(
        relatedProductsServiceImpl
            .buildFeaturedProductsList(null, category, relatedProductDTO)
            .isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link RelatedProductDTO} (default constructor) Quantity is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product,
   * org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RelatedProductsServiceImpl.buildFeaturedProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"
  })
  public void testBuildFeaturedProductsList_givenNull_whenRelatedProductDTOQuantityIsNull() {
    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();
    ProductBundleImpl product = new ProductBundleImpl();
    CategoryImpl category = new CategoryImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setQuantity(null);

    // Act and Assert
    assertNull(
        relatedProductsServiceImpl.buildFeaturedProductsList(product, category, relatedProductDTO));
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product,
   * org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RelatedProductsServiceImpl.buildFeaturedProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"
  })
  public void testBuildFeaturedProductsList_givenTrue_whenNull_thenReturnEmpty() {
    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();
    CategoryImpl category = new CategoryImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act and Assert
    assertTrue(
        relatedProductsServiceImpl
            .buildFeaturedProductsList(null, category, relatedProductDTO)
            .isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link ProductBundleImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product,
   * org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RelatedProductsServiceImpl.buildFeaturedProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"
  })
  public void testBuildFeaturedProductsList_givenTrue_whenProductBundleImpl_thenReturnNull() {
    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();
    ProductBundleImpl product = new ProductBundleImpl();
    CategoryImpl category = new CategoryImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act and Assert
    assertNull(
        relatedProductsServiceImpl.buildFeaturedProductsList(product, category, relatedProductDTO));
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Then calls {@link CategoryImpl#getCumulativeFeaturedProducts()}.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product,
   * org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RelatedProductsServiceImpl.buildFeaturedProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"
  })
  public void testBuildFeaturedProductsList_thenCallsGetCumulativeFeaturedProducts() {
    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getCumulativeFeaturedProducts()).thenThrow(new IllegalArgumentException());

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultCategory()).thenReturn(categoryImpl);
    CategoryImpl category = new CategoryImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            relatedProductsServiceImpl.buildFeaturedProductsList(
                product, category, relatedProductDTO));
    verify(categoryImpl).getCumulativeFeaturedProducts();
    verify(product).getDefaultCategory();
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Then calls {@link CategoryImpl#getFeaturedProducts()}.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product,
   * org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RelatedProductsServiceImpl.buildFeaturedProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"
  })
  public void testBuildFeaturedProductsList_thenCallsGetFeaturedProducts() {
    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getFeaturedProducts()).thenThrow(new IllegalArgumentException());

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultCategory()).thenReturn(categoryImpl);
    CategoryImpl category = new CategoryImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            relatedProductsServiceImpl.buildFeaturedProductsList(
                product, category, relatedProductDTO));
    verify(categoryImpl).getFeaturedProducts();
    verify(product).getDefaultCategory();
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product,
   * org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RelatedProductsServiceImpl.buildUpSaleProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"
  })
  public void testBuildUpSaleProductsList_givenArrayList_thenReturnEmpty() {
    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getUpSaleProducts()).thenReturn(new ArrayList<>());
    CategoryImpl category = new CategoryImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualBuildUpSaleProductsListResult =
        relatedProductsServiceImpl.buildUpSaleProductsList(product, category, relatedProductDTO);

    // Assert
    verify(product).getUpSaleProducts();
    assertTrue(actualBuildUpSaleProductsListResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link RelatedProductDTO} (default constructor) Quantity is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product,
   * org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RelatedProductsServiceImpl.buildUpSaleProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"
  })
  public void testBuildUpSaleProductsList_givenNull_whenRelatedProductDTOQuantityIsNull() {
    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

    RelatedProduct relatedProduct = mock(RelatedProduct.class);
    when(relatedProduct.getRelatedProduct()).thenReturn(new ProductBundleImpl());

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(new CrossSaleProductImpl());
    relatedProductList.add(relatedProduct);

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getUpSaleProducts()).thenReturn(relatedProductList);
    CategoryImpl category = new CategoryImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(null);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualBuildUpSaleProductsListResult =
        relatedProductsServiceImpl.buildUpSaleProductsList(product, category, relatedProductDTO);

    // Assert
    verify(product, atLeast(1)).getId();
    verify(product).getUpSaleProducts();
    verify(relatedProduct, atLeast(1)).getRelatedProduct();
    assertSame(relatedProductList, actualBuildUpSaleProductsListResult);
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor) Id is one.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product,
   * org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RelatedProductsServiceImpl.buildUpSaleProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"
  })
  public void testBuildUpSaleProductsList_givenProductBundleImplIdIsOne() {
    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setId(1L);

    RelatedProduct relatedProduct = mock(RelatedProduct.class);
    when(relatedProduct.getRelatedProduct()).thenReturn(productBundleImpl);

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(relatedProduct);

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getUpSaleProducts()).thenReturn(relatedProductList);
    CategoryImpl category = new CategoryImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualBuildUpSaleProductsListResult =
        relatedProductsServiceImpl.buildUpSaleProductsList(product, category, relatedProductDTO);

    // Assert
    verify(product).getId();
    verify(product).getUpSaleProducts();
    verify(relatedProduct).getRelatedProduct();
    assertTrue(actualBuildUpSaleProductsListResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product,
   * org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RelatedProductsServiceImpl.buildUpSaleProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"
  })
  public void testBuildUpSaleProductsList_givenTrue_whenNull_thenReturnEmpty() {
    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();
    CategoryImpl category = new CategoryImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act and Assert
    assertTrue(
        relatedProductsServiceImpl
            .buildUpSaleProductsList(null, category, relatedProductDTO)
            .isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link ProductBundleImpl} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product,
   * org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RelatedProductsServiceImpl.buildUpSaleProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"
  })
  public void testBuildUpSaleProductsList_givenTrue_whenProductBundleImpl_thenReturnEmpty() {
    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();
    ProductBundleImpl product = new ProductBundleImpl();
    CategoryImpl category = new CategoryImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act and Assert
    assertTrue(
        relatedProductsServiceImpl
            .buildUpSaleProductsList(product, category, relatedProductDTO)
            .isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product,
   * org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RelatedProductsServiceImpl.buildUpSaleProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"
  })
  public void testBuildUpSaleProductsList_thenReturnArrayList() {
    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(new CrossSaleProductImpl());

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getUpSaleProducts()).thenReturn(relatedProductList);
    CategoryImpl category = new CategoryImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualBuildUpSaleProductsListResult =
        relatedProductsServiceImpl.buildUpSaleProductsList(product, category, relatedProductDTO);

    // Assert
    verify(product).getId();
    verify(product).getUpSaleProducts();
    assertSame(relatedProductList, actualBuildUpSaleProductsListResult);
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product,
   * org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RelatedProductsServiceImpl.buildUpSaleProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"
  })
  public void testBuildUpSaleProductsList_thenReturnArrayList2() {
    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(new CrossSaleProductImpl());
    relatedProductList.add(new CrossSaleProductImpl());

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getUpSaleProducts()).thenReturn(relatedProductList);
    CategoryImpl category = new CategoryImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualBuildUpSaleProductsListResult =
        relatedProductsServiceImpl.buildUpSaleProductsList(product, category, relatedProductDTO);

    // Assert
    verify(product, atLeast(1)).getId();
    verify(product).getUpSaleProducts();
    assertSame(relatedProductList, actualBuildUpSaleProductsListResult);
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product,
   * org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RelatedProductsServiceImpl.buildUpSaleProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"
  })
  public void testBuildUpSaleProductsList_thenReturnSizeIsOne() {
    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

    RelatedProduct relatedProduct = mock(RelatedProduct.class);
    when(relatedProduct.getRelatedProduct()).thenReturn(new ProductBundleImpl());

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    CrossSaleProductImpl crossSaleProductImpl = new CrossSaleProductImpl();
    relatedProductList.add(crossSaleProductImpl);
    relatedProductList.add(relatedProduct);

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getUpSaleProducts()).thenReturn(relatedProductList);
    CategoryImpl category = new CategoryImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualBuildUpSaleProductsListResult =
        relatedProductsServiceImpl.buildUpSaleProductsList(product, category, relatedProductDTO);

    // Assert
    verify(product, atLeast(1)).getId();
    verify(product).getUpSaleProducts();
    verify(relatedProduct, atLeast(1)).getRelatedProduct();
    assertEquals(1, actualBuildUpSaleProductsListResult.size());
    assertSame(crossSaleProductImpl, actualBuildUpSaleProductsListResult.get(0));
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product,
   * org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RelatedProductsServiceImpl.buildCrossSaleProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"
  })
  public void testBuildCrossSaleProductsList_givenArrayList_thenReturnEmpty() {
    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getCrossSaleProducts()).thenReturn(new ArrayList<>());
    CategoryImpl category = new CategoryImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualBuildCrossSaleProductsListResult =
        relatedProductsServiceImpl.buildCrossSaleProductsList(product, category, relatedProductDTO);

    // Assert
    verify(product).getCrossSaleProducts();
    assertTrue(actualBuildCrossSaleProductsListResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link RelatedProductDTO} (default constructor) Quantity is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product,
   * org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RelatedProductsServiceImpl.buildCrossSaleProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"
  })
  public void testBuildCrossSaleProductsList_givenNull_whenRelatedProductDTOQuantityIsNull() {
    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

    RelatedProduct relatedProduct = mock(RelatedProduct.class);
    when(relatedProduct.getRelatedProduct()).thenReturn(new ProductBundleImpl());

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(new CrossSaleProductImpl());
    relatedProductList.add(relatedProduct);

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getCrossSaleProducts()).thenReturn(relatedProductList);
    CategoryImpl category = new CategoryImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(null);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualBuildCrossSaleProductsListResult =
        relatedProductsServiceImpl.buildCrossSaleProductsList(product, category, relatedProductDTO);

    // Assert
    verify(product).getCrossSaleProducts();
    verify(product, atLeast(1)).getId();
    verify(relatedProduct, atLeast(1)).getRelatedProduct();
    assertSame(relatedProductList, actualBuildCrossSaleProductsListResult);
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor) Id is one.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product,
   * org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RelatedProductsServiceImpl.buildCrossSaleProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"
  })
  public void testBuildCrossSaleProductsList_givenProductBundleImplIdIsOne() {
    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setId(1L);

    RelatedProduct relatedProduct = mock(RelatedProduct.class);
    when(relatedProduct.getRelatedProduct()).thenReturn(productBundleImpl);

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(relatedProduct);

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getCrossSaleProducts()).thenReturn(relatedProductList);
    CategoryImpl category = new CategoryImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualBuildCrossSaleProductsListResult =
        relatedProductsServiceImpl.buildCrossSaleProductsList(product, category, relatedProductDTO);

    // Assert
    verify(product).getCrossSaleProducts();
    verify(product).getId();
    verify(relatedProduct).getRelatedProduct();
    assertTrue(actualBuildCrossSaleProductsListResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product,
   * org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RelatedProductsServiceImpl.buildCrossSaleProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"
  })
  public void testBuildCrossSaleProductsList_givenTrue_whenNull_thenReturnEmpty() {
    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();
    CategoryImpl category = new CategoryImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act and Assert
    assertTrue(
        relatedProductsServiceImpl
            .buildCrossSaleProductsList(null, category, relatedProductDTO)
            .isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link ProductBundleImpl} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product,
   * org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RelatedProductsServiceImpl.buildCrossSaleProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"
  })
  public void testBuildCrossSaleProductsList_givenTrue_whenProductBundleImpl_thenReturnEmpty() {
    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();
    ProductBundleImpl product = new ProductBundleImpl();
    CategoryImpl category = new CategoryImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act and Assert
    assertTrue(
        relatedProductsServiceImpl
            .buildCrossSaleProductsList(product, category, relatedProductDTO)
            .isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product,
   * org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RelatedProductsServiceImpl.buildCrossSaleProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"
  })
  public void testBuildCrossSaleProductsList_thenReturnArrayList() {
    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(new CrossSaleProductImpl());

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getCrossSaleProducts()).thenReturn(relatedProductList);
    CategoryImpl category = new CategoryImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualBuildCrossSaleProductsListResult =
        relatedProductsServiceImpl.buildCrossSaleProductsList(product, category, relatedProductDTO);

    // Assert
    verify(product).getCrossSaleProducts();
    verify(product).getId();
    assertSame(relatedProductList, actualBuildCrossSaleProductsListResult);
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product,
   * org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RelatedProductsServiceImpl.buildCrossSaleProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"
  })
  public void testBuildCrossSaleProductsList_thenReturnArrayList2() {
    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(new CrossSaleProductImpl());
    relatedProductList.add(new CrossSaleProductImpl());

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getCrossSaleProducts()).thenReturn(relatedProductList);
    CategoryImpl category = new CategoryImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualBuildCrossSaleProductsListResult =
        relatedProductsServiceImpl.buildCrossSaleProductsList(product, category, relatedProductDTO);

    // Assert
    verify(product).getCrossSaleProducts();
    verify(product, atLeast(1)).getId();
    assertSame(relatedProductList, actualBuildCrossSaleProductsListResult);
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product,
   * org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RelatedProductsServiceImpl.buildCrossSaleProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"
  })
  public void testBuildCrossSaleProductsList_thenReturnSizeIsOne() {
    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

    RelatedProduct relatedProduct = mock(RelatedProduct.class);
    when(relatedProduct.getRelatedProduct()).thenReturn(new ProductBundleImpl());

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    CrossSaleProductImpl crossSaleProductImpl = new CrossSaleProductImpl();
    relatedProductList.add(crossSaleProductImpl);
    relatedProductList.add(relatedProduct);

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getCrossSaleProducts()).thenReturn(relatedProductList);
    CategoryImpl category = new CategoryImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualBuildCrossSaleProductsListResult =
        relatedProductsServiceImpl.buildCrossSaleProductsList(product, category, relatedProductDTO);

    // Assert
    verify(product).getCrossSaleProducts();
    verify(product, atLeast(1)).getId();
    verify(relatedProduct, atLeast(1)).getRelatedProduct();
    assertEquals(1, actualBuildCrossSaleProductsListResult.size());
    assertSame(crossSaleProductImpl, actualBuildCrossSaleProductsListResult.get(0));
  }

  /**
   * Test {@link RelatedProductsServiceImpl#resizeList(List, Integer)}.
   *
   * <ul>
   *   <li>Given {@link CrossSaleProductImpl} (default constructor).
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#resizeList(List, Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsServiceImpl.resizeList(List, Integer)"})
  public void testResizeList_givenCrossSaleProductImpl_thenReturnArrayList() {
    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

    ArrayList<PromotableProduct> originalList = new ArrayList<>();
    originalList.add(new CrossSaleProductImpl());

    // Act
    List<? extends PromotableProduct> actualResizeListResult =
        relatedProductsServiceImpl.resizeList(originalList, 1);

    // Assert
    assertSame(originalList, actualResizeListResult);
  }

  /**
   * Test {@link RelatedProductsServiceImpl#resizeList(List, Integer)}.
   *
   * <ul>
   *   <li>Given {@link CrossSaleProductImpl} (default constructor).
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#resizeList(List, Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsServiceImpl.resizeList(List, Integer)"})
  public void testResizeList_givenCrossSaleProductImpl_thenReturnSizeIsOne() {
    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

    ArrayList<PromotableProduct> originalList = new ArrayList<>();
    CrossSaleProductImpl crossSaleProductImpl = new CrossSaleProductImpl();
    originalList.add(crossSaleProductImpl);
    originalList.add(new CrossSaleProductImpl());

    // Act
    List<? extends PromotableProduct> actualResizeListResult =
        relatedProductsServiceImpl.resizeList(originalList, 1);

    // Assert
    assertEquals(1, actualResizeListResult.size());
    assertSame(crossSaleProductImpl, actualResizeListResult.get(0));
  }

  /**
   * Test {@link RelatedProductsServiceImpl#resizeList(List, Integer)}.
   *
   * <ul>
   *   <li>Given {@link RelatedProductsServiceImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#resizeList(List, Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsServiceImpl.resizeList(List, Integer)"})
  public void testResizeList_givenRelatedProductsServiceImpl_whenArrayList_thenReturnEmpty() {
    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

    // Act and Assert
    assertTrue(relatedProductsServiceImpl.resizeList(new ArrayList<>(), 1).isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#resizeList(List, Integer)}.
   *
   * <ul>
   *   <li>Given {@link RelatedProductsServiceImpl} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#resizeList(List, Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsServiceImpl.resizeList(List, Integer)"})
  public void testResizeList_givenRelatedProductsServiceImpl_whenNull_thenReturnEmpty() {
    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

    // Act and Assert
    assertTrue(relatedProductsServiceImpl.resizeList(new ArrayList<>(), null).isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#resizeList(List, Integer)}.
   *
   * <ul>
   *   <li>Given {@link RelatedProductsServiceImpl} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#resizeList(List, Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsServiceImpl.resizeList(List, Integer)"})
  public void testResizeList_givenRelatedProductsServiceImpl_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new RelatedProductsServiceImpl().resizeList(null, 1));
  }

  /**
   * Test {@link RelatedProductsServiceImpl#lookupProduct(RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Given {@link RelatedProductsServiceImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#lookupProduct(RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Product RelatedProductsServiceImpl.lookupProduct(RelatedProductDTO)"})
  public void testLookupProduct_givenRelatedProductsServiceImpl_thenReturnNull() {
    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);
    relatedProductDTO.setProductId(null);

    // Act and Assert
    assertNull(relatedProductsServiceImpl.lookupProduct(relatedProductDTO));
  }

  /**
   * Test {@link RelatedProductsServiceImpl#lookupProduct(RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Then return {@link ProductBundleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#lookupProduct(RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Product RelatedProductsServiceImpl.lookupProduct(RelatedProductDTO)"})
  public void testLookupProduct_thenReturnProductBundleImpl() {
    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    Product actualLookupProductResult = relatedProductsServiceImpl.lookupProduct(relatedProductDTO);

    // Assert
    verify(productDao).readProductById(1L);
    assertSame(productBundleImpl, actualLookupProductResult);
  }

  /**
   * Test {@link RelatedProductsServiceImpl#lookupProduct(RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#lookupProduct(RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Product RelatedProductsServiceImpl.lookupProduct(RelatedProductDTO)"})
  public void testLookupProduct_thenThrowIllegalArgumentException() {
    // Arrange
    when(productDao.readProductById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException());

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> relatedProductsServiceImpl.lookupProduct(relatedProductDTO));
    verify(productDao).readProductById(1L);
  }

  /**
   * Test {@link RelatedProductsServiceImpl#lookupCategory(RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Given {@link RelatedProductsServiceImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#lookupCategory(RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.catalog.domain.Category RelatedProductsServiceImpl.lookupCategory(RelatedProductDTO)"
  })
  public void testLookupCategory_givenRelatedProductsServiceImpl_thenReturnNull() {
    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);
    relatedProductDTO.setCategoryId(null);

    // Act and Assert
    assertNull(relatedProductsServiceImpl.lookupCategory(relatedProductDTO));
  }

  /**
   * Test {@link RelatedProductsServiceImpl#lookupCategory(RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Then return {@link CategoryImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#lookupCategory(RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.catalog.domain.Category RelatedProductsServiceImpl.lookupCategory(RelatedProductDTO)"
  })
  public void testLookupCategory_thenReturnCategoryImpl() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(categoryImpl);

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    org.broadleafcommerce.core.catalog.domain.Category actualLookupCategoryResult =
        relatedProductsServiceImpl.lookupCategory(relatedProductDTO);

    // Assert
    verify(categoryDao).readCategoryById(1L);
    assertSame(categoryImpl, actualLookupCategoryResult);
  }

  /**
   * Test {@link RelatedProductsServiceImpl#lookupCategory(RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#lookupCategory(RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.catalog.domain.Category RelatedProductsServiceImpl.lookupCategory(RelatedProductDTO)"
  })
  public void testLookupCategory_thenThrowIllegalArgumentException() {
    // Arrange
    when(categoryDao.readCategoryById(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> relatedProductsServiceImpl.lookupCategory(relatedProductDTO));
    verify(categoryDao).readCategoryById(1L);
  }
}

/*-
 * #%L
 * BroadleafCommerce Framework
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
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.core.catalog.dao.CategoryDao;
import org.broadleafcommerce.core.catalog.dao.ProductDao;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.CrossSaleProductImpl;
import org.broadleafcommerce.core.catalog.domain.FeaturedProduct;
import org.broadleafcommerce.core.catalog.domain.FeaturedProductImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.ProductImpl;
import org.broadleafcommerce.core.catalog.domain.PromotableProduct;
import org.broadleafcommerce.core.catalog.domain.RelatedProduct;
import org.broadleafcommerce.core.catalog.domain.RelatedProductDTO;
import org.broadleafcommerce.core.catalog.domain.RelatedProductTypeEnum;
import org.broadleafcommerce.core.inventory.service.type.InventoryType;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
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
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsServiceImpl.findRelatedProducts(RelatedProductDTO)"})
  public void testFindRelatedProducts_givenProductDaoReadProductByIdReturnNull() {
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
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(new RelatedProductTypeEnum());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> relatedProductsServiceImpl.findRelatedProducts(relatedProductDTO));
    verify(categoryDao).readCategoryById(1L);
    verify(productDao).readProductById(1L);
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
   *   <li>When {@link RelatedProductDTO} (default constructor) CategoryId is {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RelatedProductsServiceImpl.findRelatedProducts(RelatedProductDTO)"})
  public void testFindRelatedProducts_whenRelatedProductDTOCategoryIdIsNull_thenReturnNull() {
    // Arrange
    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setProductId(null);
    relatedProductDTO.setCategoryId(null);
    relatedProductDTO.setType(RelatedProductTypeEnum.FEATURED);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setQuantity(1);

    // Act and Assert
    assertNull(relatedProductsServiceImpl.findRelatedProducts(relatedProductDTO));
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
    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setProductId(null);
    relatedProductDTO.setCategoryId(null);
    relatedProductDTO.setType(RelatedProductTypeEnum.FEATURED);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setQuantity(null);

    // Act and Assert
    assertNull(relatedProductsServiceImpl.findRelatedProducts(relatedProductDTO));
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
  public void testFindRelatedProducts_whenRelatedProductDTOQuantityIsNull_thenReturnNull2() {
    // Arrange
    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setProductId(null);
    relatedProductDTO.setCategoryId(null);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setQuantity(null);

    // Act and Assert
    assertNull(relatedProductsServiceImpl.findRelatedProducts(relatedProductDTO));
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
  public void testFindRelatedProducts_whenRelatedProductDTOQuantityIsNull_thenReturnNull3() {
    // Arrange
    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setProductId(null);
    relatedProductDTO.setCategoryId(null);
    relatedProductDTO.setType(RelatedProductTypeEnum.UP_SALE);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setQuantity(null);

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
    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setProductId(null);
    relatedProductDTO.setCategoryId(null);
    relatedProductDTO.setType(null);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setQuantity(null);

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
   *   <li>Given {@code null}.
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
  public void testBuildFeaturedProductsList_givenNull_thenReturnEmpty() {
    // Arrange
    CategoryImpl category = new CategoryImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setQuantity(null);

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
  public void testBuildFeaturedProductsList_givenNull_thenReturnNull() {
    // Arrange
    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setQuantity(null);

    // Act and Assert
    assertNull(relatedProductsServiceImpl.buildFeaturedProductsList(null, null, relatedProductDTO));
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Given {@code true}.
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
  public void testBuildFeaturedProductsList_givenTrue_thenReturnEmpty() {
    // Arrange
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
   *   <li>Given zero.
   *   <li>When {@link RelatedProductDTO} (default constructor) Quantity is zero.
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
  public void testBuildFeaturedProductsList_givenZero_whenRelatedProductDTOQuantityIsZero() {
    // Arrange
    ArrayList<FeaturedProduct> featuredProductList = new ArrayList<>();
    featuredProductList.add(new FeaturedProductImpl());

    org.broadleafcommerce.core.catalog.domain.Category category =
        mock(org.broadleafcommerce.core.catalog.domain.Category.class);
    when(category.getFeaturedProducts()).thenReturn(featuredProductList);

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setQuantity(0);

    // Act
    List<? extends PromotableProduct> actualBuildFeaturedProductsListResult =
        relatedProductsServiceImpl.buildFeaturedProductsList(null, category, relatedProductDTO);

    // Assert
    verify(category).getFeaturedProducts();
    assertTrue(actualBuildFeaturedProductsListResult.isEmpty());
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
   * Test {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.
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
  public void testBuildFeaturedProductsList_thenReturnArrayList() {
    // Arrange
    ArrayList<FeaturedProduct> featuredProductList = new ArrayList<>();
    featuredProductList.add(new FeaturedProductImpl());

    org.broadleafcommerce.core.catalog.domain.Category category =
        mock(org.broadleafcommerce.core.catalog.domain.Category.class);
    when(category.getFeaturedProducts()).thenReturn(featuredProductList);

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setQuantity(null);

    // Act
    List<? extends PromotableProduct> actualBuildFeaturedProductsListResult =
        relatedProductsServiceImpl.buildFeaturedProductsList(null, category, relatedProductDTO);

    // Assert
    verify(category).getFeaturedProducts();
    assertSame(featuredProductList, actualBuildFeaturedProductsListResult);
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.
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
  public void testBuildFeaturedProductsList_thenReturnArrayList2() {
    // Arrange
    ArrayList<FeaturedProduct> featuredProductList = new ArrayList<>();
    featuredProductList.add(new FeaturedProductImpl());
    featuredProductList.add(new FeaturedProductImpl());

    org.broadleafcommerce.core.catalog.domain.Category category =
        mock(org.broadleafcommerce.core.catalog.domain.Category.class);
    when(category.getFeaturedProducts()).thenReturn(featuredProductList);

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setQuantity(null);

    // Act
    List<? extends PromotableProduct> actualBuildFeaturedProductsListResult =
        relatedProductsServiceImpl.buildFeaturedProductsList(null, category, relatedProductDTO);

    // Assert
    verify(category).getFeaturedProducts();
    assertSame(featuredProductList, actualBuildFeaturedProductsListResult);
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>When {@link RelatedProductDTO} (default constructor) Quantity is one.
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
  public void testBuildFeaturedProductsList_whenRelatedProductDTOQuantityIsOne_thenReturnEmpty() {
    // Arrange
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
   * Test {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then return {@code null}.
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
  public void testBuildUpSaleProductsList_givenFalse_thenReturnNull() {
    // Arrange
    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setQuantity(null);

    // Act and Assert
    assertNull(relatedProductsServiceImpl.buildUpSaleProductsList(null, null, relatedProductDTO));
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Given {@code false}.
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
  public void testBuildUpSaleProductsList_givenFalse_whenProductBundleImpl_thenReturnEmpty() {
    // Arrange
    ProductBundleImpl product = new ProductBundleImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setQuantity(null);

    // Act and Assert
    assertTrue(
        relatedProductsServiceImpl
            .buildUpSaleProductsList(product, null, relatedProductDTO)
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
   *   <li>Given zero.
   *   <li>When {@link RelatedProductDTO} (default constructor) Quantity is zero.
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
  public void testBuildUpSaleProductsList_givenZero_whenRelatedProductDTOQuantityIsZero() {
    // Arrange
    ArrayList<RelatedProduct> upSaleProducts = new ArrayList<>();
    upSaleProducts.add(new CrossSaleProductImpl());

    CategoryImpl category = new CategoryImpl();
    category.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    category.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    category.setCategoryAttributes(new ArrayList<>());
    category.setCategoryAttributesMap(new HashMap<>());
    category.setCategoryMediaXref(new HashMap<>());
    category.setChildCategoryIds(new ArrayList<>());
    category.setChildCategoryURLMap(new HashMap<>());
    category.setDefaultParentCategory(new CategoryImpl());
    category.setDescription("The characteristics of someone or something");
    category.setDisplayTemplate("Display Template");
    category.setExcludedSearchFacets(new ArrayList<>());
    category.setExternalId("42");
    category.setFulfillmentType(FulfillmentType.DIGITAL);
    category.setId(1L);
    category.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    category.setLongDescription("Long Description");
    category.setMetaDescription("Meta Description");
    category.setMetaTitle("Dr");
    category.setName("Name");
    category.setOverrideGeneratedUrl(true);
    category.setProductDescriptionPatternOverride("Product Description Pattern Override");
    category.setProductTitlePatternOverride("Dr");
    category.setRootDisplayOrder(new BigDecimal("2.3"));
    category.setSearchFacets(new ArrayList<>());
    category.setTaxCode("Tax Code");
    category.setUrl("https://example.org/example");
    category.setUrlKey("https://example.org/example");
    category.setUpSaleProducts(upSaleProducts);

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setQuantity(0);

    // Act
    List<? extends PromotableProduct> actualBuildUpSaleProductsListResult =
        relatedProductsServiceImpl.buildUpSaleProductsList(null, category, relatedProductDTO);

    // Assert
    assertEquals(1, category.getCumulativeUpSaleProducts().size());
    assertTrue(actualBuildUpSaleProductsListResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Then calls {@link RelatedProduct#getRelatedProduct()}.
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
  public void testBuildUpSaleProductsList_thenCallsGetRelatedProduct() {
    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setId(1L);

    RelatedProduct relatedProduct = mock(RelatedProduct.class);
    when(relatedProduct.getRelatedProduct()).thenReturn(productBundleImpl);

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(relatedProduct);

    Product product = mock(Product.class);
    when(product.getId()).thenReturn(1L);
    when(product.getCumulativeUpSaleProducts()).thenReturn(relatedProductList);
    CategoryImpl category = mock(CategoryImpl.class);

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setQuantity(null);

    // Act
    List<? extends PromotableProduct> actualBuildUpSaleProductsListResult =
        relatedProductsServiceImpl.buildUpSaleProductsList(product, category, relatedProductDTO);

    // Assert
    verify(product).getCumulativeUpSaleProducts();
    verify(product).getId();
    verify(relatedProduct).getRelatedProduct();
    assertTrue(actualBuildUpSaleProductsListResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Then {@link CategoryImpl} (default constructor) CumulativeUpSaleProducts Empty.
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
  public void testBuildUpSaleProductsList_thenCategoryImplCumulativeUpSaleProductsEmpty() {
    // Arrange
    CategoryImpl category = new CategoryImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setQuantity(null);

    // Act
    List<? extends PromotableProduct> actualBuildUpSaleProductsListResult =
        relatedProductsServiceImpl.buildUpSaleProductsList(null, category, relatedProductDTO);

    // Assert
    assertTrue(category.getCumulativeUpSaleProducts().isEmpty());
    assertTrue(actualBuildUpSaleProductsListResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Then {@link CategoryImpl} (default constructor) CumulativeUpSaleProducts Empty.
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
  public void testBuildUpSaleProductsList_thenCategoryImplCumulativeUpSaleProductsEmpty2() {
    // Arrange
    CategoryImpl category = new CategoryImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualBuildUpSaleProductsListResult =
        relatedProductsServiceImpl.buildUpSaleProductsList(null, category, relatedProductDTO);

    // Assert
    assertTrue(category.getCumulativeUpSaleProducts().isEmpty());
    assertTrue(actualBuildUpSaleProductsListResult.isEmpty());
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
    ArrayList<RelatedProduct> upSaleProducts = new ArrayList<>();
    upSaleProducts.add(new CrossSaleProductImpl());

    CategoryImpl category = new CategoryImpl();
    category.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    category.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    category.setCategoryAttributes(new ArrayList<>());
    category.setCategoryAttributesMap(new HashMap<>());
    category.setCategoryMediaXref(new HashMap<>());
    category.setChildCategoryIds(new ArrayList<>());
    category.setChildCategoryURLMap(new HashMap<>());
    category.setDefaultParentCategory(new CategoryImpl());
    category.setDescription("The characteristics of someone or something");
    category.setDisplayTemplate("Display Template");
    category.setExcludedSearchFacets(new ArrayList<>());
    category.setExternalId("42");
    category.setFulfillmentType(FulfillmentType.DIGITAL);
    category.setId(1L);
    category.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    category.setLongDescription("Long Description");
    category.setMetaDescription("Meta Description");
    category.setMetaTitle("Dr");
    category.setName("Name");
    category.setOverrideGeneratedUrl(true);
    category.setProductDescriptionPatternOverride("Product Description Pattern Override");
    category.setProductTitlePatternOverride("Dr");
    category.setRootDisplayOrder(new BigDecimal("2.3"));
    category.setSearchFacets(new ArrayList<>());
    category.setTaxCode("Tax Code");
    category.setUrl("https://example.org/example");
    category.setUrlKey("https://example.org/example");
    category.setUpSaleProducts(upSaleProducts);

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setQuantity(null);

    // Act and Assert
    assertSame(
        upSaleProducts,
        relatedProductsServiceImpl.buildUpSaleProductsList(null, category, relatedProductDTO));
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
    ArrayList<RelatedProduct> upSaleProducts = new ArrayList<>();
    upSaleProducts.add(new CrossSaleProductImpl());
    upSaleProducts.add(new CrossSaleProductImpl());

    CategoryImpl category = new CategoryImpl();
    category.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    category.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    category.setCategoryAttributes(new ArrayList<>());
    category.setCategoryAttributesMap(new HashMap<>());
    category.setCategoryMediaXref(new HashMap<>());
    category.setChildCategoryIds(new ArrayList<>());
    category.setChildCategoryURLMap(new HashMap<>());
    category.setDefaultParentCategory(new CategoryImpl());
    category.setDescription("The characteristics of someone or something");
    category.setDisplayTemplate("Display Template");
    category.setExcludedSearchFacets(new ArrayList<>());
    category.setExternalId("42");
    category.setFulfillmentType(FulfillmentType.DIGITAL);
    category.setId(1L);
    category.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    category.setLongDescription("Long Description");
    category.setMetaDescription("Meta Description");
    category.setMetaTitle("Dr");
    category.setName("Name");
    category.setOverrideGeneratedUrl(true);
    category.setProductDescriptionPatternOverride("Product Description Pattern Override");
    category.setProductTitlePatternOverride("Dr");
    category.setRootDisplayOrder(new BigDecimal("2.3"));
    category.setSearchFacets(new ArrayList<>());
    category.setTaxCode("Tax Code");
    category.setUrl("https://example.org/example");
    category.setUrlKey("https://example.org/example");
    category.setUpSaleProducts(upSaleProducts);

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setQuantity(null);

    // Act
    List<? extends PromotableProduct> actualBuildUpSaleProductsListResult =
        relatedProductsServiceImpl.buildUpSaleProductsList(null, category, relatedProductDTO);

    // Assert
    assertEquals(1, actualBuildUpSaleProductsListResult.size());
    PromotableProduct getResult = actualBuildUpSaleProductsListResult.get(0);
    assertTrue(getResult instanceof CrossSaleProductImpl);
    assertTrue(getResult.getRelatedProduct() instanceof ProductImpl);
    assertEquals(1, category.getCumulativeUpSaleProducts().size());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
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
  public void testBuildUpSaleProductsList_thenThrowIllegalArgumentException() {
    // Arrange
    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(new CrossSaleProductImpl());

    Product product = mock(Product.class);
    when(product.getId()).thenThrow(new IllegalArgumentException());
    when(product.getCumulativeUpSaleProducts()).thenReturn(relatedProductList);
    CategoryImpl category = mock(CategoryImpl.class);

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setQuantity(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            relatedProductsServiceImpl.buildUpSaleProductsList(
                product, category, relatedProductDTO));
    verify(product).getCumulativeUpSaleProducts();
    verify(product).getId();
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>When {@link Product} {@link Product#getCumulativeUpSaleProducts()} return {@code null}.
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
  public void testBuildUpSaleProductsList_whenProductGetCumulativeUpSaleProductsReturnNull() {
    // Arrange
    Product product = mock(Product.class);
    when(product.getCumulativeUpSaleProducts()).thenReturn(null);
    CategoryImpl category = mock(CategoryImpl.class);

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setQuantity(null);

    // Act
    List<? extends PromotableProduct> actualBuildUpSaleProductsListResult =
        relatedProductsServiceImpl.buildUpSaleProductsList(product, category, relatedProductDTO);

    // Assert
    verify(product).getCumulativeUpSaleProducts();
    assertNull(actualBuildUpSaleProductsListResult);
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>When {@link Product} {@link Product#getId()} return one.
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
  public void testBuildUpSaleProductsList_whenProductGetIdReturnOne_thenReturnArrayList() {
    // Arrange
    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(new CrossSaleProductImpl());

    Product product = mock(Product.class);
    when(product.getId()).thenReturn(1L);
    when(product.getCumulativeUpSaleProducts()).thenReturn(relatedProductList);
    CategoryImpl category = mock(CategoryImpl.class);

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setQuantity(null);

    // Act
    List<? extends PromotableProduct> actualBuildUpSaleProductsListResult =
        relatedProductsServiceImpl.buildUpSaleProductsList(product, category, relatedProductDTO);

    // Assert
    verify(product).getCumulativeUpSaleProducts();
    verify(product).getId();
    assertSame(relatedProductList, actualBuildUpSaleProductsListResult);
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>When {@link RelatedProductDTO} (default constructor) Quantity is one.
   *   <li>Then return {@code null}.
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
  public void testBuildUpSaleProductsList_whenRelatedProductDTOQuantityIsOne_thenReturnNull() {
    // Arrange
    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setQuantity(1);

    // Act and Assert
    assertNull(relatedProductsServiceImpl.buildUpSaleProductsList(null, null, relatedProductDTO));
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category,
   * RelatedProductDTO)}.
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
  public void testBuildCrossSaleProductsList() {
    // Arrange
    Product product = mock(Product.class);
    when(product.getCumulativeCrossSaleProducts()).thenReturn(null);
    CategoryImpl category = mock(CategoryImpl.class);

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setQuantity(null);

    // Act
    List<? extends PromotableProduct> actualBuildCrossSaleProductsListResult =
        relatedProductsServiceImpl.buildCrossSaleProductsList(product, category, relatedProductDTO);

    // Assert
    verify(product).getCumulativeCrossSaleProducts();
    assertNull(actualBuildCrossSaleProductsListResult);
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then return {@code null}.
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
  public void testBuildCrossSaleProductsList_givenFalse_thenReturnNull() {
    // Arrange
    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setQuantity(null);

    // Act and Assert
    assertNull(
        relatedProductsServiceImpl.buildCrossSaleProductsList(null, null, relatedProductDTO));
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link CategoryImpl} (default constructor).
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
  public void testBuildCrossSaleProductsList_givenFalse_whenCategoryImpl_thenReturnEmpty() {
    // Arrange
    CategoryImpl category = new CategoryImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setQuantity(null);

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
   *   <li>Given {@code false}.
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
  public void testBuildCrossSaleProductsList_givenFalse_whenProductBundleImpl_thenReturnEmpty() {
    // Arrange
    ProductBundleImpl product = new ProductBundleImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setQuantity(null);

    // Act and Assert
    assertTrue(
        relatedProductsServiceImpl
            .buildCrossSaleProductsList(product, null, relatedProductDTO)
            .isEmpty());
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
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setId(1L);

    RelatedProduct relatedProduct = mock(RelatedProduct.class);
    when(relatedProduct.getRelatedProduct()).thenReturn(productBundleImpl);

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(relatedProduct);

    Product product = mock(Product.class);
    when(product.getId()).thenReturn(1L);
    when(product.getCumulativeCrossSaleProducts()).thenReturn(relatedProductList);
    CategoryImpl category = mock(CategoryImpl.class);

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setQuantity(null);

    // Act
    List<? extends PromotableProduct> actualBuildCrossSaleProductsListResult =
        relatedProductsServiceImpl.buildCrossSaleProductsList(product, category, relatedProductDTO);

    // Assert
    verify(product).getCumulativeCrossSaleProducts();
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
   *   <li>Given zero.
   *   <li>Then calls {@link RelatedProduct#getRelatedProduct()}.
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
  public void testBuildCrossSaleProductsList_givenZero_thenCallsGetRelatedProduct() {
    // Arrange
    RelatedProduct relatedProduct = mock(RelatedProduct.class);
    when(relatedProduct.getRelatedProduct()).thenReturn(new ProductBundleImpl());

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(relatedProduct);

    Product product = mock(Product.class);
    when(product.getId()).thenReturn(1L);
    when(product.getCumulativeCrossSaleProducts()).thenReturn(relatedProductList);
    CategoryImpl category = mock(CategoryImpl.class);

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setQuantity(0);

    // Act
    List<? extends PromotableProduct> actualBuildCrossSaleProductsListResult =
        relatedProductsServiceImpl.buildCrossSaleProductsList(product, category, relatedProductDTO);

    // Assert
    verify(product).getCumulativeCrossSaleProducts();
    verify(product).getId();
    verify(relatedProduct, atLeast(1)).getRelatedProduct();
    assertTrue(actualBuildCrossSaleProductsListResult.isEmpty());
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
    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(new CrossSaleProductImpl());

    Product product = mock(Product.class);
    when(product.getId()).thenReturn(1L);
    when(product.getCumulativeCrossSaleProducts()).thenReturn(relatedProductList);
    CategoryImpl category = mock(CategoryImpl.class);

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setQuantity(null);

    // Act
    List<? extends PromotableProduct> actualBuildCrossSaleProductsListResult =
        relatedProductsServiceImpl.buildCrossSaleProductsList(product, category, relatedProductDTO);

    // Assert
    verify(product).getCumulativeCrossSaleProducts();
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
    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(new CrossSaleProductImpl());
    relatedProductList.add(new CrossSaleProductImpl());

    Product product = mock(Product.class);
    when(product.getId()).thenReturn(1L);
    when(product.getCumulativeCrossSaleProducts()).thenReturn(relatedProductList);
    CategoryImpl category = mock(CategoryImpl.class);

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setQuantity(null);

    // Act
    List<? extends PromotableProduct> actualBuildCrossSaleProductsListResult =
        relatedProductsServiceImpl.buildCrossSaleProductsList(product, category, relatedProductDTO);

    // Assert
    verify(product).getCumulativeCrossSaleProducts();
    verify(product, atLeast(1)).getId();
    assertSame(relatedProductList, actualBuildCrossSaleProductsListResult);
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
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
  public void testBuildCrossSaleProductsList_thenThrowIllegalArgumentException() {
    // Arrange
    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(new CrossSaleProductImpl());

    Product product = mock(Product.class);
    when(product.getId()).thenThrow(new IllegalArgumentException());
    when(product.getCumulativeCrossSaleProducts()).thenReturn(relatedProductList);
    CategoryImpl category = mock(CategoryImpl.class);

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setQuantity(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            relatedProductsServiceImpl.buildCrossSaleProductsList(
                product, category, relatedProductDTO));
    verify(product).getCumulativeCrossSaleProducts();
    verify(product).getId();
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category,
   * RelatedProductDTO)}.
   *
   * <ul>
   *   <li>When {@link RelatedProductDTO} (default constructor) Quantity is one.
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
  public void testBuildCrossSaleProductsList_whenRelatedProductDTOQuantityIsOne() {
    // Arrange
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
   *   <li>When {@link RelatedProductDTO} (default constructor) Quantity is one.
   *   <li>Then return {@code null}.
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
  public void testBuildCrossSaleProductsList_whenRelatedProductDTOQuantityIsOne_thenReturnNull() {
    // Arrange
    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);
    relatedProductDTO.setCumulativeResults(false);
    relatedProductDTO.setQuantity(1);

    // Act and Assert
    assertNull(
        relatedProductsServiceImpl.buildCrossSaleProductsList(null, null, relatedProductDTO));
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
  public void testResizeList_whenArrayList_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(relatedProductsServiceImpl.resizeList(new ArrayList<>(), 1).isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#resizeList(List, Integer)}.
   *
   * <ul>
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
  public void testResizeList_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(relatedProductsServiceImpl.resizeList(null, null));
  }

  /**
   * Test {@link RelatedProductsServiceImpl#resizeList(List, Integer)}.
   *
   * <ul>
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
  public void testResizeList_whenNull_thenReturnNull2() {
    // Arrange, Act and Assert
    assertNull(relatedProductsServiceImpl.resizeList(null, 1));
  }

  /**
   * Test {@link RelatedProductsServiceImpl#lookupProduct(RelatedProductDTO)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link RelatedProductDTO} (default constructor) ProductId is {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductsServiceImpl#lookupProduct(RelatedProductDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Product RelatedProductsServiceImpl.lookupProduct(RelatedProductDTO)"})
  public void testLookupProduct_givenNull_whenRelatedProductDTOProductIdIsNull_thenReturnNull() {
    // Arrange
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
   *   <li>Given {@code null}.
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
  public void testLookupCategory_givenNull_thenReturnNull() {
    // Arrange
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

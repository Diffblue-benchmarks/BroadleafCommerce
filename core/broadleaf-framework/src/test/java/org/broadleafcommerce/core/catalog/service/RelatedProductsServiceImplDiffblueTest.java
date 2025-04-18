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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.catalog.dao.CategoryDao;
import org.broadleafcommerce.core.catalog.dao.ProductDao;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.CrossSaleProductImpl;
import org.broadleafcommerce.core.catalog.domain.FeaturedProduct;
import org.broadleafcommerce.core.catalog.domain.FeaturedProductImpl;
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
  @Mock
  private CatalogService catalogService;

  @Mock
  private CategoryDao categoryDao;

  @Mock
  private ProductDao productDao;

  @InjectMocks
  private RelatedProductsServiceImpl relatedProductsServiceImpl;

  /**
   * Test {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FeaturedProductImpl} (default constructor).</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List RelatedProductsServiceImpl.findRelatedProducts(RelatedProductDTO)"})
  public void testFindRelatedProducts_givenArrayListAddFeaturedProductImpl_thenReturnArrayList() {
    // Arrange
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());

    ArrayList<FeaturedProduct> featuredProductList = new ArrayList<>();
    featuredProductList.add(new FeaturedProductImpl());
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getFeaturedProducts()).thenReturn(featuredProductList);
    Product product = mock(Product.class);
    when(product.getId()).thenReturn(1L);
    when(product.getDefaultCategory()).thenReturn(categoryImpl);
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(product);
    RelatedProductDTO relatedProductDTO = mock(RelatedProductDTO.class);
    when(relatedProductDTO.isCumulativeResults()).thenReturn(false);
    when(relatedProductDTO.getQuantity()).thenReturn(1);
    when(relatedProductDTO.getCategoryId()).thenReturn(1L);
    when(relatedProductDTO.getProductId()).thenReturn(1L);
    when(relatedProductDTO.getType()).thenReturn(RelatedProductTypeEnum.FEATURED);
    doNothing().when(relatedProductDTO).setCategoryId(Mockito.<Long>any());
    doNothing().when(relatedProductDTO).setCumulativeResults(anyBoolean());
    doNothing().when(relatedProductDTO).setProductId(Mockito.<Long>any());
    doNothing().when(relatedProductDTO).setQuantity(Mockito.<Integer>any());
    doNothing().when(relatedProductDTO).setType(Mockito.<RelatedProductTypeEnum>any());
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualFindRelatedProductsResult = relatedProductsServiceImpl
        .findRelatedProducts(relatedProductDTO);

    // Assert
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(categoryImpl).getFeaturedProducts();
    verify(product).getDefaultCategory();
    verify(product).getId();
    verify(relatedProductDTO, atLeast(1)).getCategoryId();
    verify(relatedProductDTO, atLeast(1)).getProductId();
    verify(relatedProductDTO).getQuantity();
    verify(relatedProductDTO).getType();
    verify(relatedProductDTO).isCumulativeResults();
    verify(relatedProductDTO).setCategoryId(eq(1L));
    verify(relatedProductDTO).setCumulativeResults(eq(true));
    verify(relatedProductDTO).setProductId(eq(1L));
    verify(relatedProductDTO).setQuantity(eq(1));
    verify(relatedProductDTO).setType(isA(RelatedProductTypeEnum.class));
    assertSame(featuredProductList, actualFindRelatedProductsResult);
  }

  /**
   * Test {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FeaturedProductImpl} (default constructor).</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List RelatedProductsServiceImpl.findRelatedProducts(RelatedProductDTO)"})
  public void testFindRelatedProducts_givenArrayListAddFeaturedProductImpl_thenReturnArrayList2() {
    // Arrange
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());

    ArrayList<FeaturedProduct> featuredProductList = new ArrayList<>();
    featuredProductList.add(new FeaturedProductImpl());
    featuredProductList.add(new FeaturedProductImpl());
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getFeaturedProducts()).thenReturn(featuredProductList);
    Product product = mock(Product.class);
    when(product.getId()).thenReturn(1L);
    when(product.getDefaultCategory()).thenReturn(categoryImpl);
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(product);
    RelatedProductDTO relatedProductDTO = mock(RelatedProductDTO.class);
    when(relatedProductDTO.isCumulativeResults()).thenReturn(false);
    when(relatedProductDTO.getQuantity()).thenReturn(1);
    when(relatedProductDTO.getCategoryId()).thenReturn(1L);
    when(relatedProductDTO.getProductId()).thenReturn(1L);
    when(relatedProductDTO.getType()).thenReturn(RelatedProductTypeEnum.FEATURED);
    doNothing().when(relatedProductDTO).setCategoryId(Mockito.<Long>any());
    doNothing().when(relatedProductDTO).setCumulativeResults(anyBoolean());
    doNothing().when(relatedProductDTO).setProductId(Mockito.<Long>any());
    doNothing().when(relatedProductDTO).setQuantity(Mockito.<Integer>any());
    doNothing().when(relatedProductDTO).setType(Mockito.<RelatedProductTypeEnum>any());
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualFindRelatedProductsResult = relatedProductsServiceImpl
        .findRelatedProducts(relatedProductDTO);

    // Assert
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(categoryImpl).getFeaturedProducts();
    verify(product).getDefaultCategory();
    verify(product, atLeast(1)).getId();
    verify(relatedProductDTO, atLeast(1)).getCategoryId();
    verify(relatedProductDTO, atLeast(1)).getProductId();
    verify(relatedProductDTO).getQuantity();
    verify(relatedProductDTO).getType();
    verify(relatedProductDTO).isCumulativeResults();
    verify(relatedProductDTO).setCategoryId(eq(1L));
    verify(relatedProductDTO).setCumulativeResults(eq(true));
    verify(relatedProductDTO).setProductId(eq(1L));
    verify(relatedProductDTO).setQuantity(eq(1));
    verify(relatedProductDTO).setType(isA(RelatedProductTypeEnum.class));
    assertSame(featuredProductList, actualFindRelatedProductsResult);
  }

  /**
   * Test {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   * <ul>
   *   <li>Given {@link CategoryDao}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List RelatedProductsServiceImpl.findRelatedProducts(RelatedProductDTO)"})
  public void testFindRelatedProducts_givenCategoryDao_thenThrowIllegalArgumentException() {
    // Arrange
    when(productDao.readProductById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException("FEATURED"));

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> relatedProductsServiceImpl.findRelatedProducts(relatedProductDTO));
    verify(productDao).readProductById(eq(1L));
  }

  /**
   * Test {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   * <ul>
   *   <li>Given {@link ProductDao} {@link ProductDao#readProductById(Long)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    List<? extends PromotableProduct> actualFindRelatedProductsResult = relatedProductsServiceImpl
        .findRelatedProducts(relatedProductDTO);

    // Assert
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    assertTrue(actualFindRelatedProductsResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   * <ul>
   *   <li>Given {@link ProductDao} {@link ProductDao#readProductById(Long)} return {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    List<? extends PromotableProduct> actualFindRelatedProductsResult = relatedProductsServiceImpl
        .findRelatedProducts(relatedProductDTO);

    // Assert
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    assertTrue(actualFindRelatedProductsResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultCategory()} return {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List RelatedProductsServiceImpl.findRelatedProducts(RelatedProductDTO)"})
  public void testFindRelatedProducts_givenProductGetDefaultCategoryReturnCategoryImpl() {
    // Arrange
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    Product product = mock(Product.class);
    when(product.getDefaultCategory()).thenReturn(new CategoryImpl());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(product);
    RelatedProductDTO relatedProductDTO = mock(RelatedProductDTO.class);
    when(relatedProductDTO.isCumulativeResults()).thenReturn(true);
    when(relatedProductDTO.getQuantity()).thenReturn(1);
    when(relatedProductDTO.getCategoryId()).thenReturn(1L);
    when(relatedProductDTO.getProductId()).thenReturn(1L);
    when(relatedProductDTO.getType()).thenReturn(RelatedProductTypeEnum.FEATURED);
    doNothing().when(relatedProductDTO).setCategoryId(Mockito.<Long>any());
    doNothing().when(relatedProductDTO).setCumulativeResults(anyBoolean());
    doNothing().when(relatedProductDTO).setProductId(Mockito.<Long>any());
    doNothing().when(relatedProductDTO).setQuantity(Mockito.<Integer>any());
    doNothing().when(relatedProductDTO).setType(Mockito.<RelatedProductTypeEnum>any());
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualFindRelatedProductsResult = relatedProductsServiceImpl
        .findRelatedProducts(relatedProductDTO);

    // Assert
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(product).getDefaultCategory();
    verify(relatedProductDTO, atLeast(1)).getCategoryId();
    verify(relatedProductDTO, atLeast(1)).getProductId();
    verify(relatedProductDTO).getQuantity();
    verify(relatedProductDTO).getType();
    verify(relatedProductDTO).isCumulativeResults();
    verify(relatedProductDTO).setCategoryId(eq(1L));
    verify(relatedProductDTO).setCumulativeResults(eq(true));
    verify(relatedProductDTO).setProductId(eq(1L));
    verify(relatedProductDTO).setQuantity(eq(1));
    verify(relatedProductDTO).setType(isA(RelatedProductTypeEnum.class));
    assertTrue(actualFindRelatedProductsResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultCategory()} return {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List RelatedProductsServiceImpl.findRelatedProducts(RelatedProductDTO)"})
  public void testFindRelatedProducts_givenProductGetDefaultCategoryReturnNull_thenReturnNull() {
    // Arrange
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    Product product = mock(Product.class);
    when(product.getDefaultCategory()).thenReturn(null);
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(product);
    RelatedProductDTO relatedProductDTO = mock(RelatedProductDTO.class);
    when(relatedProductDTO.getQuantity()).thenReturn(1);
    when(relatedProductDTO.getCategoryId()).thenReturn(1L);
    when(relatedProductDTO.getProductId()).thenReturn(1L);
    when(relatedProductDTO.getType()).thenReturn(RelatedProductTypeEnum.FEATURED);
    doNothing().when(relatedProductDTO).setCategoryId(Mockito.<Long>any());
    doNothing().when(relatedProductDTO).setCumulativeResults(anyBoolean());
    doNothing().when(relatedProductDTO).setProductId(Mockito.<Long>any());
    doNothing().when(relatedProductDTO).setQuantity(Mockito.<Integer>any());
    doNothing().when(relatedProductDTO).setType(Mockito.<RelatedProductTypeEnum>any());
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualFindRelatedProductsResult = relatedProductsServiceImpl
        .findRelatedProducts(relatedProductDTO);

    // Assert
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(product).getDefaultCategory();
    verify(relatedProductDTO, atLeast(1)).getCategoryId();
    verify(relatedProductDTO, atLeast(1)).getProductId();
    verify(relatedProductDTO).getQuantity();
    verify(relatedProductDTO).getType();
    verify(relatedProductDTO).setCategoryId(eq(1L));
    verify(relatedProductDTO).setCumulativeResults(eq(true));
    verify(relatedProductDTO).setProductId(eq(1L));
    verify(relatedProductDTO).setQuantity(eq(1));
    verify(relatedProductDTO).setType(isA(RelatedProductTypeEnum.class));
    assertNull(actualFindRelatedProductsResult);
  }

  /**
   * Test {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   * <ul>
   *   <li>Then calls {@link Product#getCrossSaleProducts()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List RelatedProductsServiceImpl.findRelatedProducts(RelatedProductDTO)"})
  public void testFindRelatedProducts_thenCallsGetCrossSaleProducts() {
    // Arrange
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    Product product = mock(Product.class);
    when(product.getCrossSaleProducts()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(product);
    RelatedProductDTO relatedProductDTO = mock(RelatedProductDTO.class);
    when(relatedProductDTO.isCumulativeResults()).thenReturn(false);
    when(relatedProductDTO.getQuantity()).thenReturn(1);
    when(relatedProductDTO.getCategoryId()).thenReturn(1L);
    when(relatedProductDTO.getProductId()).thenReturn(1L);
    when(relatedProductDTO.getType()).thenReturn(RelatedProductTypeEnum.CROSS_SALE);
    doNothing().when(relatedProductDTO).setCategoryId(Mockito.<Long>any());
    doNothing().when(relatedProductDTO).setCumulativeResults(anyBoolean());
    doNothing().when(relatedProductDTO).setProductId(Mockito.<Long>any());
    doNothing().when(relatedProductDTO).setQuantity(Mockito.<Integer>any());
    doNothing().when(relatedProductDTO).setType(Mockito.<RelatedProductTypeEnum>any());
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualFindRelatedProductsResult = relatedProductsServiceImpl
        .findRelatedProducts(relatedProductDTO);

    // Assert
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(product).getCrossSaleProducts();
    verify(relatedProductDTO, atLeast(1)).getCategoryId();
    verify(relatedProductDTO, atLeast(1)).getProductId();
    verify(relatedProductDTO).getQuantity();
    verify(relatedProductDTO, atLeast(1)).getType();
    verify(relatedProductDTO).isCumulativeResults();
    verify(relatedProductDTO).setCategoryId(eq(1L));
    verify(relatedProductDTO).setCumulativeResults(eq(true));
    verify(relatedProductDTO).setProductId(eq(1L));
    verify(relatedProductDTO).setQuantity(eq(1));
    verify(relatedProductDTO).setType(isA(RelatedProductTypeEnum.class));
    assertTrue(actualFindRelatedProductsResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   * <ul>
   *   <li>Then calls {@link Product#getCumulativeCrossSaleProducts()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List RelatedProductsServiceImpl.findRelatedProducts(RelatedProductDTO)"})
  public void testFindRelatedProducts_thenCallsGetCumulativeCrossSaleProducts() {
    // Arrange
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    Product product = mock(Product.class);
    when(product.getCumulativeCrossSaleProducts()).thenThrow(new IllegalArgumentException("foo"));
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(product);

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> relatedProductsServiceImpl.findRelatedProducts(relatedProductDTO));
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(product).getCumulativeCrossSaleProducts();
  }

  /**
   * Test {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   * <ul>
   *   <li>Then calls {@link CategoryImpl#getCumulativeFeaturedProducts()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List RelatedProductsServiceImpl.findRelatedProducts(RelatedProductDTO)"})
  public void testFindRelatedProducts_thenCallsGetCumulativeFeaturedProducts() {
    // Arrange
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getCumulativeFeaturedProducts()).thenThrow(new IllegalArgumentException("foo"));
    Product product = mock(Product.class);
    when(product.getDefaultCategory()).thenReturn(categoryImpl);
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(product);
    RelatedProductDTO relatedProductDTO = mock(RelatedProductDTO.class);
    when(relatedProductDTO.isCumulativeResults()).thenReturn(true);
    when(relatedProductDTO.getCategoryId()).thenReturn(1L);
    when(relatedProductDTO.getProductId()).thenReturn(1L);
    when(relatedProductDTO.getType()).thenReturn(RelatedProductTypeEnum.FEATURED);
    doNothing().when(relatedProductDTO).setCategoryId(Mockito.<Long>any());
    doNothing().when(relatedProductDTO).setCumulativeResults(anyBoolean());
    doNothing().when(relatedProductDTO).setProductId(Mockito.<Long>any());
    doNothing().when(relatedProductDTO).setQuantity(Mockito.<Integer>any());
    doNothing().when(relatedProductDTO).setType(Mockito.<RelatedProductTypeEnum>any());
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> relatedProductsServiceImpl.findRelatedProducts(relatedProductDTO));
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(categoryImpl).getCumulativeFeaturedProducts();
    verify(product).getDefaultCategory();
    verify(relatedProductDTO, atLeast(1)).getCategoryId();
    verify(relatedProductDTO, atLeast(1)).getProductId();
    verify(relatedProductDTO).getType();
    verify(relatedProductDTO).isCumulativeResults();
    verify(relatedProductDTO).setCategoryId(eq(1L));
    verify(relatedProductDTO).setCumulativeResults(eq(true));
    verify(relatedProductDTO).setProductId(eq(1L));
    verify(relatedProductDTO).setQuantity(eq(1));
    verify(relatedProductDTO).setType(isA(RelatedProductTypeEnum.class));
  }

  /**
   * Test {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   * <ul>
   *   <li>Then calls {@link Product#getCumulativeUpSaleProducts()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List RelatedProductsServiceImpl.findRelatedProducts(RelatedProductDTO)"})
  public void testFindRelatedProducts_thenCallsGetCumulativeUpSaleProducts() {
    // Arrange
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    Product product = mock(Product.class);
    when(product.getCumulativeUpSaleProducts()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(product);
    RelatedProductDTO relatedProductDTO = mock(RelatedProductDTO.class);
    when(relatedProductDTO.isCumulativeResults()).thenReturn(true);
    when(relatedProductDTO.getQuantity()).thenReturn(1);
    when(relatedProductDTO.getCategoryId()).thenReturn(1L);
    when(relatedProductDTO.getProductId()).thenReturn(1L);
    when(relatedProductDTO.getType()).thenReturn(RelatedProductTypeEnum.UP_SALE);
    doNothing().when(relatedProductDTO).setCategoryId(Mockito.<Long>any());
    doNothing().when(relatedProductDTO).setCumulativeResults(anyBoolean());
    doNothing().when(relatedProductDTO).setProductId(Mockito.<Long>any());
    doNothing().when(relatedProductDTO).setQuantity(Mockito.<Integer>any());
    doNothing().when(relatedProductDTO).setType(Mockito.<RelatedProductTypeEnum>any());
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualFindRelatedProductsResult = relatedProductsServiceImpl
        .findRelatedProducts(relatedProductDTO);

    // Assert
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(product).getCumulativeUpSaleProducts();
    verify(relatedProductDTO, atLeast(1)).getCategoryId();
    verify(relatedProductDTO, atLeast(1)).getProductId();
    verify(relatedProductDTO).getQuantity();
    verify(relatedProductDTO, atLeast(1)).getType();
    verify(relatedProductDTO).isCumulativeResults();
    verify(relatedProductDTO).setCategoryId(eq(1L));
    verify(relatedProductDTO).setCumulativeResults(eq(true));
    verify(relatedProductDTO).setProductId(eq(1L));
    verify(relatedProductDTO).setQuantity(eq(1));
    verify(relatedProductDTO).setType(isA(RelatedProductTypeEnum.class));
    assertTrue(actualFindRelatedProductsResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   * <ul>
   *   <li>Then calls {@link CategoryImpl#getFeaturedProducts()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List RelatedProductsServiceImpl.findRelatedProducts(RelatedProductDTO)"})
  public void testFindRelatedProducts_thenCallsGetFeaturedProducts() {
    // Arrange
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getFeaturedProducts()).thenReturn(new ArrayList<>());
    Product product = mock(Product.class);
    when(product.getDefaultCategory()).thenReturn(categoryImpl);
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(product);
    RelatedProductDTO relatedProductDTO = mock(RelatedProductDTO.class);
    when(relatedProductDTO.isCumulativeResults()).thenReturn(false);
    when(relatedProductDTO.getQuantity()).thenReturn(1);
    when(relatedProductDTO.getCategoryId()).thenReturn(1L);
    when(relatedProductDTO.getProductId()).thenReturn(1L);
    when(relatedProductDTO.getType()).thenReturn(RelatedProductTypeEnum.FEATURED);
    doNothing().when(relatedProductDTO).setCategoryId(Mockito.<Long>any());
    doNothing().when(relatedProductDTO).setCumulativeResults(anyBoolean());
    doNothing().when(relatedProductDTO).setProductId(Mockito.<Long>any());
    doNothing().when(relatedProductDTO).setQuantity(Mockito.<Integer>any());
    doNothing().when(relatedProductDTO).setType(Mockito.<RelatedProductTypeEnum>any());
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualFindRelatedProductsResult = relatedProductsServiceImpl
        .findRelatedProducts(relatedProductDTO);

    // Assert
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(categoryImpl).getFeaturedProducts();
    verify(product).getDefaultCategory();
    verify(relatedProductDTO, atLeast(1)).getCategoryId();
    verify(relatedProductDTO, atLeast(1)).getProductId();
    verify(relatedProductDTO).getQuantity();
    verify(relatedProductDTO).getType();
    verify(relatedProductDTO).isCumulativeResults();
    verify(relatedProductDTO).setCategoryId(eq(1L));
    verify(relatedProductDTO).setCumulativeResults(eq(true));
    verify(relatedProductDTO).setProductId(eq(1L));
    verify(relatedProductDTO).setQuantity(eq(1));
    verify(relatedProductDTO).setType(isA(RelatedProductTypeEnum.class));
    assertTrue(actualFindRelatedProductsResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   * <ul>
   *   <li>Then calls {@link Product#getUpSaleProducts()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List RelatedProductsServiceImpl.findRelatedProducts(RelatedProductDTO)"})
  public void testFindRelatedProducts_thenCallsGetUpSaleProducts() {
    // Arrange
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    Product product = mock(Product.class);
    when(product.getUpSaleProducts()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(product);
    RelatedProductDTO relatedProductDTO = mock(RelatedProductDTO.class);
    when(relatedProductDTO.isCumulativeResults()).thenReturn(false);
    when(relatedProductDTO.getQuantity()).thenReturn(1);
    when(relatedProductDTO.getCategoryId()).thenReturn(1L);
    when(relatedProductDTO.getProductId()).thenReturn(1L);
    when(relatedProductDTO.getType()).thenReturn(RelatedProductTypeEnum.UP_SALE);
    doNothing().when(relatedProductDTO).setCategoryId(Mockito.<Long>any());
    doNothing().when(relatedProductDTO).setCumulativeResults(anyBoolean());
    doNothing().when(relatedProductDTO).setProductId(Mockito.<Long>any());
    doNothing().when(relatedProductDTO).setQuantity(Mockito.<Integer>any());
    doNothing().when(relatedProductDTO).setType(Mockito.<RelatedProductTypeEnum>any());
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualFindRelatedProductsResult = relatedProductsServiceImpl
        .findRelatedProducts(relatedProductDTO);

    // Assert
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(product).getUpSaleProducts();
    verify(relatedProductDTO, atLeast(1)).getCategoryId();
    verify(relatedProductDTO, atLeast(1)).getProductId();
    verify(relatedProductDTO).getQuantity();
    verify(relatedProductDTO, atLeast(1)).getType();
    verify(relatedProductDTO).isCumulativeResults();
    verify(relatedProductDTO).setCategoryId(eq(1L));
    verify(relatedProductDTO).setCumulativeResults(eq(true));
    verify(relatedProductDTO).setProductId(eq(1L));
    verify(relatedProductDTO).setQuantity(eq(1));
    verify(relatedProductDTO).setType(isA(RelatedProductTypeEnum.class));
    assertTrue(actualFindRelatedProductsResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List RelatedProductsServiceImpl.findRelatedProducts(RelatedProductDTO)"})
  public void testFindRelatedProducts_thenReturnSizeIsOne() {
    // Arrange
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    FeaturedProductImpl featuredProductImpl = mock(FeaturedProductImpl.class);
    when(featuredProductImpl.getRelatedProduct()).thenReturn(new ProductBundleImpl());

    ArrayList<FeaturedProduct> featuredProductList = new ArrayList<>();
    FeaturedProductImpl featuredProductImpl2 = new FeaturedProductImpl();
    featuredProductList.add(featuredProductImpl2);
    featuredProductList.add(featuredProductImpl);
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getFeaturedProducts()).thenReturn(featuredProductList);
    Product product = mock(Product.class);
    when(product.getId()).thenReturn(1L);
    when(product.getDefaultCategory()).thenReturn(categoryImpl);
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(product);
    RelatedProductDTO relatedProductDTO = mock(RelatedProductDTO.class);
    when(relatedProductDTO.isCumulativeResults()).thenReturn(false);
    when(relatedProductDTO.getQuantity()).thenReturn(1);
    when(relatedProductDTO.getCategoryId()).thenReturn(1L);
    when(relatedProductDTO.getProductId()).thenReturn(1L);
    when(relatedProductDTO.getType()).thenReturn(RelatedProductTypeEnum.FEATURED);
    doNothing().when(relatedProductDTO).setCategoryId(Mockito.<Long>any());
    doNothing().when(relatedProductDTO).setCumulativeResults(anyBoolean());
    doNothing().when(relatedProductDTO).setProductId(Mockito.<Long>any());
    doNothing().when(relatedProductDTO).setQuantity(Mockito.<Integer>any());
    doNothing().when(relatedProductDTO).setType(Mockito.<RelatedProductTypeEnum>any());
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualFindRelatedProductsResult = relatedProductsServiceImpl
        .findRelatedProducts(relatedProductDTO);

    // Assert
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(categoryImpl).getFeaturedProducts();
    verify(featuredProductImpl, atLeast(1)).getRelatedProduct();
    verify(product).getDefaultCategory();
    verify(product, atLeast(1)).getId();
    verify(relatedProductDTO, atLeast(1)).getCategoryId();
    verify(relatedProductDTO, atLeast(1)).getProductId();
    verify(relatedProductDTO).getQuantity();
    verify(relatedProductDTO).getType();
    verify(relatedProductDTO).isCumulativeResults();
    verify(relatedProductDTO).setCategoryId(eq(1L));
    verify(relatedProductDTO).setCumulativeResults(eq(true));
    verify(relatedProductDTO).setProductId(eq(1L));
    verify(relatedProductDTO).setQuantity(eq(1));
    verify(relatedProductDTO).setType(isA(RelatedProductTypeEnum.class));
    assertEquals(1, actualFindRelatedProductsResult.size());
    assertSame(featuredProductImpl2, actualFindRelatedProductsResult.get(0));
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List RelatedProductsServiceImpl.buildFeaturedProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"})
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
    List<? extends PromotableProduct> actualBuildFeaturedProductsListResult = relatedProductsServiceImpl
        .buildFeaturedProductsList(product, category, relatedProductDTO);

    // Assert
    verify(product).getDefaultCategory();
    assertTrue(actualBuildFeaturedProductsListResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List RelatedProductsServiceImpl.buildFeaturedProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"})
  public void testBuildFeaturedProductsList_thenReturnArrayList() {
    // Arrange
    ArrayList<FeaturedProduct> featuredProductList = new ArrayList<>();
    featuredProductList.add(new FeaturedProductImpl());
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getFeaturedProducts()).thenReturn(featuredProductList);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getDefaultCategory()).thenReturn(categoryImpl);
    CategoryImpl category = new CategoryImpl();
    RelatedProductDTO relatedProductDTO = mock(RelatedProductDTO.class);
    when(relatedProductDTO.isCumulativeResults()).thenReturn(false);
    when(relatedProductDTO.getQuantity()).thenReturn(1);
    doNothing().when(relatedProductDTO).setCategoryId(Mockito.<Long>any());
    doNothing().when(relatedProductDTO).setCumulativeResults(anyBoolean());
    doNothing().when(relatedProductDTO).setProductId(Mockito.<Long>any());
    doNothing().when(relatedProductDTO).setQuantity(Mockito.<Integer>any());
    doNothing().when(relatedProductDTO).setType(Mockito.<RelatedProductTypeEnum>any());
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualBuildFeaturedProductsListResult = relatedProductsServiceImpl
        .buildFeaturedProductsList(product, category, relatedProductDTO);

    // Assert
    verify(categoryImpl).getFeaturedProducts();
    verify(product).getDefaultCategory();
    verify(product).getId();
    verify(relatedProductDTO).getQuantity();
    verify(relatedProductDTO).isCumulativeResults();
    verify(relatedProductDTO).setCategoryId(eq(1L));
    verify(relatedProductDTO).setCumulativeResults(eq(true));
    verify(relatedProductDTO).setProductId(eq(1L));
    verify(relatedProductDTO).setQuantity(eq(1));
    verify(relatedProductDTO).setType(isA(RelatedProductTypeEnum.class));
    assertSame(featuredProductList, actualBuildFeaturedProductsListResult);
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List RelatedProductsServiceImpl.buildFeaturedProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"})
  public void testBuildFeaturedProductsList_thenReturnArrayList2() {
    // Arrange
    ArrayList<FeaturedProduct> featuredProductList = new ArrayList<>();
    featuredProductList.add(new FeaturedProductImpl());
    featuredProductList.add(new FeaturedProductImpl());
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getFeaturedProducts()).thenReturn(featuredProductList);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getDefaultCategory()).thenReturn(categoryImpl);
    CategoryImpl category = new CategoryImpl();
    RelatedProductDTO relatedProductDTO = mock(RelatedProductDTO.class);
    when(relatedProductDTO.isCumulativeResults()).thenReturn(false);
    when(relatedProductDTO.getQuantity()).thenReturn(1);
    doNothing().when(relatedProductDTO).setCategoryId(Mockito.<Long>any());
    doNothing().when(relatedProductDTO).setCumulativeResults(anyBoolean());
    doNothing().when(relatedProductDTO).setProductId(Mockito.<Long>any());
    doNothing().when(relatedProductDTO).setQuantity(Mockito.<Integer>any());
    doNothing().when(relatedProductDTO).setType(Mockito.<RelatedProductTypeEnum>any());
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualBuildFeaturedProductsListResult = relatedProductsServiceImpl
        .buildFeaturedProductsList(product, category, relatedProductDTO);

    // Assert
    verify(categoryImpl).getFeaturedProducts();
    verify(product).getDefaultCategory();
    verify(product, atLeast(1)).getId();
    verify(relatedProductDTO).getQuantity();
    verify(relatedProductDTO).isCumulativeResults();
    verify(relatedProductDTO).setCategoryId(eq(1L));
    verify(relatedProductDTO).setCumulativeResults(eq(true));
    verify(relatedProductDTO).setProductId(eq(1L));
    verify(relatedProductDTO).setQuantity(eq(1));
    verify(relatedProductDTO).setType(isA(RelatedProductTypeEnum.class));
    assertSame(featuredProductList, actualBuildFeaturedProductsListResult);
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List RelatedProductsServiceImpl.buildFeaturedProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"})
  public void testBuildFeaturedProductsList_thenReturnEmpty() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getFeaturedProducts()).thenReturn(new ArrayList<>());
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultCategory()).thenReturn(categoryImpl);
    CategoryImpl category = new CategoryImpl();
    RelatedProductDTO relatedProductDTO = mock(RelatedProductDTO.class);
    when(relatedProductDTO.isCumulativeResults()).thenReturn(false);
    when(relatedProductDTO.getQuantity()).thenReturn(1);
    doNothing().when(relatedProductDTO).setCategoryId(Mockito.<Long>any());
    doNothing().when(relatedProductDTO).setCumulativeResults(anyBoolean());
    doNothing().when(relatedProductDTO).setProductId(Mockito.<Long>any());
    doNothing().when(relatedProductDTO).setQuantity(Mockito.<Integer>any());
    doNothing().when(relatedProductDTO).setType(Mockito.<RelatedProductTypeEnum>any());
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualBuildFeaturedProductsListResult = relatedProductsServiceImpl
        .buildFeaturedProductsList(product, category, relatedProductDTO);

    // Assert
    verify(categoryImpl).getFeaturedProducts();
    verify(product).getDefaultCategory();
    verify(relatedProductDTO).getQuantity();
    verify(relatedProductDTO).isCumulativeResults();
    verify(relatedProductDTO).setCategoryId(eq(1L));
    verify(relatedProductDTO).setCumulativeResults(eq(true));
    verify(relatedProductDTO).setProductId(eq(1L));
    verify(relatedProductDTO).setQuantity(eq(1));
    verify(relatedProductDTO).setType(isA(RelatedProductTypeEnum.class));
    assertTrue(actualBuildFeaturedProductsListResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List RelatedProductsServiceImpl.buildFeaturedProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"})
  public void testBuildFeaturedProductsList_thenThrowIllegalArgumentException() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getCumulativeFeaturedProducts()).thenThrow(new IllegalArgumentException("foo"));
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
    assertThrows(IllegalArgumentException.class,
        () -> relatedProductsServiceImpl.buildFeaturedProductsList(product, category, relatedProductDTO));
    verify(categoryImpl).getCumulativeFeaturedProducts();
    verify(product).getDefaultCategory();
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List RelatedProductsServiceImpl.buildFeaturedProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"})
  public void testBuildFeaturedProductsList_whenNull_thenReturnEmpty() {
    // Arrange
    CategoryImpl category = new CategoryImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act and Assert
    assertTrue(relatedProductsServiceImpl.buildFeaturedProductsList(null, category, relatedProductDTO).isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List RelatedProductsServiceImpl.buildFeaturedProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"})
  public void testBuildFeaturedProductsList_whenProductBundleImpl_thenReturnNull() {
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
    assertNull(relatedProductsServiceImpl.buildFeaturedProductsList(product, category, relatedProductDTO));
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List RelatedProductsServiceImpl.buildUpSaleProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"})
  public void testBuildUpSaleProductsList_givenArrayList_thenReturnEmpty() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getUpSaleProducts()).thenReturn(new ArrayList<>());
    CategoryImpl category = new CategoryImpl();
    RelatedProductDTO relatedProductDTO = mock(RelatedProductDTO.class);
    when(relatedProductDTO.isCumulativeResults()).thenReturn(false);
    when(relatedProductDTO.getQuantity()).thenReturn(1);
    doNothing().when(relatedProductDTO).setCategoryId(Mockito.<Long>any());
    doNothing().when(relatedProductDTO).setCumulativeResults(anyBoolean());
    doNothing().when(relatedProductDTO).setProductId(Mockito.<Long>any());
    doNothing().when(relatedProductDTO).setQuantity(Mockito.<Integer>any());
    doNothing().when(relatedProductDTO).setType(Mockito.<RelatedProductTypeEnum>any());
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualBuildUpSaleProductsListResult = relatedProductsServiceImpl
        .buildUpSaleProductsList(product, category, relatedProductDTO);

    // Assert
    verify(product).getUpSaleProducts();
    verify(relatedProductDTO).getQuantity();
    verify(relatedProductDTO).isCumulativeResults();
    verify(relatedProductDTO).setCategoryId(eq(1L));
    verify(relatedProductDTO).setCumulativeResults(eq(true));
    verify(relatedProductDTO).setProductId(eq(1L));
    verify(relatedProductDTO).setQuantity(eq(1));
    verify(relatedProductDTO).setType(isA(RelatedProductTypeEnum.class));
    assertTrue(actualBuildUpSaleProductsListResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List RelatedProductsServiceImpl.buildUpSaleProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"})
  public void testBuildUpSaleProductsList_thenReturnArrayList() {
    // Arrange
    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(new CrossSaleProductImpl());
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getUpSaleProducts()).thenReturn(relatedProductList);
    CategoryImpl category = new CategoryImpl();
    RelatedProductDTO relatedProductDTO = mock(RelatedProductDTO.class);
    when(relatedProductDTO.isCumulativeResults()).thenReturn(false);
    when(relatedProductDTO.getQuantity()).thenReturn(1);
    doNothing().when(relatedProductDTO).setCategoryId(Mockito.<Long>any());
    doNothing().when(relatedProductDTO).setCumulativeResults(anyBoolean());
    doNothing().when(relatedProductDTO).setProductId(Mockito.<Long>any());
    doNothing().when(relatedProductDTO).setQuantity(Mockito.<Integer>any());
    doNothing().when(relatedProductDTO).setType(Mockito.<RelatedProductTypeEnum>any());
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualBuildUpSaleProductsListResult = relatedProductsServiceImpl
        .buildUpSaleProductsList(product, category, relatedProductDTO);

    // Assert
    verify(product).getId();
    verify(product).getUpSaleProducts();
    verify(relatedProductDTO).getQuantity();
    verify(relatedProductDTO).isCumulativeResults();
    verify(relatedProductDTO).setCategoryId(eq(1L));
    verify(relatedProductDTO).setCumulativeResults(eq(true));
    verify(relatedProductDTO).setProductId(eq(1L));
    verify(relatedProductDTO).setQuantity(eq(1));
    verify(relatedProductDTO).setType(isA(RelatedProductTypeEnum.class));
    assertSame(relatedProductList, actualBuildUpSaleProductsListResult);
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List RelatedProductsServiceImpl.buildUpSaleProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"})
  public void testBuildUpSaleProductsList_thenReturnArrayList2() {
    // Arrange
    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(new CrossSaleProductImpl());
    relatedProductList.add(new CrossSaleProductImpl());
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getUpSaleProducts()).thenReturn(relatedProductList);
    CategoryImpl category = new CategoryImpl();
    RelatedProductDTO relatedProductDTO = mock(RelatedProductDTO.class);
    when(relatedProductDTO.isCumulativeResults()).thenReturn(false);
    when(relatedProductDTO.getQuantity()).thenReturn(1);
    doNothing().when(relatedProductDTO).setCategoryId(Mockito.<Long>any());
    doNothing().when(relatedProductDTO).setCumulativeResults(anyBoolean());
    doNothing().when(relatedProductDTO).setProductId(Mockito.<Long>any());
    doNothing().when(relatedProductDTO).setQuantity(Mockito.<Integer>any());
    doNothing().when(relatedProductDTO).setType(Mockito.<RelatedProductTypeEnum>any());
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualBuildUpSaleProductsListResult = relatedProductsServiceImpl
        .buildUpSaleProductsList(product, category, relatedProductDTO);

    // Assert
    verify(product, atLeast(1)).getId();
    verify(product).getUpSaleProducts();
    verify(relatedProductDTO).getQuantity();
    verify(relatedProductDTO).isCumulativeResults();
    verify(relatedProductDTO).setCategoryId(eq(1L));
    verify(relatedProductDTO).setCumulativeResults(eq(true));
    verify(relatedProductDTO).setProductId(eq(1L));
    verify(relatedProductDTO).setQuantity(eq(1));
    verify(relatedProductDTO).setType(isA(RelatedProductTypeEnum.class));
    assertSame(relatedProductList, actualBuildUpSaleProductsListResult);
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List RelatedProductsServiceImpl.buildUpSaleProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"})
  public void testBuildUpSaleProductsList_whenNull_thenReturnEmpty() {
    // Arrange
    CategoryImpl category = new CategoryImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act and Assert
    assertTrue(relatedProductsServiceImpl.buildUpSaleProductsList(null, category, relatedProductDTO).isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List RelatedProductsServiceImpl.buildUpSaleProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"})
  public void testBuildUpSaleProductsList_whenProductBundleImpl_thenReturnEmpty() {
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
    assertTrue(relatedProductsServiceImpl.buildUpSaleProductsList(product, category, relatedProductDTO).isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List RelatedProductsServiceImpl.buildCrossSaleProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"})
  public void testBuildCrossSaleProductsList_givenArrayList_thenReturnEmpty() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getCrossSaleProducts()).thenReturn(new ArrayList<>());
    CategoryImpl category = new CategoryImpl();
    RelatedProductDTO relatedProductDTO = mock(RelatedProductDTO.class);
    when(relatedProductDTO.isCumulativeResults()).thenReturn(false);
    when(relatedProductDTO.getQuantity()).thenReturn(1);
    doNothing().when(relatedProductDTO).setCategoryId(Mockito.<Long>any());
    doNothing().when(relatedProductDTO).setCumulativeResults(anyBoolean());
    doNothing().when(relatedProductDTO).setProductId(Mockito.<Long>any());
    doNothing().when(relatedProductDTO).setQuantity(Mockito.<Integer>any());
    doNothing().when(relatedProductDTO).setType(Mockito.<RelatedProductTypeEnum>any());
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualBuildCrossSaleProductsListResult = relatedProductsServiceImpl
        .buildCrossSaleProductsList(product, category, relatedProductDTO);

    // Assert
    verify(product).getCrossSaleProducts();
    verify(relatedProductDTO).getQuantity();
    verify(relatedProductDTO).isCumulativeResults();
    verify(relatedProductDTO).setCategoryId(eq(1L));
    verify(relatedProductDTO).setCumulativeResults(eq(true));
    verify(relatedProductDTO).setProductId(eq(1L));
    verify(relatedProductDTO).setQuantity(eq(1));
    verify(relatedProductDTO).setType(isA(RelatedProductTypeEnum.class));
    assertTrue(actualBuildCrossSaleProductsListResult.isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List RelatedProductsServiceImpl.buildCrossSaleProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"})
  public void testBuildCrossSaleProductsList_thenReturnArrayList() {
    // Arrange
    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(new CrossSaleProductImpl());
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getCrossSaleProducts()).thenReturn(relatedProductList);
    CategoryImpl category = new CategoryImpl();
    RelatedProductDTO relatedProductDTO = mock(RelatedProductDTO.class);
    when(relatedProductDTO.isCumulativeResults()).thenReturn(false);
    when(relatedProductDTO.getQuantity()).thenReturn(1);
    doNothing().when(relatedProductDTO).setCategoryId(Mockito.<Long>any());
    doNothing().when(relatedProductDTO).setCumulativeResults(anyBoolean());
    doNothing().when(relatedProductDTO).setProductId(Mockito.<Long>any());
    doNothing().when(relatedProductDTO).setQuantity(Mockito.<Integer>any());
    doNothing().when(relatedProductDTO).setType(Mockito.<RelatedProductTypeEnum>any());
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualBuildCrossSaleProductsListResult = relatedProductsServiceImpl
        .buildCrossSaleProductsList(product, category, relatedProductDTO);

    // Assert
    verify(product).getCrossSaleProducts();
    verify(product).getId();
    verify(relatedProductDTO).getQuantity();
    verify(relatedProductDTO).isCumulativeResults();
    verify(relatedProductDTO).setCategoryId(eq(1L));
    verify(relatedProductDTO).setCumulativeResults(eq(true));
    verify(relatedProductDTO).setProductId(eq(1L));
    verify(relatedProductDTO).setQuantity(eq(1));
    verify(relatedProductDTO).setType(isA(RelatedProductTypeEnum.class));
    assertSame(relatedProductList, actualBuildCrossSaleProductsListResult);
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List RelatedProductsServiceImpl.buildCrossSaleProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"})
  public void testBuildCrossSaleProductsList_thenReturnArrayList2() {
    // Arrange
    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(new CrossSaleProductImpl());
    relatedProductList.add(new CrossSaleProductImpl());
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getCrossSaleProducts()).thenReturn(relatedProductList);
    CategoryImpl category = new CategoryImpl();
    RelatedProductDTO relatedProductDTO = mock(RelatedProductDTO.class);
    when(relatedProductDTO.isCumulativeResults()).thenReturn(false);
    when(relatedProductDTO.getQuantity()).thenReturn(1);
    doNothing().when(relatedProductDTO).setCategoryId(Mockito.<Long>any());
    doNothing().when(relatedProductDTO).setCumulativeResults(anyBoolean());
    doNothing().when(relatedProductDTO).setProductId(Mockito.<Long>any());
    doNothing().when(relatedProductDTO).setQuantity(Mockito.<Integer>any());
    doNothing().when(relatedProductDTO).setType(Mockito.<RelatedProductTypeEnum>any());
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualBuildCrossSaleProductsListResult = relatedProductsServiceImpl
        .buildCrossSaleProductsList(product, category, relatedProductDTO);

    // Assert
    verify(product).getCrossSaleProducts();
    verify(product, atLeast(1)).getId();
    verify(relatedProductDTO).getQuantity();
    verify(relatedProductDTO).isCumulativeResults();
    verify(relatedProductDTO).setCategoryId(eq(1L));
    verify(relatedProductDTO).setCumulativeResults(eq(true));
    verify(relatedProductDTO).setProductId(eq(1L));
    verify(relatedProductDTO).setQuantity(eq(1));
    verify(relatedProductDTO).setType(isA(RelatedProductTypeEnum.class));
    assertSame(relatedProductList, actualBuildCrossSaleProductsListResult);
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List RelatedProductsServiceImpl.buildCrossSaleProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"})
  public void testBuildCrossSaleProductsList_whenNull_thenReturnEmpty() {
    // Arrange
    CategoryImpl category = new CategoryImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act and Assert
    assertTrue(relatedProductsServiceImpl.buildCrossSaleProductsList(null, category, relatedProductDTO).isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List RelatedProductsServiceImpl.buildCrossSaleProductsList(Product, org.broadleafcommerce.core.catalog.domain.Category, RelatedProductDTO)"})
  public void testBuildCrossSaleProductsList_whenProductBundleImpl_thenReturnEmpty() {
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
    assertTrue(relatedProductsServiceImpl.buildCrossSaleProductsList(product, category, relatedProductDTO).isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#resizeList(List, Integer)}.
   * <ul>
   *   <li>Given {@link CrossSaleProductImpl} (default constructor).</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#resizeList(List, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List RelatedProductsServiceImpl.resizeList(List, Integer)"})
  public void testResizeList_givenCrossSaleProductImpl_thenReturnArrayList() {
    // Arrange
    ArrayList<PromotableProduct> originalList = new ArrayList<>();
    originalList.add(new CrossSaleProductImpl());

    // Act and Assert
    assertSame(originalList, relatedProductsServiceImpl.resizeList(originalList, 1));
  }

  /**
   * Test {@link RelatedProductsServiceImpl#resizeList(List, Integer)}.
   * <ul>
   *   <li>Given {@link CrossSaleProductImpl} (default constructor).</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#resizeList(List, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List RelatedProductsServiceImpl.resizeList(List, Integer)"})
  public void testResizeList_givenCrossSaleProductImpl_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<PromotableProduct> originalList = new ArrayList<>();
    CrossSaleProductImpl crossSaleProductImpl = new CrossSaleProductImpl();
    originalList.add(crossSaleProductImpl);
    originalList.add(new CrossSaleProductImpl());

    // Act
    List<? extends PromotableProduct> actualResizeListResult = relatedProductsServiceImpl.resizeList(originalList, 1);

    // Assert
    assertEquals(1, actualResizeListResult.size());
    assertSame(crossSaleProductImpl, actualResizeListResult.get(0));
  }

  /**
   * Test {@link RelatedProductsServiceImpl#resizeList(List, Integer)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#resizeList(List, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List RelatedProductsServiceImpl.resizeList(List, Integer)"})
  public void testResizeList_whenArrayList_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(relatedProductsServiceImpl.resizeList(new ArrayList<>(), 1).isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#resizeList(List, Integer)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#resizeList(List, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List RelatedProductsServiceImpl.resizeList(List, Integer)"})
  public void testResizeList_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(relatedProductsServiceImpl.resizeList(null, null));
  }

  /**
   * Test {@link RelatedProductsServiceImpl#resizeList(List, Integer)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#resizeList(List, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List RelatedProductsServiceImpl.resizeList(List, Integer)"})
  public void testResizeList_whenNull_thenReturnNull2() {
    // Arrange, Act and Assert
    assertNull(relatedProductsServiceImpl.resizeList(null, 1));
  }

  /**
   * Test {@link RelatedProductsServiceImpl#lookupProduct(RelatedProductDTO)}.
   * <ul>
   *   <li>Given {@link ProductDao}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#lookupProduct(RelatedProductDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Product RelatedProductsServiceImpl.lookupProduct(RelatedProductDTO)"})
  public void testLookupProduct_givenProductDao_thenReturnNull() {
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
   * <ul>
   *   <li>Then return {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#lookupProduct(RelatedProductDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    verify(productDao).readProductById(eq(1L));
    assertSame(productBundleImpl, actualLookupProductResult);
  }

  /**
   * Test {@link RelatedProductsServiceImpl#lookupProduct(RelatedProductDTO)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#lookupProduct(RelatedProductDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Product RelatedProductsServiceImpl.lookupProduct(RelatedProductDTO)"})
  public void testLookupProduct_thenThrowIllegalArgumentException() {
    // Arrange
    when(productDao.readProductById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException("foo"));

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> relatedProductsServiceImpl.lookupProduct(relatedProductDTO));
    verify(productDao).readProductById(eq(1L));
  }

  /**
   * Test {@link RelatedProductsServiceImpl#lookupCategory(RelatedProductDTO)}.
   * <ul>
   *   <li>Given {@link CategoryDao}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#lookupCategory(RelatedProductDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.catalog.domain.Category RelatedProductsServiceImpl.lookupCategory(RelatedProductDTO)"})
  public void testLookupCategory_givenCategoryDao_thenReturnNull() {
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
   * <ul>
   *   <li>Then return {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#lookupCategory(RelatedProductDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.catalog.domain.Category RelatedProductsServiceImpl.lookupCategory(RelatedProductDTO)"})
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
    org.broadleafcommerce.core.catalog.domain.Category actualLookupCategoryResult = relatedProductsServiceImpl
        .lookupCategory(relatedProductDTO);

    // Assert
    verify(categoryDao).readCategoryById(eq(1L));
    assertSame(categoryImpl, actualLookupCategoryResult);
  }

  /**
   * Test {@link RelatedProductsServiceImpl#lookupCategory(RelatedProductDTO)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductsServiceImpl#lookupCategory(RelatedProductDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.catalog.domain.Category RelatedProductsServiceImpl.lookupCategory(RelatedProductDTO)"})
  public void testLookupCategory_thenThrowIllegalArgumentException() {
    // Arrange
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException("foo"));

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> relatedProductsServiceImpl.lookupCategory(relatedProductDTO));
    verify(categoryDao).readCategoryById(eq(1L));
  }
}

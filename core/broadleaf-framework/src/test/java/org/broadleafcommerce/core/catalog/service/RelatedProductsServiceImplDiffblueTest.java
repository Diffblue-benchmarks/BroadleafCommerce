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
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.catalog.domain.Category;
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
import org.junit.Test;
import org.mockito.Mockito;

public class RelatedProductsServiceImplDiffblueTest {
  /**
   * Test
   * {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   * <ul>
   *   <li>Given {@link RelatedProductTypeEnum#FEATURED}.</li>
   *   <li>When {@link RelatedProductDTO} {@link RelatedProductDTO#getType()} return
   * {@link RelatedProductTypeEnum#FEATURED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  public void testFindRelatedProducts_givenFeatured_whenRelatedProductDTOGetTypeReturnFeatured() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();
    RelatedProductDTO relatedProductDTO = mock(RelatedProductDTO.class);
    when(relatedProductDTO.getQuantity()).thenReturn(1);
    when(relatedProductDTO.getType()).thenReturn(RelatedProductTypeEnum.FEATURED);
    when(relatedProductDTO.getCategoryId()).thenReturn(null);
    when(relatedProductDTO.getProductId()).thenReturn(null);
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
    verify(relatedProductDTO).getCategoryId();
    verify(relatedProductDTO).getProductId();
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
   * Test
   * {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   * <ul>
   *   <li>Given {@link RelatedProductTypeEnum#RelatedProductTypeEnum()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  public void testFindRelatedProducts_givenRelatedProductTypeEnum() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();
    RelatedProductDTO relatedProductDTO = mock(RelatedProductDTO.class);
    when(relatedProductDTO.getType()).thenReturn(new RelatedProductTypeEnum());
    when(relatedProductDTO.getCategoryId()).thenReturn(null);
    when(relatedProductDTO.getProductId()).thenReturn(null);
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
    verify(relatedProductDTO).getCategoryId();
    verify(relatedProductDTO).getProductId();
    verify(relatedProductDTO, atLeast(1)).getType();
    verify(relatedProductDTO).setCategoryId(eq(1L));
    verify(relatedProductDTO).setCumulativeResults(eq(true));
    verify(relatedProductDTO).setProductId(eq(1L));
    verify(relatedProductDTO).setQuantity(eq(1));
    verify(relatedProductDTO).setType(isA(RelatedProductTypeEnum.class));
  }

  /**
   * Test
   * {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   * <ul>
   *   <li>Given {@link RelatedProductTypeEnum#UP_SALE}.</li>
   *   <li>When {@link RelatedProductDTO} {@link RelatedProductDTO#getType()} return
   * {@link RelatedProductTypeEnum#UP_SALE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  public void testFindRelatedProducts_givenUp_sale_whenRelatedProductDTOGetTypeReturnUp_sale() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();
    RelatedProductDTO relatedProductDTO = mock(RelatedProductDTO.class);
    when(relatedProductDTO.getQuantity()).thenReturn(1);
    when(relatedProductDTO.getType()).thenReturn(RelatedProductTypeEnum.UP_SALE);
    when(relatedProductDTO.getCategoryId()).thenReturn(null);
    when(relatedProductDTO.getProductId()).thenReturn(null);
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
    verify(relatedProductDTO).getCategoryId();
    verify(relatedProductDTO).getProductId();
    verify(relatedProductDTO).getQuantity();
    verify(relatedProductDTO, atLeast(1)).getType();
    verify(relatedProductDTO).setCategoryId(eq(1L));
    verify(relatedProductDTO).setCumulativeResults(eq(true));
    verify(relatedProductDTO).setProductId(eq(1L));
    verify(relatedProductDTO).setQuantity(eq(1));
    verify(relatedProductDTO).setType(isA(RelatedProductTypeEnum.class));
    assertNull(actualFindRelatedProductsResult);
  }

  /**
   * Test
   * {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   * <ul>
   *   <li>When {@link RelatedProductDTO} {@link RelatedProductDTO#getQuantity()}
   * return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  public void testFindRelatedProducts_whenRelatedProductDTOGetQuantityReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();
    RelatedProductDTO relatedProductDTO = mock(RelatedProductDTO.class);
    when(relatedProductDTO.getQuantity()).thenReturn(null);
    when(relatedProductDTO.getType()).thenReturn(RelatedProductTypeEnum.CROSS_SALE);
    when(relatedProductDTO.getCategoryId()).thenReturn(null);
    when(relatedProductDTO.getProductId()).thenReturn(null);
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
    verify(relatedProductDTO).getCategoryId();
    verify(relatedProductDTO).getProductId();
    verify(relatedProductDTO).getQuantity();
    verify(relatedProductDTO, atLeast(1)).getType();
    verify(relatedProductDTO).setCategoryId(eq(1L));
    verify(relatedProductDTO).setCumulativeResults(eq(true));
    verify(relatedProductDTO).setProductId(eq(1L));
    verify(relatedProductDTO).setQuantity(eq(1));
    verify(relatedProductDTO).setType(isA(RelatedProductTypeEnum.class));
    assertNull(actualFindRelatedProductsResult);
  }

  /**
   * Test
   * {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   * <ul>
   *   <li>When {@link RelatedProductDTO} {@link RelatedProductDTO#getQuantity()}
   * return one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  public void testFindRelatedProducts_whenRelatedProductDTOGetQuantityReturnOne_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();
    RelatedProductDTO relatedProductDTO = mock(RelatedProductDTO.class);
    when(relatedProductDTO.getQuantity()).thenReturn(1);
    when(relatedProductDTO.getType()).thenReturn(RelatedProductTypeEnum.CROSS_SALE);
    when(relatedProductDTO.getCategoryId()).thenReturn(null);
    when(relatedProductDTO.getProductId()).thenReturn(null);
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
    verify(relatedProductDTO).getCategoryId();
    verify(relatedProductDTO).getProductId();
    verify(relatedProductDTO).getQuantity();
    verify(relatedProductDTO, atLeast(1)).getType();
    verify(relatedProductDTO).setCategoryId(eq(1L));
    verify(relatedProductDTO).setCumulativeResults(eq(true));
    verify(relatedProductDTO).setProductId(eq(1L));
    verify(relatedProductDTO).setQuantity(eq(1));
    verify(relatedProductDTO).setType(isA(RelatedProductTypeEnum.class));
    assertNull(actualFindRelatedProductsResult);
  }

  /**
   * Test
   * {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}.
   * <ul>
   *   <li>When {@link RelatedProductDTO} {@link RelatedProductDTO#getType()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  public void testFindRelatedProducts_whenRelatedProductDTOGetTypeReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();
    RelatedProductDTO relatedProductDTO = mock(RelatedProductDTO.class);
    when(relatedProductDTO.getType()).thenReturn(null);
    when(relatedProductDTO.getCategoryId()).thenReturn(null);
    when(relatedProductDTO.getProductId()).thenReturn(null);
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
    verify(relatedProductDTO).getCategoryId();
    verify(relatedProductDTO).getProductId();
    verify(relatedProductDTO, atLeast(1)).getType();
    verify(relatedProductDTO).setCategoryId(eq(1L));
    verify(relatedProductDTO).setCumulativeResults(eq(true));
    verify(relatedProductDTO).setProductId(eq(1L));
    verify(relatedProductDTO).setQuantity(eq(1));
    verify(relatedProductDTO).setType(isA(RelatedProductTypeEnum.class));
  }

  /**
   * Test
   * {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildFeaturedProductsList_givenCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    List<? extends PromotableProduct> actualBuildFeaturedProductsListResult = relatedProductsServiceImpl
        .buildFeaturedProductsList(product, category, relatedProductDTO);

    // Assert
    verify(product).getDefaultCategory();
    assertTrue(actualBuildFeaturedProductsListResult.isEmpty());
  }

  /**
   * Test
   * {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor) Id is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildFeaturedProductsList_givenProductBundleImplIdIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setId(1L);
    FeaturedProductImpl featuredProductImpl = mock(FeaturedProductImpl.class);
    when(featuredProductImpl.getRelatedProduct()).thenReturn(productBundleImpl);

    ArrayList<FeaturedProduct> featuredProductList = new ArrayList<>();
    featuredProductList.add(featuredProductImpl);
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
    verify(featuredProductImpl).getRelatedProduct();
    verify(product).getDefaultCategory();
    verify(product).getId();
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
   * Test
   * {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildFeaturedProductsList_thenReturnArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

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
   * Test
   * {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildFeaturedProductsList_thenReturnArrayList2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

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
   * Test
   * {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildFeaturedProductsList_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();
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
   * Test
   * {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildFeaturedProductsList_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();
    FeaturedProductImpl featuredProductImpl = mock(FeaturedProductImpl.class);
    when(featuredProductImpl.getRelatedProduct()).thenReturn(new ProductBundleImpl());

    ArrayList<FeaturedProduct> featuredProductList = new ArrayList<>();
    FeaturedProductImpl featuredProductImpl2 = new FeaturedProductImpl();
    featuredProductList.add(featuredProductImpl2);
    featuredProductList.add(featuredProductImpl);
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
    verify(featuredProductImpl, atLeast(1)).getRelatedProduct();
    verify(product).getDefaultCategory();
    verify(product, atLeast(1)).getId();
    verify(relatedProductDTO).getQuantity();
    verify(relatedProductDTO).isCumulativeResults();
    verify(relatedProductDTO).setCategoryId(eq(1L));
    verify(relatedProductDTO).setCumulativeResults(eq(true));
    verify(relatedProductDTO).setProductId(eq(1L));
    verify(relatedProductDTO).setQuantity(eq(1));
    verify(relatedProductDTO).setType(isA(RelatedProductTypeEnum.class));
    assertEquals(1, actualBuildFeaturedProductsListResult.size());
    assertSame(featuredProductImpl2, actualBuildFeaturedProductsListResult.get(0));
  }

  /**
   * Test
   * {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildFeaturedProductsList_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();
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
   * Test
   * {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildFeaturedProductsList_whenNull_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    assertTrue(relatedProductsServiceImpl.buildFeaturedProductsList(null, category, relatedProductDTO).isEmpty());
  }

  /**
   * Test
   * {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildFeaturedProductsList_whenProductBundleImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    assertNull(relatedProductsServiceImpl.buildFeaturedProductsList(product, category, relatedProductDTO));
  }

  /**
   * Test
   * {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>When {@link RelatedProductDTO} {@link RelatedProductDTO#getQuantity()}
   * return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildFeaturedProductsList_whenRelatedProductDTOGetQuantityReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();
    FeaturedProductImpl featuredProductImpl = mock(FeaturedProductImpl.class);
    when(featuredProductImpl.getRelatedProduct()).thenReturn(new ProductBundleImpl());

    ArrayList<FeaturedProduct> featuredProductList = new ArrayList<>();
    featuredProductList.add(new FeaturedProductImpl());
    featuredProductList.add(featuredProductImpl);
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getFeaturedProducts()).thenReturn(featuredProductList);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getDefaultCategory()).thenReturn(categoryImpl);
    CategoryImpl category = new CategoryImpl();
    RelatedProductDTO relatedProductDTO = mock(RelatedProductDTO.class);
    when(relatedProductDTO.isCumulativeResults()).thenReturn(false);
    when(relatedProductDTO.getQuantity()).thenReturn(null);
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
    verify(featuredProductImpl, atLeast(1)).getRelatedProduct();
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
   * Test
   * {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link ProductImpl#getCumulativeUpSaleProducts()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildUpSaleProductsList_givenArrayList_thenCallsGetCumulativeUpSaleProducts() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getCumulativeUpSaleProducts()).thenReturn(new ArrayList<>());
    CategoryImpl category = new CategoryImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualBuildUpSaleProductsListResult = relatedProductsServiceImpl
        .buildUpSaleProductsList(product, category, relatedProductDTO);

    // Assert
    verify(product).getCumulativeUpSaleProducts();
    assertTrue(actualBuildUpSaleProductsListResult.isEmpty());
  }

  /**
   * Test
   * {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then calls {@link ProductImpl#getUpSaleProducts()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildUpSaleProductsList_givenFalse_thenCallsGetUpSaleProducts() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();
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
   * Test
   * {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor) Id is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildUpSaleProductsList_givenProductBundleImplIdIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setId(1L);
    CrossSaleProductImpl crossSaleProductImpl = mock(CrossSaleProductImpl.class);
    when(crossSaleProductImpl.getRelatedProduct()).thenReturn(productBundleImpl);

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(crossSaleProductImpl);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getCumulativeUpSaleProducts()).thenReturn(relatedProductList);
    CategoryImpl category = new CategoryImpl();
    RelatedProductDTO relatedProductDTO = mock(RelatedProductDTO.class);
    when(relatedProductDTO.isCumulativeResults()).thenReturn(true);
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
    verify(crossSaleProductImpl).getRelatedProduct();
    verify(product).getCumulativeUpSaleProducts();
    verify(product).getId();
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
   * Test
   * {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildUpSaleProductsList_thenReturnArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(new CrossSaleProductImpl());
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getCumulativeUpSaleProducts()).thenReturn(relatedProductList);
    CategoryImpl category = new CategoryImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualBuildUpSaleProductsListResult = relatedProductsServiceImpl
        .buildUpSaleProductsList(product, category, relatedProductDTO);

    // Assert
    verify(product).getCumulativeUpSaleProducts();
    verify(product).getId();
    assertSame(relatedProductList, actualBuildUpSaleProductsListResult);
  }

  /**
   * Test
   * {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildUpSaleProductsList_thenReturnArrayList2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(new CrossSaleProductImpl());
    relatedProductList.add(new CrossSaleProductImpl());
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getCumulativeUpSaleProducts()).thenReturn(relatedProductList);
    CategoryImpl category = new CategoryImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualBuildUpSaleProductsListResult = relatedProductsServiceImpl
        .buildUpSaleProductsList(product, category, relatedProductDTO);

    // Assert
    verify(product).getCumulativeUpSaleProducts();
    verify(product, atLeast(1)).getId();
    assertSame(relatedProductList, actualBuildUpSaleProductsListResult);
  }

  /**
   * Test
   * {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildUpSaleProductsList_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();
    CrossSaleProductImpl crossSaleProductImpl = mock(CrossSaleProductImpl.class);
    when(crossSaleProductImpl.getRelatedProduct()).thenReturn(new ProductBundleImpl());

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    CrossSaleProductImpl crossSaleProductImpl2 = new CrossSaleProductImpl();
    relatedProductList.add(crossSaleProductImpl2);
    relatedProductList.add(crossSaleProductImpl);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getCumulativeUpSaleProducts()).thenReturn(relatedProductList);
    CategoryImpl category = new CategoryImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualBuildUpSaleProductsListResult = relatedProductsServiceImpl
        .buildUpSaleProductsList(product, category, relatedProductDTO);

    // Assert
    verify(crossSaleProductImpl, atLeast(1)).getRelatedProduct();
    verify(product).getCumulativeUpSaleProducts();
    verify(product, atLeast(1)).getId();
    assertEquals(1, actualBuildUpSaleProductsListResult.size());
    assertSame(crossSaleProductImpl2, actualBuildUpSaleProductsListResult.get(0));
  }

  /**
   * Test
   * {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildUpSaleProductsList_whenNull_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    assertTrue(relatedProductsServiceImpl.buildUpSaleProductsList(null, category, relatedProductDTO).isEmpty());
  }

  /**
   * Test
   * {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildUpSaleProductsList_whenProductBundleImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    assertTrue(relatedProductsServiceImpl.buildUpSaleProductsList(product, category, relatedProductDTO).isEmpty());
  }

  /**
   * Test
   * {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>When {@link RelatedProductDTO} {@link RelatedProductDTO#getQuantity()}
   * return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildUpSaleProductsList_whenRelatedProductDTOGetQuantityReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getUpSaleProducts()).thenReturn(new ArrayList<>());
    CategoryImpl category = new CategoryImpl();
    RelatedProductDTO relatedProductDTO = mock(RelatedProductDTO.class);
    when(relatedProductDTO.isCumulativeResults()).thenReturn(false);
    when(relatedProductDTO.getQuantity()).thenReturn(null);
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
   * Test
   * {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildCrossSaleProductsList_givenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getCumulativeCrossSaleProducts()).thenReturn(new ArrayList<>());
    CategoryImpl category = new CategoryImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualBuildCrossSaleProductsListResult = relatedProductsServiceImpl
        .buildCrossSaleProductsList(product, category, relatedProductDTO);

    // Assert
    verify(product).getCumulativeCrossSaleProducts();
    assertTrue(actualBuildCrossSaleProductsListResult.isEmpty());
  }

  /**
   * Test
   * {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then calls {@link ProductImpl#getCrossSaleProducts()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildCrossSaleProductsList_givenFalse_thenCallsGetCrossSaleProducts() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();
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
   * Test
   * {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor) Id is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildCrossSaleProductsList_givenProductBundleImplIdIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setId(1L);
    CrossSaleProductImpl crossSaleProductImpl = mock(CrossSaleProductImpl.class);
    when(crossSaleProductImpl.getRelatedProduct()).thenReturn(productBundleImpl);

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(crossSaleProductImpl);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getCumulativeCrossSaleProducts()).thenReturn(relatedProductList);
    CategoryImpl category = new CategoryImpl();
    RelatedProductDTO relatedProductDTO = mock(RelatedProductDTO.class);
    when(relatedProductDTO.isCumulativeResults()).thenReturn(true);
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
    verify(crossSaleProductImpl).getRelatedProduct();
    verify(product).getCumulativeCrossSaleProducts();
    verify(product).getId();
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
   * Test
   * {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildCrossSaleProductsList_thenReturnArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(new CrossSaleProductImpl());
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getCumulativeCrossSaleProducts()).thenReturn(relatedProductList);
    CategoryImpl category = new CategoryImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualBuildCrossSaleProductsListResult = relatedProductsServiceImpl
        .buildCrossSaleProductsList(product, category, relatedProductDTO);

    // Assert
    verify(product).getCumulativeCrossSaleProducts();
    verify(product).getId();
    assertSame(relatedProductList, actualBuildCrossSaleProductsListResult);
  }

  /**
   * Test
   * {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildCrossSaleProductsList_thenReturnArrayList2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(new CrossSaleProductImpl());
    relatedProductList.add(new CrossSaleProductImpl());
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getCumulativeCrossSaleProducts()).thenReturn(relatedProductList);
    CategoryImpl category = new CategoryImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualBuildCrossSaleProductsListResult = relatedProductsServiceImpl
        .buildCrossSaleProductsList(product, category, relatedProductDTO);

    // Assert
    verify(product).getCumulativeCrossSaleProducts();
    verify(product, atLeast(1)).getId();
    assertSame(relatedProductList, actualBuildCrossSaleProductsListResult);
  }

  /**
   * Test
   * {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildCrossSaleProductsList_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();
    CrossSaleProductImpl crossSaleProductImpl = mock(CrossSaleProductImpl.class);
    when(crossSaleProductImpl.getRelatedProduct()).thenReturn(new ProductBundleImpl());

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    CrossSaleProductImpl crossSaleProductImpl2 = new CrossSaleProductImpl();
    relatedProductList.add(crossSaleProductImpl2);
    relatedProductList.add(crossSaleProductImpl);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getCumulativeCrossSaleProducts()).thenReturn(relatedProductList);
    CategoryImpl category = new CategoryImpl();

    RelatedProductDTO relatedProductDTO = new RelatedProductDTO();
    relatedProductDTO.setCategoryId(1L);
    relatedProductDTO.setCumulativeResults(true);
    relatedProductDTO.setProductId(1L);
    relatedProductDTO.setQuantity(1);
    relatedProductDTO.setType(RelatedProductTypeEnum.CROSS_SALE);

    // Act
    List<? extends PromotableProduct> actualBuildCrossSaleProductsListResult = relatedProductsServiceImpl
        .buildCrossSaleProductsList(product, category, relatedProductDTO);

    // Assert
    verify(crossSaleProductImpl, atLeast(1)).getRelatedProduct();
    verify(product).getCumulativeCrossSaleProducts();
    verify(product, atLeast(1)).getId();
    assertEquals(1, actualBuildCrossSaleProductsListResult.size());
    assertSame(crossSaleProductImpl2, actualBuildCrossSaleProductsListResult.get(0));
  }

  /**
   * Test
   * {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildCrossSaleProductsList_whenNull_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    assertTrue(relatedProductsServiceImpl.buildCrossSaleProductsList(null, category, relatedProductDTO).isEmpty());
  }

  /**
   * Test
   * {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildCrossSaleProductsList_whenProductBundleImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    assertTrue(relatedProductsServiceImpl.buildCrossSaleProductsList(product, category, relatedProductDTO).isEmpty());
  }

  /**
   * Test
   * {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category, RelatedProductDTO)}.
   * <ul>
   *   <li>When {@link RelatedProductDTO} {@link RelatedProductDTO#getQuantity()}
   * return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildCrossSaleProductsList_whenRelatedProductDTOGetQuantityReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getCrossSaleProducts()).thenReturn(new ArrayList<>());
    CategoryImpl category = new CategoryImpl();
    RelatedProductDTO relatedProductDTO = mock(RelatedProductDTO.class);
    when(relatedProductDTO.isCumulativeResults()).thenReturn(false);
    when(relatedProductDTO.getQuantity()).thenReturn(null);
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
   * Test {@link RelatedProductsServiceImpl#resizeList(List, Integer)}.
   * <ul>
   *   <li>Given {@link CrossSaleProductImpl} (default constructor).</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#resizeList(List, Integer)}
   */
  @Test
  public void testResizeList_givenCrossSaleProductImpl_thenReturnArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

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
   * Method under test:
   * {@link RelatedProductsServiceImpl#resizeList(List, Integer)}
   */
  @Test
  public void testResizeList_givenCrossSaleProductImpl_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

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
   *   <li>Given {@link CrossSaleProductImpl}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link CrossSaleProductImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#resizeList(List, Integer)}
   */
  @Test
  public void testResizeList_givenCrossSaleProductImpl_whenArrayListAddCrossSaleProductImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

    ArrayList<PromotableProduct> originalList = new ArrayList<>();
    originalList.add(mock(CrossSaleProductImpl.class));

    // Act and Assert
    assertSame(originalList, relatedProductsServiceImpl.resizeList(originalList, 1));
  }

  /**
   * Test {@link RelatedProductsServiceImpl#resizeList(List, Integer)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#resizeList(List, Integer)}
   */
  @Test
  public void testResizeList_whenArrayList_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

    // Act and Assert
    assertTrue(relatedProductsServiceImpl.resizeList(new ArrayList<>(), 1).isEmpty());
  }

  /**
   * Test {@link RelatedProductsServiceImpl#resizeList(List, Integer)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#resizeList(List, Integer)}
   */
  @Test
  public void testResizeList_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new RelatedProductsServiceImpl()).resizeList(null, null));
    assertNull((new RelatedProductsServiceImpl()).resizeList(null, 1));
  }

  /**
   * Test {@link RelatedProductsServiceImpl#lookupProduct(RelatedProductDTO)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link RelatedProductDTO} (default constructor) ProductId is
   * {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#lookupProduct(RelatedProductDTO)}
   */
  @Test
  public void testLookupProduct_givenNull_whenRelatedProductDTOProductIdIsNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test {@link RelatedProductsServiceImpl#lookupCategory(RelatedProductDTO)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductsServiceImpl#lookupCategory(RelatedProductDTO)}
   */
  @Test
  public void testLookupCategory_givenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
}

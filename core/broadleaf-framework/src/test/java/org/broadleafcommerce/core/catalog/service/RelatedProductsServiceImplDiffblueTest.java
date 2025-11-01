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
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.catalog.domain.Category;
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
import org.mockito.Mockito;

public class RelatedProductsServiceImplDiffblueTest {
  /**
   * Method under test:
   * {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  public void testFindRelatedProducts() {
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
   * Method under test:
   * {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  public void testFindRelatedProducts2() {
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
   * Method under test:
   * {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  public void testFindRelatedProducts3() {
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
   * Method under test:
   * {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  public void testFindRelatedProducts4() {
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
   * Method under test:
   * {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  public void testFindRelatedProducts5() {
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
   * Method under test:
   * {@link RelatedProductsServiceImpl#findRelatedProducts(RelatedProductDTO)}
   */
  @Test
  public void testFindRelatedProducts6() {
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
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildFeaturedProductsList() {
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
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildFeaturedProductsList2() {
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

    // Act
    List<? extends PromotableProduct> actualBuildFeaturedProductsListResult = relatedProductsServiceImpl
        .buildFeaturedProductsList(null, category, relatedProductDTO);

    // Assert
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
    assertTrue(actualBuildFeaturedProductsListResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildFeaturedProductsList3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    CategoryImpl categoryImpl = new CategoryImpl();
    when(product.getDefaultCategory()).thenReturn(categoryImpl);
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
    assertEquals(categoryImpl, category);
  }

  /**
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildFeaturedProductsList4() {
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
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildFeaturedProductsList5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    ArrayList<FeaturedProduct> featuredProductList = new ArrayList<>();
    when(categoryImpl.getFeaturedProducts()).thenReturn(featuredProductList);
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
    assertTrue(actualBuildFeaturedProductsListResult.isEmpty());
    assertSame(featuredProductList, actualBuildFeaturedProductsListResult);
  }

  /**
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildFeaturedProductsList6() {
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
    assertSame(featuredProductList, actualBuildFeaturedProductsListResult);
  }

  /**
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildFeaturedProductsList7() {
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
    assertSame(featuredProductList, actualBuildFeaturedProductsListResult);
  }

  /**
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildFeaturedProductsList8() {
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
    assertSame(featuredProductImpl2, actualBuildFeaturedProductsListResult.get(0));
  }

  /**
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildFeaturedProductsList9() {
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
    assertTrue(actualBuildFeaturedProductsListResult.isEmpty());
    assertSame(featuredProductList, actualBuildFeaturedProductsListResult);
  }

  /**
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildFeaturedProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildFeaturedProductsList10() {
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
    assertSame(featuredProductList, actualBuildFeaturedProductsListResult);
  }

  /**
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildUpSaleProductsList() {
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
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildUpSaleProductsList2() {
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
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildUpSaleProductsList3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
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
    assertTrue(actualBuildUpSaleProductsListResult.isEmpty());
    assertSame(relatedProductList, actualBuildUpSaleProductsListResult);
  }

  /**
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildUpSaleProductsList4() {
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
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildUpSaleProductsList5() {
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
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildUpSaleProductsList6() {
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
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildUpSaleProductsList7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
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
    verify(product).getUpSaleProducts();
    verify(relatedProductDTO).getQuantity();
    verify(relatedProductDTO).isCumulativeResults();
    verify(relatedProductDTO).setCategoryId(eq(1L));
    verify(relatedProductDTO).setCumulativeResults(eq(true));
    verify(relatedProductDTO).setProductId(eq(1L));
    verify(relatedProductDTO).setQuantity(eq(1));
    verify(relatedProductDTO).setType(isA(RelatedProductTypeEnum.class));
    assertTrue(actualBuildUpSaleProductsListResult.isEmpty());
    assertSame(relatedProductList, actualBuildUpSaleProductsListResult);
  }

  /**
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildUpSaleProductsList8() {
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
    assertSame(relatedProductList, actualBuildUpSaleProductsListResult);
  }

  /**
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildUpSaleProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildUpSaleProductsList9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    when(product.getUpSaleProducts()).thenReturn(relatedProductList);
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
    assertSame(relatedProductList, actualBuildUpSaleProductsListResult);
  }

  /**
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildCrossSaleProductsList() {
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
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildCrossSaleProductsList2() {
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
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildCrossSaleProductsList3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
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
    assertTrue(actualBuildCrossSaleProductsListResult.isEmpty());
    assertSame(relatedProductList, actualBuildCrossSaleProductsListResult);
  }

  /**
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildCrossSaleProductsList4() {
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
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildCrossSaleProductsList5() {
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
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildCrossSaleProductsList6() {
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
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildCrossSaleProductsList7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
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
    verify(relatedProductDTO).getQuantity();
    verify(relatedProductDTO).isCumulativeResults();
    verify(relatedProductDTO).setCategoryId(eq(1L));
    verify(relatedProductDTO).setCumulativeResults(eq(true));
    verify(relatedProductDTO).setProductId(eq(1L));
    verify(relatedProductDTO).setQuantity(eq(1));
    verify(relatedProductDTO).setType(isA(RelatedProductTypeEnum.class));
    assertTrue(actualBuildCrossSaleProductsListResult.isEmpty());
    assertSame(relatedProductList, actualBuildCrossSaleProductsListResult);
  }

  /**
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildCrossSaleProductsList8() {
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
    assertSame(relatedProductList, actualBuildCrossSaleProductsListResult);
  }

  /**
   * Method under test:
   * {@link RelatedProductsServiceImpl#buildCrossSaleProductsList(Product, Category, RelatedProductDTO)}
   */
  @Test
  public void testBuildCrossSaleProductsList9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    when(product.getCrossSaleProducts()).thenReturn(relatedProductList);
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
    assertSame(relatedProductList, actualBuildCrossSaleProductsListResult);
  }

  /**
   * Method under test:
   * {@link RelatedProductsServiceImpl#resizeList(List, Integer)}
   */
  @Test
  public void testResizeList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();
    ArrayList<PromotableProduct> originalList = new ArrayList<>();

    // Act
    List<? extends PromotableProduct> actualResizeListResult = relatedProductsServiceImpl.resizeList(originalList, 1);

    // Assert
    assertTrue(actualResizeListResult.isEmpty());
    assertSame(originalList, actualResizeListResult);
  }

  /**
   * Method under test:
   * {@link RelatedProductsServiceImpl#resizeList(List, Integer)}
   */
  @Test
  public void testResizeList2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new RelatedProductsServiceImpl()).resizeList(null, null));
  }

  /**
   * Method under test:
   * {@link RelatedProductsServiceImpl#resizeList(List, Integer)}
   */
  @Test
  public void testResizeList3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new RelatedProductsServiceImpl()).resizeList(null, 1));
  }

  /**
   * Method under test:
   * {@link RelatedProductsServiceImpl#resizeList(List, Integer)}
   */
  @Test
  public void testResizeList4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

    ArrayList<PromotableProduct> originalList = new ArrayList<>();
    originalList.add(new CrossSaleProductImpl());

    // Act and Assert
    assertSame(originalList, relatedProductsServiceImpl.resizeList(originalList, 1));
  }

  /**
   * Method under test:
   * {@link RelatedProductsServiceImpl#resizeList(List, Integer)}
   */
  @Test
  public void testResizeList5() {
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
   * Method under test:
   * {@link RelatedProductsServiceImpl#resizeList(List, Integer)}
   */
  @Test
  public void testResizeList6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelatedProductsServiceImpl relatedProductsServiceImpl = new RelatedProductsServiceImpl();

    ArrayList<PromotableProduct> originalList = new ArrayList<>();
    originalList.add(mock(CrossSaleProductImpl.class));

    // Act
    List<? extends PromotableProduct> actualResizeListResult = relatedProductsServiceImpl.resizeList(originalList, 1);

    // Assert
    assertEquals(1, actualResizeListResult.size());
    assertSame(originalList, actualResizeListResult);
  }

  /**
   * Method under test:
   * {@link RelatedProductsServiceImpl#lookupProduct(RelatedProductDTO)}
   */
  @Test
  public void testLookupProduct() {
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
   * Method under test:
   * {@link RelatedProductsServiceImpl#lookupCategory(RelatedProductDTO)}
   */
  @Test
  public void testLookupCategory() {
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

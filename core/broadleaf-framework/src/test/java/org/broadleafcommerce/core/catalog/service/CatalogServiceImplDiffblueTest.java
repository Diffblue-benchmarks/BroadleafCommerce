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
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.core.catalog.dao.CategoryDaoImpl;
import org.broadleafcommerce.core.catalog.dao.ProductDaoImpl;
import org.broadleafcommerce.core.catalog.dao.SkuDaoImpl;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundle;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuFee;
import org.broadleafcommerce.core.catalog.domain.SkuFeeImpl;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.catalog.service.type.ProductType;
import org.broadleafcommerce.core.search.domain.SearchCriteria;
import org.junit.Test;
import org.mockito.Mockito;

public class CatalogServiceImplDiffblueTest {
  /**
   * Method under test: {@link CatalogServiceImpl#findProductById(Long)}
   */
  @Test
  public void testFindProductById() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductDaoImpl productDao = mock(ProductDaoImpl.class);
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setProductDao(productDao);

    // Act
    Product actualFindProductByIdResult = catalogServiceImpl.findProductById(1L);

    // Assert
    verify(productDao).readProductById(eq(1L));
    assertSame(productBundleImpl, actualFindProductByIdResult);
  }

  /**
   * Method under test: {@link CatalogServiceImpl#findProductByExternalId(String)}
   */
  @Test
  public void testFindProductByExternalId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductDaoImpl productDao = mock(ProductDaoImpl.class);
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    when(productDao.readProductByExternalId(Mockito.<String>any())).thenReturn(productBundleImpl);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setProductDao(productDao);

    // Act
    Product actualFindProductByExternalIdResult = catalogServiceImpl.findProductByExternalId("42");

    // Assert
    verify(productDao).readProductByExternalId(eq("42"));
    assertSame(productBundleImpl, actualFindProductByExternalIdResult);
  }

  /**
   * Method under test: {@link CatalogServiceImpl#findProductsByName(String)}
   */
  @Test
  public void testFindProductsByName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductDaoImpl productDao = mock(ProductDaoImpl.class);
    ArrayList<Product> productList = new ArrayList<>();
    when(productDao.readProductsByName(Mockito.<String>any())).thenReturn(productList);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setProductDao(productDao);

    // Act
    List<Product> actualFindProductsByNameResult = catalogServiceImpl.findProductsByName("Search Name");

    // Assert
    verify(productDao).readProductsByName(eq("Search Name"));
    assertTrue(actualFindProductsByNameResult.isEmpty());
    assertSame(productList, actualFindProductsByNameResult);
  }

  /**
   * Method under test:
   * {@link CatalogServiceImpl#findProductsByName(String, int, int)}
   */
  @Test
  public void testFindProductsByName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductDaoImpl productDao = mock(ProductDaoImpl.class);
    ArrayList<Product> productList = new ArrayList<>();
    when(productDao.readProductsByName(Mockito.<String>any(), anyInt(), anyInt())).thenReturn(productList);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setProductDao(productDao);

    // Act
    List<Product> actualFindProductsByNameResult = catalogServiceImpl.findProductsByName("Search Name", 1, 2);

    // Assert
    verify(productDao).readProductsByName(eq("Search Name"), eq(1), eq(2));
    assertTrue(actualFindProductsByNameResult.isEmpty());
    assertSame(productList, actualFindProductsByNameResult);
  }

  /**
   * Method under test:
   * {@link CatalogServiceImpl#findActiveProductsByCategory(Category)}
   */
  @Test
  public void testFindActiveProductsByCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductDaoImpl productDao = mock(ProductDaoImpl.class);
    ArrayList<Product> productList = new ArrayList<>();
    when(productDao.readActiveProductsByCategory(Mockito.<Long>any())).thenReturn(productList);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setProductDao(productDao);
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getId()).thenReturn(1L);

    // Act
    List<Product> actualFindActiveProductsByCategoryResult = catalogServiceImpl.findActiveProductsByCategory(category);

    // Assert
    verify(productDao).readActiveProductsByCategory(eq(1L));
    verify(category).getId();
    assertTrue(actualFindActiveProductsByCategoryResult.isEmpty());
    assertSame(productList, actualFindActiveProductsByCategoryResult);
  }

  /**
   * Method under test:
   * {@link CatalogServiceImpl#findActiveProductsByCategory(Category, int, int)}
   */
  @Test
  public void testFindActiveProductsByCategory2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductDaoImpl productDao = mock(ProductDaoImpl.class);
    ArrayList<Product> productList = new ArrayList<>();
    when(productDao.readActiveProductsByCategory(Mockito.<Long>any(), anyInt(), anyInt())).thenReturn(productList);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setProductDao(productDao);
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getId()).thenReturn(1L);

    // Act
    List<Product> actualFindActiveProductsByCategoryResult = catalogServiceImpl.findActiveProductsByCategory(category,
        1, 2);

    // Assert
    verify(productDao).readActiveProductsByCategory(eq(1L), eq(1), eq(2));
    verify(category).getId();
    assertTrue(actualFindActiveProductsByCategoryResult.isEmpty());
    assertSame(productList, actualFindActiveProductsByCategoryResult);
  }

  /**
   * Method under test:
   * {@link CatalogServiceImpl#findActiveProductsByCategory(Category, Date)}
   */
  @Test
  public void testFindActiveProductsByCategory3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductDaoImpl productDao = mock(ProductDaoImpl.class);
    ArrayList<Product> productList = new ArrayList<>();
    when(productDao.readActiveProductsByCategory(Mockito.<Long>any(), Mockito.<Date>any())).thenReturn(productList);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setProductDao(productDao);
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getId()).thenReturn(1L);

    // Act
    List<Product> actualFindActiveProductsByCategoryResult = catalogServiceImpl.findActiveProductsByCategory(category,
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    verify(productDao).readActiveProductsByCategory(eq(1L), isA(Date.class));
    verify(category).getId();
    assertTrue(actualFindActiveProductsByCategoryResult.isEmpty());
    assertSame(productList, actualFindActiveProductsByCategoryResult);
  }

  /**
   * Method under test:
   * {@link CatalogServiceImpl#findActiveProductsByCategory(Category, Date, int, int)}
   */
  @Test
  public void testFindActiveProductsByCategory4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductDaoImpl productDao = mock(ProductDaoImpl.class);
    ArrayList<Product> productList = new ArrayList<>();
    when(productDao.readActiveProductsByCategory(Mockito.<Long>any(), Mockito.<Date>any(), anyInt(), anyInt()))
        .thenReturn(productList);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setProductDao(productDao);
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getId()).thenReturn(1L);

    // Act
    List<Product> actualFindActiveProductsByCategoryResult = catalogServiceImpl.findActiveProductsByCategory(category,
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()), 1, 2);

    // Assert
    verify(productDao).readActiveProductsByCategory(eq(1L), isA(Date.class), eq(1), eq(2));
    verify(category).getId();
    assertTrue(actualFindActiveProductsByCategoryResult.isEmpty());
    assertSame(productList, actualFindActiveProductsByCategoryResult);
  }

  /**
   * Method under test:
   * {@link CatalogServiceImpl#findFilteredActiveProductsByCategory(Category, Date, SearchCriteria)}
   */
  @Test
  public void testFindFilteredActiveProductsByCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductDaoImpl productDao = mock(ProductDaoImpl.class);
    ArrayList<Product> productList = new ArrayList<>();
    when(productDao.readFilteredActiveProductsByCategory(Mockito.<Long>any(), Mockito.<Date>any(),
        Mockito.<SearchCriteria>any())).thenReturn(productList);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setProductDao(productDao);
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getId()).thenReturn(1L);
    Date currentDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    List<Product> actualFindFilteredActiveProductsByCategoryResult = catalogServiceImpl
        .findFilteredActiveProductsByCategory(category, currentDate, new SearchCriteria());

    // Assert
    verify(productDao).readFilteredActiveProductsByCategory(eq(1L), isA(Date.class), isA(SearchCriteria.class));
    verify(category).getId();
    assertTrue(actualFindFilteredActiveProductsByCategoryResult.isEmpty());
    assertSame(productList, actualFindFilteredActiveProductsByCategoryResult);
  }

  /**
   * Method under test:
   * {@link CatalogServiceImpl#findFilteredActiveProductsByCategory(Category, SearchCriteria)}
   */
  @Test
  public void testFindFilteredActiveProductsByCategory2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductDaoImpl productDao = mock(ProductDaoImpl.class);
    ArrayList<Product> productList = new ArrayList<>();
    when(productDao.readFilteredActiveProductsByCategory(Mockito.<Long>any(), Mockito.<SearchCriteria>any()))
        .thenReturn(productList);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setProductDao(productDao);
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getId()).thenReturn(1L);

    // Act
    List<Product> actualFindFilteredActiveProductsByCategoryResult = catalogServiceImpl
        .findFilteredActiveProductsByCategory(category, new SearchCriteria());

    // Assert
    verify(productDao).readFilteredActiveProductsByCategory(eq(1L), isA(SearchCriteria.class));
    verify(category).getId();
    assertTrue(actualFindFilteredActiveProductsByCategoryResult.isEmpty());
    assertSame(productList, actualFindFilteredActiveProductsByCategoryResult);
  }

  /**
   * Method under test:
   * {@link CatalogServiceImpl#findFilteredActiveProductsByQuery(String, Date, SearchCriteria)}
   */
  @Test
  public void testFindFilteredActiveProductsByQuery() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductDaoImpl productDao = mock(ProductDaoImpl.class);
    ArrayList<Product> productList = new ArrayList<>();
    when(productDao.readFilteredActiveProductsByQuery(Mockito.<String>any(), Mockito.<Date>any(),
        Mockito.<SearchCriteria>any())).thenReturn(productList);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setProductDao(productDao);
    Date currentDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    List<Product> actualFindFilteredActiveProductsByQueryResult = catalogServiceImpl
        .findFilteredActiveProductsByQuery("Query", currentDate, new SearchCriteria());

    // Assert
    verify(productDao).readFilteredActiveProductsByQuery(eq("Query"), isA(Date.class), isA(SearchCriteria.class));
    assertTrue(actualFindFilteredActiveProductsByQueryResult.isEmpty());
    assertSame(productList, actualFindFilteredActiveProductsByQueryResult);
  }

  /**
   * Method under test:
   * {@link CatalogServiceImpl#findFilteredActiveProductsByQuery(String, SearchCriteria)}
   */
  @Test
  public void testFindFilteredActiveProductsByQuery2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductDaoImpl productDao = mock(ProductDaoImpl.class);
    ArrayList<Product> productList = new ArrayList<>();
    when(productDao.readFilteredActiveProductsByQuery(Mockito.<String>any(), Mockito.<SearchCriteria>any()))
        .thenReturn(productList);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setProductDao(productDao);

    // Act
    List<Product> actualFindFilteredActiveProductsByQueryResult = catalogServiceImpl
        .findFilteredActiveProductsByQuery("Query", new SearchCriteria());

    // Assert
    verify(productDao).readFilteredActiveProductsByQuery(eq("Query"), isA(SearchCriteria.class));
    assertTrue(actualFindFilteredActiveProductsByQueryResult.isEmpty());
    assertSame(productList, actualFindFilteredActiveProductsByQueryResult);
  }

  /**
   * Method under test: {@link CatalogServiceImpl#findAutomaticProductBundles()}
   */
  @Test
  public void testFindAutomaticProductBundles() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductDaoImpl productDao = mock(ProductDaoImpl.class);
    ArrayList<ProductBundle> productBundleList = new ArrayList<>();
    when(productDao.readAutomaticProductBundles()).thenReturn(productBundleList);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setProductDao(productDao);

    // Act
    List<ProductBundle> actualFindAutomaticProductBundlesResult = catalogServiceImpl.findAutomaticProductBundles();

    // Assert
    verify(productDao).readAutomaticProductBundles();
    assertTrue(actualFindAutomaticProductBundlesResult.isEmpty());
    assertSame(productBundleList, actualFindAutomaticProductBundlesResult);
  }

  /**
   * Method under test: {@link CatalogServiceImpl#findAutomaticProductBundles()}
   */
  @Test
  public void testFindAutomaticProductBundles2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<ProductBundle> productBundleList = new ArrayList<>();
    productBundleList.add(new ProductBundleImpl());
    productBundleList.add(new ProductBundleImpl());
    ProductDaoImpl productDao = mock(ProductDaoImpl.class);
    when(productDao.readAutomaticProductBundles()).thenReturn(productBundleList);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setProductDao(productDao);

    // Act
    List<ProductBundle> actualFindAutomaticProductBundlesResult = catalogServiceImpl.findAutomaticProductBundles();

    // Assert
    verify(productDao).readAutomaticProductBundles();
    assertSame(productBundleList, actualFindAutomaticProductBundlesResult);
  }

  /**
   * Method under test: {@link CatalogServiceImpl#saveProduct(Product)}
   */
  @Test
  public void testSaveProduct() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductDaoImpl productDao = mock(ProductDaoImpl.class);
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    when(productDao.save(Mockito.<Product>any())).thenReturn(productBundleImpl);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setProductDao(productDao);

    // Act
    Product actualSaveProductResult = catalogServiceImpl.saveProduct(new ProductBundleImpl());

    // Assert
    verify(productDao).save(isA(Product.class));
    assertSame(productBundleImpl, actualSaveProductResult);
  }

  /**
   * Method under test: {@link CatalogServiceImpl#findCategoryById(Long)}
   */
  @Test
  public void testFindCategoryById() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    CategoryImpl categoryImpl = new CategoryImpl();
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(categoryImpl);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setCategoryDao(categoryDao);

    // Act
    Category actualFindCategoryByIdResult = catalogServiceImpl.findCategoryById(1L);

    // Assert
    verify(categoryDao).readCategoryById(eq(1L));
    assertSame(categoryImpl, actualFindCategoryByIdResult);
  }

  /**
   * Method under test:
   * {@link CatalogServiceImpl#findCategoryByExternalId(String)}
   */
  @Test
  public void testFindCategoryByExternalId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    CategoryImpl categoryImpl = new CategoryImpl();
    when(categoryDao.readCategoryByExternalId(Mockito.<String>any())).thenReturn(categoryImpl);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setCategoryDao(categoryDao);

    // Act
    Category actualFindCategoryByExternalIdResult = catalogServiceImpl.findCategoryByExternalId("42");

    // Assert
    verify(categoryDao).readCategoryByExternalId(eq("42"));
    assertSame(categoryImpl, actualFindCategoryByExternalIdResult);
  }

  /**
   * Method under test: {@link CatalogServiceImpl#findCategoryByName(String)}
   */
  @Test
  public void testFindCategoryByName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    CategoryImpl categoryImpl = new CategoryImpl();
    when(categoryDao.readCategoryByName(Mockito.<String>any())).thenReturn(categoryImpl);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setCategoryDao(categoryDao);

    // Act
    Category actualFindCategoryByNameResult = catalogServiceImpl.findCategoryByName("Category Name");

    // Assert
    verify(categoryDao).readCategoryByName(eq("Category Name"));
    assertSame(categoryImpl, actualFindCategoryByNameResult);
  }

  /**
   * Method under test: {@link CatalogServiceImpl#findCategoriesByName(String)}
   */
  @Test
  public void testFindCategoriesByName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    ArrayList<Category> categoryList = new ArrayList<>();
    when(categoryDao.readCategoriesByName(Mockito.<String>any())).thenReturn(categoryList);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setCategoryDao(categoryDao);

    // Act
    List<Category> actualFindCategoriesByNameResult = catalogServiceImpl.findCategoriesByName("Category Name");

    // Assert
    verify(categoryDao).readCategoriesByName(eq("Category Name"));
    assertTrue(actualFindCategoriesByNameResult.isEmpty());
    assertSame(categoryList, actualFindCategoriesByNameResult);
  }

  /**
   * Method under test:
   * {@link CatalogServiceImpl#findCategoriesByName(String, int, int)}
   */
  @Test
  public void testFindCategoriesByName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    ArrayList<Category> categoryList = new ArrayList<>();
    when(categoryDao.readCategoriesByName(Mockito.<String>any(), anyInt(), anyInt())).thenReturn(categoryList);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setCategoryDao(categoryDao);

    // Act
    List<Category> actualFindCategoriesByNameResult = catalogServiceImpl.findCategoriesByName("Category Name", 1, 2);

    // Assert
    verify(categoryDao).readCategoriesByName(eq("Category Name"), eq(1), eq(2));
    assertTrue(actualFindCategoriesByNameResult.isEmpty());
    assertSame(categoryList, actualFindCategoriesByNameResult);
  }

  /**
   * Method under test: {@link CatalogServiceImpl#saveCategory(Category)}
   */
  @Test
  public void testSaveCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    CategoryImpl categoryImpl = new CategoryImpl();
    when(categoryDao.save(Mockito.<Category>any())).thenReturn(categoryImpl);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setCategoryDao(categoryDao);

    // Act
    Category actualSaveCategoryResult = catalogServiceImpl.saveCategory(new CategoryImpl());

    // Assert
    verify(categoryDao).save(isA(Category.class));
    assertSame(categoryImpl, actualSaveCategoryResult);
  }

  /**
   * Method under test: {@link CatalogServiceImpl#removeCategory(Category)}
   */
  @Test
  public void testRemoveCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    doNothing().when(categoryDao).delete(Mockito.<Category>any());

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setCategoryDao(categoryDao);

    // Act
    catalogServiceImpl.removeCategory(new CategoryImpl());

    // Assert
    verify(categoryDao).delete(isA(Category.class));
  }

  /**
   * Method under test: {@link CatalogServiceImpl#removeSku(Sku)}
   */
  @Test
  public void testRemoveSku() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuDaoImpl skuDao = mock(SkuDaoImpl.class);
    doNothing().when(skuDao).delete(Mockito.<Sku>any());

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setSkuDao(skuDao);

    // Act
    catalogServiceImpl.removeSku(new SkuImpl());

    // Assert
    verify(skuDao).delete(isA(Sku.class));
  }

  /**
   * Method under test: {@link CatalogServiceImpl#removeProduct(Product)}
   */
  @Test
  public void testRemoveProduct() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductDaoImpl productDao = mock(ProductDaoImpl.class);
    doNothing().when(productDao).delete(Mockito.<Product>any());

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setProductDao(productDao);

    // Act
    catalogServiceImpl.removeProduct(new ProductBundleImpl());

    // Assert
    verify(productDao).delete(isA(Product.class));
  }

  /**
   * Method under test: {@link CatalogServiceImpl#findAllCategories()}
   */
  @Test
  public void testFindAllCategories() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    ArrayList<Category> categoryList = new ArrayList<>();
    when(categoryDao.readAllCategories()).thenReturn(categoryList);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setCategoryDao(categoryDao);

    // Act
    List<Category> actualFindAllCategoriesResult = catalogServiceImpl.findAllCategories();

    // Assert
    verify(categoryDao).readAllCategories();
    assertTrue(actualFindAllCategoriesResult.isEmpty());
    assertSame(categoryList, actualFindAllCategoriesResult);
  }

  /**
   * Method under test: {@link CatalogServiceImpl#findAllCategories(int, int)}
   */
  @Test
  public void testFindAllCategories2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    ArrayList<Category> categoryList = new ArrayList<>();
    when(categoryDao.readAllCategories(anyInt(), anyInt())).thenReturn(categoryList);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setCategoryDao(categoryDao);

    // Act
    List<Category> actualFindAllCategoriesResult = catalogServiceImpl.findAllCategories(1, 2);

    // Assert
    verify(categoryDao).readAllCategories(eq(1), eq(2));
    assertTrue(actualFindAllCategoriesResult.isEmpty());
    assertSame(categoryList, actualFindAllCategoriesResult);
  }

  /**
   * Method under test: {@link CatalogServiceImpl#findTotalCategoryCount()}
   */
  @Test
  public void testFindTotalCategoryCount() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    when(categoryDao.readTotalCategoryCount()).thenReturn(3L);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setCategoryDao(categoryDao);

    // Act
    Long actualFindTotalCategoryCountResult = catalogServiceImpl.findTotalCategoryCount();

    // Assert
    verify(categoryDao).readTotalCategoryCount();
    assertEquals(3L, actualFindTotalCategoryCountResult.longValue());
  }

  /**
   * Method under test: {@link CatalogServiceImpl#findAllSubCategories(Category)}
   */
  @Test
  public void testFindAllSubCategories() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    ArrayList<Category> categoryList = new ArrayList<>();
    when(categoryDao.readAllSubCategories(Mockito.<Category>any())).thenReturn(categoryList);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setCategoryDao(categoryDao);

    // Act
    List<Category> actualFindAllSubCategoriesResult = catalogServiceImpl.findAllSubCategories(new CategoryImpl());

    // Assert
    verify(categoryDao).readAllSubCategories(isA(Category.class));
    assertTrue(actualFindAllSubCategoriesResult.isEmpty());
    assertSame(categoryList, actualFindAllSubCategoriesResult);
  }

  /**
   * Method under test:
   * {@link CatalogServiceImpl#findAllSubCategories(Category, int, int)}
   */
  @Test
  public void testFindAllSubCategories2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    ArrayList<Category> categoryList = new ArrayList<>();
    when(categoryDao.readAllSubCategories(Mockito.<Category>any(), anyInt(), anyInt())).thenReturn(categoryList);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setCategoryDao(categoryDao);

    // Act
    List<Category> actualFindAllSubCategoriesResult = catalogServiceImpl.findAllSubCategories(new CategoryImpl(), 1, 2);

    // Assert
    verify(categoryDao).readAllSubCategories(isA(Category.class), eq(1), eq(2));
    assertTrue(actualFindAllSubCategoriesResult.isEmpty());
    assertSame(categoryList, actualFindAllSubCategoriesResult);
  }

  /**
   * Method under test:
   * {@link CatalogServiceImpl#findActiveSubCategoriesByCategory(Category)}
   */
  @Test
  public void testFindActiveSubCategoriesByCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    ArrayList<Category> categoryList = new ArrayList<>();
    when(categoryDao.readActiveSubCategoriesByCategory(Mockito.<Category>any())).thenReturn(categoryList);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setCategoryDao(categoryDao);

    // Act
    List<Category> actualFindActiveSubCategoriesByCategoryResult = catalogServiceImpl
        .findActiveSubCategoriesByCategory(new CategoryImpl());

    // Assert
    verify(categoryDao).readActiveSubCategoriesByCategory(isA(Category.class));
    assertTrue(actualFindActiveSubCategoriesByCategoryResult.isEmpty());
    assertSame(categoryList, actualFindActiveSubCategoriesByCategoryResult);
  }

  /**
   * Method under test:
   * {@link CatalogServiceImpl#findActiveSubCategoriesByCategory(Category, int, int)}
   */
  @Test
  public void testFindActiveSubCategoriesByCategory2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    ArrayList<Category> categoryList = new ArrayList<>();
    when(categoryDao.readActiveSubCategoriesByCategory(Mockito.<Category>any(), anyInt(), anyInt()))
        .thenReturn(categoryList);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setCategoryDao(categoryDao);

    // Act
    List<Category> actualFindActiveSubCategoriesByCategoryResult = catalogServiceImpl
        .findActiveSubCategoriesByCategory(new CategoryImpl(), 1, 2);

    // Assert
    verify(categoryDao).readActiveSubCategoriesByCategory(isA(Category.class), eq(1), eq(2));
    assertTrue(actualFindActiveSubCategoriesByCategoryResult.isEmpty());
    assertSame(categoryList, actualFindActiveSubCategoriesByCategoryResult);
  }

  /**
   * Method under test: {@link CatalogServiceImpl#findAllProducts()}
   */
  @Test
  public void testFindAllProducts() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    ArrayList<Product> productList = new ArrayList<>();
    when(categoryDao.readAllProducts()).thenReturn(productList);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setCategoryDao(categoryDao);

    // Act
    List<Product> actualFindAllProductsResult = catalogServiceImpl.findAllProducts();

    // Assert
    verify(categoryDao).readAllProducts();
    assertTrue(actualFindAllProductsResult.isEmpty());
    assertSame(productList, actualFindAllProductsResult);
  }

  /**
   * Method under test: {@link CatalogServiceImpl#findAllProducts(int, int)}
   */
  @Test
  public void testFindAllProducts2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    ArrayList<Product> productList = new ArrayList<>();
    when(categoryDao.readAllProducts(anyInt(), anyInt())).thenReturn(productList);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setCategoryDao(categoryDao);

    // Act
    List<Product> actualFindAllProductsResult = catalogServiceImpl.findAllProducts(1, 2);

    // Assert
    verify(categoryDao).readAllProducts(eq(1), eq(2));
    assertTrue(actualFindAllProductsResult.isEmpty());
    assertSame(productList, actualFindAllProductsResult);
  }

  /**
   * Method under test: {@link CatalogServiceImpl#findAllSkus()}
   */
  @Test
  public void testFindAllSkus() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuDaoImpl skuDao = mock(SkuDaoImpl.class);
    ArrayList<Sku> skuList = new ArrayList<>();
    when(skuDao.readAllSkus()).thenReturn(skuList);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setSkuDao(skuDao);

    // Act
    List<Sku> actualFindAllSkusResult = catalogServiceImpl.findAllSkus();

    // Assert
    verify(skuDao).readAllSkus();
    assertTrue(actualFindAllSkusResult.isEmpty());
    assertSame(skuList, actualFindAllSkusResult);
  }

  /**
   * Method under test: {@link CatalogServiceImpl#findAllSkus(int, int)}
   */
  @Test
  public void testFindAllSkus2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuDaoImpl skuDao = mock(SkuDaoImpl.class);
    ArrayList<Sku> skuList = new ArrayList<>();
    when(skuDao.readAllSkus(anyInt(), anyInt())).thenReturn(skuList);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setSkuDao(skuDao);

    // Act
    List<Sku> actualFindAllSkusResult = catalogServiceImpl.findAllSkus(2, 1);

    // Assert
    verify(skuDao).readAllSkus(eq(2), eq(1));
    assertTrue(actualFindAllSkusResult.isEmpty());
    assertSame(skuList, actualFindAllSkusResult);
  }

  /**
   * Method under test: {@link CatalogServiceImpl#findSkuById(Long)}
   */
  @Test
  public void testFindSkuById() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuDaoImpl skuDao = mock(SkuDaoImpl.class);
    SkuImpl skuImpl = new SkuImpl();
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(skuImpl);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setSkuDao(skuDao);

    // Act
    Sku actualFindSkuByIdResult = catalogServiceImpl.findSkuById(1L);

    // Assert
    verify(skuDao).readSkuById(eq(1L));
    assertSame(skuImpl, actualFindSkuByIdResult);
  }

  /**
   * Method under test: {@link CatalogServiceImpl#findSkuByExternalId(String)}
   */
  @Test
  public void testFindSkuByExternalId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuDaoImpl skuDao = mock(SkuDaoImpl.class);
    SkuImpl skuImpl = new SkuImpl();
    when(skuDao.readSkuByExternalId(Mockito.<String>any())).thenReturn(skuImpl);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setSkuDao(skuDao);

    // Act
    Sku actualFindSkuByExternalIdResult = catalogServiceImpl.findSkuByExternalId("42");

    // Assert
    verify(skuDao).readSkuByExternalId(eq("42"));
    assertSame(skuImpl, actualFindSkuByExternalIdResult);
  }

  /**
   * Method under test: {@link CatalogServiceImpl#findSkuByUpc(String)}
   */
  @Test
  public void testFindSkuByUpc() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuDaoImpl skuDao = mock(SkuDaoImpl.class);
    SkuImpl skuImpl = new SkuImpl();
    when(skuDao.readSkuByUpc(Mockito.<String>any())).thenReturn(skuImpl);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setSkuDao(skuDao);

    // Act
    Sku actualFindSkuByUpcResult = catalogServiceImpl.findSkuByUpc("Upc");

    // Assert
    verify(skuDao).readSkuByUpc(eq("Upc"));
    assertSame(skuImpl, actualFindSkuByUpcResult);
  }

  /**
   * Method under test: {@link CatalogServiceImpl#saveSku(Sku)}
   */
  @Test
  public void testSaveSku() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuDaoImpl skuDao = mock(SkuDaoImpl.class);
    SkuImpl skuImpl = new SkuImpl();
    when(skuDao.save(Mockito.<Sku>any())).thenReturn(skuImpl);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setSkuDao(skuDao);

    // Act
    Sku actualSaveSkuResult = catalogServiceImpl.saveSku(new SkuImpl());

    // Assert
    verify(skuDao).save(isA(Sku.class));
    assertSame(skuImpl, actualSaveSkuResult);
  }

  /**
   * Method under test: {@link CatalogServiceImpl#saveSkuFee(SkuFee)}
   */
  @Test
  public void testSaveSkuFee() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuDaoImpl skuDao = mock(SkuDaoImpl.class);
    SkuFeeImpl skuFeeImpl = new SkuFeeImpl();
    when(skuDao.saveSkuFee(Mockito.<SkuFee>any())).thenReturn(skuFeeImpl);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setSkuDao(skuDao);

    // Act
    SkuFee actualSaveSkuFeeResult = catalogServiceImpl.saveSkuFee(new SkuFeeImpl());

    // Assert
    verify(skuDao).saveSkuFee(isA(SkuFee.class));
    assertSame(skuFeeImpl, actualSaveSkuFeeResult);
  }

  /**
   * Method under test: {@link CatalogServiceImpl#findSkusByIds(List)}
   */
  @Test
  public void testFindSkusByIds() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setSkuDao(new SkuDaoImpl());

    // Act and Assert
    assertNull(catalogServiceImpl.findSkusByIds(new ArrayList<>()));
  }

  /**
   * Method under test: {@link CatalogServiceImpl#findSkusByIds(List)}
   */
  @Test
  public void testFindSkusByIds2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuDaoImpl skuDao = mock(SkuDaoImpl.class);
    ArrayList<Sku> skuList = new ArrayList<>();
    when(skuDao.readSkusByIds(Mockito.<List<Long>>any())).thenReturn(skuList);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setSkuDao(skuDao);

    // Act
    List<Sku> actualFindSkusByIdsResult = catalogServiceImpl.findSkusByIds(new ArrayList<>());

    // Assert
    verify(skuDao).readSkusByIds(isA(List.class));
    assertTrue(actualFindSkusByIdsResult.isEmpty());
    assertSame(skuList, actualFindSkusByIdsResult);
  }

  /**
   * Method under test:
   * {@link CatalogServiceImpl#findProductsForCategory(Category)}
   */
  @Test
  public void testFindProductsForCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductDaoImpl productDao = mock(ProductDaoImpl.class);
    ArrayList<Product> productList = new ArrayList<>();
    when(productDao.readProductsByCategory(Mockito.<Long>any())).thenReturn(productList);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setProductDao(productDao);
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getId()).thenReturn(1L);

    // Act
    List<Product> actualFindProductsForCategoryResult = catalogServiceImpl.findProductsForCategory(category);

    // Assert
    verify(productDao).readProductsByCategory(eq(1L));
    verify(category).getId();
    assertTrue(actualFindProductsForCategoryResult.isEmpty());
    assertSame(productList, actualFindProductsForCategoryResult);
  }

  /**
   * Method under test:
   * {@link CatalogServiceImpl#findProductsForCategory(Category, int, int)}
   */
  @Test
  public void testFindProductsForCategory2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductDaoImpl productDao = mock(ProductDaoImpl.class);
    ArrayList<Product> productList = new ArrayList<>();
    when(productDao.readProductsByCategory(Mockito.<Long>any(), anyInt(), anyInt())).thenReturn(productList);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setProductDao(productDao);
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getId()).thenReturn(1L);

    // Act
    List<Product> actualFindProductsForCategoryResult = catalogServiceImpl.findProductsForCategory(category, 1, 2);

    // Assert
    verify(productDao).readProductsByCategory(eq(1L), eq(1), eq(2));
    verify(category).getId();
    assertTrue(actualFindProductsForCategoryResult.isEmpty());
    assertSame(productList, actualFindProductsForCategoryResult);
  }

  /**
   * Method under test:
   * {@link CatalogServiceImpl#getChildCategoryURLMapByCategoryId(Long)}
   */
  @Test
  public void testGetChildCategoryURLMapByCategoryId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(null);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setCategoryDao(categoryDao);

    // Act
    Map<String, List<Long>> actualChildCategoryURLMapByCategoryId = catalogServiceImpl
        .getChildCategoryURLMapByCategoryId(1L);

    // Assert
    verify(categoryDao).readCategoryById(eq(1L));
    assertNull(actualChildCategoryURLMapByCategoryId);
  }

  /**
   * Method under test:
   * {@link CatalogServiceImpl#getChildCategoryURLMapByCategoryId(Long)}
   */
  @Test
  public void testGetChildCategoryURLMapByCategoryId2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    HashMap<String, List<Long>> stringListMap = new HashMap<>();
    when(categoryImpl.getChildCategoryURLMap()).thenReturn(stringListMap);
    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(categoryImpl);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setCategoryDao(categoryDao);

    // Act
    Map<String, List<Long>> actualChildCategoryURLMapByCategoryId = catalogServiceImpl
        .getChildCategoryURLMapByCategoryId(1L);

    // Assert
    verify(categoryDao).readCategoryById(eq(1L));
    verify(categoryImpl).getChildCategoryURLMap();
    assertTrue(actualChildCategoryURLMapByCategoryId.isEmpty());
    assertSame(stringListMap, actualChildCategoryURLMapByCategoryId);
  }

  /**
   * Method under test: {@link CatalogServiceImpl#createCategory()}
   */
  @Test
  public void testCreateCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    CategoryImpl categoryImpl = new CategoryImpl();
    when(categoryDao.create()).thenReturn(categoryImpl);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setCategoryDao(categoryDao);

    // Act
    Category actualCreateCategoryResult = catalogServiceImpl.createCategory();

    // Assert
    verify(categoryDao).create();
    assertSame(categoryImpl, actualCreateCategoryResult);
  }

  /**
   * Method under test: {@link CatalogServiceImpl#createSku()}
   */
  @Test
  public void testCreateSku() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuDaoImpl skuDao = mock(SkuDaoImpl.class);
    SkuImpl skuImpl = new SkuImpl();
    when(skuDao.create()).thenReturn(skuImpl);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setSkuDao(skuDao);

    // Act
    Sku actualCreateSkuResult = catalogServiceImpl.createSku();

    // Assert
    verify(skuDao).create();
    assertSame(skuImpl, actualCreateSkuResult);
  }

  /**
   * Method under test: {@link CatalogServiceImpl#createProduct(ProductType)}
   */
  @Test
  public void testCreateProduct() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductDaoImpl productDao = mock(ProductDaoImpl.class);
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    when(productDao.create(Mockito.<ProductType>any())).thenReturn(productBundleImpl);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setProductDao(productDao);

    // Act
    Product actualCreateProductResult = catalogServiceImpl.createProduct(ProductType.BUNDLE);

    // Assert
    verify(productDao).create(isA(ProductType.class));
    assertSame(productBundleImpl, actualCreateProductResult);
  }

  /**
   * Method under test: {@link CatalogServiceImpl#createCatalogContextDTO()}
   */
  @Test
  public void testCreateCatalogContextDTO() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CatalogServiceImpl()).createCatalogContextDTO().getAttributes().isEmpty());
  }

  /**
   * Method under test: {@link CatalogServiceImpl#createCatalogContextDTO()}
   */
  @Test
  public void testCreateCatalogContextDTO2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setProductDao(mock(ProductDaoImpl.class));

    // Act and Assert
    assertTrue(catalogServiceImpl.createCatalogContextDTO().getAttributes().isEmpty());
  }

  /**
   * Method under test: {@link CatalogServiceImpl#findCategoryByURI(String)}
   */
  @Test
  public void testFindCategoryByURI() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    CategoryImpl categoryImpl = new CategoryImpl();
    when(categoryDao.findCategoryByURI(Mockito.<String>any())).thenReturn(categoryImpl);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setCategoryDao(categoryDao);

    // Act
    Category actualFindCategoryByURIResult = catalogServiceImpl.findCategoryByURI("Uri");

    // Assert
    verify(categoryDao).findCategoryByURI(eq("Uri"));
    assertSame(categoryImpl, actualFindCategoryByURIResult);
  }

  /**
   * Method under test:
   * {@link CatalogServiceImpl#findOriginalCategoryByURI(String)}
   */
  @Test
  public void testFindOriginalCategoryByURI() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    CategoryImpl categoryImpl = new CategoryImpl();
    when(categoryDao.findCategoryByURI(Mockito.<String>any())).thenReturn(categoryImpl);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setCategoryDao(categoryDao);

    // Act
    Category actualFindOriginalCategoryByURIResult = catalogServiceImpl.findOriginalCategoryByURI("Uri");

    // Assert
    verify(categoryDao).findCategoryByURI(eq("Uri"));
    assertSame(categoryImpl, actualFindOriginalCategoryByURIResult);
  }

  /**
   * Method under test: {@link CatalogServiceImpl#findProductByURI(String)}
   */
  @Test
  public void testFindProductByURI() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductDaoImpl productDao = mock(ProductDaoImpl.class);
    when(productDao.findProductByURI(Mockito.<String>any())).thenReturn(new ArrayList<>());

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setProductDao(productDao);

    // Act
    Product actualFindProductByURIResult = catalogServiceImpl.findProductByURI("Uri");

    // Assert
    verify(productDao).findProductByURI(eq("Uri"));
    assertNull(actualFindProductByURIResult);
  }

  /**
   * Method under test: {@link CatalogServiceImpl#findProductByURI(String)}
   */
  @Test
  public void testFindProductByURI2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<Product> productList = new ArrayList<>();
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productList.add(productBundleImpl);
    ProductDaoImpl productDao = mock(ProductDaoImpl.class);
    when(productDao.findProductByURI(Mockito.<String>any())).thenReturn(productList);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setProductDao(productDao);

    // Act
    Product actualFindProductByURIResult = catalogServiceImpl.findProductByURI("Uri");

    // Assert
    verify(productDao).findProductByURI(eq("Uri"));
    assertSame(productBundleImpl, actualFindProductByURIResult);
  }

  /**
   * Method under test: {@link CatalogServiceImpl#findProductByURI(String)}
   */
  @Test
  public void testFindProductByURI3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<Product> productList = new ArrayList<>();
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productList.add(productBundleImpl);
    productList.add(new ProductBundleImpl());
    ProductDaoImpl productDao = mock(ProductDaoImpl.class);
    when(productDao.findProductByURI(Mockito.<String>any())).thenReturn(productList);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setProductDao(productDao);

    // Act
    Product actualFindProductByURIResult = catalogServiceImpl.findProductByURI("Uri");

    // Assert
    verify(productDao).findProductByURI(eq("Uri"));
    assertSame(productBundleImpl, actualFindProductByURIResult);
  }

  /**
   * Method under test:
   * {@link CatalogServiceImpl#findOriginalProductByURI(String)}
   */
  @Test
  public void testFindOriginalProductByURI() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductDaoImpl productDao = mock(ProductDaoImpl.class);
    when(productDao.findProductByURI(Mockito.<String>any())).thenReturn(new ArrayList<>());

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setProductDao(productDao);

    // Act
    Product actualFindOriginalProductByURIResult = catalogServiceImpl.findOriginalProductByURI("Uri");

    // Assert
    verify(productDao).findProductByURI(eq("Uri"));
    assertNull(actualFindOriginalProductByURIResult);
  }

  /**
   * Method under test:
   * {@link CatalogServiceImpl#findOriginalProductByURI(String)}
   */
  @Test
  public void testFindOriginalProductByURI2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<Product> productList = new ArrayList<>();
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productList.add(productBundleImpl);
    ProductDaoImpl productDao = mock(ProductDaoImpl.class);
    when(productDao.findProductByURI(Mockito.<String>any())).thenReturn(productList);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setProductDao(productDao);

    // Act
    Product actualFindOriginalProductByURIResult = catalogServiceImpl.findOriginalProductByURI("Uri");

    // Assert
    verify(productDao).findProductByURI(eq("Uri"));
    assertSame(productBundleImpl, actualFindOriginalProductByURIResult);
  }

  /**
   * Method under test:
   * {@link CatalogServiceImpl#findOriginalProductByURI(String)}
   */
  @Test
  public void testFindOriginalProductByURI3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<Product> productList = new ArrayList<>();
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productList.add(productBundleImpl);
    productList.add(new ProductBundleImpl());
    ProductDaoImpl productDao = mock(ProductDaoImpl.class);
    when(productDao.findProductByURI(Mockito.<String>any())).thenReturn(productList);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setProductDao(productDao);

    // Act
    Product actualFindOriginalProductByURIResult = catalogServiceImpl.findOriginalProductByURI("Uri");

    // Assert
    verify(productDao).findProductByURI(eq("Uri"));
    assertSame(productBundleImpl, actualFindOriginalProductByURIResult);
  }

  /**
   * Method under test: {@link CatalogServiceImpl#findSkuByURI(String)}
   */
  @Test
  public void testFindSkuByURI() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuDaoImpl skuDao = mock(SkuDaoImpl.class);
    when(skuDao.findSkuByURI(Mockito.<String>any())).thenReturn(new ArrayList<>());

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setSkuDao(skuDao);

    // Act
    Sku actualFindSkuByURIResult = catalogServiceImpl.findSkuByURI("Uri");

    // Assert
    verify(skuDao).findSkuByURI(eq("Uri"));
    assertNull(actualFindSkuByURIResult);
  }

  /**
   * Method under test: {@link CatalogServiceImpl#findSkuByURI(String)}
   */
  @Test
  public void testFindSkuByURI2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<Sku> skuList = new ArrayList<>();
    SkuImpl skuImpl = new SkuImpl();
    skuList.add(skuImpl);
    SkuDaoImpl skuDao = mock(SkuDaoImpl.class);
    when(skuDao.findSkuByURI(Mockito.<String>any())).thenReturn(skuList);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setSkuDao(skuDao);

    // Act
    Sku actualFindSkuByURIResult = catalogServiceImpl.findSkuByURI("Uri");

    // Assert
    verify(skuDao).findSkuByURI(eq("Uri"));
    assertSame(skuImpl, actualFindSkuByURIResult);
  }

  /**
   * Method under test: {@link CatalogServiceImpl#findSkuByURI(String)}
   */
  @Test
  public void testFindSkuByURI3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getUrlKey()).thenReturn("https://example.org/example");
    when(skuImpl.getProduct()).thenReturn(new ProductBundleImpl());
    SkuImpl skuImpl2 = mock(SkuImpl.class);
    when(skuImpl2.getUrlKey()).thenReturn("https://example.org/example");
    when(skuImpl2.getProduct()).thenReturn(new ProductBundleImpl());

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(skuImpl2);
    skuList.add(skuImpl);
    SkuDaoImpl skuDao = mock(SkuDaoImpl.class);
    when(skuDao.findSkuByURI(Mockito.<String>any())).thenReturn(skuList);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setSkuDao(skuDao);

    // Act
    catalogServiceImpl.findSkuByURI("Uri");

    // Assert
    verify(skuDao).findSkuByURI(eq("Uri"));
    verify(skuImpl2).getProduct();
    verify(skuImpl).getProduct();
    verify(skuImpl2).getUrlKey();
    verify(skuImpl).getUrlKey();
  }

  /**
   * Method under test: {@link CatalogServiceImpl#findSkuByURI(String)}
   */
  @Test
  public void testFindSkuByURI4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getUrlKey()).thenReturn("https://example.org/example");
    when(skuImpl.getProduct()).thenReturn(new ProductBundleImpl());
    SkuImpl skuImpl2 = mock(SkuImpl.class);
    when(skuImpl2.getUrlKey()).thenReturn("https://example.org/example");
    when(skuImpl2.getProduct()).thenReturn(new ProductBundleImpl());

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(skuImpl2);
    skuList.add(skuImpl);
    SkuDaoImpl skuDao = mock(SkuDaoImpl.class);
    when(skuDao.findSkuByURI(Mockito.<String>any())).thenReturn(skuList);

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setSkuDao(skuDao);

    // Act
    catalogServiceImpl.findSkuByURI("nullhttps://example.org/example");

    // Assert
    verify(skuDao).findSkuByURI(eq("nullhttps://example.org/example"));
    verify(skuImpl2).getProduct();
    verify(skuImpl2).getUrlKey();
  }
}

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
   * Test {@link CatalogServiceImpl#findProductById(Long)}.
   * <ul>
   *   <li>Then return {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findProductById(Long)}
   */
  @Test
  public void testFindProductById_thenReturnProductBundleImpl() {
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
   * Test {@link CatalogServiceImpl#findProductByExternalId(String)}.
   * <ul>
   *   <li>Then return {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findProductByExternalId(String)}
   */
  @Test
  public void testFindProductByExternalId_thenReturnProductBundleImpl() {
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
   * Test {@link CatalogServiceImpl#findProductsByName(String, int, int)} with
   * {@code searchName}, {@code limit}, {@code offset}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogServiceImpl#findProductsByName(String, int, int)}
   */
  @Test
  public void testFindProductsByNameWithSearchNameLimitOffset_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductDaoImpl productDao = mock(ProductDaoImpl.class);
    when(productDao.readProductsByName(Mockito.<String>any(), anyInt(), anyInt())).thenReturn(new ArrayList<>());

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setProductDao(productDao);

    // Act
    List<Product> actualFindProductsByNameResult = catalogServiceImpl.findProductsByName("Search Name", 1, 2);

    // Assert
    verify(productDao).readProductsByName(eq("Search Name"), eq(1), eq(2));
    assertTrue(actualFindProductsByNameResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#findProductsByName(String)} with
   * {@code searchName}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findProductsByName(String)}
   */
  @Test
  public void testFindProductsByNameWithSearchName_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductDaoImpl productDao = mock(ProductDaoImpl.class);
    when(productDao.readProductsByName(Mockito.<String>any())).thenReturn(new ArrayList<>());

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setProductDao(productDao);

    // Act
    List<Product> actualFindProductsByNameResult = catalogServiceImpl.findProductsByName("Search Name");

    // Assert
    verify(productDao).readProductsByName(eq("Search Name"));
    assertTrue(actualFindProductsByNameResult.isEmpty());
  }

  /**
   * Test
   * {@link CatalogServiceImpl#findActiveProductsByCategory(Category, Date, int, int)}
   * with {@code category}, {@code currentDate}, {@code limit}, {@code offset}.
   * <p>
   * Method under test:
   * {@link CatalogServiceImpl#findActiveProductsByCategory(Category, Date, int, int)}
   */
  @Test
  public void testFindActiveProductsByCategoryWithCategoryCurrentDateLimitOffset() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductDaoImpl productDao = mock(ProductDaoImpl.class);
    when(productDao.readActiveProductsByCategory(Mockito.<Long>any(), Mockito.<Date>any(), anyInt(), anyInt()))
        .thenReturn(new ArrayList<>());

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
  }

  /**
   * Test {@link CatalogServiceImpl#findActiveProductsByCategory(Category, Date)}
   * with {@code category}, {@code currentDate}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogServiceImpl#findActiveProductsByCategory(Category, Date)}
   */
  @Test
  public void testFindActiveProductsByCategoryWithCategoryCurrentDate_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductDaoImpl productDao = mock(ProductDaoImpl.class);
    when(productDao.readActiveProductsByCategory(Mockito.<Long>any(), Mockito.<Date>any()))
        .thenReturn(new ArrayList<>());

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
  }

  /**
   * Test
   * {@link CatalogServiceImpl#findActiveProductsByCategory(Category, int, int)}
   * with {@code category}, {@code limit}, {@code offset}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogServiceImpl#findActiveProductsByCategory(Category, int, int)}
   */
  @Test
  public void testFindActiveProductsByCategoryWithCategoryLimitOffset_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductDaoImpl productDao = mock(ProductDaoImpl.class);
    when(productDao.readActiveProductsByCategory(Mockito.<Long>any(), anyInt(), anyInt()))
        .thenReturn(new ArrayList<>());

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
  }

  /**
   * Test {@link CatalogServiceImpl#findActiveProductsByCategory(Category)} with
   * {@code category}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogServiceImpl#findActiveProductsByCategory(Category)}
   */
  @Test
  public void testFindActiveProductsByCategoryWithCategory_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductDaoImpl productDao = mock(ProductDaoImpl.class);
    when(productDao.readActiveProductsByCategory(Mockito.<Long>any())).thenReturn(new ArrayList<>());

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
  }

  /**
   * Test
   * {@link CatalogServiceImpl#findFilteredActiveProductsByCategory(Category, Date, SearchCriteria)}
   * with {@code category}, {@code currentDate}, {@code searchCriteria}.
   * <p>
   * Method under test:
   * {@link CatalogServiceImpl#findFilteredActiveProductsByCategory(Category, Date, SearchCriteria)}
   */
  @Test
  public void testFindFilteredActiveProductsByCategoryWithCategoryCurrentDateSearchCriteria() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductDaoImpl productDao = mock(ProductDaoImpl.class);
    when(productDao.readFilteredActiveProductsByCategory(Mockito.<Long>any(), Mockito.<Date>any(),
        Mockito.<SearchCriteria>any())).thenReturn(new ArrayList<>());

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
  }

  /**
   * Test
   * {@link CatalogServiceImpl#findFilteredActiveProductsByCategory(Category, SearchCriteria)}
   * with {@code category}, {@code searchCriteria}.
   * <p>
   * Method under test:
   * {@link CatalogServiceImpl#findFilteredActiveProductsByCategory(Category, SearchCriteria)}
   */
  @Test
  public void testFindFilteredActiveProductsByCategoryWithCategorySearchCriteria() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductDaoImpl productDao = mock(ProductDaoImpl.class);
    when(productDao.readFilteredActiveProductsByCategory(Mockito.<Long>any(), Mockito.<SearchCriteria>any()))
        .thenReturn(new ArrayList<>());

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
  }

  /**
   * Test
   * {@link CatalogServiceImpl#findFilteredActiveProductsByQuery(String, Date, SearchCriteria)}
   * with {@code query}, {@code currentDate}, {@code searchCriteria}.
   * <p>
   * Method under test:
   * {@link CatalogServiceImpl#findFilteredActiveProductsByQuery(String, Date, SearchCriteria)}
   */
  @Test
  public void testFindFilteredActiveProductsByQueryWithQueryCurrentDateSearchCriteria() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductDaoImpl productDao = mock(ProductDaoImpl.class);
    when(productDao.readFilteredActiveProductsByQuery(Mockito.<String>any(), Mockito.<Date>any(),
        Mockito.<SearchCriteria>any())).thenReturn(new ArrayList<>());

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setProductDao(productDao);
    Date currentDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    List<Product> actualFindFilteredActiveProductsByQueryResult = catalogServiceImpl
        .findFilteredActiveProductsByQuery("Query", currentDate, new SearchCriteria());

    // Assert
    verify(productDao).readFilteredActiveProductsByQuery(eq("Query"), isA(Date.class), isA(SearchCriteria.class));
    assertTrue(actualFindFilteredActiveProductsByQueryResult.isEmpty());
  }

  /**
   * Test
   * {@link CatalogServiceImpl#findFilteredActiveProductsByQuery(String, SearchCriteria)}
   * with {@code query}, {@code searchCriteria}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogServiceImpl#findFilteredActiveProductsByQuery(String, SearchCriteria)}
   */
  @Test
  public void testFindFilteredActiveProductsByQueryWithQuerySearchCriteria_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductDaoImpl productDao = mock(ProductDaoImpl.class);
    when(productDao.readFilteredActiveProductsByQuery(Mockito.<String>any(), Mockito.<SearchCriteria>any()))
        .thenReturn(new ArrayList<>());

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setProductDao(productDao);

    // Act
    List<Product> actualFindFilteredActiveProductsByQueryResult = catalogServiceImpl
        .findFilteredActiveProductsByQuery("Query", new SearchCriteria());

    // Assert
    verify(productDao).readFilteredActiveProductsByQuery(eq("Query"), isA(SearchCriteria.class));
    assertTrue(actualFindFilteredActiveProductsByQueryResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#findAutomaticProductBundles()}.
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findAutomaticProductBundles()}
   */
  @Test
  public void testFindAutomaticProductBundles_thenReturnArrayList() {
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
   * Test {@link CatalogServiceImpl#findAutomaticProductBundles()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findAutomaticProductBundles()}
   */
  @Test
  public void testFindAutomaticProductBundles_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductDaoImpl productDao = mock(ProductDaoImpl.class);
    when(productDao.readAutomaticProductBundles()).thenReturn(new ArrayList<>());

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setProductDao(productDao);

    // Act
    List<ProductBundle> actualFindAutomaticProductBundlesResult = catalogServiceImpl.findAutomaticProductBundles();

    // Assert
    verify(productDao).readAutomaticProductBundles();
    assertTrue(actualFindAutomaticProductBundlesResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#saveProduct(Product)}.
   * <ul>
   *   <li>Then return {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#saveProduct(Product)}
   */
  @Test
  public void testSaveProduct_thenReturnProductBundleImpl() {
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
   * Test {@link CatalogServiceImpl#findCategoryById(Long)}.
   * <ul>
   *   <li>Then return {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findCategoryById(Long)}
   */
  @Test
  public void testFindCategoryById_thenReturnCategoryImpl() {
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
   * Test {@link CatalogServiceImpl#findCategoryByExternalId(String)}.
   * <ul>
   *   <li>Then return {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogServiceImpl#findCategoryByExternalId(String)}
   */
  @Test
  public void testFindCategoryByExternalId_thenReturnCategoryImpl() {
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
   * Test {@link CatalogServiceImpl#findCategoryByName(String)}.
   * <ul>
   *   <li>Then return {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findCategoryByName(String)}
   */
  @Test
  public void testFindCategoryByName_thenReturnCategoryImpl() {
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
   * Test {@link CatalogServiceImpl#findCategoriesByName(String, int, int)} with
   * {@code categoryName}, {@code limit}, {@code offset}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogServiceImpl#findCategoriesByName(String, int, int)}
   */
  @Test
  public void testFindCategoriesByNameWithCategoryNameLimitOffset_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    when(categoryDao.readCategoriesByName(Mockito.<String>any(), anyInt(), anyInt())).thenReturn(new ArrayList<>());

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setCategoryDao(categoryDao);

    // Act
    List<Category> actualFindCategoriesByNameResult = catalogServiceImpl.findCategoriesByName("Category Name", 1, 2);

    // Assert
    verify(categoryDao).readCategoriesByName(eq("Category Name"), eq(1), eq(2));
    assertTrue(actualFindCategoriesByNameResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#findCategoriesByName(String)} with
   * {@code categoryName}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findCategoriesByName(String)}
   */
  @Test
  public void testFindCategoriesByNameWithCategoryName_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    when(categoryDao.readCategoriesByName(Mockito.<String>any())).thenReturn(new ArrayList<>());

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setCategoryDao(categoryDao);

    // Act
    List<Category> actualFindCategoriesByNameResult = catalogServiceImpl.findCategoriesByName("Category Name");

    // Assert
    verify(categoryDao).readCategoriesByName(eq("Category Name"));
    assertTrue(actualFindCategoriesByNameResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#saveCategory(Category)}.
   * <ul>
   *   <li>Then return {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#saveCategory(Category)}
   */
  @Test
  public void testSaveCategory_thenReturnCategoryImpl() {
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
   * Test {@link CatalogServiceImpl#removeCategory(Category)}.
   * <ul>
   *   <li>Given {@link CategoryDaoImpl} {@link CategoryDaoImpl#delete(Category)}
   * does nothing.</li>
   *   <li>Then calls {@link CategoryDaoImpl#delete(Category)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#removeCategory(Category)}
   */
  @Test
  public void testRemoveCategory_givenCategoryDaoImplDeleteDoesNothing_thenCallsDelete() {
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
   * Test {@link CatalogServiceImpl#removeSku(Sku)}.
   * <ul>
   *   <li>Given {@link SkuDaoImpl} {@link SkuDaoImpl#delete(Sku)} does
   * nothing.</li>
   *   <li>When {@link SkuImpl} (default constructor).</li>
   *   <li>Then calls {@link SkuDaoImpl#delete(Sku)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#removeSku(Sku)}
   */
  @Test
  public void testRemoveSku_givenSkuDaoImplDeleteDoesNothing_whenSkuImpl_thenCallsDelete() {
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
   * Test {@link CatalogServiceImpl#removeProduct(Product)}.
   * <ul>
   *   <li>Given {@link ProductDaoImpl} {@link ProductDaoImpl#delete(Product)} does
   * nothing.</li>
   *   <li>Then calls {@link ProductDaoImpl#delete(Product)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#removeProduct(Product)}
   */
  @Test
  public void testRemoveProduct_givenProductDaoImplDeleteDoesNothing_thenCallsDelete() {
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
   * Test {@link CatalogServiceImpl#findAllCategories(int, int)} with {@code int},
   * {@code int}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findAllCategories(int, int)}
   */
  @Test
  public void testFindAllCategoriesWithIntInt_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    when(categoryDao.readAllCategories(anyInt(), anyInt())).thenReturn(new ArrayList<>());

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setCategoryDao(categoryDao);

    // Act
    List<Category> actualFindAllCategoriesResult = catalogServiceImpl.findAllCategories(1, 2);

    // Assert
    verify(categoryDao).readAllCategories(eq(1), eq(2));
    assertTrue(actualFindAllCategoriesResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#findAllCategories()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findAllCategories()}
   */
  @Test
  public void testFindAllCategories_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    when(categoryDao.readAllCategories()).thenReturn(new ArrayList<>());

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setCategoryDao(categoryDao);

    // Act
    List<Category> actualFindAllCategoriesResult = catalogServiceImpl.findAllCategories();

    // Assert
    verify(categoryDao).readAllCategories();
    assertTrue(actualFindAllCategoriesResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#findTotalCategoryCount()}.
   * <ul>
   *   <li>Then return longValue is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findTotalCategoryCount()}
   */
  @Test
  public void testFindTotalCategoryCount_thenReturnLongValueIsThree() {
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
   * Test {@link CatalogServiceImpl#findAllSubCategories(Category, int, int)} with
   * {@code category}, {@code limit}, {@code offset}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogServiceImpl#findAllSubCategories(Category, int, int)}
   */
  @Test
  public void testFindAllSubCategoriesWithCategoryLimitOffset_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    when(categoryDao.readAllSubCategories(Mockito.<Category>any(), anyInt(), anyInt())).thenReturn(new ArrayList<>());

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setCategoryDao(categoryDao);

    // Act
    List<Category> actualFindAllSubCategoriesResult = catalogServiceImpl.findAllSubCategories(new CategoryImpl(), 1, 2);

    // Assert
    verify(categoryDao).readAllSubCategories(isA(Category.class), eq(1), eq(2));
    assertTrue(actualFindAllSubCategoriesResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#findAllSubCategories(Category)} with
   * {@code category}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findAllSubCategories(Category)}
   */
  @Test
  public void testFindAllSubCategoriesWithCategory_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    when(categoryDao.readAllSubCategories(Mockito.<Category>any())).thenReturn(new ArrayList<>());

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setCategoryDao(categoryDao);

    // Act
    List<Category> actualFindAllSubCategoriesResult = catalogServiceImpl.findAllSubCategories(new CategoryImpl());

    // Assert
    verify(categoryDao).readAllSubCategories(isA(Category.class));
    assertTrue(actualFindAllSubCategoriesResult.isEmpty());
  }

  /**
   * Test
   * {@link CatalogServiceImpl#findActiveSubCategoriesByCategory(Category, int, int)}
   * with {@code category}, {@code limit}, {@code offset}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogServiceImpl#findActiveSubCategoriesByCategory(Category, int, int)}
   */
  @Test
  public void testFindActiveSubCategoriesByCategoryWithCategoryLimitOffset_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    when(categoryDao.readActiveSubCategoriesByCategory(Mockito.<Category>any(), anyInt(), anyInt()))
        .thenReturn(new ArrayList<>());

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setCategoryDao(categoryDao);

    // Act
    List<Category> actualFindActiveSubCategoriesByCategoryResult = catalogServiceImpl
        .findActiveSubCategoriesByCategory(new CategoryImpl(), 1, 2);

    // Assert
    verify(categoryDao).readActiveSubCategoriesByCategory(isA(Category.class), eq(1), eq(2));
    assertTrue(actualFindActiveSubCategoriesByCategoryResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#findActiveSubCategoriesByCategory(Category)}
   * with {@code category}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogServiceImpl#findActiveSubCategoriesByCategory(Category)}
   */
  @Test
  public void testFindActiveSubCategoriesByCategoryWithCategory_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    when(categoryDao.readActiveSubCategoriesByCategory(Mockito.<Category>any())).thenReturn(new ArrayList<>());

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setCategoryDao(categoryDao);

    // Act
    List<Category> actualFindActiveSubCategoriesByCategoryResult = catalogServiceImpl
        .findActiveSubCategoriesByCategory(new CategoryImpl());

    // Assert
    verify(categoryDao).readActiveSubCategoriesByCategory(isA(Category.class));
    assertTrue(actualFindActiveSubCategoriesByCategoryResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#findAllProducts(int, int)} with {@code int},
   * {@code int}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findAllProducts(int, int)}
   */
  @Test
  public void testFindAllProductsWithIntInt_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    when(categoryDao.readAllProducts(anyInt(), anyInt())).thenReturn(new ArrayList<>());

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setCategoryDao(categoryDao);

    // Act
    List<Product> actualFindAllProductsResult = catalogServiceImpl.findAllProducts(1, 2);

    // Assert
    verify(categoryDao).readAllProducts(eq(1), eq(2));
    assertTrue(actualFindAllProductsResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#findAllProducts()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findAllProducts()}
   */
  @Test
  public void testFindAllProducts_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    when(categoryDao.readAllProducts()).thenReturn(new ArrayList<>());

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setCategoryDao(categoryDao);

    // Act
    List<Product> actualFindAllProductsResult = catalogServiceImpl.findAllProducts();

    // Assert
    verify(categoryDao).readAllProducts();
    assertTrue(actualFindAllProductsResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#findAllSkus(int, int)} with {@code int},
   * {@code int}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findAllSkus(int, int)}
   */
  @Test
  public void testFindAllSkusWithIntInt_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuDaoImpl skuDao = mock(SkuDaoImpl.class);
    when(skuDao.readAllSkus(anyInt(), anyInt())).thenReturn(new ArrayList<>());

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setSkuDao(skuDao);

    // Act
    List<Sku> actualFindAllSkusResult = catalogServiceImpl.findAllSkus(2, 1);

    // Assert
    verify(skuDao).readAllSkus(eq(2), eq(1));
    assertTrue(actualFindAllSkusResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#findAllSkus()}.
   * <ul>
   *   <li>Given {@link SkuDaoImpl} {@link SkuDaoImpl#readAllSkus()} return
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findAllSkus()}
   */
  @Test
  public void testFindAllSkus_givenSkuDaoImplReadAllSkusReturnArrayList_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuDaoImpl skuDao = mock(SkuDaoImpl.class);
    when(skuDao.readAllSkus()).thenReturn(new ArrayList<>());

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setSkuDao(skuDao);

    // Act
    List<Sku> actualFindAllSkusResult = catalogServiceImpl.findAllSkus();

    // Assert
    verify(skuDao).readAllSkus();
    assertTrue(actualFindAllSkusResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#findSkuById(Long)}.
   * <ul>
   *   <li>Given {@link SkuDaoImpl} {@link SkuDaoImpl#readSkuById(Long)} return
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findSkuById(Long)}
   */
  @Test
  public void testFindSkuById_givenSkuDaoImplReadSkuByIdReturnSkuImpl_thenReturnSkuImpl() {
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
   * Test {@link CatalogServiceImpl#findSkuByExternalId(String)}.
   * <ul>
   *   <li>Then return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findSkuByExternalId(String)}
   */
  @Test
  public void testFindSkuByExternalId_thenReturnSkuImpl() {
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
   * Test {@link CatalogServiceImpl#findSkuByUpc(String)}.
   * <ul>
   *   <li>Given {@link SkuDaoImpl} {@link SkuDaoImpl#readSkuByUpc(String)} return
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findSkuByUpc(String)}
   */
  @Test
  public void testFindSkuByUpc_givenSkuDaoImplReadSkuByUpcReturnSkuImpl_thenReturnSkuImpl() {
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
   * Test {@link CatalogServiceImpl#saveSku(Sku)}.
   * <ul>
   *   <li>Given {@link SkuDaoImpl} {@link SkuDaoImpl#save(Sku)} return
   * {@link SkuImpl} (default constructor).</li>
   *   <li>When {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#saveSku(Sku)}
   */
  @Test
  public void testSaveSku_givenSkuDaoImplSaveReturnSkuImpl_whenSkuImpl_thenReturnSkuImpl() {
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
   * Test {@link CatalogServiceImpl#saveSkuFee(SkuFee)}.
   * <ul>
   *   <li>Given {@link SkuDaoImpl} {@link SkuDaoImpl#saveSkuFee(SkuFee)} return
   * {@link SkuFeeImpl} (default constructor).</li>
   *   <li>Then return {@link SkuFeeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#saveSkuFee(SkuFee)}
   */
  @Test
  public void testSaveSkuFee_givenSkuDaoImplSaveSkuFeeReturnSkuFeeImpl_thenReturnSkuFeeImpl() {
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
   * Test {@link CatalogServiceImpl#findSkusByIds(List)}.
   * <ul>
   *   <li>Given {@link CatalogServiceImpl} (default constructor) SkuDao is
   * {@link SkuDaoImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findSkusByIds(List)}
   */
  @Test
  public void testFindSkusByIds_givenCatalogServiceImplSkuDaoIsSkuDaoImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setSkuDao(new SkuDaoImpl());

    // Act and Assert
    assertNull(catalogServiceImpl.findSkusByIds(new ArrayList<>()));
  }

  /**
   * Test {@link CatalogServiceImpl#findSkusByIds(List)}.
   * <ul>
   *   <li>Given {@link SkuDaoImpl} {@link SkuDaoImpl#readSkusByIds(List)} return
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findSkusByIds(List)}
   */
  @Test
  public void testFindSkusByIds_givenSkuDaoImplReadSkusByIdsReturnArrayList_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuDaoImpl skuDao = mock(SkuDaoImpl.class);
    when(skuDao.readSkusByIds(Mockito.<List<Long>>any())).thenReturn(new ArrayList<>());

    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setSkuDao(skuDao);

    // Act
    List<Sku> actualFindSkusByIdsResult = catalogServiceImpl.findSkusByIds(new ArrayList<>());

    // Assert
    verify(skuDao).readSkusByIds(isA(List.class));
    assertTrue(actualFindSkusByIdsResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#findProductsForCategory(Category, int, int)}
   * with {@code category}, {@code limit}, {@code offset}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogServiceImpl#findProductsForCategory(Category, int, int)}
   */
  @Test
  public void testFindProductsForCategoryWithCategoryLimitOffset_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductDaoImpl productDao = mock(ProductDaoImpl.class);
    when(productDao.readProductsByCategory(Mockito.<Long>any(), anyInt(), anyInt())).thenReturn(new ArrayList<>());

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
  }

  /**
   * Test {@link CatalogServiceImpl#findProductsForCategory(Category)} with
   * {@code category}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogServiceImpl#findProductsForCategory(Category)}
   */
  @Test
  public void testFindProductsForCategoryWithCategory_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductDaoImpl productDao = mock(ProductDaoImpl.class);
    when(productDao.readProductsByCategory(Mockito.<Long>any())).thenReturn(new ArrayList<>());

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
  }

  /**
   * Test {@link CatalogServiceImpl#getChildCategoryURLMapByCategoryId(Long)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogServiceImpl#getChildCategoryURLMapByCategoryId(Long)}
   */
  @Test
  public void testGetChildCategoryURLMapByCategoryId_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getChildCategoryURLMap()).thenReturn(new HashMap<>());
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
  }

  /**
   * Test {@link CatalogServiceImpl#getChildCategoryURLMapByCategoryId(Long)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogServiceImpl#getChildCategoryURLMapByCategoryId(Long)}
   */
  @Test
  public void testGetChildCategoryURLMapByCategoryId_thenReturnNull() {
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
   * Test {@link CatalogServiceImpl#createCategory()}.
   * <ul>
   *   <li>Then return {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#createCategory()}
   */
  @Test
  public void testCreateCategory_thenReturnCategoryImpl() {
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
   * Test {@link CatalogServiceImpl#createSku()}.
   * <ul>
   *   <li>Given {@link SkuDaoImpl} {@link SkuDaoImpl#create()} return
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#createSku()}
   */
  @Test
  public void testCreateSku_givenSkuDaoImplCreateReturnSkuImpl_thenReturnSkuImpl() {
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
   * Test {@link CatalogServiceImpl#createProduct(ProductType)}.
   * <ul>
   *   <li>Then return {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#createProduct(ProductType)}
   */
  @Test
  public void testCreateProduct_thenReturnProductBundleImpl() {
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
   * Test {@link CatalogServiceImpl#createCatalogContextDTO()}.
   * <ul>
   *   <li>Given {@link CatalogServiceImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#createCatalogContextDTO()}
   */
  @Test
  public void testCreateCatalogContextDTO_givenCatalogServiceImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CatalogServiceImpl()).createCatalogContextDTO().getAttributes().isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#createCatalogContextDTO()}.
   * <ul>
   *   <li>Given {@link CatalogServiceImpl} (default constructor) ProductDao is
   * {@link ProductDaoImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#createCatalogContextDTO()}
   */
  @Test
  public void testCreateCatalogContextDTO_givenCatalogServiceImplProductDaoIsProductDaoImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogServiceImpl catalogServiceImpl = new CatalogServiceImpl();
    catalogServiceImpl.setProductDao(mock(ProductDaoImpl.class));

    // Act and Assert
    assertTrue(catalogServiceImpl.createCatalogContextDTO().getAttributes().isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#findCategoryByURI(String)}.
   * <ul>
   *   <li>Then return {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findCategoryByURI(String)}
   */
  @Test
  public void testFindCategoryByURI_thenReturnCategoryImpl() {
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
   * Test {@link CatalogServiceImpl#findOriginalCategoryByURI(String)}.
   * <ul>
   *   <li>Then return {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogServiceImpl#findOriginalCategoryByURI(String)}
   */
  @Test
  public void testFindOriginalCategoryByURI_thenReturnCategoryImpl() {
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
   * Test {@link CatalogServiceImpl#findProductByURI(String)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findProductByURI(String)}
   */
  @Test
  public void testFindProductByURI_thenReturnNull() {
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
   * Test {@link CatalogServiceImpl#findProductByURI(String)}.
   * <ul>
   *   <li>Then return {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findProductByURI(String)}
   */
  @Test
  public void testFindProductByURI_thenReturnProductBundleImpl() {
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
   * Test {@link CatalogServiceImpl#findProductByURI(String)}.
   * <ul>
   *   <li>Then return {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findProductByURI(String)}
   */
  @Test
  public void testFindProductByURI_thenReturnProductBundleImpl2() {
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
   * Test {@link CatalogServiceImpl#findOriginalProductByURI(String)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogServiceImpl#findOriginalProductByURI(String)}
   */
  @Test
  public void testFindOriginalProductByURI_thenReturnNull() {
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
   * Test {@link CatalogServiceImpl#findOriginalProductByURI(String)}.
   * <ul>
   *   <li>Then return {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogServiceImpl#findOriginalProductByURI(String)}
   */
  @Test
  public void testFindOriginalProductByURI_thenReturnProductBundleImpl() {
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
   * Test {@link CatalogServiceImpl#findOriginalProductByURI(String)}.
   * <ul>
   *   <li>Then return {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogServiceImpl#findOriginalProductByURI(String)}
   */
  @Test
  public void testFindOriginalProductByURI_thenReturnProductBundleImpl2() {
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
   * Test {@link CatalogServiceImpl#findSkuByURI(String)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link SkuImpl} (default
   * constructor).</li>
   *   <li>When {@code Uri}.</li>
   *   <li>Then return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findSkuByURI(String)}
   */
  @Test
  public void testFindSkuByURI_givenArrayListAddSkuImpl_whenUri_thenReturnSkuImpl() {
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
   * Test {@link CatalogServiceImpl#findSkuByURI(String)}.
   * <ul>
   *   <li>Given {@link SkuDaoImpl} {@link SkuDaoImpl#findSkuByURI(String)} return
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findSkuByURI(String)}
   */
  @Test
  public void testFindSkuByURI_givenSkuDaoImplFindSkuByURIReturnArrayList_thenReturnNull() {
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
   * Test {@link CatalogServiceImpl#findSkuByURI(String)}.
   * <ul>
   *   <li>Then calls {@link SkuImpl#getProduct()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findSkuByURI(String)}
   */
  @Test
  public void testFindSkuByURI_thenCallsGetProduct() {
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
   * Test {@link CatalogServiceImpl#findSkuByURI(String)}.
   * <ul>
   *   <li>When {@code nullhttps://example.org/example}.</li>
   *   <li>Then calls {@link SkuImpl#getProduct()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findSkuByURI(String)}
   */
  @Test
  public void testFindSkuByURI_whenNullhttpsExampleOrgExample_thenCallsGetProduct() {
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

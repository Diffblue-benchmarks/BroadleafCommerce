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
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.core.catalog.dao.CategoryDao;
import org.broadleafcommerce.core.catalog.dao.ProductDao;
import org.broadleafcommerce.core.catalog.dao.ProductOptionDao;
import org.broadleafcommerce.core.catalog.dao.SkuDao;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundle;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.ProductOption;
import org.broadleafcommerce.core.catalog.domain.ProductOptionImpl;
import org.broadleafcommerce.core.catalog.domain.ProductOptionValue;
import org.broadleafcommerce.core.catalog.domain.ProductOptionValueImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuFee;
import org.broadleafcommerce.core.catalog.domain.SkuFeeImpl;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.catalog.domain.dto.AssignedProductOptionDTO;
import org.broadleafcommerce.core.catalog.service.type.ProductType;
import org.broadleafcommerce.core.search.domain.SearchCriteria;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CatalogServiceImplDiffblueTest {
  @InjectMocks
  private CatalogServiceImpl catalogServiceImpl;

  @Mock
  private ProductOptionDao productOptionDao;

  @Mock
  private CategoryDao categoryDao;

  @Mock
  private ProductDao productDao;

  @Mock
  private SkuDao skuDao;

  @Mock
  private CatalogServiceExtensionManager catalogServiceExtensionManager;

  /**
   * Test {@link CatalogServiceImpl#findProductById(Long)}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#findProductById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Product CatalogServiceImpl.findProductById(Long)"})
  public void testFindProductById() {
    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);

    // Act
    Product actualFindProductByIdResult = catalogServiceImpl.findProductById(1L);

    // Assert
    verify(productDao).readProductById(eq(1L));
    assertSame(productBundleImpl, actualFindProductByIdResult);
  }

  /**
   * Test {@link CatalogServiceImpl#findProductByExternalId(String)}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#findProductByExternalId(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Product CatalogServiceImpl.findProductByExternalId(String)"})
  public void testFindProductByExternalId() {
    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    when(productDao.readProductByExternalId(Mockito.<String>any())).thenReturn(productBundleImpl);

    // Act
    Product actualFindProductByExternalIdResult = catalogServiceImpl.findProductByExternalId("42");

    // Assert
    verify(productDao).readProductByExternalId(eq("42"));
    assertSame(productBundleImpl, actualFindProductByExternalIdResult);
  }

  /**
   * Test {@link CatalogServiceImpl#findProductsByName(String)} with {@code searchName}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#findProductsByName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CatalogServiceImpl.findProductsByName(String)"})
  public void testFindProductsByNameWithSearchName() {
    // Arrange
    when(productDao.readProductsByName(Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    List<Product> actualFindProductsByNameResult = catalogServiceImpl.findProductsByName("Search Name");

    // Assert
    verify(productDao).readProductsByName(eq("Search Name"));
    assertTrue(actualFindProductsByNameResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#findProductsByName(String, int, int)} with {@code searchName}, {@code limit}, {@code offset}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#findProductsByName(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CatalogServiceImpl.findProductsByName(String, int, int)"})
  public void testFindProductsByNameWithSearchNameLimitOffset() {
    // Arrange
    when(productDao.readProductsByName(Mockito.<String>any(), anyInt(), anyInt())).thenReturn(new ArrayList<>());

    // Act
    List<Product> actualFindProductsByNameResult = catalogServiceImpl.findProductsByName("Search Name", 1, 2);

    // Assert
    verify(productDao).readProductsByName(eq("Search Name"), eq(1), eq(2));
    assertTrue(actualFindProductsByNameResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#findActiveProductsByCategory(Category, Date, int, int)} with {@code category}, {@code currentDate}, {@code limit}, {@code offset}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#findActiveProductsByCategory(org.broadleafcommerce.core.catalog.domain.Category, Date, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List CatalogServiceImpl.findActiveProductsByCategory(org.broadleafcommerce.core.catalog.domain.Category, Date, int, int)"})
  public void testFindActiveProductsByCategoryWithCategoryCurrentDateLimitOffset() {
    // Arrange
    when(productDao.readActiveProductsByCategory(Mockito.<Long>any(), Mockito.<Date>any(), anyInt(), anyInt()))
        .thenReturn(new ArrayList<>());
    CategoryImpl category = new CategoryImpl();

    // Act
    List<Product> actualFindActiveProductsByCategoryResult = catalogServiceImpl.findActiveProductsByCategory(category,
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()), 1, 2);

    // Assert
    verify(productDao).readActiveProductsByCategory(isNull(), isA(Date.class), eq(1), eq(2));
    assertTrue(actualFindActiveProductsByCategoryResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#findActiveProductsByCategory(Category, Date)} with {@code category}, {@code currentDate}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findActiveProductsByCategory(org.broadleafcommerce.core.catalog.domain.Category, Date)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List CatalogServiceImpl.findActiveProductsByCategory(org.broadleafcommerce.core.catalog.domain.Category, Date)"})
  public void testFindActiveProductsByCategoryWithCategoryCurrentDate_thenReturnEmpty() {
    // Arrange
    when(productDao.readActiveProductsByCategory(Mockito.<Long>any(), Mockito.<Date>any()))
        .thenReturn(new ArrayList<>());
    CategoryImpl category = new CategoryImpl();

    // Act
    List<Product> actualFindActiveProductsByCategoryResult = catalogServiceImpl.findActiveProductsByCategory(category,
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    verify(productDao).readActiveProductsByCategory(isNull(), isA(Date.class));
    assertTrue(actualFindActiveProductsByCategoryResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#findActiveProductsByCategory(Category, int, int)} with {@code category}, {@code limit}, {@code offset}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findActiveProductsByCategory(org.broadleafcommerce.core.catalog.domain.Category, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List CatalogServiceImpl.findActiveProductsByCategory(org.broadleafcommerce.core.catalog.domain.Category, int, int)"})
  public void testFindActiveProductsByCategoryWithCategoryLimitOffset_thenReturnEmpty() {
    // Arrange
    when(productDao.readActiveProductsByCategory(Mockito.<Long>any(), anyInt(), anyInt()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Product> actualFindActiveProductsByCategoryResult = catalogServiceImpl
        .findActiveProductsByCategory(new CategoryImpl(), 1, 2);

    // Assert
    verify(productDao).readActiveProductsByCategory(isNull(), eq(1), eq(2));
    assertTrue(actualFindActiveProductsByCategoryResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#findActiveProductsByCategory(Category)} with {@code category}.
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findActiveProductsByCategory(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List CatalogServiceImpl.findActiveProductsByCategory(org.broadleafcommerce.core.catalog.domain.Category)"})
  public void testFindActiveProductsByCategoryWithCategory_whenCategoryImpl_thenReturnEmpty() {
    // Arrange
    when(productDao.readActiveProductsByCategory(Mockito.<Long>any())).thenReturn(new ArrayList<>());

    // Act
    List<Product> actualFindActiveProductsByCategoryResult = catalogServiceImpl
        .findActiveProductsByCategory(new CategoryImpl());

    // Assert
    verify(productDao).readActiveProductsByCategory(isNull());
    assertTrue(actualFindActiveProductsByCategoryResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#findFilteredActiveProductsByCategory(Category, Date, SearchCriteria)} with {@code category}, {@code currentDate}, {@code searchCriteria}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#findFilteredActiveProductsByCategory(org.broadleafcommerce.core.catalog.domain.Category, Date, SearchCriteria)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List CatalogServiceImpl.findFilteredActiveProductsByCategory(org.broadleafcommerce.core.catalog.domain.Category, Date, SearchCriteria)"})
  public void testFindFilteredActiveProductsByCategoryWithCategoryCurrentDateSearchCriteria() {
    // Arrange
    when(productDao.readFilteredActiveProductsByCategory(Mockito.<Long>any(), Mockito.<Date>any(),
        Mockito.<SearchCriteria>any())).thenReturn(new ArrayList<>());
    CategoryImpl category = new CategoryImpl();
    Date currentDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    List<Product> actualFindFilteredActiveProductsByCategoryResult = catalogServiceImpl
        .findFilteredActiveProductsByCategory(category, currentDate, new SearchCriteria());

    // Assert
    verify(productDao).readFilteredActiveProductsByCategory(isNull(), isA(Date.class), isA(SearchCriteria.class));
    assertTrue(actualFindFilteredActiveProductsByCategoryResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#findFilteredActiveProductsByCategory(Category, SearchCriteria)} with {@code category}, {@code searchCriteria}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#findFilteredActiveProductsByCategory(org.broadleafcommerce.core.catalog.domain.Category, SearchCriteria)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List CatalogServiceImpl.findFilteredActiveProductsByCategory(org.broadleafcommerce.core.catalog.domain.Category, SearchCriteria)"})
  public void testFindFilteredActiveProductsByCategoryWithCategorySearchCriteria() {
    // Arrange
    when(productDao.readFilteredActiveProductsByCategory(Mockito.<Long>any(), Mockito.<SearchCriteria>any()))
        .thenReturn(new ArrayList<>());
    CategoryImpl category = new CategoryImpl();

    // Act
    List<Product> actualFindFilteredActiveProductsByCategoryResult = catalogServiceImpl
        .findFilteredActiveProductsByCategory(category, new SearchCriteria());

    // Assert
    verify(productDao).readFilteredActiveProductsByCategory(isNull(), isA(SearchCriteria.class));
    assertTrue(actualFindFilteredActiveProductsByCategoryResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#findFilteredActiveProductsByQuery(String, Date, SearchCriteria)} with {@code query}, {@code currentDate}, {@code searchCriteria}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#findFilteredActiveProductsByQuery(String, Date, SearchCriteria)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CatalogServiceImpl.findFilteredActiveProductsByQuery(String, Date, SearchCriteria)"})
  public void testFindFilteredActiveProductsByQueryWithQueryCurrentDateSearchCriteria() {
    // Arrange
    when(productDao.readFilteredActiveProductsByQuery(Mockito.<String>any(), Mockito.<Date>any(),
        Mockito.<SearchCriteria>any())).thenReturn(new ArrayList<>());
    Date currentDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    List<Product> actualFindFilteredActiveProductsByQueryResult = catalogServiceImpl
        .findFilteredActiveProductsByQuery("Query", currentDate, new SearchCriteria());

    // Assert
    verify(productDao).readFilteredActiveProductsByQuery(eq("Query"), isA(Date.class), isA(SearchCriteria.class));
    assertTrue(actualFindFilteredActiveProductsByQueryResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#findFilteredActiveProductsByQuery(String, SearchCriteria)} with {@code query}, {@code searchCriteria}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#findFilteredActiveProductsByQuery(String, SearchCriteria)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CatalogServiceImpl.findFilteredActiveProductsByQuery(String, SearchCriteria)"})
  public void testFindFilteredActiveProductsByQueryWithQuerySearchCriteria() {
    // Arrange
    when(productDao.readFilteredActiveProductsByQuery(Mockito.<String>any(), Mockito.<SearchCriteria>any()))
        .thenReturn(new ArrayList<>());

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CatalogServiceImpl.findAutomaticProductBundles()"})
  public void testFindAutomaticProductBundles_thenReturnArrayList() {
    // Arrange
    ArrayList<ProductBundle> productBundleList = new ArrayList<>();
    productBundleList.add(new ProductBundleImpl());
    productBundleList.add(new ProductBundleImpl());
    when(productDao.readAutomaticProductBundles()).thenReturn(productBundleList);

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CatalogServiceImpl.findAutomaticProductBundles()"})
  public void testFindAutomaticProductBundles_thenReturnEmpty() {
    // Arrange
    when(productDao.readAutomaticProductBundles()).thenReturn(new ArrayList<>());

    // Act
    List<ProductBundle> actualFindAutomaticProductBundlesResult = catalogServiceImpl.findAutomaticProductBundles();

    // Assert
    verify(productDao).readAutomaticProductBundles();
    assertTrue(actualFindAutomaticProductBundlesResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#saveProduct(Product)}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#saveProduct(Product)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Product CatalogServiceImpl.saveProduct(Product)"})
  public void testSaveProduct() {
    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    when(productDao.save(Mockito.<Product>any())).thenReturn(productBundleImpl);

    // Act
    Product actualSaveProductResult = catalogServiceImpl.saveProduct(new ProductBundleImpl());

    // Assert
    verify(productDao).save(isA(Product.class));
    assertSame(productBundleImpl, actualSaveProductResult);
  }

  /**
   * Test {@link CatalogServiceImpl#findCategoryById(Long)}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#findCategoryById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.broadleafcommerce.core.catalog.domain.Category CatalogServiceImpl.findCategoryById(Long)"})
  public void testFindCategoryById() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(categoryImpl);

    // Act
    org.broadleafcommerce.core.catalog.domain.Category actualFindCategoryByIdResult = catalogServiceImpl
        .findCategoryById(1L);

    // Assert
    verify(categoryDao).readCategoryById(eq(1L));
    assertSame(categoryImpl, actualFindCategoryByIdResult);
  }

  /**
   * Test {@link CatalogServiceImpl#findCategoryByExternalId(String)}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#findCategoryByExternalId(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.catalog.domain.Category CatalogServiceImpl.findCategoryByExternalId(String)"})
  public void testFindCategoryByExternalId() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    when(categoryDao.readCategoryByExternalId(Mockito.<String>any())).thenReturn(categoryImpl);

    // Act
    org.broadleafcommerce.core.catalog.domain.Category actualFindCategoryByExternalIdResult = catalogServiceImpl
        .findCategoryByExternalId("42");

    // Assert
    verify(categoryDao).readCategoryByExternalId(eq("42"));
    assertSame(categoryImpl, actualFindCategoryByExternalIdResult);
  }

  /**
   * Test {@link CatalogServiceImpl#findCategoryByName(String)}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#findCategoryByName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.catalog.domain.Category CatalogServiceImpl.findCategoryByName(String)"})
  public void testFindCategoryByName() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    when(categoryDao.readCategoryByName(Mockito.<String>any())).thenReturn(categoryImpl);

    // Act
    org.broadleafcommerce.core.catalog.domain.Category actualFindCategoryByNameResult = catalogServiceImpl
        .findCategoryByName("Category Name");

    // Assert
    verify(categoryDao).readCategoryByName(eq("Category Name"));
    assertSame(categoryImpl, actualFindCategoryByNameResult);
  }

  /**
   * Test {@link CatalogServiceImpl#findCategoriesByName(String)} with {@code categoryName}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#findCategoriesByName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CatalogServiceImpl.findCategoriesByName(String)"})
  public void testFindCategoriesByNameWithCategoryName() {
    // Arrange
    when(categoryDao.readCategoriesByName(Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    List<org.broadleafcommerce.core.catalog.domain.Category> actualFindCategoriesByNameResult = catalogServiceImpl
        .findCategoriesByName("Category Name");

    // Assert
    verify(categoryDao).readCategoriesByName(eq("Category Name"));
    assertTrue(actualFindCategoriesByNameResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#findCategoriesByName(String, int, int)} with {@code categoryName}, {@code limit}, {@code offset}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#findCategoriesByName(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CatalogServiceImpl.findCategoriesByName(String, int, int)"})
  public void testFindCategoriesByNameWithCategoryNameLimitOffset() {
    // Arrange
    when(categoryDao.readCategoriesByName(Mockito.<String>any(), anyInt(), anyInt())).thenReturn(new ArrayList<>());

    // Act
    List<org.broadleafcommerce.core.catalog.domain.Category> actualFindCategoriesByNameResult = catalogServiceImpl
        .findCategoriesByName("Category Name", 1, 2);

    // Assert
    verify(categoryDao).readCategoriesByName(eq("Category Name"), eq(1), eq(2));
    assertTrue(actualFindCategoriesByNameResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#saveCategory(Category)}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#saveCategory(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.catalog.domain.Category CatalogServiceImpl.saveCategory(org.broadleafcommerce.core.catalog.domain.Category)"})
  public void testSaveCategory() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    when(categoryDao.save(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any())).thenReturn(categoryImpl);

    // Act
    org.broadleafcommerce.core.catalog.domain.Category actualSaveCategoryResult = catalogServiceImpl
        .saveCategory(new CategoryImpl());

    // Assert
    verify(categoryDao).save(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    assertSame(categoryImpl, actualSaveCategoryResult);
  }

  /**
   * Test {@link CatalogServiceImpl#removeCategory(Category)}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#removeCategory(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CatalogServiceImpl.removeCategory(org.broadleafcommerce.core.catalog.domain.Category)"})
  public void testRemoveCategory() {
    // Arrange
    doNothing().when(categoryDao).delete(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());

    // Act
    catalogServiceImpl.removeCategory(new CategoryImpl());

    // Assert
    verify(categoryDao).delete(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
  }

  /**
   * Test {@link CatalogServiceImpl#removeSku(Sku)}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#removeSku(Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CatalogServiceImpl.removeSku(Sku)"})
  public void testRemoveSku() {
    // Arrange
    doNothing().when(skuDao).delete(Mockito.<Sku>any());

    // Act
    catalogServiceImpl.removeSku(new SkuImpl());

    // Assert
    verify(skuDao).delete(isA(Sku.class));
  }

  /**
   * Test {@link CatalogServiceImpl#removeProduct(Product)}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#removeProduct(Product)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CatalogServiceImpl.removeProduct(Product)"})
  public void testRemoveProduct() {
    // Arrange
    doNothing().when(productDao).delete(Mockito.<Product>any());

    // Act
    catalogServiceImpl.removeProduct(new ProductBundleImpl());

    // Assert
    verify(productDao).delete(isA(Product.class));
  }

  /**
   * Test {@link CatalogServiceImpl#findAllCategories()}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#findAllCategories()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CatalogServiceImpl.findAllCategories()"})
  public void testFindAllCategories() {
    // Arrange
    when(categoryDao.readAllCategories()).thenReturn(new ArrayList<>());

    // Act
    List<org.broadleafcommerce.core.catalog.domain.Category> actualFindAllCategoriesResult = catalogServiceImpl
        .findAllCategories();

    // Assert
    verify(categoryDao).readAllCategories();
    assertTrue(actualFindAllCategoriesResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#findAllCategories(int, int)} with {@code int}, {@code int}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#findAllCategories(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CatalogServiceImpl.findAllCategories(int, int)"})
  public void testFindAllCategoriesWithIntInt() {
    // Arrange
    when(categoryDao.readAllCategories(anyInt(), anyInt())).thenReturn(new ArrayList<>());

    // Act
    List<org.broadleafcommerce.core.catalog.domain.Category> actualFindAllCategoriesResult = catalogServiceImpl
        .findAllCategories(1, 2);

    // Assert
    verify(categoryDao).readAllCategories(eq(1), eq(2));
    assertTrue(actualFindAllCategoriesResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#findTotalCategoryCount()}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#findTotalCategoryCount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long CatalogServiceImpl.findTotalCategoryCount()"})
  public void testFindTotalCategoryCount() {
    // Arrange
    when(categoryDao.readTotalCategoryCount()).thenReturn(3L);

    // Act
    Long actualFindTotalCategoryCountResult = catalogServiceImpl.findTotalCategoryCount();

    // Assert
    verify(categoryDao).readTotalCategoryCount();
    assertEquals(3L, actualFindTotalCategoryCountResult.longValue());
  }

  /**
   * Test {@link CatalogServiceImpl#findAllSubCategories(Category)} with {@code category}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#findAllSubCategories(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List CatalogServiceImpl.findAllSubCategories(org.broadleafcommerce.core.catalog.domain.Category)"})
  public void testFindAllSubCategoriesWithCategory() {
    // Arrange
    when(categoryDao.readAllSubCategories(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<org.broadleafcommerce.core.catalog.domain.Category> actualFindAllSubCategoriesResult = catalogServiceImpl
        .findAllSubCategories(new CategoryImpl());

    // Assert
    verify(categoryDao).readAllSubCategories(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    assertTrue(actualFindAllSubCategoriesResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#findAllSubCategories(Category, int, int)} with {@code category}, {@code limit}, {@code offset}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#findAllSubCategories(org.broadleafcommerce.core.catalog.domain.Category, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List CatalogServiceImpl.findAllSubCategories(org.broadleafcommerce.core.catalog.domain.Category, int, int)"})
  public void testFindAllSubCategoriesWithCategoryLimitOffset() {
    // Arrange
    when(categoryDao.readAllSubCategories(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any(), anyInt(),
        anyInt())).thenReturn(new ArrayList<>());

    // Act
    List<org.broadleafcommerce.core.catalog.domain.Category> actualFindAllSubCategoriesResult = catalogServiceImpl
        .findAllSubCategories(new CategoryImpl(), 1, 2);

    // Assert
    verify(categoryDao).readAllSubCategories(isA(org.broadleafcommerce.core.catalog.domain.Category.class), eq(1),
        eq(2));
    assertTrue(actualFindAllSubCategoriesResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#findActiveSubCategoriesByCategory(Category)} with {@code category}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#findActiveSubCategoriesByCategory(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List CatalogServiceImpl.findActiveSubCategoriesByCategory(org.broadleafcommerce.core.catalog.domain.Category)"})
  public void testFindActiveSubCategoriesByCategoryWithCategory() {
    // Arrange
    when(categoryDao
        .readActiveSubCategoriesByCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<org.broadleafcommerce.core.catalog.domain.Category> actualFindActiveSubCategoriesByCategoryResult = catalogServiceImpl
        .findActiveSubCategoriesByCategory(new CategoryImpl());

    // Assert
    verify(categoryDao)
        .readActiveSubCategoriesByCategory(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    assertTrue(actualFindActiveSubCategoriesByCategoryResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#findActiveSubCategoriesByCategory(Category, int, int)} with {@code category}, {@code limit}, {@code offset}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#findActiveSubCategoriesByCategory(org.broadleafcommerce.core.catalog.domain.Category, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List CatalogServiceImpl.findActiveSubCategoriesByCategory(org.broadleafcommerce.core.catalog.domain.Category, int, int)"})
  public void testFindActiveSubCategoriesByCategoryWithCategoryLimitOffset() {
    // Arrange
    when(categoryDao.readActiveSubCategoriesByCategory(
        Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any(), anyInt(), anyInt()))
        .thenReturn(new ArrayList<>());

    // Act
    List<org.broadleafcommerce.core.catalog.domain.Category> actualFindActiveSubCategoriesByCategoryResult = catalogServiceImpl
        .findActiveSubCategoriesByCategory(new CategoryImpl(), 1, 2);

    // Assert
    verify(categoryDao).readActiveSubCategoriesByCategory(isA(org.broadleafcommerce.core.catalog.domain.Category.class),
        eq(1), eq(2));
    assertTrue(actualFindActiveSubCategoriesByCategoryResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#findAllProducts()}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#findAllProducts()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CatalogServiceImpl.findAllProducts()"})
  public void testFindAllProducts() {
    // Arrange
    when(categoryDao.readAllProducts()).thenReturn(new ArrayList<>());

    // Act
    List<Product> actualFindAllProductsResult = catalogServiceImpl.findAllProducts();

    // Assert
    verify(categoryDao).readAllProducts();
    assertTrue(actualFindAllProductsResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#findAllProducts(int, int)} with {@code int}, {@code int}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#findAllProducts(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CatalogServiceImpl.findAllProducts(int, int)"})
  public void testFindAllProductsWithIntInt() {
    // Arrange
    when(categoryDao.readAllProducts(anyInt(), anyInt())).thenReturn(new ArrayList<>());

    // Act
    List<Product> actualFindAllProductsResult = catalogServiceImpl.findAllProducts(1, 2);

    // Assert
    verify(categoryDao).readAllProducts(eq(1), eq(2));
    assertTrue(actualFindAllProductsResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#findAllSkus()}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#findAllSkus()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CatalogServiceImpl.findAllSkus()"})
  public void testFindAllSkus() {
    // Arrange
    when(skuDao.readAllSkus()).thenReturn(new ArrayList<>());

    // Act
    List<Sku> actualFindAllSkusResult = catalogServiceImpl.findAllSkus();

    // Assert
    verify(skuDao).readAllSkus();
    assertTrue(actualFindAllSkusResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#findAllSkus(int, int)} with {@code int}, {@code int}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#findAllSkus(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CatalogServiceImpl.findAllSkus(int, int)"})
  public void testFindAllSkusWithIntInt() {
    // Arrange
    when(skuDao.readAllSkus(anyInt(), anyInt())).thenReturn(new ArrayList<>());

    // Act
    List<Sku> actualFindAllSkusResult = catalogServiceImpl.findAllSkus(2, 1);

    // Assert
    verify(skuDao).readAllSkus(eq(2), eq(1));
    assertTrue(actualFindAllSkusResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#findSkuById(Long)}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#findSkuById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku CatalogServiceImpl.findSkuById(Long)"})
  public void testFindSkuById() {
    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(skuImpl);

    // Act
    Sku actualFindSkuByIdResult = catalogServiceImpl.findSkuById(1L);

    // Assert
    verify(skuDao).readSkuById(eq(1L));
    assertSame(skuImpl, actualFindSkuByIdResult);
  }

  /**
   * Test {@link CatalogServiceImpl#findSkuByExternalId(String)}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#findSkuByExternalId(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku CatalogServiceImpl.findSkuByExternalId(String)"})
  public void testFindSkuByExternalId() {
    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    when(skuDao.readSkuByExternalId(Mockito.<String>any())).thenReturn(skuImpl);

    // Act
    Sku actualFindSkuByExternalIdResult = catalogServiceImpl.findSkuByExternalId("42");

    // Assert
    verify(skuDao).readSkuByExternalId(eq("42"));
    assertSame(skuImpl, actualFindSkuByExternalIdResult);
  }

  /**
   * Test {@link CatalogServiceImpl#findSkuByUpc(String)}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#findSkuByUpc(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku CatalogServiceImpl.findSkuByUpc(String)"})
  public void testFindSkuByUpc() {
    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    when(skuDao.readSkuByUpc(Mockito.<String>any())).thenReturn(skuImpl);

    // Act
    Sku actualFindSkuByUpcResult = catalogServiceImpl.findSkuByUpc("Upc");

    // Assert
    verify(skuDao).readSkuByUpc(eq("Upc"));
    assertSame(skuImpl, actualFindSkuByUpcResult);
  }

  /**
   * Test {@link CatalogServiceImpl#saveSku(Sku)}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#saveSku(Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku CatalogServiceImpl.saveSku(Sku)"})
  public void testSaveSku() {
    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    when(skuDao.save(Mockito.<Sku>any())).thenReturn(skuImpl);

    // Act
    Sku actualSaveSkuResult = catalogServiceImpl.saveSku(new SkuImpl());

    // Assert
    verify(skuDao).save(isA(Sku.class));
    assertSame(skuImpl, actualSaveSkuResult);
  }

  /**
   * Test {@link CatalogServiceImpl#saveSkuFee(SkuFee)}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#saveSkuFee(SkuFee)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SkuFee CatalogServiceImpl.saveSkuFee(SkuFee)"})
  public void testSaveSkuFee() {
    // Arrange
    SkuFeeImpl skuFeeImpl = new SkuFeeImpl();
    when(skuDao.saveSkuFee(Mockito.<SkuFee>any())).thenReturn(skuFeeImpl);

    // Act
    SkuFee actualSaveSkuFeeResult = catalogServiceImpl.saveSkuFee(new SkuFeeImpl());

    // Assert
    verify(skuDao).saveSkuFee(isA(SkuFee.class));
    assertSame(skuFeeImpl, actualSaveSkuFeeResult);
  }

  /**
   * Test {@link CatalogServiceImpl#findSkusByIds(List)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link ArrayList#ArrayList()} add one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findSkusByIds(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CatalogServiceImpl.findSkusByIds(List)"})
  public void testFindSkusByIds_givenOne_whenArrayListAddOne() {
    // Arrange
    when(skuDao.readSkusByIds(Mockito.<List<Long>>any())).thenReturn(new ArrayList<>());

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act
    List<Sku> actualFindSkusByIdsResult = catalogServiceImpl.findSkusByIds(ids);

    // Assert
    verify(skuDao).readSkusByIds(isA(List.class));
    assertTrue(actualFindSkusByIdsResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#findSkusByIds(List)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link ArrayList#ArrayList()} add zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findSkusByIds(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CatalogServiceImpl.findSkusByIds(List)"})
  public void testFindSkusByIds_givenZero_whenArrayListAddZero() {
    // Arrange
    when(skuDao.readSkusByIds(Mockito.<List<Long>>any())).thenReturn(new ArrayList<>());

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(0L);
    ids.add(1L);

    // Act
    List<Sku> actualFindSkusByIdsResult = catalogServiceImpl.findSkusByIds(ids);

    // Assert
    verify(skuDao).readSkusByIds(isA(List.class));
    assertTrue(actualFindSkusByIdsResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#findSkusByIds(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findSkusByIds(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CatalogServiceImpl.findSkusByIds(List)"})
  public void testFindSkusByIds_whenArrayList() {
    // Arrange
    when(skuDao.readSkusByIds(Mockito.<List<Long>>any())).thenReturn(new ArrayList<>());

    // Act
    List<Sku> actualFindSkusByIdsResult = catalogServiceImpl.findSkusByIds(new ArrayList<>());

    // Assert
    verify(skuDao).readSkusByIds(isA(List.class));
    assertTrue(actualFindSkusByIdsResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#findProductsForCategory(Category, int, int)} with {@code category}, {@code limit}, {@code offset}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findProductsForCategory(org.broadleafcommerce.core.catalog.domain.Category, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List CatalogServiceImpl.findProductsForCategory(org.broadleafcommerce.core.catalog.domain.Category, int, int)"})
  public void testFindProductsForCategoryWithCategoryLimitOffset_thenReturnEmpty() {
    // Arrange
    when(productDao.readProductsByCategory(Mockito.<Long>any(), anyInt(), anyInt())).thenReturn(new ArrayList<>());

    // Act
    List<Product> actualFindProductsForCategoryResult = catalogServiceImpl.findProductsForCategory(new CategoryImpl(),
        1, 2);

    // Assert
    verify(productDao).readProductsByCategory(isNull(), eq(1), eq(2));
    assertTrue(actualFindProductsForCategoryResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#findProductsForCategory(Category)} with {@code category}.
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findProductsForCategory(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List CatalogServiceImpl.findProductsForCategory(org.broadleafcommerce.core.catalog.domain.Category)"})
  public void testFindProductsForCategoryWithCategory_whenCategoryImpl_thenReturnEmpty() {
    // Arrange
    when(productDao.readProductsByCategory(Mockito.<Long>any())).thenReturn(new ArrayList<>());

    // Act
    List<Product> actualFindProductsForCategoryResult = catalogServiceImpl.findProductsForCategory(new CategoryImpl());

    // Assert
    verify(productDao).readProductsByCategory(isNull());
    assertTrue(actualFindProductsForCategoryResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#getChildCategoryURLMapByCategoryId(Long)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#getChildCategoryURLMapByCategoryId(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CatalogServiceImpl.getChildCategoryURLMapByCategoryId(Long)"})
  public void testGetChildCategoryURLMapByCategoryId_thenReturnEmpty() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getChildCategoryURLMap()).thenReturn(new HashMap<>());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(categoryImpl);

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
   * Method under test: {@link CatalogServiceImpl#getChildCategoryURLMapByCategoryId(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CatalogServiceImpl.getChildCategoryURLMapByCategoryId(Long)"})
  public void testGetChildCategoryURLMapByCategoryId_thenReturnNull() {
    // Arrange
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(null);

    // Act
    Map<String, List<Long>> actualChildCategoryURLMapByCategoryId = catalogServiceImpl
        .getChildCategoryURLMapByCategoryId(1L);

    // Assert
    verify(categoryDao).readCategoryById(eq(1L));
    assertNull(actualChildCategoryURLMapByCategoryId);
  }

  /**
   * Test {@link CatalogServiceImpl#createCategory()}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#createCategory()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.broadleafcommerce.core.catalog.domain.Category CatalogServiceImpl.createCategory()"})
  public void testCreateCategory() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    when(categoryDao.create()).thenReturn(categoryImpl);

    // Act
    org.broadleafcommerce.core.catalog.domain.Category actualCreateCategoryResult = catalogServiceImpl.createCategory();

    // Assert
    verify(categoryDao).create();
    assertSame(categoryImpl, actualCreateCategoryResult);
  }

  /**
   * Test {@link CatalogServiceImpl#createSku()}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#createSku()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku CatalogServiceImpl.createSku()"})
  public void testCreateSku() {
    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    when(skuDao.create()).thenReturn(skuImpl);

    // Act
    Sku actualCreateSkuResult = catalogServiceImpl.createSku();

    // Assert
    verify(skuDao).create();
    assertSame(skuImpl, actualCreateSkuResult);
  }

  /**
   * Test {@link CatalogServiceImpl#createProduct(ProductType)}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#createProduct(ProductType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Product CatalogServiceImpl.createProduct(ProductType)"})
  public void testCreateProduct() {
    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    when(productDao.create(Mockito.<ProductType>any())).thenReturn(productBundleImpl);

    // Act
    Product actualCreateProductResult = catalogServiceImpl.createProduct(ProductType.BUNDLE);

    // Assert
    verify(productDao).create(isA(ProductType.class));
    assertSame(productBundleImpl, actualCreateProductResult);
  }

  /**
   * Test {@link CatalogServiceImpl#readAllProductOptions()}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#readAllProductOptions()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CatalogServiceImpl.readAllProductOptions()"})
  public void testReadAllProductOptions() {
    // Arrange
    when(productOptionDao.readAllProductOptions()).thenReturn(new ArrayList<>());

    // Act
    List<ProductOption> actualReadAllProductOptionsResult = catalogServiceImpl.readAllProductOptions();

    // Assert
    verify(productOptionDao).readAllProductOptions();
    assertTrue(actualReadAllProductOptionsResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#saveProductOption(ProductOption)}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#saveProductOption(ProductOption)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProductOption CatalogServiceImpl.saveProductOption(ProductOption)"})
  public void testSaveProductOption() {
    // Arrange
    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    when(productOptionDao.saveProductOption(Mockito.<ProductOption>any())).thenReturn(productOptionImpl);

    // Act
    ProductOption actualSaveProductOptionResult = catalogServiceImpl.saveProductOption(new ProductOptionImpl());

    // Assert
    verify(productOptionDao).saveProductOption(isA(ProductOption.class));
    assertSame(productOptionImpl, actualSaveProductOptionResult);
  }

  /**
   * Test {@link CatalogServiceImpl#findProductOptionById(Long)}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#findProductOptionById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProductOption CatalogServiceImpl.findProductOptionById(Long)"})
  public void testFindProductOptionById() {
    // Arrange
    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    when(productOptionDao.readProductOptionById(Mockito.<Long>any())).thenReturn(productOptionImpl);

    // Act
    ProductOption actualFindProductOptionByIdResult = catalogServiceImpl.findProductOptionById(1L);

    // Assert
    verify(productOptionDao).readProductOptionById(eq(1L));
    assertSame(productOptionImpl, actualFindProductOptionByIdResult);
  }

  /**
   * Test {@link CatalogServiceImpl#findProductOptionValueById(Long)}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#findProductOptionValueById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProductOptionValue CatalogServiceImpl.findProductOptionValueById(Long)"})
  public void testFindProductOptionValueById() {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    when(productOptionDao.readProductOptionValueById(Mockito.<Long>any())).thenReturn(productOptionValueImpl);

    // Act
    ProductOptionValue actualFindProductOptionValueByIdResult = catalogServiceImpl.findProductOptionValueById(1L);

    // Assert
    verify(productOptionDao).readProductOptionValueById(eq(1L));
    assertSame(productOptionValueImpl, actualFindProductOptionValueByIdResult);
  }

  /**
   * Test {@link CatalogServiceImpl#createCatalogContextDTO()}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#createCatalogContextDTO()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CatalogContextDTO CatalogServiceImpl.createCatalogContextDTO()"})
  public void testCreateCatalogContextDTO() {
    // Arrange, Act and Assert
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.broadleafcommerce.core.catalog.domain.Category CatalogServiceImpl.findCategoryByURI(String)"})
  public void testFindCategoryByURI_thenReturnCategoryImpl() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    when(categoryDao.findCategoryByURI(Mockito.<String>any())).thenReturn(categoryImpl);
    CatalogServiceExtensionHandler catalogServiceExtensionHandler = mock(CatalogServiceExtensionHandler.class);
    when(catalogServiceExtensionHandler.findCategoryByURI(Mockito.<CatalogContextDTO>any(), Mockito.<String>any(),
        Mockito.<ExtensionResultHolder<Object>>any())).thenReturn(null);
    when(catalogServiceExtensionManager.getProxy()).thenReturn(catalogServiceExtensionHandler);

    // Act
    org.broadleafcommerce.core.catalog.domain.Category actualFindCategoryByURIResult = catalogServiceImpl
        .findCategoryByURI("Uri");

    // Assert
    verify(catalogServiceExtensionManager).getProxy();
    verify(categoryDao).findCategoryByURI(eq("Uri"));
    verify(catalogServiceExtensionHandler).findCategoryByURI(isA(CatalogContextDTO.class), eq("Uri"),
        isA(ExtensionResultHolder.class));
    assertSame(categoryImpl, actualFindCategoryByURIResult);
  }

  /**
   * Test {@link CatalogServiceImpl#findCategoryByURI(String)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findCategoryByURI(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.broadleafcommerce.core.catalog.domain.Category CatalogServiceImpl.findCategoryByURI(String)"})
  public void testFindCategoryByURI_thenReturnNull() {
    // Arrange
    CatalogServiceExtensionHandler catalogServiceExtensionHandler = mock(CatalogServiceExtensionHandler.class);
    when(catalogServiceExtensionHandler.findCategoryByURI(Mockito.<CatalogContextDTO>any(), Mockito.<String>any(),
        Mockito.<ExtensionResultHolder<Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(catalogServiceExtensionManager.getProxy()).thenReturn(catalogServiceExtensionHandler);

    // Act
    org.broadleafcommerce.core.catalog.domain.Category actualFindCategoryByURIResult = catalogServiceImpl
        .findCategoryByURI("Uri");

    // Assert
    verify(catalogServiceExtensionManager).getProxy();
    verify(catalogServiceExtensionHandler).findCategoryByURI(isA(CatalogContextDTO.class), eq("Uri"),
        isA(ExtensionResultHolder.class));
    assertNull(actualFindCategoryByURIResult);
  }

  /**
   * Test {@link CatalogServiceImpl#findOriginalCategoryByURI(String)}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#findOriginalCategoryByURI(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.catalog.domain.Category CatalogServiceImpl.findOriginalCategoryByURI(String)"})
  public void testFindOriginalCategoryByURI() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    when(categoryDao.findCategoryByURI(Mockito.<String>any())).thenReturn(categoryImpl);

    // Act
    org.broadleafcommerce.core.catalog.domain.Category actualFindOriginalCategoryByURIResult = catalogServiceImpl
        .findOriginalCategoryByURI("Uri");

    // Assert
    verify(categoryDao).findCategoryByURI(eq("Uri"));
    assertSame(categoryImpl, actualFindOriginalCategoryByURIResult);
  }

  /**
   * Test {@link CatalogServiceImpl#findProductByURI(String)}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#findProductByURI(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Product CatalogServiceImpl.findProductByURI(String)"})
  public void testFindProductByURI() {
    // Arrange
    CatalogServiceExtensionHandler catalogServiceExtensionHandler = mock(CatalogServiceExtensionHandler.class);
    when(catalogServiceExtensionHandler.findProductByURI(Mockito.<CatalogContextDTO>any(), Mockito.<String>any(),
        Mockito.<ExtensionResultHolder<Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(catalogServiceExtensionManager.getProxy()).thenReturn(catalogServiceExtensionHandler);

    // Act
    Product actualFindProductByURIResult = catalogServiceImpl.findProductByURI("Uri");

    // Assert
    verify(catalogServiceExtensionManager).getProxy();
    verify(catalogServiceExtensionHandler).findProductByURI(isA(CatalogContextDTO.class), eq("Uri"),
        isA(ExtensionResultHolder.class));
    assertNull(actualFindProductByURIResult);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Product CatalogServiceImpl.findProductByURI(String)"})
  public void testFindProductByURI_thenReturnNull() {
    // Arrange
    CatalogServiceExtensionHandler catalogServiceExtensionHandler = mock(CatalogServiceExtensionHandler.class);
    when(catalogServiceExtensionHandler.findProductByURI(Mockito.<CatalogContextDTO>any(), Mockito.<String>any(),
        Mockito.<ExtensionResultHolder<Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED_CONTINUE);
    when(catalogServiceExtensionManager.getProxy()).thenReturn(catalogServiceExtensionHandler);
    when(productDao.findProductByURI(Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    Product actualFindProductByURIResult = catalogServiceImpl.findProductByURI("Uri");

    // Assert
    verify(catalogServiceExtensionManager).getProxy();
    verify(productDao).findProductByURI(eq("Uri"));
    verify(catalogServiceExtensionHandler).findProductByURI(isA(CatalogContextDTO.class), eq("Uri"),
        isA(ExtensionResultHolder.class));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Product CatalogServiceImpl.findProductByURI(String)"})
  public void testFindProductByURI_thenReturnProductBundleImpl() {
    // Arrange
    CatalogServiceExtensionHandler catalogServiceExtensionHandler = mock(CatalogServiceExtensionHandler.class);
    when(catalogServiceExtensionHandler.findProductByURI(Mockito.<CatalogContextDTO>any(), Mockito.<String>any(),
        Mockito.<ExtensionResultHolder<Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED_CONTINUE);
    when(catalogServiceExtensionManager.getProxy()).thenReturn(catalogServiceExtensionHandler);

    ArrayList<Product> productList = new ArrayList<>();
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productList.add(productBundleImpl);
    when(productDao.findProductByURI(Mockito.<String>any())).thenReturn(productList);

    // Act
    Product actualFindProductByURIResult = catalogServiceImpl.findProductByURI("Uri");

    // Assert
    verify(catalogServiceExtensionManager).getProxy();
    verify(productDao).findProductByURI(eq("Uri"));
    verify(catalogServiceExtensionHandler).findProductByURI(isA(CatalogContextDTO.class), eq("Uri"),
        isA(ExtensionResultHolder.class));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Product CatalogServiceImpl.findProductByURI(String)"})
  public void testFindProductByURI_thenReturnProductBundleImpl2() {
    // Arrange
    CatalogServiceExtensionHandler catalogServiceExtensionHandler = mock(CatalogServiceExtensionHandler.class);
    when(catalogServiceExtensionHandler.findProductByURI(Mockito.<CatalogContextDTO>any(), Mockito.<String>any(),
        Mockito.<ExtensionResultHolder<Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED_CONTINUE);
    when(catalogServiceExtensionManager.getProxy()).thenReturn(catalogServiceExtensionHandler);

    ArrayList<Product> productList = new ArrayList<>();
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productList.add(productBundleImpl);
    productList.add(new ProductBundleImpl());
    when(productDao.findProductByURI(Mockito.<String>any())).thenReturn(productList);

    // Act
    Product actualFindProductByURIResult = catalogServiceImpl.findProductByURI("Uri");

    // Assert
    verify(catalogServiceExtensionManager).getProxy();
    verify(productDao).findProductByURI(eq("Uri"));
    verify(catalogServiceExtensionHandler).findProductByURI(isA(CatalogContextDTO.class), eq("Uri"),
        isA(ExtensionResultHolder.class));
    assertSame(productBundleImpl, actualFindProductByURIResult);
  }

  /**
   * Test {@link CatalogServiceImpl#findOriginalProductByURI(String)}.
   * <ul>
   *   <li>Then return {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findOriginalProductByURI(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Product CatalogServiceImpl.findOriginalProductByURI(String)"})
  public void testFindOriginalProductByURI_thenReturnProductBundleImpl() {
    // Arrange
    ArrayList<Product> productList = new ArrayList<>();
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productList.add(productBundleImpl);
    when(productDao.findProductByURI(Mockito.<String>any())).thenReturn(productList);

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
   * Method under test: {@link CatalogServiceImpl#findOriginalProductByURI(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Product CatalogServiceImpl.findOriginalProductByURI(String)"})
  public void testFindOriginalProductByURI_thenReturnProductBundleImpl2() {
    // Arrange
    ArrayList<Product> productList = new ArrayList<>();
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productList.add(productBundleImpl);
    productList.add(new ProductBundleImpl());
    when(productDao.findProductByURI(Mockito.<String>any())).thenReturn(productList);

    // Act
    Product actualFindOriginalProductByURIResult = catalogServiceImpl.findOriginalProductByURI("Uri");

    // Assert
    verify(productDao).findProductByURI(eq("Uri"));
    assertSame(productBundleImpl, actualFindOriginalProductByURIResult);
  }

  /**
   * Test {@link CatalogServiceImpl#findOriginalProductByURI(String)}.
   * <ul>
   *   <li>When {@code Uri}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findOriginalProductByURI(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Product CatalogServiceImpl.findOriginalProductByURI(String)"})
  public void testFindOriginalProductByURI_whenUri_thenReturnNull() {
    // Arrange
    when(productDao.findProductByURI(Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    Product actualFindOriginalProductByURIResult = catalogServiceImpl.findOriginalProductByURI("Uri");

    // Assert
    verify(productDao).findProductByURI(eq("Uri"));
    assertNull(actualFindOriginalProductByURIResult);
  }

  /**
   * Test {@link CatalogServiceImpl#findSkuByURI(String)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link SkuImpl} (default constructor).</li>
   *   <li>When {@code Uri}.</li>
   *   <li>Then return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findSkuByURI(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku CatalogServiceImpl.findSkuByURI(String)"})
  public void testFindSkuByURI_givenArrayListAddSkuImpl_whenUri_thenReturnSkuImpl() {
    // Arrange
    CatalogServiceExtensionHandler catalogServiceExtensionHandler = mock(CatalogServiceExtensionHandler.class);
    when(catalogServiceExtensionHandler.findSkuByURI(Mockito.<CatalogContextDTO>any(), Mockito.<String>any(),
        Mockito.<ExtensionResultHolder<Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED_CONTINUE);
    when(catalogServiceExtensionManager.getProxy()).thenReturn(catalogServiceExtensionHandler);

    ArrayList<Sku> skuList = new ArrayList<>();
    SkuImpl skuImpl = new SkuImpl();
    skuList.add(skuImpl);
    when(skuDao.findSkuByURI(Mockito.<String>any())).thenReturn(skuList);

    // Act
    Sku actualFindSkuByURIResult = catalogServiceImpl.findSkuByURI("Uri");

    // Assert
    verify(catalogServiceExtensionManager).getProxy();
    verify(skuDao).findSkuByURI(eq("Uri"));
    verify(catalogServiceExtensionHandler).findSkuByURI(isA(CatalogContextDTO.class), eq("Uri"),
        isA(ExtensionResultHolder.class));
    assertSame(skuImpl, actualFindSkuByURIResult);
  }

  /**
   * Test {@link CatalogServiceImpl#findSkuByURI(String)}.
   * <ul>
   *   <li>Given {@link CatalogServiceExtensionHandler} {@link CatalogServiceExtensionHandler#findSkuByURI(CatalogContextDTO, String, ExtensionResultHolder)} return {@code HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findSkuByURI(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku CatalogServiceImpl.findSkuByURI(String)"})
  public void testFindSkuByURI_givenCatalogServiceExtensionHandlerFindSkuByURIReturnHandled() {
    // Arrange
    CatalogServiceExtensionHandler catalogServiceExtensionHandler = mock(CatalogServiceExtensionHandler.class);
    when(catalogServiceExtensionHandler.findSkuByURI(Mockito.<CatalogContextDTO>any(), Mockito.<String>any(),
        Mockito.<ExtensionResultHolder<Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(catalogServiceExtensionManager.getProxy()).thenReturn(catalogServiceExtensionHandler);

    // Act
    Sku actualFindSkuByURIResult = catalogServiceImpl.findSkuByURI("Uri");

    // Assert
    verify(catalogServiceExtensionManager).getProxy();
    verify(catalogServiceExtensionHandler).findSkuByURI(isA(CatalogContextDTO.class), eq("Uri"),
        isA(ExtensionResultHolder.class));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku CatalogServiceImpl.findSkuByURI(String)"})
  public void testFindSkuByURI_thenCallsGetProduct() {
    // Arrange
    CatalogServiceExtensionHandler catalogServiceExtensionHandler = mock(CatalogServiceExtensionHandler.class);
    when(catalogServiceExtensionHandler.findSkuByURI(Mockito.<CatalogContextDTO>any(), Mockito.<String>any(),
        Mockito.<ExtensionResultHolder<Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED_CONTINUE);
    when(catalogServiceExtensionManager.getProxy()).thenReturn(catalogServiceExtensionHandler);
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getUrlKey()).thenReturn("https://example.org/example");
    when(skuImpl.getProduct()).thenReturn(new ProductBundleImpl());
    SkuImpl skuImpl2 = mock(SkuImpl.class);
    when(skuImpl2.getUrlKey()).thenReturn("https://example.org/example");
    when(skuImpl2.getProduct()).thenReturn(new ProductBundleImpl());

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(skuImpl2);
    skuList.add(skuImpl);
    when(skuDao.findSkuByURI(Mockito.<String>any())).thenReturn(skuList);

    // Act
    catalogServiceImpl.findSkuByURI("Uri");

    // Assert
    verify(catalogServiceExtensionManager).getProxy();
    verify(skuDao).findSkuByURI(eq("Uri"));
    verify(skuImpl2).getProduct();
    verify(skuImpl).getProduct();
    verify(skuImpl2).getUrlKey();
    verify(skuImpl).getUrlKey();
    verify(catalogServiceExtensionHandler).findSkuByURI(isA(CatalogContextDTO.class), eq("Uri"),
        isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link CatalogServiceImpl#findSkuByURI(String)}.
   * <ul>
   *   <li>When {@code Uri}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogServiceImpl#findSkuByURI(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku CatalogServiceImpl.findSkuByURI(String)"})
  public void testFindSkuByURI_whenUri_thenReturnNull() {
    // Arrange
    CatalogServiceExtensionHandler catalogServiceExtensionHandler = mock(CatalogServiceExtensionHandler.class);
    when(catalogServiceExtensionHandler.findSkuByURI(Mockito.<CatalogContextDTO>any(), Mockito.<String>any(),
        Mockito.<ExtensionResultHolder<Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED_CONTINUE);
    when(catalogServiceExtensionManager.getProxy()).thenReturn(catalogServiceExtensionHandler);
    when(skuDao.findSkuByURI(Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    Sku actualFindSkuByURIResult = catalogServiceImpl.findSkuByURI("Uri");

    // Assert
    verify(catalogServiceExtensionManager).getProxy();
    verify(skuDao).findSkuByURI(eq("Uri"));
    verify(catalogServiceExtensionHandler).findSkuByURI(isA(CatalogContextDTO.class), eq("Uri"),
        isA(ExtensionResultHolder.class));
    assertNull(actualFindSkuByURIResult);
  }

  /**
   * Test {@link CatalogServiceImpl#findAssignedProductOptionsByProductId(Long)}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#findAssignedProductOptionsByProductId(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CatalogServiceImpl.findAssignedProductOptionsByProductId(Long)"})
  public void testFindAssignedProductOptionsByProductId() {
    // Arrange
    when(productOptionDao.findAssignedProductOptionsByProductId(Mockito.<Long>any())).thenReturn(new ArrayList<>());

    // Act
    List<AssignedProductOptionDTO> actualFindAssignedProductOptionsByProductIdResult = catalogServiceImpl
        .findAssignedProductOptionsByProductId(1L);

    // Assert
    verify(productOptionDao).findAssignedProductOptionsByProductId(eq(1L));
    assertTrue(actualFindAssignedProductOptionsByProductIdResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#findAssignedProductOptionsByProduct(Product)}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#findAssignedProductOptionsByProduct(Product)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CatalogServiceImpl.findAssignedProductOptionsByProduct(Product)"})
  public void testFindAssignedProductOptionsByProduct() {
    // Arrange
    when(productOptionDao.findAssignedProductOptionsByProduct(Mockito.<Product>any())).thenReturn(new ArrayList<>());

    // Act
    List<AssignedProductOptionDTO> actualFindAssignedProductOptionsByProductResult = catalogServiceImpl
        .findAssignedProductOptionsByProduct(new ProductBundleImpl());

    // Assert
    verify(productOptionDao).findAssignedProductOptionsByProduct(isA(Product.class));
    assertTrue(actualFindAssignedProductOptionsByProductResult.isEmpty());
  }

  /**
   * Test {@link CatalogServiceImpl#countProductsUsingProductOptionById(Long)}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#countProductsUsingProductOptionById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long CatalogServiceImpl.countProductsUsingProductOptionById(Long)"})
  public void testCountProductsUsingProductOptionById() {
    // Arrange
    when(productOptionDao.countProductsUsingProductOptionById(Mockito.<Long>any())).thenReturn(1L);

    // Act
    Long actualCountProductsUsingProductOptionByIdResult = catalogServiceImpl.countProductsUsingProductOptionById(1L);

    // Assert
    verify(productOptionDao).countProductsUsingProductOptionById(eq(1L));
    assertEquals(1L, actualCountProductsUsingProductOptionByIdResult.longValue());
  }

  /**
   * Test {@link CatalogServiceImpl#findProductIdsUsingProductOptionById(Long, int, int)}.
   * <p>
   * Method under test: {@link CatalogServiceImpl#findProductIdsUsingProductOptionById(Long, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CatalogServiceImpl.findProductIdsUsingProductOptionById(Long, int, int)"})
  public void testFindProductIdsUsingProductOptionById() {
    // Arrange
    when(productOptionDao.findProductIdsUsingProductOptionById(Mockito.<Long>any(), anyInt(), anyInt()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Long> actualFindProductIdsUsingProductOptionByIdResult = catalogServiceImpl
        .findProductIdsUsingProductOptionById(1L, 1, 3);

    // Assert
    verify(productOptionDao).findProductIdsUsingProductOptionById(eq(1L), eq(1), eq(3));
    assertTrue(actualFindProductIdsUsingProductOptionByIdResult.isEmpty());
  }
}

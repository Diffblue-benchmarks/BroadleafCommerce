/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.server.service.persistence.module.provider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import org.broadleafcommerce.admin.server.service.persistence.module.provider.extension.ProductParentCategoryFieldPersistenceProviderExtensionManager;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.CategoryProductXref;
import org.broadleafcommerce.core.catalog.domain.CategoryProductXrefImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.ExtractValueRequest;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.PopulateValueRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ProductParentCategoryFieldPersistenceProvider.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductParentCategoryFieldPersistenceProviderDiffblueTest {
  @Autowired
  private ProductParentCategoryFieldPersistenceProvider
      productParentCategoryFieldPersistenceProvider;

  @MockBean(name = "blProductParentCategoryFieldPersistenceProviderExtensionManager")
  private ProductParentCategoryFieldPersistenceProviderExtensionManager
      productParentCategoryFieldPersistenceProviderExtensionManager;

  /**
   * Test {@link ProductParentCategoryFieldPersistenceProvider#populateValue(PopulateValueRequest,
   * Serializable)}.
   *
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductParentCategoryFieldPersistenceProvider#populateValue(PopulateValueRequest,
   * Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse ProductParentCategoryFieldPersistenceProvider.populateValue(PopulateValueRequest, Serializable)"
  })
  public void testPopulateValue_thenReturnNotHandled() {
    // Arrange
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act
    MetadataProviderResponse actualPopulateValueResult =
        productParentCategoryFieldPersistenceProvider.populateValue(
            populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualPopulateValueResult);
  }

  /**
   * Test {@link ProductParentCategoryFieldPersistenceProvider#extractValue(ExtractValueRequest,
   * Property)}.
   *
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductParentCategoryFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse ProductParentCategoryFieldPersistenceProvider.extractValue(ExtractValueRequest, Property)"
  })
  public void testExtractValue_thenReturnNotHandled() {
    // Arrange
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    String[] customCriteria = new String[] {"Custom Criteria"};

    ExtractValueRequest extractValueRequest =
        new ExtractValueRequest(
            props,
            fieldManager,
            metadata,
            "Requested Value",
            "Display Val",
            persistenceManager,
            recordHelper,
            new SimpleDateFormat("yyyy/mm/dd"),
            customCriteria);

    // Act and Assert
    assertEquals(
        MetadataProviderResponse.NOT_HANDLED,
        productParentCategoryFieldPersistenceProvider.extractValue(
            extractValueRequest, new Property()));
  }

  /**
   * Test {@link ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)} with
   * {@code instance}, {@code checkValue}.
   *
   * <p>Method under test: {@link
   * ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductParentCategoryFieldPersistenceProvider.checkDirtyState(Product, Long)"
  })
  public void testCheckDirtyStateWithInstanceCheckValue() {
    // Arrange
    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();
    categoryProductXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl.setId(1L);
    categoryProductXrefImpl.setProduct(new ProductBundleImpl());
    categoryProductXrefImpl.setCategory(new CategoryImpl());
    categoryProductXrefImpl.setDefaultReference(null);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);

    Product instance = mock(Product.class);
    when(instance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    // Act
    boolean actualCheckDirtyStateResult =
        productParentCategoryFieldPersistenceProvider.checkDirtyState(instance, 42L);

    // Assert
    verify(instance).getAllParentCategoryXrefs();
    assertTrue(actualCheckDirtyStateResult);
  }

  /**
   * Test {@link ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)} with
   * {@code instance}, {@code checkValue}.
   *
   * <p>Method under test: {@link
   * ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductParentCategoryFieldPersistenceProvider.checkDirtyState(Product, Long)"
  })
  public void testCheckDirtyStateWithInstanceCheckValue2() {
    // Arrange
    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();
    categoryProductXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl.setId(1L);
    categoryProductXrefImpl.setProduct(new ProductBundleImpl());
    categoryProductXrefImpl.setCategory(new CategoryImpl());
    categoryProductXrefImpl.setDefaultReference(true);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);

    Product instance = mock(Product.class);
    when(instance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    // Act
    boolean actualCheckDirtyStateResult =
        productParentCategoryFieldPersistenceProvider.checkDirtyState(instance, 42L);

    // Assert
    verify(instance).getAllParentCategoryXrefs();
    assertTrue(actualCheckDirtyStateResult);
  }

  /**
   * Test {@link ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)} with
   * {@code instance}, {@code checkValue}.
   *
   * <p>Method under test: {@link
   * ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductParentCategoryFieldPersistenceProvider.checkDirtyState(Product, Long)"
  })
  public void testCheckDirtyStateWithInstanceCheckValue3() {
    // Arrange
    org.broadleafcommerce.core.catalog.domain.Category category =
        mock(org.broadleafcommerce.core.catalog.domain.Category.class);
    when(category.isActive()).thenReturn(true);

    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();
    categoryProductXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl.setId(1L);
    categoryProductXrefImpl.setProduct(new ProductBundleImpl());
    categoryProductXrefImpl.setCategory(category);
    categoryProductXrefImpl.setDefaultReference(null);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);

    Product instance = mock(Product.class);
    when(instance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    // Act
    boolean actualCheckDirtyStateResult =
        productParentCategoryFieldPersistenceProvider.checkDirtyState(instance, 42L);

    // Assert
    verify(category).isActive();
    verify(instance).getAllParentCategoryXrefs();
    assertTrue(actualCheckDirtyStateResult);
  }

  /**
   * Test {@link ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)} with
   * {@code instance}, {@code checkValue}.
   *
   * <p>Method under test: {@link
   * ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductParentCategoryFieldPersistenceProvider.checkDirtyState(Product, Long)"
  })
  public void testCheckDirtyStateWithInstanceCheckValue4() {
    // Arrange
    org.broadleafcommerce.core.catalog.domain.Category category =
        mock(org.broadleafcommerce.core.catalog.domain.Category.class);
    when(category.isActive()).thenReturn(true);

    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();
    categoryProductXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl.setId(1L);
    categoryProductXrefImpl.setProduct(new ProductBundleImpl());
    categoryProductXrefImpl.setCategory(category);
    categoryProductXrefImpl.setDefaultReference(false);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);

    Product instance = mock(Product.class);
    when(instance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    // Act
    boolean actualCheckDirtyStateResult =
        productParentCategoryFieldPersistenceProvider.checkDirtyState(instance, 42L);

    // Assert
    verify(category).isActive();
    verify(instance).getAllParentCategoryXrefs();
    assertTrue(actualCheckDirtyStateResult);
  }

  /**
   * Test {@link ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)} with
   * {@code instance}, {@code checkValue}.
   *
   * <ul>
   *   <li>Given {@link org.broadleafcommerce.core.catalog.domain.Category} {@link
   *       org.broadleafcommerce.core.catalog.domain.Category#getId()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductParentCategoryFieldPersistenceProvider.checkDirtyState(Product, Long)"
  })
  public void testCheckDirtyStateWithInstanceCheckValue_givenCategoryGetIdReturnNull() {
    // Arrange
    org.broadleafcommerce.core.catalog.domain.Category category =
        mock(org.broadleafcommerce.core.catalog.domain.Category.class);
    when(category.getId()).thenReturn(null);
    when(category.isActive()).thenReturn(true);

    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();
    categoryProductXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl.setId(1L);
    categoryProductXrefImpl.setProduct(new ProductBundleImpl());
    categoryProductXrefImpl.setCategory(category);
    categoryProductXrefImpl.setDefaultReference(true);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);

    Product instance = mock(Product.class);
    when(instance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    // Act
    boolean actualCheckDirtyStateResult =
        productParentCategoryFieldPersistenceProvider.checkDirtyState(instance, 42L);

    // Assert
    verify(category).getId();
    verify(category).isActive();
    verify(instance).getAllParentCategoryXrefs();
    assertTrue(actualCheckDirtyStateResult);
  }

  /**
   * Test {@link ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)} with
   * {@code instance}, {@code checkValue}.
   *
   * <ul>
   *   <li>Given {@link org.broadleafcommerce.core.catalog.domain.Category} {@link
   *       org.broadleafcommerce.core.catalog.domain.Category#getId()} return one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductParentCategoryFieldPersistenceProvider.checkDirtyState(Product, Long)"
  })
  public void testCheckDirtyStateWithInstanceCheckValue_givenCategoryGetIdReturnOne() {
    // Arrange
    org.broadleafcommerce.core.catalog.domain.Category category =
        mock(org.broadleafcommerce.core.catalog.domain.Category.class);
    when(category.getId()).thenReturn(1L);
    when(category.isActive()).thenReturn(true);

    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();
    categoryProductXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl.setId(1L);
    categoryProductXrefImpl.setProduct(new ProductBundleImpl());
    categoryProductXrefImpl.setCategory(category);
    categoryProductXrefImpl.setDefaultReference(true);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);

    Product instance = mock(Product.class);
    when(instance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    // Act
    boolean actualCheckDirtyStateResult =
        productParentCategoryFieldPersistenceProvider.checkDirtyState(instance, 42L);

    // Assert
    verify(category).getId();
    verify(category).isActive();
    verify(instance).getAllParentCategoryXrefs();
    assertTrue(actualCheckDirtyStateResult);
  }

  /**
   * Test {@link ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)} with
   * {@code instance}, {@code checkValue}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductParentCategoryFieldPersistenceProvider.checkDirtyState(Product, Long)"
  })
  public void testCheckDirtyStateWithInstanceCheckValue_givenNull() {
    // Arrange
    Product instance = mock(Product.class);
    when(instance.getAllParentCategoryXrefs()).thenReturn(null);

    // Act
    boolean actualCheckDirtyStateResult =
        productParentCategoryFieldPersistenceProvider.checkDirtyState(instance, 42L);

    // Assert
    verify(instance).getAllParentCategoryXrefs();
    assertTrue(actualCheckDirtyStateResult);
  }

  /**
   * Test {@link ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)} with
   * {@code instance}, {@code checkValue}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductParentCategoryFieldPersistenceProvider.checkDirtyState(Product, Long)"
  })
  public void testCheckDirtyStateWithInstanceCheckValue_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(productParentCategoryFieldPersistenceProvider.checkDirtyState(null, 42L));
  }

  /**
   * Test {@link ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)} with
   * {@code instance}, {@code checkValue}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductParentCategoryFieldPersistenceProvider.checkDirtyState(Product, Long)"
  })
  public void testCheckDirtyStateWithInstanceCheckValue_whenOne_thenReturnFalse() {
    // Arrange
    org.broadleafcommerce.core.catalog.domain.Category category =
        mock(org.broadleafcommerce.core.catalog.domain.Category.class);
    when(category.getId()).thenReturn(1L);
    when(category.isActive()).thenReturn(true);

    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();
    categoryProductXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl.setId(1L);
    categoryProductXrefImpl.setProduct(new ProductBundleImpl());
    categoryProductXrefImpl.setCategory(category);
    categoryProductXrefImpl.setDefaultReference(true);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);

    Product instance = mock(Product.class);
    when(instance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    // Act
    boolean actualCheckDirtyStateResult =
        productParentCategoryFieldPersistenceProvider.checkDirtyState(instance, 1L);

    // Assert
    verify(category).getId();
    verify(category).isActive();
    verify(instance).getAllParentCategoryXrefs();
    assertFalse(actualCheckDirtyStateResult);
  }

  /**
   * Test {@link ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)} with
   * {@code instance}, {@code checkValue}.
   *
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductParentCategoryFieldPersistenceProvider.checkDirtyState(Product, Long)"
  })
  public void testCheckDirtyStateWithInstanceCheckValue_whenProductBundleImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        productParentCategoryFieldPersistenceProvider.checkDirtyState(
            new ProductBundleImpl(), 42L));
  }

  /**
   * Test {@link ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)} with
   * {@code instance}, {@code checkValue}.
   *
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductParentCategoryFieldPersistenceProvider#checkDirtyState(Product, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductParentCategoryFieldPersistenceProvider.checkDirtyState(Product, Long)"
  })
  public void testCheckDirtyStateWithInstanceCheckValue_whenProductBundleImpl_thenReturnTrue2() {
    // Arrange, Act and Assert
    assertTrue(
        productParentCategoryFieldPersistenceProvider.checkDirtyState(
            new ProductBundleImpl(), null));
  }

  /**
   * Test {@link ProductParentCategoryFieldPersistenceProvider#getDefaultCategory(Product)}.
   *
   * <p>Method under test: {@link
   * ProductParentCategoryFieldPersistenceProvider#getDefaultCategory(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.catalog.domain.Category ProductParentCategoryFieldPersistenceProvider.getDefaultCategory(Product)"
  })
  public void testGetDefaultCategory() {
    // Arrange
    CategoryImpl category = new CategoryImpl();
    category.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();
    categoryProductXrefImpl.setCategory(category);
    categoryProductXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl.setId(1L);
    categoryProductXrefImpl.setProduct(new ProductBundleImpl());
    categoryProductXrefImpl.setDefaultReference(null);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);

    Product product = mock(Product.class);
    when(product.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    // Act
    org.broadleafcommerce.core.catalog.domain.Category actualDefaultCategory =
        productParentCategoryFieldPersistenceProvider.getDefaultCategory(product);

    // Assert
    verify(product).getAllParentCategoryXrefs();
    assertNull(actualDefaultCategory);
  }

  /**
   * Test {@link ProductParentCategoryFieldPersistenceProvider#getDefaultCategory(Product)}.
   *
   * <ul>
   *   <li>Given {@link CategoryProductXrefImpl} (default constructor) DefaultReference is {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductParentCategoryFieldPersistenceProvider#getDefaultCategory(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.catalog.domain.Category ProductParentCategoryFieldPersistenceProvider.getDefaultCategory(Product)"
  })
  public void testGetDefaultCategory_givenCategoryProductXrefImplDefaultReferenceIsFalse() {
    // Arrange
    CategoryImpl category = new CategoryImpl();
    category.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();
    categoryProductXrefImpl.setCategory(category);
    categoryProductXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl.setId(1L);
    categoryProductXrefImpl.setProduct(new ProductBundleImpl());
    categoryProductXrefImpl.setDefaultReference(false);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);

    Product product = mock(Product.class);
    when(product.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    // Act
    org.broadleafcommerce.core.catalog.domain.Category actualDefaultCategory =
        productParentCategoryFieldPersistenceProvider.getDefaultCategory(product);

    // Assert
    verify(product).getAllParentCategoryXrefs();
    assertNull(actualDefaultCategory);
  }

  /**
   * Test {@link ProductParentCategoryFieldPersistenceProvider#getDefaultCategory(Product)}.
   *
   * <ul>
   *   <li>Given {@link CategoryProductXrefImpl} (default constructor) DefaultReference is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductParentCategoryFieldPersistenceProvider#getDefaultCategory(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.catalog.domain.Category ProductParentCategoryFieldPersistenceProvider.getDefaultCategory(Product)"
  })
  public void testGetDefaultCategory_givenCategoryProductXrefImplDefaultReferenceIsNull() {
    // Arrange
    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();
    categoryProductXrefImpl.setCategory(new CategoryImpl());
    categoryProductXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl.setId(1L);
    categoryProductXrefImpl.setProduct(new ProductBundleImpl());
    categoryProductXrefImpl.setDefaultReference(null);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);

    Product product = mock(Product.class);
    when(product.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    // Act
    org.broadleafcommerce.core.catalog.domain.Category actualDefaultCategory =
        productParentCategoryFieldPersistenceProvider.getDefaultCategory(product);

    // Assert
    verify(product).getAllParentCategoryXrefs();
    assertNull(actualDefaultCategory);
  }

  /**
   * Test {@link ProductParentCategoryFieldPersistenceProvider#getDefaultCategory(Product)}.
   *
   * <ul>
   *   <li>Given {@link CategoryProductXrefImpl} (default constructor) DefaultReference is {@code
   *       true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductParentCategoryFieldPersistenceProvider#getDefaultCategory(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.catalog.domain.Category ProductParentCategoryFieldPersistenceProvider.getDefaultCategory(Product)"
  })
  public void testGetDefaultCategory_givenCategoryProductXrefImplDefaultReferenceIsTrue() {
    // Arrange
    CategoryImpl category = new CategoryImpl();
    category.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();
    categoryProductXrefImpl.setCategory(category);
    categoryProductXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl.setId(1L);
    categoryProductXrefImpl.setProduct(new ProductBundleImpl());
    categoryProductXrefImpl.setDefaultReference(true);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);

    Product product = mock(Product.class);
    when(product.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    // Act
    productParentCategoryFieldPersistenceProvider.getDefaultCategory(product);

    // Assert
    verify(product).getAllParentCategoryXrefs();
  }

  /**
   * Test {@link ProductParentCategoryFieldPersistenceProvider#getDefaultCategory(Product)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Product} {@link Product#getAllParentCategoryXrefs()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductParentCategoryFieldPersistenceProvider#getDefaultCategory(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.catalog.domain.Category ProductParentCategoryFieldPersistenceProvider.getDefaultCategory(Product)"
  })
  public void testGetDefaultCategory_givenNull_whenProductGetAllParentCategoryXrefsReturnNull() {
    // Arrange
    Product product = mock(Product.class);
    when(product.getAllParentCategoryXrefs()).thenReturn(null);

    // Act
    org.broadleafcommerce.core.catalog.domain.Category actualDefaultCategory =
        productParentCategoryFieldPersistenceProvider.getDefaultCategory(product);

    // Assert
    verify(product).getAllParentCategoryXrefs();
    assertNull(actualDefaultCategory);
  }

  /**
   * Test {@link ProductParentCategoryFieldPersistenceProvider#getDefaultCategory(Product)}.
   *
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductParentCategoryFieldPersistenceProvider#getDefaultCategory(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.catalog.domain.Category ProductParentCategoryFieldPersistenceProvider.getDefaultCategory(Product)"
  })
  public void testGetDefaultCategory_whenProductBundleImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        productParentCategoryFieldPersistenceProvider.getDefaultCategory(new ProductBundleImpl()));
  }

  /**
   * Test {@link
   * ProductParentCategoryFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest,
   * Serializable)}.
   *
   * <ul>
   *   <li>Then calls {@link Property#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductParentCategoryFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest,
   * Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductParentCategoryFieldPersistenceProvider.canHandlePersistence(PopulateValueRequest, Serializable)"
  })
  public void testCanHandlePersistence_thenCallsGetName() {
    // Arrange
    ProductParentCategoryFieldPersistenceProvider productParentCategoryFieldPersistenceProvider =
        new ProductParentCategoryFieldPersistenceProvider();

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act
    boolean actualCanHandlePersistenceResult =
        productParentCategoryFieldPersistenceProvider.canHandlePersistence(
            populateValueRequest, new ProductBundleImpl());

    // Assert
    verify(property).getName();
    assertFalse(actualCanHandlePersistenceResult);
  }

  /**
   * Test {@link
   * ProductParentCategoryFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest,
   * Serializable)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductParentCategoryFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest,
   * Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductParentCategoryFieldPersistenceProvider.canHandlePersistence(PopulateValueRequest, Serializable)"
  })
  public void testCanHandlePersistence_thenReturnFalse() {
    // Arrange
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act
    boolean actualCanHandlePersistenceResult =
        productParentCategoryFieldPersistenceProvider.canHandlePersistence(
            populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    assertFalse(actualCanHandlePersistenceResult);
  }

  /**
   * Test {@link
   * ProductParentCategoryFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest,
   * Property)}.
   *
   * <p>Method under test: {@link
   * ProductParentCategoryFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest,
   * Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductParentCategoryFieldPersistenceProvider.canHandleExtraction(ExtractValueRequest, Property)"
  })
  public void testCanHandleExtraction() {
    // Arrange
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    String[] customCriteria = new String[] {"Custom Criteria"};

    ExtractValueRequest extractValueRequest =
        new ExtractValueRequest(
            props,
            fieldManager,
            metadata,
            "Requested Value",
            "Display Val",
            persistenceManager,
            recordHelper,
            new SimpleDateFormat("yyyy/mm/dd"),
            customCriteria);

    // Act and Assert
    assertFalse(
        productParentCategoryFieldPersistenceProvider.canHandleExtraction(
            extractValueRequest, new Property()));
  }

  /**
   * Test {@link
   * ProductParentCategoryFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest,
   * Property)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link Property} {@link Property#getName()} return {@code Name}.
   *   <li>Then calls {@link Property#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductParentCategoryFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest,
   * Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductParentCategoryFieldPersistenceProvider.canHandleExtraction(ExtractValueRequest, Property)"
  })
  public void testCanHandleExtraction_givenName_whenPropertyGetNameReturnName_thenCallsGetName() {
    // Arrange
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getEntity()).thenReturn(new ProductBundleImpl());

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");

    // Act
    boolean actualCanHandleExtractionResult =
        productParentCategoryFieldPersistenceProvider.canHandleExtraction(
            extractValueRequest, property);

    // Assert
    verify(property).getName();
    verify(extractValueRequest).getEntity();
    assertFalse(actualCanHandleExtractionResult);
  }

  /**
   * Test {@link ProductParentCategoryFieldPersistenceProvider#getOrder()}.
   *
   * <p>Method under test: {@link ProductParentCategoryFieldPersistenceProvider#getOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ProductParentCategoryFieldPersistenceProvider.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(-2147483548, new ProductParentCategoryFieldPersistenceProvider().getOrder());
  }
}

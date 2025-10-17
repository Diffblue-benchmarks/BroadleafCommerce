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
import org.broadleafcommerce.admin.server.service.persistence.module.provider.extension.CategoryParentCategoryFieldPersistenceProviderExtensionManager;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.CategoryXref;
import org.broadleafcommerce.core.catalog.domain.CategoryXrefImpl;
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
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {CategoryParentCategoryFieldPersistenceProvider.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryParentCategoryFieldPersistenceProviderDiffblueTest {
  @Autowired
  private CategoryParentCategoryFieldPersistenceProvider
      categoryParentCategoryFieldPersistenceProvider;

  @MockBean(name = "blCategoryParentCategoryFieldPersistenceProviderExtensionManager")
  private CategoryParentCategoryFieldPersistenceProviderExtensionManager
      categoryParentCategoryFieldPersistenceProviderExtensionManager;

  /**
   * Test {@link CategoryParentCategoryFieldPersistenceProvider#populateValue(PopulateValueRequest,
   * Serializable)}.
   *
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryParentCategoryFieldPersistenceProvider#populateValue(PopulateValueRequest,
   * Serializable)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse CategoryParentCategoryFieldPersistenceProvider.populateValue(PopulateValueRequest, Serializable)"
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
        categoryParentCategoryFieldPersistenceProvider.populateValue(
            populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualPopulateValueResult);
  }

  /**
   * Test {@link CategoryParentCategoryFieldPersistenceProvider#extractValue(ExtractValueRequest,
   * Property)}.
   *
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryParentCategoryFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse CategoryParentCategoryFieldPersistenceProvider.extractValue(ExtractValueRequest, Property)"
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
        categoryParentCategoryFieldPersistenceProvider.extractValue(
            extractValueRequest, new Property()));
  }

  /**
   * Test {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   * with {@code instance}, {@code checkValue}.
   *
   * <p>Method under test: {@link
   * CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryParentCategoryFieldPersistenceProvider.checkDirtyState(Category, Long)"
  })
  public void testCheckDirtyStateWithInstanceCheckValue() {
    // Arrange
    CategoryXrefImpl categoryXrefImpl = new CategoryXrefImpl();
    categoryXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryXrefImpl.setId(1L);
    categoryXrefImpl.setSubCategory(new CategoryImpl());
    categoryXrefImpl.setCategory(new CategoryImpl());
    categoryXrefImpl.setDefaultReference(null);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);

    Category instance = mock(Category.class);
    when(instance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    boolean actualCheckDirtyStateResult =
        categoryParentCategoryFieldPersistenceProvider.checkDirtyState(instance, 42L);

    // Assert
    verify(instance).getAllParentCategoryXrefs();
    assertTrue(actualCheckDirtyStateResult);
  }

  /**
   * Test {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   * with {@code instance}, {@code checkValue}.
   *
   * <p>Method under test: {@link
   * CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryParentCategoryFieldPersistenceProvider.checkDirtyState(Category, Long)"
  })
  public void testCheckDirtyStateWithInstanceCheckValue2() {
    // Arrange
    CategoryXrefImpl categoryXrefImpl = new CategoryXrefImpl();
    categoryXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryXrefImpl.setId(1L);
    categoryXrefImpl.setSubCategory(new CategoryImpl());
    categoryXrefImpl.setCategory(new CategoryImpl());
    categoryXrefImpl.setDefaultReference(true);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);

    Category instance = mock(Category.class);
    when(instance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    boolean actualCheckDirtyStateResult =
        categoryParentCategoryFieldPersistenceProvider.checkDirtyState(instance, 42L);

    // Assert
    verify(instance).getAllParentCategoryXrefs();
    assertTrue(actualCheckDirtyStateResult);
  }

  /**
   * Test {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   * with {@code instance}, {@code checkValue}.
   *
   * <p>Method under test: {@link
   * CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryParentCategoryFieldPersistenceProvider.checkDirtyState(Category, Long)"
  })
  public void testCheckDirtyStateWithInstanceCheckValue3() {
    // Arrange
    Category category = mock(Category.class);
    when(category.isActive()).thenReturn(true);

    CategoryXrefImpl categoryXrefImpl = new CategoryXrefImpl();
    categoryXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryXrefImpl.setId(1L);
    categoryXrefImpl.setSubCategory(new CategoryImpl());
    categoryXrefImpl.setCategory(category);
    categoryXrefImpl.setDefaultReference(null);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);

    Category instance = mock(Category.class);
    when(instance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    boolean actualCheckDirtyStateResult =
        categoryParentCategoryFieldPersistenceProvider.checkDirtyState(instance, 42L);

    // Assert
    verify(instance).getAllParentCategoryXrefs();
    verify(category).isActive();
    assertTrue(actualCheckDirtyStateResult);
  }

  /**
   * Test {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   * with {@code instance}, {@code checkValue}.
   *
   * <p>Method under test: {@link
   * CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryParentCategoryFieldPersistenceProvider.checkDirtyState(Category, Long)"
  })
  public void testCheckDirtyStateWithInstanceCheckValue4() {
    // Arrange
    Category category = mock(Category.class);
    when(category.isActive()).thenReturn(true);

    CategoryXrefImpl categoryXrefImpl = new CategoryXrefImpl();
    categoryXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryXrefImpl.setId(1L);
    categoryXrefImpl.setSubCategory(new CategoryImpl());
    categoryXrefImpl.setCategory(category);
    categoryXrefImpl.setDefaultReference(false);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);

    Category instance = mock(Category.class);
    when(instance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    boolean actualCheckDirtyStateResult =
        categoryParentCategoryFieldPersistenceProvider.checkDirtyState(instance, 42L);

    // Assert
    verify(instance).getAllParentCategoryXrefs();
    verify(category).isActive();
    assertTrue(actualCheckDirtyStateResult);
  }

  /**
   * Test {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   * with {@code instance}, {@code checkValue}.
   *
   * <ul>
   *   <li>Given {@link Category} {@link Category#getId()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryParentCategoryFieldPersistenceProvider.checkDirtyState(Category, Long)"
  })
  public void testCheckDirtyStateWithInstanceCheckValue_givenCategoryGetIdReturnNull() {
    // Arrange
    Category category = mock(Category.class);
    when(category.getId()).thenReturn(null);
    when(category.isActive()).thenReturn(true);

    CategoryXrefImpl categoryXrefImpl = new CategoryXrefImpl();
    categoryXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryXrefImpl.setId(1L);
    categoryXrefImpl.setSubCategory(new CategoryImpl());
    categoryXrefImpl.setCategory(category);
    categoryXrefImpl.setDefaultReference(true);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);

    Category instance = mock(Category.class);
    when(instance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    boolean actualCheckDirtyStateResult =
        categoryParentCategoryFieldPersistenceProvider.checkDirtyState(instance, 42L);

    // Assert
    verify(instance).getAllParentCategoryXrefs();
    verify(category).getId();
    verify(category).isActive();
    assertTrue(actualCheckDirtyStateResult);
  }

  /**
   * Test {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   * with {@code instance}, {@code checkValue}.
   *
   * <ul>
   *   <li>Given {@link Category} {@link Category#getId()} return one.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryParentCategoryFieldPersistenceProvider.checkDirtyState(Category, Long)"
  })
  public void testCheckDirtyStateWithInstanceCheckValue_givenCategoryGetIdReturnOne() {
    // Arrange
    Category category = mock(Category.class);
    when(category.getId()).thenReturn(1L);
    when(category.isActive()).thenReturn(true);

    CategoryXrefImpl categoryXrefImpl = new CategoryXrefImpl();
    categoryXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryXrefImpl.setId(1L);
    categoryXrefImpl.setSubCategory(new CategoryImpl());
    categoryXrefImpl.setCategory(category);
    categoryXrefImpl.setDefaultReference(true);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);

    Category instance = mock(Category.class);
    when(instance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    boolean actualCheckDirtyStateResult =
        categoryParentCategoryFieldPersistenceProvider.checkDirtyState(instance, 42L);

    // Assert
    verify(instance).getAllParentCategoryXrefs();
    verify(category).getId();
    verify(category).isActive();
    assertTrue(actualCheckDirtyStateResult);
  }

  /**
   * Test {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   * with {@code instance}, {@code checkValue}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryParentCategoryFieldPersistenceProvider.checkDirtyState(Category, Long)"
  })
  public void testCheckDirtyStateWithInstanceCheckValue_givenNull() {
    // Arrange
    Category instance = mock(Category.class);
    when(instance.getAllParentCategoryXrefs()).thenReturn(null);

    // Act
    boolean actualCheckDirtyStateResult =
        categoryParentCategoryFieldPersistenceProvider.checkDirtyState(instance, 42L);

    // Assert
    verify(instance).getAllParentCategoryXrefs();
    assertTrue(actualCheckDirtyStateResult);
  }

  /**
   * Test {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   * with {@code instance}, {@code checkValue}.
   *
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryParentCategoryFieldPersistenceProvider.checkDirtyState(Category, Long)"
  })
  public void testCheckDirtyStateWithInstanceCheckValue_whenCategoryImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        categoryParentCategoryFieldPersistenceProvider.checkDirtyState(new CategoryImpl(), 42L));
  }

  /**
   * Test {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   * with {@code instance}, {@code checkValue}.
   *
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryParentCategoryFieldPersistenceProvider.checkDirtyState(Category, Long)"
  })
  public void testCheckDirtyStateWithInstanceCheckValue_whenCategoryImpl_thenReturnTrue2() {
    // Arrange, Act and Assert
    assertTrue(
        categoryParentCategoryFieldPersistenceProvider.checkDirtyState(new CategoryImpl(), null));
  }

  /**
   * Test {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   * with {@code instance}, {@code checkValue}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryParentCategoryFieldPersistenceProvider.checkDirtyState(Category, Long)"
  })
  public void testCheckDirtyStateWithInstanceCheckValue_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(categoryParentCategoryFieldPersistenceProvider.checkDirtyState(null, 42L));
  }

  /**
   * Test {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   * with {@code instance}, {@code checkValue}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryParentCategoryFieldPersistenceProvider.checkDirtyState(Category, Long)"
  })
  public void testCheckDirtyStateWithInstanceCheckValue_whenOne_thenReturnFalse() {
    // Arrange
    Category category = mock(Category.class);
    when(category.getId()).thenReturn(1L);
    when(category.isActive()).thenReturn(true);

    CategoryXrefImpl categoryXrefImpl = new CategoryXrefImpl();
    categoryXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryXrefImpl.setId(1L);
    categoryXrefImpl.setSubCategory(new CategoryImpl());
    categoryXrefImpl.setCategory(category);
    categoryXrefImpl.setDefaultReference(true);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);

    Category instance = mock(Category.class);
    when(instance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    boolean actualCheckDirtyStateResult =
        categoryParentCategoryFieldPersistenceProvider.checkDirtyState(instance, 1L);

    // Assert
    verify(instance).getAllParentCategoryXrefs();
    verify(category).getId();
    verify(category).isActive();
    assertFalse(actualCheckDirtyStateResult);
  }

  /**
   * Test {@link CategoryParentCategoryFieldPersistenceProvider#getDefaultCategory(Category)}.
   *
   * <p>Method under test: {@link
   * CategoryParentCategoryFieldPersistenceProvider#getDefaultCategory(Category)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Category CategoryParentCategoryFieldPersistenceProvider.getDefaultCategory(Category)"
  })
  public void testGetDefaultCategory() {
    // Arrange
    CategoryImpl category = new CategoryImpl();
    category.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    CategoryXrefImpl categoryXrefImpl = new CategoryXrefImpl();
    categoryXrefImpl.setCategory(category);
    categoryXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryXrefImpl.setId(1L);
    categoryXrefImpl.setSubCategory(new CategoryImpl());
    categoryXrefImpl.setDefaultReference(null);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);

    Category category2 = mock(Category.class);
    when(category2.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    Category actualDefaultCategory =
        categoryParentCategoryFieldPersistenceProvider.getDefaultCategory(category2);

    // Assert
    verify(category2).getAllParentCategoryXrefs();
    assertNull(actualDefaultCategory);
  }

  /**
   * Test {@link CategoryParentCategoryFieldPersistenceProvider#getDefaultCategory(Category)}.
   *
   * <ul>
   *   <li>Given {@link CategoryXrefImpl} (default constructor) DefaultReference is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryParentCategoryFieldPersistenceProvider#getDefaultCategory(Category)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Category CategoryParentCategoryFieldPersistenceProvider.getDefaultCategory(Category)"
  })
  public void testGetDefaultCategory_givenCategoryXrefImplDefaultReferenceIsFalse() {
    // Arrange
    CategoryImpl category = new CategoryImpl();
    category.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    CategoryXrefImpl categoryXrefImpl = new CategoryXrefImpl();
    categoryXrefImpl.setCategory(category);
    categoryXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryXrefImpl.setId(1L);
    categoryXrefImpl.setSubCategory(new CategoryImpl());
    categoryXrefImpl.setDefaultReference(false);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);

    Category category2 = mock(Category.class);
    when(category2.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    Category actualDefaultCategory =
        categoryParentCategoryFieldPersistenceProvider.getDefaultCategory(category2);

    // Assert
    verify(category2).getAllParentCategoryXrefs();
    assertNull(actualDefaultCategory);
  }

  /**
   * Test {@link CategoryParentCategoryFieldPersistenceProvider#getDefaultCategory(Category)}.
   *
   * <ul>
   *   <li>Given {@link CategoryXrefImpl} (default constructor) DefaultReference is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryParentCategoryFieldPersistenceProvider#getDefaultCategory(Category)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Category CategoryParentCategoryFieldPersistenceProvider.getDefaultCategory(Category)"
  })
  public void testGetDefaultCategory_givenCategoryXrefImplDefaultReferenceIsNull() {
    // Arrange
    CategoryXrefImpl categoryXrefImpl = new CategoryXrefImpl();
    categoryXrefImpl.setCategory(new CategoryImpl());
    categoryXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryXrefImpl.setId(1L);
    categoryXrefImpl.setSubCategory(new CategoryImpl());
    categoryXrefImpl.setDefaultReference(null);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);

    Category category = mock(Category.class);
    when(category.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    Category actualDefaultCategory =
        categoryParentCategoryFieldPersistenceProvider.getDefaultCategory(category);

    // Assert
    verify(category).getAllParentCategoryXrefs();
    assertNull(actualDefaultCategory);
  }

  /**
   * Test {@link CategoryParentCategoryFieldPersistenceProvider#getDefaultCategory(Category)}.
   *
   * <ul>
   *   <li>Given {@link CategoryXrefImpl} (default constructor) DefaultReference is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryParentCategoryFieldPersistenceProvider#getDefaultCategory(Category)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Category CategoryParentCategoryFieldPersistenceProvider.getDefaultCategory(Category)"
  })
  public void testGetDefaultCategory_givenCategoryXrefImplDefaultReferenceIsTrue() {
    // Arrange
    CategoryImpl category = new CategoryImpl();
    category.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    CategoryXrefImpl categoryXrefImpl = new CategoryXrefImpl();
    categoryXrefImpl.setCategory(category);
    categoryXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryXrefImpl.setId(1L);
    categoryXrefImpl.setSubCategory(new CategoryImpl());
    categoryXrefImpl.setDefaultReference(true);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);

    Category category2 = mock(Category.class);
    when(category2.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    categoryParentCategoryFieldPersistenceProvider.getDefaultCategory(category2);

    // Assert
    verify(category2).getAllParentCategoryXrefs();
  }

  /**
   * Test {@link CategoryParentCategoryFieldPersistenceProvider#getDefaultCategory(Category)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Category} {@link Category#getAllParentCategoryXrefs()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryParentCategoryFieldPersistenceProvider#getDefaultCategory(Category)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Category CategoryParentCategoryFieldPersistenceProvider.getDefaultCategory(Category)"
  })
  public void testGetDefaultCategory_givenNull_whenCategoryGetAllParentCategoryXrefsReturnNull() {
    // Arrange
    Category category = mock(Category.class);
    when(category.getAllParentCategoryXrefs()).thenReturn(null);

    // Act
    Category actualDefaultCategory =
        categoryParentCategoryFieldPersistenceProvider.getDefaultCategory(category);

    // Assert
    verify(category).getAllParentCategoryXrefs();
    assertNull(actualDefaultCategory);
  }

  /**
   * Test {@link CategoryParentCategoryFieldPersistenceProvider#getDefaultCategory(Category)}.
   *
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryParentCategoryFieldPersistenceProvider#getDefaultCategory(Category)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Category CategoryParentCategoryFieldPersistenceProvider.getDefaultCategory(Category)"
  })
  public void testGetDefaultCategory_whenCategoryImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        categoryParentCategoryFieldPersistenceProvider.getDefaultCategory(new CategoryImpl()));
  }

  /**
   * Test {@link
   * CategoryParentCategoryFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest,
   * Serializable)}.
   *
   * <ul>
   *   <li>Then calls {@link Property#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryParentCategoryFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest,
   * Serializable)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryParentCategoryFieldPersistenceProvider.canHandlePersistence(PopulateValueRequest, Serializable)"
  })
  public void testCanHandlePersistence_thenCallsGetName() {
    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider =
        new CategoryParentCategoryFieldPersistenceProvider();

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
        categoryParentCategoryFieldPersistenceProvider.canHandlePersistence(
            populateValueRequest, new CategoryImpl());

    // Assert
    verify(property).getName();
    assertFalse(actualCanHandlePersistenceResult);
  }

  /**
   * Test {@link
   * CategoryParentCategoryFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest,
   * Serializable)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryParentCategoryFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest,
   * Serializable)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryParentCategoryFieldPersistenceProvider.canHandlePersistence(PopulateValueRequest, Serializable)"
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
        categoryParentCategoryFieldPersistenceProvider.canHandlePersistence(
            populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    assertFalse(actualCanHandlePersistenceResult);
  }

  /**
   * Test {@link
   * CategoryParentCategoryFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest,
   * Property)}.
   *
   * <p>Method under test: {@link
   * CategoryParentCategoryFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest,
   * Property)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryParentCategoryFieldPersistenceProvider.canHandleExtraction(ExtractValueRequest, Property)"
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
        categoryParentCategoryFieldPersistenceProvider.canHandleExtraction(
            extractValueRequest, new Property()));
  }

  /**
   * Test {@link
   * CategoryParentCategoryFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest,
   * Property)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link Property} {@link Property#getName()} return {@code Name}.
   *   <li>Then calls {@link Property#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryParentCategoryFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest,
   * Property)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryParentCategoryFieldPersistenceProvider.canHandleExtraction(ExtractValueRequest, Property)"
  })
  public void testCanHandleExtraction_givenName_whenPropertyGetNameReturnName_thenCallsGetName() {
    // Arrange
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getEntity()).thenReturn(new CategoryImpl());

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");

    // Act
    boolean actualCanHandleExtractionResult =
        categoryParentCategoryFieldPersistenceProvider.canHandleExtraction(
            extractValueRequest, property);

    // Assert
    verify(property).getName();
    verify(extractValueRequest).getEntity();
    assertFalse(actualCanHandleExtractionResult);
  }

  /**
   * Test {@link CategoryParentCategoryFieldPersistenceProvider#getOrder()}.
   *
   * <p>Method under test: {@link CategoryParentCategoryFieldPersistenceProvider#getOrder()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int CategoryParentCategoryFieldPersistenceProvider.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(-2147483548, new CategoryParentCategoryFieldPersistenceProvider().getOrder());
  }
}

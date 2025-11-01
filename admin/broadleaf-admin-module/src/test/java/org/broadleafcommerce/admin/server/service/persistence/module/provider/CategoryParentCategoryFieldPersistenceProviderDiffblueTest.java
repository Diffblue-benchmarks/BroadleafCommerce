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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
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
import org.mockito.Mockito;

public class CategoryParentCategoryFieldPersistenceProviderDiffblueTest {
  /**
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testPopulateValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider = new CategoryParentCategoryFieldPersistenceProvider();
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), null);

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED, categoryParentCategoryFieldPersistenceProvider
        .populateValue(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd")));
  }

  /**
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider = new CategoryParentCategoryFieldPersistenceProvider();
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        categoryParentCategoryFieldPersistenceProvider.extractValue(extractValueRequest, new Property()));
  }

  /**
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   */
  @Test
  public void testCheckDirtyState() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider = new CategoryParentCategoryFieldPersistenceProvider();

    // Act and Assert
    assertTrue(categoryParentCategoryFieldPersistenceProvider.checkDirtyState(new CategoryImpl(), 42L));
  }

  /**
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   */
  @Test
  public void testCheckDirtyState2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CategoryParentCategoryFieldPersistenceProvider()).checkDirtyState(null, 42L));
  }

  /**
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   */
  @Test
  public void testCheckDirtyState3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider = new CategoryParentCategoryFieldPersistenceProvider();
    CategoryImpl instance = mock(CategoryImpl.class);
    when(instance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());

    // Act
    boolean actualCheckDirtyStateResult = categoryParentCategoryFieldPersistenceProvider.checkDirtyState(instance, 42L);

    // Assert
    verify(instance).getAllParentCategoryXrefs();
    assertTrue(actualCheckDirtyStateResult);
  }

  /**
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   */
  @Test
  public void testCheckDirtyState4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider = new CategoryParentCategoryFieldPersistenceProvider();

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(new CategoryXrefImpl());
    CategoryImpl instance = mock(CategoryImpl.class);
    when(instance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    boolean actualCheckDirtyStateResult = categoryParentCategoryFieldPersistenceProvider.checkDirtyState(instance, 42L);

    // Assert
    verify(instance).getAllParentCategoryXrefs();
    assertTrue(actualCheckDirtyStateResult);
  }

  /**
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   */
  @Test
  public void testCheckDirtyState5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CategoryParentCategoryFieldPersistenceProvider()).checkDirtyState(mock(CategoryImpl.class), null));
  }

  /**
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   */
  @Test
  public void testCheckDirtyState6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider = new CategoryParentCategoryFieldPersistenceProvider();

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);
    CategoryImpl instance = mock(CategoryImpl.class);
    when(instance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    boolean actualCheckDirtyStateResult = categoryParentCategoryFieldPersistenceProvider.checkDirtyState(instance, 42L);

    // Assert
    verify(instance).getAllParentCategoryXrefs();
    verify(categoryXrefImpl).getCategory();
    assertTrue(actualCheckDirtyStateResult);
  }

  /**
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   */
  @Test
  public void testCheckDirtyState7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider = new CategoryParentCategoryFieldPersistenceProvider();

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);
    CategoryImpl instance = mock(CategoryImpl.class);
    when(instance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    boolean actualCheckDirtyStateResult = categoryParentCategoryFieldPersistenceProvider.checkDirtyState(instance, 42L);

    // Assert
    verify(instance).getAllParentCategoryXrefs();
    verify(categoryXrefImpl).getCategory();
    assertTrue(actualCheckDirtyStateResult);
  }

  /**
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   */
  @Test
  public void testCheckDirtyState8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider = new CategoryParentCategoryFieldPersistenceProvider();

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);
    CategoryImpl instance = mock(CategoryImpl.class);
    when(instance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    boolean actualCheckDirtyStateResult = categoryParentCategoryFieldPersistenceProvider.checkDirtyState(instance, 42L);

    // Assert
    verify(instance).getAllParentCategoryXrefs();
    verify(categoryXrefImpl).getCategory();
    assertTrue(actualCheckDirtyStateResult);
  }

  /**
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   */
  @Test
  public void testCheckDirtyState9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider = new CategoryParentCategoryFieldPersistenceProvider();
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getId()).thenReturn(1L);
    when(categoryImpl.isActive()).thenReturn(true);
    doNothing().when(categoryImpl).setActiveStartDate(Mockito.<Date>any());
    categoryImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);
    CategoryImpl instance = mock(CategoryImpl.class);
    when(instance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    boolean actualCheckDirtyStateResult = categoryParentCategoryFieldPersistenceProvider.checkDirtyState(instance, 42L);

    // Assert
    verify(instance).getAllParentCategoryXrefs();
    verify(categoryImpl).getId();
    verify(categoryImpl).isActive();
    verify(categoryImpl).setActiveStartDate(isA(Date.class));
    verify(categoryXrefImpl, atLeast(1)).getCategory();
    verify(categoryXrefImpl, atLeast(1)).getDefaultReference();
    assertTrue(actualCheckDirtyStateResult);
  }

  /**
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   */
  @Test
  public void testCheckDirtyState10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider = new CategoryParentCategoryFieldPersistenceProvider();
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getId()).thenReturn(1L);
    when(categoryImpl.isActive()).thenReturn(true);
    doNothing().when(categoryImpl).setActiveStartDate(Mockito.<Date>any());
    categoryImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);
    CategoryImpl instance = mock(CategoryImpl.class);
    when(instance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    boolean actualCheckDirtyStateResult = categoryParentCategoryFieldPersistenceProvider.checkDirtyState(instance, 1L);

    // Assert
    verify(instance).getAllParentCategoryXrefs();
    verify(categoryImpl).getId();
    verify(categoryImpl).isActive();
    verify(categoryImpl).setActiveStartDate(isA(Date.class));
    verify(categoryXrefImpl, atLeast(1)).getCategory();
    verify(categoryXrefImpl, atLeast(1)).getDefaultReference();
    assertFalse(actualCheckDirtyStateResult);
  }

  /**
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#getDefaultCategory(Category)}
   */
  @Test
  public void testGetDefaultCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider = new CategoryParentCategoryFieldPersistenceProvider();

    // Act and Assert
    assertNull(categoryParentCategoryFieldPersistenceProvider.getDefaultCategory(new CategoryImpl()));
  }

  /**
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#getDefaultCategory(Category)}
   */
  @Test
  public void testGetDefaultCategory2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider = new CategoryParentCategoryFieldPersistenceProvider();
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());

    // Act
    Category actualDefaultCategory = categoryParentCategoryFieldPersistenceProvider.getDefaultCategory(category);

    // Assert
    verify(category).getAllParentCategoryXrefs();
    assertNull(actualDefaultCategory);
  }

  /**
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#getDefaultCategory(Category)}
   */
  @Test
  public void testGetDefaultCategory3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider = new CategoryParentCategoryFieldPersistenceProvider();

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(new CategoryXrefImpl());
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    Category actualDefaultCategory = categoryParentCategoryFieldPersistenceProvider.getDefaultCategory(category);

    // Assert
    verify(category).getAllParentCategoryXrefs();
    assertNull(actualDefaultCategory);
  }

  /**
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#getDefaultCategory(Category)}
   */
  @Test
  public void testGetDefaultCategory4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider = new CategoryParentCategoryFieldPersistenceProvider();

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    categoryParentCategoryFieldPersistenceProvider.getDefaultCategory(category);

    // Assert
    verify(category).getAllParentCategoryXrefs();
    verify(categoryXrefImpl).getCategory();
  }

  /**
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#getDefaultCategory(Category)}
   */
  @Test
  public void testGetDefaultCategory5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider = new CategoryParentCategoryFieldPersistenceProvider();

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    Category actualDefaultCategory = categoryParentCategoryFieldPersistenceProvider.getDefaultCategory(category);

    // Assert
    verify(category).getAllParentCategoryXrefs();
    verify(categoryXrefImpl).getCategory();
    assertNull(actualDefaultCategory);
  }

  /**
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#getDefaultCategory(Category)}
   */
  @Test
  public void testGetDefaultCategory6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider = new CategoryParentCategoryFieldPersistenceProvider();

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    Category actualDefaultCategory = categoryParentCategoryFieldPersistenceProvider.getDefaultCategory(category);

    // Assert
    verify(category).getAllParentCategoryXrefs();
    verify(categoryXrefImpl).getCategory();
    assertNull(actualDefaultCategory);
  }

  /**
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testCanHandlePersistence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider = new CategoryParentCategoryFieldPersistenceProvider();
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), null);

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    // Act and Assert
    assertFalse(categoryParentCategoryFieldPersistenceProvider.canHandlePersistence(populateValueRequest,
        new SimpleDateFormat("yyyy/mm/dd")));
  }

  /**
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  public void testCanHandleExtraction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider = new CategoryParentCategoryFieldPersistenceProvider();
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act and Assert
    assertFalse(
        categoryParentCategoryFieldPersistenceProvider.canHandleExtraction(extractValueRequest, new Property()));
  }

  /**
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#getOrder()}
   */
  @Test
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(-2147483548, (new CategoryParentCategoryFieldPersistenceProvider()).getOrder());
  }
}

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
package org.broadleafcommerce.core.catalog.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.persistence.NoResultException;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.sandbox.SandBoxHelper;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
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
public class CategoryDaoImplDiffblueTest {
  @Mock
  private CategoryDaoExtensionManager categoryDaoExtensionManager;

  @InjectMocks
  private CategoryDaoImpl categoryDaoImpl;

  @Mock
  private EntityConfiguration entityConfiguration;

  @Mock
  private SandBoxHelper sandBoxHelper;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CategoryDaoImpl#setCurrentDateResolution(Long)}
   *   <li>{@link CategoryDaoImpl#getCurrentDateResolution()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long CategoryDaoImpl.getCurrentDateResolution()",
      "void CategoryDaoImpl.setCurrentDateResolution(Long)"})
  public void testGettersAndSetters() {
    // Arrange
    CategoryDaoImpl categoryDaoImpl = new CategoryDaoImpl();

    // Act
    categoryDaoImpl.setCurrentDateResolution(1L);

    // Assert
    assertEquals(1L, categoryDaoImpl.getCurrentDateResolution().longValue());
  }

  /**
   * Test {@link CategoryDaoImpl#create()}.
   * <ul>
   *   <li>Then return {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryDaoImpl#create()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.broadleafcommerce.core.catalog.domain.Category CategoryDaoImpl.create()"})
  public void testCreate_thenReturnCategoryImpl() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setCategoryAttributes(new ArrayList<>());
    categoryImpl.setCategoryAttributesMap(new HashMap<>());
    categoryImpl.setCategoryMediaXref(new HashMap<>());
    categoryImpl.setChildCategoryIds(new ArrayList<>());
    categoryImpl.setChildCategoryURLMap(new HashMap<>());
    categoryImpl.setDefaultParentCategory(new CategoryImpl());
    categoryImpl.setDescription("The characteristics of someone or something");
    categoryImpl.setDisplayTemplate("Display Template");
    categoryImpl.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl.setExternalId("42");
    categoryImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    categoryImpl.setId(1L);
    categoryImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    categoryImpl.setLongDescription("Long Description");
    categoryImpl.setMetaDescription("Meta Description");
    categoryImpl.setMetaTitle("Dr");
    categoryImpl.setName("Name");
    categoryImpl.setOverrideGeneratedUrl(true);
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("https://example.org/example");
    when(entityConfiguration.createEntityInstance(Mockito.<String>any())).thenReturn(categoryImpl);

    // Act
    org.broadleafcommerce.core.catalog.domain.Category actualCreateResult = categoryDaoImpl.create();

    // Assert
    verify(entityConfiguration).createEntityInstance(eq("org.broadleafcommerce.core.catalog.domain.Category"));
    assertSame(categoryImpl, actualCreateResult);
  }

  /**
   * Test {@link CategoryDaoImpl#create()}.
   * <ul>
   *   <li>Then throw {@link NoResultException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryDaoImpl#create()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.broadleafcommerce.core.catalog.domain.Category CategoryDaoImpl.create()"})
  public void testCreate_thenThrowNoResultException() {
    // Arrange
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenThrow(new NoResultException("An error occurred"));

    // Act and Assert
    assertThrows(NoResultException.class, () -> categoryDaoImpl.create());
    verify(entityConfiguration).createEntityInstance(eq("org.broadleafcommerce.core.catalog.domain.Category"));
  }

  /**
   * Test {@link CategoryDaoImpl#findCategoryByURI(String)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryDaoImpl#findCategoryByURI(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.broadleafcommerce.core.catalog.domain.Category CategoryDaoImpl.findCategoryByURI(String)"})
  public void testFindCategoryByURI_thenReturnNull() {
    // Arrange
    CategoryDaoExtensionHandler categoryDaoExtensionHandler = mock(CategoryDaoExtensionHandler.class);
    when(categoryDaoExtensionHandler.findCategoryByURI(Mockito.<String>any(),
        Mockito.<ExtensionResultHolder<Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(categoryDaoExtensionManager.getProxy()).thenReturn(categoryDaoExtensionHandler);

    // Act
    org.broadleafcommerce.core.catalog.domain.Category actualFindCategoryByURIResult = categoryDaoImpl
        .findCategoryByURI("Uri");

    // Assert
    verify(categoryDaoExtensionManager).getProxy();
    verify(categoryDaoExtensionHandler).findCategoryByURI(eq("Uri"), isA(ExtensionResultHolder.class));
    assertNull(actualFindCategoryByURIResult);
  }

  /**
   * Test {@link CategoryDaoImpl#findCategoryByURI(String)}.
   * <ul>
   *   <li>Then throw {@link NoResultException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryDaoImpl#findCategoryByURI(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.broadleafcommerce.core.catalog.domain.Category CategoryDaoImpl.findCategoryByURI(String)"})
  public void testFindCategoryByURI_thenThrowNoResultException() {
    // Arrange
    CategoryDaoExtensionHandler categoryDaoExtensionHandler = mock(CategoryDaoExtensionHandler.class);
    when(categoryDaoExtensionHandler.findCategoryByURI(Mockito.<String>any(),
        Mockito.<ExtensionResultHolder<Object>>any())).thenThrow(new NoResultException("An error occurred"));
    when(categoryDaoExtensionManager.getProxy()).thenReturn(categoryDaoExtensionHandler);

    // Act and Assert
    assertThrows(NoResultException.class, () -> categoryDaoImpl.findCategoryByURI("Uri"));
    verify(categoryDaoExtensionManager).getProxy();
    verify(categoryDaoExtensionHandler).findCategoryByURI(eq("Uri"), isA(ExtensionResultHolder.class));
  }
}

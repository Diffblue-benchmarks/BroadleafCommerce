/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.breadcrumbs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTO;
import org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.web.BroadleafRequestContext;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CategoryBreadcrumbServiceExtensionHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}
   */
  @Test
  void testModifyBreadcrumbList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    HashMap<String, String[]> params = new HashMap<>();

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE,
        categoryBreadcrumbServiceExtensionHandler.modifyBreadcrumbList("https://example.org/example", params, holder));
  }

  /**
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}
   */
  @Test
  void testModifyBreadcrumbList2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    HashMap<String, String[]> params = new HashMap<>();
    ExtensionResultHolder<List<BreadcrumbDTO>> holder = mock(ExtensionResultHolder.class);
    when(holder.getContextMap()).thenReturn(new HashMap<>());
    doNothing().when(holder).setResult(Mockito.<List<BreadcrumbDTO>>any());
    doNothing().when(holder).setThrowable(Mockito.<Throwable>any());
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualModifyBreadcrumbListResult = categoryBreadcrumbServiceExtensionHandler
        .modifyBreadcrumbList("https://example.org/example", params, holder);

    // Assert
    verify(holder).getContextMap();
    verify(holder).setResult(isA(List.class));
    verify(holder).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE, actualModifyBreadcrumbListResult);
  }

  /**
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#buildCrumbForCategory(Category, String, Map)}
   */
  @Test
  void testBuildCrumbForCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    CategoryImpl category = new CategoryImpl();

    // Act
    BreadcrumbDTO actualBuildCrumbForCategoryResult = categoryBreadcrumbServiceExtensionHandler
        .buildCrumbForCategory(category, "https://example.org/example", new HashMap<>());

    // Assert
    assertEquals("CATEGORY", actualBuildCrumbForCategoryResult.getType());
    assertNull(actualBuildCrumbForCategoryResult.getLink());
    assertNull(actualBuildCrumbForCategoryResult.getText());
  }

  /**
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#buildCrumbForCategory(Category, String, Map)}
   */
  @Test
  void testBuildCrumbForCategory2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();

    // Act and Assert
    assertNull(categoryBreadcrumbServiceExtensionHandler.buildCrumbForCategory(null, "https://example.org/example",
        new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#buildCrumbForCategory(Category, String, Map)}
   */
  @Test
  void testBuildCrumbForCategory3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    Category category = mock(Category.class);
    when(category.getName()).thenReturn("Name");
    when(category.getUrl()).thenReturn("https://example.org/example");

    // Act
    BreadcrumbDTO actualBuildCrumbForCategoryResult = categoryBreadcrumbServiceExtensionHandler
        .buildCrumbForCategory(category, "https://example.org/example", new HashMap<>());

    // Assert
    verify(category).getName();
    verify(category).getUrl();
    assertEquals("CATEGORY", actualBuildCrumbForCategoryResult.getType());
    assertEquals("Name", actualBuildCrumbForCategoryResult.getText());
    assertEquals("https://example.org/example", actualBuildCrumbForCategoryResult.getLink());
  }

  /**
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#addParentCrumbs(List, Category, String, Map)}
   */
  @Test
  void testAddParentCrumbs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    ArrayList<BreadcrumbDTO> parentCrumbs = new ArrayList<>();
    CategoryImpl category = new CategoryImpl();

    // Act
    categoryBreadcrumbServiceExtensionHandler.addParentCrumbs(parentCrumbs, category, "https://example.org/example",
        new HashMap<>());

    // Assert that nothing has changed
    assertTrue(parentCrumbs.isEmpty());
  }

  /**
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#addParentCrumbs(List, Category, String, Map)}
   */
  @Test
  void testAddParentCrumbs2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();

    BreadcrumbDTO breadcrumbDTO = new BreadcrumbDTO();
    breadcrumbDTO.setLink("Link");
    breadcrumbDTO.setText("Text");
    breadcrumbDTO.setType(new BreadcrumbDTOType("Type", "Friendly Type"));

    ArrayList<BreadcrumbDTO> parentCrumbs = new ArrayList<>();
    parentCrumbs.add(breadcrumbDTO);
    CategoryImpl category = new CategoryImpl();

    // Act
    categoryBreadcrumbServiceExtensionHandler.addParentCrumbs(parentCrumbs, category, "https://example.org/example",
        new HashMap<>());

    // Assert that nothing has changed
    assertEquals(1, parentCrumbs.size());
    assertSame(breadcrumbDTO, parentCrumbs.get(0));
  }

  /**
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#addParentCrumbs(List, Category, String, Map)}
   */
  @Test
  void testAddParentCrumbs3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();

    BreadcrumbDTO breadcrumbDTO = new BreadcrumbDTO();
    breadcrumbDTO.setLink("Link");
    breadcrumbDTO.setText("Text");
    breadcrumbDTO.setType(new BreadcrumbDTOType("Type", "Friendly Type"));

    BreadcrumbDTO breadcrumbDTO2 = new BreadcrumbDTO();
    breadcrumbDTO2.setLink("42");
    breadcrumbDTO2.setText("42");
    breadcrumbDTO2.setType(new BreadcrumbDTOType("Type", "Friendly Type"));

    ArrayList<BreadcrumbDTO> parentCrumbs = new ArrayList<>();
    parentCrumbs.add(breadcrumbDTO2);
    parentCrumbs.add(breadcrumbDTO);
    CategoryImpl category = new CategoryImpl();

    // Act
    categoryBreadcrumbServiceExtensionHandler.addParentCrumbs(parentCrumbs, category, "https://example.org/example",
        new HashMap<>());

    // Assert that nothing has changed
    assertEquals(2, parentCrumbs.size());
    assertSame(breadcrumbDTO2, parentCrumbs.get(0));
    assertSame(breadcrumbDTO, parentCrumbs.get(1));
  }

  /**
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#addParentCrumbs(List, Category, String, Map)}
   */
  @Test
  void testAddParentCrumbs4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    ArrayList<BreadcrumbDTO> parentCrumbs = new ArrayList<>();
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getParentCategory()).thenReturn(new CategoryImpl());

    // Act
    categoryBreadcrumbServiceExtensionHandler.addParentCrumbs(parentCrumbs, category, "https://example.org/example",
        new HashMap<>());

    // Assert
    verify(category).getParentCategory();
    assertEquals(1, parentCrumbs.size());
    BreadcrumbDTO getResult = parentCrumbs.get(0);
    assertEquals("CATEGORY", getResult.getType());
    assertNull(getResult.getLink());
    assertNull(getResult.getText());
  }

  /**
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#addParentCrumbs(List, Category, String, Map)}
   */
  @Test
  void testAddParentCrumbs5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    ArrayList<BreadcrumbDTO> parentCrumbs = new ArrayList<>();
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getName()).thenReturn("Name");
    when(categoryImpl.getUrl()).thenReturn("https://example.org/example");
    when(categoryImpl.getParentCategory()).thenReturn(new CategoryImpl());
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getParentCategory()).thenReturn(categoryImpl);

    // Act
    categoryBreadcrumbServiceExtensionHandler.addParentCrumbs(parentCrumbs, category, "https://example.org/example",
        new HashMap<>());

    // Assert
    verify(categoryImpl).getName();
    verify(category).getParentCategory();
    verify(categoryImpl).getParentCategory();
    verify(categoryImpl).getUrl();
    assertEquals(2, parentCrumbs.size());
    BreadcrumbDTO getResult = parentCrumbs.get(0);
    assertEquals("CATEGORY", getResult.getType());
    BreadcrumbDTO getResult2 = parentCrumbs.get(1);
    assertEquals("CATEGORY", getResult2.getType());
    assertEquals("Name", getResult2.getText());
    assertEquals("https://example.org/example", getResult2.getLink());
    assertNull(getResult.getLink());
    assertNull(getResult.getText());
  }

  /**
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#buildCategorySearchCrumb(Category, String, Map)}
   */
  @Test
  void testBuildCategorySearchCrumb() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    CategoryImpl category = new CategoryImpl();

    // Act and Assert
    assertNull(categoryBreadcrumbServiceExtensionHandler.buildCategorySearchCrumb(category,
        "https://example.org/example", new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#buildCategorySearchCrumb(Category, String, Map)}
   */
  @Test
  void testBuildCategorySearchCrumb2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    CategoryImpl category = mock(CategoryImpl.class);

    // Act and Assert
    assertNull(categoryBreadcrumbServiceExtensionHandler.buildCategorySearchCrumb(category,
        "https://example.org/example", new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#getNameForCategoryLink(Category)}
   */
  @Test
  void testGetNameForCategoryLink() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();

    // Act and Assert
    assertNull(categoryBreadcrumbServiceExtensionHandler.getNameForCategoryLink(new CategoryImpl()));
  }

  /**
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#getNameForCategoryLink(Category)}
   */
  @Test
  void testGetNameForCategoryLink2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    Category category = mock(Category.class);
    when(category.getName()).thenReturn("Name");

    // Act
    String actualNameForCategoryLink = categoryBreadcrumbServiceExtensionHandler.getNameForCategoryLink(category);

    // Assert
    verify(category).getName();
    assertEquals("Name", actualNameForCategoryLink);
  }

  /**
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#determineFirstCategory(String, Map, ExtensionResultHolder)}
   */
  @Test
  void testDetermineFirstCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    HashMap<String, String[]> params = new HashMap<>();

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act and Assert
    assertNull(categoryBreadcrumbServiceExtensionHandler.determineFirstCategory("https://example.org/example", params,
        holder));
  }

  /**
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#determineFirstCategory(String, Map, ExtensionResultHolder)}
   */
  @Test
  void testDetermineFirstCategory2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    HashMap<String, String[]> params = new HashMap<>();
    ExtensionResultHolder<List<BreadcrumbDTO>> holder = mock(ExtensionResultHolder.class);
    doNothing().when(holder).setResult(Mockito.<List<BreadcrumbDTO>>any());
    doNothing().when(holder).setThrowable(Mockito.<Throwable>any());
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act
    Category actualDetermineFirstCategoryResult = categoryBreadcrumbServiceExtensionHandler
        .determineFirstCategory("https://example.org/example", params, holder);

    // Assert
    verify(holder).setResult(isA(List.class));
    verify(holder).setThrowable(isA(Throwable.class));
    assertNull(actualDetermineFirstCategoryResult);
  }

  /**
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)}
   */
  @Test
  void testGetMatchingCategoryFromProduct() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    BroadleafRequestContext brc = new BroadleafRequestContext();

    // Act and Assert
    assertNull(categoryBreadcrumbServiceExtensionHandler.getMatchingCategoryFromProduct(brc,
        "https://example.org/example", new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)}
   */
  @Test
  void testGetMatchingCategoryFromProduct2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();

    // Act and Assert
    assertNull(categoryBreadcrumbServiceExtensionHandler.getMatchingCategoryFromProduct(null,
        "https://example.org/example", new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)}
   */
  @Test
  void testGetMatchingCategoryFromProduct3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    BroadleafRequestContext brc = mock(BroadleafRequestContext.class);
    when(brc.getRequestAttribute(Mockito.<String>any())).thenReturn(null);

    // Act
    Category actualMatchingCategoryFromProduct = categoryBreadcrumbServiceExtensionHandler
        .getMatchingCategoryFromProduct(brc, "https://example.org/example", new HashMap<>());

    // Assert
    verify(brc).getRequestAttribute(eq("currentProduct"));
    assertNull(actualMatchingCategoryFromProduct);
  }

  /**
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)}
   */
  @Test
  void testGetMatchingCategoryFromProduct4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getCategory()).thenReturn(new CategoryImpl());
    BroadleafRequestContext brc = mock(BroadleafRequestContext.class);
    when(brc.getRequestAttribute(Mockito.<String>any())).thenReturn(productBundleImpl);

    // Act
    Category actualMatchingCategoryFromProduct = categoryBreadcrumbServiceExtensionHandler
        .getMatchingCategoryFromProduct(brc, "https://example.org/example", new HashMap<>());

    // Assert
    verify(brc).getRequestAttribute(eq("currentProduct"));
    verify(productBundleImpl).getCategory();
    assertNull(actualMatchingCategoryFromProduct);
  }

  /**
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)}
   */
  @Test
  void testGetMatchingCategoryFromProduct5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getCategory()).thenReturn(null);
    BroadleafRequestContext brc = mock(BroadleafRequestContext.class);
    when(brc.getRequestAttribute(Mockito.<String>any())).thenReturn(productBundleImpl);

    // Act
    Category actualMatchingCategoryFromProduct = categoryBreadcrumbServiceExtensionHandler
        .getMatchingCategoryFromProduct(brc, "https://example.org/example", new HashMap<>());

    // Assert
    verify(brc).getRequestAttribute(eq("currentProduct"));
    verify(productBundleImpl).getCategory();
    assertNull(actualMatchingCategoryFromProduct);
  }

  /**
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)}
   */
  @Test
  void testGetMatchingCategoryFromProduct6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getUrl()).thenReturn("https://example.org/example");
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getCategory()).thenReturn(categoryImpl);
    BroadleafRequestContext brc = mock(BroadleafRequestContext.class);
    when(brc.getRequestAttribute(Mockito.<String>any())).thenReturn(productBundleImpl);

    // Act
    categoryBreadcrumbServiceExtensionHandler.getMatchingCategoryFromProduct(brc, "https://example.org/example",
        new HashMap<>());

    // Assert
    verify(brc).getRequestAttribute(eq("currentProduct"));
    verify(categoryImpl).getUrl();
    verify(productBundleImpl).getCategory();
  }

  /**
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)}
   */
  @Test
  void testGetMatchingCategoryFromProduct7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getCategory()).thenReturn(mock(CategoryImpl.class));
    BroadleafRequestContext brc = mock(BroadleafRequestContext.class);
    when(brc.getRequestAttribute(Mockito.<String>any())).thenReturn(productBundleImpl);

    // Act
    Category actualMatchingCategoryFromProduct = categoryBreadcrumbServiceExtensionHandler
        .getMatchingCategoryFromProduct(brc, null, new HashMap<>());

    // Assert
    verify(brc).getRequestAttribute(eq("currentProduct"));
    verify(productBundleImpl).getCategory();
    assertNull(actualMatchingCategoryFromProduct);
  }

  /**
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#getDefaultPriority()}
   */
  @Test
  void testGetDefaultPriority() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(2000, (new CategoryBreadcrumbServiceExtensionHandler()).getDefaultPriority());
  }

  /**
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#getDefaultPriority()}
   */
  @Test
  void testGetDefaultPriority2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getParentCategory()).thenReturn(new CategoryImpl());

    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    ArrayList<BreadcrumbDTO> parentCrumbs = new ArrayList<>();
    categoryBreadcrumbServiceExtensionHandler.addParentCrumbs(parentCrumbs, category, "https://example.org/example",
        new HashMap<>());

    // Act
    int actualDefaultPriority = categoryBreadcrumbServiceExtensionHandler.getDefaultPriority();

    // Assert
    verify(category).getParentCategory();
    assertEquals(2000, actualDefaultPriority);
  }
}

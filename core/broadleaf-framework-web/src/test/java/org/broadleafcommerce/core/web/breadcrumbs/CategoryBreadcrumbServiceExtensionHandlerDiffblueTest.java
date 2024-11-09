/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.breadcrumbs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import org.broadleafcommerce.core.catalog.domain.ProductImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CategoryBreadcrumbServiceExtensionHandlerDiffblueTest {
  /**
   * Test
   * {@link CategoryBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link ExtensionResultHolder#getContextMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test modifyBreadcrumbList(String, Map, ExtensionResultHolder); given HashMap(); then calls getContextMap()")
  void testModifyBreadcrumbList_givenHashMap_thenCallsGetContextMap() {
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
   * Test
   * {@link CategoryBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link ExtensionResultHolder} (default constructor) Result is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test modifyBreadcrumbList(String, Map, ExtensionResultHolder); when ExtensionResultHolder (default constructor) Result is ArrayList()")
  void testModifyBreadcrumbList_whenExtensionResultHolderResultIsArrayList() {
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
   * Test
   * {@link CategoryBreadcrumbServiceExtensionHandler#buildCrumbForCategory(Category, String, Map)}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then return Text is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#buildCrumbForCategory(Category, String, Map)}
   */
  @Test
  @DisplayName("Test buildCrumbForCategory(Category, String, Map); given 'Name'; then return Text is 'Name'")
  void testBuildCrumbForCategory_givenName_thenReturnTextIsName() {
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
   * Test
   * {@link CategoryBreadcrumbServiceExtensionHandler#buildCrumbForCategory(Category, String, Map)}.
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).</li>
   *   <li>Then return Link is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#buildCrumbForCategory(Category, String, Map)}
   */
  @Test
  @DisplayName("Test buildCrumbForCategory(Category, String, Map); when CategoryImpl (default constructor); then return Link is 'null'")
  void testBuildCrumbForCategory_whenCategoryImpl_thenReturnLinkIsNull() {
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
   * Test
   * {@link CategoryBreadcrumbServiceExtensionHandler#buildCrumbForCategory(Category, String, Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#buildCrumbForCategory(Category, String, Map)}
   */
  @Test
  @DisplayName("Test buildCrumbForCategory(Category, String, Map); when 'null'; then return 'null'")
  void testBuildCrumbForCategory_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();

    // Act and Assert
    assertNull(categoryBreadcrumbServiceExtensionHandler.buildCrumbForCategory(null, "https://example.org/example",
        new HashMap<>()));
  }

  /**
   * Test
   * {@link CategoryBreadcrumbServiceExtensionHandler#addParentCrumbs(List, Category, String, Map)}.
   * <ul>
   *   <li>Given {@link BreadcrumbDTO} (default constructor) Link is
   * {@code 42}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} first Link is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#addParentCrumbs(List, Category, String, Map)}
   */
  @Test
  @DisplayName("Test addParentCrumbs(List, Category, String, Map); given BreadcrumbDTO (default constructor) Link is '42'; then ArrayList() first Link is '42'")
  void testAddParentCrumbs_givenBreadcrumbDTOLinkIs42_thenArrayListFirstLinkIs42() {
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
    BreadcrumbDTO getResult = parentCrumbs.get(0);
    assertEquals("42", getResult.getLink());
    assertEquals("42", getResult.getText());
    assertEquals("Type", getResult.getType());
  }

  /**
   * Test
   * {@link CategoryBreadcrumbServiceExtensionHandler#addParentCrumbs(List, Category, String, Map)}.
   * <ul>
   *   <li>Given {@link BreadcrumbDTO} (default constructor) Link is
   * {@code Link}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} first Link is {@code Link}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#addParentCrumbs(List, Category, String, Map)}
   */
  @Test
  @DisplayName("Test addParentCrumbs(List, Category, String, Map); given BreadcrumbDTO (default constructor) Link is 'Link'; then ArrayList() first Link is 'Link'")
  void testAddParentCrumbs_givenBreadcrumbDTOLinkIsLink_thenArrayListFirstLinkIsLink() {
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
    BreadcrumbDTO getResult = parentCrumbs.get(0);
    assertEquals("Link", getResult.getLink());
    assertEquals("Text", getResult.getText());
    assertEquals("Type", getResult.getType());
  }

  /**
   * Test
   * {@link CategoryBreadcrumbServiceExtensionHandler#addParentCrumbs(List, Category, String, Map)}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   *   <li>Then {@link ArrayList#ArrayList()} first Type is {@code CATEGORY}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#addParentCrumbs(List, Category, String, Map)}
   */
  @Test
  @DisplayName("Test addParentCrumbs(List, Category, String, Map); given CategoryImpl (default constructor); then ArrayList() first Type is 'CATEGORY'")
  void testAddParentCrumbs_givenCategoryImpl_thenArrayListFirstTypeIsCategory() {
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
   * Test
   * {@link CategoryBreadcrumbServiceExtensionHandler#addParentCrumbs(List, Category, String, Map)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} second Type is {@code CATEGORY}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#addParentCrumbs(List, Category, String, Map)}
   */
  @Test
  @DisplayName("Test addParentCrumbs(List, Category, String, Map); then ArrayList() second Type is 'CATEGORY'")
  void testAddParentCrumbs_thenArrayListSecondTypeIsCategory() {
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
    BreadcrumbDTO getResult = parentCrumbs.get(1);
    assertEquals("CATEGORY", getResult.getType());
    assertEquals("Name", getResult.getText());
    assertEquals("https://example.org/example", getResult.getLink());
  }

  /**
   * Test
   * {@link CategoryBreadcrumbServiceExtensionHandler#addParentCrumbs(List, Category, String, Map)}.
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#addParentCrumbs(List, Category, String, Map)}
   */
  @Test
  @DisplayName("Test addParentCrumbs(List, Category, String, Map); when CategoryImpl (default constructor); then ArrayList() Empty")
  void testAddParentCrumbs_whenCategoryImpl_thenArrayListEmpty() {
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
   * Test
   * {@link CategoryBreadcrumbServiceExtensionHandler#buildCategorySearchCrumb(Category, String, Map)}.
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#buildCategorySearchCrumb(Category, String, Map)}
   */
  @Test
  @DisplayName("Test buildCategorySearchCrumb(Category, String, Map); when CategoryImpl (default constructor)")
  void testBuildCategorySearchCrumb_whenCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    CategoryImpl category = new CategoryImpl();

    // Act and Assert
    assertNull(categoryBreadcrumbServiceExtensionHandler.buildCategorySearchCrumb(category,
        "https://example.org/example", new HashMap<>()));
  }

  /**
   * Test
   * {@link CategoryBreadcrumbServiceExtensionHandler#buildCategorySearchCrumb(Category, String, Map)}.
   * <ul>
   *   <li>When {@link CategoryImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#buildCategorySearchCrumb(Category, String, Map)}
   */
  @Test
  @DisplayName("Test buildCategorySearchCrumb(Category, String, Map); when CategoryImpl")
  void testBuildCategorySearchCrumb_whenCategoryImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    CategoryImpl category = mock(CategoryImpl.class);

    // Act and Assert
    assertNull(categoryBreadcrumbServiceExtensionHandler.buildCategorySearchCrumb(category,
        "https://example.org/example", new HashMap<>()));
  }

  /**
   * Test
   * {@link CategoryBreadcrumbServiceExtensionHandler#getNameForCategoryLink(Category)}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#getNameForCategoryLink(Category)}
   */
  @Test
  @DisplayName("Test getNameForCategoryLink(Category); given 'Name'; then return 'Name'")
  void testGetNameForCategoryLink_givenName_thenReturnName() {
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
   * Test
   * {@link CategoryBreadcrumbServiceExtensionHandler#getNameForCategoryLink(Category)}.
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#getNameForCategoryLink(Category)}
   */
  @Test
  @DisplayName("Test getNameForCategoryLink(Category); when CategoryImpl (default constructor); then return 'null'")
  void testGetNameForCategoryLink_whenCategoryImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();

    // Act and Assert
    assertNull(categoryBreadcrumbServiceExtensionHandler.getNameForCategoryLink(new CategoryImpl()));
  }

  /**
   * Test
   * {@link CategoryBreadcrumbServiceExtensionHandler#determineFirstCategory(String, Map, ExtensionResultHolder)}.
   * <ul>
   *   <li>Then calls {@link ExtensionResultHolder#setResult(Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#determineFirstCategory(String, Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test determineFirstCategory(String, Map, ExtensionResultHolder); then calls setResult(Object)")
  void testDetermineFirstCategory_thenCallsSetResult() {
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
   * Test
   * {@link CategoryBreadcrumbServiceExtensionHandler#determineFirstCategory(String, Map, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link ExtensionResultHolder} (default constructor) Result is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#determineFirstCategory(String, Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test determineFirstCategory(String, Map, ExtensionResultHolder); when ExtensionResultHolder (default constructor) Result is ArrayList()")
  void testDetermineFirstCategory_whenExtensionResultHolderResultIsArrayList() {
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
   * Test
   * {@link CategoryBreadcrumbServiceExtensionHandler#getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)}.
   * <p>
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)}
   */
  @Test
  @DisplayName("Test getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)")
  void testGetMatchingCategoryFromProduct() {
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
   * Test
   * {@link CategoryBreadcrumbServiceExtensionHandler#getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)}.
   * <p>
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)}
   */
  @Test
  @DisplayName("Test getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)")
  void testGetMatchingCategoryFromProduct2() {
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
   * Test
   * {@link CategoryBreadcrumbServiceExtensionHandler#getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)}.
   * <p>
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)}
   */
  @Test
  @DisplayName("Test getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)")
  void testGetMatchingCategoryFromProduct3() {
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
   * Test
   * {@link CategoryBreadcrumbServiceExtensionHandler#getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getCategory()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)}
   */
  @Test
  @DisplayName("Test getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map); given ProductBundleImpl getCategory() return 'null'")
  void testGetMatchingCategoryFromProduct_givenProductBundleImplGetCategoryReturnNull() {
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
   * Test
   * {@link CategoryBreadcrumbServiceExtensionHandler#getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)}.
   * <ul>
   *   <li>Then calls {@link CategoryImpl#getUrl()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)}
   */
  @Test
  @DisplayName("Test getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map); then calls getUrl()")
  void testGetMatchingCategoryFromProduct_thenCallsGetUrl() {
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
   * Test
   * {@link CategoryBreadcrumbServiceExtensionHandler#getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)}.
   * <ul>
   *   <li>When {@link BroadleafRequestContext} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)}
   */
  @Test
  @DisplayName("Test getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map); when BroadleafRequestContext (default constructor); then return 'null'")
  void testGetMatchingCategoryFromProduct_whenBroadleafRequestContext_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    BroadleafRequestContext brc = new BroadleafRequestContext();

    // Act and Assert
    assertNull(categoryBreadcrumbServiceExtensionHandler.getMatchingCategoryFromProduct(brc,
        "https://example.org/example", new HashMap<>()));
  }

  /**
   * Test
   * {@link CategoryBreadcrumbServiceExtensionHandler#getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)}
   */
  @Test
  @DisplayName("Test getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map); when 'null'; then return 'null'")
  void testGetMatchingCategoryFromProduct_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();

    // Act and Assert
    assertNull(categoryBreadcrumbServiceExtensionHandler.getMatchingCategoryFromProduct(null,
        "https://example.org/example", new HashMap<>()));
  }

  /**
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#getDefaultPriority()}.
   * <p>
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#getDefaultPriority()}
   */
  @Test
  @DisplayName("Test getDefaultPriority()")
  void testGetDefaultPriority() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(2000, (new CategoryBreadcrumbServiceExtensionHandler()).getDefaultPriority());
  }

  /**
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#getDefaultPriority()}.
   * <ul>
   *   <li>Then calls {@link CategoryImpl#getParentCategory()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryBreadcrumbServiceExtensionHandler#getDefaultPriority()}
   */
  @Test
  @DisplayName("Test getDefaultPriority(); then calls getParentCategory()")
  void testGetDefaultPriority_thenCallsGetParentCategory() {
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

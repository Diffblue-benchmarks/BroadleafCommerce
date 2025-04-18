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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTO;
import org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType;
import org.broadleafcommerce.common.breadcrumbs.service.BreadcrumbServiceExtensionHandler;
import org.broadleafcommerce.common.breadcrumbs.service.BreadcrumbServiceExtensionManager;
import org.broadleafcommerce.common.extension.ExtensionManager;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.web.BroadleafRequestContext;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.ProductImpl;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@ExtendWith(MockitoExtension.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class CategoryBreadcrumbServiceExtensionHandlerDiffblueTest {
  @Mock
  private BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager;

  @Mock
  private CatalogService catalogService;

  @InjectMocks
  private CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler;

  /**
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#init()}.
   * <ul>
   *   <li>Then calls {@link ExtensionManager#registerHandler(ExtensionHandler)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryBreadcrumbServiceExtensionHandler#init()}
   */
  @Test
  @DisplayName("Test init(); then calls registerHandler(ExtensionHandler)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CategoryBreadcrumbServiceExtensionHandler.init()"})
  void testInit_thenCallsRegisterHandler() {
    // Arrange
    when(breadcrumbServiceExtensionManager.registerHandler(Mockito.<BreadcrumbServiceExtensionHandler>any()))
        .thenReturn(true);

    // Act
    categoryBreadcrumbServiceExtensionHandler.init();

    // Assert
    verify(breadcrumbServiceExtensionManager).registerHandler(isA(BreadcrumbServiceExtensionHandler.class));
  }

  /**
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link CategoryBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test modifyBreadcrumbList(String, Map, ExtensionResultHolder)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ExtensionResultStatusType CategoryBreadcrumbServiceExtensionHandler.modifyBreadcrumbList(String, Map, ExtensionResultHolder)"})
  void testModifyBreadcrumbList() {
    // Arrange
    HashMap<String, String[]> params = new HashMap<>();

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE,
        categoryBreadcrumbServiceExtensionHandler.modifyBreadcrumbList("https://example.org/example", params, holder));
  }

  /**
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#buildCrumbForCategory(Category, String, Map)}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then return Text is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryBreadcrumbServiceExtensionHandler#buildCrumbForCategory(Category, String, Map)}
   */
  @Test
  @DisplayName("Test buildCrumbForCategory(Category, String, Map); given 'Name'; then return Text is 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "BreadcrumbDTO CategoryBreadcrumbServiceExtensionHandler.buildCrumbForCategory(Category, String, Map)"})
  void testBuildCrumbForCategory_givenName_thenReturnTextIsName() {
    // Arrange
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
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#buildCrumbForCategory(Category, String, Map)}.
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).</li>
   *   <li>Then return Link is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryBreadcrumbServiceExtensionHandler#buildCrumbForCategory(Category, String, Map)}
   */
  @Test
  @DisplayName("Test buildCrumbForCategory(Category, String, Map); when CategoryImpl (default constructor); then return Link is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "BreadcrumbDTO CategoryBreadcrumbServiceExtensionHandler.buildCrumbForCategory(Category, String, Map)"})
  void testBuildCrumbForCategory_whenCategoryImpl_thenReturnLinkIsNull() {
    // Arrange
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
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#buildCrumbForCategory(Category, String, Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryBreadcrumbServiceExtensionHandler#buildCrumbForCategory(Category, String, Map)}
   */
  @Test
  @DisplayName("Test buildCrumbForCategory(Category, String, Map); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "BreadcrumbDTO CategoryBreadcrumbServiceExtensionHandler.buildCrumbForCategory(Category, String, Map)"})
  void testBuildCrumbForCategory_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(categoryBreadcrumbServiceExtensionHandler.buildCrumbForCategory(null, "https://example.org/example",
        new HashMap<>()));
  }

  /**
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#addParentCrumbs(List, Category, String, Map)}.
   * <ul>
   *   <li>Given {@link BreadcrumbDTO} (default constructor) Link is {@code 42}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} first Link is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryBreadcrumbServiceExtensionHandler#addParentCrumbs(List, Category, String, Map)}
   */
  @Test
  @DisplayName("Test addParentCrumbs(List, Category, String, Map); given BreadcrumbDTO (default constructor) Link is '42'; then ArrayList() first Link is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CategoryBreadcrumbServiceExtensionHandler.addParentCrumbs(List, Category, String, Map)"})
  void testAddParentCrumbs_givenBreadcrumbDTOLinkIs42_thenArrayListFirstLinkIs42() {
    // Arrange
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
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#addParentCrumbs(List, Category, String, Map)}.
   * <ul>
   *   <li>Given {@link BreadcrumbDTO} (default constructor) Link is {@code Link}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} first Link is {@code Link}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryBreadcrumbServiceExtensionHandler#addParentCrumbs(List, Category, String, Map)}
   */
  @Test
  @DisplayName("Test addParentCrumbs(List, Category, String, Map); given BreadcrumbDTO (default constructor) Link is 'Link'; then ArrayList() first Link is 'Link'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CategoryBreadcrumbServiceExtensionHandler.addParentCrumbs(List, Category, String, Map)"})
  void testAddParentCrumbs_givenBreadcrumbDTOLinkIsLink_thenArrayListFirstLinkIsLink() {
    // Arrange
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
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#addParentCrumbs(List, Category, String, Map)}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   *   <li>Then {@link ArrayList#ArrayList()} first Type is {@code CATEGORY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryBreadcrumbServiceExtensionHandler#addParentCrumbs(List, Category, String, Map)}
   */
  @Test
  @DisplayName("Test addParentCrumbs(List, Category, String, Map); given CategoryImpl (default constructor); then ArrayList() first Type is 'CATEGORY'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CategoryBreadcrumbServiceExtensionHandler.addParentCrumbs(List, Category, String, Map)"})
  void testAddParentCrumbs_givenCategoryImpl_thenArrayListFirstTypeIsCategory() {
    // Arrange
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
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#addParentCrumbs(List, Category, String, Map)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} second Type is {@code CATEGORY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryBreadcrumbServiceExtensionHandler#addParentCrumbs(List, Category, String, Map)}
   */
  @Test
  @DisplayName("Test addParentCrumbs(List, Category, String, Map); then ArrayList() second Type is 'CATEGORY'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CategoryBreadcrumbServiceExtensionHandler.addParentCrumbs(List, Category, String, Map)"})
  void testAddParentCrumbs_thenArrayListSecondTypeIsCategory() {
    // Arrange
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
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#addParentCrumbs(List, Category, String, Map)}.
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryBreadcrumbServiceExtensionHandler#addParentCrumbs(List, Category, String, Map)}
   */
  @Test
  @DisplayName("Test addParentCrumbs(List, Category, String, Map); when CategoryImpl (default constructor); then ArrayList() Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CategoryBreadcrumbServiceExtensionHandler.addParentCrumbs(List, Category, String, Map)"})
  void testAddParentCrumbs_whenCategoryImpl_thenArrayListEmpty() {
    // Arrange
    ArrayList<BreadcrumbDTO> parentCrumbs = new ArrayList<>();
    CategoryImpl category = new CategoryImpl();

    // Act
    categoryBreadcrumbServiceExtensionHandler.addParentCrumbs(parentCrumbs, category, "https://example.org/example",
        new HashMap<>());

    // Assert that nothing has changed
    assertTrue(parentCrumbs.isEmpty());
  }

  /**
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#buildCategorySearchCrumb(Category, String, Map)}.
   * <p>
   * Method under test: {@link CategoryBreadcrumbServiceExtensionHandler#buildCategorySearchCrumb(Category, String, Map)}
   */
  @Test
  @DisplayName("Test buildCategorySearchCrumb(Category, String, Map)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "BreadcrumbDTO CategoryBreadcrumbServiceExtensionHandler.buildCategorySearchCrumb(Category, String, Map)"})
  void testBuildCategorySearchCrumb() {
    // Arrange
    CategoryImpl category = new CategoryImpl();

    // Act and Assert
    assertNull(categoryBreadcrumbServiceExtensionHandler.buildCategorySearchCrumb(category,
        "https://example.org/example", new HashMap<>()));
  }

  /**
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#getNameForCategoryLink(Category)}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryBreadcrumbServiceExtensionHandler#getNameForCategoryLink(Category)}
   */
  @Test
  @DisplayName("Test getNameForCategoryLink(Category); given 'Name'; then return 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CategoryBreadcrumbServiceExtensionHandler.getNameForCategoryLink(Category)"})
  void testGetNameForCategoryLink_givenName_thenReturnName() {
    // Arrange
    Category category = mock(Category.class);
    when(category.getName()).thenReturn("Name");

    // Act
    String actualNameForCategoryLink = categoryBreadcrumbServiceExtensionHandler.getNameForCategoryLink(category);

    // Assert
    verify(category).getName();
    assertEquals("Name", actualNameForCategoryLink);
  }

  /**
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#getNameForCategoryLink(Category)}.
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryBreadcrumbServiceExtensionHandler#getNameForCategoryLink(Category)}
   */
  @Test
  @DisplayName("Test getNameForCategoryLink(Category); when CategoryImpl (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CategoryBreadcrumbServiceExtensionHandler.getNameForCategoryLink(Category)"})
  void testGetNameForCategoryLink_whenCategoryImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(categoryBreadcrumbServiceExtensionHandler.getNameForCategoryLink(new CategoryImpl()));
  }

  /**
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#determineFirstCategory(String, Map, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link CategoryBreadcrumbServiceExtensionHandler#determineFirstCategory(String, Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test determineFirstCategory(String, Map, ExtensionResultHolder)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Category CategoryBreadcrumbServiceExtensionHandler.determineFirstCategory(String, Map, ExtensionResultHolder)"})
  void testDetermineFirstCategory() {
    // Arrange
    HashMap<String, String[]> params = new HashMap<>();

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act and Assert
    assertNull(categoryBreadcrumbServiceExtensionHandler.determineFirstCategory("https://example.org/example", params,
        holder));
  }

  /**
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)}.
   * <p>
   * Method under test: {@link CategoryBreadcrumbServiceExtensionHandler#getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)}
   */
  @Test
  @DisplayName("Test getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Category CategoryBreadcrumbServiceExtensionHandler.getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)"})
  void testGetMatchingCategoryFromProduct() {
    // Arrange
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
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)}.
   * <p>
   * Method under test: {@link CategoryBreadcrumbServiceExtensionHandler#getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)}
   */
  @Test
  @DisplayName("Test getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Category CategoryBreadcrumbServiceExtensionHandler.getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)"})
  void testGetMatchingCategoryFromProduct2() {
    // Arrange
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
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryBreadcrumbServiceExtensionHandler#getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)}
   */
  @Test
  @DisplayName("Test getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map); given 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Category CategoryBreadcrumbServiceExtensionHandler.getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)"})
  void testGetMatchingCategoryFromProduct_givenNull() {
    // Arrange
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
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getCategory()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryBreadcrumbServiceExtensionHandler#getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)}
   */
  @Test
  @DisplayName("Test getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map); given ProductBundleImpl getCategory() return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Category CategoryBreadcrumbServiceExtensionHandler.getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)"})
  void testGetMatchingCategoryFromProduct_givenProductBundleImplGetCategoryReturnNull() {
    // Arrange
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
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)}.
   * <ul>
   *   <li>Then calls {@link CategoryImpl#getUrl()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryBreadcrumbServiceExtensionHandler#getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)}
   */
  @Test
  @DisplayName("Test getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map); then calls getUrl()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Category CategoryBreadcrumbServiceExtensionHandler.getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)"})
  void testGetMatchingCategoryFromProduct_thenCallsGetUrl() {
    // Arrange
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
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)}.
   * <ul>
   *   <li>When {@link BroadleafRequestContext} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryBreadcrumbServiceExtensionHandler#getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)}
   */
  @Test
  @DisplayName("Test getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map); when BroadleafRequestContext (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Category CategoryBreadcrumbServiceExtensionHandler.getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)"})
  void testGetMatchingCategoryFromProduct_whenBroadleafRequestContext_thenReturnNull() {
    // Arrange
    BroadleafRequestContext brc = new BroadleafRequestContext();

    // Act and Assert
    assertNull(categoryBreadcrumbServiceExtensionHandler.getMatchingCategoryFromProduct(brc,
        "https://example.org/example", new HashMap<>()));
  }

  /**
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryBreadcrumbServiceExtensionHandler#getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)}
   */
  @Test
  @DisplayName("Test getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Category CategoryBreadcrumbServiceExtensionHandler.getMatchingCategoryFromProduct(BroadleafRequestContext, String, Map)"})
  void testGetMatchingCategoryFromProduct_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(categoryBreadcrumbServiceExtensionHandler.getMatchingCategoryFromProduct(null,
        "https://example.org/example", new HashMap<>()));
  }

  /**
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#getCategoryFromCategoryAttribute(BroadleafRequestContext, String, Map)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then calls {@link BroadleafRequestContext#getRequestAttribute(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryBreadcrumbServiceExtensionHandler#getCategoryFromCategoryAttribute(BroadleafRequestContext, String, Map)}
   */
  @Test
  @DisplayName("Test getCategoryFromCategoryAttribute(BroadleafRequestContext, String, Map); given 'null'; then calls getRequestAttribute(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Category CategoryBreadcrumbServiceExtensionHandler.getCategoryFromCategoryAttribute(BroadleafRequestContext, String, Map)"})
  void testGetCategoryFromCategoryAttribute_givenNull_thenCallsGetRequestAttribute() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    BroadleafRequestContext brc = mock(BroadleafRequestContext.class);
    when(brc.getRequestAttribute(Mockito.<String>any())).thenReturn(null);

    // Act
    Category actualCategoryFromCategoryAttribute = categoryBreadcrumbServiceExtensionHandler
        .getCategoryFromCategoryAttribute(brc, "https://example.org/example", new HashMap<>());

    // Assert
    verify(brc).getRequestAttribute(eq("category"));
    assertNull(actualCategoryFromCategoryAttribute);
  }

  /**
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#getCategoryFromCategoryAttribute(BroadleafRequestContext, String, Map)}.
   * <ul>
   *   <li>When {@link BroadleafRequestContext} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryBreadcrumbServiceExtensionHandler#getCategoryFromCategoryAttribute(BroadleafRequestContext, String, Map)}
   */
  @Test
  @DisplayName("Test getCategoryFromCategoryAttribute(BroadleafRequestContext, String, Map); when BroadleafRequestContext (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Category CategoryBreadcrumbServiceExtensionHandler.getCategoryFromCategoryAttribute(BroadleafRequestContext, String, Map)"})
  void testGetCategoryFromCategoryAttribute_whenBroadleafRequestContext_thenReturnNull() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler = new CategoryBreadcrumbServiceExtensionHandler();
    BroadleafRequestContext brc = new BroadleafRequestContext();

    // Act and Assert
    assertNull(categoryBreadcrumbServiceExtensionHandler.getCategoryFromCategoryAttribute(brc,
        "https://example.org/example", new HashMap<>()));
  }

  /**
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#getCategoryFromUrl(BroadleafRequestContext, String, Map)}.
   * <p>
   * Method under test: {@link CategoryBreadcrumbServiceExtensionHandler#getCategoryFromUrl(BroadleafRequestContext, String, Map)}
   */
  @Test
  @DisplayName("Test getCategoryFromUrl(BroadleafRequestContext, String, Map)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Category CategoryBreadcrumbServiceExtensionHandler.getCategoryFromUrl(BroadleafRequestContext, String, Map)"})
  void testGetCategoryFromUrl() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    when(catalogService.findCategoryByURI(Mockito.<String>any())).thenReturn(categoryImpl);
    BroadleafRequestContext brc = new BroadleafRequestContext();

    // Act
    Category actualCategoryFromUrl = categoryBreadcrumbServiceExtensionHandler.getCategoryFromUrl(brc,
        "https://example.org/example", new HashMap<>());

    // Assert
    verify(catalogService).findCategoryByURI(eq("https://example.org/example"));
    assertSame(categoryImpl, actualCategoryFromUrl);
  }

  /**
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#getDefaultPriority()}.
   * <p>
   * Method under test: {@link CategoryBreadcrumbServiceExtensionHandler#getDefaultPriority()}
   */
  @Test
  @DisplayName("Test getDefaultPriority()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CategoryBreadcrumbServiceExtensionHandler.getDefaultPriority()"})
  void testGetDefaultPriority() {
    // Arrange, Act and Assert
    assertEquals(2000, categoryBreadcrumbServiceExtensionHandler.getDefaultPriority());
  }
}

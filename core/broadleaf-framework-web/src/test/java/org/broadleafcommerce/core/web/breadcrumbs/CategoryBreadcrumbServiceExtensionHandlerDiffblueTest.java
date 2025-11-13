package org.broadleafcommerce.core.web.breadcrumbs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTO;
import org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType;
import org.broadleafcommerce.common.breadcrumbs.service.BreadcrumbServiceExtensionHandler;
import org.broadleafcommerce.common.breadcrumbs.service.BreadcrumbServiceExtensionManager;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.web.BroadleafRequestContext;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class CategoryBreadcrumbServiceExtensionHandlerDiffblueTest {
  @Mock private BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager;

  @Mock private CatalogService catalogService;

  @InjectMocks
  private CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler;

  /**
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#init()}.
   *
   * <ul>
   *   <li>Then calls {@link BreadcrumbServiceExtensionManager#registerHandler(ExtensionHandler)}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryBreadcrumbServiceExtensionHandler#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryBreadcrumbServiceExtensionHandler.init()"})
  public void testInit_thenCallsRegisterHandler() {
    // Arrange
    when(breadcrumbServiceExtensionManager.registerHandler(
            Mockito.<BreadcrumbServiceExtensionHandler>any()))
        .thenReturn(true);

    // Act
    categoryBreadcrumbServiceExtensionHandler.init();

    // Assert
    verify(breadcrumbServiceExtensionManager)
        .registerHandler(isA(BreadcrumbServiceExtensionHandler.class));
  }

  /**
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map,
   * ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link
   * CategoryBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType CategoryBreadcrumbServiceExtensionHandler.modifyBreadcrumbList(String, Map, ExtensionResultHolder)"
  })
  public void testModifyBreadcrumbList() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler =
        new CategoryBreadcrumbServiceExtensionHandler();
    HashMap<String, String[]> params = new HashMap<>();

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.HANDLED_CONTINUE,
        categoryBreadcrumbServiceExtensionHandler.modifyBreadcrumbList(
            "https://example.org/example", params, holder));
  }

  /**
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#buildCrumbForCategory(Category, String,
   * Map)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then return Text is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryBreadcrumbServiceExtensionHandler#buildCrumbForCategory(org.broadleafcommerce.core.catalog.domain.Category,
   * String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BreadcrumbDTO CategoryBreadcrumbServiceExtensionHandler.buildCrumbForCategory(org.broadleafcommerce.core.catalog.domain.Category, String, Map)"
  })
  public void testBuildCrumbForCategory_givenName_thenReturnTextIsName() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler =
        new CategoryBreadcrumbServiceExtensionHandler();

    org.broadleafcommerce.core.catalog.domain.Category category =
        mock(org.broadleafcommerce.core.catalog.domain.Category.class);
    when(category.getName()).thenReturn("Name");
    when(category.getUrl()).thenReturn("https://example.org/example");

    // Act
    BreadcrumbDTO actualBuildCrumbForCategoryResult =
        categoryBreadcrumbServiceExtensionHandler.buildCrumbForCategory(
            category, "https://example.org/example", new HashMap<>());

    // Assert
    verify(category).getName();
    verify(category).getUrl();
    assertEquals("CATEGORY", actualBuildCrumbForCategoryResult.getType());
    assertEquals("Name", actualBuildCrumbForCategoryResult.getText());
    assertEquals("https://example.org/example", actualBuildCrumbForCategoryResult.getLink());
  }

  /**
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#buildCrumbForCategory(Category, String,
   * Map)}.
   *
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).
   *   <li>Then return Link is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryBreadcrumbServiceExtensionHandler#buildCrumbForCategory(org.broadleafcommerce.core.catalog.domain.Category,
   * String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BreadcrumbDTO CategoryBreadcrumbServiceExtensionHandler.buildCrumbForCategory(org.broadleafcommerce.core.catalog.domain.Category, String, Map)"
  })
  public void testBuildCrumbForCategory_whenCategoryImpl_thenReturnLinkIsNull() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler =
        new CategoryBreadcrumbServiceExtensionHandler();
    CategoryImpl category = new CategoryImpl();

    // Act
    BreadcrumbDTO actualBuildCrumbForCategoryResult =
        categoryBreadcrumbServiceExtensionHandler.buildCrumbForCategory(
            category, "https://example.org/example", new HashMap<>());

    // Assert
    assertEquals("CATEGORY", actualBuildCrumbForCategoryResult.getType());
    assertNull(actualBuildCrumbForCategoryResult.getLink());
    assertNull(actualBuildCrumbForCategoryResult.getText());
  }

  /**
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#buildCrumbForCategory(Category, String,
   * Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryBreadcrumbServiceExtensionHandler#buildCrumbForCategory(org.broadleafcommerce.core.catalog.domain.Category,
   * String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BreadcrumbDTO CategoryBreadcrumbServiceExtensionHandler.buildCrumbForCategory(org.broadleafcommerce.core.catalog.domain.Category, String, Map)"
  })
  public void testBuildCrumbForCategory_whenNull_thenReturnNull() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler =
        new CategoryBreadcrumbServiceExtensionHandler();

    // Act and Assert
    assertNull(
        categoryBreadcrumbServiceExtensionHandler.buildCrumbForCategory(
            null, "https://example.org/example", new HashMap<>()));
  }

  /**
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#addParentCrumbs(List, Category, String,
   * Map)}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link CategoryBreadcrumbServiceExtensionHandler#addParentCrumbs(List,
   * org.broadleafcommerce.core.catalog.domain.Category, String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryBreadcrumbServiceExtensionHandler.addParentCrumbs(List, org.broadleafcommerce.core.catalog.domain.Category, String, Map)"
  })
  public void testAddParentCrumbs_givenCategoryImpl_thenArrayListSizeIsOne() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler =
        new CategoryBreadcrumbServiceExtensionHandler();
    ArrayList<BreadcrumbDTO> parentCrumbs = new ArrayList<>();

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getParentCategory()).thenReturn(new CategoryImpl());

    // Act
    categoryBreadcrumbServiceExtensionHandler.addParentCrumbs(
        parentCrumbs, category, "https://example.org/example", new HashMap<>());

    // Assert
    verify(category).getParentCategory();
    assertEquals(1, parentCrumbs.size());
    BreadcrumbDTO getResult = parentCrumbs.get(0);
    assertEquals("CATEGORY", getResult.getType());
    assertNull(getResult.getLink());
    assertNull(getResult.getText());
  }

  /**
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#addParentCrumbs(List, Category, String,
   * Map)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} second is {@link BreadcrumbDTO} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CategoryBreadcrumbServiceExtensionHandler#addParentCrumbs(List,
   * org.broadleafcommerce.core.catalog.domain.Category, String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryBreadcrumbServiceExtensionHandler.addParentCrumbs(List, org.broadleafcommerce.core.catalog.domain.Category, String, Map)"
  })
  public void testAddParentCrumbs_thenArrayListSecondIsBreadcrumbDTO() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler =
        new CategoryBreadcrumbServiceExtensionHandler();

    BreadcrumbDTO breadcrumbDTO = new BreadcrumbDTO();
    breadcrumbDTO.setLink("name");
    breadcrumbDTO.setText("name");
    breadcrumbDTO.setType(new BreadcrumbDTOType());

    ArrayList<BreadcrumbDTO> parentCrumbs = new ArrayList<>();
    parentCrumbs.add(breadcrumbDTO);

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getParentCategory()).thenReturn(new CategoryImpl());

    // Act
    categoryBreadcrumbServiceExtensionHandler.addParentCrumbs(
        parentCrumbs, category, "https://example.org/example", new HashMap<>());

    // Assert
    verify(category).getParentCategory();
    assertEquals(2, parentCrumbs.size());
    assertSame(breadcrumbDTO, parentCrumbs.get(1));
  }

  /**
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#addParentCrumbs(List, Category, String,
   * Map)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} second Type is {@code CATEGORY}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryBreadcrumbServiceExtensionHandler#addParentCrumbs(List,
   * org.broadleafcommerce.core.catalog.domain.Category, String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryBreadcrumbServiceExtensionHandler.addParentCrumbs(List, org.broadleafcommerce.core.catalog.domain.Category, String, Map)"
  })
  public void testAddParentCrumbs_thenArrayListSecondTypeIsCategory() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler =
        new CategoryBreadcrumbServiceExtensionHandler();
    ArrayList<BreadcrumbDTO> parentCrumbs = new ArrayList<>();

    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getName()).thenReturn("Name");
    when(categoryImpl.getUrl()).thenReturn("https://example.org/example");
    when(categoryImpl.getParentCategory()).thenReturn(new CategoryImpl());

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getParentCategory()).thenReturn(categoryImpl);

    // Act
    categoryBreadcrumbServiceExtensionHandler.addParentCrumbs(
        parentCrumbs, category, "https://example.org/example", new HashMap<>());

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
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#addParentCrumbs(List, Category, String,
   * Map)}.
   *
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link CategoryBreadcrumbServiceExtensionHandler#addParentCrumbs(List,
   * org.broadleafcommerce.core.catalog.domain.Category, String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryBreadcrumbServiceExtensionHandler.addParentCrumbs(List, org.broadleafcommerce.core.catalog.domain.Category, String, Map)"
  })
  public void testAddParentCrumbs_whenCategoryImpl_thenArrayListEmpty() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler =
        new CategoryBreadcrumbServiceExtensionHandler();
    ArrayList<BreadcrumbDTO> parentCrumbs = new ArrayList<>();
    CategoryImpl category = new CategoryImpl();

    // Act
    categoryBreadcrumbServiceExtensionHandler.addParentCrumbs(
        parentCrumbs, category, "https://example.org/example", new HashMap<>());

    // Assert that nothing has changed
    assertTrue(parentCrumbs.isEmpty());
  }

  /**
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#buildCategorySearchCrumb(Category,
   * String, Map)}.
   *
   * <p>Method under test: {@link
   * CategoryBreadcrumbServiceExtensionHandler#buildCategorySearchCrumb(org.broadleafcommerce.core.catalog.domain.Category,
   * String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BreadcrumbDTO CategoryBreadcrumbServiceExtensionHandler.buildCategorySearchCrumb(org.broadleafcommerce.core.catalog.domain.Category, String, Map)"
  })
  public void testBuildCategorySearchCrumb() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler =
        new CategoryBreadcrumbServiceExtensionHandler();
    CategoryImpl category = new CategoryImpl();

    // Act and Assert
    assertNull(
        categoryBreadcrumbServiceExtensionHandler.buildCategorySearchCrumb(
            category, "https://example.org/example", new HashMap<>()));
  }

  /**
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#getNameForCategoryLink(Category)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryBreadcrumbServiceExtensionHandler#getNameForCategoryLink(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String CategoryBreadcrumbServiceExtensionHandler.getNameForCategoryLink(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetNameForCategoryLink_givenName_thenReturnName() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler =
        new CategoryBreadcrumbServiceExtensionHandler();

    org.broadleafcommerce.core.catalog.domain.Category category =
        mock(org.broadleafcommerce.core.catalog.domain.Category.class);
    when(category.getName()).thenReturn("Name");

    // Act
    String actualNameForCategoryLink =
        categoryBreadcrumbServiceExtensionHandler.getNameForCategoryLink(category);

    // Assert
    verify(category).getName();
    assertEquals("Name", actualNameForCategoryLink);
  }

  /**
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#getNameForCategoryLink(Category)}.
   *
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryBreadcrumbServiceExtensionHandler#getNameForCategoryLink(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String CategoryBreadcrumbServiceExtensionHandler.getNameForCategoryLink(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetNameForCategoryLink_whenCategoryImpl_thenReturnNull() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler =
        new CategoryBreadcrumbServiceExtensionHandler();

    // Act and Assert
    assertNull(
        categoryBreadcrumbServiceExtensionHandler.getNameForCategoryLink(new CategoryImpl()));
  }

  /**
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#determineFirstCategory(String, Map,
   * ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link
   * CategoryBreadcrumbServiceExtensionHandler#determineFirstCategory(String, Map,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.catalog.domain.Category CategoryBreadcrumbServiceExtensionHandler.determineFirstCategory(String, Map, ExtensionResultHolder)"
  })
  public void testDetermineFirstCategory() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler =
        new CategoryBreadcrumbServiceExtensionHandler();
    HashMap<String, String[]> params = new HashMap<>();

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act and Assert
    assertNull(
        categoryBreadcrumbServiceExtensionHandler.determineFirstCategory(
            "https://example.org/example", params, holder));
  }

  /**
   * Test {@link
   * CategoryBreadcrumbServiceExtensionHandler#getCategoryFromCategoryAttribute(BroadleafRequestContext,
   * String, Map)}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).
   *   <li>Then return {@link CategoryImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryBreadcrumbServiceExtensionHandler#getCategoryFromCategoryAttribute(BroadleafRequestContext,
   * String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.catalog.domain.Category CategoryBreadcrumbServiceExtensionHandler.getCategoryFromCategoryAttribute(BroadleafRequestContext, String, Map)"
  })
  public void testGetCategoryFromCategoryAttribute_givenCategoryImpl_thenReturnCategoryImpl() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler =
        new CategoryBreadcrumbServiceExtensionHandler();

    BroadleafRequestContext brc = mock(BroadleafRequestContext.class);
    CategoryImpl categoryImpl = new CategoryImpl();
    when(brc.getRequestAttribute(Mockito.<String>any())).thenReturn(categoryImpl);

    // Act
    org.broadleafcommerce.core.catalog.domain.Category actualCategoryFromCategoryAttribute =
        categoryBreadcrumbServiceExtensionHandler.getCategoryFromCategoryAttribute(
            brc, "https://example.org/example", new HashMap<>());

    // Assert
    verify(brc).getRequestAttribute("category");
    assertSame(categoryImpl, actualCategoryFromCategoryAttribute);
  }

  /**
   * Test {@link
   * CategoryBreadcrumbServiceExtensionHandler#getCategoryFromCategoryAttribute(BroadleafRequestContext,
   * String, Map)}.
   *
   * <ul>
   *   <li>When {@link BroadleafRequestContext} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryBreadcrumbServiceExtensionHandler#getCategoryFromCategoryAttribute(BroadleafRequestContext,
   * String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.catalog.domain.Category CategoryBreadcrumbServiceExtensionHandler.getCategoryFromCategoryAttribute(BroadleafRequestContext, String, Map)"
  })
  public void testGetCategoryFromCategoryAttribute_whenBroadleafRequestContext_thenReturnNull() {
    // Arrange
    CategoryBreadcrumbServiceExtensionHandler categoryBreadcrumbServiceExtensionHandler =
        new CategoryBreadcrumbServiceExtensionHandler();
    BroadleafRequestContext brc = new BroadleafRequestContext();

    // Act and Assert
    assertNull(
        categoryBreadcrumbServiceExtensionHandler.getCategoryFromCategoryAttribute(
            brc, "https://example.org/example", new HashMap<>()));
  }

  /**
   * Test {@link
   * CategoryBreadcrumbServiceExtensionHandler#getCategoryFromUrl(BroadleafRequestContext, String,
   * Map)}.
   *
   * <p>Method under test: {@link
   * CategoryBreadcrumbServiceExtensionHandler#getCategoryFromUrl(BroadleafRequestContext, String,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.catalog.domain.Category CategoryBreadcrumbServiceExtensionHandler.getCategoryFromUrl(BroadleafRequestContext, String, Map)"
  })
  public void testGetCategoryFromUrl() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    when(catalogService.findCategoryByURI(Mockito.<String>any())).thenReturn(categoryImpl);
    BroadleafRequestContext brc = new BroadleafRequestContext();

    // Act
    org.broadleafcommerce.core.catalog.domain.Category actualCategoryFromUrl =
        categoryBreadcrumbServiceExtensionHandler.getCategoryFromUrl(
            brc, "https://example.org/example", new HashMap<>());

    // Assert
    verify(catalogService).findCategoryByURI("https://example.org/example");
    assertSame(categoryImpl, actualCategoryFromUrl);
  }

  /**
   * Test {@link CategoryBreadcrumbServiceExtensionHandler#getDefaultPriority()}.
   *
   * <p>Method under test: {@link CategoryBreadcrumbServiceExtensionHandler#getDefaultPriority()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int CategoryBreadcrumbServiceExtensionHandler.getDefaultPriority()"})
  public void testGetDefaultPriority() {
    // Arrange, Act and Assert
    assertEquals(2000, new CategoryBreadcrumbServiceExtensionHandler().getDefaultPriority());
  }
}

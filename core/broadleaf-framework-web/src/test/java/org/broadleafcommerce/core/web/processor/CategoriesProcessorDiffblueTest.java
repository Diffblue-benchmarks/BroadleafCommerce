package org.broadleafcommerce.core.web.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
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
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CategoriesProcessorDiffblueTest {
  @Mock private CatalogService catalogService;

  @InjectMocks private CategoriesProcessor categoriesProcessor;

  @Mock private CategoriesProcessorExtensionManager categoriesProcessorExtensionManager;

  /**
   * Test {@link CategoriesProcessor#getName()}.
   *
   * <p>Method under test: {@link CategoriesProcessor#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoriesProcessor.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("categories", new CategoriesProcessor().getName());
  }

  /**
   * Test {@link CategoriesProcessor#getPrecedence()}.
   *
   * <p>Method under test: {@link CategoriesProcessor#getPrecedence()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int CategoriesProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(10000, new CategoriesProcessor().getPrecedence());
  }

  /**
   * Test {@link CategoriesProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CategoryImpl} (default constructor).
   *   <li>Then {@code null} return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link CategoriesProcessor#populateModelVariables(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map CategoriesProcessor.populateModelVariables(String, Map, BroadleafTemplateContext)"
  })
  public void testPopulateModelVariables_givenArrayListAddCategoryImpl_thenNullReturnList() {
    // Arrange
    ArrayList<org.broadleafcommerce.core.catalog.domain.Category> categoryList = new ArrayList<>();
    categoryList.add(new CategoryImpl());
    when(catalogService.findCategoriesByName(Mockito.<String>any())).thenReturn(categoryList);

    CategoriesProcessorExtensionHandler categoriesProcessorExtensionHandler =
        mock(CategoriesProcessorExtensionHandler.class);
    when(categoriesProcessorExtensionHandler.findAllPossibleChildCategories(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito
                .<ExtensionResultHolder<List<org.broadleafcommerce.core.catalog.domain.Category>>>
                    any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_CONTINUE);
    when(categoriesProcessorExtensionManager.getProxy())
        .thenReturn(categoriesProcessorExtensionHandler);

    // Act
    Map<String, Object> actualPopulateModelVariablesResult =
        categoriesProcessor.populateModelVariables(
            "Tag Name", new HashMap<>(), mock(BroadleafTemplateContext.class));

    // Assert
    verify(categoriesProcessorExtensionManager).getProxy();
    verify(catalogService).findCategoriesByName(null);
    verify(categoriesProcessorExtensionHandler)
        .findAllPossibleChildCategories(isNull(), isNull(), isA(ExtensionResultHolder.class));
    assertEquals(1, actualPopulateModelVariablesResult.size());
    Object getResult = actualPopulateModelVariablesResult.get(null);
    assertTrue(getResult instanceof List);
    assertTrue(((List<Object>) getResult).isEmpty());
  }

  /**
   * Test {@link CategoriesProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CategoriesProcessor#populateModelVariables(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map CategoriesProcessor.populateModelVariables(String, Map, BroadleafTemplateContext)"
  })
  public void testPopulateModelVariables_thenReturnEmpty() {
    // Arrange
    when(catalogService.findCategoriesByName(Mockito.<String>any())).thenReturn(new ArrayList<>());

    CategoriesProcessorExtensionHandler categoriesProcessorExtensionHandler =
        mock(CategoriesProcessorExtensionHandler.class);
    when(categoriesProcessorExtensionHandler.findAllPossibleChildCategories(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito
                .<ExtensionResultHolder<List<org.broadleafcommerce.core.catalog.domain.Category>>>
                    any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_CONTINUE);
    when(categoriesProcessorExtensionManager.getProxy())
        .thenReturn(categoriesProcessorExtensionHandler);

    // Act
    Map<String, Object> actualPopulateModelVariablesResult =
        categoriesProcessor.populateModelVariables(
            "Tag Name", new HashMap<>(), mock(BroadleafTemplateContext.class));

    // Assert
    verify(categoriesProcessorExtensionManager).getProxy();
    verify(catalogService).findCategoriesByName(null);
    verify(categoriesProcessorExtensionHandler)
        .findAllPossibleChildCategories(isNull(), isNull(), isA(ExtensionResultHolder.class));
    assertTrue(actualPopulateModelVariablesResult.isEmpty());
  }

  /**
   * Test {@link CategoriesProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoriesProcessor#populateModelVariables(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map CategoriesProcessor.populateModelVariables(String, Map, BroadleafTemplateContext)"
  })
  public void testPopulateModelVariables_thenReturnNull() {
    // Arrange
    CategoriesProcessorExtensionHandler categoriesProcessorExtensionHandler =
        mock(CategoriesProcessorExtensionHandler.class);
    when(categoriesProcessorExtensionHandler.findAllPossibleChildCategories(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito
                .<ExtensionResultHolder<List<org.broadleafcommerce.core.catalog.domain.Category>>>
                    any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(categoriesProcessorExtensionManager.getProxy())
        .thenReturn(categoriesProcessorExtensionHandler);

    // Act
    Map<String, Object> actualPopulateModelVariablesResult =
        categoriesProcessor.populateModelVariables(
            "Tag Name", new HashMap<>(), mock(BroadleafTemplateContext.class));

    // Assert
    verify(categoriesProcessorExtensionManager).getProxy();
    verify(categoriesProcessorExtensionHandler)
        .findAllPossibleChildCategories(isNull(), isNull(), isA(ExtensionResultHolder.class));
    assertEquals(1, actualPopulateModelVariablesResult.size());
    assertNull(actualPopulateModelVariablesResult.get(null));
  }
}

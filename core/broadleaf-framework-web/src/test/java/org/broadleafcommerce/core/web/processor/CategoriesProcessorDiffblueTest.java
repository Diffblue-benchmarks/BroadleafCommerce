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
package org.broadleafcommerce.core.web.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CategoriesProcessorDiffblueTest {
  @Mock private CatalogService catalogService;

  @InjectMocks private CategoriesProcessor categoriesProcessor;

  @Mock private CategoriesProcessorExtensionManager categoriesProcessorExtensionManager;

  /**
   * Test {@link CategoriesProcessor#getName()}.
   *
   * <p>Method under test: {@link CategoriesProcessor#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoriesProcessor.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("categories", new CategoriesProcessor().getName());
  }

  /**
   * Test {@link CategoriesProcessor#getPrecedence()}.
   *
   * <p>Method under test: {@link CategoriesProcessor#getPrecedence()}
   */
  @Test
  @DisplayName("Test getPrecedence()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CategoriesProcessor.getPrecedence()"})
  void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(10000, categoriesProcessor.getPrecedence());
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
  @DisplayName(
      "Test populateModelVariables(String, Map, BroadleafTemplateContext); given ArrayList() add CategoryImpl (default constructor); then 'null' return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map CategoriesProcessor.populateModelVariables(String, Map, BroadleafTemplateContext)"
  })
  void testPopulateModelVariables_givenArrayListAddCategoryImpl_thenNullReturnList() {
    // Arrange
    ArrayList<Category> categoryList = new ArrayList<>();
    categoryList.add(new CategoryImpl());
    when(catalogService.findCategoriesByName(Mockito.<String>any())).thenReturn(categoryList);

    CategoriesProcessorExtensionHandler categoriesProcessorExtensionHandler =
        mock(CategoriesProcessorExtensionHandler.class);
    when(categoriesProcessorExtensionHandler.findAllPossibleChildCategories(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<ExtensionResultHolder<List<Category>>>any()))
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
  @DisplayName(
      "Test populateModelVariables(String, Map, BroadleafTemplateContext); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map CategoriesProcessor.populateModelVariables(String, Map, BroadleafTemplateContext)"
  })
  void testPopulateModelVariables_thenReturnEmpty() {
    // Arrange
    when(catalogService.findCategoriesByName(Mockito.<String>any())).thenReturn(new ArrayList<>());

    CategoriesProcessorExtensionHandler categoriesProcessorExtensionHandler =
        mock(CategoriesProcessorExtensionHandler.class);
    when(categoriesProcessorExtensionHandler.findAllPossibleChildCategories(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<ExtensionResultHolder<List<Category>>>any()))
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
  @DisplayName(
      "Test populateModelVariables(String, Map, BroadleafTemplateContext); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map CategoriesProcessor.populateModelVariables(String, Map, BroadleafTemplateContext)"
  })
  void testPopulateModelVariables_thenReturnNull() {
    // Arrange
    CategoriesProcessorExtensionHandler categoriesProcessorExtensionHandler =
        mock(CategoriesProcessorExtensionHandler.class);
    when(categoriesProcessorExtensionHandler.findAllPossibleChildCategories(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<ExtensionResultHolder<List<Category>>>any()))
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

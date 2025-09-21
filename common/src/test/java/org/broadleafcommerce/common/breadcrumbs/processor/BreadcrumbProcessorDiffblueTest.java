/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.breadcrumbs.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTO;
import org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType;
import org.broadleafcommerce.common.web.expression.BreadcrumbVariableExpression;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BreadcrumbProcessorDiffblueTest {
  @InjectMocks private BreadcrumbProcessor breadcrumbProcessor;

  @Mock private BreadcrumbVariableExpression breadcrumbVariableExpression;

  /**
   * Test {@link BreadcrumbProcessor#getName()}.
   *
   * <p>Method under test: {@link BreadcrumbProcessor#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BreadcrumbProcessor.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("breadcrumbs", new BreadcrumbProcessor().getName());
  }

  /**
   * Test {@link BreadcrumbProcessor#getPrecedence()}.
   *
   * <p>Method under test: {@link BreadcrumbProcessor#getPrecedence()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int BreadcrumbProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(10000, breadcrumbProcessor.getPrecedence());
  }

  /**
   * Test {@link BreadcrumbProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@link BreadcrumbDTO} (default constructor) Link is {@code resultVar}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link BreadcrumbProcessor#populateModelVariables(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map BreadcrumbProcessor.populateModelVariables(String, Map, BroadleafTemplateContext)"
  })
  public void testPopulateModelVariables_givenBreadcrumbDTOLinkIsResultVar_thenReturnSizeIsOne() {
    // Arrange
    BreadcrumbDTO breadcrumbDTO = new BreadcrumbDTO();
    breadcrumbDTO.setLink("resultVar");
    breadcrumbDTO.setText("resultVar");
    breadcrumbDTO.setType(BreadcrumbDTOType.CATEGORY);

    ArrayList<BreadcrumbDTO> breadcrumbDTOList = new ArrayList<>();
    breadcrumbDTOList.add(breadcrumbDTO);
    when(breadcrumbVariableExpression.getBreadcrumbs()).thenReturn(breadcrumbDTOList);

    // Act
    Map<String, Object> actualPopulateModelVariablesResult =
        breadcrumbProcessor.populateModelVariables(
            "Tag Name", new HashMap<>(), mock(BroadleafTemplateContext.class));

    // Assert
    verify(breadcrumbVariableExpression).getBreadcrumbs();
    assertEquals(1, actualPopulateModelVariablesResult.size());
    assertSame(breadcrumbDTOList, actualPopulateModelVariablesResult.get("breadcrumbs"));
  }

  /**
   * Test {@link BreadcrumbProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@code resultVar}.
   *   <li>When {@link HashMap#HashMap()} {@code resultVar} is {@code resultVar}.
   * </ul>
   *
   * <p>Method under test: {@link BreadcrumbProcessor#populateModelVariables(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map BreadcrumbProcessor.populateModelVariables(String, Map, BroadleafTemplateContext)"
  })
  public void testPopulateModelVariables_givenResultVar_whenHashMapResultVarIsResultVar() {
    // Arrange
    when(breadcrumbVariableExpression.getBreadcrumbs()).thenReturn(new ArrayList<>());

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("resultVar", "resultVar");

    // Act
    Map<String, Object> actualPopulateModelVariablesResult =
        breadcrumbProcessor.populateModelVariables(
            "Tag Name", tagAttributes, mock(BroadleafTemplateContext.class));

    // Assert
    verify(breadcrumbVariableExpression).getBreadcrumbs();
    assertNull(actualPopulateModelVariablesResult);
  }

  /**
   * Test {@link BreadcrumbProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BreadcrumbProcessor#populateModelVariables(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map BreadcrumbProcessor.populateModelVariables(String, Map, BroadleafTemplateContext)"
  })
  public void testPopulateModelVariables_whenHashMap_thenReturnNull() {
    // Arrange
    when(breadcrumbVariableExpression.getBreadcrumbs()).thenReturn(new ArrayList<>());

    // Act
    Map<String, Object> actualPopulateModelVariablesResult =
        breadcrumbProcessor.populateModelVariables(
            "Tag Name", new HashMap<>(), mock(BroadleafTemplateContext.class));

    // Assert
    verify(breadcrumbVariableExpression).getBreadcrumbs();
    assertNull(actualPopulateModelVariablesResult);
  }
}

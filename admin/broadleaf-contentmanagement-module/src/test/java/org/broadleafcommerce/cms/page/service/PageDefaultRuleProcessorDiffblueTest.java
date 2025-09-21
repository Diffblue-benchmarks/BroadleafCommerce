/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.page.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.page.dto.NullPageDTO;
import org.broadleafcommerce.common.page.dto.PageDTO;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {PageDefaultRuleProcessor.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PageDefaultRuleProcessorDiffblueTest {
  @Autowired private PageDefaultRuleProcessor pageDefaultRuleProcessor;

  /**
   * Test {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)} with {@code PageDTO}, {@code
   * Map}.
   *
   * <p>Method under test: {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageDefaultRuleProcessor.checkForMatch(PageDTO, Map)"})
  public void testCheckForMatchWithPageDTOMap() {
    // Arrange
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getRuleExpression()).thenReturn("getCategoryAttributesMap()[UU]");

    // Act
    boolean actualCheckForMatchResult =
        pageDefaultRuleProcessor.checkForMatch(page, new HashMap<>());

    // Assert
    verify(page).getRuleExpression();
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Test {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)} with {@code PageDTO}, {@code
   * Map}.
   *
   * <p>Method under test: {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageDefaultRuleProcessor.checkForMatch(PageDTO, Map)"})
  public void testCheckForMatchWithPageDTOMap2() {
    // Arrange
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getRuleExpression()).thenReturn("");

    // Act
    boolean actualCheckForMatchResult =
        pageDefaultRuleProcessor.checkForMatch(page, new HashMap<>());

    // Assert
    verify(page).getRuleExpression();
    assertTrue(actualCheckForMatchResult);
  }

  /**
   * Test {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)} with {@code PageDTO}, {@code
   * Map}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link NullPageDTO} {@link NullPageDTO#getRuleExpression()} return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageDefaultRuleProcessor.checkForMatch(PageDTO, Map)"})
  public void testCheckForMatchWithPageDTOMap_given42_whenNullPageDTOGetRuleExpressionReturn42() {
    // Arrange
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getRuleExpression()).thenReturn("42");

    // Act
    boolean actualCheckForMatchResult =
        pageDefaultRuleProcessor.checkForMatch(page, new HashMap<>());

    // Assert
    verify(page).getRuleExpression();
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Test {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)} with {@code PageDTO}, {@code
   * Map}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link HashMap#HashMap()} empty string is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageDefaultRuleProcessor.checkForMatch(PageDTO, Map)"})
  public void testCheckForMatchWithPageDTOMap_givenEmptyString_whenHashMapEmptyStringIs42() {
    // Arrange
    PageDefaultRuleProcessor pageDefaultRuleProcessor = new PageDefaultRuleProcessor();

    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getRuleExpression()).thenReturn("foo");

    HashMap<String, Object> vars = new HashMap<>();
    vars.put("", "42");

    // Act
    boolean actualCheckForMatchResult = pageDefaultRuleProcessor.checkForMatch(page, vars);

    // Assert
    verify(page).getRuleExpression();
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Test {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)} with {@code PageDTO}, {@code
   * Map}.
   *
   * <ul>
   *   <li>Given {@code getAdditionalAttributes()[UU]}.
   * </ul>
   *
   * <p>Method under test: {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageDefaultRuleProcessor.checkForMatch(PageDTO, Map)"})
  public void testCheckForMatchWithPageDTOMap_givenGetAdditionalAttributesUu() {
    // Arrange
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getRuleExpression()).thenReturn("getAdditionalAttributes()[UU]");

    // Act
    boolean actualCheckForMatchResult =
        pageDefaultRuleProcessor.checkForMatch(page, new HashMap<>());

    // Assert
    verify(page).getRuleExpression();
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Test {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)} with {@code PageDTO}, {@code
   * Map}.
   *
   * <ul>
   *   <li>Given {@code getAdditionalFields()[UU]}.
   * </ul>
   *
   * <p>Method under test: {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageDefaultRuleProcessor.checkForMatch(PageDTO, Map)"})
  public void testCheckForMatchWithPageDTOMap_givenGetAdditionalFieldsUu() {
    // Arrange
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getRuleExpression()).thenReturn("getAdditionalFields()[UU]");

    // Act
    boolean actualCheckForMatchResult =
        pageDefaultRuleProcessor.checkForMatch(page, new HashMap<>());

    // Assert
    verify(page).getRuleExpression();
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Test {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)} with {@code PageDTO}, {@code
   * Map}.
   *
   * <ul>
   *   <li>Given {@code getCustomerAttributes()[UU]}.
   * </ul>
   *
   * <p>Method under test: {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageDefaultRuleProcessor.checkForMatch(PageDTO, Map)"})
  public void testCheckForMatchWithPageDTOMap_givenGetCustomerAttributesUu() {
    // Arrange
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getRuleExpression()).thenReturn("getCustomerAttributes()[UU]");

    // Act
    boolean actualCheckForMatchResult =
        pageDefaultRuleProcessor.checkForMatch(page, new HashMap<>());

    // Assert
    verify(page).getRuleExpression();
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Test {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)} with {@code PageDTO}, {@code
   * Map}.
   *
   * <ul>
   *   <li>Given {@code getOrderItemAttributes()[UU]}.
   * </ul>
   *
   * <p>Method under test: {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageDefaultRuleProcessor.checkForMatch(PageDTO, Map)"})
  public void testCheckForMatchWithPageDTOMap_givenGetOrderItemAttributesUu() {
    // Arrange
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getRuleExpression()).thenReturn("getOrderItemAttributes()[UU]");

    // Act
    boolean actualCheckForMatchResult =
        pageDefaultRuleProcessor.checkForMatch(page, new HashMap<>());

    // Assert
    verify(page).getRuleExpression();
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Test {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)} with {@code PageDTO}, {@code
   * Map}.
   *
   * <ul>
   *   <li>Given {@code getProductAttributes()[UU]}.
   * </ul>
   *
   * <p>Method under test: {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageDefaultRuleProcessor.checkForMatch(PageDTO, Map)"})
  public void testCheckForMatchWithPageDTOMap_givenGetProductAttributesUu() {
    // Arrange
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getRuleExpression()).thenReturn("getProductAttributes()[UU]");

    // Act
    boolean actualCheckForMatchResult =
        pageDefaultRuleProcessor.checkForMatch(page, new HashMap<>());

    // Assert
    verify(page).getRuleExpression();
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Test {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)} with {@code PageDTO}, {@code
   * Map}.
   *
   * <ul>
   *   <li>Given {@code getSkuAttributes()[UU]}.
   * </ul>
   *
   * <p>Method under test: {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageDefaultRuleProcessor.checkForMatch(PageDTO, Map)"})
  public void testCheckForMatchWithPageDTOMap_givenGetSkuAttributesUu() {
    // Arrange
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getRuleExpression()).thenReturn("getSkuAttributes()[UU]");

    // Act
    boolean actualCheckForMatchResult =
        pageDefaultRuleProcessor.checkForMatch(page, new HashMap<>());

    // Assert
    verify(page).getRuleExpression();
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Test {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)} with {@code PageDTO}, {@code
   * Map}.
   *
   * <ul>
   *   <li>Given {@code MVEL}.
   * </ul>
   *
   * <p>Method under test: {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageDefaultRuleProcessor.checkForMatch(PageDTO, Map)"})
  public void testCheckForMatchWithPageDTOMap_givenMvel() {
    // Arrange
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getRuleExpression()).thenReturn("MVEL");

    // Act
    boolean actualCheckForMatchResult =
        pageDefaultRuleProcessor.checkForMatch(page, new HashMap<>());

    // Assert
    verify(page).getRuleExpression();
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Test {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)} with {@code PageDTO}, {@code
   * Map}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageDefaultRuleProcessor.checkForMatch(PageDTO, Map)"})
  public void testCheckForMatchWithPageDTOMap_givenNull_whenHashMapFooIsNull_thenReturnTrue() {
    // Arrange
    PageDefaultRuleProcessor pageDefaultRuleProcessor = new PageDefaultRuleProcessor();

    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getRuleExpression()).thenReturn("foo");

    HashMap<String, Object> vars = new HashMap<>();
    vars.put("foo", null);

    // Act
    boolean actualCheckForMatchResult = pageDefaultRuleProcessor.checkForMatch(page, vars);

    // Assert
    verify(page).getRuleExpression();
    assertTrue(actualCheckForMatchResult);
  }

  /**
   * Test {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)} with {@code PageDTO}, {@code
   * Map}.
   *
   * <ul>
   *   <li>Given {@code Page}.
   *   <li>When {@link PageDTO} (default constructor) RuleExpression is {@code Page}.
   * </ul>
   *
   * <p>Method under test: {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageDefaultRuleProcessor.checkForMatch(PageDTO, Map)"})
  public void testCheckForMatchWithPageDTOMap_givenPage_whenPageDTORuleExpressionIsPage() {
    // Arrange
    PageDTO page = new PageDTO();
    page.setRuleExpression("Page");

    // Act and Assert
    assertFalse(pageDefaultRuleProcessor.checkForMatch(page, new HashMap<>()));
  }

  /**
   * Test {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)} with {@code PageDTO}, {@code
   * Map}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageDefaultRuleProcessor.checkForMatch(PageDTO, Map)"})
  public void testCheckForMatchWithPageDTOMap_givenTrue_whenHashMapFooIsTrue_thenReturnTrue() {
    // Arrange
    PageDefaultRuleProcessor pageDefaultRuleProcessor = new PageDefaultRuleProcessor();

    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getRuleExpression()).thenReturn("foo");

    HashMap<String, Object> vars = new HashMap<>();
    vars.put("foo", true);

    // Act
    boolean actualCheckForMatchResult = pageDefaultRuleProcessor.checkForMatch(page, vars);

    // Assert
    verify(page).getRuleExpression();
    assertTrue(actualCheckForMatchResult);
  }

  /**
   * Test {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)} with {@code PageDTO}, {@code
   * Map}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code getCategoryAttributesMap()[UU]} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageDefaultRuleProcessor.checkForMatch(PageDTO, Map)"})
  public void testCheckForMatchWithPageDTOMap_whenHashMapGetCategoryAttributesMapUuIs42() {
    // Arrange
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getRuleExpression()).thenReturn("getProductAttributes()[UU]");

    HashMap<String, Object> vars = new HashMap<>();
    vars.put("getCategoryAttributesMap()[UU]", "42");

    // Act
    boolean actualCheckForMatchResult = pageDefaultRuleProcessor.checkForMatch(page, vars);

    // Assert
    verify(page).getRuleExpression();
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Test {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)} with {@code PageDTO}, {@code
   * Map}.
   *
   * <ul>
   *   <li>When {@link PageDTO} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageDefaultRuleProcessor.checkForMatch(PageDTO, Map)"})
  public void testCheckForMatchWithPageDTOMap_whenPageDTO_thenReturnTrue() {
    // Arrange
    PageDTO page = new PageDTO();

    // Act and Assert
    assertTrue(pageDefaultRuleProcessor.checkForMatch(page, new HashMap<>()));
  }

  /**
   * Test {@link PageDefaultRuleProcessor#getContextClassNames()}.
   *
   * <p>Method under test: {@link PageDefaultRuleProcessor#getContextClassNames()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PageDefaultRuleProcessor.getContextClassNames()"})
  public void testGetContextClassNames() {
    // Arrange and Act
    Map<String, String> actualContextClassNames = pageDefaultRuleProcessor.getContextClassNames();

    // Assert
    assertEquals(3, actualContextClassNames.size());
    assertEquals("org.broadleafcommerce.common.RequestDTO", actualContextClassNames.get("request"));
    assertEquals("org.broadleafcommerce.common.TimeDTO", actualContextClassNames.get("time"));
    assertEquals(
        "org.broadleafcommerce.profile.core.domain.Customer",
        actualContextClassNames.get("customer"));
  }
}

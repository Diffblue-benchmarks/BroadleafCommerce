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
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.page.dto.NullPageDTO;
import org.broadleafcommerce.common.page.dto.PageDTO;
import org.junit.Test;

public class PageDefaultRuleProcessorDiffblueTest {
  /**
   * Method under test:
   * {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  public void testCheckForMatch() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageDefaultRuleProcessor pageDefaultRuleProcessor = new PageDefaultRuleProcessor();
    PageDTO page = new PageDTO();

    // Act and Assert
    assertTrue(pageDefaultRuleProcessor.checkForMatch(page, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  public void testCheckForMatch2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageDefaultRuleProcessor pageDefaultRuleProcessor = new PageDefaultRuleProcessor();

    PageDTO page = new PageDTO();
    page.setRuleExpression("Page");

    // Act and Assert
    assertFalse(pageDefaultRuleProcessor.checkForMatch(page, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  public void testCheckForMatch3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageDefaultRuleProcessor pageDefaultRuleProcessor = new PageDefaultRuleProcessor();
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getRuleExpression()).thenReturn("getProductAttributes()[UU]");

    // Act
    boolean actualCheckForMatchResult = pageDefaultRuleProcessor.checkForMatch(page, new HashMap<>());

    // Assert
    verify(page).getRuleExpression();
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Method under test:
   * {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  public void testCheckForMatch4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageDefaultRuleProcessor pageDefaultRuleProcessor = new PageDefaultRuleProcessor();
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getRuleExpression()).thenReturn("getCategoryAttributesMap()[UU]");

    // Act
    boolean actualCheckForMatchResult = pageDefaultRuleProcessor.checkForMatch(page, new HashMap<>());

    // Assert
    verify(page).getRuleExpression();
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Method under test:
   * {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  public void testCheckForMatch5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageDefaultRuleProcessor pageDefaultRuleProcessor = new PageDefaultRuleProcessor();
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getRuleExpression()).thenReturn("getSkuAttributes()[UU]");

    // Act
    boolean actualCheckForMatchResult = pageDefaultRuleProcessor.checkForMatch(page, new HashMap<>());

    // Assert
    verify(page).getRuleExpression();
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Method under test:
   * {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  public void testCheckForMatch6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageDefaultRuleProcessor pageDefaultRuleProcessor = new PageDefaultRuleProcessor();
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getRuleExpression()).thenReturn("getOrderItemAttributes()[UU]");

    // Act
    boolean actualCheckForMatchResult = pageDefaultRuleProcessor.checkForMatch(page, new HashMap<>());

    // Assert
    verify(page).getRuleExpression();
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Method under test:
   * {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  public void testCheckForMatch7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageDefaultRuleProcessor pageDefaultRuleProcessor = new PageDefaultRuleProcessor();
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getRuleExpression()).thenReturn("getCustomerAttributes()[UU]");

    // Act
    boolean actualCheckForMatchResult = pageDefaultRuleProcessor.checkForMatch(page, new HashMap<>());

    // Assert
    verify(page).getRuleExpression();
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Method under test:
   * {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  public void testCheckForMatch8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageDefaultRuleProcessor pageDefaultRuleProcessor = new PageDefaultRuleProcessor();
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getRuleExpression()).thenReturn("getAdditionalAttributes()[UU]");

    // Act
    boolean actualCheckForMatchResult = pageDefaultRuleProcessor.checkForMatch(page, new HashMap<>());

    // Assert
    verify(page).getRuleExpression();
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Method under test:
   * {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  public void testCheckForMatch9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageDefaultRuleProcessor pageDefaultRuleProcessor = new PageDefaultRuleProcessor();
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getRuleExpression()).thenReturn("getAdditionalFields()[UU]");

    // Act
    boolean actualCheckForMatchResult = pageDefaultRuleProcessor.checkForMatch(page, new HashMap<>());

    // Assert
    verify(page).getRuleExpression();
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Method under test:
   * {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  public void testCheckForMatch10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageDefaultRuleProcessor pageDefaultRuleProcessor = new PageDefaultRuleProcessor();
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getRuleExpression()).thenReturn("42");

    // Act
    boolean actualCheckForMatchResult = pageDefaultRuleProcessor.checkForMatch(page, new HashMap<>());

    // Assert
    verify(page).getRuleExpression();
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Method under test:
   * {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  public void testCheckForMatch11() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageDefaultRuleProcessor pageDefaultRuleProcessor = new PageDefaultRuleProcessor();
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getRuleExpression()).thenReturn("");

    // Act
    boolean actualCheckForMatchResult = pageDefaultRuleProcessor.checkForMatch(page, new HashMap<>());

    // Assert
    verify(page).getRuleExpression();
    assertTrue(actualCheckForMatchResult);
  }

  /**
   * Method under test:
   * {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  public void testCheckForMatch12() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageDefaultRuleProcessor pageDefaultRuleProcessor = new PageDefaultRuleProcessor();
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getRuleExpression()).thenReturn("MVEL");

    // Act
    boolean actualCheckForMatchResult = pageDefaultRuleProcessor.checkForMatch(page, new HashMap<>());

    // Assert
    verify(page).getRuleExpression();
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Method under test:
   * {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  public void testCheckForMatch13() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageDefaultRuleProcessor pageDefaultRuleProcessor = new PageDefaultRuleProcessor();
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
   * Method under test:
   * {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  public void testCheckForMatch14() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageDefaultRuleProcessor pageDefaultRuleProcessor = new PageDefaultRuleProcessor();
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getRuleExpression()).thenReturn("foo");

    HashMap<String, Object> vars = new HashMap<>();
    vars.put("foo", "42");

    // Act
    boolean actualCheckForMatchResult = pageDefaultRuleProcessor.checkForMatch(page, vars);

    // Assert
    verify(page).getRuleExpression();
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Method under test:
   * {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  public void testCheckForMatch15() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageDefaultRuleProcessor pageDefaultRuleProcessor = new PageDefaultRuleProcessor();
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getRuleExpression()).thenReturn("foo");

    HashMap<String, Object> vars = new HashMap<>();
    vars.putAll(new HashMap<>());

    // Act
    boolean actualCheckForMatchResult = pageDefaultRuleProcessor.checkForMatch(page, vars);

    // Assert
    verify(page).getRuleExpression();
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Method under test: {@link PageDefaultRuleProcessor#getContextClassNames()}
   */
  @Test
  public void testGetContextClassNames() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Map<String, String> actualContextClassNames = (new PageDefaultRuleProcessor()).getContextClassNames();

    // Assert
    assertEquals(3, actualContextClassNames.size());
    assertEquals("org.broadleafcommerce.common.RequestDTO", actualContextClassNames.get("request"));
    assertEquals("org.broadleafcommerce.common.TimeDTO", actualContextClassNames.get("time"));
    assertEquals("org.broadleafcommerce.profile.core.domain.Customer", actualContextClassNames.get("customer"));
  }

  /**
   * Method under test: {@link PageDefaultRuleProcessor#getContextClassNames()}
   */
  @Test
  public void testGetContextClassNames2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, String> contextClassNames = new HashMap<>();
    contextClassNames.computeIfPresent("foo", mock(BiFunction.class));

    PageDefaultRuleProcessor pageDefaultRuleProcessor = new PageDefaultRuleProcessor();
    pageDefaultRuleProcessor.setContextClassNames(contextClassNames);

    // Act
    Map<String, String> actualContextClassNames = pageDefaultRuleProcessor.getContextClassNames();

    // Assert
    assertEquals(3, actualContextClassNames.size());
    assertEquals("org.broadleafcommerce.common.RequestDTO", actualContextClassNames.get("request"));
    assertEquals("org.broadleafcommerce.common.TimeDTO", actualContextClassNames.get("time"));
    assertEquals("org.broadleafcommerce.profile.core.domain.Customer", actualContextClassNames.get("customer"));
  }
}

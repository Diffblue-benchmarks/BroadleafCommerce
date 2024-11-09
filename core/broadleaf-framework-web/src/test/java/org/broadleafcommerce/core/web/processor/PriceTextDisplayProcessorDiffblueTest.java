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
package org.broadleafcommerce.core.web.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PriceTextDisplayProcessorDiffblueTest {
  /**
   * Test {@link PriceTextDisplayProcessor#getName()}.
   * <p>
   * Method under test: {@link PriceTextDisplayProcessor#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("price", (new PriceTextDisplayProcessor()).getName());
  }

  /**
   * Test {@link PriceTextDisplayProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link PriceTextDisplayProcessor#getPrecedence()}
   */
  @Test
  @DisplayName("Test getPrecedence()")
  void testGetPrecedence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(1500, (new PriceTextDisplayProcessor()).getPrecedence());
  }

  /**
   * Test
   * {@link PriceTextDisplayProcessor#getTagText(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then return {@code £65.00}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PriceTextDisplayProcessor#getTagText(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test getTagText(String, Map, String, String, BroadleafTemplateContext); given 'A'; then return '£65.00'")
  void testGetTagText_givenA_thenReturn6500() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PriceTextDisplayProcessor priceTextDisplayProcessor = new PriceTextDisplayProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn((byte) 'A');

    // Act
    String actualTagText = priceTextDisplayProcessor.getTagText("Tag Name", tagAttributes, "Attribute Name", "42",
        context);

    // Assert
    verify(context).parseExpression(eq("42"));
    assertEquals("£65.00", actualTagText);
  }

  /**
   * Test
   * {@link PriceTextDisplayProcessor#getTagText(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@link Money#Money()}.</li>
   *   <li>Then return {@code £0.00}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PriceTextDisplayProcessor#getTagText(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test getTagText(String, Map, String, String, BroadleafTemplateContext); given Money(); then return '£0.00'")
  void testGetTagText_givenMoney_thenReturn000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PriceTextDisplayProcessor priceTextDisplayProcessor = new PriceTextDisplayProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(new Money());

    // Act
    String actualTagText = priceTextDisplayProcessor.getTagText("Tag Name", tagAttributes, "Attribute Name", "42",
        context);

    // Assert
    verify(context).parseExpression(eq("42"));
    assertEquals("£0.00", actualTagText);
  }

  /**
   * Test
   * {@link PriceTextDisplayProcessor#getTagText(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return {@code £1.00}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PriceTextDisplayProcessor#getTagText(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test getTagText(String, Map, String, String, BroadleafTemplateContext); given one; then return '£1.00'")
  void testGetTagText_givenOne_thenReturn100() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PriceTextDisplayProcessor priceTextDisplayProcessor = new PriceTextDisplayProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(1);

    // Act
    String actualTagText = priceTextDisplayProcessor.getTagText("Tag Name", tagAttributes, "Attribute Name", "42",
        context);

    // Assert
    verify(context).parseExpression(eq("42"));
    assertEquals("£1.00", actualTagText);
  }

  /**
   * Test
   * {@link PriceTextDisplayProcessor#getTagText(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@code Parse Expression}.</li>
   *   <li>Then return {@code Not Available}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PriceTextDisplayProcessor#getTagText(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test getTagText(String, Map, String, String, BroadleafTemplateContext); given 'Parse Expression'; then return 'Not Available'")
  void testGetTagText_givenParseExpression_thenReturnNotAvailable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PriceTextDisplayProcessor priceTextDisplayProcessor = new PriceTextDisplayProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn("Parse Expression");

    // Act
    String actualTagText = priceTextDisplayProcessor.getTagText("Tag Name", tagAttributes, "Attribute Name", "42",
        context);

    // Assert
    verify(context).parseExpression(eq("42"));
    assertEquals("Not Available", actualTagText);
  }
}

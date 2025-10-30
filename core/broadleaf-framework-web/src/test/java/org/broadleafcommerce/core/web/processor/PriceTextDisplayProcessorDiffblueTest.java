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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PriceTextDisplayProcessorDiffblueTest {
  @InjectMocks
  private PriceTextDisplayProcessor priceTextDisplayProcessor;

  /**
   * Test {@link PriceTextDisplayProcessor#getName()}.
   * <p>
   * Method under test: {@link PriceTextDisplayProcessor#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PriceTextDisplayProcessor.getName()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PriceTextDisplayProcessor.getPrecedence()"})
  void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(1500, priceTextDisplayProcessor.getPrecedence());
  }

  /**
   * Test {@link PriceTextDisplayProcessor#getTagText(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then return {@code $65.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PriceTextDisplayProcessor#getTagText(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test getTagText(String, Map, String, String, BroadleafTemplateContext); given 'A'; then return '$65.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String PriceTextDisplayProcessor.getTagText(String, Map, String, String, BroadleafTemplateContext)"})
  void testGetTagText_givenA_thenReturn6500() {
    // Arrange
    HashMap<String, String> tagAttributes = new HashMap<>();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn((byte) 'A');

    // Act
    String actualTagText = priceTextDisplayProcessor.getTagText("Tag Name", tagAttributes, "Attribute Name", "42",
        context);

    // Assert
    verify(context).parseExpression(eq("42"));
    assertEquals("$65.00", actualTagText);
  }

  /**
   * Test {@link PriceTextDisplayProcessor#getTagText(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@link Money#Money()}.</li>
   *   <li>Then return {@code $0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PriceTextDisplayProcessor#getTagText(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test getTagText(String, Map, String, String, BroadleafTemplateContext); given Money(); then return '$0.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String PriceTextDisplayProcessor.getTagText(String, Map, String, String, BroadleafTemplateContext)"})
  void testGetTagText_givenMoney_thenReturn000() {
    // Arrange
    HashMap<String, String> tagAttributes = new HashMap<>();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(new Money());

    // Act
    String actualTagText = priceTextDisplayProcessor.getTagText("Tag Name", tagAttributes, "Attribute Name", "42",
        context);

    // Assert
    verify(context).parseExpression(eq("42"));
    assertEquals("$0.00", actualTagText);
  }

  /**
   * Test {@link PriceTextDisplayProcessor#getTagText(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@code Parse Expression}.</li>
   *   <li>Then return {@code Not Available}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PriceTextDisplayProcessor#getTagText(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test getTagText(String, Map, String, String, BroadleafTemplateContext); given 'Parse Expression'; then return 'Not Available'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String PriceTextDisplayProcessor.getTagText(String, Map, String, String, BroadleafTemplateContext)"})
  void testGetTagText_givenParseExpression_thenReturnNotAvailable() {
    // Arrange
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

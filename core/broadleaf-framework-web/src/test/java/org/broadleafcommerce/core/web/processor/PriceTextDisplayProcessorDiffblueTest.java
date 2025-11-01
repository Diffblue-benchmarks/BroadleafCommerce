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
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PriceTextDisplayProcessorDiffblueTest {
  /**
   * Method under test: {@link PriceTextDisplayProcessor#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("price", (new PriceTextDisplayProcessor()).getName());
  }

  /**
   * Method under test: {@link PriceTextDisplayProcessor#getPrecedence()}
   */
  @Test
  void testGetPrecedence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(1500, (new PriceTextDisplayProcessor()).getPrecedence());
  }

  /**
   * Method under test:
   * {@link PriceTextDisplayProcessor#getTagText(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  void testGetTagText() {
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

  /**
   * Method under test:
   * {@link PriceTextDisplayProcessor#getTagText(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  void testGetTagText2() {
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
    assertEquals("$65.00", actualTagText);
  }

  /**
   * Method under test:
   * {@link PriceTextDisplayProcessor#getTagText(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  void testGetTagText3() {
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
    assertEquals("$1.00", actualTagText);
  }

  /**
   * Method under test:
   * {@link PriceTextDisplayProcessor#getTagText(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  void testGetTagText4() {
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
    assertEquals("$0.00", actualTagText);
  }
}

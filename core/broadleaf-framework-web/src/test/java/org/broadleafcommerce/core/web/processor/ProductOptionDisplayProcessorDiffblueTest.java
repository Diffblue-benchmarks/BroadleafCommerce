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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ProductOptionDisplayProcessorDiffblueTest {
  /**
   * Method under test: {@link ProductOptionDisplayProcessor#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("product_option_display", (new ProductOptionDisplayProcessor()).getName());
  }

  /**
   * Method under test: {@link ProductOptionDisplayProcessor#getPrecedence()}
   */
  @Test
  void testGetPrecedence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(100, (new ProductOptionDisplayProcessor()).getPrecedence());
  }

  /**
   * Method under test: {@link ProductOptionDisplayProcessor#useGlobalScope()}
   */
  @Test
  void testUseGlobalScope() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ProductOptionDisplayProcessor()).useGlobalScope());
  }

  /**
   * Method under test:
   * {@link ProductOptionDisplayProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}
   */
  @Test
  void testPopulateModelVariables() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionDisplayProcessor productOptionDisplayProcessor = new ProductOptionDisplayProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn("Parse Expression");

    // Act
    Map<String, Object> actualPopulateModelVariablesResult = productOptionDisplayProcessor
        .populateModelVariables("Tag Name", tagAttributes, context);

    // Assert
    verify(context).parseExpression(isNull());
    assertEquals(1, actualPopulateModelVariablesResult.size());
    Object getResult = actualPopulateModelVariablesResult.get("productOptionDisplayValues");
    assertTrue(getResult instanceof Map);
    assertTrue(((Map<Object, Object>) getResult).isEmpty());
  }

  /**
   * Method under test:
   * {@link ProductOptionDisplayProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}
   */
  @Test
  void testPopulateModelVariables2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionDisplayProcessor productOptionDisplayProcessor = new ProductOptionDisplayProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getOrderItemAttributes()).thenReturn(new HashMap<>());
    when(discreteOrderItemImpl.getProduct()).thenReturn(new ProductBundleImpl());
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(discreteOrderItemImpl);

    // Act
    Map<String, Object> actualPopulateModelVariablesResult = productOptionDisplayProcessor
        .populateModelVariables("Tag Name", tagAttributes, context);

    // Assert
    verify(discreteOrderItemImpl).getProduct();
    verify(discreteOrderItemImpl).getOrderItemAttributes();
    verify(context).parseExpression(isNull());
    assertEquals(1, actualPopulateModelVariablesResult.size());
    Object getResult = actualPopulateModelVariablesResult.get("productOptionDisplayValues");
    assertTrue(getResult instanceof Map);
    assertTrue(((Map<Object, Object>) getResult).isEmpty());
  }
}

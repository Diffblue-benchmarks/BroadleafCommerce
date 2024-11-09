/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.web.payment.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.Test;

public class CreditCardTypesProcessorDiffblueTest {
  /**
   * Test {@link CreditCardTypesProcessor#getName()}.
   * <p>
   * Method under test: {@link CreditCardTypesProcessor#getName()}
   */
  @Test
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("credit_card_types", (new CreditCardTypesProcessor()).getName());
  }

  /**
   * Test {@link CreditCardTypesProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link CreditCardTypesProcessor#getPrecedence()}
   */
  @Test
  public void testGetPrecedence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(100, (new CreditCardTypesProcessor()).getPrecedence());
  }

  /**
   * Test {@link CreditCardTypesProcessor#useGlobalScope()}.
   * <p>
   * Method under test: {@link CreditCardTypesProcessor#useGlobalScope()}
   */
  @Test
  public void testUseGlobalScope() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new CreditCardTypesProcessor()).useGlobalScope());
  }

  /**
   * Test
   * {@link CreditCardTypesProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}.
   * <p>
   * Method under test:
   * {@link CreditCardTypesProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testPopulateModelVariables() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CreditCardTypesProcessor creditCardTypesProcessor = new CreditCardTypesProcessor();

    // Act and Assert
    assertNull(creditCardTypesProcessor.populateModelVariables("Tag Name", new HashMap<>(),
        mock(BroadleafTemplateContext.class)));
  }
}

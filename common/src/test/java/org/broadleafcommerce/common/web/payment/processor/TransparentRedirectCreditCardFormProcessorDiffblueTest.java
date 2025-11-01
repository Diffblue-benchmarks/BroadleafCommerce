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
package org.broadleafcommerce.common.web.payment.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.Test;

public class TransparentRedirectCreditCardFormProcessorDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TransparentRedirectCreditCardFormProcessor#setExtensionManager(TRCreditCardExtensionManager)}
   *   <li>{@link TransparentRedirectCreditCardFormProcessor#getExtensionManager()}
   *   <li>{@link TransparentRedirectCreditCardFormProcessor#getName()}
   *   <li>{@link TransparentRedirectCreditCardFormProcessor#getPrecedence()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    TransparentRedirectCreditCardFormProcessor transparentRedirectCreditCardFormProcessor = new TransparentRedirectCreditCardFormProcessor();
    TRCreditCardExtensionManager extensionManager = new TRCreditCardExtensionManager();

    // Act
    transparentRedirectCreditCardFormProcessor.setExtensionManager(extensionManager);
    TRCreditCardExtensionManager actualExtensionManager = transparentRedirectCreditCardFormProcessor
        .getExtensionManager();
    String actualName = transparentRedirectCreditCardFormProcessor.getName();

    // Assert that nothing has changed
    assertEquals("transparent_credit_card_form", actualName);
    assertEquals(1, transparentRedirectCreditCardFormProcessor.getPrecedence());
    assertSame(extensionManager, actualExtensionManager);
  }

  /**
   * Method under test:
   * {@link TransparentRedirectCreditCardFormProcessor#reprocessModel()}
   */
  @Test
  public void testReprocessModel() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new TransparentRedirectCreditCardFormProcessor()).reprocessModel());
  }

  /**
   * Method under test:
   * {@link TransparentRedirectCreditCardFormProcessor#reprocessModel()}
   */
  @Test
  public void testReprocessModel2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransparentRedirectCreditCardFormProcessor transparentRedirectCreditCardFormProcessor = new TransparentRedirectCreditCardFormProcessor();
    transparentRedirectCreditCardFormProcessor.setExtensionManager(mock(TRCreditCardExtensionManager.class));

    // Act and Assert
    assertTrue(transparentRedirectCreditCardFormProcessor.reprocessModel());
  }
}

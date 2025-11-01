/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.web.controller.extension;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.function.Function;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

public class AdminOfferControllerExtensionHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link AdminOfferControllerExtensionHandler#setAdditionalModelAttributes(Model, String)}
   */
  @Test
  public void testSetAdditionalModelAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminOfferControllerExtensionHandler adminOfferControllerExtensionHandler = new AdminOfferControllerExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE,
        adminOfferControllerExtensionHandler.setAdditionalModelAttributes(new ConcurrentModel(), "Section Key"));
  }

  /**
   * Method under test:
   * {@link AdminOfferControllerExtensionHandler#setAdditionalModelAttributes(Model, String)}
   */
  @Test
  public void testSetAdditionalModelAttributes2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminOfferControllerExtensionHandler adminOfferControllerExtensionHandler = new AdminOfferControllerExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE,
        adminOfferControllerExtensionHandler.setAdditionalModelAttributes(new ConcurrentModel(), "offer"));
  }

  /**
   * Method under test:
   * {@link AdminOfferControllerExtensionHandler#setAdditionalModelAttributes(Model, String)}
   */
  @Test
  public void testSetAdditionalModelAttributes3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminOfferControllerExtensionHandler adminOfferControllerExtensionHandler = new AdminOfferControllerExtensionHandler();
    Function<String, Object> function = mock(Function.class);
    when(function.apply(Mockito.<String>any())).thenReturn("Apply");

    ConcurrentModel model = new ConcurrentModel();
    model.computeIfAbsent("offer", function);

    // Act
    ExtensionResultStatusType actualSetAdditionalModelAttributesResult = adminOfferControllerExtensionHandler
        .setAdditionalModelAttributes(model, "Section Key");

    // Assert
    verify(function).apply(eq("offer"));
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE, actualSetAdditionalModelAttributesResult);
  }
}

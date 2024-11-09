/*-
 * #%L
 * BroadleafCommerce Admin Module
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
   * Test
   * {@link AdminOfferControllerExtensionHandler#setAdditionalModelAttributes(Model, String)}.
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} return
   * {@code Apply}.</li>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminOfferControllerExtensionHandler#setAdditionalModelAttributes(Model, String)}
   */
  @Test
  public void testSetAdditionalModelAttributes_givenFunctionApplyReturnApply_thenCallsApply() {
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

  /**
   * Test
   * {@link AdminOfferControllerExtensionHandler#setAdditionalModelAttributes(Model, String)}.
   * <ul>
   *   <li>When {@link ConcurrentModel#ConcurrentModel()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminOfferControllerExtensionHandler#setAdditionalModelAttributes(Model, String)}
   */
  @Test
  public void testSetAdditionalModelAttributes_whenConcurrentModel() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminOfferControllerExtensionHandler adminOfferControllerExtensionHandler = new AdminOfferControllerExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE,
        adminOfferControllerExtensionHandler.setAdditionalModelAttributes(new ConcurrentModel(), "Section Key"));
  }

  /**
   * Test
   * {@link AdminOfferControllerExtensionHandler#setAdditionalModelAttributes(Model, String)}.
   * <ul>
   *   <li>When {@code offer}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminOfferControllerExtensionHandler#setAdditionalModelAttributes(Model, String)}
   */
  @Test
  public void testSetAdditionalModelAttributes_whenOffer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminOfferControllerExtensionHandler adminOfferControllerExtensionHandler = new AdminOfferControllerExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE,
        adminOfferControllerExtensionHandler.setAdditionalModelAttributes(new ConcurrentModel(), "offer"));
  }
}

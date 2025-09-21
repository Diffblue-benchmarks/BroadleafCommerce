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
package org.broadleafcommerce.core.web.controller.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

class BroadleafOrderConfirmationControllerDiffblueTest {
  /**
   * Test {@link BroadleafOrderConfirmationController#displayOrderConfirmationByOrderNumber(String,
   * Model, HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link
   * BroadleafOrderConfirmationController#displayOrderConfirmationByOrderNumber(String, Model,
   * HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName(
      "Test displayOrderConfirmationByOrderNumber(String, Model, HttpServletRequest, HttpServletResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafOrderConfirmationController.displayOrderConfirmationByOrderNumber(String, Model, HttpServletRequest, HttpServletResponse)"
  })
  void testDisplayOrderConfirmationByOrderNumber() {
    // Arrange
    BroadleafOrderConfirmationController broadleafOrderConfirmationController =
        new BroadleafOrderConfirmationController();
    ConcurrentModel model = new ConcurrentModel();
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertEquals(
        "redirect:/",
        broadleafOrderConfirmationController.displayOrderConfirmationByOrderNumber(
            "42", model, request, new MockHttpServletResponse()));
  }

  /**
   * Test {@link BroadleafOrderConfirmationController#displayOrderConfirmationByOrderId(Long, Model,
   * HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link
   * BroadleafOrderConfirmationController#displayOrderConfirmationByOrderId(Long, Model,
   * HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName(
      "Test displayOrderConfirmationByOrderId(Long, Model, HttpServletRequest, HttpServletResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafOrderConfirmationController.displayOrderConfirmationByOrderId(Long, Model, HttpServletRequest, HttpServletResponse)"
  })
  void testDisplayOrderConfirmationByOrderId() {
    // Arrange
    BroadleafOrderConfirmationController broadleafOrderConfirmationController =
        new BroadleafOrderConfirmationController();
    ConcurrentModel model = new ConcurrentModel();
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertEquals(
        "redirect:/",
        broadleafOrderConfirmationController.displayOrderConfirmationByOrderId(
            1L, model, request, new MockHttpServletResponse()));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BroadleafOrderConfirmationController}
   *   <li>{@link BroadleafOrderConfirmationController#getOrderConfirmationView()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafOrderConfirmationController.<init>()",
    "String BroadleafOrderConfirmationController.getOrderConfirmationView()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        "checkout/confirmation",
        new BroadleafOrderConfirmationController().getOrderConfirmationView());
  }
}

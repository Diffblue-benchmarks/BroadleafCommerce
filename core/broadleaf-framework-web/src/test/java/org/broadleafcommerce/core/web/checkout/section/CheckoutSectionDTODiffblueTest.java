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
package org.broadleafcommerce.core.web.checkout.section;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CheckoutSectionDTODiffblueTest {
  /**
   * Test {@link CheckoutSectionDTO#CheckoutSectionDTO(CheckoutSectionViewType, boolean)}.
   * <p>
   * Method under test: {@link CheckoutSectionDTO#CheckoutSectionDTO(CheckoutSectionViewType, boolean)}
   */
  @Test
  @DisplayName("Test new CheckoutSectionDTO(CheckoutSectionViewType, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CheckoutSectionDTO.<init>(CheckoutSectionViewType, boolean)"})
  void testNewCheckoutSectionDTO() {
    // Arrange
    CheckoutSectionViewType view = CheckoutSectionViewType.BILLING_INFO;

    // Act
    CheckoutSectionDTO actualCheckoutSectionDTO = new CheckoutSectionDTO(view, true);

    // Assert
    CheckoutSectionStateType state = actualCheckoutSectionDTO.getState();
    assertEquals("INACTIVE", state.getType());
    assertEquals("Show Inactive State", state.getFriendlyType());
    assertNull(actualCheckoutSectionDTO.getHelpMessage());
    assertTrue(actualCheckoutSectionDTO.isPopulated());
    CheckoutSectionViewType expectedView = view.BILLING_INFO;
    assertSame(expectedView, actualCheckoutSectionDTO.getView());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CheckoutSectionDTO#setHelpMessage(String)}
   *   <li>{@link CheckoutSectionDTO#setPopulated(boolean)}
   *   <li>{@link CheckoutSectionDTO#setState(CheckoutSectionStateType)}
   *   <li>{@link CheckoutSectionDTO#setView(CheckoutSectionViewType)}
   *   <li>{@link CheckoutSectionDTO#getHelpMessage()}
   *   <li>{@link CheckoutSectionDTO#getState()}
   *   <li>{@link CheckoutSectionDTO#getView()}
   *   <li>{@link CheckoutSectionDTO#isPopulated()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CheckoutSectionDTO.getHelpMessage()",
      "CheckoutSectionStateType CheckoutSectionDTO.getState()", "CheckoutSectionViewType CheckoutSectionDTO.getView()",
      "boolean CheckoutSectionDTO.isPopulated()", "void CheckoutSectionDTO.setHelpMessage(String)",
      "void CheckoutSectionDTO.setPopulated(boolean)", "void CheckoutSectionDTO.setState(CheckoutSectionStateType)",
      "void CheckoutSectionDTO.setView(CheckoutSectionViewType)"})
  void testGettersAndSetters() {
    // Arrange
    CheckoutSectionDTO checkoutSectionDTO = new CheckoutSectionDTO(CheckoutSectionViewType.BILLING_INFO, true);

    // Act
    checkoutSectionDTO.setHelpMessage("Help Message");
    checkoutSectionDTO.setPopulated(true);
    checkoutSectionDTO.setState(CheckoutSectionStateType.FORM);
    checkoutSectionDTO.setView(CheckoutSectionViewType.BILLING_INFO);
    String actualHelpMessage = checkoutSectionDTO.getHelpMessage();
    CheckoutSectionStateType actualState = checkoutSectionDTO.getState();
    CheckoutSectionViewType actualView = checkoutSectionDTO.getView();

    // Assert
    assertEquals("Help Message", actualHelpMessage);
    assertTrue(checkoutSectionDTO.isPopulated());
    assertSame(actualState.FORM, actualState);
    assertSame(actualView.BILLING_INFO, actualView);
  }
}

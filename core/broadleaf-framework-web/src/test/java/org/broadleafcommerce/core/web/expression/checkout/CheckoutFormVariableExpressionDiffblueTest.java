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
package org.broadleafcommerce.core.web.expression.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.service.FulfillmentGroupService;
import org.broadleafcommerce.core.web.order.service.CartStateService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CheckoutFormVariableExpressionDiffblueTest {
  @Mock private CartStateService cartStateService;

  @InjectMocks private CheckoutFormVariableExpression checkoutFormVariableExpression;

  @Mock private FulfillmentGroupService fulfillmentGroupService;

  /**
   * Test {@link CheckoutFormVariableExpression#getName()}.
   *
   * <p>Method under test: {@link CheckoutFormVariableExpression#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String CheckoutFormVariableExpression.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("checkoutForm", new CheckoutFormVariableExpression().getName());
  }

  /**
   * Test {@link CheckoutFormVariableExpression#shouldShowShippingInfoStage()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutFormVariableExpression#shouldShowShippingInfoStage()}
   */
  @Test
  @DisplayName("Test shouldShowShippingInfoStage(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CheckoutFormVariableExpression.shouldShowShippingInfoStage()"})
  void testShouldShowShippingInfoStage_thenReturnFalse() {
    // Arrange
    when(fulfillmentGroupService.calculateNumShippableFulfillmentGroups(Mockito.<Order>any()))
        .thenReturn(0);

    // Act
    boolean actualShouldShowShippingInfoStageResult =
        checkoutFormVariableExpression.shouldShowShippingInfoStage();

    // Assert
    verify(fulfillmentGroupService).calculateNumShippableFulfillmentGroups(isNull());
    assertFalse(actualShouldShowShippingInfoStageResult);
  }

  /**
   * Test {@link CheckoutFormVariableExpression#shouldShowShippingInfoStage()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutFormVariableExpression#shouldShowShippingInfoStage()}
   */
  @Test
  @DisplayName("Test shouldShowShippingInfoStage(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CheckoutFormVariableExpression.shouldShowShippingInfoStage()"})
  void testShouldShowShippingInfoStage_thenReturnTrue() {
    // Arrange
    when(fulfillmentGroupService.calculateNumShippableFulfillmentGroups(Mockito.<Order>any()))
        .thenReturn(10);

    // Act
    boolean actualShouldShowShippingInfoStageResult =
        checkoutFormVariableExpression.shouldShowShippingInfoStage();

    // Assert
    verify(fulfillmentGroupService).calculateNumShippableFulfillmentGroups(isNull());
    assertTrue(actualShouldShowShippingInfoStageResult);
  }

  /**
   * Test {@link CheckoutFormVariableExpression#shouldShowBillingInfoStage()}.
   *
   * <p>Method under test: {@link CheckoutFormVariableExpression#shouldShowBillingInfoStage()}
   */
  @Test
  @DisplayName("Test shouldShowBillingInfoStage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CheckoutFormVariableExpression.shouldShowBillingInfoStage()"})
  void testShouldShowBillingInfoStage() {
    // Arrange
    when(cartStateService.cartHasThirdPartyPayment()).thenReturn(true);

    // Act
    boolean actualShouldShowBillingInfoStageResult =
        checkoutFormVariableExpression.shouldShowBillingInfoStage();

    // Assert
    verify(cartStateService).cartHasThirdPartyPayment();
    assertFalse(actualShouldShowBillingInfoStageResult);
  }

  /**
   * Test {@link CheckoutFormVariableExpression#shouldShowBillingInfoStage()}.
   *
   * <p>Method under test: {@link CheckoutFormVariableExpression#shouldShowBillingInfoStage()}
   */
  @Test
  @DisplayName("Test shouldShowBillingInfoStage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CheckoutFormVariableExpression.shouldShowBillingInfoStage()"})
  void testShouldShowBillingInfoStage2() {
    // Arrange
    when(cartStateService.cartHasThirdPartyPayment()).thenReturn(false);
    when(cartStateService.cartHasUnconfirmedCreditCard()).thenReturn(true);

    // Act
    boolean actualShouldShowBillingInfoStageResult =
        checkoutFormVariableExpression.shouldShowBillingInfoStage();

    // Assert
    verify(cartStateService).cartHasThirdPartyPayment();
    verify(cartStateService).cartHasUnconfirmedCreditCard();
    assertFalse(actualShouldShowBillingInfoStageResult);
  }

  /**
   * Test {@link CheckoutFormVariableExpression#shouldShowBillingInfoStage()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutFormVariableExpression#shouldShowBillingInfoStage()}
   */
  @Test
  @DisplayName("Test shouldShowBillingInfoStage(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CheckoutFormVariableExpression.shouldShowBillingInfoStage()"})
  void testShouldShowBillingInfoStage_thenReturnTrue() {
    // Arrange
    when(cartStateService.cartHasThirdPartyPayment()).thenReturn(false);
    when(cartStateService.cartHasUnconfirmedCreditCard()).thenReturn(false);

    // Act
    boolean actualShouldShowBillingInfoStageResult =
        checkoutFormVariableExpression.shouldShowBillingInfoStage();

    // Assert
    verify(cartStateService).cartHasThirdPartyPayment();
    verify(cartStateService).cartHasUnconfirmedCreditCard();
    assertTrue(actualShouldShowBillingInfoStageResult);
  }
}

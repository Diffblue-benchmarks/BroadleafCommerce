package org.broadleafcommerce.core.web.expression.checkout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.service.FulfillmentGroupService;
import org.broadleafcommerce.core.web.order.service.CartStateService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CheckoutFormVariableExpressionDiffblueTest {
  @Mock private CartStateService cartStateService;

  @InjectMocks private CheckoutFormVariableExpression checkoutFormVariableExpression;

  @Mock private FulfillmentGroupService fulfillmentGroupService;

  /**
   * Test {@link CheckoutFormVariableExpression#getName()}.
   *
   * <p>Method under test: {@link CheckoutFormVariableExpression#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String CheckoutFormVariableExpression.getName()"})
  public void testGetName() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CheckoutFormVariableExpression.shouldShowShippingInfoStage()"})
  public void testShouldShowShippingInfoStage_thenReturnFalse() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CheckoutFormVariableExpression.shouldShowShippingInfoStage()"})
  public void testShouldShowShippingInfoStage_thenReturnTrue() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CheckoutFormVariableExpression.shouldShowBillingInfoStage()"})
  public void testShouldShowBillingInfoStage() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CheckoutFormVariableExpression.shouldShowBillingInfoStage()"})
  public void testShouldShowBillingInfoStage2() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CheckoutFormVariableExpression.shouldShowBillingInfoStage()"})
  public void testShouldShowBillingInfoStage_thenReturnTrue() {
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

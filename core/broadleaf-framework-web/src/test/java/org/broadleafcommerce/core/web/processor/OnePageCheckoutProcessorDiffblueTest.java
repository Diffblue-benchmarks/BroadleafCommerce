package org.broadleafcommerce.core.web.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.service.FulfillmentGroupService;
import org.broadleafcommerce.core.web.checkout.model.BillingInfoForm;
import org.broadleafcommerce.core.web.checkout.model.OrderInfoForm;
import org.broadleafcommerce.core.web.checkout.model.ShippingInfoForm;
import org.broadleafcommerce.core.web.checkout.service.CheckoutFormService;
import org.broadleafcommerce.core.web.order.service.CartStateService;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CustomerPaymentImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OnePageCheckoutProcessorDiffblueTest {
  @Mock private CartStateService cartStateService;

  @Mock private CheckoutFormService checkoutFormService;

  @Mock private FulfillmentGroupService fulfillmentGroupService;

  @InjectMocks private OnePageCheckoutProcessor onePageCheckoutProcessor;

  /**
   * Test {@link OnePageCheckoutProcessor#getName()}.
   *
   * <p>Method under test: {@link OnePageCheckoutProcessor#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String OnePageCheckoutProcessor.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("one_page_checkout", new OnePageCheckoutProcessor().getName());
  }

  /**
   * Test {@link OnePageCheckoutProcessor#getPrecedence()}.
   *
   * <p>Method under test: {@link OnePageCheckoutProcessor#getPrecedence()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int OnePageCheckoutProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(100, new OnePageCheckoutProcessor().getPrecedence());
  }

  /**
   * Test {@link OnePageCheckoutProcessor#useGlobalScope()}.
   *
   * <p>Method under test: {@link OnePageCheckoutProcessor#useGlobalScope()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OnePageCheckoutProcessor.useGlobalScope()"})
  public void testUseGlobalScope() {
    // Arrange, Act and Assert
    assertFalse(new OnePageCheckoutProcessor().useGlobalScope());
  }

  /**
   * Test {@link OnePageCheckoutProcessor#prepopulateCheckoutForms(Order, OrderInfoForm,
   * ShippingInfoForm, BillingInfoForm)}.
   *
   * <p>Method under test: {@link OnePageCheckoutProcessor#prepopulateCheckoutForms(Order,
   * OrderInfoForm, ShippingInfoForm, BillingInfoForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OnePageCheckoutProcessor.prepopulateCheckoutForms(Order, OrderInfoForm, ShippingInfoForm, BillingInfoForm)"
  })
  public void testPrepopulateCheckoutForms() {
    // Arrange
    BillingInfoForm billingInfoForm = new BillingInfoForm();
    billingInfoForm.setAddress(new AddressImpl());
    billingInfoForm.setCustomerPayment(new CustomerPaymentImpl());
    billingInfoForm.setCustomerPaymentId(1L);
    billingInfoForm.setPaymentName("Payment Name");
    billingInfoForm.setSaveNewPayment(true);
    billingInfoForm.setUseCustomerPayment(true);
    billingInfoForm.setUseShippingAddress(true);

    OrderInfoForm orderInfoForm = new OrderInfoForm();
    orderInfoForm.setEmailAddress("42 Main St");
    when(checkoutFormService.prePopulateBillingInfoForm(
            Mockito.<BillingInfoForm>any(), Mockito.<ShippingInfoForm>any(), Mockito.<Order>any()))
        .thenReturn(billingInfoForm);
    when(checkoutFormService.prePopulateOrderInfoForm(
            Mockito.<OrderInfoForm>any(), Mockito.<Order>any()))
        .thenReturn(orderInfoForm);
    when(checkoutFormService.prePopulateShippingInfoForm(
            Mockito.<ShippingInfoForm>any(), Mockito.<Order>any()))
        .thenReturn(new ShippingInfoForm());
    NullOrderImpl cart = new NullOrderImpl();

    OrderInfoForm orderInfoForm2 = new OrderInfoForm();
    orderInfoForm2.setEmailAddress("42 Main St");
    ShippingInfoForm shippingForm = new ShippingInfoForm();

    BillingInfoForm billingForm = new BillingInfoForm();
    billingForm.setAddress(new AddressImpl());
    billingForm.setCustomerPayment(new CustomerPaymentImpl());
    billingForm.setCustomerPaymentId(1L);
    billingForm.setPaymentName("Payment Name");
    billingForm.setSaveNewPayment(true);
    billingForm.setUseCustomerPayment(true);
    billingForm.setUseShippingAddress(true);

    // Act
    onePageCheckoutProcessor.prepopulateCheckoutForms(
        cart, orderInfoForm2, shippingForm, billingForm);

    // Assert
    verify(checkoutFormService)
        .prePopulateBillingInfoForm(
            isA(BillingInfoForm.class), isA(ShippingInfoForm.class), isA(Order.class));
    verify(checkoutFormService)
        .prePopulateOrderInfoForm(isA(OrderInfoForm.class), isA(Order.class));
    verify(checkoutFormService)
        .prePopulateShippingInfoForm(isA(ShippingInfoForm.class), isA(Order.class));
  }

  /**
   * Test {@link OnePageCheckoutProcessor#calculateNumShippableFulfillmentGroups()}.
   *
   * <p>Method under test: {@link OnePageCheckoutProcessor#calculateNumShippableFulfillmentGroups()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int OnePageCheckoutProcessor.calculateNumShippableFulfillmentGroups()"})
  public void testCalculateNumShippableFulfillmentGroups() {
    // Arrange
    when(fulfillmentGroupService.calculateNumShippableFulfillmentGroups(Mockito.<Order>any()))
        .thenReturn(10);

    // Act
    int actualCalculateNumShippableFulfillmentGroupsResult =
        onePageCheckoutProcessor.calculateNumShippableFulfillmentGroups();

    // Assert
    verify(fulfillmentGroupService).calculateNumShippableFulfillmentGroups(isNull());
    assertEquals(10, actualCalculateNumShippableFulfillmentGroupsResult);
  }

  /**
   * Test {@link OnePageCheckoutProcessor#hasPopulatedOrderInfo(Order)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OnePageCheckoutProcessor#hasPopulatedOrderInfo(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OnePageCheckoutProcessor.hasPopulatedOrderInfo(Order)"})
  public void testHasPopulatedOrderInfo_thenReturnFalse() {
    // Arrange
    when(cartStateService.cartHasPopulatedOrderInfo()).thenReturn(false);

    // Act
    boolean actualHasPopulatedOrderInfoResult =
        onePageCheckoutProcessor.hasPopulatedOrderInfo(new NullOrderImpl());

    // Assert
    verify(cartStateService).cartHasPopulatedOrderInfo();
    assertFalse(actualHasPopulatedOrderInfoResult);
  }

  /**
   * Test {@link OnePageCheckoutProcessor#hasPopulatedOrderInfo(Order)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OnePageCheckoutProcessor#hasPopulatedOrderInfo(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OnePageCheckoutProcessor.hasPopulatedOrderInfo(Order)"})
  public void testHasPopulatedOrderInfo_thenReturnTrue() {
    // Arrange
    when(cartStateService.cartHasPopulatedOrderInfo()).thenReturn(true);

    // Act
    boolean actualHasPopulatedOrderInfoResult =
        onePageCheckoutProcessor.hasPopulatedOrderInfo(new NullOrderImpl());

    // Assert
    verify(cartStateService).cartHasPopulatedOrderInfo();
    assertTrue(actualHasPopulatedOrderInfoResult);
  }

  /**
   * Test {@link OnePageCheckoutProcessor#hasPopulatedBillingAddress(Order)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OnePageCheckoutProcessor#hasPopulatedBillingAddress(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OnePageCheckoutProcessor.hasPopulatedBillingAddress(Order)"})
  public void testHasPopulatedBillingAddress_thenReturnFalse() {
    // Arrange
    when(cartStateService.cartHasPopulatedBillingAddress()).thenReturn(false);

    // Act
    boolean actualHasPopulatedBillingAddressResult =
        onePageCheckoutProcessor.hasPopulatedBillingAddress(new NullOrderImpl());

    // Assert
    verify(cartStateService).cartHasPopulatedBillingAddress();
    assertFalse(actualHasPopulatedBillingAddressResult);
  }

  /**
   * Test {@link OnePageCheckoutProcessor#hasPopulatedBillingAddress(Order)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OnePageCheckoutProcessor#hasPopulatedBillingAddress(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OnePageCheckoutProcessor.hasPopulatedBillingAddress(Order)"})
  public void testHasPopulatedBillingAddress_thenReturnTrue() {
    // Arrange
    when(cartStateService.cartHasPopulatedBillingAddress()).thenReturn(true);

    // Act
    boolean actualHasPopulatedBillingAddressResult =
        onePageCheckoutProcessor.hasPopulatedBillingAddress(new NullOrderImpl());

    // Assert
    verify(cartStateService).cartHasPopulatedBillingAddress();
    assertTrue(actualHasPopulatedBillingAddressResult);
  }

  /**
   * Test {@link OnePageCheckoutProcessor#hasPopulatedShippingAddress(Order)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OnePageCheckoutProcessor#hasPopulatedShippingAddress(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OnePageCheckoutProcessor.hasPopulatedShippingAddress(Order)"})
  public void testHasPopulatedShippingAddress_thenReturnFalse() {
    // Arrange
    when(cartStateService.cartHasPopulatedShippingAddress()).thenReturn(false);

    // Act
    boolean actualHasPopulatedShippingAddressResult =
        onePageCheckoutProcessor.hasPopulatedShippingAddress(new NullOrderImpl());

    // Assert
    verify(cartStateService).cartHasPopulatedShippingAddress();
    assertFalse(actualHasPopulatedShippingAddressResult);
  }

  /**
   * Test {@link OnePageCheckoutProcessor#hasPopulatedShippingAddress(Order)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OnePageCheckoutProcessor#hasPopulatedShippingAddress(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OnePageCheckoutProcessor.hasPopulatedShippingAddress(Order)"})
  public void testHasPopulatedShippingAddress_thenReturnTrue() {
    // Arrange
    when(cartStateService.cartHasPopulatedShippingAddress()).thenReturn(true);

    // Act
    boolean actualHasPopulatedShippingAddressResult =
        onePageCheckoutProcessor.hasPopulatedShippingAddress(new NullOrderImpl());

    // Assert
    verify(cartStateService).cartHasPopulatedShippingAddress();
    assertTrue(actualHasPopulatedShippingAddressResult);
  }

  /**
   * Test {@link OnePageCheckoutProcessor#populateExpirationMonths()}.
   *
   * <p>Method under test: {@link OnePageCheckoutProcessor#populateExpirationMonths()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OnePageCheckoutProcessor.populateExpirationMonths()"})
  public void testPopulateExpirationMonths() {
    // Arrange and Act
    List<String> actualPopulateExpirationMonthsResult =
        new OnePageCheckoutProcessor().populateExpirationMonths();

    // Assert
    assertEquals(12, actualPopulateExpirationMonthsResult.size());
    assertEquals("01 - January", actualPopulateExpirationMonthsResult.get(0));
    assertEquals("02 - February", actualPopulateExpirationMonthsResult.get(1));
    assertEquals("03 - March", actualPopulateExpirationMonthsResult.get(2));
    assertEquals("04 - April", actualPopulateExpirationMonthsResult.get(3));
    assertEquals("05 - May", actualPopulateExpirationMonthsResult.get(4));
    assertEquals("06 - June", actualPopulateExpirationMonthsResult.get(5));
    assertEquals("07 - July", actualPopulateExpirationMonthsResult.get(6));
    assertEquals("08 - August", actualPopulateExpirationMonthsResult.get(7));
    assertEquals("09 - September", actualPopulateExpirationMonthsResult.get(8));
    assertEquals("10 - October", actualPopulateExpirationMonthsResult.get(9));
    assertEquals("11 - November", actualPopulateExpirationMonthsResult.get(10));
    assertEquals("12 - December", actualPopulateExpirationMonthsResult.get(11));
  }

  /**
   * Test {@link OnePageCheckoutProcessor#populateExpirationYears()}.
   *
   * <p>Method under test: {@link OnePageCheckoutProcessor#populateExpirationYears()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OnePageCheckoutProcessor.populateExpirationYears()"})
  public void testPopulateExpirationYears() {
    // Arrange, Act and Assert
    assertEquals(10, new OnePageCheckoutProcessor().populateExpirationYears().size());
  }
}

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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OnePageCheckoutProcessorDiffblueTest {
  @Mock
  private FulfillmentGroupService fulfillmentGroupService;

  @InjectMocks
  private OnePageCheckoutProcessor onePageCheckoutProcessor;

  @Mock
  private CartStateService cartStateService;

  @Mock
  private CheckoutFormService checkoutFormService;

  /**
   * Test {@link OnePageCheckoutProcessor#getName()}.
   * <p>
   * Method under test: {@link OnePageCheckoutProcessor#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String OnePageCheckoutProcessor.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("one_page_checkout", (new OnePageCheckoutProcessor()).getName());
  }

  /**
   * Test {@link OnePageCheckoutProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link OnePageCheckoutProcessor#getPrecedence()}
   */
  @Test
  @DisplayName("Test getPrecedence()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int OnePageCheckoutProcessor.getPrecedence()"})
  void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(100, onePageCheckoutProcessor.getPrecedence());
  }

  /**
   * Test {@link OnePageCheckoutProcessor#useGlobalScope()}.
   * <p>
   * Method under test: {@link OnePageCheckoutProcessor#useGlobalScope()}
   */
  @Test
  @DisplayName("Test useGlobalScope()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OnePageCheckoutProcessor.useGlobalScope()"})
  void testUseGlobalScope() {
    // Arrange, Act and Assert
    assertFalse(onePageCheckoutProcessor.useGlobalScope());
  }

  /**
   * Test {@link OnePageCheckoutProcessor#prepopulateCheckoutForms(Order, OrderInfoForm, ShippingInfoForm, BillingInfoForm)}.
   * <p>
   * Method under test: {@link OnePageCheckoutProcessor#prepopulateCheckoutForms(Order, OrderInfoForm, ShippingInfoForm, BillingInfoForm)}
   */
  @Test
  @DisplayName("Test prepopulateCheckoutForms(Order, OrderInfoForm, ShippingInfoForm, BillingInfoForm)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void OnePageCheckoutProcessor.prepopulateCheckoutForms(Order, OrderInfoForm, ShippingInfoForm, BillingInfoForm)"})
  void testPrepopulateCheckoutForms() {
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
    when(checkoutFormService.prePopulateBillingInfoForm(Mockito.<BillingInfoForm>any(), Mockito.<ShippingInfoForm>any(),
        Mockito.<Order>any())).thenReturn(billingInfoForm);
    when(checkoutFormService.prePopulateOrderInfoForm(Mockito.<OrderInfoForm>any(), Mockito.<Order>any()))
        .thenReturn(orderInfoForm);
    when(checkoutFormService.prePopulateShippingInfoForm(Mockito.<ShippingInfoForm>any(), Mockito.<Order>any()))
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
    onePageCheckoutProcessor.prepopulateCheckoutForms(cart, orderInfoForm2, shippingForm, billingForm);

    // Assert
    verify(checkoutFormService).prePopulateBillingInfoForm(isA(BillingInfoForm.class), isA(ShippingInfoForm.class),
        isA(Order.class));
    verify(checkoutFormService).prePopulateOrderInfoForm(isA(OrderInfoForm.class), isA(Order.class));
    verify(checkoutFormService).prePopulateShippingInfoForm(isA(ShippingInfoForm.class), isA(Order.class));
  }

  /**
   * Test {@link OnePageCheckoutProcessor#calculateNumShippableFulfillmentGroups()}.
   * <p>
   * Method under test: {@link OnePageCheckoutProcessor#calculateNumShippableFulfillmentGroups()}
   */
  @Test
  @DisplayName("Test calculateNumShippableFulfillmentGroups()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int OnePageCheckoutProcessor.calculateNumShippableFulfillmentGroups()"})
  void testCalculateNumShippableFulfillmentGroups() {
    // Arrange
    when(fulfillmentGroupService.calculateNumShippableFulfillmentGroups(Mockito.<Order>any())).thenReturn(10);

    // Act
    int actualCalculateNumShippableFulfillmentGroupsResult = onePageCheckoutProcessor
        .calculateNumShippableFulfillmentGroups();

    // Assert
    verify(fulfillmentGroupService).calculateNumShippableFulfillmentGroups(isNull());
    assertEquals(10, actualCalculateNumShippableFulfillmentGroupsResult);
  }

  /**
   * Test {@link OnePageCheckoutProcessor#hasPopulatedOrderInfo(Order)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OnePageCheckoutProcessor#hasPopulatedOrderInfo(Order)}
   */
  @Test
  @DisplayName("Test hasPopulatedOrderInfo(Order); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OnePageCheckoutProcessor.hasPopulatedOrderInfo(Order)"})
  void testHasPopulatedOrderInfo_thenReturnFalse() {
    // Arrange
    when(cartStateService.cartHasPopulatedOrderInfo()).thenReturn(false);

    // Act
    boolean actualHasPopulatedOrderInfoResult = onePageCheckoutProcessor.hasPopulatedOrderInfo(new NullOrderImpl());

    // Assert
    verify(cartStateService).cartHasPopulatedOrderInfo();
    assertFalse(actualHasPopulatedOrderInfoResult);
  }

  /**
   * Test {@link OnePageCheckoutProcessor#hasPopulatedOrderInfo(Order)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OnePageCheckoutProcessor#hasPopulatedOrderInfo(Order)}
   */
  @Test
  @DisplayName("Test hasPopulatedOrderInfo(Order); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OnePageCheckoutProcessor.hasPopulatedOrderInfo(Order)"})
  void testHasPopulatedOrderInfo_thenReturnTrue() {
    // Arrange
    when(cartStateService.cartHasPopulatedOrderInfo()).thenReturn(true);

    // Act
    boolean actualHasPopulatedOrderInfoResult = onePageCheckoutProcessor.hasPopulatedOrderInfo(new NullOrderImpl());

    // Assert
    verify(cartStateService).cartHasPopulatedOrderInfo();
    assertTrue(actualHasPopulatedOrderInfoResult);
  }

  /**
   * Test {@link OnePageCheckoutProcessor#hasPopulatedBillingAddress(Order)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OnePageCheckoutProcessor#hasPopulatedBillingAddress(Order)}
   */
  @Test
  @DisplayName("Test hasPopulatedBillingAddress(Order); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OnePageCheckoutProcessor.hasPopulatedBillingAddress(Order)"})
  void testHasPopulatedBillingAddress_thenReturnFalse() {
    // Arrange
    when(cartStateService.cartHasPopulatedBillingAddress()).thenReturn(false);

    // Act
    boolean actualHasPopulatedBillingAddressResult = onePageCheckoutProcessor
        .hasPopulatedBillingAddress(new NullOrderImpl());

    // Assert
    verify(cartStateService).cartHasPopulatedBillingAddress();
    assertFalse(actualHasPopulatedBillingAddressResult);
  }

  /**
   * Test {@link OnePageCheckoutProcessor#hasPopulatedBillingAddress(Order)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OnePageCheckoutProcessor#hasPopulatedBillingAddress(Order)}
   */
  @Test
  @DisplayName("Test hasPopulatedBillingAddress(Order); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OnePageCheckoutProcessor.hasPopulatedBillingAddress(Order)"})
  void testHasPopulatedBillingAddress_thenReturnTrue() {
    // Arrange
    when(cartStateService.cartHasPopulatedBillingAddress()).thenReturn(true);

    // Act
    boolean actualHasPopulatedBillingAddressResult = onePageCheckoutProcessor
        .hasPopulatedBillingAddress(new NullOrderImpl());

    // Assert
    verify(cartStateService).cartHasPopulatedBillingAddress();
    assertTrue(actualHasPopulatedBillingAddressResult);
  }

  /**
   * Test {@link OnePageCheckoutProcessor#hasPopulatedShippingAddress(Order)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OnePageCheckoutProcessor#hasPopulatedShippingAddress(Order)}
   */
  @Test
  @DisplayName("Test hasPopulatedShippingAddress(Order); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OnePageCheckoutProcessor.hasPopulatedShippingAddress(Order)"})
  void testHasPopulatedShippingAddress_thenReturnFalse() {
    // Arrange
    when(cartStateService.cartHasPopulatedShippingAddress()).thenReturn(false);

    // Act
    boolean actualHasPopulatedShippingAddressResult = onePageCheckoutProcessor
        .hasPopulatedShippingAddress(new NullOrderImpl());

    // Assert
    verify(cartStateService).cartHasPopulatedShippingAddress();
    assertFalse(actualHasPopulatedShippingAddressResult);
  }

  /**
   * Test {@link OnePageCheckoutProcessor#hasPopulatedShippingAddress(Order)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OnePageCheckoutProcessor#hasPopulatedShippingAddress(Order)}
   */
  @Test
  @DisplayName("Test hasPopulatedShippingAddress(Order); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OnePageCheckoutProcessor.hasPopulatedShippingAddress(Order)"})
  void testHasPopulatedShippingAddress_thenReturnTrue() {
    // Arrange
    when(cartStateService.cartHasPopulatedShippingAddress()).thenReturn(true);

    // Act
    boolean actualHasPopulatedShippingAddressResult = onePageCheckoutProcessor
        .hasPopulatedShippingAddress(new NullOrderImpl());

    // Assert
    verify(cartStateService).cartHasPopulatedShippingAddress();
    assertTrue(actualHasPopulatedShippingAddressResult);
  }

  /**
   * Test {@link OnePageCheckoutProcessor#populateExpirationMonths()}.
   * <p>
   * Method under test: {@link OnePageCheckoutProcessor#populateExpirationMonths()}
   */
  @Test
  @DisplayName("Test populateExpirationMonths()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List OnePageCheckoutProcessor.populateExpirationMonths()"})
  void testPopulateExpirationMonths() {
    // Arrange and Act
    List<String> actualPopulateExpirationMonthsResult = onePageCheckoutProcessor.populateExpirationMonths();

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
   * <p>
   * Method under test: {@link OnePageCheckoutProcessor#populateExpirationYears()}
   */
  @Test
  @DisplayName("Test populateExpirationYears()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List OnePageCheckoutProcessor.populateExpirationYears()"})
  void testPopulateExpirationYears() {
    // Arrange, Act and Assert
    assertEquals(10, onePageCheckoutProcessor.populateExpirationYears().size());
  }
}

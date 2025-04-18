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
package org.broadleafcommerce.common.payment.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.payment.PaymentGatewayRequestType;
import org.broadleafcommerce.common.payment.PaymentType;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {PaymentRequestDTO.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class PaymentRequestDTODiffblueTest {
  @Autowired
  private PaymentRequestDTO paymentRequestDTO;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link PaymentRequestDTO}
   *   <li>{@link PaymentRequestDTO#completeCheckoutOnCallback(boolean)}
   *   <li>{@link PaymentRequestDTO#gatewayRequestType(PaymentGatewayRequestType)}
   *   <li>{@link PaymentRequestDTO#orderCurrencyCode(String)}
   *   <li>{@link PaymentRequestDTO#orderDescription(String)}
   *   <li>{@link PaymentRequestDTO#orderId(String)}
   *   <li>{@link PaymentRequestDTO#orderSubtotal(String)}
   *   <li>{@link PaymentRequestDTO#paymentType(PaymentType)}
   *   <li>{@link PaymentRequestDTO#shippingTotal(String)}
   *   <li>{@link PaymentRequestDTO#taxTotal(String)}
   *   <li>{@link PaymentRequestDTO#transactionTotal(String)}
   *   <li>{@link PaymentRequestDTO#getAdditionalFields()}
   *   <li>{@link PaymentRequestDTO#getBillTo()}
   *   <li>{@link PaymentRequestDTO#getCreditCard()}
   *   <li>{@link PaymentRequestDTO#getCustomer()}
   *   <li>{@link PaymentRequestDTO#getCustomerCredits()}
   *   <li>{@link PaymentRequestDTO#getGatewayRequestType()}
   *   <li>{@link PaymentRequestDTO#getGiftCards()}
   *   <li>{@link PaymentRequestDTO#getLineItems()}
   *   <li>{@link PaymentRequestDTO#getOrderCurrencyCode()}
   *   <li>{@link PaymentRequestDTO#getOrderDescription()}
   *   <li>{@link PaymentRequestDTO#getOrderId()}
   *   <li>{@link PaymentRequestDTO#getOrderSubtotal()}
   *   <li>{@link PaymentRequestDTO#getPaymentType()}
   *   <li>{@link PaymentRequestDTO#getShipTo()}
   *   <li>{@link PaymentRequestDTO#getShippingTotal()}
   *   <li>{@link PaymentRequestDTO#getSubscription()}
   *   <li>{@link PaymentRequestDTO#getTaxTotal()}
   *   <li>{@link PaymentRequestDTO#getTransactionTotal()}
   *   <li>{@link PaymentRequestDTO#isCompleteCheckoutOnCallback()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PaymentRequestDTO.<init>()",
      "PaymentRequestDTO PaymentRequestDTO.completeCheckoutOnCallback(boolean)",
      "PaymentRequestDTO PaymentRequestDTO.gatewayRequestType(PaymentGatewayRequestType)",
      "Map PaymentRequestDTO.getAdditionalFields()", "AddressDTO PaymentRequestDTO.getBillTo()",
      "CreditCardDTO PaymentRequestDTO.getCreditCard()", "GatewayCustomerDTO PaymentRequestDTO.getCustomer()",
      "List PaymentRequestDTO.getCustomerCredits()",
      "PaymentGatewayRequestType PaymentRequestDTO.getGatewayRequestType()", "List PaymentRequestDTO.getGiftCards()",
      "List PaymentRequestDTO.getLineItems()", "String PaymentRequestDTO.getOrderCurrencyCode()",
      "String PaymentRequestDTO.getOrderDescription()", "String PaymentRequestDTO.getOrderId()",
      "String PaymentRequestDTO.getOrderSubtotal()", "PaymentType PaymentRequestDTO.getPaymentType()",
      "AddressDTO PaymentRequestDTO.getShipTo()", "String PaymentRequestDTO.getShippingTotal()",
      "SubscriptionDTO PaymentRequestDTO.getSubscription()", "String PaymentRequestDTO.getTaxTotal()",
      "String PaymentRequestDTO.getTransactionTotal()", "boolean PaymentRequestDTO.isCompleteCheckoutOnCallback()",
      "PaymentRequestDTO PaymentRequestDTO.orderCurrencyCode(String)",
      "PaymentRequestDTO PaymentRequestDTO.orderDescription(String)",
      "PaymentRequestDTO PaymentRequestDTO.orderId(String)",
      "PaymentRequestDTO PaymentRequestDTO.orderSubtotal(String)",
      "PaymentRequestDTO PaymentRequestDTO.paymentType(PaymentType)",
      "PaymentRequestDTO PaymentRequestDTO.shippingTotal(String)",
      "PaymentRequestDTO PaymentRequestDTO.taxTotal(String)",
      "PaymentRequestDTO PaymentRequestDTO.transactionTotal(String)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    PaymentRequestDTO actualPaymentRequestDTO = new PaymentRequestDTO();
    PaymentRequestDTO actualCompleteCheckoutOnCallbackResult = actualPaymentRequestDTO.completeCheckoutOnCallback(true);
    PaymentRequestDTO actualGatewayRequestTypeResult = actualPaymentRequestDTO
        .gatewayRequestType(PaymentGatewayRequestType.CREATE_CUSTOMER_PAYMENT_TR);
    PaymentRequestDTO actualOrderCurrencyCodeResult = actualPaymentRequestDTO.orderCurrencyCode("GBP");
    PaymentRequestDTO actualOrderDescriptionResult = actualPaymentRequestDTO.orderDescription("Order Description");
    PaymentRequestDTO actualOrderIdResult = actualPaymentRequestDTO.orderId("42");
    PaymentRequestDTO actualOrderSubtotalResult = actualPaymentRequestDTO.orderSubtotal("Order Subtotal");
    PaymentRequestDTO actualPaymentTypeResult = actualPaymentRequestDTO.paymentType(PaymentType.APPLE_PAY);
    PaymentRequestDTO actualShippingTotalResult = actualPaymentRequestDTO.shippingTotal("Shipping Total");
    PaymentRequestDTO actualTaxTotalResult = actualPaymentRequestDTO.taxTotal("Tax Total");
    PaymentRequestDTO actualTransactionTotalResult = actualPaymentRequestDTO.transactionTotal("Transaction Total");
    Map<String, Object> actualAdditionalFields = actualPaymentRequestDTO.getAdditionalFields();
    AddressDTO<PaymentRequestDTO> actualBillTo = actualPaymentRequestDTO.getBillTo();
    CreditCardDTO<PaymentRequestDTO> actualCreditCard = actualPaymentRequestDTO.getCreditCard();
    GatewayCustomerDTO<PaymentRequestDTO> actualCustomer = actualPaymentRequestDTO.getCustomer();
    List<CustomerCreditDTO<PaymentRequestDTO>> actualCustomerCredits = actualPaymentRequestDTO.getCustomerCredits();
    PaymentGatewayRequestType actualGatewayRequestType = actualPaymentRequestDTO.getGatewayRequestType();
    List<GiftCardDTO<PaymentRequestDTO>> actualGiftCards = actualPaymentRequestDTO.getGiftCards();
    List<LineItemDTO> actualLineItems = actualPaymentRequestDTO.getLineItems();
    String actualOrderCurrencyCode = actualPaymentRequestDTO.getOrderCurrencyCode();
    String actualOrderDescription = actualPaymentRequestDTO.getOrderDescription();
    String actualOrderId = actualPaymentRequestDTO.getOrderId();
    String actualOrderSubtotal = actualPaymentRequestDTO.getOrderSubtotal();
    PaymentType actualPaymentType = actualPaymentRequestDTO.getPaymentType();
    AddressDTO<PaymentRequestDTO> actualShipTo = actualPaymentRequestDTO.getShipTo();
    String actualShippingTotal = actualPaymentRequestDTO.getShippingTotal();
    SubscriptionDTO<PaymentRequestDTO> actualSubscription = actualPaymentRequestDTO.getSubscription();
    String actualTaxTotal = actualPaymentRequestDTO.getTaxTotal();
    String actualTransactionTotal = actualPaymentRequestDTO.getTransactionTotal();
    boolean actualIsCompleteCheckoutOnCallbackResult = actualPaymentRequestDTO.isCompleteCheckoutOnCallback();

    // Assert
    assertEquals("42", actualOrderId);
    assertEquals("GBP", actualOrderCurrencyCode);
    assertEquals("Order Description", actualOrderDescription);
    assertEquals("Order Subtotal", actualOrderSubtotal);
    assertEquals("Shipping Total", actualShippingTotal);
    assertEquals("Tax Total", actualTaxTotal);
    assertEquals("Transaction Total", actualTransactionTotal);
    assertNull(actualBillTo);
    assertNull(actualShipTo);
    assertNull(actualCreditCard);
    assertNull(actualCustomer);
    assertNull(actualSubscription);
    assertTrue(actualCustomerCredits.isEmpty());
    assertTrue(actualGiftCards.isEmpty());
    assertTrue(actualLineItems.isEmpty());
    assertTrue(actualAdditionalFields.isEmpty());
    assertTrue(actualIsCompleteCheckoutOnCallbackResult);
    assertSame(actualPaymentRequestDTO, actualCompleteCheckoutOnCallbackResult);
    assertSame(actualPaymentRequestDTO, actualGatewayRequestTypeResult);
    assertSame(actualPaymentRequestDTO, actualOrderCurrencyCodeResult);
    assertSame(actualPaymentRequestDTO, actualOrderDescriptionResult);
    assertSame(actualPaymentRequestDTO, actualOrderIdResult);
    assertSame(actualPaymentRequestDTO, actualOrderSubtotalResult);
    assertSame(actualPaymentRequestDTO, actualPaymentTypeResult);
    assertSame(actualPaymentRequestDTO, actualShippingTotalResult);
    assertSame(actualPaymentRequestDTO, actualTaxTotalResult);
    assertSame(actualPaymentRequestDTO, actualTransactionTotalResult);
    assertSame(actualGatewayRequestType.CREATE_CUSTOMER_PAYMENT_TR, actualGatewayRequestType);
    assertSame(actualPaymentType.APPLE_PAY, actualPaymentType);
  }

  /**
   * Test {@link PaymentRequestDTO#customer()}.
   * <p>
   * Method under test: {@link PaymentRequestDTO#customer()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GatewayCustomerDTO PaymentRequestDTO.customer()"})
  public void testCustomer() {
    // Arrange and Act
    GatewayCustomerDTO<PaymentRequestDTO> actualCustomerResult = (new PaymentRequestDTO()).customer();

    // Assert
    assertNull(actualCustomerResult.getCompanyName());
    assertNull(actualCustomerResult.getCustomerId());
    assertNull(actualCustomerResult.getEmail());
    assertNull(actualCustomerResult.getFax());
    assertNull(actualCustomerResult.getFirstName());
    assertNull(actualCustomerResult.getLastName());
    assertNull(actualCustomerResult.getMobile());
    assertNull(actualCustomerResult.getPhone());
    assertNull(actualCustomerResult.getWebsite());
    assertTrue(actualCustomerResult.getAdditionalFields().isEmpty());
  }

  /**
   * Test {@link PaymentRequestDTO#creditCard()}.
   * <p>
   * Method under test: {@link PaymentRequestDTO#creditCard()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreditCardDTO PaymentRequestDTO.creditCard()"})
  public void testCreditCard() {
    // Arrange and Act
    CreditCardDTO<PaymentRequestDTO> actualCreditCardResult = (new PaymentRequestDTO()).creditCard();

    // Assert
    assertNull(actualCreditCardResult.getCreditCardCvv());
    assertNull(actualCreditCardResult.getCreditCardExpDate());
    assertNull(actualCreditCardResult.getCreditCardExpMonth());
    assertNull(actualCreditCardResult.getCreditCardExpYear());
    assertNull(actualCreditCardResult.getCreditCardHolderName());
    assertNull(actualCreditCardResult.getCreditCardLastFour());
    assertNull(actualCreditCardResult.getCreditCardNum());
    assertNull(actualCreditCardResult.getCreditCardType());
    assertTrue(actualCreditCardResult.getAdditionalFields().isEmpty());
  }

  /**
   * Test {@link PaymentRequestDTO#subscription()}.
   * <p>
   * Method under test: {@link PaymentRequestDTO#subscription()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SubscriptionDTO PaymentRequestDTO.subscription()"})
  public void testSubscription() {
    // Arrange and Act
    SubscriptionDTO<PaymentRequestDTO> actualSubscriptionResult = (new PaymentRequestDTO()).subscription();

    // Assert
    assertNull(actualSubscriptionResult.getFrequency());
    assertNull(actualSubscriptionResult.getNumberOfInstallments());
    assertNull(actualSubscriptionResult.getRecurringAmount());
    assertNull(actualSubscriptionResult.getStartDate());
    assertTrue(actualSubscriptionResult.getAdditionalFields().isEmpty());
  }

  /**
   * Test {@link PaymentRequestDTO#shipTo()}.
   * <p>
   * Method under test: {@link PaymentRequestDTO#shipTo()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AddressDTO PaymentRequestDTO.shipTo()"})
  public void testShipTo() {
    // Arrange and Act
    AddressDTO<PaymentRequestDTO> actualShipToResult = (new PaymentRequestDTO()).shipTo();

    // Assert
    assertNull(actualShipToResult.getAddressCityLocality());
    assertNull(actualShipToResult.getAddressCompanyName());
    assertNull(actualShipToResult.getAddressCountryCode());
    assertNull(actualShipToResult.getAddressEmail());
    assertNull(actualShipToResult.getAddressFirstName());
    assertNull(actualShipToResult.getAddressFullName());
    assertNull(actualShipToResult.getAddressLastName());
    assertNull(actualShipToResult.getAddressLine1());
    assertNull(actualShipToResult.getAddressLine2());
    assertNull(actualShipToResult.getAddressPhone());
    assertNull(actualShipToResult.getAddressPostalCode());
    assertNull(actualShipToResult.getAddressStateRegion());
    assertNull(actualShipToResult.getCounty());
    assertTrue(actualShipToResult.getAdditionalFields().isEmpty());
  }

  /**
   * Test {@link PaymentRequestDTO#billTo()}.
   * <p>
   * Method under test: {@link PaymentRequestDTO#billTo()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AddressDTO PaymentRequestDTO.billTo()"})
  public void testBillTo() {
    // Arrange and Act
    AddressDTO<PaymentRequestDTO> actualBillToResult = (new PaymentRequestDTO()).billTo();

    // Assert
    assertNull(actualBillToResult.getAddressCityLocality());
    assertNull(actualBillToResult.getAddressCompanyName());
    assertNull(actualBillToResult.getAddressCountryCode());
    assertNull(actualBillToResult.getAddressEmail());
    assertNull(actualBillToResult.getAddressFirstName());
    assertNull(actualBillToResult.getAddressFullName());
    assertNull(actualBillToResult.getAddressLastName());
    assertNull(actualBillToResult.getAddressLine1());
    assertNull(actualBillToResult.getAddressLine2());
    assertNull(actualBillToResult.getAddressPhone());
    assertNull(actualBillToResult.getAddressPostalCode());
    assertNull(actualBillToResult.getAddressStateRegion());
    assertNull(actualBillToResult.getCounty());
    assertTrue(actualBillToResult.getAdditionalFields().isEmpty());
  }

  /**
   * Test {@link PaymentRequestDTO#giftCard()}.
   * <p>
   * Method under test: {@link PaymentRequestDTO#giftCard()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GiftCardDTO PaymentRequestDTO.giftCard()"})
  public void testGiftCard() {
    // Arrange and Act
    GiftCardDTO<PaymentRequestDTO> actualGiftCardResult = (new PaymentRequestDTO()).giftCard();

    // Assert
    assertNull(actualGiftCardResult.giftCardMasked);
    assertNull(actualGiftCardResult.giftCardNum);
    assertTrue(actualGiftCardResult.additionalFields.isEmpty());
  }

  /**
   * Test {@link PaymentRequestDTO#customerCredit()}.
   * <p>
   * Method under test: {@link PaymentRequestDTO#customerCredit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CustomerCreditDTO PaymentRequestDTO.customerCredit()"})
  public void testCustomerCredit() {
    // Arrange and Act
    CustomerCreditDTO<PaymentRequestDTO> actualCustomerCreditResult = (new PaymentRequestDTO()).customerCredit();

    // Assert
    assertNull(actualCustomerCreditResult.customerCreditAccountMasked);
    assertNull(actualCustomerCreditResult.customerCreditAccountNum);
    assertTrue(actualCustomerCreditResult.additionalFields.isEmpty());
  }

  /**
   * Test {@link PaymentRequestDTO#lineItem()}.
   * <p>
   * Method under test: {@link PaymentRequestDTO#lineItem()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LineItemDTO PaymentRequestDTO.lineItem()"})
  public void testLineItem() {
    // Arrange and Act
    LineItemDTO actualLineItemResult = (new PaymentRequestDTO()).lineItem();

    // Assert
    assertNull(actualLineItemResult.getAmount());
    assertNull(actualLineItemResult.getCategory());
    assertNull(actualLineItemResult.getDescription());
    assertNull(actualLineItemResult.getItemTotal());
    assertNull(actualLineItemResult.getName());
    assertNull(actualLineItemResult.getQuantity());
    assertNull(actualLineItemResult.getShortDescription());
    assertNull(actualLineItemResult.getSystemId());
    assertNull(actualLineItemResult.getTax());
    assertNull(actualLineItemResult.getTotal());
    assertTrue(actualLineItemResult.getAdditionalFields().isEmpty());
  }

  /**
   * Test {@link PaymentRequestDTO#additionalField(String, Object)}.
   * <p>
   * Method under test: {@link PaymentRequestDTO#additionalField(String, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PaymentRequestDTO PaymentRequestDTO.additionalField(String, Object)"})
  public void testAdditionalField() {
    // Arrange, Act and Assert
    assertSame(paymentRequestDTO, paymentRequestDTO.additionalField("Key", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link PaymentRequestDTO#shipToPopulated()}.
   * <p>
   * Method under test: {@link PaymentRequestDTO#shipToPopulated()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PaymentRequestDTO.shipToPopulated()"})
  public void testShipToPopulated() {
    // Arrange, Act and Assert
    assertFalse((new PaymentRequestDTO()).shipToPopulated());
  }

  /**
   * Test {@link PaymentRequestDTO#billToPopulated()}.
   * <p>
   * Method under test: {@link PaymentRequestDTO#billToPopulated()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PaymentRequestDTO.billToPopulated()"})
  public void testBillToPopulated() {
    // Arrange, Act and Assert
    assertFalse((new PaymentRequestDTO()).billToPopulated());
  }

  /**
   * Test {@link PaymentRequestDTO#creditCardPopulated()}.
   * <p>
   * Method under test: {@link PaymentRequestDTO#creditCardPopulated()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PaymentRequestDTO.creditCardPopulated()"})
  public void testCreditCardPopulated() {
    // Arrange, Act and Assert
    assertFalse((new PaymentRequestDTO()).creditCardPopulated());
  }

  /**
   * Test {@link PaymentRequestDTO#customerPopulated()}.
   * <p>
   * Method under test: {@link PaymentRequestDTO#customerPopulated()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PaymentRequestDTO.customerPopulated()"})
  public void testCustomerPopulated() {
    // Arrange, Act and Assert
    assertFalse((new PaymentRequestDTO()).customerPopulated());
  }

  /**
   * Test {@link PaymentRequestDTO#subscriptionPopulated()}.
   * <p>
   * Method under test: {@link PaymentRequestDTO#subscriptionPopulated()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PaymentRequestDTO.subscriptionPopulated()"})
  public void testSubscriptionPopulated() {
    // Arrange, Act and Assert
    assertFalse((new PaymentRequestDTO()).subscriptionPopulated());
  }
}

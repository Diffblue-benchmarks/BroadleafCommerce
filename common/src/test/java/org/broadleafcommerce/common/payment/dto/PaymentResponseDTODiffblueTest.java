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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.broadleafcommerce.common.payment.PaymentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {PaymentResponseDTO.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class PaymentResponseDTODiffblueTest {
  @MockBean
  private PaymentGatewayType paymentGatewayType;

  @Autowired
  private PaymentResponseDTO paymentResponseDTO;

  @MockBean
  private PaymentType paymentType;

  /**
   * Method under test: {@link PaymentResponseDTO#customer()}
   */
  @Test
  public void testCustomer() {
    // Arrange and Act
    GatewayCustomerDTO<PaymentResponseDTO> actualCustomerResult = (new PaymentResponseDTO(PaymentType.APPLE_PAY,
        PaymentGatewayType.PASSTHROUGH)).customer();

    // Assert
    PaymentResponseDTO paymentResponseDTO = actualCustomerResult.parent;
    PaymentType paymentType = paymentResponseDTO.getPaymentType();
    assertEquals("APPLE_PAY", paymentType.getType());
    assertEquals("Apple Pay", paymentType.getFriendlyType());
    PaymentGatewayType paymentGatewayType = paymentResponseDTO.getPaymentGatewayType();
    assertEquals("Passthrough Payment", paymentGatewayType.getFriendlyType());
    assertEquals("Passthrough", paymentGatewayType.getType());
    assertNull(actualCustomerResult.getCompanyName());
    assertNull(actualCustomerResult.getCustomerId());
    assertNull(actualCustomerResult.getEmail());
    assertNull(actualCustomerResult.getFax());
    assertNull(actualCustomerResult.getFirstName());
    assertNull(actualCustomerResult.getLastName());
    assertNull(actualCustomerResult.getMobile());
    assertNull(actualCustomerResult.getPhone());
    assertNull(actualCustomerResult.getWebsite());
    assertNull(paymentResponseDTO.getOrderId());
    assertNull(paymentResponseDTO.getPaymentToken());
    assertNull(paymentResponseDTO.getRawResponse());
    assertNull(paymentResponseDTO.getAmount());
    assertNull(paymentResponseDTO.getPaymentTransactionType());
    assertNull(paymentResponseDTO.getBillTo());
    assertNull(paymentResponseDTO.getShipTo());
    assertNull(paymentResponseDTO.getCreditCard());
    assertTrue(paymentResponseDTO.getCustomerCredits().isEmpty());
    assertTrue(paymentResponseDTO.getGiftCards().isEmpty());
    assertTrue(actualCustomerResult.getAdditionalFields().isEmpty());
    assertTrue(paymentResponseDTO.getResponseMap().isEmpty());
    assertTrue(paymentType.getIsFinalPayment());
    assertTrue(paymentType.isCreditCardType());
    assertTrue(paymentResponseDTO.isCompleteCheckoutOnCallback());
    assertTrue(paymentResponseDTO.isSuccessful());
    assertTrue(paymentResponseDTO.isValid());
    assertSame(actualCustomerResult, paymentResponseDTO.getCustomer());
  }

  /**
   * Method under test: {@link PaymentResponseDTO#creditCard()}
   */
  @Test
  public void testCreditCard() {
    // Arrange and Act
    CreditCardDTO<PaymentResponseDTO> actualCreditCardResult = (new PaymentResponseDTO(PaymentType.APPLE_PAY,
        PaymentGatewayType.PASSTHROUGH)).creditCard();

    // Assert
    PaymentResponseDTO paymentResponseDTO = actualCreditCardResult.parent;
    PaymentType paymentType = paymentResponseDTO.getPaymentType();
    assertEquals("APPLE_PAY", paymentType.getType());
    assertEquals("Apple Pay", paymentType.getFriendlyType());
    PaymentGatewayType paymentGatewayType = paymentResponseDTO.getPaymentGatewayType();
    assertEquals("Passthrough Payment", paymentGatewayType.getFriendlyType());
    assertEquals("Passthrough", paymentGatewayType.getType());
    assertNull(actualCreditCardResult.getCreditCardCvv());
    assertNull(actualCreditCardResult.getCreditCardExpDate());
    assertNull(actualCreditCardResult.getCreditCardExpMonth());
    assertNull(actualCreditCardResult.getCreditCardExpYear());
    assertNull(actualCreditCardResult.getCreditCardHolderName());
    assertNull(actualCreditCardResult.getCreditCardLastFour());
    assertNull(actualCreditCardResult.getCreditCardNum());
    assertNull(actualCreditCardResult.getCreditCardType());
    assertNull(paymentResponseDTO.getOrderId());
    assertNull(paymentResponseDTO.getPaymentToken());
    assertNull(paymentResponseDTO.getRawResponse());
    assertNull(paymentResponseDTO.getAmount());
    assertNull(paymentResponseDTO.getPaymentTransactionType());
    assertNull(paymentResponseDTO.getBillTo());
    assertNull(paymentResponseDTO.getShipTo());
    assertNull(paymentResponseDTO.getCustomer());
    assertTrue(paymentResponseDTO.getCustomerCredits().isEmpty());
    assertTrue(paymentResponseDTO.getGiftCards().isEmpty());
    assertTrue(actualCreditCardResult.getAdditionalFields().isEmpty());
    assertTrue(paymentResponseDTO.getResponseMap().isEmpty());
    assertTrue(paymentType.getIsFinalPayment());
    assertTrue(paymentType.isCreditCardType());
    assertTrue(paymentResponseDTO.isCompleteCheckoutOnCallback());
    assertTrue(paymentResponseDTO.isSuccessful());
    assertTrue(paymentResponseDTO.isValid());
    assertSame(actualCreditCardResult, paymentResponseDTO.getCreditCard());
  }

  /**
   * Method under test: {@link PaymentResponseDTO#shipTo()}
   */
  @Test
  public void testShipTo() {
    // Arrange and Act
    AddressDTO<PaymentResponseDTO> actualShipToResult = (new PaymentResponseDTO(PaymentType.APPLE_PAY,
        PaymentGatewayType.PASSTHROUGH)).shipTo();

    // Assert
    PaymentResponseDTO paymentResponseDTO = actualShipToResult.parent;
    PaymentType paymentType = paymentResponseDTO.getPaymentType();
    assertEquals("APPLE_PAY", paymentType.getType());
    assertEquals("Apple Pay", paymentType.getFriendlyType());
    PaymentGatewayType paymentGatewayType = paymentResponseDTO.getPaymentGatewayType();
    assertEquals("Passthrough Payment", paymentGatewayType.getFriendlyType());
    assertEquals("Passthrough", paymentGatewayType.getType());
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
    assertNull(paymentResponseDTO.getOrderId());
    assertNull(paymentResponseDTO.getPaymentToken());
    assertNull(paymentResponseDTO.getRawResponse());
    assertNull(paymentResponseDTO.getAmount());
    assertNull(paymentResponseDTO.getPaymentTransactionType());
    assertNull(paymentResponseDTO.getBillTo());
    assertNull(paymentResponseDTO.getCreditCard());
    assertNull(paymentResponseDTO.getCustomer());
    assertTrue(paymentResponseDTO.getCustomerCredits().isEmpty());
    assertTrue(paymentResponseDTO.getGiftCards().isEmpty());
    assertTrue(actualShipToResult.getAdditionalFields().isEmpty());
    assertTrue(paymentResponseDTO.getResponseMap().isEmpty());
    assertTrue(paymentType.getIsFinalPayment());
    assertTrue(paymentType.isCreditCardType());
    assertTrue(paymentResponseDTO.isCompleteCheckoutOnCallback());
    assertTrue(paymentResponseDTO.isSuccessful());
    assertTrue(paymentResponseDTO.isValid());
    assertSame(actualShipToResult, paymentResponseDTO.getShipTo());
  }

  /**
   * Method under test: {@link PaymentResponseDTO#billTo()}
   */
  @Test
  public void testBillTo() {
    // Arrange and Act
    AddressDTO<PaymentResponseDTO> actualBillToResult = (new PaymentResponseDTO(PaymentType.APPLE_PAY,
        PaymentGatewayType.PASSTHROUGH)).billTo();

    // Assert
    PaymentResponseDTO paymentResponseDTO = actualBillToResult.parent;
    PaymentType paymentType = paymentResponseDTO.getPaymentType();
    assertEquals("APPLE_PAY", paymentType.getType());
    assertEquals("Apple Pay", paymentType.getFriendlyType());
    PaymentGatewayType paymentGatewayType = paymentResponseDTO.getPaymentGatewayType();
    assertEquals("Passthrough Payment", paymentGatewayType.getFriendlyType());
    assertEquals("Passthrough", paymentGatewayType.getType());
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
    assertNull(paymentResponseDTO.getOrderId());
    assertNull(paymentResponseDTO.getPaymentToken());
    assertNull(paymentResponseDTO.getRawResponse());
    assertNull(paymentResponseDTO.getAmount());
    assertNull(paymentResponseDTO.getPaymentTransactionType());
    assertNull(paymentResponseDTO.getShipTo());
    assertNull(paymentResponseDTO.getCreditCard());
    assertNull(paymentResponseDTO.getCustomer());
    assertTrue(paymentResponseDTO.getCustomerCredits().isEmpty());
    assertTrue(paymentResponseDTO.getGiftCards().isEmpty());
    assertTrue(actualBillToResult.getAdditionalFields().isEmpty());
    assertTrue(paymentResponseDTO.getResponseMap().isEmpty());
    assertTrue(paymentType.getIsFinalPayment());
    assertTrue(paymentType.isCreditCardType());
    assertTrue(paymentResponseDTO.isCompleteCheckoutOnCallback());
    assertTrue(paymentResponseDTO.isSuccessful());
    assertTrue(paymentResponseDTO.isValid());
    assertSame(actualBillToResult, paymentResponseDTO.getBillTo());
  }

  /**
   * Method under test: {@link PaymentResponseDTO#giftCard()}
   */
  @Test
  public void testGiftCard() {
    // Arrange and Act
    GiftCardDTO<PaymentResponseDTO> actualGiftCardResult = (new PaymentResponseDTO(PaymentType.APPLE_PAY,
        PaymentGatewayType.PASSTHROUGH)).giftCard();

    // Assert
    PaymentResponseDTO paymentResponseDTO = actualGiftCardResult.parent;
    PaymentType paymentType = paymentResponseDTO.getPaymentType();
    assertEquals("APPLE_PAY", paymentType.getType());
    assertEquals("Apple Pay", paymentType.getFriendlyType());
    PaymentGatewayType paymentGatewayType = paymentResponseDTO.getPaymentGatewayType();
    assertEquals("Passthrough Payment", paymentGatewayType.getFriendlyType());
    assertEquals("Passthrough", paymentGatewayType.getType());
    assertNull(paymentResponseDTO.getOrderId());
    assertNull(paymentResponseDTO.getPaymentToken());
    assertNull(paymentResponseDTO.getRawResponse());
    assertNull(actualGiftCardResult.giftCardMasked);
    assertNull(actualGiftCardResult.giftCardNum);
    assertNull(paymentResponseDTO.getAmount());
    assertNull(paymentResponseDTO.getPaymentTransactionType());
    assertNull(paymentResponseDTO.getBillTo());
    assertNull(paymentResponseDTO.getShipTo());
    assertNull(paymentResponseDTO.getCreditCard());
    assertNull(paymentResponseDTO.getCustomer());
    List<GiftCardDTO<PaymentResponseDTO>> giftCards = paymentResponseDTO.getGiftCards();
    assertEquals(1, giftCards.size());
    assertTrue(paymentResponseDTO.getCustomerCredits().isEmpty());
    assertTrue(paymentResponseDTO.getResponseMap().isEmpty());
    assertTrue(actualGiftCardResult.additionalFields.isEmpty());
    assertTrue(paymentType.getIsFinalPayment());
    assertTrue(paymentType.isCreditCardType());
    assertTrue(paymentResponseDTO.isCompleteCheckoutOnCallback());
    assertTrue(paymentResponseDTO.isSuccessful());
    assertTrue(paymentResponseDTO.isValid());
    assertSame(actualGiftCardResult, giftCards.get(0));
  }

  /**
   * Method under test: {@link PaymentResponseDTO#customerCredit()}
   */
  @Test
  public void testCustomerCredit() {
    // Arrange and Act
    CustomerCreditDTO<PaymentResponseDTO> actualCustomerCreditResult = (new PaymentResponseDTO(PaymentType.APPLE_PAY,
        PaymentGatewayType.PASSTHROUGH)).customerCredit();

    // Assert
    PaymentResponseDTO paymentResponseDTO = actualCustomerCreditResult.parent;
    PaymentType paymentType = paymentResponseDTO.getPaymentType();
    assertEquals("APPLE_PAY", paymentType.getType());
    assertEquals("Apple Pay", paymentType.getFriendlyType());
    PaymentGatewayType paymentGatewayType = paymentResponseDTO.getPaymentGatewayType();
    assertEquals("Passthrough Payment", paymentGatewayType.getFriendlyType());
    assertEquals("Passthrough", paymentGatewayType.getType());
    assertNull(paymentResponseDTO.getOrderId());
    assertNull(paymentResponseDTO.getPaymentToken());
    assertNull(paymentResponseDTO.getRawResponse());
    assertNull(actualCustomerCreditResult.customerCreditAccountMasked);
    assertNull(actualCustomerCreditResult.customerCreditAccountNum);
    assertNull(paymentResponseDTO.getAmount());
    assertNull(paymentResponseDTO.getPaymentTransactionType());
    assertNull(paymentResponseDTO.getBillTo());
    assertNull(paymentResponseDTO.getShipTo());
    assertNull(paymentResponseDTO.getCreditCard());
    assertNull(paymentResponseDTO.getCustomer());
    List<CustomerCreditDTO<PaymentResponseDTO>> customerCredits = paymentResponseDTO.getCustomerCredits();
    assertEquals(1, customerCredits.size());
    assertTrue(paymentResponseDTO.getGiftCards().isEmpty());
    assertTrue(paymentResponseDTO.getResponseMap().isEmpty());
    assertTrue(actualCustomerCreditResult.additionalFields.isEmpty());
    assertTrue(paymentType.getIsFinalPayment());
    assertTrue(paymentType.isCreditCardType());
    assertTrue(paymentResponseDTO.isCompleteCheckoutOnCallback());
    assertTrue(paymentResponseDTO.isSuccessful());
    assertTrue(paymentResponseDTO.isValid());
    assertSame(actualCustomerCreditResult, customerCredits.get(0));
  }

  /**
   * Method under test: {@link PaymentResponseDTO#responseMap(String, String)}
   */
  @Test
  public void testResponseMap() {
    // Arrange, Act and Assert
    assertSame(paymentResponseDTO, paymentResponseDTO.responseMap("Key", "42"));
  }
}

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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.broadleafcommerce.common.payment.PaymentTransactionType;
import org.broadleafcommerce.common.payment.PaymentType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {PaymentResponseDTO.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class PaymentResponseDTODiffblueTest {
  @MockBean private PaymentGatewayType paymentGatewayType;

  @Autowired private PaymentResponseDTO paymentResponseDTO;

  @MockBean private PaymentType paymentType;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentResponseDTO#PaymentResponseDTO(PaymentType, PaymentGatewayType)}
   *   <li>{@link PaymentResponseDTO#amount(Money)}
   *   <li>{@link PaymentResponseDTO#completeCheckoutOnCallback(boolean)}
   *   <li>{@link PaymentResponseDTO#orderId(String)}
   *   <li>{@link PaymentResponseDTO#paymentToken(String)}
   *   <li>{@link PaymentResponseDTO#paymentTransactionType(PaymentTransactionType)}
   *   <li>{@link PaymentResponseDTO#rawResponse(String)}
   *   <li>{@link PaymentResponseDTO#successful(boolean)}
   *   <li>{@link PaymentResponseDTO#valid(boolean)}
   *   <li>{@link PaymentResponseDTO#getAmount()}
   *   <li>{@link PaymentResponseDTO#getBillTo()}
   *   <li>{@link PaymentResponseDTO#getCreditCard()}
   *   <li>{@link PaymentResponseDTO#getCustomer()}
   *   <li>{@link PaymentResponseDTO#getCustomerCredits()}
   *   <li>{@link PaymentResponseDTO#getGiftCards()}
   *   <li>{@link PaymentResponseDTO#getOrderId()}
   *   <li>{@link PaymentResponseDTO#getPaymentGatewayType()}
   *   <li>{@link PaymentResponseDTO#getPaymentToken()}
   *   <li>{@link PaymentResponseDTO#getPaymentTransactionType()}
   *   <li>{@link PaymentResponseDTO#getPaymentType()}
   *   <li>{@link PaymentResponseDTO#getRawResponse()}
   *   <li>{@link PaymentResponseDTO#getResponseMap()}
   *   <li>{@link PaymentResponseDTO#getShipTo()}
   *   <li>{@link PaymentResponseDTO#isCompleteCheckoutOnCallback()}
   *   <li>{@link PaymentResponseDTO#isSuccessful()}
   *   <li>{@link PaymentResponseDTO#isValid()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTO.<init>(PaymentType, PaymentGatewayType)",
    "PaymentResponseDTO PaymentResponseDTO.amount(Money)",
    "PaymentResponseDTO PaymentResponseDTO.completeCheckoutOnCallback(boolean)",
    "Money PaymentResponseDTO.getAmount()",
    "AddressDTO PaymentResponseDTO.getBillTo()",
    "CreditCardDTO PaymentResponseDTO.getCreditCard()",
    "GatewayCustomerDTO PaymentResponseDTO.getCustomer()",
    "List PaymentResponseDTO.getCustomerCredits()",
    "List PaymentResponseDTO.getGiftCards()",
    "String PaymentResponseDTO.getOrderId()",
    "PaymentGatewayType PaymentResponseDTO.getPaymentGatewayType()",
    "String PaymentResponseDTO.getPaymentToken()",
    "PaymentTransactionType PaymentResponseDTO.getPaymentTransactionType()",
    "PaymentType PaymentResponseDTO.getPaymentType()",
    "String PaymentResponseDTO.getRawResponse()",
    "java.util.Map PaymentResponseDTO.getResponseMap()",
    "AddressDTO PaymentResponseDTO.getShipTo()",
    "boolean PaymentResponseDTO.isCompleteCheckoutOnCallback()",
    "boolean PaymentResponseDTO.isSuccessful()",
    "boolean PaymentResponseDTO.isValid()",
    "PaymentResponseDTO PaymentResponseDTO.orderId(String)",
    "PaymentResponseDTO PaymentResponseDTO.paymentToken(String)",
    "PaymentResponseDTO PaymentResponseDTO.paymentTransactionType(PaymentTransactionType)",
    "PaymentResponseDTO PaymentResponseDTO.rawResponse(String)",
    "PaymentResponseDTO PaymentResponseDTO.successful(boolean)",
    "PaymentResponseDTO PaymentResponseDTO.valid(boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    PaymentResponseDTO actualPaymentResponseDTO =
        new PaymentResponseDTO(PaymentType.APPLE_PAY, PaymentGatewayType.PASSTHROUGH);
    PaymentResponseDTO actualAmountResult = actualPaymentResponseDTO.amount(Money.ZERO);
    PaymentResponseDTO actualCompleteCheckoutOnCallbackResult =
        actualPaymentResponseDTO.completeCheckoutOnCallback(true);
    PaymentResponseDTO actualOrderIdResult = actualPaymentResponseDTO.orderId("42");
    PaymentResponseDTO actualPaymentTokenResult = actualPaymentResponseDTO.paymentToken("ABC123");
    PaymentResponseDTO actualPaymentTransactionTypeResult =
        actualPaymentResponseDTO.paymentTransactionType(PaymentTransactionType.AUTHORIZE);
    PaymentResponseDTO actualRawResponseResult =
        actualPaymentResponseDTO.rawResponse("Raw Response");
    PaymentResponseDTO actualSuccessfulResult = actualPaymentResponseDTO.successful(true);
    PaymentResponseDTO actualValidResult = actualPaymentResponseDTO.valid(true);
    Money actualAmount = actualPaymentResponseDTO.getAmount();
    AddressDTO<PaymentResponseDTO> actualBillTo = actualPaymentResponseDTO.getBillTo();
    CreditCardDTO<PaymentResponseDTO> actualCreditCard = actualPaymentResponseDTO.getCreditCard();
    GatewayCustomerDTO<PaymentResponseDTO> actualCustomer = actualPaymentResponseDTO.getCustomer();
    List<CustomerCreditDTO<PaymentResponseDTO>> actualCustomerCredits =
        actualPaymentResponseDTO.getCustomerCredits();
    List<GiftCardDTO<PaymentResponseDTO>> actualGiftCards = actualPaymentResponseDTO.getGiftCards();
    String actualOrderId = actualPaymentResponseDTO.getOrderId();
    PaymentGatewayType actualPaymentGatewayType = actualPaymentResponseDTO.getPaymentGatewayType();
    String actualPaymentToken = actualPaymentResponseDTO.getPaymentToken();
    PaymentTransactionType actualPaymentTransactionType =
        actualPaymentResponseDTO.getPaymentTransactionType();
    PaymentType actualPaymentType = actualPaymentResponseDTO.getPaymentType();
    String actualRawResponse = actualPaymentResponseDTO.getRawResponse();
    actualPaymentResponseDTO.getResponseMap();
    AddressDTO<PaymentResponseDTO> actualShipTo = actualPaymentResponseDTO.getShipTo();
    boolean actualIsCompleteCheckoutOnCallbackResult =
        actualPaymentResponseDTO.isCompleteCheckoutOnCallback();
    boolean actualIsSuccessfulResult = actualPaymentResponseDTO.isSuccessful();

    // Assert
    assertEquals("42", actualOrderId);
    assertEquals("ABC123", actualPaymentToken);
    assertEquals("Raw Response", actualRawResponse);
    assertNull(actualBillTo);
    assertNull(actualShipTo);
    assertNull(actualCreditCard);
    assertNull(actualCustomer);
    assertTrue(actualIsCompleteCheckoutOnCallbackResult);
    assertTrue(actualIsSuccessfulResult);
    assertTrue(actualPaymentResponseDTO.isValid());
    assertEquals(actualCustomerCredits, actualGiftCards);
    assertSame(actualPaymentResponseDTO, actualAmountResult);
    assertSame(actualPaymentResponseDTO, actualCompleteCheckoutOnCallbackResult);
    assertSame(actualPaymentResponseDTO, actualOrderIdResult);
    assertSame(actualPaymentResponseDTO, actualPaymentTokenResult);
    assertSame(actualPaymentResponseDTO, actualPaymentTransactionTypeResult);
    assertSame(actualPaymentResponseDTO, actualRawResponseResult);
    assertSame(actualPaymentResponseDTO, actualSuccessfulResult);
    assertSame(actualPaymentResponseDTO, actualValidResult);
    assertSame(Money.ZERO, actualAmount);
    assertSame(PaymentGatewayType.PASSTHROUGH, actualPaymentGatewayType);
    assertSame(PaymentTransactionType.AUTHORIZE, actualPaymentTransactionType);
    assertSame(PaymentType.APPLE_PAY, actualPaymentType);
  }

  /**
   * Test {@link PaymentResponseDTO#customer()}.
   *
   * <p>Method under test: {@link PaymentResponseDTO#customer()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"GatewayCustomerDTO PaymentResponseDTO.customer()"})
  public void testCustomer() {
    // Arrange and Act
    GatewayCustomerDTO<PaymentResponseDTO> actualCustomerResult =
        new PaymentResponseDTO(PaymentType.APPLE_PAY, PaymentGatewayType.PASSTHROUGH).customer();

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
   * Test {@link PaymentResponseDTO#creditCard()}.
   *
   * <p>Method under test: {@link PaymentResponseDTO#creditCard()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CreditCardDTO PaymentResponseDTO.creditCard()"})
  public void testCreditCard() {
    // Arrange and Act
    CreditCardDTO<PaymentResponseDTO> actualCreditCardResult =
        new PaymentResponseDTO(PaymentType.APPLE_PAY, PaymentGatewayType.PASSTHROUGH).creditCard();

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
   * Test {@link PaymentResponseDTO#shipTo()}.
   *
   * <p>Method under test: {@link PaymentResponseDTO#shipTo()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AddressDTO PaymentResponseDTO.shipTo()"})
  public void testShipTo() {
    // Arrange and Act
    AddressDTO<PaymentResponseDTO> actualShipToResult =
        new PaymentResponseDTO(PaymentType.APPLE_PAY, PaymentGatewayType.PASSTHROUGH).shipTo();

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
   * Test {@link PaymentResponseDTO#billTo()}.
   *
   * <p>Method under test: {@link PaymentResponseDTO#billTo()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AddressDTO PaymentResponseDTO.billTo()"})
  public void testBillTo() {
    // Arrange and Act
    AddressDTO<PaymentResponseDTO> actualBillToResult =
        new PaymentResponseDTO(PaymentType.APPLE_PAY, PaymentGatewayType.PASSTHROUGH).billTo();

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
   * Test {@link PaymentResponseDTO#giftCard()}.
   *
   * <p>Method under test: {@link PaymentResponseDTO#giftCard()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"GiftCardDTO PaymentResponseDTO.giftCard()"})
  public void testGiftCard() {
    // Arrange and Act
    GiftCardDTO<PaymentResponseDTO> actualGiftCardResult =
        new PaymentResponseDTO(PaymentType.APPLE_PAY, PaymentGatewayType.PASSTHROUGH).giftCard();

    // Assert
    PaymentResponseDTO paymentResponseDTO = actualGiftCardResult.parent;
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
    assertEquals(1, paymentResponseDTO.getGiftCards().size());
    assertTrue(paymentResponseDTO.getCustomerCredits().isEmpty());
    assertTrue(paymentResponseDTO.getResponseMap().isEmpty());
    assertTrue(actualGiftCardResult.additionalFields.isEmpty());
    assertTrue(paymentResponseDTO.isCompleteCheckoutOnCallback());
    assertTrue(paymentResponseDTO.isSuccessful());
    assertTrue(paymentResponseDTO.isValid());
  }

  /**
   * Test {@link PaymentResponseDTO#customerCredit()}.
   *
   * <p>Method under test: {@link PaymentResponseDTO#customerCredit()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CustomerCreditDTO PaymentResponseDTO.customerCredit()"})
  public void testCustomerCredit() {
    // Arrange and Act
    CustomerCreditDTO<PaymentResponseDTO> actualCustomerCreditResult =
        new PaymentResponseDTO(PaymentType.APPLE_PAY, PaymentGatewayType.PASSTHROUGH)
            .customerCredit();

    // Assert
    PaymentResponseDTO paymentResponseDTO = actualCustomerCreditResult.parent;
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
    assertEquals(1, paymentResponseDTO.getCustomerCredits().size());
    assertTrue(paymentResponseDTO.getGiftCards().isEmpty());
    assertTrue(paymentResponseDTO.getResponseMap().isEmpty());
    assertTrue(actualCustomerCreditResult.additionalFields.isEmpty());
    assertTrue(paymentResponseDTO.isCompleteCheckoutOnCallback());
    assertTrue(paymentResponseDTO.isSuccessful());
    assertTrue(paymentResponseDTO.isValid());
  }

  /**
   * Test {@link PaymentResponseDTO#responseMap(String, String)}.
   *
   * <p>Method under test: {@link PaymentResponseDTO#responseMap(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PaymentResponseDTO PaymentResponseDTO.responseMap(String, String)"})
  public void testResponseMap() {
    // Arrange and Act
    PaymentResponseDTO actualResponseMapResult = paymentResponseDTO.responseMap("Key", "42");

    // Assert
    assertSame(paymentResponseDTO, actualResponseMapResult);
  }
}

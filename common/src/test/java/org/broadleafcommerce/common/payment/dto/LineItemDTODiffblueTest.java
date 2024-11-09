/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.payment.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.Map;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {LineItemDTO.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class LineItemDTODiffblueTest {
  @Autowired
  private LineItemDTO lineItemDTO;

  @MockBean
  private PaymentRequestDTO paymentRequestDTO;

  /**
   * Test {@link LineItemDTO#done()}.
   * <ul>
   *   <li>Then return {@link LineItemDTO#LineItemDTO(PaymentRequestDTO)} with
   * parent is {@link PaymentRequestDTO} (default constructor)
   * {@link LineItemDTO#parent}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LineItemDTO#done()}
   */
  @Test
  public void testDone_thenReturnLineItemDTOWithParentIsPaymentRequestDTOParent() {
    // Arrange
    LineItemDTO lineItemDTO = new LineItemDTO(new PaymentRequestDTO());

    // Act and Assert
    assertSame(lineItemDTO.parent, lineItemDTO.done());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LineItemDTO#LineItemDTO(PaymentRequestDTO)}
   *   <li>{@link LineItemDTO#amount(String)}
   *   <li>{@link LineItemDTO#category(String)}
   *   <li>{@link LineItemDTO#description(String)}
   *   <li>{@link LineItemDTO#itemTotal(String)}
   *   <li>{@link LineItemDTO#name(String)}
   *   <li>{@link LineItemDTO#quantity(String)}
   *   <li>{@link LineItemDTO#shortDescription(String)}
   *   <li>{@link LineItemDTO#systemId(String)}
   *   <li>{@link LineItemDTO#tax(String)}
   *   <li>{@link LineItemDTO#total(String)}
   *   <li>{@link LineItemDTO#getAdditionalFields()}
   *   <li>{@link LineItemDTO#getAmount()}
   *   <li>{@link LineItemDTO#getCategory()}
   *   <li>{@link LineItemDTO#getDescription()}
   *   <li>{@link LineItemDTO#getItemTotal()}
   *   <li>{@link LineItemDTO#getName()}
   *   <li>{@link LineItemDTO#getQuantity()}
   *   <li>{@link LineItemDTO#getShortDescription()}
   *   <li>{@link LineItemDTO#getSystemId()}
   *   <li>{@link LineItemDTO#getTax()}
   *   <li>{@link LineItemDTO#getTotal()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    LineItemDTO actualLineItemDTO = new LineItemDTO(new PaymentRequestDTO());
    LineItemDTO actualAmountResult = actualLineItemDTO.amount("10");
    LineItemDTO actualCategoryResult = actualLineItemDTO.category("Category");
    LineItemDTO actualDescriptionResult = actualLineItemDTO.description("The characteristics of someone or something");
    LineItemDTO actualItemTotalResult = actualLineItemDTO.itemTotal("Item Total");
    LineItemDTO actualNameResult = actualLineItemDTO.name("Name");
    LineItemDTO actualQuantityResult = actualLineItemDTO.quantity("Quantity");
    LineItemDTO actualShortDescriptionResult = actualLineItemDTO.shortDescription("Short Description");
    LineItemDTO actualSystemIdResult = actualLineItemDTO.systemId("42");
    LineItemDTO actualTaxResult = actualLineItemDTO.tax("Tax");
    LineItemDTO actualTotalResult = actualLineItemDTO.total("Total");
    Map<String, Object> actualAdditionalFields = actualLineItemDTO.getAdditionalFields();
    String actualAmount = actualLineItemDTO.getAmount();
    String actualCategory = actualLineItemDTO.getCategory();
    String actualDescription = actualLineItemDTO.getDescription();
    String actualItemTotal = actualLineItemDTO.getItemTotal();
    String actualName = actualLineItemDTO.getName();
    String actualQuantity = actualLineItemDTO.getQuantity();
    String actualShortDescription = actualLineItemDTO.getShortDescription();
    String actualSystemId = actualLineItemDTO.getSystemId();
    String actualTax = actualLineItemDTO.getTax();

    // Assert
    assertEquals("10", actualAmount);
    assertEquals("42", actualSystemId);
    assertEquals("Category", actualCategory);
    assertEquals("Item Total", actualItemTotal);
    assertEquals("Name", actualName);
    assertEquals("Quantity", actualQuantity);
    assertEquals("Short Description", actualShortDescription);
    assertEquals("Tax", actualTax);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals("Total", actualLineItemDTO.getTotal());
    PaymentRequestDTO paymentRequestDTO = actualLineItemDTO.parent;
    assertNull(paymentRequestDTO.getOrderCurrencyCode());
    assertNull(paymentRequestDTO.getOrderDescription());
    assertNull(paymentRequestDTO.getOrderId());
    assertNull(paymentRequestDTO.getOrderSubtotal());
    assertNull(paymentRequestDTO.getShippingTotal());
    assertNull(paymentRequestDTO.getTaxTotal());
    assertNull(paymentRequestDTO.getTransactionTotal());
    assertNull(paymentRequestDTO.getGatewayRequestType());
    assertNull(paymentRequestDTO.getPaymentType());
    assertNull(paymentRequestDTO.getBillTo());
    assertNull(paymentRequestDTO.getShipTo());
    assertNull(paymentRequestDTO.getCreditCard());
    assertNull(paymentRequestDTO.getCustomer());
    assertNull(paymentRequestDTO.getSubscription());
    assertTrue(paymentRequestDTO.getCustomerCredits().isEmpty());
    assertTrue(paymentRequestDTO.getGiftCards().isEmpty());
    assertTrue(paymentRequestDTO.getLineItems().isEmpty());
    assertTrue(actualAdditionalFields.isEmpty());
    assertTrue(paymentRequestDTO.getAdditionalFields().isEmpty());
    assertTrue(paymentRequestDTO.isCompleteCheckoutOnCallback());
    assertSame(actualLineItemDTO, actualAmountResult);
    assertSame(actualLineItemDTO, actualCategoryResult);
    assertSame(actualLineItemDTO, actualDescriptionResult);
    assertSame(actualLineItemDTO, actualItemTotalResult);
    assertSame(actualLineItemDTO, actualNameResult);
    assertSame(actualLineItemDTO, actualQuantityResult);
    assertSame(actualLineItemDTO, actualShortDescriptionResult);
    assertSame(actualLineItemDTO, actualSystemIdResult);
    assertSame(actualLineItemDTO, actualTaxResult);
    assertSame(actualLineItemDTO, actualTotalResult);
  }

  /**
   * Test {@link LineItemDTO#additionalField(String, Object)}.
   * <p>
   * Method under test: {@link LineItemDTO#additionalField(String, Object)}
   */
  @Test
  public void testAdditionalField() {
    // Arrange, Act and Assert
    assertSame(lineItemDTO, lineItemDTO.additionalField("Key", BLCFieldUtils.NULL_FIELD));
  }
}

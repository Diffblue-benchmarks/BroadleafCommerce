package org.broadleafcommerce.common.payment.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {LineItemDTO.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class LineItemDTODiffblueTest {
  @Autowired private LineItemDTO lineItemDTO;

  @MockBean private PaymentRequestDTO paymentRequestDTO;

  /**
   * Test {@link LineItemDTO#done()}.
   *
   * <ul>
   *   <li>Then return {@link LineItemDTO#LineItemDTO(PaymentRequestDTO)} with parent is {@link
   *       PaymentRequestDTO} (default constructor) {@link LineItemDTO#parent}.
   * </ul>
   *
   * <p>Method under test: {@link LineItemDTO#done()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PaymentRequestDTO LineItemDTO.done()"})
  public void testDone_thenReturnLineItemDTOWithParentIsPaymentRequestDTOParent() {
    // Arrange
    LineItemDTO lineItemDTO = new LineItemDTO(new PaymentRequestDTO());

    // Act
    PaymentRequestDTO actualDoneResult = lineItemDTO.done();

    // Assert
    assertSame(lineItemDTO.parent, actualDoneResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LineItemDTO.<init>(PaymentRequestDTO)",
    "LineItemDTO LineItemDTO.amount(String)",
    "LineItemDTO LineItemDTO.category(String)",
    "LineItemDTO LineItemDTO.description(String)",
    "Map LineItemDTO.getAdditionalFields()",
    "String LineItemDTO.getAmount()",
    "String LineItemDTO.getCategory()",
    "String LineItemDTO.getDescription()",
    "String LineItemDTO.getItemTotal()",
    "String LineItemDTO.getName()",
    "String LineItemDTO.getQuantity()",
    "String LineItemDTO.getShortDescription()",
    "String LineItemDTO.getSystemId()",
    "String LineItemDTO.getTax()",
    "String LineItemDTO.getTotal()",
    "LineItemDTO LineItemDTO.itemTotal(String)",
    "LineItemDTO LineItemDTO.name(String)",
    "LineItemDTO LineItemDTO.quantity(String)",
    "LineItemDTO LineItemDTO.shortDescription(String)",
    "LineItemDTO LineItemDTO.systemId(String)",
    "LineItemDTO LineItemDTO.tax(String)",
    "LineItemDTO LineItemDTO.total(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    LineItemDTO actualLineItemDTO = new LineItemDTO(new PaymentRequestDTO());
    LineItemDTO actualAmountResult = actualLineItemDTO.amount("10");
    LineItemDTO actualCategoryResult = actualLineItemDTO.category("Category");
    LineItemDTO actualDescriptionResult =
        actualLineItemDTO.description("The characteristics of someone or something");
    LineItemDTO actualItemTotalResult = actualLineItemDTO.itemTotal("Item Total");
    LineItemDTO actualNameResult = actualLineItemDTO.name("Name");
    LineItemDTO actualQuantityResult = actualLineItemDTO.quantity("Quantity");
    LineItemDTO actualShortDescriptionResult =
        actualLineItemDTO.shortDescription("Short Description");
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
   *
   * <p>Method under test: {@link LineItemDTO#additionalField(String, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LineItemDTO LineItemDTO.additionalField(String, Object)"})
  public void testAdditionalField() {
    // Arrange and Act
    LineItemDTO actualAdditionalFieldResult =
        lineItemDTO.additionalField("Key", BLCFieldUtils.NULL_FIELD);

    // Assert
    assertSame(lineItemDTO, actualAdditionalFieldResult);
  }
}

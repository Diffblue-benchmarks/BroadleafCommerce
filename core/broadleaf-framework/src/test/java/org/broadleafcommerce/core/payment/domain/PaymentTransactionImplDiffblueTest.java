package org.broadleafcommerce.core.payment.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class PaymentTransactionImplDiffblueTest {
  @Autowired private PaymentTransactionImpl paymentTransactionImpl;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentTransactionImpl#setAdditionalFields(Map)}
   *   <li>{@link PaymentTransactionImpl#setCustomerIpAddress(String)}
   *   <li>{@link PaymentTransactionImpl#setDate(Date)}
   *   <li>{@link PaymentTransactionImpl#setId(Long)}
   *   <li>{@link PaymentTransactionImpl#setOrderPayment(OrderPayment)}
   *   <li>{@link PaymentTransactionImpl#setParentTransaction(PaymentTransaction)}
   *   <li>{@link PaymentTransactionImpl#setRawResponse(String)}
   *   <li>{@link PaymentTransactionImpl#setSuccess(Boolean)}
   *   <li>{@link PaymentTransactionImpl#getAdditionalFields()}
   *   <li>{@link PaymentTransactionImpl#getCustomerIpAddress()}
   *   <li>{@link PaymentTransactionImpl#getDate()}
   *   <li>{@link PaymentTransactionImpl#getId()}
   *   <li>{@link PaymentTransactionImpl#getParentTransaction()}
   *   <li>{@link PaymentTransactionImpl#getRawResponse()}
   *   <li>{@link PaymentTransactionImpl#getSuccess()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map PaymentTransactionImpl.getAdditionalFields()",
    "String PaymentTransactionImpl.getCustomerIpAddress()",
    "Date PaymentTransactionImpl.getDate()",
    "Long PaymentTransactionImpl.getId()",
    "PaymentTransaction PaymentTransactionImpl.getParentTransaction()",
    "String PaymentTransactionImpl.getRawResponse()",
    "Boolean PaymentTransactionImpl.getSuccess()",
    "void PaymentTransactionImpl.setAdditionalFields(Map)",
    "void PaymentTransactionImpl.setCustomerIpAddress(String)",
    "void PaymentTransactionImpl.setDate(Date)",
    "void PaymentTransactionImpl.setId(Long)",
    "void PaymentTransactionImpl.setOrderPayment(OrderPayment)",
    "void PaymentTransactionImpl.setParentTransaction(PaymentTransaction)",
    "void PaymentTransactionImpl.setRawResponse(String)",
    "void PaymentTransactionImpl.setSuccess(Boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = new PaymentTransactionImpl();
    HashMap<String, String> additionalFields = new HashMap<>();

    // Act
    paymentTransactionImpl.setAdditionalFields(additionalFields);
    paymentTransactionImpl.setCustomerIpAddress("42 Main St");
    Date date =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    paymentTransactionImpl.setDate(date);
    paymentTransactionImpl.setId(1L);
    paymentTransactionImpl.setOrderPayment(new OrderPaymentImpl());
    PaymentTransactionImpl parentTransaction = new PaymentTransactionImpl();
    paymentTransactionImpl.setParentTransaction(parentTransaction);
    paymentTransactionImpl.setRawResponse("Raw Response");
    paymentTransactionImpl.setSuccess(true);
    Map<String, String> actualAdditionalFields = paymentTransactionImpl.getAdditionalFields();
    String actualCustomerIpAddress = paymentTransactionImpl.getCustomerIpAddress();
    Date actualDate = paymentTransactionImpl.getDate();
    Long actualId = paymentTransactionImpl.getId();
    PaymentTransaction actualParentTransaction = paymentTransactionImpl.getParentTransaction();
    String actualRawResponse = paymentTransactionImpl.getRawResponse();
    Boolean actualSuccess = paymentTransactionImpl.getSuccess();

    // Assert
    assertEquals("42 Main St", actualCustomerIpAddress);
    assertEquals("Raw Response", actualRawResponse);
    assertEquals(1L, actualId.longValue());
    assertTrue(actualAdditionalFields.isEmpty());
    assertTrue(actualSuccess);
    assertSame(additionalFields, actualAdditionalFields);
    assertSame(parentTransaction, actualParentTransaction);
    assertSame(date, actualDate);
  }

  /**
   * Test new {@link PaymentTransactionImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link PaymentTransactionImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaymentTransactionImpl.<init>()"})
  public void testNewPaymentTransactionImpl() {
    // Arrange and Act
    PaymentTransactionImpl actualPaymentTransactionImpl = new PaymentTransactionImpl();

    // Assert
    assertEquals('N', actualPaymentTransactionImpl.getArchived().charValue());
    assertNull(actualPaymentTransactionImpl.getId());
    assertNull(actualPaymentTransactionImpl.getCustomerIpAddress());
    assertNull(actualPaymentTransactionImpl.getRawResponse());
    assertNull(actualPaymentTransactionImpl.type);
    assertNull(actualPaymentTransactionImpl.amount);
    assertNull(actualPaymentTransactionImpl.getDate());
    assertNull(actualPaymentTransactionImpl.getType());
    assertNull(actualPaymentTransactionImpl.getOrderPayment());
    assertNull(actualPaymentTransactionImpl.orderPayment);
    assertNull(actualPaymentTransactionImpl.getParentTransaction());
    assertFalse(actualPaymentTransactionImpl.saveToken);
    assertTrue(actualPaymentTransactionImpl.getAdditionalFields().isEmpty());
    assertTrue(actualPaymentTransactionImpl.getSuccess());
  }
}

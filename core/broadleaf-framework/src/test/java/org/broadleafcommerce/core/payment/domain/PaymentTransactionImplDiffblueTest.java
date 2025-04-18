/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.payment.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.payment.PaymentTransactionType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class PaymentTransactionImplDiffblueTest {
  @Autowired
  private PaymentTransactionImpl paymentTransactionImpl;

  /**
   * Test {@link PaymentTransactionImpl#getOrderPayment()}.
   * <ul>
   *   <li>Given {@link PaymentTransactionImpl} (default constructor) OrderPayment is {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentTransactionImpl#getOrderPayment()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderPayment PaymentTransactionImpl.getOrderPayment()"})
  public void testGetOrderPayment_givenPaymentTransactionImplOrderPaymentIsNull_thenReturnNull() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl2 = new PaymentTransactionImpl();
    paymentTransactionImpl2.setAdditionalFields(new HashMap<>());
    paymentTransactionImpl2.setAmount(new Money());
    paymentTransactionImpl2.setCustomerIpAddress("42 Main St");
    paymentTransactionImpl2
        .setDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentTransactionImpl2.setId(1L);
    paymentTransactionImpl2.setRawResponse("Raw Response");
    paymentTransactionImpl2.setSaveToken(true);
    paymentTransactionImpl2.setSuccess(true);
    paymentTransactionImpl2.setType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentTransactionImpl2.setOrderPayment(null);
    paymentTransactionImpl2.setParentTransaction(new PaymentTransactionImpl());

    // Act and Assert
    assertNull(paymentTransactionImpl2.getOrderPayment());
  }

  /**
   * Test {@link PaymentTransactionImpl#getOrderPayment()}.
   * <ul>
   *   <li>Given {@link PaymentTransactionImpl} (default constructor) OrderPayment is {@link OrderPaymentImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentTransactionImpl#getOrderPayment()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderPayment PaymentTransactionImpl.getOrderPayment()"})
  public void testGetOrderPayment_givenPaymentTransactionImplOrderPaymentIsOrderPaymentImpl() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl2 = new PaymentTransactionImpl();
    paymentTransactionImpl2.setAdditionalFields(new HashMap<>());
    paymentTransactionImpl2.setAmount(new Money());
    paymentTransactionImpl2.setCustomerIpAddress("42 Main St");
    paymentTransactionImpl2
        .setDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentTransactionImpl2.setId(1L);
    paymentTransactionImpl2.setRawResponse("Raw Response");
    paymentTransactionImpl2.setSaveToken(true);
    paymentTransactionImpl2.setSuccess(true);
    paymentTransactionImpl2.setType(new PaymentTransactionType("Type", "Friendly Type"));
    OrderPaymentImpl orderPayment = new OrderPaymentImpl();
    paymentTransactionImpl2.setOrderPayment(orderPayment);
    paymentTransactionImpl2.setParentTransaction(null);

    // Act and Assert
    assertSame(orderPayment, paymentTransactionImpl2.getOrderPayment());
  }

  /**
   * Test {@link PaymentTransactionImpl#getOrderPayment()}.
   * <ul>
   *   <li>Given {@link PaymentTransactionImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentTransactionImpl#getOrderPayment()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderPayment PaymentTransactionImpl.getOrderPayment()"})
  public void testGetOrderPayment_givenPaymentTransactionImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PaymentTransactionImpl()).getOrderPayment());
  }

  /**
   * Test {@link PaymentTransactionImpl#getOrderPayment()}.
   * <ul>
   *   <li>Then calls {@link PaymentTransaction#getOrderPayment()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentTransactionImpl#getOrderPayment()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderPayment PaymentTransactionImpl.getOrderPayment()"})
  public void testGetOrderPayment_thenCallsGetOrderPayment() {
    // Arrange
    PaymentTransaction parentTransaction = mock(PaymentTransaction.class);
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    when(parentTransaction.getOrderPayment()).thenReturn(orderPaymentImpl);

    PaymentTransactionImpl paymentTransactionImpl2 = new PaymentTransactionImpl();
    paymentTransactionImpl2.setParentTransaction(parentTransaction);

    // Act
    OrderPayment actualOrderPayment = paymentTransactionImpl2.getOrderPayment();

    // Assert
    verify(parentTransaction).getOrderPayment();
    assertSame(orderPaymentImpl, actualOrderPayment);
  }

  /**
   * Test {@link PaymentTransactionImpl#setType(PaymentTransactionType)}.
   * <p>
   * Method under test: {@link PaymentTransactionImpl#setType(PaymentTransactionType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PaymentTransactionImpl.setType(PaymentTransactionType)"})
  public void testSetType() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl2 = new PaymentTransactionImpl();
    PaymentTransactionType type = new PaymentTransactionType("Type", "Friendly Type");

    // Act
    paymentTransactionImpl2.setType(type);

    // Assert
    assertEquals("Type", paymentTransactionImpl2.type);
    assertEquals(type, paymentTransactionImpl2.getType());
  }

  /**
   * Test {@link PaymentTransactionImpl#setType(PaymentTransactionType)}.
   * <ul>
   *   <li>Given {@code Type}.</li>
   *   <li>Then {@link PaymentTransactionImpl} (default constructor) Type Type is {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentTransactionImpl#setType(PaymentTransactionType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PaymentTransactionImpl.setType(PaymentTransactionType)"})
  public void testSetType_givenType_thenPaymentTransactionImplTypeTypeIsType() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl2 = new PaymentTransactionImpl();
    PaymentTransactionType type = mock(PaymentTransactionType.class);
    when(type.getType()).thenReturn("Type");

    // Act
    paymentTransactionImpl2.setType(type);

    // Assert
    verify(type).getType();
    assertEquals("Type", paymentTransactionImpl2.getType().getType());
    assertEquals("Type", paymentTransactionImpl2.type);
  }

  /**
   * Test {@link PaymentTransactionImpl#getAmount()}.
   * <ul>
   *   <li>Given {@link PaymentTransactionImpl} (default constructor) Amount is {@link Money#Money()}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentTransactionImpl#getAmount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money PaymentTransactionImpl.getAmount()"})
  public void testGetAmount_givenPaymentTransactionImplAmountIsMoney_thenReturnMoney() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl2 = new PaymentTransactionImpl();
    paymentTransactionImpl2.setAdditionalFields(new HashMap<>());
    paymentTransactionImpl2.setCustomerIpAddress("42 Main St");
    paymentTransactionImpl2
        .setDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentTransactionImpl2.setId(1L);
    paymentTransactionImpl2.setRawResponse("Raw Response");
    paymentTransactionImpl2.setSaveToken(true);
    paymentTransactionImpl2.setSuccess(true);
    paymentTransactionImpl2.setType(new PaymentTransactionType("Type", "Friendly Type"));
    Money amount = new Money();
    paymentTransactionImpl2.setAmount(amount);
    paymentTransactionImpl2.setOrderPayment(new OrderPaymentImpl());
    paymentTransactionImpl2.setParentTransaction(null);

    // Act and Assert
    assertEquals(amount, paymentTransactionImpl2.getAmount());
  }

  /**
   * Test {@link PaymentTransactionImpl#getAmount()}.
   * <ul>
   *   <li>Then {@link PaymentTransactionImpl} (default constructor) {@link PaymentTransactionImpl#orderPayment} {@link OrderPaymentImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentTransactionImpl#getAmount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money PaymentTransactionImpl.getAmount()"})
  public void testGetAmount_thenPaymentTransactionImplOrderPaymentOrderPaymentImpl() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl2 = new PaymentTransactionImpl();
    paymentTransactionImpl2.setAdditionalFields(new HashMap<>());
    paymentTransactionImpl2.setCustomerIpAddress("42 Main St");
    paymentTransactionImpl2
        .setDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentTransactionImpl2.setId(1L);
    paymentTransactionImpl2.setRawResponse("Raw Response");
    paymentTransactionImpl2.setSaveToken(true);
    paymentTransactionImpl2.setSuccess(true);
    paymentTransactionImpl2.setType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentTransactionImpl2.setAmount(null);
    OrderPaymentImpl orderPayment = new OrderPaymentImpl();
    paymentTransactionImpl2.setOrderPayment(orderPayment);
    paymentTransactionImpl2.setParentTransaction(null);

    // Act
    Money actualAmount = paymentTransactionImpl2.getAmount();

    // Assert
    OrderPayment orderPayment2 = paymentTransactionImpl2.orderPayment;
    assertTrue(orderPayment2 instanceof OrderPaymentImpl);
    assertEquals(actualAmount.ZERO, actualAmount);
    assertSame(orderPayment.archiveStatus, ((OrderPaymentImpl) orderPayment2).archiveStatus);
  }

  /**
   * Test {@link PaymentTransactionImpl#getAmount()}.
   * <ul>
   *   <li>Then return abs abs abs is {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentTransactionImpl#getAmount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money PaymentTransactionImpl.getAmount()"})
  public void testGetAmount_thenReturnAbsAbsAbsIsZero() {
    // Arrange
    PaymentTransaction parentTransaction = mock(PaymentTransaction.class);
    when(parentTransaction.getOrderPayment()).thenReturn(new OrderPaymentImpl());

    PaymentTransactionImpl paymentTransactionImpl2 = new PaymentTransactionImpl();
    paymentTransactionImpl2.setAdditionalFields(new HashMap<>());
    paymentTransactionImpl2.setCustomerIpAddress("42 Main St");
    paymentTransactionImpl2
        .setDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentTransactionImpl2.setId(1L);
    paymentTransactionImpl2.setRawResponse("Raw Response");
    paymentTransactionImpl2.setSaveToken(true);
    paymentTransactionImpl2.setSuccess(true);
    paymentTransactionImpl2.setType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentTransactionImpl2.setAmount(null);
    paymentTransactionImpl2.setOrderPayment(null);
    paymentTransactionImpl2.setParentTransaction(parentTransaction);

    // Act
    Money actualAmount = paymentTransactionImpl2.getAmount();

    // Assert
    verify(parentTransaction).getOrderPayment();
    Money money = actualAmount.ZERO;
    Money absResult = actualAmount.abs();
    Money absResult2 = absResult.abs();
    assertEquals(money, absResult2.abs());
    Money zeroResult = actualAmount.zero();
    Money absResult3 = zeroResult.abs();
    assertEquals(money, absResult3.abs());
    Money zeroResult2 = absResult.zero();
    assertEquals(money, zeroResult2.abs());
    Money zeroResult3 = zeroResult.zero();
    assertEquals(money, zeroResult3.abs());
    assertEquals(money, absResult2.zero());
    assertEquals(money, absResult3.zero());
    assertEquals(money, zeroResult2.zero());
    assertEquals(money, zeroResult3.zero());
  }

  /**
   * Test {@link PaymentTransactionImpl#setAmount(Money)}.
   * <ul>
   *   <li>Given {@link PaymentTransactionImpl} (default constructor) AdditionalFields is {@link HashMap#HashMap()}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentTransactionImpl#setAmount(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PaymentTransactionImpl.setAmount(Money)"})
  public void testSetAmount_givenPaymentTransactionImplAdditionalFieldsIsHashMap_whenNull() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl2 = new PaymentTransactionImpl();
    paymentTransactionImpl2.setAdditionalFields(new HashMap<>());
    paymentTransactionImpl2.setAmount(new Money());
    paymentTransactionImpl2.setCustomerIpAddress("42 Main St");
    paymentTransactionImpl2
        .setDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentTransactionImpl2.setId(1L);
    paymentTransactionImpl2.setOrderPayment(new OrderPaymentImpl());
    paymentTransactionImpl2.setParentTransaction(new PaymentTransactionImpl());
    paymentTransactionImpl2.setRawResponse("Raw Response");
    paymentTransactionImpl2.setSaveToken(true);
    paymentTransactionImpl2.setSuccess(true);
    paymentTransactionImpl2.setType(new PaymentTransactionType("Type", "Friendly Type"));

    // Act
    paymentTransactionImpl2.setAmount(null);

    // Assert that nothing has changed
    assertEquals(new BigDecimal("0.00"), paymentTransactionImpl2.amount);
  }

  /**
   * Test {@link PaymentTransactionImpl#setAmount(Money)}.
   * <ul>
   *   <li>Then {@link PaymentTransactionImpl} (default constructor) {@link PaymentTransactionImpl#amount} is {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentTransactionImpl#setAmount(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PaymentTransactionImpl.setAmount(Money)"})
  public void testSetAmount_thenPaymentTransactionImplAmountIsBigDecimalWith23() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl2 = new PaymentTransactionImpl();
    Money amount = mock(Money.class);
    when(amount.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    paymentTransactionImpl2.setAmount(amount);

    // Assert
    verify(amount).getAmount();
    assertEquals(new BigDecimal("2.3"), paymentTransactionImpl2.amount);
  }

  /**
   * Test {@link PaymentTransactionImpl#setAmount(Money)}.
   * <ul>
   *   <li>When {@link Money#Money()}.</li>
   *   <li>Then {@link Money#Money()} abs Amount is {@link PaymentTransactionImpl} (default constructor) {@link PaymentTransactionImpl#amount}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentTransactionImpl#setAmount(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PaymentTransactionImpl.setAmount(Money)"})
  public void testSetAmount_whenMoney_thenMoneyAbsAmountIsPaymentTransactionImplAmount() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl2 = new PaymentTransactionImpl();
    Money amount = new Money();

    // Act
    paymentTransactionImpl2.setAmount(amount);

    // Assert
    assertEquals(new BigDecimal("0.00"), paymentTransactionImpl2.amount);
    BigDecimal bigDecimal = paymentTransactionImpl2.amount;
    Money absResult = amount.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = amount.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(bigDecimal, absResult3.abs().getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(bigDecimal, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(bigDecimal, zeroResult3.abs().getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, absResult2.zero().getAmount());
    assertSame(bigDecimal, absResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult2.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.zero().getAmount());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map PaymentTransactionImpl.getAdditionalFields()",
      "String PaymentTransactionImpl.getCustomerIpAddress()", "Date PaymentTransactionImpl.getDate()",
      "Long PaymentTransactionImpl.getId()", "PaymentTransaction PaymentTransactionImpl.getParentTransaction()",
      "String PaymentTransactionImpl.getRawResponse()", "Boolean PaymentTransactionImpl.getSuccess()",
      "void PaymentTransactionImpl.setAdditionalFields(Map)",
      "void PaymentTransactionImpl.setCustomerIpAddress(String)", "void PaymentTransactionImpl.setDate(Date)",
      "void PaymentTransactionImpl.setId(Long)", "void PaymentTransactionImpl.setOrderPayment(OrderPayment)",
      "void PaymentTransactionImpl.setParentTransaction(PaymentTransaction)",
      "void PaymentTransactionImpl.setRawResponse(String)", "void PaymentTransactionImpl.setSuccess(Boolean)"})
  public void testGettersAndSetters() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = new PaymentTransactionImpl();
    HashMap<String, String> additionalFields = new HashMap<>();

    // Act
    paymentTransactionImpl.setAdditionalFields(additionalFields);
    paymentTransactionImpl.setCustomerIpAddress("42 Main St");
    Date date = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
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
   * Test {@link PaymentTransactionImpl#isSaveToken()}.
   * <ul>
   *   <li>Given {@link PaymentTransactionImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentTransactionImpl#isSaveToken()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PaymentTransactionImpl.isSaveToken()"})
  public void testIsSaveToken_givenPaymentTransactionImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PaymentTransactionImpl()).isSaveToken());
  }

  /**
   * Test {@link PaymentTransactionImpl#isSaveToken()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentTransactionImpl#isSaveToken()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PaymentTransactionImpl.isSaveToken()"})
  public void testIsSaveToken_thenReturnTrue() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl2 = new PaymentTransactionImpl();
    paymentTransactionImpl2.setAdditionalFields(new HashMap<>());
    paymentTransactionImpl2.setAmount(new Money());
    paymentTransactionImpl2.setCustomerIpAddress("42 Main St");
    paymentTransactionImpl2
        .setDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentTransactionImpl2.setId(1L);
    paymentTransactionImpl2.setOrderPayment(new OrderPaymentImpl());
    paymentTransactionImpl2.setParentTransaction(new PaymentTransactionImpl());
    paymentTransactionImpl2.setRawResponse("Raw Response");
    paymentTransactionImpl2.setSuccess(true);
    paymentTransactionImpl2.setType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentTransactionImpl2.setSaveToken(true);

    // Act and Assert
    assertTrue(paymentTransactionImpl2.isSaveToken());
  }

  /**
   * Test {@link PaymentTransactionImpl#setSaveToken(boolean)}.
   * <p>
   * Method under test: {@link PaymentTransactionImpl#setSaveToken(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PaymentTransactionImpl.setSaveToken(boolean)"})
  public void testSetSaveToken() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl2 = new PaymentTransactionImpl();

    // Act
    paymentTransactionImpl2.setSaveToken(true);

    // Assert
    assertTrue(paymentTransactionImpl2.saveToken);
  }

  /**
   * Test {@link PaymentTransactionImpl#getArchived()}.
   * <p>
   * Method under test: {@link PaymentTransactionImpl#getArchived()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Character PaymentTransactionImpl.getArchived()"})
  public void testGetArchived() {
    // Arrange, Act and Assert
    assertEquals('N', (new PaymentTransactionImpl()).getArchived().charValue());
  }

  /**
   * Test {@link PaymentTransactionImpl#setArchived(Character)}.
   * <p>
   * Method under test: {@link PaymentTransactionImpl#setArchived(Character)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PaymentTransactionImpl.setArchived(Character)"})
  public void testSetArchived() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl2 = new PaymentTransactionImpl();

    // Act
    paymentTransactionImpl2.setArchived('A');

    // Assert
    assertEquals('A', paymentTransactionImpl2.archiveStatus.getArchived().charValue());
    assertEquals('A', paymentTransactionImpl2.getArchived().charValue());
  }

  /**
   * Test {@link PaymentTransactionImpl#isActive()}.
   * <ul>
   *   <li>Given {@link PaymentTransactionImpl} (default constructor) Archived is {@code Y}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentTransactionImpl#isActive()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PaymentTransactionImpl.isActive()"})
  public void testIsActive_givenPaymentTransactionImplArchivedIsY_thenReturnFalse() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl2 = new PaymentTransactionImpl();
    paymentTransactionImpl2.setArchived('Y');

    // Act and Assert
    assertFalse(paymentTransactionImpl2.isActive());
  }

  /**
   * Test {@link PaymentTransactionImpl#isActive()}.
   * <ul>
   *   <li>Given {@link PaymentTransactionImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentTransactionImpl#isActive()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PaymentTransactionImpl.isActive()"})
  public void testIsActive_givenPaymentTransactionImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new PaymentTransactionImpl()).isActive());
  }

  /**
   * Test {@link PaymentTransactionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test: {@link PaymentTransactionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse PaymentTransactionImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl2 = new PaymentTransactionImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<PaymentTransaction> actualCreateOrRetrieveCopyInstanceResult = paymentTransactionImpl2
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link PaymentTransactionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test: {@link PaymentTransactionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse PaymentTransactionImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    OrderPaymentImpl orderPayment = mock(OrderPaymentImpl.class);
    when(orderPayment.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new OrderPaymentImpl(), true));
    doNothing().when(orderPayment).addTransaction(Mockito.<PaymentTransaction>any());
    orderPayment.addTransaction(new PaymentTransactionImpl());

    PaymentTransactionImpl paymentTransactionImpl = new PaymentTransactionImpl();
    paymentTransactionImpl.setOrderPayment(orderPayment);

    PaymentTransactionImpl paymentTransactionImpl2 = new PaymentTransactionImpl();
    paymentTransactionImpl2.setAdditionalFields(new HashMap<>());
    paymentTransactionImpl2.setAmount(new Money());
    paymentTransactionImpl2.setCustomerIpAddress("42 Main St");
    paymentTransactionImpl2
        .setDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentTransactionImpl2.setId(1L);
    paymentTransactionImpl2.setOrderPayment(new OrderPaymentImpl());
    paymentTransactionImpl2.setParentTransaction(new PaymentTransactionImpl());
    paymentTransactionImpl2.setRawResponse("Raw Response");
    paymentTransactionImpl2.setSaveToken(true);
    paymentTransactionImpl2.setSuccess(true);
    paymentTransactionImpl2
        .setType(new PaymentTransactionType("ThreadLocalManager.notify.orphans", "ThreadLocalManager.notify.orphans"));
    CreateResponse<Object> createResponse = new CreateResponse<>(paymentTransactionImpl2, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<PaymentTransaction> actualCreateOrRetrieveCopyInstanceResult = paymentTransactionImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(orderPayment).addTransaction(isA(PaymentTransaction.class));
    verify(orderPayment).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test new {@link PaymentTransactionImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link PaymentTransactionImpl}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    assertNull(actualPaymentTransactionImpl.getOrderPayment());
    assertNull(actualPaymentTransactionImpl.orderPayment);
    assertNull(actualPaymentTransactionImpl.getParentTransaction());
    assertFalse(actualPaymentTransactionImpl.saveToken);
    assertTrue(actualPaymentTransactionImpl.getAdditionalFields().isEmpty());
    assertTrue(actualPaymentTransactionImpl.getSuccess());
  }
}

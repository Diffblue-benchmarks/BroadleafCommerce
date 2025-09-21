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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
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
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class PaymentTransactionImplDiffblueTest {
  @Autowired private PaymentTransactionImpl paymentTransactionImpl;

  /**
   * Test {@link PaymentTransactionImpl#getOrderPayment()}.
   *
   * <p>Method under test: {@link PaymentTransactionImpl#getOrderPayment()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderPayment PaymentTransactionImpl.getOrderPayment()"})
  public void testGetOrderPayment() {
    // Arrange
    paymentTransactionImpl.setOrderPayment(null);
    paymentTransactionImpl.setParentTransaction(new PaymentTransactionImpl());

    // Act and Assert
    assertNull(paymentTransactionImpl.getOrderPayment());
  }

  /**
   * Test {@link PaymentTransactionImpl#getOrderPayment()}.
   *
   * <ul>
   *   <li>Given {@link PaymentTransactionImpl} OrderPayment is {@link OrderPaymentImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link PaymentTransactionImpl#getOrderPayment()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderPayment PaymentTransactionImpl.getOrderPayment()"})
  public void testGetOrderPayment_givenPaymentTransactionImplOrderPaymentIsOrderPaymentImpl() {
    // Arrange
    OrderPaymentImpl orderPayment = new OrderPaymentImpl();
    paymentTransactionImpl.setOrderPayment(orderPayment);
    paymentTransactionImpl.setParentTransaction(null);

    // Act and Assert
    assertSame(orderPayment, paymentTransactionImpl.getOrderPayment());
  }

  /**
   * Test {@link PaymentTransactionImpl#getOrderPayment()}.
   *
   * <ul>
   *   <li>Given {@link PaymentTransactionImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentTransactionImpl#getOrderPayment()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderPayment PaymentTransactionImpl.getOrderPayment()"})
  public void testGetOrderPayment_givenPaymentTransactionImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(paymentTransactionImpl.getOrderPayment());
  }

  /**
   * Test {@link PaymentTransactionImpl#getOrderPayment()}.
   *
   * <ul>
   *   <li>Then calls {@link PaymentTransaction#getOrderPayment()}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentTransactionImpl#getOrderPayment()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderPayment PaymentTransactionImpl.getOrderPayment()"})
  public void testGetOrderPayment_thenCallsGetOrderPayment() {
    // Arrange
    PaymentTransaction parentTransaction = mock(PaymentTransaction.class);
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    when(parentTransaction.getOrderPayment()).thenReturn(orderPaymentImpl);
    paymentTransactionImpl.setOrderPayment(null);
    paymentTransactionImpl.setParentTransaction(parentTransaction);

    // Act
    OrderPayment actualOrderPayment = paymentTransactionImpl.getOrderPayment();

    // Assert
    verify(parentTransaction).getOrderPayment();
    assertSame(orderPaymentImpl, actualOrderPayment);
  }

  /**
   * Test {@link PaymentTransactionImpl#setType(PaymentTransactionType)}.
   *
   * <p>Method under test: {@link PaymentTransactionImpl#setType(PaymentTransactionType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaymentTransactionImpl.setType(PaymentTransactionType)"})
  public void testSetType() {
    // Arrange
    PaymentTransactionType type = new PaymentTransactionType("Type", "Friendly Type");

    // Act
    paymentTransactionImpl.setType(type);

    // Assert
    assertEquals("Type", paymentTransactionImpl.type);
    assertEquals(type, paymentTransactionImpl.getType());
  }

  /**
   * Test {@link PaymentTransactionImpl#setType(PaymentTransactionType)}.
   *
   * <ul>
   *   <li>Given {@code Type}.
   *   <li>Then {@link PaymentTransactionImpl} Type Type is {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentTransactionImpl#setType(PaymentTransactionType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaymentTransactionImpl.setType(PaymentTransactionType)"})
  public void testSetType_givenType_thenPaymentTransactionImplTypeTypeIsType() {
    // Arrange
    PaymentTransactionType type = mock(PaymentTransactionType.class);
    when(type.getType()).thenReturn("Type");

    // Act
    paymentTransactionImpl.setType(type);

    // Assert
    verify(type).getType();
    assertEquals("Type", paymentTransactionImpl.getType().getType());
    assertEquals("Type", paymentTransactionImpl.type);
  }

  /**
   * Test {@link PaymentTransactionImpl#getAmount()}.
   *
   * <ul>
   *   <li>Then {@link PaymentTransactionImpl} {@link PaymentTransactionImpl#orderPayment} {@link
   *       OrderPaymentImpl}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentTransactionImpl#getAmount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money PaymentTransactionImpl.getAmount()"})
  public void testGetAmount_thenPaymentTransactionImplOrderPaymentOrderPaymentImpl() {
    // Arrange
    paymentTransactionImpl.setAmount(null);
    OrderPaymentImpl orderPayment = new OrderPaymentImpl();
    paymentTransactionImpl.setOrderPayment(orderPayment);
    paymentTransactionImpl.setParentTransaction(null);

    // Act
    Money actualAmount = paymentTransactionImpl.getAmount();

    // Assert
    OrderPayment orderPayment2 = paymentTransactionImpl.orderPayment;
    assertTrue(orderPayment2 instanceof OrderPaymentImpl);
    assertEquals(Money.ZERO, actualAmount);
    assertSame(orderPayment.archiveStatus, ((OrderPaymentImpl) orderPayment2).archiveStatus);
  }

  /**
   * Test {@link PaymentTransactionImpl#getAmount()}.
   *
   * <ul>
   *   <li>Then return abs abs abs Amount is {@link PaymentTransactionImpl} {@link
   *       PaymentTransactionImpl#amount}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentTransactionImpl#getAmount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money PaymentTransactionImpl.getAmount()"})
  public void testGetAmount_thenReturnAbsAbsAbsAmountIsPaymentTransactionImplAmount() {
    // Arrange
    paymentTransactionImpl.setAmount(new Money());
    paymentTransactionImpl.setOrderPayment(new OrderPaymentImpl());
    paymentTransactionImpl.setParentTransaction(null);

    // Act
    Money actualAmount = paymentTransactionImpl.getAmount();

    // Assert
    BigDecimal bigDecimal = paymentTransactionImpl.amount;
    Money absResult = actualAmount.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = actualAmount.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(bigDecimal, absResult3.abs().getAmount());
    assertSame(bigDecimal, absResult2.getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(bigDecimal, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(bigDecimal, zeroResult3.abs().getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, absResult2.zero().getAmount());
    assertSame(bigDecimal, absResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, zeroResult2.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
  }

  /**
   * Test {@link PaymentTransactionImpl#getAmount()}.
   *
   * <ul>
   *   <li>Then return abs abs abs Amount is {@link PaymentTransactionImpl} (default constructor)
   *       {@link PaymentTransactionImpl#amount}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentTransactionImpl#getAmount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money PaymentTransactionImpl.getAmount()"})
  public void testGetAmount_thenReturnAbsAbsAbsAmountIsPaymentTransactionImplAmount2() {
    // Arrange
    PaymentTransactionImpl parentTransaction = new PaymentTransactionImpl();
    parentTransaction.setAdditionalFields(new HashMap<>());
    parentTransaction.setAmount(new Money());
    parentTransaction.setCustomerIpAddress("42 Main St");
    parentTransaction.setDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    parentTransaction.setId(1L);
    parentTransaction.setOrderPayment(new OrderPaymentImpl());
    parentTransaction.setParentTransaction(new PaymentTransactionImpl());
    parentTransaction.setRawResponse("Raw Response");
    parentTransaction.setSaveToken(true);
    parentTransaction.setSuccess(true);
    parentTransaction.setType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentTransactionImpl.setAmount(null);
    paymentTransactionImpl.setOrderPayment(null);
    paymentTransactionImpl.setParentTransaction(parentTransaction);

    // Act
    Money actualAmount = paymentTransactionImpl.getAmount();

    // Assert
    BigDecimal bigDecimal = parentTransaction.amount;
    Money absResult = actualAmount.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = actualAmount.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(bigDecimal, absResult3.abs().getAmount());
    assertSame(bigDecimal, absResult2.getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(bigDecimal, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(bigDecimal, zeroResult3.abs().getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, absResult2.zero().getAmount());
    assertSame(bigDecimal, absResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, zeroResult2.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
  }

  /**
   * Test {@link PaymentTransactionImpl#getAmount()}.
   *
   * <ul>
   *   <li>Then return abs abs abs is {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentTransactionImpl#getAmount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money PaymentTransactionImpl.getAmount()"})
  public void testGetAmount_thenReturnAbsAbsAbsIsZero() {
    // Arrange
    PaymentTransaction parentTransaction = mock(PaymentTransaction.class);
    when(parentTransaction.getOrderPayment()).thenReturn(new OrderPaymentImpl());
    paymentTransactionImpl.setAmount(null);
    paymentTransactionImpl.setOrderPayment(null);
    paymentTransactionImpl.setParentTransaction(parentTransaction);

    // Act
    Money actualAmount = paymentTransactionImpl.getAmount();

    // Assert
    verify(parentTransaction).getOrderPayment();
    Money money = Money.ZERO;
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
   * Test {@link PaymentTransactionImpl#getAmount()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentTransactionImpl#getAmount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money PaymentTransactionImpl.getAmount()"})
  public void testGetAmount_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    OrderPaymentImpl orderPayment = mock(OrderPaymentImpl.class);
    when(orderPayment.getCurrency()).thenReturn(broadleafCurrency);
    paymentTransactionImpl.setAmount(null);
    paymentTransactionImpl.setOrderPayment(orderPayment);
    paymentTransactionImpl.setParentTransaction(mock(PaymentTransaction.class));

    // Act
    Money actualAmount = paymentTransactionImpl.getAmount();

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(orderPayment).getCurrency();
    Currency currency = actualAmount.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(826, currency.getNumericCode());
    Money actualAbsResult = actualAmount.abs();
    assertEquals(actualAmount, actualAbsResult);
    Money actualZeroResult = actualAmount.zero();
    assertEquals(actualAmount, actualZeroResult);
  }

  /**
   * Test {@link PaymentTransactionImpl#setAmount(Money)}.
   *
   * <ul>
   *   <li>Then {@link PaymentTransactionImpl} {@link PaymentTransactionImpl#amount} is {@link
   *       BigDecimal#BigDecimal(String)} with {@code 2.3}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentTransactionImpl#setAmount(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaymentTransactionImpl.setAmount(Money)"})
  public void testSetAmount_thenPaymentTransactionImplAmountIsBigDecimalWith23() {
    // Arrange
    Money amount = mock(Money.class);
    when(amount.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    paymentTransactionImpl.setAmount(amount);

    // Assert
    verify(amount).getAmount();
    assertEquals(new BigDecimal("2.3"), paymentTransactionImpl.amount);
  }

  /**
   * Test {@link PaymentTransactionImpl#setAmount(Money)}.
   *
   * <ul>
   *   <li>When {@link Money#Money()}.
   *   <li>Then {@link PaymentTransactionImpl} {@link PaymentTransactionImpl#amount} is {@link
   *       BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentTransactionImpl#setAmount(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaymentTransactionImpl.setAmount(Money)"})
  public void testSetAmount_whenMoney_thenPaymentTransactionImplAmountIsBigDecimalWith000() {
    // Arrange
    Money amount = new Money();

    // Act
    paymentTransactionImpl.setAmount(amount);

    // Assert
    assertEquals(new BigDecimal("0.00"), paymentTransactionImpl.amount);
    BigDecimal bigDecimal = paymentTransactionImpl.amount;
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
   * Test {@link PaymentTransactionImpl#setAmount(Money)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PaymentTransactionImpl} {@link PaymentTransactionImpl#amount} is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentTransactionImpl#setAmount(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaymentTransactionImpl.setAmount(Money)"})
  public void testSetAmount_whenNull_thenPaymentTransactionImplAmountIsNull() {
    // Arrange and Act
    paymentTransactionImpl.setAmount(null);

    // Assert that nothing has changed
    assertNull(paymentTransactionImpl.amount);
  }

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
   * Test {@link PaymentTransactionImpl#isSaveToken()}.
   *
   * <ul>
   *   <li>Given {@link PaymentTransactionImpl} SaveToken is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentTransactionImpl#isSaveToken()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentTransactionImpl.isSaveToken()"})
  public void testIsSaveToken_givenPaymentTransactionImplSaveTokenIsTrue_thenReturnTrue() {
    // Arrange
    paymentTransactionImpl.setSaveToken(true);

    // Act and Assert
    assertTrue(paymentTransactionImpl.isSaveToken());
  }

  /**
   * Test {@link PaymentTransactionImpl#isSaveToken()}.
   *
   * <ul>
   *   <li>Given {@link PaymentTransactionImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentTransactionImpl#isSaveToken()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentTransactionImpl.isSaveToken()"})
  public void testIsSaveToken_givenPaymentTransactionImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(paymentTransactionImpl.isSaveToken());
  }

  /**
   * Test {@link PaymentTransactionImpl#setSaveToken(boolean)}.
   *
   * <p>Method under test: {@link PaymentTransactionImpl#setSaveToken(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaymentTransactionImpl.setSaveToken(boolean)"})
  public void testSetSaveToken() {
    // Arrange and Act
    paymentTransactionImpl.setSaveToken(true);

    // Assert
    assertTrue(paymentTransactionImpl.saveToken);
  }

  /**
   * Test {@link PaymentTransactionImpl#getArchived()}.
   *
   * <p>Method under test: {@link PaymentTransactionImpl#getArchived()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Character PaymentTransactionImpl.getArchived()"})
  public void testGetArchived() {
    // Arrange, Act and Assert
    assertEquals('N', paymentTransactionImpl.getArchived().charValue());
  }

  /**
   * Test {@link PaymentTransactionImpl#setArchived(Character)}.
   *
   * <p>Method under test: {@link PaymentTransactionImpl#setArchived(Character)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaymentTransactionImpl.setArchived(Character)"})
  public void testSetArchived() {
    // Arrange and Act
    paymentTransactionImpl.setArchived('A');

    // Assert
    assertEquals('A', paymentTransactionImpl.archiveStatus.getArchived().charValue());
    assertEquals('A', paymentTransactionImpl.getArchived().charValue());
  }

  /**
   * Test {@link PaymentTransactionImpl#isActive()}.
   *
   * <ul>
   *   <li>Given {@link PaymentTransactionImpl} Archived is {@code Y}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentTransactionImpl#isActive()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentTransactionImpl.isActive()"})
  public void testIsActive_givenPaymentTransactionImplArchivedIsY_thenReturnFalse() {
    // Arrange
    paymentTransactionImpl.setArchived('Y');

    // Act and Assert
    assertFalse(paymentTransactionImpl.isActive());
  }

  /**
   * Test {@link PaymentTransactionImpl#isActive()}.
   *
   * <ul>
   *   <li>Given {@link PaymentTransactionImpl}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentTransactionImpl#isActive()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentTransactionImpl.isActive()"})
  public void testIsActive_givenPaymentTransactionImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(paymentTransactionImpl.isActive());
  }

  /**
   * Test {@link PaymentTransactionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * PaymentTransactionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse PaymentTransactionImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse =
        new CreateResponse<>(new PaymentTransactionImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<PaymentTransaction> actualCreateOrRetrieveCopyInstanceResult =
        paymentTransactionImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
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
    assertNull(actualPaymentTransactionImpl.getOrderPayment());
    assertNull(actualPaymentTransactionImpl.orderPayment);
    assertNull(actualPaymentTransactionImpl.getParentTransaction());
    assertFalse(actualPaymentTransactionImpl.saveToken);
    assertTrue(actualPaymentTransactionImpl.getAdditionalFields().isEmpty());
    assertTrue(actualPaymentTransactionImpl.getSuccess());
  }
}

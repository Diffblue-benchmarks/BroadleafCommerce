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
package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.Currency;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.money.Money;
import org.junit.Test;
import org.mockito.Mockito;

public class DiscreteOrderItemFeePriceImplDiffblueTest {
  /**
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#getAmount()}
   */
  @Test
  public void testGetAmount() {
    // Arrange, Act and Assert
    assertNull((new DiscreteOrderItemFeePriceImpl()).getAmount());
  }

  /**
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#getAmount()}
   */
  @Test
  public void testGetAmount2() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl = new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl.setName("Name");
    discreteOrderItemFeePriceImpl.setReportingCode("Reporting Code");
    Money amount = new Money();
    discreteOrderItemFeePriceImpl.setAmount(amount);

    // Act and Assert
    assertEquals(amount, discreteOrderItemFeePriceImpl.getAmount());
  }

  /**
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#setAmount(Money)}
   */
  @Test
  public void testSetAmount() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl = new DiscreteOrderItemFeePriceImpl();
    Money amount = new Money();

    // Act
    discreteOrderItemFeePriceImpl.setAmount(amount);

    // Assert
    BigDecimal expectedAmount = new BigDecimal("0.00");
    BigDecimal amount2 = amount.getAmount();
    assertEquals(expectedAmount, amount2);
    assertEquals(new BigDecimal("0.00"), discreteOrderItemFeePriceImpl.amount);
    assertEquals(amount, amount.abs());
    assertEquals(amount, amount.zero());
    assertSame(discreteOrderItemFeePriceImpl.amount, amount2);
  }

  /**
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#setAmount(Money)}
   */
  @Test
  public void testSetAmount2() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl = new DiscreteOrderItemFeePriceImpl();

    // Act
    discreteOrderItemFeePriceImpl.setAmount(null);

    // Assert
    assertNull(discreteOrderItemFeePriceImpl.amount);
  }

  /**
   * Method under test:
   * {@link DiscreteOrderItemFeePriceImpl#convertToMoney(BigDecimal)}
   */
  @Test
  public void testConvertToMoney() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl = new DiscreteOrderItemFeePriceImpl();

    // Act
    Money actualConvertToMoneyResult = discreteOrderItemFeePriceImpl.convertToMoney(new BigDecimal("2.3"));

    // Assert
    Currency currency = actualConvertToMoneyResult.getCurrency();
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("2.30");
    assertEquals(expectedAmount, actualConvertToMoneyResult.getAmount());
    assertEquals(actualConvertToMoneyResult, actualConvertToMoneyResult.abs());
    Money expectedZeroResult = actualConvertToMoneyResult.ZERO;
    assertEquals(expectedZeroResult, actualConvertToMoneyResult.zero());
  }

  /**
   * Method under test:
   * {@link DiscreteOrderItemFeePriceImpl#convertToMoney(BigDecimal)}
   */
  @Test
  public void testConvertToMoney2() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl = new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl.setAmount(new Money());
    discreteOrderItemFeePriceImpl.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl.setName("Name");
    discreteOrderItemFeePriceImpl.setReportingCode("Reporting Code");

    // Act and Assert
    assertNull(discreteOrderItemFeePriceImpl.convertToMoney(null));
  }

  /**
   * Method under test:
   * {@link DiscreteOrderItemFeePriceImpl#convertToMoney(BigDecimal)}
   */
  @Test
  public void testConvertToMoney3() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl = new DiscreteOrderItemFeePriceImpl();
    Money amount = new Money();
    discreteOrderItemFeePriceImpl.setAmount(amount);
    discreteOrderItemFeePriceImpl.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl.setName("Name");
    discreteOrderItemFeePriceImpl.setReportingCode("Reporting Code");

    // Act
    Money actualConvertToMoneyResult = discreteOrderItemFeePriceImpl.convertToMoney(new BigDecimal("2.3"));

    // Assert
    Currency currency = actualConvertToMoneyResult.getCurrency();
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("2.30");
    assertEquals(expectedAmount, actualConvertToMoneyResult.getAmount());
    assertEquals(amount, actualConvertToMoneyResult.zero());
    assertEquals(actualConvertToMoneyResult, actualConvertToMoneyResult.abs());
  }

  /**
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#clone()}
   */
  @Test
  public void testClone() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl = new DiscreteOrderItemFeePriceImpl();

    // Act
    DiscreteOrderItemFeePrice actualCloneResult = discreteOrderItemFeePriceImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof DiscreteOrderItemFeePriceImpl);
    assertEquals(discreteOrderItemFeePriceImpl, actualCloneResult);
  }

  /**
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#clone()}
   */
  @Test
  public void testClone2() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl = new DiscreteOrderItemFeePriceImpl();
    DiscreteOrderItemImpl discreteOrderItem = new DiscreteOrderItemImpl();
    discreteOrderItemFeePriceImpl.setDiscreteOrderItem(discreteOrderItem);
    discreteOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl.setName("Name");
    discreteOrderItemFeePriceImpl.setReportingCode("Reporting Code");
    Money amount = new Money();
    discreteOrderItemFeePriceImpl.setAmount(amount);

    // Act
    DiscreteOrderItemFeePrice actualCloneResult = discreteOrderItemFeePriceImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof DiscreteOrderItemFeePriceImpl);
    assertEquals("Name", actualCloneResult.getName());
    assertEquals("Reporting Code", actualCloneResult.getReportingCode());
    assertNull(actualCloneResult.getId());
    assertEquals(new BigDecimal("0.00"), ((DiscreteOrderItemFeePriceImpl) actualCloneResult).amount);
    assertEquals(amount, actualCloneResult.getAmount());
    assertSame(discreteOrderItem, actualCloneResult.getDiscreteOrderItem());
  }

  /**
   * Method under test:
   * {@link DiscreteOrderItemFeePriceImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl = new DiscreteOrderItemFeePriceImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<DiscreteOrderItemFeePrice> actualCreateOrRetrieveCopyInstanceResult = discreteOrderItemFeePriceImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   *   <li>{@link DiscreteOrderItemFeePriceImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl = new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl.setAmount(new Money());
    discreteOrderItemFeePriceImpl.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl.setName("Name");
    discreteOrderItemFeePriceImpl.setReportingCode("Reporting Code");

    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl2 = new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl2.setAmount(new Money());
    discreteOrderItemFeePriceImpl2.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl2.setName("Name");
    discreteOrderItemFeePriceImpl2.setReportingCode("Reporting Code");

    // Act and Assert
    assertEquals(discreteOrderItemFeePriceImpl, discreteOrderItemFeePriceImpl2);
    int expectedHashCodeResult = discreteOrderItemFeePriceImpl.hashCode();
    assertEquals(expectedHashCodeResult, discreteOrderItemFeePriceImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   *   <li>{@link DiscreteOrderItemFeePriceImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl = new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl.setAmount(null);
    discreteOrderItemFeePriceImpl.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl.setName("Name");
    discreteOrderItemFeePriceImpl.setReportingCode("Reporting Code");

    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl2 = new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl2.setAmount(null);
    discreteOrderItemFeePriceImpl2.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl2.setName("Name");
    discreteOrderItemFeePriceImpl2.setReportingCode("Reporting Code");

    // Act and Assert
    assertEquals(discreteOrderItemFeePriceImpl, discreteOrderItemFeePriceImpl2);
    int expectedHashCodeResult = discreteOrderItemFeePriceImpl.hashCode();
    assertEquals(expectedHashCodeResult, discreteOrderItemFeePriceImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   *   <li>{@link DiscreteOrderItemFeePriceImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl = new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl.setAmount(new Money());
    discreteOrderItemFeePriceImpl.setDiscreteOrderItem(null);
    discreteOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl.setName("Name");
    discreteOrderItemFeePriceImpl.setReportingCode("Reporting Code");

    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl2 = new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl2.setAmount(new Money());
    discreteOrderItemFeePriceImpl2.setDiscreteOrderItem(null);
    discreteOrderItemFeePriceImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl2.setName("Name");
    discreteOrderItemFeePriceImpl2.setReportingCode("Reporting Code");

    // Act and Assert
    assertEquals(discreteOrderItemFeePriceImpl, discreteOrderItemFeePriceImpl2);
    int expectedHashCodeResult = discreteOrderItemFeePriceImpl.hashCode();
    assertEquals(expectedHashCodeResult, discreteOrderItemFeePriceImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   *   <li>{@link DiscreteOrderItemFeePriceImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl = new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl.setAmount(new Money());
    discreteOrderItemFeePriceImpl.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl.setId(null);
    discreteOrderItemFeePriceImpl.setName("Name");
    discreteOrderItemFeePriceImpl.setReportingCode("Reporting Code");

    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl2 = new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl2.setAmount(new Money());
    discreteOrderItemFeePriceImpl2.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl2.setId(null);
    discreteOrderItemFeePriceImpl2.setName("Name");
    discreteOrderItemFeePriceImpl2.setReportingCode("Reporting Code");

    // Act and Assert
    assertEquals(discreteOrderItemFeePriceImpl, discreteOrderItemFeePriceImpl2);
    int expectedHashCodeResult = discreteOrderItemFeePriceImpl.hashCode();
    assertEquals(expectedHashCodeResult, discreteOrderItemFeePriceImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   *   <li>{@link DiscreteOrderItemFeePriceImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl = new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl.setAmount(new Money());
    discreteOrderItemFeePriceImpl.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl.setName("Name");
    discreteOrderItemFeePriceImpl.setReportingCode("Reporting Code");

    // Act and Assert
    assertEquals(discreteOrderItemFeePriceImpl, discreteOrderItemFeePriceImpl);
    int expectedHashCodeResult = discreteOrderItemFeePriceImpl.hashCode();
    assertEquals(expectedHashCodeResult, discreteOrderItemFeePriceImpl.hashCode());
  }

  /**
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl = new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl.setAmount(null);
    discreteOrderItemFeePriceImpl.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl.setName("Name");
    discreteOrderItemFeePriceImpl.setReportingCode("Reporting Code");

    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl2 = new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl2.setAmount(new Money());
    discreteOrderItemFeePriceImpl2.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl2.setName("Name");
    discreteOrderItemFeePriceImpl2.setReportingCode("Reporting Code");

    // Act and Assert
    assertNotEquals(discreteOrderItemFeePriceImpl, discreteOrderItemFeePriceImpl2);
  }

  /**
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl = new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl.setAmount(new Money(10.0d));
    discreteOrderItemFeePriceImpl.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl.setName("Name");
    discreteOrderItemFeePriceImpl.setReportingCode("Reporting Code");

    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl2 = new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl2.setAmount(new Money());
    discreteOrderItemFeePriceImpl2.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl2.setName("Name");
    discreteOrderItemFeePriceImpl2.setReportingCode("Reporting Code");

    // Act and Assert
    assertNotEquals(discreteOrderItemFeePriceImpl, discreteOrderItemFeePriceImpl2);
  }

  /**
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl = new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl.setAmount(mock(Money.class));
    discreteOrderItemFeePriceImpl.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl.setName("Name");
    discreteOrderItemFeePriceImpl.setReportingCode("Reporting Code");

    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl2 = new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl2.setAmount(new Money());
    discreteOrderItemFeePriceImpl2.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl2.setName("Name");
    discreteOrderItemFeePriceImpl2.setReportingCode("Reporting Code");

    // Act and Assert
    assertNotEquals(discreteOrderItemFeePriceImpl, discreteOrderItemFeePriceImpl2);
  }

  /**
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl = new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl.setAmount(new Money());
    discreteOrderItemFeePriceImpl.setDiscreteOrderItem(null);
    discreteOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl.setName("Name");
    discreteOrderItemFeePriceImpl.setReportingCode("Reporting Code");

    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl2 = new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl2.setAmount(new Money());
    discreteOrderItemFeePriceImpl2.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl2.setName("Name");
    discreteOrderItemFeePriceImpl2.setReportingCode("Reporting Code");

    // Act and Assert
    assertNotEquals(discreteOrderItemFeePriceImpl, discreteOrderItemFeePriceImpl2);
  }

  /**
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl = new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl.setAmount(new Money());
    discreteOrderItemFeePriceImpl.setDiscreteOrderItem(mock(DiscreteOrderItemImpl.class));
    discreteOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl.setName("Name");
    discreteOrderItemFeePriceImpl.setReportingCode("Reporting Code");

    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl2 = new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl2.setAmount(new Money());
    discreteOrderItemFeePriceImpl2.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl2.setName("Name");
    discreteOrderItemFeePriceImpl2.setReportingCode("Reporting Code");

    // Act and Assert
    assertNotEquals(discreteOrderItemFeePriceImpl, discreteOrderItemFeePriceImpl2);
  }

  /**
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl = new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl.setAmount(new Money());
    discreteOrderItemFeePriceImpl.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl.setId(2L);
    discreteOrderItemFeePriceImpl.setName("Name");
    discreteOrderItemFeePriceImpl.setReportingCode("Reporting Code");

    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl2 = new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl2.setAmount(new Money());
    discreteOrderItemFeePriceImpl2.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl2.setName("Name");
    discreteOrderItemFeePriceImpl2.setReportingCode("Reporting Code");

    // Act and Assert
    assertNotEquals(discreteOrderItemFeePriceImpl, discreteOrderItemFeePriceImpl2);
  }

  /**
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl = new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl.setAmount(new Money());
    discreteOrderItemFeePriceImpl.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl.setId(null);
    discreteOrderItemFeePriceImpl.setName("Name");
    discreteOrderItemFeePriceImpl.setReportingCode("Reporting Code");

    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl2 = new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl2.setAmount(new Money());
    discreteOrderItemFeePriceImpl2.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl2.setName("Name");
    discreteOrderItemFeePriceImpl2.setReportingCode("Reporting Code");

    // Act and Assert
    assertNotEquals(discreteOrderItemFeePriceImpl, discreteOrderItemFeePriceImpl2);
  }

  /**
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl = new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl.setAmount(new Money());
    discreteOrderItemFeePriceImpl.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl.setName("Reporting Code");
    discreteOrderItemFeePriceImpl.setReportingCode("Reporting Code");

    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl2 = new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl2.setAmount(new Money());
    discreteOrderItemFeePriceImpl2.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl2.setName("Name");
    discreteOrderItemFeePriceImpl2.setReportingCode("Reporting Code");

    // Act and Assert
    assertNotEquals(discreteOrderItemFeePriceImpl, discreteOrderItemFeePriceImpl2);
  }

  /**
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl = new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl.setAmount(new Money());
    discreteOrderItemFeePriceImpl.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl.setName(null);
    discreteOrderItemFeePriceImpl.setReportingCode("Reporting Code");

    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl2 = new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl2.setAmount(new Money());
    discreteOrderItemFeePriceImpl2.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl2.setName("Name");
    discreteOrderItemFeePriceImpl2.setReportingCode("Reporting Code");

    // Act and Assert
    assertNotEquals(discreteOrderItemFeePriceImpl, discreteOrderItemFeePriceImpl2);
  }

  /**
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl = new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl.setAmount(new Money());
    discreteOrderItemFeePriceImpl.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl.setName("Name");
    discreteOrderItemFeePriceImpl.setReportingCode("Name");

    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl2 = new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl2.setAmount(new Money());
    discreteOrderItemFeePriceImpl2.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl2.setName("Name");
    discreteOrderItemFeePriceImpl2.setReportingCode("Reporting Code");

    // Act and Assert
    assertNotEquals(discreteOrderItemFeePriceImpl, discreteOrderItemFeePriceImpl2);
  }

  /**
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl = new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl.setAmount(new Money());
    discreteOrderItemFeePriceImpl.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl.setName("Name");
    discreteOrderItemFeePriceImpl.setReportingCode(null);

    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl2 = new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl2.setAmount(new Money());
    discreteOrderItemFeePriceImpl2.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl2.setName("Name");
    discreteOrderItemFeePriceImpl2.setReportingCode("Reporting Code");

    // Act and Assert
    assertNotEquals(discreteOrderItemFeePriceImpl, discreteOrderItemFeePriceImpl2);
  }

  /**
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl = new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl.setAmount(new Money());
    discreteOrderItemFeePriceImpl.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl.setName("Name");
    discreteOrderItemFeePriceImpl.setReportingCode("Reporting Code");

    // Act and Assert
    assertNotEquals(discreteOrderItemFeePriceImpl, null);
  }

  /**
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl = new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl.setAmount(new Money());
    discreteOrderItemFeePriceImpl.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl.setName("Name");
    discreteOrderItemFeePriceImpl.setReportingCode("Reporting Code");

    // Act and Assert
    assertNotEquals(discreteOrderItemFeePriceImpl, "Different type to DiscreteOrderItemFeePriceImpl");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link DiscreteOrderItemFeePriceImpl}
   *   <li>
   * {@link DiscreteOrderItemFeePriceImpl#setDiscreteOrderItem(DiscreteOrderItem)}
   *   <li>{@link DiscreteOrderItemFeePriceImpl#setId(Long)}
   *   <li>{@link DiscreteOrderItemFeePriceImpl#setName(String)}
   *   <li>{@link DiscreteOrderItemFeePriceImpl#setReportingCode(String)}
   *   <li>{@link DiscreteOrderItemFeePriceImpl#getDiscreteOrderItem()}
   *   <li>{@link DiscreteOrderItemFeePriceImpl#getId()}
   *   <li>{@link DiscreteOrderItemFeePriceImpl#getName()}
   *   <li>{@link DiscreteOrderItemFeePriceImpl#getReportingCode()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    DiscreteOrderItemFeePriceImpl actualDiscreteOrderItemFeePriceImpl = new DiscreteOrderItemFeePriceImpl();
    DiscreteOrderItemImpl discreteOrderItem = new DiscreteOrderItemImpl();
    actualDiscreteOrderItemFeePriceImpl.setDiscreteOrderItem(discreteOrderItem);
    actualDiscreteOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    actualDiscreteOrderItemFeePriceImpl.setName("Name");
    actualDiscreteOrderItemFeePriceImpl.setReportingCode("Reporting Code");
    DiscreteOrderItem actualDiscreteOrderItem = actualDiscreteOrderItemFeePriceImpl.getDiscreteOrderItem();
    Long actualId = actualDiscreteOrderItemFeePriceImpl.getId();
    String actualName = actualDiscreteOrderItemFeePriceImpl.getName();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals("Reporting Code", actualDiscreteOrderItemFeePriceImpl.getReportingCode());
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualId.longValue());
    assertSame(discreteOrderItem, actualDiscreteOrderItem);
  }
}

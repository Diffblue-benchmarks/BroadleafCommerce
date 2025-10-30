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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.money.Money;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class DiscreteOrderItemFeePriceImplDiffblueTest {
  /**
   * Test {@link DiscreteOrderItemFeePriceImpl#getAmount()}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemFeePriceImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#getAmount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money DiscreteOrderItemFeePriceImpl.getAmount()"})
  public void testGetAmount_givenDiscreteOrderItemFeePriceImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new DiscreteOrderItemFeePriceImpl()).getAmount());
  }

  /**
   * Test {@link DiscreteOrderItemFeePriceImpl#getAmount()}.
   * <ul>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#getAmount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money DiscreteOrderItemFeePriceImpl.getAmount()"})
  public void testGetAmount_thenReturnMoney() {
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
   * Test {@link DiscreteOrderItemFeePriceImpl#setAmount(Money)}.
   * <ul>
   *   <li>Then {@link DiscreteOrderItemFeePriceImpl} (default constructor) {@link DiscreteOrderItemFeePriceImpl#amount} is {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#setAmount(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DiscreteOrderItemFeePriceImpl.setAmount(Money)"})
  public void testSetAmount_thenDiscreteOrderItemFeePriceImplAmountIsBigDecimalWith000() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl = new DiscreteOrderItemFeePriceImpl();
    Money amount = new Money();

    // Act
    discreteOrderItemFeePriceImpl.setAmount(amount);

    // Assert
    assertEquals(new BigDecimal("0.00"), discreteOrderItemFeePriceImpl.amount);
    BigDecimal bigDecimal = discreteOrderItemFeePriceImpl.amount;
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
   * Test {@link DiscreteOrderItemFeePriceImpl#setAmount(Money)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link DiscreteOrderItemFeePriceImpl} (default constructor) {@link DiscreteOrderItemFeePriceImpl#amount} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#setAmount(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DiscreteOrderItemFeePriceImpl.setAmount(Money)"})
  public void testSetAmount_whenNull_thenDiscreteOrderItemFeePriceImplAmountIsNull() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl = new DiscreteOrderItemFeePriceImpl();

    // Act
    discreteOrderItemFeePriceImpl.setAmount(null);

    // Assert that nothing has changed
    assertNull(discreteOrderItemFeePriceImpl.amount);
  }

  /**
   * Test {@link DiscreteOrderItemFeePriceImpl#convertToMoney(BigDecimal)}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemFeePriceImpl} (default constructor).</li>
   *   <li>Then return abs abs zero is {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#convertToMoney(BigDecimal)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money DiscreteOrderItemFeePriceImpl.convertToMoney(BigDecimal)"})
  public void testConvertToMoney_givenDiscreteOrderItemFeePriceImpl_thenReturnAbsAbsZeroIsZero() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl = new DiscreteOrderItemFeePriceImpl();

    // Act
    Money actualConvertToMoneyResult = discreteOrderItemFeePriceImpl.convertToMoney(new BigDecimal("2.3"));

    // Assert
    Money money = actualConvertToMoneyResult.ZERO;
    Money absResult = actualConvertToMoneyResult.abs();
    assertEquals(money, absResult.abs().zero());
    assertEquals(money, absResult.zero());
    assertEquals(money, actualConvertToMoneyResult.zero());
  }

  /**
   * Test {@link DiscreteOrderItemFeePriceImpl#convertToMoney(BigDecimal)}.
   * <ul>
   *   <li>Then return abs abs zero is {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#convertToMoney(BigDecimal)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money DiscreteOrderItemFeePriceImpl.convertToMoney(BigDecimal)"})
  public void testConvertToMoney_thenReturnAbsAbsZeroIsMoney() {
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
    Money absResult = actualConvertToMoneyResult.abs();
    assertEquals(amount, absResult.abs().zero());
    assertEquals(amount, absResult.zero());
    assertEquals(amount, actualConvertToMoneyResult.zero());
  }

  /**
   * Test {@link DiscreteOrderItemFeePriceImpl#convertToMoney(BigDecimal)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#convertToMoney(BigDecimal)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money DiscreteOrderItemFeePriceImpl.convertToMoney(BigDecimal)"})
  public void testConvertToMoney_whenNull_thenReturnNull() {
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
   * Test {@link DiscreteOrderItemFeePriceImpl#clone()}.
   * <ul>
   *   <li>Then DiscreteOrderItem return {@link DiscreteOrderItemImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#clone()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DiscreteOrderItemFeePrice DiscreteOrderItemFeePriceImpl.clone()"})
  public void testClone_thenDiscreteOrderItemReturnDiscreteOrderItemImpl() {
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
    DiscreteOrderItem discreteOrderItem2 = actualCloneResult.getDiscreteOrderItem();
    assertTrue(discreteOrderItem2 instanceof DiscreteOrderItemImpl);
    assertEquals("Name", actualCloneResult.getName());
    assertEquals("Reporting Code", actualCloneResult.getReportingCode());
    assertNull(actualCloneResult.getId());
    assertEquals(new BigDecimal("0.00"), ((DiscreteOrderItemFeePriceImpl) actualCloneResult).amount);
    assertEquals(amount, actualCloneResult.getAmount());
    assertSame(discreteOrderItem, discreteOrderItem2);
  }

  /**
   * Test {@link DiscreteOrderItemFeePriceImpl#clone()}.
   * <ul>
   *   <li>Then return {@link DiscreteOrderItemFeePriceImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#clone()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DiscreteOrderItemFeePrice DiscreteOrderItemFeePriceImpl.clone()"})
  public void testClone_thenReturnDiscreteOrderItemFeePriceImpl() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl = new DiscreteOrderItemFeePriceImpl();

    // Act
    DiscreteOrderItemFeePrice actualCloneResult = discreteOrderItemFeePriceImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof DiscreteOrderItemFeePriceImpl);
    assertEquals(discreteOrderItemFeePriceImpl, actualCloneResult);
  }

  /**
   * Test {@link DiscreteOrderItemFeePriceImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "CreateResponse DiscreteOrderItemFeePriceImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
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
   * Test {@link DiscreteOrderItemFeePriceImpl#equals(Object)}, and {@link DiscreteOrderItemFeePriceImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   *   <li>{@link DiscreteOrderItemFeePriceImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DiscreteOrderItemFeePriceImpl.equals(Object)",
      "int DiscreteOrderItemFeePriceImpl.hashCode()"})
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
   * Test {@link DiscreteOrderItemFeePriceImpl#equals(Object)}, and {@link DiscreteOrderItemFeePriceImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   *   <li>{@link DiscreteOrderItemFeePriceImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DiscreteOrderItemFeePriceImpl.equals(Object)",
      "int DiscreteOrderItemFeePriceImpl.hashCode()"})
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
   * Test {@link DiscreteOrderItemFeePriceImpl#equals(Object)}, and {@link DiscreteOrderItemFeePriceImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   *   <li>{@link DiscreteOrderItemFeePriceImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DiscreteOrderItemFeePriceImpl.equals(Object)",
      "int DiscreteOrderItemFeePriceImpl.hashCode()"})
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
   * Test {@link DiscreteOrderItemFeePriceImpl#equals(Object)}, and {@link DiscreteOrderItemFeePriceImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   *   <li>{@link DiscreteOrderItemFeePriceImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DiscreteOrderItemFeePriceImpl.equals(Object)",
      "int DiscreteOrderItemFeePriceImpl.hashCode()"})
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
   * Test {@link DiscreteOrderItemFeePriceImpl#equals(Object)}, and {@link DiscreteOrderItemFeePriceImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   *   <li>{@link DiscreteOrderItemFeePriceImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DiscreteOrderItemFeePriceImpl.equals(Object)",
      "int DiscreteOrderItemFeePriceImpl.hashCode()"})
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
   * Test {@link DiscreteOrderItemFeePriceImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DiscreteOrderItemFeePriceImpl.equals(Object)",
      "int DiscreteOrderItemFeePriceImpl.hashCode()"})
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
   * Test {@link DiscreteOrderItemFeePriceImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DiscreteOrderItemFeePriceImpl.equals(Object)",
      "int DiscreteOrderItemFeePriceImpl.hashCode()"})
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
   * Test {@link DiscreteOrderItemFeePriceImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DiscreteOrderItemFeePriceImpl.equals(Object)",
      "int DiscreteOrderItemFeePriceImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
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
   * Test {@link DiscreteOrderItemFeePriceImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DiscreteOrderItemFeePriceImpl.equals(Object)",
      "int DiscreteOrderItemFeePriceImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
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
   * Test {@link DiscreteOrderItemFeePriceImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DiscreteOrderItemFeePriceImpl.equals(Object)",
      "int DiscreteOrderItemFeePriceImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
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
   * Test {@link DiscreteOrderItemFeePriceImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DiscreteOrderItemFeePriceImpl.equals(Object)",
      "int DiscreteOrderItemFeePriceImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
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
   * Test {@link DiscreteOrderItemFeePriceImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DiscreteOrderItemFeePriceImpl.equals(Object)",
      "int DiscreteOrderItemFeePriceImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
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
   * Test {@link DiscreteOrderItemFeePriceImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DiscreteOrderItemFeePriceImpl.equals(Object)",
      "int DiscreteOrderItemFeePriceImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
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
   * Test {@link DiscreteOrderItemFeePriceImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DiscreteOrderItemFeePriceImpl.equals(Object)",
      "int DiscreteOrderItemFeePriceImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
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
   * Test {@link DiscreteOrderItemFeePriceImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DiscreteOrderItemFeePriceImpl.equals(Object)",
      "int DiscreteOrderItemFeePriceImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
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
   * Test {@link DiscreteOrderItemFeePriceImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DiscreteOrderItemFeePriceImpl.equals(Object)",
      "int DiscreteOrderItemFeePriceImpl.hashCode()"})
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
   * Test {@link DiscreteOrderItemFeePriceImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DiscreteOrderItemFeePriceImpl.equals(Object)",
      "int DiscreteOrderItemFeePriceImpl.hashCode()"})
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
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DiscreteOrderItemFeePriceImpl}
   *   <li>{@link DiscreteOrderItemFeePriceImpl#setDiscreteOrderItem(DiscreteOrderItem)}
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DiscreteOrderItemFeePriceImpl.<init>()",
      "DiscreteOrderItem DiscreteOrderItemFeePriceImpl.getDiscreteOrderItem()",
      "Long DiscreteOrderItemFeePriceImpl.getId()", "String DiscreteOrderItemFeePriceImpl.getName()",
      "String DiscreteOrderItemFeePriceImpl.getReportingCode()",
      "void DiscreteOrderItemFeePriceImpl.setDiscreteOrderItem(DiscreteOrderItem)",
      "void DiscreteOrderItemFeePriceImpl.setId(Long)", "void DiscreteOrderItemFeePriceImpl.setName(String)",
      "void DiscreteOrderItemFeePriceImpl.setReportingCode(String)"})
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

    // Assert
    assertEquals("Name", actualName);
    assertEquals("Reporting Code", actualDiscreteOrderItemFeePriceImpl.getReportingCode());
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualId.longValue());
    assertSame(discreteOrderItem, actualDiscreteOrderItem);
  }
}

package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.math.BigDecimal;
import org.broadleafcommerce.common.money.Money;
import org.junit.Ignore;
import org.junit.Test;

public class DiscreteOrderItemFeePriceImplDiffblueTest {
  /**
   * Test
   * {@link DiscreteOrderItemFeePriceImpl#checkCloneable(DiscreteOrderItemFeePrice)}.
   * <ul>
   *   <li>When {@link DiscreteOrderItemFeePriceImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DiscreteOrderItemFeePriceImpl#checkCloneable(DiscreteOrderItemFeePrice)}
   */
  @Test
  public void testCheckCloneable_whenDiscreteOrderItemFeePriceImpl()
      throws CloneNotSupportedException, NoSuchMethodException, SecurityException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl = new DiscreteOrderItemFeePriceImpl();

    // Act
    discreteOrderItemFeePriceImpl.checkCloneable(new DiscreteOrderItemFeePriceImpl());
  }

  /**
   * Test
   * {@link DiscreteOrderItemFeePriceImpl#checkCloneable(DiscreteOrderItemFeePrice)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DiscreteOrderItemFeePriceImpl#checkCloneable(DiscreteOrderItemFeePrice)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCheckCloneable_whenNull()
      throws CloneNotSupportedException, NoSuchMethodException, SecurityException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.order.domain.DiscreteOrderItemFeePriceImpl.checkCloneable(DiscreteOrderItemFeePriceImpl.java:147)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new DiscreteOrderItemFeePriceImpl()).checkCloneable(null);
  }

  /**
   * Test {@link DiscreteOrderItemFeePriceImpl#convertToMoney(BigDecimal)}.
   * <ul>
   *   <li>Then return abs abs abs abs abs abs abs zero is
   * {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DiscreteOrderItemFeePriceImpl#convertToMoney(BigDecimal)}
   */
  @Test
  public void testConvertToMoney_thenReturnAbsAbsAbsAbsAbsAbsAbsZeroIsMoney() {
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
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertEquals(amount, absResult6.abs().zero());
    assertEquals(amount, absResult6.zero());
    assertEquals(amount, absResult5.zero());
    assertEquals(amount, absResult4.zero());
    assertEquals(amount, absResult3.zero());
    assertEquals(amount, absResult2.zero());
    assertEquals(amount, absResult.zero());
    assertEquals(amount, actualConvertToMoneyResult.zero());
  }

  /**
   * Test {@link DiscreteOrderItemFeePriceImpl#convertToMoney(BigDecimal)}.
   * <ul>
   *   <li>Then return abs abs abs abs abs abs abs zero is {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DiscreteOrderItemFeePriceImpl#convertToMoney(BigDecimal)}
   */
  @Test
  public void testConvertToMoney_thenReturnAbsAbsAbsAbsAbsAbsAbsZeroIsZero() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl = new DiscreteOrderItemFeePriceImpl();

    // Act
    Money actualConvertToMoneyResult = discreteOrderItemFeePriceImpl.convertToMoney(new BigDecimal("2.3"));

    // Assert
    Money money = actualConvertToMoneyResult.ZERO;
    Money absResult = actualConvertToMoneyResult.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertEquals(money, absResult6.abs().zero());
    assertEquals(money, absResult6.zero());
    assertEquals(money, absResult5.zero());
    assertEquals(money, absResult4.zero());
    assertEquals(money, absResult3.zero());
    assertEquals(money, absResult2.zero());
    assertEquals(money, absResult.zero());
    assertEquals(money, actualConvertToMoneyResult.zero());
  }

  /**
   * Test {@link DiscreteOrderItemFeePriceImpl#convertToMoney(BigDecimal)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DiscreteOrderItemFeePriceImpl#convertToMoney(BigDecimal)}
   */
  @Test
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
   *   <li>Then return {@link DiscreteOrderItemFeePriceImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#clone()}
   */
  @Test
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
   * Test {@link DiscreteOrderItemFeePriceImpl#clone()}.
   * <ul>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemFeePriceImpl#clone()}
   */
  @Test
  public void testClone_thenReturnName() {
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
   * Test {@link DiscreteOrderItemFeePriceImpl#equals(Object)}, and
   * {@link DiscreteOrderItemFeePriceImpl#hashCode()}.
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
   * Test {@link DiscreteOrderItemFeePriceImpl#equals(Object)}, and
   * {@link DiscreteOrderItemFeePriceImpl#hashCode()}.
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
   * Test {@link DiscreteOrderItemFeePriceImpl#equals(Object)}, and
   * {@link DiscreteOrderItemFeePriceImpl#hashCode()}.
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
   * Test {@link DiscreteOrderItemFeePriceImpl#equals(Object)}, and
   * {@link DiscreteOrderItemFeePriceImpl#hashCode()}.
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
   * Test {@link DiscreteOrderItemFeePriceImpl#equals(Object)}, and
   * {@link DiscreteOrderItemFeePriceImpl#hashCode()}.
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
   * Test {@link DiscreteOrderItemFeePriceImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link DiscreteOrderItemFeePriceImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link DiscreteOrderItemFeePriceImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link DiscreteOrderItemFeePriceImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link DiscreteOrderItemFeePriceImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link DiscreteOrderItemFeePriceImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link DiscreteOrderItemFeePriceImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link DiscreteOrderItemFeePriceImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link DiscreteOrderItemFeePriceImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link DiscreteOrderItemFeePriceImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test getters and setters.
   * <p>
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

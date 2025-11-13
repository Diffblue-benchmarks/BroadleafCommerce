package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.util.Currency;
import org.broadleafcommerce.common.money.Money;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DiscreteOrderItemFeePriceImplDiffblueTest {
  /**
   * Test {@link DiscreteOrderItemFeePriceImpl#convertToMoney(BigDecimal)}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code US Dollar}.
   * </ul>
   *
   * <p>Method under test: {@link DiscreteOrderItemFeePriceImpl#convertToMoney(BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money DiscreteOrderItemFeePriceImpl.convertToMoney(BigDecimal)"})
  public void testConvertToMoney_thenReturnCurrencyDisplayNameIsUsDollar() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl =
        new DiscreteOrderItemFeePriceImpl();

    // Act
    Money actualConvertToMoneyResult =
        discreteOrderItemFeePriceImpl.convertToMoney(new BigDecimal("2.3"));

    // Assert
    Currency currency = actualConvertToMoneyResult.getCurrency();
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.getSymbol());
    assertEquals("USD", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
    assertEquals(new BigDecimal("2.30"), actualConvertToMoneyResult.getAmount());
    Money actualAbsResult = actualConvertToMoneyResult.abs();
    assertEquals(actualConvertToMoneyResult, actualAbsResult);
    assertEquals(Money.ZERO, actualConvertToMoneyResult.zero());
  }

  /**
   * Test {@link DiscreteOrderItemFeePriceImpl#convertToMoney(BigDecimal)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DiscreteOrderItemFeePriceImpl#convertToMoney(BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money DiscreteOrderItemFeePriceImpl.convertToMoney(BigDecimal)"})
  public void testConvertToMoney_thenReturnNull() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl =
        new DiscreteOrderItemFeePriceImpl();
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
   *
   * <ul>
   *   <li>Then DiscreteOrderItem return {@link DiscreteOrderItemImpl}.
   * </ul>
   *
   * <p>Method under test: {@link DiscreteOrderItemFeePriceImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DiscreteOrderItemFeePrice DiscreteOrderItemFeePriceImpl.clone()"})
  public void testClone_thenDiscreteOrderItemReturnDiscreteOrderItemImpl() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl =
        new DiscreteOrderItemFeePriceImpl();
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
    assertEquals(
        new BigDecimal("0.00"), ((DiscreteOrderItemFeePriceImpl) actualCloneResult).amount);
    assertEquals(amount, actualCloneResult.getAmount());
    assertSame(discreteOrderItem, discreteOrderItem2);
  }

  /**
   * Test {@link DiscreteOrderItemFeePriceImpl#clone()}.
   *
   * <ul>
   *   <li>Then return {@link DiscreteOrderItemFeePriceImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DiscreteOrderItemFeePriceImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DiscreteOrderItemFeePrice DiscreteOrderItemFeePriceImpl.clone()"})
  public void testClone_thenReturnDiscreteOrderItemFeePriceImpl() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl =
        new DiscreteOrderItemFeePriceImpl();

    // Act
    DiscreteOrderItemFeePrice actualCloneResult = discreteOrderItemFeePriceImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof DiscreteOrderItemFeePriceImpl);
    assertEquals(discreteOrderItemFeePriceImpl, actualCloneResult);
  }

  /**
   * Test {@link DiscreteOrderItemFeePriceImpl#equals(Object)}, and {@link
   * DiscreteOrderItemFeePriceImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   *   <li>{@link DiscreteOrderItemFeePriceImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DiscreteOrderItemFeePriceImpl.equals(Object)",
    "int DiscreteOrderItemFeePriceImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl =
        new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl.setAmount(new Money());
    discreteOrderItemFeePriceImpl.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl.setName("Name");
    discreteOrderItemFeePriceImpl.setReportingCode("Reporting Code");

    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl2 =
        new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl2.setAmount(new Money());
    discreteOrderItemFeePriceImpl2.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl2.setName("Name");
    discreteOrderItemFeePriceImpl2.setReportingCode("Reporting Code");

    // Act and Assert
    assertEquals(discreteOrderItemFeePriceImpl, discreteOrderItemFeePriceImpl2);
    assertEquals(
        discreteOrderItemFeePriceImpl.hashCode(), discreteOrderItemFeePriceImpl2.hashCode());
  }

  /**
   * Test {@link DiscreteOrderItemFeePriceImpl#equals(Object)}, and {@link
   * DiscreteOrderItemFeePriceImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   *   <li>{@link DiscreteOrderItemFeePriceImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DiscreteOrderItemFeePriceImpl.equals(Object)",
    "int DiscreteOrderItemFeePriceImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl =
        new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl.setAmount(null);
    discreteOrderItemFeePriceImpl.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl.setName("Name");
    discreteOrderItemFeePriceImpl.setReportingCode("Reporting Code");

    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl2 =
        new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl2.setAmount(null);
    discreteOrderItemFeePriceImpl2.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl2.setName("Name");
    discreteOrderItemFeePriceImpl2.setReportingCode("Reporting Code");

    // Act and Assert
    assertEquals(discreteOrderItemFeePriceImpl, discreteOrderItemFeePriceImpl2);
    assertEquals(
        discreteOrderItemFeePriceImpl.hashCode(), discreteOrderItemFeePriceImpl2.hashCode());
  }

  /**
   * Test {@link DiscreteOrderItemFeePriceImpl#equals(Object)}, and {@link
   * DiscreteOrderItemFeePriceImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   *   <li>{@link DiscreteOrderItemFeePriceImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DiscreteOrderItemFeePriceImpl.equals(Object)",
    "int DiscreteOrderItemFeePriceImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl =
        new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl.setAmount(new Money());
    discreteOrderItemFeePriceImpl.setDiscreteOrderItem(null);
    discreteOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl.setName("Name");
    discreteOrderItemFeePriceImpl.setReportingCode("Reporting Code");

    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl2 =
        new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl2.setAmount(new Money());
    discreteOrderItemFeePriceImpl2.setDiscreteOrderItem(null);
    discreteOrderItemFeePriceImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl2.setName("Name");
    discreteOrderItemFeePriceImpl2.setReportingCode("Reporting Code");

    // Act and Assert
    assertEquals(discreteOrderItemFeePriceImpl, discreteOrderItemFeePriceImpl2);
    assertEquals(
        discreteOrderItemFeePriceImpl.hashCode(), discreteOrderItemFeePriceImpl2.hashCode());
  }

  /**
   * Test {@link DiscreteOrderItemFeePriceImpl#equals(Object)}, and {@link
   * DiscreteOrderItemFeePriceImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   *   <li>{@link DiscreteOrderItemFeePriceImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DiscreteOrderItemFeePriceImpl.equals(Object)",
    "int DiscreteOrderItemFeePriceImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl =
        new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl.setAmount(new Money());
    discreteOrderItemFeePriceImpl.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl.setId(null);
    discreteOrderItemFeePriceImpl.setName("Name");
    discreteOrderItemFeePriceImpl.setReportingCode("Reporting Code");

    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl2 =
        new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl2.setAmount(new Money());
    discreteOrderItemFeePriceImpl2.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl2.setId(null);
    discreteOrderItemFeePriceImpl2.setName("Name");
    discreteOrderItemFeePriceImpl2.setReportingCode("Reporting Code");

    // Act and Assert
    assertEquals(discreteOrderItemFeePriceImpl, discreteOrderItemFeePriceImpl2);
    assertEquals(
        discreteOrderItemFeePriceImpl.hashCode(), discreteOrderItemFeePriceImpl2.hashCode());
  }

  /**
   * Test {@link DiscreteOrderItemFeePriceImpl#equals(Object)}, and {@link
   * DiscreteOrderItemFeePriceImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   *   <li>{@link DiscreteOrderItemFeePriceImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DiscreteOrderItemFeePriceImpl.equals(Object)",
    "int DiscreteOrderItemFeePriceImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl =
        new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl.setAmount(new Money());
    discreteOrderItemFeePriceImpl.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl.setName(null);
    discreteOrderItemFeePriceImpl.setReportingCode("Reporting Code");

    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl2 =
        new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl2.setAmount(new Money());
    discreteOrderItemFeePriceImpl2.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl2.setName(null);
    discreteOrderItemFeePriceImpl2.setReportingCode("Reporting Code");

    // Act and Assert
    assertEquals(discreteOrderItemFeePriceImpl, discreteOrderItemFeePriceImpl2);
    assertEquals(
        discreteOrderItemFeePriceImpl.hashCode(), discreteOrderItemFeePriceImpl2.hashCode());
  }

  /**
   * Test {@link DiscreteOrderItemFeePriceImpl#equals(Object)}, and {@link
   * DiscreteOrderItemFeePriceImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   *   <li>{@link DiscreteOrderItemFeePriceImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DiscreteOrderItemFeePriceImpl.equals(Object)",
    "int DiscreteOrderItemFeePriceImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl =
        new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl.setAmount(new Money());
    discreteOrderItemFeePriceImpl.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl.setName("Name");
    discreteOrderItemFeePriceImpl.setReportingCode(null);

    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl2 =
        new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl2.setAmount(new Money());
    discreteOrderItemFeePriceImpl2.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl2.setName("Name");
    discreteOrderItemFeePriceImpl2.setReportingCode(null);

    // Act and Assert
    assertEquals(discreteOrderItemFeePriceImpl, discreteOrderItemFeePriceImpl2);
    assertEquals(
        discreteOrderItemFeePriceImpl.hashCode(), discreteOrderItemFeePriceImpl2.hashCode());
  }

  /**
   * Test {@link DiscreteOrderItemFeePriceImpl#equals(Object)}, and {@link
   * DiscreteOrderItemFeePriceImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   *   <li>{@link DiscreteOrderItemFeePriceImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DiscreteOrderItemFeePriceImpl.equals(Object)",
    "int DiscreteOrderItemFeePriceImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl =
        new DiscreteOrderItemFeePriceImpl();
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DiscreteOrderItemFeePriceImpl.equals(Object)",
    "int DiscreteOrderItemFeePriceImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl =
        new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl.setAmount(null);
    discreteOrderItemFeePriceImpl.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl.setName("Name");
    discreteOrderItemFeePriceImpl.setReportingCode("Reporting Code");

    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl2 =
        new DiscreteOrderItemFeePriceImpl();
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DiscreteOrderItemFeePriceImpl.equals(Object)",
    "int DiscreteOrderItemFeePriceImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl =
        new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl.setAmount(new Money(10.0d));
    discreteOrderItemFeePriceImpl.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl.setName("Name");
    discreteOrderItemFeePriceImpl.setReportingCode("Reporting Code");

    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl2 =
        new DiscreteOrderItemFeePriceImpl();
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DiscreteOrderItemFeePriceImpl.equals(Object)",
    "int DiscreteOrderItemFeePriceImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl =
        new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl.setAmount(new Money());
    discreteOrderItemFeePriceImpl.setDiscreteOrderItem(new DynamicPriceDiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl.setName("Name");
    discreteOrderItemFeePriceImpl.setReportingCode("Reporting Code");

    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl2 =
        new DiscreteOrderItemFeePriceImpl();
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DiscreteOrderItemFeePriceImpl.equals(Object)",
    "int DiscreteOrderItemFeePriceImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl =
        new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl.setAmount(new Money());
    discreteOrderItemFeePriceImpl.setDiscreteOrderItem(null);
    discreteOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl.setName("Name");
    discreteOrderItemFeePriceImpl.setReportingCode("Reporting Code");

    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl2 =
        new DiscreteOrderItemFeePriceImpl();
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DiscreteOrderItemFeePriceImpl.equals(Object)",
    "int DiscreteOrderItemFeePriceImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl =
        new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl.setAmount(new Money());
    discreteOrderItemFeePriceImpl.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl.setId(2L);
    discreteOrderItemFeePriceImpl.setName("Name");
    discreteOrderItemFeePriceImpl.setReportingCode("Reporting Code");

    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl2 =
        new DiscreteOrderItemFeePriceImpl();
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DiscreteOrderItemFeePriceImpl.equals(Object)",
    "int DiscreteOrderItemFeePriceImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl =
        new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl.setAmount(new Money());
    discreteOrderItemFeePriceImpl.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl.setId(null);
    discreteOrderItemFeePriceImpl.setName("Name");
    discreteOrderItemFeePriceImpl.setReportingCode("Reporting Code");

    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl2 =
        new DiscreteOrderItemFeePriceImpl();
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DiscreteOrderItemFeePriceImpl.equals(Object)",
    "int DiscreteOrderItemFeePriceImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl =
        new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl.setAmount(new Money());
    discreteOrderItemFeePriceImpl.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl.setName("Reporting Code");
    discreteOrderItemFeePriceImpl.setReportingCode("Reporting Code");

    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl2 =
        new DiscreteOrderItemFeePriceImpl();
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DiscreteOrderItemFeePriceImpl.equals(Object)",
    "int DiscreteOrderItemFeePriceImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl =
        new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl.setAmount(new Money());
    discreteOrderItemFeePriceImpl.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl.setName(null);
    discreteOrderItemFeePriceImpl.setReportingCode("Reporting Code");

    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl2 =
        new DiscreteOrderItemFeePriceImpl();
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DiscreteOrderItemFeePriceImpl.equals(Object)",
    "int DiscreteOrderItemFeePriceImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl =
        new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl.setAmount(new Money());
    discreteOrderItemFeePriceImpl.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl.setName("Name");
    discreteOrderItemFeePriceImpl.setReportingCode("Name");

    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl2 =
        new DiscreteOrderItemFeePriceImpl();
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DiscreteOrderItemFeePriceImpl.equals(Object)",
    "int DiscreteOrderItemFeePriceImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl =
        new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl.setAmount(new Money());
    discreteOrderItemFeePriceImpl.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl.setName("Name");
    discreteOrderItemFeePriceImpl.setReportingCode(null);

    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl2 =
        new DiscreteOrderItemFeePriceImpl();
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
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DiscreteOrderItemFeePriceImpl.equals(Object)",
    "int DiscreteOrderItemFeePriceImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl =
        new DiscreteOrderItemFeePriceImpl();
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
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DiscreteOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DiscreteOrderItemFeePriceImpl.equals(Object)",
    "int DiscreteOrderItemFeePriceImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DiscreteOrderItemFeePriceImpl discreteOrderItemFeePriceImpl =
        new DiscreteOrderItemFeePriceImpl();
    discreteOrderItemFeePriceImpl.setAmount(new Money());
    discreteOrderItemFeePriceImpl.setDiscreteOrderItem(new DiscreteOrderItemImpl());
    discreteOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemFeePriceImpl.setName("Name");
    discreteOrderItemFeePriceImpl.setReportingCode("Reporting Code");

    // Act and Assert
    assertNotEquals(
        discreteOrderItemFeePriceImpl, "Different type to DiscreteOrderItemFeePriceImpl");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DiscreteOrderItemFeePriceImpl.<init>()",
    "DiscreteOrderItem DiscreteOrderItemFeePriceImpl.getDiscreteOrderItem()",
    "Long DiscreteOrderItemFeePriceImpl.getId()",
    "String DiscreteOrderItemFeePriceImpl.getName()",
    "String DiscreteOrderItemFeePriceImpl.getReportingCode()",
    "void DiscreteOrderItemFeePriceImpl.setDiscreteOrderItem(DiscreteOrderItem)",
    "void DiscreteOrderItemFeePriceImpl.setId(Long)",
    "void DiscreteOrderItemFeePriceImpl.setName(String)",
    "void DiscreteOrderItemFeePriceImpl.setReportingCode(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    DiscreteOrderItemFeePriceImpl actualDiscreteOrderItemFeePriceImpl =
        new DiscreteOrderItemFeePriceImpl();
    DiscreteOrderItemImpl discreteOrderItem = new DiscreteOrderItemImpl();
    actualDiscreteOrderItemFeePriceImpl.setDiscreteOrderItem(discreteOrderItem);
    actualDiscreteOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    actualDiscreteOrderItemFeePriceImpl.setName("Name");
    actualDiscreteOrderItemFeePriceImpl.setReportingCode("Reporting Code");
    DiscreteOrderItem actualDiscreteOrderItem =
        actualDiscreteOrderItemFeePriceImpl.getDiscreteOrderItem();
    Long actualId = actualDiscreteOrderItemFeePriceImpl.getId();
    String actualName = actualDiscreteOrderItemFeePriceImpl.getName();

    // Assert
    assertEquals("Name", actualName);
    assertEquals("Reporting Code", actualDiscreteOrderItemFeePriceImpl.getReportingCode());
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualId.longValue());
    assertSame(discreteOrderItem, actualDiscreteOrderItem);
  }
}

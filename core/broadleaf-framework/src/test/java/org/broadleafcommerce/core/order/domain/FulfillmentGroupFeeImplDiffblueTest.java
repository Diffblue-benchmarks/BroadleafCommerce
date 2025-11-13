package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.money.Money;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FulfillmentGroupFeeImplDiffblueTest {
  /**
   * Test {@link FulfillmentGroupFeeImpl#equals(Object)}, and {@link
   * FulfillmentGroupFeeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupFeeImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupFeeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupFeeImpl.equals(Object)",
    "int FulfillmentGroupFeeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(new Money());
    fulfillmentGroupFeeImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl.setName("Name");
    fulfillmentGroupFeeImpl.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());

    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl2 = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl2.setAmount(new Money());
    fulfillmentGroupFeeImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl2.setName("Name");
    fulfillmentGroupFeeImpl2.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl2.setTaxable(true);
    fulfillmentGroupFeeImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl2.setTotalTax(new Money());

    // Act and Assert
    assertEquals(fulfillmentGroupFeeImpl, fulfillmentGroupFeeImpl2);
    assertEquals(fulfillmentGroupFeeImpl.hashCode(), fulfillmentGroupFeeImpl2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupFeeImpl#equals(Object)}, and {@link
   * FulfillmentGroupFeeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupFeeImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupFeeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupFeeImpl.equals(Object)",
    "int FulfillmentGroupFeeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(null);
    fulfillmentGroupFeeImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl.setName("Name");
    fulfillmentGroupFeeImpl.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());

    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl2 = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl2.setAmount(null);
    fulfillmentGroupFeeImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl2.setName("Name");
    fulfillmentGroupFeeImpl2.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl2.setTaxable(true);
    fulfillmentGroupFeeImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl2.setTotalTax(new Money());

    // Act and Assert
    assertEquals(fulfillmentGroupFeeImpl, fulfillmentGroupFeeImpl2);
    assertEquals(fulfillmentGroupFeeImpl.hashCode(), fulfillmentGroupFeeImpl2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupFeeImpl#equals(Object)}, and {@link
   * FulfillmentGroupFeeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupFeeImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupFeeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupFeeImpl.equals(Object)",
    "int FulfillmentGroupFeeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(new Money());
    fulfillmentGroupFeeImpl.setFulfillmentGroup(null);
    fulfillmentGroupFeeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl.setName("Name");
    fulfillmentGroupFeeImpl.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());

    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl2 = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl2.setAmount(new Money());
    fulfillmentGroupFeeImpl2.setFulfillmentGroup(null);
    fulfillmentGroupFeeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl2.setName("Name");
    fulfillmentGroupFeeImpl2.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl2.setTaxable(true);
    fulfillmentGroupFeeImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl2.setTotalTax(new Money());

    // Act and Assert
    assertEquals(fulfillmentGroupFeeImpl, fulfillmentGroupFeeImpl2);
    assertEquals(fulfillmentGroupFeeImpl.hashCode(), fulfillmentGroupFeeImpl2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupFeeImpl#equals(Object)}, and {@link
   * FulfillmentGroupFeeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupFeeImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupFeeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupFeeImpl.equals(Object)",
    "int FulfillmentGroupFeeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(new Money());
    fulfillmentGroupFeeImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl.setId(null);
    fulfillmentGroupFeeImpl.setName("Name");
    fulfillmentGroupFeeImpl.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());

    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl2 = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl2.setAmount(new Money());
    fulfillmentGroupFeeImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl2.setId(null);
    fulfillmentGroupFeeImpl2.setName("Name");
    fulfillmentGroupFeeImpl2.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl2.setTaxable(true);
    fulfillmentGroupFeeImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl2.setTotalTax(new Money());

    // Act and Assert
    assertEquals(fulfillmentGroupFeeImpl, fulfillmentGroupFeeImpl2);
    assertEquals(fulfillmentGroupFeeImpl.hashCode(), fulfillmentGroupFeeImpl2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupFeeImpl#equals(Object)}, and {@link
   * FulfillmentGroupFeeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupFeeImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupFeeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupFeeImpl.equals(Object)",
    "int FulfillmentGroupFeeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(new Money());
    fulfillmentGroupFeeImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl.setName(null);
    fulfillmentGroupFeeImpl.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());

    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl2 = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl2.setAmount(new Money());
    fulfillmentGroupFeeImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl2.setName(null);
    fulfillmentGroupFeeImpl2.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl2.setTaxable(true);
    fulfillmentGroupFeeImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl2.setTotalTax(new Money());

    // Act and Assert
    assertEquals(fulfillmentGroupFeeImpl, fulfillmentGroupFeeImpl2);
    assertEquals(fulfillmentGroupFeeImpl.hashCode(), fulfillmentGroupFeeImpl2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupFeeImpl#equals(Object)}, and {@link
   * FulfillmentGroupFeeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupFeeImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupFeeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupFeeImpl.equals(Object)",
    "int FulfillmentGroupFeeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(new Money());
    fulfillmentGroupFeeImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl.setName("Name");
    fulfillmentGroupFeeImpl.setReportingCode(null);
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());

    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl2 = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl2.setAmount(new Money());
    fulfillmentGroupFeeImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl2.setName("Name");
    fulfillmentGroupFeeImpl2.setReportingCode(null);
    fulfillmentGroupFeeImpl2.setTaxable(true);
    fulfillmentGroupFeeImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl2.setTotalTax(new Money());

    // Act and Assert
    assertEquals(fulfillmentGroupFeeImpl, fulfillmentGroupFeeImpl2);
    assertEquals(fulfillmentGroupFeeImpl.hashCode(), fulfillmentGroupFeeImpl2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupFeeImpl#equals(Object)}, and {@link
   * FulfillmentGroupFeeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupFeeImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupFeeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupFeeImpl.equals(Object)",
    "int FulfillmentGroupFeeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(new Money());
    fulfillmentGroupFeeImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl.setName("Name");
    fulfillmentGroupFeeImpl.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());

    // Act and Assert
    assertEquals(fulfillmentGroupFeeImpl, fulfillmentGroupFeeImpl);
    int expectedHashCodeResult = fulfillmentGroupFeeImpl.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentGroupFeeImpl.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupFeeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupFeeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupFeeImpl.equals(Object)",
    "int FulfillmentGroupFeeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(null);
    fulfillmentGroupFeeImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl.setName("Name");
    fulfillmentGroupFeeImpl.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());

    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl2 = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl2.setAmount(new Money());
    fulfillmentGroupFeeImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl2.setName("Name");
    fulfillmentGroupFeeImpl2.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl2.setTaxable(true);
    fulfillmentGroupFeeImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl2.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupFeeImpl, fulfillmentGroupFeeImpl2);
  }

  /**
   * Test {@link FulfillmentGroupFeeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupFeeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupFeeImpl.equals(Object)",
    "int FulfillmentGroupFeeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(new Money(10.0d));
    fulfillmentGroupFeeImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl.setName("Name");
    fulfillmentGroupFeeImpl.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());

    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl2 = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl2.setAmount(new Money());
    fulfillmentGroupFeeImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl2.setName("Name");
    fulfillmentGroupFeeImpl2.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl2.setTaxable(true);
    fulfillmentGroupFeeImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl2.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupFeeImpl, fulfillmentGroupFeeImpl2);
  }

  /**
   * Test {@link FulfillmentGroupFeeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupFeeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupFeeImpl.equals(Object)",
    "int FulfillmentGroupFeeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(new Money());
    fulfillmentGroupFeeImpl.setFulfillmentGroup(null);
    fulfillmentGroupFeeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl.setName("Name");
    fulfillmentGroupFeeImpl.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());

    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl2 = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl2.setAmount(new Money());
    fulfillmentGroupFeeImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl2.setName("Name");
    fulfillmentGroupFeeImpl2.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl2.setTaxable(true);
    fulfillmentGroupFeeImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl2.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupFeeImpl, fulfillmentGroupFeeImpl2);
  }

  /**
   * Test {@link FulfillmentGroupFeeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupFeeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupFeeImpl.equals(Object)",
    "int FulfillmentGroupFeeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(new Money());
    fulfillmentGroupFeeImpl.setFulfillmentGroup(mock(FulfillmentGroupImpl.class));
    fulfillmentGroupFeeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl.setName("Name");
    fulfillmentGroupFeeImpl.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());

    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl2 = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl2.setAmount(new Money());
    fulfillmentGroupFeeImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl2.setName("Name");
    fulfillmentGroupFeeImpl2.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl2.setTaxable(true);
    fulfillmentGroupFeeImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl2.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupFeeImpl, fulfillmentGroupFeeImpl2);
  }

  /**
   * Test {@link FulfillmentGroupFeeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupFeeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupFeeImpl.equals(Object)",
    "int FulfillmentGroupFeeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(new Money());
    fulfillmentGroupFeeImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl.setId(2L);
    fulfillmentGroupFeeImpl.setName("Name");
    fulfillmentGroupFeeImpl.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());

    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl2 = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl2.setAmount(new Money());
    fulfillmentGroupFeeImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl2.setName("Name");
    fulfillmentGroupFeeImpl2.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl2.setTaxable(true);
    fulfillmentGroupFeeImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl2.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupFeeImpl, fulfillmentGroupFeeImpl2);
  }

  /**
   * Test {@link FulfillmentGroupFeeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupFeeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupFeeImpl.equals(Object)",
    "int FulfillmentGroupFeeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(new Money());
    fulfillmentGroupFeeImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl.setId(null);
    fulfillmentGroupFeeImpl.setName("Name");
    fulfillmentGroupFeeImpl.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());

    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl2 = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl2.setAmount(new Money());
    fulfillmentGroupFeeImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl2.setName("Name");
    fulfillmentGroupFeeImpl2.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl2.setTaxable(true);
    fulfillmentGroupFeeImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl2.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupFeeImpl, fulfillmentGroupFeeImpl2);
  }

  /**
   * Test {@link FulfillmentGroupFeeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupFeeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupFeeImpl.equals(Object)",
    "int FulfillmentGroupFeeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(new Money());
    fulfillmentGroupFeeImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl.setName("Reporting Code");
    fulfillmentGroupFeeImpl.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());

    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl2 = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl2.setAmount(new Money());
    fulfillmentGroupFeeImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl2.setName("Name");
    fulfillmentGroupFeeImpl2.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl2.setTaxable(true);
    fulfillmentGroupFeeImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl2.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupFeeImpl, fulfillmentGroupFeeImpl2);
  }

  /**
   * Test {@link FulfillmentGroupFeeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupFeeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupFeeImpl.equals(Object)",
    "int FulfillmentGroupFeeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(new Money());
    fulfillmentGroupFeeImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl.setName(null);
    fulfillmentGroupFeeImpl.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());

    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl2 = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl2.setAmount(new Money());
    fulfillmentGroupFeeImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl2.setName("Name");
    fulfillmentGroupFeeImpl2.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl2.setTaxable(true);
    fulfillmentGroupFeeImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl2.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupFeeImpl, fulfillmentGroupFeeImpl2);
  }

  /**
   * Test {@link FulfillmentGroupFeeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupFeeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupFeeImpl.equals(Object)",
    "int FulfillmentGroupFeeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(new Money());
    fulfillmentGroupFeeImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl.setName("Name");
    fulfillmentGroupFeeImpl.setReportingCode("Name");
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());

    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl2 = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl2.setAmount(new Money());
    fulfillmentGroupFeeImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl2.setName("Name");
    fulfillmentGroupFeeImpl2.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl2.setTaxable(true);
    fulfillmentGroupFeeImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl2.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupFeeImpl, fulfillmentGroupFeeImpl2);
  }

  /**
   * Test {@link FulfillmentGroupFeeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupFeeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupFeeImpl.equals(Object)",
    "int FulfillmentGroupFeeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(new Money());
    fulfillmentGroupFeeImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl.setName("Name");
    fulfillmentGroupFeeImpl.setReportingCode(null);
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());

    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl2 = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl2.setAmount(new Money());
    fulfillmentGroupFeeImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl2.setName("Name");
    fulfillmentGroupFeeImpl2.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl2.setTaxable(true);
    fulfillmentGroupFeeImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl2.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupFeeImpl, fulfillmentGroupFeeImpl2);
  }

  /**
   * Test {@link FulfillmentGroupFeeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupFeeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupFeeImpl.equals(Object)",
    "int FulfillmentGroupFeeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(new Money());
    fulfillmentGroupFeeImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl.setName("Name");
    fulfillmentGroupFeeImpl.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupFeeImpl, null);
  }

  /**
   * Test {@link FulfillmentGroupFeeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupFeeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupFeeImpl.equals(Object)",
    "int FulfillmentGroupFeeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(new Money());
    fulfillmentGroupFeeImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl.setName("Name");
    fulfillmentGroupFeeImpl.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupFeeImpl, "Different type to FulfillmentGroupFeeImpl");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link FulfillmentGroupFeeImpl}
   *   <li>{@link FulfillmentGroupFeeImpl#setFulfillmentGroup(FulfillmentGroup)}
   *   <li>{@link FulfillmentGroupFeeImpl#setId(Long)}
   *   <li>{@link FulfillmentGroupFeeImpl#setName(String)}
   *   <li>{@link FulfillmentGroupFeeImpl#setReportingCode(String)}
   *   <li>{@link FulfillmentGroupFeeImpl#setTaxable(Boolean)}
   *   <li>{@link FulfillmentGroupFeeImpl#setTaxes(List)}
   *   <li>{@link FulfillmentGroupFeeImpl#getFulfillmentGroup()}
   *   <li>{@link FulfillmentGroupFeeImpl#getId()}
   *   <li>{@link FulfillmentGroupFeeImpl#getName()}
   *   <li>{@link FulfillmentGroupFeeImpl#getReportingCode()}
   *   <li>{@link FulfillmentGroupFeeImpl#getTaxes()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FulfillmentGroupFeeImpl.<init>()",
    "FulfillmentGroup FulfillmentGroupFeeImpl.getFulfillmentGroup()",
    "Long FulfillmentGroupFeeImpl.getId()",
    "String FulfillmentGroupFeeImpl.getName()",
    "String FulfillmentGroupFeeImpl.getReportingCode()",
    "List FulfillmentGroupFeeImpl.getTaxes()",
    "void FulfillmentGroupFeeImpl.setFulfillmentGroup(FulfillmentGroup)",
    "void FulfillmentGroupFeeImpl.setId(Long)",
    "void FulfillmentGroupFeeImpl.setName(String)",
    "void FulfillmentGroupFeeImpl.setReportingCode(String)",
    "void FulfillmentGroupFeeImpl.setTaxable(Boolean)",
    "void FulfillmentGroupFeeImpl.setTaxes(List)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    FulfillmentGroupFeeImpl actualFulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    actualFulfillmentGroupFeeImpl.setFulfillmentGroup(fulfillmentGroup);
    actualFulfillmentGroupFeeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    actualFulfillmentGroupFeeImpl.setName("Name");
    actualFulfillmentGroupFeeImpl.setReportingCode("Reporting Code");
    actualFulfillmentGroupFeeImpl.setTaxable(true);
    ArrayList<TaxDetail> taxes = new ArrayList<>();
    actualFulfillmentGroupFeeImpl.setTaxes(taxes);
    FulfillmentGroup actualFulfillmentGroup = actualFulfillmentGroupFeeImpl.getFulfillmentGroup();
    Long actualId = actualFulfillmentGroupFeeImpl.getId();
    String actualName = actualFulfillmentGroupFeeImpl.getName();
    String actualReportingCode = actualFulfillmentGroupFeeImpl.getReportingCode();
    List<TaxDetail> actualTaxes = actualFulfillmentGroupFeeImpl.getTaxes();

    // Assert
    assertEquals("Name", actualName);
    assertEquals("Reporting Code", actualReportingCode);
    assertTrue(actualTaxes.isEmpty());
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualId.longValue());
    assertSame(taxes, actualTaxes);
    assertSame(fulfillmentGroup, actualFulfillmentGroup);
  }
}

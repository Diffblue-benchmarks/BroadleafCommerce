package org.broadleafcommerce.core.offer.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.OrderItemPriceDetail;
import org.broadleafcommerce.core.order.domain.OrderItemPriceDetailImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderItemPriceDetailAdjustmentImplDiffblueTest {
  @Autowired private OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#setAppliedToSalePrice(boolean)}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#setId(Long)}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#setOfferName(String)}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#setOrderItemPriceDetail(OrderItemPriceDetail)}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#setRetailPriceValue(Money)}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#setSalesPriceValue(Money)}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#getId()}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#getOfferName()}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#getOrderItemPriceDetail()}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#getReason()}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#isAppliedToSalePrice()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long OrderItemPriceDetailAdjustmentImpl.getId()",
    "String OrderItemPriceDetailAdjustmentImpl.getOfferName()",
    "OrderItemPriceDetail OrderItemPriceDetailAdjustmentImpl.getOrderItemPriceDetail()",
    "String OrderItemPriceDetailAdjustmentImpl.getReason()",
    "boolean OrderItemPriceDetailAdjustmentImpl.isAppliedToSalePrice()",
    "void OrderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(boolean)",
    "void OrderItemPriceDetailAdjustmentImpl.setId(Long)",
    "void OrderItemPriceDetailAdjustmentImpl.setOfferName(String)",
    "void OrderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(OrderItemPriceDetail)",
    "void OrderItemPriceDetailAdjustmentImpl.setRetailPriceValue(Money)",
    "void OrderItemPriceDetailAdjustmentImpl.setSalesPriceValue(Money)"
  })
  public void testGettersAndSetters() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl =
        new OrderItemPriceDetailAdjustmentImpl();

    // Act
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    OrderItemPriceDetailImpl orderItemPriceDetail = new OrderItemPriceDetailImpl();
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(orderItemPriceDetail);
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    Long actualId = orderItemPriceDetailAdjustmentImpl.getId();
    String actualOfferName = orderItemPriceDetailAdjustmentImpl.getOfferName();
    OrderItemPriceDetail actualOrderItemPriceDetail =
        orderItemPriceDetailAdjustmentImpl.getOrderItemPriceDetail();
    String actualReason = orderItemPriceDetailAdjustmentImpl.getReason();

    // Assert
    assertEquals("Offer Name", actualOfferName);
    assertNull(actualReason);
    assertTrue(orderItemPriceDetailAdjustmentImpl.isAppliedToSalePrice());
    assertEquals(OrderItemPriceDetailAdjustmentImpl.serialVersionUID, actualId.longValue());
    assertSame(orderItemPriceDetail, actualOrderItemPriceDetail);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}, and {@link
   * OrderItemPriceDetailAdjustmentImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
    "int OrderItemPriceDetailAdjustmentImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(orderItemPriceDetailAdjustmentImpl, orderItemPriceDetailAdjustmentImpl2);
    assertNotEquals(
        orderItemPriceDetailAdjustmentImpl.hashCode(),
        orderItemPriceDetailAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}, and {@link
   * OrderItemPriceDetailAdjustmentImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
    "int OrderItemPriceDetailAdjustmentImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(null);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(null);
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(null);
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(orderItemPriceDetailAdjustmentImpl, orderItemPriceDetailAdjustmentImpl2);
    assertEquals(
        orderItemPriceDetailAdjustmentImpl.hashCode(),
        orderItemPriceDetailAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}, and {@link
   * OrderItemPriceDetailAdjustmentImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
    "int OrderItemPriceDetailAdjustmentImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(null);

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(null);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(null);
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(value);

    Money value2 = mock(Money.class);
    when(value2.getAmount()).thenReturn(null);

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(null);
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(value2);

    // Act and Assert
    assertEquals(orderItemPriceDetailAdjustmentImpl, orderItemPriceDetailAdjustmentImpl2);
    assertEquals(
        orderItemPriceDetailAdjustmentImpl.hashCode(),
        orderItemPriceDetailAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}, and {@link
   * OrderItemPriceDetailAdjustmentImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
    "int OrderItemPriceDetailAdjustmentImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    // Act and Assert
    assertEquals(orderItemPriceDetailAdjustmentImpl, orderItemPriceDetailAdjustmentImpl);
    int expectedHashCodeResult = orderItemPriceDetailAdjustmentImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderItemPriceDetailAdjustmentImpl.hashCode());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
    "int OrderItemPriceDetailAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(2L);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemPriceDetailAdjustmentImpl, orderItemPriceDetailAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
    "int OrderItemPriceDetailAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(null);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemPriceDetailAdjustmentImpl, orderItemPriceDetailAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
    "int OrderItemPriceDetailAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(null);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemPriceDetailAdjustmentImpl, orderItemPriceDetailAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
    "int OrderItemPriceDetailAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(null);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(null);
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemPriceDetailAdjustmentImpl, orderItemPriceDetailAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
    "int OrderItemPriceDetailAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(false);
    orderItemPriceDetailAdjustmentImpl.setId(null);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(null);
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(null);
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemPriceDetailAdjustmentImpl, orderItemPriceDetailAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
    "int OrderItemPriceDetailAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(null);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(null);
    orderItemPriceDetailAdjustmentImpl.setReason("Reason");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(null);
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemPriceDetailAdjustmentImpl, orderItemPriceDetailAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
    "int OrderItemPriceDetailAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(null);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(null);
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money(10.0d));

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(null);
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemPriceDetailAdjustmentImpl, orderItemPriceDetailAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
    "int OrderItemPriceDetailAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(null);

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(null);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(null);
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(value);

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(null);
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemPriceDetailAdjustmentImpl, orderItemPriceDetailAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
    "int OrderItemPriceDetailAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemPriceDetailAdjustmentImpl, null);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
    "int OrderItemPriceDetailAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    // Act and Assert
    assertNotEquals(
        orderItemPriceDetailAdjustmentImpl, "Different type to OrderItemPriceDetailAdjustmentImpl");
  }

  /**
   * Test new {@link OrderItemPriceDetailAdjustmentImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * OrderItemPriceDetailAdjustmentImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderItemPriceDetailAdjustmentImpl.<init>()"})
  public void testNewOrderItemPriceDetailAdjustmentImpl() {
    // Arrange and Act
    OrderItemPriceDetailAdjustmentImpl actualOrderItemPriceDetailAdjustmentImpl =
        new OrderItemPriceDetailAdjustmentImpl();

    // Assert
    assertNull(actualOrderItemPriceDetailAdjustmentImpl.getId());
    assertNull(actualOrderItemPriceDetailAdjustmentImpl.getOfferName());
    assertNull(actualOrderItemPriceDetailAdjustmentImpl.getReason());
    assertNull(actualOrderItemPriceDetailAdjustmentImpl.retailValue);
    assertNull(actualOrderItemPriceDetailAdjustmentImpl.salesValue);
    assertNull(actualOrderItemPriceDetailAdjustmentImpl.getOffer());
    assertNull(actualOrderItemPriceDetailAdjustmentImpl.deproxiedOffer);
    assertNull(actualOrderItemPriceDetailAdjustmentImpl.offer);
    assertNull(actualOrderItemPriceDetailAdjustmentImpl.getOrderItemPriceDetail());
    assertFalse(actualOrderItemPriceDetailAdjustmentImpl.isAppliedToSalePrice());
    assertFalse(actualOrderItemPriceDetailAdjustmentImpl.isFutureCredit);
    assertEquals(new BigDecimal("0.00"), actualOrderItemPriceDetailAdjustmentImpl.value);
  }
}

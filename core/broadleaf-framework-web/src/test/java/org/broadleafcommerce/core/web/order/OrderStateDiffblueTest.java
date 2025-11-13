package org.broadleafcommerce.core.web.order;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OrderStateDiffblueTest {
  /**
   * Test {@link OrderState#getOrder(Customer)}.
   *
   * <ul>
   *   <li>Given {@link OrderState} (default constructor).
   *   <li>When {@link CustomerImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderState#getOrder(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderState.getOrder(Customer)"})
  public void testGetOrder_givenOrderState_whenCustomerImpl_thenReturnNull() {
    // Arrange
    OrderState orderState = new OrderState();

    // Act and Assert
    assertNull(orderState.getOrder(new CustomerImpl()));
  }

  /**
   * Test {@link OrderState#setOrder(Customer, Order)}.
   *
   * <ul>
   *   <li>When {@link CustomerImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderState#setOrder(Customer, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderState.setOrder(Customer, Order)"})
  public void testSetOrder_whenCustomerImpl_thenReturnNull() {
    // Arrange
    OrderState orderState = new OrderState();

    // Act and Assert
    assertNull(orderState.setOrder(new CustomerImpl(), null));
  }

  /**
   * Test {@link OrderState#setOrder(Customer, Order)}.
   *
   * <ul>
   *   <li>When {@link CustomerImpl} (default constructor).
   *   <li>Then return {@link NullOrderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link OrderState#setOrder(Customer, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderState.setOrder(Customer, Order)"})
  public void testSetOrder_whenCustomerImpl_thenReturnNullOrderImpl() {
    // Arrange
    OrderState orderState = new OrderState();
    CustomerImpl customer = new CustomerImpl();

    // Act
    Order actualSetOrderResult = orderState.setOrder(customer, new NullOrderImpl());

    // Assert
    assertTrue(actualSetOrderResult instanceof NullOrderImpl);
    Money orderAdjustmentsValue = actualSetOrderResult.getOrderAdjustmentsValue();
    Money actualAbsResult = orderAdjustmentsValue.abs();
    assertEquals(orderAdjustmentsValue, actualAbsResult);
    Money actualZeroResult = orderAdjustmentsValue.zero();
    assertEquals(orderAdjustmentsValue, actualZeroResult);
    assertEquals(orderAdjustmentsValue, actualSetOrderResult.getSubTotal());
  }

  /**
   * Test {@link OrderState#setOrder(Customer, Order)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link NullOrderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link OrderState#setOrder(Customer, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderState.setOrder(Customer, Order)"})
  public void testSetOrder_whenNull_thenReturnNullOrderImpl() {
    // Arrange
    OrderState orderState = new OrderState();

    // Act
    Order actualSetOrderResult = orderState.setOrder(null, new NullOrderImpl());

    // Assert
    assertTrue(actualSetOrderResult instanceof NullOrderImpl);
    Money orderAdjustmentsValue = actualSetOrderResult.getOrderAdjustmentsValue();
    Money actualAbsResult = orderAdjustmentsValue.abs();
    assertEquals(orderAdjustmentsValue, actualAbsResult);
    Money actualZeroResult = orderAdjustmentsValue.zero();
    assertEquals(orderAdjustmentsValue, actualZeroResult);
    assertEquals(orderAdjustmentsValue, actualSetOrderResult.getSubTotal());
  }

  /**
   * Test new {@link OrderState} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link OrderState}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderState.<init>()"})
  public void testNewOrderState() {
    // Arrange, Act and Assert
    assertNull(new OrderState().orderDao);
  }
}

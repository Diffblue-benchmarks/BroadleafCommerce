package org.broadleafcommerce.core.web.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml",
    "/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
@ExtendWith(SpringExtension.class)
class OrderStateDiffblueTest {
  @Autowired
  private OrderState orderState;

  /**
   * Test {@link OrderState#getOrder(Customer)}.
   * <p>
   * Method under test: {@link OrderState#getOrder(Customer)}
   */
  @Test
  @DisplayName("Test getOrder(Customer)")
  @Disabled("TODO: Complete this test")
  void testGetOrder() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.order;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7493 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.order.OrderState orderState;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderState orderState2 = new OrderState();

    // Act
    orderState2.getOrder(new CustomerImpl());
  }

  /**
   * Test {@link OrderState#getOrder(Customer)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link CustomerImpl} {@link CustomerImpl#getId()} return one.</li>
   *   <li>Then calls {@link CustomerImpl#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderState#getOrder(Customer)}
   */
  @Test
  @DisplayName("Test getOrder(Customer); given one; when CustomerImpl getId() return one; then calls getId()")
  void testGetOrder_givenOne_whenCustomerImplGetIdReturnOne_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderState orderState = new OrderState();
    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getId()).thenReturn(1L);

    // Act
    Order actualOrder = orderState.getOrder(customer);

    // Assert
    verify(customer).getId();
    assertNull(actualOrder);
  }

  /**
   * Test {@link OrderState#getOrder(Customer)}.
   * <ul>
   *   <li>When {@link CustomerImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderState#getOrder(Customer)}
   */
  @Test
  @DisplayName("Test getOrder(Customer); when CustomerImpl (default constructor); then return 'null'")
  void testGetOrder_whenCustomerImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderState orderState = new OrderState();

    // Act and Assert
    assertNull(orderState.getOrder(new CustomerImpl()));
  }

  /**
   * Test {@link OrderState#setOrder(Customer, Order)}.
   * <p>
   * Method under test: {@link OrderState#setOrder(Customer, Order)}
   */
  @Test
  @DisplayName("Test setOrder(Customer, Order)")
  @Disabled("TODO: Complete this test")
  void testSetOrder() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.order;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7521 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.order.OrderState orderState;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderState orderState2 = new OrderState();
    CustomerImpl customer = new CustomerImpl();

    // Act
    orderState2.setOrder(customer, new NullOrderImpl());
  }

  /**
   * Test {@link OrderState#setOrder(Customer, Order)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link CustomerImpl} {@link CustomerImpl#getId()} return one.</li>
   *   <li>Then calls {@link CustomerImpl#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderState#setOrder(Customer, Order)}
   */
  @Test
  @DisplayName("Test setOrder(Customer, Order); given one; when CustomerImpl getId() return one; then calls getId()")
  void testSetOrder_givenOne_whenCustomerImplGetIdReturnOne_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderState orderState = new OrderState();
    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getId()).thenReturn(1L);

    // Act
    Order actualSetOrderResult = orderState.setOrder(customer, new NullOrderImpl());

    // Assert
    verify(customer).getId();
    assertTrue(actualSetOrderResult instanceof NullOrderImpl);
    Money orderAdjustmentsValue = actualSetOrderResult.getOrderAdjustmentsValue();
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.abs());
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.zero());
    assertEquals(orderAdjustmentsValue, actualSetOrderResult.getSubTotal());
  }

  /**
   * Test {@link OrderState#setOrder(Customer, Order)}.
   * <ul>
   *   <li>When {@link CustomerImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderState#setOrder(Customer, Order)}
   */
  @Test
  @DisplayName("Test setOrder(Customer, Order); when CustomerImpl (default constructor); then return 'null'")
  void testSetOrder_whenCustomerImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderState orderState = new OrderState();

    // Act and Assert
    assertNull(orderState.setOrder(new CustomerImpl(), null));
  }

  /**
   * Test {@link OrderState#setOrder(Customer, Order)}.
   * <ul>
   *   <li>When {@link CustomerImpl} (default constructor).</li>
   *   <li>Then return {@link NullOrderImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderState#setOrder(Customer, Order)}
   */
  @Test
  @DisplayName("Test setOrder(Customer, Order); when CustomerImpl (default constructor); then return NullOrderImpl")
  void testSetOrder_whenCustomerImpl_thenReturnNullOrderImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderState orderState = new OrderState();
    CustomerImpl customer = new CustomerImpl();

    // Act
    Order actualSetOrderResult = orderState.setOrder(customer, new NullOrderImpl());

    // Assert
    assertTrue(actualSetOrderResult instanceof NullOrderImpl);
    Money orderAdjustmentsValue = actualSetOrderResult.getOrderAdjustmentsValue();
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.abs());
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.zero());
    assertEquals(orderAdjustmentsValue, actualSetOrderResult.getSubTotal());
  }

  /**
   * Test {@link OrderState#setOrder(Customer, Order)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderState#setOrder(Customer, Order)}
   */
  @Test
  @DisplayName("Test setOrder(Customer, Order); when 'null'; then return 'null'")
  void testSetOrder_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OrderState()).setOrder(null, null));
  }

  /**
   * Test new {@link OrderState} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link OrderState}
   */
  @Test
  @DisplayName("Test new OrderState (default constructor)")
  void testNewOrderState() {
    // Arrange, Act and Assert
    assertNull((new OrderState()).orderDao);
  }
}

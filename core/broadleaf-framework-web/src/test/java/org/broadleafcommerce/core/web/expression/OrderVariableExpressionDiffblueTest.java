package org.broadleafcommerce.core.web.expression;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderVariableExpressionDiffblueTest {
  /**
   * Test {@link OrderVariableExpression#getNamedOrderForCurrentCustomer(String)}.
   * <p>
   * Method under test:
   * {@link OrderVariableExpression#getNamedOrderForCurrentCustomer(String)}
   */
  @Test
  @DisplayName("Test getNamedOrderForCurrentCustomer(String)")
  @Disabled("TODO: Complete this test")
  void testGetNamedOrderForCurrentCustomer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.web.expression.OrderVariableExpression.getNamedOrderForCustomer(OrderVariableExpression.java:52)
    //       at org.broadleafcommerce.core.web.expression.OrderVariableExpression.getNamedOrderForCurrentCustomer(OrderVariableExpression.java:48)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new OrderVariableExpression()).getNamedOrderForCurrentCustomer("Order Name");
  }

  /**
   * Test
   * {@link OrderVariableExpression#getNamedOrderForCustomer(String, Customer)}.
   * <ul>
   *   <li>When {@link CustomerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderVariableExpression#getNamedOrderForCustomer(String, Customer)}
   */
  @Test
  @DisplayName("Test getNamedOrderForCustomer(String, Customer); when CustomerImpl (default constructor)")
  @Disabled("TODO: Complete this test")
  void testGetNamedOrderForCustomer_whenCustomerImpl() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.web.expression.OrderVariableExpression.getNamedOrderForCustomer(OrderVariableExpression.java:52)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    OrderVariableExpression orderVariableExpression = new OrderVariableExpression();

    // Act
    orderVariableExpression.getNamedOrderForCustomer("Order Name", new CustomerImpl());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OrderVariableExpression}
   *   <li>{@link OrderVariableExpression#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("orders", (new OrderVariableExpression()).getName());
  }
}

package org.broadleafcommerce.profile.core.dto;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CustomerRuleHolderDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerRuleHolder#CustomerRuleHolder()}
   *   <li>{@link CustomerRuleHolder#setCustomerRule(String)}
   *   <li>{@link CustomerRuleHolder#getCustomerRule()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CustomerRuleHolder actualCustomerRuleHolder = new CustomerRuleHolder();
    actualCustomerRuleHolder.setCustomerRule("Customer Rule");

    // Assert that nothing has changed
    assertEquals("Customer Rule", actualCustomerRuleHolder.getCustomerRule());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code Customer Rule}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerRuleHolder#CustomerRuleHolder(String)}
   *   <li>{@link CustomerRuleHolder#setCustomerRule(String)}
   *   <li>{@link CustomerRuleHolder#getCustomerRule()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenCustomerRule() {
    // Arrange and Act
    CustomerRuleHolder actualCustomerRuleHolder = new CustomerRuleHolder("Customer Rule");
    actualCustomerRuleHolder.setCustomerRule("Customer Rule");

    // Assert that nothing has changed
    assertEquals("Customer Rule", actualCustomerRuleHolder.getCustomerRule());
  }
}

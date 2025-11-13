package org.broadleafcommerce.profile.core.dto;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CustomerRuleHolderDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerRuleHolder#CustomerRuleHolder()}
   *   <li>{@link CustomerRuleHolder#setCustomerRule(String)}
   *   <li>{@link CustomerRuleHolder#getCustomerRule()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CustomerRuleHolder.<init>()",
    "void CustomerRuleHolder.<init>(String)",
    "String CustomerRuleHolder.getCustomerRule()",
    "void CustomerRuleHolder.setCustomerRule(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    CustomerRuleHolder actualCustomerRuleHolder = new CustomerRuleHolder();
    actualCustomerRuleHolder.setCustomerRule("Customer Rule");

    // Assert
    assertEquals("Customer Rule", actualCustomerRuleHolder.getCustomerRule());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Customer Rule}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerRuleHolder#CustomerRuleHolder(String)}
   *   <li>{@link CustomerRuleHolder#setCustomerRule(String)}
   *   <li>{@link CustomerRuleHolder#getCustomerRule()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CustomerRuleHolder.<init>()",
    "void CustomerRuleHolder.<init>(String)",
    "String CustomerRuleHolder.getCustomerRule()",
    "void CustomerRuleHolder.setCustomerRule(String)"
  })
  public void testGettersAndSetters_whenCustomerRule() {
    // Arrange and Act
    CustomerRuleHolder actualCustomerRuleHolder = new CustomerRuleHolder("Customer Rule");
    actualCustomerRuleHolder.setCustomerRule("Customer Rule");

    // Assert
    assertEquals("Customer Rule", actualCustomerRuleHolder.getCustomerRule());
  }
}

package org.broadleafcommerce.core.web.expression;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OrderVariableExpressionDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link OrderVariableExpression}
   *   <li>{@link OrderVariableExpression#getName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderVariableExpression.<init>()",
    "java.lang.String OrderVariableExpression.getName()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("orders", new OrderVariableExpression().getName());
  }
}

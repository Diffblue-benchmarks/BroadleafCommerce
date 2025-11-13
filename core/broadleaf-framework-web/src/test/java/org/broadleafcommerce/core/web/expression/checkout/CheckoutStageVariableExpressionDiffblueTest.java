package org.broadleafcommerce.core.web.expression.checkout;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CheckoutStageVariableExpressionDiffblueTest {
  /**
   * Test {@link CheckoutStageVariableExpression#getName()}.
   *
   * <p>Method under test: {@link CheckoutStageVariableExpression#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String CheckoutStageVariableExpression.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("checkoutStage", new CheckoutStageVariableExpression().getName());
  }
}

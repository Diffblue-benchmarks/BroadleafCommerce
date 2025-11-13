package org.broadleafcommerce.common.web.expression;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class NullBroadleafVariableExpressionDiffblueTest {
  /**
   * Test {@link NullBroadleafVariableExpression#getName()}.
   *
   * <p>Method under test: {@link NullBroadleafVariableExpression#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String NullBroadleafVariableExpression.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertNull(new NullBroadleafVariableExpression().getName());
  }
}

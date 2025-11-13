package org.broadleafcommerce.common.web.expression;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AssetURLVariableExpressionDiffblueTest {
  /**
   * Test {@link AssetURLVariableExpression#getName()}.
   *
   * <p>Method under test: {@link AssetURLVariableExpression#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String AssetURLVariableExpression.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("cms", new AssetURLVariableExpression().getName());
  }
}

package org.broadleafcommerce.common.web.expression;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PropertiesVariableExpressionDiffblueTest {
  /**
   * Test {@link PropertiesVariableExpression#getName()}.
   *
   * <p>Method under test: {@link PropertiesVariableExpression#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PropertiesVariableExpression.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("props", new PropertiesVariableExpression().getName());
  }
}

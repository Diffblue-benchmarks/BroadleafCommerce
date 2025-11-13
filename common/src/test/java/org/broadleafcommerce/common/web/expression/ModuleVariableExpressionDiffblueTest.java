package org.broadleafcommerce.common.web.expression;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ModuleVariableExpressionDiffblueTest {
  /**
   * Test {@link ModuleVariableExpression#getName()}.
   *
   * <p>Method under test: {@link ModuleVariableExpression#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ModuleVariableExpression.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("module", new ModuleVariableExpression().getName());
  }

  /**
   * Test {@link ModuleVariableExpression#isPresent(String)}.
   *
   * <ul>
   *   <li>When {@code CommonTest}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ModuleVariableExpression#isPresent(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ModuleVariableExpression.isPresent(String)"})
  public void testIsPresent_whenCommonTest_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new ModuleVariableExpression().isPresent("CommonTest"));
  }

  /**
   * Test {@link ModuleVariableExpression#isPresent(String)}.
   *
   * <ul>
   *   <li>When {@code Module In Question}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ModuleVariableExpression#isPresent(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ModuleVariableExpression.isPresent(String)"})
  public void testIsPresent_whenModuleInQuestion_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new ModuleVariableExpression().isPresent("Module In Question"));
  }
}

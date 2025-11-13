package org.broadleafcommerce.openadmin.web.rulebuilder.statement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.openadmin.web.rulebuilder.BLCOperator;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {Expression.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class ExpressionDiffblueTest {
  @Autowired private Expression expression;

  /**
   * Test {@link Expression#setField(String)}.
   *
   * <ul>
   *   <li>When {@code Field}.
   *   <li>Then {@link Expression} Field is {@code Field}.
   * </ul>
   *
   * <p>Method under test: {@link Expression#setField(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Expression.setField(String)"})
  public void testSetField_whenField_thenExpressionFieldIsField() {
    // Arrange and Act
    expression.setField("Field");

    // Assert
    assertEquals("Field", expression.getField());
  }

  /**
   * Test {@link Expression#setValue(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then {@link Expression} Value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Expression#setValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Expression.setValue(String)"})
  public void testSetValue_when42_thenExpressionValueIs42() {
    // Arrange and Act
    expression.setValue("42");

    // Assert
    assertEquals("42", expression.getValue());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Expression}
   *   <li>{@link Expression#setEntityKey(String)}
   *   <li>{@link Expression#setOperator(BLCOperator)}
   *   <li>{@link Expression#getEntityKey()}
   *   <li>{@link Expression#getField()}
   *   <li>{@link Expression#getOperator()}
   *   <li>{@link Expression#getValue()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Expression.<init>()",
    "String Expression.getEntityKey()",
    "String Expression.getField()",
    "BLCOperator Expression.getOperator()",
    "String Expression.getValue()",
    "void Expression.setEntityKey(String)",
    "void Expression.setOperator(BLCOperator)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    Expression actualExpression = new Expression();
    actualExpression.setEntityKey("Entity Key");
    actualExpression.setOperator(BLCOperator.EQUALS);
    String actualEntityKey = actualExpression.getEntityKey();
    String actualField = actualExpression.getField();
    BLCOperator actualOperator = actualExpression.getOperator();

    // Assert
    assertEquals("Entity Key", actualEntityKey);
    assertNull(actualField);
    assertNull(actualExpression.getValue());
    assertEquals(BLCOperator.EQUALS, actualOperator);
  }
}

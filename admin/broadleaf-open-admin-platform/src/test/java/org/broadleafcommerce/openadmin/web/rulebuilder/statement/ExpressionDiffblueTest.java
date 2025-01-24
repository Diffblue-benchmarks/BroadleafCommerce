package org.broadleafcommerce.openadmin.web.rulebuilder.statement;

import static org.junit.Assert.assertEquals;
import org.broadleafcommerce.openadmin.web.rulebuilder.BLCOperator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {Expression.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ExpressionDiffblueTest {
  @Autowired
  private Expression expression;

  /**
   * Test {@link Expression#setField(String)}.
   * <p>
   * Method under test: {@link Expression#setField(String)}
   */
  @Test
  public void testSetField() {
    // Arrange
    Expression expression2 = new Expression();

    // Act
    expression2.setField("Field");

    // Assert
    assertEquals("Field", expression2.getField());
  }

  /**
   * Test {@link Expression#setValue(String)}.
   * <p>
   * Method under test: {@link Expression#setValue(String)}
   */
  @Test
  public void testSetValue() {
    // Arrange
    Expression expression2 = new Expression();

    // Act
    expression2.setValue("42");

    // Assert
    assertEquals("42", expression2.getValue());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  public void testGettersAndSetters() {
    // Arrange and Act
    Expression actualExpression = new Expression();
    actualExpression.setEntityKey("Entity Key");
    actualExpression.setOperator(BLCOperator.EQUALS);
    String actualEntityKey = actualExpression.getEntityKey();
    actualExpression.getField();
    BLCOperator actualOperator = actualExpression.getOperator();
    actualExpression.getValue();

    // Assert that nothing has changed
    assertEquals("Entity Key", actualEntityKey);
    assertEquals(BLCOperator.EQUALS, actualOperator);
  }
}

/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.openadmin.web.rulebuilder.statement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class ExpressionDiffblueTest {
  @Autowired
  private Expression expression;

  /**
   * Test {@link Expression#setField(String)}.
   * <p>
   * Method under test: {@link Expression#setField(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Expression.setField(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Expression.setValue(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Expression.<init>()", "String Expression.getEntityKey()", "String Expression.getField()",
      "BLCOperator Expression.getOperator()", "String Expression.getValue()", "void Expression.setEntityKey(String)",
      "void Expression.setOperator(BLCOperator)"})
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

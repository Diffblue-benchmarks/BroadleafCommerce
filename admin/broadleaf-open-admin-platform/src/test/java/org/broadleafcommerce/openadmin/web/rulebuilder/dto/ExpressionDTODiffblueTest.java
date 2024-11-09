/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
package org.broadleafcommerce.openadmin.web.rulebuilder.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import java.util.ArrayList;
import org.junit.Test;

public class ExpressionDTODiffblueTest {
  /**
   * Test {@link ExpressionDTO#equals(Object)}, and
   * {@link ExpressionDTO#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ExpressionDTO#equals(Object)}
   *   <li>{@link ExpressionDTO#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ExpressionDTO expressionDTO = new ExpressionDTO();
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("42");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");

    ExpressionDTO expressionDTO2 = new ExpressionDTO();
    expressionDTO2.setCondition("Condition");
    expressionDTO2.setContainedPk(1L);
    expressionDTO2.setCreatedFromSubGroup(true);
    expressionDTO2.setId("42");
    expressionDTO2.setOperator("Operator");
    expressionDTO2.setPk(1L);
    expressionDTO2.setPreviousContainedPk(1L);
    expressionDTO2.setPreviousPk(1L);
    expressionDTO2.setQuantity(1);
    expressionDTO2.setRules(new ArrayList<>());
    expressionDTO2.setValue("42");

    // Act and Assert
    assertEquals(expressionDTO, expressionDTO2);
    int expectedHashCodeResult = expressionDTO.hashCode();
    assertEquals(expectedHashCodeResult, expressionDTO2.hashCode());
  }

  /**
   * Test {@link ExpressionDTO#equals(Object)}, and
   * {@link ExpressionDTO#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ExpressionDTO#equals(Object)}
   *   <li>{@link ExpressionDTO#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ExpressionDTO expressionDTO = new ExpressionDTO();
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("42");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");

    // Act and Assert
    assertEquals(expressionDTO, expressionDTO);
    int expectedHashCodeResult = expressionDTO.hashCode();
    assertEquals(expectedHashCodeResult, expressionDTO.hashCode());
  }

  /**
   * Test {@link ExpressionDTO#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExpressionDTO#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ExpressionDTO expressionDTO = new ExpressionDTO();
    expressionDTO.setCondition(null);
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("42");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");

    ExpressionDTO expressionDTO2 = new ExpressionDTO();
    expressionDTO2.setCondition("Condition");
    expressionDTO2.setContainedPk(1L);
    expressionDTO2.setCreatedFromSubGroup(true);
    expressionDTO2.setId("42");
    expressionDTO2.setOperator("Operator");
    expressionDTO2.setPk(1L);
    expressionDTO2.setPreviousContainedPk(1L);
    expressionDTO2.setPreviousPk(1L);
    expressionDTO2.setQuantity(1);
    expressionDTO2.setRules(new ArrayList<>());
    expressionDTO2.setValue("42");

    // Act and Assert
    assertNotEquals(expressionDTO, expressionDTO2);
  }

  /**
   * Test {@link ExpressionDTO#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExpressionDTO#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ExpressionDTO expressionDTO = new ExpressionDTO();
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("Id");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");

    ExpressionDTO expressionDTO2 = new ExpressionDTO();
    expressionDTO2.setCondition("Condition");
    expressionDTO2.setContainedPk(1L);
    expressionDTO2.setCreatedFromSubGroup(true);
    expressionDTO2.setId("42");
    expressionDTO2.setOperator("Operator");
    expressionDTO2.setPk(1L);
    expressionDTO2.setPreviousContainedPk(1L);
    expressionDTO2.setPreviousPk(1L);
    expressionDTO2.setQuantity(1);
    expressionDTO2.setRules(new ArrayList<>());
    expressionDTO2.setValue("42");

    // Act and Assert
    assertNotEquals(expressionDTO, expressionDTO2);
  }

  /**
   * Test {@link ExpressionDTO#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExpressionDTO#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ExpressionDTO expressionDTO = new ExpressionDTO();
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("42");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");

    // Act and Assert
    assertNotEquals(expressionDTO, null);
  }

  /**
   * Test {@link ExpressionDTO#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExpressionDTO#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ExpressionDTO expressionDTO = new ExpressionDTO();
    expressionDTO.setCondition("Condition");
    expressionDTO.setContainedPk(1L);
    expressionDTO.setCreatedFromSubGroup(true);
    expressionDTO.setId("42");
    expressionDTO.setOperator("Operator");
    expressionDTO.setPk(1L);
    expressionDTO.setPreviousContainedPk(1L);
    expressionDTO.setPreviousPk(1L);
    expressionDTO.setQuantity(1);
    expressionDTO.setRules(new ArrayList<>());
    expressionDTO.setValue("42");

    // Act and Assert
    assertNotEquals(expressionDTO, "Different type to ExpressionDTO");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ExpressionDTO}
   *   <li>{@link ExpressionDTO#setId(String)}
   *   <li>{@link ExpressionDTO#setOperator(String)}
   *   <li>{@link ExpressionDTO#setValue(String)}
   *   <li>{@link ExpressionDTO#getId()}
   *   <li>{@link ExpressionDTO#getOperator()}
   *   <li>{@link ExpressionDTO#getValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ExpressionDTO actualExpressionDTO = new ExpressionDTO();
    actualExpressionDTO.setId("42");
    actualExpressionDTO.setOperator("Operator");
    actualExpressionDTO.setValue("42");
    String actualId = actualExpressionDTO.getId();
    String actualOperator = actualExpressionDTO.getOperator();

    // Assert that nothing has changed
    assertEquals("42", actualId);
    assertEquals("42", actualExpressionDTO.getValue());
    assertEquals("Operator", actualOperator);
    assertFalse(actualExpressionDTO.isCreatedFromSubGroup());
  }
}

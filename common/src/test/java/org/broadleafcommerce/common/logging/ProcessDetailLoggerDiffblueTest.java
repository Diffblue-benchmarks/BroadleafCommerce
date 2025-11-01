/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.logging;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import java.util.ArrayList;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ProcessDetailLogger.class, String.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProcessDetailLoggerDiffblueTest {
  @Autowired
  private ProcessDetailLogger processDetailLogger;

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProcessDetailLogger#ProcessDetailLogger(String)}
   *   <li>{@link ProcessDetailLogger#setListTemplateVariableMaxMemberCount(int)}
   *   <li>{@link ProcessDetailLogger#setStringTemplateVariableMaxLength(int)}
   *   <li>{@link ProcessDetailLogger#getListTemplateVariableMaxMemberCount()}
   *   <li>{@link ProcessDetailLogger#getStringTemplateVariableMaxLength()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ProcessDetailLogger actualProcessDetailLogger = new ProcessDetailLogger("42");
    actualProcessDetailLogger.setListTemplateVariableMaxMemberCount(3);
    actualProcessDetailLogger.setStringTemplateVariableMaxLength(3);
    int actualListTemplateVariableMaxMemberCount = actualProcessDetailLogger.getListTemplateVariableMaxMemberCount();

    // Assert that nothing has changed
    assertEquals(3, actualListTemplateVariableMaxMemberCount);
    assertEquals(3, actualProcessDetailLogger.getStringTemplateVariableMaxLength());
  }

  /**
   * Method under test: {@link ProcessDetailLogger#processVariables(Object[])}
   */
  @Test
  public void testProcessVariables() {
    // Arrange
    Object[] variables = new Object[]{BLCFieldUtils.NULL_FIELD};

    // Act
    Object[] actualProcessVariablesResult = processDetailLogger.processVariables(variables);

    // Assert
    assertEquals(1, actualProcessVariablesResult.length);
    assertSame(variables, actualProcessVariablesResult);
  }

  /**
   * Method under test: {@link ProcessDetailLogger#processVariables(Object[])}
   */
  @Test
  public void testProcessVariables2() {
    // Arrange
    Object[] variables = new Object[]{new ArrayList<>()};

    // Act
    Object[] actualProcessVariablesResult = processDetailLogger.processVariables(variables);

    // Assert
    assertEquals("", actualProcessVariablesResult[0]);
    assertEquals("", variables[0]);
    assertEquals(1, actualProcessVariablesResult.length);
    assertEquals(1, variables.length);
    assertSame(variables, actualProcessVariablesResult);
  }

  /**
   * Method under test: {@link ProcessDetailLogger#processVariables(Object[])}
   */
  @Test
  public void testProcessVariables3() {
    // Arrange
    Object[] variables = new Object[]{null};

    // Act
    Object[] actualProcessVariablesResult = processDetailLogger.processVariables(variables);

    // Assert
    assertNull(actualProcessVariablesResult[0]);
    assertEquals(1, actualProcessVariablesResult.length);
    assertSame(variables, actualProcessVariablesResult);
  }

  /**
   * Method under test: {@link ProcessDetailLogger#processVariables(Object[])}
   */
  @Test
  public void testProcessVariables4() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add(BLCFieldUtils.NULL_FIELD);
    Object[] variables = new Object[]{objectList};

    // Act
    Object[] actualProcessVariablesResult = processDetailLogger.processVariables(variables);

    // Assert
    assertEquals(1, actualProcessVariablesResult.length);
    assertEquals(1, variables.length);
    assertSame(variables, actualProcessVariablesResult);
  }
}

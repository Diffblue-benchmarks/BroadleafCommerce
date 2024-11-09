/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
   * Test getters and setters.
   * <p>
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
   * Test {@link ProcessDetailLogger#processVariables(Object[])}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProcessDetailLogger#processVariables(Object[])}
   */
  @Test
  public void testProcessVariables_givenNull_field_whenArrayListAddNull_field() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add(BLCFieldUtils.NULL_FIELD);
    Object[] variables = new Object[]{objectList};

    // Act and Assert
    assertEquals(1, variables.length);
    assertSame(variables, processDetailLogger.processVariables(variables));
  }

  /**
   * Test {@link ProcessDetailLogger#processVariables(Object[])}.
   * <ul>
   *   <li>Then return array of {@link Object} with
   * {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProcessDetailLogger#processVariables(Object[])}
   */
  @Test
  public void testProcessVariables_thenReturnArrayOfObjectWithNull_field() {
    // Arrange
    Object[] variables = new Object[]{BLCFieldUtils.NULL_FIELD};

    // Act and Assert
    assertSame(variables, processDetailLogger.processVariables(variables));
  }

  /**
   * Test {@link ProcessDetailLogger#processVariables(Object[])}.
   * <ul>
   *   <li>When array of {@link Object} with {@code null}.</li>
   *   <li>Then first element is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProcessDetailLogger#processVariables(Object[])}
   */
  @Test
  public void testProcessVariables_whenArrayOfObjectWithNull_thenFirstElementIsNull() {
    // Arrange
    Object[] variables = new Object[]{null};

    // Act and Assert
    assertNull(variables[0]);
    assertEquals(1, variables.length);
    assertSame(variables, processDetailLogger.processVariables(variables));
  }
}

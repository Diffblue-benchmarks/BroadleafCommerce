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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import java.util.ArrayList;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ProcessDetailLogger.class, String.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
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
   * Test {@link ProcessDetailLogger#init()}.
   * <p>
   * Method under test: {@link ProcessDetailLogger#init()}
   */
  @Test
  public void testInit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProcessDetailLogger processDetailLogger = new ProcessDetailLogger("42");

    // Act
    processDetailLogger.init();

    // Assert
    assertFalse(processDetailLogger.isProperLogLevelEnabled());
  }

  /**
   * Test {@link ProcessDetailLogger#init()}.
   * <p>
   * Method under test: {@link ProcessDetailLogger#init()}
   */
  @Test
  public void testInit2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    processDetailLogger.init();
  }

  /**
   * Test {@link ProcessDetailLogger#isProperLogLevelEnabled()}.
   * <p>
   * Method under test: {@link ProcessDetailLogger#isProperLogLevelEnabled()}
   */
  @Test
  public void testIsProperLogLevelEnabled() {
    // Arrange, Act and Assert
    assertFalse(processDetailLogger.isProperLogLevelEnabled());
  }

  /**
   * Test {@link ProcessDetailLogger#logProcessDetail(String, Throwable, String)}
   * with {@code logContext}, {@code e}, {@code message}.
   * <p>
   * Method under test:
   * {@link ProcessDetailLogger#logProcessDetail(String, Throwable, String)}
   */
  @Test
  public void testLogProcessDetailWithLogContextEMessage() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    processDetailLogger.logProcessDetail("Log Context", new Throwable(), "Not all who wander are lost");
  }

  /**
   * Test
   * {@link ProcessDetailLogger#logProcessDetail(String, Throwable, String, Object[])}
   * with {@code logContext}, {@code e}, {@code messageTemplate},
   * {@code templateVariables}.
   * <p>
   * Method under test:
   * {@link ProcessDetailLogger#logProcessDetail(String, Throwable, String, Object[])}
   */
  @Test
  public void testLogProcessDetailWithLogContextEMessageTemplateTemplateVariables() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    processDetailLogger.logProcessDetail("Log Context", new Throwable(), "Message Template", BLCFieldUtils.NULL_FIELD);
  }

  /**
   * Test {@link ProcessDetailLogger#logProcessDetail(String, String)} with
   * {@code logContext}, {@code message}.
   * <p>
   * Method under test:
   * {@link ProcessDetailLogger#logProcessDetail(String, String)}
   */
  @Test
  public void testLogProcessDetailWithLogContextMessage() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    processDetailLogger.logProcessDetail("Log Context", "Not all who wander are lost");
  }

  /**
   * Test {@link ProcessDetailLogger#logProcessDetail(String, String, Object[])}
   * with {@code logContext}, {@code messageTemplate}, {@code templateVariables}.
   * <p>
   * Method under test:
   * {@link ProcessDetailLogger#logProcessDetail(String, String, Object[])}
   */
  @Test
  public void testLogProcessDetailWithLogContextMessageTemplateTemplateVariables() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    processDetailLogger.logProcessDetail("Log Context", "Message Template", BLCFieldUtils.NULL_FIELD);
  }

  /**
   * Test
   * {@link ProcessDetailLogger#logProcessDetailMessage(String, Throwable, String)}.
   * <ul>
   *   <li>When {@code Log Context}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProcessDetailLogger#logProcessDetailMessage(String, Throwable, String)}
   */
  @Test
  public void testLogProcessDetailMessage_whenLogContext() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    processDetailLogger.logProcessDetailMessage("Log Context", new Throwable(), "Not all who wander are lost");
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
   *   <li>Then first element is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProcessDetailLogger#processVariables(Object[])}
   */
  @Test
  public void testProcessVariables_thenFirstElementIsEmptyString() {
    // Arrange
    Object[] variables = new Object[]{new ArrayList<>()};

    // Act and Assert
    assertEquals("", variables[0]);
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

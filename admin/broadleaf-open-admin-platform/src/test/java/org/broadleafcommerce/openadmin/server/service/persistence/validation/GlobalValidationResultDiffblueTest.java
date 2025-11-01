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
package org.broadleafcommerce.openadmin.server.service.persistence.validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

public class GlobalValidationResultDiffblueTest {
  @MockBean
  private GlobalValidationResult globalValidationResult;

  /**
   * Method under test: {@link GlobalValidationResult#isNotValid()}
   */
  @Test
  public void testIsNotValid() {
    // Arrange, Act and Assert
    assertFalse((new GlobalValidationResult(true)).isNotValid());
  }

  /**
   * Method under test: {@link GlobalValidationResult#isNotValid()}
   */
  @Test
  public void testIsNotValid2() {
    // Arrange
    GlobalValidationResult globalValidationResult = new GlobalValidationResult(true);
    globalValidationResult.setValid(false);

    // Act and Assert
    assertTrue(globalValidationResult.isNotValid());
  }

  /**
   * Method under test: {@link GlobalValidationResult#getErrorMessage()}
   */
  @Test
  public void testGetErrorMessage() {
    // Arrange, Act and Assert
    assertNull((new GlobalValidationResult(true)).getErrorMessage());
  }

  /**
   * Method under test: {@link GlobalValidationResult#getErrorMessage()}
   */
  @Test
  public void testGetErrorMessage2() {
    // Arrange
    ArrayList<String> errorMessages = new ArrayList<>();
    errorMessages.add("foo");

    GlobalValidationResult globalValidationResult = new GlobalValidationResult(true);
    globalValidationResult.setErrorMessages(errorMessages);

    // Act and Assert
    assertEquals("foo", globalValidationResult.getErrorMessage());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GlobalValidationResult#setErrorMessages(List)}
   *   <li>{@link GlobalValidationResult#setValid(boolean)}
   *   <li>{@link GlobalValidationResult#getErrorMessages()}
   *   <li>{@link GlobalValidationResult#isValid()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    GlobalValidationResult globalValidationResult = new GlobalValidationResult(true);
    ArrayList<String> errorMessages = new ArrayList<>();

    // Act
    globalValidationResult.setErrorMessages(errorMessages);
    globalValidationResult.setValid(true);
    List<String> actualErrorMessages = globalValidationResult.getErrorMessages();
    boolean actualIsValidResult = globalValidationResult.isValid();

    // Assert that nothing has changed
    assertTrue(actualErrorMessages.isEmpty());
    assertTrue(actualIsValidResult);
    assertSame(errorMessages, actualErrorMessages);
  }

  /**
   * Method under test:
   * {@link GlobalValidationResult#GlobalValidationResult(boolean)}
   */
  @Test
  public void testNewGlobalValidationResult() {
    // Arrange and Act
    GlobalValidationResult actualGlobalValidationResult = new GlobalValidationResult(true);

    // Assert
    assertNull(actualGlobalValidationResult.getErrorMessage());
    assertFalse(actualGlobalValidationResult.isNotValid());
    assertTrue(actualGlobalValidationResult.getErrorMessages().isEmpty());
    assertTrue(actualGlobalValidationResult.isValid());
  }

  /**
   * Method under test:
   * {@link GlobalValidationResult#GlobalValidationResult(boolean, String)}
   */
  @Test
  public void testNewGlobalValidationResult2() {
    // Arrange and Act
    GlobalValidationResult actualGlobalValidationResult = new GlobalValidationResult(true, "An error occurred");

    // Assert
    List<String> errorMessages = actualGlobalValidationResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertEquals("An error occurred", errorMessages.get(0));
    assertEquals("An error occurred", actualGlobalValidationResult.getErrorMessage());
    assertFalse(actualGlobalValidationResult.isNotValid());
    assertTrue(actualGlobalValidationResult.isValid());
  }
}

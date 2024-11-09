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
package org.broadleafcommerce.openadmin.server.service.persistence.validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

public class PropertyValidationResultDiffblueTest {
  @MockBean
  private PropertyValidationResult propertyValidationResult;

  /**
   * Test {@link PropertyValidationResult#PropertyValidationResult(boolean)}.
   * <p>
   * Method under test:
   * {@link PropertyValidationResult#PropertyValidationResult(boolean)}
   */
  @Test
  public void testNewPropertyValidationResult() {
    // Arrange and Act
    PropertyValidationResult actualPropertyValidationResult = new PropertyValidationResult(true);

    // Assert
    assertNull(actualPropertyValidationResult.getErrorMessage());
    assertFalse(actualPropertyValidationResult.isNotValid());
    assertTrue(actualPropertyValidationResult.getErrorMessages().isEmpty());
    assertTrue(actualPropertyValidationResult.isValid());
  }

  /**
   * Test
   * {@link PropertyValidationResult#PropertyValidationResult(boolean, String)}.
   * <p>
   * Method under test:
   * {@link PropertyValidationResult#PropertyValidationResult(boolean, String)}
   */
  @Test
  public void testNewPropertyValidationResult2() {
    // Arrange and Act
    PropertyValidationResult actualPropertyValidationResult = new PropertyValidationResult(true, "An error occurred");

    // Assert
    List<String> errorMessages = actualPropertyValidationResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertEquals("An error occurred", errorMessages.get(0));
    assertEquals("An error occurred", actualPropertyValidationResult.getErrorMessage());
    assertFalse(actualPropertyValidationResult.isNotValid());
    assertTrue(actualPropertyValidationResult.isValid());
  }
}

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

package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class CriteriaConversionExceptionDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link CriteriaConversionException#CriteriaConversionException(String, FieldPath)}
   *   <li>{@link CriteriaConversionException#setFieldPath(FieldPath)}
   *   <li>{@link CriteriaConversionException#getFieldPath()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CriteriaConversionException actualCriteriaConversionException = new CriteriaConversionException("An error occurred",
        new FieldPath());
    FieldPath fieldPath = new FieldPath();
    actualCriteriaConversionException.setFieldPath(fieldPath);
    FieldPath actualFieldPath = actualCriteriaConversionException.getFieldPath();

    // Assert that nothing has changed
    assertEquals("An error occurred", actualCriteriaConversionException.getMessage());
    assertEquals(0, actualCriteriaConversionException.getSuppressed().length);
    assertSame(fieldPath, actualFieldPath);
  }
}

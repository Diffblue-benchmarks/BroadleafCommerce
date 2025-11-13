package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CriteriaConversionExceptionDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CriteriaConversionException#CriteriaConversionException(String, FieldPath)}
   *   <li>{@link CriteriaConversionException#setFieldPath(FieldPath)}
   *   <li>{@link CriteriaConversionException#getFieldPath()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CriteriaConversionException.<init>(String, FieldPath)",
    "FieldPath CriteriaConversionException.getFieldPath()",
    "void CriteriaConversionException.setFieldPath(FieldPath)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    CriteriaConversionException actualCriteriaConversionException =
        new CriteriaConversionException("An error occurred", new FieldPath());
    FieldPath fieldPath = new FieldPath();
    actualCriteriaConversionException.setFieldPath(fieldPath);
    FieldPath actualFieldPath = actualCriteriaConversionException.getFieldPath();

    // Assert
    assertEquals("An error occurred", actualCriteriaConversionException.getMessage());
    assertNull(actualCriteriaConversionException.getCause());
    assertEquals(0, actualCriteriaConversionException.getSuppressed().length);
    assertSame(fieldPath, actualFieldPath);
  }
}

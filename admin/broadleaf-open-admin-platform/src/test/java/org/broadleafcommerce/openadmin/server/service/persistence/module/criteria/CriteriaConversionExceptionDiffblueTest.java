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

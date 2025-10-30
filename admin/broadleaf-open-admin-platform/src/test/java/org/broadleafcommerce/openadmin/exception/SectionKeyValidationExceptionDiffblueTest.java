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
package org.broadleafcommerce.openadmin.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SectionKeyValidationExceptionDiffblueTest {
  /**
   * Test {@link SectionKeyValidationException#SectionKeyValidationException(String)}.
   * <p>
   * Method under test: {@link SectionKeyValidationException#SectionKeyValidationException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SectionKeyValidationException.<init>(String)"})
  public void testNewSectionKeyValidationException() {
    // Arrange and Act
    SectionKeyValidationException actualSectionKeyValidationException = new SectionKeyValidationException(
        "An error occurred");

    // Assert
    assertEquals("An error occurred", actualSectionKeyValidationException.getMessage());
    assertNull(actualSectionKeyValidationException.getCause());
    assertEquals(0, actualSectionKeyValidationException.getSuppressed().length);
  }
}

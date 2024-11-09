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
package org.broadleafcommerce.openadmin.web.rulebuilder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class MVELTranslationExceptionDiffblueTest {
  /**
   * Test {@link MVELTranslationException#MVELTranslationException(int, String)}.
   * <p>
   * Method under test:
   * {@link MVELTranslationException#MVELTranslationException(int, String)}
   */
  @Test
  public void testNewMVELTranslationException() {
    // Arrange and Act
    MVELTranslationException actualMvelTranslationException = new MVELTranslationException(1, "An error occurred");

    // Assert
    assertEquals("An error occurred", actualMvelTranslationException.getMessage());
    assertNull(actualMvelTranslationException.getMessageParameters());
    assertNull(actualMvelTranslationException.getCause());
    assertEquals(0, actualMvelTranslationException.getSuppressed().length);
    assertEquals(1, actualMvelTranslationException.getCode());
  }
}

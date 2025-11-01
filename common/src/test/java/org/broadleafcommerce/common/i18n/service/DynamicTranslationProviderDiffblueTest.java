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
package org.broadleafcommerce.common.i18n.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.common.classloader.release.ThreadLocalManager;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.broadleafcommerce.common.web.BroadleafRequestContext;
import org.junit.Test;

public class DynamicTranslationProviderDiffblueTest {
  /**
   * Method under test:
   * {@link DynamicTranslationProvider#getValue(Object, String, String)}
   */
  @Test
  public void testGetValue() {
    // Arrange, Act and Assert
    assertEquals("42", DynamicTranslationProvider.getValue(BLCFieldUtils.NULL_FIELD, "Field", "42"));
    assertEquals("42", DynamicTranslationProvider.getValue(new TranslationConsiderationContext(), "Field", "42"));
    assertEquals("42",
        DynamicTranslationProvider.getValue(BroadleafRequestContext.getBroadleafRequestContext(true), "Field", "42"));
    assertEquals("42", DynamicTranslationProvider.getValue(mock(ThreadLocalManager.class), "Field", "42"));
  }
}

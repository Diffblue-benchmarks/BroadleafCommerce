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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.broadleafcommerce.common.web.BroadleafRequestContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DynamicTranslationProviderDiffblueTest {
  /**
   * Test {@link DynamicTranslationProvider#getValue(Object, String, String)}.
   * <ul>
   *   <li>When BroadleafRequestContext is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicTranslationProvider#getValue(Object, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DynamicTranslationProvider.getValue(Object, String, String)"})
  public void testGetValue_whenBroadleafRequestContextIsTrue() {
    // Arrange, Act and Assert
    assertEquals("42",
        DynamicTranslationProvider.getValue(BroadleafRequestContext.getBroadleafRequestContext(true), "Field", "42"));
  }

  /**
   * Test {@link DynamicTranslationProvider#getValue(Object, String, String)}.
   * <ul>
   *   <li>When {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicTranslationProvider#getValue(Object, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DynamicTranslationProvider.getValue(Object, String, String)"})
  public void testGetValue_whenNull_field() {
    // Arrange, Act and Assert
    assertEquals("42", DynamicTranslationProvider.getValue(BLCFieldUtils.NULL_FIELD, "Field", "42"));
  }

  /**
   * Test {@link DynamicTranslationProvider#getValue(Object, String, String)}.
   * <ul>
   *   <li>When {@link TranslationConsiderationContext} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicTranslationProvider#getValue(Object, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DynamicTranslationProvider.getValue(Object, String, String)"})
  public void testGetValue_whenTranslationConsiderationContext() {
    // Arrange, Act and Assert
    assertEquals("42", DynamicTranslationProvider.getValue(new TranslationConsiderationContext(), "Field", "42"));
  }
}

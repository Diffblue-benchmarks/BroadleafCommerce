/*-
 * #%L
 * BroadleafCommerce Admin Functional Tests
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
package org.broadleafcommerce.browsertest.page;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FieldConverterSupportDiffblueTest {
  /**
   * Method under test: {@link FieldConverterSupport#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName() {
    // Arrange, Act and Assert
    assertEquals("[name=\"fields\\[\\'Field Name\\'\\].value\"]",
        (new FieldConverterSupport()).convertFieldName("Field Name"));
    assertEquals("[name=\"fields\\[\\'org__broadleafcommerce__browsertest__page__FieldConverterSupport\\'\\].value\"]",
        (new FieldConverterSupport()).convertFieldName("org.broadleafcommerce.browsertest.page.FieldConverterSupport"));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link FieldConverterSupport}
   */
  @Test
  public void testNewFieldConverterSupport() {
    // Arrange, Act and Assert
    assertEquals("[name=\"fields\\[\\'Field Name\\'\\].value\"]",
        (new FieldConverterSupport()).convertFieldName("Field Name"));
  }
}

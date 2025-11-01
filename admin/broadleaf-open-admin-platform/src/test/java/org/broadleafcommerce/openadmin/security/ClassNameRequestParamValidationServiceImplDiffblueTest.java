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
package org.broadleafcommerce.openadmin.security;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class ClassNameRequestParamValidationServiceImplDiffblueTest {
  /**
   * Method under test:
   * {@link ClassNameRequestParamValidationServiceImpl#validateClassNameParams(Map, String)}
   */
  @Test
  public void testValidateClassNameParams() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ClassNameRequestParamValidationServiceImpl classNameRequestParamValidationServiceImpl = new ClassNameRequestParamValidationServiceImpl();

    // Act and Assert
    assertFalse(
        classNameRequestParamValidationServiceImpl.validateClassNameParams(new HashMap<>(), "Persistence Unit Name"));
  }

  /**
   * Method under test:
   * {@link ClassNameRequestParamValidationServiceImpl#validateClassNameParams(Map, String)}
   */
  @Test
  public void testValidateClassNameParams2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ClassNameRequestParamValidationServiceImpl classNameRequestParamValidationServiceImpl = new ClassNameRequestParamValidationServiceImpl();

    HashMap<String, String> requestParamToClassName = new HashMap<>();
    requestParamToClassName.put("foo", "");

    // Act and Assert
    assertTrue(classNameRequestParamValidationServiceImpl.validateClassNameParams(requestParamToClassName,
        "Persistence Unit Name"));
  }
}

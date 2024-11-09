/*-
 * #%L
 * BroadleafCommerce Profile
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
package org.broadleafcommerce.profile.core.service.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.springframework.validation.BindException;

public class BaseResponseDiffblueTest {
  /**
   * Test {@link BaseResponse#hasErrors()}.
   * <p>
   * Method under test: {@link BaseResponse#hasErrors()}
   */
  @Test
  public void testHasErrors() {
    // Arrange, Act and Assert
    assertFalse((new BaseResponse("Target", "Object Name")).hasErrors());
  }

  /**
   * Test {@link BaseResponse#getErrors()}.
   * <p>
   * Method under test: {@link BaseResponse#getErrors()}
   */
  @Test
  public void testGetErrors() {
    // Arrange, Act and Assert
    assertTrue((new BaseResponse("Target", "Object Name")).getErrors() instanceof BindException);
  }
}

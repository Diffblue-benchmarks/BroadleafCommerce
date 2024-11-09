/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.common.web.validator;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BroadleafCommonAddressValidatorExtensionManager.class})
@ExtendWith(SpringExtension.class)
class BroadleafCommonAddressValidatorExtensionManagerDiffblueTest {
  @Autowired
  private BroadleafCommonAddressValidatorExtensionManager broadleafCommonAddressValidatorExtensionManager;

  /**
   * Test
   * {@link BroadleafCommonAddressValidatorExtensionManager#continueOnHandled()}.
   * <p>
   * Method under test:
   * {@link BroadleafCommonAddressValidatorExtensionManager#continueOnHandled()}
   */
  @Test
  @DisplayName("Test continueOnHandled()")
  void testContinueOnHandled() {
    // Arrange, Act and Assert
    assertTrue(broadleafCommonAddressValidatorExtensionManager.continueOnHandled());
  }
}

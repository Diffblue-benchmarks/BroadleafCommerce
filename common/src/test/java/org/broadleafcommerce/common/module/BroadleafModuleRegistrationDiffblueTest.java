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
package org.broadleafcommerce.common.module;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class BroadleafModuleRegistrationDiffblueTest {
  /**
   * Method under test:
   * {@link BroadleafModuleRegistration.BroadleafModuleEnum#equalsModuleName(String)}
   */
  @Test
  public void testBroadleafModuleEnumEqualsModuleName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse(BroadleafModuleRegistration.BroadleafModuleEnum.ACCOUNT.equalsModuleName("Name"));
    assertFalse(BroadleafModuleRegistration.BroadleafModuleEnum.ACCOUNT.equalsModuleName("ACCOUNT"));
    assertTrue(BroadleafModuleRegistration.BroadleafModuleEnum.ACCOUNT.equalsModuleName("Account"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BroadleafModuleRegistration.BroadleafModuleEnum#getName()}
   *   <li>{@link BroadleafModuleRegistration.BroadleafModuleEnum#toString()}
   * </ul>
   */
  @Test
  public void testBroadleafModuleEnumGettersAndSetters() {
    // Arrange
    BroadleafModuleRegistration.BroadleafModuleEnum valueOfResult = BroadleafModuleRegistration.BroadleafModuleEnum
        .valueOf("ACCOUNT");

    // Act
    String actualName = valueOfResult.getName();

    // Assert
    assertEquals("Account", actualName);
    assertEquals("Account", valueOfResult.toString());
  }
}

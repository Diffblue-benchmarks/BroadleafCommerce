/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.extensibility.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.Map;
import org.junit.Test;

public class AutoDDLCreateStatusTestBeanImplDiffblueTest {
  /**
   * Test {@link AutoDDLCreateStatusTestBeanImpl#getStartedWithCreate(String)}.
   * <p>
   * Method under test:
   * {@link AutoDDLCreateStatusTestBeanImpl#getStartedWithCreate(String)}
   */
  @Test
  public void testGetStartedWithCreate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AutoDDLCreateStatusTestBeanImpl()).getStartedWithCreate("Pu"));
  }

  /**
   * Test
   * {@link AutoDDLCreateStatusTestBeanImpl#setStartedWithCreate(String, Boolean)}.
   * <p>
   * Method under test:
   * {@link AutoDDLCreateStatusTestBeanImpl#setStartedWithCreate(String, Boolean)}
   */
  @Test
  public void testSetStartedWithCreate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AutoDDLCreateStatusTestBeanImpl autoDDLCreateStatusTestBeanImpl = new AutoDDLCreateStatusTestBeanImpl();

    // Act
    autoDDLCreateStatusTestBeanImpl.setStartedWithCreate("Pu", true);

    // Assert
    Map<String, Boolean> stringResultBooleanMap = autoDDLCreateStatusTestBeanImpl.startedWithCreate;
    assertEquals(1, stringResultBooleanMap.size());
    assertTrue(stringResultBooleanMap.get("Pu"));
  }

  /**
   * Test new {@link AutoDDLCreateStatusTestBeanImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AutoDDLCreateStatusTestBeanImpl}
   */
  @Test
  public void testNewAutoDDLCreateStatusTestBeanImpl() {
    // Arrange, Act and Assert
    assertTrue((new AutoDDLCreateStatusTestBeanImpl()).startedWithCreate.isEmpty());
  }
}

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
package org.broadleafcommerce.common.cache;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class DefaultOverridePreCacheServiceImplDiffblueTest {
  /**
   * Test {@link DefaultOverridePreCacheServiceImpl#findElements(String[])}.
   * <p>
   * Method under test:
   * {@link DefaultOverridePreCacheServiceImpl#findElements(String[])}
   */
  @Test
  public void testFindElements() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new DefaultOverridePreCacheServiceImpl()).findElements("Cache Keys"));
  }

  /**
   * Test {@link DefaultOverridePreCacheServiceImpl#isActiveForType(String)}.
   * <p>
   * Method under test:
   * {@link DefaultOverridePreCacheServiceImpl#isActiveForType(String)}
   */
  @Test
  public void testIsActiveForType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new DefaultOverridePreCacheServiceImpl()).isActiveForType("Type"));
  }

  /**
   * Test
   * {@link DefaultOverridePreCacheServiceImpl#isActiveIsolatedSiteForType(Long, String)}.
   * <p>
   * Method under test:
   * {@link DefaultOverridePreCacheServiceImpl#isActiveIsolatedSiteForType(Long, String)}
   */
  @Test
  public void testIsActiveIsolatedSiteForType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new DefaultOverridePreCacheServiceImpl()).isActiveIsolatedSiteForType(1L, "Entity Type"));
  }
}

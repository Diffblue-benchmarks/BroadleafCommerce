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
package org.broadleafcommerce.openadmin.web.filter;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import org.junit.Test;
import org.springframework.core.env.StandardEnvironment;

public class AbstractBroadleafAdminRequestFilterDiffblueTest {
  /**
   * Test {@link AbstractBroadleafAdminRequestFilter#getIgnoreSuffixes()}.
   * <p>
   * Method under test:
   * {@link AbstractBroadleafAdminRequestFilter#getIgnoreSuffixes()}
   */
  @Test
  public void testGetIgnoreSuffixes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafAdminRequestFilter broadleafAdminRequestFilter = new BroadleafAdminRequestFilter();
    broadleafAdminRequestFilter.setEnvironment(mock(StandardEnvironment.class));

    // Act and Assert
    assertEquals(44, broadleafAdminRequestFilter.getIgnoreSuffixes().size());
  }

  /**
   * Test {@link AbstractBroadleafAdminRequestFilter#getIgnoreSuffixes()}.
   * <ul>
   *   <li>Given {@link BroadleafAdminRequestFilter} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractBroadleafAdminRequestFilter#getIgnoreSuffixes()}
   */
  @Test
  public void testGetIgnoreSuffixes_givenBroadleafAdminRequestFilter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(44, (new BroadleafAdminRequestFilter()).getIgnoreSuffixes().size());
  }
}

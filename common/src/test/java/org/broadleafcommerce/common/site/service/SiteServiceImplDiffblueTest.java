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
package org.broadleafcommerce.common.site.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import org.broadleafcommerce.common.site.domain.Site;
import org.junit.Test;

public class SiteServiceImplDiffblueTest {
  /**
   * Method under test: {@link SiteServiceImpl#retrieveSiteById(Long)}
   */
  @Test
  public void testRetrieveSiteById() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SiteServiceImpl()).retrieveSiteById(null));
    assertNull((new SiteServiceImpl()).retrieveSiteById(null, true));
  }

  /**
   * Method under test:
   * {@link SiteServiceImpl#retrieveNonPersistentSiteById(Long)}
   */
  @Test
  public void testRetrieveNonPersistentSiteById() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SiteServiceImpl()).retrieveNonPersistentSiteById(null));
  }

  /**
   * Method under test: {@link SiteServiceImpl#retrievePersistentSiteById(Long)}
   */
  @Test
  public void testRetrievePersistentSiteById() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SiteServiceImpl()).retrievePersistentSiteById(null));
  }

  /**
   * Method under test:
   * {@link SiteServiceImpl#retrieveNonPersistentSiteByIdentifer(String)}
   */
  @Test
  public void testRetrieveNonPersistentSiteByIdentifer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SiteServiceImpl()).retrieveNonPersistentSiteByIdentifer(null));
  }

  /**
   * Method under test:
   * {@link SiteServiceImpl#retrievePersistentSiteByIdentifier(String)}
   */
  @Test
  public void testRetrievePersistentSiteByIdentifier() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SiteServiceImpl()).retrievePersistentSiteByIdentifier(null));
  }

  /**
   * Method under test:
   * {@link SiteServiceImpl#retrieveSiteByIdentifier(String, boolean)}
   */
  @Test
  public void testRetrieveSiteByIdentifier() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SiteServiceImpl()).retrieveSiteByIdentifier(null, true));
  }

  /**
   * Method under test: {@link SiteServiceImpl#stripSubdomain(String)}
   */
  @Test
  public void testStripSubdomain() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new SiteServiceImpl()).stripSubdomain(null));
  }

  /**
   * Method under test: {@link SiteServiceImpl#getNonPersistentSite(Site)}
   */
  @Test
  public void testGetNonPersistentSite() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SiteServiceImpl()).getNonPersistentSite(null));
  }
}

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
package org.broadleafcommerce.common.site.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import org.broadleafcommerce.common.site.domain.Site;
import org.junit.Test;

public class SiteServiceImplDiffblueTest {
  /**
   * Test {@link SiteServiceImpl#retrieveSiteById(Long, boolean)} with {@code id},
   * {@code persistentResult}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteServiceImpl#retrieveSiteById(Long, boolean)}
   */
  @Test
  public void testRetrieveSiteByIdWithIdPersistentResult_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SiteServiceImpl()).retrieveSiteById(null, true));
  }

  /**
   * Test {@link SiteServiceImpl#retrieveSiteById(Long)} with {@code id}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteServiceImpl#retrieveSiteById(Long)}
   */
  @Test
  public void testRetrieveSiteByIdWithId_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SiteServiceImpl()).retrieveSiteById(null));
  }

  /**
   * Test {@link SiteServiceImpl#retrieveNonPersistentSiteById(Long)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SiteServiceImpl#retrieveNonPersistentSiteById(Long)}
   */
  @Test
  public void testRetrieveNonPersistentSiteById_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SiteServiceImpl()).retrieveNonPersistentSiteById(null));
  }

  /**
   * Test {@link SiteServiceImpl#retrievePersistentSiteById(Long)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteServiceImpl#retrievePersistentSiteById(Long)}
   */
  @Test
  public void testRetrievePersistentSiteById_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SiteServiceImpl()).retrievePersistentSiteById(null));
  }

  /**
   * Test {@link SiteServiceImpl#retrieveNonPersistentSiteByIdentifer(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SiteServiceImpl#retrieveNonPersistentSiteByIdentifer(String)}
   */
  @Test
  public void testRetrieveNonPersistentSiteByIdentifer_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SiteServiceImpl()).retrieveNonPersistentSiteByIdentifer(null));
  }

  /**
   * Test {@link SiteServiceImpl#retrievePersistentSiteByIdentifier(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SiteServiceImpl#retrievePersistentSiteByIdentifier(String)}
   */
  @Test
  public void testRetrievePersistentSiteByIdentifier_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SiteServiceImpl()).retrievePersistentSiteByIdentifier(null));
  }

  /**
   * Test {@link SiteServiceImpl#retrieveSiteByIdentifier(String, boolean)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SiteServiceImpl#retrieveSiteByIdentifier(String, boolean)}
   */
  @Test
  public void testRetrieveSiteByIdentifier_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SiteServiceImpl()).retrieveSiteByIdentifier(null, true));
  }

  /**
   * Test {@link SiteServiceImpl#stripSubdomain(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteServiceImpl#stripSubdomain(String)}
   */
  @Test
  public void testStripSubdomain_whenNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new SiteServiceImpl()).stripSubdomain(null));
  }

  /**
   * Test {@link SiteServiceImpl#getNonPersistentSite(Site)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteServiceImpl#getNonPersistentSite(Site)}
   */
  @Test
  public void testGetNonPersistentSite_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SiteServiceImpl()).getNonPersistentSite(null));
  }
}

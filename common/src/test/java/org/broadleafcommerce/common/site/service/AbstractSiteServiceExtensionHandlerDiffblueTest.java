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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.site.domain.Site;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.junit.Test;

public class AbstractSiteServiceExtensionHandlerDiffblueTest {
  /**
   * Test
   * {@link AbstractSiteServiceExtensionHandler#contributeNonPersitentSiteProperties(Site, Site)}.
   * <ul>
   *   <li>Given {@link Locale}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSiteServiceExtensionHandler#contributeNonPersitentSiteProperties(Site, Site)}
   */
  @Test
  public void testContributeNonPersitentSiteProperties_givenLocale() {
    // Arrange
    AbstractSiteServiceExtensionHandler abstractSiteServiceExtensionHandler = new AbstractSiteServiceExtensionHandler();

    SiteImpl from = new SiteImpl();
    from.setDefaultLocale(mock(Locale.class));

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractSiteServiceExtensionHandler.contributeNonPersitentSiteProperties(from, new SiteImpl()));
  }

  /**
   * Test
   * {@link AbstractSiteServiceExtensionHandler#contributeNonPersitentSiteProperties(Site, Site)}.
   * <ul>
   *   <li>When {@link SiteImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSiteServiceExtensionHandler#contributeNonPersitentSiteProperties(Site, Site)}
   */
  @Test
  public void testContributeNonPersitentSiteProperties_whenSiteImpl() {
    // Arrange
    AbstractSiteServiceExtensionHandler abstractSiteServiceExtensionHandler = new AbstractSiteServiceExtensionHandler();
    SiteImpl from = new SiteImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractSiteServiceExtensionHandler.contributeNonPersitentSiteProperties(from, new SiteImpl()));
  }

  /**
   * Test new {@link AbstractSiteServiceExtensionHandler} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AbstractSiteServiceExtensionHandler}
   */
  @Test
  public void testNewAbstractSiteServiceExtensionHandler() {
    // Arrange and Act
    AbstractSiteServiceExtensionHandler actualAbstractSiteServiceExtensionHandler = new AbstractSiteServiceExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractSiteServiceExtensionHandler.getPriority());
    assertTrue(actualAbstractSiteServiceExtensionHandler.isEnabled());
  }
}

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
package org.broadleafcommerce.common.event;

import static org.junit.Assert.assertNull;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;

public class BroadleafApplicationEventDiffblueTest {
  /**
   * Method under test: {@link BroadleafApplicationEvent#getSiteId()}
   */
  @Test
  public void testGetSiteId() {
    // Arrange, Act and Assert
    assertNull((new ReindexEvent(BLCFieldUtils.NULL_FIELD)).getSiteId());
  }

  /**
   * Method under test: {@link BroadleafApplicationEvent#getCatalogId()}
   */
  @Test
  public void testGetCatalogId() {
    // Arrange, Act and Assert
    assertNull((new ReindexEvent(BLCFieldUtils.NULL_FIELD)).getCatalogId());
  }

  /**
   * Method under test: {@link BroadleafApplicationEvent#getProfileId()}
   */
  @Test
  public void testGetProfileId() {
    // Arrange, Act and Assert
    assertNull((new ReindexEvent(BLCFieldUtils.NULL_FIELD)).getProfileId());
  }

  /**
   * Method under test: {@link BroadleafApplicationEvent#getLocaleCode()}
   */
  @Test
  public void testGetLocaleCode() {
    // Arrange, Act and Assert
    assertNull((new ReindexEvent(BLCFieldUtils.NULL_FIELD)).getLocaleCode());
  }

  /**
   * Method under test: {@link BroadleafApplicationEvent#getCurrencyCode()}
   */
  @Test
  public void testGetCurrencyCode() {
    // Arrange, Act and Assert
    assertNull((new ReindexEvent(BLCFieldUtils.NULL_FIELD)).getCurrencyCode());
  }
}

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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BroadleafApplicationEventDiffblueTest {
  /**
   * Test {@link BroadleafApplicationEvent#getSiteId()}.
   * <p>
   * Method under test: {@link BroadleafApplicationEvent#getSiteId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Long BroadleafApplicationEvent.getSiteId()"})
  public void testGetSiteId() {
    // Arrange, Act and Assert
    assertNull((new ReindexEvent(BLCFieldUtils.NULL_FIELD)).getSiteId());
  }

  /**
   * Test {@link BroadleafApplicationEvent#getCatalogId()}.
   * <p>
   * Method under test: {@link BroadleafApplicationEvent#getCatalogId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Long BroadleafApplicationEvent.getCatalogId()"})
  public void testGetCatalogId() {
    // Arrange, Act and Assert
    assertNull((new ReindexEvent(BLCFieldUtils.NULL_FIELD)).getCatalogId());
  }

  /**
   * Test {@link BroadleafApplicationEvent#getProfileId()}.
   * <p>
   * Method under test: {@link BroadleafApplicationEvent#getProfileId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Long BroadleafApplicationEvent.getProfileId()"})
  public void testGetProfileId() {
    // Arrange, Act and Assert
    assertNull((new ReindexEvent(BLCFieldUtils.NULL_FIELD)).getProfileId());
  }

  /**
   * Test {@link BroadleafApplicationEvent#getCurrencyCode()}.
   * <p>
   * Method under test: {@link BroadleafApplicationEvent#getCurrencyCode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String BroadleafApplicationEvent.getCurrencyCode()"})
  public void testGetCurrencyCode() {
    // Arrange, Act and Assert
    assertNull((new ReindexEvent(BLCFieldUtils.NULL_FIELD)).getCurrencyCode());
  }
}

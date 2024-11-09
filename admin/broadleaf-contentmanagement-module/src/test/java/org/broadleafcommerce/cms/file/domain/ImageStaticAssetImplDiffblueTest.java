/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.file.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ImageStaticAssetImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ImageStaticAssetImpl}
   *   <li>{@link ImageStaticAssetImpl#setHeight(Integer)}
   *   <li>{@link ImageStaticAssetImpl#setWidth(Integer)}
   *   <li>{@link ImageStaticAssetImpl#getHeight()}
   *   <li>{@link ImageStaticAssetImpl#getWidth()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ImageStaticAssetImpl actualImageStaticAssetImpl = new ImageStaticAssetImpl();
    actualImageStaticAssetImpl.setHeight(1);
    actualImageStaticAssetImpl.setWidth(1);
    Integer actualHeight = actualImageStaticAssetImpl.getHeight();
    Integer actualWidth = actualImageStaticAssetImpl.getWidth();

    // Assert that nothing has changed
    assertEquals(1, actualHeight.intValue());
    assertEquals(1, actualWidth.intValue());
    assertTrue(actualImageStaticAssetImpl.getContentMessageValues().isEmpty());
  }
}

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
package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class ResourceBundleExtensionPointDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ResourceBundleExtensionPoint#setBasenameExtensions(String[])}
   *   <li>{@link ResourceBundleExtensionPoint#getBasenameExtensions()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ResourceBundleExtensionPoint resourceBundleExtensionPoint = new ResourceBundleExtensionPoint();
    String[] basenameExtensions = new String[]{"Basename Extensions"};

    // Act
    resourceBundleExtensionPoint.setBasenameExtensions(basenameExtensions);
    String[] actualBasenameExtensions = resourceBundleExtensionPoint.getBasenameExtensions();

    // Assert that nothing has changed
    assertSame(basenameExtensions, actualBasenameExtensions);
    assertArrayEquals(new String[]{"Basename Extensions"}, actualBasenameExtensions);
  }

  /**
   * Test new {@link ResourceBundleExtensionPoint} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link ResourceBundleExtensionPoint}
   */
  @Test
  public void testNewResourceBundleExtensionPoint() {
    // Arrange, Act and Assert
    assertEquals(0, (new ResourceBundleExtensionPoint()).getBasenameExtensions().length);
  }
}

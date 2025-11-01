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
package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.Set;
import org.junit.Test;

public class BLResourceBundleMessageSourceDiffblueTest {
  /**
   * Method under test:
   * {@link BLResourceBundleMessageSource#BLResourceBundleMessageSource(String[], ResourceBundleExtensionPoint)}
   */
  @Test
  public void testNewBLResourceBundleMessageSource() {
    // Arrange
    ResourceBundleExtensionPoint resourceBundleExtensionPoint = new ResourceBundleExtensionPoint();
    resourceBundleExtensionPoint.setBasenameExtensions(new String[]{"Basename Extensions"});

    // Act
    BLResourceBundleMessageSource actualBlResourceBundleMessageSource = new BLResourceBundleMessageSource(
        new String[]{"Basenames"}, resourceBundleExtensionPoint);

    // Assert
    assertNull(actualBlResourceBundleMessageSource.getParentMessageSource());
    Set<String> basenameSet = actualBlResourceBundleMessageSource.getBasenameSet();
    assertEquals(2, basenameSet.size());
    assertTrue(basenameSet.contains("Basename Extensions"));
    assertTrue(basenameSet.contains("Basenames"));
  }

  /**
   * Method under test:
   * {@link BLResourceBundleMessageSource#BLResourceBundleMessageSource(String[], ResourceBundleExtensionPoint)}
   */
  @Test
  public void testNewBLResourceBundleMessageSource2() {
    // Arrange and Act
    BLResourceBundleMessageSource actualBlResourceBundleMessageSource = new BLResourceBundleMessageSource(null, null);

    // Assert
    assertNull(actualBlResourceBundleMessageSource.getParentMessageSource());
    assertTrue(actualBlResourceBundleMessageSource.getBasenameSet().isEmpty());
  }

  /**
   * Method under test:
   * {@link BLResourceBundleMessageSource#BLResourceBundleMessageSource(String[], ResourceBundleExtensionPoint)}
   */
  @Test
  public void testNewBLResourceBundleMessageSource3() {
    // Arrange
    ResourceBundleExtensionPoint resourceBundleExtensionPoint = new ResourceBundleExtensionPoint();
    resourceBundleExtensionPoint.setBasenameExtensions(new String[]{"Basename Extensions"});

    // Act
    BLResourceBundleMessageSource actualBlResourceBundleMessageSource = new BLResourceBundleMessageSource(null,
        resourceBundleExtensionPoint);

    // Assert
    assertNull(actualBlResourceBundleMessageSource.getParentMessageSource());
    Set<String> basenameSet = actualBlResourceBundleMessageSource.getBasenameSet();
    assertEquals(1, basenameSet.size());
    assertTrue(basenameSet.contains("Basename Extensions"));
  }

  /**
   * Method under test:
   * {@link BLResourceBundleMessageSource#BLResourceBundleMessageSource(String[], ResourceBundleExtensionPoint)}
   */
  @Test
  public void testNewBLResourceBundleMessageSource4() {
    // Arrange
    ResourceBundleExtensionPoint resourceBundleExtensionPoint = new ResourceBundleExtensionPoint();
    resourceBundleExtensionPoint.setBasenameExtensions(null);

    // Act
    BLResourceBundleMessageSource actualBlResourceBundleMessageSource = new BLResourceBundleMessageSource(null,
        resourceBundleExtensionPoint);

    // Assert
    assertNull(actualBlResourceBundleMessageSource.getParentMessageSource());
    assertTrue(actualBlResourceBundleMessageSource.getBasenameSet().isEmpty());
  }
}

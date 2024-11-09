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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.Set;
import org.junit.Test;

public class BLResourceBundleMessageSourceDiffblueTest {
  /**
   * Test
   * {@link BLResourceBundleMessageSource#BLResourceBundleMessageSource(String[], ResourceBundleExtensionPoint)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLResourceBundleMessageSource#BLResourceBundleMessageSource(String[], ResourceBundleExtensionPoint)}
   */
  @Test
  public void testNewBLResourceBundleMessageSource_givenNull() {
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

  /**
   * Test
   * {@link BLResourceBundleMessageSource#BLResourceBundleMessageSource(String[], ResourceBundleExtensionPoint)}.
   * <ul>
   *   <li>Then return BasenameSet size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLResourceBundleMessageSource#BLResourceBundleMessageSource(String[], ResourceBundleExtensionPoint)}
   */
  @Test
  public void testNewBLResourceBundleMessageSource_thenReturnBasenameSetSizeIsOne() {
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
   * Test
   * {@link BLResourceBundleMessageSource#BLResourceBundleMessageSource(String[], ResourceBundleExtensionPoint)}.
   * <ul>
   *   <li>Then return BasenameSet size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLResourceBundleMessageSource#BLResourceBundleMessageSource(String[], ResourceBundleExtensionPoint)}
   */
  @Test
  public void testNewBLResourceBundleMessageSource_thenReturnBasenameSetSizeIsTwo() {
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
   * Test
   * {@link BLResourceBundleMessageSource#BLResourceBundleMessageSource(String[], ResourceBundleExtensionPoint)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return BasenameSet Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLResourceBundleMessageSource#BLResourceBundleMessageSource(String[], ResourceBundleExtensionPoint)}
   */
  @Test
  public void testNewBLResourceBundleMessageSource_whenNull_thenReturnBasenameSetEmpty() {
    // Arrange and Act
    BLResourceBundleMessageSource actualBlResourceBundleMessageSource = new BLResourceBundleMessageSource(null, null);

    // Assert
    assertNull(actualBlResourceBundleMessageSource.getParentMessageSource());
    assertTrue(actualBlResourceBundleMessageSource.getBasenameSet().isEmpty());
  }
}

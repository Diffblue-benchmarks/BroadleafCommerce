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
package org.broadleafcommerce.common.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.springframework.core.io.Resource;

public class BundledResourceInfoDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BundledResourceInfo#BundledResourceInfo(Resource, String, List)}
   *   <li>{@link BundledResourceInfo#setBundledFilePaths(List)}
   *   <li>{@link BundledResourceInfo#setResource(Resource)}
   *   <li>{@link BundledResourceInfo#setVersionedBundleName(String)}
   *   <li>{@link BundledResourceInfo#getBundledFilePaths()}
   *   <li>{@link BundledResourceInfo#getResource()}
   *   <li>{@link BundledResourceInfo#getVersionedBundleName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    GeneratedResource resource = new GeneratedResource();

    // Act
    BundledResourceInfo actualBundledResourceInfo = new BundledResourceInfo(resource, "1.0.2", new ArrayList<>());
    ArrayList<String> bundledFilePaths = new ArrayList<>();
    actualBundledResourceInfo.setBundledFilePaths(bundledFilePaths);
    GeneratedResource resource2 = new GeneratedResource();
    actualBundledResourceInfo.setResource(resource2);
    actualBundledResourceInfo.setVersionedBundleName("1.0.2");
    List<String> actualBundledFilePaths = actualBundledResourceInfo.getBundledFilePaths();
    Resource actualResource = actualBundledResourceInfo.getResource();

    // Assert that nothing has changed
    assertEquals("1.0.2", actualBundledResourceInfo.getVersionedBundleName());
    assertTrue(actualBundledFilePaths.isEmpty());
    assertSame(bundledFilePaths, actualBundledFilePaths);
    assertSame(resource2, actualResource);
  }
}

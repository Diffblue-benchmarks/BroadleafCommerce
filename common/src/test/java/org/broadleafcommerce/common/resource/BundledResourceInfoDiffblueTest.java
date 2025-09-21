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
package org.broadleafcommerce.common.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.core.io.Resource;

public class BundledResourceInfoDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BundledResourceInfo#BundledResourceInfo(Resource, String, List)}
   *   <li>{@link BundledResourceInfo#setResource(Resource)}
   *   <li>{@link BundledResourceInfo#setVersionedBundleName(String)}
   *   <li>{@link BundledResourceInfo#getBundledFilePaths()}
   *   <li>{@link BundledResourceInfo#getResource()}
   *   <li>{@link BundledResourceInfo#getVersionedBundleName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BundledResourceInfo.<init>(Resource, String, List)",
    "List BundledResourceInfo.getBundledFilePaths()",
    "Resource BundledResourceInfo.getResource()",
    "String BundledResourceInfo.getVersionedBundleName()",
    "void BundledResourceInfo.setBundledFilePaths(List)",
    "void BundledResourceInfo.setResource(Resource)",
    "void BundledResourceInfo.setVersionedBundleName(String)"
  })
  public void testGettersAndSetters() {
    // Arrange
    GeneratedResource resource = new GeneratedResource();
    ArrayList<String> bundledFilePaths = new ArrayList<>();

    // Act
    BundledResourceInfo actualBundledResourceInfo =
        new BundledResourceInfo(resource, "1.0.2", bundledFilePaths);
    GeneratedResource resource2 = new GeneratedResource();
    actualBundledResourceInfo.setResource(resource2);
    actualBundledResourceInfo.setVersionedBundleName("1.0.2");
    List<String> actualBundledFilePaths = actualBundledResourceInfo.getBundledFilePaths();
    Resource actualResource = actualBundledResourceInfo.getResource();

    // Assert
    assertEquals("1.0.2", actualBundledResourceInfo.getVersionedBundleName());
    assertTrue(actualBundledFilePaths.isEmpty());
    assertSame(bundledFilePaths, actualBundledFilePaths);
    assertSame(resource2, actualResource);
  }
}

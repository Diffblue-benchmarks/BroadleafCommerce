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
package org.broadleafcommerce.common.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.broadleafcommerce.test.common.properties.sources.CommonFrameworkTestProperties;
import org.broadleafcommerce.test.common.properties.sources.ProfileAwareProperties;
import org.broadleafcommerce.test.common.properties.sources.ProfileAwareSharedProperties;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BroadleafEnvironmentConfiguringPostProcessorDiffblueTest {
  /**
   * Test new {@link BroadleafEnvironmentConfiguringPostProcessor} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link BroadleafEnvironmentConfiguringPostProcessor}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafEnvironmentConfiguringPostProcessor.<init>()"})
  public void testNewBroadleafEnvironmentConfiguringPostProcessor() {
    // Arrange and Act
    BroadleafEnvironmentConfiguringPostProcessor actualBroadleafEnvironmentConfiguringPostProcessor = new BroadleafEnvironmentConfiguringPostProcessor();

    // Assert
    List<FrameworkCommonClasspathPropertySource> frameworkSources = actualBroadleafEnvironmentConfiguringPostProcessor
        .getFrameworkSources();
    assertEquals(2, frameworkSources.size());
    FrameworkCommonClasspathPropertySource getResult = frameworkSources.get(0);
    assertTrue(getResult instanceof BroadleafCommonPropertySource);
    List<BroadleafSharedOverrideProfileAwarePropertySource> profileAwareSources = actualBroadleafEnvironmentConfiguringPostProcessor
        .getProfileAwareSources();
    assertEquals(3, profileAwareSources.size());
    BroadleafSharedOverrideProfileAwarePropertySource getResult2 = profileAwareSources.get(0);
    assertTrue(getResult2 instanceof DefaultRuntimeEnvironmentProfileAwarePropertySource);
    FrameworkCommonClasspathPropertySource getResult3 = frameworkSources.get(1);
    assertTrue(getResult3 instanceof CommonFrameworkTestProperties);
    BroadleafSharedOverrideProfileAwarePropertySource getResult4 = profileAwareSources.get(1);
    assertTrue(getResult4 instanceof ProfileAwareProperties);
    BroadleafSharedOverrideProfileAwarePropertySource getResult5 = profileAwareSources.get(2);
    assertTrue(getResult5 instanceof ProfileAwareSharedProperties);
    assertEquals("common-test-properties", getResult3.getClasspathFolder());
    assertEquals("common-test-properties/profile-aware-properties", getResult4.getClasspathFolder());
    assertEquals("common-test-properties/profile-aware-shared-properties", getResult5.getClasspathFolder());
    assertEquals("config/bc/", getResult.getClasspathFolder());
    assertEquals("development", actualBroadleafEnvironmentConfiguringPostProcessor.getDeprecatedDefaultProfileKey());
    assertEquals("runtime-properties", getResult2.getClasspathFolder());
    assertEquals(FrameworkCommonClasspathPropertySource.DEFAULT_ORDER,
        ((CommonFrameworkTestProperties) getResult3).getOrder());
  }
}

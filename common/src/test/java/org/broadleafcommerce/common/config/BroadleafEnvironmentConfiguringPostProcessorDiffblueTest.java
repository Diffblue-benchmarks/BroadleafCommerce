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
package org.broadleafcommerce.common.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import org.broadleafcommerce.test.common.properties.sources.CommonFrameworkTestProperties;
import org.broadleafcommerce.test.common.properties.sources.ProfileAwareProperties;
import org.broadleafcommerce.test.common.properties.sources.ProfileAwareSharedProperties;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;

public class BroadleafEnvironmentConfiguringPostProcessorDiffblueTest {
  /**
   * Test
   * {@link BroadleafEnvironmentConfiguringPostProcessor#postProcessEnvironment(ConfigurableEnvironment, SpringApplication)}.
   * <ul>
   *   <li>Given {@code Property}.</li>
   *   <li>Then calls {@link ConfigurableEnvironment#addActiveProfile(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafEnvironmentConfiguringPostProcessor#postProcessEnvironment(ConfigurableEnvironment, SpringApplication)}
   */
  @Test
  public void testPostProcessEnvironment_givenProperty_thenCallsAddActiveProfile() {
    // Arrange
    BroadleafEnvironmentConfiguringPostProcessor broadleafEnvironmentConfiguringPostProcessor = new BroadleafEnvironmentConfiguringPostProcessor();
    ConfigurableEnvironment environment = mock(ConfigurableEnvironment.class);
    doNothing().when(environment).addActiveProfile(Mockito.<String>any());
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(environment.getActiveProfiles()).thenReturn(new String[]{"Active Profiles"});
    when(environment.getPropertySources()).thenReturn(new MutablePropertySources());
    Class<Object> forNameResult = Object.class;

    // Act
    broadleafEnvironmentConfiguringPostProcessor.postProcessEnvironment(environment,
        new SpringApplication(forNameResult));

    // Assert
    verify(environment).addActiveProfile(eq("Property"));
    verify(environment, atLeast(1)).getPropertySources();
    verify(environment, atLeast(1)).getActiveProfiles();
    verify(environment, atLeast(1)).getProperty(Mockito.<String>any());
  }

  /**
   * Test new {@link BroadleafEnvironmentConfiguringPostProcessor} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link BroadleafEnvironmentConfiguringPostProcessor}
   */
  @Test
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

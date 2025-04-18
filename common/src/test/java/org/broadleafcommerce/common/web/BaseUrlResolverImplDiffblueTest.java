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
package org.broadleafcommerce.common.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertyResolver;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BaseUrlResolverImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseUrlResolverImplDiffblueTest {
  @Autowired
  private BaseUrlResolverImpl baseUrlResolverImpl;

  @MockBean
  private Environment environment;

  /**
   * Test {@link BaseUrlResolverImpl#getSiteBaseUrl()}.
   * <ul>
   *   <li>Given {@link Environment} {@link PropertyResolver#getProperty(String)} return {@code Property}.</li>
   *   <li>Then return {@code Property}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseUrlResolverImpl#getSiteBaseUrl()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BaseUrlResolverImpl.getSiteBaseUrl()"})
  public void testGetSiteBaseUrl_givenEnvironmentGetPropertyReturnProperty_thenReturnProperty() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    // Act
    String actualSiteBaseUrl = baseUrlResolverImpl.getSiteBaseUrl();

    // Assert
    verify(environment).getProperty(eq("site.baseurl"));
    assertEquals("Property", actualSiteBaseUrl);
  }

  /**
   * Test {@link BaseUrlResolverImpl#getAdminBaseUrl()}.
   * <ul>
   *   <li>Given {@link Environment} {@link PropertyResolver#getProperty(String)} return {@code Property}.</li>
   *   <li>Then return {@code Property}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseUrlResolverImpl#getAdminBaseUrl()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BaseUrlResolverImpl.getAdminBaseUrl()"})
  public void testGetAdminBaseUrl_givenEnvironmentGetPropertyReturnProperty_thenReturnProperty() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    // Act
    String actualAdminBaseUrl = baseUrlResolverImpl.getAdminBaseUrl();

    // Assert
    verify(environment).getProperty(eq("admin.baseurl"));
    assertEquals("Property", actualAdminBaseUrl);
  }

  /**
   * Test new {@link BaseUrlResolverImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link BaseUrlResolverImpl}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseUrlResolverImpl.<init>()"})
  public void testNewBaseUrlResolverImpl() {
    // Arrange, Act and Assert
    assertNull((new BaseUrlResolverImpl()).env);
  }
}

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
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.broadleafcommerce.common.site.domain.Site;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.common.site.domain.Theme;
import org.broadleafcommerce.common.site.domain.ThemeDTO;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@ContextConfiguration(classes = {NullBroadleafThemeResolver.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class NullBroadleafThemeResolverDiffblueTest {
  @Autowired private NullBroadleafThemeResolver nullBroadleafThemeResolver;

  /**
   * Test {@link NullBroadleafThemeResolver#resolveTheme(WebRequest)} with {@code request}.
   *
   * <p>Method under test: {@link NullBroadleafThemeResolver#resolveTheme(WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Theme NullBroadleafThemeResolver.resolveTheme(WebRequest)"})
  public void testResolveThemeWithRequest() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act
    Theme actualResolveThemeResult =
        nullBroadleafThemeResolver.resolveTheme(new ServletWebRequest(request));

    // Assert
    assertTrue(actualResolveThemeResult instanceof ThemeDTO);
    assertEquals("", actualResolveThemeResult.getName());
    assertEquals("", actualResolveThemeResult.getPath());
    assertNull(actualResolveThemeResult.getId());
  }

  /**
   * Test {@link NullBroadleafThemeResolver#resolveTheme(HttpServletRequest, Site)} with {@code
   * request}, {@code site}.
   *
   * <ul>
   *   <li>Then return {@link ThemeDTO}.
   * </ul>
   *
   * <p>Method under test: {@link NullBroadleafThemeResolver#resolveTheme(HttpServletRequest, Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Theme NullBroadleafThemeResolver.resolveTheme(HttpServletRequest, Site)"})
  public void testResolveThemeWithRequestSite_thenReturnThemeDTO() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act
    Theme actualResolveThemeResult =
        nullBroadleafThemeResolver.resolveTheme(request, new SiteImpl());

    // Assert
    assertTrue(actualResolveThemeResult instanceof ThemeDTO);
    assertEquals("", actualResolveThemeResult.getName());
    assertEquals("", actualResolveThemeResult.getPath());
    assertNull(actualResolveThemeResult.getId());
  }

  /**
   * Test new {@link NullBroadleafThemeResolver} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * NullBroadleafThemeResolver}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NullBroadleafThemeResolver.<init>()"})
  public void testNewNullBroadleafThemeResolver() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    Theme resolveThemeResult = new NullBroadleafThemeResolver().resolveTheme(null);
    assertTrue(resolveThemeResult instanceof ThemeDTO);
    assertEquals("", resolveThemeResult.getName());
    assertEquals("", resolveThemeResult.getPath());
    assertNull(resolveThemeResult.getId());
  }
}

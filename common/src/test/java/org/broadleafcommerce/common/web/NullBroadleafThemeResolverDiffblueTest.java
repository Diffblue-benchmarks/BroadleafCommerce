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
package org.broadleafcommerce.common.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.site.domain.Site;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.common.site.domain.Theme;
import org.broadleafcommerce.common.site.domain.ThemeDTO;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

public class NullBroadleafThemeResolverDiffblueTest {
  /**
   * Test {@link NullBroadleafThemeResolver#resolveTheme(WebRequest)} with
   * {@code request}.
   * <p>
   * Method under test:
   * {@link NullBroadleafThemeResolver#resolveTheme(WebRequest)}
   */
  @Test
  public void testResolveThemeWithRequest() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NullBroadleafThemeResolver nullBroadleafThemeResolver = new NullBroadleafThemeResolver();

    // Act
    Theme actualResolveThemeResult = nullBroadleafThemeResolver
        .resolveTheme(new ServletWebRequest(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())));

    // Assert
    assertTrue(actualResolveThemeResult instanceof ThemeDTO);
    assertEquals("", actualResolveThemeResult.getName());
    assertEquals("", actualResolveThemeResult.getPath());
    assertNull(actualResolveThemeResult.getId());
  }

  /**
   * Test {@link NullBroadleafThemeResolver#resolveTheme(WebRequest)} with
   * {@code request}.
   * <p>
   * Method under test:
   * {@link NullBroadleafThemeResolver#resolveTheme(WebRequest)}
   */
  @Test
  public void testResolveThemeWithRequest2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NullBroadleafThemeResolver nullBroadleafThemeResolver = new NullBroadleafThemeResolver();

    // Act
    Theme actualResolveThemeResult = nullBroadleafThemeResolver.resolveTheme(new ServletWebRequest(
        new SessionlessHttpServletRequestWrapper(mock(SessionlessHttpServletRequestWrapper.class))));

    // Assert
    assertTrue(actualResolveThemeResult instanceof ThemeDTO);
    assertEquals("", actualResolveThemeResult.getName());
    assertEquals("", actualResolveThemeResult.getPath());
    assertNull(actualResolveThemeResult.getId());
  }

  /**
   * Test
   * {@link NullBroadleafThemeResolver#resolveTheme(HttpServletRequest, Site)}
   * with {@code request}, {@code site}.
   * <p>
   * Method under test:
   * {@link NullBroadleafThemeResolver#resolveTheme(HttpServletRequest, Site)}
   */
  @Test
  public void testResolveThemeWithRequestSite() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NullBroadleafThemeResolver nullBroadleafThemeResolver = new NullBroadleafThemeResolver();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());

    // Act
    Theme actualResolveThemeResult = nullBroadleafThemeResolver.resolveTheme(request, new SiteImpl());

    // Assert
    assertTrue(actualResolveThemeResult instanceof ThemeDTO);
    assertEquals("", actualResolveThemeResult.getName());
    assertEquals("", actualResolveThemeResult.getPath());
    assertNull(actualResolveThemeResult.getId());
  }

  /**
   * Test
   * {@link NullBroadleafThemeResolver#resolveTheme(HttpServletRequest, Site)}
   * with {@code request}, {@code site}.
   * <p>
   * Method under test:
   * {@link NullBroadleafThemeResolver#resolveTheme(HttpServletRequest, Site)}
   */
  @Test
  public void testResolveThemeWithRequestSite2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NullBroadleafThemeResolver nullBroadleafThemeResolver = new NullBroadleafThemeResolver();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        mock(SessionlessHttpServletRequestWrapper.class));

    // Act
    Theme actualResolveThemeResult = nullBroadleafThemeResolver.resolveTheme(request, new SiteImpl());

    // Assert
    assertTrue(actualResolveThemeResult instanceof ThemeDTO);
    assertEquals("", actualResolveThemeResult.getName());
    assertEquals("", actualResolveThemeResult.getPath());
    assertNull(actualResolveThemeResult.getId());
  }

  /**
   * Test new {@link NullBroadleafThemeResolver} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link NullBroadleafThemeResolver}
   */
  @Test
  public void testNewNullBroadleafThemeResolver() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    Theme resolveThemeResult = (new NullBroadleafThemeResolver()).resolveTheme(null);
    assertTrue(resolveThemeResult instanceof ThemeDTO);
    assertEquals("", resolveThemeResult.getName());
    assertEquals("", resolveThemeResult.getPath());
    assertNull(resolveThemeResult.getId());
  }
}

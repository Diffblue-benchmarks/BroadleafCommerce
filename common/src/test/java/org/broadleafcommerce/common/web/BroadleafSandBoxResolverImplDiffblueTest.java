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

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.sandbox.domain.SandBox;
import org.broadleafcommerce.common.site.domain.Site;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

public class BroadleafSandBoxResolverImplDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BroadleafSandBoxResolverImpl#setSandBoxPreviewEnabled(Boolean)}
   *   <li>{@link BroadleafSandBoxResolverImpl#getSandBoxPreviewEnabled()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    BroadleafSandBoxResolverImpl broadleafSandBoxResolverImpl = new BroadleafSandBoxResolverImpl();

    // Act
    broadleafSandBoxResolverImpl.setSandBoxPreviewEnabled(true);

    // Assert that nothing has changed
    assertTrue(broadleafSandBoxResolverImpl.getSandBoxPreviewEnabled());
  }

  /**
   * Method under test:
   * {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest, Site)}
   */
  @Test
  public void testResolveSandBox() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafSandBoxResolverImpl broadleafSandBoxResolverImpl = new BroadleafSandBoxResolverImpl();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());

    // Act and Assert
    assertNull(broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl()));
  }

  /**
   * Method under test:
   * {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest, Site)}
   */
  @Test
  public void testResolveSandBox2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafSandBoxResolverImpl broadleafSandBoxResolverImpl = new BroadleafSandBoxResolverImpl();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertNull(broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl()));
  }

  /**
   * Method under test:
   * {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest, Site)}
   */
  @Test
  public void testResolveSandBox3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafSandBoxResolverImpl broadleafSandBoxResolverImpl = new BroadleafSandBoxResolverImpl();

    // Act and Assert
    assertNull(broadleafSandBoxResolverImpl
        .resolveSandBox(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()), mock(Site.class)));
  }

  /**
   * Method under test:
   * {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest, Site)}
   */
  @Test
  public void testResolveSandBox4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafSandBoxResolverImpl broadleafSandBoxResolverImpl = new BroadleafSandBoxResolverImpl();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(BroadleafSandBoxResolver.SANDBOX_ID_VAR, BroadleafSandBoxResolver.SANDBOX_ID_VAR);

    // Act and Assert
    assertNull(broadleafSandBoxResolverImpl.resolveSandBox(new SessionlessHttpServletRequestWrapper(request),
        mock(Site.class)));
  }

  /**
   * Method under test:
   * {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest, Site)}
   */
  @Test
  public void testResolveSandBox5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafSandBoxResolverImpl broadleafSandBoxResolverImpl = new BroadleafSandBoxResolverImpl();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("blClearSandBox", "42");
    request.addParameter(BroadleafSandBoxResolver.SANDBOX_ID_VAR, BroadleafSandBoxResolver.SANDBOX_ID_VAR);

    // Act and Assert
    assertNull(broadleafSandBoxResolverImpl.resolveSandBox(new SessionlessHttpServletRequestWrapper(request),
        mock(Site.class)));
  }

  /**
   * Method under test:
   * {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest, Site)}
   */
  @Test
  public void testResolveSandBox6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafSandBoxResolverImpl broadleafSandBoxResolverImpl = new BroadleafSandBoxResolverImpl();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("blSandboxDateTimeRibbonProduction", "42");
    request.addParameter(BroadleafSandBoxResolver.SANDBOX_ID_VAR, BroadleafSandBoxResolver.SANDBOX_ID_VAR);

    // Act and Assert
    assertNull(broadleafSandBoxResolverImpl.resolveSandBox(new SessionlessHttpServletRequestWrapper(request),
        mock(Site.class)));
  }

  /**
   * Method under test:
   * {@link BroadleafSandBoxResolverImpl#resolveSandBox(WebRequest, Site)}
   */
  @Test
  public void testResolveSandBox7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafSandBoxResolverImpl broadleafSandBoxResolverImpl = new BroadleafSandBoxResolverImpl();
    ServletWebRequest request = new ServletWebRequest(
        new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertNull(broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl()));
  }

  /**
   * Method under test:
   * {@link BroadleafSandBoxResolverImpl#resolveSandBox(WebRequest, Site)}
   */
  @Test
  public void testResolveSandBox8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafSandBoxResolverImpl broadleafSandBoxResolverImpl = new BroadleafSandBoxResolverImpl();
    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(false);
    when(request.getParameter(Mockito.<String>any())).thenReturn("Parameter");
    doNothing().when(request).setAttribute(Mockito.<String>any(), Mockito.<Object>any(), anyInt());

    // Act
    SandBox actualResolveSandBoxResult = broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl());

    // Assert
    verify(request, atLeast(1)).getAttribute(eq("blOkToUseSession"), eq(0));
    verify(request, atLeast(1)).setAttribute(Mockito.<String>any(), Mockito.<Object>any(), eq(0));
    verify(request).getParameter(eq("blClearSandBox"));
    assertNull(actualResolveSandBoxResult);
  }
}

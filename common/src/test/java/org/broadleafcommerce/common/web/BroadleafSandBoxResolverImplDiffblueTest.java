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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.broadleafcommerce.common.crossapp.service.CrossAppAuthService;
import org.broadleafcommerce.common.sandbox.domain.SandBox;
import org.broadleafcommerce.common.site.domain.Site;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.owasp.esapi.filters.SecurityWrapperRequest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@RunWith(MockitoJUnitRunner.class)
public class BroadleafSandBoxResolverImplDiffblueTest {
  @InjectMocks private BroadleafSandBoxResolverImpl broadleafSandBoxResolverImpl;

  @Mock private CrossAppAuthService crossAppAuthService;

  /**
   * Test {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest, Site)} with {@code
   * HttpServletRequest}, {@code Site}.
   *
   * <p>Method under test: {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest,
   * Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SandBox BroadleafSandBoxResolverImpl.resolveSandBox(HttpServletRequest, Site)"
  })
  public void testResolveSandBoxWithHttpServletRequestSite() {
    // Arrange
    when(crossAppAuthService.isAuthedFromAdmin()).thenThrow(new NumberFormatException());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl()));
    verify(crossAppAuthService).isAuthedFromAdmin();
  }

  /**
   * Test {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest, Site)} with {@code
   * HttpServletRequest}, {@code Site}.
   *
   * <p>Method under test: {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest,
   * Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SandBox BroadleafSandBoxResolverImpl.resolveSandBox(HttpServletRequest, Site)"
  })
  public void testResolveSandBoxWithHttpServletRequestSite2() {
    // Arrange
    when(crossAppAuthService.hasCsrPermission()).thenReturn(true);
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(true);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act
    SandBox actualResolveSandBoxResult =
        broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl());

    // Assert
    verify(crossAppAuthService).hasCsrPermission();
    verify(crossAppAuthService).isAuthedFromAdmin();
    assertNull(actualResolveSandBoxResult);
  }

  /**
   * Test {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest, Site)} with {@code
   * HttpServletRequest}, {@code Site}.
   *
   * <p>Method under test: {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest,
   * Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SandBox BroadleafSandBoxResolverImpl.resolveSandBox(HttpServletRequest, Site)"
  })
  public void testResolveSandBoxWithHttpServletRequestSite3() {
    // Arrange
    when(crossAppAuthService.hasCsrPermission()).thenThrow(new NumberFormatException());
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(true);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl()));
    verify(crossAppAuthService).hasCsrPermission();
    verify(crossAppAuthService).isAuthedFromAdmin();
  }

  /**
   * Test {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest, Site)} with {@code
   * HttpServletRequest}, {@code Site}.
   *
   * <p>Method under test: {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest,
   * Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SandBox BroadleafSandBoxResolverImpl.resolveSandBox(HttpServletRequest, Site)"
  })
  public void testResolveSandBoxWithHttpServletRequestSite4() {
    // Arrange
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(false);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act
    SandBox actualResolveSandBoxResult =
        broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl());

    // Assert
    verify(crossAppAuthService).isAuthedFromAdmin();
    assertNull(actualResolveSandBoxResult);
  }

  /**
   * Test {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest, Site)} with {@code
   * HttpServletRequest}, {@code Site}.
   *
   * <p>Method under test: {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest,
   * Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SandBox BroadleafSandBoxResolverImpl.resolveSandBox(HttpServletRequest, Site)"
  })
  public void testResolveSandBoxWithHttpServletRequestSite5() {
    // Arrange
    when(crossAppAuthService.hasCsrPermission()).thenReturn(false);
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(true);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    SecurityWrapperRequest request2 = new SecurityWrapperRequest(request);

    // Act
    SandBox actualResolveSandBoxResult =
        broadleafSandBoxResolverImpl.resolveSandBox(request2, new SiteImpl());

    // Assert
    verify(crossAppAuthService).hasCsrPermission();
    verify(crossAppAuthService).isAuthedFromAdmin();
    assertNull(actualResolveSandBoxResult);
  }

  /**
   * Test {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest, Site)} with {@code
   * HttpServletRequest}, {@code Site}.
   *
   * <ul>
   *   <li>Given {@link BroadleafSandBoxResolverImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest,
   * Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SandBox BroadleafSandBoxResolverImpl.resolveSandBox(HttpServletRequest, Site)"
  })
  public void testResolveSandBoxWithHttpServletRequestSite_givenBroadleafSandBoxResolverImpl() {
    // Arrange
    BroadleafSandBoxResolverImpl broadleafSandBoxResolverImpl = new BroadleafSandBoxResolverImpl();
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertNull(broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl()));
  }

  /**
   * Test {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest, Site)} with {@code
   * HttpServletRequest}, {@code Site}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then calls {@link MockHttpServletRequest#addParameter(String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest,
   * Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SandBox BroadleafSandBoxResolverImpl.resolveSandBox(HttpServletRequest, Site)"
  })
  public void testResolveSandBoxWithHttpServletRequestSite_givenFalse_thenCallsAddParameter()
      throws UnsupportedEncodingException {
    // Arrange
    when(crossAppAuthService.hasCsrPermission()).thenReturn(false);
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(true);

    MockHttpServletRequest request = mock(MockHttpServletRequest.class);
    doNothing().when(request).setCharacterEncoding(Mockito.<String>any());
    when(request.getAttribute(Mockito.<String>any())).thenReturn(false);
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");
    doNothing().when(request).addParameter(Mockito.<String>any(), Mockito.<String>any());
    doNothing().when(request).setAttribute(Mockito.<String>any(), Mockito.<Object>any());
    request.addParameter(
        BroadleafIncludeMyChangesResolver.INCLUDE_MY_CHANGES_VAR,
        BroadleafSandBoxResolver.SANDBOX_ID_VAR);

    SessionlessHttpServletRequestWrapper request2 =
        new SessionlessHttpServletRequestWrapper(request);
    request2.setCharacterEncoding("https://example.org/example");
    HttpServletRequestWrapper request3 = new HttpServletRequestWrapper(request2);

    // Act
    SandBox actualResolveSandBoxResult =
        broadleafSandBoxResolverImpl.resolveSandBox(request3, new SiteImpl());

    // Assert
    verify(crossAppAuthService).hasCsrPermission();
    verify(crossAppAuthService).isAuthedFromAdmin();
    verify(request).addParameter("blIncludeMyChanges", "blSandboxId");
    verify(request, atLeast(1)).getAttribute("blOkToUseSession");
    verify(request).getParameter("blClearSandBox");
    verify(request, atLeast(1)).setAttribute(Mockito.<String>any(), Mockito.<Object>any());
    verify(request).setCharacterEncoding("https://example.org/example");
    assertNull(actualResolveSandBoxResult);
  }

  /**
   * Test {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest, Site)} with {@code
   * HttpServletRequest}, {@code Site}.
   *
   * <ul>
   *   <li>Then calls {@link SessionlessHttpServletRequestWrapper#getAttribute(String)}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest,
   * Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SandBox BroadleafSandBoxResolverImpl.resolveSandBox(HttpServletRequest, Site)"
  })
  public void testResolveSandBoxWithHttpServletRequestSite_thenCallsGetAttribute() {
    // Arrange
    when(crossAppAuthService.hasCsrPermission()).thenReturn(false);
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(true);

    SessionlessHttpServletRequestWrapper request = mock(SessionlessHttpServletRequestWrapper.class);
    when(request.getAttribute(Mockito.<String>any())).thenReturn(true);
    when(request.getParameter(Mockito.<String>any())).thenReturn("Parameter");
    when(request.getSession(anyBoolean())).thenReturn(new MockHttpSession());
    doNothing().when(request).setAttribute(Mockito.<String>any(), Mockito.<Object>any());

    // Act
    SandBox actualResolveSandBoxResult =
        broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl());

    // Assert
    verify(request, atLeast(1)).getAttribute("blOkToUseSession");
    verify(request, atLeast(1)).getParameter(Mockito.<String>any());
    verify(request, atLeast(1)).setAttribute(Mockito.<String>any(), Mockito.<Object>any());
    verify(crossAppAuthService).hasCsrPermission();
    verify(crossAppAuthService).isAuthedFromAdmin();
    verify(request, atLeast(1)).getSession(anyBoolean());
    assertNull(actualResolveSandBoxResult);
  }

  /**
   * Test {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest, Site)} with {@code
   * HttpServletRequest}, {@code Site}.
   *
   * <ul>
   *   <li>Then calls {@link CrossAppAuthService#hasCsrPermission()}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest,
   * Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SandBox BroadleafSandBoxResolverImpl.resolveSandBox(HttpServletRequest, Site)"
  })
  public void testResolveSandBoxWithHttpServletRequestSite_thenCallsHasCsrPermission() {
    // Arrange
    when(crossAppAuthService.hasCsrPermission()).thenReturn(false);
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(true);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act
    SandBox actualResolveSandBoxResult =
        broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl());

    // Assert
    verify(crossAppAuthService).hasCsrPermission();
    verify(crossAppAuthService).isAuthedFromAdmin();
    assertNull(actualResolveSandBoxResult);
  }

  /**
   * Test {@link BroadleafSandBoxResolverImpl#resolveSandBox(WebRequest, Site)} with {@code
   * WebRequest}, {@code Site}.
   *
   * <p>Method under test: {@link BroadleafSandBoxResolverImpl#resolveSandBox(WebRequest, Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SandBox BroadleafSandBoxResolverImpl.resolveSandBox(WebRequest, Site)"})
  public void testResolveSandBoxWithWebRequestSite() {
    // Arrange
    when(crossAppAuthService.isAuthedFromAdmin()).thenThrow(new NumberFormatException());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    ServletWebRequest request2 = new ServletWebRequest(request);

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> broadleafSandBoxResolverImpl.resolveSandBox(request2, new SiteImpl()));
    verify(crossAppAuthService).isAuthedFromAdmin();
  }

  /**
   * Test {@link BroadleafSandBoxResolverImpl#resolveSandBox(WebRequest, Site)} with {@code
   * WebRequest}, {@code Site}.
   *
   * <p>Method under test: {@link BroadleafSandBoxResolverImpl#resolveSandBox(WebRequest, Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SandBox BroadleafSandBoxResolverImpl.resolveSandBox(WebRequest, Site)"})
  public void testResolveSandBoxWithWebRequestSite2() {
    // Arrange
    when(crossAppAuthService.hasCsrPermission()).thenThrow(new NumberFormatException());
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(true);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    ServletWebRequest request2 = new ServletWebRequest(request);

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> broadleafSandBoxResolverImpl.resolveSandBox(request2, new SiteImpl()));
    verify(crossAppAuthService).hasCsrPermission();
    verify(crossAppAuthService).isAuthedFromAdmin();
  }

  /**
   * Test {@link BroadleafSandBoxResolverImpl#resolveSandBox(WebRequest, Site)} with {@code
   * WebRequest}, {@code Site}.
   *
   * <ul>
   *   <li>Given {@link BroadleafSandBoxResolverImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BroadleafSandBoxResolverImpl#resolveSandBox(WebRequest, Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SandBox BroadleafSandBoxResolverImpl.resolveSandBox(WebRequest, Site)"})
  public void testResolveSandBoxWithWebRequestSite_givenBroadleafSandBoxResolverImpl() {
    // Arrange
    BroadleafSandBoxResolverImpl broadleafSandBoxResolverImpl = new BroadleafSandBoxResolverImpl();
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    ServletWebRequest request2 = new ServletWebRequest(request);

    // Act and Assert
    assertNull(broadleafSandBoxResolverImpl.resolveSandBox(request2, new SiteImpl()));
  }

  /**
   * Test {@link BroadleafSandBoxResolverImpl#resolveSandBox(WebRequest, Site)} with {@code
   * WebRequest}, {@code Site}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafSandBoxResolverImpl#resolveSandBox(WebRequest, Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SandBox BroadleafSandBoxResolverImpl.resolveSandBox(WebRequest, Site)"})
  public void testResolveSandBoxWithWebRequestSite_givenNull() {
    // Arrange
    BroadleafSandBoxResolverImpl broadleafSandBoxResolverImpl = new BroadleafSandBoxResolverImpl();

    WebRequest request = mock(WebRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn(null);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(false);
    doNothing().when(request).setAttribute(Mockito.<String>any(), Mockito.<Object>any(), anyInt());

    // Act
    SandBox actualResolveSandBoxResult =
        broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl());

    // Assert
    verify(request, atLeast(1)).getAttribute("blOkToUseSession", 0);
    verify(request, atLeast(1)).setAttribute(Mockito.<String>any(), Mockito.<Object>any(), eq(0));
    verify(request, atLeast(1)).getParameter(Mockito.<String>any());
    assertNull(actualResolveSandBoxResult);
  }

  /**
   * Test {@link BroadleafSandBoxResolverImpl#resolveSandBox(WebRequest, Site)} with {@code
   * WebRequest}, {@code Site}.
   *
   * <ul>
   *   <li>Given {@link Boolean#TRUE} toString.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafSandBoxResolverImpl#resolveSandBox(WebRequest, Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SandBox BroadleafSandBoxResolverImpl.resolveSandBox(WebRequest, Site)"})
  public void testResolveSandBoxWithWebRequestSite_givenTrueToString() {
    // Arrange
    BroadleafSandBoxResolverImpl broadleafSandBoxResolverImpl = new BroadleafSandBoxResolverImpl();

    WebRequest request = mock(WebRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn(Boolean.TRUE.toString());
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(false);
    doNothing().when(request).setAttribute(Mockito.<String>any(), Mockito.<Object>any(), anyInt());

    // Act
    SandBox actualResolveSandBoxResult =
        broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl());

    // Assert
    verify(request, atLeast(1)).getAttribute("blOkToUseSession", 0);
    verify(request, atLeast(1)).setAttribute(Mockito.<String>any(), Mockito.<Object>any(), eq(0));
    verify(request).getParameter("blClearSandBox");
    assertNull(actualResolveSandBoxResult);
  }

  /**
   * Test {@link BroadleafSandBoxResolverImpl#resolveSandBox(WebRequest, Site)} with {@code
   * WebRequest}, {@code Site}.
   *
   * <ul>
   *   <li>Then calls {@link CrossAppAuthService#hasCsrPermission()}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafSandBoxResolverImpl#resolveSandBox(WebRequest, Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SandBox BroadleafSandBoxResolverImpl.resolveSandBox(WebRequest, Site)"})
  public void testResolveSandBoxWithWebRequestSite_thenCallsHasCsrPermission() {
    // Arrange
    when(crossAppAuthService.hasCsrPermission()).thenReturn(true);
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(true);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    ServletWebRequest request2 = new ServletWebRequest(request);

    // Act
    SandBox actualResolveSandBoxResult =
        broadleafSandBoxResolverImpl.resolveSandBox(request2, new SiteImpl());

    // Assert
    verify(crossAppAuthService).hasCsrPermission();
    verify(crossAppAuthService).isAuthedFromAdmin();
    assertNull(actualResolveSandBoxResult);
  }

  /**
   * Test {@link BroadleafSandBoxResolverImpl#resolveSandBox(WebRequest, Site)} with {@code
   * WebRequest}, {@code Site}.
   *
   * <ul>
   *   <li>Then calls {@link CrossAppAuthService#hasCsrPermission()}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafSandBoxResolverImpl#resolveSandBox(WebRequest, Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SandBox BroadleafSandBoxResolverImpl.resolveSandBox(WebRequest, Site)"})
  public void testResolveSandBoxWithWebRequestSite_thenCallsHasCsrPermission2() {
    // Arrange
    when(crossAppAuthService.hasCsrPermission()).thenReturn(true);
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(true);

    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(false);
    doNothing().when(request).setAttribute(Mockito.<String>any(), Mockito.<Object>any(), anyInt());

    // Act
    SandBox actualResolveSandBoxResult =
        broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl());

    // Assert
    verify(crossAppAuthService).hasCsrPermission();
    verify(crossAppAuthService).isAuthedFromAdmin();
    verify(request).getAttribute("blOkToUseSession", 0);
    verify(request, atLeast(1)).setAttribute(Mockito.<String>any(), Mockito.<Object>any(), eq(0));
    assertNull(actualResolveSandBoxResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BroadleafSandBoxResolverImpl#setSandBoxPreviewEnabled(Boolean)}
   *   <li>{@link BroadleafSandBoxResolverImpl#getSandBoxPreviewEnabled()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean BroadleafSandBoxResolverImpl.getSandBoxPreviewEnabled()",
    "void BroadleafSandBoxResolverImpl.setSandBoxPreviewEnabled(Boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange
    BroadleafSandBoxResolverImpl broadleafSandBoxResolverImpl = new BroadleafSandBoxResolverImpl();

    // Act
    broadleafSandBoxResolverImpl.setSandBoxPreviewEnabled(true);

    // Assert
    assertTrue(broadleafSandBoxResolverImpl.getSandBoxPreviewEnabled());
  }
}

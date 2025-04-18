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
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.crossapp.service.CrossAppAuthService;
import org.broadleafcommerce.common.sandbox.dao.SandBoxDao;
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
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@RunWith(MockitoJUnitRunner.class)
public class BroadleafSandBoxResolverImplDiffblueTest {
  @InjectMocks
  private BroadleafSandBoxResolverImpl broadleafSandBoxResolverImpl;

  @Mock
  private CrossAppAuthService crossAppAuthService;

  @Mock
  private SandBoxDao sandBoxDao;

  /**
   * Test {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest, Site)} with {@code HttpServletRequest}, {@code Site}.
   * <p>
   * Method under test: {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest, Site)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SandBox BroadleafSandBoxResolverImpl.resolveSandBox(HttpServletRequest, Site)"})
  public void testResolveSandBoxWithHttpServletRequestSite() {
    // Arrange
    when(crossAppAuthService.hasCsrPermission()).thenReturn(true);
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(true);
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());

    // Act
    SandBox actualResolveSandBoxResult = broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl());

    // Assert
    verify(crossAppAuthService).hasCsrPermission();
    verify(crossAppAuthService).isAuthedFromAdmin();
    assertNull(actualResolveSandBoxResult);
  }

  /**
   * Test {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest, Site)} with {@code HttpServletRequest}, {@code Site}.
   * <p>
   * Method under test: {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest, Site)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SandBox BroadleafSandBoxResolverImpl.resolveSandBox(HttpServletRequest, Site)"})
  public void testResolveSandBoxWithHttpServletRequestSite2() {
    // Arrange
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(false);
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());

    // Act
    SandBox actualResolveSandBoxResult = broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl());

    // Assert
    verify(crossAppAuthService).isAuthedFromAdmin();
    assertNull(actualResolveSandBoxResult);
  }

  /**
   * Test {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest, Site)} with {@code HttpServletRequest}, {@code Site}.
   * <ul>
   *   <li>Given {@link BroadleafSandBoxResolverImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest, Site)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SandBox BroadleafSandBoxResolverImpl.resolveSandBox(HttpServletRequest, Site)"})
  public void testResolveSandBoxWithHttpServletRequestSite_givenBroadleafSandBoxResolverImpl() {
    // Arrange
    BroadleafSandBoxResolverImpl broadleafSandBoxResolverImpl = new BroadleafSandBoxResolverImpl();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());

    // Act and Assert
    assertNull(broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl()));
  }

  /**
   * Test {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest, Site)} with {@code HttpServletRequest}, {@code Site}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then calls {@link MockHttpServletRequest#addParameter(String, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest, Site)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SandBox BroadleafSandBoxResolverImpl.resolveSandBox(HttpServletRequest, Site)"})
  public void testResolveSandBoxWithHttpServletRequestSite_givenFalse_thenCallsAddParameter() {
    // Arrange
    when(crossAppAuthService.hasCsrPermission()).thenReturn(false);
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(true);
    MockHttpServletRequest request = mock(MockHttpServletRequest.class);
    when(request.getAttribute(Mockito.<String>any())).thenReturn(false);
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");
    doNothing().when(request).addParameter(Mockito.<String>any(), Mockito.<String>any());
    doNothing().when(request).setAttribute(Mockito.<String>any(), Mockito.<Object>any());
    request.addParameter(BroadleafIncludeMyChangesResolver.INCLUDE_MY_CHANGES_VAR,
        BroadleafSandBoxResolver.SANDBOX_ID_VAR);
    SessionlessHttpServletRequestWrapper request2 = new SessionlessHttpServletRequestWrapper(request);

    // Act
    SandBox actualResolveSandBoxResult = broadleafSandBoxResolverImpl.resolveSandBox(request2, new SiteImpl());

    // Assert
    verify(crossAppAuthService).hasCsrPermission();
    verify(crossAppAuthService).isAuthedFromAdmin();
    verify(request).addParameter(eq("blIncludeMyChanges"), eq("blSandboxId"));
    verify(request, atLeast(1)).getAttribute(eq("blOkToUseSession"));
    verify(request).getParameter(eq("blClearSandBox"));
    verify(request, atLeast(1)).setAttribute(Mockito.<String>any(), Mockito.<Object>any());
    assertNull(actualResolveSandBoxResult);
  }

  /**
   * Test {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest, Site)} with {@code HttpServletRequest}, {@code Site}.
   * <ul>
   *   <li>Then calls {@link CrossAppAuthService#hasCsrPermission()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest, Site)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SandBox BroadleafSandBoxResolverImpl.resolveSandBox(HttpServletRequest, Site)"})
  public void testResolveSandBoxWithHttpServletRequestSite_thenCallsHasCsrPermission() {
    // Arrange
    when(crossAppAuthService.hasCsrPermission()).thenReturn(false);
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(true);
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());

    // Act
    SandBox actualResolveSandBoxResult = broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl());

    // Assert
    verify(crossAppAuthService).hasCsrPermission();
    verify(crossAppAuthService).isAuthedFromAdmin();
    assertNull(actualResolveSandBoxResult);
  }

  /**
   * Test {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest, Site)} with {@code HttpServletRequest}, {@code Site}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest, Site)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SandBox BroadleafSandBoxResolverImpl.resolveSandBox(HttpServletRequest, Site)"})
  public void testResolveSandBoxWithHttpServletRequestSite_thenThrowNumberFormatException() {
    // Arrange
    when(crossAppAuthService.hasCsrPermission())
        .thenThrow(new NumberFormatException(BroadleafSandBoxResolver.SANDBOX_ID_VAR));
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(true);
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl()));
    verify(crossAppAuthService).hasCsrPermission();
    verify(crossAppAuthService).isAuthedFromAdmin();
  }

  /**
   * Test {@link BroadleafSandBoxResolverImpl#resolveSandBox(WebRequest, Site)} with {@code WebRequest}, {@code Site}.
   * <p>
   * Method under test: {@link BroadleafSandBoxResolverImpl#resolveSandBox(WebRequest, Site)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SandBox BroadleafSandBoxResolverImpl.resolveSandBox(WebRequest, Site)"})
  public void testResolveSandBoxWithWebRequestSite() {
    // Arrange
    when(crossAppAuthService.hasCsrPermission()).thenReturn(true);
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(true);
    ServletWebRequest request = new ServletWebRequest(
        new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act
    SandBox actualResolveSandBoxResult = broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl());

    // Assert
    verify(crossAppAuthService).hasCsrPermission();
    verify(crossAppAuthService).isAuthedFromAdmin();
    assertNull(actualResolveSandBoxResult);
  }

  /**
   * Test {@link BroadleafSandBoxResolverImpl#resolveSandBox(WebRequest, Site)} with {@code WebRequest}, {@code Site}.
   * <p>
   * Method under test: {@link BroadleafSandBoxResolverImpl#resolveSandBox(WebRequest, Site)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SandBox BroadleafSandBoxResolverImpl.resolveSandBox(WebRequest, Site)"})
  public void testResolveSandBoxWithWebRequestSite2() {
    // Arrange
    when(crossAppAuthService.hasCsrPermission()).thenReturn(false);
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(true);
    ServletWebRequest request = new ServletWebRequest(
        new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act
    SandBox actualResolveSandBoxResult = broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl());

    // Assert
    verify(crossAppAuthService).hasCsrPermission();
    verify(crossAppAuthService).isAuthedFromAdmin();
    assertNull(actualResolveSandBoxResult);
  }

  /**
   * Test {@link BroadleafSandBoxResolverImpl#resolveSandBox(WebRequest, Site)} with {@code WebRequest}, {@code Site}.
   * <p>
   * Method under test: {@link BroadleafSandBoxResolverImpl#resolveSandBox(WebRequest, Site)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SandBox BroadleafSandBoxResolverImpl.resolveSandBox(WebRequest, Site)"})
  public void testResolveSandBoxWithWebRequestSite3() {
    // Arrange
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(false);
    ServletWebRequest request = new ServletWebRequest(
        new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act
    SandBox actualResolveSandBoxResult = broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl());

    // Assert
    verify(crossAppAuthService).isAuthedFromAdmin();
    assertNull(actualResolveSandBoxResult);
  }

  /**
   * Test {@link BroadleafSandBoxResolverImpl#resolveSandBox(WebRequest, Site)} with {@code WebRequest}, {@code Site}.
   * <ul>
   *   <li>Given {@link BroadleafSandBoxResolverImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafSandBoxResolverImpl#resolveSandBox(WebRequest, Site)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SandBox BroadleafSandBoxResolverImpl.resolveSandBox(WebRequest, Site)"})
  public void testResolveSandBoxWithWebRequestSite_givenBroadleafSandBoxResolverImpl() {
    // Arrange
    BroadleafSandBoxResolverImpl broadleafSandBoxResolverImpl = new BroadleafSandBoxResolverImpl();
    ServletWebRequest request = new ServletWebRequest(
        new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertNull(broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl()));
  }

  /**
   * Test {@link BroadleafSandBoxResolverImpl#resolveSandBox(WebRequest, Site)} with {@code WebRequest}, {@code Site}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then calls {@link RequestAttributes#getAttribute(String, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafSandBoxResolverImpl#resolveSandBox(WebRequest, Site)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SandBox BroadleafSandBoxResolverImpl.resolveSandBox(WebRequest, Site)"})
  public void testResolveSandBoxWithWebRequestSite_givenFalse_thenCallsGetAttribute() {
    // Arrange
    when(crossAppAuthService.hasCsrPermission()).thenReturn(true);
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(true);
    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(false);
    doNothing().when(request).setAttribute(Mockito.<String>any(), Mockito.<Object>any(), anyInt());

    // Act
    SandBox actualResolveSandBoxResult = broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl());

    // Assert
    verify(crossAppAuthService).hasCsrPermission();
    verify(crossAppAuthService).isAuthedFromAdmin();
    verify(request).getAttribute(eq("blOkToUseSession"), eq(0));
    verify(request, atLeast(1)).setAttribute(Mockito.<String>any(), Mockito.<Object>any(), eq(0));
    assertNull(actualResolveSandBoxResult);
  }

  /**
   * Test {@link BroadleafSandBoxResolverImpl#resolveSandBox(WebRequest, Site)} with {@code WebRequest}, {@code Site}.
   * <ul>
   *   <li>Given {@code Parameter}.</li>
   *   <li>Then calls {@link WebRequest#getParameter(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafSandBoxResolverImpl#resolveSandBox(WebRequest, Site)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SandBox BroadleafSandBoxResolverImpl.resolveSandBox(WebRequest, Site)"})
  public void testResolveSandBoxWithWebRequestSite_givenParameter_thenCallsGetParameter() {
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

  /**
   * Test {@link BroadleafSandBoxResolverImpl#resolveSandBox(WebRequest, Site)} with {@code WebRequest}, {@code Site}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafSandBoxResolverImpl#resolveSandBox(WebRequest, Site)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SandBox BroadleafSandBoxResolverImpl.resolveSandBox(WebRequest, Site)"})
  public void testResolveSandBoxWithWebRequestSite_thenThrowNumberFormatException() {
    // Arrange
    when(crossAppAuthService.hasCsrPermission())
        .thenThrow(new NumberFormatException(BroadleafSandBoxResolver.SANDBOX_ID_VAR));
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(true);
    ServletWebRequest request = new ServletWebRequest(
        new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl()));
    verify(crossAppAuthService).hasCsrPermission();
    verify(crossAppAuthService).isAuthedFromAdmin();
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BroadleafSandBoxResolverImpl#setSandBoxPreviewEnabled(Boolean)}
   *   <li>{@link BroadleafSandBoxResolverImpl#getSandBoxPreviewEnabled()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean BroadleafSandBoxResolverImpl.getSandBoxPreviewEnabled()",
      "void BroadleafSandBoxResolverImpl.setSandBoxPreviewEnabled(Boolean)"})
  public void testGettersAndSetters() {
    // Arrange
    BroadleafSandBoxResolverImpl broadleafSandBoxResolverImpl = new BroadleafSandBoxResolverImpl();

    // Act
    broadleafSandBoxResolverImpl.setSandBoxPreviewEnabled(true);

    // Assert
    assertTrue(broadleafSandBoxResolverImpl.getSandBoxPreviewEnabled());
  }
}

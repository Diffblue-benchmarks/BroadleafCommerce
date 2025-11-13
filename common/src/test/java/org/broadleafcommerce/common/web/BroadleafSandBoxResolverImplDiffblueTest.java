package org.broadleafcommerce.common.web;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.crossapp.service.CrossAppAuthService;
import org.broadleafcommerce.common.sandbox.dao.SandBoxDao;
import org.broadleafcommerce.common.sandbox.domain.SandBox;
import org.broadleafcommerce.common.sandbox.domain.SandBoxImpl;
import org.broadleafcommerce.common.sandbox.domain.SandBoxType;
import org.broadleafcommerce.common.site.domain.Site;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@RunWith(MockitoJUnitRunner.class)
public class BroadleafSandBoxResolverImplDiffblueTest {
  @InjectMocks private BroadleafSandBoxResolverImpl broadleafSandBoxResolverImpl;

  @Mock private CrossAppAuthService crossAppAuthService;

  @Mock private SandBoxDao sandBoxDao;

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
    BroadleafSandBoxResolverImpl broadleafSandBoxResolverImpl = new BroadleafSandBoxResolverImpl();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(
        BroadleafSandBoxResolver.SANDBOX_ID_VAR,
        BroadleafIncludeMyChangesResolver.INCLUDE_MY_CHANGES_VAR);
    request.addParameter(
        BroadleafIncludeMyChangesResolver.INCLUDE_MY_CHANGES_VAR,
        BroadleafSandBoxResolver.SANDBOX_ID_VAR);
    request.addParameter(BroadleafSandBoxResolver.SANDBOX_ID_VAR, "42");

    // Act and Assert
    assertNull(broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl()));
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
    BroadleafSandBoxResolverImpl broadleafSandBoxResolverImpl = new BroadleafSandBoxResolverImpl();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(
        BroadleafSandBoxResolver.SANDBOX_ID_VAR,
        BroadleafIncludeMyChangesResolver.INCLUDE_MY_CHANGES_VAR);
    request.addParameter(
        "blSandboxDateTimeRibbonProduction", BroadleafSandBoxResolver.SANDBOX_ID_VAR);
    request.addParameter(BroadleafSandBoxResolver.SANDBOX_ID_VAR, "42");

    // Act and Assert
    assertNull(broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl()));
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
    when(crossAppAuthService.isAuthedFromAdmin()).thenThrow(new NumberFormatException());
    MockHttpServletRequest request = new MockHttpServletRequest();

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
  public void testResolveSandBoxWithHttpServletRequestSite4() {
    // Arrange
    when(crossAppAuthService.hasCsrPermission()).thenReturn(true);
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(true);
    MockHttpServletRequest request = new MockHttpServletRequest();

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
  public void testResolveSandBoxWithHttpServletRequestSite5() {
    // Arrange
    when(crossAppAuthService.hasCsrPermission()).thenThrow(new NumberFormatException());
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(true);
    MockHttpServletRequest request = new MockHttpServletRequest();

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
  public void testResolveSandBoxWithHttpServletRequestSite6() {
    // Arrange
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(false);
    MockHttpServletRequest request = new MockHttpServletRequest();

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
  public void testResolveSandBoxWithHttpServletRequestSite7() {
    // Arrange
    when(crossAppAuthService.hasCsrPermission()).thenReturn(false);
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(true);
    when(sandBoxDao.retrieve(Mockito.<Long>any())).thenThrow(new NumberFormatException());

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(BroadleafSandBoxResolver.SANDBOX_ID_VAR, "42");

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl()));
    verify(crossAppAuthService).hasCsrPermission();
    verify(crossAppAuthService).isAuthedFromAdmin();
    verify(sandBoxDao).retrieve(42L);
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
  public void testResolveSandBoxWithHttpServletRequestSite8() {
    // Arrange
    when(crossAppAuthService.hasCsrPermission()).thenReturn(false);
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(true);

    SandBox sandBox = mock(SandBox.class);
    when(sandBox.getSandBoxType()).thenReturn(SandBoxType.APPROVAL);
    when(sandBoxDao.retrieve(Mockito.<Long>any())).thenReturn(sandBox);

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(BroadleafSandBoxResolver.SANDBOX_ID_VAR, "42");

    // Act
    broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl());

    // Assert
    verify(crossAppAuthService).hasCsrPermission();
    verify(crossAppAuthService).isAuthedFromAdmin();
    verify(sandBoxDao).retrieve(42L);
    verify(sandBox).getSandBoxType();
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
  public void testResolveSandBoxWithHttpServletRequestSite9() {
    // Arrange
    when(crossAppAuthService.hasCsrPermission()).thenReturn(false);
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(true);

    SandBox sandBox = mock(SandBox.class);
    when(sandBox.getSandBoxType()).thenThrow(new NumberFormatException());
    when(sandBoxDao.retrieve(Mockito.<Long>any())).thenReturn(sandBox);

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(BroadleafSandBoxResolver.SANDBOX_ID_VAR, "42");

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl()));
    verify(crossAppAuthService).hasCsrPermission();
    verify(crossAppAuthService).isAuthedFromAdmin();
    verify(sandBoxDao).retrieve(42L);
    verify(sandBox).getSandBoxType();
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
  public void testResolveSandBoxWithHttpServletRequestSite10() {
    // Arrange
    when(crossAppAuthService.hasCsrPermission()).thenReturn(false);
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(true);

    SandBox sandBox = mock(SandBox.class);
    when(sandBox.getSandBoxType()).thenReturn(SandBoxType.PRODUCTION);
    when(sandBoxDao.retrieve(Mockito.<Long>any())).thenReturn(sandBox);

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(BroadleafSandBoxResolver.SANDBOX_ID_VAR, "42");

    // Act
    broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl());

    // Assert
    verify(crossAppAuthService).hasCsrPermission();
    verify(crossAppAuthService).isAuthedFromAdmin();
    verify(sandBoxDao).retrieve(42L);
    verify(sandBox).getSandBoxType();
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
  public void testResolveSandBoxWithHttpServletRequestSite11() {
    // Arrange
    when(crossAppAuthService.hasCsrPermission()).thenReturn(false);
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(true);

    SandBox sandBox = mock(SandBox.class);
    when(sandBox.getSandBoxType()).thenReturn(null);
    when(sandBoxDao.retrieve(Mockito.<Long>any())).thenReturn(sandBox);

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(BroadleafSandBoxResolver.SANDBOX_ID_VAR, "42");

    // Act
    broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl());

    // Assert
    verify(crossAppAuthService).hasCsrPermission();
    verify(crossAppAuthService).isAuthedFromAdmin();
    verify(sandBoxDao).retrieve(42L);
    verify(sandBox).getSandBoxType();
  }

  /**
   * Test {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest, Site)} with {@code
   * HttpServletRequest}, {@code Site}.
   *
   * <ul>
   *   <li>Given {@code blClearSandBox}.
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
  public void testResolveSandBoxWithHttpServletRequestSite_givenBlClearSandBox() {
    // Arrange
    BroadleafSandBoxResolverImpl broadleafSandBoxResolverImpl = new BroadleafSandBoxResolverImpl();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(
        "blClearSandBox", BroadleafIncludeMyChangesResolver.INCLUDE_MY_CHANGES_VAR);
    request.addParameter(
        BroadleafIncludeMyChangesResolver.INCLUDE_MY_CHANGES_VAR,
        BroadleafSandBoxResolver.SANDBOX_ID_VAR);
    request.addParameter(BroadleafSandBoxResolver.SANDBOX_ID_VAR, "42");

    // Act and Assert
    assertNull(broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl()));
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
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertNull(broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl()));
  }

  /**
   * Test {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest, Site)} with {@code
   * HttpServletRequest}, {@code Site}.
   *
   * <ul>
   *   <li>Given {@link SandBoxDao} {@link SandBoxDao#retrieve(Long)} return {@code null}.
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
  public void testResolveSandBoxWithHttpServletRequestSite_givenSandBoxDaoRetrieveReturnNull() {
    // Arrange
    when(crossAppAuthService.hasCsrPermission()).thenReturn(false);
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(true);
    when(sandBoxDao.retrieve(Mockito.<Long>any())).thenReturn(null);

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(BroadleafSandBoxResolver.SANDBOX_ID_VAR, "42");

    // Act
    SandBox actualResolveSandBoxResult =
        broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl());

    // Assert
    verify(crossAppAuthService).hasCsrPermission();
    verify(crossAppAuthService).isAuthedFromAdmin();
    verify(sandBoxDao).retrieve(42L);
    assertNull(actualResolveSandBoxResult);
  }

  /**
   * Test {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest, Site)} with {@code
   * HttpServletRequest}, {@code Site}.
   *
   * <ul>
   *   <li>Then return {@link SandBoxImpl} (default constructor).
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
  public void testResolveSandBoxWithHttpServletRequestSite_thenReturnSandBoxImpl() {
    // Arrange
    when(crossAppAuthService.hasCsrPermission()).thenReturn(false);
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(true);
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    when(sandBoxDao.retrieve(Mockito.<Long>any())).thenReturn(sandBoxImpl);

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(BroadleafSandBoxResolver.SANDBOX_ID_VAR, "42");

    // Act
    SandBox actualResolveSandBoxResult =
        broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl());

    // Assert
    verify(crossAppAuthService).hasCsrPermission();
    verify(crossAppAuthService).isAuthedFromAdmin();
    verify(sandBoxDao).retrieve(42L);
    assertSame(sandBoxImpl, actualResolveSandBoxResult);
  }

  /**
   * Test {@link BroadleafSandBoxResolverImpl#resolveSandBox(HttpServletRequest, Site)} with {@code
   * HttpServletRequest}, {@code Site}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
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
  public void testResolveSandBoxWithHttpServletRequestSite_whenMockHttpServletRequest() {
    // Arrange
    when(crossAppAuthService.hasCsrPermission()).thenReturn(false);
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(true);
    MockHttpServletRequest request = new MockHttpServletRequest();

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
    BroadleafSandBoxResolverImpl broadleafSandBoxResolverImpl = new BroadleafSandBoxResolverImpl();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(
        BroadleafSandBoxResolver.SANDBOX_ID_VAR,
        BroadleafIncludeMyChangesResolver.INCLUDE_MY_CHANGES_VAR);
    request.addParameter(
        BroadleafIncludeMyChangesResolver.INCLUDE_MY_CHANGES_VAR,
        BroadleafSandBoxResolver.SANDBOX_ID_VAR);
    request.addParameter(BroadleafSandBoxResolver.SANDBOX_ID_VAR, "42");
    ServletWebRequest request2 = new ServletWebRequest(request);

    // Act
    SandBox actualResolveSandBoxResult =
        broadleafSandBoxResolverImpl.resolveSandBox(request2, new SiteImpl());

    // Assert
    Object sessionMutex = request2.getSessionMutex();
    assertTrue(sessionMutex instanceof MockHttpSession);
    assertNull(actualResolveSandBoxResult);
    assertArrayEquals(
        new String[] {BroadleafIncludeMyChangesResolver.INCLUDE_MY_CHANGES_VAR},
        ((MockHttpSession) sessionMutex).getValueNames());
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
    when(crossAppAuthService.isAuthedFromAdmin()).thenThrow(new NumberFormatException());
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl()));
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
  public void testResolveSandBoxWithWebRequestSite3() {
    // Arrange
    when(crossAppAuthService.hasCsrPermission()).thenThrow(new NumberFormatException());
    when(crossAppAuthService.isAuthedFromAdmin()).thenReturn(true);
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl()));
    verify(crossAppAuthService).hasCsrPermission();
    verify(crossAppAuthService).isAuthedFromAdmin();
  }

  /**
   * Test {@link BroadleafSandBoxResolverImpl#resolveSandBox(WebRequest, Site)} with {@code
   * WebRequest}, {@code Site}.
   *
   * <ul>
   *   <li>Given {@code blClearSandBox}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafSandBoxResolverImpl#resolveSandBox(WebRequest, Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SandBox BroadleafSandBoxResolverImpl.resolveSandBox(WebRequest, Site)"})
  public void testResolveSandBoxWithWebRequestSite_givenBlClearSandBox() {
    // Arrange
    BroadleafSandBoxResolverImpl broadleafSandBoxResolverImpl = new BroadleafSandBoxResolverImpl();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(
        "blClearSandBox", BroadleafIncludeMyChangesResolver.INCLUDE_MY_CHANGES_VAR);
    request.addParameter(
        BroadleafIncludeMyChangesResolver.INCLUDE_MY_CHANGES_VAR,
        BroadleafSandBoxResolver.SANDBOX_ID_VAR);
    request.addParameter(BroadleafSandBoxResolver.SANDBOX_ID_VAR, "42");
    ServletWebRequest request2 = new ServletWebRequest(request);

    // Act
    SandBox actualResolveSandBoxResult =
        broadleafSandBoxResolverImpl.resolveSandBox(request2, new SiteImpl());

    // Assert
    Object sessionMutex = request2.getSessionMutex();
    assertTrue(sessionMutex instanceof MockHttpSession);
    assertNull(actualResolveSandBoxResult);
    assertEquals(0, ((MockHttpSession) sessionMutex).getValueNames().length);
  }

  /**
   * Test {@link BroadleafSandBoxResolverImpl#resolveSandBox(WebRequest, Site)} with {@code
   * WebRequest}, {@code Site}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then calls {@link WebRequest#getAttribute(String, int)}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafSandBoxResolverImpl#resolveSandBox(WebRequest, Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SandBox BroadleafSandBoxResolverImpl.resolveSandBox(WebRequest, Site)"})
  public void testResolveSandBoxWithWebRequestSite_givenFalse_thenCallsGetAttribute() {
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
   * Test {@link BroadleafSandBoxResolverImpl#resolveSandBox(WebRequest, Site)} with {@code
   * WebRequest}, {@code Site}.
   *
   * <ul>
   *   <li>Then array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafSandBoxResolverImpl#resolveSandBox(WebRequest, Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SandBox BroadleafSandBoxResolverImpl.resolveSandBox(WebRequest, Site)"})
  public void testResolveSandBoxWithWebRequestSite_thenArrayLengthIsZero() {
    // Arrange
    BroadleafSandBoxResolverImpl broadleafSandBoxResolverImpl = new BroadleafSandBoxResolverImpl();
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act
    SandBox actualResolveSandBoxResult =
        broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl());

    // Assert
    Object sessionMutex = request.getSessionMutex();
    assertTrue(sessionMutex instanceof MockHttpSession);
    assertNull(actualResolveSandBoxResult);
    assertEquals(0, ((MockHttpSession) sessionMutex).getValueNames().length);
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
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act
    SandBox actualResolveSandBoxResult =
        broadleafSandBoxResolverImpl.resolveSandBox(request, new SiteImpl());

    // Assert
    verify(crossAppAuthService).hasCsrPermission();
    verify(crossAppAuthService).isAuthedFromAdmin();
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

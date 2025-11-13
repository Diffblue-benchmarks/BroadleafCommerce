package org.broadleafcommerce.common.web;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
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
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.locale.service.LocaleService;
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
public class BroadleafLocaleResolverImplDiffblueTest {
  @InjectMocks private BroadleafLocaleResolverImpl broadleafLocaleResolverImpl;

  @Mock private LocaleService localeService;

  /**
   * Test {@link BroadleafLocaleResolverImpl#resolveLocale(HttpServletRequest)} with {@code
   * HttpServletRequest}.
   *
   * <ul>
   *   <li>Then return {@link LocaleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BroadleafLocaleResolverImpl#resolveLocale(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Locale BroadleafLocaleResolverImpl.resolveLocale(HttpServletRequest)"})
  public void testResolveLocaleWithHttpServletRequest_thenReturnLocaleImpl() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    when(localeService.findDefaultLocale()).thenReturn(localeImpl);

    // Act
    Locale actualResolveLocaleResult =
        broadleafLocaleResolverImpl.resolveLocale(new MockHttpServletRequest());

    // Assert
    verify(localeService).findDefaultLocale();
    assertSame(localeImpl, actualResolveLocaleResult);
  }

  /**
   * Test {@link BroadleafLocaleResolverImpl#resolveLocale(HttpServletRequest)} with {@code
   * HttpServletRequest}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafLocaleResolverImpl#resolveLocale(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Locale BroadleafLocaleResolverImpl.resolveLocale(HttpServletRequest)"})
  public void testResolveLocaleWithHttpServletRequest_thenReturnNull() {
    // Arrange
    when(localeService.findDefaultLocale()).thenReturn(null);

    // Act
    Locale actualResolveLocaleResult =
        broadleafLocaleResolverImpl.resolveLocale(new MockHttpServletRequest());

    // Assert
    verify(localeService).findDefaultLocale();
    assertNull(actualResolveLocaleResult);
  }

  /**
   * Test {@link BroadleafLocaleResolverImpl#resolveLocale(WebRequest)} with {@code WebRequest}.
   *
   * <p>Method under test: {@link BroadleafLocaleResolverImpl#resolveLocale(WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Locale BroadleafLocaleResolverImpl.resolveLocale(WebRequest)"})
  public void testResolveLocaleWithWebRequest() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    when(localeService.findDefaultLocale()).thenReturn(localeImpl);
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act
    Locale actualResolveLocaleResult = broadleafLocaleResolverImpl.resolveLocale(request);

    // Assert
    verify(localeService).findDefaultLocale();
    Object sessionMutex = request.getSessionMutex();
    assertTrue(sessionMutex instanceof MockHttpSession);
    assertSame(localeImpl, actualResolveLocaleResult);
    assertArrayEquals(new String[] {"blLocale"}, ((MockHttpSession) sessionMutex).getValueNames());
  }

  /**
   * Test {@link BroadleafLocaleResolverImpl#resolveLocale(WebRequest)} with {@code WebRequest}.
   *
   * <ul>
   *   <li>Then calls {@link LocaleService#findLocaleByCode(String)}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafLocaleResolverImpl#resolveLocale(WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Locale BroadleafLocaleResolverImpl.resolveLocale(WebRequest)"})
  public void testResolveLocaleWithWebRequest_thenCallsFindLocaleByCode() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(localeImpl);

    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(null);
    when(request.getHeader(Mockito.<String>any())).thenReturn("Header");
    doNothing().when(request).removeAttribute(Mockito.<String>any(), anyInt());
    doNothing().when(request).setAttribute(Mockito.<String>any(), Mockito.<Object>any(), anyInt());

    // Act
    Locale actualResolveLocaleResult = broadleafLocaleResolverImpl.resolveLocale(request);

    // Assert
    verify(localeService).findLocaleByCode("Header");
    verify(request, atLeast(1)).getAttribute(Mockito.<String>any(), eq(0));
    verify(request).removeAttribute("blCurrency", 1);
    verify(request, atLeast(1))
        .setAttribute(Mockito.<String>any(), Mockito.<Object>any(), anyInt());
    verify(request, atLeast(1)).getHeader("blLocaleCode");
    assertSame(localeImpl, actualResolveLocaleResult);
  }

  /**
   * Test {@link BroadleafLocaleResolverImpl#resolveLocale(WebRequest)} with {@code WebRequest}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafLocaleResolverImpl#resolveLocale(WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Locale BroadleafLocaleResolverImpl.resolveLocale(WebRequest)"})
  public void testResolveLocaleWithWebRequest_thenReturnNull() {
    // Arrange
    when(localeService.findDefaultLocale()).thenReturn(null);
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act
    Locale actualResolveLocaleResult = broadleafLocaleResolverImpl.resolveLocale(request);

    // Assert
    verify(localeService).findDefaultLocale();
    Object sessionMutex = request.getSessionMutex();
    assertTrue(sessionMutex instanceof MockHttpSession);
    assertNull(actualResolveLocaleResult);
    assertEquals(0, ((MockHttpSession) sessionMutex).getValueNames().length);
  }
}

package org.broadleafcommerce.common.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.TimeZone;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.RequestDTO;
import org.broadleafcommerce.common.RequestDTOImpl;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.sandbox.domain.SandBox;
import org.broadleafcommerce.common.sandbox.domain.SandBoxImpl;
import org.broadleafcommerce.common.site.domain.Catalog;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.Site;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.common.site.domain.Theme;
import org.broadleafcommerce.common.site.domain.ThemeDTO;
import org.broadleafcommerce.common.util.BroadleafMergeResourceBundleMessageSource;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.context.MessageSource;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

public class BroadleafRequestContextDiffblueTest {
  /**
   * Test {@link BroadleafRequestContext#hasLocale()}.
   *
   * <p>Method under test: {@link BroadleafRequestContext#hasLocale()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafRequestContext.hasLocale()"})
  public void testHasLocale() {
    // Arrange, Act and Assert
    assertFalse(BroadleafRequestContext.hasLocale());
  }

  /**
   * Test {@link BroadleafRequestContext#getRequestAttribute(String)}.
   *
   * <ul>
   *   <li>Given BroadleafRequestContext is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRequestContext#getRequestAttribute(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object BroadleafRequestContext.getRequestAttribute(String)"})
  public void testGetRequestAttribute_givenBroadleafRequestContextIsTrue() {
    // Arrange
    BroadleafRequestContext broadleafRequestContext =
        BroadleafRequestContext.getBroadleafRequestContext(true);

    // Act and Assert
    assertNull(broadleafRequestContext.getRequestAttribute("Name"));
  }

  /**
   * Test {@link BroadleafRequestContext#setRequest(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then {@link BroadleafRequestContext} (default constructor) WebRequest SessionMutex {@link
   *       MockHttpSession}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRequestContext#setRequest(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafRequestContext.setRequest(HttpServletRequest)"})
  public void testSetRequest_thenBroadleafRequestContextWebRequestSessionMutexMockHttpSession() {
    // Arrange
    BroadleafRequestContext broadleafRequestContext = new BroadleafRequestContext();
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act
    broadleafRequestContext.setRequest(request);

    // Assert
    WebRequest webRequest = broadleafRequestContext.getWebRequest();
    assertTrue(webRequest.getSessionMutex() instanceof MockHttpSession);
    assertTrue(webRequest instanceof ServletWebRequest);
    assertEquals("", broadleafRequestContext.getRequestURIWithoutContext());
    assertEquals("", webRequest.getContextPath());
    assertNull(((ServletWebRequest) webRequest).getNativeResponse());
    assertNull(webRequest.getRemoteUser());
    assertNull(webRequest.getUserPrincipal());
    assertNull(((ServletWebRequest) webRequest).getResponse());
    assertNull(((ServletWebRequest) webRequest).getHttpMethod());
    assertFalse(webRequest.getHeaderNames().hasNext());
    assertFalse(webRequest.getParameterNames().hasNext());
    assertFalse(((ServletWebRequest) webRequest).isNotModified());
    assertFalse(webRequest.isSecure());
    assertTrue(webRequest.getParameterMap().isEmpty());
    assertSame(request, broadleafRequestContext.getRequest());
    assertSame(request, ((ServletWebRequest) webRequest).getRequest());
    assertSame(request, ((ServletWebRequest) webRequest).getNativeRequest());
  }

  /**
   * Test {@link BroadleafRequestContext#setWebRequest(WebRequest)}.
   *
   * <p>Method under test: {@link BroadleafRequestContext#setWebRequest(WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafRequestContext.setWebRequest(WebRequest)"})
  public void testSetWebRequest() {
    // Arrange
    BroadleafRequestContext broadleafRequestContext = new BroadleafRequestContext();
    MockHttpServletRequest request = new MockHttpServletRequest();
    ServletWebRequest webRequest = new ServletWebRequest(request);

    // Act
    broadleafRequestContext.setWebRequest(webRequest);

    // Assert
    assertEquals("", broadleafRequestContext.getRequestURIWithoutContext());
    assertSame(request, broadleafRequestContext.getRequest());
    assertSame(webRequest, broadleafRequestContext.getWebRequest());
  }

  /**
   * Test {@link BroadleafRequestContext#setWebRequest(WebRequest)}.
   *
   * <ul>
   *   <li>Then {@link BroadleafRequestContext} (default constructor) RequestURIWithoutContext is
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRequestContext#setWebRequest(WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafRequestContext.setWebRequest(WebRequest)"})
  public void testSetWebRequest_thenBroadleafRequestContextRequestURIWithoutContextIsNull() {
    // Arrange
    BroadleafRequestContext broadleafRequestContext = new BroadleafRequestContext();

    // Act
    broadleafRequestContext.setWebRequest(null);

    // Assert that nothing has changed
    assertNull(broadleafRequestContext.getRequestURIWithoutContext());
    assertNull(broadleafRequestContext.getRequest());
    assertNull(broadleafRequestContext.getWebRequest());
  }

  /**
   * Test {@link BroadleafRequestContext#getSite()}.
   *
   * <p>Method under test: {@link BroadleafRequestContext#getSite()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site BroadleafRequestContext.getSite()"})
  public void testGetSite() {
    // Arrange, Act and Assert
    assertNull(new BroadleafRequestContext().getSite());
  }

  /**
   * Test {@link BroadleafRequestContext#setSite(Site)}.
   *
   * <p>Method under test: {@link BroadleafRequestContext#setSite(Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafRequestContext.setSite(Site)"})
  public void testSetSite() {
    // Arrange
    BroadleafRequestContext broadleafRequestContext = new BroadleafRequestContext();
    SiteImpl site = new SiteImpl();

    // Act
    broadleafRequestContext.setSite(site);

    // Assert
    assertSame(site, broadleafRequestContext.getNonPersistentSite());
    assertSame(site, broadleafRequestContext.getSite());
  }

  /**
   * Test {@link BroadleafRequestContext#getSandBoxId()}.
   *
   * <ul>
   *   <li>Given {@link BroadleafRequestContext} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRequestContext#getSandBoxId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long BroadleafRequestContext.getSandBoxId()"})
  public void testGetSandBoxId_givenBroadleafRequestContext() {
    // Arrange, Act and Assert
    assertNull(new BroadleafRequestContext().getSandBoxId());
  }

  /**
   * Test {@link BroadleafRequestContext#getSandBoxId()}.
   *
   * <ul>
   *   <li>Given BroadleafRequestContext is {@code true} SandBox is {@link SandBoxImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRequestContext#getSandBoxId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long BroadleafRequestContext.getSandBoxId()"})
  public void testGetSandBoxId_givenBroadleafRequestContextIsTrueSandBoxIsSandBoxImpl() {
    // Arrange
    BroadleafRequestContext broadleafRequestContext =
        BroadleafRequestContext.getBroadleafRequestContext(true);
    broadleafRequestContext.setSandBox(new SandBoxImpl());

    // Act and Assert
    assertNull(broadleafRequestContext.getSandBoxId());
  }

  /**
   * Test {@link BroadleafRequestContext#isProductionSandBox()}.
   *
   * <ul>
   *   <li>Given {@link BroadleafRequestContext} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRequestContext#isProductionSandBox()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafRequestContext.isProductionSandBox()"})
  public void testIsProductionSandBox_givenBroadleafRequestContext_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new BroadleafRequestContext().isProductionSandBox());
  }

  /**
   * Test {@link BroadleafRequestContext#isProductionSandBox()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRequestContext#isProductionSandBox()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafRequestContext.isProductionSandBox()"})
  public void testIsProductionSandBox_thenReturnFalse() {
    // Arrange
    BroadleafRequestContext broadleafRequestContext =
        BroadleafRequestContext.getBroadleafRequestContext(true);
    broadleafRequestContext.setSandBox(new SandBoxImpl());

    // Act and Assert
    assertFalse(broadleafRequestContext.isProductionSandBox());
  }

  /**
   * Test {@link BroadleafRequestContext#getJavaLocale()}.
   *
   * <ul>
   *   <li>Given {@link BroadleafRequestContext} (default constructor).
   *   <li>Then return {@link java.util.Locale#ENGLISH}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRequestContext#getJavaLocale()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Locale BroadleafRequestContext.getJavaLocale()"})
  public void testGetJavaLocale_givenBroadleafRequestContext_thenReturnEnglish() {
    // Arrange, Act and Assert
    assertSame(java.util.Locale.ENGLISH, new BroadleafRequestContext().getJavaLocale());
  }

  /**
   * Test {@link BroadleafRequestContext#setLocale(Locale)}.
   *
   * <ul>
   *   <li>Given Default.
   *   <li>Then {@link BroadleafRequestContext} (default constructor) JavaLocale is {@link
   *       java.util.Locale#ENGLISH}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRequestContext#setLocale(Locale)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafRequestContext.setLocale(Locale)"})
  public void testSetLocale_givenDefault_thenBroadleafRequestContextJavaLocaleIsEnglish()
      throws MissingResourceException {
    // Arrange
    BroadleafRequestContext broadleafRequestContext = new BroadleafRequestContext();

    Locale locale = mock(Locale.class);
    when(locale.getJavaLocale()).thenReturn(java.util.Locale.getDefault());
    when(locale.getLocaleCode()).thenReturn("en");

    // Act
    broadleafRequestContext.setLocale(locale);

    // Assert
    verify(locale).getJavaLocale();
    verify(locale).getLocaleCode();
    java.util.Locale locale2 = broadleafRequestContext.javaLocale;
    assertEquals("", locale2.getCountry());
    assertEquals("", locale2.getDisplayCountry());
    assertEquals("", locale2.getDisplayScript());
    assertEquals("", locale2.getDisplayVariant());
    assertEquals("", locale2.getISO3Country());
    assertEquals("", locale2.getScript());
    assertEquals("", locale2.getVariant());
    assertEquals("English", locale2.getDisplayLanguage());
    assertEquals("English", locale2.getDisplayName());
    assertEquals("en", locale2.getLanguage());
    assertEquals("eng", locale2.getISO3Language());
    assertFalse(locale2.hasExtensions());
    assertSame(java.util.Locale.ENGLISH, broadleafRequestContext.getJavaLocale());
    assertSame(locale, broadleafRequestContext.getLocale());
  }

  /**
   * Test {@link BroadleafRequestContext#setLocale(Locale)}.
   *
   * <ul>
   *   <li>When {@link Locale} {@link Locale#getJavaLocale()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRequestContext#setLocale(Locale)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafRequestContext.setLocale(Locale)"})
  public void testSetLocale_whenLocaleGetJavaLocaleThrowIllegalArgumentException() {
    // Arrange
    BroadleafRequestContext broadleafRequestContext = new BroadleafRequestContext();

    Locale locale = mock(Locale.class);
    when(locale.getJavaLocale()).thenThrow(new IllegalArgumentException());
    when(locale.getLocaleCode()).thenReturn("en");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> broadleafRequestContext.setLocale(locale));
    verify(locale).getJavaLocale();
    verify(locale).getLocaleCode();
  }

  /**
   * Test {@link BroadleafRequestContext#setLocale(Locale)}.
   *
   * <ul>
   *   <li>When {@link Locale} {@link Locale#getLocaleCode()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRequestContext#setLocale(Locale)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafRequestContext.setLocale(Locale)"})
  public void testSetLocale_whenLocaleGetLocaleCodeThrowIllegalArgumentException() {
    // Arrange
    BroadleafRequestContext broadleafRequestContext = new BroadleafRequestContext();

    Locale locale = mock(Locale.class);
    when(locale.getLocaleCode()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> broadleafRequestContext.setLocale(locale));
    verify(locale).getLocaleCode();
  }

  /**
   * Test {@link BroadleafRequestContext#setLocale(Locale)}.
   *
   * <ul>
   *   <li>When {@link LocaleImpl} (default constructor).
   *   <li>Then {@link BroadleafRequestContext} (default constructor) Locale is {@link LocaleImpl}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRequestContext#setLocale(Locale)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafRequestContext.setLocale(Locale)"})
  public void testSetLocale_whenLocaleImpl_thenBroadleafRequestContextLocaleIsLocaleImpl()
      throws MissingResourceException {
    // Arrange
    BroadleafRequestContext broadleafRequestContext = new BroadleafRequestContext();
    LocaleImpl locale = new LocaleImpl();

    // Act
    broadleafRequestContext.setLocale(locale);

    // Assert
    java.util.Locale locale2 = broadleafRequestContext.javaLocale;
    assertEquals("", locale2.getCountry());
    assertEquals("", locale2.getDisplayCountry());
    assertEquals("", locale2.getDisplayScript());
    assertEquals("", locale2.getDisplayVariant());
    assertEquals("", locale2.getISO3Country());
    assertEquals("", locale2.getScript());
    assertEquals("", locale2.getVariant());
    assertEquals("English", locale2.getDisplayLanguage());
    assertEquals("English", locale2.getDisplayName());
    assertEquals("en", locale2.getLanguage());
    assertEquals("eng", locale2.getISO3Language());
    assertFalse(locale2.hasExtensions());
    assertSame(locale, broadleafRequestContext.getLocale());
    java.util.Locale expectedJavaLocale = broadleafRequestContext.javaLocale;
    assertSame(expectedJavaLocale, broadleafRequestContext.getJavaLocale());
  }

  /**
   * Test {@link BroadleafRequestContext#setLocale(Locale)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link BroadleafRequestContext} (default constructor) Locale is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRequestContext#setLocale(Locale)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafRequestContext.setLocale(Locale)"})
  public void testSetLocale_whenNull_thenBroadleafRequestContextLocaleIsNull()
      throws MissingResourceException {
    // Arrange
    BroadleafRequestContext broadleafRequestContext = new BroadleafRequestContext();

    // Act
    broadleafRequestContext.setLocale(null);

    // Assert
    java.util.Locale locale = broadleafRequestContext.javaLocale;
    assertEquals("", locale.getCountry());
    assertEquals("", locale.getDisplayCountry());
    assertEquals("", locale.getDisplayScript());
    assertEquals("", locale.getDisplayVariant());
    assertEquals("", locale.getISO3Country());
    assertEquals("", locale.getScript());
    assertEquals("", locale.getVariant());
    assertEquals("English", locale.getDisplayLanguage());
    assertEquals("English", locale.getDisplayName());
    assertEquals("en", locale.getLanguage());
    assertEquals("eng", locale.getISO3Language());
    assertNull(broadleafRequestContext.getLocale());
    assertFalse(locale.hasExtensions());
    java.util.Locale expectedJavaLocale = broadleafRequestContext.javaLocale;
    assertSame(expectedJavaLocale, broadleafRequestContext.getJavaLocale());
  }

  /**
   * Test {@link BroadleafRequestContext#getRequestURIWithoutContext()}.
   *
   * <p>Method under test: {@link BroadleafRequestContext#getRequestURIWithoutContext()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafRequestContext.getRequestURIWithoutContext()"})
  public void testGetRequestURIWithoutContext() {
    // Arrange, Act and Assert
    assertNull(new BroadleafRequestContext().getRequestURIWithoutContext());
  }

  /**
   * Test {@link BroadleafRequestContext#convertLocaleToJavaLocale()}.
   *
   * <p>Method under test: {@link BroadleafRequestContext#convertLocaleToJavaLocale()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Locale BroadleafRequestContext.convertLocaleToJavaLocale()"})
  public void testConvertLocaleToJavaLocale() {
    // Arrange
    BroadleafRequestContext broadleafRequestContext = new BroadleafRequestContext();

    // Act and Assert
    java.util.Locale locale = java.util.Locale.ENGLISH;
    assertSame(locale, broadleafRequestContext.convertLocaleToJavaLocale());
    assertSame(locale, broadleafRequestContext.getJavaLocale());
    assertSame(locale, broadleafRequestContext.javaLocale);
  }

  /**
   * Test {@link BroadleafRequestContext#convertLocaleToJavaLocale(Locale)} with {@code Locale}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRequestContext#convertLocaleToJavaLocale(Locale)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Locale BroadleafRequestContext.convertLocaleToJavaLocale(Locale)"})
  public void testConvertLocaleToJavaLocaleWithLocale_thenThrowIllegalArgumentException() {
    // Arrange
    Locale broadleafLocale = mock(Locale.class);
    when(broadleafLocale.getJavaLocale()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> BroadleafRequestContext.convertLocaleToJavaLocale(broadleafLocale));
    verify(broadleafLocale).getJavaLocale();
  }

  /**
   * Test {@link BroadleafRequestContext#convertLocaleToJavaLocale(Locale)} with {@code Locale}.
   *
   * <ul>
   *   <li>When {@link LocaleImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRequestContext#convertLocaleToJavaLocale(Locale)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Locale BroadleafRequestContext.convertLocaleToJavaLocale(Locale)"})
  public void testConvertLocaleToJavaLocaleWithLocale_whenLocaleImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BroadleafRequestContext.convertLocaleToJavaLocale(new LocaleImpl()));
  }

  /**
   * Test {@link BroadleafRequestContext#convertLocaleToJavaLocale(Locale)} with {@code Locale}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRequestContext#convertLocaleToJavaLocale(Locale)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Locale BroadleafRequestContext.convertLocaleToJavaLocale(Locale)"})
  public void testConvertLocaleToJavaLocaleWithLocale_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BroadleafRequestContext.convertLocaleToJavaLocale(null));
  }

  /**
   * Test {@link BroadleafRequestContext#isSecure()}.
   *
   * <p>Method under test: {@link BroadleafRequestContext#isSecure()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafRequestContext.isSecure()"})
  public void testIsSecure() {
    // Arrange, Act and Assert
    assertFalse(new BroadleafRequestContext().isSecure());
  }

  /**
   * Test {@link BroadleafRequestContext#getExplicitCatalogs()}.
   *
   * <ul>
   *   <li>Given {@link BroadleafRequestContext} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRequestContext#getExplicitCatalogs()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BroadleafRequestContext.getExplicitCatalogs()"})
  public void testGetExplicitCatalogs_givenBroadleafRequestContext() {
    // Arrange, Act and Assert
    assertTrue(new BroadleafRequestContext().getExplicitCatalogs().isEmpty());
  }

  /**
   * Test {@link BroadleafRequestContext#getExplicitCatalogs()}.
   *
   * <ul>
   *   <li>Given BroadleafRequestContext is {@code true} ExplicitCatalogs is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRequestContext#getExplicitCatalogs()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BroadleafRequestContext.getExplicitCatalogs()"})
  public void testGetExplicitCatalogs_givenBroadleafRequestContextIsTrueExplicitCatalogsIsNull() {
    // Arrange
    BroadleafRequestContext broadleafRequestContext =
        BroadleafRequestContext.getBroadleafRequestContext(true);
    broadleafRequestContext.setExplicitCatalogs(null);

    // Act and Assert
    assertTrue(broadleafRequestContext.getExplicitCatalogs().isEmpty());
  }

  /**
   * Test {@link BroadleafRequestContext#getIgnoreSite()}.
   *
   * <ul>
   *   <li>Given BroadleafRequestContext is {@code true} IgnoreSite is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRequestContext#getIgnoreSite()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean BroadleafRequestContext.getIgnoreSite()"})
  public void testGetIgnoreSite_givenBroadleafRequestContextIsTrueIgnoreSiteIsNull() {
    // Arrange
    BroadleafRequestContext broadleafRequestContext =
        BroadleafRequestContext.getBroadleafRequestContext(true);
    broadleafRequestContext.setIgnoreSite(null);

    // Act and Assert
    assertFalse(broadleafRequestContext.getIgnoreSite());
  }

  /**
   * Test {@link BroadleafRequestContext#getIgnoreSite()}.
   *
   * <ul>
   *   <li>Given {@link BroadleafRequestContext} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRequestContext#getIgnoreSite()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean BroadleafRequestContext.getIgnoreSite()"})
  public void testGetIgnoreSite_givenBroadleafRequestContext_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new BroadleafRequestContext().getIgnoreSite());
  }

  /**
   * Test {@link BroadleafRequestContext#getIgnoreSite()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRequestContext#getIgnoreSite()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean BroadleafRequestContext.getIgnoreSite()"})
  public void testGetIgnoreSite_thenReturnTrue() {
    // Arrange
    BroadleafRequestContext broadleafRequestContext =
        BroadleafRequestContext.getBroadleafRequestContext(true);
    broadleafRequestContext.setIgnoreSite(true);

    // Act and Assert
    assertTrue(broadleafRequestContext.getIgnoreSite());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BroadleafRequestContext#setAdditionalProperties(Map)}
   *   <li>{@link BroadleafRequestContext#setAdmin(Boolean)}
   *   <li>{@link BroadleafRequestContext#setAdminUserId(Long)}
   *   <li>{@link BroadleafRequestContext#setBroadleafCurrency(BroadleafCurrency)}
   *   <li>{@link BroadleafRequestContext#setCurrentCatalog(Catalog)}
   *   <li>{@link BroadleafRequestContext#setCurrentProfile(Site)}
   *   <li>{@link BroadleafRequestContext#setDeployBehavior(DeployBehavior)}
   *   <li>{@link BroadleafRequestContext#setDeployState(DeployState)}
   *   <li>{@link
   *       BroadleafRequestContext#setEnforceEnterpriseCollectionBehaviorState(EnforceEnterpriseCollectionBehaviorState)}
   *   <li>{@link BroadleafRequestContext#setExplicitCatalogs(List)}
   *   <li>{@link BroadleafRequestContext#setIgnoreSite(Boolean)}
   *   <li>{@link BroadleafRequestContext#setInternalIgnoreFilters(Boolean)}
   *   <li>{@link BroadleafRequestContext#setInternalValidateFind(Boolean)}
   *   <li>{@link BroadleafRequestContext#setMessageSource(MessageSource)}
   *   <li>{@link BroadleafRequestContext#setNonPersistentSite(Site)}
   *   <li>{@link BroadleafRequestContext#setRequestDTO(RequestDTO)}
   *   <li>{@link BroadleafRequestContext#setRequestedBroadleafCurrency(BroadleafCurrency)}
   *   <li>{@link BroadleafRequestContext#setResponse(HttpServletResponse)}
   *   <li>{@link BroadleafRequestContext#setSandBox(SandBox)}
   *   <li>{@link BroadleafRequestContext#setTheme(Theme)}
   *   <li>{@link BroadleafRequestContext#setTimeZone(TimeZone)}
   *   <li>{@link
   *       BroadleafRequestContext#setValidateProductionChangesState(ValidateProductionChangesState)}
   *   <li>{@link BroadleafRequestContext#getAdditionalProperties()}
   *   <li>{@link BroadleafRequestContext#getAdminUserId()}
   *   <li>{@link BroadleafRequestContext#getBroadleafCurrency()}
   *   <li>{@link BroadleafRequestContext#getCurrentCatalog()}
   *   <li>{@link BroadleafRequestContext#getCurrentProfile()}
   *   <li>{@link BroadleafRequestContext#getDeployBehavior()}
   *   <li>{@link BroadleafRequestContext#getDeployState()}
   *   <li>{@link BroadleafRequestContext#getEnforceEnterpriseCollectionBehaviorState()}
   *   <li>{@link BroadleafRequestContext#getInternalIgnoreFilters()}
   *   <li>{@link BroadleafRequestContext#getInternalValidateFind()}
   *   <li>{@link BroadleafRequestContext#getLocale()}
   *   <li>{@link BroadleafRequestContext#getMessageSource()}
   *   <li>{@link BroadleafRequestContext#getNonPersistentSite()}
   *   <li>{@link BroadleafRequestContext#getRequest()}
   *   <li>{@link BroadleafRequestContext#getRequestDTO()}
   *   <li>{@link BroadleafRequestContext#getRequestedBroadleafCurrency()}
   *   <li>{@link BroadleafRequestContext#getResponse()}
   *   <li>{@link BroadleafRequestContext#getSandBox()}
   *   <li>{@link BroadleafRequestContext#getTheme()}
   *   <li>{@link BroadleafRequestContext#getTimeZone()}
   *   <li>{@link BroadleafRequestContext#getValidateProductionChangesState()}
   *   <li>{@link BroadleafRequestContext#getWebRequest()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map BroadleafRequestContext.getAdditionalProperties()",
    "Long BroadleafRequestContext.getAdminUserId()",
    "BroadleafCurrency BroadleafRequestContext.getBroadleafCurrency()",
    "Catalog BroadleafRequestContext.getCurrentCatalog()",
    "Site BroadleafRequestContext.getCurrentProfile()",
    "DeployBehavior BroadleafRequestContext.getDeployBehavior()",
    "DeployState BroadleafRequestContext.getDeployState()",
    "EnforceEnterpriseCollectionBehaviorState BroadleafRequestContext.getEnforceEnterpriseCollectionBehaviorState()",
    "Boolean BroadleafRequestContext.getInternalIgnoreFilters()",
    "Boolean BroadleafRequestContext.getInternalValidateFind()",
    "Locale BroadleafRequestContext.getLocale()",
    "MessageSource BroadleafRequestContext.getMessageSource()",
    "Site BroadleafRequestContext.getNonPersistentSite()",
    "HttpServletRequest BroadleafRequestContext.getRequest()",
    "RequestDTO BroadleafRequestContext.getRequestDTO()",
    "BroadleafCurrency BroadleafRequestContext.getRequestedBroadleafCurrency()",
    "HttpServletResponse BroadleafRequestContext.getResponse()",
    "SandBox BroadleafRequestContext.getSandBox()",
    "Theme BroadleafRequestContext.getTheme()",
    "TimeZone BroadleafRequestContext.getTimeZone()",
    "ValidateProductionChangesState BroadleafRequestContext.getValidateProductionChangesState()",
    "WebRequest BroadleafRequestContext.getWebRequest()",
    "void BroadleafRequestContext.setAdditionalProperties(Map)",
    "void BroadleafRequestContext.setAdmin(Boolean)",
    "void BroadleafRequestContext.setAdminUserId(Long)",
    "void BroadleafRequestContext.setBroadleafCurrency(BroadleafCurrency)",
    "void BroadleafRequestContext.setCurrentCatalog(Catalog)",
    "void BroadleafRequestContext.setCurrentProfile(Site)",
    "void BroadleafRequestContext.setDeployBehavior(DeployBehavior)",
    "void BroadleafRequestContext.setDeployState(DeployState)",
    "void BroadleafRequestContext.setEnforceEnterpriseCollectionBehaviorState(EnforceEnterpriseCollectionBehaviorState)",
    "void BroadleafRequestContext.setExplicitCatalogs(List)",
    "void BroadleafRequestContext.setIgnoreSite(Boolean)",
    "void BroadleafRequestContext.setInternalIgnoreFilters(Boolean)",
    "void BroadleafRequestContext.setInternalValidateFind(Boolean)",
    "void BroadleafRequestContext.setMessageSource(MessageSource)",
    "void BroadleafRequestContext.setNonPersistentSite(Site)",
    "void BroadleafRequestContext.setRequestDTO(RequestDTO)",
    "void BroadleafRequestContext.setRequestedBroadleafCurrency(BroadleafCurrency)",
    "void BroadleafRequestContext.setResponse(HttpServletResponse)",
    "void BroadleafRequestContext.setSandBox(SandBox)",
    "void BroadleafRequestContext.setTheme(Theme)",
    "void BroadleafRequestContext.setTimeZone(TimeZone)",
    "void BroadleafRequestContext.setValidateProductionChangesState(ValidateProductionChangesState)"
  })
  public void testGettersAndSetters() {
    // Arrange
    BroadleafRequestContext broadleafRequestContext = new BroadleafRequestContext();
    HashMap<String, Object> additionalProperties = new HashMap<>();

    // Act
    broadleafRequestContext.setAdditionalProperties(additionalProperties);
    broadleafRequestContext.setAdmin(true);
    broadleafRequestContext.setAdminUserId(1L);
    BroadleafCurrencyImpl broadleafCurrency = new BroadleafCurrencyImpl();
    broadleafRequestContext.setBroadleafCurrency(broadleafCurrency);
    CatalogImpl currentCatalog = new CatalogImpl();
    broadleafRequestContext.setCurrentCatalog(currentCatalog);
    SiteImpl currentProfile = new SiteImpl();
    broadleafRequestContext.setCurrentProfile(currentProfile);
    broadleafRequestContext.setDeployBehavior(DeployBehavior.CLONE_PARENT);
    broadleafRequestContext.setDeployState(DeployState.SANDBOX);
    broadleafRequestContext.setEnforceEnterpriseCollectionBehaviorState(
        EnforceEnterpriseCollectionBehaviorState.TRUE);
    broadleafRequestContext.setExplicitCatalogs(new ArrayList<>());
    broadleafRequestContext.setIgnoreSite(true);
    broadleafRequestContext.setInternalIgnoreFilters(true);
    broadleafRequestContext.setInternalValidateFind(true);
    BroadleafMergeResourceBundleMessageSource messageSource =
        new BroadleafMergeResourceBundleMessageSource();
    broadleafRequestContext.setMessageSource(messageSource);
    SiteImpl site = new SiteImpl();
    broadleafRequestContext.setNonPersistentSite(site);
    RequestDTOImpl requestDTO = new RequestDTOImpl();
    broadleafRequestContext.setRequestDTO(requestDTO);
    BroadleafCurrencyImpl requestedCurrency = new BroadleafCurrencyImpl();
    broadleafRequestContext.setRequestedBroadleafCurrency(requestedCurrency);
    MockHttpServletResponse response = new MockHttpServletResponse();
    broadleafRequestContext.setResponse(response);
    SandBoxImpl sandBox = new SandBoxImpl();
    broadleafRequestContext.setSandBox(sandBox);
    ThemeDTO theme = new ThemeDTO("Name", "Path");
    broadleafRequestContext.setTheme(theme);
    TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");
    broadleafRequestContext.setTimeZone(timeZone);
    broadleafRequestContext.setValidateProductionChangesState(ValidateProductionChangesState.ADMIN);
    Map<String, Object> actualAdditionalProperties =
        broadleafRequestContext.getAdditionalProperties();
    Long actualAdminUserId = broadleafRequestContext.getAdminUserId();
    BroadleafCurrency actualBroadleafCurrency = broadleafRequestContext.getBroadleafCurrency();
    Catalog actualCurrentCatalog = broadleafRequestContext.getCurrentCatalog();
    Site actualCurrentProfile = broadleafRequestContext.getCurrentProfile();
    DeployBehavior actualDeployBehavior = broadleafRequestContext.getDeployBehavior();
    DeployState actualDeployState = broadleafRequestContext.getDeployState();
    EnforceEnterpriseCollectionBehaviorState actualEnforceEnterpriseCollectionBehaviorState =
        broadleafRequestContext.getEnforceEnterpriseCollectionBehaviorState();
    Boolean actualInternalIgnoreFilters = broadleafRequestContext.getInternalIgnoreFilters();
    Boolean actualInternalValidateFind = broadleafRequestContext.getInternalValidateFind();
    Locale actualLocale = broadleafRequestContext.getLocale();
    MessageSource actualMessageSource = broadleafRequestContext.getMessageSource();
    Site actualNonPersistentSite = broadleafRequestContext.getNonPersistentSite();
    HttpServletRequest actualRequest = broadleafRequestContext.getRequest();
    RequestDTO actualRequestDTO = broadleafRequestContext.getRequestDTO();
    BroadleafCurrency actualRequestedBroadleafCurrency =
        broadleafRequestContext.getRequestedBroadleafCurrency();
    HttpServletResponse actualResponse = broadleafRequestContext.getResponse();
    SandBox actualSandBox = broadleafRequestContext.getSandBox();
    Theme actualTheme = broadleafRequestContext.getTheme();
    TimeZone actualTimeZone = broadleafRequestContext.getTimeZone();
    ValidateProductionChangesState actualValidateProductionChangesState =
        broadleafRequestContext.getValidateProductionChangesState();

    // Assert
    assertNull(actualRequest);
    assertNull(actualLocale);
    assertNull(broadleafRequestContext.getWebRequest());
    assertEquals(1L, actualAdminUserId.longValue());
    assertEquals(DeployBehavior.CLONE_PARENT, actualDeployBehavior);
    assertEquals(DeployState.SANDBOX, actualDeployState);
    assertEquals(
        EnforceEnterpriseCollectionBehaviorState.TRUE,
        actualEnforceEnterpriseCollectionBehaviorState);
    assertEquals(ValidateProductionChangesState.ADMIN, actualValidateProductionChangesState);
    assertTrue(actualAdditionalProperties.isEmpty());
    assertTrue(actualInternalIgnoreFilters);
    assertTrue(actualInternalValidateFind);
    assertSame(additionalProperties, actualAdditionalProperties);
    assertSame(requestDTO, actualRequestDTO);
    assertSame(broadleafCurrency, actualBroadleafCurrency);
    assertSame(requestedCurrency, actualRequestedBroadleafCurrency);
    assertSame(sandBox, actualSandBox);
    assertSame(currentCatalog, actualCurrentCatalog);
    assertSame(currentProfile, actualCurrentProfile);
    assertSame(site, actualNonPersistentSite);
    assertSame(theme, actualTheme);
    assertSame(messageSource, actualMessageSource);
    assertSame(response, actualResponse);
    assertSame(timeZone, actualTimeZone);
  }

  /**
   * Test {@link BroadleafRequestContext#getAdmin()}.
   *
   * <ul>
   *   <li>Given BroadleafRequestContext is {@code true} Admin is {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRequestContext#getAdmin()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean BroadleafRequestContext.getAdmin()"})
  public void testGetAdmin_givenBroadleafRequestContextIsTrueAdminIsNull_thenReturnFalse() {
    // Arrange
    BroadleafRequestContext broadleafRequestContext =
        BroadleafRequestContext.getBroadleafRequestContext(true);
    broadleafRequestContext.setAdmin(null);

    // Act and Assert
    assertFalse(broadleafRequestContext.getAdmin());
  }

  /**
   * Test {@link BroadleafRequestContext#getAdmin()}.
   *
   * <ul>
   *   <li>Given BroadleafRequestContext is {@code true} Admin is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRequestContext#getAdmin()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean BroadleafRequestContext.getAdmin()"})
  public void testGetAdmin_givenBroadleafRequestContextIsTrueAdminIsTrue_thenReturnTrue() {
    // Arrange
    BroadleafRequestContext broadleafRequestContext =
        BroadleafRequestContext.getBroadleafRequestContext(true);
    broadleafRequestContext.setAdmin(true);

    // Act and Assert
    assertTrue(broadleafRequestContext.getAdmin());
  }

  /**
   * Test {@link BroadleafRequestContext#getAdmin()}.
   *
   * <ul>
   *   <li>Given {@link BroadleafRequestContext} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRequestContext#getAdmin()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean BroadleafRequestContext.getAdmin()"})
  public void testGetAdmin_givenBroadleafRequestContext_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new BroadleafRequestContext().getAdmin());
  }

  /**
   * Test {@link BroadleafRequestContext#createLightWeightClone()}.
   *
   * <p>Method under test: {@link BroadleafRequestContext#createLightWeightClone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BroadleafRequestContext BroadleafRequestContext.createLightWeightClone()"})
  public void testCreateLightWeightClone() {
    // Arrange
    BroadleafRequestContext broadleafRequestContext = new BroadleafRequestContext();

    // Act
    BroadleafRequestContext actualCreateLightWeightCloneResult =
        broadleafRequestContext.createLightWeightClone();

    // Assert
    assertNull(actualCreateLightWeightCloneResult.getAdminUserId());
    assertNull(actualCreateLightWeightCloneResult.getSandBoxId());
    assertNull(actualCreateLightWeightCloneResult.getRequestURIWithoutContext());
    assertNull(actualCreateLightWeightCloneResult.javaCurrency);
    assertNull(actualCreateLightWeightCloneResult.getTimeZone());
    assertNull(actualCreateLightWeightCloneResult.getRequest());
    assertNull(actualCreateLightWeightCloneResult.getResponse());
    assertNull(actualCreateLightWeightCloneResult.getRequestDTO());
    assertNull(actualCreateLightWeightCloneResult.getBroadleafCurrency());
    assertNull(actualCreateLightWeightCloneResult.getRequestedBroadleafCurrency());
    assertNull(actualCreateLightWeightCloneResult.getLocale());
    assertNull(actualCreateLightWeightCloneResult.getSandBox());
    assertNull(actualCreateLightWeightCloneResult.getCurrentCatalog());
    assertNull(actualCreateLightWeightCloneResult.getCurrentProfile());
    assertNull(actualCreateLightWeightCloneResult.getNonPersistentSite());
    assertNull(actualCreateLightWeightCloneResult.getSite());
    assertNull(actualCreateLightWeightCloneResult.getTheme());
    assertNull(actualCreateLightWeightCloneResult.getMessageSource());
    assertNull(actualCreateLightWeightCloneResult.getWebRequest());
    assertEquals(DeployBehavior.UNDEFINED, actualCreateLightWeightCloneResult.getDeployBehavior());
    assertEquals(DeployState.UNDEFINED, actualCreateLightWeightCloneResult.getDeployState());
    assertEquals(
        EnforceEnterpriseCollectionBehaviorState.UNDEFINED,
        actualCreateLightWeightCloneResult.getEnforceEnterpriseCollectionBehaviorState());
    assertEquals(
        ValidateProductionChangesState.UNDEFINED,
        actualCreateLightWeightCloneResult.getValidateProductionChangesState());
    assertFalse(actualCreateLightWeightCloneResult.getAdmin());
    assertFalse(actualCreateLightWeightCloneResult.getIgnoreSite());
    assertFalse(actualCreateLightWeightCloneResult.getInternalIgnoreFilters());
    assertFalse(actualCreateLightWeightCloneResult.getInternalValidateFind());
    assertFalse(actualCreateLightWeightCloneResult.ignoreSite);
    assertFalse(actualCreateLightWeightCloneResult.isAdmin);
    assertTrue(actualCreateLightWeightCloneResult.getExplicitCatalogs().isEmpty());
    assertTrue(actualCreateLightWeightCloneResult.explicitCatalogs.isEmpty());
    assertTrue(actualCreateLightWeightCloneResult.getAdditionalProperties().isEmpty());
    assertTrue(actualCreateLightWeightCloneResult.isProductionSandBox());
    java.util.Locale locale = actualCreateLightWeightCloneResult.javaLocale;
    assertSame(locale, broadleafRequestContext.getJavaLocale());
    assertSame(locale, actualCreateLightWeightCloneResult.getJavaLocale());
    assertSame(locale, broadleafRequestContext.javaLocale);
  }

  /**
   * Test {@link BroadleafRequestContext#createLightWeightCloneJson()}.
   *
   * <ul>
   *   <li>Given {@link BroadleafRequestContext} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRequestContext#createLightWeightCloneJson()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafRequestContext.createLightWeightCloneJson()"})
  public void testCreateLightWeightCloneJson_givenBroadleafRequestContext() {
    // Arrange, Act and Assert
    assertEquals(
        "{\"ignoreSite\":\"false\",\"sandBox\":\"null\",\"nonPersistentSite\":\"null\",\"enforceEnterpriseCollectionBehaviorState"
            + "\":\"UNDEFINED\",\"admin\":\"false\",\"adminUserId\":\"null\",\"broadleafCurrency\":\"null\",\"currentCatalog\":\"null"
            + "\",\"currentProfile\":\"null\",\"deployBehavior\":\"UNDEFINED\",\"deployState\":\"UNDEFINED\",\"internalIgnoreFilters"
            + "\":\"false\",\"locale\":\"null\",\"validateProductionChangesState\":\"UNDEFINED\",\"timeZone\":\"null\"}",
        new BroadleafRequestContext().createLightWeightCloneJson());
  }

  /**
   * Test new {@link BroadleafRequestContext} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link BroadleafRequestContext}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafRequestContext.<init>()"})
  public void testNewBroadleafRequestContext() {
    // Arrange and Act
    BroadleafRequestContext actualBroadleafRequestContext = new BroadleafRequestContext();

    // Assert
    assertNull(actualBroadleafRequestContext.getAdminUserId());
    assertNull(actualBroadleafRequestContext.getSandBoxId());
    assertNull(actualBroadleafRequestContext.getRequestURIWithoutContext());
    assertNull(actualBroadleafRequestContext.javaCurrency);
    assertNull(actualBroadleafRequestContext.getTimeZone());
    assertNull(actualBroadleafRequestContext.getRequest());
    assertNull(actualBroadleafRequestContext.getResponse());
    assertNull(actualBroadleafRequestContext.getRequestDTO());
    assertNull(actualBroadleafRequestContext.getBroadleafCurrency());
    assertNull(actualBroadleafRequestContext.getRequestedBroadleafCurrency());
    assertNull(actualBroadleafRequestContext.getLocale());
    assertNull(actualBroadleafRequestContext.getSandBox());
    assertNull(actualBroadleafRequestContext.getCurrentCatalog());
    assertNull(actualBroadleafRequestContext.getCurrentProfile());
    assertNull(actualBroadleafRequestContext.getNonPersistentSite());
    assertNull(actualBroadleafRequestContext.getSite());
    assertNull(actualBroadleafRequestContext.getTheme());
    assertNull(actualBroadleafRequestContext.getMessageSource());
    assertNull(actualBroadleafRequestContext.getWebRequest());
    assertEquals(DeployBehavior.UNDEFINED, actualBroadleafRequestContext.getDeployBehavior());
    assertEquals(DeployState.UNDEFINED, actualBroadleafRequestContext.getDeployState());
    assertEquals(
        EnforceEnterpriseCollectionBehaviorState.UNDEFINED,
        actualBroadleafRequestContext.getEnforceEnterpriseCollectionBehaviorState());
    assertEquals(
        ValidateProductionChangesState.UNDEFINED,
        actualBroadleafRequestContext.getValidateProductionChangesState());
    assertFalse(actualBroadleafRequestContext.getAdmin());
    assertFalse(actualBroadleafRequestContext.getIgnoreSite());
    assertFalse(actualBroadleafRequestContext.getInternalIgnoreFilters());
    assertFalse(actualBroadleafRequestContext.getInternalValidateFind());
    assertFalse(actualBroadleafRequestContext.ignoreSite);
    assertFalse(actualBroadleafRequestContext.isAdmin);
    assertTrue(actualBroadleafRequestContext.getExplicitCatalogs().isEmpty());
    assertTrue(actualBroadleafRequestContext.explicitCatalogs.isEmpty());
    assertTrue(actualBroadleafRequestContext.getAdditionalProperties().isEmpty());
    assertTrue(actualBroadleafRequestContext.isProductionSandBox());
  }
}

/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.locale.service.LocaleService;
import org.broadleafcommerce.common.sandbox.service.SandBoxService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(classes = {BroadleafProcessURLFilter.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class BroadleafProcessURLFilterDiffblueTest {
  @Autowired private BroadleafProcessURLFilter broadleafProcessURLFilter;

  @MockBean(name = "blLocaleService")
  private LocaleService localeService;

  @MockBean(name = "blSandBoxService")
  private SandBoxService sandBoxService;

  /**
   * Test {@link BroadleafProcessURLFilter#doFilterInternal(HttpServletRequest, HttpServletResponse,
   * FilterChain)}.
   *
   * <p>Method under test: {@link BroadleafProcessURLFilter#doFilterInternal(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafProcessURLFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternal() throws IOException, ServletException {
    // Arrange
    when(localeService.findDefaultLocale()).thenThrow(new NumberFormatException());
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () ->
            broadleafProcessURLFilter.doFilterInternal(
                request, new MockHttpServletResponse(), mock(FilterChain.class)));
    verify(localeService).findDefaultLocale();
  }

  /**
   * Test {@link BroadleafProcessURLFilter#doFilterInternal(HttpServletRequest, HttpServletResponse,
   * FilterChain)}.
   *
   * <p>Method under test: {@link BroadleafProcessURLFilter#doFilterInternal(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafProcessURLFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternal2() throws IOException, ServletException {
    // Arrange
    when(localeService.findDefaultLocale()).thenReturn(new LocaleImpl());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new NumberFormatException())
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> broadleafProcessURLFilter.doFilterInternal(request, response, filterChain));
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(localeService).findDefaultLocale();
  }

  /**
   * Test {@link BroadleafProcessURLFilter#doFilterInternal(HttpServletRequest, HttpServletResponse,
   * FilterChain)}.
   *
   * <p>Method under test: {@link BroadleafProcessURLFilter#doFilterInternal(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafProcessURLFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternal3() throws IOException, ServletException {
    // Arrange
    MockHttpServletRequest request = mock(MockHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenThrow(new NumberFormatException());
    when(request.getAttribute(Mockito.<String>any())).thenReturn("Attribute");
    when(request.getContextPath()).thenReturn("https://example.org/example");
    when(request.getRequestURI()).thenReturn("https://example.org/example");
    doNothing().when(request).addParameter(Mockito.<String>any(), Mockito.<String>any());
    request.addParameter("https://example.org/example", "https://example.org/example");

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () ->
            broadleafProcessURLFilter.doFilterInternal(
                request, new MockHttpServletResponse(), mock(FilterChain.class)));
    verify(request).addParameter("https://example.org/example", "https://example.org/example");
    verify(request).getAttribute("blRequestDTO");
    verify(request, atLeast(1)).getContextPath();
    verify(request).getParameter("blSandboxDateTimeRibbonProduction");
    verify(request, atLeast(1)).getRequestURI();
  }

  /**
   * Test {@link BroadleafProcessURLFilter#doFilterInternal(HttpServletRequest, HttpServletResponse,
   * FilterChain)}.
   *
   * <ul>
   *   <li>Given {@link BroadleafProcessURLFilter} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BroadleafProcessURLFilter#doFilterInternal(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafProcessURLFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternal_givenBroadleafProcessURLFilter()
      throws IOException, ServletException {
    // Arrange
    BroadleafProcessURLFilter broadleafProcessURLFilter = new BroadleafProcessURLFilter();

    MockHttpServletRequest request = new MockHttpServletRequest(new MockServletContext());
    request.setContextPath(null);
    request.setRequestURI("org.broadleafcommerce.admin");
    request.setQueryString("not empty");
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new NumberFormatException())
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> broadleafProcessURLFilter.doFilterInternal(request, response, filterChain));
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link BroadleafProcessURLFilter#doFilterInternal(HttpServletRequest, HttpServletResponse,
   * FilterChain)}.
   *
   * <ul>
   *   <li>Then calls {@link MockHttpServletRequest#setAttribute(String, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafProcessURLFilter#doFilterInternal(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafProcessURLFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternal_thenCallsSetAttribute() throws IOException, ServletException {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    localeImpl.setDefaultCurrency(new BroadleafCurrencyImpl());
    localeImpl.setDefaultFlag(true);
    localeImpl.setFriendlyName("en");
    localeImpl.setLocaleCode("en");
    localeImpl.setUseCountryInSearchIndex(true);

    MockHttpSession mockHttpSession = mock(MockHttpSession.class);
    doThrow(new NumberFormatException())
        .when(mockHttpSession)
        .setAttribute(Mockito.<String>any(), Mockito.<Object>any());
    doNothing().when(mockHttpSession).putValue(Mockito.<String>any(), Mockito.<Object>any());
    doNothing().when(mockHttpSession).removeAttribute(Mockito.<String>any());
    mockHttpSession.putValue("https://example.org/example", "Value");

    MockHttpServletRequest request = mock(MockHttpServletRequest.class);
    when(request.getSession()).thenReturn(mockHttpSession);
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");
    doNothing().when(request).setAttribute(Mockito.<String>any(), Mockito.<Object>any());
    when(request.getAttribute(Mockito.<String>any())).thenReturn(localeImpl);
    when(request.getContextPath()).thenReturn("https://example.org/example");
    when(request.getRequestURI()).thenReturn("https://example.org/example");
    doNothing().when(request).addParameter(Mockito.<String>any(), Mockito.<String>any());
    request.addParameter("https://example.org/example", "https://example.org/example");

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () ->
            broadleafProcessURLFilter.doFilterInternal(
                request, new MockHttpServletResponse(), mock(FilterChain.class)));
    verify(request).addParameter("https://example.org/example", "https://example.org/example");
    verify(request, atLeast(1)).getAttribute(Mockito.<String>any());
    verify(request, atLeast(1)).getContextPath();
    verify(request).getParameter("blSandboxDateTimeRibbonProduction");
    verify(request, atLeast(1)).getRequestURI();
    verify(request, atLeast(1)).getSession();
    verify(request, atLeast(1)).setAttribute(Mockito.<String>any(), Mockito.<Object>any());
    verify(mockHttpSession).putValue(eq("https://example.org/example"), isA(Object.class));
    verify(mockHttpSession, atLeast(1)).removeAttribute(Mockito.<String>any());
    verify(mockHttpSession).setAttribute(eq("blLocale"), isA(Object.class));
  }

  /**
   * Test {@link BroadleafProcessURLFilter#shouldProcessURL(HttpServletRequest, String)}.
   *
   * <ul>
   *   <li>When {@code blcadmin}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafProcessURLFilter#shouldProcessURL(HttpServletRequest,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafProcessURLFilter.shouldProcessURL(HttpServletRequest, String)"
  })
  public void testShouldProcessURL_whenBlcadmin_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        broadleafProcessURLFilter.shouldProcessURL(new MockHttpServletRequest(), "blcadmin"));
  }

  /**
   * Test {@link BroadleafProcessURLFilter#shouldProcessURL(HttpServletRequest, String)}.
   *
   * <ul>
   *   <li>When {@code .}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafProcessURLFilter#shouldProcessURL(HttpServletRequest,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafProcessURLFilter.shouldProcessURL(HttpServletRequest, String)"
  })
  public void testShouldProcessURL_whenDot_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(broadleafProcessURLFilter.shouldProcessURL(new MockHttpServletRequest(), "."));
  }

  /**
   * Test {@link BroadleafProcessURLFilter#shouldProcessURL(HttpServletRequest, String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafProcessURLFilter#shouldProcessURL(HttpServletRequest,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafProcessURLFilter.shouldProcessURL(HttpServletRequest, String)"
  })
  public void testShouldProcessURL_whenHttpsExampleOrgExample_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        broadleafProcessURLFilter.shouldProcessURL(
            new MockHttpServletRequest(), "https://example.org/example"));
  }

  /**
   * Test {@link BroadleafProcessURLFilter#shouldProcessURL(HttpServletRequest, String)}.
   *
   * <ul>
   *   <li>When {@code org.broadleafcommerce.admin}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafProcessURLFilter#shouldProcessURL(HttpServletRequest,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafProcessURLFilter.shouldProcessURL(HttpServletRequest, String)"
  })
  public void testShouldProcessURL_whenOrgBroadleafcommerceAdmin_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        broadleafProcessURLFilter.shouldProcessURL(
            new MockHttpServletRequest(), "org.broadleafcommerce.admin"));
  }

  /**
   * Test {@link BroadleafProcessURLFilter#shouldProcessURL(HttpServletRequest, String)}.
   *
   * <ul>
   *   <li>When {@code .service}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafProcessURLFilter#shouldProcessURL(HttpServletRequest,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafProcessURLFilter.shouldProcessURL(HttpServletRequest, String)"
  })
  public void testShouldProcessURL_whenService_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        broadleafProcessURLFilter.shouldProcessURL(new MockHttpServletRequest(), ".service"));
  }

  /**
   * Test {@link BroadleafProcessURLFilter#getIgnoreSuffixes()}.
   *
   * <p>Method under test: {@link BroadleafProcessURLFilter#getIgnoreSuffixes()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set BroadleafProcessURLFilter.getIgnoreSuffixes()"})
  public void testGetIgnoreSuffixes() {
    // Arrange, Act and Assert
    assertEquals(44, broadleafProcessURLFilter.getIgnoreSuffixes().size());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BroadleafProcessURLFilter#setCacheExpirationSeconds(int)}
   *   <li>{@link BroadleafProcessURLFilter#setMaxCacheConcurrency(int)}
   *   <li>{@link BroadleafProcessURLFilter#setMaxCacheElements(int)}
   *   <li>{@link BroadleafProcessURLFilter#setSandBoxPreviewEnabled(Boolean)}
   *   <li>{@link BroadleafProcessURLFilter#setUrlProcessorList(List)}
   *   <li>{@link BroadleafProcessURLFilter#getCacheExpirationSeconds()}
   *   <li>{@link BroadleafProcessURLFilter#getMaxCacheConcurrency()}
   *   <li>{@link BroadleafProcessURLFilter#getMaxCacheElements()}
   *   <li>{@link BroadleafProcessURLFilter#getSandBoxPreviewEnabled()}
   *   <li>{@link BroadleafProcessURLFilter#getUrlProcessorList()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int BroadleafProcessURLFilter.getCacheExpirationSeconds()",
    "int BroadleafProcessURLFilter.getMaxCacheConcurrency()",
    "int BroadleafProcessURLFilter.getMaxCacheElements()",
    "Boolean BroadleafProcessURLFilter.getSandBoxPreviewEnabled()",
    "List BroadleafProcessURLFilter.getUrlProcessorList()",
    "void BroadleafProcessURLFilter.setCacheExpirationSeconds(int)",
    "void BroadleafProcessURLFilter.setMaxCacheConcurrency(int)",
    "void BroadleafProcessURLFilter.setMaxCacheElements(int)",
    "void BroadleafProcessURLFilter.setSandBoxPreviewEnabled(Boolean)",
    "void BroadleafProcessURLFilter.setUrlProcessorList(List)"
  })
  public void testGettersAndSetters() {
    // Arrange
    BroadleafProcessURLFilter broadleafProcessURLFilter = new BroadleafProcessURLFilter();

    // Act
    broadleafProcessURLFilter.setCacheExpirationSeconds(1);
    broadleafProcessURLFilter.setMaxCacheConcurrency(3);
    broadleafProcessURLFilter.setMaxCacheElements(3);
    broadleafProcessURLFilter.setSandBoxPreviewEnabled(true);
    ArrayList<URLProcessor> urlProcessorList = new ArrayList<>();
    broadleafProcessURLFilter.setUrlProcessorList(urlProcessorList);
    int actualCacheExpirationSeconds = broadleafProcessURLFilter.getCacheExpirationSeconds();
    int actualMaxCacheConcurrency = broadleafProcessURLFilter.getMaxCacheConcurrency();
    int actualMaxCacheElements = broadleafProcessURLFilter.getMaxCacheElements();
    Boolean actualSandBoxPreviewEnabled = broadleafProcessURLFilter.getSandBoxPreviewEnabled();
    List<URLProcessor> actualUrlProcessorList = broadleafProcessURLFilter.getUrlProcessorList();

    // Assert
    assertEquals(1, actualCacheExpirationSeconds);
    assertEquals(3, actualMaxCacheConcurrency);
    assertEquals(3, actualMaxCacheElements);
    assertTrue(actualUrlProcessorList.isEmpty());
    assertTrue(actualSandBoxPreviewEnabled);
    assertSame(urlProcessorList, actualUrlProcessorList);
  }
}

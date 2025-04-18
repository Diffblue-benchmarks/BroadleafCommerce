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
package org.broadleafcommerce.common.web.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.nio.file.Paths;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.broadleafcommerce.common.web.AbstractBroadleafWebRequestProcessor;
import org.broadleafcommerce.common.web.util.FileSystemResponseWrapper;
import org.broadleafcommerce.common.web.util.StatusExposingServletResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertyResolver;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.request.WebRequest;

@ContextConfiguration(classes = {TranslationFilter.class})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class TranslationFilterDiffblueTest {
  @MockBean
  private Environment environment;

  @Autowired
  private TranslationFilter translationFilter;

  @MockBean(name = "blTranslationRequestProcessor")
  private TranslationRequestProcessor translationRequestProcessor;

  /**
   * Test {@link TranslationFilter#doFilterUnlessIgnored(ServletRequest, ServletResponse, FilterChain)}.
   * <ul>
   *   <li>Given {@link Environment} {@link PropertyResolver#getProperty(String, Class, Object)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationFilter#doFilterUnlessIgnored(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TranslationFilter.doFilterUnlessIgnored(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilterUnlessIgnored_givenEnvironmentGetPropertyReturnFalse() throws IOException, ServletException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(false);
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    FilterChain filterChain = mock(FilterChain.class);
    doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    translationFilter.doFilterUnlessIgnored(request, response2, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(environment, atLeast(1)).getProperty(eq("i18n.translation.enabled"), isA(Class.class), isA(Object.class));
  }

  /**
   * Test {@link TranslationFilter#doFilterUnlessIgnored(ServletRequest, ServletResponse, FilterChain)}.
   * <ul>
   *   <li>Then calls {@link AbstractBroadleafWebRequestProcessor#postProcess(WebRequest)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationFilter#doFilterUnlessIgnored(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TranslationFilter.doFilterUnlessIgnored(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilterUnlessIgnored_thenCallsPostProcess() throws IOException, ServletException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);
    doNothing().when(translationRequestProcessor).postProcess(Mockito.<WebRequest>any());
    doNothing().when(translationRequestProcessor).process(Mockito.<WebRequest>any());
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    FilterChain filterChain = mock(FilterChain.class);
    doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    translationFilter.doFilterUnlessIgnored(request, response2, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(translationRequestProcessor).postProcess(isA(WebRequest.class));
    verify(translationRequestProcessor).process(isA(WebRequest.class));
    verify(environment, atLeast(1)).getProperty(eq("i18n.translation.enabled"), isA(Class.class), isA(Object.class));
  }

  /**
   * Test {@link TranslationFilter#doFilterUnlessIgnored(ServletRequest, ServletResponse, FilterChain)}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationFilter#doFilterUnlessIgnored(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TranslationFilter.doFilterUnlessIgnored(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilterUnlessIgnored_thenThrowIOException() throws IOException, ServletException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);
    doNothing().when(translationRequestProcessor).postProcess(Mockito.<WebRequest>any());
    doNothing().when(translationRequestProcessor).process(Mockito.<WebRequest>any());
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new IOException("i18n.translation.enabled")).when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(IOException.class, () -> translationFilter.doFilterUnlessIgnored(request, response2, filterChain));
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(translationRequestProcessor).postProcess(isA(WebRequest.class));
    verify(translationRequestProcessor).process(isA(WebRequest.class));
    verify(environment, atLeast(1)).getProperty(eq("i18n.translation.enabled"), isA(Class.class), isA(Object.class));
  }

  /**
   * Test {@link TranslationFilter#doFilterUnlessIgnored(ServletRequest, ServletResponse, FilterChain)}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationFilter#doFilterUnlessIgnored(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TranslationFilter.doFilterUnlessIgnored(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilterUnlessIgnored_thenThrowIOException2() throws IOException, ServletException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(false);
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new IOException("i18n.translation.enabled")).when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(IOException.class, () -> translationFilter.doFilterUnlessIgnored(request, response2, filterChain));
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(environment, atLeast(1)).getProperty(eq("i18n.translation.enabled"), isA(Class.class), isA(Object.class));
  }

  /**
   * Test {@link TranslationFilter#areTranslationsEnabled()}.
   * <ul>
   *   <li>Given {@link Environment} {@link PropertyResolver#getProperty(String, Class, Object)} return {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationFilter#areTranslationsEnabled()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TranslationFilter.areTranslationsEnabled()"})
  public void testAreTranslationsEnabled_givenEnvironmentGetPropertyReturnTrue_thenReturnTrue() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);

    // Act
    boolean actualAreTranslationsEnabledResult = translationFilter.areTranslationsEnabled();

    // Assert
    verify(environment).getProperty(eq("i18n.translation.enabled"), isA(Class.class), isA(Object.class));
    assertTrue(actualAreTranslationsEnabledResult);
  }

  /**
   * Test {@link TranslationFilter#areTranslationsEnabled()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationFilter#areTranslationsEnabled()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TranslationFilter.areTranslationsEnabled()"})
  public void testAreTranslationsEnabled_thenReturnFalse() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(false);

    // Act
    boolean actualAreTranslationsEnabledResult = translationFilter.areTranslationsEnabled();

    // Assert
    verify(environment).getProperty(eq("i18n.translation.enabled"), isA(Class.class), isA(Object.class));
    assertFalse(actualAreTranslationsEnabledResult);
  }

  /**
   * Test {@link TranslationFilter#getOrder()}.
   * <p>
   * Method under test: {@link TranslationFilter#getOrder()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TranslationFilter.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(FilterOrdered.POST_SECURITY_LOW, (new TranslationFilter()).getOrder());
  }
}

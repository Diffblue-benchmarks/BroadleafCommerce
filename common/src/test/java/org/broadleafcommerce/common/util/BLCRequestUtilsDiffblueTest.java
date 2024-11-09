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
package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

public class BLCRequestUtilsDiffblueTest {
  /**
   * Test {@link BLCRequestUtils#isOKtoUseSession(WebRequest)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCRequestUtils#isOKtoUseSession(WebRequest)}
   */
  @Test
  public void testIsOKtoUseSession_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(BLCRequestUtils.isOKtoUseSession(
        new ServletWebRequest(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()))));
  }

  /**
   * Test {@link BLCRequestUtils#isFilteringIgnoredForUri(WebRequest)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCRequestUtils#isFilteringIgnoredForUri(WebRequest)}
   */
  @Test
  public void testIsFilteringIgnoredForUri_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(BLCRequestUtils.isFilteringIgnoredForUri(
        new ServletWebRequest(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()))));
  }

  /**
   * Test {@link BLCRequestUtils#getSessionAttributeIfOk(WebRequest, String)}.
   * <p>
   * Method under test:
   * {@link BLCRequestUtils#getSessionAttributeIfOk(WebRequest, String)}
   */
  @Test
  public void testGetSessionAttributeIfOk() {
    // Arrange, Act and Assert
    assertNull(BLCRequestUtils.getSessionAttributeIfOk(
        new ServletWebRequest(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())), "Attribute"));
  }

  /**
   * Test {@link BLCRequestUtils#getSessionAttributeIfOk(WebRequest, String)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link WebRequest}
   * {@link RequestAttributes#getAttribute(String, int)} return
   * {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCRequestUtils#getSessionAttributeIfOk(WebRequest, String)}
   */
  @Test
  public void testGetSessionAttributeIfOk_givenFalse_whenWebRequestGetAttributeReturnFalse() {
    // Arrange
    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(false);

    // Act
    Object actualSessionAttributeIfOk = BLCRequestUtils.getSessionAttributeIfOk(request, "Attribute");

    // Assert
    verify(request).getAttribute(eq("blOkToUseSession"), eq(0));
    assertNull(actualSessionAttributeIfOk);
  }

  /**
   * Test {@link BLCRequestUtils#getSessionAttributeIfOk(WebRequest, String)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link WebRequest}
   * {@link RequestAttributes#getAttribute(String, int)} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCRequestUtils#getSessionAttributeIfOk(WebRequest, String)}
   */
  @Test
  public void testGetSessionAttributeIfOk_givenTrue_whenWebRequestGetAttributeReturnTrue() {
    // Arrange
    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(true);

    // Act
    BLCRequestUtils.getSessionAttributeIfOk(request, "Attribute");

    // Assert
    verify(request, atLeast(1)).getAttribute(Mockito.<String>any(), anyInt());
  }

  /**
   * Test
   * {@link BLCRequestUtils#setSessionAttributeIfOk(WebRequest, String, Object)}.
   * <p>
   * Method under test:
   * {@link BLCRequestUtils#setSessionAttributeIfOk(WebRequest, String, Object)}
   */
  @Test
  public void testSetSessionAttributeIfOk() {
    // Arrange
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act
    BLCRequestUtils.setSessionAttributeIfOk(request, "Attribute", BLCFieldUtils.NULL_FIELD);

    // Assert
    Object sessionMutex = request.getSessionMutex();
    assertTrue(sessionMutex instanceof MockHttpSession);
    assertArrayEquals(new String[]{"Attribute"}, ((MockHttpSession) sessionMutex).getValueNames());
  }

  /**
   * Test
   * {@link BLCRequestUtils#setSessionAttributeIfOk(WebRequest, String, Object)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCRequestUtils#setSessionAttributeIfOk(WebRequest, String, Object)}
   */
  @Test
  public void testSetSessionAttributeIfOk_givenFalse_thenReturnFalse() {
    // Arrange
    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(false);

    // Act
    boolean actualSetSessionAttributeIfOkResult = BLCRequestUtils.setSessionAttributeIfOk(request, "Attribute",
        BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(request).getAttribute(eq("blOkToUseSession"), eq(0));
    assertFalse(actualSetSessionAttributeIfOkResult);
  }

  /**
   * Test
   * {@link BLCRequestUtils#setSessionAttributeIfOk(WebRequest, String, Object)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCRequestUtils#setSessionAttributeIfOk(WebRequest, String, Object)}
   */
  @Test
  public void testSetSessionAttributeIfOk_givenTrue_thenReturnTrue() {
    // Arrange
    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(true);
    doNothing().when(request).setAttribute(Mockito.<String>any(), Mockito.<Object>any(), anyInt());

    // Act
    boolean actualSetSessionAttributeIfOkResult = BLCRequestUtils.setSessionAttributeIfOk(request, "Attribute",
        BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(request).getAttribute(eq("blOkToUseSession"), eq(0));
    verify(request).setAttribute(eq("Attribute"), isA(Object.class), eq(1));
    assertTrue(actualSetSessionAttributeIfOkResult);
  }

  /**
   * Test {@link BLCRequestUtils#setOKtoUseSession(WebRequest, Boolean)}.
   * <ul>
   *   <li>Then calls
   * {@link ServletRequestWrapper#setAttribute(String, Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCRequestUtils#setOKtoUseSession(WebRequest, Boolean)}
   */
  @Test
  public void testSetOKtoUseSession_thenCallsSetAttribute() {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    doNothing().when(request).setAttribute(Mockito.<String>any(), Mockito.<Object>any());

    // Act
    BLCRequestUtils.setOKtoUseSession(new ServletWebRequest(new SessionlessHttpServletRequestWrapper(request)), true);

    // Assert
    verify(request).setAttribute(eq("blOkToUseSession"), isA(Object.class));
  }

  /**
   * Test
   * {@link BLCRequestUtils#setIsFilteringIgnoredForUri(WebRequest, Boolean)}.
   * <ul>
   *   <li>Then calls
   * {@link ServletRequestWrapper#setAttribute(String, Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCRequestUtils#setIsFilteringIgnoredForUri(WebRequest, Boolean)}
   */
  @Test
  public void testSetIsFilteringIgnoredForUri_thenCallsSetAttribute() {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    doNothing().when(request).setAttribute(Mockito.<String>any(), Mockito.<Object>any());

    // Act
    BLCRequestUtils
        .setIsFilteringIgnoredForUri(new ServletWebRequest(new SessionlessHttpServletRequestWrapper(request)), true);

    // Assert
    verify(request).setAttribute(eq("blUriIsFilterIgnored"), isA(Object.class));
  }

  /**
   * Test {@link BLCRequestUtils#getURLorHeaderParameter(WebRequest, String)}.
   * <ul>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCRequestUtils#getURLorHeaderParameter(WebRequest, String)}
   */
  @Test
  public void testGetURLorHeaderParameter_thenReturnHttpsExampleOrgExample() {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");

    // Act
    String actualURLorHeaderParameter = BLCRequestUtils.getURLorHeaderParameter(
        new ServletWebRequest(new SessionlessHttpServletRequestWrapper(request)), "https://example.org/example");

    // Assert
    verify(request).getHeader(eq("https://example.org/example"));
    assertEquals("https://example.org/example", actualURLorHeaderParameter);
  }

  /**
   * Test {@link BLCRequestUtils#getURLorHeaderParameter(WebRequest, String)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCRequestUtils#getURLorHeaderParameter(WebRequest, String)}
   */
  @Test
  public void testGetURLorHeaderParameter_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BLCRequestUtils.getURLorHeaderParameter(
        new ServletWebRequest(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())),
        "https://example.org/example"));
  }

  /**
   * Test {@link BLCRequestUtils#getRequestURIWithoutContext(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code Request}.</li>
   *   <li>Then return {@code Request}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCRequestUtils#getRequestURIWithoutContext(HttpServletRequest)}
   */
  @Test
  public void testGetRequestURIWithoutContext_givenRequest_thenReturnRequest() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setRequestURI("Request");
    request.setContextPath(null);

    // Act and Assert
    assertEquals("Request", BLCRequestUtils.getRequestURIWithoutContext(request));
  }

  /**
   * Test {@link BLCRequestUtils#getRequestURIWithoutContext(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code ;}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCRequestUtils#getRequestURIWithoutContext(HttpServletRequest)}
   */
  @Test
  public void testGetRequestURIWithoutContext_givenSemicolon() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setRequestURI(";");
    request.setContextPath(null);

    // Act and Assert
    assertEquals("", BLCRequestUtils.getRequestURIWithoutContext(request));
  }

  /**
   * Test {@link BLCRequestUtils#getRequestURIWithoutContext(HttpServletRequest)}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCRequestUtils#getRequestURIWithoutContext(HttpServletRequest)}
   */
  @Test
  public void testGetRequestURIWithoutContext_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", BLCRequestUtils
        .getRequestURIWithoutContext(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())));
  }

  /**
   * Test {@link BLCRequestUtils#getRequestURIWithoutContext(HttpServletRequest)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} RequestURI
   * is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCRequestUtils#getRequestURIWithoutContext(HttpServletRequest)}
   */
  @Test
  public void testGetRequestURIWithoutContext_whenMockHttpServletRequestRequestURIIsNull() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setRequestURI(null);
    request.setContextPath(null);

    // Act and Assert
    assertNull(BLCRequestUtils.getRequestURIWithoutContext(request));
  }

  /**
   * Test {@link BLCRequestUtils#getRequestURIWithoutContext(HttpServletRequest)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCRequestUtils#getRequestURIWithoutContext(HttpServletRequest)}
   */
  @Test
  public void testGetRequestURIWithoutContext_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BLCRequestUtils.getRequestURIWithoutContext(null));
  }
}

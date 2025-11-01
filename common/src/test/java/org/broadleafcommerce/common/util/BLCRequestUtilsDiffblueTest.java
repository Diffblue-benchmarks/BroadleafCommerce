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
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

public class BLCRequestUtilsDiffblueTest {
  /**
   * Method under test: {@link BLCRequestUtils#isOKtoUseSession(WebRequest)}
   */
  @Test
  public void testIsOKtoUseSession() {
    // Arrange, Act and Assert
    assertTrue(BLCRequestUtils.isOKtoUseSession(
        new ServletWebRequest(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()))));
  }

  /**
   * Method under test:
   * {@link BLCRequestUtils#isFilteringIgnoredForUri(WebRequest)}
   */
  @Test
  public void testIsFilteringIgnoredForUri() {
    // Arrange, Act and Assert
    assertFalse(BLCRequestUtils.isFilteringIgnoredForUri(
        new ServletWebRequest(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()))));
  }

  /**
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
   * Method under test:
   * {@link BLCRequestUtils#getSessionAttributeIfOk(WebRequest, String)}
   */
  @Test
  public void testGetSessionAttributeIfOk2() {
    // Arrange
    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(true);

    // Act
    BLCRequestUtils.getSessionAttributeIfOk(request, "Attribute");

    // Assert
    verify(request, atLeast(1)).getAttribute(Mockito.<String>any(), anyInt());
  }

  /**
   * Method under test:
   * {@link BLCRequestUtils#getSessionAttributeIfOk(WebRequest, String)}
   */
  @Test
  public void testGetSessionAttributeIfOk3() {
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
   * Method under test:
   * {@link BLCRequestUtils#setSessionAttributeIfOk(WebRequest, String, Object)}
   */
  @Test
  public void testSetSessionAttributeIfOk() {
    // Arrange
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act
    boolean actualSetSessionAttributeIfOkResult = BLCRequestUtils.setSessionAttributeIfOk(request, "Attribute",
        BLCFieldUtils.NULL_FIELD);

    // Assert
    Object sessionMutex = request.getSessionMutex();
    assertTrue(sessionMutex instanceof MockHttpSession);
    assertTrue(actualSetSessionAttributeIfOkResult);
    assertArrayEquals(new String[]{"Attribute"}, ((MockHttpSession) sessionMutex).getValueNames());
  }

  /**
   * Method under test:
   * {@link BLCRequestUtils#setSessionAttributeIfOk(WebRequest, String, Object)}
   */
  @Test
  public void testSetSessionAttributeIfOk2() {
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
   * Method under test:
   * {@link BLCRequestUtils#setSessionAttributeIfOk(WebRequest, String, Object)}
   */
  @Test
  public void testSetSessionAttributeIfOk3() {
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
   * Method under test:
   * {@link BLCRequestUtils#setOKtoUseSession(WebRequest, Boolean)}
   */
  @Test
  public void testSetOKtoUseSession() {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    doNothing().when(request).setAttribute(Mockito.<String>any(), Mockito.<Object>any());

    // Act
    BLCRequestUtils.setOKtoUseSession(new ServletWebRequest(new SessionlessHttpServletRequestWrapper(request)), true);

    // Assert
    verify(request).setAttribute(eq("blOkToUseSession"), isA(Object.class));
  }

  /**
   * Method under test:
   * {@link BLCRequestUtils#setIsFilteringIgnoredForUri(WebRequest, Boolean)}
   */
  @Test
  public void testSetIsFilteringIgnoredForUri() {
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
   * Method under test:
   * {@link BLCRequestUtils#getURLorHeaderParameter(WebRequest, String)}
   */
  @Test
  public void testGetURLorHeaderParameter() {
    // Arrange, Act and Assert
    assertNull(BLCRequestUtils.getURLorHeaderParameter(
        new ServletWebRequest(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())),
        "https://example.org/example"));
  }

  /**
   * Method under test:
   * {@link BLCRequestUtils#getURLorHeaderParameter(WebRequest, String)}
   */
  @Test
  public void testGetURLorHeaderParameter2() {
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
   * Method under test:
   * {@link BLCRequestUtils#getRequestURIWithoutContext(HttpServletRequest)}
   */
  @Test
  public void testGetRequestURIWithoutContext() {
    // Arrange, Act and Assert
    assertEquals("", BLCRequestUtils
        .getRequestURIWithoutContext(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())));
    assertNull(BLCRequestUtils.getRequestURIWithoutContext(null));
  }

  /**
   * Method under test:
   * {@link BLCRequestUtils#getRequestURIWithoutContext(HttpServletRequest)}
   */
  @Test
  public void testGetRequestURIWithoutContext2() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setRequestURI(null);
    request.setContextPath(null);

    // Act and Assert
    assertNull(BLCRequestUtils.getRequestURIWithoutContext(request));
  }

  /**
   * Method under test:
   * {@link BLCRequestUtils#getRequestURIWithoutContext(HttpServletRequest)}
   */
  @Test
  public void testGetRequestURIWithoutContext3() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setRequestURI("Request");
    request.setContextPath(null);

    // Act and Assert
    assertEquals("Request", BLCRequestUtils.getRequestURIWithoutContext(request));
  }

  /**
   * Method under test:
   * {@link BLCRequestUtils#getRequestURIWithoutContext(HttpServletRequest)}
   */
  @Test
  public void testGetRequestURIWithoutContext4() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setRequestURI(";");
    request.setContextPath(null);

    // Act and Assert
    assertEquals("", BLCRequestUtils.getRequestURIWithoutContext(request));
  }
}

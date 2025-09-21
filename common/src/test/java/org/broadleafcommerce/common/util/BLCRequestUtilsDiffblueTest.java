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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

public class BLCRequestUtilsDiffblueTest {
  /**
   * Test {@link BLCRequestUtils#isOKtoUseSession(WebRequest)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BLCRequestUtils#isOKtoUseSession(WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BLCRequestUtils.isOKtoUseSession(WebRequest)"})
  public void testIsOKtoUseSession_thenReturnTrue() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertTrue(BLCRequestUtils.isOKtoUseSession(new ServletWebRequest(request)));
  }

  /**
   * Test {@link BLCRequestUtils#isFilteringIgnoredForUri(WebRequest)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BLCRequestUtils#isFilteringIgnoredForUri(WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BLCRequestUtils.isFilteringIgnoredForUri(WebRequest)"})
  public void testIsFilteringIgnoredForUri_thenReturnFalse() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertFalse(BLCRequestUtils.isFilteringIgnoredForUri(new ServletWebRequest(request)));
  }

  /**
   * Test {@link BLCRequestUtils#getSessionAttributeIfOk(WebRequest, String)}.
   *
   * <p>Method under test: {@link BLCRequestUtils#getSessionAttributeIfOk(WebRequest, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object BLCRequestUtils.getSessionAttributeIfOk(WebRequest, String)"})
  public void testGetSessionAttributeIfOk() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertNull(
        BLCRequestUtils.getSessionAttributeIfOk(new ServletWebRequest(request), "Attribute"));
  }

  /**
   * Test {@link BLCRequestUtils#getSessionAttributeIfOk(WebRequest, String)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link WebRequest} {@link WebRequest#getAttribute(String, int)} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link BLCRequestUtils#getSessionAttributeIfOk(WebRequest, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object BLCRequestUtils.getSessionAttributeIfOk(WebRequest, String)"})
  public void testGetSessionAttributeIfOk_givenFalse_whenWebRequestGetAttributeReturnFalse() {
    // Arrange
    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(false);

    // Act
    Object actualSessionAttributeIfOk =
        BLCRequestUtils.getSessionAttributeIfOk(request, "Attribute");

    // Assert
    verify(request).getAttribute("blOkToUseSession", 0);
    assertNull(actualSessionAttributeIfOk);
  }

  /**
   * Test {@link BLCRequestUtils#getSessionAttributeIfOk(WebRequest, String)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BLCRequestUtils#getSessionAttributeIfOk(WebRequest, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object BLCRequestUtils.getSessionAttributeIfOk(WebRequest, String)"})
  public void testGetSessionAttributeIfOk_givenTrue_thenReturnTrue() {
    // Arrange
    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(true);

    // Act
    Object actualSessionAttributeIfOk =
        BLCRequestUtils.getSessionAttributeIfOk(request, "Attribute");

    // Assert
    verify(request, atLeast(1)).getAttribute(Mockito.<String>any(), anyInt());
    assertTrue((Boolean) actualSessionAttributeIfOk);
  }

  /**
   * Test {@link BLCRequestUtils#setSessionAttributeIfOk(WebRequest, String, Object)}.
   *
   * <p>Method under test: {@link BLCRequestUtils#setSessionAttributeIfOk(WebRequest, String,
   * Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BLCRequestUtils.setSessionAttributeIfOk(WebRequest, String, Object)"})
  public void testSetSessionAttributeIfOk() {
    // Arrange
    ServletWebRequest request =
        new ServletWebRequest(new HttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act
    boolean actualSetSessionAttributeIfOkResult =
        BLCRequestUtils.setSessionAttributeIfOk(request, "Attribute", BLCFieldUtils.NULL_FIELD);

    // Assert
    Object sessionMutex = request.getSessionMutex();
    assertTrue(sessionMutex instanceof MockHttpSession);
    assertTrue(actualSetSessionAttributeIfOkResult);
    assertArrayEquals(new String[] {"Attribute"}, ((MockHttpSession) sessionMutex).getValueNames());
  }

  /**
   * Test {@link BLCRequestUtils#setSessionAttributeIfOk(WebRequest, String, Object)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BLCRequestUtils#setSessionAttributeIfOk(WebRequest, String,
   * Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BLCRequestUtils.setSessionAttributeIfOk(WebRequest, String, Object)"})
  public void testSetSessionAttributeIfOk_givenFalse_thenReturnFalse() {
    // Arrange
    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(false);

    // Act
    boolean actualSetSessionAttributeIfOkResult =
        BLCRequestUtils.setSessionAttributeIfOk(request, "Attribute", BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(request).getAttribute("blOkToUseSession", 0);
    assertFalse(actualSetSessionAttributeIfOkResult);
  }

  /**
   * Test {@link BLCRequestUtils#setSessionAttributeIfOk(WebRequest, String, Object)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then calls {@link WebRequest#setAttribute(String, Object, int)}.
   * </ul>
   *
   * <p>Method under test: {@link BLCRequestUtils#setSessionAttributeIfOk(WebRequest, String,
   * Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BLCRequestUtils.setSessionAttributeIfOk(WebRequest, String, Object)"})
  public void testSetSessionAttributeIfOk_givenTrue_thenCallsSetAttribute() {
    // Arrange
    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(true);
    doNothing().when(request).setAttribute(Mockito.<String>any(), Mockito.<Object>any(), anyInt());

    // Act
    boolean actualSetSessionAttributeIfOkResult =
        BLCRequestUtils.setSessionAttributeIfOk(request, "Attribute", BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(request).getAttribute("blOkToUseSession", 0);
    verify(request).setAttribute(eq("Attribute"), isA(Object.class), eq(1));
    assertTrue(actualSetSessionAttributeIfOkResult);
  }

  /**
   * Test {@link BLCRequestUtils#getURLorHeaderParameter(WebRequest, String)}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link BLCRequestUtils#getURLorHeaderParameter(WebRequest, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCRequestUtils.getURLorHeaderParameter(WebRequest, String)"})
  public void testGetURLorHeaderParameter_thenReturnHttpsExampleOrgExample() {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");
    SessionlessHttpServletRequestWrapper request2 =
        new SessionlessHttpServletRequestWrapper(request);
    HttpServletRequestWrapper request3 = new HttpServletRequestWrapper(request2);

    // Act
    String actualURLorHeaderParameter =
        BLCRequestUtils.getURLorHeaderParameter(
            new ServletWebRequest(request3), "https://example.org/example");

    // Assert
    verify(request).getHeader("https://example.org/example");
    assertEquals("https://example.org/example", actualURLorHeaderParameter);
  }

  /**
   * Test {@link BLCRequestUtils#getURLorHeaderParameter(WebRequest, String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BLCRequestUtils#getURLorHeaderParameter(WebRequest, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCRequestUtils.getURLorHeaderParameter(WebRequest, String)"})
  public void testGetURLorHeaderParameter_thenReturnNull() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertNull(
        BLCRequestUtils.getURLorHeaderParameter(
            new ServletWebRequest(request), "https://example.org/example"));
  }

  /**
   * Test {@link BLCRequestUtils#getRequestURIWithoutContext(HttpServletRequest)}.
   *
   * <p>Method under test: {@link BLCRequestUtils#getRequestURIWithoutContext(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCRequestUtils.getRequestURIWithoutContext(HttpServletRequest)"})
  public void testGetRequestURIWithoutContext() {
    // Arrange, Act and Assert
    assertEquals(
        "",
        BLCRequestUtils.getRequestURIWithoutContext(
            new HttpServletRequestWrapper(
                new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()))));
  }

  /**
   * Test {@link BLCRequestUtils#getRequestURIWithoutContext(HttpServletRequest)}.
   *
   * <p>Method under test: {@link BLCRequestUtils#getRequestURIWithoutContext(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCRequestUtils.getRequestURIWithoutContext(HttpServletRequest)"})
  public void testGetRequestURIWithoutContext2() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest(new MockServletContext());
    request.setRequestURI(null);
    request.setContextPath(null);

    // Act and Assert
    assertNull(BLCRequestUtils.getRequestURIWithoutContext(request));
  }

  /**
   * Test {@link BLCRequestUtils#getRequestURIWithoutContext(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Given {@code ;}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link BLCRequestUtils#getRequestURIWithoutContext(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCRequestUtils.getRequestURIWithoutContext(HttpServletRequest)"})
  public void testGetRequestURIWithoutContext_givenSemicolon_thenReturnEmptyString() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest(new MockServletContext());
    request.setRequestURI(";");
    request.setContextPath(null);

    // Act and Assert
    assertEquals("", BLCRequestUtils.getRequestURIWithoutContext(request));
  }

  /**
   * Test {@link BLCRequestUtils#getRequestURIWithoutContext(HttpServletRequest)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BLCRequestUtils#getRequestURIWithoutContext(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCRequestUtils.getRequestURIWithoutContext(HttpServletRequest)"})
  public void testGetRequestURIWithoutContext_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BLCRequestUtils.getRequestURIWithoutContext(null));
  }
}

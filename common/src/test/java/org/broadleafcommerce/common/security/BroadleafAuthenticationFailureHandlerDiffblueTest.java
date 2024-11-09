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
package org.broadleafcommerce.common.security;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.broadleafcommerce.common.web.util.FileSystemResponseWrapper;
import org.broadleafcommerce.common.web.util.StatusExposingServletResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BroadleafAuthenticationFailureHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafAuthenticationFailureHandlerDiffblueTest {
  @Autowired
  private BroadleafAuthenticationFailureHandler broadleafAuthenticationFailureHandler;

  /**
   * Test
   * {@link BroadleafAuthenticationFailureHandler#BroadleafAuthenticationFailureHandler()}.
   * <p>
   * Method under test:
   * {@link BroadleafAuthenticationFailureHandler#BroadleafAuthenticationFailureHandler()}
   */
  @Test
  public void testNewBroadleafAuthenticationFailureHandler() {
    // Arrange, Act and Assert
    assertNull((new BroadleafAuthenticationFailureHandler()).validateUrlParam("https://example.org/example"));
    assertNull((new BroadleafAuthenticationFailureHandler("https://example.org/example"))
        .validateUrlParam("https://example.org/example"));
  }

  /**
   * Test
   * {@link BroadleafAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)}.
   * <p>
   * Method under test:
   * {@link BroadleafAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)}
   */
  @Test
  public void testOnAuthenticationFailure() throws IOException, ServletException {
    // Arrange
    BroadleafAuthenticationFailureHandler broadleafAuthenticationFailureHandler = new BroadleafAuthenticationFailureHandler();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act
    broadleafAuthenticationFailureHandler.onAuthenticationFailure(request, response2,
        new AccountExpiredException("Msg"));

    // Assert
    Collection<String> headerNames = response2.getHeaderNames();
    assertTrue(headerNames instanceof Set);
    ServletResponse response3 = response2.getResponse();
    assertTrue(response3 instanceof FileSystemResponseWrapper);
    ServletResponse response4 = ((FileSystemResponseWrapper) response3).getResponse();
    assertTrue(response4 instanceof MockHttpServletResponse);
    assertEquals("Unauthorized", ((MockHttpServletResponse) response4).getErrorMessage());
    assertNull(((MockHttpServletResponse) response4).getRedirectedUrl());
    assertEquals(401, ((FileSystemResponseWrapper) response3).getStatus());
    assertEquals(401, response2.getStatus());
    assertEquals(401, ((MockHttpServletResponse) response4).getStatus());
    assertTrue(headerNames.isEmpty());
  }

  /**
   * Test
   * {@link BroadleafAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)}.
   * <p>
   * Method under test:
   * {@link BroadleafAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)}
   */
  @Test
  public void testOnAuthenticationFailure2() throws IOException, ServletException {
    // Arrange
    BroadleafAuthenticationFailureHandler broadleafAuthenticationFailureHandler = new BroadleafAuthenticationFailureHandler(
        "https://example.org/example");
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act
    broadleafAuthenticationFailureHandler.onAuthenticationFailure(request, response2,
        new AccountExpiredException("Msg"));

    // Assert
    Collection<String> headerNames = response2.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    ServletResponse response3 = response2.getResponse();
    assertTrue(response3 instanceof FileSystemResponseWrapper);
    ServletResponse response4 = ((FileSystemResponseWrapper) response3).getResponse();
    assertTrue(response4 instanceof MockHttpServletResponse);
    HttpSession session = request.getSession();
    assertTrue(session instanceof MockHttpSession);
    assertEquals("https://example.org/example", ((MockHttpServletResponse) response4).getRedirectedUrl());
    assertNull(((MockHttpServletResponse) response4).getErrorMessage());
    assertEquals(200, response2.getStatus());
    assertEquals(302, ((FileSystemResponseWrapper) response3).getStatus());
    assertEquals(302, ((MockHttpServletResponse) response4).getStatus());
    assertTrue(headerNames.contains("Location"));
    assertArrayEquals(new String[]{"SPRING_SECURITY_LAST_EXCEPTION"}, session.getValueNames());
  }

  /**
   * Test {@link BroadleafAuthenticationFailureHandler#validateUrlParam(String)}.
   * <ul>
   *   <li>When {@code .}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafAuthenticationFailureHandler#validateUrlParam(String)}
   */
  @Test
  public void testValidateUrlParam_whenDot_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(broadleafAuthenticationFailureHandler.validateUrlParam("."));
  }

  /**
   * Test {@link BroadleafAuthenticationFailureHandler#validateUrlParam(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafAuthenticationFailureHandler#validateUrlParam(String)}
   */
  @Test
  public void testValidateUrlParam_whenHttpsExampleOrgExample_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(broadleafAuthenticationFailureHandler.validateUrlParam("https://example.org/example"));
  }

  /**
   * Test {@link BroadleafAuthenticationFailureHandler#validateUrlParam(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafAuthenticationFailureHandler#validateUrlParam(String)}
   */
  @Test
  public void testValidateUrlParam_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(broadleafAuthenticationFailureHandler.validateUrlParam(null));
  }

  /**
   * Test {@link BroadleafAuthenticationFailureHandler#validateUrlParam(String)}.
   * <ul>
   *   <li>When {@code Url}.</li>
   *   <li>Then return {@code Url}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafAuthenticationFailureHandler#validateUrlParam(String)}
   */
  @Test
  public void testValidateUrlParam_whenUrl_thenReturnUrl() {
    // Arrange, Act and Assert
    assertEquals("Url", broadleafAuthenticationFailureHandler.validateUrlParam("Url"));
  }

  /**
   * Test {@link BroadleafAuthenticationFailureHandler#validateUrlParam(String)}.
   * <ul>
   *   <li>When {@code www}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafAuthenticationFailureHandler#validateUrlParam(String)}
   */
  @Test
  public void testValidateUrlParam_whenWww_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(broadleafAuthenticationFailureHandler.validateUrlParam("www"));
  }
}

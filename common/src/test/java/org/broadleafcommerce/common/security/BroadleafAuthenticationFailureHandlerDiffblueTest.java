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
package org.broadleafcommerce.common.security;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Set;
import javax.servlet.ServletException;
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
    FileSystemResponseWrapper response2 = new FileSystemResponseWrapper(response,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    StatusExposingServletResponse response3 = new StatusExposingServletResponse(response2);

    // Act
    broadleafAuthenticationFailureHandler.onAuthenticationFailure(request, response3,
        new AccountExpiredException("Msg"));

    // Assert
    Collection<String> headerNames = response3.getHeaderNames();
    assertTrue(headerNames instanceof Set);
    assertEquals(401, response3.getStatus());
    assertTrue(headerNames.isEmpty());
    assertTrue(response3.isCommitted());
    assertSame(response2, response3.getResponse());
  }

  /**
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
    FileSystemResponseWrapper response2 = new FileSystemResponseWrapper(response,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    StatusExposingServletResponse response3 = new StatusExposingServletResponse(response2);

    // Act
    broadleafAuthenticationFailureHandler.onAuthenticationFailure(request, response3,
        new AccountExpiredException("Msg"));

    // Assert
    Collection<String> headerNames = response3.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    HttpSession session = request.getSession();
    assertTrue(session instanceof MockHttpSession);
    assertEquals(200, response3.getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response3.isCommitted());
    assertSame(response2, response3.getResponse());
    assertArrayEquals(new String[]{"SPRING_SECURITY_LAST_EXCEPTION"}, session.getValueNames());
  }

  /**
   * Method under test:
   * {@link BroadleafAuthenticationFailureHandler#validateUrlParam(String)}
   */
  @Test
  public void testValidateUrlParam() {
    // Arrange, Act and Assert
    assertNull(broadleafAuthenticationFailureHandler.validateUrlParam("https://example.org/example"));
    assertEquals("Url", broadleafAuthenticationFailureHandler.validateUrlParam("Url"));
    assertNull(broadleafAuthenticationFailureHandler.validateUrlParam(null));
    assertNull(broadleafAuthenticationFailureHandler.validateUrlParam("."));
    assertNull(broadleafAuthenticationFailureHandler.validateUrlParam("www"));
  }
}

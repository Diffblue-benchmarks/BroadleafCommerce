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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.broadleafcommerce.common.web.util.StatusExposingServletResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.owasp.esapi.filters.SecurityWrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BroadleafAuthenticationFailureHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafAuthenticationFailureHandlerDiffblueTest {
  @Autowired private BroadleafAuthenticationFailureHandler broadleafAuthenticationFailureHandler;

  /**
   * Test {@link BroadleafAuthenticationFailureHandler#BroadleafAuthenticationFailureHandler()}.
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationFailureHandler#BroadleafAuthenticationFailureHandler()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafAuthenticationFailureHandler.<init>()"})
  public void testNewBroadleafAuthenticationFailureHandler() {
    // Arrange, Act and Assert
    assertNull(
        new BroadleafAuthenticationFailureHandler()
            .validateUrlParam("https://example.org/example"));
  }

  /**
   * Test {@link
   * BroadleafAuthenticationFailureHandler#BroadleafAuthenticationFailureHandler(String)}.
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationFailureHandler#BroadleafAuthenticationFailureHandler(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafAuthenticationFailureHandler.<init>(String)"})
  public void testNewBroadleafAuthenticationFailureHandler2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertNull(
        new BroadleafAuthenticationFailureHandler("https://example.org/example")
            .validateUrlParam("https://example.org/example"));
  }

  /**
   * Test {@link BroadleafAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}.
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAuthenticationFailureHandler.onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)"
  })
  public void testOnAuthenticationFailure() throws IOException, ServletException {
    // Arrange
    BroadleafAuthenticationFailureHandler broadleafAuthenticationFailureHandler =
        new BroadleafAuthenticationFailureHandler();
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));

    // Act
    broadleafAuthenticationFailureHandler.onAuthenticationFailure(
        request, response, new AccountExpiredException("Msg"));

    // Assert
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof StatusExposingServletResponse);
    ServletResponse response3 = ((StatusExposingServletResponse) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertEquals("Unauthorized", ((MockHttpServletResponse) response3).getErrorMessage());
    assertEquals(401, response.getStatus());
    assertEquals(401, ((StatusExposingServletResponse) response2).getStatus());
    assertEquals(401, ((MockHttpServletResponse) response3).getStatus());
  }

  /**
   * Test {@link BroadleafAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}.
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAuthenticationFailureHandler.onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)"
  })
  public void testOnAuthenticationFailure2() throws IOException, ServletException {
    // Arrange
    BroadleafAuthenticationFailureHandler broadleafAuthenticationFailureHandler =
        new BroadleafAuthenticationFailureHandler("https://example.org/example");
    broadleafAuthenticationFailureHandler.setUseForward(false);
    broadleafAuthenticationFailureHandler.setAllowSessionCreation(false);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));

    // Act
    broadleafAuthenticationFailureHandler.onAuthenticationFailure(
        request, response, new AccountExpiredException("Msg"));

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof StatusExposingServletResponse);
    ServletResponse response3 = ((StatusExposingServletResponse) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertEquals(
        "https://example.org/example", ((MockHttpServletResponse) response3).getRedirectedUrl());
    assertEquals(302, ((MockHttpServletResponse) response3).getStatus());
    assertTrue(headerNames.contains("Location"));
  }

  /**
   * Test {@link BroadleafAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}.
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAuthenticationFailureHandler.onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)"
  })
  public void testOnAuthenticationFailure3() throws IOException, ServletException {
    // Arrange
    BroadleafAuthenticationFailureHandler broadleafAuthenticationFailureHandler =
        new BroadleafAuthenticationFailureHandler();
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    SessionlessHttpServletRequestWrapper request2 =
        new SessionlessHttpServletRequestWrapper(request);
    HttpServletRequestWrapper request3 = new HttpServletRequestWrapper(request2);
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));
    SecurityWrapperResponse response2 = new SecurityWrapperResponse(response, "Mode");

    // Act
    broadleafAuthenticationFailureHandler.onAuthenticationFailure(
        request3, response2, new AccountExpiredException("Msg"));

    // Assert
    ServletResponse response3 = response2.getResponse();
    assertTrue(response3 instanceof HttpServletResponseWrapper);
    ServletResponse response4 = ((HttpServletResponseWrapper) response3).getResponse();
    assertTrue(response4 instanceof StatusExposingServletResponse);
    ServletResponse response5 = ((StatusExposingServletResponse) response4).getResponse();
    assertTrue(response5 instanceof MockHttpServletResponse);
    assertEquals("Unauthorized", ((MockHttpServletResponse) response5).getErrorMessage());
    assertTrue(response4.isCommitted());
    assertTrue(response5.isCommitted());
    assertTrue(response2.isCommitted());
  }

  /**
   * Test {@link BroadleafAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}.
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAuthenticationFailureHandler.onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)"
  })
  public void testOnAuthenticationFailure4() throws IOException, ServletException {
    // Arrange
    BroadleafAuthenticationFailureHandler broadleafAuthenticationFailureHandler =
        new BroadleafAuthenticationFailureHandler();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("successUrl", "failureUrl");
    HttpServletRequestWrapper request2 =
        new HttpServletRequestWrapper(new SessionlessHttpServletRequestWrapper(request));
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));

    // Act
    broadleafAuthenticationFailureHandler.onAuthenticationFailure(
        request2, response, new AccountExpiredException("Msg"));

    // Assert
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof StatusExposingServletResponse);
    ServletResponse response3 = ((StatusExposingServletResponse) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertEquals("Unauthorized", ((MockHttpServletResponse) response3).getErrorMessage());
    assertEquals(401, response.getStatus());
    assertEquals(401, ((StatusExposingServletResponse) response2).getStatus());
    assertEquals(401, ((MockHttpServletResponse) response3).getStatus());
  }

  /**
   * Test {@link BroadleafAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}.
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAuthenticationFailureHandler.onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)"
  })
  public void testOnAuthenticationFailure5() throws IOException, ServletException {
    // Arrange
    BroadleafAuthenticationFailureHandler broadleafAuthenticationFailureHandler =
        new BroadleafAuthenticationFailureHandler();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("successUrl", "https://example.org/example");
    HttpServletRequestWrapper request2 =
        new HttpServletRequestWrapper(new SessionlessHttpServletRequestWrapper(request));
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));

    // Act
    broadleafAuthenticationFailureHandler.onAuthenticationFailure(
        request2, response, new AccountExpiredException("Msg"));

    // Assert
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof StatusExposingServletResponse);
    ServletResponse response3 = ((StatusExposingServletResponse) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertEquals("Unauthorized", ((MockHttpServletResponse) response3).getErrorMessage());
    assertEquals(401, response.getStatus());
    assertEquals(401, ((StatusExposingServletResponse) response2).getStatus());
    assertEquals(401, ((MockHttpServletResponse) response3).getStatus());
  }

  /**
   * Test {@link BroadleafAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}.
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAuthenticationFailureHandler.onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)"
  })
  public void testOnAuthenticationFailure6() throws IOException, ServletException {
    // Arrange
    BroadleafAuthenticationFailureHandler broadleafAuthenticationFailureHandler =
        new BroadleafAuthenticationFailureHandler("https://example.org/example");
    broadleafAuthenticationFailureHandler.setRedirectStrategy(new LocalRedirectStrategy());
    broadleafAuthenticationFailureHandler.setUseForward(false);
    broadleafAuthenticationFailureHandler.setAllowSessionCreation(false);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));

    // Act
    broadleafAuthenticationFailureHandler.onAuthenticationFailure(
        request, response, new AccountExpiredException("Msg"));

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof StatusExposingServletResponse);
    ServletResponse response3 = ((StatusExposingServletResponse) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertEquals(
        "https://example.org/example", ((MockHttpServletResponse) response3).getRedirectedUrl());
    assertEquals(302, ((MockHttpServletResponse) response3).getStatus());
    assertTrue(headerNames.contains("Location"));
  }

  /**
   * Test {@link BroadleafAuthenticationFailureHandler#validateUrlParam(String)}.
   *
   * <ul>
   *   <li>When {@code .}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafAuthenticationFailureHandler#validateUrlParam(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafAuthenticationFailureHandler.validateUrlParam(String)"})
  public void testValidateUrlParam_whenDot_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(broadleafAuthenticationFailureHandler.validateUrlParam("."));
  }

  /**
   * Test {@link BroadleafAuthenticationFailureHandler#validateUrlParam(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafAuthenticationFailureHandler#validateUrlParam(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafAuthenticationFailureHandler.validateUrlParam(String)"})
  public void testValidateUrlParam_whenHttpsExampleOrgExample_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        broadleafAuthenticationFailureHandler.validateUrlParam("https://example.org/example"));
  }

  /**
   * Test {@link BroadleafAuthenticationFailureHandler#validateUrlParam(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafAuthenticationFailureHandler#validateUrlParam(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafAuthenticationFailureHandler.validateUrlParam(String)"})
  public void testValidateUrlParam_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(broadleafAuthenticationFailureHandler.validateUrlParam(null));
  }

  /**
   * Test {@link BroadleafAuthenticationFailureHandler#validateUrlParam(String)}.
   *
   * <ul>
   *   <li>When {@code Url}.
   *   <li>Then return {@code Url}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafAuthenticationFailureHandler#validateUrlParam(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafAuthenticationFailureHandler.validateUrlParam(String)"})
  public void testValidateUrlParam_whenUrl_thenReturnUrl() {
    // Arrange, Act and Assert
    assertEquals("Url", broadleafAuthenticationFailureHandler.validateUrlParam("Url"));
  }

  /**
   * Test {@link BroadleafAuthenticationFailureHandler#validateUrlParam(String)}.
   *
   * <ul>
   *   <li>When {@code www}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafAuthenticationFailureHandler#validateUrlParam(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafAuthenticationFailureHandler.validateUrlParam(String)"})
  public void testValidateUrlParam_whenWww_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(broadleafAuthenticationFailureHandler.validateUrlParam("www"));
  }
}

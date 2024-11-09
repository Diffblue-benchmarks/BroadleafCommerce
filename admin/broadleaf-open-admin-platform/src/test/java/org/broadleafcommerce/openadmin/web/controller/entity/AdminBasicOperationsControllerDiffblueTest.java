/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.web.controller.entity;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.openadmin.web.compatibility.JSCompatibilityRequestWrapper;
import org.junit.Test;
import org.owasp.esapi.filters.SecurityWrapperRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

public class AdminBasicOperationsControllerDiffblueTest {
  /**
   * Test
   * {@link AdminBasicOperationsController#sessionTimerReset(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test:
   * {@link AdminBasicOperationsController#sessionTimerReset(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testSessionTimerReset() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicOperationsController adminBasicOperationsController = new AdminBasicOperationsController();
    SecurityWrapperRequest request = new SecurityWrapperRequest(
        new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualSessionTimerResetResult = adminBasicOperationsController.sessionTimerReset(request, response);

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("application/json", response.getContentType());
    assertEquals("{\"serverSessionTimeoutInterval\":0}", response.getContentAsString());
    assertNull(actualSessionTimerResetResult);
    assertTrue(headerNames.contains("Content-Type"));
    assertTrue(response.isCommitted());
    byte[] expectedContentAsByteArray = "{\"serverSessionTimeoutInterval\":0}".getBytes("UTF-8");
    assertArrayEquals(expectedContentAsByteArray, response.getContentAsByteArray());
  }

  /**
   * Test
   * {@link AdminBasicOperationsController#sessionTimerReset(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given {@link MockHttpSession#MockHttpSession()}.</li>
   *   <li>Then calls {@link HttpServletRequestWrapper#getSession()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminBasicOperationsController#sessionTimerReset(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testSessionTimerReset_givenMockHttpSession_thenCallsGetSession() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicOperationsController adminBasicOperationsController = new AdminBasicOperationsController();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getSession()).thenReturn(new MockHttpSession());
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualSessionTimerResetResult = adminBasicOperationsController.sessionTimerReset(request2, response);

    // Assert
    verify(request).getSession();
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("application/json", response.getContentType());
    assertEquals("{\"serverSessionTimeoutInterval\":0}", response.getContentAsString());
    assertNull(actualSessionTimerResetResult);
    assertTrue(headerNames.contains("Content-Type"));
    assertTrue(response.isCommitted());
    byte[] expectedContentAsByteArray = "{\"serverSessionTimeoutInterval\":0}".getBytes("UTF-8");
    assertArrayEquals(expectedContentAsByteArray, response.getContentAsByteArray());
  }

  /**
   * Test
   * {@link AdminBasicOperationsController#sessionTimerReset(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) HeaderNames
   * size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminBasicOperationsController#sessionTimerReset(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testSessionTimerReset_thenMockHttpServletResponseHeaderNamesSizeIsOne() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicOperationsController adminBasicOperationsController = new AdminBasicOperationsController();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualSessionTimerResetResult = adminBasicOperationsController.sessionTimerReset(request, response);

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("application/json", response.getContentType());
    assertEquals("{\"serverSessionTimeoutInterval\":0}", response.getContentAsString());
    assertNull(actualSessionTimerResetResult);
    assertTrue(headerNames.contains("Content-Type"));
    assertTrue(response.isCommitted());
    byte[] expectedContentAsByteArray = "{\"serverSessionTimeoutInterval\":0}".getBytes("UTF-8");
    assertArrayEquals(expectedContentAsByteArray, response.getContentAsByteArray());
  }

  /**
   * Test
   * {@link AdminBasicOperationsController#logJavaScriptError(HttpServletRequest, HttpServletResponse, MultiValueMap)}.
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) HeaderNames
   * size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminBasicOperationsController#logJavaScriptError(HttpServletRequest, HttpServletResponse, MultiValueMap)}
   */
  @Test
  public void testLogJavaScriptError_thenMockHttpServletResponseHeaderNamesSizeIsOne() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicOperationsController adminBasicOperationsController = new AdminBasicOperationsController();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualLogJavaScriptErrorResult = adminBasicOperationsController.logJavaScriptError(request, response,
        new HttpHeaders());

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("application/json", response.getContentType());
    assertEquals("{\"errorLogged\":true}", response.getContentAsString());
    assertNull(actualLogJavaScriptErrorResult);
    assertTrue(headerNames.contains("Content-Type"));
    assertTrue(response.isCommitted());
    byte[] expectedContentAsByteArray = "{\"errorLogged\":true}".getBytes("UTF-8");
    assertArrayEquals(expectedContentAsByteArray, response.getContentAsByteArray());
  }

  /**
   * Test
   * {@link AdminBasicOperationsController#logJavaScriptError(HttpServletRequest, HttpServletResponse, MultiValueMap)}.
   * <ul>
   *   <li>When {@link DefaultMultipartHttpServletRequest}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminBasicOperationsController#logJavaScriptError(HttpServletRequest, HttpServletResponse, MultiValueMap)}
   */
  @Test
  public void testLogJavaScriptError_whenDefaultMultipartHttpServletRequest() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicOperationsController adminBasicOperationsController = new AdminBasicOperationsController();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualLogJavaScriptErrorResult = adminBasicOperationsController.logJavaScriptError(request, response,
        new HttpHeaders());

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("application/json", response.getContentType());
    assertEquals("{\"errorLogged\":true}", response.getContentAsString());
    assertNull(actualLogJavaScriptErrorResult);
    assertTrue(headerNames.contains("Content-Type"));
    assertTrue(response.isCommitted());
    byte[] expectedContentAsByteArray = "{\"errorLogged\":true}".getBytes("UTF-8");
    assertArrayEquals(expectedContentAsByteArray, response.getContentAsByteArray());
  }

  /**
   * Test
   * {@link AdminBasicOperationsController#updateAdminNavigation(HttpServletRequest, HttpServletResponse, Model, Map)}.
   * <p>
   * Method under test:
   * {@link AdminBasicOperationsController#updateAdminNavigation(HttpServletRequest, HttpServletResponse, Model, Map)}
   */
  @Test
  public void testUpdateAdminNavigation() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicOperationsController adminBasicOperationsController = new AdminBasicOperationsController();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act and Assert
    assertEquals("layout/partials/secondLeftNav",
        adminBasicOperationsController.updateAdminNavigation(request, response, model, new HashMap<>()));
  }

  /**
   * Test
   * {@link AdminBasicOperationsController#updateAdminNavigation(HttpServletRequest, HttpServletResponse, Model, Map)}.
   * <p>
   * Method under test:
   * {@link AdminBasicOperationsController#updateAdminNavigation(HttpServletRequest, HttpServletResponse, Model, Map)}
   */
  @Test
  public void testUpdateAdminNavigation2() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicOperationsController adminBasicOperationsController = new AdminBasicOperationsController();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act and Assert
    assertEquals("layout/partials/secondLeftNav",
        adminBasicOperationsController.updateAdminNavigation(request, response, model, new HashMap<>()));
  }
}

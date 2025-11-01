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
package org.broadleafcommerce.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

public class RequestDTOImplDiffblueTest {
  /**
   * Method under test: {@link RequestDTOImpl#getProperties()}
   */
  @Test
  public void testGetProperties() {
    // Arrange, Act and Assert
    assertTrue((new RequestDTOImpl()).getProperties().isEmpty());
  }

  /**
   * Method under test: {@link RequestDTOImpl#getProperties()}
   */
  @Test
  public void testGetProperties2() {
    // Arrange
    HashMap<String, String> requestContextAttributes = new HashMap<>();
    requestContextAttributes.computeIfPresent("foo", mock(BiFunction.class));

    RequestDTOImpl requestDTOImpl = new RequestDTOImpl();
    requestDTOImpl.setRequestContextAttributes(requestContextAttributes);

    // Act and Assert
    assertTrue(requestDTOImpl.getProperties().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RequestDTOImpl#RequestDTOImpl()}
   *   <li>{@link RequestDTOImpl#setFullUrlWithQueryString(String)}
   *   <li>{@link RequestDTOImpl#setRequestContextAttributes(Map)}
   *   <li>{@link RequestDTOImpl#setRequestURI(String)}
   *   <li>{@link RequestDTOImpl#setSecure(Boolean)}
   *   <li>{@link RequestDTOImpl#getFullUrLWithQueryString()}
   *   <li>{@link RequestDTOImpl#getFullUrlWithQueryString()}
   *   <li>{@link RequestDTOImpl#getRequestContextAttributes()}
   *   <li>{@link RequestDTOImpl#getRequestURI()}
   *   <li>{@link RequestDTOImpl#getSecure()}
   *   <li>{@link RequestDTOImpl#isSecure()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    RequestDTOImpl actualRequestDTOImpl = new RequestDTOImpl();
    actualRequestDTOImpl.setFullUrlWithQueryString("https://example.org/example");
    HashMap<String, String> requestContextAttributes = new HashMap<>();
    actualRequestDTOImpl.setRequestContextAttributes(requestContextAttributes);
    actualRequestDTOImpl.setRequestURI("Request URI");
    actualRequestDTOImpl.setSecure(true);
    String actualFullUrLWithQueryString = actualRequestDTOImpl.getFullUrLWithQueryString();
    String actualFullUrlWithQueryString = actualRequestDTOImpl.getFullUrlWithQueryString();
    Map<String, String> actualRequestContextAttributes = actualRequestDTOImpl.getRequestContextAttributes();
    String actualRequestURI = actualRequestDTOImpl.getRequestURI();
    Boolean actualSecure = actualRequestDTOImpl.getSecure();
    Boolean actualIsSecureResult = actualRequestDTOImpl.isSecure();

    // Assert that nothing has changed
    assertEquals("Request URI", actualRequestURI);
    assertEquals("https://example.org/example", actualFullUrLWithQueryString);
    assertEquals("https://example.org/example", actualFullUrlWithQueryString);
    assertTrue(actualRequestContextAttributes.isEmpty());
    assertTrue(actualSecure);
    assertTrue(actualIsSecureResult);
    assertSame(requestContextAttributes, actualRequestContextAttributes);
  }

  /**
   * Method under test: {@link RequestDTOImpl#RequestDTOImpl(HttpServletRequest)}
   */
  @Test
  public void testNewRequestDTOImpl() {
    // Arrange and Act
    RequestDTOImpl actualRequestDTOImpl = new RequestDTOImpl(
        new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Assert
    assertEquals("", actualRequestDTOImpl.getRequestURI());
    assertEquals("http://localhost", actualRequestDTOImpl.getFullUrLWithQueryString());
    assertEquals("http://localhost", actualRequestDTOImpl.getFullUrlWithQueryString());
    assertFalse(actualRequestDTOImpl.getSecure());
    assertFalse(actualRequestDTOImpl.isSecure());
    assertTrue(actualRequestDTOImpl.getProperties().isEmpty());
    assertTrue(actualRequestDTOImpl.getRequestContextAttributes().isEmpty());
  }

  /**
   * Method under test: {@link RequestDTOImpl#RequestDTOImpl(HttpServletRequest)}
   */
  @Test
  public void testNewRequestDTOImpl2() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setQueryString("Request");

    // Act
    RequestDTOImpl actualRequestDTOImpl = new RequestDTOImpl(request);

    // Assert
    assertEquals("", actualRequestDTOImpl.getRequestURI());
    assertEquals("http://localhost?Request", actualRequestDTOImpl.getFullUrLWithQueryString());
    assertEquals("http://localhost?Request", actualRequestDTOImpl.getFullUrlWithQueryString());
    assertFalse(actualRequestDTOImpl.getSecure());
    assertFalse(actualRequestDTOImpl.isSecure());
    assertTrue(actualRequestDTOImpl.getProperties().isEmpty());
    assertTrue(actualRequestDTOImpl.getRequestContextAttributes().isEmpty());
  }

  /**
   * Method under test: {@link RequestDTOImpl#RequestDTOImpl(HttpServletRequest)}
   */
  @Test
  public void testNewRequestDTOImpl3() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("https://example.org/example", "https://example.org/example");

    // Act
    RequestDTOImpl actualRequestDTOImpl = new RequestDTOImpl(new SessionlessHttpServletRequestWrapper(request));

    // Assert
    assertEquals("", actualRequestDTOImpl.getRequestURI());
    assertEquals("http://localhost", actualRequestDTOImpl.getFullUrLWithQueryString());
    assertEquals("http://localhost", actualRequestDTOImpl.getFullUrlWithQueryString());
    Map<String, String> requestContextAttributes = actualRequestDTOImpl.getRequestContextAttributes();
    assertEquals(1, requestContextAttributes.size());
    assertEquals("https://example.org/example", requestContextAttributes.get("https://example.org/example"));
    assertFalse(actualRequestDTOImpl.getSecure());
    assertFalse(actualRequestDTOImpl.isSecure());
    assertTrue(actualRequestDTOImpl.getProperties().isEmpty());
  }

  /**
   * Method under test: {@link RequestDTOImpl#RequestDTOImpl(HttpServletRequest)}
   */
  @Test
  public void testNewRequestDTOImpl4() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setSecure(true);
    request.addParameter("https://example.org/example", "https://example.org/example");

    // Act
    RequestDTOImpl actualRequestDTOImpl = new RequestDTOImpl(new SessionlessHttpServletRequestWrapper(request));

    // Assert
    assertEquals("", actualRequestDTOImpl.getRequestURI());
    assertEquals("http://localhost", actualRequestDTOImpl.getFullUrLWithQueryString());
    assertEquals("http://localhost", actualRequestDTOImpl.getFullUrlWithQueryString());
    Map<String, String> requestContextAttributes = actualRequestDTOImpl.getRequestContextAttributes();
    assertEquals(1, requestContextAttributes.size());
    assertEquals("https://example.org/example", requestContextAttributes.get("https://example.org/example"));
    assertTrue(actualRequestDTOImpl.getProperties().isEmpty());
    assertTrue(actualRequestDTOImpl.getSecure());
    assertTrue(actualRequestDTOImpl.isSecure());
  }

  /**
   * Method under test: {@link RequestDTOImpl#RequestDTOImpl(WebRequest)}
   */
  @Test
  public void testNewRequestDTOImpl5() {
    // Arrange and Act
    RequestDTOImpl actualRequestDTOImpl = new RequestDTOImpl(
        new ServletWebRequest(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())));

    // Assert
    assertNull(actualRequestDTOImpl.getFullUrLWithQueryString());
    assertNull(actualRequestDTOImpl.getFullUrlWithQueryString());
    assertNull(actualRequestDTOImpl.getRequestURI());
    assertFalse(actualRequestDTOImpl.getSecure());
    assertFalse(actualRequestDTOImpl.isSecure());
    assertTrue(actualRequestDTOImpl.getProperties().isEmpty());
    assertTrue(actualRequestDTOImpl.getRequestContextAttributes().isEmpty());
  }

  /**
   * Method under test: {@link RequestDTOImpl#RequestDTOImpl(WebRequest)}
   */
  @Test
  public void testNewRequestDTOImpl6() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("https://example.org/example", "https://example.org/example");

    // Act
    RequestDTOImpl actualRequestDTOImpl = new RequestDTOImpl(
        new ServletWebRequest(new SessionlessHttpServletRequestWrapper(request)));

    // Assert
    Map<String, String> requestContextAttributes = actualRequestDTOImpl.getRequestContextAttributes();
    assertEquals(1, requestContextAttributes.size());
    assertEquals("https://example.org/example", requestContextAttributes.get("https://example.org/example"));
    assertNull(actualRequestDTOImpl.getFullUrLWithQueryString());
    assertNull(actualRequestDTOImpl.getFullUrlWithQueryString());
    assertNull(actualRequestDTOImpl.getRequestURI());
    assertFalse(actualRequestDTOImpl.getSecure());
    assertFalse(actualRequestDTOImpl.isSecure());
    assertTrue(actualRequestDTOImpl.getProperties().isEmpty());
  }
}

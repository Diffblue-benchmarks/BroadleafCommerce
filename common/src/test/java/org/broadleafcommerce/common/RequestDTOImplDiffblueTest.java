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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

public class RequestDTOImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RequestDTOImpl.<init>()", "String RequestDTOImpl.getFullUrLWithQueryString()",
      "String RequestDTOImpl.getFullUrlWithQueryString()", "Map RequestDTOImpl.getRequestContextAttributes()",
      "String RequestDTOImpl.getRequestURI()", "Boolean RequestDTOImpl.getSecure()",
      "Boolean RequestDTOImpl.isSecure()", "void RequestDTOImpl.setFullUrlWithQueryString(String)",
      "void RequestDTOImpl.setRequestContextAttributes(Map)", "void RequestDTOImpl.setRequestURI(String)",
      "void RequestDTOImpl.setSecure(Boolean)"})
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

    // Assert
    assertEquals("Request URI", actualRequestURI);
    assertEquals("https://example.org/example", actualFullUrLWithQueryString);
    assertEquals("https://example.org/example", actualFullUrlWithQueryString);
    assertTrue(actualRequestContextAttributes.isEmpty());
    assertTrue(actualSecure);
    assertTrue(actualIsSecureResult);
    assertSame(requestContextAttributes, actualRequestContextAttributes);
  }

  /**
   * Test {@link RequestDTOImpl#RequestDTOImpl(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return Secure.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequestDTOImpl#RequestDTOImpl(HttpServletRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RequestDTOImpl.<init>(HttpServletRequest)"})
  public void testNewRequestDTOImpl_givenTrue_thenReturnSecure() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setSecure(true);
    request.addParameter("https://example.org/example", "https://example.org/example");

    // Act
    RequestDTOImpl actualRequestDTOImpl = new RequestDTOImpl(new SessionlessHttpServletRequestWrapper(request));

    // Assert
    Map<String, String> requestContextAttributes = actualRequestDTOImpl.getRequestContextAttributes();
    assertEquals(1, requestContextAttributes.size());
    assertEquals("https://example.org/example", requestContextAttributes.get("https://example.org/example"));
    assertTrue(actualRequestDTOImpl.getSecure());
    assertTrue(actualRequestDTOImpl.isSecure());
  }

  /**
   * Test {@link RequestDTOImpl#RequestDTOImpl(HttpServletRequest)}.
   * <ul>
   *   <li>Then return FullUrLWithQueryString is {@code http://localhost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequestDTOImpl#RequestDTOImpl(HttpServletRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RequestDTOImpl.<init>(HttpServletRequest)"})
  public void testNewRequestDTOImpl_thenReturnFullUrLWithQueryStringIsHttpLocalhost() {
    // Arrange and Act
    RequestDTOImpl actualRequestDTOImpl = new RequestDTOImpl(
        new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Assert
    assertEquals("http://localhost", actualRequestDTOImpl.getFullUrLWithQueryString());
    assertEquals("http://localhost", actualRequestDTOImpl.getFullUrlWithQueryString());
    assertFalse(actualRequestDTOImpl.getSecure());
    assertFalse(actualRequestDTOImpl.isSecure());
    assertTrue(actualRequestDTOImpl.getRequestContextAttributes().isEmpty());
  }

  /**
   * Test {@link RequestDTOImpl#RequestDTOImpl(HttpServletRequest)}.
   * <ul>
   *   <li>Then return FullUrLWithQueryString is {@code http://localhost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequestDTOImpl#RequestDTOImpl(HttpServletRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RequestDTOImpl.<init>(HttpServletRequest)"})
  public void testNewRequestDTOImpl_thenReturnFullUrLWithQueryStringIsHttpLocalhost2() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("https://example.org/example", "https://example.org/example");

    // Act
    RequestDTOImpl actualRequestDTOImpl = new RequestDTOImpl(new SessionlessHttpServletRequestWrapper(request));

    // Assert
    assertEquals("http://localhost", actualRequestDTOImpl.getFullUrLWithQueryString());
    assertEquals("http://localhost", actualRequestDTOImpl.getFullUrlWithQueryString());
    Map<String, String> requestContextAttributes = actualRequestDTOImpl.getRequestContextAttributes();
    assertEquals(1, requestContextAttributes.size());
    assertEquals("https://example.org/example", requestContextAttributes.get("https://example.org/example"));
  }

  /**
   * Test {@link RequestDTOImpl#RequestDTOImpl(HttpServletRequest)}.
   * <ul>
   *   <li>Then return FullUrLWithQueryString is {@code http://localhost?Request}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequestDTOImpl#RequestDTOImpl(HttpServletRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RequestDTOImpl.<init>(HttpServletRequest)"})
  public void testNewRequestDTOImpl_thenReturnFullUrLWithQueryStringIsHttpLocalhostRequest() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setQueryString("Request");

    // Act
    RequestDTOImpl actualRequestDTOImpl = new RequestDTOImpl(request);

    // Assert
    assertEquals("http://localhost?Request", actualRequestDTOImpl.getFullUrLWithQueryString());
    assertEquals("http://localhost?Request", actualRequestDTOImpl.getFullUrlWithQueryString());
    assertFalse(actualRequestDTOImpl.getSecure());
    assertFalse(actualRequestDTOImpl.isSecure());
    assertTrue(actualRequestDTOImpl.getRequestContextAttributes().isEmpty());
  }

  /**
   * Test {@link RequestDTOImpl#RequestDTOImpl(WebRequest)}.
   * <ul>
   *   <li>Then return RequestContextAttributes Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequestDTOImpl#RequestDTOImpl(WebRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RequestDTOImpl.<init>(WebRequest)"})
  public void testNewRequestDTOImpl_thenReturnRequestContextAttributesEmpty() {
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
   * Test {@link RequestDTOImpl#RequestDTOImpl(WebRequest)}.
   * <ul>
   *   <li>Then return RequestContextAttributes size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequestDTOImpl#RequestDTOImpl(WebRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RequestDTOImpl.<init>(WebRequest)"})
  public void testNewRequestDTOImpl_thenReturnRequestContextAttributesSizeIsOne() {
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

  /**
   * Test {@link RequestDTOImpl#getProperties()}.
   * <p>
   * Method under test: {@link RequestDTOImpl#getProperties()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map RequestDTOImpl.getProperties()"})
  public void testGetProperties() {
    // Arrange, Act and Assert
    assertTrue((new RequestDTOImpl()).getProperties().isEmpty());
  }
}

/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.web.compatibility;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.web.savedrequest.Enumerator;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

public class JSCompatibilityRequestWrapperDiffblueTest {
  /**
   * Method under test: {@link JSCompatibilityRequestWrapper#getContextPath()}
   */
  @Test
  public void testGetContextPath() {
    // Arrange, Act and Assert
    assertEquals("", (new JSCompatibilityRequestWrapper(new MockHttpServletRequest())).getContextPath());
    assertEquals("",
        (new JSCompatibilityRequestWrapper(
            new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()))))
            .getContextPath());
  }

  /**
   * Method under test: {@link JSCompatibilityRequestWrapper#getContextPath()}
   */
  @Test
  public void testGetContextPath2() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setContextPath("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example", (new JSCompatibilityRequestWrapper(request)).getContextPath());
  }

  /**
   * Method under test: {@link JSCompatibilityRequestWrapper#getPathTranslated()}
   */
  @Test
  public void testGetPathTranslated() {
    // Arrange, Act and Assert
    assertNull((new JSCompatibilityRequestWrapper(new MockHttpServletRequest())).getPathTranslated());
    assertNull((new JSCompatibilityRequestWrapper(
        new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()))))
        .getPathTranslated());
  }

  /**
   * Method under test: {@link JSCompatibilityRequestWrapper#getQueryString()}
   */
  @Test
  public void testGetQueryString() {
    // Arrange, Act and Assert
    assertNull((new JSCompatibilityRequestWrapper(new MockHttpServletRequest())).getQueryString());
    assertNull((new JSCompatibilityRequestWrapper(
        new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()))))
        .getQueryString());
  }

  /**
   * Method under test: {@link JSCompatibilityRequestWrapper#getQueryString()}
   */
  @Test
  public void testGetQueryString2() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setQueryString("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example", (new JSCompatibilityRequestWrapper(request)).getQueryString());
  }

  /**
   * Method under test: {@link JSCompatibilityRequestWrapper#getQueryString()}
   */
  @Test
  public void testGetQueryString3() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setQueryString("");

    // Act and Assert
    assertEquals("", (new JSCompatibilityRequestWrapper(request)).getQueryString());
  }

  /**
   * Method under test: {@link JSCompatibilityRequestWrapper#getRequestURI()}
   */
  @Test
  public void testGetRequestURI() {
    // Arrange, Act and Assert
    assertEquals("", (new JSCompatibilityRequestWrapper(new MockHttpServletRequest())).getRequestURI());
    assertEquals("",
        (new JSCompatibilityRequestWrapper(
            new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()))))
            .getRequestURI());
    assertEquals("https://example.org/example", (new JSCompatibilityRequestWrapper(
        new MockHttpServletRequest("https://example.org/example", "https://example.org/example"))).getRequestURI());
  }

  /**
   * Method under test: {@link JSCompatibilityRequestWrapper#getRequestURL()}
   */
  @Test
  public void testGetRequestURL() {
    // Arrange, Act and Assert
    assertEquals("http://localhost",
        (new JSCompatibilityRequestWrapper(new MockHttpServletRequest())).getRequestURL().toString());
    assertEquals("http://localhost",
        (new JSCompatibilityRequestWrapper(
            new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()))))
            .getRequestURL()
            .toString());
  }

  /**
   * Method under test: {@link JSCompatibilityRequestWrapper#getServletPath()}
   */
  @Test
  public void testGetServletPath() {
    // Arrange, Act and Assert
    assertEquals("", (new JSCompatibilityRequestWrapper(new MockHttpServletRequest())).getServletPath());
    assertEquals("",
        (new JSCompatibilityRequestWrapper(
            new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()))))
            .getServletPath());
  }

  /**
   * Method under test: {@link JSCompatibilityRequestWrapper#getServletPath()}
   */
  @Test
  public void testGetServletPath2() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setServletPath("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example", (new JSCompatibilityRequestWrapper(request)).getServletPath());
  }

  /**
   * Method under test: {@link JSCompatibilityRequestWrapper#getParameter(String)}
   */
  @Test
  public void testGetParameter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new JSCompatibilityRequestWrapper(new MockHttpServletRequest())).getParameter("Name"));
    assertNull((new JSCompatibilityRequestWrapper(
        new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()))))
        .getParameter("Name"));
  }

  /**
   * Method under test: {@link JSCompatibilityRequestWrapper#getParameter(String)}
   */
  @Test
  public void testGetParameter2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");

    // Act
    String actualParameter = (new JSCompatibilityRequestWrapper(request)).getParameter("Name");

    // Assert
    verify(request).getParameter(eq("Name"));
    assertEquals("https://example.org/example", actualParameter);
  }

  /**
   * Method under test: {@link JSCompatibilityRequestWrapper#getParameter(String)}
   */
  @Test
  public void testGetParameter3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("");

    // Act
    String actualParameter = (new JSCompatibilityRequestWrapper(request)).getParameter("Name");

    // Assert
    verify(request).getParameter(eq("Name"));
    assertEquals("", actualParameter);
  }

  /**
   * Method under test: {@link JSCompatibilityRequestWrapper#getParameterNames()}
   */
  @Test
  public void testGetParameterNames() {
    // Arrange and Act
    Enumeration actualParameterNames = (new JSCompatibilityRequestWrapper(new MockHttpServletRequest()))
        .getParameterNames();

    // Assert
    assertTrue(actualParameterNames instanceof Enumerator);
    assertFalse(actualParameterNames.hasMoreElements());
  }

  /**
   * Method under test: {@link JSCompatibilityRequestWrapper#getParameterNames()}
   */
  @Test
  public void testGetParameterNames2() {
    // Arrange and Act
    Enumeration actualParameterNames = (new JSCompatibilityRequestWrapper(
        new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()))))
        .getParameterNames();

    // Assert
    assertTrue(actualParameterNames instanceof Enumerator);
    assertFalse(actualParameterNames.hasMoreElements());
  }

  /**
   * Method under test: {@link JSCompatibilityRequestWrapper#getParameterNames()}
   */
  @Test
  public void testGetParameterNames3() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("https://example.org/example", "https://example.org/example");

    // Act
    Enumeration actualParameterNames = (new JSCompatibilityRequestWrapper(request)).getParameterNames();

    // Assert
    assertTrue(actualParameterNames instanceof Enumerator);
    assertTrue(actualParameterNames.hasMoreElements());
  }

  /**
   * Method under test: {@link JSCompatibilityRequestWrapper#getParameterNames()}
   */
  @Test
  public void testGetParameterNames4() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("", "https://example.org/example");

    // Act
    Enumeration actualParameterNames = (new JSCompatibilityRequestWrapper(request)).getParameterNames();

    // Assert
    assertTrue(actualParameterNames instanceof Enumerator);
    assertTrue(actualParameterNames.hasMoreElements());
  }

  /**
   * Method under test: {@link JSCompatibilityRequestWrapper#getParameterMap()}
   */
  @Test
  public void testGetParameterMap() {
    // Arrange, Act and Assert
    assertTrue((new JSCompatibilityRequestWrapper(new MockHttpServletRequest())).getParameterMap().isEmpty());
    assertTrue((new JSCompatibilityRequestWrapper(
        new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()))))
        .getParameterMap()
        .isEmpty());
  }

  /**
   * Method under test: {@link JSCompatibilityRequestWrapper#getParameterMap()}
   */
  @Test
  public void testGetParameterMap2() {
    // Arrange
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    LinkedMultiValueMap<String, MultipartFile> mpFiles = new LinkedMultiValueMap<>();
    HashMap<String, String[]> mpParams = new HashMap<>();

    // Act and Assert
    assertTrue((new JSCompatibilityRequestWrapper(
        new DefaultMultipartHttpServletRequest(request, mpFiles, mpParams, new HashMap<>()))).getParameterMap()
        .isEmpty());
  }

  /**
   * Method under test: {@link JSCompatibilityRequestWrapper#getParameterMap()}
   */
  @Test
  public void testGetParameterMap3() {
    // Arrange
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(
        new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(new MockHttpServletRequest())));
    LinkedMultiValueMap<String, MultipartFile> mpFiles = new LinkedMultiValueMap<>();
    HashMap<String, String[]> mpParams = new HashMap<>();

    // Act and Assert
    assertTrue((new JSCompatibilityRequestWrapper(
        new DefaultMultipartHttpServletRequest(request, mpFiles, mpParams, new HashMap<>()))).getParameterMap()
        .isEmpty());
  }

  /**
   * Method under test:
   * {@link JSCompatibilityRequestWrapper#getParameterNameConversionMap()}
   */
  @Test
  public void testGetParameterNameConversionMap() {
    // Arrange, Act and Assert
    assertTrue(
        (new JSCompatibilityRequestWrapper(new MockHttpServletRequest())).getParameterNameConversionMap().isEmpty());
    assertTrue((new JSCompatibilityRequestWrapper(new JSCompatibilityRequestWrapper(new MockHttpServletRequest())))
        .getParameterNameConversionMap()
        .isEmpty());
    assertTrue((new JSCompatibilityRequestWrapper(
        new JSCompatibilityRequestWrapper(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()))))
        .getParameterNameConversionMap()
        .isEmpty());
  }

  /**
   * Method under test:
   * {@link JSCompatibilityRequestWrapper#getParameterNameConversionMap()}
   */
  @Test
  public void testGetParameterNameConversionMap2() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("https://example.org/example", "https://example.org/example");

    // Act
    Map<String, String> actualParameterNameConversionMap = (new JSCompatibilityRequestWrapper(request))
        .getParameterNameConversionMap();

    // Assert
    assertEquals(1, actualParameterNameConversionMap.size());
    assertEquals("https://example.org/example", actualParameterNameConversionMap.get("https://example.org/example"));
  }

  /**
   * Method under test:
   * {@link JSCompatibilityRequestWrapper#getParameterNameConversionMap()}
   */
  @Test
  public void testGetParameterNameConversionMap3() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("", "https://example.org/example");

    // Act
    Map<String, String> actualParameterNameConversionMap = (new JSCompatibilityRequestWrapper(request))
        .getParameterNameConversionMap();

    // Assert
    assertEquals(1, actualParameterNameConversionMap.size());
    assertEquals("", actualParameterNameConversionMap.get(""));
  }

  /**
   * Method under test:
   * {@link JSCompatibilityRequestWrapper#getParameterNameConversionMap()}
   */
  @Test
  public void testGetParameterNameConversionMap4() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("https://example.org/example", "https://example.org/example");

    // Act
    Map<String, String> actualParameterNameConversionMap = (new JSCompatibilityRequestWrapper(
        new JSCompatibilityRequestWrapper(request))).getParameterNameConversionMap();

    // Assert
    assertEquals(1, actualParameterNameConversionMap.size());
    assertEquals("https://example.org/example", actualParameterNameConversionMap.get("https://example.org/example"));
  }

  /**
   * Method under test:
   * {@link JSCompatibilityRequestWrapper#getParameterValues(String)}
   */
  @Test
  public void testGetParameterValues() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new JSCompatibilityRequestWrapper(new MockHttpServletRequest())).getParameterValues("Name"));
    assertNull((new JSCompatibilityRequestWrapper(new JSCompatibilityRequestWrapper(new MockHttpServletRequest())))
        .getParameterValues("Name"));
    assertNull((new JSCompatibilityRequestWrapper(
        new JSCompatibilityRequestWrapper(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()))))
        .getParameterValues("Name"));
  }

  /**
   * Method under test:
   * {@link JSCompatibilityRequestWrapper#getParameterValues(String)}
   */
  @Test
  public void testGetParameterValues2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("https://example.org/example", "https://example.org/example");

    // Act and Assert
    assertNull((new JSCompatibilityRequestWrapper(request)).getParameterValues("Name"));
  }

  /**
   * Method under test:
   * {@link JSCompatibilityRequestWrapper#getParameterValues(String)}
   */
  @Test
  public void testGetParameterValues3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("Name", "https://example.org/example");

    // Act and Assert
    assertArrayEquals(new String[]{"https://example.org/example"},
        (new JSCompatibilityRequestWrapper(request)).getParameterValues("Name"));
  }

  /**
   * Method under test:
   * {@link JSCompatibilityRequestWrapper#getParameterValues(String)}
   */
  @Test
  public void testGetParameterValues4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("", "https://example.org/example");

    // Act and Assert
    assertNull((new JSCompatibilityRequestWrapper(request)).getParameterValues("Name"));
  }

  /**
   * Method under test:
   * {@link JSCompatibilityRequestWrapper#getParameterValues(String)}
   */
  @Test
  public void testGetParameterValues5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("https://example.org/example", "https://example.org/example");

    // Act and Assert
    assertNull(
        (new JSCompatibilityRequestWrapper(new JSCompatibilityRequestWrapper(request))).getParameterValues("Name"));
  }

  /**
   * Method under test:
   * {@link JSCompatibilityRequestWrapper#getParameterValues(String)}
   */
  @Test
  public void testGetParameterValues6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("Name", "https://example.org/example");

    // Act and Assert
    assertArrayEquals(new String[]{"https://example.org/example"},
        (new JSCompatibilityRequestWrapper(new JSCompatibilityRequestWrapper(request))).getParameterValues("Name"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link JSCompatibilityRequestWrapper#JSCompatibilityRequestWrapper(HttpServletRequest)}
   *   <li>{@link JSCompatibilityRequestWrapper#reset()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act
    JSCompatibilityRequestWrapper actualJsCompatibilityRequestWrapper = new JSCompatibilityRequestWrapper(request);
    actualJsCompatibilityRequestWrapper.reset();

    // Assert that nothing has changed
    assertSame(request, actualJsCompatibilityRequestWrapper.getRequest());
  }
}

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
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.web.savedrequest.Enumerator;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@RunWith(MockitoJUnitRunner.class)
public class JSCompatibilityRequestWrapperDiffblueTest {
  @Mock
  private HttpServletRequest httpServletRequest;

  @InjectMocks
  private JSCompatibilityRequestWrapper jSCompatibilityRequestWrapper;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JSCompatibilityRequestWrapper#JSCompatibilityRequestWrapper(HttpServletRequest)}
   *   <li>{@link JSCompatibilityRequestWrapper#reset()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JSCompatibilityRequestWrapper.<init>(HttpServletRequest)",
      "void JSCompatibilityRequestWrapper.reset()"})
  public void testGettersAndSetters() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act
    JSCompatibilityRequestWrapper actualJsCompatibilityRequestWrapper = new JSCompatibilityRequestWrapper(request);
    actualJsCompatibilityRequestWrapper.reset();

    // Assert
    assertSame(request, actualJsCompatibilityRequestWrapper.getRequest());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getContextPath()}.
   * <p>
   * Method under test: {@link JSCompatibilityRequestWrapper#getContextPath()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getContextPath()"})
  public void testGetContextPath() {
    // Arrange, Act and Assert
    assertEquals("",
        (new JSCompatibilityRequestWrapper(
            new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()))))
            .getContextPath());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getContextPath()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSCompatibilityRequestWrapper#getContextPath()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getContextPath()"})
  public void testGetContextPath_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new JSCompatibilityRequestWrapper(new MockHttpServletRequest())).getContextPath());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getContextPath()}.
   * <ul>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSCompatibilityRequestWrapper#getContextPath()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getContextPath()"})
  public void testGetContextPath_thenReturnHttpsExampleOrgExample() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setContextPath("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example", (new JSCompatibilityRequestWrapper(request)).getContextPath());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getPathTranslated()}.
   * <p>
   * Method under test: {@link JSCompatibilityRequestWrapper#getPathTranslated()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getPathTranslated()"})
  public void testGetPathTranslated() {
    // Arrange, Act and Assert
    assertNull((new JSCompatibilityRequestWrapper(new MockHttpServletRequest())).getPathTranslated());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getPathTranslated()}.
   * <p>
   * Method under test: {@link JSCompatibilityRequestWrapper#getPathTranslated()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getPathTranslated()"})
  public void testGetPathTranslated2() {
    // Arrange, Act and Assert
    assertNull((new JSCompatibilityRequestWrapper(
        new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()))))
        .getPathTranslated());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getQueryString()}.
   * <p>
   * Method under test: {@link JSCompatibilityRequestWrapper#getQueryString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getQueryString()"})
  public void testGetQueryString() {
    // Arrange, Act and Assert
    assertNull((new JSCompatibilityRequestWrapper(
        new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()))))
        .getQueryString());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getQueryString()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSCompatibilityRequestWrapper#getQueryString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getQueryString()"})
  public void testGetQueryString_thenReturnEmptyString() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setQueryString("");

    // Act and Assert
    assertEquals("", (new JSCompatibilityRequestWrapper(request)).getQueryString());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getQueryString()}.
   * <ul>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSCompatibilityRequestWrapper#getQueryString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getQueryString()"})
  public void testGetQueryString_thenReturnHttpsExampleOrgExample() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setQueryString("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example", (new JSCompatibilityRequestWrapper(request)).getQueryString());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getQueryString()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSCompatibilityRequestWrapper#getQueryString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getQueryString()"})
  public void testGetQueryString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new JSCompatibilityRequestWrapper(new MockHttpServletRequest())).getQueryString());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getRequestURI()}.
   * <p>
   * Method under test: {@link JSCompatibilityRequestWrapper#getRequestURI()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getRequestURI()"})
  public void testGetRequestURI() {
    // Arrange, Act and Assert
    assertEquals("",
        (new JSCompatibilityRequestWrapper(
            new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()))))
            .getRequestURI());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getRequestURI()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSCompatibilityRequestWrapper#getRequestURI()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getRequestURI()"})
  public void testGetRequestURI_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new JSCompatibilityRequestWrapper(new MockHttpServletRequest())).getRequestURI());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getRequestURI()}.
   * <ul>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSCompatibilityRequestWrapper#getRequestURI()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getRequestURI()"})
  public void testGetRequestURI_thenReturnHttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example", (new JSCompatibilityRequestWrapper(
        new MockHttpServletRequest("https://example.org/example", "https://example.org/example"))).getRequestURI());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getRequestURL()}.
   * <p>
   * Method under test: {@link JSCompatibilityRequestWrapper#getRequestURL()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuffer JSCompatibilityRequestWrapper.getRequestURL()"})
  public void testGetRequestURL() {
    // Arrange, Act and Assert
    assertEquals("http://localhost",
        (new JSCompatibilityRequestWrapper(new MockHttpServletRequest())).getRequestURL().toString());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getRequestURL()}.
   * <p>
   * Method under test: {@link JSCompatibilityRequestWrapper#getRequestURL()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuffer JSCompatibilityRequestWrapper.getRequestURL()"})
  public void testGetRequestURL2() {
    // Arrange, Act and Assert
    assertEquals("http://localhost",
        (new JSCompatibilityRequestWrapper(
            new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()))))
            .getRequestURL()
            .toString());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getServletPath()}.
   * <p>
   * Method under test: {@link JSCompatibilityRequestWrapper#getServletPath()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getServletPath()"})
  public void testGetServletPath() {
    // Arrange, Act and Assert
    assertEquals("",
        (new JSCompatibilityRequestWrapper(
            new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()))))
            .getServletPath());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getServletPath()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSCompatibilityRequestWrapper#getServletPath()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getServletPath()"})
  public void testGetServletPath_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new JSCompatibilityRequestWrapper(new MockHttpServletRequest())).getServletPath());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getServletPath()}.
   * <ul>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSCompatibilityRequestWrapper#getServletPath()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getServletPath()"})
  public void testGetServletPath_thenReturnHttpsExampleOrgExample() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setServletPath("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example", (new JSCompatibilityRequestWrapper(request)).getServletPath());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameter(String)}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSCompatibilityRequestWrapper#getParameter(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getParameter(String)"})
  public void testGetParameter_thenReturnEmptyString() {
    // Arrange
    when(httpServletRequest.getParameter(Mockito.<String>any())).thenReturn("");

    // Act
    String actualParameter = jSCompatibilityRequestWrapper.getParameter("Name");

    // Assert
    verify(httpServletRequest).getParameter(eq("Name"));
    assertEquals("", actualParameter);
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameter(String)}.
   * <ul>
   *   <li>Then return {@code Parameter}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSCompatibilityRequestWrapper#getParameter(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getParameter(String)"})
  public void testGetParameter_thenReturnParameter() {
    // Arrange
    when(httpServletRequest.getParameter(Mockito.<String>any())).thenReturn("Parameter");

    // Act
    String actualParameter = jSCompatibilityRequestWrapper.getParameter("Name");

    // Assert
    verify(httpServletRequest).getParameter(eq("Name"));
    assertEquals("Parameter", actualParameter);
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameterNames()}.
   * <p>
   * Method under test: {@link JSCompatibilityRequestWrapper#getParameterNames()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Enumeration JSCompatibilityRequestWrapper.getParameterNames()"})
  public void testGetParameterNames() {
    // Arrange and Act
    Enumeration actualParameterNames = (new JSCompatibilityRequestWrapper(
        new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()))))
        .getParameterNames();

    // Assert
    assertTrue(actualParameterNames instanceof Enumerator);
    assertFalse(actualParameterNames.hasMoreElements());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameterNames()}.
   * <p>
   * Method under test: {@link JSCompatibilityRequestWrapper#getParameterNames()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Enumeration JSCompatibilityRequestWrapper.getParameterNames()"})
  public void testGetParameterNames2() {
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
   * Test {@link JSCompatibilityRequestWrapper#getParameterNames()}.
   * <p>
   * Method under test: {@link JSCompatibilityRequestWrapper#getParameterNames()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Enumeration JSCompatibilityRequestWrapper.getParameterNames()"})
  public void testGetParameterNames3() {
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
   * Test {@link JSCompatibilityRequestWrapper#getParameterNames()}.
   * <ul>
   *   <li>Then return not hasMoreElements.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSCompatibilityRequestWrapper#getParameterNames()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Enumeration JSCompatibilityRequestWrapper.getParameterNames()"})
  public void testGetParameterNames_thenReturnNotHasMoreElements() {
    // Arrange and Act
    Enumeration actualParameterNames = (new JSCompatibilityRequestWrapper(new MockHttpServletRequest()))
        .getParameterNames();

    // Assert
    assertTrue(actualParameterNames instanceof Enumerator);
    assertFalse(actualParameterNames.hasMoreElements());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameterMap()}.
   * <p>
   * Method under test: {@link JSCompatibilityRequestWrapper#getParameterMap()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map JSCompatibilityRequestWrapper.getParameterMap()"})
  public void testGetParameterMap() {
    // Arrange, Act and Assert
    assertTrue((new JSCompatibilityRequestWrapper(
        new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()))))
        .getParameterMap()
        .isEmpty());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameterMap()}.
   * <p>
   * Method under test: {@link JSCompatibilityRequestWrapper#getParameterMap()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map JSCompatibilityRequestWrapper.getParameterMap()"})
  public void testGetParameterMap2() {
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
   * Test {@link JSCompatibilityRequestWrapper#getParameterMap()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSCompatibilityRequestWrapper#getParameterMap()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map JSCompatibilityRequestWrapper.getParameterMap()"})
  public void testGetParameterMap_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new JSCompatibilityRequestWrapper(new MockHttpServletRequest())).getParameterMap().isEmpty());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameterMap()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSCompatibilityRequestWrapper#getParameterMap()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map JSCompatibilityRequestWrapper.getParameterMap()"})
  public void testGetParameterMap_thenReturnEmpty2() {
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
   * Test {@link JSCompatibilityRequestWrapper#getParameterNameConversionMap()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSCompatibilityRequestWrapper#getParameterNameConversionMap()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map JSCompatibilityRequestWrapper.getParameterNameConversionMap()"})
  public void testGetParameterNameConversionMap_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        (new JSCompatibilityRequestWrapper(new MockHttpServletRequest())).getParameterNameConversionMap().isEmpty());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameterNameConversionMap()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSCompatibilityRequestWrapper#getParameterNameConversionMap()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map JSCompatibilityRequestWrapper.getParameterNameConversionMap()"})
  public void testGetParameterNameConversionMap_thenReturnEmpty2() {
    // Arrange, Act and Assert
    assertTrue((new JSCompatibilityRequestWrapper(new JSCompatibilityRequestWrapper(new MockHttpServletRequest())))
        .getParameterNameConversionMap()
        .isEmpty());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameterNameConversionMap()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSCompatibilityRequestWrapper#getParameterNameConversionMap()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map JSCompatibilityRequestWrapper.getParameterNameConversionMap()"})
  public void testGetParameterNameConversionMap_thenReturnEmpty3() {
    // Arrange, Act and Assert
    assertTrue((new JSCompatibilityRequestWrapper(
        new JSCompatibilityRequestWrapper(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()))))
        .getParameterNameConversionMap()
        .isEmpty());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameterNameConversionMap()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSCompatibilityRequestWrapper#getParameterNameConversionMap()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map JSCompatibilityRequestWrapper.getParameterNameConversionMap()"})
  public void testGetParameterNameConversionMap_thenReturnEmptyString() {
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
   * Test {@link JSCompatibilityRequestWrapper#getParameterNameConversionMap()}.
   * <ul>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSCompatibilityRequestWrapper#getParameterNameConversionMap()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map JSCompatibilityRequestWrapper.getParameterNameConversionMap()"})
  public void testGetParameterNameConversionMap_thenReturnHttpsExampleOrgExample() {
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
   * Test {@link JSCompatibilityRequestWrapper#getParameterNameConversionMap()}.
   * <ul>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSCompatibilityRequestWrapper#getParameterNameConversionMap()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map JSCompatibilityRequestWrapper.getParameterNameConversionMap()"})
  public void testGetParameterNameConversionMap_thenReturnHttpsExampleOrgExample2() {
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
   * Test {@link JSCompatibilityRequestWrapper#getParameterValues(String)}.
   * <ul>
   *   <li>Then return array of {@link String} with {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSCompatibilityRequestWrapper#getParameterValues(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String[] JSCompatibilityRequestWrapper.getParameterValues(String)"})
  public void testGetParameterValues_thenReturnArrayOfStringWith42() {
    // Arrange
    when(httpServletRequest.getParameterValues(Mockito.<String>any())).thenReturn(new String[]{"42"});
    when(httpServletRequest.getAttribute(Mockito.<String>any())).thenReturn(new HashMap<>());

    // Act
    String[] actualParameterValues = jSCompatibilityRequestWrapper.getParameterValues("Name");

    // Assert
    verify(httpServletRequest, atLeast(1)).getAttribute(eq("requestParameterConversionMap"));
    verify(httpServletRequest).getParameterValues(eq("Name"));
    assertArrayEquals(new String[]{"42"}, actualParameterValues);
  }
}

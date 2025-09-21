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
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Mock private HttpServletRequest httpServletRequest;

  @InjectMocks private JSCompatibilityRequestWrapper jSCompatibilityRequestWrapper;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JSCompatibilityRequestWrapper#JSCompatibilityRequestWrapper(HttpServletRequest)}
   *   <li>{@link JSCompatibilityRequestWrapper#reset()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JSCompatibilityRequestWrapper.<init>(HttpServletRequest)",
    "void JSCompatibilityRequestWrapper.reset()"
  })
  public void testGettersAndSetters() {
    // Arrange
    HttpServletRequestWrapper request = new HttpServletRequestWrapper(new MockHttpServletRequest());

    // Act
    JSCompatibilityRequestWrapper actualJsCompatibilityRequestWrapper =
        new JSCompatibilityRequestWrapper(request);
    actualJsCompatibilityRequestWrapper.reset();

    // Assert
    assertSame(request, actualJsCompatibilityRequestWrapper.getRequest());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getContextPath()}.
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getContextPath()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getContextPath()"})
  public void testGetContextPath() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    HttpServletRequestWrapper request2 = new HttpServletRequestWrapper(request);

    // Act and Assert
    assertEquals("", new JSCompatibilityRequestWrapper(request2).getContextPath());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getContextPath()}.
   *
   * <ul>
   *   <li>Given {@link MockHttpServletRequest#MockHttpServletRequest()} ContextPath is {@code
   *       null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getContextPath()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getContextPath()"})
  public void testGetContextPath_givenMockHttpServletRequestContextPathIsNull_thenReturnNull() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setContextPath(null);

    // Act and Assert
    assertNull(
        new JSCompatibilityRequestWrapper(new HttpServletRequestWrapper(request)).getContextPath());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getContextPath()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getContextPath()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getContextPath()"})
  public void testGetContextPath_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals(
        "",
        new JSCompatibilityRequestWrapper(
                new HttpServletRequestWrapper(new MockHttpServletRequest()))
            .getContextPath());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getContextPath()}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getContextPath()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getContextPath()"})
  public void testGetContextPath_thenReturnHttpsExampleOrgExample() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setContextPath("https://example.org/example");

    // Act and Assert
    assertEquals(
        "https://example.org/example",
        new JSCompatibilityRequestWrapper(new HttpServletRequestWrapper(request)).getContextPath());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getPathTranslated()}.
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getPathTranslated()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getPathTranslated()"})
  public void testGetPathTranslated() {
    // Arrange, Act and Assert
    assertNull(
        new JSCompatibilityRequestWrapper(
                new HttpServletRequestWrapper(new MockHttpServletRequest()))
            .getPathTranslated());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getPathTranslated()}.
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getPathTranslated()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getPathTranslated()"})
  public void testGetPathTranslated2() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    HttpServletRequestWrapper request2 = new HttpServletRequestWrapper(request);

    // Act and Assert
    assertNull(new JSCompatibilityRequestWrapper(request2).getPathTranslated());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getQueryString()}.
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getQueryString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getQueryString()"})
  public void testGetQueryString() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    HttpServletRequestWrapper request2 = new HttpServletRequestWrapper(request);

    // Act and Assert
    assertNull(new JSCompatibilityRequestWrapper(request2).getQueryString());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getQueryString()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getQueryString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getQueryString()"})
  public void testGetQueryString_thenReturnEmptyString() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setQueryString("");

    // Act and Assert
    assertEquals(
        "",
        new JSCompatibilityRequestWrapper(new HttpServletRequestWrapper(request)).getQueryString());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getQueryString()}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getQueryString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getQueryString()"})
  public void testGetQueryString_thenReturnHttpsExampleOrgExample() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setQueryString("https://example.org/example");

    // Act and Assert
    assertEquals(
        "https://example.org/example",
        new JSCompatibilityRequestWrapper(new HttpServletRequestWrapper(request)).getQueryString());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getQueryString()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getQueryString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getQueryString()"})
  public void testGetQueryString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new JSCompatibilityRequestWrapper(
                new HttpServletRequestWrapper(new MockHttpServletRequest()))
            .getQueryString());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getRequestURI()}.
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getRequestURI()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getRequestURI()"})
  public void testGetRequestURI() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    HttpServletRequestWrapper request2 = new HttpServletRequestWrapper(request);

    // Act and Assert
    assertEquals("", new JSCompatibilityRequestWrapper(request2).getRequestURI());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getRequestURI()}.
   *
   * <ul>
   *   <li>Given {@link MockHttpServletRequest#MockHttpServletRequest()} RequestURI is {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getRequestURI()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getRequestURI()"})
  public void testGetRequestURI_givenMockHttpServletRequestRequestURIIsNull_thenReturnNull() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setRequestURI(null);

    // Act and Assert
    assertNull(
        new JSCompatibilityRequestWrapper(new HttpServletRequestWrapper(request)).getRequestURI());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getRequestURI()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getRequestURI()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getRequestURI()"})
  public void testGetRequestURI_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals(
        "",
        new JSCompatibilityRequestWrapper(
                new HttpServletRequestWrapper(new MockHttpServletRequest()))
            .getRequestURI());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getRequestURI()}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getRequestURI()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getRequestURI()"})
  public void testGetRequestURI_thenReturnHttpsExampleOrgExample() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setRequestURI("https://example.org/example");

    // Act and Assert
    assertEquals(
        "https://example.org/example",
        new JSCompatibilityRequestWrapper(new HttpServletRequestWrapper(request)).getRequestURI());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getRequestURL()}.
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getRequestURL()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"StringBuffer JSCompatibilityRequestWrapper.getRequestURL()"})
  public void testGetRequestURL() {
    // Arrange, Act and Assert
    assertEquals(
        "http://localhost",
        new JSCompatibilityRequestWrapper(
                new HttpServletRequestWrapper(new MockHttpServletRequest()))
            .getRequestURL()
            .toString());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getRequestURL()}.
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getRequestURL()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"StringBuffer JSCompatibilityRequestWrapper.getRequestURL()"})
  public void testGetRequestURL2() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    HttpServletRequestWrapper request2 = new HttpServletRequestWrapper(request);

    // Act and Assert
    assertEquals(
        "http://localhost", new JSCompatibilityRequestWrapper(request2).getRequestURL().toString());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getServletPath()}.
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getServletPath()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getServletPath()"})
  public void testGetServletPath() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    HttpServletRequestWrapper request2 = new HttpServletRequestWrapper(request);

    // Act and Assert
    assertEquals("", new JSCompatibilityRequestWrapper(request2).getServletPath());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getServletPath()}.
   *
   * <ul>
   *   <li>Given {@link MockHttpServletRequest#MockHttpServletRequest()} ServletPath is {@code
   *       null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getServletPath()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getServletPath()"})
  public void testGetServletPath_givenMockHttpServletRequestServletPathIsNull_thenReturnNull() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setServletPath(null);

    // Act and Assert
    assertNull(
        new JSCompatibilityRequestWrapper(new HttpServletRequestWrapper(request)).getServletPath());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getServletPath()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getServletPath()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getServletPath()"})
  public void testGetServletPath_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals(
        "",
        new JSCompatibilityRequestWrapper(
                new HttpServletRequestWrapper(new MockHttpServletRequest()))
            .getServletPath());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getServletPath()}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getServletPath()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getServletPath()"})
  public void testGetServletPath_thenReturnHttpsExampleOrgExample() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setServletPath("https://example.org/example");

    // Act and Assert
    assertEquals(
        "https://example.org/example",
        new JSCompatibilityRequestWrapper(new HttpServletRequestWrapper(request)).getServletPath());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameter(String)}.
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getParameter(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getParameter(String)"})
  public void testGetParameter() {
    // Arrange, Act and Assert
    assertNull(
        new JSCompatibilityRequestWrapper(
                new HttpServletRequestWrapper(new MockHttpServletRequest()))
            .getParameter("Name"));
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameter(String)}.
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getParameter(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getParameter(String)"})
  public void testGetParameter2() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    HttpServletRequestWrapper request2 = new HttpServletRequestWrapper(request);

    // Act and Assert
    assertNull(new JSCompatibilityRequestWrapper(request2).getParameter("Name"));
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameter(String)}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getParameter(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getParameter(String)"})
  public void testGetParameter_thenReturnEmptyString() {
    // Arrange
    when(httpServletRequest.getParameter(Mockito.<String>any())).thenReturn("");

    // Act
    String actualParameter = jSCompatibilityRequestWrapper.getParameter("Name");

    // Assert
    verify(httpServletRequest).getParameter("Name");
    assertEquals("", actualParameter);
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameter(String)}.
   *
   * <ul>
   *   <li>Then return {@code Parameter}.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getParameter(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getParameter(String)"})
  public void testGetParameter_thenReturnParameter() {
    // Arrange
    when(httpServletRequest.getParameter(Mockito.<String>any())).thenReturn("Parameter");

    // Act
    String actualParameter = jSCompatibilityRequestWrapper.getParameter("Name");

    // Assert
    verify(httpServletRequest).getParameter("Name");
    assertEquals("Parameter", actualParameter);
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameterNames()}.
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getParameterNames()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Enumeration JSCompatibilityRequestWrapper.getParameterNames()"})
  public void testGetParameterNames() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    HttpServletRequestWrapper request2 = new HttpServletRequestWrapper(request);

    // Act
    Enumeration actualParameterNames =
        new JSCompatibilityRequestWrapper(request2).getParameterNames();

    // Assert
    assertTrue(actualParameterNames instanceof Enumerator);
    assertFalse(actualParameterNames.hasMoreElements());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameterNames()}.
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getParameterNames()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Enumeration JSCompatibilityRequestWrapper.getParameterNames()"})
  public void testGetParameterNames2() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("https://example.org/example", "https://example.org/example");

    // Act
    Enumeration actualParameterNames =
        new JSCompatibilityRequestWrapper(new HttpServletRequestWrapper(request))
            .getParameterNames();

    // Assert
    assertTrue(actualParameterNames instanceof Enumerator);
    assertTrue(actualParameterNames.hasMoreElements());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameterNames()}.
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getParameterNames()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Enumeration JSCompatibilityRequestWrapper.getParameterNames()"})
  public void testGetParameterNames3() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("", "https://example.org/example");

    // Act
    Enumeration actualParameterNames =
        new JSCompatibilityRequestWrapper(new HttpServletRequestWrapper(request))
            .getParameterNames();

    // Assert
    assertTrue(actualParameterNames instanceof Enumerator);
    assertTrue(actualParameterNames.hasMoreElements());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameterNames()}.
   *
   * <ul>
   *   <li>Then return not hasMoreElements.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getParameterNames()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Enumeration JSCompatibilityRequestWrapper.getParameterNames()"})
  public void testGetParameterNames_thenReturnNotHasMoreElements() {
    // Arrange and Act
    Enumeration actualParameterNames =
        new JSCompatibilityRequestWrapper(
                new HttpServletRequestWrapper(new MockHttpServletRequest()))
            .getParameterNames();

    // Assert
    assertTrue(actualParameterNames instanceof Enumerator);
    assertFalse(actualParameterNames.hasMoreElements());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameterMap()}.
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getParameterMap()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JSCompatibilityRequestWrapper.getParameterMap()"})
  public void testGetParameterMap() {
    // Arrange, Act and Assert
    assertTrue(
        new JSCompatibilityRequestWrapper(
                new HttpServletRequestWrapper(new MockHttpServletRequest()))
            .getParameterMap()
            .isEmpty());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameterMap()}.
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getParameterMap()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JSCompatibilityRequestWrapper.getParameterMap()"})
  public void testGetParameterMap2() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    HttpServletRequestWrapper request2 = new HttpServletRequestWrapper(request);

    // Act and Assert
    assertTrue(new JSCompatibilityRequestWrapper(request2).getParameterMap().isEmpty());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameterMap()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getParameterMap()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JSCompatibilityRequestWrapper.getParameterMap()"})
  public void testGetParameterMap_thenReturnEmpty() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    LinkedMultiValueMap<String, MultipartFile> mpFiles = new LinkedMultiValueMap<>();
    HashMap<String, String[]> mpParams = new HashMap<>();

    DefaultMultipartHttpServletRequest request2 =
        new DefaultMultipartHttpServletRequest(request, mpFiles, mpParams, new HashMap<>());

    // Act and Assert
    assertTrue(
        new JSCompatibilityRequestWrapper(new HttpServletRequestWrapper(request2))
            .getParameterMap()
            .isEmpty());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameterMap()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getParameterMap()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JSCompatibilityRequestWrapper.getParameterMap()"})
  public void testGetParameterMap_thenReturnEmpty2() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    HttpServletRequestWrapper request3 = new HttpServletRequestWrapper(request2);
    LinkedMultiValueMap<String, MultipartFile> mpFiles = new LinkedMultiValueMap<>();
    HashMap<String, String[]> mpParams = new HashMap<>();

    DefaultMultipartHttpServletRequest request4 =
        new DefaultMultipartHttpServletRequest(request3, mpFiles, mpParams, new HashMap<>());

    // Act and Assert
    assertTrue(
        new JSCompatibilityRequestWrapper(new HttpServletRequestWrapper(request4))
            .getParameterMap()
            .isEmpty());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameterNameConversionMap()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getParameterNameConversionMap()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JSCompatibilityRequestWrapper.getParameterNameConversionMap()"})
  public void testGetParameterNameConversionMap_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        new JSCompatibilityRequestWrapper(
                new HttpServletRequestWrapper(new MockHttpServletRequest()))
            .getParameterNameConversionMap()
            .isEmpty());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameterNameConversionMap()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getParameterNameConversionMap()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JSCompatibilityRequestWrapper.getParameterNameConversionMap()"})
  public void testGetParameterNameConversionMap_thenReturnEmpty2() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    HttpServletRequestWrapper request2 = new HttpServletRequestWrapper(request);

    // Act and Assert
    assertTrue(
        new JSCompatibilityRequestWrapper(request2).getParameterNameConversionMap().isEmpty());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameterNameConversionMap()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getParameterNameConversionMap()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JSCompatibilityRequestWrapper.getParameterNameConversionMap()"})
  public void testGetParameterNameConversionMap_thenReturnEmpty3() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    HttpServletRequestWrapper request3 = new HttpServletRequestWrapper(request2);
    HttpServletRequestWrapper request4 = new HttpServletRequestWrapper(request3);

    // Act and Assert
    assertTrue(
        new JSCompatibilityRequestWrapper(request4).getParameterNameConversionMap().isEmpty());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameterNameConversionMap()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getParameterNameConversionMap()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JSCompatibilityRequestWrapper.getParameterNameConversionMap()"})
  public void testGetParameterNameConversionMap_thenReturnEmptyString() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("", "https://example.org/example");

    // Act
    Map<String, String> actualParameterNameConversionMap =
        new JSCompatibilityRequestWrapper(new HttpServletRequestWrapper(request))
            .getParameterNameConversionMap();

    // Assert
    assertEquals(1, actualParameterNameConversionMap.size());
    assertEquals("", actualParameterNameConversionMap.get(""));
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameterNameConversionMap()}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getParameterNameConversionMap()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JSCompatibilityRequestWrapper.getParameterNameConversionMap()"})
  public void testGetParameterNameConversionMap_thenReturnHttpsExampleOrgExample() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("https://example.org/example", "https://example.org/example");

    // Act
    Map<String, String> actualParameterNameConversionMap =
        new JSCompatibilityRequestWrapper(new HttpServletRequestWrapper(request))
            .getParameterNameConversionMap();

    // Assert
    assertEquals(1, actualParameterNameConversionMap.size());
    assertEquals(
        "https://example.org/example",
        actualParameterNameConversionMap.get("https://example.org/example"));
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameterNameConversionMap()}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getParameterNameConversionMap()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JSCompatibilityRequestWrapper.getParameterNameConversionMap()"})
  public void testGetParameterNameConversionMap_thenReturnHttpsExampleOrgExample2() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("https://example.org/example", "https://example.org/example");
    HttpServletRequestWrapper request2 =
        new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(request));
    HttpServletRequestWrapper request3 = new HttpServletRequestWrapper(request2);

    // Act
    Map<String, String> actualParameterNameConversionMap =
        new JSCompatibilityRequestWrapper(request3).getParameterNameConversionMap();

    // Assert
    assertEquals(1, actualParameterNameConversionMap.size());
    assertEquals(
        "https://example.org/example",
        actualParameterNameConversionMap.get("https://example.org/example"));
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameterValues(String)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code 42} is {@code 42}.
   *   <li>When {@code 42}.
   *   <li>Then return array of {@link String} with {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getParameterValues(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] JSCompatibilityRequestWrapper.getParameterValues(String)"})
  public void testGetParameterValues_givenHashMap42Is42_when42_thenReturnArrayOfStringWith42() {
    // Arrange
    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    objectObjectMap.put("42", "42");
    when(httpServletRequest.getParameterValues(Mockito.<String>any()))
        .thenReturn(new String[] {"42"});
    when(httpServletRequest.getAttribute(Mockito.<String>any())).thenReturn(objectObjectMap);

    // Act
    String[] actualParameterValues = jSCompatibilityRequestWrapper.getParameterValues("42");

    // Assert
    verify(httpServletRequest, atLeast(1)).getAttribute("requestParameterConversionMap");
    verify(httpServletRequest).getParameterValues("42");
    assertArrayEquals(new String[] {"42"}, actualParameterValues);
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameterValues(String)}.
   *
   * <ul>
   *   <li>Then return array of {@link String} with {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getParameterValues(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] JSCompatibilityRequestWrapper.getParameterValues(String)"})
  public void testGetParameterValues_thenReturnArrayOfStringWith42() {
    // Arrange
    when(httpServletRequest.getParameterValues(Mockito.<String>any()))
        .thenReturn(new String[] {"42"});
    when(httpServletRequest.getAttribute(Mockito.<String>any())).thenReturn(new HashMap<>());

    // Act
    String[] actualParameterValues = jSCompatibilityRequestWrapper.getParameterValues("Name");

    // Assert
    verify(httpServletRequest, atLeast(1)).getAttribute("requestParameterConversionMap");
    verify(httpServletRequest).getParameterValues("Name");
    assertArrayEquals(new String[] {"42"}, actualParameterValues);
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameterValues(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getParameterValues(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] JSCompatibilityRequestWrapper.getParameterValues(String)"})
  public void testGetParameterValues_thenReturnNull() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    HttpServletRequestWrapper request2 = new HttpServletRequestWrapper(request);

    // Act and Assert
    assertNull(new JSCompatibilityRequestWrapper(request2).getParameterValues("Name"));
  }
}

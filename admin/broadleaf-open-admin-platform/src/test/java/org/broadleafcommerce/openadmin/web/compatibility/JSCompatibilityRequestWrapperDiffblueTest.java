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
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.web.savedrequest.Enumerator;

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
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act
    JSCompatibilityRequestWrapper actualJsCompatibilityRequestWrapper =
        new JSCompatibilityRequestWrapper(request);
    actualJsCompatibilityRequestWrapper.reset();

    // Assert
    ServletRequest request2 = actualJsCompatibilityRequestWrapper.getRequest();
    assertTrue(request2 instanceof MockHttpServletRequest);
    assertSame(request, request2);
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
    // Arrange, Act and Assert
    assertEquals(
        "", new JSCompatibilityRequestWrapper(new MockHttpServletRequest()).getContextPath());
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
    assertNull(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()).getPathTranslated());
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
    assertEquals("", new JSCompatibilityRequestWrapper(request).getQueryString());
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
    assertNull(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()).getQueryString());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getQueryString()}.
   *
   * <ul>
   *   <li>Then return {@code Query String}.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getQueryString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getQueryString()"})
  public void testGetQueryString_thenReturnQueryString() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setQueryString("Query String");

    // Act and Assert
    assertEquals("Query String", new JSCompatibilityRequestWrapper(request).getQueryString());
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
    // Arrange, Act and Assert
    assertEquals(
        "", new JSCompatibilityRequestWrapper(new MockHttpServletRequest()).getRequestURI());
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
        new JSCompatibilityRequestWrapper(new MockHttpServletRequest()).getRequestURL().toString());
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
    // Arrange, Act and Assert
    assertEquals(
        "", new JSCompatibilityRequestWrapper(new MockHttpServletRequest()).getServletPath());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameter(String)}.
   *
   * <ul>
   *   <li>Given {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@code Name}
   *       and {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getParameter(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getParameter(String)"})
  public void testGetParameter_givenMockHttpServletRequestAddParameterNameAnd42_thenReturn42() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("Name", "42");

    // Act and Assert
    assertEquals("42", new JSCompatibilityRequestWrapper(request).getParameter("Name"));
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("Name", "");

    // Act and Assert
    assertEquals("", new JSCompatibilityRequestWrapper(request).getParameter("Name"));
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameter(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getParameter(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JSCompatibilityRequestWrapper.getParameter(String)"})
  public void testGetParameter_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new JSCompatibilityRequestWrapper(new MockHttpServletRequest()).getParameter("Name"));
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameterNames()}.
   *
   * <ul>
   *   <li>Given {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter empty string
   *       and {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getParameterNames()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Enumeration JSCompatibilityRequestWrapper.getParameterNames()"})
  public void testGetParameterNames_givenMockHttpServletRequestAddParameterEmptyStringAnd42() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("", "42");

    // Act
    Enumeration actualParameterNames =
        new JSCompatibilityRequestWrapper(request).getParameterNames();

    // Assert
    assertTrue(actualParameterNames instanceof Enumerator);
    assertTrue(actualParameterNames.hasMoreElements());
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameterNames()}.
   *
   * <ul>
   *   <li>Given {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@code Name}
   *       and {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getParameterNames()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Enumeration JSCompatibilityRequestWrapper.getParameterNames()"})
  public void testGetParameterNames_givenMockHttpServletRequestAddParameterNameAnd42() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("Name", "42");

    // Act
    Enumeration actualParameterNames =
        new JSCompatibilityRequestWrapper(request).getParameterNames();

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
        new JSCompatibilityRequestWrapper(new MockHttpServletRequest()).getParameterNames();

    // Assert
    assertTrue(actualParameterNames instanceof Enumerator);
    assertFalse(actualParameterNames.hasMoreElements());
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
    // Arrange, Act and Assert
    assertTrue(
        new JSCompatibilityRequestWrapper(new MockHttpServletRequest())
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
        new JSCompatibilityRequestWrapper(new MockHttpServletRequest())
            .getParameterNameConversionMap()
            .isEmpty());
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
    request.addParameter("", "42");

    // Act
    Map<String, String> actualParameterNameConversionMap =
        new JSCompatibilityRequestWrapper(request).getParameterNameConversionMap();

    // Assert
    assertEquals(1, actualParameterNameConversionMap.size());
    assertEquals("", actualParameterNameConversionMap.get(""));
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameterNameConversionMap()}.
   *
   * <ul>
   *   <li>Then return {@code requestParameterConversionMap}.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getParameterNameConversionMap()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JSCompatibilityRequestWrapper.getParameterNameConversionMap()"})
  public void testGetParameterNameConversionMap_thenReturnRequestParameterConversionMap() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("requestParameterConversionMap", "42");

    // Act
    Map<String, String> actualParameterNameConversionMap =
        new JSCompatibilityRequestWrapper(request).getParameterNameConversionMap();

    // Assert
    assertEquals(1, actualParameterNameConversionMap.size());
    assertEquals(
        "requestParameterConversionMap",
        actualParameterNameConversionMap.get("requestParameterConversionMap"));
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameterValues(String)}.
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getParameterValues(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] JSCompatibilityRequestWrapper.getParameterValues(String)"})
  public void testGetParameterValues() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("requestParameterConversionMap", "42");

    // Act and Assert
    assertNull(new JSCompatibilityRequestWrapper(request).getParameterValues("Name"));
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameterValues(String)}.
   *
   * <ul>
   *   <li>Given {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter empty string
   *       and {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getParameterValues(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] JSCompatibilityRequestWrapper.getParameterValues(String)"})
  public void testGetParameterValues_givenMockHttpServletRequestAddParameterEmptyStringAnd42() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("", "42");

    // Act and Assert
    assertNull(new JSCompatibilityRequestWrapper(request).getParameterValues("Name"));
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameterValues(String)}.
   *
   * <ul>
   *   <li>Given {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@code Name}
   *       and {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getParameterValues(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] JSCompatibilityRequestWrapper.getParameterValues(String)"})
  public void testGetParameterValues_givenMockHttpServletRequestAddParameterNameAnd42() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("Name", "42");

    // Act and Assert
    assertArrayEquals(
        new String[] {"42"}, new JSCompatibilityRequestWrapper(request).getParameterValues("Name"));
  }

  /**
   * Test {@link JSCompatibilityRequestWrapper#getParameterValues(String)}.
   *
   * <ul>
   *   <li>Then calls {@link HttpServletRequest#getAttribute(String)}.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityRequestWrapper#getParameterValues(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] JSCompatibilityRequestWrapper.getParameterValues(String)"})
  public void testGetParameterValues_thenCallsGetAttribute() {
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
    // Arrange, Act and Assert
    assertNull(
        new JSCompatibilityRequestWrapper(new MockHttpServletRequest()).getParameterValues("Name"));
  }
}

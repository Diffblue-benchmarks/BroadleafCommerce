package org.broadleafcommerce.core.web.security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import javax.servlet.DispatcherType;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;

public class XssRequestWrapperDiffblueTest {
  /**
   * Test {@link XssRequestWrapper#XssRequestWrapper(HttpServletRequest, Environment, String[])}.
   *
   * <p>Method under test: {@link XssRequestWrapper#XssRequestWrapper(HttpServletRequest,
   * Environment, String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void XssRequestWrapper.<init>(HttpServletRequest, Environment, String[])"})
  public void testNewXssRequestWrapper() throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    String[] whiteListParamNames = new String[] {"White List Param Names"};

    // Act
    XssRequestWrapper actualXssRequestWrapper =
        new XssRequestWrapper(
            servletRequest, new StandardReactiveWebEnvironment(), whiteListParamNames);

    // Assert
    Collection<Part> parts = actualXssRequestWrapper.getParts();
    assertTrue(parts instanceof List);
    assertTrue(actualXssRequestWrapper.environment instanceof StandardReactiveWebEnvironment);
    ServletRequest request = actualXssRequestWrapper.getRequest();
    assertTrue(request instanceof MockHttpServletRequest);
    assertTrue(actualXssRequestWrapper.getSession() instanceof MockHttpSession);
    assertTrue(actualXssRequestWrapper.getServletContext() instanceof MockServletContext);
    assertEquals("", actualXssRequestWrapper.getContextPath());
    assertEquals("", actualXssRequestWrapper.getMethod());
    assertEquals("", actualXssRequestWrapper.getRequestURI());
    assertEquals("", actualXssRequestWrapper.getServletPath());
    assertEquals("HTTP/1.1", actualXssRequestWrapper.getProtocol());
    assertEquals("http", actualXssRequestWrapper.getScheme());
    assertEquals("localhost", actualXssRequestWrapper.getLocalName());
    assertEquals("localhost", actualXssRequestWrapper.getRemoteHost());
    assertEquals("localhost", actualXssRequestWrapper.getServerName());
    assertNull(actualXssRequestWrapper.getCharacterEncoding());
    assertNull(actualXssRequestWrapper.getContentType());
    assertNull(actualXssRequestWrapper.getAuthType());
    assertNull(actualXssRequestWrapper.getPathInfo());
    assertNull(actualXssRequestWrapper.getPathTranslated());
    assertNull(actualXssRequestWrapper.getQueryString());
    assertNull(actualXssRequestWrapper.getRemoteUser());
    assertNull(actualXssRequestWrapper.getRequestedSessionId());
    assertNull(actualXssRequestWrapper.getUserPrincipal());
    assertNull(actualXssRequestWrapper.getAsyncContext());
    assertNull(actualXssRequestWrapper.getCookies());
    assertEquals(-1, actualXssRequestWrapper.getContentLength());
    assertEquals(-1L, actualXssRequestWrapper.getContentLengthLong());
    assertEquals(80, actualXssRequestWrapper.getLocalPort());
    assertEquals(80, actualXssRequestWrapper.getRemotePort());
    assertEquals(80, actualXssRequestWrapper.getServerPort());
    assertEquals(DispatcherType.REQUEST, actualXssRequestWrapper.getDispatcherType());
    assertFalse(actualXssRequestWrapper.isAsyncStarted());
    assertFalse(actualXssRequestWrapper.isAsyncSupported());
    assertFalse(actualXssRequestWrapper.isSecure());
    assertFalse(actualXssRequestWrapper.customStripXssEnabled);
    assertTrue(parts.isEmpty());
    assertTrue(actualXssRequestWrapper.getParameterMap().isEmpty());
    assertTrue(actualXssRequestWrapper.getTrailerFields().isEmpty());
    assertSame(servletRequest, request);
  }

  /**
   * Test {@link XssRequestWrapper#getParameterValues(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XssRequestWrapper#getParameterValues(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] XssRequestWrapper.getParameterValues(String)"})
  public void testGetParameterValues_whenNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    String[] whiteListParamNames = new String[] {"White List Param Names"};

    XssRequestWrapper xssRequestWrapper =
        new XssRequestWrapper(
            servletRequest, new StandardReactiveWebEnvironment(), whiteListParamNames);

    // Act and Assert
    assertNull(xssRequestWrapper.getParameterValues(null));
  }

  /**
   * Test {@link XssRequestWrapper#getParameterValues(String)}.
   *
   * <ul>
   *   <li>When {@code Parameter}.
   * </ul>
   *
   * <p>Method under test: {@link XssRequestWrapper#getParameterValues(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] XssRequestWrapper.getParameterValues(String)"})
  public void testGetParameterValues_whenParameter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    String[] whiteListParamNames = new String[] {"White List Param Names"};

    XssRequestWrapper xssRequestWrapper =
        new XssRequestWrapper(
            servletRequest, new StandardReactiveWebEnvironment(), whiteListParamNames);

    // Act and Assert
    assertNull(xssRequestWrapper.getParameterValues("Parameter"));
  }

  /**
   * Test {@link XssRequestWrapper#checkWhitelist(String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link XssRequestWrapper#checkWhitelist(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean XssRequestWrapper.checkWhitelist(String)"})
  public void testCheckWhitelist_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    String[] whiteListParamNames = new String[] {"White List Param Names"};

    XssRequestWrapper xssRequestWrapper =
        new XssRequestWrapper(
            servletRequest, new StandardReactiveWebEnvironment(), whiteListParamNames);

    // Act and Assert
    assertFalse(xssRequestWrapper.checkWhitelist("Parameter"));
  }

  /**
   * Test {@link XssRequestWrapper#checkWhitelist(String)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link XssRequestWrapper#checkWhitelist(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean XssRequestWrapper.checkWhitelist(String)"})
  public void testCheckWhitelist_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    XssRequestWrapper xssRequestWrapper =
        new XssRequestWrapper(
            servletRequest,
            new StandardReactiveWebEnvironment(),
            new String[] {"White List Param Names", "Parameter"});

    // Act and Assert
    assertTrue(xssRequestWrapper.checkWhitelist("Parameter"));
  }

  /**
   * Test {@link XssRequestWrapper#getParameter(String)}.
   *
   * <p>Method under test: {@link XssRequestWrapper#getParameter(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String XssRequestWrapper.getParameter(String)"})
  public void testGetParameter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    String[] whiteListParamNames = new String[] {"White List Param Names"};

    XssRequestWrapper xssRequestWrapper =
        new XssRequestWrapper(
            servletRequest, new StandardReactiveWebEnvironment(), whiteListParamNames);

    // Act and Assert
    assertNull(xssRequestWrapper.getParameter("Parameter"));
  }

  /**
   * Test {@link XssRequestWrapper#getParameter(String)}.
   *
   * <p>Method under test: {@link XssRequestWrapper#getParameter(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String XssRequestWrapper.getParameter(String)"})
  public void testGetParameter2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    XssRequestWrapper xssRequestWrapper =
        new XssRequestWrapper(
            servletRequest,
            new StandardReactiveWebEnvironment(),
            new String[] {"White List Param Names", "Parameter"});

    // Act and Assert
    assertNull(xssRequestWrapper.getParameter("Parameter"));
  }

  /**
   * Test {@link XssRequestWrapper#getParameter(String)}.
   *
   * <ul>
   *   <li>Given {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@code White
   *       List Param Names} and {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link XssRequestWrapper#getParameter(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String XssRequestWrapper.getParameter(String)"})
  public void testGetParameter_givenMockHttpServletRequestAddParameterWhiteListParamNamesAnd42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    servletRequest.addParameter("White List Param Names", "42");
    String[] whiteListParamNames = new String[] {"White List Param Names"};

    XssRequestWrapper xssRequestWrapper =
        new XssRequestWrapper(
            servletRequest, new StandardReactiveWebEnvironment(), whiteListParamNames);

    // Act and Assert
    assertNull(xssRequestWrapper.getParameter("Parameter"));
  }

  /**
   * Test {@link XssRequestWrapper#getParameter(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XssRequestWrapper#getParameter(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String XssRequestWrapper.getParameter(String)"})
  public void testGetParameter_whenNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    String[] whiteListParamNames = new String[] {"White List Param Names"};

    XssRequestWrapper xssRequestWrapper =
        new XssRequestWrapper(
            servletRequest, new StandardReactiveWebEnvironment(), whiteListParamNames);

    // Act and Assert
    assertNull(xssRequestWrapper.getParameter(null));
  }

  /**
   * Test {@link XssRequestWrapper#stripXss(String, String)} with {@code value}, {@code
   * esapiInputType}.
   *
   * <ul>
   *   <li>When {@code BroadleafHttpParameterValue}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link XssRequestWrapper#stripXss(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String XssRequestWrapper.stripXss(String, String)"})
  public void testStripXssWithValueEsapiInputType_whenBroadleafHttpParameterValue_thenReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    String[] whiteListParamNames = new String[] {"White List Param Names"};

    XssRequestWrapper xssRequestWrapper =
        new XssRequestWrapper(
            servletRequest, new StandardReactiveWebEnvironment(), whiteListParamNames);

    // Act and Assert
    assertEquals("42", xssRequestWrapper.stripXss("42", "BroadleafHttpParameterValue"));
  }

  /**
   * Test {@link XssRequestWrapper#customStripXss(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link XssRequestWrapper#customStripXss(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String XssRequestWrapper.customStripXss(String)"})
  public void testCustomStripXss_when42_thenReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    String[] whiteListParamNames = new String[] {"White List Param Names"};

    XssRequestWrapper xssRequestWrapper =
        new XssRequestWrapper(
            servletRequest, new StandardReactiveWebEnvironment(), whiteListParamNames);

    // Act and Assert
    assertEquals("42", xssRequestWrapper.customStripXss("42"));
  }

  /**
   * Test {@link XssRequestWrapper#customStripXss(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XssRequestWrapper#customStripXss(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String XssRequestWrapper.customStripXss(String)"})
  public void testCustomStripXss_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    String[] whiteListParamNames = new String[] {"White List Param Names"};

    XssRequestWrapper xssRequestWrapper =
        new XssRequestWrapper(
            servletRequest, new StandardReactiveWebEnvironment(), whiteListParamNames);

    // Act and Assert
    assertNull(xssRequestWrapper.customStripXss(null));
  }

  /**
   * Test {@link XssRequestWrapper#stripXssWithESAPI(String, String)}.
   *
   * <ul>
   *   <li>When {@code BroadleafHttpParameterValue}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link XssRequestWrapper#stripXssWithESAPI(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String XssRequestWrapper.stripXssWithESAPI(String, String)"})
  public void testStripXssWithESAPI_whenBroadleafHttpParameterValue_thenReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    String[] whiteListParamNames = new String[] {"White List Param Names"};

    XssRequestWrapper xssRequestWrapper =
        new XssRequestWrapper(
            servletRequest, new StandardReactiveWebEnvironment(), whiteListParamNames);

    // Act and Assert
    assertEquals("42", xssRequestWrapper.stripXssWithESAPI("42", "BroadleafHttpParameterValue"));
  }
}

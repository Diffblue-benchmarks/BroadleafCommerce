package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

public class BLCRequestUtilsDiffblueTest {
  /**
   * Test {@link BLCRequestUtils#isOKtoUseSession(WebRequest)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BLCRequestUtils#isOKtoUseSession(WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BLCRequestUtils.isOKtoUseSession(WebRequest)"})
  public void testIsOKtoUseSession_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        BLCRequestUtils.isOKtoUseSession(new ServletWebRequest(new MockHttpServletRequest())));
  }

  /**
   * Test {@link BLCRequestUtils#isFilteringIgnoredForUri(WebRequest)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BLCRequestUtils#isFilteringIgnoredForUri(WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BLCRequestUtils.isFilteringIgnoredForUri(WebRequest)"})
  public void testIsFilteringIgnoredForUri_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        BLCRequestUtils.isFilteringIgnoredForUri(
            new ServletWebRequest(new MockHttpServletRequest())));
  }

  /**
   * Test {@link BLCRequestUtils#getSessionAttributeIfOk(WebRequest, String)}.
   *
   * <p>Method under test: {@link BLCRequestUtils#getSessionAttributeIfOk(WebRequest, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object BLCRequestUtils.getSessionAttributeIfOk(WebRequest, String)"})
  public void testGetSessionAttributeIfOk() {
    // Arrange, Act and Assert
    assertNull(
        BLCRequestUtils.getSessionAttributeIfOk(
            new ServletWebRequest(new MockHttpServletRequest()), "Attribute"));
  }

  /**
   * Test {@link BLCRequestUtils#getSessionAttributeIfOk(WebRequest, String)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link WebRequest} {@link WebRequest#getAttribute(String, int)} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link BLCRequestUtils#getSessionAttributeIfOk(WebRequest, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object BLCRequestUtils.getSessionAttributeIfOk(WebRequest, String)"})
  public void testGetSessionAttributeIfOk_givenFalse_whenWebRequestGetAttributeReturnFalse() {
    // Arrange
    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(false);

    // Act
    Object actualSessionAttributeIfOk =
        BLCRequestUtils.getSessionAttributeIfOk(request, "Attribute");

    // Assert
    verify(request).getAttribute("blOkToUseSession", 0);
    assertNull(actualSessionAttributeIfOk);
  }

  /**
   * Test {@link BLCRequestUtils#getSessionAttributeIfOk(WebRequest, String)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BLCRequestUtils#getSessionAttributeIfOk(WebRequest, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object BLCRequestUtils.getSessionAttributeIfOk(WebRequest, String)"})
  public void testGetSessionAttributeIfOk_givenTrue_thenReturnTrue() {
    // Arrange
    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(true);

    // Act
    Object actualSessionAttributeIfOk =
        BLCRequestUtils.getSessionAttributeIfOk(request, "Attribute");

    // Assert
    verify(request, atLeast(1)).getAttribute(Mockito.<String>any(), anyInt());
    assertTrue((Boolean) actualSessionAttributeIfOk);
  }

  /**
   * Test {@link BLCRequestUtils#setSessionAttributeIfOk(WebRequest, String, Object)}.
   *
   * <p>Method under test: {@link BLCRequestUtils#setSessionAttributeIfOk(WebRequest, String,
   * Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BLCRequestUtils.setSessionAttributeIfOk(WebRequest, String, Object)"})
  public void testSetSessionAttributeIfOk() {
    // Arrange
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act
    boolean actualSetSessionAttributeIfOkResult =
        BLCRequestUtils.setSessionAttributeIfOk(request, "Attribute", BLCFieldUtils.NULL_FIELD);

    // Assert
    Object sessionMutex = request.getSessionMutex();
    assertTrue(sessionMutex instanceof MockHttpSession);
    assertTrue(actualSetSessionAttributeIfOkResult);
    assertArrayEquals(new String[] {"Attribute"}, ((MockHttpSession) sessionMutex).getValueNames());
  }

  /**
   * Test {@link BLCRequestUtils#setSessionAttributeIfOk(WebRequest, String, Object)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BLCRequestUtils#setSessionAttributeIfOk(WebRequest, String,
   * Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BLCRequestUtils.setSessionAttributeIfOk(WebRequest, String, Object)"})
  public void testSetSessionAttributeIfOk_givenFalse_thenReturnFalse() {
    // Arrange
    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(false);

    // Act
    boolean actualSetSessionAttributeIfOkResult =
        BLCRequestUtils.setSessionAttributeIfOk(request, "Attribute", BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(request).getAttribute("blOkToUseSession", 0);
    assertFalse(actualSetSessionAttributeIfOkResult);
  }

  /**
   * Test {@link BLCRequestUtils#setSessionAttributeIfOk(WebRequest, String, Object)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then calls {@link WebRequest#setAttribute(String, Object, int)}.
   * </ul>
   *
   * <p>Method under test: {@link BLCRequestUtils#setSessionAttributeIfOk(WebRequest, String,
   * Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BLCRequestUtils.setSessionAttributeIfOk(WebRequest, String, Object)"})
  public void testSetSessionAttributeIfOk_givenTrue_thenCallsSetAttribute() {
    // Arrange
    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(true);
    doNothing().when(request).setAttribute(Mockito.<String>any(), Mockito.<Object>any(), anyInt());

    // Act
    boolean actualSetSessionAttributeIfOkResult =
        BLCRequestUtils.setSessionAttributeIfOk(request, "Attribute", BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(request).getAttribute("blOkToUseSession", 0);
    verify(request).setAttribute(eq("Attribute"), isA(Object.class), eq(1));
    assertTrue(actualSetSessionAttributeIfOkResult);
  }

  /**
   * Test {@link BLCRequestUtils#getURLorHeaderParameter(WebRequest, String)}.
   *
   * <ul>
   *   <li>Given {@code Header}.
   *   <li>Then return {@code Header}.
   * </ul>
   *
   * <p>Method under test: {@link BLCRequestUtils#getURLorHeaderParameter(WebRequest, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCRequestUtils.getURLorHeaderParameter(WebRequest, String)"})
  public void testGetURLorHeaderParameter_givenHeader_thenReturnHeader() {
    // Arrange
    ServletWebRequest request = mock(ServletWebRequest.class);
    when(request.getHeader(Mockito.<String>any())).thenReturn("Header");

    // Act
    String actualURLorHeaderParameter =
        BLCRequestUtils.getURLorHeaderParameter(request, "https://example.org/example");

    // Assert
    verify(request).getHeader("https://example.org/example");
    assertEquals("Header", actualURLorHeaderParameter);
  }

  /**
   * Test {@link BLCRequestUtils#getURLorHeaderParameter(WebRequest, String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BLCRequestUtils#getURLorHeaderParameter(WebRequest, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCRequestUtils.getURLorHeaderParameter(WebRequest, String)"})
  public void testGetURLorHeaderParameter_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        BLCRequestUtils.getURLorHeaderParameter(
            new ServletWebRequest(new MockHttpServletRequest()), "https://example.org/example"));
  }

  /**
   * Test {@link BLCRequestUtils#getRequestURIWithoutContext(HttpServletRequest)}.
   *
   * <p>Method under test: {@link BLCRequestUtils#getRequestURIWithoutContext(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCRequestUtils.getRequestURIWithoutContext(HttpServletRequest)"})
  public void testGetRequestURIWithoutContext() {
    // Arrange
    MockMultipartHttpServletRequest request =
        new MockMultipartHttpServletRequest(new MockServletContext());
    request.setRequestURI(";");
    request.setContextPath(null);

    // Act and Assert
    assertEquals("", BLCRequestUtils.getRequestURIWithoutContext(request));
  }

  /**
   * Test {@link BLCRequestUtils#getRequestURIWithoutContext(HttpServletRequest)}.
   *
   * <p>Method under test: {@link BLCRequestUtils#getRequestURIWithoutContext(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCRequestUtils.getRequestURIWithoutContext(HttpServletRequest)"})
  public void testGetRequestURIWithoutContext2() {
    // Arrange
    MockMultipartHttpServletRequest request =
        new MockMultipartHttpServletRequest(new MockServletContext());
    request.setRequestURI(null);
    request.setContextPath("Request");

    // Act and Assert
    assertNull(BLCRequestUtils.getRequestURIWithoutContext(request));
  }

  /**
   * Test {@link BLCRequestUtils#getRequestURIWithoutContext(HttpServletRequest)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link BLCRequestUtils#getRequestURIWithoutContext(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCRequestUtils.getRequestURIWithoutContext(HttpServletRequest)"})
  public void testGetRequestURIWithoutContext_whenMockHttpServletRequest_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", BLCRequestUtils.getRequestURIWithoutContext(new MockHttpServletRequest()));
  }

  /**
   * Test {@link BLCRequestUtils#getRequestURIWithoutContext(HttpServletRequest)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BLCRequestUtils#getRequestURIWithoutContext(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCRequestUtils.getRequestURIWithoutContext(HttpServletRequest)"})
  public void testGetRequestURIWithoutContext_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BLCRequestUtils.getRequestURIWithoutContext(null));
  }
}

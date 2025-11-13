package org.broadleafcommerce.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

public class RequestDTOImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RequestDTOImpl.<init>()",
    "String RequestDTOImpl.getFullUrLWithQueryString()",
    "String RequestDTOImpl.getFullUrlWithQueryString()",
    "Map RequestDTOImpl.getRequestContextAttributes()",
    "String RequestDTOImpl.getRequestURI()",
    "Boolean RequestDTOImpl.getSecure()",
    "Boolean RequestDTOImpl.isSecure()",
    "void RequestDTOImpl.setFullUrlWithQueryString(String)",
    "void RequestDTOImpl.setRequestContextAttributes(Map)",
    "void RequestDTOImpl.setRequestURI(String)",
    "void RequestDTOImpl.setSecure(Boolean)"
  })
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
    Map<String, String> actualRequestContextAttributes =
        actualRequestDTOImpl.getRequestContextAttributes();
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
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link RequestDTOImpl#RequestDTOImpl(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RequestDTOImpl.<init>(HttpServletRequest)"})
  public void testNewRequestDTOImpl_givenEmptyString() {
    // Arrange
    MockMultipartHttpServletRequest request =
        new MockMultipartHttpServletRequest(new MockServletContext());
    request.setQueryString("");

    // Act
    RequestDTOImpl actualRequestDTOImpl = new RequestDTOImpl(request);

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
   * Test {@link RequestDTOImpl#RequestDTOImpl(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Given {@code HTTPS}.
   *   <li>Then return RequestContextAttributes size is one.
   * </ul>
   *
   * <p>Method under test: {@link RequestDTOImpl#RequestDTOImpl(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RequestDTOImpl.<init>(HttpServletRequest)"})
  public void testNewRequestDTOImpl_givenHttps_thenReturnRequestContextAttributesSizeIsOne() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("HTTPS", "42");

    // Act
    RequestDTOImpl actualRequestDTOImpl = new RequestDTOImpl(request);

    // Assert
    Map<String, String> requestContextAttributes =
        actualRequestDTOImpl.getRequestContextAttributes();
    assertEquals(1, requestContextAttributes.size());
    assertEquals("42", requestContextAttributes.get("HTTPS"));
    assertEquals("http://localhost", actualRequestDTOImpl.getFullUrLWithQueryString());
    assertEquals("http://localhost", actualRequestDTOImpl.getFullUrlWithQueryString());
  }

  /**
   * Test {@link RequestDTOImpl#RequestDTOImpl(WebRequest)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then return RequestContextAttributes size is one.
   * </ul>
   *
   * <p>Method under test: {@link RequestDTOImpl#RequestDTOImpl(WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RequestDTOImpl.<init>(WebRequest)"})
  public void testNewRequestDTOImpl_givenName_thenReturnRequestContextAttributesSizeIsOne() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("Name", "42");

    // Act
    RequestDTOImpl actualRequestDTOImpl = new RequestDTOImpl(new ServletWebRequest(request));

    // Assert
    Map<String, String> requestContextAttributes =
        actualRequestDTOImpl.getRequestContextAttributes();
    assertEquals(1, requestContextAttributes.size());
    assertEquals("42", requestContextAttributes.get("Name"));
    assertNull(actualRequestDTOImpl.getFullUrLWithQueryString());
    assertNull(actualRequestDTOImpl.getFullUrlWithQueryString());
    assertNull(actualRequestDTOImpl.getRequestURI());
    assertFalse(actualRequestDTOImpl.getSecure());
    assertFalse(actualRequestDTOImpl.isSecure());
    assertTrue(actualRequestDTOImpl.getProperties().isEmpty());
  }

  /**
   * Test {@link RequestDTOImpl#RequestDTOImpl(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then return FullUrLWithQueryString is {@code http://localhost?not empty}.
   * </ul>
   *
   * <p>Method under test: {@link RequestDTOImpl#RequestDTOImpl(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RequestDTOImpl.<init>(HttpServletRequest)"})
  public void testNewRequestDTOImpl_thenReturnFullUrLWithQueryStringIsHttpLocalhostNotEmpty() {
    // Arrange
    MockMultipartHttpServletRequest request =
        new MockMultipartHttpServletRequest(new MockServletContext());
    request.setQueryString("not empty");

    // Act
    RequestDTOImpl actualRequestDTOImpl = new RequestDTOImpl(request);

    // Assert
    assertEquals("", actualRequestDTOImpl.getRequestURI());
    assertEquals("http://localhost?not empty", actualRequestDTOImpl.getFullUrLWithQueryString());
    assertEquals("http://localhost?not empty", actualRequestDTOImpl.getFullUrlWithQueryString());
    assertFalse(actualRequestDTOImpl.getSecure());
    assertFalse(actualRequestDTOImpl.isSecure());
    assertTrue(actualRequestDTOImpl.getProperties().isEmpty());
    assertTrue(actualRequestDTOImpl.getRequestContextAttributes().isEmpty());
  }

  /**
   * Test {@link RequestDTOImpl#RequestDTOImpl(WebRequest)}.
   *
   * <ul>
   *   <li>Then return RequestContextAttributes Empty.
   * </ul>
   *
   * <p>Method under test: {@link RequestDTOImpl#RequestDTOImpl(WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RequestDTOImpl.<init>(WebRequest)"})
  public void testNewRequestDTOImpl_thenReturnRequestContextAttributesEmpty() {
    // Arrange and Act
    RequestDTOImpl actualRequestDTOImpl =
        new RequestDTOImpl(new ServletWebRequest(new MockHttpServletRequest()));

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
   * Test {@link RequestDTOImpl#RequestDTOImpl(HttpServletRequest)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link RequestDTOImpl#RequestDTOImpl(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RequestDTOImpl.<init>(HttpServletRequest)"})
  public void testNewRequestDTOImpl_whenMockHttpServletRequest() {
    // Arrange and Act
    RequestDTOImpl actualRequestDTOImpl = new RequestDTOImpl(new MockHttpServletRequest());

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
   * Test {@link RequestDTOImpl#getProperties()}.
   *
   * <p>Method under test: {@link RequestDTOImpl#getProperties()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map RequestDTOImpl.getProperties()"})
  public void testGetProperties() {
    // Arrange, Act and Assert
    assertTrue(new RequestDTOImpl().getProperties().isEmpty());
  }
}

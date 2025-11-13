package org.broadleafcommerce.common.web.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.mock.web.MockServletContext;

@RunWith(MockitoJUnitRunner.class)
public class PrecompressedArtifactFilterDiffblueTest {
  @Mock private List<String> list;

  @InjectMocks private PrecompressedArtifactFilter precompressedArtifactFilter;

  /**
   * Test {@link PrecompressedArtifactFilter#getResourcePath(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Given {@code Request}.
   *   <li>Then return {@code Request}.
   * </ul>
   *
   * <p>Method under test: {@link PrecompressedArtifactFilter#getResourcePath(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PrecompressedArtifactFilter.getResourcePath(HttpServletRequest)"})
  public void testGetResourcePath_givenRequest_thenReturnRequest() {
    // Arrange
    PrecompressedArtifactFilter precompressedArtifactFilter = new PrecompressedArtifactFilter();

    MockMultipartHttpServletRequest request =
        new MockMultipartHttpServletRequest(new MockServletContext());
    request.setPathInfo("Request");

    // Act
    String actualResourcePath = precompressedArtifactFilter.getResourcePath(request);

    // Assert
    assertEquals("Request", actualResourcePath);
  }

  /**
   * Test {@link PrecompressedArtifactFilter#getResourcePath(HttpServletRequest)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PrecompressedArtifactFilter#getResourcePath(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PrecompressedArtifactFilter.getResourcePath(HttpServletRequest)"})
  public void testGetResourcePath_whenMockHttpServletRequest_thenReturnEmptyString() {
    // Arrange
    PrecompressedArtifactFilter precompressedArtifactFilter = new PrecompressedArtifactFilter();

    // Act and Assert
    assertEquals("", precompressedArtifactFilter.getResourcePath(new MockHttpServletRequest()));
  }

  /**
   * Test {@link PrecompressedArtifactFilter#useGzipCompression(HttpServletRequest,
   * HttpServletResponse, String, String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code .}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link PrecompressedArtifactFilter#useGzipCompression(HttpServletRequest,
   * HttpServletResponse, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PrecompressedArtifactFilter.useGzipCompression(HttpServletRequest, HttpServletResponse, String, String)"
  })
  public void testUseGzipCompression_givenArrayListAddDot_thenThrowIllegalStateException()
      throws MalformedURLException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add(".");
    when(list.iterator()).thenReturn(stringList.iterator());
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            precompressedArtifactFilter.useGzipCompression(
                request, new MockHttpServletResponse(), ".", "Gzip Path"));
    verify(list).iterator();
  }

  /**
   * Test {@link PrecompressedArtifactFilter#useGzipCompression(HttpServletRequest,
   * HttpServletResponse, String, String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link PrecompressedArtifactFilter#useGzipCompression(HttpServletRequest,
   * HttpServletResponse, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PrecompressedArtifactFilter.useGzipCompression(HttpServletRequest, HttpServletResponse, String, String)"
  })
  public void testUseGzipCompression_givenArrayListAddFoo_thenThrowIllegalStateException()
      throws MalformedURLException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    stringList.add(".");
    when(list.iterator()).thenReturn(stringList.iterator());
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            precompressedArtifactFilter.useGzipCompression(
                request, new MockHttpServletResponse(), ".", "Gzip Path"));
    verify(list).iterator();
  }

  /**
   * Test {@link PrecompressedArtifactFilter#useGzipCompression(HttpServletRequest,
   * HttpServletResponse, String, String)}.
   *
   * <ul>
   *   <li>Given {@code gzip}.
   * </ul>
   *
   * <p>Method under test: {@link PrecompressedArtifactFilter#useGzipCompression(HttpServletRequest,
   * HttpServletResponse, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PrecompressedArtifactFilter.useGzipCompression(HttpServletRequest, HttpServletResponse, String, String)"
  })
  public void testUseGzipCompression_givenGzip() throws MalformedURLException {
    // Arrange
    PrecompressedArtifactFilter precompressedArtifactFilter = new PrecompressedArtifactFilter();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("gzip", Boolean.FALSE.toString());

    // Act and Assert
    assertFalse(
        precompressedArtifactFilter.useGzipCompression(
            request, new MockHttpServletResponse(), "Path", null));
  }

  /**
   * Test {@link PrecompressedArtifactFilter#useGzipCompression(HttpServletRequest,
   * HttpServletResponse, String, String)}.
   *
   * <ul>
   *   <li>Given {@link PrecompressedArtifactFilter} (default constructor).
   *   <li>When {@code Path}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PrecompressedArtifactFilter#useGzipCompression(HttpServletRequest,
   * HttpServletResponse, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PrecompressedArtifactFilter.useGzipCompression(HttpServletRequest, HttpServletResponse, String, String)"
  })
  public void testUseGzipCompression_givenPrecompressedArtifactFilter_whenPath_thenReturnFalse()
      throws MalformedURLException {
    // Arrange
    PrecompressedArtifactFilter precompressedArtifactFilter = new PrecompressedArtifactFilter();
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertFalse(
        precompressedArtifactFilter.useGzipCompression(
            request, new MockHttpServletResponse(), "Path", "Gzip Path"));
  }

  /**
   * Test {@link PrecompressedArtifactFilter#useGzipCompression(HttpServletRequest,
   * HttpServletResponse, String, String)}.
   *
   * <ul>
   *   <li>When {@code .}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PrecompressedArtifactFilter#useGzipCompression(HttpServletRequest,
   * HttpServletResponse, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PrecompressedArtifactFilter.useGzipCompression(HttpServletRequest, HttpServletResponse, String, String)"
  })
  public void testUseGzipCompression_whenDot_thenReturnFalse() throws MalformedURLException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    when(list.iterator()).thenReturn(stringList.iterator());
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act
    boolean actualUseGzipCompressionResult =
        precompressedArtifactFilter.useGzipCompression(
            request, new MockHttpServletResponse(), ".", "Gzip Path");

    // Assert
    verify(list).iterator();
    assertFalse(actualUseGzipCompressionResult);
  }

  /**
   * Test {@link PrecompressedArtifactFilter#fileExtensionInWhitelist(String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code .}.
   *   <li>When {@code .}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PrecompressedArtifactFilter#fileExtensionInWhitelist(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PrecompressedArtifactFilter.fileExtensionInWhitelist(String)"})
  public void testFileExtensionInWhitelist_givenArrayListAddDot_whenDot_thenReturnTrue() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add(".");
    when(list.iterator()).thenReturn(stringList.iterator());

    // Act
    boolean actualFileExtensionInWhitelistResult =
        precompressedArtifactFilter.fileExtensionInWhitelist(".");

    // Assert
    verify(list).iterator();
    assertTrue(actualFileExtensionInWhitelistResult);
  }

  /**
   * Test {@link PrecompressedArtifactFilter#fileExtensionInWhitelist(String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>When {@code .}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PrecompressedArtifactFilter#fileExtensionInWhitelist(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PrecompressedArtifactFilter.fileExtensionInWhitelist(String)"})
  public void testFileExtensionInWhitelist_givenArrayListAddFoo_whenDot_thenReturnTrue() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    stringList.add(".");
    when(list.iterator()).thenReturn(stringList.iterator());

    // Act
    boolean actualFileExtensionInWhitelistResult =
        precompressedArtifactFilter.fileExtensionInWhitelist(".");

    // Assert
    verify(list).iterator();
    assertTrue(actualFileExtensionInWhitelistResult);
  }

  /**
   * Test {@link PrecompressedArtifactFilter#fileExtensionInWhitelist(String)}.
   *
   * <ul>
   *   <li>Given {@link PrecompressedArtifactFilter} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PrecompressedArtifactFilter#fileExtensionInWhitelist(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PrecompressedArtifactFilter.fileExtensionInWhitelist(String)"})
  public void testFileExtensionInWhitelist_givenPrecompressedArtifactFilter_whenNull() {
    // Arrange, Act and Assert
    assertFalse(new PrecompressedArtifactFilter().fileExtensionInWhitelist(null));
  }

  /**
   * Test {@link PrecompressedArtifactFilter#fileExtensionInWhitelist(String)}.
   *
   * <ul>
   *   <li>Given {@link PrecompressedArtifactFilter} (default constructor).
   *   <li>When {@code Path}.
   * </ul>
   *
   * <p>Method under test: {@link PrecompressedArtifactFilter#fileExtensionInWhitelist(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PrecompressedArtifactFilter.fileExtensionInWhitelist(String)"})
  public void testFileExtensionInWhitelist_givenPrecompressedArtifactFilter_whenPath() {
    // Arrange, Act and Assert
    assertFalse(new PrecompressedArtifactFilter().fileExtensionInWhitelist("Path"));
  }

  /**
   * Test {@link PrecompressedArtifactFilter#fileExtensionInWhitelist(String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PrecompressedArtifactFilter#fileExtensionInWhitelist(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PrecompressedArtifactFilter.fileExtensionInWhitelist(String)"})
  public void testFileExtensionInWhitelist_thenReturnFalse() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    when(list.iterator()).thenReturn(stringList.iterator());

    // Act
    boolean actualFileExtensionInWhitelistResult =
        precompressedArtifactFilter.fileExtensionInWhitelist(".");

    // Assert
    verify(list).iterator();
    assertFalse(actualFileExtensionInWhitelistResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PrecompressedArtifactFilter#setUseWhileInDefaultEnvironment(boolean)}
   *   <li>{@link PrecompressedArtifactFilter#isUseWhileInDefaultEnvironment()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PrecompressedArtifactFilter.isUseWhileInDefaultEnvironment()",
    "void PrecompressedArtifactFilter.setUseWhileInDefaultEnvironment(boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange
    PrecompressedArtifactFilter precompressedArtifactFilter = new PrecompressedArtifactFilter();

    // Act
    precompressedArtifactFilter.setUseWhileInDefaultEnvironment(true);

    // Assert
    assertTrue(precompressedArtifactFilter.isUseWhileInDefaultEnvironment());
  }
}

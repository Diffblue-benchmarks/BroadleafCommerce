package org.broadleafcommerce.common.web.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.demo.AutoImportSql;
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.OrderedComparator;
import org.broadleafcommerce.common.web.resource.resolver.BLCJSResourceResolver;
import org.broadleafcommerce.common.web.resource.resolver.BroadleafPathResourceResolver;
import org.broadleafcommerce.common.web.util.CacheAwareResponseHandler;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.web.servlet.resource.HttpResource;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class BroadleafResourceHttpRequestHandlerDiffblueTest {
  @Mock private BroadleafContextUtil broadleafContextUtil;

  @InjectMocks private BroadleafResourceHttpRequestHandler broadleafResourceHttpRequestHandler;

  /**
   * Test {@link BroadleafResourceHttpRequestHandler#handleRequest(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link
   * BroadleafResourceHttpRequestHandler#handleRequest(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafResourceHttpRequestHandler.handleRequest(HttpServletRequest, HttpServletResponse)"
  })
  public void testHandleRequest() throws IOException, ServletException {
    // Arrange
    doNothing().when(broadleafContextUtil).clearThinRequestContext();
    doNothing().when(broadleafContextUtil).establishThinRequestContext();
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            broadleafResourceHttpRequestHandler.handleRequest(
                request, new MockHttpServletResponse()));
    verify(broadleafContextUtil).clearThinRequestContext();
    verify(broadleafContextUtil).establishThinRequestContext();
  }

  /**
   * Test OrderedComparator {@link OrderedComparator#compare(Object, Object)}.
   *
   * <p>Method under test: {@link OrderedComparator#compare(Object, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int OrderedComparator.compare(Object, Object)"})
  public void testOrderedComparatorCompare() {
    // Arrange
    OrderedComparator orderedComparator =
        new BroadleafResourceHttpRequestHandler().new OrderedComparator();
    AutoImportSql autoImportSql =
        new AutoImportSql("Persistence Unit", "/directory/foo.txt", Integer.MAX_VALUE);
    AutoImportSql autoImportSql2 =
        new AutoImportSql("Persistence Unit", "/directory/foo.txt", Integer.MAX_VALUE);

    // Act and Assert
    assertEquals(0, orderedComparator.compare(autoImportSql, autoImportSql2));
  }

  /**
   * Test OrderedComparator {@link OrderedComparator#compare(Object, Object)}.
   *
   * <ul>
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link OrderedComparator#compare(Object, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int OrderedComparator.compare(Object, Object)"})
  public void testOrderedComparatorCompare_thenReturnMinusOne() {
    // Arrange
    OrderedComparator orderedComparator =
        new BroadleafResourceHttpRequestHandler().new OrderedComparator();

    // Act and Assert
    assertEquals(
        -1,
        orderedComparator.compare(BLCFieldUtils.NULL_FIELD, new BroadleafPathResourceResolver()));
  }

  /**
   * Test OrderedComparator {@link OrderedComparator#compare(Object, Object)}.
   *
   * <ul>
   *   <li>When {@link BLCJSResourceResolver} (default constructor).
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link OrderedComparator#compare(Object, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int OrderedComparator.compare(Object, Object)"})
  public void testOrderedComparatorCompare_whenBLCJSResourceResolver_thenReturnMinusOne() {
    // Arrange
    OrderedComparator orderedComparator =
        new BroadleafResourceHttpRequestHandler().new OrderedComparator();

    // Act and Assert
    assertEquals(
        -1, orderedComparator.compare(new BLCJSResourceResolver(), BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test OrderedComparator {@link OrderedComparator#compare(Object, Object)}.
   *
   * <ul>
   *   <li>When {@link BLCJSResourceResolver} (default constructor).
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link OrderedComparator#compare(Object, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int OrderedComparator.compare(Object, Object)"})
  public void testOrderedComparatorCompare_whenBLCJSResourceResolver_thenReturnOne() {
    // Arrange
    OrderedComparator orderedComparator =
        new BroadleafResourceHttpRequestHandler().new OrderedComparator();

    // Act and Assert
    assertEquals(
        1, orderedComparator.compare(BLCFieldUtils.NULL_FIELD, new BLCJSResourceResolver()));
  }

  /**
   * Test OrderedComparator {@link OrderedComparator#compare(Object, Object)}.
   *
   * <ul>
   *   <li>When {@link BroadleafPathResourceResolver} (default constructor).
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link OrderedComparator#compare(Object, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int OrderedComparator.compare(Object, Object)"})
  public void testOrderedComparatorCompare_whenBroadleafPathResourceResolver_thenReturnOne() {
    // Arrange
    OrderedComparator orderedComparator =
        new BroadleafResourceHttpRequestHandler().new OrderedComparator();

    // Act and Assert
    assertEquals(
        1,
        orderedComparator.compare(new BroadleafPathResourceResolver(), BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test OrderedComparator {@link OrderedComparator#compare(Object, Object)}.
   *
   * <ul>
   *   <li>When {@link BLCFieldUtils#NULL_FIELD}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link OrderedComparator#compare(Object, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int OrderedComparator.compare(Object, Object)"})
  public void testOrderedComparatorCompare_whenNull_field_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        new BroadleafResourceHttpRequestHandler().new OrderedComparator()
            .compare(BLCFieldUtils.NULL_FIELD, BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link BroadleafResourceHttpRequestHandler#setHeaders(HttpServletResponse, Resource,
   * MediaType)}.
   *
   * <ul>
   *   <li>Given {@link BroadleafResourceHttpRequestHandler} (default constructor).
   *   <li>When {@link GeneratedResource#GeneratedResource()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafResourceHttpRequestHandler#setHeaders(HttpServletResponse, Resource, MediaType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafResourceHttpRequestHandler.setHeaders(HttpServletResponse, Resource, MediaType)"
  })
  public void testSetHeaders_givenBroadleafResourceHttpRequestHandler_whenGeneratedResource()
      throws IOException {
    // Arrange
    BroadleafResourceHttpRequestHandler broadleafResourceHttpRequestHandler =
        new BroadleafResourceHttpRequestHandler();
    MockHttpServletResponse response = new MockHttpServletResponse();
    GeneratedResource resource = new GeneratedResource();

    // Act
    broadleafResourceHttpRequestHandler.setHeaders(
        response, resource, MediaType.parseMediaType(MediaType.TEXT_PLAIN_VALUE));

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(2, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("text/plain", response.getContentType());
    assertTrue(headerNames.contains("Accept-Ranges"));
    assertTrue(headerNames.contains("Content-Type"));
  }

  /**
   * Test {@link BroadleafResourceHttpRequestHandler#setHeaders(HttpServletResponse, Resource,
   * MediaType)}.
   *
   * <ul>
   *   <li>Then calls {@link HttpResource#getResponseHeaders()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafResourceHttpRequestHandler#setHeaders(HttpServletResponse, Resource, MediaType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafResourceHttpRequestHandler.setHeaders(HttpServletResponse, Resource, MediaType)"
  })
  public void testSetHeaders_thenCallsGetResponseHeaders() throws IOException {
    // Arrange
    CacheAwareResponseHandler cacheAwareResponseHandler = new CacheAwareResponseHandler();
    cacheAwareResponseHandler.setUseCacheControlHeader(false);
    cacheAwareResponseHandler.setCacheSeconds(1);
    MockHttpServletResponse response = new MockHttpServletResponse();

    HttpResource resource = mock(HttpResource.class);
    when(resource.getResponseHeaders()).thenReturn(new HttpHeaders());

    // Act
    cacheAwareResponseHandler.setHeaders(
        response, resource, MediaType.parseMediaType(MediaType.TEXT_PLAIN_VALUE));

    // Assert
    verify(resource).getResponseHeaders();
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(2, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("text/plain", response.getContentType());
    assertTrue(headerNames.contains("Accept-Ranges"));
    assertTrue(headerNames.contains("Content-Type"));
  }

  /**
   * Test new {@link BroadleafResourceHttpRequestHandler} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * BroadleafResourceHttpRequestHandler}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafResourceHttpRequestHandler.<init>()"})
  public void testNewBroadleafResourceHttpRequestHandler() {
    // Arrange and Act
    BroadleafResourceHttpRequestHandler actualBroadleafResourceHttpRequestHandler =
        new BroadleafResourceHttpRequestHandler();

    // Assert
    assertNull(actualBroadleafResourceHttpRequestHandler.getVaryByRequestHeaders());
    assertNull(actualBroadleafResourceHttpRequestHandler.blcContextUtil);
    assertNull(actualBroadleafResourceHttpRequestHandler.getCacheControl());
    assertNull(actualBroadleafResourceHttpRequestHandler.getResourceHttpMessageConverter());
    assertNull(actualBroadleafResourceHttpRequestHandler.getResourceRegionHttpMessageConverter());
    assertNull(actualBroadleafResourceHttpRequestHandler.getContentNegotiationManager());
    assertNull(actualBroadleafResourceHttpRequestHandler.getUrlPathHelper());
    assertEquals(-1, actualBroadleafResourceHttpRequestHandler.getCacheSeconds());
    assertEquals(2, actualBroadleafResourceHttpRequestHandler.getSupportedMethods().length);
    assertFalse(actualBroadleafResourceHttpRequestHandler.isOptimizeLocations());
    assertFalse(actualBroadleafResourceHttpRequestHandler.isAlwaysMustRevalidate());
    assertFalse(actualBroadleafResourceHttpRequestHandler.isRequireSession());
    assertFalse(actualBroadleafResourceHttpRequestHandler.isUseExpiresHeader());
    assertTrue(actualBroadleafResourceHttpRequestHandler.getLocations().isEmpty());
    assertTrue(actualBroadleafResourceHttpRequestHandler.getResourceResolvers().isEmpty());
    assertTrue(actualBroadleafResourceHttpRequestHandler.getResourceTransformers().isEmpty());
    assertTrue(actualBroadleafResourceHttpRequestHandler.getMediaTypes().isEmpty());
    assertTrue(actualBroadleafResourceHttpRequestHandler.isUseLastModified());
    assertTrue(actualBroadleafResourceHttpRequestHandler.isUseCacheControlHeader());
    assertTrue(actualBroadleafResourceHttpRequestHandler.isUseCacheControlNoStore());
  }
}

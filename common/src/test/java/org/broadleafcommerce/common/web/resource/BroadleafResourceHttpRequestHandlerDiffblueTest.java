/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
package org.broadleafcommerce.common.web.resource;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Set;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.OrderedComparator;
import org.broadleafcommerce.common.web.resource.resolver.BLCJSResourceResolver;
import org.broadleafcommerce.common.web.util.FileSystemResponseWrapper;
import org.broadleafcommerce.common.web.util.StatusExposingServletResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.resource.HttpResource;

@ContextConfiguration(classes = {BroadleafResourceHttpRequestHandler.OrderedComparator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafResourceHttpRequestHandlerDiffblueTest {
  @MockBean
  private BroadleafResourceHttpRequestHandler broadleafResourceHttpRequestHandler;

  @Autowired
  private BroadleafResourceHttpRequestHandler.OrderedComparator orderedComparator;

  /**
   * Test OrderedComparator {@link OrderedComparator#compare(Object, Object)}.
   * <ul>
   *   <li>Given {@link Integer#MAX_VALUE}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafResourceHttpRequestHandler.OrderedComparator#compare(Object, Object)}
   */
  @Test
  public void testOrderedComparatorCompare_givenMax_value_thenReturnOne() {
    // Arrange
    BLCJSResourceResolver blcjsResourceResolver = mock(BLCJSResourceResolver.class);
    when(blcjsResourceResolver.getOrder()).thenReturn(Integer.MAX_VALUE);

    // Act
    int actualCompareResult = orderedComparator.compare(blcjsResourceResolver, BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(blcjsResourceResolver).getOrder();
    assertEquals(1, actualCompareResult);
  }

  /**
   * Test OrderedComparator {@link OrderedComparator#compare(Object, Object)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return {@code -10999}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafResourceHttpRequestHandler.OrderedComparator#compare(Object, Object)}
   */
  @Test
  public void testOrderedComparatorCompare_givenOne_thenReturn10999() {
    // Arrange
    BLCJSResourceResolver blcjsResourceResolver = mock(BLCJSResourceResolver.class);
    when(blcjsResourceResolver.getOrder()).thenReturn(1);

    // Act
    int actualCompareResult = orderedComparator.compare(blcjsResourceResolver, new BLCJSResourceResolver());

    // Assert
    verify(blcjsResourceResolver).getOrder();
    assertEquals(-10999, actualCompareResult);
  }

  /**
   * Test OrderedComparator {@link OrderedComparator#compare(Object, Object)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafResourceHttpRequestHandler.OrderedComparator#compare(Object, Object)}
   */
  @Test
  public void testOrderedComparatorCompare_givenOne_thenReturnMinusOne() {
    // Arrange
    BLCJSResourceResolver blcjsResourceResolver = mock(BLCJSResourceResolver.class);
    when(blcjsResourceResolver.getOrder()).thenReturn(1);

    // Act
    int actualCompareResult = orderedComparator.compare(blcjsResourceResolver, BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(blcjsResourceResolver).getOrder();
    assertEquals(-1, actualCompareResult);
  }

  /**
   * Test OrderedComparator {@link OrderedComparator#compare(Object, Object)}.
   * <ul>
   *   <li>When {@link BLCJSResourceResolver} (default constructor).</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafResourceHttpRequestHandler.OrderedComparator#compare(Object, Object)}
   */
  @Test
  public void testOrderedComparatorCompare_whenBLCJSResourceResolver_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, orderedComparator.compare(new BLCJSResourceResolver(), BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test OrderedComparator {@link OrderedComparator#compare(Object, Object)}.
   * <ul>
   *   <li>When {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafResourceHttpRequestHandler.OrderedComparator#compare(Object, Object)}
   */
  @Test
  public void testOrderedComparatorCompare_whenNull_field_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, orderedComparator.compare(BLCFieldUtils.NULL_FIELD, BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test
   * {@link BroadleafResourceHttpRequestHandler#setHeaders(HttpServletResponse, Resource, MediaType)}.
   * <p>
   * Method under test:
   * {@link BroadleafResourceHttpRequestHandler#setHeaders(HttpServletResponse, Resource, MediaType)}
   */
  @Test
  public void testSetHeaders() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafResourceHttpRequestHandler broadleafResourceHttpRequestHandler = new BroadleafResourceHttpRequestHandler();
    broadleafResourceHttpRequestHandler.setUseCacheControlHeader(false);
    broadleafResourceHttpRequestHandler.setCacheSeconds(1);
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    HttpResource resource = mock(HttpResource.class);
    when(resource.getResponseHeaders()).thenReturn(new HttpHeaders());

    // Act
    broadleafResourceHttpRequestHandler.setHeaders(response2, resource, null);

    // Assert
    verify(resource).getResponseHeaders();
    Collection<String> headerNames = response2.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertTrue(headerNames.contains("Accept-Ranges"));
  }

  /**
   * Test
   * {@link BroadleafResourceHttpRequestHandler#setHeaders(HttpServletResponse, Resource, MediaType)}.
   * <p>
   * Method under test:
   * {@link BroadleafResourceHttpRequestHandler#setHeaders(HttpServletResponse, Resource, MediaType)}
   */
  @Test
  public void testSetHeaders2() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafResourceHttpRequestHandler broadleafResourceHttpRequestHandler = new BroadleafResourceHttpRequestHandler();
    broadleafResourceHttpRequestHandler.setUseCacheControlHeader(true);
    broadleafResourceHttpRequestHandler.setCacheSeconds(1);
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    HttpResource resource = mock(HttpResource.class);
    when(resource.getResponseHeaders()).thenReturn(new HttpHeaders());

    // Act
    broadleafResourceHttpRequestHandler.setHeaders(response2, resource, null);

    // Assert
    verify(resource).getResponseHeaders();
    Collection<String> headerNames = response2.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertTrue(headerNames.contains("Accept-Ranges"));
  }

  /**
   * Test new {@link BroadleafResourceHttpRequestHandler} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link BroadleafResourceHttpRequestHandler}
   */
  @Test
  public void testNewBroadleafResourceHttpRequestHandler() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    BroadleafResourceHttpRequestHandler actualBroadleafResourceHttpRequestHandler = new BroadleafResourceHttpRequestHandler();

    // Assert
    assertNull(actualBroadleafResourceHttpRequestHandler.getVaryByRequestHeaders());
    assertNull(actualBroadleafResourceHttpRequestHandler.blcContextUtil);
    assertNull(actualBroadleafResourceHttpRequestHandler.getCacheControl());
    assertNull(actualBroadleafResourceHttpRequestHandler.getResourceHttpMessageConverter());
    assertNull(actualBroadleafResourceHttpRequestHandler.getResourceRegionHttpMessageConverter());
    assertNull(actualBroadleafResourceHttpRequestHandler.getContentNegotiationManager());
    assertNull(actualBroadleafResourceHttpRequestHandler.getUrlPathHelper());
    assertEquals(-1, actualBroadleafResourceHttpRequestHandler.getCacheSeconds());
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
    assertArrayEquals(new String[]{"GET", "HEAD"}, actualBroadleafResourceHttpRequestHandler.getSupportedMethods());
  }
}

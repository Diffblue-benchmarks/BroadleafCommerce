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
package org.broadleafcommerce.common.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.broadleafcommerce.common.web.util.FileSystemResponseWrapper;
import org.broadleafcommerce.common.web.util.StatusExposingServletResponse;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

public class BroadleafSimpleMappingExceptionResolverDiffblueTest {
  /**
   * Test
   * {@link BroadleafSimpleMappingExceptionResolver#doResolveException(HttpServletRequest, HttpServletResponse, Object, Exception)}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>Then calls {@link ServletRequestWrapper#getAttribute(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafSimpleMappingExceptionResolver#doResolveException(HttpServletRequest, HttpServletResponse, Object, Exception)}
   */
  @Test
  public void testDoResolveException_givenNull_field_thenCallsGetAttribute() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafSimpleMappingExceptionResolver broadleafSimpleMappingExceptionResolver = new BroadleafSimpleMappingExceptionResolver();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getAttribute(Mockito.<String>any())).thenReturn(BLCFieldUtils.NULL_FIELD);
    SessionlessHttpServletRequestWrapper request2 = new SessionlessHttpServletRequestWrapper(request);
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    Exception ex = new Exception("foo");

    // Act
    ModelAndView actualDoResolveExceptionResult = broadleafSimpleMappingExceptionResolver.doResolveException(request2,
        response2, BLCFieldUtils.NULL_FIELD, ex);

    // Assert
    verify(request, atLeast(1)).getAttribute(eq("exceptionUUID"));
    assertEquals("utility/error", actualDoResolveExceptionResult.getViewName());
    assertNull(actualDoResolveExceptionResult.getStatus());
    assertNull(actualDoResolveExceptionResult.getView());
    Map<String, Object> model = actualDoResolveExceptionResult.getModel();
    assertEquals(2, model.size());
    assertFalse(actualDoResolveExceptionResult.isEmpty());
    assertTrue(actualDoResolveExceptionResult.hasView());
    assertTrue(actualDoResolveExceptionResult.isReference());
    assertSame(ex, model.get("exception"));
    assertSame(model, actualDoResolveExceptionResult.getModelMap());
  }

  /**
   * Test
   * {@link BroadleafSimpleMappingExceptionResolver#doResolveException(HttpServletRequest, HttpServletResponse, Object, Exception)}.
   * <ul>
   *   <li>Then calls {@link ServletRequestWrapper#getAttribute(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafSimpleMappingExceptionResolver#doResolveException(HttpServletRequest, HttpServletResponse, Object, Exception)}
   */
  @Test
  public void testDoResolveException_thenCallsGetAttribute() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafSimpleMappingExceptionResolver broadleafSimpleMappingExceptionResolver = new BroadleafSimpleMappingExceptionResolver();
    broadleafSimpleMappingExceptionResolver.setDefaultStatusCode(1);
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getAttribute(Mockito.<String>any())).thenReturn(BLCFieldUtils.NULL_FIELD);
    SessionlessHttpServletRequestWrapper request2 = new SessionlessHttpServletRequestWrapper(request);
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    Exception ex = new Exception("foo");

    // Act
    ModelAndView actualDoResolveExceptionResult = broadleafSimpleMappingExceptionResolver.doResolveException(request2,
        response2, BLCFieldUtils.NULL_FIELD, ex);

    // Assert
    verify(request, atLeast(1)).getAttribute(Mockito.<String>any());
    assertEquals("utility/error", actualDoResolveExceptionResult.getViewName());
    assertNull(actualDoResolveExceptionResult.getStatus());
    assertNull(actualDoResolveExceptionResult.getView());
    Map<String, Object> model = actualDoResolveExceptionResult.getModel();
    assertEquals(2, model.size());
    assertFalse(actualDoResolveExceptionResult.isEmpty());
    assertTrue(actualDoResolveExceptionResult.hasView());
    assertTrue(actualDoResolveExceptionResult.isReference());
    assertSame(ex, model.get("exception"));
    assertSame(model, actualDoResolveExceptionResult.getModelMap());
  }

  /**
   * Test
   * {@link BroadleafSimpleMappingExceptionResolver#doResolveException(HttpServletRequest, HttpServletResponse, Object, Exception)}.
   * <ul>
   *   <li>Then return Model {@code exceptionUUID} is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafSimpleMappingExceptionResolver#doResolveException(HttpServletRequest, HttpServletResponse, Object, Exception)}
   */
  @Test
  public void testDoResolveException_thenReturnModelExceptionUUIDIsEmptyString() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafSimpleMappingExceptionResolver broadleafSimpleMappingExceptionResolver = new BroadleafSimpleMappingExceptionResolver();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    Exception ex = new Exception("foo");

    // Act
    ModelAndView actualDoResolveExceptionResult = broadleafSimpleMappingExceptionResolver.doResolveException(request,
        response2, BLCFieldUtils.NULL_FIELD, ex);

    // Assert
    Map<String, Object> model = actualDoResolveExceptionResult.getModel();
    assertEquals(2, model.size());
    assertEquals("", model.get("exceptionUUID"));
    assertEquals("utility/error", actualDoResolveExceptionResult.getViewName());
    assertNull(actualDoResolveExceptionResult.getStatus());
    assertNull(actualDoResolveExceptionResult.getView());
    assertFalse(actualDoResolveExceptionResult.isEmpty());
    assertTrue(actualDoResolveExceptionResult.hasView());
    assertTrue(actualDoResolveExceptionResult.isReference());
    assertSame(ex, model.get("exception"));
    assertSame(model, actualDoResolveExceptionResult.getModelMap());
  }

  /**
   * Test
   * {@link BroadleafSimpleMappingExceptionResolver#resolveException(HttpServletRequest, HttpServletResponse, Object, Exception)}.
   * <p>
   * Method under test:
   * {@link BroadleafSimpleMappingExceptionResolver#resolveException(HttpServletRequest, HttpServletResponse, Object, Exception)}
   */
  @Test
  public void testResolveException() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafSimpleMappingExceptionResolver broadleafSimpleMappingExceptionResolver = new BroadleafSimpleMappingExceptionResolver();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertNull(broadleafSimpleMappingExceptionResolver.resolveException(request, response2, BLCFieldUtils.NULL_FIELD,
        new Exception("foo")));
  }

  /**
   * Test
   * {@link BroadleafSimpleMappingExceptionResolver#resolveException(HttpServletRequest, HttpServletResponse, Object, Exception)}.
   * <p>
   * Method under test:
   * {@link BroadleafSimpleMappingExceptionResolver#resolveException(HttpServletRequest, HttpServletResponse, Object, Exception)}
   */
  @Test
  public void testResolveException2() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafSimpleMappingExceptionResolver broadleafSimpleMappingExceptionResolver = new BroadleafSimpleMappingExceptionResolver();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class));
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertNull(broadleafSimpleMappingExceptionResolver.resolveException(request, response2, BLCFieldUtils.NULL_FIELD,
        new Exception("foo")));
  }

  /**
   * Test {@link BroadleafSimpleMappingExceptionResolver#getDefaultErrorView()}.
   * <p>
   * Method under test:
   * {@link BroadleafSimpleMappingExceptionResolver#getDefaultErrorView()}
   */
  @Test
  public void testGetDefaultErrorView() {
    // Arrange, Act and Assert
    assertEquals("utility/error", (new BroadleafSimpleMappingExceptionResolver()).getDefaultErrorView());
  }
}

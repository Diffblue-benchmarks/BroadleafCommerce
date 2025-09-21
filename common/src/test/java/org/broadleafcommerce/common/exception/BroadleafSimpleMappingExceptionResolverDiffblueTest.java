/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.broadleafcommerce.common.web.util.StatusExposingServletResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@ContextConfiguration(classes = {BroadleafSimpleMappingExceptionResolver.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafSimpleMappingExceptionResolverDiffblueTest {
  @Autowired
  private BroadleafSimpleMappingExceptionResolver broadleafSimpleMappingExceptionResolver;

  /**
   * Test {@link BroadleafSimpleMappingExceptionResolver#doResolveException(HttpServletRequest,
   * HttpServletResponse, Object, Exception)}.
   *
   * <p>Method under test: {@link
   * BroadleafSimpleMappingExceptionResolver#doResolveException(HttpServletRequest,
   * HttpServletResponse, Object, Exception)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModelAndView BroadleafSimpleMappingExceptionResolver.doResolveException(HttpServletRequest, HttpServletResponse, Object, Exception)"
  })
  public void testDoResolveException() {
    // Arrange
    BroadleafSimpleMappingExceptionResolver broadleafSimpleMappingExceptionResolver =
        new BroadleafSimpleMappingExceptionResolver();
    broadleafSimpleMappingExceptionResolver.setDefaultStatusCode(1);

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getAttribute(Mockito.<String>any())).thenReturn(BLCFieldUtils.NULL_FIELD);
    SessionlessHttpServletRequestWrapper request2 =
        new SessionlessHttpServletRequestWrapper(request);
    HttpServletRequestWrapper request3 = new HttpServletRequestWrapper(request2);
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));
    Exception ex = new Exception();

    // Act
    ModelAndView actualDoResolveExceptionResult =
        broadleafSimpleMappingExceptionResolver.doResolveException(
            request3, response, BLCFieldUtils.NULL_FIELD, ex);

    // Assert
    verify(request, atLeast(1)).getAttribute(Mockito.<String>any());
    Map<String, Object> model = actualDoResolveExceptionResult.getModel();
    assertEquals(2, model.size());
    Object getResult = model.get("exception");
    assertTrue(getResult instanceof Exception);
    assertEquals("utility/error", actualDoResolveExceptionResult.getViewName());
    assertNull(actualDoResolveExceptionResult.getStatus());
    assertNull(actualDoResolveExceptionResult.getView());
    assertFalse(actualDoResolveExceptionResult.isEmpty());
    assertTrue(actualDoResolveExceptionResult.hasView());
    assertTrue(actualDoResolveExceptionResult.isReference());
    assertSame(ex, getResult);
    assertSame(model, actualDoResolveExceptionResult.getModelMap());
  }

  /**
   * Test {@link BroadleafSimpleMappingExceptionResolver#doResolveException(HttpServletRequest,
   * HttpServletResponse, Object, Exception)}.
   *
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.
   *   <li>Then calls {@link DefaultMultipartHttpServletRequest#getAttribute(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafSimpleMappingExceptionResolver#doResolveException(HttpServletRequest,
   * HttpServletResponse, Object, Exception)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModelAndView BroadleafSimpleMappingExceptionResolver.doResolveException(HttpServletRequest, HttpServletResponse, Object, Exception)"
  })
  public void testDoResolveException_givenNull_field_thenCallsGetAttribute() {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getAttribute(Mockito.<String>any())).thenReturn(BLCFieldUtils.NULL_FIELD);
    SessionlessHttpServletRequestWrapper request2 =
        new SessionlessHttpServletRequestWrapper(request);
    HttpServletRequestWrapper request3 = new HttpServletRequestWrapper(request2);
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));
    Exception ex = new Exception();

    // Act
    ModelAndView actualDoResolveExceptionResult =
        broadleafSimpleMappingExceptionResolver.doResolveException(
            request3, response, BLCFieldUtils.NULL_FIELD, ex);

    // Assert
    verify(request, atLeast(1)).getAttribute("exceptionUUID");
    Map<String, Object> model = actualDoResolveExceptionResult.getModel();
    assertEquals(2, model.size());
    Object getResult = model.get("exception");
    assertTrue(getResult instanceof Exception);
    assertEquals("utility/error", actualDoResolveExceptionResult.getViewName());
    assertNull(actualDoResolveExceptionResult.getStatus());
    assertNull(actualDoResolveExceptionResult.getView());
    assertFalse(actualDoResolveExceptionResult.isEmpty());
    assertTrue(actualDoResolveExceptionResult.hasView());
    assertTrue(actualDoResolveExceptionResult.isReference());
    assertSame(ex, getResult);
    assertSame(model, actualDoResolveExceptionResult.getModelMap());
  }

  /**
   * Test {@link BroadleafSimpleMappingExceptionResolver#doResolveException(HttpServletRequest,
   * HttpServletResponse, Object, Exception)}.
   *
   * <ul>
   *   <li>Then return Model {@code exceptionUUID} is empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafSimpleMappingExceptionResolver#doResolveException(HttpServletRequest,
   * HttpServletResponse, Object, Exception)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModelAndView BroadleafSimpleMappingExceptionResolver.doResolveException(HttpServletRequest, HttpServletResponse, Object, Exception)"
  })
  public void testDoResolveException_thenReturnModelExceptionUUIDIsEmptyString() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));
    Exception ex = new Exception();

    // Act
    ModelAndView actualDoResolveExceptionResult =
        broadleafSimpleMappingExceptionResolver.doResolveException(
            request, response, BLCFieldUtils.NULL_FIELD, ex);

    // Assert
    Map<String, Object> model = actualDoResolveExceptionResult.getModel();
    assertEquals(2, model.size());
    Object getResult = model.get("exception");
    assertTrue(getResult instanceof Exception);
    assertEquals("", model.get("exceptionUUID"));
    assertEquals("utility/error", actualDoResolveExceptionResult.getViewName());
    assertNull(actualDoResolveExceptionResult.getStatus());
    assertNull(actualDoResolveExceptionResult.getView());
    assertFalse(actualDoResolveExceptionResult.isEmpty());
    assertTrue(actualDoResolveExceptionResult.hasView());
    assertTrue(actualDoResolveExceptionResult.isReference());
    assertSame(ex, getResult);
    assertSame(model, actualDoResolveExceptionResult.getModelMap());
  }

  /**
   * Test {@link BroadleafSimpleMappingExceptionResolver#resolveException(HttpServletRequest,
   * HttpServletResponse, Object, Exception)}.
   *
   * <p>Method under test: {@link
   * BroadleafSimpleMappingExceptionResolver#resolveException(HttpServletRequest,
   * HttpServletResponse, Object, Exception)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModelAndView BroadleafSimpleMappingExceptionResolver.resolveException(HttpServletRequest, HttpServletResponse, Object, Exception)"
  })
  public void testResolveException() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));

    // Act and Assert
    assertNull(
        broadleafSimpleMappingExceptionResolver.resolveException(
            request, response, BLCFieldUtils.NULL_FIELD, new Exception()));
  }

  /**
   * Test {@link BroadleafSimpleMappingExceptionResolver#getDefaultErrorView()}.
   *
   * <p>Method under test: {@link BroadleafSimpleMappingExceptionResolver#getDefaultErrorView()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafSimpleMappingExceptionResolver.getDefaultErrorView()"})
  public void testGetDefaultErrorView() {
    // Arrange, Act and Assert
    assertEquals(
        "utility/error", new BroadleafSimpleMappingExceptionResolver().getDefaultErrorView());
  }
}

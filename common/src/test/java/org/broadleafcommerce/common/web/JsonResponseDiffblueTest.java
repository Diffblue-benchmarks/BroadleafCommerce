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
package org.broadleafcommerce.common.web;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.broadleafcommerce.common.web.util.StatusExposingServletResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {JsonResponse.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class JsonResponseDiffblueTest {
  @MockBean private HttpServletResponse httpServletResponse;

  @Autowired private JsonResponse jsonResponse;

  /**
   * Test {@link JsonResponse#JsonResponse(HttpServletResponse)}.
   *
   * <p>Method under test: {@link JsonResponse#JsonResponse(HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonResponse.<init>(HttpServletResponse)"})
  public void testNewJsonResponse() {
    // Arrange
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));

    // Act and Assert
    assertTrue(new JsonResponse(response).map.isEmpty());
  }

  /**
   * Test {@link JsonResponse#with(String, Object)}.
   *
   * <p>Method under test: {@link JsonResponse#with(String, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonResponse JsonResponse.with(String, Object)"})
  public void testWith() {
    // Arrange
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act
    JsonResponse actualWithResult = jsonResponse.with("Key", object);

    // Assert
    Map<String, Object> stringObjectMap = jsonResponse.map;
    assertEquals(1, stringObjectMap.size());
    assertSame(jsonResponse, actualWithResult);
    assertSame(object, stringObjectMap.get("Key"));
  }

  /**
   * Test {@link JsonResponse#done()}.
   *
   * <p>Method under test: {@link JsonResponse#done()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonResponse.done()"})
  public void testDone() throws UnsupportedEncodingException {
    // Arrange
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));
    JsonResponse jsonResponse = new JsonResponse(response);

    // Act
    jsonResponse.done();

    // Assert
    HttpServletResponse httpServletResponse = jsonResponse.response;
    assertTrue(httpServletResponse instanceof HttpServletResponseWrapper);
    ServletResponse response2 = ((HttpServletResponseWrapper) httpServletResponse).getResponse();
    assertTrue(response2 instanceof StatusExposingServletResponse);
    ServletResponse response3 = ((StatusExposingServletResponse) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertEquals("application/json", response3.getContentType());
    assertEquals("{}", ((MockHttpServletResponse) response3).getContentAsString());
    assertTrue(response3.isCommitted());
    assertArrayEquals(
        new byte[] {'{', '}'}, ((MockHttpServletResponse) response3).getContentAsByteArray());
  }

  /**
   * Test {@link JsonResponse#done()}.
   *
   * <p>Method under test: {@link JsonResponse#done()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonResponse.done()"})
  public void testDone2() throws UnsupportedEncodingException {
    // Arrange
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(response);
    HttpServletResponseWrapper response3 = new HttpServletResponseWrapper(response2);
    JsonResponse jsonResponse = new JsonResponse(response3);

    // Act
    jsonResponse.done();

    // Assert
    HttpServletResponse httpServletResponse = jsonResponse.response;
    ServletResponse response4 = ((HttpServletResponseWrapper) httpServletResponse).getResponse();
    ServletResponse response5 = ((StatusExposingServletResponse) response4).getResponse();
    assertTrue(response5 instanceof HttpServletResponseWrapper);
    assertTrue(httpServletResponse instanceof HttpServletResponseWrapper);
    ServletResponse response6 = ((HttpServletResponseWrapper) response5).getResponse();
    assertTrue(response6 instanceof StatusExposingServletResponse);
    assertTrue(response4 instanceof StatusExposingServletResponse);
    ServletResponse response7 = ((StatusExposingServletResponse) response6).getResponse();
    assertTrue(response7 instanceof MockHttpServletResponse);
    assertEquals("application/json", response6.getContentType());
    assertEquals("application/json", response7.getContentType());
    assertEquals("application/json", response5.getContentType());
    assertEquals("{}", ((MockHttpServletResponse) response7).getContentAsString());
    assertTrue(response6.isCommitted());
    assertTrue(response7.isCommitted());
    assertTrue(response5.isCommitted());
    assertArrayEquals(
        new byte[] {'{', '}'}, ((MockHttpServletResponse) response7).getContentAsByteArray());
  }

  /**
   * Test {@link JsonResponse#done()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonResponse#done()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonResponse.done()"})
  public void testDone_thenThrowRuntimeException() {
    // Arrange
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));
    response.setCharacterEncoding("https://example.org/example");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> new JsonResponse(response).done());
  }
}

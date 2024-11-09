/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.web.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.function.BiFunction;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.TimeDTO;
import org.broadleafcommerce.common.web.BroadleafRequestContext;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

public class ContentProcessorDiffblueTest {
  /**
   * Test {@link ContentProcessor#getName()}.
   * <p>
   * Method under test: {@link ContentProcessor#getName()}
   */
  @Test
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("content", (new ContentProcessor()).getName());
  }

  /**
   * Test {@link ContentProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link ContentProcessor#getPrecedence()}
   */
  @Test
  public void testGetPrecedence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(10000, (new ContentProcessor()).getPrecedence());
  }

  /**
   * Test {@link ContentProcessor#getAttributeValue(Map, String, String)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code 42} is {@code foo}.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ContentProcessor#getAttributeValue(Map, String, String)}
   */
  @Test
  public void testGetAttributeValue_given42_whenHashMap42IsFoo_thenReturnFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("42", "foo");

    // Act and Assert
    assertEquals("foo", contentProcessor.getAttributeValue(tagAttributes, "42", "42"));
  }

  /**
   * Test {@link ContentProcessor#getAttributeValue(Map, String, String)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ContentProcessor#getAttributeValue(Map, String, String)}
   */
  @Test
  public void testGetAttributeValue_givenBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertEquals("42", contentProcessor.getAttributeValue(tagAttributes, "42", "42"));
  }

  /**
   * Test {@link ContentProcessor#getAttributeValue(Map, String, String)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ContentProcessor#getAttributeValue(Map, String, String)}
   */
  @Test
  public void testGetAttributeValue_whenHashMap_thenReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();

    // Act and Assert
    assertEquals("42", contentProcessor.getAttributeValue(new HashMap<>(), "42", "42"));
  }

  /**
   * Test
   * {@link ContentProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link HashMap#HashMap()} {@code contentType} is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ContentProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testPopulateModelVariables_givenEmptyString_whenHashMapContentTypeIsEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("contentType", "");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> contentProcessor.populateModelVariables("Tag Name", tagAttributes, mock(BroadleafTemplateContext.class)));
  }

  /**
   * Test
   * {@link ContentProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ContentProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testPopulateModelVariables_whenHashMap_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> contentProcessor.populateModelVariables("Tag Name",
        new HashMap<>(), mock(BroadleafTemplateContext.class)));
  }

  /**
   * Test
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@code Parse Expression}.</li>
   *   <li>Then return {@code category} is {@code Parse Expression}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testBuildMvelParameters_givenParseExpression_thenReturnCategoryIsParseExpression() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();
    MockHttpServletRequest request = new MockHttpServletRequest();

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("product", null);
    tagAttributes.put("category", "Tag Attributes");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn("Parse Expression");

    // Act
    Map<String, Object> actualBuildMvelParametersResult = contentProcessor.buildMvelParameters(request, tagAttributes,
        context);

    // Assert
    verify(context).parseExpression(eq("Tag Attributes"));
    assertEquals(3, actualBuildMvelParametersResult.size());
    assertEquals("Parse Expression", actualBuildMvelParametersResult.get("category"));
    assertTrue(actualBuildMvelParametersResult.containsKey("request"));
    assertTrue(actualBuildMvelParametersResult.containsKey("time"));
  }

  /**
   * Test
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@code Parse Expression}.</li>
   *   <li>Then return size is four.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testBuildMvelParameters_givenParseExpression_thenReturnSizeIsFour() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();
    MockHttpServletRequest request = new MockHttpServletRequest();

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("product", "ThreadLocalManager.notify.orphans");
    tagAttributes.put("category", "Tag Attributes");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn("Parse Expression");

    // Act
    Map<String, Object> actualBuildMvelParametersResult = contentProcessor.buildMvelParameters(request, tagAttributes,
        context);

    // Assert
    verify(context, atLeast(1)).parseExpression(Mockito.<String>any());
    assertEquals(4, actualBuildMvelParametersResult.size());
    assertEquals("Parse Expression", actualBuildMvelParametersResult.get("product"));
    assertTrue(actualBuildMvelParametersResult.containsKey("category"));
    assertTrue(actualBuildMvelParametersResult.containsKey("request"));
    assertTrue(actualBuildMvelParametersResult.containsKey("time"));
  }

  /**
   * Test
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then {@code category} return {@link BroadleafRequestContext}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testBuildMvelParameters_thenCategoryReturnBroadleafRequestContext() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();
    MockHttpServletRequest request = new MockHttpServletRequest();

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("product", null);
    tagAttributes.put("category", "Tag Attributes");
    BroadleafRequestContext broadleafRequestContext = BroadleafRequestContext.getBroadleafRequestContext(true);
    TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");
    broadleafRequestContext.setTimeZone(timeZone);
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(broadleafRequestContext);

    // Act
    Map<String, Object> actualBuildMvelParametersResult = contentProcessor.buildMvelParameters(request, tagAttributes,
        context);

    // Assert
    verify(context).parseExpression(eq("Tag Attributes"));
    assertEquals(3, actualBuildMvelParametersResult.size());
    assertTrue(actualBuildMvelParametersResult.get("time") instanceof TimeDTO);
    Object getResult = actualBuildMvelParametersResult.get("category");
    assertTrue(getResult instanceof BroadleafRequestContext);
    assertTrue(actualBuildMvelParametersResult.containsKey("request"));
    assertSame(timeZone, ((BroadleafRequestContext) getResult).getTimeZone());
  }

  /**
   * Test
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return {@code category} is BroadleafRequestContext is
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testBuildMvelParameters_thenReturnCategoryIsBroadleafRequestContextIsTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();
    MockHttpServletRequest request = new MockHttpServletRequest();

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("product", null);
    tagAttributes.put("category", "Tag Attributes");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    BroadleafRequestContext broadleafRequestContext = BroadleafRequestContext.getBroadleafRequestContext(true);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(broadleafRequestContext);

    // Act
    Map<String, Object> actualBuildMvelParametersResult = contentProcessor.buildMvelParameters(request, tagAttributes,
        context);

    // Assert
    verify(context).parseExpression(eq("Tag Attributes"));
    assertEquals(3, actualBuildMvelParametersResult.size());
    assertTrue(actualBuildMvelParametersResult.containsKey("request"));
    assertTrue(actualBuildMvelParametersResult.containsKey("time"));
    assertSame(broadleafRequestContext, actualBuildMvelParametersResult.get("category"));
  }

  /**
   * Test
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testBuildMvelParameters_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();
    MockHttpServletRequest request = new MockHttpServletRequest();

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("product", null);
    tagAttributes.put("category", "Tag Attributes");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException("ThreadLocalManager.notify.orphans"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> contentProcessor.buildMvelParameters(request, tagAttributes, context));
    verify(context).parseExpression(eq("Tag Attributes"));
  }

  /**
   * Test
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testBuildMvelParameters_thenThrowIllegalArgumentException2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();
    MockHttpServletRequest request = new MockHttpServletRequest();

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("product", "ThreadLocalManager.notify.orphans");
    tagAttributes.put("category", "Tag Attributes");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException("ThreadLocalManager.notify.orphans"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> contentProcessor.buildMvelParameters(request, tagAttributes, context));
    verify(context).parseExpression(eq("ThreadLocalManager.notify.orphans"));
  }

  /**
   * Test
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>When {@link BroadleafTemplateContext}
   * {@link BroadleafTemplateContext#parseExpression(String)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testBuildMvelParameters_whenBroadleafTemplateContextParseExpressionReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();
    MockHttpServletRequest request = new MockHttpServletRequest();

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("product", null);
    tagAttributes.put("category", "Tag Attributes");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(null);

    // Act
    Map<String, Object> actualBuildMvelParametersResult = contentProcessor.buildMvelParameters(request, tagAttributes,
        context);

    // Assert
    verify(context).parseExpression(eq("Tag Attributes"));
    assertEquals(2, actualBuildMvelParametersResult.size());
    assertTrue(actualBuildMvelParametersResult.get("time") instanceof TimeDTO);
    assertTrue(actualBuildMvelParametersResult.containsKey("request"));
  }

  /**
   * Test
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>When {@link BroadleafTemplateContext}
   * {@link BroadleafTemplateContext#parseExpression(String)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testBuildMvelParameters_whenBroadleafTemplateContextParseExpressionReturnNull2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();
    MockHttpServletRequest request = new MockHttpServletRequest();

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("product", "ThreadLocalManager.notify.orphans");
    tagAttributes.put("category", "Tag Attributes");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(null);

    // Act
    Map<String, Object> actualBuildMvelParametersResult = contentProcessor.buildMvelParameters(request, tagAttributes,
        context);

    // Assert
    verify(context, atLeast(1)).parseExpression(Mockito.<String>any());
    assertEquals(2, actualBuildMvelParametersResult.size());
    assertTrue(actualBuildMvelParametersResult.get("time") instanceof TimeDTO);
    assertTrue(actualBuildMvelParametersResult.containsKey("request"));
  }

  /**
   * Test
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testBuildMvelParameters_whenHashMap_thenReturnSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act
    Map<String, Object> actualBuildMvelParametersResult = contentProcessor.buildMvelParameters(request, new HashMap<>(),
        mock(BroadleafTemplateContext.class));

    // Assert
    assertEquals(2, actualBuildMvelParametersResult.size());
    assertTrue(actualBuildMvelParametersResult.get("time") instanceof TimeDTO);
    assertTrue(actualBuildMvelParametersResult.containsKey("request"));
  }

  /**
   * Test {@link ContentProcessor#isSecure(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code HTTPS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentProcessor#isSecure(HttpServletRequest)}
   */
  @Test
  public void testIsSecure_givenHttps() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getScheme()).thenReturn("HTTPS");

    // Act
    boolean actualIsSecureResult = contentProcessor.isSecure(request);

    // Assert
    verify(request).getScheme();
    assertTrue(actualIsSecureResult);
  }

  /**
   * Test {@link ContentProcessor#isSecure(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then calls {@link ServletRequestWrapper#isSecure()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentProcessor#isSecure(HttpServletRequest)}
   */
  @Test
  public void testIsSecure_givenTrue_thenCallsIsSecure() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.isSecure()).thenReturn(true);
    when(request.getScheme()).thenReturn("Scheme");

    // Act
    boolean actualIsSecureResult = contentProcessor.isSecure(request);

    // Assert
    verify(request).getScheme();
    verify(request).isSecure();
    assertTrue(actualIsSecureResult);
  }

  /**
   * Test {@link ContentProcessor#isSecure(HttpServletRequest)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentProcessor#isSecure(HttpServletRequest)}
   */
  @Test
  public void testIsSecure_whenMockHttpServletRequest_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();

    // Act and Assert
    assertFalse(contentProcessor.isSecure(new MockHttpServletRequest()));
  }

  /**
   * Test {@link ContentProcessor#isSecure(HttpServletRequest)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentProcessor#isSecure(HttpServletRequest)}
   */
  @Test
  public void testIsSecure_whenNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ContentProcessor()).isSecure(null));
  }
}

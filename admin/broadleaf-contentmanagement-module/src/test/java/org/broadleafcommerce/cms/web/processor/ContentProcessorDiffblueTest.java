/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.web.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
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
   * Method under test: {@link ContentProcessor#getName()}
   */
  @Test
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("content", (new ContentProcessor()).getName());
  }

  /**
   * Method under test: {@link ContentProcessor#getPrecedence()}
   */
  @Test
  public void testGetPrecedence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(10000, (new ContentProcessor()).getPrecedence());
  }

  /**
   * Method under test:
   * {@link ContentProcessor#getAttributeValue(Map, String, String)}
   */
  @Test
  public void testGetAttributeValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();

    // Act and Assert
    assertEquals("42", contentProcessor.getAttributeValue(new HashMap<>(), "42", "42"));
  }

  /**
   * Method under test:
   * {@link ContentProcessor#getAttributeValue(Map, String, String)}
   */
  @Test
  public void testGetAttributeValue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("42", "foo");

    // Act and Assert
    assertEquals("foo", contentProcessor.getAttributeValue(tagAttributes, "42", "42"));
  }

  /**
   * Method under test:
   * {@link ContentProcessor#getAttributeValue(Map, String, String)}
   */
  @Test
  public void testGetAttributeValue3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertEquals("42", contentProcessor.getAttributeValue(tagAttributes, "42", "42"));
  }

  /**
   * Method under test:
   * {@link ContentProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testPopulateModelVariables() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> contentProcessor.populateModelVariables("Tag Name",
        new HashMap<>(), mock(BroadleafTemplateContext.class)));
  }

  /**
   * Method under test:
   * {@link ContentProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testPopulateModelVariables2() {
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
   * Method under test:
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testBuildMvelParameters() {
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
    assertNull(actualBuildMvelParametersResult.get("request"));
  }

  /**
   * Method under test:
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testBuildMvelParameters2() {
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
    assertTrue(actualBuildMvelParametersResult.get("time") instanceof TimeDTO);
    assertEquals("Parse Expression", actualBuildMvelParametersResult.get("category"));
    assertNull(actualBuildMvelParametersResult.get("request"));
  }

  /**
   * Method under test:
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testBuildMvelParameters3() {
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
    assertTrue(actualBuildMvelParametersResult.get("time") instanceof TimeDTO);
    assertEquals("Parse Expression", actualBuildMvelParametersResult.get("category"));
    assertEquals("Parse Expression", actualBuildMvelParametersResult.get("product"));
    assertNull(actualBuildMvelParametersResult.get("request"));
  }

  /**
   * Method under test:
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testBuildMvelParameters4() {
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
    assertNull(actualBuildMvelParametersResult.get("request"));
  }

  /**
   * Method under test:
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testBuildMvelParameters5() {
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
    assertTrue(actualBuildMvelParametersResult.get("time") instanceof TimeDTO);
    assertNull(actualBuildMvelParametersResult.get("request"));
    assertSame(broadleafRequestContext, actualBuildMvelParametersResult.get("category"));
  }

  /**
   * Method under test:
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testBuildMvelParameters6() {
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
   * Method under test:
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testBuildMvelParameters7() {
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
   * Method under test:
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testBuildMvelParameters8() {
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
    assertNull(actualBuildMvelParametersResult.get("request"));
  }

  /**
   * Method under test:
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testBuildMvelParameters9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();
    MockHttpServletRequest request = new MockHttpServletRequest();

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("product", null);
    tagAttributes.put("category", "Tag Attributes");
    BroadleafRequestContext broadleafRequestContext = BroadleafRequestContext.getBroadleafRequestContext(true);
    broadleafRequestContext.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(broadleafRequestContext);

    // Act
    Map<String, Object> actualBuildMvelParametersResult = contentProcessor.buildMvelParameters(request, tagAttributes,
        context);

    // Assert
    verify(context).parseExpression(eq("Tag Attributes"));
    assertEquals(3, actualBuildMvelParametersResult.size());
    assertTrue(actualBuildMvelParametersResult.get("time") instanceof TimeDTO);
    assertNull(actualBuildMvelParametersResult.get("request"));
    assertSame(broadleafRequestContext, actualBuildMvelParametersResult.get("category"));
  }

  /**
   * Method under test: {@link ContentProcessor#isSecure(HttpServletRequest)}
   */
  @Test
  public void testIsSecure() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();

    // Act and Assert
    assertFalse(contentProcessor.isSecure(new MockHttpServletRequest()));
  }

  /**
   * Method under test: {@link ContentProcessor#isSecure(HttpServletRequest)}
   */
  @Test
  public void testIsSecure2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ContentProcessor()).isSecure(null));
  }

  /**
   * Method under test: {@link ContentProcessor#isSecure(HttpServletRequest)}
   */
  @Test
  public void testIsSecure3() {
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
   * Method under test: {@link ContentProcessor#isSecure(HttpServletRequest)}
   */
  @Test
  public void testIsSecure4() {
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
}

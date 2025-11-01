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
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

public class UrlRewriteProcessorDiffblueTest {
  /**
   * Method under test: {@link UrlRewriteProcessor#getName()}
   */
  @Test
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("src", (new UrlRewriteProcessor()).getName());
  }

  /**
   * Method under test: {@link UrlRewriteProcessor#getPrecedence()}
   */
  @Test
  public void testGetPrecedence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(1000, (new UrlRewriteProcessor()).getPrecedence());
  }

  /**
   * Method under test:
   * {@link UrlRewriteProcessor#isRequestSecure(HttpServletRequest)}
   */
  @Test
  public void testIsRequestSecure() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UrlRewriteProcessor urlRewriteProcessor = new UrlRewriteProcessor();

    // Act and Assert
    assertFalse(urlRewriteProcessor.isRequestSecure(new MockHttpServletRequest()));
  }

  /**
   * Method under test:
   * {@link UrlRewriteProcessor#isRequestSecure(HttpServletRequest)}
   */
  @Test
  public void testIsRequestSecure2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UrlRewriteProcessor urlRewriteProcessor = new UrlRewriteProcessor();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.isSecure()).thenReturn(true);
    when(request.getScheme()).thenReturn("Scheme");

    // Act
    boolean actualIsRequestSecureResult = urlRewriteProcessor.isRequestSecure(request);

    // Assert
    verify(request).getScheme();
    verify(request).isSecure();
    assertTrue(actualIsRequestSecureResult);
  }

  /**
   * Method under test:
   * {@link UrlRewriteProcessor#isRequestSecure(HttpServletRequest)}
   */
  @Test
  public void testIsRequestSecure3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UrlRewriteProcessor urlRewriteProcessor = new UrlRewriteProcessor();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getScheme()).thenReturn("HTTPS");

    // Act
    boolean actualIsRequestSecureResult = urlRewriteProcessor.isRequestSecure(request);

    // Assert
    verify(request).getScheme();
    assertTrue(actualIsRequestSecureResult);
  }

  /**
   * Method under test: {@link UrlRewriteProcessor#isImageTag(String)}
   */
  @Test
  public void testIsImageTag() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new UrlRewriteProcessor()).isImageTag("https://example.org/example"));
    assertTrue((new UrlRewriteProcessor()).isImageTag("img"));
  }

  /**
   * Method under test: {@link UrlRewriteProcessor#isAdminRequest()}
   */
  @Test
  public void testIsAdminRequest() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new UrlRewriteProcessor()).isAdminRequest());
  }

  /**
   * Method under test:
   * {@link UrlRewriteProcessor#parsePath(String, BroadleafTemplateContext)}
   */
  @Test
  public void testParsePath() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UrlRewriteProcessor urlRewriteProcessor = new UrlRewriteProcessor();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn("Parse Expression");

    // Act
    String actualParsePathResult = urlRewriteProcessor.parsePath("https://example.org/example", context);

    // Assert
    verify(context).parseExpression(eq("https://example.org/example"));
    assertEquals("Parse Expression", actualParsePathResult);
  }

  /**
   * Method under test:
   * {@link UrlRewriteProcessor#parsePath(String, BroadleafTemplateContext)}
   */
  @Test
  public void testParsePath2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UrlRewriteProcessor urlRewriteProcessor = new UrlRewriteProcessor();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn("Parse Expression");

    // Act
    String actualParsePathResult = urlRewriteProcessor.parsePath("/", context);

    // Assert
    verify(context).parseExpression(eq("@{ / }"));
    assertEquals("Parse Expression", actualParsePathResult);
  }

  /**
   * Method under test: {@link UrlRewriteProcessor#getFileExtension(String)}
   */
  @Test
  public void testGetFileExtension() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("org/example", (new UrlRewriteProcessor()).getFileExtension("https://example.org/example"));
    assertEquals("org/example", (new UrlRewriteProcessor()).getFileExtension("https://example.org/example?"));
  }

  /**
   * Method under test:
   * {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}
   */
  @Test
  public void testGetDefaultFileTypeImagePath() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("/img/admin/file-unkn.png",
        (new UrlRewriteProcessor()).getDefaultFileTypeImagePath("https://example.org/example"));
    assertEquals("/img/admin/file-txt.png", (new UrlRewriteProcessor()).getDefaultFileTypeImagePath("txt"));
    assertEquals("/img/admin/file-pdf.png", (new UrlRewriteProcessor()).getDefaultFileTypeImagePath("pdf"));
    assertEquals("/img/admin/file-doc.png", (new UrlRewriteProcessor()).getDefaultFileTypeImagePath("doc"));
    assertEquals("/img/admin/file-doc.png", (new UrlRewriteProcessor()).getDefaultFileTypeImagePath("docx"));
    assertEquals("/img/admin/file-xls.png", (new UrlRewriteProcessor()).getDefaultFileTypeImagePath("xls"));
    assertEquals("/img/admin/file-xls.png", (new UrlRewriteProcessor()).getDefaultFileTypeImagePath("xlsx"));
    assertEquals("/img/admin/file-ppt.png", (new UrlRewriteProcessor()).getDefaultFileTypeImagePath("ppt"));
    assertEquals("/img/admin/file-ppt.png", (new UrlRewriteProcessor()).getDefaultFileTypeImagePath("pptx"));
  }

  /**
   * Method under test: {@link UrlRewriteProcessor#getQueryString(String)}
   */
  @Test
  public void testGetQueryString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new UrlRewriteProcessor()).getQueryString("https://example.org/example"));
    assertEquals("?", (new UrlRewriteProcessor()).getQueryString("https://example.org/example?"));
  }
}

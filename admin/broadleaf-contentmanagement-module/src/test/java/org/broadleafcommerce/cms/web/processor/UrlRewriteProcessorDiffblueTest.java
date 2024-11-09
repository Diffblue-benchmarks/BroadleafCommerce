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
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

public class UrlRewriteProcessorDiffblueTest {
  /**
   * Test {@link UrlRewriteProcessor#getName()}.
   * <p>
   * Method under test: {@link UrlRewriteProcessor#getName()}
   */
  @Test
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("src", (new UrlRewriteProcessor()).getName());
  }

  /**
   * Test {@link UrlRewriteProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link UrlRewriteProcessor#getPrecedence()}
   */
  @Test
  public void testGetPrecedence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(1000, (new UrlRewriteProcessor()).getPrecedence());
  }

  /**
   * Test {@link UrlRewriteProcessor#isRequestSecure(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code HTTPS}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UrlRewriteProcessor#isRequestSecure(HttpServletRequest)}
   */
  @Test
  public void testIsRequestSecure_givenHttps() {
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
   * Test {@link UrlRewriteProcessor#isRequestSecure(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then calls {@link ServletRequestWrapper#isSecure()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UrlRewriteProcessor#isRequestSecure(HttpServletRequest)}
   */
  @Test
  public void testIsRequestSecure_givenTrue_thenCallsIsSecure() {
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
   * Test {@link UrlRewriteProcessor#isRequestSecure(HttpServletRequest)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UrlRewriteProcessor#isRequestSecure(HttpServletRequest)}
   */
  @Test
  public void testIsRequestSecure_whenMockHttpServletRequest_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UrlRewriteProcessor urlRewriteProcessor = new UrlRewriteProcessor();

    // Act and Assert
    assertFalse(urlRewriteProcessor.isRequestSecure(new MockHttpServletRequest()));
  }

  /**
   * Test {@link UrlRewriteProcessor#isImageTag(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlRewriteProcessor#isImageTag(String)}
   */
  @Test
  public void testIsImageTag_whenHttpsExampleOrgExample_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new UrlRewriteProcessor()).isImageTag("https://example.org/example"));
  }

  /**
   * Test {@link UrlRewriteProcessor#isImageTag(String)}.
   * <ul>
   *   <li>When {@code img}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlRewriteProcessor#isImageTag(String)}
   */
  @Test
  public void testIsImageTag_whenImg_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new UrlRewriteProcessor()).isImageTag("img"));
  }

  /**
   * Test {@link UrlRewriteProcessor#isAdminRequest()}.
   * <p>
   * Method under test: {@link UrlRewriteProcessor#isAdminRequest()}
   */
  @Test
  public void testIsAdminRequest() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new UrlRewriteProcessor()).isAdminRequest());
  }

  /**
   * Test {@link UrlRewriteProcessor#parsePath(String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UrlRewriteProcessor#parsePath(String, BroadleafTemplateContext)}
   */
  @Test
  public void testParsePath_whenHttpsExampleOrgExample() {
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
   * Test {@link UrlRewriteProcessor#parsePath(String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>When {@code /}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UrlRewriteProcessor#parsePath(String, BroadleafTemplateContext)}
   */
  @Test
  public void testParsePath_whenSlash() {
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
   * Test {@link UrlRewriteProcessor#getFileExtension(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlRewriteProcessor#getFileExtension(String)}
   */
  @Test
  public void testGetFileExtension_whenHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("org/example", (new UrlRewriteProcessor()).getFileExtension("https://example.org/example"));
    assertEquals("org/example", (new UrlRewriteProcessor()).getFileExtension("https://example.org/example?"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}.
   * <ul>
   *   <li>Then return {@code /img/admin/file-unkn.png}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}
   */
  @Test
  public void testGetDefaultFileTypeImagePath_thenReturnImgAdminFileUnknPng() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("/img/admin/file-unkn.png",
        (new UrlRewriteProcessor()).getDefaultFileTypeImagePath("https://example.org/example"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}.
   * <ul>
   *   <li>When {@code doc}.</li>
   *   <li>Then return {@code /img/admin/file-doc.png}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}
   */
  @Test
  public void testGetDefaultFileTypeImagePath_whenDoc_thenReturnImgAdminFileDocPng() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("/img/admin/file-doc.png", (new UrlRewriteProcessor()).getDefaultFileTypeImagePath("doc"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}.
   * <ul>
   *   <li>When {@code docx}.</li>
   *   <li>Then return {@code /img/admin/file-doc.png}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}
   */
  @Test
  public void testGetDefaultFileTypeImagePath_whenDocx_thenReturnImgAdminFileDocPng() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("/img/admin/file-doc.png", (new UrlRewriteProcessor()).getDefaultFileTypeImagePath("docx"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}.
   * <ul>
   *   <li>When {@code pdf}.</li>
   *   <li>Then return {@code /img/admin/file-pdf.png}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}
   */
  @Test
  public void testGetDefaultFileTypeImagePath_whenPdf_thenReturnImgAdminFilePdfPng() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("/img/admin/file-pdf.png", (new UrlRewriteProcessor()).getDefaultFileTypeImagePath("pdf"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}.
   * <ul>
   *   <li>When {@code ppt}.</li>
   *   <li>Then return {@code /img/admin/file-ppt.png}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}
   */
  @Test
  public void testGetDefaultFileTypeImagePath_whenPpt_thenReturnImgAdminFilePptPng() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("/img/admin/file-ppt.png", (new UrlRewriteProcessor()).getDefaultFileTypeImagePath("ppt"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}.
   * <ul>
   *   <li>When {@code pptx}.</li>
   *   <li>Then return {@code /img/admin/file-ppt.png}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}
   */
  @Test
  public void testGetDefaultFileTypeImagePath_whenPptx_thenReturnImgAdminFilePptPng() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("/img/admin/file-ppt.png", (new UrlRewriteProcessor()).getDefaultFileTypeImagePath("pptx"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}.
   * <ul>
   *   <li>When {@code txt}.</li>
   *   <li>Then return {@code /img/admin/file-txt.png}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}
   */
  @Test
  public void testGetDefaultFileTypeImagePath_whenTxt_thenReturnImgAdminFileTxtPng() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("/img/admin/file-txt.png", (new UrlRewriteProcessor()).getDefaultFileTypeImagePath("txt"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}.
   * <ul>
   *   <li>When {@code xls}.</li>
   *   <li>Then return {@code /img/admin/file-xls.png}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}
   */
  @Test
  public void testGetDefaultFileTypeImagePath_whenXls_thenReturnImgAdminFileXlsPng() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("/img/admin/file-xls.png", (new UrlRewriteProcessor()).getDefaultFileTypeImagePath("xls"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}.
   * <ul>
   *   <li>When {@code xlsx}.</li>
   *   <li>Then return {@code /img/admin/file-xls.png}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}
   */
  @Test
  public void testGetDefaultFileTypeImagePath_whenXlsx_thenReturnImgAdminFileXlsPng() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("/img/admin/file-xls.png", (new UrlRewriteProcessor()).getDefaultFileTypeImagePath("xlsx"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getQueryString(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlRewriteProcessor#getQueryString(String)}
   */
  @Test
  public void testGetQueryString_whenHttpsExampleOrgExample_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new UrlRewriteProcessor()).getQueryString("https://example.org/example"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getQueryString(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example?}.</li>
   *   <li>Then return {@code ?}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlRewriteProcessor#getQueryString(String)}
   */
  @Test
  public void testGetQueryString_whenHttpsExampleOrgExample_thenReturnQuestionMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("?", (new UrlRewriteProcessor()).getQueryString("https://example.org/example?"));
  }
}

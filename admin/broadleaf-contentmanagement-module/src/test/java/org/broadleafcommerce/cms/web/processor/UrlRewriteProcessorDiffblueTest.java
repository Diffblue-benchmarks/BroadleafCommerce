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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@RunWith(MockitoJUnitRunner.class)
public class UrlRewriteProcessorDiffblueTest {
  @InjectMocks
  private UrlRewriteProcessor urlRewriteProcessor;

  /**
   * Test {@link UrlRewriteProcessor#getName()}.
   * <p>
   * Method under test: {@link UrlRewriteProcessor#getName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlRewriteProcessor.getName()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int UrlRewriteProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(1000, urlRewriteProcessor.getPrecedence());
  }

  /**
   * Test {@link UrlRewriteProcessor#isRequestSecure(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code HTTPS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlRewriteProcessor#isRequestSecure(HttpServletRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UrlRewriteProcessor.isRequestSecure(HttpServletRequest)"})
  public void testIsRequestSecure_givenHttps() {
    // Arrange
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
   * Method under test: {@link UrlRewriteProcessor#isRequestSecure(HttpServletRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UrlRewriteProcessor.isRequestSecure(HttpServletRequest)"})
  public void testIsRequestSecure_givenTrue_thenCallsIsSecure() {
    // Arrange
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
   * Method under test: {@link UrlRewriteProcessor#isRequestSecure(HttpServletRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UrlRewriteProcessor.isRequestSecure(HttpServletRequest)"})
  public void testIsRequestSecure_whenMockHttpServletRequest_thenReturnFalse() {
    // Arrange, Act and Assert
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UrlRewriteProcessor.isImageTag(String)"})
  public void testIsImageTag_whenHttpsExampleOrgExample_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(urlRewriteProcessor.isImageTag("https://example.org/example"));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UrlRewriteProcessor.isImageTag(String)"})
  public void testIsImageTag_whenImg_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(urlRewriteProcessor.isImageTag("img"));
  }

  /**
   * Test {@link UrlRewriteProcessor#isAdminRequest()}.
   * <p>
   * Method under test: {@link UrlRewriteProcessor#isAdminRequest()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UrlRewriteProcessor.isAdminRequest()"})
  public void testIsAdminRequest() {
    // Arrange, Act and Assert
    assertFalse(urlRewriteProcessor.isAdminRequest());
  }

  /**
   * Test {@link UrlRewriteProcessor#parsePath(String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlRewriteProcessor#parsePath(String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlRewriteProcessor.parsePath(String, BroadleafTemplateContext)"})
  public void testParsePath_whenHttpsExampleOrgExample() {
    // Arrange
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
   * Method under test: {@link UrlRewriteProcessor#parsePath(String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlRewriteProcessor.parsePath(String, BroadleafTemplateContext)"})
  public void testParsePath_whenSlash() {
    // Arrange
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlRewriteProcessor.getFileExtension(String)"})
  public void testGetFileExtension_whenHttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals("org/example", urlRewriteProcessor.getFileExtension("https://example.org/example"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getFileExtension(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example?}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlRewriteProcessor#getFileExtension(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlRewriteProcessor.getFileExtension(String)"})
  public void testGetFileExtension_whenHttpsExampleOrgExample2() {
    // Arrange, Act and Assert
    assertEquals("org/example", urlRewriteProcessor.getFileExtension("https://example.org/example?"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}.
   * <ul>
   *   <li>Then return {@code /img/admin/file-unkn.png}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlRewriteProcessor.getDefaultFileTypeImagePath(String)"})
  public void testGetDefaultFileTypeImagePath_thenReturnImgAdminFileUnknPng() {
    // Arrange, Act and Assert
    assertEquals("/img/admin/file-unkn.png",
        urlRewriteProcessor.getDefaultFileTypeImagePath("https://example.org/example"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}.
   * <ul>
   *   <li>When {@code doc}.</li>
   *   <li>Then return {@code /img/admin/file-doc.png}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlRewriteProcessor.getDefaultFileTypeImagePath(String)"})
  public void testGetDefaultFileTypeImagePath_whenDoc_thenReturnImgAdminFileDocPng() {
    // Arrange, Act and Assert
    assertEquals("/img/admin/file-doc.png", urlRewriteProcessor.getDefaultFileTypeImagePath("doc"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}.
   * <ul>
   *   <li>When {@code docx}.</li>
   *   <li>Then return {@code /img/admin/file-doc.png}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlRewriteProcessor.getDefaultFileTypeImagePath(String)"})
  public void testGetDefaultFileTypeImagePath_whenDocx_thenReturnImgAdminFileDocPng() {
    // Arrange, Act and Assert
    assertEquals("/img/admin/file-doc.png", urlRewriteProcessor.getDefaultFileTypeImagePath("docx"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}.
   * <ul>
   *   <li>When {@code pdf}.</li>
   *   <li>Then return {@code /img/admin/file-pdf.png}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlRewriteProcessor.getDefaultFileTypeImagePath(String)"})
  public void testGetDefaultFileTypeImagePath_whenPdf_thenReturnImgAdminFilePdfPng() {
    // Arrange, Act and Assert
    assertEquals("/img/admin/file-pdf.png", urlRewriteProcessor.getDefaultFileTypeImagePath("pdf"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}.
   * <ul>
   *   <li>When {@code ppt}.</li>
   *   <li>Then return {@code /img/admin/file-ppt.png}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlRewriteProcessor.getDefaultFileTypeImagePath(String)"})
  public void testGetDefaultFileTypeImagePath_whenPpt_thenReturnImgAdminFilePptPng() {
    // Arrange, Act and Assert
    assertEquals("/img/admin/file-ppt.png", urlRewriteProcessor.getDefaultFileTypeImagePath("ppt"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}.
   * <ul>
   *   <li>When {@code pptx}.</li>
   *   <li>Then return {@code /img/admin/file-ppt.png}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlRewriteProcessor.getDefaultFileTypeImagePath(String)"})
  public void testGetDefaultFileTypeImagePath_whenPptx_thenReturnImgAdminFilePptPng() {
    // Arrange, Act and Assert
    assertEquals("/img/admin/file-ppt.png", urlRewriteProcessor.getDefaultFileTypeImagePath("pptx"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}.
   * <ul>
   *   <li>When {@code txt}.</li>
   *   <li>Then return {@code /img/admin/file-txt.png}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlRewriteProcessor.getDefaultFileTypeImagePath(String)"})
  public void testGetDefaultFileTypeImagePath_whenTxt_thenReturnImgAdminFileTxtPng() {
    // Arrange, Act and Assert
    assertEquals("/img/admin/file-txt.png", urlRewriteProcessor.getDefaultFileTypeImagePath("txt"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}.
   * <ul>
   *   <li>When {@code xls}.</li>
   *   <li>Then return {@code /img/admin/file-xls.png}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlRewriteProcessor.getDefaultFileTypeImagePath(String)"})
  public void testGetDefaultFileTypeImagePath_whenXls_thenReturnImgAdminFileXlsPng() {
    // Arrange, Act and Assert
    assertEquals("/img/admin/file-xls.png", urlRewriteProcessor.getDefaultFileTypeImagePath("xls"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}.
   * <ul>
   *   <li>When {@code xlsx}.</li>
   *   <li>Then return {@code /img/admin/file-xls.png}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlRewriteProcessor.getDefaultFileTypeImagePath(String)"})
  public void testGetDefaultFileTypeImagePath_whenXlsx_thenReturnImgAdminFileXlsPng() {
    // Arrange, Act and Assert
    assertEquals("/img/admin/file-xls.png", urlRewriteProcessor.getDefaultFileTypeImagePath("xlsx"));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlRewriteProcessor.getQueryString(String)"})
  public void testGetQueryString_whenHttpsExampleOrgExample_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", urlRewriteProcessor.getQueryString("https://example.org/example"));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlRewriteProcessor.getQueryString(String)"})
  public void testGetQueryString_whenHttpsExampleOrgExample_thenReturnQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?", urlRewriteProcessor.getQueryString("https://example.org/example?"));
  }
}

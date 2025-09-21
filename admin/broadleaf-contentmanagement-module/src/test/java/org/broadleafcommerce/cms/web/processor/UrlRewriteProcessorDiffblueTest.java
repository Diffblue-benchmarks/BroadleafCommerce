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
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.file.service.StaticAssetPathService;
import org.broadleafcommerce.presentation.model.BroadleafAttributeModifier;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@RunWith(MockitoJUnitRunner.class)
public class UrlRewriteProcessorDiffblueTest {
  @Mock private StaticAssetPathService staticAssetPathService;

  @InjectMocks private UrlRewriteProcessor urlRewriteProcessor;

  /**
   * Test {@link UrlRewriteProcessor#getName()}.
   *
   * <p>Method under test: {@link UrlRewriteProcessor#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlRewriteProcessor.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("src", new UrlRewriteProcessor().getName());
  }

  /**
   * Test {@link UrlRewriteProcessor#getPrecedence()}.
   *
   * <p>Method under test: {@link UrlRewriteProcessor#getPrecedence()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int UrlRewriteProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(1000, urlRewriteProcessor.getPrecedence());
  }

  /**
   * Test {@link UrlRewriteProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@link HrefUrlRewriteProcessor} (default constructor).
   *   <li>Then return Added {@code href} is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link UrlRewriteProcessor#getModifiedAttributes(String, Map, String,
   * String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier UrlRewriteProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_givenHrefUrlRewriteProcessor_thenReturnAddedHrefIsDot() {
    // Arrange
    HrefUrlRewriteProcessor hrefUrlRewriteProcessor = new HrefUrlRewriteProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(".");

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        hrefUrlRewriteProcessor.getModifiedAttributes(
            "https://example.org/example",
            tagAttributes,
            "https://example.org/example",
            "https://example.org/example",
            context);

    // Assert
    verify(context).parseExpression("https://example.org/example");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals(".", added.get("href"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link UrlRewriteProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code src} is {@code Convert Asset Path}.
   * </ul>
   *
   * <p>Method under test: {@link UrlRewriteProcessor#getModifiedAttributes(String, Map, String,
   * String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier UrlRewriteProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedSrcIsConvertAssetPath() {
    // Arrange
    when(staticAssetPathService.convertAssetPath(
            Mockito.<String>any(), Mockito.<String>any(), anyBoolean()))
        .thenReturn("Convert Asset Path");
    HashMap<String, String> tagAttributes = new HashMap<>();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn("Parse Expression");

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        urlRewriteProcessor.getModifiedAttributes(
            "https://example.org/example",
            tagAttributes,
            "https://example.org/example",
            "https://example.org/example",
            context);

    // Assert
    verify(staticAssetPathService).convertAssetPath("Parse Expression", null, true);
    verify(context).parseExpression("https://example.org/example");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("Convert Asset Path", added.get("src"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link UrlRewriteProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then return Added {@code src} is {@code Convert Asset Path}.
   * </ul>
   *
   * <p>Method under test: {@link UrlRewriteProcessor#getModifiedAttributes(String, Map, String,
   * String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier UrlRewriteProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_whenSlash_thenReturnAddedSrcIsConvertAssetPath() {
    // Arrange
    when(staticAssetPathService.convertAssetPath(
            Mockito.<String>any(), Mockito.<String>any(), anyBoolean()))
        .thenReturn("Convert Asset Path");
    HashMap<String, String> tagAttributes = new HashMap<>();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn("Parse Expression");

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        urlRewriteProcessor.getModifiedAttributes(
            "https://example.org/example",
            tagAttributes,
            "https://example.org/example",
            "/",
            context);

    // Assert
    verify(staticAssetPathService).convertAssetPath("Parse Expression", null, true);
    verify(context).parseExpression("@{ / }");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("Convert Asset Path", added.get("src"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link UrlRewriteProcessor#getFullAssetPath(String, String, BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@code Parse Expression}.
   *   <li>Then return {@code Convert Asset Path}.
   * </ul>
   *
   * <p>Method under test: {@link UrlRewriteProcessor#getFullAssetPath(String, String,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String UrlRewriteProcessor.getFullAssetPath(String, String, BroadleafTemplateContext)"
  })
  public void testGetFullAssetPath_givenParseExpression_thenReturnConvertAssetPath() {
    // Arrange
    when(staticAssetPathService.convertAssetPath(
            Mockito.<String>any(), Mockito.<String>any(), anyBoolean()))
        .thenReturn("Convert Asset Path");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn("Parse Expression");

    // Act
    String actualFullAssetPath =
        urlRewriteProcessor.getFullAssetPath(
            "https://example.org/example", "https://example.org/example", context);

    // Assert
    verify(staticAssetPathService).convertAssetPath("Parse Expression", null, true);
    verify(context).parseExpression("https://example.org/example");
    assertEquals("Convert Asset Path", actualFullAssetPath);
  }

  /**
   * Test {@link UrlRewriteProcessor#getFullAssetPath(String, String, BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@code Parse Expression}.
   *   <li>When {@code /}.
   *   <li>Then return {@code Convert Asset Path}.
   * </ul>
   *
   * <p>Method under test: {@link UrlRewriteProcessor#getFullAssetPath(String, String,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String UrlRewriteProcessor.getFullAssetPath(String, String, BroadleafTemplateContext)"
  })
  public void testGetFullAssetPath_givenParseExpression_whenSlash_thenReturnConvertAssetPath() {
    // Arrange
    when(staticAssetPathService.convertAssetPath(
            Mockito.<String>any(), Mockito.<String>any(), anyBoolean()))
        .thenReturn("Convert Asset Path");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn("Parse Expression");

    // Act
    String actualFullAssetPath =
        urlRewriteProcessor.getFullAssetPath("https://example.org/example", "/", context);

    // Assert
    verify(staticAssetPathService).convertAssetPath("Parse Expression", null, true);
    verify(context).parseExpression("@{ / }");
    assertEquals("Convert Asset Path", actualFullAssetPath);
  }

  /**
   * Test {@link UrlRewriteProcessor#isRequestSecure(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Given {@code HTTPS}.
   * </ul>
   *
   * <p>Method under test: {@link UrlRewriteProcessor#isRequestSecure(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then calls {@link DefaultMultipartHttpServletRequest#isSecure()}.
   * </ul>
   *
   * <p>Method under test: {@link UrlRewriteProcessor#isRequestSecure(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UrlRewriteProcessor#isRequestSecure(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UrlRewriteProcessor.isRequestSecure(HttpServletRequest)"})
  public void testIsRequestSecure_whenMockHttpServletRequest_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(urlRewriteProcessor.isRequestSecure(new MockHttpServletRequest()));
  }

  /**
   * Test {@link UrlRewriteProcessor#isImageTag(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UrlRewriteProcessor#isImageTag(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UrlRewriteProcessor.isImageTag(String)"})
  public void testIsImageTag_whenHttpsExampleOrgExample_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(urlRewriteProcessor.isImageTag("https://example.org/example"));
  }

  /**
   * Test {@link UrlRewriteProcessor#isImageTag(String)}.
   *
   * <ul>
   *   <li>When {@code img}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link UrlRewriteProcessor#isImageTag(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UrlRewriteProcessor.isImageTag(String)"})
  public void testIsImageTag_whenImg_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(urlRewriteProcessor.isImageTag("img"));
  }

  /**
   * Test {@link UrlRewriteProcessor#parsePath(String, BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link UrlRewriteProcessor#parsePath(String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlRewriteProcessor.parsePath(String, BroadleafTemplateContext)"})
  public void testParsePath_whenHttpsExampleOrgExample() {
    // Arrange
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn("Parse Expression");

    // Act
    String actualParsePathResult =
        urlRewriteProcessor.parsePath("https://example.org/example", context);

    // Assert
    verify(context).parseExpression("https://example.org/example");
    assertEquals("Parse Expression", actualParsePathResult);
  }

  /**
   * Test {@link UrlRewriteProcessor#parsePath(String, BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>When {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link UrlRewriteProcessor#parsePath(String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlRewriteProcessor.parsePath(String, BroadleafTemplateContext)"})
  public void testParsePath_whenSlash() {
    // Arrange
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn("Parse Expression");

    // Act
    String actualParsePathResult = urlRewriteProcessor.parsePath("/", context);

    // Assert
    verify(context).parseExpression("@{ / }");
    assertEquals("Parse Expression", actualParsePathResult);
  }

  /**
   * Test {@link UrlRewriteProcessor#getFileExtension(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link UrlRewriteProcessor#getFileExtension(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlRewriteProcessor.getFileExtension(String)"})
  public void testGetFileExtension_whenHttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals(
        "org/example", urlRewriteProcessor.getFileExtension("https://example.org/example"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getFileExtension(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example?}.
   * </ul>
   *
   * <p>Method under test: {@link UrlRewriteProcessor#getFileExtension(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlRewriteProcessor.getFileExtension(String)"})
  public void testGetFileExtension_whenHttpsExampleOrgExample2() {
    // Arrange, Act and Assert
    assertEquals(
        "org/example", urlRewriteProcessor.getFileExtension("https://example.org/example?"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}.
   *
   * <ul>
   *   <li>Then return {@code /img/admin/file-unkn.png}.
   * </ul>
   *
   * <p>Method under test: {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlRewriteProcessor.getDefaultFileTypeImagePath(String)"})
  public void testGetDefaultFileTypeImagePath_thenReturnImgAdminFileUnknPng() {
    // Arrange, Act and Assert
    assertEquals(
        "/img/admin/file-unkn.png",
        urlRewriteProcessor.getDefaultFileTypeImagePath("https://example.org/example"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}.
   *
   * <ul>
   *   <li>When {@code doc}.
   *   <li>Then return {@code /img/admin/file-doc.png}.
   * </ul>
   *
   * <p>Method under test: {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlRewriteProcessor.getDefaultFileTypeImagePath(String)"})
  public void testGetDefaultFileTypeImagePath_whenDoc_thenReturnImgAdminFileDocPng() {
    // Arrange, Act and Assert
    assertEquals("/img/admin/file-doc.png", urlRewriteProcessor.getDefaultFileTypeImagePath("doc"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}.
   *
   * <ul>
   *   <li>When {@code docx}.
   *   <li>Then return {@code /img/admin/file-doc.png}.
   * </ul>
   *
   * <p>Method under test: {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlRewriteProcessor.getDefaultFileTypeImagePath(String)"})
  public void testGetDefaultFileTypeImagePath_whenDocx_thenReturnImgAdminFileDocPng() {
    // Arrange, Act and Assert
    assertEquals(
        "/img/admin/file-doc.png", urlRewriteProcessor.getDefaultFileTypeImagePath("docx"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}.
   *
   * <ul>
   *   <li>When {@code pdf}.
   *   <li>Then return {@code /img/admin/file-pdf.png}.
   * </ul>
   *
   * <p>Method under test: {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlRewriteProcessor.getDefaultFileTypeImagePath(String)"})
  public void testGetDefaultFileTypeImagePath_whenPdf_thenReturnImgAdminFilePdfPng() {
    // Arrange, Act and Assert
    assertEquals("/img/admin/file-pdf.png", urlRewriteProcessor.getDefaultFileTypeImagePath("pdf"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}.
   *
   * <ul>
   *   <li>When {@code ppt}.
   *   <li>Then return {@code /img/admin/file-ppt.png}.
   * </ul>
   *
   * <p>Method under test: {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlRewriteProcessor.getDefaultFileTypeImagePath(String)"})
  public void testGetDefaultFileTypeImagePath_whenPpt_thenReturnImgAdminFilePptPng() {
    // Arrange, Act and Assert
    assertEquals("/img/admin/file-ppt.png", urlRewriteProcessor.getDefaultFileTypeImagePath("ppt"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}.
   *
   * <ul>
   *   <li>When {@code pptx}.
   *   <li>Then return {@code /img/admin/file-ppt.png}.
   * </ul>
   *
   * <p>Method under test: {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlRewriteProcessor.getDefaultFileTypeImagePath(String)"})
  public void testGetDefaultFileTypeImagePath_whenPptx_thenReturnImgAdminFilePptPng() {
    // Arrange, Act and Assert
    assertEquals(
        "/img/admin/file-ppt.png", urlRewriteProcessor.getDefaultFileTypeImagePath("pptx"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}.
   *
   * <ul>
   *   <li>When {@code txt}.
   *   <li>Then return {@code /img/admin/file-txt.png}.
   * </ul>
   *
   * <p>Method under test: {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlRewriteProcessor.getDefaultFileTypeImagePath(String)"})
  public void testGetDefaultFileTypeImagePath_whenTxt_thenReturnImgAdminFileTxtPng() {
    // Arrange, Act and Assert
    assertEquals("/img/admin/file-txt.png", urlRewriteProcessor.getDefaultFileTypeImagePath("txt"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}.
   *
   * <ul>
   *   <li>When {@code xls}.
   *   <li>Then return {@code /img/admin/file-xls.png}.
   * </ul>
   *
   * <p>Method under test: {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlRewriteProcessor.getDefaultFileTypeImagePath(String)"})
  public void testGetDefaultFileTypeImagePath_whenXls_thenReturnImgAdminFileXlsPng() {
    // Arrange, Act and Assert
    assertEquals("/img/admin/file-xls.png", urlRewriteProcessor.getDefaultFileTypeImagePath("xls"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}.
   *
   * <ul>
   *   <li>When {@code xlsx}.
   *   <li>Then return {@code /img/admin/file-xls.png}.
   * </ul>
   *
   * <p>Method under test: {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlRewriteProcessor.getDefaultFileTypeImagePath(String)"})
  public void testGetDefaultFileTypeImagePath_whenXlsx_thenReturnImgAdminFileXlsPng() {
    // Arrange, Act and Assert
    assertEquals(
        "/img/admin/file-xls.png", urlRewriteProcessor.getDefaultFileTypeImagePath("xlsx"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getQueryString(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link UrlRewriteProcessor#getQueryString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlRewriteProcessor.getQueryString(String)"})
  public void testGetQueryString_whenHttpsExampleOrgExample_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", urlRewriteProcessor.getQueryString("https://example.org/example"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getQueryString(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example?}.
   *   <li>Then return {@code ?}.
   * </ul>
   *
   * <p>Method under test: {@link UrlRewriteProcessor#getQueryString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlRewriteProcessor.getQueryString(String)"})
  public void testGetQueryString_whenHttpsExampleOrgExample_thenReturnQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?", urlRewriteProcessor.getQueryString("https://example.org/example?"));
  }
}

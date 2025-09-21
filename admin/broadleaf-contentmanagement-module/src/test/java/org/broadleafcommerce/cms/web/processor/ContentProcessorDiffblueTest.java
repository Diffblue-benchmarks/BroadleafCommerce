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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.cms.structure.domain.StructuredContentType;
import org.broadleafcommerce.cms.structure.domain.StructuredContentTypeImpl;
import org.broadleafcommerce.cms.structure.service.StructuredContentService;
import org.broadleafcommerce.common.TimeDTO;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.sandbox.domain.SandBox;
import org.broadleafcommerce.common.sandbox.domain.SandBoxImpl;
import org.broadleafcommerce.common.structure.dto.StructuredContentDTO;
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
public class ContentProcessorDiffblueTest {
  @InjectMocks private ContentProcessor contentProcessor;

  @Mock private ContentProcessorExtensionManager contentProcessorExtensionManager;

  @Mock private StructuredContentService structuredContentService;

  /**
   * Test {@link ContentProcessor#getName()}.
   *
   * <p>Method under test: {@link ContentProcessor#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ContentProcessor.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("content", new ContentProcessor().getName());
  }

  /**
   * Test {@link ContentProcessor#getPrecedence()}.
   *
   * <p>Method under test: {@link ContentProcessor#getPrecedence()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ContentProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(10000, contentProcessor.getPrecedence());
  }

  /**
   * Test {@link ContentProcessor#getAttributeValue(Map, String, String)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashMap#HashMap()} {@code 42} is {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link ContentProcessor#getAttributeValue(Map, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ContentProcessor.getAttributeValue(Map, String, String)"})
  public void testGetAttributeValue_given42_whenHashMap42IsFoo_thenReturnFoo() {
    // Arrange
    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("42", "foo");

    // Act and Assert
    assertEquals("foo", contentProcessor.getAttributeValue(tagAttributes, "42", "42"));
  }

  /**
   * Test {@link ContentProcessor#getAttributeValue(Map, String, String)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ContentProcessor#getAttributeValue(Map, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ContentProcessor.getAttributeValue(Map, String, String)"})
  public void testGetAttributeValue_whenHashMap_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", contentProcessor.getAttributeValue(new HashMap<>(), "42", "42"));
  }

  /**
   * Test {@link ContentProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link HashMap#HashMap()} {@code contentType} is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ContentProcessor#populateModelVariables(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map ContentProcessor.populateModelVariables(String, Map, BroadleafTemplateContext)"
  })
  public void testPopulateModelVariables_givenEmptyString_whenHashMapContentTypeIsEmptyString() {
    // Arrange
    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("contentType", "");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            contentProcessor.populateModelVariables(
                "Tag Name", tagAttributes, mock(BroadleafTemplateContext.class)));
  }

  /**
   * Test {@link ContentProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ContentProcessor#populateModelVariables(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map ContentProcessor.populateModelVariables(String, Map, BroadleafTemplateContext)"
  })
  public void testPopulateModelVariables_whenHashMap_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            contentProcessor.populateModelVariables(
                "Tag Name", new HashMap<>(), mock(BroadleafTemplateContext.class)));
  }

  /**
   * Test {@link ContentProcessor#getContentItems(String, Integer, HttpServletRequest, Map, SandBox,
   * StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link ContentProcessor#getContentItems(String, Integer,
   * HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ContentProcessor.getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)"
  })
  public void testGetContentItems() {
    // Arrange
    ContentProcessorExtensionHandler contentProcessorExtensionHandler =
        mock(ContentProcessorExtensionHandler.class);
    when(contentProcessorExtensionHandler.addAdditionalFieldsToModel(
            Mockito.<String>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<BroadleafTemplateContext>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(contentProcessorExtensionManager.getProxy()).thenReturn(contentProcessorExtensionHandler);
    when(structuredContentService.lookupStructuredContentItemsByName(
            Mockito.<StructuredContentType>any(),
            Mockito.<String>any(),
            Mockito.<Locale>any(),
            Mockito.<Integer>any(),
            Mockito.<Map<String, Object>>any(),
            anyBoolean()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    HashMap<String, Object> mvelParameters = new HashMap<>();
    SandBoxImpl currentSandbox = new SandBoxImpl();
    StructuredContentTypeImpl structuredContentType = new StructuredContentTypeImpl();
    LocaleImpl locale = new LocaleImpl();
    HashMap<String, String> tagAttributes = new HashMap<>();

    // Act
    List<StructuredContentDTO> actualContentItems =
        contentProcessor.getContentItems(
            "Not all who wander are lost",
            3,
            request,
            mvelParameters,
            currentSandbox,
            structuredContentType,
            locale,
            "Tag Name",
            tagAttributes,
            new HashMap<>(),
            mock(BroadleafTemplateContext.class));

    // Assert
    verify(structuredContentService)
        .lookupStructuredContentItemsByName(
            isA(StructuredContentType.class),
            eq("Not all who wander are lost"),
            isA(Locale.class),
            eq(3),
            isA(Map.class),
            eq(false));
    verify(contentProcessorExtensionHandler)
        .addAdditionalFieldsToModel(
            eq("Tag Name"), isA(Map.class), isA(Map.class), isA(BroadleafTemplateContext.class));
    verify(contentProcessorExtensionManager).getProxy();
    assertTrue(actualContentItems.isEmpty());
  }

  /**
   * Test {@link ContentProcessor#getContentItems(String, Integer, HttpServletRequest, Map, SandBox,
   * StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link ContentProcessor#getContentItems(String, Integer,
   * HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ContentProcessor.getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)"
  })
  public void testGetContentItems2() {
    // Arrange
    when(structuredContentService.lookupStructuredContentItemsByName(
            Mockito.<StructuredContentType>any(),
            Mockito.<String>any(),
            Mockito.<Locale>any(),
            Mockito.<Integer>any(),
            Mockito.<Map<String, Object>>any(),
            anyBoolean()))
        .thenThrow(new IllegalArgumentException());
    MockHttpServletRequest request = new MockHttpServletRequest();
    HashMap<String, Object> mvelParameters = new HashMap<>();
    SandBoxImpl currentSandbox = new SandBoxImpl();
    StructuredContentTypeImpl structuredContentType = new StructuredContentTypeImpl();
    LocaleImpl locale = new LocaleImpl();
    HashMap<String, String> tagAttributes = new HashMap<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            contentProcessor.getContentItems(
                "Not all who wander are lost",
                3,
                request,
                mvelParameters,
                currentSandbox,
                structuredContentType,
                locale,
                "Tag Name",
                tagAttributes,
                new HashMap<>(),
                mock(BroadleafTemplateContext.class)));
    verify(structuredContentService)
        .lookupStructuredContentItemsByName(
            isA(StructuredContentType.class),
            eq("Not all who wander are lost"),
            isA(Locale.class),
            eq(3),
            isA(Map.class),
            eq(false));
  }

  /**
   * Test {@link ContentProcessor#getContentItems(String, Integer, HttpServletRequest, Map, SandBox,
   * StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link ContentProcessor#getContentItems(String, Integer,
   * HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ContentProcessor.getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)"
  })
  public void testGetContentItems3() {
    // Arrange
    ContentProcessorExtensionHandler contentProcessorExtensionHandler =
        mock(ContentProcessorExtensionHandler.class);
    when(contentProcessorExtensionHandler.addAdditionalFieldsToModel(
            Mockito.<String>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<BroadleafTemplateContext>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(contentProcessorExtensionManager.getProxy()).thenReturn(contentProcessorExtensionHandler);
    when(structuredContentService.lookupStructuredContentItemsByName(
            Mockito.<StructuredContentType>any(),
            Mockito.<String>any(),
            Mockito.<Locale>any(),
            Mockito.<Integer>any(),
            Mockito.<Map<String, Object>>any(),
            anyBoolean()))
        .thenReturn(new ArrayList<>());
    HashMap<String, Object> mvelParameters = new HashMap<>();
    SandBoxImpl currentSandbox = new SandBoxImpl();
    StructuredContentTypeImpl structuredContentType = new StructuredContentTypeImpl();
    LocaleImpl locale = new LocaleImpl();
    HashMap<String, String> tagAttributes = new HashMap<>();

    // Act
    List<StructuredContentDTO> actualContentItems =
        contentProcessor.getContentItems(
            "Not all who wander are lost",
            3,
            null,
            mvelParameters,
            currentSandbox,
            structuredContentType,
            locale,
            "Tag Name",
            tagAttributes,
            new HashMap<>(),
            mock(BroadleafTemplateContext.class));

    // Assert
    verify(structuredContentService)
        .lookupStructuredContentItemsByName(
            isA(StructuredContentType.class),
            eq("Not all who wander are lost"),
            isA(Locale.class),
            eq(3),
            isA(Map.class),
            eq(false));
    verify(contentProcessorExtensionHandler)
        .addAdditionalFieldsToModel(
            eq("Tag Name"), isA(Map.class), isA(Map.class), isA(BroadleafTemplateContext.class));
    verify(contentProcessorExtensionManager).getProxy();
    assertTrue(actualContentItems.isEmpty());
  }

  /**
   * Test {@link ContentProcessor#getContentItems(String, Integer, HttpServletRequest, Map, SandBox,
   * StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link ContentProcessor#getContentItems(String, Integer,
   * HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ContentProcessor.getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)"
  })
  public void testGetContentItems4() {
    // Arrange
    when(structuredContentService.lookupStructuredContentItemsByName(
            Mockito.<StructuredContentType>any(),
            Mockito.<String>any(),
            Mockito.<Locale>any(),
            Mockito.<Integer>any(),
            Mockito.<Map<String, Object>>any(),
            anyBoolean()))
        .thenThrow(new IllegalArgumentException());

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.isSecure()).thenReturn(true);
    when(request.getScheme()).thenReturn("Scheme");
    HashMap<String, Object> mvelParameters = new HashMap<>();
    SandBoxImpl currentSandbox = new SandBoxImpl();
    StructuredContentTypeImpl structuredContentType = new StructuredContentTypeImpl();
    LocaleImpl locale = new LocaleImpl();
    HashMap<String, String> tagAttributes = new HashMap<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            contentProcessor.getContentItems(
                "Not all who wander are lost",
                3,
                request,
                mvelParameters,
                currentSandbox,
                structuredContentType,
                locale,
                "Tag Name",
                tagAttributes,
                new HashMap<>(),
                mock(BroadleafTemplateContext.class)));
    verify(request).getScheme();
    verify(request).isSecure();
    verify(structuredContentService)
        .lookupStructuredContentItemsByName(
            isA(StructuredContentType.class),
            eq("Not all who wander are lost"),
            isA(Locale.class),
            eq(3),
            isA(Map.class),
            eq(true));
  }

  /**
   * Test {@link ContentProcessor#getContentItems(String, Integer, HttpServletRequest, Map, SandBox,
   * StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link ContentProcessor#getContentItems(String, Integer,
   * HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ContentProcessor.getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)"
  })
  public void testGetContentItems5() {
    // Arrange
    ContentProcessorExtensionHandler contentProcessorExtensionHandler =
        mock(ContentProcessorExtensionHandler.class);
    when(contentProcessorExtensionHandler.addAdditionalFieldsToModel(
            Mockito.<String>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<BroadleafTemplateContext>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(contentProcessorExtensionManager.getProxy()).thenReturn(contentProcessorExtensionHandler);
    when(structuredContentService.lookupStructuredContentItemsByType(
            Mockito.<StructuredContentType>any(),
            Mockito.<Locale>any(),
            Mockito.<Integer>any(),
            Mockito.<Map<String, Object>>any(),
            anyBoolean()))
        .thenReturn(new ArrayList<>());

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.isSecure()).thenReturn(true);
    when(request.getScheme()).thenReturn("Scheme");
    HashMap<String, Object> mvelParameters = new HashMap<>();
    SandBoxImpl currentSandbox = new SandBoxImpl();
    StructuredContentTypeImpl structuredContentType = new StructuredContentTypeImpl();
    LocaleImpl locale = new LocaleImpl();
    HashMap<String, String> tagAttributes = new HashMap<>();

    // Act
    List<StructuredContentDTO> actualContentItems =
        contentProcessor.getContentItems(
            "",
            3,
            request,
            mvelParameters,
            currentSandbox,
            structuredContentType,
            locale,
            "Tag Name",
            tagAttributes,
            new HashMap<>(),
            mock(BroadleafTemplateContext.class));

    // Assert
    verify(request).getScheme();
    verify(request).isSecure();
    verify(structuredContentService)
        .lookupStructuredContentItemsByType(
            isA(StructuredContentType.class), isA(Locale.class), eq(3), isA(Map.class), eq(true));
    verify(contentProcessorExtensionHandler)
        .addAdditionalFieldsToModel(
            eq("Tag Name"), isA(Map.class), isA(Map.class), isA(BroadleafTemplateContext.class));
    verify(contentProcessorExtensionManager).getProxy();
    assertTrue(actualContentItems.isEmpty());
  }

  /**
   * Test {@link ContentProcessor#getContentItems(String, Integer, HttpServletRequest, Map, SandBox,
   * StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link ContentProcessor#getContentItems(String, Integer,
   * HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ContentProcessor.getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)"
  })
  public void testGetContentItems6() {
    // Arrange
    when(structuredContentService.lookupStructuredContentItemsByType(
            Mockito.<StructuredContentType>any(),
            Mockito.<Locale>any(),
            Mockito.<Integer>any(),
            Mockito.<Map<String, Object>>any(),
            anyBoolean()))
        .thenThrow(new IllegalArgumentException());

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.isSecure()).thenReturn(true);
    when(request.getScheme()).thenReturn("Scheme");
    HashMap<String, Object> mvelParameters = new HashMap<>();
    SandBoxImpl currentSandbox = new SandBoxImpl();
    StructuredContentTypeImpl structuredContentType = new StructuredContentTypeImpl();
    LocaleImpl locale = new LocaleImpl();
    HashMap<String, String> tagAttributes = new HashMap<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            contentProcessor.getContentItems(
                "",
                3,
                request,
                mvelParameters,
                currentSandbox,
                structuredContentType,
                locale,
                "Tag Name",
                tagAttributes,
                new HashMap<>(),
                mock(BroadleafTemplateContext.class)));
    verify(request).getScheme();
    verify(request).isSecure();
    verify(structuredContentService)
        .lookupStructuredContentItemsByType(
            isA(StructuredContentType.class), isA(Locale.class), eq(3), isA(Map.class), eq(true));
  }

  /**
   * Test {@link ContentProcessor#getContentItems(String, Integer, HttpServletRequest, Map, SandBox,
   * StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link ContentProcessor#getContentItems(String, Integer,
   * HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ContentProcessor.getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)"
  })
  public void testGetContentItems7() {
    // Arrange
    ContentProcessorExtensionHandler contentProcessorExtensionHandler =
        mock(ContentProcessorExtensionHandler.class);
    when(contentProcessorExtensionHandler.addAdditionalFieldsToModel(
            Mockito.<String>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<BroadleafTemplateContext>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(contentProcessorExtensionManager.getProxy()).thenReturn(contentProcessorExtensionHandler);
    when(structuredContentService.lookupStructuredContentItemsByType(
            Mockito.<StructuredContentType>any(),
            Mockito.<Locale>any(),
            Mockito.<Integer>any(),
            Mockito.<Map<String, Object>>any(),
            anyBoolean()))
        .thenReturn(new ArrayList<>());

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.isSecure()).thenReturn(true);
    when(request.getScheme()).thenReturn("Scheme");
    HashMap<String, Object> mvelParameters = new HashMap<>();
    SandBoxImpl currentSandbox = new SandBoxImpl();
    StructuredContentTypeImpl structuredContentType = new StructuredContentTypeImpl();
    LocaleImpl locale = new LocaleImpl();
    HashMap<String, String> tagAttributes = new HashMap<>();

    // Act
    List<StructuredContentDTO> actualContentItems =
        contentProcessor.getContentItems(
            null,
            3,
            request,
            mvelParameters,
            currentSandbox,
            structuredContentType,
            locale,
            "Tag Name",
            tagAttributes,
            new HashMap<>(),
            mock(BroadleafTemplateContext.class));

    // Assert
    verify(request).getScheme();
    verify(request).isSecure();
    verify(structuredContentService)
        .lookupStructuredContentItemsByType(
            isA(StructuredContentType.class), isA(Locale.class), eq(3), isA(Map.class), eq(true));
    verify(contentProcessorExtensionHandler)
        .addAdditionalFieldsToModel(
            eq("Tag Name"), isA(Map.class), isA(Map.class), isA(BroadleafTemplateContext.class));
    verify(contentProcessorExtensionManager).getProxy();
    assertTrue(actualContentItems.isEmpty());
  }

  /**
   * Test {@link ContentProcessor#getContentItems(String, Integer, HttpServletRequest, Map, SandBox,
   * StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link ContentProcessor#getContentItems(String, Integer,
   * HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ContentProcessor.getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)"
  })
  public void testGetContentItems8() {
    // Arrange
    ContentProcessorExtensionHandler contentProcessorExtensionHandler =
        mock(ContentProcessorExtensionHandler.class);
    when(contentProcessorExtensionHandler.addAdditionalFieldsToModel(
            Mockito.<String>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<BroadleafTemplateContext>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(contentProcessorExtensionManager.getProxy()).thenReturn(contentProcessorExtensionHandler);
    when(structuredContentService.lookupStructuredContentItemsByName(
            Mockito.<String>any(),
            Mockito.<Locale>any(),
            Mockito.<Integer>any(),
            Mockito.<Map<String, Object>>any(),
            anyBoolean()))
        .thenReturn(new ArrayList<>());

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.isSecure()).thenReturn(true);
    when(request.getScheme()).thenReturn("Scheme");
    HashMap<String, Object> mvelParameters = new HashMap<>();
    SandBoxImpl currentSandbox = new SandBoxImpl();
    LocaleImpl locale = new LocaleImpl();
    HashMap<String, String> tagAttributes = new HashMap<>();

    // Act
    List<StructuredContentDTO> actualContentItems =
        contentProcessor.getContentItems(
            "",
            3,
            request,
            mvelParameters,
            currentSandbox,
            null,
            locale,
            "Tag Name",
            tagAttributes,
            new HashMap<>(),
            mock(BroadleafTemplateContext.class));

    // Assert
    verify(request).getScheme();
    verify(request).isSecure();
    verify(structuredContentService)
        .lookupStructuredContentItemsByName(
            eq(""), isA(Locale.class), eq(3), isA(Map.class), eq(true));
    verify(contentProcessorExtensionHandler)
        .addAdditionalFieldsToModel(
            eq("Tag Name"), isA(Map.class), isA(Map.class), isA(BroadleafTemplateContext.class));
    verify(contentProcessorExtensionManager).getProxy();
    assertTrue(actualContentItems.isEmpty());
  }

  /**
   * Test {@link ContentProcessor#getContentItems(String, Integer, HttpServletRequest, Map, SandBox,
   * StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link ContentProcessor#getContentItems(String, Integer,
   * HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ContentProcessor.getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)"
  })
  public void testGetContentItems9() {
    // Arrange
    when(structuredContentService.lookupStructuredContentItemsByName(
            Mockito.<String>any(),
            Mockito.<Locale>any(),
            Mockito.<Integer>any(),
            Mockito.<Map<String, Object>>any(),
            anyBoolean()))
        .thenThrow(new IllegalArgumentException());

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.isSecure()).thenReturn(true);
    when(request.getScheme()).thenReturn("Scheme");
    HashMap<String, Object> mvelParameters = new HashMap<>();
    SandBoxImpl currentSandbox = new SandBoxImpl();
    LocaleImpl locale = new LocaleImpl();
    HashMap<String, String> tagAttributes = new HashMap<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            contentProcessor.getContentItems(
                "",
                3,
                request,
                mvelParameters,
                currentSandbox,
                null,
                locale,
                "Tag Name",
                tagAttributes,
                new HashMap<>(),
                mock(BroadleafTemplateContext.class)));
    verify(request).getScheme();
    verify(request).isSecure();
    verify(structuredContentService)
        .lookupStructuredContentItemsByName(
            eq(""), isA(Locale.class), eq(3), isA(Map.class), eq(true));
  }

  /**
   * Test {@link ContentProcessor#getContentItems(String, Integer, HttpServletRequest, Map, SandBox,
   * StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link ContentProcessor#getContentItems(String, Integer,
   * HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ContentProcessor.getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)"
  })
  public void testGetContentItems10() {
    // Arrange
    ContentProcessorExtensionHandler contentProcessorExtensionHandler =
        mock(ContentProcessorExtensionHandler.class);
    when(contentProcessorExtensionHandler.addAdditionalFieldsToModel(
            Mockito.<String>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<BroadleafTemplateContext>any()))
        .thenThrow(new IllegalArgumentException());
    when(contentProcessorExtensionManager.getProxy()).thenReturn(contentProcessorExtensionHandler);
    when(structuredContentService.lookupStructuredContentItemsByName(
            Mockito.<String>any(),
            Mockito.<Locale>any(),
            Mockito.<Integer>any(),
            Mockito.<Map<String, Object>>any(),
            anyBoolean()))
        .thenReturn(new ArrayList<>());
    HashMap<String, Object> mvelParameters = new HashMap<>();
    SandBoxImpl currentSandbox = new SandBoxImpl();
    LocaleImpl locale = new LocaleImpl();
    HashMap<String, String> tagAttributes = new HashMap<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            contentProcessor.getContentItems(
                null,
                3,
                null,
                mvelParameters,
                currentSandbox,
                null,
                locale,
                "Tag Name",
                tagAttributes,
                new HashMap<>(),
                mock(BroadleafTemplateContext.class)));
    verify(structuredContentService)
        .lookupStructuredContentItemsByName(
            isNull(), isA(Locale.class), eq(3), isA(Map.class), eq(false));
    verify(contentProcessorExtensionHandler)
        .addAdditionalFieldsToModel(
            eq("Tag Name"), isA(Map.class), isA(Map.class), isA(BroadleafTemplateContext.class));
    verify(contentProcessorExtensionManager).getProxy();
  }

  /**
   * Test {@link ContentProcessor#getContentItems(String, Integer, HttpServletRequest, Map, SandBox,
   * StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link ContentProcessor#getContentItems(String, Integer,
   * HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ContentProcessor.getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)"
  })
  public void testGetContentItems11() {
    // Arrange
    when(contentProcessorExtensionManager.getProxy()).thenThrow(new IllegalArgumentException());
    when(structuredContentService.lookupStructuredContentItemsByType(
            Mockito.<StructuredContentType>any(),
            Mockito.<Locale>any(),
            Mockito.<Integer>any(),
            Mockito.<Map<String, Object>>any(),
            anyBoolean()))
        .thenReturn(new ArrayList<>());
    HashMap<String, Object> mvelParameters = new HashMap<>();
    SandBoxImpl currentSandbox = new SandBoxImpl();
    StructuredContentTypeImpl structuredContentType = new StructuredContentTypeImpl();
    LocaleImpl locale = new LocaleImpl();
    HashMap<String, String> tagAttributes = new HashMap<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            contentProcessor.getContentItems(
                null,
                3,
                null,
                mvelParameters,
                currentSandbox,
                structuredContentType,
                locale,
                "Tag Name",
                tagAttributes,
                new HashMap<>(),
                mock(BroadleafTemplateContext.class)));
    verify(structuredContentService)
        .lookupStructuredContentItemsByType(
            isA(StructuredContentType.class), isA(Locale.class), eq(3), isA(Map.class), eq(false));
    verify(contentProcessorExtensionManager).getProxy();
  }

  /**
   * Test {@link ContentProcessor#getContentItems(String, Integer, HttpServletRequest, Map, SandBox,
   * StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@code HTTPS}.
   * </ul>
   *
   * <p>Method under test: {@link ContentProcessor#getContentItems(String, Integer,
   * HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ContentProcessor.getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)"
  })
  public void testGetContentItems_givenHttps() {
    // Arrange
    ContentProcessorExtensionHandler contentProcessorExtensionHandler =
        mock(ContentProcessorExtensionHandler.class);
    when(contentProcessorExtensionHandler.addAdditionalFieldsToModel(
            Mockito.<String>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<BroadleafTemplateContext>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(contentProcessorExtensionManager.getProxy()).thenReturn(contentProcessorExtensionHandler);
    when(structuredContentService.lookupStructuredContentItemsByType(
            Mockito.<StructuredContentType>any(),
            Mockito.<Locale>any(),
            Mockito.<Integer>any(),
            Mockito.<Map<String, Object>>any(),
            anyBoolean()))
        .thenReturn(new ArrayList<>());

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getScheme()).thenReturn("HTTPS");
    HashMap<String, Object> mvelParameters = new HashMap<>();
    SandBoxImpl currentSandbox = new SandBoxImpl();
    StructuredContentTypeImpl structuredContentType = new StructuredContentTypeImpl();
    LocaleImpl locale = new LocaleImpl();
    HashMap<String, String> tagAttributes = new HashMap<>();

    // Act
    List<StructuredContentDTO> actualContentItems =
        contentProcessor.getContentItems(
            "",
            3,
            request,
            mvelParameters,
            currentSandbox,
            structuredContentType,
            locale,
            "Tag Name",
            tagAttributes,
            new HashMap<>(),
            mock(BroadleafTemplateContext.class));

    // Assert
    verify(request).getScheme();
    verify(structuredContentService)
        .lookupStructuredContentItemsByType(
            isA(StructuredContentType.class), isA(Locale.class), eq(3), isA(Map.class), eq(true));
    verify(contentProcessorExtensionHandler)
        .addAdditionalFieldsToModel(
            eq("Tag Name"), isA(Map.class), isA(Map.class), isA(BroadleafTemplateContext.class));
    verify(contentProcessorExtensionManager).getProxy();
    assertTrue(actualContentItems.isEmpty());
  }

  /**
   * Test {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link HashMap#HashMap()} {@code category} is {@code null}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map ContentProcessor.buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)"
  })
  public void testBuildMvelParameters_givenNull_whenHashMapCategoryIsNull_thenReturnSizeIsTwo() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("product", null);
    tagAttributes.put("category", null);

    // Act
    Map<String, Object> actualBuildMvelParametersResult =
        contentProcessor.buildMvelParameters(
            request, tagAttributes, mock(BroadleafTemplateContext.class));

    // Assert
    assertEquals(2, actualBuildMvelParametersResult.size());
    assertTrue(actualBuildMvelParametersResult.get("time") instanceof TimeDTO);
    assertNull(actualBuildMvelParametersResult.get("request"));
  }

  /**
   * Test {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@code Parse Expression}.
   *   <li>Then return size is four.
   * </ul>
   *
   * <p>Method under test: {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map ContentProcessor.buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)"
  })
  public void testBuildMvelParameters_givenParseExpression_thenReturnSizeIsFour() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("product", ContentProcessor.REQUEST_DTO);
    tagAttributes.put("category", "Tag Attributes");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn("Parse Expression");

    // Act
    Map<String, Object> actualBuildMvelParametersResult =
        contentProcessor.buildMvelParameters(request, tagAttributes, context);

    // Assert
    verify(context, atLeast(1)).parseExpression(Mockito.<String>any());
    assertEquals(4, actualBuildMvelParametersResult.size());
    assertEquals("Parse Expression", actualBuildMvelParametersResult.get("category"));
    assertEquals("Parse Expression", actualBuildMvelParametersResult.get("product"));
    assertTrue(actualBuildMvelParametersResult.containsKey("request"));
    assertTrue(actualBuildMvelParametersResult.containsKey("time"));
  }

  /**
   * Test {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@code Parse Expression}.
   *   <li>Then return size is three.
   * </ul>
   *
   * <p>Method under test: {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map ContentProcessor.buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)"
  })
  public void testBuildMvelParameters_givenParseExpression_thenReturnSizeIsThree() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("product", null);
    tagAttributes.put("category", "Tag Attributes");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn("Parse Expression");

    // Act
    Map<String, Object> actualBuildMvelParametersResult =
        contentProcessor.buildMvelParameters(request, tagAttributes, context);

    // Assert
    verify(context).parseExpression("Tag Attributes");
    assertEquals(3, actualBuildMvelParametersResult.size());
    assertTrue(actualBuildMvelParametersResult.get("time") instanceof TimeDTO);
    assertEquals("Parse Expression", actualBuildMvelParametersResult.get("category"));
    assertNull(actualBuildMvelParametersResult.get("request"));
  }

  /**
   * Test {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map ContentProcessor.buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)"
  })
  public void testBuildMvelParameters_thenThrowIllegalArgumentException() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("product", null);
    tagAttributes.put("category", "Tag Attributes");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> contentProcessor.buildMvelParameters(request, tagAttributes, context));
    verify(context).parseExpression("Tag Attributes");
  }

  /**
   * Test {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map ContentProcessor.buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)"
  })
  public void testBuildMvelParameters_thenThrowIllegalArgumentException2() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("product", ContentProcessor.REQUEST_DTO);
    tagAttributes.put("category", "Tag Attributes");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> contentProcessor.buildMvelParameters(request, tagAttributes, context));
    verify(context).parseExpression("blRequestDTO");
  }

  /**
   * Test {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>When {@link BroadleafTemplateContext} {@link
   *       BroadleafTemplateContext#parseExpression(String)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map ContentProcessor.buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)"
  })
  public void testBuildMvelParameters_whenBroadleafTemplateContextParseExpressionReturnNull() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("product", null);
    tagAttributes.put("category", "Tag Attributes");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(null);

    // Act
    Map<String, Object> actualBuildMvelParametersResult =
        contentProcessor.buildMvelParameters(request, tagAttributes, context);

    // Assert
    verify(context).parseExpression("Tag Attributes");
    assertEquals(2, actualBuildMvelParametersResult.size());
    assertTrue(actualBuildMvelParametersResult.get("time") instanceof TimeDTO);
    assertNull(actualBuildMvelParametersResult.get("request"));
  }

  /**
   * Test {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>When {@link BroadleafTemplateContext} {@link
   *       BroadleafTemplateContext#parseExpression(String)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map ContentProcessor.buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)"
  })
  public void testBuildMvelParameters_whenBroadleafTemplateContextParseExpressionReturnNull2() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("product", ContentProcessor.REQUEST_DTO);
    tagAttributes.put("category", "Tag Attributes");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(null);

    // Act
    Map<String, Object> actualBuildMvelParametersResult =
        contentProcessor.buildMvelParameters(request, tagAttributes, context);

    // Assert
    verify(context, atLeast(1)).parseExpression(Mockito.<String>any());
    assertEquals(2, actualBuildMvelParametersResult.size());
    assertTrue(actualBuildMvelParametersResult.get("time") instanceof TimeDTO);
    assertNull(actualBuildMvelParametersResult.get("request"));
  }

  /**
   * Test {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map ContentProcessor.buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)"
  })
  public void testBuildMvelParameters_whenHashMap_thenReturnSizeIsTwo() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act
    Map<String, Object> actualBuildMvelParametersResult =
        contentProcessor.buildMvelParameters(
            request, new HashMap<>(), mock(BroadleafTemplateContext.class));

    // Assert
    assertEquals(2, actualBuildMvelParametersResult.size());
    assertTrue(actualBuildMvelParametersResult.get("time") instanceof TimeDTO);
    assertNull(actualBuildMvelParametersResult.get("request"));
  }

  /**
   * Test {@link ContentProcessor#isSecure(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Given {@code HTTPS}.
   * </ul>
   *
   * <p>Method under test: {@link ContentProcessor#isSecure(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ContentProcessor.isSecure(HttpServletRequest)"})
  public void testIsSecure_givenHttps() {
    // Arrange
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
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then calls {@link DefaultMultipartHttpServletRequest#isSecure()}.
   * </ul>
   *
   * <p>Method under test: {@link ContentProcessor#isSecure(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ContentProcessor.isSecure(HttpServletRequest)"})
  public void testIsSecure_givenTrue_thenCallsIsSecure() {
    // Arrange
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
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ContentProcessor#isSecure(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ContentProcessor.isSecure(HttpServletRequest)"})
  public void testIsSecure_whenMockHttpServletRequest_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(contentProcessor.isSecure(new MockHttpServletRequest()));
  }

  /**
   * Test {@link ContentProcessor#isSecure(HttpServletRequest)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ContentProcessor#isSecure(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ContentProcessor.isSecure(HttpServletRequest)"})
  public void testIsSecure_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(contentProcessor.isSecure(null));
  }
}

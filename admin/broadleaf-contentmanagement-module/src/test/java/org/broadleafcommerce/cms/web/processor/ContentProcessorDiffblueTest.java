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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletRequestWrapper;
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
import org.broadleafcommerce.common.web.BroadleafRequestContext;
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
  @InjectMocks
  private ContentProcessor contentProcessor;

  @Mock
  private ContentProcessorExtensionManager contentProcessorExtensionManager;

  @Mock
  private StructuredContentService structuredContentService;

  /**
   * Test {@link ContentProcessor#getName()}.
   * <p>
   * Method under test: {@link ContentProcessor#getName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ContentProcessor.getName()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ContentProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(10000, contentProcessor.getPrecedence());
  }

  /**
   * Test {@link ContentProcessor#getAttributeValue(Map, String, String)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code 42} is {@code foo}.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentProcessor#getAttributeValue(Map, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentProcessor#getAttributeValue(Map, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ContentProcessor.getAttributeValue(Map, String, String)"})
  public void testGetAttributeValue_whenHashMap_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", contentProcessor.getAttributeValue(new HashMap<>(), "42", "42"));
  }

  /**
   * Test {@link ContentProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link HashMap#HashMap()} {@code contentType} is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ContentProcessor.populateModelVariables(String, Map, BroadleafTemplateContext)"})
  public void testPopulateModelVariables_givenEmptyString_whenHashMapContentTypeIsEmptyString() {
    // Arrange
    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("contentType", "");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> contentProcessor.populateModelVariables("Tag Name", tagAttributes, mock(BroadleafTemplateContext.class)));
  }

  /**
   * Test {@link ContentProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ContentProcessor.populateModelVariables(String, Map, BroadleafTemplateContext)"})
  public void testPopulateModelVariables_whenHashMap_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> contentProcessor.populateModelVariables("Tag Name",
        new HashMap<>(), mock(BroadleafTemplateContext.class)));
  }

  /**
   * Test {@link ContentProcessor#getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)}.
   * <p>
   * Method under test: {@link ContentProcessor#getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List ContentProcessor.getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)"})
  public void testGetContentItems() {
    // Arrange
    ContentProcessorExtensionHandler contentProcessorExtensionHandler = mock(ContentProcessorExtensionHandler.class);
    when(contentProcessorExtensionHandler.addAdditionalFieldsToModel(Mockito.<String>any(),
        Mockito.<Map<String, String>>any(), Mockito.<Map<String, Object>>any(),
        Mockito.<BroadleafTemplateContext>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(contentProcessorExtensionManager.getProxy()).thenReturn(contentProcessorExtensionHandler);
    when(structuredContentService.lookupStructuredContentItemsByName(Mockito.<StructuredContentType>any(),
        Mockito.<String>any(), Mockito.<Locale>any(), Mockito.<Integer>any(), Mockito.<Map<String, Object>>any(),
        anyBoolean())).thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    HashMap<String, Object> mvelParameters = new HashMap<>();
    SandBoxImpl currentSandbox = new SandBoxImpl();
    StructuredContentTypeImpl structuredContentType = new StructuredContentTypeImpl();
    LocaleImpl locale = new LocaleImpl();
    HashMap<String, String> tagAttributes = new HashMap<>();

    // Act
    List<StructuredContentDTO> actualContentItems = contentProcessor.getContentItems("Not all who wander are lost", 3,
        request, mvelParameters, currentSandbox, structuredContentType, locale, "Tag Name", tagAttributes,
        new HashMap<>(), mock(BroadleafTemplateContext.class));

    // Assert
    verify(structuredContentService).lookupStructuredContentItemsByName(isA(StructuredContentType.class),
        eq("Not all who wander are lost"), isA(Locale.class), eq(3), isA(Map.class), eq(false));
    verify(contentProcessorExtensionHandler).addAdditionalFieldsToModel(eq("Tag Name"), isA(Map.class), isA(Map.class),
        isA(BroadleafTemplateContext.class));
    verify(contentProcessorExtensionManager).getProxy();
    assertTrue(actualContentItems.isEmpty());
  }

  /**
   * Test {@link ContentProcessor#getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)}.
   * <p>
   * Method under test: {@link ContentProcessor#getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List ContentProcessor.getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)"})
  public void testGetContentItems2() {
    // Arrange
    when(structuredContentService.lookupStructuredContentItemsByName(Mockito.<StructuredContentType>any(),
        Mockito.<String>any(), Mockito.<Locale>any(), Mockito.<Integer>any(), Mockito.<Map<String, Object>>any(),
        anyBoolean())).thenThrow(new IllegalArgumentException("Not all who wander are lost"));
    MockHttpServletRequest request = new MockHttpServletRequest();
    HashMap<String, Object> mvelParameters = new HashMap<>();
    SandBoxImpl currentSandbox = new SandBoxImpl();
    StructuredContentTypeImpl structuredContentType = new StructuredContentTypeImpl();
    LocaleImpl locale = new LocaleImpl();
    HashMap<String, String> tagAttributes = new HashMap<>();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> contentProcessor.getContentItems("Not all who wander are lost", 3, request, mvelParameters,
            currentSandbox, structuredContentType, locale, "Tag Name", tagAttributes, new HashMap<>(),
            mock(BroadleafTemplateContext.class)));
    verify(structuredContentService).lookupStructuredContentItemsByName(isA(StructuredContentType.class),
        eq("Not all who wander are lost"), isA(Locale.class), eq(3), isA(Map.class), eq(false));
  }

  /**
   * Test {@link ContentProcessor#getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)}.
   * <p>
   * Method under test: {@link ContentProcessor#getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List ContentProcessor.getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)"})
  public void testGetContentItems3() {
    // Arrange
    ContentProcessorExtensionHandler contentProcessorExtensionHandler = mock(ContentProcessorExtensionHandler.class);
    when(contentProcessorExtensionHandler.addAdditionalFieldsToModel(Mockito.<String>any(),
        Mockito.<Map<String, String>>any(), Mockito.<Map<String, Object>>any(),
        Mockito.<BroadleafTemplateContext>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(contentProcessorExtensionManager.getProxy()).thenReturn(contentProcessorExtensionHandler);
    when(structuredContentService.lookupStructuredContentItemsByName(Mockito.<String>any(), Mockito.<Locale>any(),
        Mockito.<Integer>any(), Mockito.<Map<String, Object>>any(), anyBoolean())).thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    HashMap<String, Object> mvelParameters = new HashMap<>();
    SandBoxImpl currentSandbox = new SandBoxImpl();
    LocaleImpl locale = new LocaleImpl();
    HashMap<String, String> tagAttributes = new HashMap<>();

    // Act
    List<StructuredContentDTO> actualContentItems = contentProcessor.getContentItems("", 3, request, mvelParameters,
        currentSandbox, null, locale, "Tag Name", tagAttributes, new HashMap<>(), mock(BroadleafTemplateContext.class));

    // Assert
    verify(structuredContentService).lookupStructuredContentItemsByName(eq(""), isA(Locale.class), eq(3),
        isA(Map.class), eq(false));
    verify(contentProcessorExtensionHandler).addAdditionalFieldsToModel(eq("Tag Name"), isA(Map.class), isA(Map.class),
        isA(BroadleafTemplateContext.class));
    verify(contentProcessorExtensionManager).getProxy();
    assertTrue(actualContentItems.isEmpty());
  }

  /**
   * Test {@link ContentProcessor#getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)}.
   * <p>
   * Method under test: {@link ContentProcessor#getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List ContentProcessor.getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)"})
  public void testGetContentItems4() {
    // Arrange
    when(structuredContentService.lookupStructuredContentItemsByName(Mockito.<String>any(), Mockito.<Locale>any(),
        Mockito.<Integer>any(), Mockito.<Map<String, Object>>any(), anyBoolean()))
        .thenThrow(new IllegalArgumentException("HTTPS"));
    MockHttpServletRequest request = new MockHttpServletRequest();
    HashMap<String, Object> mvelParameters = new HashMap<>();
    SandBoxImpl currentSandbox = new SandBoxImpl();
    LocaleImpl locale = new LocaleImpl();
    HashMap<String, String> tagAttributes = new HashMap<>();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> contentProcessor.getContentItems("", 3, request, mvelParameters, currentSandbox, null, locale, "Tag Name",
            tagAttributes, new HashMap<>(), mock(BroadleafTemplateContext.class)));
    verify(structuredContentService).lookupStructuredContentItemsByName(eq(""), isA(Locale.class), eq(3),
        isA(Map.class), eq(false));
  }

  /**
   * Test {@link ContentProcessor#getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} Secure is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentProcessor#getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List ContentProcessor.getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)"})
  public void testGetContentItems_givenTrue_whenMockHttpServletRequestSecureIsTrue() {
    // Arrange
    ContentProcessorExtensionHandler contentProcessorExtensionHandler = mock(ContentProcessorExtensionHandler.class);
    when(contentProcessorExtensionHandler.addAdditionalFieldsToModel(Mockito.<String>any(),
        Mockito.<Map<String, String>>any(), Mockito.<Map<String, Object>>any(),
        Mockito.<BroadleafTemplateContext>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(contentProcessorExtensionManager.getProxy()).thenReturn(contentProcessorExtensionHandler);
    when(structuredContentService.lookupStructuredContentItemsByName(Mockito.<String>any(), Mockito.<Locale>any(),
        Mockito.<Integer>any(), Mockito.<Map<String, Object>>any(), anyBoolean())).thenReturn(new ArrayList<>());

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setSecure(true);
    HashMap<String, Object> mvelParameters = new HashMap<>();
    SandBoxImpl currentSandbox = new SandBoxImpl();
    LocaleImpl locale = new LocaleImpl();
    HashMap<String, String> tagAttributes = new HashMap<>();

    // Act
    List<StructuredContentDTO> actualContentItems = contentProcessor.getContentItems("", 3, request, mvelParameters,
        currentSandbox, null, locale, "Tag Name", tagAttributes, new HashMap<>(), mock(BroadleafTemplateContext.class));

    // Assert
    verify(structuredContentService).lookupStructuredContentItemsByName(eq(""), isA(Locale.class), eq(3),
        isA(Map.class), eq(true));
    verify(contentProcessorExtensionHandler).addAdditionalFieldsToModel(eq("Tag Name"), isA(Map.class), isA(Map.class),
        isA(BroadleafTemplateContext.class));
    verify(contentProcessorExtensionManager).getProxy();
    assertTrue(actualContentItems.isEmpty());
  }

  /**
   * Test {@link ContentProcessor#getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then calls {@link StructuredContentService#lookupStructuredContentItemsByType(StructuredContentType, Locale, Integer, Map, boolean)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentProcessor#getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List ContentProcessor.getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)"})
  public void testGetContentItems_thenCallsLookupStructuredContentItemsByType() {
    // Arrange
    ContentProcessorExtensionHandler contentProcessorExtensionHandler = mock(ContentProcessorExtensionHandler.class);
    when(contentProcessorExtensionHandler.addAdditionalFieldsToModel(Mockito.<String>any(),
        Mockito.<Map<String, String>>any(), Mockito.<Map<String, Object>>any(),
        Mockito.<BroadleafTemplateContext>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(contentProcessorExtensionManager.getProxy()).thenReturn(contentProcessorExtensionHandler);
    when(structuredContentService.lookupStructuredContentItemsByType(Mockito.<StructuredContentType>any(),
        Mockito.<Locale>any(), Mockito.<Integer>any(), Mockito.<Map<String, Object>>any(), anyBoolean()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    HashMap<String, Object> mvelParameters = new HashMap<>();
    SandBoxImpl currentSandbox = new SandBoxImpl();
    StructuredContentTypeImpl structuredContentType = new StructuredContentTypeImpl();
    LocaleImpl locale = new LocaleImpl();
    HashMap<String, String> tagAttributes = new HashMap<>();

    // Act
    List<StructuredContentDTO> actualContentItems = contentProcessor.getContentItems("", 3, request, mvelParameters,
        currentSandbox, structuredContentType, locale, "Tag Name", tagAttributes, new HashMap<>(),
        mock(BroadleafTemplateContext.class));

    // Assert
    verify(structuredContentService).lookupStructuredContentItemsByType(isA(StructuredContentType.class),
        isA(Locale.class), eq(3), isA(Map.class), eq(false));
    verify(contentProcessorExtensionHandler).addAdditionalFieldsToModel(eq("Tag Name"), isA(Map.class), isA(Map.class),
        isA(BroadleafTemplateContext.class));
    verify(contentProcessorExtensionManager).getProxy();
    assertTrue(actualContentItems.isEmpty());
  }

  /**
   * Test {@link ContentProcessor#getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then calls {@link StructuredContentService#lookupStructuredContentItemsByType(StructuredContentType, Locale, Integer, Map, boolean)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentProcessor#getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List ContentProcessor.getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)"})
  public void testGetContentItems_thenCallsLookupStructuredContentItemsByType2() {
    // Arrange
    ContentProcessorExtensionHandler contentProcessorExtensionHandler = mock(ContentProcessorExtensionHandler.class);
    when(contentProcessorExtensionHandler.addAdditionalFieldsToModel(Mockito.<String>any(),
        Mockito.<Map<String, String>>any(), Mockito.<Map<String, Object>>any(),
        Mockito.<BroadleafTemplateContext>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(contentProcessorExtensionManager.getProxy()).thenReturn(contentProcessorExtensionHandler);
    when(structuredContentService.lookupStructuredContentItemsByType(Mockito.<StructuredContentType>any(),
        Mockito.<Locale>any(), Mockito.<Integer>any(), Mockito.<Map<String, Object>>any(), anyBoolean()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    HashMap<String, Object> mvelParameters = new HashMap<>();
    SandBoxImpl currentSandbox = new SandBoxImpl();
    StructuredContentTypeImpl structuredContentType = new StructuredContentTypeImpl();
    LocaleImpl locale = new LocaleImpl();
    HashMap<String, String> tagAttributes = new HashMap<>();

    // Act
    List<StructuredContentDTO> actualContentItems = contentProcessor.getContentItems(null, 3, request, mvelParameters,
        currentSandbox, structuredContentType, locale, "Tag Name", tagAttributes, new HashMap<>(),
        mock(BroadleafTemplateContext.class));

    // Assert
    verify(structuredContentService).lookupStructuredContentItemsByType(isA(StructuredContentType.class),
        isA(Locale.class), eq(3), isA(Map.class), eq(false));
    verify(contentProcessorExtensionHandler).addAdditionalFieldsToModel(eq("Tag Name"), isA(Map.class), isA(Map.class),
        isA(BroadleafTemplateContext.class));
    verify(contentProcessorExtensionManager).getProxy();
    assertTrue(actualContentItems.isEmpty());
  }

  /**
   * Test {@link ContentProcessor#getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then calls {@link StructuredContentService#lookupStructuredContentItemsByType(StructuredContentType, Locale, Integer, Map, boolean)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentProcessor#getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List ContentProcessor.getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)"})
  public void testGetContentItems_thenCallsLookupStructuredContentItemsByType3() {
    // Arrange
    ContentProcessorExtensionHandler contentProcessorExtensionHandler = mock(ContentProcessorExtensionHandler.class);
    when(contentProcessorExtensionHandler.addAdditionalFieldsToModel(Mockito.<String>any(),
        Mockito.<Map<String, String>>any(), Mockito.<Map<String, Object>>any(),
        Mockito.<BroadleafTemplateContext>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(contentProcessorExtensionManager.getProxy()).thenReturn(contentProcessorExtensionHandler);
    when(structuredContentService.lookupStructuredContentItemsByType(Mockito.<StructuredContentType>any(),
        Mockito.<Locale>any(), Mockito.<Integer>any(), Mockito.<Map<String, Object>>any(), anyBoolean()))
        .thenReturn(new ArrayList<>());
    HashMap<String, Object> mvelParameters = new HashMap<>();
    SandBoxImpl currentSandbox = new SandBoxImpl();
    StructuredContentTypeImpl structuredContentType = new StructuredContentTypeImpl();
    LocaleImpl locale = new LocaleImpl();
    HashMap<String, String> tagAttributes = new HashMap<>();

    // Act
    List<StructuredContentDTO> actualContentItems = contentProcessor.getContentItems("", 3, null, mvelParameters,
        currentSandbox, structuredContentType, locale, "Tag Name", tagAttributes, new HashMap<>(),
        mock(BroadleafTemplateContext.class));

    // Assert
    verify(structuredContentService).lookupStructuredContentItemsByType(isA(StructuredContentType.class),
        isA(Locale.class), eq(3), isA(Map.class), eq(false));
    verify(contentProcessorExtensionHandler).addAdditionalFieldsToModel(eq("Tag Name"), isA(Map.class), isA(Map.class),
        isA(BroadleafTemplateContext.class));
    verify(contentProcessorExtensionManager).getProxy();
    assertTrue(actualContentItems.isEmpty());
  }

  /**
   * Test {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@code Parse Expression}.</li>
   *   <li>Then return size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ContentProcessor.buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)"})
  public void testBuildMvelParameters_givenParseExpression_thenReturnSizeIsThree() {
    // Arrange
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
   * Test {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then {@code category} return {@link BroadleafRequestContext}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ContentProcessor.buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)"})
  public void testBuildMvelParameters_thenCategoryReturnBroadleafRequestContext() {
    // Arrange
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
    Object getResult = actualBuildMvelParametersResult.get("category");
    assertTrue(getResult instanceof BroadleafRequestContext);
    assertTrue(actualBuildMvelParametersResult.containsKey("request"));
    assertTrue(actualBuildMvelParametersResult.containsKey("time"));
    assertSame(broadleafRequestContext, getResult);
  }

  /**
   * Test {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ContentProcessor.buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)"})
  public void testBuildMvelParameters_thenReturnSizeIsFour() {
    // Arrange
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
    assertEquals("Parse Expression", actualBuildMvelParametersResult.get("category"));
    assertEquals("Parse Expression", actualBuildMvelParametersResult.get("product"));
    assertTrue(actualBuildMvelParametersResult.containsKey("request"));
    assertTrue(actualBuildMvelParametersResult.containsKey("time"));
  }

  /**
   * Test {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ContentProcessor.buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)"})
  public void testBuildMvelParameters_thenThrowIllegalArgumentException() {
    // Arrange
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
   * Test {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ContentProcessor.buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)"})
  public void testBuildMvelParameters_thenThrowIllegalArgumentException2() {
    // Arrange
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
   * Test {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>When {@link BroadleafTemplateContext} {@link BroadleafTemplateContext#parseExpression(String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ContentProcessor.buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)"})
  public void testBuildMvelParameters_whenBroadleafTemplateContextParseExpressionReturnNull() {
    // Arrange
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
   * Test {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ContentProcessor.buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)"})
  public void testBuildMvelParameters_whenHashMap_thenReturnSizeIsTwo() {
    // Arrange
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
   * Test {@link ContentProcessor#isSecure(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code HTTPS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentProcessor#isSecure(HttpServletRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then calls {@link ServletRequestWrapper#isSecure()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentProcessor#isSecure(HttpServletRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentProcessor#isSecure(HttpServletRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ContentProcessor.isSecure(HttpServletRequest)"})
  public void testIsSecure_whenMockHttpServletRequest_thenReturnFalse() {
    // Arrange, Act and Assert
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ContentProcessor.isSecure(HttpServletRequest)"})
  public void testIsSecure_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(contentProcessor.isSecure(null));
  }
}

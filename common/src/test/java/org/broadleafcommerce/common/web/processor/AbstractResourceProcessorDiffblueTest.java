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
package org.broadleafcommerce.common.web.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequestWrapper;
import org.broadleafcommerce.common.resource.service.ResourceBundlingService;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.broadleafcommerce.common.web.processor.attributes.ResourceTagAttributes;
import org.broadleafcommerce.common.web.request.ResourcesRequest;
import org.broadleafcommerce.common.web.request.ResourcesRequestBundle;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.broadleafcommerce.presentation.model.BroadleafTemplateModel;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertyResolver;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@RunWith(MockitoJUnitRunner.class)
public class AbstractResourceProcessorDiffblueTest {
  @Mock
  private Environment environment;

  @InjectMocks
  private ResourceBundleProcessor resourceBundleProcessor;

  @Mock
  private ResourceBundlingService resourceBundlingService;

  @Mock
  private ResourcesRequest resourcesRequest;

  /**
   * Test {@link AbstractResourceProcessor#getBundleEnabled()}.
   * <ul>
   *   <li>Given {@link Environment} {@link PropertyResolver#getProperty(String)} return {@code Property}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractResourceProcessor#getBundleEnabled()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractResourceProcessor.getBundleEnabled()"})
  public void testGetBundleEnabled_givenEnvironmentGetPropertyReturnProperty_thenReturnFalse() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    // Act
    boolean actualBundleEnabled = resourceBundleProcessor.getBundleEnabled();

    // Assert
    verify(environment).getProperty(eq("bundle.enabled"));
    assertFalse(actualBundleEnabled);
  }

  /**
   * Test {@link AbstractResourceProcessor#getReplacementModel(String, Map, BroadleafTemplateContext)}.
   * <p>
   * Method under test: {@link AbstractResourceProcessor#getReplacementModel(String, Map, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafTemplateModel AbstractResourceProcessor.getReplacementModel(String, Map, BroadleafTemplateContext)"})
  public void testGetReplacementModel() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ArrayList<String> files = new ArrayList<>();
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ResourcesRequestBundle("name", "name", files, new ArrayList<>()));

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("name", "name");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act
    resourceBundleProcessor.getReplacementModel("Tag Name", tagAttributes, context);

    // Assert
    verify(resourcesRequest, atLeast(1)).getBundle(eq("name"), isNull(), isA(List.class));
    verify(context).createModel();
    verify(environment, atLeast(1)).getProperty(eq("bundle.enabled"));
  }

  /**
   * Test {@link AbstractResourceProcessor#getReplacementModel(String, Map, BroadleafTemplateContext)}.
   * <p>
   * Method under test: {@link AbstractResourceProcessor#getReplacementModel(String, Map, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafTemplateModel AbstractResourceProcessor.getReplacementModel(String, Map, BroadleafTemplateContext)"})
  public void testGetReplacementModel2() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ResourcesRequestBundle resourcesRequestBundle = mock(ResourcesRequestBundle.class);
    when(resourcesRequestBundle.getBundleFilePaths()).thenReturn(new ArrayList<>());
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("name", "name");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act
    resourceBundleProcessor.getReplacementModel("Tag Name", tagAttributes, context);

    // Assert
    verify(resourcesRequest, atLeast(1)).getBundle(eq("name"), isNull(), isA(List.class));
    verify(resourcesRequestBundle).getBundleFilePaths();
    verify(context).createModel();
    verify(environment, atLeast(1)).getProperty(eq("bundle.enabled"));
  }

  /**
   * Test {@link AbstractResourceProcessor#getReplacementModel(String, Map, BroadleafTemplateContext)}.
   * <p>
   * Method under test: {@link AbstractResourceProcessor#getReplacementModel(String, Map, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafTemplateModel AbstractResourceProcessor.getReplacementModel(String, Map, BroadleafTemplateContext)"})
  public void testGetReplacementModel3() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ResourcesRequestBundle resourcesRequestBundle = mock(ResourcesRequestBundle.class);
    when(resourcesRequestBundle.getBundleFilePaths()).thenThrow(new IllegalArgumentException("name"));
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("name", "name");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> resourceBundleProcessor.getReplacementModel("Tag Name", tagAttributes, context));
    verify(resourcesRequest, atLeast(1)).getBundle(eq("name"), isNull(), isA(List.class));
    verify(resourcesRequestBundle).getBundleFilePaths();
    verify(context).createModel();
    verify(environment).getProperty(eq("bundle.enabled"));
  }

  /**
   * Test {@link AbstractResourceProcessor#getReplacementModel(String, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given Bean Name{blResourcesRequest} {@link ResourcesRequest#getBundle(String, String, List)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractResourceProcessor#getReplacementModel(String, Map, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafTemplateModel AbstractResourceProcessor.getReplacementModel(String, Map, BroadleafTemplateContext)"})
  public void testGetReplacementModel_givenBeanNameBlResourcesRequestGetBundleReturnNull() {
    // Arrange
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(null);

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("name", "name");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> resourceBundleProcessor.getReplacementModel("Tag Name",
        tagAttributes, mock(BroadleafTemplateContext.class)));
    verify(resourcesRequest).getBundle(eq("name"), isNull(), isA(List.class));
  }

  /**
   * Test {@link AbstractResourceProcessor#getReplacementModel(String, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link HashMap#HashMap()} {@code name} is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractResourceProcessor#getReplacementModel(String, Map, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafTemplateModel AbstractResourceProcessor.getReplacementModel(String, Map, BroadleafTemplateContext)"})
  public void testGetReplacementModel_givenEmptyString_whenHashMapNameIsEmptyString() {
    // Arrange
    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("name", "");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> resourceBundleProcessor.getReplacementModel("Tag Name",
        tagAttributes, mock(BroadleafTemplateContext.class)));
  }

  /**
   * Test {@link AbstractResourceProcessor#getReplacementModel(String, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@link ResourceBundleProcessor} (default constructor).</li>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractResourceProcessor#getReplacementModel(String, Map, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafTemplateModel AbstractResourceProcessor.getReplacementModel(String, Map, BroadleafTemplateContext)"})
  public void testGetReplacementModel_givenResourceBundleProcessor_whenHashMap() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> resourceBundleProcessor.getReplacementModel("Tag Name",
        new HashMap<>(), mock(BroadleafTemplateContext.class)));
  }

  /**
   * Test {@link AbstractResourceProcessor#getReplacementModel(String, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then calls {@link ResourcesRequest#saveBundle(String, String, List, List)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractResourceProcessor#getReplacementModel(String, Map, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafTemplateModel AbstractResourceProcessor.getReplacementModel(String, Map, BroadleafTemplateContext)"})
  public void testGetReplacementModel_thenCallsSaveBundle() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    doNothing().when(resourcesRequest)
        .saveBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any(),
            Mockito.<List<String>>any());
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path"));

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("name", "name");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act
    resourceBundleProcessor.getReplacementModel("Tag Name", tagAttributes, context);

    // Assert
    verify(resourcesRequest, atLeast(1)).getBundle(eq("name"), isNull(), isA(List.class));
    verify(resourcesRequest).saveBundle(eq("name"), (String) isNull(), isA(List.class), isA(List.class));
    verify(context).createModel();
    verify(environment, atLeast(1)).getProperty(eq("bundle.enabled"));
  }

  /**
   * Test {@link AbstractResourceProcessor#getRequestedFileNames(String)}.
   * <ul>
   *   <li>When {@code foo.txt}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractResourceProcessor#getRequestedFileNames(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AbstractResourceProcessor.getRequestedFileNames(String)"})
  public void testGetRequestedFileNames_whenFooTxt_thenReturnSizeIsOne() {
    // Arrange and Act
    List<String> actualRequestedFileNames = (new ResourceBundleProcessor()).getRequestedFileNames("foo.txt");

    // Assert
    assertEquals(1, actualRequestedFileNames.size());
    assertEquals("foo.txt", actualRequestedFileNames.get(0));
  }

  /**
   * Test {@link AbstractResourceProcessor#getRequestedFileNames(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractResourceProcessor#getRequestedFileNames(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AbstractResourceProcessor.getRequestedFileNames(String)"})
  public void testGetRequestedFileNames_whenNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new ResourceBundleProcessor()).getRequestedFileNames(null).isEmpty());
  }

  /**
   * Test {@link AbstractResourceProcessor#getRequestedFileNames(String)}.
   * <ul>
   *   <li>When space.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractResourceProcessor#getRequestedFileNames(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AbstractResourceProcessor.getRequestedFileNames(String)"})
  public void testGetRequestedFileNames_whenSpace_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new ResourceBundleProcessor()).getRequestedFileNames(" ").isEmpty());
  }

  /**
   * Test {@link AbstractResourceProcessor#buildResourceTagAttributes(Map)}.
   * <p>
   * Method under test: {@link AbstractResourceProcessor#buildResourceTagAttributes(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ResourceTagAttributes AbstractResourceProcessor.buildResourceTagAttributes(Map)"})
  public void testBuildResourceTagAttributes() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    // Act
    ResourceTagAttributes actualBuildResourceTagAttributesResult = resourceBundleProcessor
        .buildResourceTagAttributes(new HashMap<>());

    // Assert
    assertNull(actualBuildResourceTagAttributesResult.bundleCompletedEvent());
    assertNull(actualBuildResourceTagAttributesResult.bundleDependencyEvent());
    assertNull(actualBuildResourceTagAttributesResult.files());
    assertNull(actualBuildResourceTagAttributesResult.mappingPrefix());
    assertNull(actualBuildResourceTagAttributesResult.name());
    assertNull(actualBuildResourceTagAttributesResult.src());
    assertFalse(actualBuildResourceTagAttributesResult.async());
    assertFalse(actualBuildResourceTagAttributesResult.defer());
    assertFalse(actualBuildResourceTagAttributesResult.includeAsyncDeferUnbundled());
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@link DefaultMultipartHttpServletRequest} {@link HttpServletRequestWrapper#getContextPath()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractResourceProcessor.getBundleUrl(String, BroadleafTemplateContext)"})
  public void testGetBundleUrl_givenDefaultMultipartHttpServletRequestGetContextPathReturnNull() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getContextPath()).thenReturn(null);
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getRequest()).thenReturn(new SessionlessHttpServletRequestWrapper(request));

    // Act
    String actualBundleUrl = resourceBundleProcessor.getBundleUrl("https://example.org/example", context);

    // Assert
    verify(request).getContextPath();
    verify(context).getRequest();
    assertEquals("/https://example.org/example", actualBundleUrl);
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link BroadleafTemplateContext} {@link BroadleafTemplateContext#getRequest()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractResourceProcessor.getBundleUrl(String, BroadleafTemplateContext)"})
  public void testGetBundleUrl_givenNull_whenBroadleafTemplateContextGetRequestReturnNull() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getRequest()).thenReturn(null);

    // Act
    String actualBundleUrl = resourceBundleProcessor.getBundleUrl("https://example.org/example", context);

    // Assert
    verify(context).getRequest();
    assertEquals("/https://example.org/example", actualBundleUrl);
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return {@code /https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractResourceProcessor.getBundleUrl(String, BroadleafTemplateContext)"})
  public void testGetBundleUrl_thenReturnHttpsExampleOrgExample() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getRequest()).thenReturn(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act
    String actualBundleUrl = resourceBundleProcessor.getBundleUrl("https://example.org/example", context);

    // Assert
    verify(context).getRequest();
    assertEquals("/https://example.org/example", actualBundleUrl);
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return {@code https://example.org/example/https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractResourceProcessor.getBundleUrl(String, BroadleafTemplateContext)"})
  public void testGetBundleUrl_thenReturnHttpsExampleOrgExampleHttpsExampleOrgExample() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getContextPath()).thenReturn("https://example.org/example");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getRequest()).thenReturn(new SessionlessHttpServletRequestWrapper(request));

    // Act
    String actualBundleUrl = resourceBundleProcessor.getBundleUrl("https://example.org/example", context);

    // Assert
    verify(request).getContextPath();
    verify(context).getRequest();
    assertEquals("https://example.org/example/https://example.org/example", actualBundleUrl);
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractResourceProcessor.getBundleUrl(String, BroadleafTemplateContext)"})
  public void testGetBundleUrl_thenThrowIllegalArgumentException() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();
    DefaultMultipartHttpServletRequest defaultMultipartHttpServletRequest = mock(
        DefaultMultipartHttpServletRequest.class);
    when(defaultMultipartHttpServletRequest.getContextPath()).thenThrow(new IllegalArgumentException("/"));
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getRequest()).thenReturn(defaultMultipartHttpServletRequest);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> resourceBundleProcessor.getBundleUrl("https://example.org/example", context));
    verify(defaultMultipartHttpServletRequest).getContextPath();
    verify(context).getRequest();
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractResourceProcessor.getBundleUrl(String, BroadleafTemplateContext)"})
  public void testGetBundleUrl_whenEmptyString_thenReturnSlash() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getRequest()).thenReturn(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act
    String actualBundleUrl = resourceBundleProcessor.getBundleUrl("", context);

    // Assert
    verify(context).getRequest();
    assertEquals("/", actualBundleUrl);
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code /null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractResourceProcessor.getBundleUrl(String, BroadleafTemplateContext)"})
  public void testGetBundleUrl_whenNull_thenReturnNull() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getRequest()).thenReturn(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act
    String actualBundleUrl = resourceBundleProcessor.getBundleUrl(null, context);

    // Assert
    verify(context).getRequest();
    assertEquals("/null", actualBundleUrl);
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractResourceProcessor.getBundleUrl(String, BroadleafTemplateContext)"})
  public void testGetBundleUrl_whenSlash_thenReturnSlash() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getRequest()).thenReturn(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act
    String actualBundleUrl = resourceBundleProcessor.getBundleUrl("/", context);

    // Assert
    verify(context).getRequest();
    assertEquals("/", actualBundleUrl);
  }

  /**
   * Test {@link AbstractResourceProcessor#buildBundledFilesList(ResourceTagAttributes)}.
   * <ul>
   *   <li>Given space.</li>
   *   <li>When {@link ResourceTagAttributes#ResourceTagAttributes()} files space.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractResourceProcessor#buildBundledFilesList(ResourceTagAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AbstractResourceProcessor.buildBundledFilesList(ResourceTagAttributes)"})
  public void testBuildBundledFilesList_givenSpace_whenResourceTagAttributesFilesSpace() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    ResourceTagAttributes tagAttributes = new ResourceTagAttributes();
    tagAttributes.files(" ");

    // Act and Assert
    assertTrue(resourceBundleProcessor.buildBundledFilesList(tagAttributes).isEmpty());
  }

  /**
   * Test {@link AbstractResourceProcessor#buildBundledFilesList(ResourceTagAttributes)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractResourceProcessor#buildBundledFilesList(ResourceTagAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AbstractResourceProcessor.buildBundledFilesList(ResourceTagAttributes)"})
  public void testBuildBundledFilesList_thenReturnSizeIsOne() {
    // Arrange
    when(resourceBundlingService.getAdditionalBundleFiles(Mockito.<String>any())).thenReturn(new ArrayList<>());

    ResourceTagAttributes tagAttributes = new ResourceTagAttributes();
    tagAttributes.files("not blank");

    // Act
    List<String> actualBuildBundledFilesListResult = resourceBundleProcessor.buildBundledFilesList(tagAttributes);

    // Assert
    verify(resourceBundlingService).getAdditionalBundleFiles(isNull());
    assertEquals(1, actualBuildBundledFilesListResult.size());
    assertEquals("not blank", actualBuildBundledFilesListResult.get(0));
  }

  /**
   * Test {@link AbstractResourceProcessor#buildBundledFilesList(ResourceTagAttributes)}.
   * <ul>
   *   <li>When {@link ResourceTagAttributes#ResourceTagAttributes()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractResourceProcessor#buildBundledFilesList(ResourceTagAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AbstractResourceProcessor.buildBundledFilesList(ResourceTagAttributes)"})
  public void testBuildBundledFilesList_whenResourceTagAttributes_thenReturnEmpty() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    // Act and Assert
    assertTrue(resourceBundleProcessor.buildBundledFilesList(new ResourceTagAttributes()).isEmpty());
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundlePath(ResourceTagAttributes, List)}.
   * <p>
   * Method under test: {@link AbstractResourceProcessor#getBundlePath(ResourceTagAttributes, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractResourceProcessor.getBundlePath(ResourceTagAttributes, List)"})
  public void testGetBundlePath() {
    // Arrange
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path"));
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    // Act
    String actualBundlePath = resourceBundleProcessor.getBundlePath(attributes, new ArrayList<>());

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    assertEquals("Bundle Path", actualBundlePath);
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundlePath(ResourceTagAttributes, List)}.
   * <p>
   * Method under test: {@link AbstractResourceProcessor#getBundlePath(ResourceTagAttributes, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractResourceProcessor.getBundlePath(ResourceTagAttributes, List)"})
  public void testGetBundlePath2() {
    // Arrange
    when(resourceBundlingService.resolveBundleResourceName(Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<List<String>>any(), Mockito.<String>any())).thenReturn("Resolve Bundle Resource Name");
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", new ArrayList<>(), (String) null));
    doNothing().when(resourcesRequest)
        .saveBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any(), Mockito.<String>any());
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    // Act
    String actualBundlePath = resourceBundleProcessor.getBundlePath(attributes, new ArrayList<>());

    // Assert
    verify(resourceBundlingService).resolveBundleResourceName(isNull(), isNull(), isA(List.class), isNull());
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequest).saveBundle((String) isNull(), (String) isNull(), isA(List.class),
        eq("Resolve Bundle Resource Name"));
    assertEquals("Resolve Bundle Resource Name", actualBundlePath);
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundlePath(ResourceTagAttributes, List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code Bundle Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractResourceProcessor#getBundlePath(ResourceTagAttributes, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractResourceProcessor.getBundlePath(ResourceTagAttributes, List)"})
  public void testGetBundlePath_given42_whenArrayListAdd42_thenReturnBundlePath() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle = mock(ResourcesRequestBundle.class);
    when(resourcesRequestBundle.getBundlePath()).thenReturn("Bundle Path");
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    ArrayList<String> files = new ArrayList<>();
    files.add("42");
    files.add("foo");

    // Act
    String actualBundlePath = resourceBundleProcessor.getBundlePath(attributes, files);

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequestBundle).getBundlePath();
    assertEquals("Bundle Path", actualBundlePath);
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundlePath(ResourceTagAttributes, List)}.
   * <ul>
   *   <li>Given Bean Name{blResourcesRequest} {@link ResourcesRequest#getBundle(String, String, List)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractResourceProcessor#getBundlePath(ResourceTagAttributes, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractResourceProcessor.getBundlePath(ResourceTagAttributes, List)"})
  public void testGetBundlePath_givenBeanNameBlResourcesRequestGetBundleReturnNull() {
    // Arrange
    when(resourceBundlingService.resolveBundleResourceName(Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<List<String>>any(), Mockito.<String>any())).thenReturn("Resolve Bundle Resource Name");
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(null);
    doNothing().when(resourcesRequest)
        .saveBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any(), Mockito.<String>any());
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    // Act
    String actualBundlePath = resourceBundleProcessor.getBundlePath(attributes, new ArrayList<>());

    // Assert
    verify(resourceBundlingService).resolveBundleResourceName(isNull(), isNull(), isA(List.class), isNull());
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequest).saveBundle((String) isNull(), (String) isNull(), isA(List.class),
        eq("Resolve Bundle Resource Name"));
    assertEquals("Resolve Bundle Resource Name", actualBundlePath);
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundlePath(ResourceTagAttributes, List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then return {@code Bundle Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractResourceProcessor#getBundlePath(ResourceTagAttributes, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractResourceProcessor.getBundlePath(ResourceTagAttributes, List)"})
  public void testGetBundlePath_givenFoo_whenArrayListAddFoo_thenReturnBundlePath() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle = mock(ResourcesRequestBundle.class);
    when(resourcesRequestBundle.getBundlePath()).thenReturn("Bundle Path");
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    ArrayList<String> files = new ArrayList<>();
    files.add("foo");

    // Act
    String actualBundlePath = resourceBundleProcessor.getBundlePath(attributes, files);

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequestBundle).getBundlePath();
    assertEquals("Bundle Path", actualBundlePath);
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundlePath(ResourceTagAttributes, List)}.
   * <ul>
   *   <li>Then return {@code Bundle Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractResourceProcessor#getBundlePath(ResourceTagAttributes, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractResourceProcessor.getBundlePath(ResourceTagAttributes, List)"})
  public void testGetBundlePath_thenReturnBundlePath() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle = mock(ResourcesRequestBundle.class);
    when(resourcesRequestBundle.getBundlePath()).thenReturn("Bundle Path");
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    // Act
    String actualBundlePath = resourceBundleProcessor.getBundlePath(attributes, new ArrayList<>());

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequestBundle).getBundlePath();
    assertEquals("Bundle Path", actualBundlePath);
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundlePath(ResourceTagAttributes, List)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractResourceProcessor#getBundlePath(ResourceTagAttributes, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractResourceProcessor.getBundlePath(ResourceTagAttributes, List)"})
  public void testGetBundlePath_thenThrowIllegalArgumentException() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle = mock(ResourcesRequestBundle.class);
    when(resourcesRequestBundle.getBundlePath()).thenThrow(new IllegalArgumentException("foo"));
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> resourceBundleProcessor.getBundlePath(attributes, new ArrayList<>()));
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequestBundle).getBundlePath();
  }

  /**
   * Test {@link AbstractResourceProcessor#postProcessUnbundledFileList(List, ResourceTagAttributes, BroadleafTemplateContext)}.
   * <p>
   * Method under test: {@link AbstractResourceProcessor#postProcessUnbundledFileList(List, ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List AbstractResourceProcessor.postProcessUnbundledFileList(List, ResourceTagAttributes, BroadleafTemplateContext)"})
  public void testPostProcessUnbundledFileList() {
    // Arrange
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path"));
    doNothing().when(resourcesRequest)
        .saveBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any(),
            Mockito.<List<String>>any());
    ArrayList<String> attributeFiles = new ArrayList<>();

    // Act
    List<String> actualPostProcessUnbundledFileListResult = resourceBundleProcessor.postProcessUnbundledFileList(
        attributeFiles, new ResourceTagAttributes(), mock(BroadleafTemplateContext.class));

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequest).saveBundle((String) isNull(), (String) isNull(), isA(List.class), isA(List.class));
    assertTrue(actualPostProcessUnbundledFileListResult.isEmpty());
  }

  /**
   * Test {@link AbstractResourceProcessor#postProcessUnbundledFileList(List, ResourceTagAttributes, BroadleafTemplateContext)}.
   * <p>
   * Method under test: {@link AbstractResourceProcessor#postProcessUnbundledFileList(List, ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List AbstractResourceProcessor.postProcessUnbundledFileList(List, ResourceTagAttributes, BroadleafTemplateContext)"})
  public void testPostProcessUnbundledFileList2() {
    // Arrange
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(null);
    doNothing().when(resourcesRequest)
        .saveBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any(),
            Mockito.<List<String>>any());
    ArrayList<String> attributeFiles = new ArrayList<>();

    // Act
    List<String> actualPostProcessUnbundledFileListResult = resourceBundleProcessor.postProcessUnbundledFileList(
        attributeFiles, new ResourceTagAttributes(), mock(BroadleafTemplateContext.class));

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequest).saveBundle((String) isNull(), (String) isNull(), isA(List.class), isA(List.class));
    assertTrue(actualPostProcessUnbundledFileListResult.isEmpty());
  }

  /**
   * Test {@link AbstractResourceProcessor#postProcessUnbundledFileList(List, ResourceTagAttributes, BroadleafTemplateContext)}.
   * <p>
   * Method under test: {@link AbstractResourceProcessor#postProcessUnbundledFileList(List, ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List AbstractResourceProcessor.postProcessUnbundledFileList(List, ResourceTagAttributes, BroadleafTemplateContext)"})
  public void testPostProcessUnbundledFileList3() {
    // Arrange
    ArrayList<String> files = new ArrayList<>();
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", files, new ArrayList<>()));
    ArrayList<String> attributeFiles = new ArrayList<>();

    // Act
    List<String> actualPostProcessUnbundledFileListResult = resourceBundleProcessor.postProcessUnbundledFileList(
        attributeFiles, new ResourceTagAttributes(), mock(BroadleafTemplateContext.class));

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    assertTrue(actualPostProcessUnbundledFileListResult.isEmpty());
  }

  /**
   * Test {@link AbstractResourceProcessor#postProcessUnbundledFileList(List, ResourceTagAttributes, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractResourceProcessor#postProcessUnbundledFileList(List, ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List AbstractResourceProcessor.postProcessUnbundledFileList(List, ResourceTagAttributes, BroadleafTemplateContext)"})
  public void testPostProcessUnbundledFileList_given42_whenArrayListAdd42() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle = mock(ResourcesRequestBundle.class);
    when(resourcesRequestBundle.getBundleFilePaths()).thenReturn(new ArrayList<>());
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);

    ArrayList<String> attributeFiles = new ArrayList<>();
    attributeFiles.add("42");
    attributeFiles.add("foo");

    // Act
    List<String> actualPostProcessUnbundledFileListResult = resourceBundleProcessor.postProcessUnbundledFileList(
        attributeFiles, new ResourceTagAttributes(), mock(BroadleafTemplateContext.class));

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequestBundle).getBundleFilePaths();
    assertTrue(actualPostProcessUnbundledFileListResult.isEmpty());
  }

  /**
   * Test {@link AbstractResourceProcessor#postProcessUnbundledFileList(List, ResourceTagAttributes, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractResourceProcessor#postProcessUnbundledFileList(List, ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List AbstractResourceProcessor.postProcessUnbundledFileList(List, ResourceTagAttributes, BroadleafTemplateContext)"})
  public void testPostProcessUnbundledFileList_givenFoo_whenArrayListAddFoo() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle = mock(ResourcesRequestBundle.class);
    when(resourcesRequestBundle.getBundleFilePaths()).thenReturn(new ArrayList<>());
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);

    ArrayList<String> attributeFiles = new ArrayList<>();
    attributeFiles.add("foo");

    // Act
    List<String> actualPostProcessUnbundledFileListResult = resourceBundleProcessor.postProcessUnbundledFileList(
        attributeFiles, new ResourceTagAttributes(), mock(BroadleafTemplateContext.class));

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequestBundle).getBundleFilePaths();
    assertTrue(actualPostProcessUnbundledFileListResult.isEmpty());
  }

  /**
   * Test {@link AbstractResourceProcessor#postProcessUnbundledFileList(List, ResourceTagAttributes, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then calls {@link ResourcesRequestBundle#getBundleFilePaths()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractResourceProcessor#postProcessUnbundledFileList(List, ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List AbstractResourceProcessor.postProcessUnbundledFileList(List, ResourceTagAttributes, BroadleafTemplateContext)"})
  public void testPostProcessUnbundledFileList_thenCallsGetBundleFilePaths() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle = mock(ResourcesRequestBundle.class);
    when(resourcesRequestBundle.getBundleFilePaths()).thenReturn(new ArrayList<>());
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);
    ArrayList<String> attributeFiles = new ArrayList<>();

    // Act
    List<String> actualPostProcessUnbundledFileListResult = resourceBundleProcessor.postProcessUnbundledFileList(
        attributeFiles, new ResourceTagAttributes(), mock(BroadleafTemplateContext.class));

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequestBundle).getBundleFilePaths();
    assertTrue(actualPostProcessUnbundledFileListResult.isEmpty());
  }

  /**
   * Test {@link AbstractResourceProcessor#postProcessUnbundledFileList(List, ResourceTagAttributes, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractResourceProcessor#postProcessUnbundledFileList(List, ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List AbstractResourceProcessor.postProcessUnbundledFileList(List, ResourceTagAttributes, BroadleafTemplateContext)"})
  public void testPostProcessUnbundledFileList_thenThrowIllegalArgumentException() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle = mock(ResourcesRequestBundle.class);
    when(resourcesRequestBundle.getBundleFilePaths()).thenThrow(new IllegalArgumentException("foo"));
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);
    ArrayList<String> attributeFiles = new ArrayList<>();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> resourceBundleProcessor.postProcessUnbundledFileList(attributeFiles, new ResourceTagAttributes(),
            mock(BroadleafTemplateContext.class)));
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequestBundle).getBundleFilePaths();
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundleAppendText(ResourceTagAttributes)}.
   * <p>
   * Method under test: {@link AbstractResourceProcessor#getBundleAppendText(ResourceTagAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractResourceProcessor.getBundleAppendText(ResourceTagAttributes)"})
  public void testGetBundleAppendText() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    ResourceTagAttributes attributes = new ResourceTagAttributes();
    attributes.bundleCompletedEvent("Attributes");
    attributes.name(".js");

    // Act and Assert
    assertEquals("var AttributesEvent = new CustomEvent('Attributes');document.dispatchEvent(AttributesEvent);",
        resourceBundleProcessor.getBundleAppendText(attributes));
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundleAppendText(ResourceTagAttributes)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractResourceProcessor#getBundleAppendText(ResourceTagAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractResourceProcessor.getBundleAppendText(ResourceTagAttributes)"})
  public void testGetBundleAppendText_givenEmptyString() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    ResourceTagAttributes attributes = new ResourceTagAttributes();
    attributes.bundleCompletedEvent("");
    attributes.name(".js");

    // Act and Assert
    assertNull(resourceBundleProcessor.getBundleAppendText(attributes));
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundleAppendText(ResourceTagAttributes)}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>When {@link ResourceTagAttributes} {@link ResourceTagAttributes#name()} return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractResourceProcessor#getBundleAppendText(ResourceTagAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractResourceProcessor.getBundleAppendText(ResourceTagAttributes)"})
  public void testGetBundleAppendText_givenName_whenResourceTagAttributesNameReturnName() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();
    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.name()).thenReturn("Name");
    when(attributes.bundleCompletedEvent()).thenReturn("Bundle Completed Event");

    // Act
    String actualBundleAppendText = resourceBundleProcessor.getBundleAppendText(attributes);

    // Assert
    verify(attributes).bundleCompletedEvent();
    verify(attributes).name();
    assertNull(actualBundleAppendText);
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundleAppendText(ResourceTagAttributes)}.
   * <ul>
   *   <li>When {@link ResourceTagAttributes#ResourceTagAttributes()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractResourceProcessor#getBundleAppendText(ResourceTagAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractResourceProcessor.getBundleAppendText(ResourceTagAttributes)"})
  public void testGetBundleAppendText_whenResourceTagAttributes_thenReturnNull() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    // Act and Assert
    assertNull(resourceBundleProcessor.getBundleAppendText(new ResourceTagAttributes()));
  }

  /**
   * Test {@link AbstractResourceProcessor#getBundleCompleteEventJavaScript(ResourceTagAttributes)}.
   * <p>
   * Method under test: {@link AbstractResourceProcessor#getBundleCompleteEventJavaScript(ResourceTagAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractResourceProcessor.getBundleCompleteEventJavaScript(ResourceTagAttributes)"})
  public void testGetBundleCompleteEventJavaScript() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    // Act and Assert
    assertEquals("var nullEvent = new CustomEvent('null');document.dispatchEvent(nullEvent);",
        resourceBundleProcessor.getBundleCompleteEventJavaScript(new ResourceTagAttributes()));
  }

  /**
   * Test {@link AbstractResourceProcessor#validateTagAttributes(ResourceTagAttributes)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractResourceProcessor#validateTagAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractResourceProcessor.validateTagAttributes(ResourceTagAttributes)"})
  public void testValidateTagAttributes_givenEmptyString() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();
    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.name()).thenReturn("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> resourceBundleProcessor.validateTagAttributes(attributes));
    verify(attributes).name();
  }

  /**
   * Test {@link AbstractResourceProcessor#validateTagAttributes(ResourceTagAttributes)}.
   * <ul>
   *   <li>When {@link ResourceTagAttributes#ResourceTagAttributes()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractResourceProcessor#validateTagAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractResourceProcessor.validateTagAttributes(ResourceTagAttributes)"})
  public void testValidateTagAttributes_whenResourceTagAttributes() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> resourceBundleProcessor.validateTagAttributes(new ResourceTagAttributes()));
  }
}

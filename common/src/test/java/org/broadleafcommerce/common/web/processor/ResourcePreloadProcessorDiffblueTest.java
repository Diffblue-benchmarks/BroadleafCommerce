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
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.broadleafcommerce.common.web.processor.attributes.ResourceTagAttributes;
import org.broadleafcommerce.common.web.request.ResourcesRequest;
import org.broadleafcommerce.common.web.request.ResourcesRequestBundle;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.broadleafcommerce.presentation.model.BroadleafTemplateElement;
import org.broadleafcommerce.presentation.model.BroadleafTemplateModel;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;

@RunWith(MockitoJUnitRunner.class)
public class ResourcePreloadProcessorDiffblueTest {
  @InjectMocks
  private ResourcePreloadProcessor resourcePreloadProcessor;

  @Mock
  private ResourcesRequest resourcesRequest;

  /**
   * Test {@link ResourcePreloadProcessor#getName()}.
   * <p>
   * Method under test: {@link ResourcePreloadProcessor#getName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourcePreloadProcessor.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("bundlepreload", (new ResourcePreloadProcessor()).getName());
  }

  /**
   * Test {@link ResourcePreloadProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link ResourcePreloadProcessor#getPrecedence()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ResourcePreloadProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(10000, resourcePreloadProcessor.getPrecedence());
  }

  /**
   * Test {@link ResourcePreloadProcessor#buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)}.
   * <p>
   * Method under test: {@link ResourcePreloadProcessor#buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafTemplateModel ResourcePreloadProcessor.buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)"})
  public void testBuildModelBundled() {
    // Arrange
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path"));
    ArrayList<String> attributeFiles = new ArrayList<>();
    ResourceTagAttributes resourceTagAttributes = new ResourceTagAttributes();
    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getRequest()).thenReturn(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    when(context.createStandaloneElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createModel()).thenReturn(broadleafTemplateModel);

    // Act
    resourcePreloadProcessor.buildModelBundled(attributeFiles, resourceTagAttributes, context);

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(context).createModel();
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
    verify(context).getRequest();
    verify(broadleafTemplateModel).addElement(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourcePreloadProcessor#buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)}.
   * <p>
   * Method under test: {@link ResourcePreloadProcessor#buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafTemplateModel ResourcePreloadProcessor.buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)"})
  public void testBuildModelBundled2() {
    // Arrange
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", new ArrayList<>(), ".js"));
    ArrayList<String> attributeFiles = new ArrayList<>();
    ResourceTagAttributes resourceTagAttributes = new ResourceTagAttributes();
    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getRequest()).thenReturn(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    when(context.createStandaloneElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createModel()).thenReturn(broadleafTemplateModel);

    // Act
    resourcePreloadProcessor.buildModelBundled(attributeFiles, resourceTagAttributes, context);

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(context).createModel();
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
    verify(context).getRequest();
    verify(broadleafTemplateModel).addElement(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourcePreloadProcessor#buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)}.
   * <p>
   * Method under test: {@link ResourcePreloadProcessor#buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafTemplateModel ResourcePreloadProcessor.buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)"})
  public void testBuildModelBundled3() {
    // Arrange
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", new ArrayList<>(), ".css"));
    ArrayList<String> attributeFiles = new ArrayList<>();
    ResourceTagAttributes resourceTagAttributes = new ResourceTagAttributes();
    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getRequest()).thenReturn(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    when(context.createStandaloneElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createModel()).thenReturn(broadleafTemplateModel);

    // Act
    resourcePreloadProcessor.buildModelBundled(attributeFiles, resourceTagAttributes, context);

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(context).createModel();
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
    verify(context).getRequest();
    verify(broadleafTemplateModel).addElement(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourcePreloadProcessor#buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@code /}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code /}.</li>
   *   <li>Then calls {@link ResourcesRequest#getBundle(String, String, List)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePreloadProcessor#buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafTemplateModel ResourcePreloadProcessor.buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)"})
  public void testBuildModelBundled_givenSlash_whenArrayListAddSlash_thenCallsGetBundle() {
    // Arrange
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path"));

    ArrayList<String> attributeFiles = new ArrayList<>();
    attributeFiles.add("/");
    ResourceTagAttributes resourceTagAttributes = new ResourceTagAttributes();
    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getRequest()).thenReturn(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    when(context.createStandaloneElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createModel()).thenReturn(broadleafTemplateModel);

    // Act
    resourcePreloadProcessor.buildModelBundled(attributeFiles, resourceTagAttributes, context);

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(context).createModel();
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
    verify(context).getRequest();
    verify(broadleafTemplateModel).addElement(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourcePreloadProcessor#buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@code ThreadLocalManager.notify.orphans}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePreloadProcessor#buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafTemplateModel ResourcePreloadProcessor.buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)"})
  public void testBuildModelBundled_givenThreadLocalManagerNotifyOrphans() {
    // Arrange
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path"));

    ArrayList<String> attributeFiles = new ArrayList<>();
    attributeFiles.add("ThreadLocalManager.notify.orphans");
    attributeFiles.add("/");
    ResourceTagAttributes resourceTagAttributes = new ResourceTagAttributes();
    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getRequest()).thenReturn(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    when(context.createStandaloneElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createModel()).thenReturn(broadleafTemplateModel);

    // Act
    resourcePreloadProcessor.buildModelBundled(attributeFiles, resourceTagAttributes, context);

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(context).createModel();
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
    verify(context).getRequest();
    verify(broadleafTemplateModel).addElement(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourcePreloadProcessor#buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)}.
   * <p>
   * Method under test: {@link ResourcePreloadProcessor#buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafTemplateModel ResourcePreloadProcessor.buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)"})
  public void testBuildModelUnbundled() {
    // Arrange
    ArrayList<String> files = new ArrayList<>();
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", files, new ArrayList<>()));

    ArrayList<String> attributeFiles = new ArrayList<>();
    attributeFiles.add("foo");
    ResourceTagAttributes resourceTagAttributes = new ResourceTagAttributes();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act
    resourcePreloadProcessor.buildModelUnbundled(attributeFiles, resourceTagAttributes, context);

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(context).createModel();
  }

  /**
   * Test {@link ResourcePreloadProcessor#buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@link BroadleafTemplateModel}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePreloadProcessor#buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafTemplateModel ResourcePreloadProcessor.buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)"})
  public void testBuildModelUnbundled_givenBroadleafTemplateModel_whenArrayList() {
    // Arrange
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path"));
    doNothing().when(resourcesRequest)
        .saveBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any(),
            Mockito.<List<String>>any());
    ArrayList<String> attributeFiles = new ArrayList<>();
    ResourceTagAttributes resourceTagAttributes = new ResourceTagAttributes();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act
    resourcePreloadProcessor.buildModelUnbundled(attributeFiles, resourceTagAttributes, context);

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequest).saveBundle((String) isNull(), (String) isNull(), isA(List.class), isA(List.class));
    verify(context).createModel();
  }

  /**
   * Test {@link ResourcePreloadProcessor#buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@code @{'}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePreloadProcessor#buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafTemplateModel ResourcePreloadProcessor.buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)"})
  public void testBuildModelUnbundled_givenCommercialAtLeftCurlyBracketApostrophe() {
    // Arrange
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path"));
    doNothing().when(resourcesRequest)
        .saveBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any(),
            Mockito.<List<String>>any());

    ArrayList<String> attributeFiles = new ArrayList<>();
    attributeFiles.add("foo");
    ResourceTagAttributes resourceTagAttributes = new ResourceTagAttributes();
    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.parseExpression(Mockito.<String>any())).thenReturn("@{'");
    when(context.createModel()).thenReturn(broadleafTemplateModel);

    // Act
    resourcePreloadProcessor.buildModelUnbundled(attributeFiles, resourceTagAttributes, context);

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequest).saveBundle((String) isNull(), (String) isNull(), isA(List.class), isA(List.class));
    verify(context).createModel();
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
    verify(context).parseExpression(eq("@{'nullfoo'}"));
    verify(broadleafTemplateModel).addElement(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourcePreloadProcessor#buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@code .css}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePreloadProcessor#buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafTemplateModel ResourcePreloadProcessor.buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)"})
  public void testBuildModelUnbundled_givenCss() {
    // Arrange
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path"));
    doNothing().when(resourcesRequest)
        .saveBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any(),
            Mockito.<List<String>>any());

    ArrayList<String> attributeFiles = new ArrayList<>();
    attributeFiles.add("foo");
    ResourceTagAttributes resourceTagAttributes = new ResourceTagAttributes();
    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.parseExpression(Mockito.<String>any())).thenReturn(".css");
    when(context.createModel()).thenReturn(broadleafTemplateModel);

    // Act
    resourcePreloadProcessor.buildModelUnbundled(attributeFiles, resourceTagAttributes, context);

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequest).saveBundle((String) isNull(), (String) isNull(), isA(List.class), isA(List.class));
    verify(context).createModel();
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
    verify(context).parseExpression(eq("@{'nullfoo'}"));
    verify(broadleafTemplateModel).addElement(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourcePreloadProcessor#buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@code .js}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code .js}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePreloadProcessor#buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafTemplateModel ResourcePreloadProcessor.buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)"})
  public void testBuildModelUnbundled_givenJs_whenArrayListAddJs() {
    // Arrange
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path"));
    doNothing().when(resourcesRequest)
        .saveBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any(),
            Mockito.<List<String>>any());

    ArrayList<String> attributeFiles = new ArrayList<>();
    attributeFiles.add(".js");
    attributeFiles.add("foo");
    ResourceTagAttributes resourceTagAttributes = new ResourceTagAttributes();
    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.parseExpression(Mockito.<String>any())).thenReturn("@{'");
    when(context.createModel()).thenReturn(broadleafTemplateModel);

    // Act
    resourcePreloadProcessor.buildModelUnbundled(attributeFiles, resourceTagAttributes, context);

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequest).saveBundle((String) isNull(), (String) isNull(), isA(List.class), isA(List.class));
    verify(context).createModel();
    verify(context, atLeast(1)).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
    verify(context, atLeast(1)).parseExpression(Mockito.<String>any());
    verify(broadleafTemplateModel, atLeast(1)).addElement(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourcePreloadProcessor#buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)}.
   * <ul>
   *   <li>When {@link BroadleafTemplateContext} {@link BroadleafTemplateContext#parseExpression(String)} return {@code .js}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePreloadProcessor#buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafTemplateModel ResourcePreloadProcessor.buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)"})
  public void testBuildModelUnbundled_whenBroadleafTemplateContextParseExpressionReturnJs() {
    // Arrange
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path"));
    doNothing().when(resourcesRequest)
        .saveBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any(),
            Mockito.<List<String>>any());

    ArrayList<String> attributeFiles = new ArrayList<>();
    attributeFiles.add("foo");
    ResourceTagAttributes resourceTagAttributes = new ResourceTagAttributes();
    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.parseExpression(Mockito.<String>any())).thenReturn(".js");
    when(context.createModel()).thenReturn(broadleafTemplateModel);

    // Act
    resourcePreloadProcessor.buildModelUnbundled(attributeFiles, resourceTagAttributes, context);

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequest).saveBundle((String) isNull(), (String) isNull(), isA(List.class), isA(List.class));
    verify(context).createModel();
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
    verify(context).parseExpression(eq("@{'nullfoo'}"));
    verify(broadleafTemplateModel).addElement(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourcePreloadProcessor#buildPreloadElement(String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>When {@code .css}.</li>
   *   <li>Then calls {@link BroadleafTemplateContext#createStandaloneElement(String, Map, boolean)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePreloadProcessor#buildPreloadElement(String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafTemplateElement ResourcePreloadProcessor.buildPreloadElement(String, BroadleafTemplateContext)"})
  public void testBuildPreloadElement_whenCss_thenCallsCreateStandaloneElement() {
    // Arrange
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    // Act
    resourcePreloadProcessor.buildPreloadElement(".css", context);

    // Assert
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
  }

  /**
   * Test {@link ResourcePreloadProcessor#buildPreloadElement(String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>When {@code Href}.</li>
   *   <li>Then calls {@link BroadleafTemplateContext#createStandaloneElement(String, Map, boolean)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePreloadProcessor#buildPreloadElement(String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafTemplateElement ResourcePreloadProcessor.buildPreloadElement(String, BroadleafTemplateContext)"})
  public void testBuildPreloadElement_whenHref_thenCallsCreateStandaloneElement() {
    // Arrange
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    // Act
    resourcePreloadProcessor.buildPreloadElement("Href", context);

    // Assert
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
  }

  /**
   * Test {@link ResourcePreloadProcessor#buildPreloadElement(String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>When {@code .js}.</li>
   *   <li>Then calls {@link BroadleafTemplateContext#createStandaloneElement(String, Map, boolean)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePreloadProcessor#buildPreloadElement(String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafTemplateElement ResourcePreloadProcessor.buildPreloadElement(String, BroadleafTemplateContext)"})
  public void testBuildPreloadElement_whenJs_thenCallsCreateStandaloneElement() {
    // Arrange
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    // Act
    resourcePreloadProcessor.buildPreloadElement(".js", context);

    // Assert
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
  }

  /**
   * Test {@link ResourcePreloadProcessor#getPreloadAttributes(String, String)}.
   * <ul>
   *   <li>When {@code As}.</li>
   *   <li>Then return size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePreloadProcessor#getPreloadAttributes(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ResourcePreloadProcessor.getPreloadAttributes(String, String)"})
  public void testGetPreloadAttributes_whenAs_thenReturnSizeIsThree() {
    // Arrange and Act
    Map<String, String> actualPreloadAttributes = resourcePreloadProcessor.getPreloadAttributes("Href", "As");

    // Assert
    assertEquals(3, actualPreloadAttributes.size());
    assertEquals("As", actualPreloadAttributes.get("as"));
    assertEquals("Href", actualPreloadAttributes.get("href"));
    assertEquals("preload", actualPreloadAttributes.get("rel"));
  }

  /**
   * Test {@link ResourcePreloadProcessor#getPreloadAttributes(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePreloadProcessor#getPreloadAttributes(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ResourcePreloadProcessor.getPreloadAttributes(String, String)"})
  public void testGetPreloadAttributes_whenNull_thenReturnSizeIsTwo() {
    // Arrange and Act
    Map<String, String> actualPreloadAttributes = resourcePreloadProcessor.getPreloadAttributes("Href", null);

    // Assert
    assertEquals(2, actualPreloadAttributes.size());
    assertEquals("Href", actualPreloadAttributes.get("href"));
    assertEquals("preload", actualPreloadAttributes.get("rel"));
  }

  /**
   * Test {@link ResourcePreloadProcessor#getAs(String)}.
   * <ul>
   *   <li>When {@code .css}.</li>
   *   <li>Then return {@code style}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePreloadProcessor#getAs(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourcePreloadProcessor.getAs(String)"})
  public void testGetAs_whenCss_thenReturnStyle() {
    // Arrange, Act and Assert
    assertEquals("style", resourcePreloadProcessor.getAs(".css"));
  }

  /**
   * Test {@link ResourcePreloadProcessor#getAs(String)}.
   * <ul>
   *   <li>When {@code File}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePreloadProcessor#getAs(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourcePreloadProcessor.getAs(String)"})
  public void testGetAs_whenFile_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(resourcePreloadProcessor.getAs("File"));
  }

  /**
   * Test {@link ResourcePreloadProcessor#getAs(String)}.
   * <ul>
   *   <li>When {@code .js}.</li>
   *   <li>Then return {@code script}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePreloadProcessor#getAs(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourcePreloadProcessor.getAs(String)"})
  public void testGetAs_whenJs_thenReturnScript() {
    // Arrange, Act and Assert
    assertEquals("script", resourcePreloadProcessor.getAs(".js"));
  }
}

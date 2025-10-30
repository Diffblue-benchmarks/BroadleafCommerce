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
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.resource.service.ResourceBundlingService;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.broadleafcommerce.common.web.processor.attributes.ResourceTagAttributes;
import org.broadleafcommerce.common.web.request.ResourcesRequest;
import org.broadleafcommerce.common.web.request.ResourcesRequestBundle;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.broadleafcommerce.presentation.model.BroadleafTemplateElement;
import org.broadleafcommerce.presentation.model.BroadleafTemplateModel;
import org.broadleafcommerce.presentation.model.BroadleafTemplateNonVoidElement;
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

@RunWith(MockitoJUnitRunner.class)
public class ResourceBundleProcessorDiffblueTest {
  @InjectMocks
  private ResourceBundleProcessor resourceBundleProcessor;

  @Mock
  private Environment environment;

  @Mock
  private ResourcesRequest resourcesRequest;

  @Mock
  private ResourceBundlingService resourceBundlingService;

  /**
   * Test {@link ResourceBundleProcessor#getName()}.
   * <p>
   * Method under test: {@link ResourceBundleProcessor#getName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("bundle", (new ResourceBundleProcessor()).getName());
  }

  /**
   * Test {@link ResourceBundleProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link ResourceBundleProcessor#getPrecedence()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ResourceBundleProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(10000, resourceBundleProcessor.getPrecedence());
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)}.
   * <p>
   * Method under test: {@link ResourceBundleProcessor#buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafTemplateModel ResourceBundleProcessor.buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)"})
  public void testBuildModelUnbundled() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path"));
    doNothing().when(resourcesRequest)
        .saveBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any(),
            Mockito.<List<String>>any());
    ArrayList<String> attributeFiles = new ArrayList<>();
    ResourceTagAttributes attributes = new ResourceTagAttributes();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act
    resourceBundleProcessor.buildModelUnbundled(attributeFiles, attributes, context);

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequest).saveBundle((String) isNull(), (String) isNull(), isA(List.class), isA(List.class));
    verify(context).createModel();
    verify(environment).getProperty(eq("bundle.enabled"));
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)}.
   * <p>
   * Method under test: {@link ResourceBundleProcessor#buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafTemplateModel ResourceBundleProcessor.buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)"})
  public void testBuildModelUnbundled2() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ArrayList<String> files = new ArrayList<>();
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ResourcesRequestBundle("bundle.enabled", "bundle.enabled", files, new ArrayList<>()));
    ArrayList<String> attributeFiles = new ArrayList<>();
    ResourceTagAttributes attributes = new ResourceTagAttributes();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act
    resourceBundleProcessor.buildModelUnbundled(attributeFiles, attributes, context);

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(context).createModel();
    verify(environment).getProperty(eq("bundle.enabled"));
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@code blResourcesRequest} {@link ResourcesRequest#getBundle(String, String, List)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafTemplateModel ResourceBundleProcessor.buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)"})
  public void testBuildModelUnbundled_givenBlResourcesRequestGetBundleReturnNull() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(null);
    doNothing().when(resourcesRequest)
        .saveBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any(),
            Mockito.<List<String>>any());
    ArrayList<String> attributeFiles = new ArrayList<>();
    ResourceTagAttributes attributes = new ResourceTagAttributes();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act
    resourceBundleProcessor.buildModelUnbundled(attributeFiles, attributes, context);

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequest).saveBundle((String) isNull(), (String) isNull(), isA(List.class), isA(List.class));
    verify(context).createModel();
    verify(environment).getProperty(eq("bundle.enabled"));
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafTemplateModel ResourceBundleProcessor.buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)"})
  public void testBuildModelUnbundled_thenThrowIllegalArgumentException() {
    // Arrange
    ArrayList<String> attributeFiles = new ArrayList<>();
    ResourceTagAttributes attributes = new ResourceTagAttributes();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createModel()).thenThrow(new IllegalArgumentException("bundle.enabled"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> resourceBundleProcessor.buildModelUnbundled(attributeFiles, attributes, context));
    verify(context).createModel();
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)}.
   * <p>
   * Method under test: {@link ResourceBundleProcessor#buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafTemplateModel ResourceBundleProcessor.buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)"})
  public void testBuildModelBundled() {
    // Arrange
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path"));
    ArrayList<String> attributeFiles = new ArrayList<>();
    ResourceTagAttributes attributes = new ResourceTagAttributes();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getRequest()).thenReturn(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> resourceBundleProcessor.buildModelBundled(attributeFiles, attributes, context));
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(context).createModel();
    verify(context).getRequest();
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)}.
   * <p>
   * Method under test: {@link ResourceBundleProcessor#buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafTemplateModel ResourceBundleProcessor.buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)"})
  public void testBuildModelBundled2() {
    // Arrange
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", new ArrayList<>(), "/"));
    ArrayList<String> attributeFiles = new ArrayList<>();
    ResourceTagAttributes attributes = new ResourceTagAttributes();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getRequest()).thenReturn(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> resourceBundleProcessor.buildModelBundled(attributeFiles, attributes, context));
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(context).createModel();
    verify(context).getRequest();
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)}.
   * <p>
   * Method under test: {@link ResourceBundleProcessor#buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafTemplateModel ResourceBundleProcessor.buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)"})
  public void testBuildModelBundled3() {
    // Arrange
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", new ArrayList<>(), ";"));
    ArrayList<String> attributeFiles = new ArrayList<>();
    ResourceTagAttributes attributes = new ResourceTagAttributes();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getRequest()).thenReturn(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> resourceBundleProcessor.buildModelBundled(attributeFiles, attributes, context));
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(context).createModel();
    verify(context).getRequest();
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)}.
   * <p>
   * Method under test: {@link ResourceBundleProcessor#buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafTemplateModel ResourceBundleProcessor.buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)"})
  public void testBuildModelBundled4() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", new ArrayList<>(), ".js"));
    ArrayList<String> attributeFiles = new ArrayList<>();
    ResourceTagAttributes attributes = new ResourceTagAttributes();
    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doThrow(new IllegalArgumentException("/")).when(broadleafTemplateModel)
        .addElement(Mockito.<BroadleafTemplateElement>any());
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateNonVoidElement.class));
    when(context.getRequest()).thenReturn(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    when(context.createModel()).thenReturn(broadleafTemplateModel);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> resourceBundleProcessor.buildModelBundled(attributeFiles, attributes, context));
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(context).createModel();
    verify(context).createNonVoidElement(eq("script"), isA(Map.class), eq(true));
    verify(context).getRequest();
    verify(broadleafTemplateModel).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty(eq("bundle.enabled"));
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)}.
   * <p>
   * Method under test: {@link ResourceBundleProcessor#buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafTemplateModel ResourceBundleProcessor.buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)"})
  public void testBuildModelBundled5() {
    // Arrange
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", new ArrayList<>(), ""));
    ArrayList<String> attributeFiles = new ArrayList<>();
    ResourceTagAttributes attributes = new ResourceTagAttributes();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getRequest()).thenReturn(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> resourceBundleProcessor.buildModelBundled(attributeFiles, attributes, context));
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(context).createModel();
    verify(context).getRequest();
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@link Environment} {@link PropertyResolver#getProperty(String)} return {@link Boolean#TRUE} toString.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafTemplateModel ResourceBundleProcessor.buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)"})
  public void testBuildModelBundled_givenEnvironmentGetPropertyReturnTrueToString() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn(Boolean.TRUE.toString());
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", new ArrayList<>(), ".js"));
    ArrayList<String> attributeFiles = new ArrayList<>();
    ResourceTagAttributes attributes = new ResourceTagAttributes();
    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateNonVoidElement.class));
    when(context.getRequest()).thenReturn(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    when(context.createModel()).thenReturn(broadleafTemplateModel);

    // Act
    resourceBundleProcessor.buildModelBundled(attributeFiles, attributes, context);

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(context).createModel();
    verify(context).createNonVoidElement(eq("script"), isA(Map.class), eq(true));
    verify(context).getRequest();
    verify(broadleafTemplateModel).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty(eq("bundle.enabled"));
    assertEquals("/.js", attributes.src());
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then calls {@link ResourceBundlingService#resolveBundleResourceName(String, String, List, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafTemplateModel ResourceBundleProcessor.buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)"})
  public void testBuildModelBundled_thenCallsResolveBundleResourceName() {
    // Arrange
    when(resourceBundlingService.resolveBundleResourceName(Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<List<String>>any(), Mockito.<String>any())).thenReturn("Resolve Bundle Resource Name");
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(null);
    doNothing().when(resourcesRequest)
        .saveBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any(), Mockito.<String>any());
    ArrayList<String> attributeFiles = new ArrayList<>();
    ResourceTagAttributes attributes = new ResourceTagAttributes();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getRequest()).thenReturn(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> resourceBundleProcessor.buildModelBundled(attributeFiles, attributes, context));
    verify(resourceBundlingService).resolveBundleResourceName(isNull(), isNull(), isA(List.class), isNull());
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequest).saveBundle((String) isNull(), (String) isNull(), isA(List.class),
        eq("Resolve Bundle Resource Name"));
    verify(context).createModel();
    verify(context).getRequest();
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then {@link ResourceTagAttributes#ResourceTagAttributes()} src is {@code /.js}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafTemplateModel ResourceBundleProcessor.buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)"})
  public void testBuildModelBundled_thenResourceTagAttributesSrcIsJs() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", new ArrayList<>(), ".js"));
    ArrayList<String> attributeFiles = new ArrayList<>();
    ResourceTagAttributes attributes = new ResourceTagAttributes();
    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateNonVoidElement.class));
    when(context.getRequest()).thenReturn(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    when(context.createModel()).thenReturn(broadleafTemplateModel);

    // Act
    resourceBundleProcessor.buildModelBundled(attributeFiles, attributes, context);

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(context).createModel();
    verify(context).createNonVoidElement(eq("script"), isA(Map.class), eq(true));
    verify(context).getRequest();
    verify(broadleafTemplateModel).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty(eq("bundle.enabled"));
    assertEquals("/.js", attributes.src());
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then throw {@link InvalidParameterException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafTemplateModel ResourceBundleProcessor.buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)"})
  public void testBuildModelBundled_thenThrowInvalidParameterException() {
    // Arrange
    ArrayList<String> attributeFiles = new ArrayList<>();
    ResourceTagAttributes attributes = new ResourceTagAttributes();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createModel()).thenThrow(new InvalidParameterException("/"));

    // Act and Assert
    assertThrows(InvalidParameterException.class,
        () -> resourceBundleProcessor.buildModelBundled(attributeFiles, attributes, context));
    verify(context).createModel();
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)} with {@code attributes}, {@code context}, {@code model}.
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddElementToModelWithAttributesContextModel() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ResourceTagAttributes attributes = new ResourceTagAttributes();
    attributes.src(".js");
    attributes.defer(false);
    attributes.includeAsyncDeferUnbundled(false);
    attributes.async(false);
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateNonVoidElement.class));
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addElementToModel(attributes, context, model);

    // Assert
    verify(context).createNonVoidElement(eq("script"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty(eq("bundle.enabled"));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)} with {@code attributes}, {@code context}, {@code model}.
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddElementToModelWithAttributesContextModel2() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ResourceTagAttributes attributes = new ResourceTagAttributes();
    attributes.src(".js");
    attributes.defer(false);
    attributes.includeAsyncDeferUnbundled(false);
    attributes.async(false);
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateNonVoidElement.class));
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doThrow(new IllegalArgumentException(";")).when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> resourceBundleProcessor.addElementToModel(attributes, context, model));
    verify(context).createNonVoidElement(eq("script"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty(eq("bundle.enabled"));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)} with {@code attributes}, {@code context}, {@code model}.
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddElementToModelWithAttributesContextModel3() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ResourceTagAttributes attributes = new ResourceTagAttributes();
    attributes.src(".js");
    attributes.defer(true);
    attributes.includeAsyncDeferUnbundled(true);
    attributes.async(false);
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateNonVoidElement.class));
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addElementToModel(attributes, context, model);

    // Assert
    verify(context).createNonVoidElement(eq("script"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty(eq("bundle.enabled"));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)} with {@code attributes}, {@code context}, {@code model}.
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddElementToModelWithAttributesContextModel4() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ResourceTagAttributes attributes = new ResourceTagAttributes();
    attributes.src(".js");
    attributes.defer(false);
    attributes.includeAsyncDeferUnbundled(true);
    attributes.async(true);
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateNonVoidElement.class));
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addElementToModel(attributes, context, model);

    // Assert
    verify(context).createNonVoidElement(eq("script"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty(eq("bundle.enabled"));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)} with {@code attributes}, {@code context}, {@code model}.
   * <ul>
   *   <li>Given {@code ;}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddElementToModelWithAttributesContextModel_givenSemicolon() {
    // Arrange
    ResourceTagAttributes attributes = new ResourceTagAttributes();
    attributes.src(";");
    attributes.defer(false);
    attributes.includeAsyncDeferUnbundled(false);
    attributes.async(false);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> resourceBundleProcessor.addElementToModel(attributes,
        mock(BroadleafTemplateContext.class), mock(BroadleafTemplateModel.class)));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)} with {@code attributes}, {@code context}, {@code model}.
   * <ul>
   *   <li>Given {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddElementToModelWithAttributesContextModel_givenTrue() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ResourceTagAttributes attributes = new ResourceTagAttributes();
    attributes.src(".js");
    attributes.defer(false);
    attributes.includeAsyncDeferUnbundled(true);
    attributes.async(false);
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateNonVoidElement.class));
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addElementToModel(attributes, context, model);

    // Assert
    verify(context).createNonVoidElement(eq("script"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty(eq("bundle.enabled"));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)} with {@code src}, {@code async}, {@code defer}, {@code context}, {@code model}.
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddElementToModelWithSrcAsyncDeferContextModel() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateNonVoidElement.class));
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doThrow(new IllegalArgumentException(";")).when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> resourceBundleProcessor.addElementToModel(".js", true, true, context, model));
    verify(context).createNonVoidElement(eq("script"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty(eq("bundle.enabled"));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)} with {@code src}, {@code async}, {@code defer}, {@code context}, {@code model}.
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddElementToModelWithSrcAsyncDeferContextModel2() {
    // Arrange
    BroadleafTemplateNonVoidElement broadleafTemplateNonVoidElement = mock(BroadleafTemplateNonVoidElement.class);
    doNothing().when(broadleafTemplateNonVoidElement).addChild(Mockito.<BroadleafTemplateElement>any());
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createNonVoidElement(Mockito.<String>any())).thenReturn(broadleafTemplateNonVoidElement);
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addElementToModel(".css", true, true, context, model);

    // Assert
    verify(context).createNonVoidElement(eq("noscript"));
    verify(context, atLeast(1)).createStandaloneElement(eq("link"), Mockito.<Map<String, String>>any(), eq(true));
    verify(model, atLeast(1)).addElement(Mockito.<BroadleafTemplateElement>any());
    verify(broadleafTemplateNonVoidElement).addChild(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)} with {@code src}, {@code async}, {@code defer}, {@code context}, {@code model}.
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddElementToModelWithSrcAsyncDeferContextModel3() {
    // Arrange
    BroadleafTemplateNonVoidElement broadleafTemplateNonVoidElement = mock(BroadleafTemplateNonVoidElement.class);
    doThrow(new IllegalArgumentException(";")).when(broadleafTemplateNonVoidElement)
        .addChild(Mockito.<BroadleafTemplateElement>any());
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createNonVoidElement(Mockito.<String>any())).thenReturn(broadleafTemplateNonVoidElement);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> resourceBundleProcessor.addElementToModel(".css", true, true,
        context, mock(BroadleafTemplateModel.class)));
    verify(context).createNonVoidElement(eq("noscript"));
    verify(context, atLeast(1)).createStandaloneElement(eq("link"), Mockito.<Map<String, String>>any(), eq(true));
    verify(broadleafTemplateNonVoidElement).addChild(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)} with {@code src}, {@code async}, {@code defer}, {@code context}, {@code model}.
   * <ul>
   *   <li>Then calls {@link BroadleafTemplateContext#createNonVoidElement(String, Map, boolean)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddElementToModelWithSrcAsyncDeferContextModel_thenCallsCreateNonVoidElement() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateNonVoidElement.class));
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addElementToModel(".js", true, true, context, model);

    // Assert
    verify(context).createNonVoidElement(eq("script"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty(eq("bundle.enabled"));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)} with {@code src}, {@code async}, {@code defer}, {@code context}, {@code model}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddElementToModelWithSrcAsyncDeferContextModel_whenFalse() {
    // Arrange
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addElementToModel(".css", true, false, context, model);

    // Assert
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)} with {@code src}, {@code async}, {@code defer}, {@code context}, {@code model}.
   * <ul>
   *   <li>When {@code ;}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddElementToModelWithSrcAsyncDeferContextModel_whenSemicolon() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> resourceBundleProcessor.addElementToModel(";", true, true,
        mock(BroadleafTemplateContext.class), mock(BroadleafTemplateModel.class)));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)} with {@code src}, {@code async}, {@code defer}, {@code context}, {@code model}.
   * <ul>
   *   <li>When {@code Src}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddElementToModelWithSrcAsyncDeferContextModel_whenSrc() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> resourceBundleProcessor.addElementToModel("Src", true, true,
        mock(BroadleafTemplateContext.class), mock(BroadleafTemplateModel.class)));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)} with {@code src}, {@code async}, {@code defer}, {@code dependencyEvent}, {@code context}, {@code model}.
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddElementToModelWithSrcAsyncDeferDependencyEventContextModel() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateNonVoidElement.class));
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addElementToModel(".js", true, true, "Dependency Event", context, model);

    // Assert
    verify(context).createNonVoidElement(eq("script"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty(eq("bundle.enabled"));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)} with {@code src}, {@code async}, {@code defer}, {@code dependencyEvent}, {@code context}, {@code model}.
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddElementToModelWithSrcAsyncDeferDependencyEventContextModel2() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateNonVoidElement.class));
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doThrow(new IllegalArgumentException(";")).when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> resourceBundleProcessor.addElementToModel(".js", true, true, "Dependency Event", context, model));
    verify(context).createNonVoidElement(eq("script"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty(eq("bundle.enabled"));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)} with {@code src}, {@code async}, {@code defer}, {@code dependencyEvent}, {@code context}, {@code model}.
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddElementToModelWithSrcAsyncDeferDependencyEventContextModel3() {
    // Arrange
    BroadleafTemplateNonVoidElement broadleafTemplateNonVoidElement = mock(BroadleafTemplateNonVoidElement.class);
    doNothing().when(broadleafTemplateNonVoidElement).addChild(Mockito.<BroadleafTemplateElement>any());
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createNonVoidElement(Mockito.<String>any())).thenReturn(broadleafTemplateNonVoidElement);
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addElementToModel(".css", true, true, "Dependency Event", context, model);

    // Assert
    verify(context).createNonVoidElement(eq("noscript"));
    verify(context, atLeast(1)).createStandaloneElement(eq("link"), Mockito.<Map<String, String>>any(), eq(true));
    verify(model, atLeast(1)).addElement(Mockito.<BroadleafTemplateElement>any());
    verify(broadleafTemplateNonVoidElement).addChild(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)} with {@code src}, {@code async}, {@code defer}, {@code dependencyEvent}, {@code context}, {@code model}.
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddElementToModelWithSrcAsyncDeferDependencyEventContextModel4() {
    // Arrange
    BroadleafTemplateNonVoidElement broadleafTemplateNonVoidElement = mock(BroadleafTemplateNonVoidElement.class);
    doThrow(new IllegalArgumentException(";")).when(broadleafTemplateNonVoidElement)
        .addChild(Mockito.<BroadleafTemplateElement>any());
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createNonVoidElement(Mockito.<String>any())).thenReturn(broadleafTemplateNonVoidElement);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> resourceBundleProcessor.addElementToModel(".css", true, true,
        "Dependency Event", context, mock(BroadleafTemplateModel.class)));
    verify(context).createNonVoidElement(eq("noscript"));
    verify(context, atLeast(1)).createStandaloneElement(eq("link"), Mockito.<Map<String, String>>any(), eq(true));
    verify(broadleafTemplateNonVoidElement).addChild(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)} with {@code src}, {@code async}, {@code defer}, {@code dependencyEvent}, {@code context}, {@code model}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddElementToModelWithSrcAsyncDeferDependencyEventContextModel_whenFalse() {
    // Arrange
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addElementToModel(".css", true, false, "Dependency Event", context, model);

    // Assert
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)} with {@code src}, {@code async}, {@code defer}, {@code dependencyEvent}, {@code context}, {@code model}.
   * <ul>
   *   <li>When {@code ;}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddElementToModelWithSrcAsyncDeferDependencyEventContextModel_whenSemicolon() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> resourceBundleProcessor.addElementToModel(";", true, true,
        "Dependency Event", mock(BroadleafTemplateContext.class), mock(BroadleafTemplateModel.class)));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)} with {@code src}, {@code async}, {@code defer}, {@code dependencyEvent}, {@code context}, {@code model}.
   * <ul>
   *   <li>When {@code Src}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddElementToModelWithSrcAsyncDeferDependencyEventContextModel_whenSrc() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> resourceBundleProcessor.addElementToModel("Src", true, true,
        "Dependency Event", mock(BroadleafTemplateContext.class), mock(BroadleafTemplateModel.class)));
  }

  /**
   * Test {@link ResourceBundleProcessor#addJavaScriptToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link ResourceTagAttributes} {@link ResourceTagAttributes#async()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addJavaScriptToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addJavaScriptToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddJavaScriptToModel_givenFalse_whenResourceTagAttributesAsyncReturnFalse() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.async()).thenReturn(false);
    when(attributes.defer()).thenReturn(true);
    when(attributes.includeAsyncDeferUnbundled()).thenReturn(true);
    when(attributes.src()).thenReturn("Src");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateNonVoidElement.class));
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addJavaScriptToModel(attributes, context, model);

    // Assert
    verify(attributes).async();
    verify(attributes).defer();
    verify(attributes).includeAsyncDeferUnbundled();
    verify(attributes).src();
    verify(context).createNonVoidElement(eq("script"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty(eq("bundle.enabled"));
  }

  /**
   * Test {@link ResourceBundleProcessor#addJavaScriptToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link ResourceTagAttributes} {@link ResourceTagAttributes#defer()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addJavaScriptToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addJavaScriptToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddJavaScriptToModel_givenFalse_whenResourceTagAttributesDeferReturnFalse() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.async()).thenReturn(true);
    when(attributes.defer()).thenReturn(false);
    when(attributes.includeAsyncDeferUnbundled()).thenReturn(true);
    when(attributes.src()).thenReturn("Src");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateNonVoidElement.class));
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addJavaScriptToModel(attributes, context, model);

    // Assert
    verify(attributes).async();
    verify(attributes).defer();
    verify(attributes).includeAsyncDeferUnbundled();
    verify(attributes).src();
    verify(context).createNonVoidElement(eq("script"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty(eq("bundle.enabled"));
  }

  /**
   * Test {@link ResourceBundleProcessor#addJavaScriptToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addJavaScriptToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addJavaScriptToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddJavaScriptToModel_thenThrowIllegalArgumentException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ResourceTagAttributes attributes = new ResourceTagAttributes();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateNonVoidElement.class));
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doThrow(new IllegalArgumentException("script")).when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> resourceBundleProcessor.addJavaScriptToModel(attributes, context, model));
    verify(context).createNonVoidElement(eq("script"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty(eq("bundle.enabled"));
  }

  /**
   * Test {@link ResourceBundleProcessor#addJavaScriptToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   * <ul>
   *   <li>When {@link ResourceTagAttributes} {@link ResourceTagAttributes#async()} return {@code true}.</li>
   *   <li>Then calls {@link ResourceTagAttributes#defer()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addJavaScriptToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addJavaScriptToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddJavaScriptToModel_whenResourceTagAttributesAsyncReturnTrue_thenCallsDefer() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.async()).thenReturn(true);
    when(attributes.defer()).thenReturn(true);
    when(attributes.includeAsyncDeferUnbundled()).thenReturn(true);
    when(attributes.src()).thenReturn("Src");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateNonVoidElement.class));
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addJavaScriptToModel(attributes, context, model);

    // Assert
    verify(attributes).async();
    verify(attributes).defer();
    verify(attributes).includeAsyncDeferUnbundled();
    verify(attributes).src();
    verify(context).createNonVoidElement(eq("script"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty(eq("bundle.enabled"));
  }

  /**
   * Test {@link ResourceBundleProcessor#addJavaScriptToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   * <ul>
   *   <li>When {@link ResourceTagAttributes#ResourceTagAttributes()}.</li>
   *   <li>Then calls {@link BroadleafTemplateContext#createNonVoidElement(String, Map, boolean)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addJavaScriptToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addJavaScriptToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddJavaScriptToModel_whenResourceTagAttributes_thenCallsCreateNonVoidElement() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ResourceTagAttributes attributes = new ResourceTagAttributes();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateNonVoidElement.class));
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addJavaScriptToModel(attributes, context, model);

    // Assert
    verify(context).createNonVoidElement(eq("script"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty(eq("bundle.enabled"));
  }

  /**
   * Test {@link ResourceBundleProcessor#addCssToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addCssToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addCssToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddCssToModel() {
    // Arrange
    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.defer()).thenReturn(true);
    when(attributes.src()).thenReturn("Src");
    BroadleafTemplateNonVoidElement broadleafTemplateNonVoidElement = mock(BroadleafTemplateNonVoidElement.class);
    doThrow(new IllegalArgumentException("href")).when(broadleafTemplateNonVoidElement)
        .addChild(Mockito.<BroadleafTemplateElement>any());
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(Mockito.<String>any())).thenReturn(broadleafTemplateNonVoidElement);
    when(context.createStandaloneElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> resourceBundleProcessor.addCssToModel(attributes, context, mock(BroadleafTemplateModel.class)));
    verify(attributes).defer();
    verify(attributes, atLeast(1)).src();
    verify(context).createNonVoidElement(eq("noscript"));
    verify(context, atLeast(1)).createStandaloneElement(eq("link"), Mockito.<Map<String, String>>any(), eq(true));
    verify(broadleafTemplateNonVoidElement).addChild(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#addCssToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   * <ul>
   *   <li>Given {@link BroadleafTemplateNonVoidElement} {@link BroadleafTemplateNonVoidElement#addChild(BroadleafTemplateElement)} does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addCssToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addCssToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddCssToModel_givenBroadleafTemplateNonVoidElementAddChildDoesNothing() {
    // Arrange
    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.defer()).thenReturn(true);
    when(attributes.src()).thenReturn("Src");
    BroadleafTemplateNonVoidElement broadleafTemplateNonVoidElement = mock(BroadleafTemplateNonVoidElement.class);
    doNothing().when(broadleafTemplateNonVoidElement).addChild(Mockito.<BroadleafTemplateElement>any());
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(Mockito.<String>any())).thenReturn(broadleafTemplateNonVoidElement);
    when(context.createStandaloneElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addCssToModel(attributes, context, model);

    // Assert
    verify(attributes).defer();
    verify(attributes, atLeast(1)).src();
    verify(context).createNonVoidElement(eq("noscript"));
    verify(context, atLeast(1)).createStandaloneElement(eq("link"), Mockito.<Map<String, String>>any(), eq(true));
    verify(model, atLeast(1)).addElement(Mockito.<BroadleafTemplateElement>any());
    verify(broadleafTemplateNonVoidElement).addChild(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#addCssToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)} with {@code link}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addCssToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addCssToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddCssToModel_givenIllegalArgumentExceptionWithLink() {
    // Arrange
    ResourceTagAttributes attributes = new ResourceTagAttributes();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doThrow(new IllegalArgumentException("link")).when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> resourceBundleProcessor.addCssToModel(attributes, context, model));
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#addCssToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   * <ul>
   *   <li>When {@link ResourceTagAttributes#ResourceTagAttributes()}.</li>
   *   <li>Then calls {@link BroadleafTemplateModel#addElement(BroadleafTemplateElement)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addCssToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addCssToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddCssToModel_whenResourceTagAttributes_thenCallsAddElement() {
    // Arrange
    ResourceTagAttributes attributes = new ResourceTagAttributes();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addCssToModel(attributes, context, model);

    // Assert
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#getDeferredCssElements(ResourceTagAttributes, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@code Src}.</li>
   *   <li>Then calls {@link ResourceTagAttributes#src()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#getDeferredCssElements(ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List ResourceBundleProcessor.getDeferredCssElements(ResourceTagAttributes, BroadleafTemplateContext)"})
  public void testGetDeferredCssElements_givenSrc_thenCallsSrc() {
    // Arrange
    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.src()).thenReturn("Src");
    BroadleafTemplateNonVoidElement broadleafTemplateNonVoidElement = mock(BroadleafTemplateNonVoidElement.class);
    doNothing().when(broadleafTemplateNonVoidElement).addChild(Mockito.<BroadleafTemplateElement>any());
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createNonVoidElement(Mockito.<String>any())).thenReturn(broadleafTemplateNonVoidElement);

    // Act
    List<BroadleafTemplateElement> actualDeferredCssElements = resourceBundleProcessor
        .getDeferredCssElements(attributes, context);

    // Assert
    verify(attributes, atLeast(1)).src();
    verify(context).createNonVoidElement(eq("noscript"));
    verify(context, atLeast(1)).createStandaloneElement(eq("link"), Mockito.<Map<String, String>>any(), eq(true));
    verify(broadleafTemplateNonVoidElement).addChild(isA(BroadleafTemplateElement.class));
    assertEquals(2, actualDeferredCssElements.size());
  }

  /**
   * Test {@link ResourceBundleProcessor#getDeferredCssElements(ResourceTagAttributes, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#getDeferredCssElements(ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List ResourceBundleProcessor.getDeferredCssElements(ResourceTagAttributes, BroadleafTemplateContext)"})
  public void testGetDeferredCssElements_thenThrowIllegalArgumentException() {
    // Arrange
    ResourceTagAttributes attributes = new ResourceTagAttributes();
    BroadleafTemplateNonVoidElement broadleafTemplateNonVoidElement = mock(BroadleafTemplateNonVoidElement.class);
    doThrow(new IllegalArgumentException("href")).when(broadleafTemplateNonVoidElement)
        .addChild(Mockito.<BroadleafTemplateElement>any());
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createNonVoidElement(Mockito.<String>any())).thenReturn(broadleafTemplateNonVoidElement);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> resourceBundleProcessor.getDeferredCssElements(attributes, context));
    verify(context).createNonVoidElement(eq("noscript"));
    verify(context, atLeast(1)).createStandaloneElement(eq("link"), Mockito.<Map<String, String>>any(), eq(true));
    verify(broadleafTemplateNonVoidElement).addChild(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#getDeferredCssElements(ResourceTagAttributes, BroadleafTemplateContext)}.
   * <ul>
   *   <li>When {@link ResourceTagAttributes#ResourceTagAttributes()}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#getDeferredCssElements(ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List ResourceBundleProcessor.getDeferredCssElements(ResourceTagAttributes, BroadleafTemplateContext)"})
  public void testGetDeferredCssElements_whenResourceTagAttributes_thenReturnSizeIsTwo() {
    // Arrange
    ResourceTagAttributes attributes = new ResourceTagAttributes();
    BroadleafTemplateNonVoidElement broadleafTemplateNonVoidElement = mock(BroadleafTemplateNonVoidElement.class);
    doNothing().when(broadleafTemplateNonVoidElement).addChild(Mockito.<BroadleafTemplateElement>any());
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createNonVoidElement(Mockito.<String>any())).thenReturn(broadleafTemplateNonVoidElement);

    // Act
    List<BroadleafTemplateElement> actualDeferredCssElements = resourceBundleProcessor
        .getDeferredCssElements(attributes, context);

    // Assert
    verify(context).createNonVoidElement(eq("noscript"));
    verify(context, atLeast(1)).createStandaloneElement(eq("link"), Mockito.<Map<String, String>>any(), eq(true));
    verify(broadleafTemplateNonVoidElement).addChild(isA(BroadleafTemplateElement.class));
    assertEquals(2, actualDeferredCssElements.size());
  }

  /**
   * Test {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddDependencyRestrictionToModel() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ArrayList<String> files = new ArrayList<>();
    files.add("Files");

    ResourceTagAttributes attributes = new ResourceTagAttributes();
    attributes.name("if (idx === arr.length - 1) {    script.addEventListener('load', function () {        ");
    attributes.async(false);
    attributes.includeAsyncDeferUnbundled(false);
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any())).thenReturn(mock(BroadleafTemplateElement.class));
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addDependencyRestrictionToModel(files, attributes, context, model);

    // Assert
    verify(context).createTextElement(eq(
        "<script>function runOnReady(callback, event) {    var watchEvent = typeof(event) == 'undefined' ? 'DOMContentLoaded' : event;    if (document.readyState != 'loading' && !event) {        callback();    } else {        document.addEventListener(watchEvent, callback);    }}; if (typeof(nullEvent) !== 'undefined') {    runOnReady(handleif (idx === arr_length _ 1) {    script_addEventListener('load', function () {        );} else {    runOnReady(function() {            runOnReady(handleif (idx === arr_length _ 1) {    script_addEventListener('load', function () {        );        },        'null');} function handleif (idx === arr_length _ 1) {    script_addEventListener('load', function () {        () {    var lastScript = null;    ['Files'].forEach(function (elem, idx, arr) {        var script = document.createElement('script');        script.type = 'text/javascript';        script.src = elem;        script.async = false;        document.body.appendChild(script);if (idx === arr.length - 1) {    script.addEventListener('load', function () {        null;    });}    });};</script>"));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty(eq("bundle.enabled"));
  }

  /**
   * Test {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   * <ul>
   *   <li>Given a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddDependencyRestrictionToModel_givenAString() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ArrayList<String> files = new ArrayList<>();
    files.add("Files");

    ResourceTagAttributes attributes = new ResourceTagAttributes();
    attributes.name("<script>function runOnReady(callback, event) {    var watchEvent = typeof(event) == 'undefined' ?"
        + " 'DOMContentLoaded' : event;    if (document.readyState != 'loading' && !event) {        callback();"
        + "    } else {        document.addEventListener(watchEvent, callback);    }}; if (typeof(");
    attributes.async(false);
    attributes.includeAsyncDeferUnbundled(false);
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any())).thenReturn(mock(BroadleafTemplateElement.class));
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addDependencyRestrictionToModel(files, attributes, context, model);

    // Assert
    verify(context).createTextElement(eq(
        "<script>function runOnReady(callback, event) {    var watchEvent = typeof(event) == 'undefined' ? 'DOMContentLoaded' : event;    if (document.readyState != 'loading' && !event) {        callback();    } else {        document.addEventListener(watchEvent, callback);    }}; if (typeof(nullEvent) !== 'undefined') {    runOnReady(handle<script>function runOnReady(callback, event) {    var watchEvent = typeof(event) == 'undefined' ? 'DOMContentLoaded' : event;    if (document_readyState != 'loading' && !event) {        callback();    } else {        document_addEventListener(watchEvent, callback);    }}; if (typeof();} else {    runOnReady(function() {            runOnReady(handle<script>function runOnReady(callback, event) {    var watchEvent = typeof(event) == 'undefined' ? 'DOMContentLoaded' : event;    if (document_readyState != 'loading' && !event) {        callback();    } else {        document_addEventListener(watchEvent, callback);    }}; if (typeof();        },        'null');} function handle<script>function runOnReady(callback, event) {    var watchEvent = typeof(event) == 'undefined' ? 'DOMContentLoaded' : event;    if (document_readyState != 'loading' && !event) {        callback();    } else {        document_addEventListener(watchEvent, callback);    }}; if (typeof(() {    var lastScript = null;    ['Files'].forEach(function (elem, idx, arr) {        var script = document.createElement('script');        script.type = 'text/javascript';        script.src = elem;        script.async = false;        document.body.appendChild(script);if (idx === arr.length - 1) {    script.addEventListener('load', function () {        null;    });}    });};</script>"));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty(eq("bundle.enabled"));
  }

  /**
   * Test {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   * <ul>
   *   <li>Given {@code \.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddDependencyRestrictionToModel_givenBackslashDot() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ArrayList<String> files = new ArrayList<>();
    files.add("Files");

    ResourceTagAttributes attributes = new ResourceTagAttributes();
    attributes.name("\\.");
    attributes.async(false);
    attributes.includeAsyncDeferUnbundled(false);
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any())).thenReturn(mock(BroadleafTemplateElement.class));
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addDependencyRestrictionToModel(files, attributes, context, model);

    // Assert
    verify(context).createTextElement(eq(
        "<script>function runOnReady(callback, event) {    var watchEvent = typeof(event) == 'undefined' ? 'DOMContentLoaded' : event;    if (document.readyState != 'loading' && !event) {        callback();    } else {        document.addEventListener(watchEvent, callback);    }}; if (typeof(nullEvent) !== 'undefined') {    runOnReady(handle\\_);} else {    runOnReady(function() {            runOnReady(handle\\_);        },        'null');} function handle\\_() {    var lastScript = null;    ['Files'].forEach(function (elem, idx, arr) {        var script = document.createElement('script');        script.type = 'text/javascript';        script.src = elem;        script.async = false;        document.body.appendChild(script);if (idx === arr.length - 1) {    script.addEventListener('load', function () {        null;    });}    });};</script>"));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty(eq("bundle.enabled"));
  }

  /**
   * Test {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   * <ul>
   *   <li>Given {@code bundle.enabled}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddDependencyRestrictionToModel_givenBundleEnabled() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ArrayList<String> files = new ArrayList<>();
    files.add("Files");

    ResourceTagAttributes attributes = new ResourceTagAttributes();
    attributes.name("bundle.enabled");
    attributes.async(false);
    attributes.includeAsyncDeferUnbundled(false);
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any())).thenReturn(mock(BroadleafTemplateElement.class));
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addDependencyRestrictionToModel(files, attributes, context, model);

    // Assert
    verify(context).createTextElement(eq(
        "<script>function runOnReady(callback, event) {    var watchEvent = typeof(event) == 'undefined' ? 'DOMContentLoaded' : event;    if (document.readyState != 'loading' && !event) {        callback();    } else {        document.addEventListener(watchEvent, callback);    }}; if (typeof(nullEvent) !== 'undefined') {    runOnReady(handlebundle_enabled);} else {    runOnReady(function() {            runOnReady(handlebundle_enabled);        },        'null');} function handlebundle_enabled() {    var lastScript = null;    ['Files'].forEach(function (elem, idx, arr) {        var script = document.createElement('script');        script.type = 'text/javascript';        script.src = elem;        script.async = false;        document.body.appendChild(script);if (idx === arr.length - 1) {    script.addEventListener('load', function () {        null;    });}    });};</script>"));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty(eq("bundle.enabled"));
  }

  /**
   * Test {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   * <ul>
   *   <li>Given {@code --}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddDependencyRestrictionToModel_givenDashDash() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ArrayList<String> files = new ArrayList<>();
    files.add("Files");

    ResourceTagAttributes attributes = new ResourceTagAttributes();
    attributes.name("--");
    attributes.async(false);
    attributes.includeAsyncDeferUnbundled(false);
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any())).thenReturn(mock(BroadleafTemplateElement.class));
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addDependencyRestrictionToModel(files, attributes, context, model);

    // Assert
    verify(context).createTextElement(eq(
        "<script>function runOnReady(callback, event) {    var watchEvent = typeof(event) == 'undefined' ? 'DOMContentLoaded' : event;    if (document.readyState != 'loading' && !event) {        callback();    } else {        document.addEventListener(watchEvent, callback);    }}; if (typeof(nullEvent) !== 'undefined') {    runOnReady(handle__);} else {    runOnReady(function() {            runOnReady(handle__);        },        'null');} function handle__() {    var lastScript = null;    ['Files'].forEach(function (elem, idx, arr) {        var script = document.createElement('script');        script.type = 'text/javascript';        script.src = elem;        script.async = false;        document.body.appendChild(script);if (idx === arr.length - 1) {    script.addEventListener('load', function () {        null;    });}    });};</script>"));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty(eq("bundle.enabled"));
  }

  /**
   * Test {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   * <ul>
   *   <li>Given {@code -.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddDependencyRestrictionToModel_givenDashDot() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ArrayList<String> files = new ArrayList<>();
    files.add("Files");

    ResourceTagAttributes attributes = new ResourceTagAttributes();
    attributes.name("-.");
    attributes.async(false);
    attributes.includeAsyncDeferUnbundled(false);
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any())).thenReturn(mock(BroadleafTemplateElement.class));
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addDependencyRestrictionToModel(files, attributes, context, model);

    // Assert
    verify(context).createTextElement(eq(
        "<script>function runOnReady(callback, event) {    var watchEvent = typeof(event) == 'undefined' ? 'DOMContentLoaded' : event;    if (document.readyState != 'loading' && !event) {        callback();    } else {        document.addEventListener(watchEvent, callback);    }}; if (typeof(nullEvent) !== 'undefined') {    runOnReady(handle__);} else {    runOnReady(function() {            runOnReady(handle__);        },        'null');} function handle__() {    var lastScript = null;    ['Files'].forEach(function (elem, idx, arr) {        var script = document.createElement('script');        script.type = 'text/javascript';        script.src = elem;        script.async = false;        document.body.appendChild(script);if (idx === arr.length - 1) {    script.addEventListener('load', function () {        null;    });}    });};</script>"));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty(eq("bundle.enabled"));
  }

  /**
   * Test {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   * <ul>
   *   <li>Given {@code -}.</li>
   *   <li>When {@link ResourceTagAttributes#ResourceTagAttributes()} name {@code -}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddDependencyRestrictionToModel_givenDash_whenResourceTagAttributesNameDash() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ArrayList<String> files = new ArrayList<>();
    files.add("Files");

    ResourceTagAttributes attributes = new ResourceTagAttributes();
    attributes.name("-");
    attributes.async(false);
    attributes.includeAsyncDeferUnbundled(false);
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any())).thenReturn(mock(BroadleafTemplateElement.class));
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addDependencyRestrictionToModel(files, attributes, context, model);

    // Assert
    verify(context).createTextElement(eq(
        "<script>function runOnReady(callback, event) {    var watchEvent = typeof(event) == 'undefined' ? 'DOMContentLoaded' : event;    if (document.readyState != 'loading' && !event) {        callback();    } else {        document.addEventListener(watchEvent, callback);    }}; if (typeof(nullEvent) !== 'undefined') {    runOnReady(handle_);} else {    runOnReady(function() {            runOnReady(handle_);        },        'null');} function handle_() {    var lastScript = null;    ['Files'].forEach(function (elem, idx, arr) {        var script = document.createElement('script');        script.type = 'text/javascript';        script.src = elem;        script.async = false;        document.body.appendChild(script);if (idx === arr.length - 1) {    script.addEventListener('load', function () {        null;    });}    });};</script>"));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty(eq("bundle.enabled"));
  }

  /**
   * Test {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   * <ul>
   *   <li>Given {@code .}.</li>
   *   <li>When {@link ResourceTagAttributes#ResourceTagAttributes()} name {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddDependencyRestrictionToModel_givenDot_whenResourceTagAttributesNameDot() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ArrayList<String> files = new ArrayList<>();
    files.add("Files");

    ResourceTagAttributes attributes = new ResourceTagAttributes();
    attributes.name(".");
    attributes.async(false);
    attributes.includeAsyncDeferUnbundled(false);
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any())).thenReturn(mock(BroadleafTemplateElement.class));
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addDependencyRestrictionToModel(files, attributes, context, model);

    // Assert
    verify(context).createTextElement(eq(
        "<script>function runOnReady(callback, event) {    var watchEvent = typeof(event) == 'undefined' ? 'DOMContentLoaded' : event;    if (document.readyState != 'loading' && !event) {        callback();    } else {        document.addEventListener(watchEvent, callback);    }}; if (typeof(nullEvent) !== 'undefined') {    runOnReady(handle_);} else {    runOnReady(function() {            runOnReady(handle_);        },        'null');} function handle_() {    var lastScript = null;    ['Files'].forEach(function (elem, idx, arr) {        var script = document.createElement('script');        script.type = 'text/javascript';        script.src = elem;        script.async = false;        document.body.appendChild(script);if (idx === arr.length - 1) {    script.addEventListener('load', function () {        null;    });}    });};</script>"));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty(eq("bundle.enabled"));
  }

  /**
   * Test {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   * <ul>
   *   <li>Given {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddDependencyRestrictionToModel_givenSlash() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ArrayList<String> files = new ArrayList<>();
    files.add("Files");

    ResourceTagAttributes attributes = new ResourceTagAttributes();
    attributes.name("/");
    attributes.async(false);
    attributes.includeAsyncDeferUnbundled(false);
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any())).thenReturn(mock(BroadleafTemplateElement.class));
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addDependencyRestrictionToModel(files, attributes, context, model);

    // Assert
    verify(context).createTextElement(eq(
        "<script>function runOnReady(callback, event) {    var watchEvent = typeof(event) == 'undefined' ? 'DOMContentLoaded' : event;    if (document.readyState != 'loading' && !event) {        callback();    } else {        document.addEventListener(watchEvent, callback);    }}; if (typeof(nullEvent) !== 'undefined') {    runOnReady(handle);} else {    runOnReady(function() {            runOnReady(handle);        },        'null');} function handle() {    var lastScript = null;    ['Files'].forEach(function (elem, idx, arr) {        var script = document.createElement('script');        script.type = 'text/javascript';        script.src = elem;        script.async = false;        document.body.appendChild(script);if (idx === arr.length - 1) {    script.addEventListener('load', function () {        null;    });}    });};</script>"));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty(eq("bundle.enabled"));
  }

  /**
   * Test {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link ResourceTagAttributes#ResourceTagAttributes()} async {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddDependencyRestrictionToModel_givenTrue_whenResourceTagAttributesAsyncTrue() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ArrayList<String> files = new ArrayList<>();
    files.add("Files");

    ResourceTagAttributes attributes = new ResourceTagAttributes();
    attributes.name("/");
    attributes.async(true);
    attributes.includeAsyncDeferUnbundled(false);
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any())).thenReturn(mock(BroadleafTemplateElement.class));
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addDependencyRestrictionToModel(files, attributes, context, model);

    // Assert
    verify(context).createTextElement(eq(
        "<script>function runOnReady(callback, event) {    var watchEvent = typeof(event) == 'undefined' ? 'DOMContentLoaded' : event;    if (document.readyState != 'loading' && !event) {        callback();    } else {        document.addEventListener(watchEvent, callback);    }}; if (typeof(nullEvent) !== 'undefined') {    runOnReady(handle);} else {    runOnReady(function() {            runOnReady(handle);        },        'null');} function handle() {    var lastScript = null;    ['Files'].forEach(function (elem, idx, arr) {        var script = document.createElement('script');        script.type = 'text/javascript';        script.src = elem;        script.async = false;        document.body.appendChild(script);if (idx === arr.length - 1) {    script.addEventListener('load', function () {        null;    });}    });};</script>"));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment, atLeast(1)).getProperty(eq("bundle.enabled"));
  }

  /**
   * Test {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ResourceBundleProcessor.addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"})
  public void testAddDependencyRestrictionToModel_thenThrowIllegalArgumentException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ArrayList<String> files = new ArrayList<>();
    files.add("Files");

    ResourceTagAttributes attributes = new ResourceTagAttributes();
    attributes.name("/");
    attributes.async(false);
    attributes.includeAsyncDeferUnbundled(false);
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any())).thenReturn(mock(BroadleafTemplateElement.class));
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doThrow(new IllegalArgumentException("-")).when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> resourceBundleProcessor.addDependencyRestrictionToModel(files, attributes, context, model));
    verify(context).createTextElement(eq(
        "<script>function runOnReady(callback, event) {    var watchEvent = typeof(event) == 'undefined' ? 'DOMContentLoaded' : event;    if (document.readyState != 'loading' && !event) {        callback();    } else {        document.addEventListener(watchEvent, callback);    }}; if (typeof(nullEvent) !== 'undefined') {    runOnReady(handle);} else {    runOnReady(function() {            runOnReady(handle);        },        'null');} function handle() {    var lastScript = null;    ['Files'].forEach(function (elem, idx, arr) {        var script = document.createElement('script');        script.type = 'text/javascript';        script.src = elem;        script.async = false;        document.body.appendChild(script);if (idx === arr.length - 1) {    script.addEventListener('load', function () {        null;    });}    });};</script>"));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty(eq("bundle.enabled"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>Then return {@code \_'}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_thenReturnBackslashUnderscoreApostrophe() {
    // Arrange, Act and Assert
    assertEquals("\\_'", resourceBundleProcessor.cleanUpJavaScriptName("\\.'"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>Then return {@code \_\_}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_thenReturnBackslashUnderscoreBackslashUnderscore() {
    // Arrange, Act and Assert
    assertEquals("\\_\\_", resourceBundleProcessor.cleanUpJavaScriptName("\\.\\."));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>Then return {@code \_;}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_thenReturnBackslashUnderscoreSemicolon() {
    // Arrange, Act and Assert
    assertEquals("\\_;", resourceBundleProcessor.cleanUpJavaScriptName("\\.;"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code -42}.</li>
   *   <li>Then return {@code _42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("_42", resourceBundleProcessor.cleanUpJavaScriptName("-42"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code .42}.</li>
   *   <li>Then return {@code _42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_when42_thenReturn422() {
    // Arrange, Act and Assert
    assertEquals("_42", resourceBundleProcessor.cleanUpJavaScriptName(".42"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code \.42}.</li>
   *   <li>Then return {@code \_42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_when42_thenReturn423() {
    // Arrange, Act and Assert
    assertEquals("\\_42", resourceBundleProcessor.cleanUpJavaScriptName("\\.42"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code -async}.</li>
   *   <li>Then return {@code _async}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenAsync_thenReturnAsync() {
    // Arrange, Act and Assert
    assertEquals("_async", resourceBundleProcessor.cleanUpJavaScriptName("-async"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code .async}.</li>
   *   <li>Then return {@code _async}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenAsync_thenReturnAsync2() {
    // Arrange, Act and Assert
    assertEquals("_async", resourceBundleProcessor.cleanUpJavaScriptName(".async"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code \.async}.</li>
   *   <li>Then return {@code \_async}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenAsync_thenReturnAsync3() {
    // Arrange, Act and Assert
    assertEquals("\\_async", resourceBundleProcessor.cleanUpJavaScriptName("\\.async"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code \.-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenBackslashDotDash() {
    // Arrange, Act and Assert
    assertEquals("\\__", resourceBundleProcessor.cleanUpJavaScriptName("\\.-"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code \..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenBackslashDotDot() {
    // Arrange, Act and Assert
    assertEquals("\\__", resourceBundleProcessor.cleanUpJavaScriptName("\\.."));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code \.}.</li>
   *   <li>Then return {@code \_}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenBackslashDot_thenReturnBackslashUnderscore() {
    // Arrange, Act and Assert
    assertEquals("\\_", resourceBundleProcessor.cleanUpJavaScriptName("\\."));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code .css}.</li>
   *   <li>Then return {@code _css}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenCss_thenReturnCss() {
    // Arrange, Act and Assert
    assertEquals("_css", resourceBundleProcessor.cleanUpJavaScriptName(".css"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code -.css}.</li>
   *   <li>Then return {@code __css}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenCss_thenReturnCss2() {
    // Arrange, Act and Assert
    assertEquals("__css", resourceBundleProcessor.cleanUpJavaScriptName("-.css"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code ..css}.</li>
   *   <li>Then return {@code __css}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenCss_thenReturnCss3() {
    // Arrange, Act and Assert
    assertEquals("__css", resourceBundleProcessor.cleanUpJavaScriptName("..css"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code \..css}.</li>
   *   <li>Then return {@code \__css}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenCss_thenReturnCss4() {
    // Arrange, Act and Assert
    assertEquals("\\__css", resourceBundleProcessor.cleanUpJavaScriptName("\\..css"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code -'}.</li>
   *   <li>Then return {@code _'}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenDashApostrophe_thenReturnUnderscoreApostrophe() {
    // Arrange, Act and Assert
    assertEquals("_'", resourceBundleProcessor.cleanUpJavaScriptName("-'"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code -\.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenDashBackslashDot() {
    // Arrange, Act and Assert
    assertEquals("_\\_", resourceBundleProcessor.cleanUpJavaScriptName("-\\."));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code --}.</li>
   *   <li>Then return {@code __}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenDashDash_thenReturnUnderscoreUnderscore() {
    // Arrange, Act and Assert
    assertEquals("__", resourceBundleProcessor.cleanUpJavaScriptName("--"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code -.}.</li>
   *   <li>Then return {@code __}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenDashDot_thenReturnUnderscoreUnderscore() {
    // Arrange, Act and Assert
    assertEquals("__", resourceBundleProcessor.cleanUpJavaScriptName("-."));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code -;}.</li>
   *   <li>Then return {@code _;}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenDashSemicolon_thenReturnUnderscoreSemicolon() {
    // Arrange, Act and Assert
    assertEquals("_;", resourceBundleProcessor.cleanUpJavaScriptName("-;"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code -_}.</li>
   *   <li>Then return {@code __}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenDashUnderscore_thenReturnUnderscoreUnderscore() {
    // Arrange, Act and Assert
    assertEquals("__", resourceBundleProcessor.cleanUpJavaScriptName("-_"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code -}.</li>
   *   <li>Then return {@code _}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenDash_thenReturnUnderscore() {
    // Arrange, Act and Assert
    assertEquals("_", resourceBundleProcessor.cleanUpJavaScriptName("-"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code .'}.</li>
   *   <li>Then return {@code _'}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenDotApostrophe_thenReturnUnderscoreApostrophe() {
    // Arrange, Act and Assert
    assertEquals("_'", resourceBundleProcessor.cleanUpJavaScriptName(".'"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code .\.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenDotBackslashDot() {
    // Arrange, Act and Assert
    assertEquals("_\\_", resourceBundleProcessor.cleanUpJavaScriptName(".\\."));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code .-}.</li>
   *   <li>Then return {@code __}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenDotDash_thenReturnUnderscoreUnderscore() {
    // Arrange, Act and Assert
    assertEquals("__", resourceBundleProcessor.cleanUpJavaScriptName(".-"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code ..}.</li>
   *   <li>Then return {@code __}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenDotDot_thenReturnUnderscoreUnderscore() {
    // Arrange, Act and Assert
    assertEquals("__", resourceBundleProcessor.cleanUpJavaScriptName(".."));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code .;}.</li>
   *   <li>Then return {@code _;}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenDotSemicolon_thenReturnUnderscoreSemicolon() {
    // Arrange, Act and Assert
    assertEquals("_;", resourceBundleProcessor.cleanUpJavaScriptName(".;"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code .}.</li>
   *   <li>Then return {@code _}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenDot_thenReturnUnderscore() {
    // Arrange, Act and Assert
    assertEquals("_", resourceBundleProcessor.cleanUpJavaScriptName("."));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code String}.</li>
   *   <li>Then return {@code java_lang_String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJavaLangString_thenReturnJavaLangString() {
    // Arrange, Act and Assert
    assertEquals("java_lang_String", resourceBundleProcessor.cleanUpJavaScriptName("java.lang.String"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code -String}.</li>
   *   <li>Then return {@code _java_lang_String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJavaLangString_thenReturnJavaLangString2() {
    // Arrange, Act and Assert
    assertEquals("_java_lang_String", resourceBundleProcessor.cleanUpJavaScriptName("-java.lang.String"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code .String}.</li>
   *   <li>Then return {@code _java_lang_String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJavaLangString_thenReturnJavaLangString3() {
    // Arrange, Act and Assert
    assertEquals("_java_lang_String", resourceBundleProcessor.cleanUpJavaScriptName(".java.lang.String"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code \.String}.</li>
   *   <li>Then return {@code \_java_lang_String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJavaLangString_thenReturnJavaLangString4() {
    // Arrange, Act and Assert
    assertEquals("\\_java_lang_String", resourceBundleProcessor.cleanUpJavaScriptName("\\.java.lang.String"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code .js}.</li>
   *   <li>Then return {@code _js}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJs_thenReturnJs() {
    // Arrange, Act and Assert
    assertEquals("_js", resourceBundleProcessor.cleanUpJavaScriptName(".js"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code -.js}.</li>
   *   <li>Then return {@code __js}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJs_thenReturnJs2() {
    // Arrange, Act and Assert
    assertEquals("__js", resourceBundleProcessor.cleanUpJavaScriptName("-.js"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code ..js}.</li>
   *   <li>Then return {@code __js}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJs_thenReturnJs3() {
    // Arrange, Act and Assert
    assertEquals("__js", resourceBundleProcessor.cleanUpJavaScriptName("..js"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code \..js}.</li>
   *   <li>Then return {@code \__js}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJs_thenReturnJs4() {
    // Arrange, Act and Assert
    assertEquals("\\__js", resourceBundleProcessor.cleanUpJavaScriptName("\\..js"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code -link}.</li>
   *   <li>Then return {@code _link}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenLink_thenReturnLink() {
    // Arrange, Act and Assert
    assertEquals("_link", resourceBundleProcessor.cleanUpJavaScriptName("-link"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code .link}.</li>
   *   <li>Then return {@code _link}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenLink_thenReturnLink2() {
    // Arrange, Act and Assert
    assertEquals("_link", resourceBundleProcessor.cleanUpJavaScriptName(".link"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code \.link}.</li>
   *   <li>Then return {@code \_link}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenLink_thenReturnLink3() {
    // Arrange, Act and Assert
    assertEquals("\\_link", resourceBundleProcessor.cleanUpJavaScriptName("\\.link"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code -onload}.</li>
   *   <li>Then return {@code _onload}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenOnload_thenReturnOnload() {
    // Arrange, Act and Assert
    assertEquals("_onload", resourceBundleProcessor.cleanUpJavaScriptName("-onload"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code .onload}.</li>
   *   <li>Then return {@code _onload}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenOnload_thenReturnOnload2() {
    // Arrange, Act and Assert
    assertEquals("_onload", resourceBundleProcessor.cleanUpJavaScriptName(".onload"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code \.onload}.</li>
   *   <li>Then return {@code \_onload}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenOnload_thenReturnOnload3() {
    // Arrange, Act and Assert
    assertEquals("\\_onload", resourceBundleProcessor.cleanUpJavaScriptName("\\.onload"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code Original}.</li>
   *   <li>Then return {@code Original}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenOriginal_thenReturnOriginal() {
    // Arrange, Act and Assert
    assertEquals("Original", resourceBundleProcessor.cleanUpJavaScriptName("Original"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code -Original}.</li>
   *   <li>Then return {@code _Original}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenOriginal_thenReturnOriginal2() {
    // Arrange, Act and Assert
    assertEquals("_Original", resourceBundleProcessor.cleanUpJavaScriptName("-Original"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code .Original}.</li>
   *   <li>Then return {@code _Original}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenOriginal_thenReturnOriginal3() {
    // Arrange, Act and Assert
    assertEquals("_Original", resourceBundleProcessor.cleanUpJavaScriptName(".Original"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code \.Original}.</li>
   *   <li>Then return {@code \_Original}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenOriginal_thenReturnOriginal4() {
    // Arrange, Act and Assert
    assertEquals("\\_Original", resourceBundleProcessor.cleanUpJavaScriptName("\\.Original"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code -rel}.</li>
   *   <li>Then return {@code _rel}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenRel_thenReturnRel() {
    // Arrange, Act and Assert
    assertEquals("_rel", resourceBundleProcessor.cleanUpJavaScriptName("-rel"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code .rel}.</li>
   *   <li>Then return {@code _rel}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenRel_thenReturnRel2() {
    // Arrange, Act and Assert
    assertEquals("_rel", resourceBundleProcessor.cleanUpJavaScriptName(".rel"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code -script}.</li>
   *   <li>Then return {@code _script}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenScript_thenReturnScript() {
    // Arrange, Act and Assert
    assertEquals("_script", resourceBundleProcessor.cleanUpJavaScriptName("-script"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code .script}.</li>
   *   <li>Then return {@code _script}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenScript_thenReturnScript2() {
    // Arrange, Act and Assert
    assertEquals("_script", resourceBundleProcessor.cleanUpJavaScriptName(".script"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenSlash_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", resourceBundleProcessor.cleanUpJavaScriptName("/"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code -src}.</li>
   *   <li>Then return {@code _src}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenSrc_thenReturnSrc() {
    // Arrange, Act and Assert
    assertEquals("_src", resourceBundleProcessor.cleanUpJavaScriptName("-src"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code .src}.</li>
   *   <li>Then return {@code _src}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenSrc_thenReturnSrc2() {
    // Arrange, Act and Assert
    assertEquals("_src", resourceBundleProcessor.cleanUpJavaScriptName(".src"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code -stylesheet}.</li>
   *   <li>Then return {@code _stylesheet}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenStylesheet_thenReturnStylesheet() {
    // Arrange, Act and Assert
    assertEquals("_stylesheet", resourceBundleProcessor.cleanUpJavaScriptName("-stylesheet"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code .stylesheet}.</li>
   *   <li>Then return {@code _stylesheet}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenStylesheet_thenReturnStylesheet2() {
    // Arrange, Act and Assert
    assertEquals("_stylesheet", resourceBundleProcessor.cleanUpJavaScriptName(".stylesheet"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code _-}.</li>
   *   <li>Then return {@code __}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenUnderscoreDash_thenReturnUnderscoreUnderscore() {
    // Arrange, Act and Assert
    assertEquals("__", resourceBundleProcessor.cleanUpJavaScriptName("_-"));
  }

  /**
   * Test {@link ResourceBundleProcessor#getScriptAttributes(String, boolean, boolean)} with {@code src}, {@code async}, {@code defer}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#getScriptAttributes(String, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ResourceBundleProcessor.getScriptAttributes(String, boolean, boolean)"})
  public void testGetScriptAttributesWithSrcAsyncDefer_thenReturnSizeIsTwo() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    // Act
    Map<String, String> actualScriptAttributes = resourceBundleProcessor.getScriptAttributes("Src", true, true);

    // Assert
    verify(environment).getProperty(eq("bundle.enabled"));
    assertEquals(2, actualScriptAttributes.size());
    assertEquals("Src", actualScriptAttributes.get("src"));
    assertEquals("text/javascript", actualScriptAttributes.get("type"));
  }

  /**
   * Test {@link ResourceBundleProcessor#getScriptAttributes(ResourceTagAttributes)} with {@code tagAttributes}.
   * <p>
   * Method under test: {@link ResourceBundleProcessor#getScriptAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ResourceBundleProcessor.getScriptAttributes(ResourceTagAttributes)"})
  public void testGetScriptAttributesWithTagAttributes() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ResourceTagAttributes tagAttributes = mock(ResourceTagAttributes.class);
    when(tagAttributes.async()).thenReturn(false);
    when(tagAttributes.defer()).thenReturn(true);
    when(tagAttributes.includeAsyncDeferUnbundled()).thenReturn(true);
    when(tagAttributes.src()).thenReturn("Src");

    // Act
    Map<String, String> actualScriptAttributes = resourceBundleProcessor.getScriptAttributes(tagAttributes);

    // Assert
    verify(tagAttributes).async();
    verify(tagAttributes).defer();
    verify(tagAttributes).includeAsyncDeferUnbundled();
    verify(tagAttributes).src();
    verify(environment).getProperty(eq("bundle.enabled"));
    assertEquals(3, actualScriptAttributes.size());
    assertEquals("Src", actualScriptAttributes.get("src"));
    assertEquals("text/javascript", actualScriptAttributes.get("type"));
    assertNull(actualScriptAttributes.get("defer"));
  }

  /**
   * Test {@link ResourceBundleProcessor#getScriptAttributes(ResourceTagAttributes)} with {@code tagAttributes}.
   * <p>
   * Method under test: {@link ResourceBundleProcessor#getScriptAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ResourceBundleProcessor.getScriptAttributes(ResourceTagAttributes)"})
  public void testGetScriptAttributesWithTagAttributes2() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ResourceTagAttributes tagAttributes = mock(ResourceTagAttributes.class);
    when(tagAttributes.async()).thenReturn(true);
    when(tagAttributes.defer()).thenReturn(false);
    when(tagAttributes.includeAsyncDeferUnbundled()).thenReturn(true);
    when(tagAttributes.src()).thenReturn("Src");

    // Act
    Map<String, String> actualScriptAttributes = resourceBundleProcessor.getScriptAttributes(tagAttributes);

    // Assert
    verify(tagAttributes).async();
    verify(tagAttributes).defer();
    verify(tagAttributes).includeAsyncDeferUnbundled();
    verify(tagAttributes).src();
    verify(environment).getProperty(eq("bundle.enabled"));
    assertEquals(3, actualScriptAttributes.size());
    assertEquals("Src", actualScriptAttributes.get("src"));
    assertEquals("text/javascript", actualScriptAttributes.get("type"));
    assertNull(actualScriptAttributes.get("async"));
  }

  /**
   * Test {@link ResourceBundleProcessor#getScriptAttributes(ResourceTagAttributes)} with {@code tagAttributes}.
   * <ul>
   *   <li>Then return size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#getScriptAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ResourceBundleProcessor.getScriptAttributes(ResourceTagAttributes)"})
  public void testGetScriptAttributesWithTagAttributes_thenReturnSizeIsFour() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ResourceTagAttributes tagAttributes = mock(ResourceTagAttributes.class);
    when(tagAttributes.async()).thenReturn(true);
    when(tagAttributes.defer()).thenReturn(true);
    when(tagAttributes.includeAsyncDeferUnbundled()).thenReturn(true);
    when(tagAttributes.src()).thenReturn("Src");

    // Act
    Map<String, String> actualScriptAttributes = resourceBundleProcessor.getScriptAttributes(tagAttributes);

    // Assert
    verify(tagAttributes).async();
    verify(tagAttributes).defer();
    verify(tagAttributes).includeAsyncDeferUnbundled();
    verify(tagAttributes).src();
    verify(environment).getProperty(eq("bundle.enabled"));
    assertEquals(4, actualScriptAttributes.size());
    assertEquals("Src", actualScriptAttributes.get("src"));
    assertNull(actualScriptAttributes.get("async"));
    assertNull(actualScriptAttributes.get("defer"));
    assertTrue(actualScriptAttributes.containsKey("type"));
  }

  /**
   * Test {@link ResourceBundleProcessor#getScriptAttributes(ResourceTagAttributes)} with {@code tagAttributes}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#getScriptAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ResourceBundleProcessor.getScriptAttributes(ResourceTagAttributes)"})
  public void testGetScriptAttributesWithTagAttributes_thenReturnSizeIsTwo() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    // Act
    Map<String, String> actualScriptAttributes = resourceBundleProcessor
        .getScriptAttributes(new ResourceTagAttributes());

    // Assert
    verify(environment).getProperty(eq("bundle.enabled"));
    assertEquals(2, actualScriptAttributes.size());
    assertEquals("text/javascript", actualScriptAttributes.get("type"));
    assertNull(actualScriptAttributes.get("src"));
  }

  /**
   * Test {@link ResourceBundleProcessor#getLinkAttributes(String)}.
   * <p>
   * Method under test: {@link ResourceBundleProcessor#getLinkAttributes(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ResourceBundleProcessor.getLinkAttributes(String)"})
  public void testGetLinkAttributes() {
    // Arrange and Act
    Map<String, String> actualLinkAttributes = resourceBundleProcessor.getLinkAttributes("Src");

    // Assert
    assertEquals(2, actualLinkAttributes.size());
    assertEquals("Src", actualLinkAttributes.get("href"));
    assertEquals("stylesheet", actualLinkAttributes.get("rel"));
  }

  /**
   * Test {@link ResourceBundleProcessor#getNormalCssAttributes(ResourceTagAttributes)}.
   * <ul>
   *   <li>Given {@code Src}.</li>
   *   <li>Then return {@code href} is {@code Src}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#getNormalCssAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ResourceBundleProcessor.getNormalCssAttributes(ResourceTagAttributes)"})
  public void testGetNormalCssAttributes_givenSrc_thenReturnHrefIsSrc() {
    // Arrange
    ResourceTagAttributes tagAttributes = mock(ResourceTagAttributes.class);
    when(tagAttributes.src()).thenReturn("Src");

    // Act
    Map<String, String> actualNormalCssAttributes = resourceBundleProcessor.getNormalCssAttributes(tagAttributes);

    // Assert
    verify(tagAttributes).src();
    assertEquals(2, actualNormalCssAttributes.size());
    assertEquals("Src", actualNormalCssAttributes.get("href"));
    assertEquals("stylesheet", actualNormalCssAttributes.get("rel"));
  }

  /**
   * Test {@link ResourceBundleProcessor#getNormalCssAttributes(ResourceTagAttributes)}.
   * <ul>
   *   <li>When {@link ResourceTagAttributes#ResourceTagAttributes()}.</li>
   *   <li>Then return {@code href} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#getNormalCssAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ResourceBundleProcessor.getNormalCssAttributes(ResourceTagAttributes)"})
  public void testGetNormalCssAttributes_whenResourceTagAttributes_thenReturnHrefIsNull() {
    // Arrange and Act
    Map<String, String> actualNormalCssAttributes = resourceBundleProcessor
        .getNormalCssAttributes(new ResourceTagAttributes());

    // Assert
    assertEquals(2, actualNormalCssAttributes.size());
    assertEquals("stylesheet", actualNormalCssAttributes.get("rel"));
    assertNull(actualNormalCssAttributes.get("href"));
  }

  /**
   * Test {@link ResourceBundleProcessor#useAsyncJavaScript(ResourceTagAttributes)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#useAsyncJavaScript(ResourceTagAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ResourceBundleProcessor.useAsyncJavaScript(ResourceTagAttributes)"})
  public void testUseAsyncJavaScript_givenFalse() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.includeAsyncDeferUnbundled()).thenReturn(false);
    when(attributes.async()).thenReturn(true);

    // Act
    boolean actualUseAsyncJavaScriptResult = resourceBundleProcessor.useAsyncJavaScript(attributes);

    // Assert
    verify(attributes).async();
    verify(attributes).includeAsyncDeferUnbundled();
    verify(environment).getProperty(eq("bundle.enabled"));
    assertFalse(actualUseAsyncJavaScriptResult);
  }

  /**
   * Test {@link ResourceBundleProcessor#useAsyncJavaScript(ResourceTagAttributes)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#useAsyncJavaScript(ResourceTagAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ResourceBundleProcessor.useAsyncJavaScript(ResourceTagAttributes)"})
  public void testUseAsyncJavaScript_thenReturnTrue() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.includeAsyncDeferUnbundled()).thenReturn(true);
    when(attributes.async()).thenReturn(true);

    // Act
    boolean actualUseAsyncJavaScriptResult = resourceBundleProcessor.useAsyncJavaScript(attributes);

    // Assert
    verify(attributes).async();
    verify(attributes).includeAsyncDeferUnbundled();
    verify(environment).getProperty(eq("bundle.enabled"));
    assertTrue(actualUseAsyncJavaScriptResult);
  }

  /**
   * Test {@link ResourceBundleProcessor#useAsyncJavaScript(ResourceTagAttributes)}.
   * <ul>
   *   <li>When {@link ResourceTagAttributes#ResourceTagAttributes()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#useAsyncJavaScript(ResourceTagAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ResourceBundleProcessor.useAsyncJavaScript(ResourceTagAttributes)"})
  public void testUseAsyncJavaScript_whenResourceTagAttributes_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(resourceBundleProcessor.useAsyncJavaScript(new ResourceTagAttributes()));
  }

  /**
   * Test {@link ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}.
   * <p>
   * Method under test: {@link ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ResourceBundleProcessor.validateTagAttributes(ResourceTagAttributes)"})
  public void testValidateTagAttributes() {
    // Arrange
    when(resourceBundlingService.getAdditionalBundleFiles(Mockito.<String>any())).thenReturn(new ArrayList<>());
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path"));
    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.bundleCompletedEvent()).thenReturn("Bundle Completed Event");
    when(attributes.bundleDependencyEvent()).thenReturn(null);
    when(attributes.files()).thenReturn("Files");
    when(attributes.mappingPrefix()).thenReturn("Mapping Prefix");
    when(attributes.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(InvalidParameterException.class, () -> resourceBundleProcessor.validateTagAttributes(attributes));
    verify(resourceBundlingService).getAdditionalBundleFiles(eq("Name"));
    verify(attributes).bundleCompletedEvent();
    verify(attributes).bundleDependencyEvent();
    verify(attributes).files();
    verify(attributes).mappingPrefix();
    verify(attributes, atLeast(1)).name();
    verify(resourcesRequest).getBundle(eq("Name"), eq("Mapping Prefix"), isA(List.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}.
   * <p>
   * Method under test: {@link ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ResourceBundleProcessor.validateTagAttributes(ResourceTagAttributes)"})
  public void testValidateTagAttributes2() {
    // Arrange
    when(resourceBundlingService.getAdditionalBundleFiles(Mockito.<String>any())).thenReturn(new ArrayList<>());
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path"));
    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.includeAsyncDeferUnbundled()).thenReturn(true);
    when(attributes.async()).thenReturn(true);
    when(attributes.bundleCompletedEvent()).thenReturn("Bundle Completed Event");
    when(attributes.files()).thenReturn("Files");
    when(attributes.mappingPrefix()).thenReturn("Mapping Prefix");
    when(attributes.name()).thenReturn(".js");

    // Act and Assert
    assertThrows(InvalidParameterException.class, () -> resourceBundleProcessor.validateTagAttributes(attributes));
    verify(resourceBundlingService).getAdditionalBundleFiles(eq(".js"));
    verify(attributes).async();
    verify(attributes).bundleCompletedEvent();
    verify(attributes).files();
    verify(attributes).includeAsyncDeferUnbundled();
    verify(attributes).mappingPrefix();
    verify(attributes, atLeast(1)).name();
    verify(resourcesRequest).getBundle(eq(".js"), eq("Mapping Prefix"), isA(List.class));
    verify(environment, atLeast(1)).getProperty(eq("bundle.enabled"));
  }

  /**
   * Test {@link ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}.
   * <p>
   * Method under test: {@link ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ResourceBundleProcessor.validateTagAttributes(ResourceTagAttributes)"})
  public void testValidateTagAttributes3() {
    // Arrange
    when(resourceBundlingService.getAdditionalBundleFiles(Mockito.<String>any())).thenReturn(new ArrayList<>());
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path"));
    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.includeAsyncDeferUnbundled()).thenReturn(false);
    when(attributes.async()).thenReturn(true);
    when(attributes.bundleCompletedEvent()).thenReturn("Bundle Completed Event");
    when(attributes.files()).thenReturn("Files");
    when(attributes.mappingPrefix()).thenReturn("Mapping Prefix");
    when(attributes.name()).thenReturn(".js");

    // Act
    resourceBundleProcessor.validateTagAttributes(attributes);

    // Assert
    verify(resourceBundlingService).getAdditionalBundleFiles(eq(".js"));
    verify(attributes).async();
    verify(attributes).bundleCompletedEvent();
    verify(attributes).files();
    verify(attributes).includeAsyncDeferUnbundled();
    verify(attributes).mappingPrefix();
    verify(attributes, atLeast(1)).name();
    verify(resourcesRequest).getBundle(eq(".js"), eq("Mapping Prefix"), isA(List.class));
    verify(environment, atLeast(1)).getProperty(eq("bundle.enabled"));
  }

  /**
   * Test {@link ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}.
   * <p>
   * Method under test: {@link ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ResourceBundleProcessor.validateTagAttributes(ResourceTagAttributes)"})
  public void testValidateTagAttributes4() {
    // Arrange
    when(resourceBundlingService.getAdditionalBundleFiles(Mockito.<String>any())).thenReturn(new ArrayList<>());
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path"));
    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.bundleCompletedEvent()).thenReturn(null);
    when(attributes.files()).thenReturn("Files");
    when(attributes.mappingPrefix()).thenReturn("Mapping Prefix");
    when(attributes.name()).thenReturn(".js");

    // Act
    resourceBundleProcessor.validateTagAttributes(attributes);

    // Assert
    verify(resourceBundlingService).getAdditionalBundleFiles(eq(".js"));
    verify(attributes).bundleCompletedEvent();
    verify(attributes).files();
    verify(attributes).mappingPrefix();
    verify(attributes, atLeast(1)).name();
    verify(resourcesRequest).getBundle(eq(".js"), eq("Mapping Prefix"), isA(List.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}.
   * <ul>
   *   <li>Given {@code blResourcesRequest} {@link ResourcesRequest#getBundle(String, String, List)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ResourceBundleProcessor.validateTagAttributes(ResourceTagAttributes)"})
  public void testValidateTagAttributes_givenBlResourcesRequestGetBundleReturnNull() {
    // Arrange
    when(resourceBundlingService.getAdditionalBundleFiles(Mockito.<String>any())).thenReturn(new ArrayList<>());
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(null);
    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.bundleDependencyEvent()).thenReturn("Bundle Dependency Event");
    when(attributes.files()).thenReturn("Files");
    when(attributes.mappingPrefix()).thenReturn("Mapping Prefix");
    when(attributes.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(InvalidParameterException.class, () -> resourceBundleProcessor.validateTagAttributes(attributes));
    verify(resourceBundlingService).getAdditionalBundleFiles(eq("Name"));
    verify(attributes).bundleDependencyEvent();
    verify(attributes, atLeast(1)).files();
    verify(attributes, atLeast(1)).mappingPrefix();
    verify(attributes, atLeast(1)).name();
    verify(resourcesRequest).getBundle(eq("Name"), eq("Mapping Prefix"), isA(List.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}.
   * <ul>
   *   <li>Given {@code ,}.</li>
   *   <li>When {@link ResourceTagAttributes} {@link ResourceTagAttributes#files()} return {@code ,}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ResourceBundleProcessor.validateTagAttributes(ResourceTagAttributes)"})
  public void testValidateTagAttributes_givenComma_whenResourceTagAttributesFilesReturnComma() {
    // Arrange
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path"));
    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.bundleDependencyEvent()).thenReturn("Bundle Dependency Event");
    when(attributes.files()).thenReturn(",");
    when(attributes.mappingPrefix()).thenReturn("Mapping Prefix");
    when(attributes.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(InvalidParameterException.class, () -> resourceBundleProcessor.validateTagAttributes(attributes));
    verify(attributes).bundleDependencyEvent();
    verify(attributes).files();
    verify(attributes).mappingPrefix();
    verify(attributes, atLeast(1)).name();
    verify(resourcesRequest).getBundle(eq("Name"), eq("Mapping Prefix"), isA(List.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link ResourceTagAttributes} {@link ResourceTagAttributes#async()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ResourceBundleProcessor.validateTagAttributes(ResourceTagAttributes)"})
  public void testValidateTagAttributes_givenFalse_whenResourceTagAttributesAsyncReturnFalse() {
    // Arrange
    when(resourceBundlingService.getAdditionalBundleFiles(Mockito.<String>any())).thenReturn(new ArrayList<>());
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path"));
    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.async()).thenReturn(false);
    when(attributes.bundleCompletedEvent()).thenReturn("Bundle Completed Event");
    when(attributes.files()).thenReturn("Files");
    when(attributes.mappingPrefix()).thenReturn("Mapping Prefix");
    when(attributes.name()).thenReturn(".js");

    // Act
    resourceBundleProcessor.validateTagAttributes(attributes);

    // Assert
    verify(resourceBundlingService).getAdditionalBundleFiles(eq(".js"));
    verify(attributes).async();
    verify(attributes).bundleCompletedEvent();
    verify(attributes).files();
    verify(attributes).mappingPrefix();
    verify(attributes, atLeast(1)).name();
    verify(resourcesRequest).getBundle(eq(".js"), eq("Mapping Prefix"), isA(List.class));
    verify(environment).getProperty(eq("bundle.enabled"));
  }

  /**
   * Test {@link ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ResourceTagAttributes} {@link ResourceTagAttributes#files()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ResourceBundleProcessor.validateTagAttributes(ResourceTagAttributes)"})
  public void testValidateTagAttributes_givenNull_whenResourceTagAttributesFilesReturnNull() {
    // Arrange
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path"));
    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.bundleDependencyEvent()).thenReturn("Bundle Dependency Event");
    when(attributes.files()).thenReturn(null);
    when(attributes.mappingPrefix()).thenReturn("Mapping Prefix");
    when(attributes.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(InvalidParameterException.class, () -> resourceBundleProcessor.validateTagAttributes(attributes));
    verify(attributes).bundleDependencyEvent();
    verify(attributes).files();
    verify(attributes).mappingPrefix();
    verify(attributes, atLeast(1)).name();
    verify(resourcesRequest).getBundle(eq("Name"), eq("Mapping Prefix"), isA(List.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}.
   * <ul>
   *   <li>Then calls {@link ResourceTagAttributes#bundleDependencyEvent()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ResourceBundleProcessor.validateTagAttributes(ResourceTagAttributes)"})
  public void testValidateTagAttributes_thenCallsBundleDependencyEvent() {
    // Arrange
    when(resourceBundlingService.getAdditionalBundleFiles(Mockito.<String>any())).thenReturn(new ArrayList<>());
    when(resourcesRequest.getBundle(Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path"));
    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.bundleDependencyEvent()).thenReturn("Bundle Dependency Event");
    when(attributes.files()).thenReturn("Files");
    when(attributes.mappingPrefix()).thenReturn("Mapping Prefix");
    when(attributes.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(InvalidParameterException.class, () -> resourceBundleProcessor.validateTagAttributes(attributes));
    verify(resourceBundlingService).getAdditionalBundleFiles(eq("Name"));
    verify(attributes).bundleDependencyEvent();
    verify(attributes).files();
    verify(attributes).mappingPrefix();
    verify(attributes, atLeast(1)).name();
    verify(resourcesRequest).getBundle(eq("Name"), eq("Mapping Prefix"), isA(List.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#buildUnbundledSyncCompletedEventElement(ResourceTagAttributes, BroadleafTemplateContext)}.
   * <p>
   * Method under test: {@link ResourceBundleProcessor#buildUnbundledSyncCompletedEventElement(ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafTemplateElement ResourceBundleProcessor.buildUnbundledSyncCompletedEventElement(ResourceTagAttributes, BroadleafTemplateContext)"})
  public void testBuildUnbundledSyncCompletedEventElement() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.includeAsyncDeferUnbundled()).thenReturn(true);
    when(attributes.async()).thenReturn(true);

    // Act
    BroadleafTemplateElement actualBuildUnbundledSyncCompletedEventElementResult = resourceBundleProcessor
        .buildUnbundledSyncCompletedEventElement(attributes, mock(BroadleafTemplateContext.class));

    // Assert
    verify(attributes).async();
    verify(attributes).includeAsyncDeferUnbundled();
    verify(environment, atLeast(1)).getProperty(eq("bundle.enabled"));
    assertNull(actualBuildUnbundledSyncCompletedEventElementResult);
  }

  /**
   * Test {@link ResourceBundleProcessor#buildUnbundledSyncCompletedEventElement(ResourceTagAttributes, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then calls {@link ResourceTagAttributes#bundleCompletedEvent()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#buildUnbundledSyncCompletedEventElement(ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafTemplateElement ResourceBundleProcessor.buildUnbundledSyncCompletedEventElement(ResourceTagAttributes, BroadleafTemplateContext)"})
  public void testBuildUnbundledSyncCompletedEventElement_thenCallsBundleCompletedEvent() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.includeAsyncDeferUnbundled()).thenReturn(false);
    when(attributes.async()).thenReturn(true);
    when(attributes.bundleCompletedEvent()).thenReturn("Bundle Completed Event");
    BroadleafTemplateNonVoidElement broadleafTemplateNonVoidElement = mock(BroadleafTemplateNonVoidElement.class);
    doNothing().when(broadleafTemplateNonVoidElement).addChild(Mockito.<BroadleafTemplateElement>any());
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any())).thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createNonVoidElement(Mockito.<String>any())).thenReturn(broadleafTemplateNonVoidElement);

    // Act
    resourceBundleProcessor.buildUnbundledSyncCompletedEventElement(attributes, context);

    // Assert
    verify(attributes).async();
    verify(attributes, atLeast(1)).bundleCompletedEvent();
    verify(attributes).includeAsyncDeferUnbundled();
    verify(context).createNonVoidElement(eq("script"));
    verify(context).createTextElement(eq(
        "var Bundle Completed EventEvent = new CustomEvent('Bundle Completed Event');document.dispatchEvent(Bundle Completed EventEvent);"));
    verify(broadleafTemplateNonVoidElement).addChild(isA(BroadleafTemplateElement.class));
    verify(environment, atLeast(1)).getProperty(eq("bundle.enabled"));
  }

  /**
   * Test {@link ResourceBundleProcessor#buildUnbundledSyncCompletedEventElement(ResourceTagAttributes, BroadleafTemplateContext)}.
   * <ul>
   *   <li>When {@link ResourceTagAttributes#ResourceTagAttributes()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundleProcessor#buildUnbundledSyncCompletedEventElement(ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafTemplateElement ResourceBundleProcessor.buildUnbundledSyncCompletedEventElement(ResourceTagAttributes, BroadleafTemplateContext)"})
  public void testBuildUnbundledSyncCompletedEventElement_whenResourceTagAttributes() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    // Act
    BroadleafTemplateElement actualBuildUnbundledSyncCompletedEventElementResult = resourceBundleProcessor
        .buildUnbundledSyncCompletedEventElement(new ResourceTagAttributes(), mock(BroadleafTemplateContext.class));

    // Assert
    verify(environment).getProperty(eq("bundle.enabled"));
    assertNull(actualBuildUnbundledSyncCompletedEventElementResult);
  }
}

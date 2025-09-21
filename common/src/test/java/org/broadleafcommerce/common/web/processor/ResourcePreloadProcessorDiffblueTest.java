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
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequestWrapper;
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
  @InjectMocks private ResourcePreloadProcessor resourcePreloadProcessor;

  @Mock private ResourcesRequest resourcesRequest;

  /**
   * Test {@link ResourcePreloadProcessor#getName()}.
   *
   * <p>Method under test: {@link ResourcePreloadProcessor#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourcePreloadProcessor.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("bundlepreload", new ResourcePreloadProcessor().getName());
  }

  /**
   * Test {@link ResourcePreloadProcessor#getPrecedence()}.
   *
   * <p>Method under test: {@link ResourcePreloadProcessor#getPrecedence()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ResourcePreloadProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(10000, resourcePreloadProcessor.getPrecedence());
  }

  /**
   * Test {@link ResourcePreloadProcessor#buildModelBundled(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link ResourcePreloadProcessor#buildModelBundled(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel ResourcePreloadProcessor.buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildModelBundled() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle =
        new ResourcesRequestBundle(
            "Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);
    ArrayList<String> attributeFiles = new ArrayList<>();
    ResourceTagAttributes resourceTagAttributes = new ResourceTagAttributes();

    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getRequest())
        .thenReturn(
            new HttpServletRequestWrapper(
                new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())));
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
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
   * Test {@link ResourcePreloadProcessor#buildModelBundled(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link ResourcePreloadProcessor#buildModelBundled(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel ResourcePreloadProcessor.buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildModelBundled2() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle =
        new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", new ArrayList<>(), ".js");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);
    ArrayList<String> attributeFiles = new ArrayList<>();
    ResourceTagAttributes resourceTagAttributes = new ResourceTagAttributes();

    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getRequest())
        .thenReturn(
            new HttpServletRequestWrapper(
                new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())));
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
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
   * Test {@link ResourcePreloadProcessor#buildModelBundled(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link ResourcePreloadProcessor#buildModelBundled(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel ResourcePreloadProcessor.buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildModelBundled3() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle =
        new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", new ArrayList<>(), ".css");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);
    ArrayList<String> attributeFiles = new ArrayList<>();
    ResourceTagAttributes resourceTagAttributes = new ResourceTagAttributes();

    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getRequest())
        .thenReturn(
            new HttpServletRequestWrapper(
                new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())));
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
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
   * Test {@link ResourcePreloadProcessor#buildModelBundled(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@code .js}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code .js}.
   *   <li>Then calls {@link ResourcesRequest#getBundle(String, String, List)}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePreloadProcessor#buildModelBundled(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel ResourcePreloadProcessor.buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildModelBundled_givenJs_whenArrayListAddJs_thenCallsGetBundle() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle =
        new ResourcesRequestBundle(
            "Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);

    ArrayList<String> attributeFiles = new ArrayList<>();
    attributeFiles.add(".js");
    attributeFiles.add("/");
    ResourceTagAttributes resourceTagAttributes = new ResourceTagAttributes();

    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getRequest())
        .thenReturn(
            new HttpServletRequestWrapper(
                new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())));
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
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
   * Test {@link ResourcePreloadProcessor#buildModelBundled(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@code /}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code /}.
   *   <li>Then calls {@link ResourcesRequest#getBundle(String, String, List)}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePreloadProcessor#buildModelBundled(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel ResourcePreloadProcessor.buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildModelBundled_givenSlash_whenArrayListAddSlash_thenCallsGetBundle() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle =
        new ResourcesRequestBundle(
            "Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);

    ArrayList<String> attributeFiles = new ArrayList<>();
    attributeFiles.add("/");
    ResourceTagAttributes resourceTagAttributes = new ResourceTagAttributes();

    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getRequest())
        .thenReturn(
            new HttpServletRequestWrapper(
                new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())));
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
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
   * Test {@link ResourcePreloadProcessor#buildModelUnbundled(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@link BroadleafTemplateModel}.
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePreloadProcessor#buildModelUnbundled(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel ResourcePreloadProcessor.buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildModelUnbundled_givenBroadleafTemplateModel_whenArrayList() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle =
        new ResourcesRequestBundle(
            "Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);
    doNothing()
        .when(resourcesRequest)
        .saveBundle(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<String>>any());
    ArrayList<String> attributeFiles = new ArrayList<>();
    ResourceTagAttributes resourceTagAttributes = new ResourceTagAttributes();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act
    resourcePreloadProcessor.buildModelUnbundled(attributeFiles, resourceTagAttributes, context);

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequest)
        .saveBundle((String) isNull(), (String) isNull(), isA(List.class), isA(List.class));
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel ResourcePreloadProcessor.buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildModelUnbundled_givenCommercialAtLeftCurlyBracketApostrophe() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle =
        new ResourcesRequestBundle(
            "Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);
    doNothing()
        .when(resourcesRequest)
        .saveBundle(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<String>>any());

    ArrayList<String> attributeFiles = new ArrayList<>();
    attributeFiles.add("foo");
    ResourceTagAttributes resourceTagAttributes = new ResourceTagAttributes();

    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.parseExpression(Mockito.<String>any())).thenReturn("@{'");
    when(context.createModel()).thenReturn(broadleafTemplateModel);

    // Act
    resourcePreloadProcessor.buildModelUnbundled(attributeFiles, resourceTagAttributes, context);

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequest)
        .saveBundle((String) isNull(), (String) isNull(), isA(List.class), isA(List.class));
    verify(context).createModel();
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
    verify(context).parseExpression("@{'nullfoo'}");
    verify(broadleafTemplateModel).addElement(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourcePreloadProcessor#buildModelUnbundled(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@code .css}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePreloadProcessor#buildModelUnbundled(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel ResourcePreloadProcessor.buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildModelUnbundled_givenCss() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle =
        new ResourcesRequestBundle(
            "Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);
    doNothing()
        .when(resourcesRequest)
        .saveBundle(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<String>>any());

    ArrayList<String> attributeFiles = new ArrayList<>();
    attributeFiles.add("foo");
    ResourceTagAttributes resourceTagAttributes = new ResourceTagAttributes();

    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.parseExpression(Mockito.<String>any())).thenReturn(".css");
    when(context.createModel()).thenReturn(broadleafTemplateModel);

    // Act
    resourcePreloadProcessor.buildModelUnbundled(attributeFiles, resourceTagAttributes, context);

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequest)
        .saveBundle((String) isNull(), (String) isNull(), isA(List.class), isA(List.class));
    verify(context).createModel();
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
    verify(context).parseExpression("@{'nullfoo'}");
    verify(broadleafTemplateModel).addElement(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourcePreloadProcessor#buildModelUnbundled(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@code .js}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePreloadProcessor#buildModelUnbundled(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel ResourcePreloadProcessor.buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildModelUnbundled_givenJs() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle =
        new ResourcesRequestBundle(
            "Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);
    doNothing()
        .when(resourcesRequest)
        .saveBundle(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<String>>any());

    ArrayList<String> attributeFiles = new ArrayList<>();
    attributeFiles.add("foo");
    ResourceTagAttributes resourceTagAttributes = new ResourceTagAttributes();

    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.parseExpression(Mockito.<String>any())).thenReturn(".js");
    when(context.createModel()).thenReturn(broadleafTemplateModel);

    // Act
    resourcePreloadProcessor.buildModelUnbundled(attributeFiles, resourceTagAttributes, context);

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequest)
        .saveBundle((String) isNull(), (String) isNull(), isA(List.class), isA(List.class));
    verify(context).createModel();
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
    verify(context).parseExpression("@{'nullfoo'}");
    verify(broadleafTemplateModel).addElement(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourcePreloadProcessor#buildPreloadElement(String, BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>When {@code .css}.
   *   <li>Then calls {@link BroadleafTemplateContext#createStandaloneElement(String, Map,
   *       boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePreloadProcessor#buildPreloadElement(String,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateElement ResourcePreloadProcessor.buildPreloadElement(String, BroadleafTemplateContext)"
  })
  public void testBuildPreloadElement_whenCss_thenCallsCreateStandaloneElement() {
    // Arrange
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    // Act
    resourcePreloadProcessor.buildPreloadElement(".css", context);

    // Assert
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
  }

  /**
   * Test {@link ResourcePreloadProcessor#buildPreloadElement(String, BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>When {@code Href}.
   *   <li>Then calls {@link BroadleafTemplateContext#createStandaloneElement(String, Map,
   *       boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePreloadProcessor#buildPreloadElement(String,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateElement ResourcePreloadProcessor.buildPreloadElement(String, BroadleafTemplateContext)"
  })
  public void testBuildPreloadElement_whenHref_thenCallsCreateStandaloneElement() {
    // Arrange
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    // Act
    resourcePreloadProcessor.buildPreloadElement("Href", context);

    // Assert
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
  }

  /**
   * Test {@link ResourcePreloadProcessor#buildPreloadElement(String, BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>When {@code .js}.
   *   <li>Then calls {@link BroadleafTemplateContext#createStandaloneElement(String, Map,
   *       boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePreloadProcessor#buildPreloadElement(String,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateElement ResourcePreloadProcessor.buildPreloadElement(String, BroadleafTemplateContext)"
  })
  public void testBuildPreloadElement_whenJs_thenCallsCreateStandaloneElement() {
    // Arrange
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    // Act
    resourcePreloadProcessor.buildPreloadElement(".js", context);

    // Assert
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
  }

  /**
   * Test {@link ResourcePreloadProcessor#getPreloadAttributes(String, String)}.
   *
   * <ul>
   *   <li>When {@code As}.
   *   <li>Then return size is three.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePreloadProcessor#getPreloadAttributes(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ResourcePreloadProcessor.getPreloadAttributes(String, String)"})
  public void testGetPreloadAttributes_whenAs_thenReturnSizeIsThree() {
    // Arrange and Act
    Map<String, String> actualPreloadAttributes =
        resourcePreloadProcessor.getPreloadAttributes("Href", "As");

    // Assert
    assertEquals(3, actualPreloadAttributes.size());
    assertEquals("As", actualPreloadAttributes.get("as"));
    assertEquals("Href", actualPreloadAttributes.get("href"));
    assertEquals("preload", actualPreloadAttributes.get("rel"));
  }

  /**
   * Test {@link ResourcePreloadProcessor#getPreloadAttributes(String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePreloadProcessor#getPreloadAttributes(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ResourcePreloadProcessor.getPreloadAttributes(String, String)"})
  public void testGetPreloadAttributes_whenNull_thenReturnSizeIsTwo() {
    // Arrange and Act
    Map<String, String> actualPreloadAttributes =
        resourcePreloadProcessor.getPreloadAttributes("Href", null);

    // Assert
    assertEquals(2, actualPreloadAttributes.size());
    assertEquals("Href", actualPreloadAttributes.get("href"));
    assertEquals("preload", actualPreloadAttributes.get("rel"));
  }

  /**
   * Test {@link ResourcePreloadProcessor#getAs(String)}.
   *
   * <ul>
   *   <li>When {@code .css}.
   *   <li>Then return {@code style}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePreloadProcessor#getAs(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourcePreloadProcessor.getAs(String)"})
  public void testGetAs_whenCss_thenReturnStyle() {
    // Arrange, Act and Assert
    assertEquals("style", resourcePreloadProcessor.getAs(".css"));
  }

  /**
   * Test {@link ResourcePreloadProcessor#getAs(String)}.
   *
   * <ul>
   *   <li>When {@code File}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePreloadProcessor#getAs(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourcePreloadProcessor.getAs(String)"})
  public void testGetAs_whenFile_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(resourcePreloadProcessor.getAs("File"));
  }

  /**
   * Test {@link ResourcePreloadProcessor#getAs(String)}.
   *
   * <ul>
   *   <li>When {@code .js}.
   *   <li>Then return {@code script}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePreloadProcessor#getAs(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourcePreloadProcessor.getAs(String)"})
  public void testGetAs_whenJs_thenReturnScript() {
    // Arrange, Act and Assert
    assertEquals("script", resourcePreloadProcessor.getAs(".js"));
  }
}

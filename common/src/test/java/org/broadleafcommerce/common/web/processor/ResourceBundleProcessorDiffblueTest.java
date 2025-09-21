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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequestWrapper;
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
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@RunWith(MockitoJUnitRunner.class)
public class ResourceBundleProcessorDiffblueTest {
  @Mock private Environment environment;

  @InjectMocks private ResourceBundleProcessor resourceBundleProcessor;

  @Mock private ResourceBundlingService resourceBundlingService;

  @Mock private ResourcesRequest resourcesRequest;

  /**
   * Test {@link ResourceBundleProcessor#getName()}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("bundle", new ResourceBundleProcessor().getName());
  }

  /**
   * Test {@link ResourceBundleProcessor#getPrecedence()}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#getPrecedence()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ResourceBundleProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(10000, resourceBundleProcessor.getPrecedence());
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelUnbundled(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#buildModelUnbundled(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel ResourceBundleProcessor.buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildModelUnbundled() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ArrayList<String> files = new ArrayList<>();
    ResourcesRequestBundle resourcesRequestBundle =
        new ResourcesRequestBundle("bundle.enabled", "bundle.enabled", files, new ArrayList<>());
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);
    ArrayList<String> attributeFiles = new ArrayList<>();
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act
    resourceBundleProcessor.buildModelUnbundled(attributeFiles, attributes, context);

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(context).createModel();
    verify(environment).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelUnbundled(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then calls {@link ResourceTagAttributes#mappingPrefix()}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#buildModelUnbundled(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel ResourceBundleProcessor.buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildModelUnbundled_given42_whenArrayListAdd42_thenCallsMappingPrefix() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle = mock(ResourcesRequestBundle.class);
    when(resourcesRequestBundle.getBundleFilePaths()).thenThrow(new IllegalArgumentException());
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);

    ArrayList<String> attributeFiles = new ArrayList<>();
    attributeFiles.add("42");
    attributeFiles.add("foo");

    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.mappingPrefix()).thenReturn("Mapping Prefix");
    when(attributes.name()).thenReturn("Name");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.buildModelUnbundled(attributeFiles, attributes, context));
    verify(attributes).mappingPrefix();
    verify(attributes).name();
    verify(resourcesRequest).getBundle(eq("Name"), eq("Mapping Prefix"), isA(List.class));
    verify(resourcesRequestBundle).getBundleFilePaths();
    verify(context).createModel();
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelUnbundled(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given Bean Name{blResourcesRequest} {@link ResourcesRequest#getBundle(String, String,
   *       List)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#buildModelUnbundled(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel ResourceBundleProcessor.buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildModelUnbundled_givenBeanNameBlResourcesRequestGetBundleReturnNull() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(null);
    doNothing()
        .when(resourcesRequest)
        .saveBundle(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<String>>any());
    ArrayList<String> attributeFiles = new ArrayList<>();
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act
    resourceBundleProcessor.buildModelUnbundled(attributeFiles, attributes, context);

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequest)
        .saveBundle((String) isNull(), (String) isNull(), isA(List.class), isA(List.class));
    verify(context).createModel();
    verify(environment).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelUnbundled(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#buildModelUnbundled(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel ResourceBundleProcessor.buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildModelUnbundled_givenEnvironmentGetPropertyThrowIllegalArgumentException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
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
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.buildModelUnbundled(attributeFiles, attributes, context));
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequest)
        .saveBundle((String) isNull(), (String) isNull(), isA(List.class), isA(List.class));
    verify(context).createModel();
    verify(environment).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelUnbundled(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then calls {@link ResourceTagAttributes#mappingPrefix()}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#buildModelUnbundled(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel ResourceBundleProcessor.buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildModelUnbundled_givenFoo_whenArrayListAddFoo_thenCallsMappingPrefix() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle = mock(ResourcesRequestBundle.class);
    when(resourcesRequestBundle.getBundleFilePaths()).thenThrow(new IllegalArgumentException());
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);

    ArrayList<String> attributeFiles = new ArrayList<>();
    attributeFiles.add("foo");

    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.mappingPrefix()).thenReturn("Mapping Prefix");
    when(attributes.name()).thenReturn("Name");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.buildModelUnbundled(attributeFiles, attributes, context));
    verify(attributes).mappingPrefix();
    verify(attributes).name();
    verify(resourcesRequest).getBundle(eq("Name"), eq("Mapping Prefix"), isA(List.class));
    verify(resourcesRequestBundle).getBundleFilePaths();
    verify(context).createModel();
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelUnbundled(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#buildModelUnbundled(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel ResourceBundleProcessor.buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildModelUnbundled_givenIllegalArgumentException() {
    // Arrange
    ArrayList<String> attributeFiles = new ArrayList<>();
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createModel()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.buildModelUnbundled(attributeFiles, attributes, context));
    verify(context).createModel();
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelUnbundled(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@code Mapping Prefix}.
   *   <li>Then calls {@link ResourceTagAttributes#mappingPrefix()}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#buildModelUnbundled(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel ResourceBundleProcessor.buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildModelUnbundled_givenMappingPrefix_thenCallsMappingPrefix() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle = mock(ResourcesRequestBundle.class);
    when(resourcesRequestBundle.getBundleFilePaths()).thenThrow(new IllegalArgumentException());
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);
    ArrayList<String> attributeFiles = new ArrayList<>();

    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.mappingPrefix()).thenReturn("Mapping Prefix");
    when(attributes.name()).thenReturn("Name");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.buildModelUnbundled(attributeFiles, attributes, context));
    verify(attributes).mappingPrefix();
    verify(attributes).name();
    verify(resourcesRequest).getBundle(eq("Name"), eq("Mapping Prefix"), isA(List.class));
    verify(resourcesRequestBundle).getBundleFilePaths();
    verify(context).createModel();
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelUnbundled(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then calls {@link ResourcesRequestBundle#getBundleFilePaths()}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#buildModelUnbundled(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel ResourceBundleProcessor.buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildModelUnbundled_thenCallsGetBundleFilePaths() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle = mock(ResourcesRequestBundle.class);
    when(resourcesRequestBundle.getBundleFilePaths()).thenThrow(new IllegalArgumentException());
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);
    ArrayList<String> attributeFiles = new ArrayList<>();
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.buildModelUnbundled(attributeFiles, attributes, context));
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequestBundle).getBundleFilePaths();
    verify(context).createModel();
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelUnbundled(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then calls {@link ResourcesRequest#saveBundle(String, String, List, List)}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#buildModelUnbundled(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel ResourceBundleProcessor.buildModelUnbundled(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildModelUnbundled_thenCallsSaveBundle() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
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
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act
    resourceBundleProcessor.buildModelUnbundled(attributeFiles, attributes, context);

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequest)
        .saveBundle((String) isNull(), (String) isNull(), isA(List.class), isA(List.class));
    verify(context).createModel();
    verify(environment).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelBundled(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#buildModelBundled(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel ResourceBundleProcessor.buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)"
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
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getRequest())
        .thenReturn(
            new HttpServletRequestWrapper(
                new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())));
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.buildModelBundled(attributeFiles, attributes, context));
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(context).createModel();
    verify(context).getRequest();
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelBundled(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#buildModelBundled(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel ResourceBundleProcessor.buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildModelBundled2() {
    // Arrange
    ArrayList<String> attributeFiles = new ArrayList<>();
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createModel()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.buildModelBundled(attributeFiles, attributes, context));
    verify(context).createModel();
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelBundled(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#buildModelBundled(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel ResourceBundleProcessor.buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildModelBundled3() {
    // Arrange
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenThrow(new IllegalArgumentException());
    ArrayList<String> attributeFiles = new ArrayList<>();
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.buildModelBundled(attributeFiles, attributes, context));
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(context).createModel();
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelBundled(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#buildModelBundled(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel ResourceBundleProcessor.buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildModelBundled4() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle =
        new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", new ArrayList<>(), "/");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);
    ArrayList<String> attributeFiles = new ArrayList<>();
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getRequest())
        .thenReturn(
            new HttpServletRequestWrapper(
                new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())));
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.buildModelBundled(attributeFiles, attributes, context));
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(context).createModel();
    verify(context).getRequest();
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelBundled(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#buildModelBundled(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel ResourceBundleProcessor.buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildModelBundled5() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle =
        new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", new ArrayList<>(), ";");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);
    ArrayList<String> attributeFiles = new ArrayList<>();
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getRequest())
        .thenReturn(
            new HttpServletRequestWrapper(
                new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())));
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.buildModelBundled(attributeFiles, attributes, context));
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(context).createModel();
    verify(context).getRequest();
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelBundled(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#buildModelBundled(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel ResourceBundleProcessor.buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildModelBundled6() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle =
        new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", new ArrayList<>(), "");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);
    ArrayList<String> attributeFiles = new ArrayList<>();
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getRequest())
        .thenReturn(
            new HttpServletRequestWrapper(
                new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())));
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.buildModelBundled(attributeFiles, attributes, context));
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(context).createModel();
    verify(context).getRequest();
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelBundled(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#buildModelBundled(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel ResourceBundleProcessor.buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildModelBundled7() {
    // Arrange
    when(resourceBundlingService.resolveBundleResourceName(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<String>any()))
        .thenReturn("Resolve Bundle Resource Name");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(null);
    doNothing()
        .when(resourcesRequest)
        .saveBundle(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<String>any());
    ArrayList<String> attributeFiles = new ArrayList<>();
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getRequest())
        .thenReturn(
            new HttpServletRequestWrapper(
                new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())));
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.buildModelBundled(attributeFiles, attributes, context));
    verify(resourceBundlingService)
        .resolveBundleResourceName(isNull(), isNull(), isA(List.class), isNull());
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequest)
        .saveBundle(
            (String) isNull(),
            (String) isNull(),
            isA(List.class),
            eq("Resolve Bundle Resource Name"));
    verify(context).createModel();
    verify(context).getRequest();
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelBundled(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#buildModelBundled(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel ResourceBundleProcessor.buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildModelBundled8() {
    // Arrange
    when(resourceBundlingService.resolveBundleResourceName(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(null);
    ArrayList<String> attributeFiles = new ArrayList<>();
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.buildModelBundled(attributeFiles, attributes, context));
    verify(resourceBundlingService)
        .resolveBundleResourceName(isNull(), isNull(), isA(List.class), isNull());
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(context).createModel();
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelBundled(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#buildModelBundled(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel ResourceBundleProcessor.buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildModelBundled9() {
    // Arrange
    when(resourceBundlingService.resolveBundleResourceName(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<String>any()))
        .thenReturn("Resolve Bundle Resource Name");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(null);
    doNothing()
        .when(resourcesRequest)
        .saveBundle(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<String>any());
    ArrayList<String> attributeFiles = new ArrayList<>();
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getContextPath()).thenThrow(new IllegalArgumentException());
    SessionlessHttpServletRequestWrapper request2 =
        new SessionlessHttpServletRequestWrapper(request);

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getRequest()).thenReturn(new HttpServletRequestWrapper(request2));
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.buildModelBundled(attributeFiles, attributes, context));
    verify(request).getContextPath();
    verify(resourceBundlingService)
        .resolveBundleResourceName(isNull(), isNull(), isA(List.class), isNull());
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequest)
        .saveBundle(
            (String) isNull(),
            (String) isNull(),
            isA(List.class),
            eq("Resolve Bundle Resource Name"));
    verify(context).createModel();
    verify(context).getRequest();
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelBundled(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#buildModelBundled(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel ResourceBundleProcessor.buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildModelBundled10() {
    // Arrange
    when(resourceBundlingService.resolveBundleResourceName(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<String>any()))
        .thenReturn("Resolve Bundle Resource Name");
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(null);
    doNothing()
        .when(resourcesRequest)
        .saveBundle(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<String>any());
    ArrayList<String> attributeFiles = new ArrayList<>();

    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.includeAsyncDeferUnbundled()).thenReturn(true);
    when(attributes.async()).thenReturn(true);
    when(attributes.bundleCompletedEvent()).thenReturn("Bundle Completed Event");
    when(attributes.bundleDependencyEvent()).thenReturn("Bundle Dependency Event");
    when(attributes.mappingPrefix()).thenReturn("Mapping Prefix");
    when(attributes.name()).thenReturn("Name");
    when(attributes.src(Mockito.<String>any())).thenReturn(new ResourceTagAttributes());

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getContextPath()).thenReturn("https://example.org/example");
    SessionlessHttpServletRequestWrapper request2 =
        new SessionlessHttpServletRequestWrapper(request);
    HttpServletRequestWrapper httpServletRequestWrapper = new HttpServletRequestWrapper(request2);

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    when(context.getRequest()).thenReturn(httpServletRequestWrapper);
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.buildModelBundled(attributeFiles, attributes, context));
    verify(request).getContextPath();
    verify(resourceBundlingService)
        .resolveBundleResourceName(eq("Name"), eq("Mapping Prefix"), isA(List.class), isNull());
    verify(attributes, atLeast(1)).async();
    verify(attributes).bundleCompletedEvent();
    verify(attributes, atLeast(1)).bundleDependencyEvent();
    verify(attributes, atLeast(1)).includeAsyncDeferUnbundled();
    verify(attributes, atLeast(1)).mappingPrefix();
    verify(attributes, atLeast(1)).name();
    verify(attributes).src("https://example.org/example/Resolve Bundle Resource Name");
    verify(resourcesRequest).getBundle(eq("Name"), eq("Mapping Prefix"), isA(List.class));
    verify(resourcesRequest)
        .saveBundle(
            eq("Name"), eq("Mapping Prefix"), isA(List.class), eq("Resolve Bundle Resource Name"));
    verify(context).createModel();
    verify(context)
        .createTextElement(
            "<script>function runOnReady(callback, event) {    var watchEvent = typeof(event) == 'undefined' ? 'DOMContentLoaded' : event;    if (document.readyState != 'loading' && !event) {        callback();    } else {        document.addEventListener(watchEvent, callback);    }}; if (typeof(Bundle Dependency EventEvent) !== 'undefined') {    runOnReady(handleName);} else {    runOnReady(function() {            runOnReady(handleName);        },        'Bundle Dependency Event');} function handleName() {    var lastScript = null;    ['https://example.org/example/Resolve Bundle Resource Name'].forEach(function (elem, idx, arr) {        var script = document.createElement('script');        script.type = 'text/javascript';        script.src = elem;        script.async = true;        document.body.appendChild(script);    });};</script>");
    verify(context).getRequest();
    verify(environment, atLeast(1)).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelBundled(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then calls {@link ResourcesRequestBundle#getBundlePath()}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#buildModelBundled(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel ResourceBundleProcessor.buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildModelBundled_given42_whenArrayListAdd42_thenCallsGetBundlePath() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle = mock(ResourcesRequestBundle.class);
    when(resourcesRequestBundle.getBundlePath()).thenThrow(new IllegalArgumentException());
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);

    ArrayList<String> attributeFiles = new ArrayList<>();
    attributeFiles.add("42");
    attributeFiles.add("foo");

    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.mappingPrefix()).thenReturn("Mapping Prefix");
    when(attributes.name()).thenReturn("Name");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.buildModelBundled(attributeFiles, attributes, context));
    verify(attributes).mappingPrefix();
    verify(attributes).name();
    verify(resourcesRequest).getBundle(eq("Name"), eq("Mapping Prefix"), isA(List.class));
    verify(resourcesRequestBundle).getBundlePath();
    verify(context).createModel();
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelBundled(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@link BroadleafTemplateElement}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#buildModelBundled(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel ResourceBundleProcessor.buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildModelBundled_givenBroadleafTemplateElement() {
    // Arrange
    when(resourceBundlingService.resolveBundleResourceName(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<String>any()))
        .thenReturn("Resolve Bundle Resource Name");
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(null);
    doNothing()
        .when(resourcesRequest)
        .saveBundle(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<String>any());
    ArrayList<String> attributeFiles = new ArrayList<>();

    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.includeAsyncDeferUnbundled()).thenReturn(true);
    when(attributes.async()).thenReturn(true);
    when(attributes.bundleCompletedEvent()).thenReturn("Bundle Completed Event");
    when(attributes.bundleDependencyEvent()).thenReturn("Bundle Dependency Event");
    when(attributes.mappingPrefix()).thenReturn("Mapping Prefix");
    when(attributes.name()).thenReturn("Name");
    when(attributes.src(Mockito.<String>any())).thenReturn(new ResourceTagAttributes());

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getContextPath()).thenReturn("https://example.org/example");
    SessionlessHttpServletRequestWrapper request2 =
        new SessionlessHttpServletRequestWrapper(request);
    HttpServletRequestWrapper httpServletRequestWrapper = new HttpServletRequestWrapper(request2);

    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.getRequest()).thenReturn(httpServletRequestWrapper);
    when(context.createModel()).thenReturn(broadleafTemplateModel);

    // Act
    resourceBundleProcessor.buildModelBundled(attributeFiles, attributes, context);

    // Assert
    verify(request).getContextPath();
    verify(resourceBundlingService)
        .resolveBundleResourceName(eq("Name"), eq("Mapping Prefix"), isA(List.class), isNull());
    verify(attributes, atLeast(1)).async();
    verify(attributes).bundleCompletedEvent();
    verify(attributes, atLeast(1)).bundleDependencyEvent();
    verify(attributes, atLeast(1)).includeAsyncDeferUnbundled();
    verify(attributes, atLeast(1)).mappingPrefix();
    verify(attributes, atLeast(1)).name();
    verify(attributes).src("https://example.org/example/Resolve Bundle Resource Name");
    verify(resourcesRequest).getBundle(eq("Name"), eq("Mapping Prefix"), isA(List.class));
    verify(resourcesRequest)
        .saveBundle(
            eq("Name"), eq("Mapping Prefix"), isA(List.class), eq("Resolve Bundle Resource Name"));
    verify(context).createModel();
    verify(context)
        .createTextElement(
            "<script>function runOnReady(callback, event) {    var watchEvent = typeof(event) == 'undefined' ? 'DOMContentLoaded' : event;    if (document.readyState != 'loading' && !event) {        callback();    } else {        document.addEventListener(watchEvent, callback);    }}; if (typeof(Bundle Dependency EventEvent) !== 'undefined') {    runOnReady(handleName);} else {    runOnReady(function() {            runOnReady(handleName);        },        'Bundle Dependency Event');} function handleName() {    var lastScript = null;    ['https://example.org/example/Resolve Bundle Resource Name'].forEach(function (elem, idx, arr) {        var script = document.createElement('script');        script.type = 'text/javascript';        script.src = elem;        script.async = true;        document.body.appendChild(script);    });};</script>");
    verify(context).getRequest();
    verify(broadleafTemplateModel).addElement(isA(BroadleafTemplateElement.class));
    verify(environment, atLeast(1)).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelBundled(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#buildModelBundled(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel ResourceBundleProcessor.buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildModelBundled_givenEnvironmentGetPropertyThrowIllegalArgumentException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
    ResourcesRequestBundle resourcesRequestBundle =
        new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", new ArrayList<>(), ".js");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);
    ArrayList<String> attributeFiles = new ArrayList<>();
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getRequest())
        .thenReturn(
            new HttpServletRequestWrapper(
                new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())));
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.buildModelBundled(attributeFiles, attributes, context));
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(context).createModel();
    verify(context).getRequest();
    verify(environment).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelBundled(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then calls {@link ResourcesRequestBundle#getBundlePath()}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#buildModelBundled(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel ResourceBundleProcessor.buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildModelBundled_givenFoo_whenArrayListAddFoo_thenCallsGetBundlePath() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle = mock(ResourcesRequestBundle.class);
    when(resourcesRequestBundle.getBundlePath()).thenThrow(new IllegalArgumentException());
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);

    ArrayList<String> attributeFiles = new ArrayList<>();
    attributeFiles.add("foo");

    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.mappingPrefix()).thenReturn("Mapping Prefix");
    when(attributes.name()).thenReturn("Name");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.buildModelBundled(attributeFiles, attributes, context));
    verify(attributes).mappingPrefix();
    verify(attributes).name();
    verify(resourcesRequest).getBundle(eq("Name"), eq("Mapping Prefix"), isA(List.class));
    verify(resourcesRequestBundle).getBundlePath();
    verify(context).createModel();
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelBundled(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link BroadleafTemplateContext} {@link BroadleafTemplateContext#getRequest()}
   *       return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#buildModelBundled(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel ResourceBundleProcessor.buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildModelBundled_givenNull_whenBroadleafTemplateContextGetRequestReturnNull() {
    // Arrange
    when(resourceBundlingService.resolveBundleResourceName(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<String>any()))
        .thenReturn("Resolve Bundle Resource Name");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(null);
    doNothing()
        .when(resourcesRequest)
        .saveBundle(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<String>any());
    ArrayList<String> attributeFiles = new ArrayList<>();
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getRequest()).thenReturn(null);
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.buildModelBundled(attributeFiles, attributes, context));
    verify(resourceBundlingService)
        .resolveBundleResourceName(isNull(), isNull(), isA(List.class), isNull());
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequest)
        .saveBundle(
            (String) isNull(),
            (String) isNull(),
            isA(List.class),
            eq("Resolve Bundle Resource Name"));
    verify(context).createModel();
    verify(context).getRequest();
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelBundled(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then calls {@link ResourcesRequestBundle#getBundlePath()}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#buildModelBundled(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel ResourceBundleProcessor.buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildModelBundled_thenCallsGetBundlePath() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle = mock(ResourcesRequestBundle.class);
    when(resourcesRequestBundle.getBundlePath()).thenThrow(new IllegalArgumentException());
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);
    ArrayList<String> attributeFiles = new ArrayList<>();

    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.mappingPrefix()).thenReturn("Mapping Prefix");
    when(attributes.name()).thenReturn("Name");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.buildModelBundled(attributeFiles, attributes, context));
    verify(attributes).mappingPrefix();
    verify(attributes).name();
    verify(resourcesRequest).getBundle(eq("Name"), eq("Mapping Prefix"), isA(List.class));
    verify(resourcesRequestBundle).getBundlePath();
    verify(context).createModel();
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelBundled(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then calls {@link DefaultMultipartHttpServletRequest#getContextPath()}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#buildModelBundled(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel ResourceBundleProcessor.buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildModelBundled_thenCallsGetContextPath() {
    // Arrange
    when(resourceBundlingService.resolveBundleResourceName(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<String>any()))
        .thenReturn("Resolve Bundle Resource Name");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(null);
    doNothing()
        .when(resourcesRequest)
        .saveBundle(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<String>any());
    ArrayList<String> attributeFiles = new ArrayList<>();
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getContextPath()).thenReturn("https://example.org/example");
    SessionlessHttpServletRequestWrapper request2 =
        new SessionlessHttpServletRequestWrapper(request);

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getRequest()).thenReturn(new HttpServletRequestWrapper(request2));
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.buildModelBundled(attributeFiles, attributes, context));
    verify(request).getContextPath();
    verify(resourceBundlingService)
        .resolveBundleResourceName(isNull(), isNull(), isA(List.class), isNull());
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(resourcesRequest)
        .saveBundle(
            (String) isNull(),
            (String) isNull(),
            isA(List.class),
            eq("Resolve Bundle Resource Name"));
    verify(context).createModel();
    verify(context).getRequest();
  }

  /**
   * Test {@link ResourceBundleProcessor#buildModelBundled(List, ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then {@link ResourceTagAttributes#ResourceTagAttributes()} src is {@code /.js}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#buildModelBundled(List,
   * ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel ResourceBundleProcessor.buildModelBundled(List, ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildModelBundled_thenResourceTagAttributesSrcIsJs() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ResourcesRequestBundle resourcesRequestBundle =
        new ResourcesRequestBundle("Bundle Name", "Mapping Prefix", new ArrayList<>(), ".js");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);
    ArrayList<String> attributeFiles = new ArrayList<>();
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateNonVoidElement.class));
    when(context.getRequest())
        .thenReturn(
            new HttpServletRequestWrapper(
                new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())));
    when(context.createModel()).thenReturn(broadleafTemplateModel);

    // Act
    resourceBundleProcessor.buildModelBundled(attributeFiles, attributes, context);

    // Assert
    verify(resourcesRequest).getBundle(isNull(), isNull(), isA(List.class));
    verify(context).createModel();
    verify(context).createNonVoidElement(eq("script"), isA(Map.class), eq(true));
    verify(context).getRequest();
    verify(broadleafTemplateModel).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty("bundle.enabled");
    assertEquals("/.js", attributes.src());
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)} with {@code attributes}, {@code context},
   * {@code model}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddElementToModelWithAttributesContextModel() {
    // Arrange
    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.src(";");
    attributes.defer(false);
    attributes.includeAsyncDeferUnbundled(false);
    attributes.async(false);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            resourceBundleProcessor.addElementToModel(
                attributes,
                mock(BroadleafTemplateContext.class),
                mock(BroadleafTemplateModel.class)));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)} with {@code attributes}, {@code context},
   * {@code model}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddElementToModelWithAttributesContextModel2() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.src(".js");
    attributes.defer(false);
    attributes.includeAsyncDeferUnbundled(false);
    attributes.async(false);

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateNonVoidElement.class));

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addElementToModel(attributes, context, model);

    // Assert
    verify(context).createNonVoidElement(eq("script"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)} with {@code attributes}, {@code context},
   * {@code model}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddElementToModelWithAttributesContextModel3() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.src(".js");
    attributes.defer(false);
    attributes.includeAsyncDeferUnbundled(false);
    attributes.async(false);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            resourceBundleProcessor.addElementToModel(
                attributes,
                mock(BroadleafTemplateContext.class),
                mock(BroadleafTemplateModel.class)));
    verify(environment).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)} with {@code attributes}, {@code context},
   * {@code model}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddElementToModelWithAttributesContextModel4() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.src(".js");
    attributes.defer(false);
    attributes.includeAsyncDeferUnbundled(true);
    attributes.async(false);

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateNonVoidElement.class));

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addElementToModel(attributes, context, model);

    // Assert
    verify(context).createNonVoidElement(eq("script"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)} with {@code attributes}, {@code context},
   * {@code model}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddElementToModelWithAttributesContextModel5() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.src(".js");
    attributes.defer(false);
    attributes.includeAsyncDeferUnbundled(false);
    attributes.async(false);

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateNonVoidElement.class));

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doThrow(new IllegalArgumentException())
        .when(model)
        .addElement(Mockito.<BroadleafTemplateElement>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.addElementToModel(attributes, context, model));
    verify(context).createNonVoidElement(eq("script"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)} with {@code attributes}, {@code context},
   * {@code model}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddElementToModelWithAttributesContextModel6() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.src(".js");
    attributes.defer(true);
    attributes.includeAsyncDeferUnbundled(true);
    attributes.async(false);

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateNonVoidElement.class));

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addElementToModel(attributes, context, model);

    // Assert
    verify(context).createNonVoidElement(eq("script"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)} with {@code attributes}, {@code context},
   * {@code model}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddElementToModelWithAttributesContextModel7() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.src(".js");
    attributes.defer(false);
    attributes.includeAsyncDeferUnbundled(true);
    attributes.async(true);

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateNonVoidElement.class));

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addElementToModel(attributes, context, model);

    // Assert
    verify(context).createNonVoidElement(eq("script"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)} with {@code attributes}, {@code context},
   * {@code model}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddElementToModelWithAttributesContextModel8() {
    // Arrange
    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.src(".css");
    attributes.defer(false);
    attributes.includeAsyncDeferUnbundled(false);
    attributes.async(false);

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            resourceBundleProcessor.addElementToModel(
                attributes, context, mock(BroadleafTemplateModel.class)));
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)} with {@code attributes}, {@code context},
   * {@code model}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddElementToModelWithAttributesContextModel9() {
    // Arrange
    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.src(".css");
    attributes.defer(false);
    attributes.includeAsyncDeferUnbundled(false);
    attributes.async(false);

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doThrow(new IllegalArgumentException())
        .when(model)
        .addElement(Mockito.<BroadleafTemplateElement>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.addElementToModel(attributes, context, model));
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)} with {@code attributes}, {@code context},
   * {@code model}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddElementToModelWithAttributesContextModel10() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.src(".js");
    attributes.defer(false);
    attributes.includeAsyncDeferUnbundled(false);
    attributes.async(false);

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            resourceBundleProcessor.addElementToModel(
                attributes, context, mock(BroadleafTemplateModel.class)));
    verify(context).createNonVoidElement(eq("script"), isA(Map.class), eq(true));
    verify(environment).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)} with {@code attributes}, {@code context},
   * {@code model}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddElementToModelWithAttributesContextModel11() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.src(".css");
    attributes.defer(true);
    attributes.includeAsyncDeferUnbundled(false);
    attributes.async(false);

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            resourceBundleProcessor.addElementToModel(
                attributes, context, mock(BroadleafTemplateModel.class)));
    verify(context).createNonVoidElement("noscript");
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)} with {@code attributes}, {@code context},
   * {@code model}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddElementToModelWithAttributesContextModel12() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.src(".css");
    attributes.defer(true);
    attributes.includeAsyncDeferUnbundled(false);
    attributes.async(false);

    BroadleafTemplateNonVoidElement broadleafTemplateNonVoidElement =
        mock(BroadleafTemplateNonVoidElement.class);
    doNothing()
        .when(broadleafTemplateNonVoidElement)
        .addChild(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(Mockito.<String>any()))
        .thenReturn(broadleafTemplateNonVoidElement);
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addElementToModel(attributes, context, model);

    // Assert
    verify(context).createNonVoidElement("noscript");
    verify(context, atLeast(1))
        .createStandaloneElement(eq("link"), Mockito.<Map<String, String>>any(), eq(true));
    verify(model, atLeast(1)).addElement(Mockito.<BroadleafTemplateElement>any());
    verify(broadleafTemplateNonVoidElement).addChild(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)} with {@code attributes}, {@code context},
   * {@code model}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddElementToModelWithAttributesContextModel13() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.src(".css");
    attributes.defer(true);
    attributes.includeAsyncDeferUnbundled(false);
    attributes.async(false);

    BroadleafTemplateNonVoidElement broadleafTemplateNonVoidElement =
        mock(BroadleafTemplateNonVoidElement.class);
    doThrow(new IllegalArgumentException())
        .when(broadleafTemplateNonVoidElement)
        .addChild(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(Mockito.<String>any()))
        .thenReturn(broadleafTemplateNonVoidElement);
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            resourceBundleProcessor.addElementToModel(
                attributes, context, mock(BroadleafTemplateModel.class)));
    verify(context).createNonVoidElement("noscript");
    verify(context, atLeast(1))
        .createStandaloneElement(eq("link"), Mockito.<Map<String, String>>any(), eq(true));
    verify(broadleafTemplateNonVoidElement).addChild(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)} with {@code attributes}, {@code context},
   * {@code model}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddElementToModelWithAttributesContextModel14() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.src()).thenReturn(";");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            resourceBundleProcessor.addElementToModel(
                attributes,
                mock(BroadleafTemplateContext.class),
                mock(BroadleafTemplateModel.class)));
    verify(attributes, atLeast(1)).src();
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)} with {@code attributes}, {@code context},
   * {@code model}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddElementToModelWithAttributesContextModel15() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.defer()).thenReturn(false);
    when(attributes.src()).thenReturn(".css");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            resourceBundleProcessor.addElementToModel(
                attributes, context, mock(BroadleafTemplateModel.class)));
    verify(attributes).defer();
    verify(attributes, atLeast(1)).src();
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)} with {@code attributes}, {@code context},
   * {@code model}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddElementToModelWithAttributesContextModel16() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.defer()).thenReturn(true);
    when(attributes.src()).thenReturn(".css");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            resourceBundleProcessor.addElementToModel(
                attributes, context, mock(BroadleafTemplateModel.class)));
    verify(attributes).defer();
    verify(attributes, atLeast(1)).src();
    verify(context).createNonVoidElement("noscript");
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)} with {@code attributes}, {@code context},
   * {@code model}.
   *
   * <ul>
   *   <li>Given {@link BroadleafTemplateElement}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddElementToModelWithAttributesContextModel_givenBroadleafTemplateElement() {
    // Arrange
    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.src(".css");
    attributes.defer(false);
    attributes.includeAsyncDeferUnbundled(false);
    attributes.async(false);

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addElementToModel(attributes, context, model);

    // Assert
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean,
   * BroadleafTemplateContext, BroadleafTemplateModel)} with {@code src}, {@code async}, {@code
   * defer}, {@code context}, {@code model}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addElementToModel(String, boolean,
   * boolean, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddElementToModelWithSrcAsyncDeferContextModel() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            resourceBundleProcessor.addElementToModel(
                ".js",
                true,
                true,
                mock(BroadleafTemplateContext.class),
                mock(BroadleafTemplateModel.class)));
    verify(environment).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean,
   * BroadleafTemplateContext, BroadleafTemplateModel)} with {@code src}, {@code async}, {@code
   * defer}, {@code context}, {@code model}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addElementToModel(String, boolean,
   * boolean, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddElementToModelWithSrcAsyncDeferContextModel2() {
    // Arrange
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            resourceBundleProcessor.addElementToModel(
                ".css", true, true, context, mock(BroadleafTemplateModel.class)));
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean,
   * BroadleafTemplateContext, BroadleafTemplateModel)} with {@code src}, {@code async}, {@code
   * defer}, {@code context}, {@code model}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addElementToModel(String, boolean,
   * boolean, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddElementToModelWithSrcAsyncDeferContextModel3() {
    // Arrange
    BroadleafTemplateNonVoidElement broadleafTemplateNonVoidElement =
        mock(BroadleafTemplateNonVoidElement.class);
    doNothing()
        .when(broadleafTemplateNonVoidElement)
        .addChild(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createNonVoidElement(Mockito.<String>any()))
        .thenReturn(broadleafTemplateNonVoidElement);

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addElementToModel(".css", true, true, context, model);

    // Assert
    verify(context).createNonVoidElement("noscript");
    verify(context, atLeast(1))
        .createStandaloneElement(eq("link"), Mockito.<Map<String, String>>any(), eq(true));
    verify(model, atLeast(1)).addElement(Mockito.<BroadleafTemplateElement>any());
    verify(broadleafTemplateNonVoidElement).addChild(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean,
   * BroadleafTemplateContext, BroadleafTemplateModel)} with {@code src}, {@code async}, {@code
   * defer}, {@code context}, {@code model}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addElementToModel(String, boolean,
   * boolean, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddElementToModelWithSrcAsyncDeferContextModel4() {
    // Arrange
    BroadleafTemplateNonVoidElement broadleafTemplateNonVoidElement =
        mock(BroadleafTemplateNonVoidElement.class);
    doThrow(new IllegalArgumentException())
        .when(broadleafTemplateNonVoidElement)
        .addChild(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createNonVoidElement(Mockito.<String>any()))
        .thenReturn(broadleafTemplateNonVoidElement);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            resourceBundleProcessor.addElementToModel(
                ".css", true, true, context, mock(BroadleafTemplateModel.class)));
    verify(context).createNonVoidElement("noscript");
    verify(context, atLeast(1))
        .createStandaloneElement(eq("link"), Mockito.<Map<String, String>>any(), eq(true));
    verify(broadleafTemplateNonVoidElement).addChild(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean,
   * BroadleafTemplateContext, BroadleafTemplateModel)} with {@code src}, {@code async}, {@code
   * defer}, {@code context}, {@code model}.
   *
   * <ul>
   *   <li>Given {@link ResourceBundleProcessor} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addElementToModel(String, boolean,
   * boolean, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddElementToModelWithSrcAsyncDeferContextModel_givenResourceBundleProcessor() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    BroadleafTemplateNonVoidElement broadleafTemplateNonVoidElement =
        mock(BroadleafTemplateNonVoidElement.class);
    doNothing()
        .when(broadleafTemplateNonVoidElement)
        .addChild(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createNonVoidElement(Mockito.<String>any()))
        .thenReturn(broadleafTemplateNonVoidElement);

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doThrow(new IllegalArgumentException())
        .when(model)
        .addElement(Mockito.<BroadleafTemplateElement>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.addElementToModel(".css", true, true, context, model));
    verify(context).createNonVoidElement("noscript");
    verify(context, atLeast(1))
        .createStandaloneElement(eq("link"), Mockito.<Map<String, String>>any(), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(broadleafTemplateNonVoidElement).addChild(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean,
   * BroadleafTemplateContext, BroadleafTemplateModel)} with {@code src}, {@code async}, {@code
   * defer}, {@code context}, {@code model}.
   *
   * <ul>
   *   <li>Given {@link ResourceBundleProcessor} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addElementToModel(String, boolean,
   * boolean, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddElementToModelWithSrcAsyncDeferContextModel_givenResourceBundleProcessor2() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doThrow(new IllegalArgumentException())
        .when(model)
        .addElement(Mockito.<BroadleafTemplateElement>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.addElementToModel(".css", true, false, context, model));
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean,
   * BroadleafTemplateContext, BroadleafTemplateModel)} with {@code src}, {@code async}, {@code
   * defer}, {@code context}, {@code model}.
   *
   * <ul>
   *   <li>Then calls {@link BroadleafTemplateContext#createNonVoidElement(String, Map, boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addElementToModel(String, boolean,
   * boolean, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddElementToModelWithSrcAsyncDeferContextModel_thenCallsCreateNonVoidElement() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateNonVoidElement.class));

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addElementToModel(".js", true, true, context, model);

    // Assert
    verify(context).createNonVoidElement(eq("script"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean,
   * BroadleafTemplateContext, BroadleafTemplateModel)} with {@code src}, {@code async}, {@code
   * defer}, {@code context}, {@code model}.
   *
   * <ul>
   *   <li>Then calls {@link BroadleafTemplateContext#createNonVoidElement(String, Map, boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addElementToModel(String, boolean,
   * boolean, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddElementToModelWithSrcAsyncDeferContextModel_thenCallsCreateNonVoidElement2() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateNonVoidElement.class));

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doThrow(new IllegalArgumentException())
        .when(model)
        .addElement(Mockito.<BroadleafTemplateElement>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.addElementToModel(".js", true, true, context, model));
    verify(context).createNonVoidElement(eq("script"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean,
   * BroadleafTemplateContext, BroadleafTemplateModel)} with {@code src}, {@code async}, {@code
   * defer}, {@code context}, {@code model}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addElementToModel(String, boolean,
   * boolean, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddElementToModelWithSrcAsyncDeferContextModel_whenFalse() {
    // Arrange
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
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
   * Test {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean,
   * BroadleafTemplateContext, BroadleafTemplateModel)} with {@code src}, {@code async}, {@code
   * defer}, {@code context}, {@code model}.
   *
   * <ul>
   *   <li>When {@code ;}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addElementToModel(String, boolean,
   * boolean, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddElementToModelWithSrcAsyncDeferContextModel_whenSemicolon() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            resourceBundleProcessor.addElementToModel(
                ";",
                true,
                true,
                mock(BroadleafTemplateContext.class),
                mock(BroadleafTemplateModel.class)));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean,
   * BroadleafTemplateContext, BroadleafTemplateModel)} with {@code src}, {@code async}, {@code
   * defer}, {@code context}, {@code model}.
   *
   * <ul>
   *   <li>When {@code Src}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addElementToModel(String, boolean,
   * boolean, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddElementToModelWithSrcAsyncDeferContextModel_whenSrc() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            resourceBundleProcessor.addElementToModel(
                "Src",
                true,
                true,
                mock(BroadleafTemplateContext.class),
                mock(BroadleafTemplateModel.class)));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, String,
   * BroadleafTemplateContext, BroadleafTemplateModel)} with {@code src}, {@code async}, {@code
   * defer}, {@code dependencyEvent}, {@code context}, {@code model}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addElementToModel(String, boolean,
   * boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddElementToModelWithSrcAsyncDeferDependencyEventContextModel() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateNonVoidElement.class));

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addElementToModel(
        ".js", true, true, "Dependency Event", context, model);

    // Assert
    verify(context).createNonVoidElement(eq("script"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, String,
   * BroadleafTemplateContext, BroadleafTemplateModel)} with {@code src}, {@code async}, {@code
   * defer}, {@code dependencyEvent}, {@code context}, {@code model}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addElementToModel(String, boolean,
   * boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddElementToModelWithSrcAsyncDeferDependencyEventContextModel2() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            resourceBundleProcessor.addElementToModel(
                ".js",
                true,
                true,
                "Dependency Event",
                mock(BroadleafTemplateContext.class),
                mock(BroadleafTemplateModel.class)));
    verify(environment).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, String,
   * BroadleafTemplateContext, BroadleafTemplateModel)} with {@code src}, {@code async}, {@code
   * defer}, {@code dependencyEvent}, {@code context}, {@code model}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addElementToModel(String, boolean,
   * boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddElementToModelWithSrcAsyncDeferDependencyEventContextModel3() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateNonVoidElement.class));

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doThrow(new IllegalArgumentException())
        .when(model)
        .addElement(Mockito.<BroadleafTemplateElement>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            resourceBundleProcessor.addElementToModel(
                ".js", true, true, "Dependency Event", context, model));
    verify(context).createNonVoidElement(eq("script"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, String,
   * BroadleafTemplateContext, BroadleafTemplateModel)} with {@code src}, {@code async}, {@code
   * defer}, {@code dependencyEvent}, {@code context}, {@code model}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addElementToModel(String, boolean,
   * boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddElementToModelWithSrcAsyncDeferDependencyEventContextModel4() {
    // Arrange
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            resourceBundleProcessor.addElementToModel(
                ".css",
                true,
                true,
                "Dependency Event",
                context,
                mock(BroadleafTemplateModel.class)));
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, String,
   * BroadleafTemplateContext, BroadleafTemplateModel)} with {@code src}, {@code async}, {@code
   * defer}, {@code dependencyEvent}, {@code context}, {@code model}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addElementToModel(String, boolean,
   * boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddElementToModelWithSrcAsyncDeferDependencyEventContextModel5() {
    // Arrange
    BroadleafTemplateNonVoidElement broadleafTemplateNonVoidElement =
        mock(BroadleafTemplateNonVoidElement.class);
    doNothing()
        .when(broadleafTemplateNonVoidElement)
        .addChild(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createNonVoidElement(Mockito.<String>any()))
        .thenReturn(broadleafTemplateNonVoidElement);

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addElementToModel(
        ".css", true, true, "Dependency Event", context, model);

    // Assert
    verify(context).createNonVoidElement("noscript");
    verify(context, atLeast(1))
        .createStandaloneElement(eq("link"), Mockito.<Map<String, String>>any(), eq(true));
    verify(model, atLeast(1)).addElement(Mockito.<BroadleafTemplateElement>any());
    verify(broadleafTemplateNonVoidElement).addChild(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, String,
   * BroadleafTemplateContext, BroadleafTemplateModel)} with {@code src}, {@code async}, {@code
   * defer}, {@code dependencyEvent}, {@code context}, {@code model}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addElementToModel(String, boolean,
   * boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddElementToModelWithSrcAsyncDeferDependencyEventContextModel6() {
    // Arrange
    BroadleafTemplateNonVoidElement broadleafTemplateNonVoidElement =
        mock(BroadleafTemplateNonVoidElement.class);
    doThrow(new IllegalArgumentException())
        .when(broadleafTemplateNonVoidElement)
        .addChild(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createNonVoidElement(Mockito.<String>any()))
        .thenReturn(broadleafTemplateNonVoidElement);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            resourceBundleProcessor.addElementToModel(
                ".css",
                true,
                true,
                "Dependency Event",
                context,
                mock(BroadleafTemplateModel.class)));
    verify(context).createNonVoidElement("noscript");
    verify(context, atLeast(1))
        .createStandaloneElement(eq("link"), Mockito.<Map<String, String>>any(), eq(true));
    verify(broadleafTemplateNonVoidElement).addChild(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, String,
   * BroadleafTemplateContext, BroadleafTemplateModel)} with {@code src}, {@code async}, {@code
   * defer}, {@code dependencyEvent}, {@code context}, {@code model}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addElementToModel(String, boolean,
   * boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddElementToModelWithSrcAsyncDeferDependencyEventContextModel7() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    BroadleafTemplateNonVoidElement broadleafTemplateNonVoidElement =
        mock(BroadleafTemplateNonVoidElement.class);
    doNothing()
        .when(broadleafTemplateNonVoidElement)
        .addChild(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createNonVoidElement(Mockito.<String>any()))
        .thenReturn(broadleafTemplateNonVoidElement);

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doThrow(new IllegalArgumentException())
        .when(model)
        .addElement(Mockito.<BroadleafTemplateElement>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            resourceBundleProcessor.addElementToModel(
                ".css", true, true, "Dependency Event", context, model));
    verify(context).createNonVoidElement("noscript");
    verify(context, atLeast(1))
        .createStandaloneElement(eq("link"), Mockito.<Map<String, String>>any(), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(broadleafTemplateNonVoidElement).addChild(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, String,
   * BroadleafTemplateContext, BroadleafTemplateModel)} with {@code src}, {@code async}, {@code
   * defer}, {@code dependencyEvent}, {@code context}, {@code model}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addElementToModel(String, boolean,
   * boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddElementToModelWithSrcAsyncDeferDependencyEventContextModel8() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doThrow(new IllegalArgumentException())
        .when(model)
        .addElement(Mockito.<BroadleafTemplateElement>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            resourceBundleProcessor.addElementToModel(
                ".css", true, false, "Dependency Event", context, model));
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, String,
   * BroadleafTemplateContext, BroadleafTemplateModel)} with {@code src}, {@code async}, {@code
   * defer}, {@code dependencyEvent}, {@code context}, {@code model}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addElementToModel(String, boolean,
   * boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddElementToModelWithSrcAsyncDeferDependencyEventContextModel_whenFalse() {
    // Arrange
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addElementToModel(
        ".css", true, false, "Dependency Event", context, model);

    // Assert
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, String,
   * BroadleafTemplateContext, BroadleafTemplateModel)} with {@code src}, {@code async}, {@code
   * defer}, {@code dependencyEvent}, {@code context}, {@code model}.
   *
   * <ul>
   *   <li>When {@code ;}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addElementToModel(String, boolean,
   * boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddElementToModelWithSrcAsyncDeferDependencyEventContextModel_whenSemicolon() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            resourceBundleProcessor.addElementToModel(
                ";",
                true,
                true,
                "Dependency Event",
                mock(BroadleafTemplateContext.class),
                mock(BroadleafTemplateModel.class)));
  }

  /**
   * Test {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, String,
   * BroadleafTemplateContext, BroadleafTemplateModel)} with {@code src}, {@code async}, {@code
   * defer}, {@code dependencyEvent}, {@code context}, {@code model}.
   *
   * <ul>
   *   <li>When {@code Src}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addElementToModel(String, boolean,
   * boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddElementToModelWithSrcAsyncDeferDependencyEventContextModel_whenSrc() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            resourceBundleProcessor.addElementToModel(
                "Src",
                true,
                true,
                "Dependency Event",
                mock(BroadleafTemplateContext.class),
                mock(BroadleafTemplateModel.class)));
  }

  /**
   * Test {@link ResourceBundleProcessor#addJavaScriptToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}.
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#addJavaScriptToModel(ResourceTagAttributes, BroadleafTemplateContext,
   * BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addJavaScriptToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddJavaScriptToModel() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            resourceBundleProcessor.addJavaScriptToModel(
                new ResourceTagAttributes(),
                mock(BroadleafTemplateContext.class),
                mock(BroadleafTemplateModel.class)));
    verify(environment).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#addJavaScriptToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}.
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#addJavaScriptToModel(ResourceTagAttributes, BroadleafTemplateContext,
   * BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addJavaScriptToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddJavaScriptToModel2() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.src()).thenReturn("Src");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            resourceBundleProcessor.addJavaScriptToModel(
                attributes,
                mock(BroadleafTemplateContext.class),
                mock(BroadleafTemplateModel.class)));
    verify(attributes).src();
    verify(environment).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#addJavaScriptToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}.
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#addJavaScriptToModel(ResourceTagAttributes, BroadleafTemplateContext,
   * BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addJavaScriptToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddJavaScriptToModel3() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.includeAsyncDeferUnbundled()).thenReturn(false);
    when(attributes.src()).thenReturn("Src");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateNonVoidElement.class));

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addJavaScriptToModel(attributes, context, model);

    // Assert
    verify(attributes).includeAsyncDeferUnbundled();
    verify(attributes).src();
    verify(context).createNonVoidElement(eq("script"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#addJavaScriptToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}.
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#addJavaScriptToModel(ResourceTagAttributes, BroadleafTemplateContext,
   * BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addJavaScriptToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddJavaScriptToModel4() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.includeAsyncDeferUnbundled(false);
    attributes.async(false);
    attributes.defer(false);

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateNonVoidElement.class));

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doThrow(new IllegalArgumentException())
        .when(model)
        .addElement(Mockito.<BroadleafTemplateElement>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.addJavaScriptToModel(attributes, context, model));
    verify(context).createNonVoidElement(eq("script"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#addJavaScriptToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}.
   *
   * <ul>
   *   <li>When {@link ResourceTagAttributes} {@link ResourceTagAttributes#async()} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#addJavaScriptToModel(ResourceTagAttributes, BroadleafTemplateContext,
   * BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addJavaScriptToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddJavaScriptToModel_whenResourceTagAttributesAsyncReturnFalse() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.async()).thenReturn(false);
    when(attributes.defer()).thenReturn(false);
    when(attributes.includeAsyncDeferUnbundled()).thenReturn(true);
    when(attributes.src()).thenReturn("Src");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
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
    verify(environment).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#addJavaScriptToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}.
   *
   * <ul>
   *   <li>When {@link ResourceTagAttributes} {@link ResourceTagAttributes#async()} return {@code
   *       true}.
   *   <li>Then calls {@link ResourceTagAttributes#defer()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#addJavaScriptToModel(ResourceTagAttributes, BroadleafTemplateContext,
   * BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addJavaScriptToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddJavaScriptToModel_whenResourceTagAttributesAsyncReturnTrue_thenCallsDefer() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.async()).thenReturn(true);
    when(attributes.defer()).thenReturn(true);
    when(attributes.includeAsyncDeferUnbundled()).thenReturn(true);
    when(attributes.src()).thenReturn("Src");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
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
    verify(environment).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#addJavaScriptToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}.
   *
   * <ul>
   *   <li>When {@link ResourceTagAttributes#ResourceTagAttributes()} includeAsyncDeferUnbundled
   *       {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#addJavaScriptToModel(ResourceTagAttributes, BroadleafTemplateContext,
   * BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addJavaScriptToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddJavaScriptToModel_whenResourceTagAttributesIncludeAsyncDeferUnbundledTrue() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ResourceTagAttributes attributes = new ResourceTagAttributes();
    attributes.includeAsyncDeferUnbundled(true);

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateNonVoidElement.class));

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addJavaScriptToModel(attributes, context, model);

    // Assert
    verify(context).createNonVoidElement(eq("script"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#addJavaScriptToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}.
   *
   * <ul>
   *   <li>When {@link ResourceTagAttributes#ResourceTagAttributes()}.
   *   <li>Then calls {@link BroadleafTemplateContext#createNonVoidElement(String, Map, boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#addJavaScriptToModel(ResourceTagAttributes, BroadleafTemplateContext,
   * BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addJavaScriptToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddJavaScriptToModel_whenResourceTagAttributes_thenCallsCreateNonVoidElement() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateNonVoidElement.class));

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addJavaScriptToModel(attributes, context, model);

    // Assert
    verify(context).createNonVoidElement(eq("script"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#addCssToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addCssToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addCssToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddCssToModel() {
    // Arrange
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            resourceBundleProcessor.addCssToModel(
                attributes, context, mock(BroadleafTemplateModel.class)));
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
  }

  /**
   * Test {@link ResourceBundleProcessor#addCssToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addCssToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addCssToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddCssToModel2() {
    // Arrange
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doThrow(new IllegalArgumentException())
        .when(model)
        .addElement(Mockito.<BroadleafTemplateElement>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.addCssToModel(attributes, context, model));
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#addCssToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addCssToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addCssToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddCssToModel3() {
    // Arrange
    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.defer()).thenReturn(true);
    when(attributes.src()).thenReturn("Src");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            resourceBundleProcessor.addCssToModel(
                attributes, context, mock(BroadleafTemplateModel.class)));
    verify(attributes).defer();
    verify(attributes).src();
    verify(context).createNonVoidElement("noscript");
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
  }

  /**
   * Test {@link ResourceBundleProcessor#addCssToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addCssToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addCssToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddCssToModel4() {
    // Arrange
    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.defer()).thenReturn(true);
    when(attributes.src()).thenReturn("Src");

    BroadleafTemplateNonVoidElement broadleafTemplateNonVoidElement =
        mock(BroadleafTemplateNonVoidElement.class);
    doThrow(new IllegalArgumentException())
        .when(broadleafTemplateNonVoidElement)
        .addChild(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(Mockito.<String>any()))
        .thenReturn(broadleafTemplateNonVoidElement);
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            resourceBundleProcessor.addCssToModel(
                attributes, context, mock(BroadleafTemplateModel.class)));
    verify(attributes).defer();
    verify(attributes, atLeast(1)).src();
    verify(context).createNonVoidElement("noscript");
    verify(context, atLeast(1))
        .createStandaloneElement(eq("link"), Mockito.<Map<String, String>>any(), eq(true));
    verify(broadleafTemplateNonVoidElement).addChild(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#addCssToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}.
   *
   * <ul>
   *   <li>Given {@link BroadleafTemplateNonVoidElement} {@link
   *       BroadleafTemplateNonVoidElement#addChild(BroadleafTemplateElement)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addCssToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addCssToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddCssToModel_givenBroadleafTemplateNonVoidElementAddChildDoesNothing() {
    // Arrange
    ResourceTagAttributes attributes = new ResourceTagAttributes();
    attributes.defer(true);

    BroadleafTemplateNonVoidElement broadleafTemplateNonVoidElement =
        mock(BroadleafTemplateNonVoidElement.class);
    doNothing()
        .when(broadleafTemplateNonVoidElement)
        .addChild(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(Mockito.<String>any()))
        .thenReturn(broadleafTemplateNonVoidElement);
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addCssToModel(attributes, context, model);

    // Assert
    verify(context).createNonVoidElement("noscript");
    verify(context, atLeast(1))
        .createStandaloneElement(eq("link"), Mockito.<Map<String, String>>any(), eq(true));
    verify(model, atLeast(1)).addElement(Mockito.<BroadleafTemplateElement>any());
    verify(broadleafTemplateNonVoidElement).addChild(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#addCssToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link ResourceTagAttributes} {@link ResourceTagAttributes#defer()} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addCssToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addCssToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddCssToModel_givenFalse_whenResourceTagAttributesDeferReturnFalse() {
    // Arrange
    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.defer()).thenReturn(false);
    when(attributes.src()).thenReturn("Src");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doThrow(new InvalidParameterException())
        .when(model)
        .addElement(Mockito.<BroadleafTemplateElement>any());

    // Act and Assert
    assertThrows(
        InvalidParameterException.class,
        () -> resourceBundleProcessor.addCssToModel(attributes, context, model));
    verify(attributes).defer();
    verify(attributes).src();
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#addCssToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}.
   *
   * <ul>
   *   <li>Then throw {@link InvalidParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addCssToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addCssToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddCssToModel_thenThrowInvalidParameterException() {
    // Arrange
    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.defer()).thenReturn(true);
    when(attributes.src()).thenReturn("Src");

    BroadleafTemplateNonVoidElement broadleafTemplateNonVoidElement =
        mock(BroadleafTemplateNonVoidElement.class);
    doNothing()
        .when(broadleafTemplateNonVoidElement)
        .addChild(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(Mockito.<String>any()))
        .thenReturn(broadleafTemplateNonVoidElement);
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doThrow(new InvalidParameterException())
        .when(model)
        .addElement(Mockito.<BroadleafTemplateElement>any());

    // Act and Assert
    assertThrows(
        InvalidParameterException.class,
        () -> resourceBundleProcessor.addCssToModel(attributes, context, model));
    verify(attributes).defer();
    verify(attributes, atLeast(1)).src();
    verify(context).createNonVoidElement("noscript");
    verify(context, atLeast(1))
        .createStandaloneElement(eq("link"), Mockito.<Map<String, String>>any(), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(broadleafTemplateNonVoidElement).addChild(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#addCssToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}.
   *
   * <ul>
   *   <li>When {@link ResourceTagAttributes#ResourceTagAttributes()} defer {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addCssToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addCssToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddCssToModel_whenResourceTagAttributesDeferTrue() {
    // Arrange
    ResourceTagAttributes attributes = new ResourceTagAttributes();
    attributes.defer(true);

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            resourceBundleProcessor.addCssToModel(
                attributes, context, mock(BroadleafTemplateModel.class)));
    verify(context).createNonVoidElement("noscript");
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
  }

  /**
   * Test {@link ResourceBundleProcessor#addCssToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}.
   *
   * <ul>
   *   <li>When {@link ResourceTagAttributes#ResourceTagAttributes()}.
   *   <li>Then calls {@link BroadleafTemplateModel#addElement(BroadleafTemplateElement)}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addCssToModel(ResourceTagAttributes,
   * BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addCssToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddCssToModel_whenResourceTagAttributes_thenCallsAddElement() {
    // Arrange
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
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
   * Test {@link ResourceBundleProcessor#getDeferredCssElements(ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#getDeferredCssElements(ResourceTagAttributes,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ResourceBundleProcessor.getDeferredCssElements(ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testGetDeferredCssElements() {
    // Arrange
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    BroadleafTemplateNonVoidElement broadleafTemplateNonVoidElement =
        mock(BroadleafTemplateNonVoidElement.class);
    doThrow(new IllegalArgumentException())
        .when(broadleafTemplateNonVoidElement)
        .addChild(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createNonVoidElement(Mockito.<String>any()))
        .thenReturn(broadleafTemplateNonVoidElement);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.getDeferredCssElements(attributes, context));
    verify(context).createNonVoidElement("noscript");
    verify(context, atLeast(1))
        .createStandaloneElement(eq("link"), Mockito.<Map<String, String>>any(), eq(true));
    verify(broadleafTemplateNonVoidElement).addChild(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#getDeferredCssElements(ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#getDeferredCssElements(ResourceTagAttributes,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ResourceBundleProcessor.getDeferredCssElements(ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testGetDeferredCssElements_givenIllegalArgumentException() {
    // Arrange
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.getDeferredCssElements(attributes, context));
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
  }

  /**
   * Test {@link ResourceBundleProcessor#getDeferredCssElements(ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@code Src}.
   *   <li>Then throw {@link InvalidParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#getDeferredCssElements(ResourceTagAttributes,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ResourceBundleProcessor.getDeferredCssElements(ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testGetDeferredCssElements_givenSrc_thenThrowInvalidParameterException() {
    // Arrange
    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.src()).thenReturn("Src");

    BroadleafTemplateNonVoidElement broadleafTemplateNonVoidElement =
        mock(BroadleafTemplateNonVoidElement.class);
    doThrow(new InvalidParameterException())
        .when(broadleafTemplateNonVoidElement)
        .addChild(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createNonVoidElement(Mockito.<String>any()))
        .thenReturn(broadleafTemplateNonVoidElement);

    // Act and Assert
    assertThrows(
        InvalidParameterException.class,
        () -> resourceBundleProcessor.getDeferredCssElements(attributes, context));
    verify(attributes, atLeast(1)).src();
    verify(context).createNonVoidElement("noscript");
    verify(context, atLeast(1))
        .createStandaloneElement(eq("link"), Mockito.<Map<String, String>>any(), eq(true));
    verify(broadleafTemplateNonVoidElement).addChild(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#getDeferredCssElements(ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#getDeferredCssElements(ResourceTagAttributes,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ResourceBundleProcessor.getDeferredCssElements(ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testGetDeferredCssElements_thenReturnSizeIsTwo() {
    // Arrange
    ResourceTagAttributes attributes = new ResourceTagAttributes();

    BroadleafTemplateNonVoidElement broadleafTemplateNonVoidElement =
        mock(BroadleafTemplateNonVoidElement.class);
    doNothing()
        .when(broadleafTemplateNonVoidElement)
        .addChild(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createNonVoidElement(Mockito.<String>any()))
        .thenReturn(broadleafTemplateNonVoidElement);

    // Act
    List<BroadleafTemplateElement> actualDeferredCssElements =
        resourceBundleProcessor.getDeferredCssElements(attributes, context);

    // Assert
    verify(context).createNonVoidElement("noscript");
    verify(context, atLeast(1))
        .createStandaloneElement(eq("link"), Mockito.<Map<String, String>>any(), eq(true));
    verify(broadleafTemplateNonVoidElement).addChild(isA(BroadleafTemplateElement.class));
    assertEquals(2, actualDeferredCssElements.size());
  }

  /**
   * Test {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List,
   * ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List,
   * ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddDependencyRestrictionToModel() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
    ArrayList<String> files = new ArrayList<>();

    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.bundleDependencyEvent()).thenReturn("Bundle Dependency Event");
    when(attributes.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            resourceBundleProcessor.addDependencyRestrictionToModel(
                files,
                attributes,
                mock(BroadleafTemplateContext.class),
                mock(BroadleafTemplateModel.class)));
    verify(attributes).bundleDependencyEvent();
    verify(attributes).name();
    verify(environment).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List,
   * ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List,
   * ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddDependencyRestrictionToModel2() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ArrayList<String> files = new ArrayList<>();

    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.includeAsyncDeferUnbundled()).thenReturn(true);
    when(attributes.async()).thenReturn(true);
    when(attributes.bundleDependencyEvent()).thenReturn("Bundle Dependency Event");
    when(attributes.name()).thenReturn("Name");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doThrow(new IllegalArgumentException())
        .when(model)
        .addElement(Mockito.<BroadleafTemplateElement>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            resourceBundleProcessor.addDependencyRestrictionToModel(
                files, attributes, context, model));
    verify(attributes, atLeast(1)).async();
    verify(attributes).bundleDependencyEvent();
    verify(attributes, atLeast(1)).includeAsyncDeferUnbundled();
    verify(attributes).name();
    verify(context)
        .createTextElement(
            "<script>function runOnReady(callback, event) {    var watchEvent = typeof(event) == 'undefined' ? 'DOMContentLoaded' : event;    if (document.readyState != 'loading' && !event) {        callback();    } else {        document.addEventListener(watchEvent, callback);    }}; if (typeof(Bundle Dependency EventEvent) !== 'undefined') {    runOnReady(handleName);} else {    runOnReady(function() {            runOnReady(handleName);        },        'Bundle Dependency Event');} function handleName() {    var lastScript = null;    [].forEach(function (elem, idx, arr) {        var script = document.createElement('script');        script.type = 'text/javascript';        script.src = elem;        script.async = true;        document.body.appendChild(script);    });};</script>");
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment, atLeast(1)).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List,
   * ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List,
   * ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddDependencyRestrictionToModel3() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ArrayList<String> files = new ArrayList<>();

    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.includeAsyncDeferUnbundled()).thenReturn(false);
    when(attributes.async()).thenReturn(true);
    when(attributes.bundleCompletedEvent()).thenReturn("Bundle Completed Event");
    when(attributes.bundleDependencyEvent()).thenReturn("Bundle Dependency Event");
    when(attributes.name())
        .thenReturn(
            "if (idx === arr.length - 1) {    script.addEventListener('load', function () {        ");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addDependencyRestrictionToModel(files, attributes, context, model);

    // Assert
    verify(attributes, atLeast(1)).async();
    verify(attributes).bundleCompletedEvent();
    verify(attributes).bundleDependencyEvent();
    verify(attributes, atLeast(1)).includeAsyncDeferUnbundled();
    verify(attributes, atLeast(1)).name();
    verify(context)
        .createTextElement(
            "<script>function runOnReady(callback, event) {    var watchEvent = typeof(event) == 'undefined' ? 'DOMContentLoaded' : event;    if (document.readyState != 'loading' && !event) {        callback();    } else {        document.addEventListener(watchEvent, callback);    }}; if (typeof(Bundle Dependency EventEvent) !== 'undefined') {    runOnReady(handleif (idx === arr_length _ 1) {    script_addEventListener('load', function () {        );} else {    runOnReady(function() {            runOnReady(handleif (idx === arr_length _ 1) {    script_addEventListener('load', function () {        );        },        'Bundle Dependency Event');} function handleif (idx === arr_length _ 1) {    script_addEventListener('load', function () {        () {    var lastScript = null;    [].forEach(function (elem, idx, arr) {        var script = document.createElement('script');        script.type = 'text/javascript';        script.src = elem;        script.async = false;        document.body.appendChild(script);if (idx === arr.length - 1) {    script.addEventListener('load', function () {        null;    });}    });};</script>");
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment, atLeast(1)).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List,
   * ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   *
   * <ul>
   *   <li>Given a string.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List,
   * ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddDependencyRestrictionToModel_givenAString() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ArrayList<String> files = new ArrayList<>();

    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.includeAsyncDeferUnbundled()).thenReturn(true);
    when(attributes.async()).thenReturn(true);
    when(attributes.bundleDependencyEvent()).thenReturn("Bundle Dependency Event");
    when(attributes.name())
        .thenReturn(
            "<script>function runOnReady(callback, event) {    var watchEvent = typeof(event) == 'undefined' ?"
                + " 'DOMContentLoaded' : event;    if (document.readyState != 'loading' && !event) {        callback();"
                + "    } else {        document.addEventListener(watchEvent, callback);    }}; if (typeof(");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addDependencyRestrictionToModel(files, attributes, context, model);

    // Assert
    verify(attributes, atLeast(1)).async();
    verify(attributes).bundleDependencyEvent();
    verify(attributes, atLeast(1)).includeAsyncDeferUnbundled();
    verify(attributes).name();
    verify(context)
        .createTextElement(
            "<script>function runOnReady(callback, event) {    var watchEvent = typeof(event) == 'undefined' ? 'DOMContentLoaded' : event;    if (document.readyState != 'loading' && !event) {        callback();    } else {        document.addEventListener(watchEvent, callback);    }}; if (typeof(Bundle Dependency EventEvent) !== 'undefined') {    runOnReady(handle<script>function runOnReady(callback, event) {    var watchEvent = typeof(event) == 'undefined' ? 'DOMContentLoaded' : event;    if (document_readyState != 'loading' && !event) {        callback();    } else {        document_addEventListener(watchEvent, callback);    }}; if (typeof();} else {    runOnReady(function() {            runOnReady(handle<script>function runOnReady(callback, event) {    var watchEvent = typeof(event) == 'undefined' ? 'DOMContentLoaded' : event;    if (document_readyState != 'loading' && !event) {        callback();    } else {        document_addEventListener(watchEvent, callback);    }}; if (typeof();        },        'Bundle Dependency Event');} function handle<script>function runOnReady(callback, event) {    var watchEvent = typeof(event) == 'undefined' ? 'DOMContentLoaded' : event;    if (document_readyState != 'loading' && !event) {        callback();    } else {        document_addEventListener(watchEvent, callback);    }}; if (typeof(() {    var lastScript = null;    [].forEach(function (elem, idx, arr) {        var script = document.createElement('script');        script.type = 'text/javascript';        script.src = elem;        script.async = true;        document.body.appendChild(script);    });};</script>");
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment, atLeast(1)).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List,
   * ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   *
   * <ul>
   *   <li>Given a string.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List,
   * ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddDependencyRestrictionToModel_givenAString2() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ArrayList<String> files = new ArrayList<>();

    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.includeAsyncDeferUnbundled()).thenReturn(true);
    when(attributes.async()).thenReturn(true);
    when(attributes.bundleDependencyEvent()).thenReturn("Bundle Dependency Event");
    when(attributes.name())
        .thenReturn(
            "].forEach(function (elem, idx, arr) {        var script = document.createElement('script');       "
                + " script.type = 'text/javascript';        script.src = elem;        script.async = ");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addDependencyRestrictionToModel(files, attributes, context, model);

    // Assert
    verify(attributes, atLeast(1)).async();
    verify(attributes).bundleDependencyEvent();
    verify(attributes, atLeast(1)).includeAsyncDeferUnbundled();
    verify(attributes).name();
    verify(context)
        .createTextElement(
            "<script>function runOnReady(callback, event) {    var watchEvent = typeof(event) == 'undefined' ? 'DOMContentLoaded' : event;    if (document.readyState != 'loading' && !event) {        callback();    } else {        document.addEventListener(watchEvent, callback);    }}; if (typeof(Bundle Dependency EventEvent) !== 'undefined') {    runOnReady(handlejavascript';        script_src = elem;        script_async = );} else {    runOnReady(function() {            runOnReady(handlejavascript';        script_src = elem;        script_async = );        },        'Bundle Dependency Event');} function handlejavascript';        script_src = elem;        script_async = () {    var lastScript = null;    [].forEach(function (elem, idx, arr) {        var script = document.createElement('script');        script.type = 'text/javascript';        script.src = elem;        script.async = true;        document.body.appendChild(script);    });};</script>");
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment, atLeast(1)).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List,
   * ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   *
   * <ul>
   *   <li>Given {@code \.}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List,
   * ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddDependencyRestrictionToModel_givenBackslashDot() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ArrayList<String> files = new ArrayList<>();

    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.includeAsyncDeferUnbundled()).thenReturn(true);
    when(attributes.async()).thenReturn(true);
    when(attributes.bundleDependencyEvent()).thenReturn("Bundle Dependency Event");
    when(attributes.name()).thenReturn("\\.");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addDependencyRestrictionToModel(files, attributes, context, model);

    // Assert
    verify(attributes, atLeast(1)).async();
    verify(attributes).bundleDependencyEvent();
    verify(attributes, atLeast(1)).includeAsyncDeferUnbundled();
    verify(attributes).name();
    verify(context)
        .createTextElement(
            "<script>function runOnReady(callback, event) {    var watchEvent = typeof(event) == 'undefined' ? 'DOMContentLoaded' : event;    if (document.readyState != 'loading' && !event) {        callback();    } else {        document.addEventListener(watchEvent, callback);    }}; if (typeof(Bundle Dependency EventEvent) !== 'undefined') {    runOnReady(handle\\_);} else {    runOnReady(function() {            runOnReady(handle\\_);        },        'Bundle Dependency Event');} function handle\\_() {    var lastScript = null;    [].forEach(function (elem, idx, arr) {        var script = document.createElement('script');        script.type = 'text/javascript';        script.src = elem;        script.async = true;        document.body.appendChild(script);    });};</script>");
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment, atLeast(1)).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List,
   * ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   *
   * <ul>
   *   <li>Given {@code Bundle Completed Event}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List,
   * ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddDependencyRestrictionToModel_givenBundleCompletedEvent() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ArrayList<String> files = new ArrayList<>();

    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.includeAsyncDeferUnbundled()).thenReturn(false);
    when(attributes.async()).thenReturn(true);
    when(attributes.bundleCompletedEvent()).thenReturn("Bundle Completed Event");
    when(attributes.bundleDependencyEvent()).thenReturn("Bundle Dependency Event");
    when(attributes.name()).thenReturn("Name");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addDependencyRestrictionToModel(files, attributes, context, model);

    // Assert
    verify(attributes, atLeast(1)).async();
    verify(attributes).bundleCompletedEvent();
    verify(attributes).bundleDependencyEvent();
    verify(attributes, atLeast(1)).includeAsyncDeferUnbundled();
    verify(attributes, atLeast(1)).name();
    verify(context)
        .createTextElement(
            "<script>function runOnReady(callback, event) {    var watchEvent = typeof(event) == 'undefined' ? 'DOMContentLoaded' : event;    if (document.readyState != 'loading' && !event) {        callback();    } else {        document.addEventListener(watchEvent, callback);    }}; if (typeof(Bundle Dependency EventEvent) !== 'undefined') {    runOnReady(handleName);} else {    runOnReady(function() {            runOnReady(handleName);        },        'Bundle Dependency Event');} function handleName() {    var lastScript = null;    [].forEach(function (elem, idx, arr) {        var script = document.createElement('script');        script.type = 'text/javascript';        script.src = elem;        script.async = false;        document.body.appendChild(script);if (idx === arr.length - 1) {    script.addEventListener('load', function () {        null;    });}    });};</script>");
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment, atLeast(1)).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List,
   * ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   *
   * <ul>
   *   <li>Given {@code bundle.enabled}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List,
   * ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddDependencyRestrictionToModel_givenBundleEnabled() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ArrayList<String> files = new ArrayList<>();

    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.includeAsyncDeferUnbundled()).thenReturn(true);
    when(attributes.async()).thenReturn(true);
    when(attributes.bundleDependencyEvent()).thenReturn("Bundle Dependency Event");
    when(attributes.name()).thenReturn("bundle.enabled");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addDependencyRestrictionToModel(files, attributes, context, model);

    // Assert
    verify(attributes, atLeast(1)).async();
    verify(attributes).bundleDependencyEvent();
    verify(attributes, atLeast(1)).includeAsyncDeferUnbundled();
    verify(attributes).name();
    verify(context)
        .createTextElement(
            "<script>function runOnReady(callback, event) {    var watchEvent = typeof(event) == 'undefined' ? 'DOMContentLoaded' : event;    if (document.readyState != 'loading' && !event) {        callback();    } else {        document.addEventListener(watchEvent, callback);    }}; if (typeof(Bundle Dependency EventEvent) !== 'undefined') {    runOnReady(handlebundle_enabled);} else {    runOnReady(function() {            runOnReady(handlebundle_enabled);        },        'Bundle Dependency Event');} function handlebundle_enabled() {    var lastScript = null;    [].forEach(function (elem, idx, arr) {        var script = document.createElement('script');        script.type = 'text/javascript';        script.src = elem;        script.async = true;        document.body.appendChild(script);    });};</script>");
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment, atLeast(1)).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List,
   * ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   *
   * <ul>
   *   <li>Given {@code -}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code -}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List,
   * ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddDependencyRestrictionToModel_givenDash_whenArrayListAddDash() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ArrayList<String> files = new ArrayList<>();
    files.add("-");

    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.includeAsyncDeferUnbundled()).thenReturn(true);
    when(attributes.async()).thenReturn(true);
    when(attributes.bundleDependencyEvent()).thenReturn("Bundle Dependency Event");
    when(attributes.name()).thenReturn("Name");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addDependencyRestrictionToModel(files, attributes, context, model);

    // Assert
    verify(attributes, atLeast(1)).async();
    verify(attributes).bundleDependencyEvent();
    verify(attributes, atLeast(1)).includeAsyncDeferUnbundled();
    verify(attributes).name();
    verify(context)
        .createTextElement(
            "<script>function runOnReady(callback, event) {    var watchEvent = typeof(event) == 'undefined' ? 'DOMContentLoaded' : event;    if (document.readyState != 'loading' && !event) {        callback();    } else {        document.addEventListener(watchEvent, callback);    }}; if (typeof(Bundle Dependency EventEvent) !== 'undefined') {    runOnReady(handleName);} else {    runOnReady(function() {            runOnReady(handleName);        },        'Bundle Dependency Event');} function handleName() {    var lastScript = null;    ['-'].forEach(function (elem, idx, arr) {        var script = document.createElement('script');        script.type = 'text/javascript';        script.src = elem;        script.async = true;        document.body.appendChild(script);    });};</script>");
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment, atLeast(1)).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List,
   * ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   *
   * <ul>
   *   <li>Given {@code .}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List,
   * ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddDependencyRestrictionToModel_givenDot_whenArrayListAddDot() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ArrayList<String> files = new ArrayList<>();
    files.add(".");
    files.add("-");

    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.includeAsyncDeferUnbundled()).thenReturn(true);
    when(attributes.async()).thenReturn(true);
    when(attributes.bundleDependencyEvent()).thenReturn("Bundle Dependency Event");
    when(attributes.name()).thenReturn("Name");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addDependencyRestrictionToModel(files, attributes, context, model);

    // Assert
    verify(attributes, atLeast(1)).async();
    verify(attributes).bundleDependencyEvent();
    verify(attributes, atLeast(1)).includeAsyncDeferUnbundled();
    verify(attributes).name();
    verify(context)
        .createTextElement(
            "<script>function runOnReady(callback, event) {    var watchEvent = typeof(event) == 'undefined' ? 'DOMContentLoaded' : event;    if (document.readyState != 'loading' && !event) {        callback();    } else {        document.addEventListener(watchEvent, callback);    }}; if (typeof(Bundle Dependency EventEvent) !== 'undefined') {    runOnReady(handleName);} else {    runOnReady(function() {            runOnReady(handleName);        },        'Bundle Dependency Event');} function handleName() {    var lastScript = null;    ['.','-'].forEach(function (elem, idx, arr) {        var script = document.createElement('script');        script.type = 'text/javascript';        script.src = elem;        script.async = true;        document.body.appendChild(script);    });};</script>");
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment, atLeast(1)).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List,
   * ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List,
   * ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddDependencyRestrictionToModel_givenEmptyString() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ArrayList<String> files = new ArrayList<>();

    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.includeAsyncDeferUnbundled()).thenReturn(false);
    when(attributes.async()).thenReturn(true);
    when(attributes.bundleCompletedEvent()).thenReturn("");
    when(attributes.bundleDependencyEvent()).thenReturn("Bundle Dependency Event");
    when(attributes.name()).thenReturn("Name");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addDependencyRestrictionToModel(files, attributes, context, model);

    // Assert
    verify(attributes, atLeast(1)).async();
    verify(attributes).bundleCompletedEvent();
    verify(attributes).bundleDependencyEvent();
    verify(attributes, atLeast(1)).includeAsyncDeferUnbundled();
    verify(attributes).name();
    verify(context)
        .createTextElement(
            "<script>function runOnReady(callback, event) {    var watchEvent = typeof(event) == 'undefined' ? 'DOMContentLoaded' : event;    if (document.readyState != 'loading' && !event) {        callback();    } else {        document.addEventListener(watchEvent, callback);    }}; if (typeof(Bundle Dependency EventEvent) !== 'undefined') {    runOnReady(handleName);} else {    runOnReady(function() {            runOnReady(handleName);        },        'Bundle Dependency Event');} function handleName() {    var lastScript = null;    [].forEach(function (elem, idx, arr) {        var script = document.createElement('script');        script.type = 'text/javascript';        script.src = elem;        script.async = false;        document.body.appendChild(script);if (idx === arr.length - 1) {    script.addEventListener('load', function () {        null;    });}    });};</script>");
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment, atLeast(1)).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List,
   * ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List,
   * ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddDependencyRestrictionToModel_givenName() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ArrayList<String> files = new ArrayList<>();

    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.includeAsyncDeferUnbundled()).thenReturn(true);
    when(attributes.async()).thenReturn(true);
    when(attributes.bundleDependencyEvent()).thenReturn("Bundle Dependency Event");
    when(attributes.name()).thenReturn("Name");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addDependencyRestrictionToModel(files, attributes, context, model);

    // Assert
    verify(attributes, atLeast(1)).async();
    verify(attributes).bundleDependencyEvent();
    verify(attributes, atLeast(1)).includeAsyncDeferUnbundled();
    verify(attributes).name();
    verify(context)
        .createTextElement(
            "<script>function runOnReady(callback, event) {    var watchEvent = typeof(event) == 'undefined' ? 'DOMContentLoaded' : event;    if (document.readyState != 'loading' && !event) {        callback();    } else {        document.addEventListener(watchEvent, callback);    }}; if (typeof(Bundle Dependency EventEvent) !== 'undefined') {    runOnReady(handleName);} else {    runOnReady(function() {            runOnReady(handleName);        },        'Bundle Dependency Event');} function handleName() {    var lastScript = null;    [].forEach(function (elem, idx, arr) {        var script = document.createElement('script');        script.type = 'text/javascript';        script.src = elem;        script.async = true;        document.body.appendChild(script);    });};</script>");
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment, atLeast(1)).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List,
   * ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   *
   * <ul>
   *   <li>Given {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List,
   * ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddDependencyRestrictionToModel_givenSlash() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ArrayList<String> files = new ArrayList<>();

    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.includeAsyncDeferUnbundled()).thenReturn(true);
    when(attributes.async()).thenReturn(true);
    when(attributes.bundleDependencyEvent()).thenReturn("Bundle Dependency Event");
    when(attributes.name()).thenReturn("/");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addDependencyRestrictionToModel(files, attributes, context, model);

    // Assert
    verify(attributes, atLeast(1)).async();
    verify(attributes).bundleDependencyEvent();
    verify(attributes, atLeast(1)).includeAsyncDeferUnbundled();
    verify(attributes).name();
    verify(context)
        .createTextElement(
            "<script>function runOnReady(callback, event) {    var watchEvent = typeof(event) == 'undefined' ? 'DOMContentLoaded' : event;    if (document.readyState != 'loading' && !event) {        callback();    } else {        document.addEventListener(watchEvent, callback);    }}; if (typeof(Bundle Dependency EventEvent) !== 'undefined') {    runOnReady(handle);} else {    runOnReady(function() {            runOnReady(handle);        },        'Bundle Dependency Event');} function handle() {    var lastScript = null;    [].forEach(function (elem, idx, arr) {        var script = document.createElement('script');        script.type = 'text/javascript';        script.src = elem;        script.async = true;        document.body.appendChild(script);    });};</script>");
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment, atLeast(1)).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List,
   * ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   *
   * <ul>
   *   <li>When {@link ResourceTagAttributes} {@link ResourceTagAttributes#async()} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List,
   * ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddDependencyRestrictionToModel_whenResourceTagAttributesAsyncReturnFalse() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ArrayList<String> files = new ArrayList<>();

    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.async()).thenReturn(false);
    when(attributes.bundleCompletedEvent()).thenReturn("Bundle Completed Event");
    when(attributes.bundleDependencyEvent()).thenReturn("Bundle Dependency Event");
    when(attributes.name()).thenReturn("Name");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addDependencyRestrictionToModel(files, attributes, context, model);

    // Assert
    verify(attributes, atLeast(1)).async();
    verify(attributes).bundleCompletedEvent();
    verify(attributes).bundleDependencyEvent();
    verify(attributes, atLeast(1)).name();
    verify(context)
        .createTextElement(
            "<script>function runOnReady(callback, event) {    var watchEvent = typeof(event) == 'undefined' ? 'DOMContentLoaded' : event;    if (document.readyState != 'loading' && !event) {        callback();    } else {        document.addEventListener(watchEvent, callback);    }}; if (typeof(Bundle Dependency EventEvent) !== 'undefined') {    runOnReady(handleName);} else {    runOnReady(function() {            runOnReady(handleName);        },        'Bundle Dependency Event');} function handleName() {    var lastScript = null;    [].forEach(function (elem, idx, arr) {        var script = document.createElement('script');        script.type = 'text/javascript';        script.src = elem;        script.async = false;        document.body.appendChild(script);if (idx === arr.length - 1) {    script.addEventListener('load', function () {        null;    });}    });};</script>");
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List,
   * ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   *
   * <ul>
   *   <li>When {@link ResourceTagAttributes} {@link ResourceTagAttributes#name()} return {@code -}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List,
   * ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddDependencyRestrictionToModel_whenResourceTagAttributesNameReturnDash() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ArrayList<String> files = new ArrayList<>();

    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.includeAsyncDeferUnbundled()).thenReturn(true);
    when(attributes.async()).thenReturn(true);
    when(attributes.bundleDependencyEvent()).thenReturn("Bundle Dependency Event");
    when(attributes.name()).thenReturn("-");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addDependencyRestrictionToModel(files, attributes, context, model);

    // Assert
    verify(attributes, atLeast(1)).async();
    verify(attributes).bundleDependencyEvent();
    verify(attributes, atLeast(1)).includeAsyncDeferUnbundled();
    verify(attributes).name();
    verify(context)
        .createTextElement(
            "<script>function runOnReady(callback, event) {    var watchEvent = typeof(event) == 'undefined' ? 'DOMContentLoaded' : event;    if (document.readyState != 'loading' && !event) {        callback();    } else {        document.addEventListener(watchEvent, callback);    }}; if (typeof(Bundle Dependency EventEvent) !== 'undefined') {    runOnReady(handle_);} else {    runOnReady(function() {            runOnReady(handle_);        },        'Bundle Dependency Event');} function handle_() {    var lastScript = null;    [].forEach(function (elem, idx, arr) {        var script = document.createElement('script');        script.type = 'text/javascript';        script.src = elem;        script.async = true;        document.body.appendChild(script);    });};</script>");
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment, atLeast(1)).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List,
   * ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   *
   * <ul>
   *   <li>When {@link ResourceTagAttributes} {@link ResourceTagAttributes#name()} return {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#addDependencyRestrictionToModel(List,
   * ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundleProcessor.addDependencyRestrictionToModel(List, ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)"
  })
  public void testAddDependencyRestrictionToModel_whenResourceTagAttributesNameReturnDot() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ArrayList<String> files = new ArrayList<>();

    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.includeAsyncDeferUnbundled()).thenReturn(true);
    when(attributes.async()).thenReturn(true);
    when(attributes.bundleDependencyEvent()).thenReturn("Bundle Dependency Event");
    when(attributes.name()).thenReturn(".");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addDependencyRestrictionToModel(files, attributes, context, model);

    // Assert
    verify(attributes, atLeast(1)).async();
    verify(attributes).bundleDependencyEvent();
    verify(attributes, atLeast(1)).includeAsyncDeferUnbundled();
    verify(attributes).name();
    verify(context)
        .createTextElement(
            "<script>function runOnReady(callback, event) {    var watchEvent = typeof(event) == 'undefined' ? 'DOMContentLoaded' : event;    if (document.readyState != 'loading' && !event) {        callback();    } else {        document.addEventListener(watchEvent, callback);    }}; if (typeof(Bundle Dependency EventEvent) !== 'undefined') {    runOnReady(handle_);} else {    runOnReady(function() {            runOnReady(handle_);        },        'Bundle Dependency Event');} function handle_() {    var lastScript = null;    [].forEach(function (elem, idx, arr) {        var script = document.createElement('script');        script.type = 'text/javascript';        script.src = elem;        script.async = true;        document.body.appendChild(script);    });};</script>");
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(environment, atLeast(1)).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>Then return {@code '\_}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_thenReturnApostropheBackslashUnderscore() {
    // Arrange, Act and Assert
    assertEquals("'\\_", resourceBundleProcessor.cleanUpJavaScriptName("'\\."));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>Then return {@code \_'}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_thenReturnBackslashUnderscoreApostrophe() {
    // Arrange, Act and Assert
    assertEquals("\\_'", resourceBundleProcessor.cleanUpJavaScriptName("\\.'"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>Then return {@code \_\_}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_thenReturnBackslashUnderscoreBackslashUnderscore() {
    // Arrange, Act and Assert
    assertEquals("\\_\\_", resourceBundleProcessor.cleanUpJavaScriptName("\\.\\."));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>Then return {@code \_;}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_thenReturnBackslashUnderscoreSemicolon() {
    // Arrange, Act and Assert
    assertEquals("\\_;", resourceBundleProcessor.cleanUpJavaScriptName("\\.;"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>Then return {@code java_lang_StringOriginal}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_thenReturnJavaLangStringOriginal() {
    // Arrange, Act and Assert
    assertEquals(
        "java_lang_StringOriginal",
        resourceBundleProcessor.cleanUpJavaScriptName("java.lang.StringOriginal"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>Then return {@code java_lang_Stringjava_lang_String}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_thenReturnJavaLangStringjavaLangString() {
    // Arrange, Act and Assert
    assertEquals(
        "java_lang_Stringjava_lang_String",
        resourceBundleProcessor.cleanUpJavaScriptName("java.lang.Stringjava.lang.String"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>Then return {@code java_lang_Stringonload}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_thenReturnJavaLangStringonload() {
    // Arrange, Act and Assert
    assertEquals(
        "java_lang_Stringonload",
        resourceBundleProcessor.cleanUpJavaScriptName("java.lang.Stringonload"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>Then return {@code java_lang_Stringscript}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_thenReturnJavaLangStringscript() {
    // Arrange, Act and Assert
    assertEquals(
        "java_lang_Stringscript",
        resourceBundleProcessor.cleanUpJavaScriptName("java.lang.Stringscript"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>Then return {@code java_lang_Stringstylesheet}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_thenReturnJavaLangStringstylesheet() {
    // Arrange, Act and Assert
    assertEquals(
        "java_lang_Stringstylesheet",
        resourceBundleProcessor.cleanUpJavaScriptName("java.lang.Stringstylesheet"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>Then return {@code onloadjava_lang_String}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_thenReturnOnloadjavaLangString() {
    // Arrange, Act and Assert
    assertEquals(
        "onloadjava_lang_String",
        resourceBundleProcessor.cleanUpJavaScriptName("onloadjava.lang.String"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>Then return {@code Originaljava_lang_String}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_thenReturnOriginaljavaLangString() {
    // Arrange, Act and Assert
    assertEquals(
        "Originaljava_lang_String",
        resourceBundleProcessor.cleanUpJavaScriptName("Originaljava.lang.String"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>Then return {@code ;\_}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_thenReturnSemicolonBackslashUnderscore() {
    // Arrange, Act and Assert
    assertEquals(";\\_", resourceBundleProcessor.cleanUpJavaScriptName(";\\."));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code 42.css}.
   *   <li>Then return {@code 42_css}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_when42Css_thenReturn42Css() {
    // Arrange, Act and Assert
    assertEquals("42_css", resourceBundleProcessor.cleanUpJavaScriptName("42.css"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code 42.js}.
   *   <li>Then return {@code 42_js}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_when42Js_thenReturn42Js() {
    // Arrange, Act and Assert
    assertEquals("42_js", resourceBundleProcessor.cleanUpJavaScriptName("42.js"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code -42}.
   *   <li>Then return {@code _42}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("_42", resourceBundleProcessor.cleanUpJavaScriptName("-42"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .42}.
   *   <li>Then return {@code _42}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_when42_thenReturn422() {
    // Arrange, Act and Assert
    assertEquals("_42", resourceBundleProcessor.cleanUpJavaScriptName(".42"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code \.42}.
   *   <li>Then return {@code \_42}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_when42_thenReturn423() {
    // Arrange, Act and Assert
    assertEquals("\\_42", resourceBundleProcessor.cleanUpJavaScriptName("\\.42"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code 42-}.
   *   <li>Then return {@code 42_}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_when42_thenReturn424() {
    // Arrange, Act and Assert
    assertEquals("42_", resourceBundleProcessor.cleanUpJavaScriptName("42-"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code 42.}.
   *   <li>Then return {@code 42_}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_when42_thenReturn425() {
    // Arrange, Act and Assert
    assertEquals("42_", resourceBundleProcessor.cleanUpJavaScriptName("42."));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code 42\.}.
   *   <li>Then return {@code 42\_}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_when42_thenReturn426() {
    // Arrange, Act and Assert
    assertEquals("42\\_", resourceBundleProcessor.cleanUpJavaScriptName("42\\."));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code 42String}.
   *   <li>Then return {@code 42java_lang_String}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_when42javaLangString_thenReturn42javaLangString() {
    // Arrange, Act and Assert
    assertEquals(
        "42java_lang_String", resourceBundleProcessor.cleanUpJavaScriptName("42java.lang.String"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code '-}.
   *   <li>Then return {@code '_}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenApostropheDash_thenReturnApostropheUnderscore() {
    // Arrange, Act and Assert
    assertEquals("'_", resourceBundleProcessor.cleanUpJavaScriptName("'-"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code '.}.
   *   <li>Then return {@code '_}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenApostropheDot_thenReturnApostropheUnderscore() {
    // Arrange, Act and Assert
    assertEquals("'_", resourceBundleProcessor.cleanUpJavaScriptName("'."));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code async.css}.
   *   <li>Then return {@code async_css}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenAsyncCss_thenReturnAsyncCss() {
    // Arrange, Act and Assert
    assertEquals("async_css", resourceBundleProcessor.cleanUpJavaScriptName("async.css"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code async.js}.
   *   <li>Then return {@code async_js}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenAsyncJs_thenReturnAsyncJs() {
    // Arrange, Act and Assert
    assertEquals("async_js", resourceBundleProcessor.cleanUpJavaScriptName("async.js"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code -async}.
   *   <li>Then return {@code _async}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenAsync_thenReturnAsync() {
    // Arrange, Act and Assert
    assertEquals("_async", resourceBundleProcessor.cleanUpJavaScriptName("-async"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .async}.
   *   <li>Then return {@code _async}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenAsync_thenReturnAsync2() {
    // Arrange, Act and Assert
    assertEquals("_async", resourceBundleProcessor.cleanUpJavaScriptName(".async"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code \.async}.
   *   <li>Then return {@code \_async}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenAsync_thenReturnAsync3() {
    // Arrange, Act and Assert
    assertEquals("\\_async", resourceBundleProcessor.cleanUpJavaScriptName("\\.async"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code async-}.
   *   <li>Then return {@code async_}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenAsync_thenReturnAsync4() {
    // Arrange, Act and Assert
    assertEquals("async_", resourceBundleProcessor.cleanUpJavaScriptName("async-"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code async.}.
   *   <li>Then return {@code async_}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenAsync_thenReturnAsync5() {
    // Arrange, Act and Assert
    assertEquals("async_", resourceBundleProcessor.cleanUpJavaScriptName("async."));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code async\.}.
   *   <li>Then return {@code async\_}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenAsync_thenReturnAsync6() {
    // Arrange, Act and Assert
    assertEquals("async\\_", resourceBundleProcessor.cleanUpJavaScriptName("async\\."));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code asyncString}.
   *   <li>Then return {@code asyncjava_lang_String}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenAsyncjavaLangString_thenReturnAsyncjavaLangString() {
    // Arrange, Act and Assert
    assertEquals(
        "asyncjava_lang_String",
        resourceBundleProcessor.cleanUpJavaScriptName("asyncjava.lang.String"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code \.-}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenBackslashDotDash() {
    // Arrange, Act and Assert
    assertEquals("\\__", resourceBundleProcessor.cleanUpJavaScriptName("\\.-"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code \..}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenBackslashDotDot() {
    // Arrange, Act and Assert
    assertEquals("\\__", resourceBundleProcessor.cleanUpJavaScriptName("\\.."));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code \.}.
   *   <li>Then return {@code \_}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenBackslashDot_thenReturnBackslashUnderscore() {
    // Arrange, Act and Assert
    assertEquals("\\_", resourceBundleProcessor.cleanUpJavaScriptName("\\."));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .css42}.
   *   <li>Then return {@code _css42}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenCss42_thenReturnCss42() {
    // Arrange, Act and Assert
    assertEquals("_css42", resourceBundleProcessor.cleanUpJavaScriptName(".css42"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .css.css}.
   *   <li>Then return {@code _css_css}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenCssCss_thenReturnCssCss() {
    // Arrange, Act and Assert
    assertEquals("_css_css", resourceBundleProcessor.cleanUpJavaScriptName(".css.css"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .css.js}.
   *   <li>Then return {@code _css_js}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenCssJs_thenReturnCssJs() {
    // Arrange, Act and Assert
    assertEquals("_css_js", resourceBundleProcessor.cleanUpJavaScriptName(".css.js"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .cssOriginal}.
   *   <li>Then return {@code _cssOriginal}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenCssOriginal_thenReturnCssOriginal() {
    // Arrange, Act and Assert
    assertEquals("_cssOriginal", resourceBundleProcessor.cleanUpJavaScriptName(".cssOriginal"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .css}.
   *   <li>Then return {@code _css}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenCss_thenReturnCss() {
    // Arrange, Act and Assert
    assertEquals("_css", resourceBundleProcessor.cleanUpJavaScriptName(".css"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code -.css}.
   *   <li>Then return {@code __css}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenCss_thenReturnCss2() {
    // Arrange, Act and Assert
    assertEquals("__css", resourceBundleProcessor.cleanUpJavaScriptName("-.css"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code ..css}.
   *   <li>Then return {@code __css}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenCss_thenReturnCss3() {
    // Arrange, Act and Assert
    assertEquals("__css", resourceBundleProcessor.cleanUpJavaScriptName("..css"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code \..css}.
   *   <li>Then return {@code \__css}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenCss_thenReturnCss4() {
    // Arrange, Act and Assert
    assertEquals("\\__css", resourceBundleProcessor.cleanUpJavaScriptName("\\..css"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code '.css}.
   *   <li>Then return {@code '_css}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenCss_thenReturnCss5() {
    // Arrange, Act and Assert
    assertEquals("'_css", resourceBundleProcessor.cleanUpJavaScriptName("'.css"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .css-}.
   *   <li>Then return {@code _css_}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenCss_thenReturnCss6() {
    // Arrange, Act and Assert
    assertEquals("_css_", resourceBundleProcessor.cleanUpJavaScriptName(".css-"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .css.}.
   *   <li>Then return {@code _css_}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenCss_thenReturnCss7() {
    // Arrange, Act and Assert
    assertEquals("_css_", resourceBundleProcessor.cleanUpJavaScriptName(".css."));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .css\.}.
   *   <li>Then return {@code _css\_}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenCss_thenReturnCss8() {
    // Arrange, Act and Assert
    assertEquals("_css\\_", resourceBundleProcessor.cleanUpJavaScriptName(".css\\."));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .css'}.
   *   <li>Then return {@code _css'}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenCss_thenReturnCss9() {
    // Arrange, Act and Assert
    assertEquals("_css'", resourceBundleProcessor.cleanUpJavaScriptName(".css'"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .css;}.
   *   <li>Then return {@code _css;}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenCss_thenReturnCss10() {
    // Arrange, Act and Assert
    assertEquals("_css;", resourceBundleProcessor.cleanUpJavaScriptName(".css;"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code ;.css}.
   *   <li>Then return {@code ;_css}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenCss_thenReturnCss11() {
    // Arrange, Act and Assert
    assertEquals(";_css", resourceBundleProcessor.cleanUpJavaScriptName(";.css"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .cssasync}.
   *   <li>Then return {@code _cssasync}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenCssasync_thenReturnCssasync() {
    // Arrange, Act and Assert
    assertEquals("_cssasync", resourceBundleProcessor.cleanUpJavaScriptName(".cssasync"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .cssString}.
   *   <li>Then return {@code _cssjava_lang_String}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenCssjavaLangString_thenReturnCssjavaLangString() {
    // Arrange, Act and Assert
    assertEquals(
        "_cssjava_lang_String",
        resourceBundleProcessor.cleanUpJavaScriptName(".cssjava.lang.String"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .csslink}.
   *   <li>Then return {@code _csslink}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenCsslink_thenReturnCsslink() {
    // Arrange, Act and Assert
    assertEquals("_csslink", resourceBundleProcessor.cleanUpJavaScriptName(".csslink"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .cssonload}.
   *   <li>Then return {@code _cssonload}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenCssonload_thenReturnCssonload() {
    // Arrange, Act and Assert
    assertEquals("_cssonload", resourceBundleProcessor.cleanUpJavaScriptName(".cssonload"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .cssrel}.
   *   <li>Then return {@code _cssrel}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenCssrel_thenReturnCssrel() {
    // Arrange, Act and Assert
    assertEquals("_cssrel", resourceBundleProcessor.cleanUpJavaScriptName(".cssrel"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .cssscript}.
   *   <li>Then return {@code _cssscript}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenCssscript_thenReturnCssscript() {
    // Arrange, Act and Assert
    assertEquals("_cssscript", resourceBundleProcessor.cleanUpJavaScriptName(".cssscript"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .csssrc}.
   *   <li>Then return {@code _csssrc}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenCsssrc_thenReturnCsssrc() {
    // Arrange, Act and Assert
    assertEquals("_csssrc", resourceBundleProcessor.cleanUpJavaScriptName(".csssrc"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .cssstylesheet}.
   *   <li>Then return {@code _cssstylesheet}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenCssstylesheet_thenReturnCssstylesheet() {
    // Arrange, Act and Assert
    assertEquals("_cssstylesheet", resourceBundleProcessor.cleanUpJavaScriptName(".cssstylesheet"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code -'}.
   *   <li>Then return {@code _'}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenDashApostrophe_thenReturnUnderscoreApostrophe() {
    // Arrange, Act and Assert
    assertEquals("_'", resourceBundleProcessor.cleanUpJavaScriptName("-'"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code -\.}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenDashBackslashDot() {
    // Arrange, Act and Assert
    assertEquals("_\\_", resourceBundleProcessor.cleanUpJavaScriptName("-\\."));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code --}.
   *   <li>Then return {@code __}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenDashDash_thenReturnUnderscoreUnderscore() {
    // Arrange, Act and Assert
    assertEquals("__", resourceBundleProcessor.cleanUpJavaScriptName("--"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code -.}.
   *   <li>Then return {@code __}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenDashDot_thenReturnUnderscoreUnderscore() {
    // Arrange, Act and Assert
    assertEquals("__", resourceBundleProcessor.cleanUpJavaScriptName("-."));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code -;}.
   *   <li>Then return {@code _;}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenDashSemicolon_thenReturnUnderscoreSemicolon() {
    // Arrange, Act and Assert
    assertEquals("_;", resourceBundleProcessor.cleanUpJavaScriptName("-;"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code -_}.
   *   <li>Then return {@code __}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenDashUnderscore_thenReturnUnderscoreUnderscore() {
    // Arrange, Act and Assert
    assertEquals("__", resourceBundleProcessor.cleanUpJavaScriptName("-_"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code -}.
   *   <li>Then return {@code _}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenDash_thenReturnUnderscore() {
    // Arrange, Act and Assert
    assertEquals("_", resourceBundleProcessor.cleanUpJavaScriptName("-"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .'}.
   *   <li>Then return {@code _'}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenDotApostrophe_thenReturnUnderscoreApostrophe() {
    // Arrange, Act and Assert
    assertEquals("_'", resourceBundleProcessor.cleanUpJavaScriptName(".'"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .\.}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenDotBackslashDot() {
    // Arrange, Act and Assert
    assertEquals("_\\_", resourceBundleProcessor.cleanUpJavaScriptName(".\\."));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .-}.
   *   <li>Then return {@code __}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenDotDash_thenReturnUnderscoreUnderscore() {
    // Arrange, Act and Assert
    assertEquals("__", resourceBundleProcessor.cleanUpJavaScriptName(".-"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code ..}.
   *   <li>Then return {@code __}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenDotDot_thenReturnUnderscoreUnderscore() {
    // Arrange, Act and Assert
    assertEquals("__", resourceBundleProcessor.cleanUpJavaScriptName(".."));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .;}.
   *   <li>Then return {@code _;}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenDotSemicolon_thenReturnUnderscoreSemicolon() {
    // Arrange, Act and Assert
    assertEquals("_;", resourceBundleProcessor.cleanUpJavaScriptName(".;"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .}.
   *   <li>Then return {@code _}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenDot_thenReturnUnderscore() {
    // Arrange, Act and Assert
    assertEquals("_", resourceBundleProcessor.cleanUpJavaScriptName("."));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code String42}.
   *   <li>Then return {@code java_lang_String42}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJavaLangString42_thenReturnJavaLangString42() {
    // Arrange, Act and Assert
    assertEquals(
        "java_lang_String42", resourceBundleProcessor.cleanUpJavaScriptName("java.lang.String42"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code String.css}.
   *   <li>Then return {@code java_lang_String_css}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJavaLangStringCss_thenReturnJavaLangStringCss() {
    // Arrange, Act and Assert
    assertEquals(
        "java_lang_String_css",
        resourceBundleProcessor.cleanUpJavaScriptName("java.lang.String.css"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code String.js}.
   *   <li>Then return {@code java_lang_String_js}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJavaLangStringJs_thenReturnJavaLangStringJs() {
    // Arrange, Act and Assert
    assertEquals(
        "java_lang_String_js",
        resourceBundleProcessor.cleanUpJavaScriptName("java.lang.String.js"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then return {@code java_lang_String}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJavaLangString_thenReturnJavaLangString() {
    // Arrange, Act and Assert
    assertEquals(
        "java_lang_String", resourceBundleProcessor.cleanUpJavaScriptName("java.lang.String"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code -String}.
   *   <li>Then return {@code _java_lang_String}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJavaLangString_thenReturnJavaLangString2() {
    // Arrange, Act and Assert
    assertEquals(
        "_java_lang_String", resourceBundleProcessor.cleanUpJavaScriptName("-java.lang.String"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .String}.
   *   <li>Then return {@code _java_lang_String}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJavaLangString_thenReturnJavaLangString3() {
    // Arrange, Act and Assert
    assertEquals(
        "_java_lang_String", resourceBundleProcessor.cleanUpJavaScriptName(".java.lang.String"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code \.String}.
   *   <li>Then return {@code \_java_lang_String}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJavaLangString_thenReturnJavaLangString4() {
    // Arrange, Act and Assert
    assertEquals(
        "\\_java_lang_String",
        resourceBundleProcessor.cleanUpJavaScriptName("\\.java.lang.String"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code 'String}.
   *   <li>Then return {@code 'java_lang_String}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJavaLangString_thenReturnJavaLangString5() {
    // Arrange, Act and Assert
    assertEquals(
        "'java_lang_String", resourceBundleProcessor.cleanUpJavaScriptName("'java.lang.String"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code ;String}.
   *   <li>Then return {@code ;java_lang_String}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJavaLangString_thenReturnJavaLangString6() {
    // Arrange, Act and Assert
    assertEquals(
        ";java_lang_String", resourceBundleProcessor.cleanUpJavaScriptName(";java.lang.String"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code String-}.
   *   <li>Then return {@code java_lang_String_}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJavaLangString_thenReturnJavaLangString7() {
    // Arrange, Act and Assert
    assertEquals(
        "java_lang_String_", resourceBundleProcessor.cleanUpJavaScriptName("java.lang.String-"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code String.}.
   *   <li>Then return {@code java_lang_String_}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJavaLangString_thenReturnJavaLangString8() {
    // Arrange, Act and Assert
    assertEquals(
        "java_lang_String_", resourceBundleProcessor.cleanUpJavaScriptName("java.lang.String."));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code String\.}.
   *   <li>Then return {@code java_lang_String\_}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJavaLangString_thenReturnJavaLangString9() {
    // Arrange, Act and Assert
    assertEquals(
        "java_lang_String\\_",
        resourceBundleProcessor.cleanUpJavaScriptName("java.lang.String\\."));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code String'}.
   *   <li>Then return {@code java_lang_String'}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJavaLangString_thenReturnJavaLangString10() {
    // Arrange, Act and Assert
    assertEquals(
        "java_lang_String'", resourceBundleProcessor.cleanUpJavaScriptName("java.lang.String'"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code String;}.
   *   <li>Then return {@code java_lang_String;}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJavaLangString_thenReturnJavaLangString11() {
    // Arrange, Act and Assert
    assertEquals(
        "java_lang_String;", resourceBundleProcessor.cleanUpJavaScriptName("java.lang.String;"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code Stringasync}.
   *   <li>Then return {@code java_lang_Stringasync}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJavaLangStringasync_thenReturnJavaLangStringasync() {
    // Arrange, Act and Assert
    assertEquals(
        "java_lang_Stringasync",
        resourceBundleProcessor.cleanUpJavaScriptName("java.lang.Stringasync"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code Stringlink}.
   *   <li>Then return {@code java_lang_Stringlink}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJavaLangStringlink_thenReturnJavaLangStringlink() {
    // Arrange, Act and Assert
    assertEquals(
        "java_lang_Stringlink",
        resourceBundleProcessor.cleanUpJavaScriptName("java.lang.Stringlink"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code Stringrel}.
   *   <li>Then return {@code java_lang_Stringrel}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJavaLangStringrel_thenReturnJavaLangStringrel() {
    // Arrange, Act and Assert
    assertEquals(
        "java_lang_Stringrel",
        resourceBundleProcessor.cleanUpJavaScriptName("java.lang.Stringrel"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code Stringsrc}.
   *   <li>Then return {@code java_lang_Stringsrc}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJavaLangStringsrc_thenReturnJavaLangStringsrc() {
    // Arrange, Act and Assert
    assertEquals(
        "java_lang_Stringsrc",
        resourceBundleProcessor.cleanUpJavaScriptName("java.lang.Stringsrc"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .js42}.
   *   <li>Then return {@code _js42}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJs42_thenReturnJs42() {
    // Arrange, Act and Assert
    assertEquals("_js42", resourceBundleProcessor.cleanUpJavaScriptName(".js42"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .js.css}.
   *   <li>Then return {@code _js_css}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJsCss_thenReturnJsCss() {
    // Arrange, Act and Assert
    assertEquals("_js_css", resourceBundleProcessor.cleanUpJavaScriptName(".js.css"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .js.js}.
   *   <li>Then return {@code _js_js}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJsJs_thenReturnJsJs() {
    // Arrange, Act and Assert
    assertEquals("_js_js", resourceBundleProcessor.cleanUpJavaScriptName(".js.js"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .jsOriginal}.
   *   <li>Then return {@code _jsOriginal}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJsOriginal_thenReturnJsOriginal() {
    // Arrange, Act and Assert
    assertEquals("_jsOriginal", resourceBundleProcessor.cleanUpJavaScriptName(".jsOriginal"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .js}.
   *   <li>Then return {@code _js}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJs_thenReturnJs() {
    // Arrange, Act and Assert
    assertEquals("_js", resourceBundleProcessor.cleanUpJavaScriptName(".js"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code -.js}.
   *   <li>Then return {@code __js}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJs_thenReturnJs2() {
    // Arrange, Act and Assert
    assertEquals("__js", resourceBundleProcessor.cleanUpJavaScriptName("-.js"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code ..js}.
   *   <li>Then return {@code __js}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJs_thenReturnJs3() {
    // Arrange, Act and Assert
    assertEquals("__js", resourceBundleProcessor.cleanUpJavaScriptName("..js"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code \..js}.
   *   <li>Then return {@code \__js}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJs_thenReturnJs4() {
    // Arrange, Act and Assert
    assertEquals("\\__js", resourceBundleProcessor.cleanUpJavaScriptName("\\..js"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code '.js}.
   *   <li>Then return {@code '_js}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJs_thenReturnJs5() {
    // Arrange, Act and Assert
    assertEquals("'_js", resourceBundleProcessor.cleanUpJavaScriptName("'.js"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .js-}.
   *   <li>Then return {@code _js_}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJs_thenReturnJs6() {
    // Arrange, Act and Assert
    assertEquals("_js_", resourceBundleProcessor.cleanUpJavaScriptName(".js-"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .js.}.
   *   <li>Then return {@code _js_}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJs_thenReturnJs7() {
    // Arrange, Act and Assert
    assertEquals("_js_", resourceBundleProcessor.cleanUpJavaScriptName(".js."));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .js\.}.
   *   <li>Then return {@code _js\_}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJs_thenReturnJs8() {
    // Arrange, Act and Assert
    assertEquals("_js\\_", resourceBundleProcessor.cleanUpJavaScriptName(".js\\."));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .js'}.
   *   <li>Then return {@code _js'}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJs_thenReturnJs9() {
    // Arrange, Act and Assert
    assertEquals("_js'", resourceBundleProcessor.cleanUpJavaScriptName(".js'"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .js;}.
   *   <li>Then return {@code _js;}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJs_thenReturnJs10() {
    // Arrange, Act and Assert
    assertEquals("_js;", resourceBundleProcessor.cleanUpJavaScriptName(".js;"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code ;.js}.
   *   <li>Then return {@code ;_js}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJs_thenReturnJs11() {
    // Arrange, Act and Assert
    assertEquals(";_js", resourceBundleProcessor.cleanUpJavaScriptName(";.js"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .jsasync}.
   *   <li>Then return {@code _jsasync}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJsasync_thenReturnJsasync() {
    // Arrange, Act and Assert
    assertEquals("_jsasync", resourceBundleProcessor.cleanUpJavaScriptName(".jsasync"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .jsString}.
   *   <li>Then return {@code _jsjava_lang_String}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJsjavaLangString_thenReturnJsjavaLangString() {
    // Arrange, Act and Assert
    assertEquals(
        "_jsjava_lang_String",
        resourceBundleProcessor.cleanUpJavaScriptName(".jsjava.lang.String"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .jslink}.
   *   <li>Then return {@code _jslink}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJslink_thenReturnJslink() {
    // Arrange, Act and Assert
    assertEquals("_jslink", resourceBundleProcessor.cleanUpJavaScriptName(".jslink"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .jsonload}.
   *   <li>Then return {@code _jsonload}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJsonload_thenReturnJsonload() {
    // Arrange, Act and Assert
    assertEquals("_jsonload", resourceBundleProcessor.cleanUpJavaScriptName(".jsonload"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .jsrel}.
   *   <li>Then return {@code _jsrel}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJsrel_thenReturnJsrel() {
    // Arrange, Act and Assert
    assertEquals("_jsrel", resourceBundleProcessor.cleanUpJavaScriptName(".jsrel"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .jsscript}.
   *   <li>Then return {@code _jsscript}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJsscript_thenReturnJsscript() {
    // Arrange, Act and Assert
    assertEquals("_jsscript", resourceBundleProcessor.cleanUpJavaScriptName(".jsscript"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .jssrc}.
   *   <li>Then return {@code _jssrc}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJssrc_thenReturnJssrc() {
    // Arrange, Act and Assert
    assertEquals("_jssrc", resourceBundleProcessor.cleanUpJavaScriptName(".jssrc"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .jsstylesheet}.
   *   <li>Then return {@code _jsstylesheet}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenJsstylesheet_thenReturnJsstylesheet() {
    // Arrange, Act and Assert
    assertEquals("_jsstylesheet", resourceBundleProcessor.cleanUpJavaScriptName(".jsstylesheet"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code link.css}.
   *   <li>Then return {@code link_css}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenLinkCss_thenReturnLinkCss() {
    // Arrange, Act and Assert
    assertEquals("link_css", resourceBundleProcessor.cleanUpJavaScriptName("link.css"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code link.js}.
   *   <li>Then return {@code link_js}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenLinkJs_thenReturnLinkJs() {
    // Arrange, Act and Assert
    assertEquals("link_js", resourceBundleProcessor.cleanUpJavaScriptName("link.js"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code -link}.
   *   <li>Then return {@code _link}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenLink_thenReturnLink() {
    // Arrange, Act and Assert
    assertEquals("_link", resourceBundleProcessor.cleanUpJavaScriptName("-link"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .link}.
   *   <li>Then return {@code _link}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenLink_thenReturnLink2() {
    // Arrange, Act and Assert
    assertEquals("_link", resourceBundleProcessor.cleanUpJavaScriptName(".link"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code \.link}.
   *   <li>Then return {@code \_link}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenLink_thenReturnLink3() {
    // Arrange, Act and Assert
    assertEquals("\\_link", resourceBundleProcessor.cleanUpJavaScriptName("\\.link"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code link-}.
   *   <li>Then return {@code link_}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenLink_thenReturnLink4() {
    // Arrange, Act and Assert
    assertEquals("link_", resourceBundleProcessor.cleanUpJavaScriptName("link-"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code link.}.
   *   <li>Then return {@code link_}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenLink_thenReturnLink5() {
    // Arrange, Act and Assert
    assertEquals("link_", resourceBundleProcessor.cleanUpJavaScriptName("link."));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code link\.}.
   *   <li>Then return {@code link\_}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenLink_thenReturnLink6() {
    // Arrange, Act and Assert
    assertEquals("link\\_", resourceBundleProcessor.cleanUpJavaScriptName("link\\."));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code linkString}.
   *   <li>Then return {@code linkjava_lang_String}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenLinkjavaLangString_thenReturnLinkjavaLangString() {
    // Arrange, Act and Assert
    assertEquals(
        "linkjava_lang_String",
        resourceBundleProcessor.cleanUpJavaScriptName("linkjava.lang.String"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code onload.css}.
   *   <li>Then return {@code onload_css}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenOnloadCss_thenReturnOnloadCss() {
    // Arrange, Act and Assert
    assertEquals("onload_css", resourceBundleProcessor.cleanUpJavaScriptName("onload.css"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code onload.js}.
   *   <li>Then return {@code onload_js}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenOnloadJs_thenReturnOnloadJs() {
    // Arrange, Act and Assert
    assertEquals("onload_js", resourceBundleProcessor.cleanUpJavaScriptName("onload.js"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code -onload}.
   *   <li>Then return {@code _onload}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenOnload_thenReturnOnload() {
    // Arrange, Act and Assert
    assertEquals("_onload", resourceBundleProcessor.cleanUpJavaScriptName("-onload"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .onload}.
   *   <li>Then return {@code _onload}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenOnload_thenReturnOnload2() {
    // Arrange, Act and Assert
    assertEquals("_onload", resourceBundleProcessor.cleanUpJavaScriptName(".onload"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code \.onload}.
   *   <li>Then return {@code \_onload}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenOnload_thenReturnOnload3() {
    // Arrange, Act and Assert
    assertEquals("\\_onload", resourceBundleProcessor.cleanUpJavaScriptName("\\.onload"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code onload-}.
   *   <li>Then return {@code onload_}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenOnload_thenReturnOnload4() {
    // Arrange, Act and Assert
    assertEquals("onload_", resourceBundleProcessor.cleanUpJavaScriptName("onload-"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code onload.}.
   *   <li>Then return {@code onload_}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenOnload_thenReturnOnload5() {
    // Arrange, Act and Assert
    assertEquals("onload_", resourceBundleProcessor.cleanUpJavaScriptName("onload."));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code onload\.}.
   *   <li>Then return {@code onload\_}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenOnload_thenReturnOnload6() {
    // Arrange, Act and Assert
    assertEquals("onload\\_", resourceBundleProcessor.cleanUpJavaScriptName("onload\\."));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code Original.css}.
   *   <li>Then return {@code Original_css}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenOriginalCss_thenReturnOriginalCss() {
    // Arrange, Act and Assert
    assertEquals("Original_css", resourceBundleProcessor.cleanUpJavaScriptName("Original.css"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code Original.js}.
   *   <li>Then return {@code Original_js}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenOriginalJs_thenReturnOriginalJs() {
    // Arrange, Act and Assert
    assertEquals("Original_js", resourceBundleProcessor.cleanUpJavaScriptName("Original.js"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code Original}.
   *   <li>Then return {@code Original}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenOriginal_thenReturnOriginal() {
    // Arrange, Act and Assert
    assertEquals("Original", resourceBundleProcessor.cleanUpJavaScriptName("Original"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code -Original}.
   *   <li>Then return {@code _Original}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenOriginal_thenReturnOriginal2() {
    // Arrange, Act and Assert
    assertEquals("_Original", resourceBundleProcessor.cleanUpJavaScriptName("-Original"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .Original}.
   *   <li>Then return {@code _Original}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenOriginal_thenReturnOriginal3() {
    // Arrange, Act and Assert
    assertEquals("_Original", resourceBundleProcessor.cleanUpJavaScriptName(".Original"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code \.Original}.
   *   <li>Then return {@code \_Original}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenOriginal_thenReturnOriginal4() {
    // Arrange, Act and Assert
    assertEquals("\\_Original", resourceBundleProcessor.cleanUpJavaScriptName("\\.Original"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code Original-}.
   *   <li>Then return {@code Original_}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenOriginal_thenReturnOriginal5() {
    // Arrange, Act and Assert
    assertEquals("Original_", resourceBundleProcessor.cleanUpJavaScriptName("Original-"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code Original.}.
   *   <li>Then return {@code Original_}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenOriginal_thenReturnOriginal6() {
    // Arrange, Act and Assert
    assertEquals("Original_", resourceBundleProcessor.cleanUpJavaScriptName("Original."));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code Original\.}.
   *   <li>Then return {@code Original\_}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenOriginal_thenReturnOriginal7() {
    // Arrange, Act and Assert
    assertEquals("Original\\_", resourceBundleProcessor.cleanUpJavaScriptName("Original\\."));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code rel.css}.
   *   <li>Then return {@code rel_css}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenRelCss_thenReturnRelCss() {
    // Arrange, Act and Assert
    assertEquals("rel_css", resourceBundleProcessor.cleanUpJavaScriptName("rel.css"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code rel.js}.
   *   <li>Then return {@code rel_js}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenRelJs_thenReturnRelJs() {
    // Arrange, Act and Assert
    assertEquals("rel_js", resourceBundleProcessor.cleanUpJavaScriptName("rel.js"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code -rel}.
   *   <li>Then return {@code _rel}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenRel_thenReturnRel() {
    // Arrange, Act and Assert
    assertEquals("_rel", resourceBundleProcessor.cleanUpJavaScriptName("-rel"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .rel}.
   *   <li>Then return {@code _rel}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenRel_thenReturnRel2() {
    // Arrange, Act and Assert
    assertEquals("_rel", resourceBundleProcessor.cleanUpJavaScriptName(".rel"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code \.rel}.
   *   <li>Then return {@code \_rel}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenRel_thenReturnRel3() {
    // Arrange, Act and Assert
    assertEquals("\\_rel", resourceBundleProcessor.cleanUpJavaScriptName("\\.rel"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code rel-}.
   *   <li>Then return {@code rel_}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenRel_thenReturnRel4() {
    // Arrange, Act and Assert
    assertEquals("rel_", resourceBundleProcessor.cleanUpJavaScriptName("rel-"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code rel.}.
   *   <li>Then return {@code rel_}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenRel_thenReturnRel5() {
    // Arrange, Act and Assert
    assertEquals("rel_", resourceBundleProcessor.cleanUpJavaScriptName("rel."));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code rel\.}.
   *   <li>Then return {@code rel\_}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenRel_thenReturnRel6() {
    // Arrange, Act and Assert
    assertEquals("rel\\_", resourceBundleProcessor.cleanUpJavaScriptName("rel\\."));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code relString}.
   *   <li>Then return {@code reljava_lang_String}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenReljavaLangString_thenReturnReljavaLangString() {
    // Arrange, Act and Assert
    assertEquals(
        "reljava_lang_String",
        resourceBundleProcessor.cleanUpJavaScriptName("reljava.lang.String"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code -script}.
   *   <li>Then return {@code _script}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenScript_thenReturnScript() {
    // Arrange, Act and Assert
    assertEquals("_script", resourceBundleProcessor.cleanUpJavaScriptName("-script"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .script}.
   *   <li>Then return {@code _script}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenScript_thenReturnScript2() {
    // Arrange, Act and Assert
    assertEquals("_script", resourceBundleProcessor.cleanUpJavaScriptName(".script"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code \.script}.
   *   <li>Then return {@code \_script}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenScript_thenReturnScript3() {
    // Arrange, Act and Assert
    assertEquals("\\_script", resourceBundleProcessor.cleanUpJavaScriptName("\\.script"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code ;-}.
   *   <li>Then return {@code ;_}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenSemicolonDash_thenReturnSemicolonUnderscore() {
    // Arrange, Act and Assert
    assertEquals(";_", resourceBundleProcessor.cleanUpJavaScriptName(";-"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code ;.}.
   *   <li>Then return {@code ;_}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenSemicolonDot_thenReturnSemicolonUnderscore() {
    // Arrange, Act and Assert
    assertEquals(";_", resourceBundleProcessor.cleanUpJavaScriptName(";."));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenSlash_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", resourceBundleProcessor.cleanUpJavaScriptName("/"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code -src}.
   *   <li>Then return {@code _src}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenSrc_thenReturnSrc() {
    // Arrange, Act and Assert
    assertEquals("_src", resourceBundleProcessor.cleanUpJavaScriptName("-src"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .src}.
   *   <li>Then return {@code _src}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenSrc_thenReturnSrc2() {
    // Arrange, Act and Assert
    assertEquals("_src", resourceBundleProcessor.cleanUpJavaScriptName(".src"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code \.src}.
   *   <li>Then return {@code \_src}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenSrc_thenReturnSrc3() {
    // Arrange, Act and Assert
    assertEquals("\\_src", resourceBundleProcessor.cleanUpJavaScriptName("\\.src"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code -stylesheet}.
   *   <li>Then return {@code _stylesheet}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenStylesheet_thenReturnStylesheet() {
    // Arrange, Act and Assert
    assertEquals("_stylesheet", resourceBundleProcessor.cleanUpJavaScriptName("-stylesheet"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code .stylesheet}.
   *   <li>Then return {@code _stylesheet}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenStylesheet_thenReturnStylesheet2() {
    // Arrange, Act and Assert
    assertEquals("_stylesheet", resourceBundleProcessor.cleanUpJavaScriptName(".stylesheet"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code \.stylesheet}.
   *   <li>Then return {@code \_stylesheet}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenStylesheet_thenReturnStylesheet3() {
    // Arrange, Act and Assert
    assertEquals("\\_stylesheet", resourceBundleProcessor.cleanUpJavaScriptName("\\.stylesheet"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   *
   * <ul>
   *   <li>When {@code _-}.
   *   <li>Then return {@code __}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundleProcessor.cleanUpJavaScriptName(String)"})
  public void testCleanUpJavaScriptName_whenUnderscoreDash_thenReturnUnderscoreUnderscore() {
    // Arrange, Act and Assert
    assertEquals("__", resourceBundleProcessor.cleanUpJavaScriptName("_-"));
  }

  /**
   * Test {@link ResourceBundleProcessor#getScriptAttributes(String, boolean, boolean)} with {@code
   * src}, {@code async}, {@code defer}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#getScriptAttributes(String, boolean,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ResourceBundleProcessor.getScriptAttributes(String, boolean, boolean)"})
  public void testGetScriptAttributesWithSrcAsyncDefer_thenReturnSizeIsTwo() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    // Act
    Map<String, String> actualScriptAttributes =
        resourceBundleProcessor.getScriptAttributes("Src", true, true);

    // Assert
    verify(environment).getProperty("bundle.enabled");
    assertEquals(2, actualScriptAttributes.size());
    assertEquals("Src", actualScriptAttributes.get("src"));
    assertEquals("text/javascript", actualScriptAttributes.get("type"));
  }

  /**
   * Test {@link ResourceBundleProcessor#getScriptAttributes(String, boolean, boolean)} with {@code
   * src}, {@code async}, {@code defer}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#getScriptAttributes(String, boolean,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ResourceBundleProcessor.getScriptAttributes(String, boolean, boolean)"})
  public void testGetScriptAttributesWithSrcAsyncDefer_thenThrowIllegalArgumentException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.getScriptAttributes("Src", true, true));
    verify(environment).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#getScriptAttributes(ResourceTagAttributes)} with {@code
   * tagAttributes}.
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#getScriptAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ResourceBundleProcessor.getScriptAttributes(ResourceTagAttributes)"})
  public void testGetScriptAttributesWithTagAttributes() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ResourceTagAttributes tagAttributes = mock(ResourceTagAttributes.class);
    when(tagAttributes.includeAsyncDeferUnbundled()).thenReturn(false);
    when(tagAttributes.src()).thenReturn("Src");

    // Act
    Map<String, String> actualScriptAttributes =
        resourceBundleProcessor.getScriptAttributes(tagAttributes);

    // Assert
    verify(tagAttributes).includeAsyncDeferUnbundled();
    verify(tagAttributes).src();
    verify(environment).getProperty("bundle.enabled");
    assertEquals(2, actualScriptAttributes.size());
    assertEquals("Src", actualScriptAttributes.get("src"));
    assertEquals("text/javascript", actualScriptAttributes.get("type"));
  }

  /**
   * Test {@link ResourceBundleProcessor#getScriptAttributes(ResourceTagAttributes)} with {@code
   * tagAttributes}.
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#getScriptAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ResourceBundleProcessor.getScriptAttributes(ResourceTagAttributes)"})
  public void testGetScriptAttributesWithTagAttributes2() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ResourceTagAttributes tagAttributes = mock(ResourceTagAttributes.class);
    when(tagAttributes.async()).thenReturn(false);
    when(tagAttributes.defer()).thenReturn(false);
    when(tagAttributes.includeAsyncDeferUnbundled()).thenReturn(true);
    when(tagAttributes.src()).thenReturn("Src");

    // Act
    Map<String, String> actualScriptAttributes =
        resourceBundleProcessor.getScriptAttributes(tagAttributes);

    // Assert
    verify(tagAttributes).async();
    verify(tagAttributes).defer();
    verify(tagAttributes).includeAsyncDeferUnbundled();
    verify(tagAttributes).src();
    verify(environment).getProperty("bundle.enabled");
    assertEquals(2, actualScriptAttributes.size());
    assertEquals("Src", actualScriptAttributes.get("src"));
    assertEquals("text/javascript", actualScriptAttributes.get("type"));
  }

  /**
   * Test {@link ResourceBundleProcessor#getScriptAttributes(ResourceTagAttributes)} with {@code
   * tagAttributes}.
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#getScriptAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ResourceBundleProcessor.getScriptAttributes(ResourceTagAttributes)"})
  public void testGetScriptAttributesWithTagAttributes3() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ResourceTagAttributes tagAttributes = new ResourceTagAttributes(new ResourceTagAttributes());
    tagAttributes.includeAsyncDeferUnbundled(true);
    tagAttributes.async(false);
    tagAttributes.defer(false);

    // Act
    Map<String, String> actualScriptAttributes =
        resourceBundleProcessor.getScriptAttributes(tagAttributes);

    // Assert
    verify(environment).getProperty("bundle.enabled");
    assertEquals(2, actualScriptAttributes.size());
    assertEquals("text/javascript", actualScriptAttributes.get("type"));
    assertNull(actualScriptAttributes.get("src"));
  }

  /**
   * Test {@link ResourceBundleProcessor#getScriptAttributes(ResourceTagAttributes)} with {@code
   * tagAttributes}.
   *
   * <ul>
   *   <li>Then return size is four.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#getScriptAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    Map<String, String> actualScriptAttributes =
        resourceBundleProcessor.getScriptAttributes(tagAttributes);

    // Assert
    verify(tagAttributes).async();
    verify(tagAttributes).defer();
    verify(tagAttributes).includeAsyncDeferUnbundled();
    verify(tagAttributes).src();
    verify(environment).getProperty("bundle.enabled");
    assertEquals(4, actualScriptAttributes.size());
    assertEquals("Src", actualScriptAttributes.get("src"));
    assertNull(actualScriptAttributes.get("async"));
    assertNull(actualScriptAttributes.get("defer"));
    assertTrue(actualScriptAttributes.containsKey("type"));
  }

  /**
   * Test {@link ResourceBundleProcessor#getScriptAttributes(ResourceTagAttributes)} with {@code
   * tagAttributes}.
   *
   * <ul>
   *   <li>Then return {@code src} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#getScriptAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ResourceBundleProcessor.getScriptAttributes(ResourceTagAttributes)"})
  public void testGetScriptAttributesWithTagAttributes_thenReturnSrcIsNull() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    // Act
    Map<String, String> actualScriptAttributes =
        resourceBundleProcessor.getScriptAttributes(new ResourceTagAttributes());

    // Assert
    verify(environment).getProperty("bundle.enabled");
    assertEquals(2, actualScriptAttributes.size());
    assertEquals("text/javascript", actualScriptAttributes.get("type"));
    assertNull(actualScriptAttributes.get("src"));
  }

  /**
   * Test {@link ResourceBundleProcessor#getScriptAttributes(ResourceTagAttributes)} with {@code
   * tagAttributes}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#getScriptAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ResourceBundleProcessor.getScriptAttributes(ResourceTagAttributes)"})
  public void testGetScriptAttributesWithTagAttributes_thenThrowIllegalArgumentException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.getScriptAttributes(new ResourceTagAttributes()));
    verify(environment).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#getLinkAttributes(String)}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#getLinkAttributes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@code Src}.
   *   <li>Then return {@code href} is {@code Src}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#getNormalCssAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ResourceBundleProcessor.getNormalCssAttributes(ResourceTagAttributes)"})
  public void testGetNormalCssAttributes_givenSrc_thenReturnHrefIsSrc() {
    // Arrange
    ResourceTagAttributes tagAttributes = mock(ResourceTagAttributes.class);
    when(tagAttributes.src()).thenReturn("Src");

    // Act
    Map<String, String> actualNormalCssAttributes =
        resourceBundleProcessor.getNormalCssAttributes(tagAttributes);

    // Assert
    verify(tagAttributes).src();
    assertEquals(2, actualNormalCssAttributes.size());
    assertEquals("Src", actualNormalCssAttributes.get("href"));
    assertEquals("stylesheet", actualNormalCssAttributes.get("rel"));
  }

  /**
   * Test {@link ResourceBundleProcessor#getNormalCssAttributes(ResourceTagAttributes)}.
   *
   * <ul>
   *   <li>When {@link ResourceTagAttributes#ResourceTagAttributes()}.
   *   <li>Then return {@code href} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#getNormalCssAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ResourceBundleProcessor.getNormalCssAttributes(ResourceTagAttributes)"})
  public void testGetNormalCssAttributes_whenResourceTagAttributes_thenReturnHrefIsNull() {
    // Arrange and Act
    Map<String, String> actualNormalCssAttributes =
        resourceBundleProcessor.getNormalCssAttributes(new ResourceTagAttributes());

    // Assert
    assertEquals(2, actualNormalCssAttributes.size());
    assertEquals("stylesheet", actualNormalCssAttributes.get("rel"));
    assertNull(actualNormalCssAttributes.get("href"));
  }

  /**
   * Test {@link ResourceBundleProcessor#useAsyncJavaScript(ResourceTagAttributes)}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#useAsyncJavaScript(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ResourceBundleProcessor.useAsyncJavaScript(ResourceTagAttributes)"})
  public void testUseAsyncJavaScript() {
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
    verify(environment).getProperty("bundle.enabled");
    assertFalse(actualUseAsyncJavaScriptResult);
  }

  /**
   * Test {@link ResourceBundleProcessor#useAsyncJavaScript(ResourceTagAttributes)}.
   *
   * <p>Method under test: {@link ResourceBundleProcessor#useAsyncJavaScript(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ResourceBundleProcessor.useAsyncJavaScript(ResourceTagAttributes)"})
  public void testUseAsyncJavaScript2() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.async(true);
    attributes.includeAsyncDeferUnbundled(false);

    // Act
    boolean actualUseAsyncJavaScriptResult = resourceBundleProcessor.useAsyncJavaScript(attributes);

    // Assert
    verify(environment).getProperty("bundle.enabled");
    assertFalse(actualUseAsyncJavaScriptResult);
  }

  /**
   * Test {@link ResourceBundleProcessor#useAsyncJavaScript(ResourceTagAttributes)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link ResourceTagAttributes} {@link ResourceTagAttributes#async()} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#useAsyncJavaScript(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ResourceBundleProcessor.useAsyncJavaScript(ResourceTagAttributes)"})
  public void testUseAsyncJavaScript_givenFalse_whenResourceTagAttributesAsyncReturnFalse() {
    // Arrange
    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.async()).thenReturn(false);

    // Act
    boolean actualUseAsyncJavaScriptResult = resourceBundleProcessor.useAsyncJavaScript(attributes);

    // Assert
    verify(attributes).async();
    assertFalse(actualUseAsyncJavaScriptResult);
  }

  /**
   * Test {@link ResourceBundleProcessor#useAsyncJavaScript(ResourceTagAttributes)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#useAsyncJavaScript(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    verify(environment).getProperty("bundle.enabled");
    assertTrue(actualUseAsyncJavaScriptResult);
  }

  /**
   * Test {@link ResourceBundleProcessor#useAsyncJavaScript(ResourceTagAttributes)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#useAsyncJavaScript(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ResourceBundleProcessor.useAsyncJavaScript(ResourceTagAttributes)"})
  public void testUseAsyncJavaScript_thenThrowIllegalArgumentException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.async()).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.useAsyncJavaScript(attributes));
    verify(attributes).async();
    verify(environment).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#useAsyncJavaScript(ResourceTagAttributes)}.
   *
   * <ul>
   *   <li>When {@link ResourceTagAttributes#ResourceTagAttributes()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundleProcessor#useAsyncJavaScript(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ResourceBundleProcessor.useAsyncJavaScript(ResourceTagAttributes)"})
  public void testUseAsyncJavaScript_whenResourceTagAttributes_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(resourceBundleProcessor.useAsyncJavaScript(new ResourceTagAttributes()));
  }

  /**
   * Test {@link ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}.
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceBundleProcessor.validateTagAttributes(ResourceTagAttributes)"})
  public void testValidateTagAttributes() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle =
        new ResourcesRequestBundle(
            "Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);

    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.name(".js");
    attributes.bundleDependencyEvent(null);
    attributes.bundleCompletedEvent(null);
    attributes.mappingPrefix(null);
    attributes.files("");
    attributes.async(false);
    attributes.includeAsyncDeferUnbundled(false);

    // Act
    resourceBundleProcessor.validateTagAttributes(attributes);

    // Assert
    verify(resourcesRequest).getBundle(eq(".js"), isNull(), isA(List.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}.
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceBundleProcessor.validateTagAttributes(ResourceTagAttributes)"})
  public void testValidateTagAttributes2() {
    // Arrange
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenThrow(new IllegalArgumentException());

    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.name(".js");
    attributes.bundleDependencyEvent(null);
    attributes.bundleCompletedEvent(null);
    attributes.mappingPrefix(null);
    attributes.files("");
    attributes.async(false);
    attributes.includeAsyncDeferUnbundled(false);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.validateTagAttributes(attributes));
    verify(resourcesRequest).getBundle(eq(".js"), isNull(), isA(List.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}.
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceBundleProcessor.validateTagAttributes(ResourceTagAttributes)"})
  public void testValidateTagAttributes3() {
    // Arrange
    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.name("");
    attributes.bundleDependencyEvent(null);
    attributes.bundleCompletedEvent(null);
    attributes.mappingPrefix(null);
    attributes.files("");
    attributes.async(false);
    attributes.includeAsyncDeferUnbundled(false);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.validateTagAttributes(attributes));
  }

  /**
   * Test {@link ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}.
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceBundleProcessor.validateTagAttributes(ResourceTagAttributes)"})
  public void testValidateTagAttributes4() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
    ResourcesRequestBundle resourcesRequestBundle =
        new ResourcesRequestBundle(
            "Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);

    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.name(".js");
    attributes.bundleDependencyEvent(null);
    attributes.bundleCompletedEvent(".js");
    attributes.mappingPrefix(null);
    attributes.files("");
    attributes.async(false);
    attributes.includeAsyncDeferUnbundled(false);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.validateTagAttributes(attributes));
    verify(resourcesRequest).getBundle(eq(".js"), isNull(), isA(List.class));
    verify(environment).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}.
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceBundleProcessor.validateTagAttributes(ResourceTagAttributes)"})
  public void testValidateTagAttributes5() {
    // Arrange
    when(resourceBundlingService.getAdditionalBundleFiles(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ResourcesRequestBundle resourcesRequestBundle =
        new ResourcesRequestBundle(
            "Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);

    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.name(".js");
    attributes.bundleDependencyEvent(null);
    attributes.bundleCompletedEvent(".js");
    attributes.mappingPrefix(null);
    attributes.files(".js");
    attributes.async(false);
    attributes.includeAsyncDeferUnbundled(false);

    // Act
    resourceBundleProcessor.validateTagAttributes(attributes);

    // Assert
    verify(resourceBundlingService).getAdditionalBundleFiles(".js");
    verify(resourcesRequest).getBundle(eq(".js"), isNull(), isA(List.class));
    verify(environment).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}.
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceBundleProcessor.validateTagAttributes(ResourceTagAttributes)"})
  public void testValidateTagAttributes6() {
    // Arrange
    when(resourceBundlingService.getAdditionalBundleFiles(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.name(".js");
    attributes.bundleDependencyEvent(null);
    attributes.bundleCompletedEvent(".js");
    attributes.mappingPrefix(null);
    attributes.files(".js");
    attributes.async(false);
    attributes.includeAsyncDeferUnbundled(false);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.validateTagAttributes(attributes));
    verify(resourceBundlingService).getAdditionalBundleFiles(".js");
  }

  /**
   * Test {@link ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}.
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceBundleProcessor.validateTagAttributes(ResourceTagAttributes)"})
  public void testValidateTagAttributes7() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ResourcesRequestBundle resourcesRequestBundle =
        new ResourcesRequestBundle(
            "Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);

    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.name(".js");
    attributes.bundleDependencyEvent(null);
    attributes.bundleCompletedEvent(".js");
    attributes.mappingPrefix(null);
    attributes.files(null);
    attributes.async(false);
    attributes.includeAsyncDeferUnbundled(false);

    // Act
    resourceBundleProcessor.validateTagAttributes(attributes);

    // Assert
    verify(resourcesRequest).getBundle(eq(".js"), isNull(), isA(List.class));
    verify(environment).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}.
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceBundleProcessor.validateTagAttributes(ResourceTagAttributes)"})
  public void testValidateTagAttributes8() {
    // Arrange
    when(resourceBundlingService.getAdditionalBundleFiles(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ResourcesRequestBundle resourcesRequestBundle =
        new ResourcesRequestBundle(
            "Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);

    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.name(".js");
    attributes.bundleDependencyEvent(null);
    attributes.bundleCompletedEvent(".js");
    attributes.mappingPrefix(null);
    attributes.files(".js");
    attributes.async(true);
    attributes.includeAsyncDeferUnbundled(true);

    // Act and Assert
    assertThrows(
        InvalidParameterException.class,
        () -> resourceBundleProcessor.validateTagAttributes(attributes));
    verify(resourceBundlingService).getAdditionalBundleFiles(".js");
    verify(resourcesRequest).getBundle(eq(".js"), isNull(), isA(List.class));
    verify(environment, atLeast(1)).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}.
   *
   * <ul>
   *   <li>Given Bean Name{blResourcesRequest} {@link ResourcesRequest#getBundle(String, String,
   *       List)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceBundleProcessor.validateTagAttributes(ResourceTagAttributes)"})
  public void testValidateTagAttributes_givenBeanNameBlResourcesRequestGetBundleReturnNull() {
    // Arrange
    when(resourceBundlingService.getAdditionalBundleFiles(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(null);

    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.name(".js");
    attributes.bundleDependencyEvent(null);
    attributes.bundleCompletedEvent(".js");
    attributes.mappingPrefix(null);
    attributes.files(".js");
    attributes.async(false);
    attributes.includeAsyncDeferUnbundled(false);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.validateTagAttributes(attributes));
    verify(resourceBundlingService).getAdditionalBundleFiles(".js");
    verify(resourcesRequest).getBundle(eq(".js"), isNull(), isA(List.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}.
   *
   * <ul>
   *   <li>Given {@code bundle.enabled}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceBundleProcessor.validateTagAttributes(ResourceTagAttributes)"})
  public void testValidateTagAttributes_givenBundleEnabled() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle =
        new ResourcesRequestBundle(
            "Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);

    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.name("bundle.enabled");
    attributes.bundleDependencyEvent(null);
    attributes.bundleCompletedEvent(".js");
    attributes.mappingPrefix(null);
    attributes.files("");
    attributes.async(false);
    attributes.includeAsyncDeferUnbundled(false);

    // Act and Assert
    assertThrows(
        InvalidParameterException.class,
        () -> resourceBundleProcessor.validateTagAttributes(attributes));
    verify(resourcesRequest).getBundle(eq("bundle.enabled"), isNull(), isA(List.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}.
   *
   * <ul>
   *   <li>Given {@code ,}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceBundleProcessor.validateTagAttributes(ResourceTagAttributes)"})
  public void testValidateTagAttributes_givenComma() {
    // Arrange
    when(resourceBundlingService.getAdditionalBundleFiles(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(null);

    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.name(".js");
    attributes.bundleDependencyEvent(null);
    attributes.bundleCompletedEvent(".js");
    attributes.mappingPrefix(",");
    attributes.files(".js");
    attributes.async(false);
    attributes.includeAsyncDeferUnbundled(false);

    // Act
    resourceBundleProcessor.validateTagAttributes(attributes);

    // Assert
    verify(resourceBundlingService).getAdditionalBundleFiles(".js");
    verify(resourcesRequest).getBundle(eq(".js"), eq(","), isA(List.class));
    verify(environment).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}.
   *
   * <ul>
   *   <li>Given {@code ,}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceBundleProcessor.validateTagAttributes(ResourceTagAttributes)"})
  public void testValidateTagAttributes_givenComma2() {
    // Arrange
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(null);

    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.name(".js");
    attributes.bundleDependencyEvent(null);
    attributes.bundleCompletedEvent(".js");
    attributes.mappingPrefix(",");
    attributes.files(null);
    attributes.async(false);
    attributes.includeAsyncDeferUnbundled(false);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.validateTagAttributes(attributes));
    verify(resourcesRequest).getBundle(eq(".js"), eq(","), isA(List.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String)} return {@code
   *       Property}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceBundleProcessor.validateTagAttributes(ResourceTagAttributes)"})
  public void testValidateTagAttributes_givenEnvironmentGetPropertyReturnProperty() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ResourcesRequestBundle resourcesRequestBundle =
        new ResourcesRequestBundle(
            "Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);

    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.name(".js");
    attributes.bundleDependencyEvent(null);
    attributes.bundleCompletedEvent(".js");
    attributes.mappingPrefix(null);
    attributes.files("");
    attributes.async(false);
    attributes.includeAsyncDeferUnbundled(false);

    // Act
    resourceBundleProcessor.validateTagAttributes(attributes);

    // Assert
    verify(resourcesRequest).getBundle(eq(".js"), isNull(), isA(List.class));
    verify(environment).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceBundleProcessor.validateTagAttributes(ResourceTagAttributes)"})
  public void testValidateTagAttributes_givenName() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle =
        new ResourcesRequestBundle(
            "Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);

    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.name("Name");
    attributes.bundleDependencyEvent(null);
    attributes.bundleCompletedEvent(null);
    attributes.mappingPrefix(null);
    attributes.files("");
    attributes.async(false);
    attributes.includeAsyncDeferUnbundled(false);

    // Act
    resourceBundleProcessor.validateTagAttributes(attributes);

    // Assert
    verify(resourcesRequest).getBundle(eq("Name"), isNull(), isA(List.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}.
   *
   * <ul>
   *   <li>Given space.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceBundleProcessor.validateTagAttributes(ResourceTagAttributes)"})
  public void testValidateTagAttributes_givenSpace() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle =
        new ResourcesRequestBundle(
            "Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);

    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.name(".js");
    attributes.bundleDependencyEvent(null);
    attributes.bundleCompletedEvent(null);
    attributes.mappingPrefix(null);
    attributes.files(" ");
    attributes.async(false);
    attributes.includeAsyncDeferUnbundled(false);

    // Act
    resourceBundleProcessor.validateTagAttributes(attributes);

    // Assert
    verify(resourcesRequest).getBundle(eq(".js"), isNull(), isA(List.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}.
   *
   * <ul>
   *   <li>Given {@code tags when they first appear on the template}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceBundleProcessor.validateTagAttributes(ResourceTagAttributes)"})
  public void testValidateTagAttributes_givenTagsWhenTheyFirstAppearOnTheTemplate() {
    // Arrange
    when(resourceBundlingService.getAdditionalBundleFiles(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(null);

    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.name(".js");
    attributes.bundleDependencyEvent(null);
    attributes.bundleCompletedEvent(".js");
    attributes.mappingPrefix(null);
    attributes.files(" tags when they first appear on the template");
    attributes.async(false);
    attributes.includeAsyncDeferUnbundled(false);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.validateTagAttributes(attributes));
    verify(resourceBundlingService).getAdditionalBundleFiles(".js");
    verify(resourcesRequest).getBundle(eq(".js"), isNull(), isA(List.class));
  }

  /**
   * Test {@link ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceBundleProcessor.validateTagAttributes(ResourceTagAttributes)"})
  public void testValidateTagAttributes_givenTrue() {
    // Arrange
    when(resourceBundlingService.getAdditionalBundleFiles(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ResourcesRequestBundle resourcesRequestBundle =
        new ResourcesRequestBundle(
            "Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path");
    when(resourcesRequest.getBundle(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(resourcesRequestBundle);

    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.name(".js");
    attributes.bundleDependencyEvent(null);
    attributes.bundleCompletedEvent(".js");
    attributes.mappingPrefix(null);
    attributes.files(".js");
    attributes.async(true);
    attributes.includeAsyncDeferUnbundled(false);

    // Act
    resourceBundleProcessor.validateTagAttributes(attributes);

    // Assert
    verify(resourceBundlingService).getAdditionalBundleFiles(".js");
    verify(resourcesRequest).getBundle(eq(".js"), isNull(), isA(List.class));
    verify(environment, atLeast(1)).getProperty("bundle.enabled");
  }

  /**
   * Test {@link ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}.
   *
   * <ul>
   *   <li>When {@link ResourceTagAttributes#ResourceTagAttributes()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceBundleProcessor.validateTagAttributes(ResourceTagAttributes)"})
  public void testValidateTagAttributes_whenResourceTagAttributes() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.validateTagAttributes(new ResourceTagAttributes()));
  }

  /**
   * Test {@link ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}.
   *
   * <ul>
   *   <li>When {@link ResourceTagAttributes} {@link ResourceTagAttributes#name()} return empty
   *       string.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#validateTagAttributes(ResourceTagAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceBundleProcessor.validateTagAttributes(ResourceTagAttributes)"})
  public void testValidateTagAttributes_whenResourceTagAttributesNameReturnEmptyString() {
    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.name()).thenReturn("");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.validateTagAttributes(attributes));
    verify(attributes).name();
  }

  /**
   * Test {@link
   * ResourceBundleProcessor#buildUnbundledSyncCompletedEventElement(ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#buildUnbundledSyncCompletedEventElement(ResourceTagAttributes,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateElement ResourceBundleProcessor.buildUnbundledSyncCompletedEventElement(ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildUnbundledSyncCompletedEventElement() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.bundleCompletedEvent("Attributes");
    attributes.async(false);
    attributes.includeAsyncDeferUnbundled(false);

    BroadleafTemplateNonVoidElement broadleafTemplateNonVoidElement =
        mock(BroadleafTemplateNonVoidElement.class);
    doNothing()
        .when(broadleafTemplateNonVoidElement)
        .addChild(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createNonVoidElement(Mockito.<String>any()))
        .thenReturn(broadleafTemplateNonVoidElement);

    // Act
    resourceBundleProcessor.buildUnbundledSyncCompletedEventElement(attributes, context);

    // Assert
    verify(context).createNonVoidElement("script");
    verify(context)
        .createTextElement(
            "var AttributesEvent = new CustomEvent('Attributes');document.dispatchEvent(AttributesEvent);");
    verify(broadleafTemplateNonVoidElement).addChild(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty("bundle.enabled");
  }

  /**
   * Test {@link
   * ResourceBundleProcessor#buildUnbundledSyncCompletedEventElement(ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#buildUnbundledSyncCompletedEventElement(ResourceTagAttributes,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateElement ResourceBundleProcessor.buildUnbundledSyncCompletedEventElement(ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildUnbundledSyncCompletedEventElement2() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.bundleCompletedEvent("Attributes");
    attributes.async(false);
    attributes.includeAsyncDeferUnbundled(false);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            resourceBundleProcessor.buildUnbundledSyncCompletedEventElement(
                attributes, mock(BroadleafTemplateContext.class)));
    verify(environment).getProperty("bundle.enabled");
  }

  /**
   * Test {@link
   * ResourceBundleProcessor#buildUnbundledSyncCompletedEventElement(ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#buildUnbundledSyncCompletedEventElement(ResourceTagAttributes,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateElement ResourceBundleProcessor.buildUnbundledSyncCompletedEventElement(ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildUnbundledSyncCompletedEventElement3() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.bundleCompletedEvent(null);
    attributes.async(false);
    attributes.includeAsyncDeferUnbundled(false);

    // Act
    BroadleafTemplateElement actualBuildUnbundledSyncCompletedEventElementResult =
        resourceBundleProcessor.buildUnbundledSyncCompletedEventElement(
            attributes, mock(BroadleafTemplateContext.class));

    // Assert
    verify(environment).getProperty("bundle.enabled");
    assertNull(actualBuildUnbundledSyncCompletedEventElementResult);
  }

  /**
   * Test {@link
   * ResourceBundleProcessor#buildUnbundledSyncCompletedEventElement(ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#buildUnbundledSyncCompletedEventElement(ResourceTagAttributes,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateElement ResourceBundleProcessor.buildUnbundledSyncCompletedEventElement(ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildUnbundledSyncCompletedEventElement4() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.bundleCompletedEvent("Attributes");
    attributes.async(true);
    attributes.includeAsyncDeferUnbundled(false);

    BroadleafTemplateNonVoidElement broadleafTemplateNonVoidElement =
        mock(BroadleafTemplateNonVoidElement.class);
    doNothing()
        .when(broadleafTemplateNonVoidElement)
        .addChild(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createNonVoidElement(Mockito.<String>any()))
        .thenReturn(broadleafTemplateNonVoidElement);

    // Act
    resourceBundleProcessor.buildUnbundledSyncCompletedEventElement(attributes, context);

    // Assert
    verify(context).createNonVoidElement("script");
    verify(context)
        .createTextElement(
            "var AttributesEvent = new CustomEvent('Attributes');document.dispatchEvent(AttributesEvent);");
    verify(broadleafTemplateNonVoidElement).addChild(isA(BroadleafTemplateElement.class));
    verify(environment, atLeast(1)).getProperty("bundle.enabled");
  }

  /**
   * Test {@link
   * ResourceBundleProcessor#buildUnbundledSyncCompletedEventElement(ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#buildUnbundledSyncCompletedEventElement(ResourceTagAttributes,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateElement ResourceBundleProcessor.buildUnbundledSyncCompletedEventElement(ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildUnbundledSyncCompletedEventElement5() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.bundleCompletedEvent("Attributes");
    attributes.async(false);
    attributes.includeAsyncDeferUnbundled(false);

    BroadleafTemplateNonVoidElement broadleafTemplateNonVoidElement =
        mock(BroadleafTemplateNonVoidElement.class);
    doThrow(new IllegalArgumentException())
        .when(broadleafTemplateNonVoidElement)
        .addChild(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createNonVoidElement(Mockito.<String>any()))
        .thenReturn(broadleafTemplateNonVoidElement);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.buildUnbundledSyncCompletedEventElement(attributes, context));
    verify(context).createNonVoidElement("script");
    verify(context)
        .createTextElement(
            "var AttributesEvent = new CustomEvent('Attributes');document.dispatchEvent(AttributesEvent);");
    verify(broadleafTemplateNonVoidElement).addChild(isA(BroadleafTemplateElement.class));
    verify(environment).getProperty("bundle.enabled");
  }

  /**
   * Test {@link
   * ResourceBundleProcessor#buildUnbundledSyncCompletedEventElement(ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#buildUnbundledSyncCompletedEventElement(ResourceTagAttributes,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateElement ResourceBundleProcessor.buildUnbundledSyncCompletedEventElement(ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildUnbundledSyncCompletedEventElement6() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ResourceTagAttributes attributes = new ResourceTagAttributes(new ResourceTagAttributes());
    attributes.bundleCompletedEvent("Attributes");
    attributes.async(true);
    attributes.includeAsyncDeferUnbundled(true);

    // Act
    BroadleafTemplateElement actualBuildUnbundledSyncCompletedEventElementResult =
        resourceBundleProcessor.buildUnbundledSyncCompletedEventElement(
            attributes, mock(BroadleafTemplateContext.class));

    // Assert
    verify(environment, atLeast(1)).getProperty("bundle.enabled");
    assertNull(actualBuildUnbundledSyncCompletedEventElementResult);
  }

  /**
   * Test {@link
   * ResourceBundleProcessor#buildUnbundledSyncCompletedEventElement(ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#buildUnbundledSyncCompletedEventElement(ResourceTagAttributes,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateElement ResourceBundleProcessor.buildUnbundledSyncCompletedEventElement(ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildUnbundledSyncCompletedEventElement7() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.async()).thenReturn(false);
    when(attributes.bundleCompletedEvent()).thenReturn(null);

    // Act
    BroadleafTemplateElement actualBuildUnbundledSyncCompletedEventElementResult =
        resourceBundleProcessor.buildUnbundledSyncCompletedEventElement(
            attributes, mock(BroadleafTemplateContext.class));

    // Assert
    verify(attributes).async();
    verify(attributes).bundleCompletedEvent();
    verify(environment).getProperty("bundle.enabled");
    assertNull(actualBuildUnbundledSyncCompletedEventElementResult);
  }

  /**
   * Test {@link
   * ResourceBundleProcessor#buildUnbundledSyncCompletedEventElement(ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#buildUnbundledSyncCompletedEventElement(ResourceTagAttributes,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateElement ResourceBundleProcessor.buildUnbundledSyncCompletedEventElement(ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildUnbundledSyncCompletedEventElement8() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.includeAsyncDeferUnbundled()).thenReturn(true);
    when(attributes.async()).thenReturn(true);

    // Act
    BroadleafTemplateElement actualBuildUnbundledSyncCompletedEventElementResult =
        resourceBundleProcessor.buildUnbundledSyncCompletedEventElement(
            attributes, mock(BroadleafTemplateContext.class));

    // Assert
    verify(attributes).async();
    verify(attributes).includeAsyncDeferUnbundled();
    verify(environment, atLeast(1)).getProperty("bundle.enabled");
    assertNull(actualBuildUnbundledSyncCompletedEventElementResult);
  }

  /**
   * Test {@link
   * ResourceBundleProcessor#buildUnbundledSyncCompletedEventElement(ResourceTagAttributes,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@code Bundle Completed Event}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourceBundleProcessor#buildUnbundledSyncCompletedEventElement(ResourceTagAttributes,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateElement ResourceBundleProcessor.buildUnbundledSyncCompletedEventElement(ResourceTagAttributes, BroadleafTemplateContext)"
  })
  public void testBuildUnbundledSyncCompletedEventElement_givenBundleCompletedEvent() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.includeAsyncDeferUnbundled()).thenReturn(false);
    when(attributes.async()).thenReturn(true);
    when(attributes.bundleCompletedEvent()).thenReturn("Bundle Completed Event");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourceBundleProcessor.buildUnbundledSyncCompletedEventElement(attributes, context));
    verify(attributes).async();
    verify(attributes, atLeast(1)).bundleCompletedEvent();
    verify(attributes).includeAsyncDeferUnbundled();
    verify(context).createNonVoidElement("script");
    verify(environment, atLeast(1)).getProperty("bundle.enabled");
  }
}

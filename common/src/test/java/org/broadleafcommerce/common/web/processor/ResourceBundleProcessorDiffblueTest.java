/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.web.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.web.processor.attributes.ResourceTagAttributes;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.broadleafcommerce.presentation.model.BroadleafTemplateElement;
import org.broadleafcommerce.presentation.model.BroadleafTemplateModel;
import org.broadleafcommerce.presentation.model.BroadleafTemplateNonVoidElement;
import org.junit.Test;
import org.mockito.Mockito;

public class ResourceBundleProcessorDiffblueTest {
  /**
   * Test {@link ResourceBundleProcessor#getName()}.
   * <p>
   * Method under test: {@link ResourceBundleProcessor#getName()}
   */
  @Test
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
  public void testGetPrecedence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(10000, (new ResourceBundleProcessor()).getPrecedence());
  }

  /**
   * Test
   * {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   * with {@code attributes}, {@code context}, {@code model}.
   * <p>
   * Method under test:
   * {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  public void testAddElementToModelWithAttributesContextModel() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    ResourceTagAttributes attributes = new ResourceTagAttributes();
    attributes.src(".css");
    attributes.defer(false);
    attributes.includeAsyncDeferUnbundled(false);
    attributes.async(false);
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
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
   * Test
   * {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   * with {@code attributes}, {@code context}, {@code model}.
   * <p>
   * Method under test:
   * {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  public void testAddElementToModelWithAttributesContextModel2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    ResourceTagAttributes attributes = new ResourceTagAttributes();
    attributes.src(".css");
    attributes.defer(false);
    attributes.includeAsyncDeferUnbundled(false);
    attributes.async(false);
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doThrow(new IllegalArgumentException(";")).when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> resourceBundleProcessor.addElementToModel(attributes, context, model));
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test
   * {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   * with {@code attributes}, {@code context}, {@code model}.
   * <p>
   * Method under test:
   * {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  public void testAddElementToModelWithAttributesContextModel3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    ResourceTagAttributes attributes = new ResourceTagAttributes();
    attributes.src(".css");
    attributes.defer(true);
    attributes.includeAsyncDeferUnbundled(false);
    attributes.async(false);
    BroadleafTemplateNonVoidElement broadleafTemplateNonVoidElement = mock(BroadleafTemplateNonVoidElement.class);
    doNothing().when(broadleafTemplateNonVoidElement).addChild(Mockito.<BroadleafTemplateElement>any());
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(Mockito.<String>any())).thenReturn(broadleafTemplateNonVoidElement);
    when(context.createStandaloneElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addElementToModel(attributes, context, model);

    // Assert
    verify(context).createNonVoidElement(eq("noscript"));
    verify(context, atLeast(1)).createStandaloneElement(eq("link"), Mockito.<Map<String, String>>any(), eq(true));
    verify(model, atLeast(1)).addElement(Mockito.<BroadleafTemplateElement>any());
    verify(broadleafTemplateNonVoidElement).addChild(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test
   * {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   * with {@code attributes}, {@code context}, {@code model}.
   * <p>
   * Method under test:
   * {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  public void testAddElementToModelWithAttributesContextModel4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    ResourceTagAttributes attributes = new ResourceTagAttributes();
    attributes.src(".css");
    attributes.defer(true);
    attributes.includeAsyncDeferUnbundled(false);
    attributes.async(false);
    BroadleafTemplateNonVoidElement broadleafTemplateNonVoidElement = mock(BroadleafTemplateNonVoidElement.class);
    doThrow(new IllegalArgumentException(";")).when(broadleafTemplateNonVoidElement)
        .addChild(Mockito.<BroadleafTemplateElement>any());
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createNonVoidElement(Mockito.<String>any())).thenReturn(broadleafTemplateNonVoidElement);
    when(context.createStandaloneElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> resourceBundleProcessor.addElementToModel(attributes, context, mock(BroadleafTemplateModel.class)));
    verify(context).createNonVoidElement(eq("noscript"));
    verify(context, atLeast(1)).createStandaloneElement(eq("link"), Mockito.<Map<String, String>>any(), eq(true));
    verify(broadleafTemplateNonVoidElement).addChild(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test
   * {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   * with {@code attributes}, {@code context}, {@code model}.
   * <ul>
   *   <li>Given {@code ;}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  public void testAddElementToModelWithAttributesContextModel_givenSemicolon() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

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
   * Test
   * {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   * with {@code attributes}, {@code context}, {@code model}.
   * <ul>
   *   <li>Given {@code Src}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  public void testAddElementToModelWithAttributesContextModel_givenSrc() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();
    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.src()).thenReturn("Src");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> resourceBundleProcessor.addElementToModel(attributes,
        mock(BroadleafTemplateContext.class), mock(BroadleafTemplateModel.class)));
    verify(attributes, atLeast(1)).src();
  }

  /**
   * Test
   * {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   * with {@code attributes}, {@code context}, {@code model}.
   * <ul>
   *   <li>Then calls {@link ResourceTagAttributes#defer()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  public void testAddElementToModelWithAttributesContextModel_thenCallsDefer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();
    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.defer()).thenReturn(true);
    when(attributes.src()).thenReturn(".css");
    BroadleafTemplateNonVoidElement broadleafTemplateNonVoidElement = mock(BroadleafTemplateNonVoidElement.class);
    doNothing().when(broadleafTemplateNonVoidElement).addChild(Mockito.<BroadleafTemplateElement>any());
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createNonVoidElement(Mockito.<String>any())).thenReturn(broadleafTemplateNonVoidElement);
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doNothing().when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act
    resourceBundleProcessor.addElementToModel(attributes, context, model);

    // Assert
    verify(attributes).defer();
    verify(attributes, atLeast(1)).src();
    verify(context).createNonVoidElement(eq("noscript"));
    verify(context, atLeast(1)).createStandaloneElement(eq("link"), Mockito.<Map<String, String>>any(), eq(true));
    verify(model, atLeast(1)).addElement(Mockito.<BroadleafTemplateElement>any());
    verify(broadleafTemplateNonVoidElement).addChild(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test
   * {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   * with {@code attributes}, {@code context}, {@code model}.
   * <ul>
   *   <li>Then calls {@link ResourceTagAttributes#defer()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundleProcessor#addElementToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  public void testAddElementToModelWithAttributesContextModel_thenCallsDefer2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();
    ResourceTagAttributes attributes = mock(ResourceTagAttributes.class);
    when(attributes.defer()).thenReturn(true);
    when(attributes.src()).thenReturn(".css");
    BroadleafTemplateNonVoidElement broadleafTemplateNonVoidElement = mock(BroadleafTemplateNonVoidElement.class);
    doNothing().when(broadleafTemplateNonVoidElement).addChild(Mockito.<BroadleafTemplateElement>any());
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createNonVoidElement(Mockito.<String>any())).thenReturn(broadleafTemplateNonVoidElement);
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doThrow(new IllegalArgumentException(";")).when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> resourceBundleProcessor.addElementToModel(attributes, context, model));
    verify(attributes).defer();
    verify(attributes, atLeast(1)).src();
    verify(context).createNonVoidElement(eq("noscript"));
    verify(context, atLeast(1)).createStandaloneElement(eq("link"), Mockito.<Map<String, String>>any(), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(broadleafTemplateNonVoidElement).addChild(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test
   * {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)}
   * with {@code src}, {@code async}, {@code defer}, {@code context},
   * {@code model}.
   * <p>
   * Method under test:
   * {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  public void testAddElementToModelWithSrcAsyncDeferContextModel() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doThrow(new IllegalArgumentException("foo")).when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> resourceBundleProcessor.addElementToModel(".css", true, false, context, model));
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test
   * {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)}
   * with {@code src}, {@code async}, {@code defer}, {@code context},
   * {@code model}.
   * <ul>
   *   <li>Then calls
   * {@link BroadleafTemplateContext#createNonVoidElement(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  public void testAddElementToModelWithSrcAsyncDeferContextModel_thenCallsCreateNonVoidElement() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();
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
   * Test
   * {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)}
   * with {@code src}, {@code async}, {@code defer}, {@code context},
   * {@code model}.
   * <ul>
   *   <li>Then calls
   * {@link BroadleafTemplateContext#createNonVoidElement(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  public void testAddElementToModelWithSrcAsyncDeferContextModel_thenCallsCreateNonVoidElement2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();
    BroadleafTemplateNonVoidElement broadleafTemplateNonVoidElement = mock(BroadleafTemplateNonVoidElement.class);
    doNothing().when(broadleafTemplateNonVoidElement).addChild(Mockito.<BroadleafTemplateElement>any());
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createNonVoidElement(Mockito.<String>any())).thenReturn(broadleafTemplateNonVoidElement);
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doThrow(new IllegalArgumentException("foo")).when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> resourceBundleProcessor.addElementToModel(".css", true, true, context, model));
    verify(context).createNonVoidElement(eq("noscript"));
    verify(context, atLeast(1)).createStandaloneElement(eq("link"), Mockito.<Map<String, String>>any(), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(broadleafTemplateNonVoidElement).addChild(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test
   * {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)}
   * with {@code src}, {@code async}, {@code defer}, {@code context},
   * {@code model}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  public void testAddElementToModelWithSrcAsyncDeferContextModel_whenFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();
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
   * Test
   * {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)}
   * with {@code src}, {@code async}, {@code defer}, {@code context},
   * {@code model}.
   * <ul>
   *   <li>When {@code ;}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  public void testAddElementToModelWithSrcAsyncDeferContextModel_whenSemicolon() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new ResourceBundleProcessor()).addElementToModel(";", true,
        true, mock(BroadleafTemplateContext.class), mock(BroadleafTemplateModel.class)));
  }

  /**
   * Test
   * {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)}
   * with {@code src}, {@code async}, {@code defer}, {@code context},
   * {@code model}.
   * <ul>
   *   <li>When {@code Src}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  public void testAddElementToModelWithSrcAsyncDeferContextModel_whenSrc() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new ResourceBundleProcessor()).addElementToModel("Src", true,
        true, mock(BroadleafTemplateContext.class), mock(BroadleafTemplateModel.class)));
  }

  /**
   * Test
   * {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)}
   * with {@code src}, {@code async}, {@code defer}, {@code dependencyEvent},
   * {@code context}, {@code model}.
   * <p>
   * Method under test:
   * {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  public void testAddElementToModelWithSrcAsyncDeferDependencyEventContextModel() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();
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
   * Test
   * {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)}
   * with {@code src}, {@code async}, {@code defer}, {@code dependencyEvent},
   * {@code context}, {@code model}.
   * <p>
   * Method under test:
   * {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  public void testAddElementToModelWithSrcAsyncDeferDependencyEventContextModel2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();
    BroadleafTemplateNonVoidElement broadleafTemplateNonVoidElement = mock(BroadleafTemplateNonVoidElement.class);
    doNothing().when(broadleafTemplateNonVoidElement).addChild(Mockito.<BroadleafTemplateElement>any());
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createNonVoidElement(Mockito.<String>any())).thenReturn(broadleafTemplateNonVoidElement);
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doThrow(new IllegalArgumentException("foo")).when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> resourceBundleProcessor.addElementToModel(".css", true, true, "Dependency Event", context, model));
    verify(context).createNonVoidElement(eq("noscript"));
    verify(context, atLeast(1)).createStandaloneElement(eq("link"), Mockito.<Map<String, String>>any(), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
    verify(broadleafTemplateNonVoidElement).addChild(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test
   * {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)}
   * with {@code src}, {@code async}, {@code defer}, {@code dependencyEvent},
   * {@code context}, {@code model}.
   * <p>
   * Method under test:
   * {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  public void testAddElementToModelWithSrcAsyncDeferDependencyEventContextModel3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    BroadleafTemplateModel model = mock(BroadleafTemplateModel.class);
    doThrow(new IllegalArgumentException("foo")).when(model).addElement(Mockito.<BroadleafTemplateElement>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> resourceBundleProcessor.addElementToModel(".css", true, false, "Dependency Event", context, model));
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
    verify(model).addElement(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test
   * {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)}
   * with {@code src}, {@code async}, {@code defer}, {@code dependencyEvent},
   * {@code context}, {@code model}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  public void testAddElementToModelWithSrcAsyncDeferDependencyEventContextModel_whenFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();
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
   * Test
   * {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)}
   * with {@code src}, {@code async}, {@code defer}, {@code dependencyEvent},
   * {@code context}, {@code model}.
   * <ul>
   *   <li>When {@code ;}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  public void testAddElementToModelWithSrcAsyncDeferDependencyEventContextModel_whenSemicolon() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new ResourceBundleProcessor()).addElementToModel(";", true,
        true, "Dependency Event", mock(BroadleafTemplateContext.class), mock(BroadleafTemplateModel.class)));
  }

  /**
   * Test
   * {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)}
   * with {@code src}, {@code async}, {@code defer}, {@code dependencyEvent},
   * {@code context}, {@code model}.
   * <ul>
   *   <li>When {@code Src}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundleProcessor#addElementToModel(String, boolean, boolean, String, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  public void testAddElementToModelWithSrcAsyncDeferDependencyEventContextModel_whenSrc() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new ResourceBundleProcessor()).addElementToModel("Src", true,
        true, "Dependency Event", mock(BroadleafTemplateContext.class), mock(BroadleafTemplateModel.class)));
  }

  /**
   * Test
   * {@link ResourceBundleProcessor#addCssToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   * <p>
   * Method under test:
   * {@link ResourceBundleProcessor#addCssToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  public void testAddCssToModel() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();
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
   * Test
   * {@link ResourceBundleProcessor#addCssToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   * <ul>
   *   <li>Given {@link BroadleafTemplateNonVoidElement}
   * {@link BroadleafTemplateNonVoidElement#addChild(BroadleafTemplateElement)}
   * does nothing.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundleProcessor#addCssToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  public void testAddCssToModel_givenBroadleafTemplateNonVoidElementAddChildDoesNothing() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();
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
   * Test
   * {@link ResourceBundleProcessor#addCssToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)}
   * with {@code link}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundleProcessor#addCssToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  public void testAddCssToModel_givenIllegalArgumentExceptionWithLink() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();
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
   * Test
   * {@link ResourceBundleProcessor#addCssToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}.
   * <ul>
   *   <li>When {@link ResourceTagAttributes#ResourceTagAttributes()}.</li>
   *   <li>Then calls
   * {@link BroadleafTemplateModel#addElement(BroadleafTemplateElement)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundleProcessor#addCssToModel(ResourceTagAttributes, BroadleafTemplateContext, BroadleafTemplateModel)}
   */
  @Test
  public void testAddCssToModel_whenResourceTagAttributes_thenCallsAddElement() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();
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
   * Test
   * {@link ResourceBundleProcessor#getDeferredCssElements(ResourceTagAttributes, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@code Src}.</li>
   *   <li>Then calls {@link ResourceTagAttributes#src()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundleProcessor#getDeferredCssElements(ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  public void testGetDeferredCssElements_givenSrc_thenCallsSrc() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();
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
   * Test
   * {@link ResourceBundleProcessor#getDeferredCssElements(ResourceTagAttributes, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundleProcessor#getDeferredCssElements(ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  public void testGetDeferredCssElements_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();
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
   * Test
   * {@link ResourceBundleProcessor#getDeferredCssElements(ResourceTagAttributes, BroadleafTemplateContext)}.
   * <ul>
   *   <li>When {@link ResourceTagAttributes#ResourceTagAttributes()}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundleProcessor#getDeferredCssElements(ResourceTagAttributes, BroadleafTemplateContext)}
   */
  @Test
  public void testGetDeferredCssElements_whenResourceTagAttributes_thenReturnSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();
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
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code Original}.</li>
   *   <li>Then return {@code Original}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  public void testCleanUpJavaScriptName_whenOriginal_thenReturnOriginal() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Original", (new ResourceBundleProcessor()).cleanUpJavaScriptName("Original"));
  }

  /**
   * Test {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundleProcessor#cleanUpJavaScriptName(String)}
   */
  @Test
  public void testCleanUpJavaScriptName_whenSlash_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new ResourceBundleProcessor()).cleanUpJavaScriptName("/"));
  }

  /**
   * Test {@link ResourceBundleProcessor#getLinkAttributes(String)}.
   * <p>
   * Method under test: {@link ResourceBundleProcessor#getLinkAttributes(String)}
   */
  @Test
  public void testGetLinkAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Map<String, String> actualLinkAttributes = (new ResourceBundleProcessor()).getLinkAttributes("Src");

    // Assert
    assertEquals(2, actualLinkAttributes.size());
    assertEquals("Src", actualLinkAttributes.get("href"));
    assertEquals("stylesheet", actualLinkAttributes.get("rel"));
  }

  /**
   * Test
   * {@link ResourceBundleProcessor#getNormalCssAttributes(ResourceTagAttributes)}.
   * <p>
   * Method under test:
   * {@link ResourceBundleProcessor#getNormalCssAttributes(ResourceTagAttributes)}
   */
  @Test
  public void testGetNormalCssAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    // Act
    Map<String, String> actualNormalCssAttributes = resourceBundleProcessor
        .getNormalCssAttributes(new ResourceTagAttributes());

    // Assert
    assertEquals(2, actualNormalCssAttributes.size());
    assertEquals("stylesheet", actualNormalCssAttributes.get("rel"));
    assertNull(actualNormalCssAttributes.get("href"));
  }

  /**
   * Test
   * {@link ResourceBundleProcessor#useAsyncJavaScript(ResourceTagAttributes)}.
   * <p>
   * Method under test:
   * {@link ResourceBundleProcessor#useAsyncJavaScript(ResourceTagAttributes)}
   */
  @Test
  public void testUseAsyncJavaScript() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    // Act and Assert
    assertFalse(resourceBundleProcessor.useAsyncJavaScript(new ResourceTagAttributes()));
  }
}

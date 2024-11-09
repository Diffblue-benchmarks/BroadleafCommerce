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
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Map;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.broadleafcommerce.presentation.model.BroadleafTemplateElement;
import org.junit.Test;
import org.mockito.Mockito;

public class ResourcePreloadProcessorDiffblueTest {
  /**
   * Test {@link ResourcePreloadProcessor#getName()}.
   * <p>
   * Method under test: {@link ResourcePreloadProcessor#getName()}
   */
  @Test
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
  public void testGetPrecedence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(10000, (new ResourcePreloadProcessor()).getPrecedence());
  }

  /**
   * Test
   * {@link ResourcePreloadProcessor#buildPreloadElement(String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>When {@code .css}.</li>
   *   <li>Then calls
   * {@link BroadleafTemplateContext#createStandaloneElement(String, Map, boolean)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourcePreloadProcessor#buildPreloadElement(String, BroadleafTemplateContext)}
   */
  @Test
  public void testBuildPreloadElement_whenCss_thenCallsCreateStandaloneElement() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourcePreloadProcessor resourcePreloadProcessor = new ResourcePreloadProcessor();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    // Act
    resourcePreloadProcessor.buildPreloadElement(".css", context);

    // Assert
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
  }

  /**
   * Test
   * {@link ResourcePreloadProcessor#buildPreloadElement(String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>When {@code Href}.</li>
   *   <li>Then calls
   * {@link BroadleafTemplateContext#createStandaloneElement(String, Map, boolean)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourcePreloadProcessor#buildPreloadElement(String, BroadleafTemplateContext)}
   */
  @Test
  public void testBuildPreloadElement_whenHref_thenCallsCreateStandaloneElement() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourcePreloadProcessor resourcePreloadProcessor = new ResourcePreloadProcessor();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));

    // Act
    resourcePreloadProcessor.buildPreloadElement("Href", context);

    // Assert
    verify(context).createStandaloneElement(eq("link"), isA(Map.class), eq(true));
  }

  /**
   * Test
   * {@link ResourcePreloadProcessor#buildPreloadElement(String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>When {@code .js}.</li>
   *   <li>Then calls
   * {@link BroadleafTemplateContext#createStandaloneElement(String, Map, boolean)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourcePreloadProcessor#buildPreloadElement(String, BroadleafTemplateContext)}
   */
  @Test
  public void testBuildPreloadElement_whenJs_thenCallsCreateStandaloneElement() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourcePreloadProcessor resourcePreloadProcessor = new ResourcePreloadProcessor();
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
   * Method under test:
   * {@link ResourcePreloadProcessor#getPreloadAttributes(String, String)}
   */
  @Test
  public void testGetPreloadAttributes_whenAs_thenReturnSizeIsThree() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Map<String, String> actualPreloadAttributes = (new ResourcePreloadProcessor()).getPreloadAttributes("Href", "As");

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
   * Method under test:
   * {@link ResourcePreloadProcessor#getPreloadAttributes(String, String)}
   */
  @Test
  public void testGetPreloadAttributes_whenNull_thenReturnSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Map<String, String> actualPreloadAttributes = (new ResourcePreloadProcessor()).getPreloadAttributes("Href", null);

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
  public void testGetAs_whenCss_thenReturnStyle() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("style", (new ResourcePreloadProcessor()).getAs(".css"));
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
  public void testGetAs_whenFile_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ResourcePreloadProcessor()).getAs("File"));
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
  public void testGetAs_whenJs_thenReturnScript() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("script", (new ResourcePreloadProcessor()).getAs(".js"));
  }
}

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
   * Method under test: {@link ResourcePreloadProcessor#getName()}
   */
  @Test
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("bundlepreload", (new ResourcePreloadProcessor()).getName());
  }

  /**
   * Method under test: {@link ResourcePreloadProcessor#getPrecedence()}
   */
  @Test
  public void testGetPrecedence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(10000, (new ResourcePreloadProcessor()).getPrecedence());
  }

  /**
   * Method under test:
   * {@link ResourcePreloadProcessor#buildPreloadElement(String, BroadleafTemplateContext)}
   */
  @Test
  public void testBuildPreloadElement() {
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
   * Method under test:
   * {@link ResourcePreloadProcessor#buildPreloadElement(String, BroadleafTemplateContext)}
   */
  @Test
  public void testBuildPreloadElement2() {
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
   * Method under test:
   * {@link ResourcePreloadProcessor#buildPreloadElement(String, BroadleafTemplateContext)}
   */
  @Test
  public void testBuildPreloadElement3() {
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
   * Method under test:
   * {@link ResourcePreloadProcessor#getPreloadAttributes(String, String)}
   */
  @Test
  public void testGetPreloadAttributes() {
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
   * Method under test:
   * {@link ResourcePreloadProcessor#getPreloadAttributes(String, String)}
   */
  @Test
  public void testGetPreloadAttributes2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Map<String, String> actualPreloadAttributes = (new ResourcePreloadProcessor()).getPreloadAttributes("Href", null);

    // Assert
    assertEquals(2, actualPreloadAttributes.size());
    assertEquals("Href", actualPreloadAttributes.get("href"));
    assertEquals("preload", actualPreloadAttributes.get("rel"));
  }

  /**
   * Method under test: {@link ResourcePreloadProcessor#getAs(String)}
   */
  @Test
  public void testGetAs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ResourcePreloadProcessor()).getAs("File"));
    assertEquals("script", (new ResourcePreloadProcessor()).getAs(".js"));
    assertEquals("style", (new ResourcePreloadProcessor()).getAs(".css"));
  }
}

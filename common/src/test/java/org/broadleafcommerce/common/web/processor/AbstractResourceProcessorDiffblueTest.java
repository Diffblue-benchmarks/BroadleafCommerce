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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.broadleafcommerce.common.web.processor.attributes.ResourceTagAttributes;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

public class AbstractResourceProcessorDiffblueTest {
  /**
   * Method under test:
   * {@link AbstractResourceProcessor#getRequestedFileNames(String)}
   */
  @Test
  public void testGetRequestedFileNames() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    List<String> actualRequestedFileNames = (new ResourceBundleProcessor()).getRequestedFileNames("foo.txt");

    // Assert
    assertEquals(1, actualRequestedFileNames.size());
    assertEquals("foo.txt", actualRequestedFileNames.get(0));
  }

  /**
   * Method under test:
   * {@link AbstractResourceProcessor#getRequestedFileNames(String)}
   */
  @Test
  public void testGetRequestedFileNames2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ResourceBundleProcessor()).getRequestedFileNames(null).isEmpty());
  }

  /**
   * Method under test:
   * {@link AbstractResourceProcessor#buildResourceTagAttributes(Map)}
   */
  @Test
  public void testBuildResourceTagAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetBundleUrl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetBundleUrl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetBundleUrl3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetBundleUrl4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetBundleUrl5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetBundleUrl6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetBundleUrl7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetBundleUrl8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link AbstractResourceProcessor#buildBundledFilesList(ResourceTagAttributes)}
   */
  @Test
  public void testBuildBundledFilesList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    // Act and Assert
    assertTrue(resourceBundleProcessor.buildBundledFilesList(new ResourceTagAttributes()).isEmpty());
  }

  /**
   * Method under test:
   * {@link AbstractResourceProcessor#getBundleAppendText(ResourceTagAttributes)}
   */
  @Test
  public void testGetBundleAppendText() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    // Act and Assert
    assertNull(resourceBundleProcessor.getBundleAppendText(new ResourceTagAttributes()));
  }

  /**
   * Method under test:
   * {@link AbstractResourceProcessor#getBundleAppendText(ResourceTagAttributes)}
   */
  @Test
  public void testGetBundleAppendText2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    ResourceTagAttributes attributes = new ResourceTagAttributes();
    attributes.name(".js");
    attributes.bundleCompletedEvent("Attributes");

    // Act and Assert
    assertEquals("var AttributesEvent = new CustomEvent('Attributes');document.dispatchEvent(AttributesEvent);",
        resourceBundleProcessor.getBundleAppendText(attributes));
  }

  /**
   * Method under test:
   * {@link AbstractResourceProcessor#getBundleCompleteEventJavaScript(ResourceTagAttributes)}
   */
  @Test
  public void testGetBundleCompleteEventJavaScript() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    // Act and Assert
    assertEquals("var nullEvent = new CustomEvent('null');document.dispatchEvent(nullEvent);",
        resourceBundleProcessor.getBundleCompleteEventJavaScript(new ResourceTagAttributes()));
  }

  /**
   * Method under test:
   * {@link AbstractResourceProcessor#validateTagAttributes(ResourceTagAttributes)}
   */
  @Test
  public void testValidateTagAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourcePreloadProcessor resourcePreloadProcessor = new ResourcePreloadProcessor();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> resourcePreloadProcessor.validateTagAttributes(new ResourceTagAttributes()));
  }

  /**
   * Method under test:
   * {@link AbstractResourceProcessor#validateTagAttributes(ResourceTagAttributes)}
   */
  @Test
  public void testValidateTagAttributes2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourcePreloadProcessor resourcePreloadProcessor = new ResourcePreloadProcessor();
    ResourceTagAttributes resourceTagAttributes = mock(ResourceTagAttributes.class);
    when(resourceTagAttributes.name()).thenReturn("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> resourcePreloadProcessor.validateTagAttributes(resourceTagAttributes));
    verify(resourceTagAttributes).name();
  }
}

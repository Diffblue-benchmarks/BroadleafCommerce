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
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequestWrapper;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.broadleafcommerce.common.web.processor.attributes.ResourceTagAttributes;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

public class AbstractResourceProcessorDiffblueTest {
  /**
   * Test {@link AbstractResourceProcessor#getRequestedFileNames(String)}.
   * <ul>
   *   <li>When {@code foo.txt}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractResourceProcessor#getRequestedFileNames(String)}
   */
  @Test
  public void testGetRequestedFileNames_whenFooTxt_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link AbstractResourceProcessor#getRequestedFileNames(String)}
   */
  @Test
  public void testGetRequestedFileNames_whenNull_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ResourceBundleProcessor()).getRequestedFileNames(null).isEmpty());
  }

  /**
   * Test {@link AbstractResourceProcessor#buildResourceTagAttributes(Map)}.
   * <p>
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
   * Test
   * {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@link DefaultMultipartHttpServletRequest}
   * {@link HttpServletRequestWrapper#getContextPath()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetBundleUrl_givenDefaultMultipartHttpServletRequestGetContextPathReturnNull() {
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
   * Test
   * {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link BroadleafTemplateContext}
   * {@link BroadleafTemplateContext#getRequest()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetBundleUrl_givenNull_whenBroadleafTemplateContextGetRequestReturnNull() {
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
   * Test
   * {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return {@code /https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetBundleUrl_thenReturnHttpsExampleOrgExample() {
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
   * Test
   * {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return
   * {@code https://example.org/example/https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetBundleUrl_thenReturnHttpsExampleOrgExampleHttpsExampleOrgExample() {
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
   * Test
   * {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetBundleUrl_thenThrowIllegalArgumentException() {
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
   * Test
   * {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetBundleUrl_whenEmptyString_thenReturnSlash() {
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
   * Test
   * {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code /null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetBundleUrl_whenNull_thenReturnNull() {
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
   * Test
   * {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractResourceProcessor#getBundleUrl(String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetBundleUrl_whenSlash_thenReturnSlash() {
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
   * Test
   * {@link AbstractResourceProcessor#buildBundledFilesList(ResourceTagAttributes)}.
   * <ul>
   *   <li>When {@link ResourceTagAttributes#ResourceTagAttributes()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractResourceProcessor#buildBundledFilesList(ResourceTagAttributes)}
   */
  @Test
  public void testBuildBundledFilesList_whenResourceTagAttributes_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    // Act and Assert
    assertTrue(resourceBundleProcessor.buildBundledFilesList(new ResourceTagAttributes()).isEmpty());
  }

  /**
   * Test
   * {@link AbstractResourceProcessor#getBundleAppendText(ResourceTagAttributes)}.
   * <p>
   * Method under test:
   * {@link AbstractResourceProcessor#getBundleAppendText(ResourceTagAttributes)}
   */
  @Test
  public void testGetBundleAppendText() {
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
   * Test
   * {@link AbstractResourceProcessor#getBundleAppendText(ResourceTagAttributes)}.
   * <ul>
   *   <li>When {@link ResourceTagAttributes#ResourceTagAttributes()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractResourceProcessor#getBundleAppendText(ResourceTagAttributes)}
   */
  @Test
  public void testGetBundleAppendText_whenResourceTagAttributes_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundleProcessor resourceBundleProcessor = new ResourceBundleProcessor();

    // Act and Assert
    assertNull(resourceBundleProcessor.getBundleAppendText(new ResourceTagAttributes()));
  }

  /**
   * Test
   * {@link AbstractResourceProcessor#getBundleCompleteEventJavaScript(ResourceTagAttributes)}.
   * <p>
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
   * Test
   * {@link AbstractResourceProcessor#validateTagAttributes(ResourceTagAttributes)}.
   * <ul>
   *   <li>When {@link ResourceTagAttributes#ResourceTagAttributes()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractResourceProcessor#validateTagAttributes(ResourceTagAttributes)}
   */
  @Test
  public void testValidateTagAttributes_whenResourceTagAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourcePreloadProcessor resourcePreloadProcessor = new ResourcePreloadProcessor();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> resourcePreloadProcessor.validateTagAttributes(new ResourceTagAttributes()));
  }

  /**
   * Test
   * {@link AbstractResourceProcessor#validateTagAttributes(ResourceTagAttributes)}.
   * <ul>
   *   <li>When {@link ResourceTagAttributes} {@link ResourceTagAttributes#name()}
   * return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractResourceProcessor#validateTagAttributes(ResourceTagAttributes)}
   */
  @Test
  public void testValidateTagAttributes_whenResourceTagAttributesNameReturnEmptyString() {
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

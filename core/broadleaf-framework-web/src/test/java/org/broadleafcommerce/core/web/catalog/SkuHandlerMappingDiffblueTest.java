/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.cors.DefaultCorsProcessor;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ExtendWith(MockitoExtension.class)
class SkuHandlerMappingDiffblueTest {
  @Mock private CatalogService catalogService;

  @InjectMocks private SkuHandlerMapping skuHandlerMapping;

  /**
   * Test {@link SkuHandlerMapping#getHandlerInternal(HttpServletRequest)}.
   *
   * <p>Method under test: {@link SkuHandlerMapping#getHandlerInternal(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getHandlerInternal(HttpServletRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SkuHandlerMapping.getHandlerInternal(HttpServletRequest)"})
  void testGetHandlerInternal() throws Exception {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest(new MockServletContext());
    request.setRequestURI(null);
    request.setContextPath(null);

    // Act and Assert
    assertNull(skuHandlerMapping.getHandlerInternal(request));
  }

  /**
   * Test {@link SkuHandlerMapping#getHandlerInternal(HttpServletRequest)}.
   *
   * <p>Method under test: {@link SkuHandlerMapping#getHandlerInternal(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getHandlerInternal(HttpServletRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SkuHandlerMapping.getHandlerInternal(HttpServletRequest)"})
  void testGetHandlerInternal2() throws Exception {
    // Arrange
    when(catalogService.findSkuByURI(Mockito.<String>any())).thenReturn(new SkuImpl());

    // Act
    Object actualHandlerInternal =
        skuHandlerMapping.getHandlerInternal(
            new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest())));

    // Assert
    verify(catalogService).findSkuByURI("");
    assertEquals("blSkuController", actualHandlerInternal);
  }

  /**
   * Test {@link SkuHandlerMapping#getHandlerInternal(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then calls {@link DefaultMultipartHttpServletRequest#getContextPath()}.
   * </ul>
   *
   * <p>Method under test: {@link SkuHandlerMapping#getHandlerInternal(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getHandlerInternal(HttpServletRequest); then calls getContextPath()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SkuHandlerMapping.getHandlerInternal(HttpServletRequest)"})
  void testGetHandlerInternal_thenCallsGetContextPath() throws Exception {
    // Arrange
    when(catalogService.findSkuByURI(Mockito.<String>any())).thenReturn(null);

    DefaultMultipartHttpServletRequest servletRequest =
        mock(DefaultMultipartHttpServletRequest.class);
    when(servletRequest.getContextPath()).thenReturn("https://example.org/example");
    when(servletRequest.getRequestURI()).thenReturn("https://example.org/example");
    SearchRequestWrapper request = new SearchRequestWrapper(servletRequest);

    // Act
    Object actualHandlerInternal =
        skuHandlerMapping.getHandlerInternal(new HttpServletRequestWrapper(request));

    // Assert
    verify(servletRequest, atLeast(1)).getContextPath();
    verify(servletRequest, atLeast(1)).getRequestURI();
    verify(catalogService).findSkuByURI("");
    assertNull(actualHandlerInternal);
  }

  /**
   * Test {@link SkuHandlerMapping#getHandlerInternal(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then return {@code blSkuController}.
   * </ul>
   *
   * <p>Method under test: {@link SkuHandlerMapping#getHandlerInternal(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getHandlerInternal(HttpServletRequest); then return 'blSkuController'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SkuHandlerMapping.getHandlerInternal(HttpServletRequest)"})
  void testGetHandlerInternal_thenReturnBlSkuController() throws Exception {
    // Arrange
    when(catalogService.findSkuByURI(Mockito.<String>any())).thenReturn(new SkuImpl());

    MockHttpServletRequest request = new MockHttpServletRequest(new MockServletContext());
    request.setRequestURI(";");
    request.setContextPath(null);

    // Act
    Object actualHandlerInternal = skuHandlerMapping.getHandlerInternal(request);

    // Assert
    verify(catalogService).findSkuByURI("");
    assertEquals("blSkuController", actualHandlerInternal);
  }

  /**
   * Test {@link SkuHandlerMapping#getHandlerInternal(HttpServletRequest)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SkuHandlerMapping#getHandlerInternal(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getHandlerInternal(HttpServletRequest); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SkuHandlerMapping.getHandlerInternal(HttpServletRequest)"})
  void testGetHandlerInternal_whenNull_thenReturnNull() throws Exception {
    // Arrange, Act and Assert
    assertNull(skuHandlerMapping.getHandlerInternal(null));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuHandlerMapping#setDefaultTemplateName(String)}
   *   <li>{@link SkuHandlerMapping#getDefaultTemplateName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SkuHandlerMapping.getDefaultTemplateName()",
    "void SkuHandlerMapping.setDefaultTemplateName(String)"
  })
  void testGettersAndSetters() {
    // Arrange
    SkuHandlerMapping skuHandlerMapping = new SkuHandlerMapping();

    // Act
    skuHandlerMapping.setDefaultTemplateName("Default Template Name");

    // Assert
    assertEquals("Default Template Name", skuHandlerMapping.getDefaultTemplateName());
  }

  /**
   * Test new {@link SkuHandlerMapping} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link SkuHandlerMapping}
   */
  @Test
  @DisplayName("Test new SkuHandlerMapping (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuHandlerMapping.<init>()"})
  void testNewSkuHandlerMapping() {
    // Arrange and Act
    SkuHandlerMapping actualSkuHandlerMapping = new SkuHandlerMapping();

    // Assert
    assertTrue(actualSkuHandlerMapping.getPathMatcher() instanceof AntPathMatcher);
    assertTrue(actualSkuHandlerMapping.getCorsProcessor() instanceof DefaultCorsProcessor);
    assertEquals("catalog/sku", actualSkuHandlerMapping.getDefaultTemplateName());
    assertNull(actualSkuHandlerMapping.getDefaultHandler());
    assertNull(actualSkuHandlerMapping.getControllerName());
    assertNull(actualSkuHandlerMapping.getCorsConfigurationSource());
    assertNull(actualSkuHandlerMapping.getPatternParser());
    assertTrue(actualSkuHandlerMapping.getUrlPathHelper().isUrlDecode());
    assertEquals(Integer.MAX_VALUE, actualSkuHandlerMapping.getOrder());
  }
}

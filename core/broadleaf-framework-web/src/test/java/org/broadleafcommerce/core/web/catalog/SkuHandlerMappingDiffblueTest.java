/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import javax.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.cors.DefaultCorsProcessor;

class SkuHandlerMappingDiffblueTest {
  /**
   * Test {@link SkuHandlerMapping#getHandlerInternal(HttpServletRequest)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} RequestURI
   * is {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuHandlerMapping#getHandlerInternal(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getHandlerInternal(HttpServletRequest); when MockHttpServletRequest() RequestURI is 'null'; then return 'null'")
  void testGetHandlerInternal_whenMockHttpServletRequestRequestURIIsNull_thenReturnNull() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuHandlerMapping skuHandlerMapping = new SkuHandlerMapping();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setRequestURI(null);
    request.setContextPath(null);

    // Act and Assert
    assertNull(skuHandlerMapping.getHandlerInternal(request));
  }

  /**
   * Test {@link SkuHandlerMapping#getHandlerInternal(HttpServletRequest)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuHandlerMapping#getHandlerInternal(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getHandlerInternal(HttpServletRequest); when 'null'; then return 'null'")
  void testGetHandlerInternal_whenNull_thenReturnNull() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SkuHandlerMapping()).getHandlerInternal(null));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SkuHandlerMapping#setDefaultTemplateName(String)}
   *   <li>{@link SkuHandlerMapping#getDefaultTemplateName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    SkuHandlerMapping skuHandlerMapping = new SkuHandlerMapping();

    // Act
    skuHandlerMapping.setDefaultTemplateName("Default Template Name");

    // Assert that nothing has changed
    assertEquals("Default Template Name", skuHandlerMapping.getDefaultTemplateName());
  }

  /**
   * Test new {@link SkuHandlerMapping} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link SkuHandlerMapping}
   */
  @Test
  @DisplayName("Test new SkuHandlerMapping (default constructor)")
  void testNewSkuHandlerMapping() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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

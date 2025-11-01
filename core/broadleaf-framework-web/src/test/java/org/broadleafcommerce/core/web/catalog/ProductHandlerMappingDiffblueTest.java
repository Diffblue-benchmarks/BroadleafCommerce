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
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.cors.DefaultCorsProcessor;

class ProductHandlerMappingDiffblueTest {
  /**
   * Method under test:
   * {@link ProductHandlerMapping#findProductUsingIdParam(HttpServletRequest)}
   */
  @Test
  void testFindProductUsingIdParam() throws ServletRequestBindingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductHandlerMapping productHandlerMapping = new ProductHandlerMapping();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertNull(
        productHandlerMapping.findProductUsingIdParam(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProductHandlerMapping#setDefaultTemplateName(String)}
   *   <li>{@link ProductHandlerMapping#getDefaultTemplateName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    ProductHandlerMapping productHandlerMapping = new ProductHandlerMapping();

    // Act
    productHandlerMapping.setDefaultTemplateName("Default Template Name");

    // Assert that nothing has changed
    assertEquals("Default Template Name", productHandlerMapping.getDefaultTemplateName());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ProductHandlerMapping}
   */
  @Test
  void testNewProductHandlerMapping() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    ProductHandlerMapping actualProductHandlerMapping = new ProductHandlerMapping();

    // Assert
    assertTrue(actualProductHandlerMapping.getPathMatcher() instanceof AntPathMatcher);
    assertTrue(actualProductHandlerMapping.getCorsProcessor() instanceof DefaultCorsProcessor);
    assertEquals("catalog/product", actualProductHandlerMapping.getDefaultTemplateName());
    assertNull(actualProductHandlerMapping.getDefaultHandler());
    assertNull(actualProductHandlerMapping.getControllerName());
    assertNull(actualProductHandlerMapping.charEncoding);
    assertNull(actualProductHandlerMapping.catalogService);
    assertNull(actualProductHandlerMapping.getCorsConfigurationSource());
    assertNull(actualProductHandlerMapping.getPatternParser());
    assertTrue(actualProductHandlerMapping.getUrlPathHelper().isUrlDecode());
    assertEquals(Integer.MAX_VALUE, actualProductHandlerMapping.getOrder());
  }
}

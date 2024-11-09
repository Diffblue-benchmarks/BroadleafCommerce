/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import javax.servlet.http.HttpServletRequest;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.DefaultCorsProcessor;

public class PageHandlerMappingDiffblueTest {
  /**
   * Test {@link PageHandlerMapping#getHandlerInternal(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link PageHandlerMapping#getHandlerInternal(HttpServletRequest)}
   */
  @Test
  public void testGetHandlerInternal() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageHandlerMapping pageHandlerMapping = new PageHandlerMapping();
    pageHandlerMapping.setCorsConfigurationSource(mock(CorsConfigurationSource.class));

    // Act and Assert
    assertNull(pageHandlerMapping.getHandlerInternal(new MockHttpServletRequest()));
  }

  /**
   * Test {@link PageHandlerMapping#getHandlerInternal(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@link PageHandlerMapping} (default constructor).</li>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageHandlerMapping#getHandlerInternal(HttpServletRequest)}
   */
  @Test
  public void testGetHandlerInternal_givenPageHandlerMapping_whenMockHttpServletRequest() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageHandlerMapping pageHandlerMapping = new PageHandlerMapping();

    // Act and Assert
    assertNull(pageHandlerMapping.getHandlerInternal(new MockHttpServletRequest()));
  }

  /**
   * Test {@link PageHandlerMapping#getHandlerInternal(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@link PageHandlerMapping} (default constructor).</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageHandlerMapping#getHandlerInternal(HttpServletRequest)}
   */
  @Test
  public void testGetHandlerInternal_givenPageHandlerMapping_whenNull() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new PageHandlerMapping()).getHandlerInternal(null));
  }

  /**
   * Test new {@link PageHandlerMapping} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link PageHandlerMapping}
   */
  @Test
  public void testNewPageHandlerMapping() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    PageHandlerMapping actualPageHandlerMapping = new PageHandlerMapping();

    // Assert
    assertTrue(actualPageHandlerMapping.getPathMatcher() instanceof AntPathMatcher);
    assertTrue(actualPageHandlerMapping.getCorsProcessor() instanceof DefaultCorsProcessor);
    assertNull(actualPageHandlerMapping.getDefaultHandler());
    assertNull(actualPageHandlerMapping.getControllerName());
    assertNull(actualPageHandlerMapping.charEncoding);
    assertNull(actualPageHandlerMapping.getCorsConfigurationSource());
    assertNull(actualPageHandlerMapping.getPatternParser());
    assertTrue(actualPageHandlerMapping.getUrlPathHelper().isUrlDecode());
    assertEquals(Integer.MAX_VALUE, actualPageHandlerMapping.getOrder());
  }
}

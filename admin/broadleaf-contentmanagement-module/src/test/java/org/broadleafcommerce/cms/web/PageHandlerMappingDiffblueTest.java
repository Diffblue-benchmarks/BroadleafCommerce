/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.cms.page.service.PageService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.env.Environment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.cors.DefaultCorsProcessor;

@RunWith(MockitoJUnitRunner.class)
public class PageHandlerMappingDiffblueTest {
  @Mock
  private Environment environment;

  @InjectMocks
  private PageHandlerMapping pageHandlerMapping;

  @Mock
  private PageService pageService;

  /**
   * Test {@link PageHandlerMapping#getHandlerInternal(HttpServletRequest)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageHandlerMapping#getHandlerInternal(HttpServletRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Object PageHandlerMapping.getHandlerInternal(HttpServletRequest)"})
  public void testGetHandlerInternal_whenMockHttpServletRequest() throws Exception {
    // Arrange, Act and Assert
    assertNull(pageHandlerMapping.getHandlerInternal(new MockHttpServletRequest()));
  }

  /**
   * Test {@link PageHandlerMapping#getHandlerInternal(HttpServletRequest)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageHandlerMapping#getHandlerInternal(HttpServletRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Object PageHandlerMapping.getHandlerInternal(HttpServletRequest)"})
  public void testGetHandlerInternal_whenNull() throws Exception {
    // Arrange, Act and Assert
    assertNull(pageHandlerMapping.getHandlerInternal(null));
  }

  /**
   * Test new {@link PageHandlerMapping} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link PageHandlerMapping}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageHandlerMapping.<init>()"})
  public void testNewPageHandlerMapping() {
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

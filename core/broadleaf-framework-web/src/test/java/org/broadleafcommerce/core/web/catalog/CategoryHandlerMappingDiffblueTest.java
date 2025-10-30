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
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.cors.DefaultCorsProcessor;

@ExtendWith(MockitoExtension.class)
class CategoryHandlerMappingDiffblueTest {
  @InjectMocks
  private CategoryHandlerMapping categoryHandlerMapping;

  @Mock
  private Environment environment;

  /**
   * Test {@link CategoryHandlerMapping#findCategoryUsingIdParam(HttpServletRequest)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryHandlerMapping#findCategoryUsingIdParam(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test findCategoryUsingIdParam(HttpServletRequest); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.broadleafcommerce.core.catalog.domain.Category CategoryHandlerMapping.findCategoryUsingIdParam(HttpServletRequest)"})
  void testFindCategoryUsingIdParam_thenReturnNull() throws ServletRequestBindingException {
    // Arrange, Act and Assert
    assertNull(categoryHandlerMapping.findCategoryUsingIdParam(new SearchRequestWrapper(
        new XssRequestWrapper(new MockHttpServletRequest(), environment, new String[]{"White List Param Names"}))));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CategoryHandlerMapping#setDefaultTemplateName(String)}
   *   <li>{@link CategoryHandlerMapping#getDefaultTemplateName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CategoryHandlerMapping.getDefaultTemplateName()",
      "void CategoryHandlerMapping.setDefaultTemplateName(String)"})
  void testGettersAndSetters() {
    // Arrange
    CategoryHandlerMapping categoryHandlerMapping = new CategoryHandlerMapping();

    // Act
    categoryHandlerMapping.setDefaultTemplateName("Default Template Name");

    // Assert
    assertEquals("Default Template Name", categoryHandlerMapping.getDefaultTemplateName());
  }

  /**
   * Test new {@link CategoryHandlerMapping} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link CategoryHandlerMapping}
   */
  @Test
  @DisplayName("Test new CategoryHandlerMapping (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CategoryHandlerMapping.<init>()"})
  void testNewCategoryHandlerMapping() {
    // Arrange and Act
    CategoryHandlerMapping actualCategoryHandlerMapping = new CategoryHandlerMapping();

    // Assert
    assertTrue(actualCategoryHandlerMapping.getPathMatcher() instanceof AntPathMatcher);
    assertTrue(actualCategoryHandlerMapping.getCorsProcessor() instanceof DefaultCorsProcessor);
    assertEquals("catalog/category", actualCategoryHandlerMapping.getDefaultTemplateName());
    assertNull(actualCategoryHandlerMapping.getDefaultHandler());
    assertNull(actualCategoryHandlerMapping.getControllerName());
    assertNull(actualCategoryHandlerMapping.charEncoding);
    assertNull(actualCategoryHandlerMapping.getCorsConfigurationSource());
    assertNull(actualCategoryHandlerMapping.getPatternParser());
    assertTrue(actualCategoryHandlerMapping.getUrlPathHelper().isUrlDecode());
    assertEquals(Integer.MAX_VALUE, actualCategoryHandlerMapping.getOrder());
  }
}

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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertyResolver;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.cors.DefaultCorsProcessor;

@ExtendWith(MockitoExtension.class)
class ProductHandlerMappingDiffblueTest {
  @Mock
  private Environment environment;

  @InjectMocks
  private ProductHandlerMapping productHandlerMapping;

  /**
   * Test {@link ProductHandlerMapping#shouldSkipExecution(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@link Environment} {@link PropertyResolver#getProperty(String, Class, Object)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductHandlerMapping#shouldSkipExecution(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test shouldSkipExecution(HttpServletRequest); given Environment getProperty(String, Class, Object) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProductHandlerMapping.shouldSkipExecution(HttpServletRequest)"})
  void testShouldSkipExecution_givenEnvironmentGetPropertyReturnFalse() throws ServletRequestBindingException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(false);

    // Act
    boolean actualShouldSkipExecutionResult = productHandlerMapping.shouldSkipExecution(new SearchRequestWrapper(
        new XssRequestWrapper(new MockHttpServletRequest(), environment, new String[]{"White List Param Names"})));

    // Assert
    verify(environment).getProperty(eq("allowCategoryResolutionUsingIdParam"), isA(Class.class), isA(Object.class));
    assertFalse(actualShouldSkipExecutionResult);
  }

  /**
   * Test {@link ProductHandlerMapping#shouldSkipExecution(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@link Environment} {@link PropertyResolver#getProperty(String, Class, Object)} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductHandlerMapping#shouldSkipExecution(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test shouldSkipExecution(HttpServletRequest); given Environment getProperty(String, Class, Object) return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProductHandlerMapping.shouldSkipExecution(HttpServletRequest)"})
  void testShouldSkipExecution_givenEnvironmentGetPropertyReturnTrue() throws ServletRequestBindingException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);

    // Act
    boolean actualShouldSkipExecutionResult = productHandlerMapping.shouldSkipExecution(new SearchRequestWrapper(
        new XssRequestWrapper(new MockHttpServletRequest(), environment, new String[]{"White List Param Names"})));

    // Assert
    verify(environment).getProperty(eq("allowCategoryResolutionUsingIdParam"), isA(Class.class), isA(Object.class));
    assertFalse(actualShouldSkipExecutionResult);
  }

  /**
   * Test {@link ProductHandlerMapping#findProductUsingIdParam(HttpServletRequest)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductHandlerMapping#findProductUsingIdParam(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test findProductUsingIdParam(HttpServletRequest); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.broadleafcommerce.core.catalog.domain.Product ProductHandlerMapping.findProductUsingIdParam(HttpServletRequest)"})
  void testFindProductUsingIdParam_thenReturnNull() throws ServletRequestBindingException {
    // Arrange, Act and Assert
    assertNull(productHandlerMapping.findProductUsingIdParam(new SearchRequestWrapper(
        new XssRequestWrapper(new MockHttpServletRequest(), environment, new String[]{"White List Param Names"}))));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductHandlerMapping#setDefaultTemplateName(String)}
   *   <li>{@link ProductHandlerMapping#getDefaultTemplateName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ProductHandlerMapping.getDefaultTemplateName()",
      "void ProductHandlerMapping.setDefaultTemplateName(String)"})
  void testGettersAndSetters() {
    // Arrange
    ProductHandlerMapping productHandlerMapping = new ProductHandlerMapping();

    // Act
    productHandlerMapping.setDefaultTemplateName("Default Template Name");

    // Assert
    assertEquals("Default Template Name", productHandlerMapping.getDefaultTemplateName());
  }

  /**
   * Test new {@link ProductHandlerMapping} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link ProductHandlerMapping}
   */
  @Test
  @DisplayName("Test new ProductHandlerMapping (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ProductHandlerMapping.<init>()"})
  void testNewProductHandlerMapping() {
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

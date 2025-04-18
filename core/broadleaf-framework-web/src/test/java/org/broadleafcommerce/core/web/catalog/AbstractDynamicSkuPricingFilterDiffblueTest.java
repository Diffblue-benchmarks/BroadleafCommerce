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

import static org.mockito.Mockito.mock;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.broadleafcommerce.core.catalog.service.dynamic.DynamicSkuPricingService;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.broadleafcommerce.profile.web.core.CustomerState;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockFilterConfig;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {DefaultDynamicSkuPricingFilter.class})
@ExtendWith(SpringExtension.class)
class AbstractDynamicSkuPricingFilterDiffblueTest {
  @Autowired
  private AbstractDynamicSkuPricingFilter abstractDynamicSkuPricingFilter;

  @MockBean(name = "blCustomerState")
  private CustomerState customerState;

  @MockBean(name = "blDynamicSkuPricingService")
  private DynamicSkuPricingService dynamicSkuPricingService;

  /**
   * Test {@link AbstractDynamicSkuPricingFilter#destroy()}.
   * <p>
   * Method under test: {@link AbstractDynamicSkuPricingFilter#destroy()}
   */
  @Test
  @DisplayName("Test destroy()")
  void testDestroy() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    abstractDynamicSkuPricingFilter.destroy();
  }

  /**
   * Test
   * {@link AbstractDynamicSkuPricingFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   * <p>
   * Method under test:
   * {@link AbstractDynamicSkuPricingFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  @DisplayName("Test doFilter(ServletRequest, ServletResponse, FilterChain)")
  @Disabled("TODO: Complete this test")
  void testDoFilter() throws IOException, ServletException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.web.BroadleafRequestCustomerResolverImpl.getRequestCustomerResolver(BroadleafRequestCustomerResolverImpl.java:79)
    //       at org.broadleafcommerce.profile.web.core.CustomerState.getCustomer(CustomerState.java:39)
    //       at org.broadleafcommerce.core.web.catalog.DefaultDynamicSkuPricingFilter.getPricingConsiderations(DefaultDynamicSkuPricingFilter.java:58)
    //       at org.broadleafcommerce.core.web.catalog.AbstractDynamicSkuPricingFilter.doFilter(AbstractDynamicSkuPricingFilter.java:41)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act
    abstractDynamicSkuPricingFilter.doFilter(request, new MockHttpServletResponse(), mock(FilterChain.class));
  }

  /**
   * Test {@link AbstractDynamicSkuPricingFilter#init(FilterConfig)}.
   * <ul>
   *   <li>When {@link MockFilterConfig#MockFilterConfig()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDynamicSkuPricingFilter#init(FilterConfig)}
   */
  @Test
  @DisplayName("Test init(FilterConfig); when MockFilterConfig()")
  void testInit_whenMockFilterConfig() throws ServletException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    abstractDynamicSkuPricingFilter.init(new MockFilterConfig());
  }
}

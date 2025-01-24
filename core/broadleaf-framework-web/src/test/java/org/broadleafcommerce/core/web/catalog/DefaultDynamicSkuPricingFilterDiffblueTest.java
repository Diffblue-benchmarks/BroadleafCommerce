package org.broadleafcommerce.core.web.catalog;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import javax.servlet.ServletRequest;
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
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ContextConfiguration(classes = {DefaultDynamicSkuPricingFilter.class})
@ExtendWith(SpringExtension.class)
class DefaultDynamicSkuPricingFilterDiffblueTest {
  @MockBean(name = "blCustomerState")
  private CustomerState customerState;

  @Autowired
  private DefaultDynamicSkuPricingFilter defaultDynamicSkuPricingFilter;

  @MockBean(name = "blDynamicSkuPricingService")
  private DynamicSkuPricingService dynamicSkuPricingService;

  /**
   * Test
   * {@link DefaultDynamicSkuPricingFilter#getDynamicSkuPricingService(ServletRequest)}.
   * <p>
   * Method under test:
   * {@link DefaultDynamicSkuPricingFilter#getDynamicSkuPricingService(ServletRequest)}
   */
  @Test
  @DisplayName("Test getDynamicSkuPricingService(ServletRequest)")
  void testGetDynamicSkuPricingService() {
    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertSame(defaultDynamicSkuPricingFilter.skuPricingService,
        defaultDynamicSkuPricingFilter
            .getDynamicSkuPricingService(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
                new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));
  }

  /**
   * Test
   * {@link DefaultDynamicSkuPricingFilter#getDynamicSkuPricingService(ServletRequest)}.
   * <p>
   * Method under test:
   * {@link DefaultDynamicSkuPricingFilter#getDynamicSkuPricingService(ServletRequest)}
   */
  @Test
  @DisplayName("Test getDynamicSkuPricingService(ServletRequest)")
  void testGetDynamicSkuPricingService2() {
    // Arrange
    DefaultMultipartHttpServletRequest servletRequest = mock(DefaultMultipartHttpServletRequest.class);

    // Act and Assert
    assertSame(defaultDynamicSkuPricingFilter.skuPricingService,
        defaultDynamicSkuPricingFilter
            .getDynamicSkuPricingService(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
                new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));
  }

  /**
   * Test
   * {@link DefaultDynamicSkuPricingFilter#getPricingConsiderations(ServletRequest)}.
   * <p>
   * Method under test:
   * {@link DefaultDynamicSkuPricingFilter#getPricingConsiderations(ServletRequest)}
   */
  @Test
  @DisplayName("Test getPricingConsiderations(ServletRequest)")
  @Disabled("TODO: Complete this test")
  void testGetPricingConsiderations() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.web.BroadleafRequestCustomerResolverImpl.getRequestCustomerResolver(BroadleafRequestCustomerResolverImpl.java:79)
    //       at org.broadleafcommerce.profile.web.core.CustomerState.getCustomer(CustomerState.java:39)
    //       at org.broadleafcommerce.core.web.catalog.DefaultDynamicSkuPricingFilter.getPricingConsiderations(DefaultDynamicSkuPricingFilter.java:58)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    defaultDynamicSkuPricingFilter
        .getPricingConsiderations(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));
  }

  /**
   * Test new {@link DefaultDynamicSkuPricingFilter} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link DefaultDynamicSkuPricingFilter}
   */
  @Test
  @DisplayName("Test new DefaultDynamicSkuPricingFilter (default constructor)")
  void testNewDefaultDynamicSkuPricingFilter() {
    // Arrange and Act
    DefaultDynamicSkuPricingFilter actualDefaultDynamicSkuPricingFilter = new DefaultDynamicSkuPricingFilter();

    // Assert
    assertNull(actualDefaultDynamicSkuPricingFilter.skuPricingService);
    assertNull(actualDefaultDynamicSkuPricingFilter.customerState);
  }
}

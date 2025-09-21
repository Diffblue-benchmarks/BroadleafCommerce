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

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.broadleafcommerce.core.catalog.service.dynamic.DynamicSkuPricingService;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.profile.web.core.CustomerState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {DefaultDynamicSkuPricingFilter.class})
@ExtendWith(SpringExtension.class)
class DefaultDynamicSkuPricingFilterDiffblueTest {
  @MockBean(name = "blCustomerState")
  private CustomerState customerState;

  @Autowired private DefaultDynamicSkuPricingFilter defaultDynamicSkuPricingFilter;

  @MockBean(name = "blDynamicSkuPricingService")
  private DynamicSkuPricingService dynamicSkuPricingService;

  /**
   * Test {@link DefaultDynamicSkuPricingFilter#getDynamicSkuPricingService(ServletRequest)}.
   *
   * <p>Method under test: {@link
   * DefaultDynamicSkuPricingFilter#getDynamicSkuPricingService(ServletRequest)}
   */
  @Test
  @DisplayName("Test getDynamicSkuPricingService(ServletRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DynamicSkuPricingService DefaultDynamicSkuPricingFilter.getDynamicSkuPricingService(ServletRequest)"
  })
  void testGetDynamicSkuPricingService() {
    // Arrange and Act
    DynamicSkuPricingService actualDynamicSkuPricingService =
        defaultDynamicSkuPricingFilter.getDynamicSkuPricingService(
            new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest())));

    // Assert
    assertSame(defaultDynamicSkuPricingFilter.skuPricingService, actualDynamicSkuPricingService);
  }

  /**
   * Test new {@link DefaultDynamicSkuPricingFilter} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * DefaultDynamicSkuPricingFilter}
   */
  @Test
  @DisplayName("Test new DefaultDynamicSkuPricingFilter (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultDynamicSkuPricingFilter.<init>()"})
  void testNewDefaultDynamicSkuPricingFilter() {
    // Arrange and Act
    DefaultDynamicSkuPricingFilter actualDefaultDynamicSkuPricingFilter =
        new DefaultDynamicSkuPricingFilter();

    // Assert
    assertNull(actualDefaultDynamicSkuPricingFilter.skuPricingService);
    assertNull(actualDefaultDynamicSkuPricingFilter.customerState);
  }
}

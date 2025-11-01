/*-
 * #%L
 * BroadleafCommerce Profile Web
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
package org.broadleafcommerce.profile.web.core.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.broadleafcommerce.profile.core.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(classes = {RestApiCustomerStateFilter.class})
@WebAppConfiguration
@ExtendWith(SpringExtension.class)
class RestApiCustomerStateFilterDiffblueTest {
  @MockBean(name = "blCustomerService")
  private CustomerService customerService;

  @Autowired
  private RestApiCustomerStateFilter restApiCustomerStateFilter;

  /**
   * Method under test: {@link RestApiCustomerStateFilter#getOrder()}
   */
  @Test
  void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(2000, restApiCustomerStateFilter.getOrder());
  }

  /**
   * Method under test:
   * {@link RestApiCustomerStateFilter#getCustomerIdAttributeName()}
   */
  @Test
  void testGetCustomerIdAttributeName() {
    // Arrange, Act and Assert
    assertEquals(RestApiCustomerStateFilter.CUSTOMER_ID_ATTRIBUTE,
        (new RestApiCustomerStateFilter()).getCustomerIdAttributeName());
  }
}

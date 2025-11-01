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
package org.broadleafcommerce.profile.web.site.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

class CustomerStateFilterDiffblueTest {
  /**
   * Method under test:
   * {@link CustomerStateFilter#isIgnored(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  void testIsIgnored() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerStateFilter customerStateFilter = new CustomerStateFilter();
    MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertFalse(customerStateFilter.isIgnored(httpServletRequest, new MockHttpServletResponse()));
  }

  /**
   * Method under test:
   * {@link CustomerStateFilter#isIgnored(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  void testIsIgnored2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerStateFilter customerStateFilter = new CustomerStateFilter();
    DefaultMultipartHttpServletRequest httpServletRequest = mock(DefaultMultipartHttpServletRequest.class);
    when(httpServletRequest.getAttribute(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualIsIgnoredResult = customerStateFilter.isIgnored(httpServletRequest, new MockHttpServletResponse());

    // Assert
    verify(httpServletRequest).getAttribute(eq("blUriIsFilterIgnored"));
    assertTrue(actualIsIgnoredResult);
  }

  /**
   * Method under test:
   * {@link CustomerStateFilter#isIgnored(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  void testIsIgnored3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerStateFilter customerStateFilter = new CustomerStateFilter();
    DefaultMultipartHttpServletRequest httpServletRequest = mock(DefaultMultipartHttpServletRequest.class);
    when(httpServletRequest.getAttribute(Mockito.<String>any())).thenReturn(false);

    // Act
    boolean actualIsIgnoredResult = customerStateFilter.isIgnored(httpServletRequest, new MockHttpServletResponse());

    // Assert
    verify(httpServletRequest, atLeast(1)).getAttribute(Mockito.<String>any());
    assertTrue(actualIsIgnoredResult);
  }

  /**
   * Method under test: {@link CustomerStateFilter#getOrder()}
   */
  @Test
  void testGetOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(10050, (new CustomerStateFilter()).getOrder());
  }

  /**
   * Method under test: {@link CustomerStateFilter#getOrder()}
   */
  @Test
  void testGetOrder2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerStateFilter customerStateFilter = new CustomerStateFilter();
    customerStateFilter.setEnvironment(mock(StandardEnvironment.class));

    // Act and Assert
    assertEquals(10050, customerStateFilter.getOrder());
  }

  /**
   * Method under test: {@link CustomerStateFilter#shouldNotFilterErrorDispatch()}
   */
  @Test
  void testShouldNotFilterErrorDispatch() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new CustomerStateFilter()).shouldNotFilterErrorDispatch());
  }

  /**
   * Method under test: {@link CustomerStateFilter#shouldNotFilterErrorDispatch()}
   */
  @Test
  void testShouldNotFilterErrorDispatch2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerStateFilter customerStateFilter = new CustomerStateFilter();
    customerStateFilter.setEnvironment(mock(StandardEnvironment.class));

    // Act and Assert
    assertFalse(customerStateFilter.shouldNotFilterErrorDispatch());
  }
}

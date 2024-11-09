/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

public class BroadleafRequestCustomerResolverImplDiffblueTest {
  /**
   * Test
   * {@link BroadleafRequestCustomerResolverImpl#getCustomer(HttpServletRequest)}
   * with {@code HttpServletRequest}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>Then calls {@link ServletRequestWrapper#getAttribute(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafRequestCustomerResolverImpl#getCustomer(HttpServletRequest)}
   */
  @Test
  public void testGetCustomerWithHttpServletRequest_givenNull_field_thenCallsGetAttribute() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestCustomerResolverImpl broadleafRequestCustomerResolverImpl = new BroadleafRequestCustomerResolverImpl();
    SessionlessHttpServletRequestWrapper request = mock(SessionlessHttpServletRequestWrapper.class);
    when(request.getAttribute(Mockito.<String>any())).thenReturn(BLCFieldUtils.NULL_FIELD);

    // Act
    broadleafRequestCustomerResolverImpl.getCustomer(new SessionlessHttpServletRequestWrapper(request));

    // Assert
    verify(request).getAttribute(eq("Customer Request Attribute Name"));
  }

  /**
   * Test
   * {@link BroadleafRequestCustomerResolverImpl#getCustomer(HttpServletRequest)}
   * with {@code HttpServletRequest}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafRequestCustomerResolverImpl#getCustomer(HttpServletRequest)}
   */
  @Test
  public void testGetCustomerWithHttpServletRequest_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestCustomerResolverImpl broadleafRequestCustomerResolverImpl = new BroadleafRequestCustomerResolverImpl();

    // Act and Assert
    assertNull(broadleafRequestCustomerResolverImpl
        .getCustomer(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())));
  }

  /**
   * Test {@link BroadleafRequestCustomerResolverImpl#getCustomer(WebRequest)}
   * with {@code WebRequest}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>Then calls {@link ServletRequestWrapper#getAttribute(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafRequestCustomerResolverImpl#getCustomer(WebRequest)}
   */
  @Test
  public void testGetCustomerWithWebRequest_givenNull_field_thenCallsGetAttribute() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestCustomerResolverImpl broadleafRequestCustomerResolverImpl = new BroadleafRequestCustomerResolverImpl();
    SessionlessHttpServletRequestWrapper request = mock(SessionlessHttpServletRequestWrapper.class);
    when(request.getAttribute(Mockito.<String>any())).thenReturn(BLCFieldUtils.NULL_FIELD);

    // Act
    broadleafRequestCustomerResolverImpl
        .getCustomer(new ServletWebRequest(new SessionlessHttpServletRequestWrapper(request)));

    // Assert
    verify(request).getAttribute(eq("Customer Request Attribute Name"));
  }

  /**
   * Test {@link BroadleafRequestCustomerResolverImpl#getCustomer(WebRequest)}
   * with {@code WebRequest}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafRequestCustomerResolverImpl#getCustomer(WebRequest)}
   */
  @Test
  public void testGetCustomerWithWebRequest_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestCustomerResolverImpl broadleafRequestCustomerResolverImpl = new BroadleafRequestCustomerResolverImpl();

    // Act and Assert
    assertNull(broadleafRequestCustomerResolverImpl
        .getCustomer(new ServletWebRequest(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()))));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link BroadleafRequestCustomerResolverImpl#setApplicationContext(ApplicationContext)}
   *   <li>
   * {@link BroadleafRequestCustomerResolverImpl#setCustomerRequestAttributeName(String)}
   *   <li>
   * {@link BroadleafRequestCustomerResolverImpl#getCustomerRequestAttributeName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws BeansException {
    // Arrange
    BroadleafRequestCustomerResolverImpl broadleafRequestCustomerResolverImpl = new BroadleafRequestCustomerResolverImpl();

    // Act
    broadleafRequestCustomerResolverImpl.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());
    broadleafRequestCustomerResolverImpl.setCustomerRequestAttributeName("Customer Request Attribute Name");

    // Assert that nothing has changed
    assertEquals("Customer Request Attribute Name",
        broadleafRequestCustomerResolverImpl.getCustomerRequestAttributeName());
  }
}

/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@ContextConfiguration(classes = {BroadleafRequestCustomerResolverImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafRequestCustomerResolverImplDiffblueTest {
  @Autowired
  private BroadleafRequestCustomerResolverImpl broadleafRequestCustomerResolverImpl;

  /**
   * Test {@link BroadleafRequestCustomerResolverImpl#getCustomer(HttpServletRequest)} with {@code HttpServletRequest}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafRequestCustomerResolverImpl#getCustomer(HttpServletRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Object BroadleafRequestCustomerResolverImpl.getCustomer(HttpServletRequest)"})
  public void testGetCustomerWithHttpServletRequest_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(broadleafRequestCustomerResolverImpl
        .getCustomer(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())));
  }

  /**
   * Test {@link BroadleafRequestCustomerResolverImpl#getCustomer(WebRequest)} with {@code WebRequest}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafRequestCustomerResolverImpl#getCustomer(WebRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Object BroadleafRequestCustomerResolverImpl.getCustomer(WebRequest)"})
  public void testGetCustomerWithWebRequest_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(broadleafRequestCustomerResolverImpl
        .getCustomer(new ServletWebRequest(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()))));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BroadleafRequestCustomerResolverImpl#setApplicationContext(ApplicationContext)}
   *   <li>{@link BroadleafRequestCustomerResolverImpl#setCustomerRequestAttributeName(String)}
   *   <li>{@link BroadleafRequestCustomerResolverImpl#getCustomerRequestAttributeName()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BroadleafRequestCustomerResolverImpl.getCustomerRequestAttributeName()",
      "void BroadleafRequestCustomerResolverImpl.setApplicationContext(ApplicationContext)",
      "void BroadleafRequestCustomerResolverImpl.setCustomerRequestAttributeName(String)"})
  public void testGettersAndSetters() throws BeansException {
    // Arrange
    BroadleafRequestCustomerResolverImpl broadleafRequestCustomerResolverImpl = new BroadleafRequestCustomerResolverImpl();

    // Act
    broadleafRequestCustomerResolverImpl.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());
    broadleafRequestCustomerResolverImpl.setCustomerRequestAttributeName("Customer Request Attribute Name");

    // Assert
    assertEquals("Customer Request Attribute Name",
        broadleafRequestCustomerResolverImpl.getCustomerRequestAttributeName());
  }
}

/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.linkeddata.generator;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

class DefaultLinkedDataGeneratorImplDiffblueTest {
  /**
   * Test {@link DefaultLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link DefaultLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test canHandle(HttpServletRequest)")
  void testCanHandle() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorImpl defaultLinkedDataGeneratorImpl = new DefaultLinkedDataGeneratorImpl();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertTrue(defaultLinkedDataGeneratorImpl.canHandle(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));
  }

  /**
   * Test {@link DefaultLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link DefaultLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test canHandle(HttpServletRequest)")
  void testCanHandle2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorImpl defaultLinkedDataGeneratorImpl = new DefaultLinkedDataGeneratorImpl();
    DefaultMultipartHttpServletRequest servletRequest = mock(DefaultMultipartHttpServletRequest.class);

    // Act and Assert
    assertTrue(defaultLinkedDataGeneratorImpl.canHandle(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));
  }
}

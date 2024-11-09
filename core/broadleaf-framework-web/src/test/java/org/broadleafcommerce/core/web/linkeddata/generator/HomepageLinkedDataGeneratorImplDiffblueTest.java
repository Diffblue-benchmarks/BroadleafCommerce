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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

class HomepageLinkedDataGeneratorImplDiffblueTest {
  /**
   * Test {@link HomepageLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link HomepageLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test canHandle(HttpServletRequest)")
  void testCanHandle() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HomepageLinkedDataGeneratorImpl homepageLinkedDataGeneratorImpl = new HomepageLinkedDataGeneratorImpl();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertFalse(homepageLinkedDataGeneratorImpl.canHandle(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));
  }

  /**
   * Test {@link HomepageLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HomepageLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test canHandle(HttpServletRequest); given 'https://example.org/example'")
  void testCanHandle_givenHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HomepageLinkedDataGeneratorImpl homepageLinkedDataGeneratorImpl = new HomepageLinkedDataGeneratorImpl();
    DefaultMultipartHttpServletRequest servletRequest = mock(DefaultMultipartHttpServletRequest.class);
    when(servletRequest.getRequestURI()).thenReturn("https://example.org/example");

    // Act
    boolean actualCanHandleResult = homepageLinkedDataGeneratorImpl
        .canHandle(new SearchRequestWrapper(new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
            new String[]{"White List Param Names"})));

    // Assert
    verify(servletRequest).getRequestURI();
    assertFalse(actualCanHandleResult);
  }

  /**
   * Test {@link HomepageLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code /}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HomepageLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test canHandle(HttpServletRequest); given '/'; then return 'true'")
  void testCanHandle_givenSlash_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HomepageLinkedDataGeneratorImpl homepageLinkedDataGeneratorImpl = new HomepageLinkedDataGeneratorImpl();
    DefaultMultipartHttpServletRequest servletRequest = mock(DefaultMultipartHttpServletRequest.class);
    when(servletRequest.getRequestURI()).thenReturn("/");

    // Act
    boolean actualCanHandleResult = homepageLinkedDataGeneratorImpl
        .canHandle(new SearchRequestWrapper(new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
            new String[]{"White List Param Names"})));

    // Assert
    verify(servletRequest).getRequestURI();
    assertTrue(actualCanHandleResult);
  }
}

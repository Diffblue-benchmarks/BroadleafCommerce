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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.profile.web.core.security.CustomerStateRequestProcessor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ContextConfiguration(classes = {CustomerStateFilter.class})
@WebAppConfiguration
@ExtendWith(SpringExtension.class)
class CustomerStateFilterDiffblueTest {
  @Autowired
  private CustomerStateFilter customerStateFilter;

  @MockBean(name = "blCustomerStateRequestProcessor")
  private CustomerStateRequestProcessor customerStateRequestProcessor;

  /**
   * Test {@link CustomerStateFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerStateFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @DisplayName("Test doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain); given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void CustomerStateFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"})
  void testDoFilterInternalUnlessIgnored_givenIOExceptionWithFoo_thenThrowIOException()
      throws IOException, ServletException {
    // Arrange
    doNothing().when(customerStateRequestProcessor).postProcess(Mockito.<WebRequest>any());
    doNothing().when(customerStateRequestProcessor).process(Mockito.<WebRequest>any());
    MockHttpServletRequest baseRequest = new MockHttpServletRequest();
    MockHttpServletResponse baseResponse = new MockHttpServletResponse();
    FilterChain chain = mock(FilterChain.class);
    doThrow(new IOException("foo")).when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(IOException.class,
        () -> customerStateFilter.doFilterInternalUnlessIgnored(baseRequest, baseResponse, chain));
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(customerStateRequestProcessor).postProcess(isA(WebRequest.class));
    verify(customerStateRequestProcessor).process(isA(WebRequest.class));
  }

  /**
   * Test {@link CustomerStateFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   *   <li>Then calls {@link FilterChain#doFilter(ServletRequest, ServletResponse)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerStateFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @DisplayName("Test doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain); when MockHttpServletRequest(); then calls doFilter(ServletRequest, ServletResponse)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void CustomerStateFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"})
  void testDoFilterInternalUnlessIgnored_whenMockHttpServletRequest_thenCallsDoFilter()
      throws IOException, ServletException {
    // Arrange
    doNothing().when(customerStateRequestProcessor).postProcess(Mockito.<WebRequest>any());
    doNothing().when(customerStateRequestProcessor).process(Mockito.<WebRequest>any());
    MockHttpServletRequest baseRequest = new MockHttpServletRequest();
    MockHttpServletResponse baseResponse = new MockHttpServletResponse();
    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    customerStateFilter.doFilterInternalUnlessIgnored(baseRequest, baseResponse, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(customerStateRequestProcessor).postProcess(isA(WebRequest.class));
    verify(customerStateRequestProcessor).process(isA(WebRequest.class));
  }

  /**
   * Test {@link CustomerStateFilter#isIgnored(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerStateFilter#isIgnored(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test isIgnored(HttpServletRequest, HttpServletResponse); given 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CustomerStateFilter.isIgnored(HttpServletRequest, HttpServletResponse)"})
  void testIsIgnored_givenFalse() {
    // Arrange
    DefaultMultipartHttpServletRequest httpServletRequest = mock(DefaultMultipartHttpServletRequest.class);
    when(httpServletRequest.getAttribute(Mockito.<String>any())).thenReturn(false);

    // Act
    boolean actualIsIgnoredResult = customerStateFilter.isIgnored(httpServletRequest, new MockHttpServletResponse());

    // Assert
    verify(httpServletRequest, atLeast(1)).getAttribute(Mockito.<String>any());
    assertTrue(actualIsIgnoredResult);
  }

  /**
   * Test {@link CustomerStateFilter#isIgnored(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerStateFilter#isIgnored(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test isIgnored(HttpServletRequest, HttpServletResponse); given 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CustomerStateFilter.isIgnored(HttpServletRequest, HttpServletResponse)"})
  void testIsIgnored_givenTrue() {
    // Arrange
    DefaultMultipartHttpServletRequest httpServletRequest = mock(DefaultMultipartHttpServletRequest.class);
    when(httpServletRequest.getAttribute(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualIsIgnoredResult = customerStateFilter.isIgnored(httpServletRequest, new MockHttpServletResponse());

    // Assert
    verify(httpServletRequest).getAttribute(eq("blUriIsFilterIgnored"));
    assertTrue(actualIsIgnoredResult);
  }

  /**
   * Test {@link CustomerStateFilter#isIgnored(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerStateFilter#isIgnored(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test isIgnored(HttpServletRequest, HttpServletResponse); when MockHttpServletRequest(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CustomerStateFilter.isIgnored(HttpServletRequest, HttpServletResponse)"})
  void testIsIgnored_whenMockHttpServletRequest_thenReturnFalse() {
    // Arrange
    MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertFalse(customerStateFilter.isIgnored(httpServletRequest, new MockHttpServletResponse()));
  }

  /**
   * Test {@link CustomerStateFilter#getOrder()}.
   * <p>
   * Method under test: {@link CustomerStateFilter#getOrder()}
   */
  @Test
  @DisplayName("Test getOrder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CustomerStateFilter.getOrder()"})
  void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(10050, customerStateFilter.getOrder());
  }

  /**
   * Test {@link CustomerStateFilter#shouldNotFilterErrorDispatch()}.
   * <p>
   * Method under test: {@link CustomerStateFilter#shouldNotFilterErrorDispatch()}
   */
  @Test
  @DisplayName("Test shouldNotFilterErrorDispatch()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CustomerStateFilter.shouldNotFilterErrorDispatch()"})
  void testShouldNotFilterErrorDispatch() {
    // Arrange, Act and Assert
    assertFalse(customerStateFilter.shouldNotFilterErrorDispatch());
  }
}

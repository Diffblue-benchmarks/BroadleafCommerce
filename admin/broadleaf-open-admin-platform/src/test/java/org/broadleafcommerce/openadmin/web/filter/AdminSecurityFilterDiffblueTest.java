/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.web.filter;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.security.service.ExploitProtectionService;
import org.broadleafcommerce.common.security.service.StaleStateProtectionService;
import org.broadleafcommerce.common.security.service.StaleStateServiceException;
import org.broadleafcommerce.openadmin.web.compatibility.JSCompatibilityRequestWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(classes = {AdminSecurityFilter.class})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminSecurityFilterDiffblueTest {
  @Autowired
  private AdminSecurityFilter adminSecurityFilter;

  @MockBean(name = "blExploitProtectionService")
  private ExploitProtectionService exploitProtectionService;

  @MockBean(name = "blStaleStateProtectionService")
  private StaleStateProtectionService staleStateProtectionService;

  /**
   * Test {@link AdminSecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <p>
   * Method under test: {@link AdminSecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"})
  public void testDoFilterInternal() throws IOException, ServletException {
    // Arrange
    when(staleStateProtectionService.isEnabled()).thenReturn(false);
    JSCompatibilityRequestWrapper baseRequest = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse baseResponse = new MockHttpServletResponse();
    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    adminSecurityFilter.doFilterInternal(baseRequest, baseResponse, chain);

    // Assert that nothing has changed
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(staleStateProtectionService).isEnabled();
    assertEquals("", baseResponse.getContentAsString());
    assertEquals(200, baseResponse.getStatus());
    assertArrayEquals(new byte[]{}, baseResponse.getContentAsByteArray());
  }

  /**
   * Test {@link AdminSecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <p>
   * Method under test: {@link AdminSecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"})
  public void testDoFilterInternal2() throws IOException, ServletException, ServiceException {
    // Arrange
    doNothing().when(exploitProtectionService).compareToken(Mockito.<String>any());
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");
    doNothing().when(staleStateProtectionService).compareToken(Mockito.<String>any());
    when(staleStateProtectionService.getStateVersionTokenParameter()).thenReturn("MD");
    when(staleStateProtectionService.isEnabled()).thenReturn(true);
    MockMultipartHttpServletRequest baseRequest = new MockMultipartHttpServletRequest();
    MockHttpServletResponse baseResponse = new MockHttpServletResponse();
    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    adminSecurityFilter.doFilterInternal(baseRequest, baseResponse, chain);

    // Assert that nothing has changed
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(exploitProtectionService).compareToken(isNull());
    verify(exploitProtectionService).getCsrfTokenParameter();
    verify(staleStateProtectionService).compareToken(isNull());
    verify(staleStateProtectionService).getStateVersionTokenParameter();
    verify(staleStateProtectionService).isEnabled();
    assertEquals("", baseResponse.getContentAsString());
    assertEquals(200, baseResponse.getStatus());
    assertArrayEquals(new byte[]{}, baseResponse.getContentAsByteArray());
  }

  /**
   * Test {@link AdminSecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) ContentAsString is a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"})
  public void testDoFilterInternal_thenMockHttpServletResponseContentAsStringIsAString()
      throws IOException, ServletException, ServiceException {
    // Arrange
    doNothing().when(exploitProtectionService).compareToken(Mockito.<String>any());
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");
    doThrow(new StaleStateServiceException("An error occurred")).when(staleStateProtectionService)
        .compareToken(Mockito.<String>any());
    when(staleStateProtectionService.getStateVersionTokenParameter()).thenReturn("MD");
    when(staleStateProtectionService.isEnabled()).thenReturn(true);
    MockMultipartHttpServletRequest baseRequest = new MockMultipartHttpServletRequest();
    MockHttpServletResponse baseResponse = new MockHttpServletResponse();

    // Act
    adminSecurityFilter.doFilterInternal(baseRequest, baseResponse, mock(FilterChain.class));

    // Assert
    verify(exploitProtectionService).compareToken(isNull());
    verify(exploitProtectionService).getCsrfTokenParameter();
    verify(staleStateProtectionService).compareToken(isNull());
    verify(staleStateProtectionService).getStateVersionTokenParameter();
    verify(staleStateProtectionService).isEnabled();
    assertEquals(
        "Stale State Detected\n"
            + "org.broadleafcommerce.common.security.service.StaleStateServiceException: An error occurred\n",
        baseResponse.getContentAsString());
    assertEquals(113, baseResponse.getContentAsByteArray().length);
    assertEquals(409, baseResponse.getStatus());
  }

  /**
   * Test {@link AdminSecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) ContentAsString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"})
  public void testDoFilterInternal_thenMockHttpServletResponseContentAsStringIsEmptyString()
      throws IOException, ServletException {
    // Arrange
    when(staleStateProtectionService.isEnabled()).thenReturn(true);
    JSCompatibilityRequestWrapper baseRequest = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse baseResponse = new MockHttpServletResponse();
    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    adminSecurityFilter.doFilterInternal(baseRequest, baseResponse, chain);

    // Assert that nothing has changed
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(staleStateProtectionService).isEnabled();
    assertEquals("", baseResponse.getContentAsString());
    assertEquals(200, baseResponse.getStatus());
    assertArrayEquals(new byte[]{}, baseResponse.getContentAsByteArray());
  }
}

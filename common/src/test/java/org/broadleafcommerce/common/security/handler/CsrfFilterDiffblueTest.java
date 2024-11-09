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
package org.broadleafcommerce.common.security.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.broadleafcommerce.common.exception.SecurityServiceException;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.security.service.ExploitProtectionService;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.broadleafcommerce.common.web.util.FileSystemResponseWrapper;
import org.broadleafcommerce.common.web.util.StatusExposingServletResponse;
import org.junit.Test;
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

@ContextConfiguration(classes = {CsrfFilter.class})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class CsrfFilterDiffblueTest {
  @Autowired
  private CsrfFilter csrfFilter;

  @MockBean(name = "blExploitProtectionService")
  private ExploitProtectionService exploitProtectionService;

  /**
   * Test
   * {@link CsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   * <p>
   * Method under test:
   * {@link CsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilter() throws IOException, ServletException {
    // Arrange
    SessionlessHttpServletRequestWrapper baseRequest = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse baseResponse = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    csrfFilter.doFilter(baseRequest, baseResponse, chain);

    // Assert that nothing has changed
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    ServletResponse response2 = baseResponse.getResponse();
    assertTrue(response2 instanceof FileSystemResponseWrapper);
    ServletResponse response3 = ((FileSystemResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertEquals(200, ((FileSystemResponseWrapper) response2).getStatus());
    assertEquals(200, baseResponse.getStatus());
    assertEquals(200, ((MockHttpServletResponse) response3).getStatus());
    assertFalse(response2.isCommitted());
    assertFalse(response3.isCommitted());
    assertFalse(baseResponse.isCommitted());
  }

  /**
   * Test
   * {@link CsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   * <p>
   * Method under test:
   * {@link CsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilter2() throws IOException, ServletException, ServiceException {
    // Arrange
    doNothing().when(exploitProtectionService).compareToken(Mockito.<String>any());
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");
    MockMultipartHttpServletRequest baseRequest = new MockMultipartHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse baseResponse = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    csrfFilter.doFilter(baseRequest, baseResponse, chain);

    // Assert that nothing has changed
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(exploitProtectionService).compareToken(isNull());
    verify(exploitProtectionService).getCsrfTokenParameter();
    ServletResponse response2 = baseResponse.getResponse();
    assertTrue(response2 instanceof FileSystemResponseWrapper);
    ServletResponse response3 = ((FileSystemResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertEquals(200, ((FileSystemResponseWrapper) response2).getStatus());
    assertEquals(200, baseResponse.getStatus());
    assertEquals(200, ((MockHttpServletResponse) response3).getStatus());
    assertFalse(response2.isCommitted());
    assertFalse(response3.isCommitted());
    assertFalse(baseResponse.isCommitted());
  }

  /**
   * Test
   * {@link CsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   * <p>
   * Method under test:
   * {@link CsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilter3() throws IOException, ServletException, ServiceException {
    // Arrange
    doThrow(new SecurityServiceException("An error occurred")).when(exploitProtectionService)
        .compareToken(Mockito.<String>any());
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");
    MockMultipartHttpServletRequest baseRequest = new MockMultipartHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse baseResponse = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act
    csrfFilter.doFilter(baseRequest, baseResponse, mock(FilterChain.class));

    // Assert
    verify(exploitProtectionService).compareToken(isNull());
    verify(exploitProtectionService).getCsrfTokenParameter();
    ServletResponse response2 = baseResponse.getResponse();
    assertTrue(response2 instanceof FileSystemResponseWrapper);
    ServletResponse response3 = ((FileSystemResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertEquals(403, ((FileSystemResponseWrapper) response2).getStatus());
    assertEquals(403, baseResponse.getStatus());
    assertEquals(403, ((MockHttpServletResponse) response3).getStatus());
    assertTrue(response2.isCommitted());
    assertTrue(response3.isCommitted());
    assertTrue(baseResponse.isCommitted());
  }

  /**
   * Test
   * {@link CsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   * <ul>
   *   <li>Then throw {@link ServletException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilter_thenThrowServletException() throws IOException, ServletException, ServiceException {
    // Arrange
    doThrow(new ServiceException("An error occurred")).when(exploitProtectionService)
        .compareToken(Mockito.<String>any());
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");
    MockMultipartHttpServletRequest baseRequest = new MockMultipartHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertThrows(ServletException.class, () -> csrfFilter.doFilter(baseRequest, new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())),
        mock(FilterChain.class)));
    verify(exploitProtectionService).compareToken(isNull());
    verify(exploitProtectionService).getCsrfTokenParameter();
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CsrfFilter#setExcludedRequestPatterns(List)}
   *   <li>{@link CsrfFilter#getExcludedRequestPatterns()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    CsrfFilter csrfFilter = new CsrfFilter();
    ArrayList<String> excludedRequestPatterns = new ArrayList<>();

    // Act
    csrfFilter.setExcludedRequestPatterns(excludedRequestPatterns);
    List<String> actualExcludedRequestPatterns = csrfFilter.getExcludedRequestPatterns();

    // Assert that nothing has changed
    assertTrue(actualExcludedRequestPatterns.isEmpty());
    assertSame(excludedRequestPatterns, actualExcludedRequestPatterns);
  }
}

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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.HashSet;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.admin.domain.TypedEntity;
import org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.web.BroadleafWebRequestProcessor;
import org.broadleafcommerce.openadmin.server.security.domain.AdminPermission;
import org.broadleafcommerce.openadmin.server.security.domain.AdminPermissionImpl;
import org.broadleafcommerce.openadmin.server.security.domain.AdminRole;
import org.broadleafcommerce.openadmin.server.security.domain.AdminRoleImpl;
import org.broadleafcommerce.openadmin.server.security.domain.AdminSection;
import org.broadleafcommerce.openadmin.server.security.domain.AdminSectionImpl;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl;
import org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier;
import org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService;
import org.broadleafcommerce.openadmin.server.security.service.type.PermissionType;
import org.broadleafcommerce.openadmin.web.compatibility.JSCompatibilityRequestWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ContextConfiguration(classes = {BroadleafAdminTypedEntityRequestFilter.class})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class BroadleafAdminTypedEntityRequestFilterDiffblueTest {
  @MockBean(name = "blAdminNavigationService")
  private AdminNavigationService adminNavigationService;

  @Autowired private BroadleafAdminTypedEntityRequestFilter broadleafAdminTypedEntityRequestFilter;

  @MockBean(name = "blAdminRequestProcessor")
  private BroadleafWebRequestProcessor broadleafWebRequestProcessor;

  @MockBean(name = "blGenericEntityService")
  private GenericEntityService genericEntityService;

  @MockBean(name = "blAdminSecurityRemoteService")
  private SecurityVerifier securityVerifier;

  /**
   * Test {@link
   * BroadleafAdminTypedEntityRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <p>Method under test: {@link
   * BroadleafAdminTypedEntityRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminTypedEntityRequestFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored() throws IOException, ServletException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doNothing()
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    broadleafAdminTypedEntityRequestFilter.doFilterInternalUnlessIgnored(
        request, response, filterChain);

    // Assert that nothing has changed
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    assertEquals(200, response.getStatus());
    assertFalse(response.isCommitted());
  }

  /**
   * Test {@link
   * BroadleafAdminTypedEntityRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <p>Method under test: {@link
   * BroadleafAdminTypedEntityRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminTypedEntityRequestFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored2() throws IOException, ServletException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    HttpServletRequestWrapper request3 = new HttpServletRequestWrapper(request2);
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doNothing()
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    broadleafAdminTypedEntityRequestFilter.doFilterInternalUnlessIgnored(
        request3, response, filterChain);

    // Assert that nothing has changed
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    assertEquals(200, response.getStatus());
    assertFalse(response.isCommitted());
  }

  /**
   * Test {@link
   * BroadleafAdminTypedEntityRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <p>Method under test: {@link
   * BroadleafAdminTypedEntityRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminTypedEntityRequestFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored3() throws IOException, ServletException {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getServletPath()).thenReturn("https://example.org/example");
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    HttpServletRequestWrapper request3 = new HttpServletRequestWrapper(request2);
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAdminTypedEntityRequestFilter.doFilterInternalUnlessIgnored(
        request3, response, mock(FilterChain.class));

    // Assert
    verify(request, atLeast(1)).getServletPath();
    verify(securityVerifier).getPersistentAdminUser();
    verify(adminNavigationService).findAdminSectionByURI("https:");
    assertEquals("Access is denied", response.getErrorMessage());
    assertEquals(403, response.getStatus());
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link
   * BroadleafAdminTypedEntityRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <p>Method under test: {@link
   * BroadleafAdminTypedEntityRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminTypedEntityRequestFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored4() throws IOException, ServletException {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(null);

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getServletPath()).thenReturn("https://example.org/example");
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    HttpServletRequestWrapper request3 = new HttpServletRequestWrapper(request2);
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doNothing()
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    broadleafAdminTypedEntityRequestFilter.doFilterInternalUnlessIgnored(
        request3, response, filterChain);

    // Assert that nothing has changed
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(request, atLeast(1)).getServletPath();
    verify(adminNavigationService).findAdminSectionByURI("https:");
    assertEquals(200, response.getStatus());
    assertFalse(response.isCommitted());
  }

  /**
   * Test {@link
   * BroadleafAdminTypedEntityRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <p>Method under test: {@link
   * BroadleafAdminTypedEntityRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminTypedEntityRequestFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored5() throws IOException, ServletException {
    // Arrange
    HttpServletRequestWrapper request = new HttpServletRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doNothing()
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    broadleafAdminTypedEntityRequestFilter.doFilterInternalUnlessIgnored(
        request, response, filterChain);

    // Assert that nothing has changed
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    assertEquals(200, response.getStatus());
    assertFalse(response.isCommitted());
  }

  /**
   * Test {@link
   * BroadleafAdminTypedEntityRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <p>Method under test: {@link
   * BroadleafAdminTypedEntityRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminTypedEntityRequestFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored6() throws IOException, ServletException {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getServletPath()).thenReturn("https://example.org/example");
    HttpServletRequestWrapper request2 = new HttpServletRequestWrapper(request);
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAdminTypedEntityRequestFilter.doFilterInternalUnlessIgnored(
        request2, response, mock(FilterChain.class));

    // Assert
    verify(request, atLeast(1)).getServletPath();
    verify(securityVerifier).getPersistentAdminUser();
    verify(adminNavigationService).findAdminSectionByURI("https:");
    assertEquals("Access is denied", response.getErrorMessage());
    assertEquals(403, response.getStatus());
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link
   * BroadleafAdminTypedEntityRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Given {@code :}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAdminTypedEntityRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminTypedEntityRequestFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored_givenColon() throws IOException, ServletException {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());

    MockHttpServletRequest request = new MockHttpServletRequest(new MockServletContext());
    request.setServletPath(":");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAdminTypedEntityRequestFilter.doFilterInternalUnlessIgnored(
        request, response, mock(FilterChain.class));

    // Assert
    verify(securityVerifier).getPersistentAdminUser();
    verify(adminNavigationService).findAdminSectionByURI(":");
    assertEquals("Access is denied", response.getErrorMessage());
    assertEquals(403, response.getStatus());
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link
   * BroadleafAdminTypedEntityRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAdminTypedEntityRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminTypedEntityRequestFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored_givenIOException_thenThrowIOException()
      throws IOException, ServletException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new IOException())
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            broadleafAdminTypedEntityRequestFilter.doFilterInternalUnlessIgnored(
                request, response, filterChain));
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#isRequestForTypedEntity(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link
   * BroadleafAdminTypedEntityRequestFilter#isRequestForTypedEntity(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafAdminTypedEntityRequestFilter.isRequestForTypedEntity(HttpServletRequest, HttpServletResponse)"
  })
  public void testIsRequestForTypedEntity() throws IOException, ServletException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    boolean actualIsRequestForTypedEntityResult =
        broadleafAdminTypedEntityRequestFilter.isRequestForTypedEntity(request, response);

    // Assert
    assertNull(response.getErrorMessage());
    assertEquals(200, response.getStatus());
    assertFalse(actualIsRequestForTypedEntityResult);
    assertFalse(response.isCommitted());
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#isRequestForTypedEntity(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link
   * BroadleafAdminTypedEntityRequestFilter#isRequestForTypedEntity(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafAdminTypedEntityRequestFilter.isRequestForTypedEntity(HttpServletRequest, HttpServletResponse)"
  })
  public void testIsRequestForTypedEntity2() throws IOException, ServletException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    HttpServletRequestWrapper request3 = new HttpServletRequestWrapper(request2);
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    boolean actualIsRequestForTypedEntityResult =
        broadleafAdminTypedEntityRequestFilter.isRequestForTypedEntity(request3, response);

    // Assert
    assertNull(response.getErrorMessage());
    assertEquals(200, response.getStatus());
    assertFalse(actualIsRequestForTypedEntityResult);
    assertFalse(response.isCommitted());
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#isRequestForTypedEntity(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link
   * BroadleafAdminTypedEntityRequestFilter#isRequestForTypedEntity(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafAdminTypedEntityRequestFilter.isRequestForTypedEntity(HttpServletRequest, HttpServletResponse)"
  })
  public void testIsRequestForTypedEntity3() throws IOException, ServletException {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getServletPath()).thenReturn("https://example.org/example");
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    HttpServletRequestWrapper request3 = new HttpServletRequestWrapper(request2);
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    boolean actualIsRequestForTypedEntityResult =
        broadleafAdminTypedEntityRequestFilter.isRequestForTypedEntity(request3, response);

    // Assert
    verify(request, atLeast(1)).getServletPath();
    verify(securityVerifier).getPersistentAdminUser();
    verify(adminNavigationService).findAdminSectionByURI("https:");
    assertEquals("Access is denied", response.getErrorMessage());
    assertEquals(403, response.getStatus());
    assertTrue(actualIsRequestForTypedEntityResult);
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#isRequestForTypedEntity(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link
   * BroadleafAdminTypedEntityRequestFilter#isRequestForTypedEntity(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafAdminTypedEntityRequestFilter.isRequestForTypedEntity(HttpServletRequest, HttpServletResponse)"
  })
  public void testIsRequestForTypedEntity4() throws IOException, ServletException {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(null);

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getServletPath()).thenReturn("https://example.org/example");
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    HttpServletRequestWrapper request3 = new HttpServletRequestWrapper(request2);
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    boolean actualIsRequestForTypedEntityResult =
        broadleafAdminTypedEntityRequestFilter.isRequestForTypedEntity(request3, response);

    // Assert
    verify(request, atLeast(1)).getServletPath();
    verify(adminNavigationService).findAdminSectionByURI("https:");
    assertNull(response.getErrorMessage());
    assertEquals(200, response.getStatus());
    assertFalse(actualIsRequestForTypedEntityResult);
    assertFalse(response.isCommitted());
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#isRequestForTypedEntity(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link
   * BroadleafAdminTypedEntityRequestFilter#isRequestForTypedEntity(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafAdminTypedEntityRequestFilter.isRequestForTypedEntity(HttpServletRequest, HttpServletResponse)"
  })
  public void testIsRequestForTypedEntity5() throws IOException, ServletException {
    // Arrange
    HttpServletRequestWrapper request = new HttpServletRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    boolean actualIsRequestForTypedEntityResult =
        broadleafAdminTypedEntityRequestFilter.isRequestForTypedEntity(request, response);

    // Assert
    assertNull(response.getErrorMessage());
    assertEquals(200, response.getStatus());
    assertFalse(actualIsRequestForTypedEntityResult);
    assertFalse(response.isCommitted());
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#isRequestForTypedEntity(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link
   * BroadleafAdminTypedEntityRequestFilter#isRequestForTypedEntity(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafAdminTypedEntityRequestFilter.isRequestForTypedEntity(HttpServletRequest, HttpServletResponse)"
  })
  public void testIsRequestForTypedEntity6() throws IOException, ServletException {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getServletPath()).thenReturn("https://example.org/example");
    HttpServletRequestWrapper request2 = new HttpServletRequestWrapper(request);
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    boolean actualIsRequestForTypedEntityResult =
        broadleafAdminTypedEntityRequestFilter.isRequestForTypedEntity(request2, response);

    // Assert
    verify(request, atLeast(1)).getServletPath();
    verify(securityVerifier).getPersistentAdminUser();
    verify(adminNavigationService).findAdminSectionByURI("https:");
    assertEquals("Access is denied", response.getErrorMessage());
    assertEquals(403, response.getStatus());
    assertTrue(actualIsRequestForTypedEntityResult);
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#isRequestForTypedEntity(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code :}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAdminTypedEntityRequestFilter#isRequestForTypedEntity(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafAdminTypedEntityRequestFilter.isRequestForTypedEntity(HttpServletRequest, HttpServletResponse)"
  })
  public void testIsRequestForTypedEntity_givenColon() throws IOException, ServletException {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getServletPath()).thenReturn(":");
    HttpServletRequestWrapper request2 = new HttpServletRequestWrapper(request);
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    boolean actualIsRequestForTypedEntityResult =
        broadleafAdminTypedEntityRequestFilter.isRequestForTypedEntity(request2, response);

    // Assert
    verify(request, atLeast(1)).getServletPath();
    verify(securityVerifier).getPersistentAdminUser();
    verify(adminNavigationService).findAdminSectionByURI(":");
    assertEquals("Access is denied", response.getErrorMessage());
    assertEquals(403, response.getStatus());
    assertTrue(actualIsRequestForTypedEntityResult);
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#getTypedEntityFromServletPathId(String,
   * String)}.
   *
   * <p>Method under test: {@link
   * BroadleafAdminTypedEntityRequestFilter#getTypedEntityFromServletPathId(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TypedEntity BroadleafAdminTypedEntityRequestFilter.getTypedEntityFromServletPathId(String, String)"
  })
  public void testGetTypedEntityFromServletPathId() {
    // Arrange, Act and Assert
    assertNull(
        broadleafAdminTypedEntityRequestFilter.getTypedEntityFromServletPathId(
            "Servlet Path", "Ceiling Entity"));
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#getTypeAdminSectionMismatchUrl(TypedEntity,
   * String, String, String)}.
   *
   * <p>Method under test: {@link
   * BroadleafAdminTypedEntityRequestFilter#getTypeAdminSectionMismatchUrl(TypedEntity, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafAdminTypedEntityRequestFilter.getTypeAdminSectionMismatchUrl(TypedEntity, String, String, String)"
  })
  public void testGetTypeAdminSectionMismatchUrl() {
    // Arrange
    BroadleafAdminTypedEntityRequestFilter broadleafAdminTypedEntityRequestFilter =
        new BroadleafAdminTypedEntityRequestFilter();

    TypedEntity typedEntity = mock(TypedEntity.class);
    when(typedEntity.getType()).thenReturn(new BreadcrumbDTOType("standard", "."));

    // Act
    String actualTypeAdminSectionMismatchUrl =
        broadleafAdminTypedEntityRequestFilter.getTypeAdminSectionMismatchUrl(
            typedEntity, "/", "https://example.org/example", "https://example.org/example");

    // Assert
    verify(typedEntity).getType();
    assertEquals("//", actualTypeAdminSectionMismatchUrl);
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#getTypeAdminSectionMismatchUrl(TypedEntity,
   * String, String, String)}.
   *
   * <p>Method under test: {@link
   * BroadleafAdminTypedEntityRequestFilter#getTypeAdminSectionMismatchUrl(TypedEntity, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafAdminTypedEntityRequestFilter.getTypeAdminSectionMismatchUrl(TypedEntity, String, String, String)"
  })
  public void testGetTypeAdminSectionMismatchUrl2() {
    // Arrange
    BroadleafAdminTypedEntityRequestFilter broadleafAdminTypedEntityRequestFilter =
        new BroadleafAdminTypedEntityRequestFilter();

    TypedEntity typedEntity = mock(TypedEntity.class);
    when(typedEntity.getType()).thenReturn(new BreadcrumbDTOType("/", "."));

    // Act
    String actualTypeAdminSectionMismatchUrl =
        broadleafAdminTypedEntityRequestFilter.getTypeAdminSectionMismatchUrl(
            typedEntity, "/", "https://example.org/example", "https://example.org/example");

    // Assert
    verify(typedEntity).getType();
    assertEquals("//", actualTypeAdminSectionMismatchUrl);
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#getTypeAdminSectionMismatchUrl(TypedEntity,
   * String, String, String)}.
   *
   * <ul>
   *   <li>Given {@link PermissionType#ALL}.
   *   <li>Then return {@code /org/example:all}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAdminTypedEntityRequestFilter#getTypeAdminSectionMismatchUrl(TypedEntity, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafAdminTypedEntityRequestFilter.getTypeAdminSectionMismatchUrl(TypedEntity, String, String, String)"
  })
  public void testGetTypeAdminSectionMismatchUrl_givenAll_thenReturnOrgExampleAll() {
    // Arrange
    TypedEntity typedEntity = mock(TypedEntity.class);
    when(typedEntity.getType()).thenReturn(PermissionType.ALL);

    // Act
    String actualTypeAdminSectionMismatchUrl =
        broadleafAdminTypedEntityRequestFilter.getTypeAdminSectionMismatchUrl(
            typedEntity,
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example");

    // Assert
    verify(typedEntity).getType();
    assertEquals("/org/example:all", actualTypeAdminSectionMismatchUrl);
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#getTypeAdminSectionMismatchUrl(TypedEntity,
   * String, String, String)}.
   *
   * <ul>
   *   <li>Given {@link PermissionType#ALL}.
   *   <li>When {@code .}.
   *   <li>Then return {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAdminTypedEntityRequestFilter#getTypeAdminSectionMismatchUrl(TypedEntity, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafAdminTypedEntityRequestFilter.getTypeAdminSectionMismatchUrl(TypedEntity, String, String, String)"
  })
  public void testGetTypeAdminSectionMismatchUrl_givenAll_whenDot_thenReturnDot() {
    // Arrange
    TypedEntity typedEntity = mock(TypedEntity.class);
    when(typedEntity.getType()).thenReturn(PermissionType.ALL);

    // Act
    String actualTypeAdminSectionMismatchUrl =
        broadleafAdminTypedEntityRequestFilter.getTypeAdminSectionMismatchUrl(
            typedEntity, "https://example.org/example", ".", "https://example.org/example");

    // Assert
    verify(typedEntity).getType();
    assertEquals(".", actualTypeAdminSectionMismatchUrl);
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#getTypeAdminSectionMismatchUrl(TypedEntity,
   * String, String, String)}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAdminTypedEntityRequestFilter#getTypeAdminSectionMismatchUrl(TypedEntity, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafAdminTypedEntityRequestFilter.getTypeAdminSectionMismatchUrl(TypedEntity, String, String, String)"
  })
  public void testGetTypeAdminSectionMismatchUrl_thenReturnHttpsExampleOrgExample() {
    // Arrange
    TypedEntity typedEntity = mock(TypedEntity.class);
    when(typedEntity.getType()).thenReturn(PermissionType.ALL);

    // Act
    String actualTypeAdminSectionMismatchUrl =
        broadleafAdminTypedEntityRequestFilter.getTypeAdminSectionMismatchUrl(
            typedEntity, "https://example.org/example", "https://example.org/example", "");

    // Assert
    verify(typedEntity).getType();
    assertEquals("https://example.org/example", actualTypeAdminSectionMismatchUrl);
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#getTypeAdminSectionMismatchUrl(TypedEntity,
   * String, String, String)}.
   *
   * <ul>
   *   <li>Then return {@code //:.}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAdminTypedEntityRequestFilter#getTypeAdminSectionMismatchUrl(TypedEntity, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafAdminTypedEntityRequestFilter.getTypeAdminSectionMismatchUrl(TypedEntity, String, String, String)"
  })
  public void testGetTypeAdminSectionMismatchUrl_thenReturnSlashSlashColonDot() {
    // Arrange
    BroadleafAdminTypedEntityRequestFilter broadleafAdminTypedEntityRequestFilter =
        new BroadleafAdminTypedEntityRequestFilter();

    TypedEntity typedEntity = mock(TypedEntity.class);
    when(typedEntity.getType()).thenReturn(new BreadcrumbDTOType(".", "."));

    // Act
    String actualTypeAdminSectionMismatchUrl =
        broadleafAdminTypedEntityRequestFilter.getTypeAdminSectionMismatchUrl(
            typedEntity, "/", "https://example.org/example", "https://example.org/example");

    // Assert
    verify(typedEntity).getType();
    assertEquals("//:.", actualTypeAdminSectionMismatchUrl);
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#getTypeAdminSectionMismatchUrl(TypedEntity,
   * String, String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAdminTypedEntityRequestFilter#getTypeAdminSectionMismatchUrl(TypedEntity, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafAdminTypedEntityRequestFilter.getTypeAdminSectionMismatchUrl(TypedEntity, String, String, String)"
  })
  public void testGetTypeAdminSectionMismatchUrl_whenEmptyString_thenReturnEmptyString() {
    // Arrange
    TypedEntity typedEntity = mock(TypedEntity.class);
    when(typedEntity.getType()).thenReturn(PermissionType.ALL);

    // Act
    String actualTypeAdminSectionMismatchUrl =
        broadleafAdminTypedEntityRequestFilter.getTypeAdminSectionMismatchUrl(
            typedEntity, "https://example.org/example", "", "https://example.org/example");

    // Assert
    verify(typedEntity).getType();
    assertEquals("", actualTypeAdminSectionMismatchUrl);
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#typeMatchesAdminSection(TypedEntity,
   * String)}.
   *
   * <p>Method under test: {@link
   * BroadleafAdminTypedEntityRequestFilter#typeMatchesAdminSection(TypedEntity, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafAdminTypedEntityRequestFilter.typeMatchesAdminSection(TypedEntity, String)"
  })
  public void testTypeMatchesAdminSection() {
    // Arrange
    TypedEntity typedEntity = mock(TypedEntity.class);
    when(typedEntity.getType()).thenReturn(new BreadcrumbDTOType(":", ":"));

    // Act
    boolean actualTypeMatchesAdminSectionResult =
        broadleafAdminTypedEntityRequestFilter.typeMatchesAdminSection(typedEntity, "/");

    // Assert
    verify(typedEntity).getType();
    assertFalse(actualTypeMatchesAdminSectionResult);
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#typeMatchesAdminSection(TypedEntity,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PermissionType#ALL}.
   *   <li>When {@link TypedEntity} {@link TypedEntity#getType()} return {@link PermissionType#ALL}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAdminTypedEntityRequestFilter#typeMatchesAdminSection(TypedEntity, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafAdminTypedEntityRequestFilter.typeMatchesAdminSection(TypedEntity, String)"
  })
  public void testTypeMatchesAdminSection_givenAll_whenTypedEntityGetTypeReturnAll() {
    // Arrange
    TypedEntity typedEntity = mock(TypedEntity.class);
    when(typedEntity.getType()).thenReturn(PermissionType.ALL);

    // Act
    boolean actualTypeMatchesAdminSectionResult =
        broadleafAdminTypedEntityRequestFilter.typeMatchesAdminSection(typedEntity, "Section Key");

    // Assert
    verify(typedEntity).getType();
    assertFalse(actualTypeMatchesAdminSectionResult);
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#typeMatchesAdminSection(TypedEntity,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link BreadcrumbDTOType#BreadcrumbDTOType()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAdminTypedEntityRequestFilter#typeMatchesAdminSection(TypedEntity, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafAdminTypedEntityRequestFilter.typeMatchesAdminSection(TypedEntity, String)"
  })
  public void testTypeMatchesAdminSection_givenBreadcrumbDTOType() {
    // Arrange
    TypedEntity typedEntity = mock(TypedEntity.class);
    when(typedEntity.getType()).thenReturn(new BreadcrumbDTOType());

    // Act
    boolean actualTypeMatchesAdminSectionResult =
        broadleafAdminTypedEntityRequestFilter.typeMatchesAdminSection(typedEntity, "Section Key");

    // Assert
    verify(typedEntity).getType();
    assertFalse(actualTypeMatchesAdminSectionResult);
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#adminUserHasAccess(AdminSection)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link AdminPermissionImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAdminTypedEntityRequestFilter#adminUserHasAccess(AdminSection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafAdminTypedEntityRequestFilter.adminUserHasAccess(AdminSection)"
  })
  public void testAdminUserHasAccess_givenHashSetAddAdminPermissionImpl_thenReturnFalse() {
    // Arrange
    HashSet<AdminPermission> allPermissions = new HashSet<>();
    allPermissions.add(new AdminPermissionImpl());

    AdminUserImpl adminUserImpl = new AdminUserImpl();
    adminUserImpl.setAllPermissions(allPermissions);
    when(securityVerifier.getPersistentAdminUser()).thenReturn(adminUserImpl);

    // Act
    boolean actualAdminUserHasAccessResult =
        broadleafAdminTypedEntityRequestFilter.adminUserHasAccess(new AdminSectionImpl());

    // Assert
    verify(securityVerifier).getPersistentAdminUser();
    assertFalse(actualAdminUserHasAccessResult);
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#adminUserHasAccess(AdminSection)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link AdminRoleImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAdminTypedEntityRequestFilter#adminUserHasAccess(AdminSection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafAdminTypedEntityRequestFilter.adminUserHasAccess(AdminSection)"
  })
  public void testAdminUserHasAccess_givenHashSetAddAdminRoleImpl_thenReturnFalse() {
    // Arrange
    HashSet<AdminRole> allRoles = new HashSet<>();
    allRoles.add(new AdminRoleImpl());

    AdminUserImpl adminUserImpl = new AdminUserImpl();
    adminUserImpl.setAllRoles(allRoles);
    when(securityVerifier.getPersistentAdminUser()).thenReturn(adminUserImpl);

    // Act
    boolean actualAdminUserHasAccessResult =
        broadleafAdminTypedEntityRequestFilter.adminUserHasAccess(new AdminSectionImpl());

    // Assert
    verify(securityVerifier).getPersistentAdminUser();
    assertFalse(actualAdminUserHasAccessResult);
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#adminUserHasAccess(AdminSection)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAdminTypedEntityRequestFilter#adminUserHasAccess(AdminSection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafAdminTypedEntityRequestFilter.adminUserHasAccess(AdminSection)"
  })
  public void testAdminUserHasAccess_thenReturnFalse() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());

    // Act
    boolean actualAdminUserHasAccessResult =
        broadleafAdminTypedEntityRequestFilter.adminUserHasAccess(new AdminSectionImpl());

    // Assert
    verify(securityVerifier).getPersistentAdminUser();
    assertFalse(actualAdminUserHasAccessResult);
  }

  /**
   * Test {@link
   * BroadleafAdminTypedEntityRequestFilter#getEntityTypeFromRequest(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Given {@code :}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAdminTypedEntityRequestFilter#getEntityTypeFromRequest(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafAdminTypedEntityRequestFilter.getEntityTypeFromRequest(HttpServletRequest)"
  })
  public void testGetEntityTypeFromRequest_givenColon() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest(new MockServletContext());
    request.setServletPath(":");

    // Act and Assert
    assertEquals(":", broadleafAdminTypedEntityRequestFilter.getEntityTypeFromRequest(request));
  }

  /**
   * Test {@link
   * BroadleafAdminTypedEntityRequestFilter#getEntityTypeFromRequest(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Given {@code https://example.org/example}.
   *   <li>Then calls {@link DefaultMultipartHttpServletRequest#getServletPath()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAdminTypedEntityRequestFilter#getEntityTypeFromRequest(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafAdminTypedEntityRequestFilter.getEntityTypeFromRequest(HttpServletRequest)"
  })
  public void testGetEntityTypeFromRequest_givenHttpsExampleOrgExample_thenCallsGetServletPath() {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getServletPath()).thenReturn("https://example.org/example");
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);

    // Act
    String actualEntityTypeFromRequest =
        broadleafAdminTypedEntityRequestFilter.getEntityTypeFromRequest(
            new HttpServletRequestWrapper(request2));

    // Assert
    verify(request).getServletPath();
    assertEquals(":", actualEntityTypeFromRequest);
  }

  /**
   * Test {@link
   * BroadleafAdminTypedEntityRequestFilter#getSectionKeyFromRequest(HttpServletRequest)}.
   *
   * <p>Method under test: {@link
   * BroadleafAdminTypedEntityRequestFilter#getSectionKeyFromRequest(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafAdminTypedEntityRequestFilter.getSectionKeyFromRequest(HttpServletRequest)"
  })
  public void testGetSectionKeyFromRequest() {
    // Arrange, Act and Assert
    assertEquals(
        "",
        broadleafAdminTypedEntityRequestFilter.getSectionKeyFromRequest(
            new HttpServletRequestWrapper(
                new JSCompatibilityRequestWrapper(new MockHttpServletRequest()))));
  }

  /**
   * Test {@link
   * BroadleafAdminTypedEntityRequestFilter#getSectionKeyFromRequest(HttpServletRequest)}.
   *
   * <p>Method under test: {@link
   * BroadleafAdminTypedEntityRequestFilter#getSectionKeyFromRequest(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafAdminTypedEntityRequestFilter.getSectionKeyFromRequest(HttpServletRequest)"
  })
  public void testGetSectionKeyFromRequest2() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);

    // Act and Assert
    assertEquals(
        "",
        broadleafAdminTypedEntityRequestFilter.getSectionKeyFromRequest(
            new HttpServletRequestWrapper(request2)));
  }

  /**
   * Test {@link
   * BroadleafAdminTypedEntityRequestFilter#getSectionKeyFromRequest(HttpServletRequest)}.
   *
   * <p>Method under test: {@link
   * BroadleafAdminTypedEntityRequestFilter#getSectionKeyFromRequest(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafAdminTypedEntityRequestFilter.getSectionKeyFromRequest(HttpServletRequest)"
  })
  public void testGetSectionKeyFromRequest3() {
    // Arrange, Act and Assert
    assertEquals(
        "",
        broadleafAdminTypedEntityRequestFilter.getSectionKeyFromRequest(
            new HttpServletRequestWrapper(new MockHttpServletRequest())));
  }

  /**
   * Test {@link
   * BroadleafAdminTypedEntityRequestFilter#getSectionKeyFromRequest(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Given {@code https://example.org/example}.
   *   <li>Then return {@code https:}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAdminTypedEntityRequestFilter#getSectionKeyFromRequest(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafAdminTypedEntityRequestFilter.getSectionKeyFromRequest(HttpServletRequest)"
  })
  public void testGetSectionKeyFromRequest_givenHttpsExampleOrgExample_thenReturnHttps() {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getServletPath()).thenReturn("https://example.org/example");
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);

    // Act
    String actualSectionKeyFromRequest =
        broadleafAdminTypedEntityRequestFilter.getSectionKeyFromRequest(
            new HttpServletRequestWrapper(request2));

    // Assert
    verify(request).getServletPath();
    assertEquals("https:", actualSectionKeyFromRequest);
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#getTypeFieldName(AdminSection)}.
   *
   * <ul>
   *   <li>Given {@code Ceiling Entity}.
   *   <li>Then calls {@link AdminSection#getCeilingEntity()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAdminTypedEntityRequestFilter#getTypeFieldName(AdminSection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafAdminTypedEntityRequestFilter.getTypeFieldName(AdminSection)"
  })
  public void testGetTypeFieldName_givenCeilingEntity_thenCallsGetCeilingEntity() {
    // Arrange
    AdminSection adminSection = mock(AdminSection.class);
    when(adminSection.getCeilingEntity()).thenReturn("Ceiling Entity");

    // Act
    String actualTypeFieldName =
        broadleafAdminTypedEntityRequestFilter.getTypeFieldName(adminSection);

    // Assert
    verify(adminSection).getCeilingEntity();
    assertNull(actualTypeFieldName);
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#getTypeFieldName(AdminSection)}.
   *
   * <ul>
   *   <li>When {@link AdminSectionImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAdminTypedEntityRequestFilter#getTypeFieldName(AdminSection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafAdminTypedEntityRequestFilter.getTypeFieldName(AdminSection)"
  })
  public void testGetTypeFieldName_whenAdminSectionImpl() {
    // Arrange, Act and Assert
    assertNull(broadleafAdminTypedEntityRequestFilter.getTypeFieldName(new AdminSectionImpl()));
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#getTypeFieldName(AdminSection)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAdminTypedEntityRequestFilter#getTypeFieldName(AdminSection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafAdminTypedEntityRequestFilter.getTypeFieldName(AdminSection)"
  })
  public void testGetTypeFieldName_whenNull() {
    // Arrange, Act and Assert
    assertNull(broadleafAdminTypedEntityRequestFilter.getTypeFieldName(null));
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#getOrder()}.
   *
   * <p>Method under test: {@link BroadleafAdminTypedEntityRequestFilter#getOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int BroadleafAdminTypedEntityRequestFilter.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(1001000, new BroadleafAdminTypedEntityRequestFilter().getOrder());
  }
}

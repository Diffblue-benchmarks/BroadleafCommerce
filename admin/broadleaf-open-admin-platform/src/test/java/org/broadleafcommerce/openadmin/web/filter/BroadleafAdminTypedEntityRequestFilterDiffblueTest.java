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
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
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
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.admin.domain.TypedEntity;
import org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.web.BroadleafWebRequestProcessor;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ContextConfiguration(classes = {BroadleafAdminTypedEntityRequestFilter.class})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafAdminTypedEntityRequestFilterDiffblueTest {
  @MockBean(name = "blAdminNavigationService")
  private AdminNavigationService adminNavigationService;

  @Autowired
  private BroadleafAdminTypedEntityRequestFilter broadleafAdminTypedEntityRequestFilter;

  @MockBean(name = "blAdminRequestProcessor")
  private BroadleafWebRequestProcessor broadleafWebRequestProcessor;

  @MockBean(name = "blGenericEntityService")
  private GenericEntityService genericEntityService;

  @MockBean(name = "blAdminSecurityRemoteService")
  private SecurityVerifier securityVerifier;

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <p>
   * Method under test: {@link BroadleafAdminTypedEntityRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void BroadleafAdminTypedEntityRequestFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"})
  public void testDoFilterInternalUnlessIgnored() throws IOException, ServletException {
    // Arrange
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();
    FilterChain filterChain = mock(FilterChain.class);
    doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    broadleafAdminTypedEntityRequestFilter.doFilterInternalUnlessIgnored(request, response, filterChain);

    // Assert that nothing has changed
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    assertEquals(200, response.getStatus());
    assertFalse(response.isCommitted());
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <p>
   * Method under test: {@link BroadleafAdminTypedEntityRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void BroadleafAdminTypedEntityRequestFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"})
  public void testDoFilterInternalUnlessIgnored2() throws IOException, ServletException {
    // Arrange
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(
        new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(new MockHttpServletRequest())));
    MockHttpServletResponse response = new MockHttpServletResponse();
    FilterChain filterChain = mock(FilterChain.class);
    doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    broadleafAdminTypedEntityRequestFilter.doFilterInternalUnlessIgnored(request, response, filterChain);

    // Assert that nothing has changed
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    assertEquals(200, response.getStatus());
    assertFalse(response.isCommitted());
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <p>
   * Method under test: {@link BroadleafAdminTypedEntityRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void BroadleafAdminTypedEntityRequestFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"})
  public void testDoFilterInternalUnlessIgnored3() throws IOException, ServletException {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(new AdminSectionImpl());
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getServletPath()).thenReturn("https://example.org/example");
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAdminTypedEntityRequestFilter.doFilterInternalUnlessIgnored(request2, response, mock(FilterChain.class));

    // Assert
    verify(request, atLeast(1)).getServletPath();
    verify(securityVerifier).getPersistentAdminUser();
    verify(adminNavigationService).findAdminSectionByURI(eq("https:"));
    assertEquals("Access is denied", response.getErrorMessage());
    assertEquals(403, response.getStatus());
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <p>
   * Method under test: {@link BroadleafAdminTypedEntityRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void BroadleafAdminTypedEntityRequestFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"})
  public void testDoFilterInternalUnlessIgnored4() throws IOException, ServletException {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(null);
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getServletPath()).thenReturn("https://example.org/example");
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    MockHttpServletResponse response = new MockHttpServletResponse();
    FilterChain filterChain = mock(FilterChain.class);
    doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    broadleafAdminTypedEntityRequestFilter.doFilterInternalUnlessIgnored(request2, response, filterChain);

    // Assert that nothing has changed
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(request, atLeast(1)).getServletPath();
    verify(adminNavigationService).findAdminSectionByURI(eq("https:"));
    assertEquals(200, response.getStatus());
    assertFalse(response.isCommitted());
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <p>
   * Method under test: {@link BroadleafAdminTypedEntityRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void BroadleafAdminTypedEntityRequestFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"})
  public void testDoFilterInternalUnlessIgnored5() throws IOException, ServletException {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(new AdminSectionImpl());
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getServletPath()).thenReturn("https://example.org/example");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAdminTypedEntityRequestFilter.doFilterInternalUnlessIgnored(request, response, mock(FilterChain.class));

    // Assert
    verify(request, atLeast(1)).getServletPath();
    verify(securityVerifier).getPersistentAdminUser();
    verify(adminNavigationService).findAdminSectionByURI(eq("https:"));
    assertEquals("Access is denied", response.getErrorMessage());
    assertEquals(403, response.getStatus());
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Given {@code :}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminTypedEntityRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void BroadleafAdminTypedEntityRequestFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"})
  public void testDoFilterInternalUnlessIgnored_givenColon() throws IOException, ServletException {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(new AdminSectionImpl());
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getServletPath()).thenReturn(":");
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAdminTypedEntityRequestFilter.doFilterInternalUnlessIgnored(request2, response, mock(FilterChain.class));

    // Assert
    verify(request, atLeast(1)).getServletPath();
    verify(securityVerifier).getPersistentAdminUser();
    verify(adminNavigationService).findAdminSectionByURI(eq(":"));
    assertEquals("Access is denied", response.getErrorMessage());
    assertEquals(403, response.getStatus());
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminTypedEntityRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void BroadleafAdminTypedEntityRequestFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"})
  public void testDoFilterInternalUnlessIgnored_whenMockHttpServletRequest() throws IOException, ServletException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    FilterChain filterChain = mock(FilterChain.class);
    doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    broadleafAdminTypedEntityRequestFilter.doFilterInternalUnlessIgnored(request, response, filterChain);

    // Assert that nothing has changed
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    assertEquals(200, response.getStatus());
    assertFalse(response.isCommitted());
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#isRequestForTypedEntity(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link BroadleafAdminTypedEntityRequestFilter#isRequestForTypedEntity(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean BroadleafAdminTypedEntityRequestFilter.isRequestForTypedEntity(HttpServletRequest, HttpServletResponse)"})
  public void testIsRequestForTypedEntity() throws IOException, ServletException {
    // Arrange
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    boolean actualIsRequestForTypedEntityResult = broadleafAdminTypedEntityRequestFilter
        .isRequestForTypedEntity(request, response);

    // Assert
    assertNull(response.getErrorMessage());
    assertEquals(200, response.getStatus());
    assertFalse(actualIsRequestForTypedEntityResult);
    assertFalse(response.isCommitted());
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#isRequestForTypedEntity(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link BroadleafAdminTypedEntityRequestFilter#isRequestForTypedEntity(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean BroadleafAdminTypedEntityRequestFilter.isRequestForTypedEntity(HttpServletRequest, HttpServletResponse)"})
  public void testIsRequestForTypedEntity2() throws IOException, ServletException {
    // Arrange
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(
        new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(new MockHttpServletRequest())));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    boolean actualIsRequestForTypedEntityResult = broadleafAdminTypedEntityRequestFilter
        .isRequestForTypedEntity(request, response);

    // Assert
    assertNull(response.getErrorMessage());
    assertEquals(200, response.getStatus());
    assertFalse(actualIsRequestForTypedEntityResult);
    assertFalse(response.isCommitted());
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#isRequestForTypedEntity(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link BroadleafAdminTypedEntityRequestFilter#isRequestForTypedEntity(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean BroadleafAdminTypedEntityRequestFilter.isRequestForTypedEntity(HttpServletRequest, HttpServletResponse)"})
  public void testIsRequestForTypedEntity3() throws IOException, ServletException {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(new AdminSectionImpl());
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getServletPath()).thenReturn("https://example.org/example");
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    boolean actualIsRequestForTypedEntityResult = broadleafAdminTypedEntityRequestFilter
        .isRequestForTypedEntity(request2, response);

    // Assert
    verify(request, atLeast(1)).getServletPath();
    verify(securityVerifier).getPersistentAdminUser();
    verify(adminNavigationService).findAdminSectionByURI(eq("https:"));
    assertEquals("Access is denied", response.getErrorMessage());
    assertEquals(403, response.getStatus());
    assertTrue(actualIsRequestForTypedEntityResult);
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#isRequestForTypedEntity(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link BroadleafAdminTypedEntityRequestFilter#isRequestForTypedEntity(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean BroadleafAdminTypedEntityRequestFilter.isRequestForTypedEntity(HttpServletRequest, HttpServletResponse)"})
  public void testIsRequestForTypedEntity4() throws IOException, ServletException {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(null);
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getServletPath()).thenReturn("https://example.org/example");
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    boolean actualIsRequestForTypedEntityResult = broadleafAdminTypedEntityRequestFilter
        .isRequestForTypedEntity(request2, response);

    // Assert
    verify(request, atLeast(1)).getServletPath();
    verify(adminNavigationService).findAdminSectionByURI(eq("https:"));
    assertNull(response.getErrorMessage());
    assertEquals(200, response.getStatus());
    assertFalse(actualIsRequestForTypedEntityResult);
    assertFalse(response.isCommitted());
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#isRequestForTypedEntity(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link BroadleafAdminTypedEntityRequestFilter#isRequestForTypedEntity(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean BroadleafAdminTypedEntityRequestFilter.isRequestForTypedEntity(HttpServletRequest, HttpServletResponse)"})
  public void testIsRequestForTypedEntity5() throws IOException, ServletException {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(new AdminSectionImpl());
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getServletPath()).thenReturn("https://example.org/example");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    boolean actualIsRequestForTypedEntityResult = broadleafAdminTypedEntityRequestFilter
        .isRequestForTypedEntity(request, response);

    // Assert
    verify(request, atLeast(1)).getServletPath();
    verify(securityVerifier).getPersistentAdminUser();
    verify(adminNavigationService).findAdminSectionByURI(eq("https:"));
    assertEquals("Access is denied", response.getErrorMessage());
    assertEquals(403, response.getStatus());
    assertTrue(actualIsRequestForTypedEntityResult);
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#isRequestForTypedEntity(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given {@code :}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminTypedEntityRequestFilter#isRequestForTypedEntity(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean BroadleafAdminTypedEntityRequestFilter.isRequestForTypedEntity(HttpServletRequest, HttpServletResponse)"})
  public void testIsRequestForTypedEntity_givenColon() throws IOException, ServletException {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(new AdminSectionImpl());
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getServletPath()).thenReturn(":");
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    boolean actualIsRequestForTypedEntityResult = broadleafAdminTypedEntityRequestFilter
        .isRequestForTypedEntity(request2, response);

    // Assert
    verify(request, atLeast(1)).getServletPath();
    verify(securityVerifier).getPersistentAdminUser();
    verify(adminNavigationService).findAdminSectionByURI(eq(":"));
    assertEquals("Access is denied", response.getErrorMessage());
    assertEquals(403, response.getStatus());
    assertTrue(actualIsRequestForTypedEntityResult);
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#isRequestForTypedEntity(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminTypedEntityRequestFilter#isRequestForTypedEntity(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean BroadleafAdminTypedEntityRequestFilter.isRequestForTypedEntity(HttpServletRequest, HttpServletResponse)"})
  public void testIsRequestForTypedEntity_whenMockHttpServletRequest() throws IOException, ServletException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    boolean actualIsRequestForTypedEntityResult = broadleafAdminTypedEntityRequestFilter
        .isRequestForTypedEntity(request, response);

    // Assert
    assertNull(response.getErrorMessage());
    assertEquals(200, response.getStatus());
    assertFalse(actualIsRequestForTypedEntityResult);
    assertFalse(response.isCommitted());
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#getTypedEntityFromServletPathId(String, String)}.
   * <p>
   * Method under test: {@link BroadleafAdminTypedEntityRequestFilter#getTypedEntityFromServletPathId(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "TypedEntity BroadleafAdminTypedEntityRequestFilter.getTypedEntityFromServletPathId(String, String)"})
  public void testGetTypedEntityFromServletPathId() {
    // Arrange, Act and Assert
    assertNull(
        broadleafAdminTypedEntityRequestFilter.getTypedEntityFromServletPathId("Servlet Path", "Ceiling Entity"));
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#getTypeAdminSectionMismatchUrl(TypedEntity, String, String, String)}.
   * <ul>
   *   <li>Given {@link PermissionType#ALL}.</li>
   *   <li>Then return {@code /org/example:all}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminTypedEntityRequestFilter#getTypeAdminSectionMismatchUrl(TypedEntity, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String BroadleafAdminTypedEntityRequestFilter.getTypeAdminSectionMismatchUrl(TypedEntity, String, String, String)"})
  public void testGetTypeAdminSectionMismatchUrl_givenAll_thenReturnOrgExampleAll() {
    // Arrange
    TypedEntity typedEntity = mock(TypedEntity.class);
    when(typedEntity.getType()).thenReturn(PermissionType.ALL);

    // Act
    String actualTypeAdminSectionMismatchUrl = broadleafAdminTypedEntityRequestFilter.getTypeAdminSectionMismatchUrl(
        typedEntity, "https://example.org/example", "https://example.org/example", "https://example.org/example");

    // Assert
    verify(typedEntity).getType();
    assertEquals("/org/example:all", actualTypeAdminSectionMismatchUrl);
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#getTypeAdminSectionMismatchUrl(TypedEntity, String, String, String)}.
   * <ul>
   *   <li>Given {@link PermissionType#ALL}.</li>
   *   <li>When {@code .}.</li>
   *   <li>Then return {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminTypedEntityRequestFilter#getTypeAdminSectionMismatchUrl(TypedEntity, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String BroadleafAdminTypedEntityRequestFilter.getTypeAdminSectionMismatchUrl(TypedEntity, String, String, String)"})
  public void testGetTypeAdminSectionMismatchUrl_givenAll_whenDot_thenReturnDot() {
    // Arrange
    TypedEntity typedEntity = mock(TypedEntity.class);
    when(typedEntity.getType()).thenReturn(PermissionType.ALL);

    // Act
    String actualTypeAdminSectionMismatchUrl = broadleafAdminTypedEntityRequestFilter
        .getTypeAdminSectionMismatchUrl(typedEntity, "https://example.org/example", ".", "https://example.org/example");

    // Assert
    verify(typedEntity).getType();
    assertEquals(".", actualTypeAdminSectionMismatchUrl);
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#getTypeAdminSectionMismatchUrl(TypedEntity, String, String, String)}.
   * <ul>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminTypedEntityRequestFilter#getTypeAdminSectionMismatchUrl(TypedEntity, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String BroadleafAdminTypedEntityRequestFilter.getTypeAdminSectionMismatchUrl(TypedEntity, String, String, String)"})
  public void testGetTypeAdminSectionMismatchUrl_thenReturnHttpsExampleOrgExample() {
    // Arrange
    TypedEntity typedEntity = mock(TypedEntity.class);
    when(typedEntity.getType()).thenReturn(PermissionType.ALL);

    // Act
    String actualTypeAdminSectionMismatchUrl = broadleafAdminTypedEntityRequestFilter
        .getTypeAdminSectionMismatchUrl(typedEntity, "https://example.org/example", "https://example.org/example", "");

    // Assert
    verify(typedEntity).getType();
    assertEquals("https://example.org/example", actualTypeAdminSectionMismatchUrl);
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#getTypeAdminSectionMismatchUrl(TypedEntity, String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminTypedEntityRequestFilter#getTypeAdminSectionMismatchUrl(TypedEntity, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String BroadleafAdminTypedEntityRequestFilter.getTypeAdminSectionMismatchUrl(TypedEntity, String, String, String)"})
  public void testGetTypeAdminSectionMismatchUrl_whenEmptyString_thenReturnEmptyString() {
    // Arrange
    TypedEntity typedEntity = mock(TypedEntity.class);
    when(typedEntity.getType()).thenReturn(PermissionType.ALL);

    // Act
    String actualTypeAdminSectionMismatchUrl = broadleafAdminTypedEntityRequestFilter
        .getTypeAdminSectionMismatchUrl(typedEntity, "https://example.org/example", "", "https://example.org/example");

    // Assert
    verify(typedEntity).getType();
    assertEquals("", actualTypeAdminSectionMismatchUrl);
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#typeMatchesAdminSection(TypedEntity, String)}.
   * <p>
   * Method under test: {@link BroadleafAdminTypedEntityRequestFilter#typeMatchesAdminSection(TypedEntity, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BroadleafAdminTypedEntityRequestFilter.typeMatchesAdminSection(TypedEntity, String)"})
  public void testTypeMatchesAdminSection() {
    // Arrange
    TypedEntity typedEntity = mock(TypedEntity.class);
    when(typedEntity.getType()).thenReturn(new BreadcrumbDTOType(":", ":"));

    // Act
    boolean actualTypeMatchesAdminSectionResult = broadleafAdminTypedEntityRequestFilter
        .typeMatchesAdminSection(typedEntity, "/");

    // Assert
    verify(typedEntity).getType();
    assertFalse(actualTypeMatchesAdminSectionResult);
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#typeMatchesAdminSection(TypedEntity, String)}.
   * <ul>
   *   <li>Given {@link PermissionType#ALL}.</li>
   *   <li>When {@link TypedEntity} {@link TypedEntity#getType()} return {@link PermissionType#ALL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminTypedEntityRequestFilter#typeMatchesAdminSection(TypedEntity, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BroadleafAdminTypedEntityRequestFilter.typeMatchesAdminSection(TypedEntity, String)"})
  public void testTypeMatchesAdminSection_givenAll_whenTypedEntityGetTypeReturnAll() {
    // Arrange
    TypedEntity typedEntity = mock(TypedEntity.class);
    when(typedEntity.getType()).thenReturn(PermissionType.ALL);

    // Act
    boolean actualTypeMatchesAdminSectionResult = broadleafAdminTypedEntityRequestFilter
        .typeMatchesAdminSection(typedEntity, "Section Key");

    // Assert
    verify(typedEntity).getType();
    assertFalse(actualTypeMatchesAdminSectionResult);
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#typeMatchesAdminSection(TypedEntity, String)}.
   * <ul>
   *   <li>Given {@link BreadcrumbDTOType#BreadcrumbDTOType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminTypedEntityRequestFilter#typeMatchesAdminSection(TypedEntity, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BroadleafAdminTypedEntityRequestFilter.typeMatchesAdminSection(TypedEntity, String)"})
  public void testTypeMatchesAdminSection_givenBreadcrumbDTOType() {
    // Arrange
    TypedEntity typedEntity = mock(TypedEntity.class);
    when(typedEntity.getType()).thenReturn(new BreadcrumbDTOType());

    // Act
    boolean actualTypeMatchesAdminSectionResult = broadleafAdminTypedEntityRequestFilter
        .typeMatchesAdminSection(typedEntity, "Section Key");

    // Assert
    verify(typedEntity).getType();
    assertFalse(actualTypeMatchesAdminSectionResult);
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#adminUserHasAccess(AdminSection)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminTypedEntityRequestFilter#adminUserHasAccess(AdminSection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BroadleafAdminTypedEntityRequestFilter.adminUserHasAccess(AdminSection)"})
  public void testAdminUserHasAccess_thenReturnFalse() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());

    // Act
    boolean actualAdminUserHasAccessResult = broadleafAdminTypedEntityRequestFilter
        .adminUserHasAccess(new AdminSectionImpl());

    // Assert
    verify(securityVerifier).getPersistentAdminUser();
    assertFalse(actualAdminUserHasAccessResult);
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#getEntityTypeFromRequest(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code :}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminTypedEntityRequestFilter#getEntityTypeFromRequest(HttpServletRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BroadleafAdminTypedEntityRequestFilter.getEntityTypeFromRequest(HttpServletRequest)"})
  public void testGetEntityTypeFromRequest_givenColon() {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getServletPath()).thenReturn(":");

    // Act
    String actualEntityTypeFromRequest = broadleafAdminTypedEntityRequestFilter
        .getEntityTypeFromRequest(new JSCompatibilityRequestWrapper(request));

    // Assert
    verify(request).getServletPath();
    assertEquals(":", actualEntityTypeFromRequest);
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#getEntityTypeFromRequest(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminTypedEntityRequestFilter#getEntityTypeFromRequest(HttpServletRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BroadleafAdminTypedEntityRequestFilter.getEntityTypeFromRequest(HttpServletRequest)"})
  public void testGetEntityTypeFromRequest_givenHttpsExampleOrgExample() {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getServletPath()).thenReturn("https://example.org/example");

    // Act
    String actualEntityTypeFromRequest = broadleafAdminTypedEntityRequestFilter
        .getEntityTypeFromRequest(new JSCompatibilityRequestWrapper(request));

    // Assert
    verify(request).getServletPath();
    assertEquals(":", actualEntityTypeFromRequest);
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#getSectionKeyFromRequest(HttpServletRequest)}.
   * <p>
   * Method under test: {@link BroadleafAdminTypedEntityRequestFilter#getSectionKeyFromRequest(HttpServletRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BroadleafAdminTypedEntityRequestFilter.getSectionKeyFromRequest(HttpServletRequest)"})
  public void testGetSectionKeyFromRequest() {
    // Arrange, Act and Assert
    assertEquals("", broadleafAdminTypedEntityRequestFilter
        .getSectionKeyFromRequest(new JSCompatibilityRequestWrapper(new MockHttpServletRequest())));
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#getSectionKeyFromRequest(HttpServletRequest)}.
   * <p>
   * Method under test: {@link BroadleafAdminTypedEntityRequestFilter#getSectionKeyFromRequest(HttpServletRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BroadleafAdminTypedEntityRequestFilter.getSectionKeyFromRequest(HttpServletRequest)"})
  public void testGetSectionKeyFromRequest2() {
    // Arrange, Act and Assert
    assertEquals("", broadleafAdminTypedEntityRequestFilter.getSectionKeyFromRequest(new JSCompatibilityRequestWrapper(
        new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(new MockHttpServletRequest())))));
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#getSectionKeyFromRequest(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code https://example.org/example}.</li>
   *   <li>Then return {@code https:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminTypedEntityRequestFilter#getSectionKeyFromRequest(HttpServletRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BroadleafAdminTypedEntityRequestFilter.getSectionKeyFromRequest(HttpServletRequest)"})
  public void testGetSectionKeyFromRequest_givenHttpsExampleOrgExample_thenReturnHttps() {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getServletPath()).thenReturn("https://example.org/example");

    // Act
    String actualSectionKeyFromRequest = broadleafAdminTypedEntityRequestFilter
        .getSectionKeyFromRequest(new JSCompatibilityRequestWrapper(request));

    // Assert
    verify(request).getServletPath();
    assertEquals("https:", actualSectionKeyFromRequest);
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#getSectionKeyFromRequest(HttpServletRequest)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminTypedEntityRequestFilter#getSectionKeyFromRequest(HttpServletRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BroadleafAdminTypedEntityRequestFilter.getSectionKeyFromRequest(HttpServletRequest)"})
  public void testGetSectionKeyFromRequest_whenMockHttpServletRequest_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", broadleafAdminTypedEntityRequestFilter.getSectionKeyFromRequest(new MockHttpServletRequest()));
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#getTypeFieldName(AdminSection)}.
   * <ul>
   *   <li>Given {@code Ceiling Entity}.</li>
   *   <li>Then calls {@link AdminSectionImpl#getCeilingEntity()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminTypedEntityRequestFilter#getTypeFieldName(AdminSection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BroadleafAdminTypedEntityRequestFilter.getTypeFieldName(AdminSection)"})
  public void testGetTypeFieldName_givenCeilingEntity_thenCallsGetCeilingEntity() {
    // Arrange
    AdminSectionImpl adminSection = mock(AdminSectionImpl.class);
    when(adminSection.getCeilingEntity()).thenReturn("Ceiling Entity");

    // Act
    String actualTypeFieldName = broadleafAdminTypedEntityRequestFilter.getTypeFieldName(adminSection);

    // Assert
    verify(adminSection).getCeilingEntity();
    assertNull(actualTypeFieldName);
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#getTypeFieldName(AdminSection)}.
   * <ul>
   *   <li>When {@link AdminSectionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminTypedEntityRequestFilter#getTypeFieldName(AdminSection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BroadleafAdminTypedEntityRequestFilter.getTypeFieldName(AdminSection)"})
  public void testGetTypeFieldName_whenAdminSectionImpl() {
    // Arrange, Act and Assert
    assertNull(broadleafAdminTypedEntityRequestFilter.getTypeFieldName(new AdminSectionImpl()));
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#getTypeFieldName(AdminSection)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminTypedEntityRequestFilter#getTypeFieldName(AdminSection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BroadleafAdminTypedEntityRequestFilter.getTypeFieldName(AdminSection)"})
  public void testGetTypeFieldName_whenNull() {
    // Arrange, Act and Assert
    assertNull(broadleafAdminTypedEntityRequestFilter.getTypeFieldName(null));
  }

  /**
   * Test {@link BroadleafAdminTypedEntityRequestFilter#getOrder()}.
   * <p>
   * Method under test: {@link BroadleafAdminTypedEntityRequestFilter#getOrder()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int BroadleafAdminTypedEntityRequestFilter.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(1001000, (new BroadleafAdminTypedEntityRequestFilter()).getOrder());
  }
}

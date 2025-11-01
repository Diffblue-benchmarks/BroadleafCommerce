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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.broadleafcommerce.openadmin.server.security.domain.AdminSection;
import org.broadleafcommerce.openadmin.server.security.domain.AdminSectionImpl;
import org.broadleafcommerce.openadmin.server.security.service.type.PermissionType;
import org.broadleafcommerce.openadmin.web.compatibility.JSCompatibilityRequestWrapper;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

public class BroadleafAdminTypedEntityRequestFilterDiffblueTest {
  /**
   * Method under test:
   * {@link BroadleafAdminTypedEntityRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilterInternalUnlessIgnored() throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafAdminTypedEntityRequestFilter broadleafAdminTypedEntityRequestFilter = new BroadleafAdminTypedEntityRequestFilter();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();
    FilterChain filterChain = mock(FilterChain.class);
    doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    broadleafAdminTypedEntityRequestFilter.doFilterInternalUnlessIgnored(request, response, filterChain);

    // Assert that nothing has changed
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Method under test:
   * {@link BroadleafAdminTypedEntityRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilterInternalUnlessIgnored2() throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafAdminTypedEntityRequestFilter broadleafAdminTypedEntityRequestFilter = new BroadleafAdminTypedEntityRequestFilter();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(
        new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(new MockHttpServletRequest())));
    MockHttpServletResponse response = new MockHttpServletResponse();
    FilterChain filterChain = mock(FilterChain.class);
    doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    broadleafAdminTypedEntityRequestFilter.doFilterInternalUnlessIgnored(request, response, filterChain);

    // Assert that nothing has changed
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Method under test:
   * {@link BroadleafAdminTypedEntityRequestFilter#isRequestForTypedEntity(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testIsRequestForTypedEntity() throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafAdminTypedEntityRequestFilter broadleafAdminTypedEntityRequestFilter = new BroadleafAdminTypedEntityRequestFilter();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());

    // Act and Assert
    assertFalse(broadleafAdminTypedEntityRequestFilter.isRequestForTypedEntity(request, new MockHttpServletResponse()));
  }

  /**
   * Method under test:
   * {@link BroadleafAdminTypedEntityRequestFilter#isRequestForTypedEntity(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testIsRequestForTypedEntity2() throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafAdminTypedEntityRequestFilter broadleafAdminTypedEntityRequestFilter = new BroadleafAdminTypedEntityRequestFilter();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(
        new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(new MockHttpServletRequest())));

    // Act and Assert
    assertFalse(broadleafAdminTypedEntityRequestFilter.isRequestForTypedEntity(request, new MockHttpServletResponse()));
  }

  /**
   * Method under test:
   * {@link BroadleafAdminTypedEntityRequestFilter#isRequestForTypedEntity(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testIsRequestForTypedEntity3() throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafAdminTypedEntityRequestFilter broadleafAdminTypedEntityRequestFilter = new BroadleafAdminTypedEntityRequestFilter();
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertFalse(broadleafAdminTypedEntityRequestFilter.isRequestForTypedEntity(request, new MockHttpServletResponse()));
  }

  /**
   * Method under test:
   * {@link BroadleafAdminTypedEntityRequestFilter#getTypedEntityFromServletPathId(String, String)}
   */
  @Test
  public void testGetTypedEntityFromServletPathId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new BroadleafAdminTypedEntityRequestFilter()).getTypedEntityFromServletPathId("Servlet Path",
        "Ceiling Entity"));
  }

  /**
   * Method under test:
   * {@link BroadleafAdminTypedEntityRequestFilter#getTypedEntityFromServletPathId(String, String)}
   */
  @Test
  public void testGetTypedEntityFromServletPathId2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafAdminTypedEntityRequestFilter broadleafAdminTypedEntityRequestFilter = new BroadleafAdminTypedEntityRequestFilter();
    broadleafAdminTypedEntityRequestFilter.setEnvironment(mock(StandardEnvironment.class));

    // Act and Assert
    assertNull(
        broadleafAdminTypedEntityRequestFilter.getTypedEntityFromServletPathId("Servlet Path", "Ceiling Entity"));
  }

  /**
   * Method under test:
   * {@link BroadleafAdminTypedEntityRequestFilter#getTypeAdminSectionMismatchUrl(TypedEntity, String, String, String)}
   */
  @Test
  public void testGetTypeAdminSectionMismatchUrl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafAdminTypedEntityRequestFilter broadleafAdminTypedEntityRequestFilter = new BroadleafAdminTypedEntityRequestFilter();
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
   * Method under test:
   * {@link BroadleafAdminTypedEntityRequestFilter#getTypeAdminSectionMismatchUrl(TypedEntity, String, String, String)}
   */
  @Test
  public void testGetTypeAdminSectionMismatchUrl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafAdminTypedEntityRequestFilter broadleafAdminTypedEntityRequestFilter = new BroadleafAdminTypedEntityRequestFilter();
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
   * Method under test:
   * {@link BroadleafAdminTypedEntityRequestFilter#getTypeAdminSectionMismatchUrl(TypedEntity, String, String, String)}
   */
  @Test
  public void testGetTypeAdminSectionMismatchUrl3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafAdminTypedEntityRequestFilter broadleafAdminTypedEntityRequestFilter = new BroadleafAdminTypedEntityRequestFilter();
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
   * Method under test:
   * {@link BroadleafAdminTypedEntityRequestFilter#getTypeAdminSectionMismatchUrl(TypedEntity, String, String, String)}
   */
  @Test
  public void testGetTypeAdminSectionMismatchUrl4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafAdminTypedEntityRequestFilter broadleafAdminTypedEntityRequestFilter = new BroadleafAdminTypedEntityRequestFilter();
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
   * Method under test:
   * {@link BroadleafAdminTypedEntityRequestFilter#typeMatchesAdminSection(TypedEntity, String)}
   */
  @Test
  public void testTypeMatchesAdminSection() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafAdminTypedEntityRequestFilter broadleafAdminTypedEntityRequestFilter = new BroadleafAdminTypedEntityRequestFilter();
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
   * Method under test:
   * {@link BroadleafAdminTypedEntityRequestFilter#typeMatchesAdminSection(TypedEntity, String)}
   */
  @Test
  public void testTypeMatchesAdminSection2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafAdminTypedEntityRequestFilter broadleafAdminTypedEntityRequestFilter = new BroadleafAdminTypedEntityRequestFilter();
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
   * Method under test:
   * {@link BroadleafAdminTypedEntityRequestFilter#typeMatchesAdminSection(TypedEntity, String)}
   */
  @Test
  public void testTypeMatchesAdminSection3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafAdminTypedEntityRequestFilter broadleafAdminTypedEntityRequestFilter = new BroadleafAdminTypedEntityRequestFilter();
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
   * Method under test:
   * {@link BroadleafAdminTypedEntityRequestFilter#getEntityTypeFromRequest(HttpServletRequest)}
   */
  @Test
  public void testGetEntityTypeFromRequest() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafAdminTypedEntityRequestFilter broadleafAdminTypedEntityRequestFilter = new BroadleafAdminTypedEntityRequestFilter();
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
   * Method under test:
   * {@link BroadleafAdminTypedEntityRequestFilter#getEntityTypeFromRequest(HttpServletRequest)}
   */
  @Test
  public void testGetEntityTypeFromRequest2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafAdminTypedEntityRequestFilter broadleafAdminTypedEntityRequestFilter = new BroadleafAdminTypedEntityRequestFilter();
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
   * Method under test:
   * {@link BroadleafAdminTypedEntityRequestFilter#getSectionKeyFromRequest(HttpServletRequest)}
   */
  @Test
  public void testGetSectionKeyFromRequest() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafAdminTypedEntityRequestFilter broadleafAdminTypedEntityRequestFilter = new BroadleafAdminTypedEntityRequestFilter();

    // Act and Assert
    assertEquals("", broadleafAdminTypedEntityRequestFilter
        .getSectionKeyFromRequest(new JSCompatibilityRequestWrapper(new MockHttpServletRequest())));
  }

  /**
   * Method under test:
   * {@link BroadleafAdminTypedEntityRequestFilter#getSectionKeyFromRequest(HttpServletRequest)}
   */
  @Test
  public void testGetSectionKeyFromRequest2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafAdminTypedEntityRequestFilter broadleafAdminTypedEntityRequestFilter = new BroadleafAdminTypedEntityRequestFilter();

    // Act and Assert
    assertEquals("", broadleafAdminTypedEntityRequestFilter.getSectionKeyFromRequest(new JSCompatibilityRequestWrapper(
        new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(new MockHttpServletRequest())))));
  }

  /**
   * Method under test:
   * {@link BroadleafAdminTypedEntityRequestFilter#getSectionKeyFromRequest(HttpServletRequest)}
   */
  @Test
  public void testGetSectionKeyFromRequest3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafAdminTypedEntityRequestFilter broadleafAdminTypedEntityRequestFilter = new BroadleafAdminTypedEntityRequestFilter();
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
   * Method under test:
   * {@link BroadleafAdminTypedEntityRequestFilter#getSectionKeyFromRequest(HttpServletRequest)}
   */
  @Test
  public void testGetSectionKeyFromRequest4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafAdminTypedEntityRequestFilter broadleafAdminTypedEntityRequestFilter = new BroadleafAdminTypedEntityRequestFilter();

    // Act and Assert
    assertEquals("", broadleafAdminTypedEntityRequestFilter.getSectionKeyFromRequest(new MockHttpServletRequest()));
  }

  /**
   * Method under test:
   * {@link BroadleafAdminTypedEntityRequestFilter#getTypeFieldName(AdminSection)}
   */
  @Test
  public void testGetTypeFieldName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafAdminTypedEntityRequestFilter broadleafAdminTypedEntityRequestFilter = new BroadleafAdminTypedEntityRequestFilter();

    // Act and Assert
    assertNull(broadleafAdminTypedEntityRequestFilter.getTypeFieldName(new AdminSectionImpl()));
  }

  /**
   * Method under test:
   * {@link BroadleafAdminTypedEntityRequestFilter#getTypeFieldName(AdminSection)}
   */
  @Test
  public void testGetTypeFieldName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new BroadleafAdminTypedEntityRequestFilter()).getTypeFieldName(null));
  }

  /**
   * Method under test:
   * {@link BroadleafAdminTypedEntityRequestFilter#getTypeFieldName(AdminSection)}
   */
  @Test
  public void testGetTypeFieldName3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafAdminTypedEntityRequestFilter broadleafAdminTypedEntityRequestFilter = new BroadleafAdminTypedEntityRequestFilter();
    AdminSectionImpl adminSection = mock(AdminSectionImpl.class);
    when(adminSection.getCeilingEntity()).thenReturn("Ceiling Entity");

    // Act
    String actualTypeFieldName = broadleafAdminTypedEntityRequestFilter.getTypeFieldName(adminSection);

    // Assert
    verify(adminSection).getCeilingEntity();
    assertNull(actualTypeFieldName);
  }

  /**
   * Method under test: {@link BroadleafAdminTypedEntityRequestFilter#getOrder()}
   */
  @Test
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(1001000, (new BroadleafAdminTypedEntityRequestFilter()).getOrder());
  }
}

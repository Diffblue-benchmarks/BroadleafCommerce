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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.exception.SiteNotFoundException;
import org.broadleafcommerce.common.security.service.StaleStateProtectionService;
import org.broadleafcommerce.common.web.BroadleafWebRequestProcessor;
import org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationService;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceThreadManager;
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
import org.springframework.web.context.request.WebRequest;

@ContextConfiguration(classes = {BroadleafAdminRequestFilter.class})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class BroadleafAdminRequestFilterDiffblueTest {
  @Autowired private BroadleafAdminRequestFilter broadleafAdminRequestFilter;

  @MockBean(name = "blAdminRequestProcessor")
  private BroadleafWebRequestProcessor broadleafWebRequestProcessor;

  @MockBean(name = "blClassNameRequestParamValidationService")
  private ClassNameRequestParamValidationService classNameRequestParamValidationService;

  @MockBean(name = "blPersistenceThreadManager")
  private PersistenceThreadManager persistenceThreadManager;

  @MockBean(name = "blStaleStateProtectionService")
  private StaleStateProtectionService staleStateProtectionService;

  /**
   * Test {@link BroadleafAdminRequestFilter#validateClassNameParams(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Given {@code /translations}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAdminRequestFilter#validateClassNameParams(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafAdminRequestFilter.validateClassNameParams(HttpServletRequest)"
  })
  public void testValidateClassNameParams_givenTranslations() {
    // Arrange
    when(classNameRequestParamValidationService.validateClassNameParams(
            Mockito.<Map<String, String>>any(), Mockito.<String>any()))
        .thenReturn(true);

    MockHttpServletRequest request = new MockHttpServletRequest(new MockServletContext());
    request.setServletPath("/translations");

    // Act
    boolean actualValidateClassNameParamsResult =
        broadleafAdminRequestFilter.validateClassNameParams(request);

    // Assert
    verify(classNameRequestParamValidationService)
        .validateClassNameParams(isA(Map.class), eq("blPU"));
    assertTrue(actualValidateClassNameParamsResult);
  }

  /**
   * Test {@link BroadleafAdminRequestFilter#validateClassNameParams(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAdminRequestFilter#validateClassNameParams(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafAdminRequestFilter.validateClassNameParams(HttpServletRequest)"
  })
  public void testValidateClassNameParams_thenReturnTrue() {
    // Arrange
    when(classNameRequestParamValidationService.validateClassNameParams(
            Mockito.<Map<String, String>>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act
    boolean actualValidateClassNameParamsResult =
        broadleafAdminRequestFilter.validateClassNameParams(
            new HttpServletRequestWrapper(
                new JSCompatibilityRequestWrapper(new MockHttpServletRequest())));

    // Assert
    verify(classNameRequestParamValidationService)
        .validateClassNameParams(isA(Map.class), eq("blPU"));
    assertTrue(actualValidateClassNameParamsResult);
  }

  /**
   * Test {@link BroadleafAdminRequestFilter#validateClassNameParams(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then throw {@link SiteNotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAdminRequestFilter#validateClassNameParams(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafAdminRequestFilter.validateClassNameParams(HttpServletRequest)"
  })
  public void testValidateClassNameParams_thenThrowSiteNotFoundException() {
    // Arrange
    when(classNameRequestParamValidationService.validateClassNameParams(
            Mockito.<Map<String, String>>any(), Mockito.<String>any()))
        .thenThrow(new SiteNotFoundException("An error occurred"));

    // Act and Assert
    assertThrows(
        SiteNotFoundException.class,
        () ->
            broadleafAdminRequestFilter.validateClassNameParams(
                new HttpServletRequestWrapper(
                    new JSCompatibilityRequestWrapper(new MockHttpServletRequest()))));
    verify(classNameRequestParamValidationService)
        .validateClassNameParams(isA(Map.class), eq("blPU"));
  }

  /**
   * Test {@link BroadleafAdminRequestFilter#forwardToConflictDestination(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link
   * BroadleafAdminRequestFilter#forwardToConflictDestination(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminRequestFilter.forwardToConflictDestination(HttpServletRequest, HttpServletResponse)"
  })
  public void testForwardToConflictDestination() throws IOException, ServletException {
    // Arrange
    doNothing().when(broadleafWebRequestProcessor).process(Mockito.<WebRequest>any());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAdminRequestFilter.forwardToConflictDestination(request, response);

    // Assert
    verify(broadleafWebRequestProcessor).process(isA(WebRequest.class));
    assertEquals("/sc_conflict", response.getForwardedUrl());
    assertEquals(409, response.getStatus());
  }

  /**
   * Test {@link BroadleafAdminRequestFilter#forwardToConflictDestination(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then throw {@link SiteNotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAdminRequestFilter#forwardToConflictDestination(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminRequestFilter.forwardToConflictDestination(HttpServletRequest, HttpServletResponse)"
  })
  public void testForwardToConflictDestination_thenThrowSiteNotFoundException()
      throws IOException, ServletException {
    // Arrange
    doThrow(new SiteNotFoundException("An error occurred"))
        .when(broadleafWebRequestProcessor)
        .process(Mockito.<WebRequest>any());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertThrows(
        SiteNotFoundException.class,
        () ->
            broadleafAdminRequestFilter.forwardToConflictDestination(
                request, new MockHttpServletResponse()));
    verify(broadleafWebRequestProcessor).process(isA(WebRequest.class));
  }

  /**
   * Test {@link BroadleafAdminRequestFilter#getOrder()}.
   *
   * <p>Method under test: {@link BroadleafAdminRequestFilter#getOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int BroadleafAdminRequestFilter.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(10000, broadleafAdminRequestFilter.getOrder());
  }
}

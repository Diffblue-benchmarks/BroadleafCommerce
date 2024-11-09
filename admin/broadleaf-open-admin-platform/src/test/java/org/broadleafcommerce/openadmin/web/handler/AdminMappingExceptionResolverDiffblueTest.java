/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.web.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.openadmin.exception.EntityNotFoundException;
import org.broadleafcommerce.openadmin.web.compatibility.JSCompatibilityRequestWrapper;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class AdminMappingExceptionResolverDiffblueTest {
  /**
   * Test
   * {@link AdminMappingExceptionResolver#resolveException(HttpServletRequest, HttpServletResponse, Object, Exception)}.
   * <ul>
   *   <li>Given {@link AdminMappingExceptionResolver} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminMappingExceptionResolver#resolveException(HttpServletRequest, HttpServletResponse, Object, Exception)}
   */
  @Test
  public void testResolveException_givenAdminMappingExceptionResolver_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminMappingExceptionResolver adminMappingExceptionResolver = new AdminMappingExceptionResolver();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertNull(adminMappingExceptionResolver.resolveException(request, response, "Handler", new Exception("foo")));
  }

  /**
   * Test
   * {@link AdminMappingExceptionResolver#resolveException(HttpServletRequest, HttpServletResponse, Object, Exception)}.
   * <ul>
   *   <li>When {@link EntityNotFoundException}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminMappingExceptionResolver#resolveException(HttpServletRequest, HttpServletResponse, Object, Exception)}
   */
  @Test
  public void testResolveException_whenEntityNotFoundException_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminMappingExceptionResolver adminMappingExceptionResolver = new AdminMappingExceptionResolver();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();
    EntityNotFoundException entityNotFoundException = mock(EntityNotFoundException.class);

    // Act and Assert
    assertNull(adminMappingExceptionResolver.resolveException(request, response, entityNotFoundException,
        new Exception("foo")));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdminMappingExceptionResolver#setEnableStacktrace(boolean)}
   *   <li>{@link AdminMappingExceptionResolver#setShowDebugMessage(boolean)}
   *   <li>{@link AdminMappingExceptionResolver#isEnableStacktrace()}
   *   <li>{@link AdminMappingExceptionResolver#isShowDebugMessage()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    AdminMappingExceptionResolver adminMappingExceptionResolver = new AdminMappingExceptionResolver();

    // Act
    adminMappingExceptionResolver.setEnableStacktrace(true);
    adminMappingExceptionResolver.setShowDebugMessage(true);
    boolean actualIsEnableStacktraceResult = adminMappingExceptionResolver.isEnableStacktrace();

    // Assert that nothing has changed
    assertTrue(actualIsEnableStacktraceResult);
    assertTrue(adminMappingExceptionResolver.isShowDebugMessage());
  }

  /**
   * Test new {@link AdminMappingExceptionResolver} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AdminMappingExceptionResolver}
   */
  @Test
  public void testNewAdminMappingExceptionResolver() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    AdminMappingExceptionResolver actualAdminMappingExceptionResolver = new AdminMappingExceptionResolver();

    // Assert
    assertFalse(actualAdminMappingExceptionResolver.isEnableStacktrace());
    assertFalse(actualAdminMappingExceptionResolver.isShowDebugMessage());
    assertTrue(actualAdminMappingExceptionResolver.getStatusCodesAsMap().isEmpty());
    assertEquals(Integer.MAX_VALUE, actualAdminMappingExceptionResolver.getOrder());
  }
}

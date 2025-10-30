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
package org.broadleafcommerce.openadmin.web.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.openadmin.web.compatibility.JSCompatibilityRequestWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AdminMappingExceptionResolver.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminMappingExceptionResolverDiffblueTest {
  @Autowired
  private AdminMappingExceptionResolver adminMappingExceptionResolver;

  /**
   * Test {@link AdminMappingExceptionResolver#resolveException(HttpServletRequest, HttpServletResponse, Object, Exception)}.
   * <ul>
   *   <li>Given {@link AdminMappingExceptionResolver}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminMappingExceptionResolver#resolveException(HttpServletRequest, HttpServletResponse, Object, Exception)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.springframework.web.servlet.ModelAndView AdminMappingExceptionResolver.resolveException(HttpServletRequest, HttpServletResponse, Object, Exception)"})
  public void testResolveException_givenAdminMappingExceptionResolver_thenReturnNull() {
    // Arrange
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertNull(adminMappingExceptionResolver.resolveException(request, response, "Handler", new Exception("foo")));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminMappingExceptionResolver.isEnableStacktrace()",
      "boolean AdminMappingExceptionResolver.isShowDebugMessage()",
      "void AdminMappingExceptionResolver.setEnableStacktrace(boolean)",
      "void AdminMappingExceptionResolver.setShowDebugMessage(boolean)"})
  public void testGettersAndSetters() {
    // Arrange
    AdminMappingExceptionResolver adminMappingExceptionResolver = new AdminMappingExceptionResolver();

    // Act
    adminMappingExceptionResolver.setEnableStacktrace(true);
    adminMappingExceptionResolver.setShowDebugMessage(true);
    boolean actualIsEnableStacktraceResult = adminMappingExceptionResolver.isEnableStacktrace();

    // Assert
    assertTrue(actualIsEnableStacktraceResult);
    assertTrue(adminMappingExceptionResolver.isShowDebugMessage());
  }

  /**
   * Test new {@link AdminMappingExceptionResolver} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link AdminMappingExceptionResolver}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminMappingExceptionResolver.<init>()"})
  public void testNewAdminMappingExceptionResolver() {
    // Arrange and Act
    AdminMappingExceptionResolver actualAdminMappingExceptionResolver = new AdminMappingExceptionResolver();

    // Assert
    assertFalse(actualAdminMappingExceptionResolver.isEnableStacktrace());
    assertFalse(actualAdminMappingExceptionResolver.isShowDebugMessage());
    assertTrue(actualAdminMappingExceptionResolver.getStatusCodesAsMap().isEmpty());
    assertEquals(Integer.MAX_VALUE, actualAdminMappingExceptionResolver.getOrder());
  }
}

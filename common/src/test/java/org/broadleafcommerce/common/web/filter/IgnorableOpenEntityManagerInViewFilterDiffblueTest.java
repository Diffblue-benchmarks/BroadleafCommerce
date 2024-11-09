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
package org.broadleafcommerce.common.web.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import java.io.IOException;
import java.nio.file.Paths;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.web.util.FileSystemResponseWrapper;
import org.broadleafcommerce.common.web.util.StatusExposingServletResponse;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class IgnorableOpenEntityManagerInViewFilterDiffblueTest {
  /**
   * Test
   * {@link IgnorableOpenEntityManagerInViewFilter#isIgnored(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IgnorableOpenEntityManagerInViewFilter#isIgnored(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testIsIgnored_thenReturnFalse() throws IOException {
    // Arrange
    IgnorableOpenEntityManagerInViewFilter ignorableOpenEntityManagerInViewFilter = new IgnorableOpenEntityManagerInViewFilter();
    SessionlessHttpServletRequestWrapper httpServletRequest = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertFalse(ignorableOpenEntityManagerInViewFilter.isIgnored(httpServletRequest,
        new StatusExposingServletResponse(new FileSystemResponseWrapper(response,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))));
  }

  /**
   * Test {@link IgnorableOpenEntityManagerInViewFilter#getOrder()}.
   * <p>
   * Method under test: {@link IgnorableOpenEntityManagerInViewFilter#getOrder()}
   */
  @Test
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(FilterOrdered.PRE_SECURITY_HIGH, (new IgnorableOpenEntityManagerInViewFilter()).getOrder());
  }
}

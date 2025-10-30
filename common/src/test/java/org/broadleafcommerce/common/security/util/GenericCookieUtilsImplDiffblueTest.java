/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.security.util;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.owasp.esapi.filters.SecurityWrapperRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {GenericCookieUtilsImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class GenericCookieUtilsImplDiffblueTest {
  @Autowired
  private GenericCookieUtilsImpl genericCookieUtilsImpl;

  /**
   * Test {@link GenericCookieUtilsImpl#getCookieValue(HttpServletRequest, String)}.
   * <p>
   * Method under test: {@link GenericCookieUtilsImpl#getCookieValue(HttpServletRequest, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String GenericCookieUtilsImpl.getCookieValue(HttpServletRequest, String)"})
  public void testGetCookieValue() {
    // Arrange, Act and Assert
    assertNull(genericCookieUtilsImpl.getCookieValue(
        new SessionlessHttpServletRequestWrapper(
            new SecurityWrapperRequest(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()))),
        "Cookie Name"));
  }

  /**
   * Test {@link GenericCookieUtilsImpl#getCookieValue(HttpServletRequest, String)}.
   * <p>
   * Method under test: {@link GenericCookieUtilsImpl#getCookieValue(HttpServletRequest, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String GenericCookieUtilsImpl.getCookieValue(HttpServletRequest, String)"})
  public void testGetCookieValue2() {
    // Arrange, Act and Assert
    assertNull(genericCookieUtilsImpl.getCookieValue(
        new SessionlessHttpServletRequestWrapper(new SecurityWrapperRequest(new SessionlessHttpServletRequestWrapper(
            new SecurityWrapperRequest(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()))))),
        "Cookie Name"));
  }

  /**
   * Test {@link GenericCookieUtilsImpl#getCookieValue(HttpServletRequest, String)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericCookieUtilsImpl#getCookieValue(HttpServletRequest, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String GenericCookieUtilsImpl.getCookieValue(HttpServletRequest, String)"})
  public void testGetCookieValue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(genericCookieUtilsImpl
        .getCookieValue(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()), "Cookie Name"));
  }
}

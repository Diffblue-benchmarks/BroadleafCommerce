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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.owasp.esapi.filters.SecurityWrapperRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {GenericCookieUtilsImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class GenericCookieUtilsImplDiffblueTest {
  @Autowired private GenericCookieUtilsImpl genericCookieUtilsImpl;

  /**
   * Test {@link GenericCookieUtilsImpl#getCookieValue(HttpServletRequest, String)}.
   *
   * <p>Method under test: {@link GenericCookieUtilsImpl#getCookieValue(HttpServletRequest, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GenericCookieUtilsImpl.getCookieValue(HttpServletRequest, String)"})
  public void testGetCookieValue() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    SecurityWrapperRequest request2 = new SecurityWrapperRequest(request);
    SessionlessHttpServletRequestWrapper request3 =
        new SessionlessHttpServletRequestWrapper(request2);

    // Act and Assert
    assertNull(
        genericCookieUtilsImpl.getCookieValue(
            new HttpServletRequestWrapper(request3), "Cookie Name"));
  }

  /**
   * Test {@link GenericCookieUtilsImpl#getCookieValue(HttpServletRequest, String)}.
   *
   * <p>Method under test: {@link GenericCookieUtilsImpl#getCookieValue(HttpServletRequest, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GenericCookieUtilsImpl.getCookieValue(HttpServletRequest, String)"})
  public void testGetCookieValue2() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    SecurityWrapperRequest request2 = new SecurityWrapperRequest(request);
    SessionlessHttpServletRequestWrapper request3 =
        new SessionlessHttpServletRequestWrapper(request2);
    HttpServletRequestWrapper request4 = new HttpServletRequestWrapper(request3);
    SecurityWrapperRequest request5 = new SecurityWrapperRequest(request4);
    SessionlessHttpServletRequestWrapper request6 =
        new SessionlessHttpServletRequestWrapper(request5);

    // Act and Assert
    assertNull(
        genericCookieUtilsImpl.getCookieValue(
            new HttpServletRequestWrapper(request6), "Cookie Name"));
  }

  /**
   * Test {@link GenericCookieUtilsImpl#getCookieValue(HttpServletRequest, String)}.
   *
   * <p>Method under test: {@link GenericCookieUtilsImpl#getCookieValue(HttpServletRequest, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GenericCookieUtilsImpl.getCookieValue(HttpServletRequest, String)"})
  public void testGetCookieValue3() {
    // Arrange
    GenericCookieUtilsImpl genericCookieUtilsImpl = new GenericCookieUtilsImpl();

    MockHttpServletRequest request = new MockHttpServletRequest(new MockServletContext());
    request.setCookies(new Cookie("Name", "https://example.org/example"));

    // Act and Assert
    assertNull(genericCookieUtilsImpl.getCookieValue(request, "Cookie Name"));
  }

  /**
   * Test {@link GenericCookieUtilsImpl#getCookieValue(HttpServletRequest, String)}.
   *
   * <ul>
   *   <li>Given {@link GenericCookieUtilsImpl}.
   * </ul>
   *
   * <p>Method under test: {@link GenericCookieUtilsImpl#getCookieValue(HttpServletRequest, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GenericCookieUtilsImpl.getCookieValue(HttpServletRequest, String)"})
  public void testGetCookieValue_givenGenericCookieUtilsImpl() {
    // Arrange, Act and Assert
    assertNull(
        genericCookieUtilsImpl.getCookieValue(
            new HttpServletRequestWrapper(
                new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())),
            "Cookie Name"));
  }

  /**
   * Test {@link GenericCookieUtilsImpl#getCookieValue(HttpServletRequest, String)}.
   *
   * <ul>
   *   <li>Given {@link GenericCookieUtilsImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GenericCookieUtilsImpl#getCookieValue(HttpServletRequest, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GenericCookieUtilsImpl.getCookieValue(HttpServletRequest, String)"})
  public void testGetCookieValue_givenGenericCookieUtilsImpl2() {
    // Arrange
    GenericCookieUtilsImpl genericCookieUtilsImpl = new GenericCookieUtilsImpl();
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    SecurityWrapperRequest request2 = new SecurityWrapperRequest(request);
    SessionlessHttpServletRequestWrapper request3 =
        new SessionlessHttpServletRequestWrapper(request2);
    HttpServletRequestWrapper request4 = new HttpServletRequestWrapper(request3);
    SecurityWrapperRequest request5 = new SecurityWrapperRequest(request4);
    SessionlessHttpServletRequestWrapper request6 =
        new SessionlessHttpServletRequestWrapper(request5);
    HttpServletRequestWrapper request7 = new HttpServletRequestWrapper(request6);
    SecurityWrapperRequest request8 = new SecurityWrapperRequest(request7);
    SessionlessHttpServletRequestWrapper request9 =
        new SessionlessHttpServletRequestWrapper(request8);

    // Act and Assert
    assertNull(
        genericCookieUtilsImpl.getCookieValue(
            new HttpServletRequestWrapper(request9), "Cookie Name"));
  }

  /**
   * Test {@link GenericCookieUtilsImpl#getCookieValue(HttpServletRequest, String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link GenericCookieUtilsImpl#getCookieValue(HttpServletRequest, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GenericCookieUtilsImpl.getCookieValue(HttpServletRequest, String)"})
  public void testGetCookieValue_whenName_thenReturnHttpsExampleOrgExample() {
    // Arrange
    GenericCookieUtilsImpl genericCookieUtilsImpl = new GenericCookieUtilsImpl();

    MockHttpServletRequest request = new MockHttpServletRequest(new MockServletContext());
    request.setCookies(new Cookie("Name", "https://example.org/example"));

    // Act and Assert
    assertEquals(
        "https://example.org/example", genericCookieUtilsImpl.getCookieValue(request, "Name"));
  }
}

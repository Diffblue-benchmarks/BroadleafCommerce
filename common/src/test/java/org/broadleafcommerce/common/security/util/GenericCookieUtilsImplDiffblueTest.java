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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.junit.Test;
import org.owasp.esapi.filters.SecurityWrapperRequest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

public class GenericCookieUtilsImplDiffblueTest {
  /**
   * Method under test:
   * {@link GenericCookieUtilsImpl#getCookieValue(HttpServletRequest, String)}
   */
  @Test
  public void testGetCookieValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    GenericCookieUtilsImpl genericCookieUtilsImpl = new GenericCookieUtilsImpl();

    // Act and Assert
    assertNull(genericCookieUtilsImpl
        .getCookieValue(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()), "Cookie Name"));
  }

  /**
   * Method under test:
   * {@link GenericCookieUtilsImpl#getCookieValue(HttpServletRequest, String)}
   */
  @Test
  public void testGetCookieValue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    GenericCookieUtilsImpl genericCookieUtilsImpl = new GenericCookieUtilsImpl();

    // Act and Assert
    assertNull(genericCookieUtilsImpl.getCookieValue(
        new SessionlessHttpServletRequestWrapper(
            new SecurityWrapperRequest(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()))),
        "Cookie Name"));
  }

  /**
   * Method under test:
   * {@link GenericCookieUtilsImpl#getCookieValue(HttpServletRequest, String)}
   */
  @Test
  public void testGetCookieValue3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    GenericCookieUtilsImpl genericCookieUtilsImpl = new GenericCookieUtilsImpl();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getCookies()).thenReturn(new Cookie[]{new Cookie("Name", "https://example.org/example")});

    // Act
    String actualCookieValue = genericCookieUtilsImpl.getCookieValue(new SessionlessHttpServletRequestWrapper(request),
        "Cookie Name");

    // Assert
    verify(request).getCookies();
    assertNull(actualCookieValue);
  }

  /**
   * Method under test:
   * {@link GenericCookieUtilsImpl#getCookieValue(HttpServletRequest, String)}
   */
  @Test
  public void testGetCookieValue4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    GenericCookieUtilsImpl genericCookieUtilsImpl = new GenericCookieUtilsImpl();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getCookies()).thenReturn(new Cookie[]{new Cookie("Name", "https://example.org/example")});

    // Act
    String actualCookieValue = genericCookieUtilsImpl.getCookieValue(new SessionlessHttpServletRequestWrapper(request),
        "Name");

    // Assert
    verify(request).getCookies();
    assertEquals("https://example.org/example", actualCookieValue);
  }
}

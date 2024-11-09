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
package org.broadleafcommerce.common.web.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

public class BroadleafContextUtilDiffblueTest {
  /**
   * Test {@link BroadleafContextUtil#getContextName(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code https://example.org/example}.</li>
   *   <li>Then return {@code https://example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafContextUtil#getContextName(HttpServletRequest)}
   */
  @Test
  public void testGetContextName_givenHttpsExampleOrgExample_thenReturnHttpsExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafContextUtil broadleafContextUtil = new BroadleafContextUtil();
    MockHttpServletRequest request = mock(MockHttpServletRequest.class);
    when(request.getServerName()).thenReturn("https://example.org/example");

    // Act
    String actualContextName = broadleafContextUtil.getContextName(request);

    // Assert
    verify(request).getServerName();
    assertEquals("https://example", actualContextName);
  }

  /**
   * Test {@link BroadleafContextUtil#getContextName(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code Server Name}.</li>
   *   <li>Then return {@code Server Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafContextUtil#getContextName(HttpServletRequest)}
   */
  @Test
  public void testGetContextName_givenServerName_thenReturnServerName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafContextUtil broadleafContextUtil = new BroadleafContextUtil();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getServerName()).thenReturn("Server Name");

    // Act
    String actualContextName = broadleafContextUtil.getContextName(new SessionlessHttpServletRequestWrapper(request));

    // Assert
    verify(request).getServerName();
    assertEquals("Server Name", actualContextName);
  }

  /**
   * Test {@link BroadleafContextUtil#getContextName(HttpServletRequest)}.
   * <ul>
   *   <li>Then return {@code localhost}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafContextUtil#getContextName(HttpServletRequest)}
   */
  @Test
  public void testGetContextName_thenReturnLocalhost() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafContextUtil broadleafContextUtil = new BroadleafContextUtil();

    // Act and Assert
    assertEquals("localhost",
        broadleafContextUtil.getContextName(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())));
  }

  /**
   * Test
   * {@link BroadleafContextUtil#readSecurityContextFromSession(HttpSession)}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafContextUtil#readSecurityContextFromSession(HttpSession)}
   */
  @Test
  public void testReadSecurityContextFromSession_givenNull_field() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafContextUtil broadleafContextUtil = new BroadleafContextUtil();
    MockHttpSession httpSession = mock(MockHttpSession.class);
    when(httpSession.getAttribute(Mockito.<String>any())).thenReturn(BLCFieldUtils.NULL_FIELD);

    // Act
    SecurityContext actualReadSecurityContextFromSessionResult = broadleafContextUtil
        .readSecurityContextFromSession(httpSession);

    // Assert
    verify(httpSession).getAttribute(eq("SPRING_SECURITY_CONTEXT"));
    assertNull(actualReadSecurityContextFromSessionResult);
  }

  /**
   * Test
   * {@link BroadleafContextUtil#readSecurityContextFromSession(HttpSession)}.
   * <ul>
   *   <li>Then return {@link SecurityContextImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafContextUtil#readSecurityContextFromSession(HttpSession)}
   */
  @Test
  public void testReadSecurityContextFromSession_thenReturnSecurityContextImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafContextUtil broadleafContextUtil = new BroadleafContextUtil();
    MockHttpSession httpSession = mock(MockHttpSession.class);
    SecurityContextImpl securityContextImpl = new SecurityContextImpl();
    when(httpSession.getAttribute(Mockito.<String>any())).thenReturn(securityContextImpl);

    // Act
    SecurityContext actualReadSecurityContextFromSessionResult = broadleafContextUtil
        .readSecurityContextFromSession(httpSession);

    // Assert
    verify(httpSession).getAttribute(eq("SPRING_SECURITY_CONTEXT"));
    assertTrue(actualReadSecurityContextFromSessionResult instanceof SecurityContextImpl);
    assertNull(actualReadSecurityContextFromSessionResult.getAuthentication());
    assertSame(securityContextImpl, actualReadSecurityContextFromSessionResult);
  }

  /**
   * Test
   * {@link BroadleafContextUtil#readSecurityContextFromSession(HttpSession)}.
   * <ul>
   *   <li>When {@link MockHttpSession#MockHttpSession()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafContextUtil#readSecurityContextFromSession(HttpSession)}
   */
  @Test
  public void testReadSecurityContextFromSession_whenMockHttpSession_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafContextUtil broadleafContextUtil = new BroadleafContextUtil();

    // Act and Assert
    assertNull(broadleafContextUtil.readSecurityContextFromSession(new MockHttpSession()));
  }

  /**
   * Test
   * {@link BroadleafContextUtil#readSecurityContextFromSession(HttpSession)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafContextUtil#readSecurityContextFromSession(HttpSession)}
   */
  @Test
  public void testReadSecurityContextFromSession_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new BroadleafContextUtil()).readSecurityContextFromSession(null));
  }
}

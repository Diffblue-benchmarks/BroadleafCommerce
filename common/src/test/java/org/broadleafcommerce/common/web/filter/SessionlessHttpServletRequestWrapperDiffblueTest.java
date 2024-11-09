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

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import javax.servlet.http.HttpServletRequest;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;

public class SessionlessHttpServletRequestWrapperDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link SessionlessHttpServletRequestWrapper#SessionlessHttpServletRequestWrapper(HttpServletRequest)}
   *   <li>{@link SessionlessHttpServletRequestWrapper#getRequestedSessionId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act
    SessionlessHttpServletRequestWrapper actualSessionlessHttpServletRequestWrapper = new SessionlessHttpServletRequestWrapper(
        request);

    // Assert
    assertNull(actualSessionlessHttpServletRequestWrapper.getRequestedSessionId());
    assertSame(request, actualSessionlessHttpServletRequestWrapper.getRequest());
  }

  /**
   * Test {@link SessionlessHttpServletRequestWrapper#getSession()}.
   * <p>
   * Method under test: {@link SessionlessHttpServletRequestWrapper#getSession()}
   */
  @Test
  public void testGetSession() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())).getSession());
  }

  /**
   * Test {@link SessionlessHttpServletRequestWrapper#getSession(boolean)} with
   * {@code boolean}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SessionlessHttpServletRequestWrapper#getSession(boolean)}
   */
  @Test
  public void testGetSessionWithBoolean_whenFalse_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())).getSession(false));
  }

  /**
   * Test {@link SessionlessHttpServletRequestWrapper#getSession(boolean)} with
   * {@code boolean}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SessionlessHttpServletRequestWrapper#getSession(boolean)}
   */
  @Test
  public void testGetSessionWithBoolean_whenTrue_thenThrowUnsupportedOperationException() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())).getSession(true));
  }
}

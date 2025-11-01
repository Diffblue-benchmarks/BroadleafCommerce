/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.order;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.web.session.HttpSessionDestroyedEvent;

class SessionOrderLockManagerDiffblueTest {
  /**
   * Method under test: {@link SessionOrderLockManager#acquireLock(Order)}
   */
  @Test
  void testAcquireLock() {
    // Arrange
    SessionOrderLockManager sessionOrderLockManager = new SessionOrderLockManager();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> sessionOrderLockManager.acquireLock(new NullOrderImpl()));
  }

  /**
   * Method under test:
   * {@link SessionOrderLockManager#acquireLockIfAvailable(Order)}
   */
  @Test
  void testAcquireLockIfAvailable() {
    // Arrange
    SessionOrderLockManager sessionOrderLockManager = new SessionOrderLockManager();

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> sessionOrderLockManager.acquireLockIfAvailable(new NullOrderImpl()));
  }

  /**
   * Method under test:
   * {@link SessionOrderLockManager#onApplicationEvent(HttpSessionDestroyedEvent)}
   */
  @Test
  void testOnApplicationEvent() {
    // Arrange
    SessionOrderLockManager sessionOrderLockManager = new SessionOrderLockManager();
    MockHttpSession session = mock(MockHttpSession.class);
    when(session.getId()).thenReturn("https://example.org/example");
    doNothing().when(session).putValue(Mockito.<String>any(), Mockito.<Object>any());
    session.putValue("https://example.org/example", "Value");

    // Act
    sessionOrderLockManager.onApplicationEvent(new HttpSessionDestroyedEvent(session));

    // Assert
    verify(session).getId();
    verify(session).putValue(eq("https://example.org/example"), isA(Object.class));
  }

  /**
   * Method under test: {@link SessionOrderLockManager#getRequest()}
   */
  @Test
  void testGetRequest() {
    // Arrange, Act and Assert
    assertNull((new SessionOrderLockManager()).getRequest());
  }

  /**
   * Method under test: {@link SessionOrderLockManager#getSessionLock()}
   */
  @Test
  void testGetSessionLock() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new SessionOrderLockManager()).getSessionLock());
  }

  /**
   * Method under test: {@link SessionOrderLockManager#isActive()}
   */
  @Test
  void testIsActive() {
    // Arrange, Act and Assert
    assertFalse((new SessionOrderLockManager()).isActive());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link SessionOrderLockManager}
   */
  @Test
  void testNewSessionOrderLockManager() {
    // Arrange and Act
    SessionOrderLockManager actualSessionOrderLockManager = new SessionOrderLockManager();

    // Assert
    assertNull(actualSessionOrderLockManager.getRequest());
    assertFalse(actualSessionOrderLockManager.isActive());
  }
}

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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SessionOrderLockManagerDiffblueTest {
  /**
   * Test {@link SessionOrderLockManager#acquireLock(Order)}.
   *
   * <p>Method under test: {@link SessionOrderLockManager#acquireLock(Order)}
   */
  @Test
  @DisplayName("Test acquireLock(Order)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Object SessionOrderLockManager.acquireLock(Order)"})
  void testAcquireLock() {
    // Arrange
    SessionOrderLockManager sessionOrderLockManager = new SessionOrderLockManager();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> sessionOrderLockManager.acquireLock(new NullOrderImpl()));
  }

  /**
   * Test {@link SessionOrderLockManager#acquireLockIfAvailable(Order)}.
   *
   * <p>Method under test: {@link SessionOrderLockManager#acquireLockIfAvailable(Order)}
   */
  @Test
  @DisplayName("Test acquireLockIfAvailable(Order)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Object SessionOrderLockManager.acquireLockIfAvailable(Order)"})
  void testAcquireLockIfAvailable() {
    // Arrange
    SessionOrderLockManager sessionOrderLockManager = new SessionOrderLockManager();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> sessionOrderLockManager.acquireLockIfAvailable(new NullOrderImpl()));
  }

  /**
   * Test {@link SessionOrderLockManager#getRequest()}.
   *
   * <p>Method under test: {@link SessionOrderLockManager#getRequest()}
   */
  @Test
  @DisplayName("Test getRequest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"javax.servlet.http.HttpServletRequest SessionOrderLockManager.getRequest()"})
  void testGetRequest() {
    // Arrange, Act and Assert
    assertNull(new SessionOrderLockManager().getRequest());
  }

  /**
   * Test {@link SessionOrderLockManager#getSessionLock()}.
   *
   * <p>Method under test: {@link SessionOrderLockManager#getSessionLock()}
   */
  @Test
  @DisplayName("Test getSessionLock()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.concurrent.locks.ReentrantLock SessionOrderLockManager.getSessionLock()"
  })
  void testGetSessionLock() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> new SessionOrderLockManager().getSessionLock());
  }

  /**
   * Test {@link SessionOrderLockManager#isActive()}.
   *
   * <p>Method under test: {@link SessionOrderLockManager#isActive()}
   */
  @Test
  @DisplayName("Test isActive()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SessionOrderLockManager.isActive()"})
  void testIsActive() {
    // Arrange, Act and Assert
    assertFalse(new SessionOrderLockManager().isActive());
  }

  /**
   * Test new {@link SessionOrderLockManager} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link SessionOrderLockManager}
   */
  @Test
  @DisplayName("Test new SessionOrderLockManager (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SessionOrderLockManager.<init>()"})
  void testNewSessionOrderLockManager() {
    // Arrange and Act
    SessionOrderLockManager actualSessionOrderLockManager = new SessionOrderLockManager();

    // Assert
    assertNull(actualSessionOrderLockManager.getRequest());
    assertFalse(actualSessionOrderLockManager.isActive());
  }
}

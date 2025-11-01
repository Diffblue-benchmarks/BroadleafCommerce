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

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.junit.jupiter.api.Test;

class DatabaseOrderLockManagerDiffblueTest {
  /**
   * Method under test: {@link DatabaseOrderLockManager#acquireLock(Order)}
   */
  @Test
  void testAcquireLock() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DatabaseOrderLockManager databaseOrderLockManager = new DatabaseOrderLockManager();
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertSame(order, databaseOrderLockManager.acquireLock(order));
  }

  /**
   * Method under test: {@link DatabaseOrderLockManager#acquireLock(Order)}
   */
  @Test
  void testAcquireLock2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new DatabaseOrderLockManager()).acquireLock(null));
  }

  /**
   * Method under test: {@link DatabaseOrderLockManager#acquireLock(Order)}
   */
  @Test
  void testAcquireLock3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);

    // Act and Assert
    assertSame(order, (new DatabaseOrderLockManager()).acquireLock(order));
  }

  /**
   * Method under test:
   * {@link DatabaseOrderLockManager#acquireLockIfAvailable(Order)}
   */
  @Test
  void testAcquireLockIfAvailable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DatabaseOrderLockManager databaseOrderLockManager = new DatabaseOrderLockManager();
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertSame(order, databaseOrderLockManager.acquireLockIfAvailable(order));
  }

  /**
   * Method under test:
   * {@link DatabaseOrderLockManager#acquireLockIfAvailable(Order)}
   */
  @Test
  void testAcquireLockIfAvailable2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new DatabaseOrderLockManager()).acquireLockIfAvailable(null));
  }

  /**
   * Method under test:
   * {@link DatabaseOrderLockManager#acquireLockIfAvailable(Order)}
   */
  @Test
  void testAcquireLockIfAvailable3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);

    // Act and Assert
    assertSame(order, (new DatabaseOrderLockManager()).acquireLockIfAvailable(order));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DatabaseOrderLockManager}
   *   <li>{@link DatabaseOrderLockManager#isActive()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue((new DatabaseOrderLockManager()).isActive());
  }
}

/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.order;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DatabaseOrderLockManagerDiffblueTest {
  /**
   * Test {@link DatabaseOrderLockManager#acquireLock(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseOrderLockManager#acquireLock(Order)}
   */
  @Test
  @DisplayName("Test acquireLock(Order); when NullOrderImpl (default constructor); then return NullOrderImpl (default constructor)")
  void testAcquireLock_whenNullOrderImpl_thenReturnNullOrderImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DatabaseOrderLockManager databaseOrderLockManager = new DatabaseOrderLockManager();
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertSame(order, databaseOrderLockManager.acquireLock(order));
  }

  /**
   * Test {@link DatabaseOrderLockManager#acquireLock(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl}.</li>
   *   <li>Then return {@link NullOrderImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseOrderLockManager#acquireLock(Order)}
   */
  @Test
  @DisplayName("Test acquireLock(Order); when NullOrderImpl; then return NullOrderImpl")
  void testAcquireLock_whenNullOrderImpl_thenReturnNullOrderImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);

    // Act and Assert
    assertSame(order, (new DatabaseOrderLockManager()).acquireLock(order));
  }

  /**
   * Test {@link DatabaseOrderLockManager#acquireLock(Order)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseOrderLockManager#acquireLock(Order)}
   */
  @Test
  @DisplayName("Test acquireLock(Order); when 'null'; then return 'null'")
  void testAcquireLock_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new DatabaseOrderLockManager()).acquireLock(null));
  }

  /**
   * Test {@link DatabaseOrderLockManager#acquireLockIfAvailable(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DatabaseOrderLockManager#acquireLockIfAvailable(Order)}
   */
  @Test
  @DisplayName("Test acquireLockIfAvailable(Order); when NullOrderImpl (default constructor); then return NullOrderImpl (default constructor)")
  void testAcquireLockIfAvailable_whenNullOrderImpl_thenReturnNullOrderImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DatabaseOrderLockManager databaseOrderLockManager = new DatabaseOrderLockManager();
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertSame(order, databaseOrderLockManager.acquireLockIfAvailable(order));
  }

  /**
   * Test {@link DatabaseOrderLockManager#acquireLockIfAvailable(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl}.</li>
   *   <li>Then return {@link NullOrderImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DatabaseOrderLockManager#acquireLockIfAvailable(Order)}
   */
  @Test
  @DisplayName("Test acquireLockIfAvailable(Order); when NullOrderImpl; then return NullOrderImpl")
  void testAcquireLockIfAvailable_whenNullOrderImpl_thenReturnNullOrderImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);

    // Act and Assert
    assertSame(order, (new DatabaseOrderLockManager()).acquireLockIfAvailable(order));
  }

  /**
   * Test {@link DatabaseOrderLockManager#acquireLockIfAvailable(Order)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DatabaseOrderLockManager#acquireLockIfAvailable(Order)}
   */
  @Test
  @DisplayName("Test acquireLockIfAvailable(Order); when 'null'; then return 'null'")
  void testAcquireLockIfAvailable_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new DatabaseOrderLockManager()).acquireLockIfAvailable(null));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DatabaseOrderLockManager}
   *   <li>{@link DatabaseOrderLockManager#isActive()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue((new DatabaseOrderLockManager()).isActive());
  }
}

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
package org.broadleafcommerce.common.classloader.release;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ThreadLocalManagerDiffblueTest {
  /**
   * Test {@link ThreadLocalManager#addThreadLocal(ThreadLocal)}.
   * <p>
   * Method under test: {@link ThreadLocalManager#addThreadLocal(ThreadLocal)}
   */
  @Test
  public void testAddThreadLocal() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    ThreadLocalManager.addThreadLocal(new ThreadLocal());
  }

  /**
   * Test {@link ThreadLocalManager#createThreadLocal(Class)} with {@code type}.
   * <p>
   * Method under test: {@link ThreadLocalManager#createThreadLocal(Class)}
   */
  @Test
  public void testCreateThreadLocalWithType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    Class<Object> type = Object.class;

    // Act
    ThreadLocalManager.createThreadLocal(type);
  }

  /**
   * Test {@link ThreadLocalManager#createThreadLocal(Class, boolean)} with
   * {@code type}, {@code createInitialValue}.
   * <p>
   * Method under test:
   * {@link ThreadLocalManager#createThreadLocal(Class, boolean)}
   */
  @Test
  public void testCreateThreadLocalWithTypeCreateInitialValue() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    Class<Object> type = Object.class;

    // Act
    ThreadLocalManager.createThreadLocal(type, true);
  }

  /**
   * Test {@link ThreadLocalManager#remove()}.
   * <p>
   * Method under test: {@link ThreadLocalManager#remove()}
   */
  @Test
  public void testRemove() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    ThreadLocalManager.remove();
  }

  /**
   * Test {@link ThreadLocalManager#remove(ThreadLocal)} with {@code ThreadLocal}.
   * <p>
   * Method under test: {@link ThreadLocalManager#remove(ThreadLocal)}
   */
  @Test
  public void testRemoveWithThreadLocal() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    ThreadLocalManager.remove(new ThreadLocal());
  }

  /**
   * Test {@link ThreadLocalManager#toString()}.
   * <p>
   * Method under test: {@link ThreadLocalManager#toString()}
   */
  @Test
  public void testToString() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new ThreadLocalManager()).toString();
  }

  /**
   * Test new {@link ThreadLocalManager} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link ThreadLocalManager}
   */
  @Test
  public void testNewThreadLocalManager() {
    // Arrange, Act and Assert
    assertTrue((new ThreadLocalManager()).threadLocals.isEmpty());
  }
}

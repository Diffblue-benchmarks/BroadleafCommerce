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
package org.broadleafcommerce.common.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class PersistenceServiceImplDiffblueTest {
  /**
   * Test {@link PersistenceServiceImpl#stop(Runnable)} with {@code Runnable}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with
   * {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistenceServiceImpl#stop(Runnable)}
   */
  @Test
  public void testStopWithRunnable_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceServiceImpl persistenceServiceImpl = new PersistenceServiceImpl();
    Runnable callback = mock(Runnable.class);
    doThrow(new RuntimeException("foo")).when(callback).run();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> persistenceServiceImpl.stop(callback));
    verify(callback).run();
  }

  /**
   * Test {@link PersistenceServiceImpl#stop(Runnable)} with {@code Runnable}.
   * <ul>
   *   <li>When {@link Runnable} {@link Runnable#run()} does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistenceServiceImpl#stop(Runnable)}
   */
  @Test
  public void testStopWithRunnable_whenRunnableRunDoesNothing() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceServiceImpl persistenceServiceImpl = new PersistenceServiceImpl();
    Runnable callback = mock(Runnable.class);
    doNothing().when(callback).run();

    // Act
    persistenceServiceImpl.stop(callback);

    // Assert that nothing has changed
    verify(callback).run();
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PersistenceServiceImpl#stop()}
   *   <li>{@link PersistenceServiceImpl#getPhase()}
   *   <li>{@link PersistenceServiceImpl#isAutoStartup()}
   *   <li>{@link PersistenceServiceImpl#isRunning()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    PersistenceServiceImpl persistenceServiceImpl = new PersistenceServiceImpl();

    // Act
    persistenceServiceImpl.stop();
    int actualPhase = persistenceServiceImpl.getPhase();
    boolean actualIsAutoStartupResult = persistenceServiceImpl.isAutoStartup();

    // Assert that nothing has changed
    assertEquals(0, actualPhase);
    assertFalse(persistenceServiceImpl.isRunning());
    assertTrue(actualIsAutoStartupResult);
  }

  /**
   * Test {@link PersistenceServiceImpl#getEntityManager(Map)}.
   * <p>
   * Method under test: {@link PersistenceServiceImpl#getEntityManager(Map)}
   */
  @Test
  public void testGetEntityManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceServiceImpl persistenceServiceImpl = new PersistenceServiceImpl();

    // Act and Assert
    assertNull(persistenceServiceImpl.getEntityManager(new HashMap<>()));
  }

  /**
   * Test {@link PersistenceServiceImpl#getTransactionManager(Map)}.
   * <p>
   * Method under test: {@link PersistenceServiceImpl#getTransactionManager(Map)}
   */
  @Test
  public void testGetTransactionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceServiceImpl persistenceServiceImpl = new PersistenceServiceImpl();

    // Act and Assert
    assertNull(persistenceServiceImpl.getTransactionManager(new HashMap<>()));
  }

  /**
   * Test
   * {@link PersistenceServiceImpl#getCeilingImplClassFromEntityManagers(String)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceServiceImpl#getCeilingImplClassFromEntityManagers(String)}
   */
  @Test
  public void testGetCeilingImplClassFromEntityManagers_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new PersistenceServiceImpl()).getCeilingImplClassFromEntityManagers("Class Name"));
  }

  /**
   * Test {@link PersistenceServiceImpl#getClassForName(String)}.
   * <ul>
   *   <li>When {@code Class Name}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistenceServiceImpl#getClassForName(String)}
   */
  @Test
  public void testGetClassForName_whenClassName_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new PersistenceServiceImpl()).getClassForName("Class Name"));
  }

  /**
   * Test {@link PersistenceServiceImpl#getClassForName(String)}.
   * <ul>
   *   <li>When {@code java.util.Map}.</li>
   *   <li>Then return {@link Map}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistenceServiceImpl#getClassForName(String)}
   */
  @Test
  public void testGetClassForName_whenJavaUtilMap_thenReturnMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Class<?> actualClassForName = (new PersistenceServiceImpl()).getClassForName("java.util.Map");

    // Assert
    Class<Map> expectedClassForName = Map.class;
    assertEquals(expectedClassForName, actualClassForName);
  }
}

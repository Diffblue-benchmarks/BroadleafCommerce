/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.service.persistence;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class PersistenceManagerContextDiffblueTest {
  /**
   * Test {@link PersistenceManagerContext#getPersistenceManagerContext()}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerContext#getPersistenceManagerContext()}
   */
  @Test
  public void testGetPersistenceManagerContext() {
    // Arrange, Act and Assert
    assertNull(PersistenceManagerContext.getPersistenceManagerContext());
  }

  /**
   * Test
   * {@link PersistenceManagerContext#addPersistenceManager(PersistenceManager)}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerContext#addPersistenceManager(PersistenceManager)}
   */
  @Test
  public void testAddPersistenceManager() throws BeansException {
    // Arrange
    PersistenceManagerContext persistenceManagerContext = new PersistenceManagerContext();

    AnnotationConfigReactiveWebApplicationContext applicationContext = new AnnotationConfigReactiveWebApplicationContext();
    applicationContext.addApplicationListener(mock(ApplicationListener.class));

    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    persistenceManager.setApplicationContext(applicationContext);

    // Act
    persistenceManagerContext.addPersistenceManager(persistenceManager);

    // Assert
    assertSame(persistenceManager, persistenceManagerContext.getPersistenceManager());
  }

  /**
   * Test
   * {@link PersistenceManagerContext#addPersistenceManager(PersistenceManager)}.
   * <ul>
   *   <li>When {@link PersistenceManagerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerContext#addPersistenceManager(PersistenceManager)}
   */
  @Test
  public void testAddPersistenceManager_whenPersistenceManagerImpl() {
    // Arrange
    PersistenceManagerContext persistenceManagerContext = new PersistenceManagerContext();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();

    // Act
    persistenceManagerContext.addPersistenceManager(persistenceManager);

    // Assert
    assertSame(persistenceManager, persistenceManagerContext.getPersistenceManager());
  }

  /**
   * Test {@link PersistenceManagerContext#getPersistenceManager()}.
   * <ul>
   *   <li>Given {@link PersistenceManagerContext} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistenceManagerContext#getPersistenceManager()}
   */
  @Test
  public void testGetPersistenceManager_givenPersistenceManagerContext_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PersistenceManagerContext()).getPersistenceManager());
  }

  /**
   * Test {@link PersistenceManagerContext#getPersistenceManager()}.
   * <ul>
   *   <li>Then return {@link PersistenceManagerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistenceManagerContext#getPersistenceManager()}
   */
  @Test
  public void testGetPersistenceManager_thenReturnPersistenceManagerImpl() {
    // Arrange
    PersistenceManagerContext persistenceManagerContext = new PersistenceManagerContext();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    persistenceManagerContext.addPersistenceManager(persistenceManager);

    // Act and Assert
    assertSame(persistenceManager, persistenceManagerContext.getPersistenceManager());
  }

  /**
   * Test {@link PersistenceManagerContext#remove()}.
   * <p>
   * Method under test: {@link PersistenceManagerContext#remove()}
   */
  @Test
  public void testRemove() throws BeansException {
    // Arrange
    AnnotationConfigReactiveWebApplicationContext applicationContext = new AnnotationConfigReactiveWebApplicationContext();
    applicationContext.addApplicationListener(mock(ApplicationListener.class));

    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    persistenceManager.setApplicationContext(applicationContext);

    PersistenceManagerContext persistenceManagerContext = new PersistenceManagerContext();
    persistenceManagerContext.addPersistenceManager(persistenceManager);

    // Act
    persistenceManagerContext.remove();

    // Assert
    assertNull(persistenceManagerContext.getPersistenceManager());
  }

  /**
   * Test {@link PersistenceManagerContext#remove()}.
   * <ul>
   *   <li>Given {@link PersistenceManagerContext} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistenceManagerContext#remove()}
   */
  @Test
  public void testRemove_givenPersistenceManagerContext() {
    // Arrange
    PersistenceManagerContext persistenceManagerContext = new PersistenceManagerContext();

    // Act
    persistenceManagerContext.remove();

    // Assert
    assertNull(persistenceManagerContext.getPersistenceManager());
  }

  /**
   * Test {@link PersistenceManagerContext#remove()}.
   * <ul>
   *   <li>Then {@link PersistenceManagerContext} (default constructor)
   * PersistenceManager is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistenceManagerContext#remove()}
   */
  @Test
  public void testRemove_thenPersistenceManagerContextPersistenceManagerIsNull() {
    // Arrange
    PersistenceManagerContext persistenceManagerContext = new PersistenceManagerContext();
    persistenceManagerContext.addPersistenceManager(new PersistenceManagerImpl());

    // Act
    persistenceManagerContext.remove();

    // Assert
    assertNull(persistenceManagerContext.getPersistenceManager());
  }

  /**
   * Test {@link PersistenceManagerContext#remove()}.
   * <ul>
   *   <li>Then {@link PersistenceManagerContext} (default constructor)
   * PersistenceManager {@link PersistenceManagerImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistenceManagerContext#remove()}
   */
  @Test
  public void testRemove_thenPersistenceManagerContextPersistenceManagerPersistenceManagerImpl() {
    // Arrange
    PersistenceManagerContext persistenceManagerContext = new PersistenceManagerContext();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    persistenceManagerContext.addPersistenceManager(persistenceManager);
    persistenceManagerContext.addPersistenceManager(new PersistenceManagerImpl());

    // Act
    persistenceManagerContext.remove();

    // Assert
    PersistenceManager persistenceManager2 = persistenceManagerContext.getPersistenceManager();
    assertTrue(persistenceManager2 instanceof PersistenceManagerImpl);
    assertSame(persistenceManager, persistenceManager2);
  }

  /**
   * Test new {@link PersistenceManagerContext} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link PersistenceManagerContext}
   */
  @Test
  public void testNewPersistenceManagerContext() {
    // Arrange, Act and Assert
    assertNull((new PersistenceManagerContext()).getPersistenceManager());
  }
}

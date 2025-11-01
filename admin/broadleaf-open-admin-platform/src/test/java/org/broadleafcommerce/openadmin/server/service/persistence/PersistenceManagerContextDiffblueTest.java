/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
   * Method under test:
   * {@link PersistenceManagerContext#getPersistenceManagerContext()}
   */
  @Test
  public void testGetPersistenceManagerContext() {
    // Arrange, Act and Assert
    assertNull(PersistenceManagerContext.getPersistenceManagerContext());
  }

  /**
   * Method under test:
   * {@link PersistenceManagerContext#addPersistenceManager(PersistenceManager)}
   */
  @Test
  public void testAddPersistenceManager() {
    // Arrange
    PersistenceManagerContext persistenceManagerContext = new PersistenceManagerContext();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();

    // Act
    persistenceManagerContext.addPersistenceManager(persistenceManager);

    // Assert
    assertSame(persistenceManager, persistenceManagerContext.getPersistenceManager());
  }

  /**
   * Method under test:
   * {@link PersistenceManagerContext#addPersistenceManager(PersistenceManager)}
   */
  @Test
  public void testAddPersistenceManager2() throws BeansException {
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
   * Method under test: {@link PersistenceManagerContext#getPersistenceManager()}
   */
  @Test
  public void testGetPersistenceManager() {
    // Arrange, Act and Assert
    assertNull((new PersistenceManagerContext()).getPersistenceManager());
  }

  /**
   * Method under test: {@link PersistenceManagerContext#getPersistenceManager()}
   */
  @Test
  public void testGetPersistenceManager2() {
    // Arrange
    PersistenceManagerContext persistenceManagerContext = new PersistenceManagerContext();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    persistenceManagerContext.addPersistenceManager(persistenceManager);

    // Act and Assert
    assertSame(persistenceManager, persistenceManagerContext.getPersistenceManager());
  }

  /**
   * Method under test: {@link PersistenceManagerContext#getPersistenceManager()}
   */
  @Test
  public void testGetPersistenceManager3() throws BeansException {
    // Arrange
    AnnotationConfigReactiveWebApplicationContext applicationContext = new AnnotationConfigReactiveWebApplicationContext();
    applicationContext.addApplicationListener(mock(ApplicationListener.class));

    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    persistenceManager.setApplicationContext(applicationContext);

    PersistenceManagerContext persistenceManagerContext = new PersistenceManagerContext();
    persistenceManagerContext.addPersistenceManager(persistenceManager);

    // Act and Assert
    assertSame(persistenceManager, persistenceManagerContext.getPersistenceManager());
  }

  /**
   * Method under test: {@link PersistenceManagerContext#remove()}
   */
  @Test
  public void testRemove() {
    // Arrange
    PersistenceManagerContext persistenceManagerContext = new PersistenceManagerContext();

    // Act
    persistenceManagerContext.remove();

    // Assert
    assertNull(persistenceManagerContext.getPersistenceManager());
  }

  /**
   * Method under test: {@link PersistenceManagerContext#remove()}
   */
  @Test
  public void testRemove2() {
    // Arrange
    PersistenceManagerContext persistenceManagerContext = new PersistenceManagerContext();
    persistenceManagerContext.addPersistenceManager(new PersistenceManagerImpl());

    // Act
    persistenceManagerContext.remove();

    // Assert
    assertNull(persistenceManagerContext.getPersistenceManager());
  }

  /**
   * Method under test: {@link PersistenceManagerContext#remove()}
   */
  @Test
  public void testRemove3() {
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
   * Method under test: {@link PersistenceManagerContext#remove()}
   */
  @Test
  public void testRemove4() throws BeansException {
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
   * Method under test: default or parameterless constructor of
   * {@link PersistenceManagerContext}
   */
  @Test
  public void testNewPersistenceManagerContext() {
    // Arrange, Act and Assert
    assertNull((new PersistenceManagerContext()).getPersistenceManager());
  }
}

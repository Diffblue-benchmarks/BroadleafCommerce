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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class PersistenceManagerEventHandlerAdapterDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link PersistenceManagerEventHandlerAdapter}
   *   <li>{@link PersistenceManagerEventHandlerAdapter#getOrder()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(Integer.MAX_VALUE, (new PersistenceManagerEventHandlerAdapter()).getOrder());
  }

  /**
   * Method under test:
   * {@link PersistenceManagerEventHandlerAdapter#postAdd(PersistenceManager, Entity, PersistencePackage)}
   */
  @Test
  public void testPostAdd() throws ServiceException {
    // Arrange
    PersistenceManagerEventHandlerAdapter persistenceManagerEventHandlerAdapter = new PersistenceManagerEventHandlerAdapter();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    Entity entity = new Entity();

    // Act
    PersistenceManagerEventHandlerResponse actualPostAddResult = persistenceManagerEventHandlerAdapter
        .postAdd(persistenceManager, entity, new PersistencePackage());

    // Assert
    assertNull(actualPostAddResult.getDynamicResultSet());
    assertEquals(PersistenceManagerEventHandlerResponse.PersistenceManagerEventHandlerResponseStatus.NOT_HANDLED,
        actualPostAddResult.getStatus());
    assertTrue(actualPostAddResult.getAdditionalData().isEmpty());
    assertSame(entity, actualPostAddResult.getEntity());
  }

  /**
   * Method under test:
   * {@link PersistenceManagerEventHandlerAdapter#preFetch(PersistenceManager, PersistencePackage, CriteriaTransferObject)}
   */
  @Test
  public void testPreFetch() throws ServiceException {
    // Arrange
    PersistenceManagerEventHandlerAdapter persistenceManagerEventHandlerAdapter = new PersistenceManagerEventHandlerAdapter();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    PersistencePackage persistencePackage = new PersistencePackage();

    // Act
    PersistenceManagerEventHandlerResponse actualPreFetchResult = persistenceManagerEventHandlerAdapter
        .preFetch(persistenceManager, persistencePackage, new CriteriaTransferObject());

    // Assert
    assertNull(actualPreFetchResult.getDynamicResultSet());
    assertNull(actualPreFetchResult.getEntity());
    assertEquals(PersistenceManagerEventHandlerResponse.PersistenceManagerEventHandlerResponseStatus.NOT_HANDLED,
        actualPreFetchResult.getStatus());
    assertTrue(actualPreFetchResult.getAdditionalData().isEmpty());
  }

  /**
   * Method under test:
   * {@link PersistenceManagerEventHandlerAdapter#preFetch(PersistenceManager, PersistencePackage, CriteriaTransferObject)}
   */
  @Test
  public void testPreFetch2() throws ServiceException {
    // Arrange
    ArchiveStatusPersistenceEventHandler archiveStatusPersistenceEventHandler = new ArchiveStatusPersistenceEventHandler();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    Entity entity = new Entity();
    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria"}, "ABC123");

    // Act
    PersistenceManagerEventHandlerResponse actualPreFetchResult = archiveStatusPersistenceEventHandler
        .preFetch(persistenceManager, persistencePackage, new CriteriaTransferObject());

    // Assert
    assertNull(actualPreFetchResult.getDynamicResultSet());
    assertNull(actualPreFetchResult.getEntity());
    assertEquals(PersistenceManagerEventHandlerResponse.PersistenceManagerEventHandlerResponseStatus.NOT_HANDLED,
        actualPreFetchResult.getStatus());
    assertTrue(actualPreFetchResult.getAdditionalData().isEmpty());
  }

  /**
   * Method under test:
   * {@link PersistenceManagerEventHandlerAdapter#postFetch(PersistenceManager, DynamicResultSet, PersistencePackage, CriteriaTransferObject)}
   */
  @Test
  public void testPostFetch() throws ServiceException {
    // Arrange
    PersistenceManagerEventHandlerAdapter persistenceManagerEventHandlerAdapter = new PersistenceManagerEventHandlerAdapter();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    DynamicResultSet resultSet = new DynamicResultSet();
    PersistencePackage persistencePackage = new PersistencePackage();

    // Act
    PersistenceManagerEventHandlerResponse actualPostFetchResult = persistenceManagerEventHandlerAdapter
        .postFetch(persistenceManager, resultSet, persistencePackage, new CriteriaTransferObject());

    // Assert
    assertNull(actualPostFetchResult.getEntity());
    assertEquals(PersistenceManagerEventHandlerResponse.PersistenceManagerEventHandlerResponseStatus.NOT_HANDLED,
        actualPostFetchResult.getStatus());
    assertTrue(actualPostFetchResult.getAdditionalData().isEmpty());
    assertSame(resultSet, actualPostFetchResult.getDynamicResultSet());
  }

  /**
   * Method under test:
   * {@link PersistenceManagerEventHandlerAdapter#preAdd(PersistenceManager, PersistencePackage)}
   */
  @Test
  public void testPreAdd() throws ServiceException {
    // Arrange
    PersistenceManagerEventHandlerAdapter persistenceManagerEventHandlerAdapter = new PersistenceManagerEventHandlerAdapter();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();

    // Act
    PersistenceManagerEventHandlerResponse actualPreAddResult = persistenceManagerEventHandlerAdapter
        .preAdd(persistenceManager, new PersistencePackage());

    // Assert
    assertNull(actualPreAddResult.getDynamicResultSet());
    assertNull(actualPreAddResult.getEntity());
    assertEquals(PersistenceManagerEventHandlerResponse.PersistenceManagerEventHandlerResponseStatus.NOT_HANDLED,
        actualPreAddResult.getStatus());
    assertTrue(actualPreAddResult.getAdditionalData().isEmpty());
  }

  /**
   * Method under test:
   * {@link PersistenceManagerEventHandlerAdapter#preAdd(PersistenceManager, PersistencePackage)}
   */
  @Test
  public void testPreAdd2() throws ServiceException, BeansException {
    // Arrange
    PersistenceManagerEventHandlerAdapter persistenceManagerEventHandlerAdapter = new PersistenceManagerEventHandlerAdapter();

    AnnotationConfigReactiveWebApplicationContext applicationContext = new AnnotationConfigReactiveWebApplicationContext();
    applicationContext.addApplicationListener(mock(ApplicationListener.class));

    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    persistenceManager.setApplicationContext(applicationContext);

    // Act
    PersistenceManagerEventHandlerResponse actualPreAddResult = persistenceManagerEventHandlerAdapter
        .preAdd(persistenceManager, new PersistencePackage());

    // Assert
    assertNull(actualPreAddResult.getDynamicResultSet());
    assertNull(actualPreAddResult.getEntity());
    assertEquals(PersistenceManagerEventHandlerResponse.PersistenceManagerEventHandlerResponseStatus.NOT_HANDLED,
        actualPreAddResult.getStatus());
    assertTrue(actualPreAddResult.getAdditionalData().isEmpty());
  }

  /**
   * Method under test:
   * {@link PersistenceManagerEventHandlerAdapter#preUpdate(PersistenceManager, PersistencePackage)}
   */
  @Test
  public void testPreUpdate() throws ServiceException {
    // Arrange
    PersistenceManagerEventHandlerAdapter persistenceManagerEventHandlerAdapter = new PersistenceManagerEventHandlerAdapter();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();

    // Act
    PersistenceManagerEventHandlerResponse actualPreUpdateResult = persistenceManagerEventHandlerAdapter
        .preUpdate(persistenceManager, new PersistencePackage());

    // Assert
    assertNull(actualPreUpdateResult.getDynamicResultSet());
    assertNull(actualPreUpdateResult.getEntity());
    assertEquals(PersistenceManagerEventHandlerResponse.PersistenceManagerEventHandlerResponseStatus.NOT_HANDLED,
        actualPreUpdateResult.getStatus());
    assertTrue(actualPreUpdateResult.getAdditionalData().isEmpty());
  }

  /**
   * Method under test:
   * {@link PersistenceManagerEventHandlerAdapter#preUpdate(PersistenceManager, PersistencePackage)}
   */
  @Test
  public void testPreUpdate2() throws ServiceException, BeansException {
    // Arrange
    PersistenceManagerEventHandlerAdapter persistenceManagerEventHandlerAdapter = new PersistenceManagerEventHandlerAdapter();

    AnnotationConfigReactiveWebApplicationContext applicationContext = new AnnotationConfigReactiveWebApplicationContext();
    applicationContext.addApplicationListener(mock(ApplicationListener.class));

    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    persistenceManager.setApplicationContext(applicationContext);

    // Act
    PersistenceManagerEventHandlerResponse actualPreUpdateResult = persistenceManagerEventHandlerAdapter
        .preUpdate(persistenceManager, new PersistencePackage());

    // Assert
    assertNull(actualPreUpdateResult.getDynamicResultSet());
    assertNull(actualPreUpdateResult.getEntity());
    assertEquals(PersistenceManagerEventHandlerResponse.PersistenceManagerEventHandlerResponseStatus.NOT_HANDLED,
        actualPreUpdateResult.getStatus());
    assertTrue(actualPreUpdateResult.getAdditionalData().isEmpty());
  }

  /**
   * Method under test:
   * {@link PersistenceManagerEventHandlerAdapter#postUpdate(PersistenceManager, Entity, PersistencePackage)}
   */
  @Test
  public void testPostUpdate() throws ServiceException {
    // Arrange
    PersistenceManagerEventHandlerAdapter persistenceManagerEventHandlerAdapter = new PersistenceManagerEventHandlerAdapter();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    Entity entity = new Entity();

    // Act
    PersistenceManagerEventHandlerResponse actualPostUpdateResult = persistenceManagerEventHandlerAdapter
        .postUpdate(persistenceManager, entity, new PersistencePackage());

    // Assert
    assertNull(actualPostUpdateResult.getDynamicResultSet());
    assertEquals(PersistenceManagerEventHandlerResponse.PersistenceManagerEventHandlerResponseStatus.NOT_HANDLED,
        actualPostUpdateResult.getStatus());
    assertTrue(actualPostUpdateResult.getAdditionalData().isEmpty());
    assertSame(entity, actualPostUpdateResult.getEntity());
  }

  /**
   * Method under test:
   * {@link PersistenceManagerEventHandlerAdapter#preRemove(PersistenceManager, PersistencePackage)}
   */
  @Test
  public void testPreRemove() throws ServiceException {
    // Arrange
    PersistenceManagerEventHandlerAdapter persistenceManagerEventHandlerAdapter = new PersistenceManagerEventHandlerAdapter();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();

    // Act
    PersistenceManagerEventHandlerResponse actualPreRemoveResult = persistenceManagerEventHandlerAdapter
        .preRemove(persistenceManager, new PersistencePackage());

    // Assert
    assertNull(actualPreRemoveResult.getDynamicResultSet());
    assertNull(actualPreRemoveResult.getEntity());
    assertEquals(PersistenceManagerEventHandlerResponse.PersistenceManagerEventHandlerResponseStatus.NOT_HANDLED,
        actualPreRemoveResult.getStatus());
    assertTrue(actualPreRemoveResult.getAdditionalData().isEmpty());
  }

  /**
   * Method under test:
   * {@link PersistenceManagerEventHandlerAdapter#preRemove(PersistenceManager, PersistencePackage)}
   */
  @Test
  public void testPreRemove2() throws ServiceException, BeansException {
    // Arrange
    PersistenceManagerEventHandlerAdapter persistenceManagerEventHandlerAdapter = new PersistenceManagerEventHandlerAdapter();

    AnnotationConfigReactiveWebApplicationContext applicationContext = new AnnotationConfigReactiveWebApplicationContext();
    applicationContext.addApplicationListener(mock(ApplicationListener.class));

    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    persistenceManager.setApplicationContext(applicationContext);

    // Act
    PersistenceManagerEventHandlerResponse actualPreRemoveResult = persistenceManagerEventHandlerAdapter
        .preRemove(persistenceManager, new PersistencePackage());

    // Assert
    assertNull(actualPreRemoveResult.getDynamicResultSet());
    assertNull(actualPreRemoveResult.getEntity());
    assertEquals(PersistenceManagerEventHandlerResponse.PersistenceManagerEventHandlerResponseStatus.NOT_HANDLED,
        actualPreRemoveResult.getStatus());
    assertTrue(actualPreRemoveResult.getAdditionalData().isEmpty());
  }

  /**
   * Method under test:
   * {@link PersistenceManagerEventHandlerAdapter#postRemove(PersistenceManager, PersistencePackage)}
   */
  @Test
  public void testPostRemove() throws ServiceException {
    // Arrange
    PersistenceManagerEventHandlerAdapter persistenceManagerEventHandlerAdapter = new PersistenceManagerEventHandlerAdapter();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();

    // Act
    PersistenceManagerEventHandlerResponse actualPostRemoveResult = persistenceManagerEventHandlerAdapter
        .postRemove(persistenceManager, new PersistencePackage());

    // Assert
    assertNull(actualPostRemoveResult.getDynamicResultSet());
    assertNull(actualPostRemoveResult.getEntity());
    assertEquals(PersistenceManagerEventHandlerResponse.PersistenceManagerEventHandlerResponseStatus.NOT_HANDLED,
        actualPostRemoveResult.getStatus());
    assertTrue(actualPostRemoveResult.getAdditionalData().isEmpty());
  }

  /**
   * Method under test:
   * {@link PersistenceManagerEventHandlerAdapter#postRemove(PersistenceManager, PersistencePackage)}
   */
  @Test
  public void testPostRemove2() throws ServiceException, BeansException {
    // Arrange
    PersistenceManagerEventHandlerAdapter persistenceManagerEventHandlerAdapter = new PersistenceManagerEventHandlerAdapter();

    AnnotationConfigReactiveWebApplicationContext applicationContext = new AnnotationConfigReactiveWebApplicationContext();
    applicationContext.addApplicationListener(mock(ApplicationListener.class));

    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    persistenceManager.setApplicationContext(applicationContext);

    // Act
    PersistenceManagerEventHandlerResponse actualPostRemoveResult = persistenceManagerEventHandlerAdapter
        .postRemove(persistenceManager, new PersistencePackage());

    // Assert
    assertNull(actualPostRemoveResult.getDynamicResultSet());
    assertNull(actualPostRemoveResult.getEntity());
    assertEquals(PersistenceManagerEventHandlerResponse.PersistenceManagerEventHandlerResponseStatus.NOT_HANDLED,
        actualPostRemoveResult.getStatus());
    assertTrue(actualPostRemoveResult.getAdditionalData().isEmpty());
  }

  /**
   * Method under test:
   * {@link PersistenceManagerEventHandlerAdapter#postInspect(PersistenceManager, DynamicResultSet, PersistencePackage)}
   */
  @Test
  public void testPostInspect() throws ServiceException {
    // Arrange
    PersistenceManagerEventHandlerAdapter persistenceManagerEventHandlerAdapter = new PersistenceManagerEventHandlerAdapter();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    DynamicResultSet resultSet = new DynamicResultSet();

    // Act
    PersistenceManagerEventHandlerResponse actualPostInspectResult = persistenceManagerEventHandlerAdapter
        .postInspect(persistenceManager, resultSet, new PersistencePackage());

    // Assert
    assertNull(actualPostInspectResult.getEntity());
    assertEquals(PersistenceManagerEventHandlerResponse.PersistenceManagerEventHandlerResponseStatus.NOT_HANDLED,
        actualPostInspectResult.getStatus());
    assertTrue(actualPostInspectResult.getAdditionalData().isEmpty());
    assertSame(resultSet, actualPostInspectResult.getDynamicResultSet());
  }

  /**
   * Method under test:
   * {@link PersistenceManagerEventHandlerAdapter#postInspect(PersistenceManager, DynamicResultSet, PersistencePackage)}
   */
  @Test
  public void testPostInspect2() throws ServiceException, BeansException {
    // Arrange
    PersistenceManagerEventHandlerAdapter persistenceManagerEventHandlerAdapter = new PersistenceManagerEventHandlerAdapter();

    AnnotationConfigReactiveWebApplicationContext applicationContext = new AnnotationConfigReactiveWebApplicationContext();
    applicationContext.addApplicationListener(mock(ApplicationListener.class));

    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    persistenceManager.setApplicationContext(applicationContext);
    DynamicResultSet resultSet = new DynamicResultSet();

    // Act
    PersistenceManagerEventHandlerResponse actualPostInspectResult = persistenceManagerEventHandlerAdapter
        .postInspect(persistenceManager, resultSet, new PersistencePackage());

    // Assert
    assertNull(actualPostInspectResult.getEntity());
    assertEquals(PersistenceManagerEventHandlerResponse.PersistenceManagerEventHandlerResponseStatus.NOT_HANDLED,
        actualPostInspectResult.getStatus());
    assertTrue(actualPostInspectResult.getAdditionalData().isEmpty());
    assertSame(resultSet, actualPostInspectResult.getDynamicResultSet());
  }

  /**
   * Method under test:
   * {@link PersistenceManagerEventHandlerAdapter#preInspect(PersistenceManager, PersistencePackage)}
   */
  @Test
  public void testPreInspect() throws ServiceException {
    // Arrange
    PersistenceManagerEventHandlerAdapter persistenceManagerEventHandlerAdapter = new PersistenceManagerEventHandlerAdapter();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();

    // Act
    PersistenceManagerEventHandlerResponse actualPreInspectResult = persistenceManagerEventHandlerAdapter
        .preInspect(persistenceManager, new PersistencePackage());

    // Assert
    assertNull(actualPreInspectResult.getDynamicResultSet());
    assertNull(actualPreInspectResult.getEntity());
    assertEquals(PersistenceManagerEventHandlerResponse.PersistenceManagerEventHandlerResponseStatus.NOT_HANDLED,
        actualPreInspectResult.getStatus());
    assertTrue(actualPreInspectResult.getAdditionalData().isEmpty());
  }

  /**
   * Method under test:
   * {@link PersistenceManagerEventHandlerAdapter#preInspect(PersistenceManager, PersistencePackage)}
   */
  @Test
  public void testPreInspect2() throws ServiceException, BeansException {
    // Arrange
    PersistenceManagerEventHandlerAdapter persistenceManagerEventHandlerAdapter = new PersistenceManagerEventHandlerAdapter();

    AnnotationConfigReactiveWebApplicationContext applicationContext = new AnnotationConfigReactiveWebApplicationContext();
    applicationContext.addApplicationListener(mock(ApplicationListener.class));

    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    persistenceManager.setApplicationContext(applicationContext);

    // Act
    PersistenceManagerEventHandlerResponse actualPreInspectResult = persistenceManagerEventHandlerAdapter
        .preInspect(persistenceManager, new PersistencePackage());

    // Assert
    assertNull(actualPreInspectResult.getDynamicResultSet());
    assertNull(actualPreInspectResult.getEntity());
    assertEquals(PersistenceManagerEventHandlerResponse.PersistenceManagerEventHandlerResponseStatus.NOT_HANDLED,
        actualPreInspectResult.getStatus());
    assertTrue(actualPreInspectResult.getAdditionalData().isEmpty());
  }

  /**
   * Method under test:
   * {@link PersistenceManagerEventHandlerAdapter#processValidationError(PersistenceManager, Entity, PersistencePackage)}
   */
  @Test
  public void testProcessValidationError() throws ServiceException {
    // Arrange
    PersistenceManagerEventHandlerAdapter persistenceManagerEventHandlerAdapter = new PersistenceManagerEventHandlerAdapter();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    Entity entity = new Entity();

    // Act
    PersistenceManagerEventHandlerResponse actualProcessValidationErrorResult = persistenceManagerEventHandlerAdapter
        .processValidationError(persistenceManager, entity, new PersistencePackage());

    // Assert
    assertNull(actualProcessValidationErrorResult.getDynamicResultSet());
    assertNull(actualProcessValidationErrorResult.getEntity());
    assertEquals(PersistenceManagerEventHandlerResponse.PersistenceManagerEventHandlerResponseStatus.NOT_HANDLED,
        actualProcessValidationErrorResult.getStatus());
    assertTrue(actualProcessValidationErrorResult.getAdditionalData().isEmpty());
  }
}

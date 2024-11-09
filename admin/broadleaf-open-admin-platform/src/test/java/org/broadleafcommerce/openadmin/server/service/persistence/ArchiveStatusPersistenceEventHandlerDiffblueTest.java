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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.junit.Test;

public class ArchiveStatusPersistenceEventHandlerDiffblueTest {
  /**
   * Test
   * {@link ArchiveStatusPersistenceEventHandler#preFetch(PersistenceManager, PersistencePackage, CriteriaTransferObject)}.
   * <ul>
   *   <li>Then return Status is {@code HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ArchiveStatusPersistenceEventHandler#preFetch(PersistenceManager, PersistencePackage, CriteriaTransferObject)}
   */
  @Test
  public void testPreFetch_thenReturnStatusIsHandled() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArchiveStatusPersistenceEventHandler archiveStatusPersistenceEventHandler = new ArchiveStatusPersistenceEventHandler();
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(new DynamicEntityDaoImpl());
    Entity entity = new Entity();
    PersistencePackage persistencePackage = new PersistencePackage("java.util.List", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123");

    // Act
    PersistenceManagerEventHandlerResponse actualPreFetchResult = archiveStatusPersistenceEventHandler
        .preFetch(persistenceManager, persistencePackage, new CriteriaTransferObject());

    // Assert
    verify(persistenceManager).getDynamicEntityDao();
    assertNull(actualPreFetchResult.getDynamicResultSet());
    assertNull(actualPreFetchResult.getEntity());
    assertEquals(PersistenceManagerEventHandlerResponse.PersistenceManagerEventHandlerResponseStatus.HANDLED,
        actualPreFetchResult.getStatus());
    assertTrue(actualPreFetchResult.getAdditionalData().isEmpty());
  }

  /**
   * Test
   * {@link ArchiveStatusPersistenceEventHandler#preFetch(PersistenceManager, PersistencePackage, CriteriaTransferObject)}.
   * <ul>
   *   <li>Then return Status is {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ArchiveStatusPersistenceEventHandler#preFetch(PersistenceManager, PersistencePackage, CriteriaTransferObject)}
   */
  @Test
  public void testPreFetch_thenReturnStatusIsNotHandled() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArchiveStatusPersistenceEventHandler archiveStatusPersistenceEventHandler = new ArchiveStatusPersistenceEventHandler();
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(new DynamicEntityDaoImpl());
    Entity entity = new Entity();
    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria"}, "ABC123");

    // Act
    PersistenceManagerEventHandlerResponse actualPreFetchResult = archiveStatusPersistenceEventHandler
        .preFetch(persistenceManager, persistencePackage, new CriteriaTransferObject());

    // Assert
    verify(persistenceManager).getDynamicEntityDao();
    assertNull(actualPreFetchResult.getDynamicResultSet());
    assertNull(actualPreFetchResult.getEntity());
    assertEquals(PersistenceManagerEventHandlerResponse.PersistenceManagerEventHandlerResponseStatus.NOT_HANDLED,
        actualPreFetchResult.getStatus());
    assertTrue(actualPreFetchResult.getAdditionalData().isEmpty());
  }

  /**
   * Test {@link ArchiveStatusPersistenceEventHandler#getOrder()}.
   * <p>
   * Method under test: {@link ArchiveStatusPersistenceEventHandler#getOrder()}
   */
  @Test
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(Integer.MIN_VALUE, (new ArchiveStatusPersistenceEventHandler()).getOrder());
  }
}

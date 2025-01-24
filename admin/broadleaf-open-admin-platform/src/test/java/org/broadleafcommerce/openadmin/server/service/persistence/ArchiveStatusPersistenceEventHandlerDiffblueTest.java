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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml",
    "/bl-open-admin-applicationContext-entity.xml", "/bl-open-admin-contentClient-applicationContext.xml",
    "/bl-open-admin-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ArchiveStatusPersistenceEventHandlerDiffblueTest {
  @Autowired
  private ArchiveStatusPersistenceEventHandler archiveStatusPersistenceEventHandler;

  /**
   * Test
   * {@link ArchiveStatusPersistenceEventHandler#preFetch(PersistenceManager, PersistencePackage, CriteriaTransferObject)}.
   * <p>
   * Method under test:
   * {@link ArchiveStatusPersistenceEventHandler#preFetch(PersistenceManager, PersistencePackage, CriteriaTransferObject)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPreFetch() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3548 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.ArchiveStatusPersistenceEventHandler archiveStatusPersistenceEventHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ArchiveStatusPersistenceEventHandler archiveStatusPersistenceEventHandler2 = new ArchiveStatusPersistenceEventHandler();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    PersistencePackage persistencePackage = new PersistencePackage();

    // Act
    archiveStatusPersistenceEventHandler2.preFetch(persistenceManager, persistencePackage,
        new CriteriaTransferObject());
  }

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

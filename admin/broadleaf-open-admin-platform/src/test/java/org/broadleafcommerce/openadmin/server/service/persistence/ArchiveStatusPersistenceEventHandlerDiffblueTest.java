package org.broadleafcommerce.openadmin.server.service.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.presentation.client.PersistencePerspectiveItemType;
import org.broadleafcommerce.openadmin.dto.AdornedTargetList;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.ForeignKey;
import org.broadleafcommerce.openadmin.dto.OperationTypes;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.PersistencePerspectiveItem;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerEventHandlerResponse.PersistenceManagerEventHandlerResponseStatus;
import org.broadleafcommerce.openadmin.server.service.persistence.extension.ArchiveStatusPersistenceEventHandlerExtensionManager;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ArchiveStatusPersistenceEventHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ArchiveStatusPersistenceEventHandlerDiffblueTest {
  @Autowired private ArchiveStatusPersistenceEventHandler archiveStatusPersistenceEventHandler;

  @MockBean(name = "blArchiveStatusPersistenceEventHandlerExtensionManager")
  private ArchiveStatusPersistenceEventHandlerExtensionManager
      archiveStatusPersistenceEventHandlerExtensionManager;

  /**
   * Test {@link ArchiveStatusPersistenceEventHandler#preFetch(PersistenceManager,
   * PersistencePackage, CriteriaTransferObject)}.
   *
   * <ul>
   *   <li>Then return DynamicResultSet is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ArchiveStatusPersistenceEventHandler#preFetch(PersistenceManager,
   * PersistencePackage, CriteriaTransferObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceManagerEventHandlerResponse ArchiveStatusPersistenceEventHandler.preFetch(PersistenceManager, PersistencePackage, CriteriaTransferObject)"
  })
  public void testPreFetch_thenReturnDynamicResultSetIsNull() throws ServiceException {
    // Arrange
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItems = new HashMap<>();
    persistencePerspectiveItems.put(
        PersistencePerspectiveItemType.ADORNEDTARGETLIST, new AdornedTargetList());
    OperationTypes operationTypes = new OperationTypes();
    String[] additionalNonPersistentProperties =
        new String[] {"Additional Non Persistent Properties"};
    ForeignKey[] additionalForeignKeys = new ForeignKey[] {new ForeignKey()};

    PersistencePerspective persistencePerspective =
        new PersistencePerspective(
            operationTypes, additionalNonPersistentProperties, additionalForeignKeys);
    persistencePerspective.setPersistencePerspectiveItems(persistencePerspectiveItems);
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", new Entity(), persistencePerspective, customCriteria, "ABC123");

    // Act
    PersistenceManagerEventHandlerResponse actualPreFetchResult =
        archiveStatusPersistenceEventHandler.preFetch(
            persistenceManager, persistencePackage, new CriteriaTransferObject());

    // Assert
    assertNull(actualPreFetchResult.getDynamicResultSet());
    assertNull(actualPreFetchResult.getEntity());
    assertEquals(
        PersistenceManagerEventHandlerResponseStatus.NOT_HANDLED, actualPreFetchResult.getStatus());
    assertTrue(actualPreFetchResult.getAdditionalData().isEmpty());
  }

  /**
   * Test {@link ArchiveStatusPersistenceEventHandler#getOrder()}.
   *
   * <p>Method under test: {@link ArchiveStatusPersistenceEventHandler#getOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ArchiveStatusPersistenceEventHandler.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(Integer.MIN_VALUE, new ArchiveStatusPersistenceEventHandler().getOrder());
  }
}

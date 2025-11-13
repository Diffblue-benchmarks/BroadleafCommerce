package org.broadleafcommerce.cms.admin.server.handler;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.cms.structure.service.StructuredContentService;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StructuredContentTypeCustomPersistenceHandlerDiffblueTest {
  @Mock private StructuredContentService structuredContentService;

  @InjectMocks
  private StructuredContentTypeCustomPersistenceHandler
      structuredContentTypeCustomPersistenceHandler;

  /**
   * Test {@link StructuredContentTypeCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StructuredContentTypeCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean StructuredContentTypeCustomPersistenceHandler.canHandleFetch(PersistencePackage)"
  })
  public void testCanHandleFetch_thenReturnFalse() {
    // Arrange
    StructuredContentTypeCustomPersistenceHandler structuredContentTypeCustomPersistenceHandler =
        new StructuredContentTypeCustomPersistenceHandler();

    // Act and Assert
    assertFalse(
        structuredContentTypeCustomPersistenceHandler.canHandleFetch(new PersistencePackage()));
  }

  /**
   * Test {@link StructuredContentTypeCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StructuredContentTypeCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean StructuredContentTypeCustomPersistenceHandler.canHandleAdd(PersistencePackage)"
  })
  public void testCanHandleAdd_thenReturnFalse() {
    // Arrange
    StructuredContentTypeCustomPersistenceHandler structuredContentTypeCustomPersistenceHandler =
        new StructuredContentTypeCustomPersistenceHandler();

    // Act and Assert
    assertFalse(
        structuredContentTypeCustomPersistenceHandler.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Test {@link
   * StructuredContentTypeCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StructuredContentTypeCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean StructuredContentTypeCustomPersistenceHandler.canHandleInspect(PersistencePackage)"
  })
  public void testCanHandleInspect_thenReturnFalse() {
    // Arrange
    StructuredContentTypeCustomPersistenceHandler structuredContentTypeCustomPersistenceHandler =
        new StructuredContentTypeCustomPersistenceHandler();

    // Act and Assert
    assertFalse(
        structuredContentTypeCustomPersistenceHandler.canHandleInspect(new PersistencePackage()));
  }

  /**
   * Test {@link StructuredContentTypeCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * StructuredContentTypeCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean StructuredContentTypeCustomPersistenceHandler.canHandleRemove(PersistencePackage)"
  })
  public void testCanHandleRemove() {
    // Arrange
    StructuredContentTypeCustomPersistenceHandler structuredContentTypeCustomPersistenceHandler =
        new StructuredContentTypeCustomPersistenceHandler();

    // Act and Assert
    assertFalse(
        structuredContentTypeCustomPersistenceHandler.canHandleRemove(new PersistencePackage()));
  }

  /**
   * Test {@link StructuredContentTypeCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StructuredContentTypeCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean StructuredContentTypeCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"
  })
  public void testCanHandleUpdate_thenReturnFalse() {
    // Arrange
    StructuredContentTypeCustomPersistenceHandler structuredContentTypeCustomPersistenceHandler =
        new StructuredContentTypeCustomPersistenceHandler();

    // Act and Assert
    assertFalse(
        structuredContentTypeCustomPersistenceHandler.canHandleUpdate(new PersistencePackage()));
  }

  /**
   * Test {@link StructuredContentTypeCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link StructuredContentTypeCustomPersistenceHandler} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * StructuredContentTypeCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.openadmin.dto.DynamicResultSet StructuredContentTypeCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"
  })
  public void testFetch_givenStructuredContentTypeCustomPersistenceHandler()
      throws ServiceException {
    // Arrange
    StructuredContentTypeCustomPersistenceHandler structuredContentTypeCustomPersistenceHandler =
        new StructuredContentTypeCustomPersistenceHandler();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Unable to perform fetch for entity: "};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.addCustomCriteria("Unable to perform fetch for entity: ");
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            structuredContentTypeCustomPersistenceHandler.fetch(
                persistencePackage,
                cto,
                dynamicEntityDao,
                new AdornedTargetListPersistenceModule()));
  }

  /**
   * Test {@link StructuredContentTypeCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Then calls {@link StructuredContentService#findStructuredContentById(Long)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StructuredContentTypeCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.openadmin.dto.DynamicResultSet StructuredContentTypeCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"
  })
  public void testFetch_thenCallsFindStructuredContentById() throws ServiceException {
    // Arrange
    when(structuredContentService.findStructuredContentById(Mockito.<Long>any()))
        .thenThrow(new RuntimeException());
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Unable to perform fetch for entity: "};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.addCustomCriteria("42");
    persistencePackage.addCustomCriteria("Unable to perform fetch for entity: ");
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            structuredContentTypeCustomPersistenceHandler.fetch(
                persistencePackage,
                cto,
                dynamicEntityDao,
                new AdornedTargetListPersistenceModule()));
    verify(structuredContentService).findStructuredContentById(42L);
  }

  /**
   * Test {@link StructuredContentTypeCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StructuredContentTypeCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity StructuredContentTypeCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_thenThrowServiceException() throws ServiceException {
    // Arrange
    StructuredContentTypeCustomPersistenceHandler structuredContentTypeCustomPersistenceHandler =
        new StructuredContentTypeCustomPersistenceHandler();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Unable to perform fetch for entity: "};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.addCustomCriteria("Unable to perform fetch for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            structuredContentTypeCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
  }

  /**
   * Test {@link StructuredContentTypeCustomPersistenceHandler#addOrUpdate(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StructuredContentTypeCustomPersistenceHandler#addOrUpdate(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity StructuredContentTypeCustomPersistenceHandler.addOrUpdate(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAddOrUpdate_thenThrowServiceException() throws ServiceException {
    // Arrange
    StructuredContentTypeCustomPersistenceHandler structuredContentTypeCustomPersistenceHandler =
        new StructuredContentTypeCustomPersistenceHandler();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Unable to perform fetch for entity: "};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.addCustomCriteria("Unable to perform fetch for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            structuredContentTypeCustomPersistenceHandler.addOrUpdate(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
  }
}

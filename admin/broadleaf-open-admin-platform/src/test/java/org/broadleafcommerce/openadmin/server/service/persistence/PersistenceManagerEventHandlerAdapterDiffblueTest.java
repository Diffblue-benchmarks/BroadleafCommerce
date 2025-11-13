package org.broadleafcommerce.openadmin.server.service.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerEventHandlerResponse.PersistenceManagerEventHandlerResponseStatus;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PersistenceManagerEventHandlerAdapterDiffblueTest {
  /**
   * Test {@link PersistenceManagerEventHandlerAdapter#postAdd(PersistenceManager, Entity,
   * PersistencePackage)}.
   *
   * <p>Method under test: {@link PersistenceManagerEventHandlerAdapter#postAdd(PersistenceManager,
   * Entity, PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceManagerEventHandlerResponse PersistenceManagerEventHandlerAdapter.postAdd(PersistenceManager, Entity, PersistencePackage)"
  })
  public void testPostAdd() throws ServiceException {
    // Arrange
    PersistenceManagerEventHandlerAdapter persistenceManagerEventHandlerAdapter =
        new PersistenceManagerEventHandlerAdapter();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    Entity entity = new Entity();

    // Act
    PersistenceManagerEventHandlerResponse actualPostAddResult =
        persistenceManagerEventHandlerAdapter.postAdd(
            persistenceManager, entity, new PersistencePackage());

    // Assert
    assertNull(actualPostAddResult.getDynamicResultSet());
    assertEquals(
        PersistenceManagerEventHandlerResponseStatus.NOT_HANDLED, actualPostAddResult.getStatus());
    assertTrue(actualPostAddResult.getAdditionalData().isEmpty());
    assertSame(entity, actualPostAddResult.getEntity());
  }

  /**
   * Test {@link PersistenceManagerEventHandlerAdapter#preFetch(PersistenceManager,
   * PersistencePackage, CriteriaTransferObject)}.
   *
   * <p>Method under test: {@link PersistenceManagerEventHandlerAdapter#preFetch(PersistenceManager,
   * PersistencePackage, CriteriaTransferObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceManagerEventHandlerResponse PersistenceManagerEventHandlerAdapter.preFetch(PersistenceManager, PersistencePackage, CriteriaTransferObject)"
  })
  public void testPreFetch() throws ServiceException {
    // Arrange
    PersistenceManagerEventHandlerAdapter persistenceManagerEventHandlerAdapter =
        new PersistenceManagerEventHandlerAdapter();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    PersistencePackage persistencePackage = new PersistencePackage();

    // Act
    PersistenceManagerEventHandlerResponse actualPreFetchResult =
        persistenceManagerEventHandlerAdapter.preFetch(
            persistenceManager, persistencePackage, new CriteriaTransferObject());

    // Assert
    assertNull(actualPreFetchResult.getDynamicResultSet());
    assertNull(actualPreFetchResult.getEntity());
    assertEquals(
        PersistenceManagerEventHandlerResponseStatus.NOT_HANDLED, actualPreFetchResult.getStatus());
    assertTrue(actualPreFetchResult.getAdditionalData().isEmpty());
  }

  /**
   * Test {@link PersistenceManagerEventHandlerAdapter#postFetch(PersistenceManager,
   * DynamicResultSet, PersistencePackage, CriteriaTransferObject)}.
   *
   * <p>Method under test: {@link
   * PersistenceManagerEventHandlerAdapter#postFetch(PersistenceManager, DynamicResultSet,
   * PersistencePackage, CriteriaTransferObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceManagerEventHandlerResponse PersistenceManagerEventHandlerAdapter.postFetch(PersistenceManager, DynamicResultSet, PersistencePackage, CriteriaTransferObject)"
  })
  public void testPostFetch() throws ServiceException {
    // Arrange
    PersistenceManagerEventHandlerAdapter persistenceManagerEventHandlerAdapter =
        new PersistenceManagerEventHandlerAdapter();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    DynamicResultSet resultSet = new DynamicResultSet();
    PersistencePackage persistencePackage = new PersistencePackage();

    // Act
    PersistenceManagerEventHandlerResponse actualPostFetchResult =
        persistenceManagerEventHandlerAdapter.postFetch(
            persistenceManager, resultSet, persistencePackage, new CriteriaTransferObject());

    // Assert
    assertNull(actualPostFetchResult.getEntity());
    assertEquals(
        PersistenceManagerEventHandlerResponseStatus.NOT_HANDLED,
        actualPostFetchResult.getStatus());
    assertTrue(actualPostFetchResult.getAdditionalData().isEmpty());
    assertSame(resultSet, actualPostFetchResult.getDynamicResultSet());
  }

  /**
   * Test {@link PersistenceManagerEventHandlerAdapter#preAdd(PersistenceManager,
   * PersistencePackage)}.
   *
   * <p>Method under test: {@link PersistenceManagerEventHandlerAdapter#preAdd(PersistenceManager,
   * PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceManagerEventHandlerResponse PersistenceManagerEventHandlerAdapter.preAdd(PersistenceManager, PersistencePackage)"
  })
  public void testPreAdd() throws ServiceException {
    // Arrange
    PersistenceManagerEventHandlerAdapter persistenceManagerEventHandlerAdapter =
        new PersistenceManagerEventHandlerAdapter();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();

    // Act
    PersistenceManagerEventHandlerResponse actualPreAddResult =
        persistenceManagerEventHandlerAdapter.preAdd(persistenceManager, new PersistencePackage());

    // Assert
    assertNull(actualPreAddResult.getDynamicResultSet());
    assertNull(actualPreAddResult.getEntity());
    assertEquals(
        PersistenceManagerEventHandlerResponseStatus.NOT_HANDLED, actualPreAddResult.getStatus());
    assertTrue(actualPreAddResult.getAdditionalData().isEmpty());
  }

  /**
   * Test {@link PersistenceManagerEventHandlerAdapter#preUpdate(PersistenceManager,
   * PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * PersistenceManagerEventHandlerAdapter#preUpdate(PersistenceManager, PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceManagerEventHandlerResponse PersistenceManagerEventHandlerAdapter.preUpdate(PersistenceManager, PersistencePackage)"
  })
  public void testPreUpdate() throws ServiceException {
    // Arrange
    PersistenceManagerEventHandlerAdapter persistenceManagerEventHandlerAdapter =
        new PersistenceManagerEventHandlerAdapter();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();

    // Act
    PersistenceManagerEventHandlerResponse actualPreUpdateResult =
        persistenceManagerEventHandlerAdapter.preUpdate(
            persistenceManager, new PersistencePackage());

    // Assert
    assertNull(actualPreUpdateResult.getDynamicResultSet());
    assertNull(actualPreUpdateResult.getEntity());
    assertEquals(
        PersistenceManagerEventHandlerResponseStatus.NOT_HANDLED,
        actualPreUpdateResult.getStatus());
    assertTrue(actualPreUpdateResult.getAdditionalData().isEmpty());
  }

  /**
   * Test {@link PersistenceManagerEventHandlerAdapter#postUpdate(PersistenceManager, Entity,
   * PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * PersistenceManagerEventHandlerAdapter#postUpdate(PersistenceManager, Entity,
   * PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceManagerEventHandlerResponse PersistenceManagerEventHandlerAdapter.postUpdate(PersistenceManager, Entity, PersistencePackage)"
  })
  public void testPostUpdate() throws ServiceException {
    // Arrange
    PersistenceManagerEventHandlerAdapter persistenceManagerEventHandlerAdapter =
        new PersistenceManagerEventHandlerAdapter();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    Entity entity = new Entity();

    // Act
    PersistenceManagerEventHandlerResponse actualPostUpdateResult =
        persistenceManagerEventHandlerAdapter.postUpdate(
            persistenceManager, entity, new PersistencePackage());

    // Assert
    assertNull(actualPostUpdateResult.getDynamicResultSet());
    assertEquals(
        PersistenceManagerEventHandlerResponseStatus.NOT_HANDLED,
        actualPostUpdateResult.getStatus());
    assertTrue(actualPostUpdateResult.getAdditionalData().isEmpty());
    assertSame(entity, actualPostUpdateResult.getEntity());
  }

  /**
   * Test {@link PersistenceManagerEventHandlerAdapter#preRemove(PersistenceManager,
   * PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * PersistenceManagerEventHandlerAdapter#preRemove(PersistenceManager, PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceManagerEventHandlerResponse PersistenceManagerEventHandlerAdapter.preRemove(PersistenceManager, PersistencePackage)"
  })
  public void testPreRemove() throws ServiceException {
    // Arrange
    PersistenceManagerEventHandlerAdapter persistenceManagerEventHandlerAdapter =
        new PersistenceManagerEventHandlerAdapter();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();

    // Act
    PersistenceManagerEventHandlerResponse actualPreRemoveResult =
        persistenceManagerEventHandlerAdapter.preRemove(
            persistenceManager, new PersistencePackage());

    // Assert
    assertNull(actualPreRemoveResult.getDynamicResultSet());
    assertNull(actualPreRemoveResult.getEntity());
    assertEquals(
        PersistenceManagerEventHandlerResponseStatus.NOT_HANDLED,
        actualPreRemoveResult.getStatus());
    assertTrue(actualPreRemoveResult.getAdditionalData().isEmpty());
  }

  /**
   * Test {@link PersistenceManagerEventHandlerAdapter#postRemove(PersistenceManager,
   * PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * PersistenceManagerEventHandlerAdapter#postRemove(PersistenceManager, PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceManagerEventHandlerResponse PersistenceManagerEventHandlerAdapter.postRemove(PersistenceManager, PersistencePackage)"
  })
  public void testPostRemove() throws ServiceException {
    // Arrange
    PersistenceManagerEventHandlerAdapter persistenceManagerEventHandlerAdapter =
        new PersistenceManagerEventHandlerAdapter();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();

    // Act
    PersistenceManagerEventHandlerResponse actualPostRemoveResult =
        persistenceManagerEventHandlerAdapter.postRemove(
            persistenceManager, new PersistencePackage());

    // Assert
    assertNull(actualPostRemoveResult.getDynamicResultSet());
    assertNull(actualPostRemoveResult.getEntity());
    assertEquals(
        PersistenceManagerEventHandlerResponseStatus.NOT_HANDLED,
        actualPostRemoveResult.getStatus());
    assertTrue(actualPostRemoveResult.getAdditionalData().isEmpty());
  }

  /**
   * Test {@link PersistenceManagerEventHandlerAdapter#postInspect(PersistenceManager,
   * DynamicResultSet, PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * PersistenceManagerEventHandlerAdapter#postInspect(PersistenceManager, DynamicResultSet,
   * PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceManagerEventHandlerResponse PersistenceManagerEventHandlerAdapter.postInspect(PersistenceManager, DynamicResultSet, PersistencePackage)"
  })
  public void testPostInspect() throws ServiceException {
    // Arrange
    PersistenceManagerEventHandlerAdapter persistenceManagerEventHandlerAdapter =
        new PersistenceManagerEventHandlerAdapter();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    DynamicResultSet resultSet = new DynamicResultSet();

    // Act
    PersistenceManagerEventHandlerResponse actualPostInspectResult =
        persistenceManagerEventHandlerAdapter.postInspect(
            persistenceManager, resultSet, new PersistencePackage());

    // Assert
    assertNull(actualPostInspectResult.getEntity());
    assertEquals(
        PersistenceManagerEventHandlerResponseStatus.NOT_HANDLED,
        actualPostInspectResult.getStatus());
    assertTrue(actualPostInspectResult.getAdditionalData().isEmpty());
    assertSame(resultSet, actualPostInspectResult.getDynamicResultSet());
  }

  /**
   * Test {@link PersistenceManagerEventHandlerAdapter#preInspect(PersistenceManager,
   * PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * PersistenceManagerEventHandlerAdapter#preInspect(PersistenceManager, PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceManagerEventHandlerResponse PersistenceManagerEventHandlerAdapter.preInspect(PersistenceManager, PersistencePackage)"
  })
  public void testPreInspect() throws ServiceException {
    // Arrange
    PersistenceManagerEventHandlerAdapter persistenceManagerEventHandlerAdapter =
        new PersistenceManagerEventHandlerAdapter();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();

    // Act
    PersistenceManagerEventHandlerResponse actualPreInspectResult =
        persistenceManagerEventHandlerAdapter.preInspect(
            persistenceManager, new PersistencePackage());

    // Assert
    assertNull(actualPreInspectResult.getDynamicResultSet());
    assertNull(actualPreInspectResult.getEntity());
    assertEquals(
        PersistenceManagerEventHandlerResponseStatus.NOT_HANDLED,
        actualPreInspectResult.getStatus());
    assertTrue(actualPreInspectResult.getAdditionalData().isEmpty());
  }

  /**
   * Test {@link PersistenceManagerEventHandlerAdapter#processValidationError(PersistenceManager,
   * Entity, PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * PersistenceManagerEventHandlerAdapter#processValidationError(PersistenceManager, Entity,
   * PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceManagerEventHandlerResponse PersistenceManagerEventHandlerAdapter.processValidationError(PersistenceManager, Entity, PersistencePackage)"
  })
  public void testProcessValidationError() throws ServiceException {
    // Arrange
    PersistenceManagerEventHandlerAdapter persistenceManagerEventHandlerAdapter =
        new PersistenceManagerEventHandlerAdapter();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    Entity entity = new Entity();

    // Act
    PersistenceManagerEventHandlerResponse actualProcessValidationErrorResult =
        persistenceManagerEventHandlerAdapter.processValidationError(
            persistenceManager, entity, new PersistencePackage());

    // Assert
    assertNull(actualProcessValidationErrorResult.getDynamicResultSet());
    assertNull(actualProcessValidationErrorResult.getEntity());
    assertEquals(
        PersistenceManagerEventHandlerResponseStatus.NOT_HANDLED,
        actualProcessValidationErrorResult.getStatus());
    assertTrue(actualProcessValidationErrorResult.getAdditionalData().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link PersistenceManagerEventHandlerAdapter}
   *   <li>{@link PersistenceManagerEventHandlerAdapter#getOrder()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PersistenceManagerEventHandlerAdapter.<init>()",
    "int PersistenceManagerEventHandlerAdapter.getOrder()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(Integer.MAX_VALUE, new PersistenceManagerEventHandlerAdapter().getOrder());
  }
}

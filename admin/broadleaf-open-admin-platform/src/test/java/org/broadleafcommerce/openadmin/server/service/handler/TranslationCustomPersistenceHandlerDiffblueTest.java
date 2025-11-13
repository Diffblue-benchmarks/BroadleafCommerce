package org.broadleafcommerce.openadmin.server.service.handler;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TranslationCustomPersistenceHandlerDiffblueTest {
  /**
   * Test {@link TranslationCustomPersistenceHandler#classMatches(PersistencePackage)}.
   *
   * <ul>
   *   <li>Given {@link TranslationCustomPersistenceHandler} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TranslationCustomPersistenceHandler#classMatches(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean TranslationCustomPersistenceHandler.classMatches(PersistencePackage)"
  })
  public void testClassMatches_givenTranslationCustomPersistenceHandler_thenReturnFalse() {
    // Arrange
    TranslationCustomPersistenceHandler translationCustomPersistenceHandler =
        new TranslationCustomPersistenceHandler();

    // Act and Assert
    assertFalse(translationCustomPersistenceHandler.classMatches(new PersistencePackage()));
  }

  /**
   * Test {@link TranslationCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   *
   * <ul>
   *   <li>Given {@link TranslationCustomPersistenceHandler} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TranslationCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean TranslationCustomPersistenceHandler.canHandleAdd(PersistencePackage)"
  })
  public void testCanHandleAdd_givenTranslationCustomPersistenceHandler_thenReturnFalse() {
    // Arrange
    TranslationCustomPersistenceHandler translationCustomPersistenceHandler =
        new TranslationCustomPersistenceHandler();

    // Act and Assert
    assertFalse(translationCustomPersistenceHandler.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Test {@link TranslationCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <ul>
   *   <li>Given {@link TranslationCustomPersistenceHandler} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TranslationCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean TranslationCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"
  })
  public void testCanHandleUpdate_givenTranslationCustomPersistenceHandler_thenReturnFalse() {
    // Arrange
    TranslationCustomPersistenceHandler translationCustomPersistenceHandler =
        new TranslationCustomPersistenceHandler();

    // Act and Assert
    assertFalse(translationCustomPersistenceHandler.canHandleUpdate(new PersistencePackage()));
  }

  /**
   * Test {@link TranslationCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link TranslationCustomPersistenceHandler} (default constructor).
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity TranslationCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenTranslationCustomPersistenceHandler_thenThrowServiceException()
      throws ServiceException {
    // Arrange
    TranslationCustomPersistenceHandler translationCustomPersistenceHandler =
        new TranslationCustomPersistenceHandler();

    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[] {"Type"});

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            translationCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).getType();
  }

  /**
   * Test {@link TranslationCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given array of {@link String} with {@code java.util.List}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationCustomPersistenceHandler#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity TranslationCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testUpdate_givenArrayOfStringWithJavaUtilList() throws ServiceException {
    // Arrange
    TranslationCustomPersistenceHandler translationCustomPersistenceHandler =
        new TranslationCustomPersistenceHandler();

    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[] {"java.util.List"});
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.setRequestingEntityName("");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            translationCustomPersistenceHandler.update(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).getType();
  }

  /**
   * Test {@link TranslationCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given array of {@link String} with {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationCustomPersistenceHandler#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity TranslationCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testUpdate_givenArrayOfStringWithType() throws ServiceException {
    // Arrange
    TranslationCustomPersistenceHandler translationCustomPersistenceHandler =
        new TranslationCustomPersistenceHandler();

    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[] {"Type"});
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.setRequestingEntityName("");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            translationCustomPersistenceHandler.update(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).getType();
  }
}

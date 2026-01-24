package org.broadleafcommerce.openadmin.server.service.persistence;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.persistence.TargetModeType;
import org.broadleafcommerce.common.service.PersistenceService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PersistenceManagerFactoryDiffblueTest {
  @InjectMocks private PersistenceManagerFactory persistenceManagerFactory;

  @Mock private PersistenceService persistenceService;

  /**
   * Test {@link PersistenceManagerFactory#getPersistenceManager()}.
   *
   * <p>Method under test: {@link PersistenceManagerFactory#getPersistenceManager()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManager PersistenceManagerFactory.getPersistenceManager()"
  })
  public void testGetPersistenceManager() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class, () -> PersistenceManagerFactory.getPersistenceManager());
  }

  /**
   * Test {@link PersistenceManagerFactory#getPersistenceManager(String)} with {@code className}.
   *
   * <p>Method under test: {@link PersistenceManagerFactory#getPersistenceManager(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManager PersistenceManagerFactory.getPersistenceManager(String)"
  })
  public void testGetPersistenceManagerWithClassName() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> PersistenceManagerFactory.getPersistenceManager("Class Name"));
  }

  /**
   * Test {@link PersistenceManagerFactory#getPersistenceManager(String, TargetModeType)} with
   * {@code className}, {@code targetModeType}.
   *
   * <p>Method under test: {@link PersistenceManagerFactory#getPersistenceManager(String,
   * TargetModeType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManager PersistenceManagerFactory.getPersistenceManager(String, TargetModeType)"
  })
  public void testGetPersistenceManagerWithClassNameTargetModeType() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> PersistenceManagerFactory.getPersistenceManager("Class Name", new TargetModeType()));
  }

  /**
   * Test {@link PersistenceManagerFactory#getPersistenceManager(Class, TargetModeType)} with {@code
   * entityClass}, {@code targetModeType}.
   *
   * <p>Method under test: {@link PersistenceManagerFactory#getPersistenceManager(Class,
   * TargetModeType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManager PersistenceManagerFactory.getPersistenceManager(Class, TargetModeType)"
  })
  public void testGetPersistenceManagerWithEntityClassTargetModeType() {
    // Arrange
    when(persistenceService.identifyEntityManager(
            Mockito.<Class<Object>>any(), Mockito.<TargetModeType>any()))
        .thenThrow(new IllegalStateException());
    Class<Object> entityClass = Object.class;

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> PersistenceManagerFactory.getPersistenceManager(entityClass, new TargetModeType()));
    verify(persistenceService).identifyEntityManager(isA(Class.class), isA(TargetModeType.class));
  }

  /**
   * Test {@link PersistenceManagerFactory#getPersistenceManager(Class)} with {@code entityClass}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link PersistenceManagerFactory#getPersistenceManager(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManager PersistenceManagerFactory.getPersistenceManager(Class)"
  })
  public void testGetPersistenceManagerWithEntityClass_thenThrowIllegalStateException() {
    // Arrange
    when(persistenceService.identifyEntityManager(
            Mockito.<Class<Object>>any(), Mockito.<TargetModeType>any()))
        .thenThrow(new IllegalStateException());
    Class<Object> entityClass = Object.class;

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> PersistenceManagerFactory.getPersistenceManager(entityClass));
    verify(persistenceService).identifyEntityManager(isA(Class.class), isA(TargetModeType.class));
  }

  /**
   * Test {@link PersistenceManagerFactory#startPersistenceManager(String, TargetModeType)} with
   * {@code entityClassName}, {@code targetModeType}.
   *
   * <p>Method under test: {@link PersistenceManagerFactory#startPersistenceManager(String,
   * TargetModeType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PersistenceManagerFactory.startPersistenceManager(String, TargetModeType)"
  })
  public void testStartPersistenceManagerWithEntityClassNameTargetModeType() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            PersistenceManagerFactory.startPersistenceManager(
                "Entity Class Name", new TargetModeType()));
  }

  /**
   * Test {@link PersistenceManagerFactory#startPersistenceManager(TargetModeType)} with {@code
   * targetModeType}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link PersistenceManagerFactory#startPersistenceManager(TargetModeType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PersistenceManagerFactory.startPersistenceManager(TargetModeType)"})
  public void testStartPersistenceManagerWithTargetModeType_thenThrowIllegalStateException() {
    // Arrange
    when(persistenceService.identifyDefaultEntityManager(Mockito.<TargetModeType>any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> PersistenceManagerFactory.startPersistenceManager(new TargetModeType()));
    verify(persistenceService).identifyDefaultEntityManager(isA(TargetModeType.class));
  }

  /**
   * Test {@link PersistenceManagerFactory#getDefaultPersistenceManager(TargetModeType)} with {@code
   * TargetModeType}.
   *
   * <p>Method under test: {@link
   * PersistenceManagerFactory#getDefaultPersistenceManager(TargetModeType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManager PersistenceManagerFactory.getDefaultPersistenceManager(TargetModeType)"
  })
  public void testGetDefaultPersistenceManagerWithTargetModeType() {
    // Arrange
    when(persistenceService.identifyDefaultEntityManager(Mockito.<TargetModeType>any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> PersistenceManagerFactory.getDefaultPersistenceManager(new TargetModeType()));
    verify(persistenceService).identifyDefaultEntityManager(isA(TargetModeType.class));
  }

  /**
   * Test {@link PersistenceManagerFactory#getDefaultPersistenceManager()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link PersistenceManagerFactory#getDefaultPersistenceManager()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManager PersistenceManagerFactory.getDefaultPersistenceManager()"
  })
  public void testGetDefaultPersistenceManager_thenThrowIllegalStateException() {
    // Arrange
    when(persistenceService.identifyDefaultEntityManager(Mockito.<TargetModeType>any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> PersistenceManagerFactory.getDefaultPersistenceManager());
    verify(persistenceService).identifyDefaultEntityManager(isA(TargetModeType.class));
  }

  /**
   * Test {@link PersistenceManagerFactory#getClassForName(String)}.
   *
   * <p>Method under test: {@link PersistenceManagerFactory#getClassForName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class PersistenceManagerFactory.getClassForName(String)"})
  public void testGetClassForName() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> PersistenceManagerFactory.getClassForName("Class Name"));
  }
}

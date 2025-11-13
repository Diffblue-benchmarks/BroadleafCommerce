package org.broadleafcommerce.openadmin.server.service.persistence;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.persistence.TargetModeType;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PersistenceManagerFactoryDiffblueTest {
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
   * Test {@link PersistenceManagerFactory#getClassForName(String)}.
   *
   * <p>Method under test: {@link PersistenceManagerFactory#getClassForName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Class PersistenceManagerFactory.getClassForName(String)"})
  public void testGetClassForName() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> PersistenceManagerFactory.getClassForName("Class Name"));
  }
}

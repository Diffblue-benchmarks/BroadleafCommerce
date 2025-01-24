package org.broadleafcommerce.openadmin.server.service.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.persistence.TargetModeType;
import org.broadleafcommerce.common.service.PersistenceServiceImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;

public class PersistenceManagerFactoryDiffblueTest {
  /**
   * Test {@link PersistenceManagerFactory#getPersistenceManager()}.
   * <p>
   * Method under test: {@link PersistenceManagerFactory#getPersistenceManager()}
   */
  @Test
  public void testGetPersistenceManager() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> PersistenceManagerFactory.getPersistenceManager());
  }

  /**
   * Test {@link PersistenceManagerFactory#getPersistenceManager(String)} with
   * {@code className}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerFactory#getPersistenceManager(String)}
   */
  @Test
  public void testGetPersistenceManagerWithClassName() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> PersistenceManagerFactory.getPersistenceManager("Class Name"));
  }

  /**
   * Test
   * {@link PersistenceManagerFactory#getPersistenceManager(String, TargetModeType)}
   * with {@code className}, {@code targetModeType}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerFactory#getPersistenceManager(String, TargetModeType)}
   */
  @Test
  public void testGetPersistenceManagerWithClassNameTargetModeType() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> PersistenceManagerFactory.getPersistenceManager("Class Name",
        new TargetModeType("Type", "Friendly Type")));
  }

  /**
   * Test {@link PersistenceManagerFactory#getPersistenceManager(Class)} with
   * {@code entityClass}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerFactory#getPersistenceManager(Class)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPersistenceManagerWithEntityClass() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.service.PersistenceServiceImpl.getManagedClassName(PersistenceServiceImpl.java:235)
    //       at org.broadleafcommerce.common.service.PersistenceServiceImpl.buildManagerCacheKey(PersistenceServiceImpl.java:224)
    //       at org.broadleafcommerce.common.service.PersistenceServiceImpl.buildManagerCacheKey(PersistenceServiceImpl.java:220)
    //       at org.broadleafcommerce.common.service.PersistenceServiceImpl.identifyEntityManager(PersistenceServiceImpl.java:159)
    //       at org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerFactory.getPersistenceManager(PersistenceManagerFactory.java:117)
    //       at org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerFactory.getPersistenceManager(PersistenceManagerFactory.java:86)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    Class<Object> entityClass = Object.class;

    // Act
    PersistenceManagerFactory.getPersistenceManager(entityClass);
  }

  /**
   * Test
   * {@link PersistenceManagerFactory#getPersistenceManager(Class, TargetModeType)}
   * with {@code entityClass}, {@code targetModeType}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerFactory#getPersistenceManager(Class, TargetModeType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPersistenceManagerWithEntityClassTargetModeType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.service.PersistenceServiceImpl.getManagedClassName(PersistenceServiceImpl.java:235)
    //       at org.broadleafcommerce.common.service.PersistenceServiceImpl.buildManagerCacheKey(PersistenceServiceImpl.java:224)
    //       at org.broadleafcommerce.common.service.PersistenceServiceImpl.buildManagerCacheKey(PersistenceServiceImpl.java:220)
    //       at org.broadleafcommerce.common.service.PersistenceServiceImpl.identifyEntityManager(PersistenceServiceImpl.java:159)
    //       at org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerFactory.getPersistenceManager(PersistenceManagerFactory.java:117)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    Class<Object> entityClass = Object.class;

    // Act
    PersistenceManagerFactory.getPersistenceManager(entityClass, new TargetModeType("Type", "Friendly Type"));
  }

  /**
   * Test {@link PersistenceManagerFactory#isPersistenceManagerActive()}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerFactory#isPersistenceManagerActive()}
   */
  @Test
  public void testIsPersistenceManagerActive() {
    // Arrange, Act and Assert
    assertFalse(PersistenceManagerFactory.isPersistenceManagerActive());
  }

  /**
   * Test
   * {@link PersistenceManagerFactory#startPersistenceManager(String, TargetModeType)}
   * with {@code entityClassName}, {@code targetModeType}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerFactory#startPersistenceManager(String, TargetModeType)}
   */
  @Test
  public void testStartPersistenceManagerWithEntityClassNameTargetModeType() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> PersistenceManagerFactory.startPersistenceManager("Entity Class Name",
        new TargetModeType("Type", "Friendly Type")));
  }

  /**
   * Test
   * {@link PersistenceManagerFactory#startPersistenceManager(TargetModeType)}
   * with {@code targetModeType}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerFactory#startPersistenceManager(TargetModeType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testStartPersistenceManagerWithTargetModeType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.service.PersistenceServiceImpl.identifyDefaultEntityManager(PersistenceServiceImpl.java:185)
    //       at org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerFactory.getDefaultPersistenceManager(PersistenceManagerFactory.java:103)
    //       at org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerFactory.startPersistenceManager(PersistenceManagerFactory.java:138)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    PersistenceManagerFactory.startPersistenceManager(new TargetModeType("Type", "Friendly Type"));
  }

  /**
   * Test {@link PersistenceManagerFactory#getDefaultPersistenceManager()}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerFactory#getDefaultPersistenceManager()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetDefaultPersistenceManager() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.service.PersistenceServiceImpl.identifyDefaultEntityManager(PersistenceServiceImpl.java:185)
    //       at org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerFactory.getDefaultPersistenceManager(PersistenceManagerFactory.java:103)
    //       at org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerFactory.getDefaultPersistenceManager(PersistenceManagerFactory.java:94)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    PersistenceManagerFactory.getDefaultPersistenceManager();
  }

  /**
   * Test
   * {@link PersistenceManagerFactory#getDefaultPersistenceManager(TargetModeType)}
   * with {@code TargetModeType}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerFactory#getDefaultPersistenceManager(TargetModeType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetDefaultPersistenceManagerWithTargetModeType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.service.PersistenceServiceImpl.identifyDefaultEntityManager(PersistenceServiceImpl.java:185)
    //       at org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerFactory.getDefaultPersistenceManager(PersistenceManagerFactory.java:103)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    PersistenceManagerFactory.getDefaultPersistenceManager(new TargetModeType("Type", "Friendly Type"));
  }

  /**
   * Test {@link PersistenceManagerFactory#endPersistenceManager()}.
   * <p>
   * Method under test: {@link PersistenceManagerFactory#endPersistenceManager()}
   */
  @Test
  public void testEndPersistenceManager() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    PersistenceManagerFactory.endPersistenceManager();
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PersistenceManagerFactory#getPersistenceManagerRef()}
   *   <li>
   * {@link PersistenceManagerFactory#setApplicationContext(ApplicationContext)}
   *   <li>{@link PersistenceManagerFactory#setPersistenceManagerRef(String)}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws BeansException {
    // Arrange
    PersistenceServiceImpl persistenceService = new PersistenceServiceImpl();
    PersistenceManagerFactory persistenceManagerFactory = new PersistenceManagerFactory(persistenceService,
        new EntityConfiguration());

    // Act
    String actualPersistenceManagerRef = persistenceManagerFactory.getPersistenceManagerRef();
    persistenceManagerFactory.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());
    persistenceManagerFactory.setPersistenceManagerRef("Persistence Manager Ref");

    // Assert
    assertEquals("Persistence Manager Ref", actualPersistenceManagerRef);
  }

  /**
   * Test {@link PersistenceManagerFactory#getClassForName(String)}.
   * <p>
   * Method under test: {@link PersistenceManagerFactory#getClassForName(String)}
   */
  @Test
  public void testGetClassForName() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> PersistenceManagerFactory.getClassForName("Class Name"));
  }
}

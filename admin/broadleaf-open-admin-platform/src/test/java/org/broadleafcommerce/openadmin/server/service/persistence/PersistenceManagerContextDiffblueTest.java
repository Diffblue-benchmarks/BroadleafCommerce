package org.broadleafcommerce.openadmin.server.service.persistence;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PersistenceManagerContextDiffblueTest {
  /**
   * Test {@link PersistenceManagerContext#addPersistenceManager(PersistenceManager)}.
   *
   * <p>Method under test: {@link
   * PersistenceManagerContext#addPersistenceManager(PersistenceManager)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PersistenceManagerContext.addPersistenceManager(PersistenceManager)"})
  public void testAddPersistenceManager() {
    // Arrange
    PersistenceManagerContext persistenceManagerContext = new PersistenceManagerContext();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();

    // Act
    persistenceManagerContext.addPersistenceManager(persistenceManager);

    // Assert
    assertSame(persistenceManager, persistenceManagerContext.getPersistenceManager());
  }

  /**
   * Test {@link PersistenceManagerContext#getPersistenceManager()}.
   *
   * <ul>
   *   <li>Given {@link PersistenceManagerContext} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PersistenceManagerContext#getPersistenceManager()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PersistenceManager PersistenceManagerContext.getPersistenceManager()"})
  public void testGetPersistenceManager_givenPersistenceManagerContext_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PersistenceManagerContext().getPersistenceManager());
  }

  /**
   * Test {@link PersistenceManagerContext#getPersistenceManager()}.
   *
   * <ul>
   *   <li>Then return {@link PersistenceManagerImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link PersistenceManagerContext#getPersistenceManager()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PersistenceManager PersistenceManagerContext.getPersistenceManager()"})
  public void testGetPersistenceManager_thenReturnPersistenceManagerImpl() {
    // Arrange
    PersistenceManagerContext persistenceManagerContext = new PersistenceManagerContext();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    persistenceManagerContext.addPersistenceManager(persistenceManager);

    // Act and Assert
    assertSame(persistenceManager, persistenceManagerContext.getPersistenceManager());
  }

  /**
   * Test {@link PersistenceManagerContext#remove()}.
   *
   * <ul>
   *   <li>Given {@link PersistenceManagerContext} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link PersistenceManagerContext#remove()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PersistenceManagerContext.remove()"})
  public void testRemove_givenPersistenceManagerContext() {
    // Arrange
    PersistenceManagerContext persistenceManagerContext = new PersistenceManagerContext();

    // Act
    persistenceManagerContext.remove();

    // Assert that nothing has changed
    assertNull(persistenceManagerContext.getPersistenceManager());
  }

  /**
   * Test {@link PersistenceManagerContext#remove()}.
   *
   * <ul>
   *   <li>Then {@link PersistenceManagerContext} (default constructor) PersistenceManager is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link PersistenceManagerContext#remove()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PersistenceManagerContext.remove()"})
  public void testRemove_thenPersistenceManagerContextPersistenceManagerIsNull() {
    // Arrange
    PersistenceManagerContext persistenceManagerContext = new PersistenceManagerContext();
    persistenceManagerContext.addPersistenceManager(new PersistenceManagerImpl());

    // Act
    persistenceManagerContext.remove();

    // Assert
    assertNull(persistenceManagerContext.getPersistenceManager());
  }

  /**
   * Test {@link PersistenceManagerContext#remove()}.
   *
   * <ul>
   *   <li>Then {@link PersistenceManagerContext} (default constructor) PersistenceManager {@link
   *       PersistenceManagerImpl}.
   * </ul>
   *
   * <p>Method under test: {@link PersistenceManagerContext#remove()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PersistenceManagerContext.remove()"})
  public void testRemove_thenPersistenceManagerContextPersistenceManagerPersistenceManagerImpl() {
    // Arrange
    PersistenceManagerContext persistenceManagerContext = new PersistenceManagerContext();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    persistenceManagerContext.addPersistenceManager(persistenceManager);
    persistenceManagerContext.addPersistenceManager(new PersistenceManagerImpl());

    // Act
    persistenceManagerContext.remove();

    // Assert that nothing has changed
    PersistenceManager persistenceManager2 = persistenceManagerContext.getPersistenceManager();
    assertTrue(persistenceManager2 instanceof PersistenceManagerImpl);
    assertSame(persistenceManager, persistenceManager2);
  }

  /**
   * Test new {@link PersistenceManagerContext} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link PersistenceManagerContext}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PersistenceManagerContext.<init>()"})
  public void testNewPersistenceManagerContext() {
    // Arrange, Act and Assert
    assertNull(new PersistenceManagerContext().getPersistenceManager());
  }
}

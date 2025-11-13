package org.broadleafcommerce.common.cache;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class HydratedSetupDiffblueTest {
  /**
   * Test {@link HydratedSetup#retrieveBoundEntityManager()}.
   *
   * <p>Method under test: {@link HydratedSetup#retrieveBoundEntityManager()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"javax.persistence.EntityManager HydratedSetup.retrieveBoundEntityManager()"})
  public void testRetrieveBoundEntityManager() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> HydratedSetup.retrieveBoundEntityManager());
  }

  /**
   * Test {@link HydratedSetup#retrieveBoundEntityManager()}.
   *
   * <p>Method under test: {@link HydratedSetup#retrieveBoundEntityManager()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"javax.persistence.EntityManager HydratedSetup.retrieveBoundEntityManager()"})
  public void testRetrieveBoundEntityManager2() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> HydratedSetup.retrieveBoundEntityManager());
  }
}

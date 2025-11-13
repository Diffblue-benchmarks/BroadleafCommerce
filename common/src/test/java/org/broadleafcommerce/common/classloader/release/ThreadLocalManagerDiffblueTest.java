package org.broadleafcommerce.common.classloader.release;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ThreadLocalManagerDiffblueTest {
  /**
   * Test new {@link ThreadLocalManager} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ThreadLocalManager}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ThreadLocalManager.<init>()"})
  public void testNewThreadLocalManager() {
    // Arrange and Act
    ThreadLocalManager actualThreadLocalManager = new ThreadLocalManager();

    // Assert
    assertNull(actualThreadLocalManager.marker);
    assertTrue(actualThreadLocalManager.threadLocals.isEmpty());
  }
}

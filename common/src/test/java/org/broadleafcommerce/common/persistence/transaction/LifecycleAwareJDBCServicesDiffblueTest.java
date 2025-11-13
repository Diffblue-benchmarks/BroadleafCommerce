package org.broadleafcommerce.common.persistence.transaction;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class LifecycleAwareJDBCServicesDiffblueTest {
  /**
   * Test new {@link LifecycleAwareJDBCServices} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * LifecycleAwareJDBCServices}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LifecycleAwareJDBCServices.<init>()"})
  public void testNewLifecycleAwareJDBCServices() {
    // Arrange and Act
    LifecycleAwareJDBCServices actualLifecycleAwareJDBCServices = new LifecycleAwareJDBCServices();

    // Assert
    assertNull(actualLifecycleAwareJDBCServices.getJdbcEnvironment());
    assertNull(actualLifecycleAwareJDBCServices.getResultSetWrapper());
  }
}

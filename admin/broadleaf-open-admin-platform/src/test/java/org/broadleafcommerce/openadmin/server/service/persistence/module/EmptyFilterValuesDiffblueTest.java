package org.broadleafcommerce.openadmin.server.service.persistence.module;

import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class EmptyFilterValuesDiffblueTest {
  /**
   * Test new {@link EmptyFilterValues} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link EmptyFilterValues}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EmptyFilterValues.<init>()"})
  public void testNewEmptyFilterValues() {
    // Arrange, Act and Assert
    assertTrue(new EmptyFilterValues().isEmpty());
  }
}

package org.broadleafcommerce.common.extensibility.cache.ehcache;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class InfiniteExpiryPolicyDiffblueTest {
  /**
   * Test new {@link InfiniteExpiryPolicy} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link InfiniteExpiryPolicy}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InfiniteExpiryPolicy.<init>()"})
  public void testNewInfiniteExpiryPolicy() {
    // Arrange, Act and Assert
    assertEquals(Long.MAX_VALUE, new InfiniteExpiryPolicy().getDefaultDuration().toNanos());
  }
}

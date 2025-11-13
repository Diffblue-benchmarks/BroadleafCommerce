package org.broadleafcommerce.common.extensibility.cache.ehcache;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TenMinuteExpiryPolicyDiffblueTest {
  /**
   * Test new {@link TenMinuteExpiryPolicy} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TenMinuteExpiryPolicy}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenMinuteExpiryPolicy.<init>()"})
  public void testNewTenMinuteExpiryPolicy() {
    // Arrange, Act and Assert
    assertEquals(600000000000L, new TenMinuteExpiryPolicy().getDefaultDuration().toNanos());
  }
}

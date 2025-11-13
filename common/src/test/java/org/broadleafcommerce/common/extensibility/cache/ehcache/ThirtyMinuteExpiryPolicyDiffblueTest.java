package org.broadleafcommerce.common.extensibility.cache.ehcache;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ThirtyMinuteExpiryPolicyDiffblueTest {
  /**
   * Test new {@link ThirtyMinuteExpiryPolicy} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ThirtyMinuteExpiryPolicy}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ThirtyMinuteExpiryPolicy.<init>()"})
  public void testNewThirtyMinuteExpiryPolicy() {
    // Arrange, Act and Assert
    assertEquals(1800000000000L, new ThirtyMinuteExpiryPolicy().getDefaultDuration().toNanos());
  }
}

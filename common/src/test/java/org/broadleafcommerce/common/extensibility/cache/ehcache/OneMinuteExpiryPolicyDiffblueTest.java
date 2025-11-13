package org.broadleafcommerce.common.extensibility.cache.ehcache;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OneMinuteExpiryPolicyDiffblueTest {
  /**
   * Test new {@link OneMinuteExpiryPolicy} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link OneMinuteExpiryPolicy}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OneMinuteExpiryPolicy.<init>()"})
  public void testNewOneMinuteExpiryPolicy() {
    // Arrange, Act and Assert
    assertEquals(60000000000L, new OneMinuteExpiryPolicy().getDefaultDuration().toNanos());
  }
}

package org.broadleafcommerce.common.extensibility.cache.ehcache;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TwelveHourExpiryPolicyDiffblueTest {
  /**
   * Test new {@link TwelveHourExpiryPolicy} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TwelveHourExpiryPolicy}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TwelveHourExpiryPolicy.<init>()"})
  public void testNewTwelveHourExpiryPolicy() {
    // Arrange, Act and Assert
    assertEquals(43200000000000L, new TwelveHourExpiryPolicy().getDefaultDuration().toNanos());
  }
}

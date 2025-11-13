package org.broadleafcommerce.common.extensibility.cache.ehcache;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TwentyFourHourExpiryPolicyDiffblueTest {
  /**
   * Test new {@link TwentyFourHourExpiryPolicy} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * TwentyFourHourExpiryPolicy}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TwentyFourHourExpiryPolicy.<init>()"})
  public void testNewTwentyFourHourExpiryPolicy() {
    // Arrange, Act and Assert
    assertEquals(86400000000000L, new TwentyFourHourExpiryPolicy().getDefaultDuration().toNanos());
  }
}

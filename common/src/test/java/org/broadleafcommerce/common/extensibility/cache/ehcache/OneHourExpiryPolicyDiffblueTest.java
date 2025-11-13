package org.broadleafcommerce.common.extensibility.cache.ehcache;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OneHourExpiryPolicyDiffblueTest {
  /**
   * Test new {@link OneHourExpiryPolicy} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link OneHourExpiryPolicy}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OneHourExpiryPolicy.<init>()"})
  public void testNewOneHourExpiryPolicy() {
    // Arrange, Act and Assert
    assertEquals(3600000000000L, new OneHourExpiryPolicy().getDefaultDuration().toNanos());
  }
}

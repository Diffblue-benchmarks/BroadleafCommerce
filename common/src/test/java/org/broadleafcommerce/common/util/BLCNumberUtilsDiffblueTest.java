package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BLCNumberUtilsDiffblueTest {
  /**
   * Test {@link BLCNumberUtils#toLong(Object)}.
   *
   * <p>Method under test: {@link BLCNumberUtils#toLong(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long BLCNumberUtils.toLong(Object)"})
  public void testToLong() {
    // Arrange and Act
    Long actualToLongResult = BLCNumberUtils.toLong(1);

    // Assert
    assertEquals(1L, actualToLongResult.longValue());
  }

  /**
   * Test {@link BLCNumberUtils#toLong(Object)}.
   *
   * <p>Method under test: {@link BLCNumberUtils#toLong(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long BLCNumberUtils.toLong(Object)"})
  public void testToLong2() {
    // Arrange and Act
    Long actualToLongResult = BLCNumberUtils.toLong(1L);

    // Assert
    assertEquals(1L, actualToLongResult.longValue());
  }
}

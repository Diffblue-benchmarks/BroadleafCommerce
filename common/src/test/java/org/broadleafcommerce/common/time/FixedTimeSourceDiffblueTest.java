package org.broadleafcommerce.common.time;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FixedTimeSourceDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FixedTimeSource#FixedTimeSource(long)}
   *   <li>{@link FixedTimeSource#timeInMillis()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FixedTimeSource.<init>(long)", "long FixedTimeSource.timeInMillis()"})
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(10L, new FixedTimeSource(10L).timeInMillis());
  }
}

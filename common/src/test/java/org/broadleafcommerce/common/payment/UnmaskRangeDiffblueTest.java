package org.broadleafcommerce.common.payment;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class UnmaskRangeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UnmaskRange#UnmaskRange(int, int)}
   *   <li>{@link UnmaskRange#getLength()}
   *   <li>{@link UnmaskRange#getPositionType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UnmaskRange.<init>(int, int)",
    "int UnmaskRange.getLength()",
    "int UnmaskRange.getPositionType()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    UnmaskRange actualUnmaskRange = new UnmaskRange(1, 3);
    int actualLength = actualUnmaskRange.getLength();

    // Assert
    assertEquals(1, actualUnmaskRange.getPositionType());
    assertEquals(3, actualLength);
  }
}

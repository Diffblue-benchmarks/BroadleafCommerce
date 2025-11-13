package org.broadleafcommerce.common.payment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AccountNumberMaskDiffblueTest {
  /**
   * Test {@link AccountNumberMask#mask(String)}.
   *
   * <ul>
   *   <li>Given {@link UnmaskRange} {@link UnmaskRange#getLength()} return three.
   *   <li>Then return {@code Acc77777777ber}.
   * </ul>
   *
   * <p>Method under test: {@link AccountNumberMask#mask(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AccountNumberMask.mask(String)"})
  public void testMask_givenUnmaskRangeGetLengthReturnThree_thenReturnAcc77777777ber() {
    // Arrange
    UnmaskRange unmaskRange = mock(UnmaskRange.class);
    when(unmaskRange.getLength()).thenReturn(3);
    when(unmaskRange.getPositionType()).thenReturn(1);

    ArrayList<UnmaskRange> ranges = new ArrayList<>();
    ranges.add(new UnmaskRange(0, 3));
    ranges.add(unmaskRange);

    // Act
    String actualMaskResult = new AccountNumberMask(ranges, '7').mask("Account Number");

    // Assert
    verify(unmaskRange, atLeast(1)).getLength();
    verify(unmaskRange).getPositionType();
    assertEquals("Acc77777777ber", actualMaskResult);
  }

  /**
   * Test {@link AccountNumberMask#mask(String)}.
   *
   * <ul>
   *   <li>Then return {@code 72}.
   * </ul>
   *
   * <p>Method under test: {@link AccountNumberMask#mask(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AccountNumberMask.mask(String)"})
  public void testMask_thenReturn72() {
    // Arrange
    ArrayList<UnmaskRange> ranges = new ArrayList<>();
    ranges.add(new UnmaskRange(1, 1));

    // Act and Assert
    assertEquals("72", new AccountNumberMask(ranges, '7').mask("42"));
  }

  /**
   * Test {@link AccountNumberMask#mask(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 77}.
   * </ul>
   *
   * <p>Method under test: {@link AccountNumberMask#mask(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AccountNumberMask.mask(String)"})
  public void testMask_when42_thenReturn77() {
    // Arrange, Act and Assert
    assertEquals("77", new AccountNumberMask(new ArrayList<>(), '7').mask("42"));
  }

  /**
   * Test {@link AccountNumberMask#mask(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AccountNumberMask#mask(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AccountNumberMask.mask(String)"})
  public void testMask_whenNull_thenThrowRuntimeException() {
    // Arrange
    ArrayList<UnmaskRange> ranges = new ArrayList<>();
    ranges.add(new UnmaskRange(0, 3));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> new AccountNumberMask(ranges, '7').mask(null));
  }
}

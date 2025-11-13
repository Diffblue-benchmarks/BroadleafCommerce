package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BLCPaymentMethodUtilsDiffblueTest {
  /**
   * Test {@link BLCPaymentMethodUtils#getExpirationMonthOptions()}.
   *
   * <p>Method under test: {@link BLCPaymentMethodUtils#getExpirationMonthOptions()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BLCPaymentMethodUtils.getExpirationMonthOptions()"})
  public void testGetExpirationMonthOptions() {
    // Arrange and Act
    List<String> actualExpirationMonthOptions = BLCPaymentMethodUtils.getExpirationMonthOptions();

    // Assert
    assertEquals(12, actualExpirationMonthOptions.size());
    assertEquals("01 - January", actualExpirationMonthOptions.get(0));
    assertEquals("02 - February", actualExpirationMonthOptions.get(1));
    assertEquals("03 - March", actualExpirationMonthOptions.get(2));
    assertEquals("04 - April", actualExpirationMonthOptions.get(3));
    assertEquals("05 - May", actualExpirationMonthOptions.get(4));
    assertEquals("06 - June", actualExpirationMonthOptions.get(5));
    assertEquals("07 - July", actualExpirationMonthOptions.get(6));
    assertEquals("08 - August", actualExpirationMonthOptions.get(7));
    assertEquals("09 - September", actualExpirationMonthOptions.get(8));
    assertEquals("10 - October", actualExpirationMonthOptions.get(9));
    assertEquals("11 - November", actualExpirationMonthOptions.get(10));
    assertEquals("12 - December", actualExpirationMonthOptions.get(11));
  }

  /**
   * Test {@link BLCPaymentMethodUtils#getExpirationYearOptions()}.
   *
   * <p>Method under test: {@link BLCPaymentMethodUtils#getExpirationYearOptions()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BLCPaymentMethodUtils.getExpirationYearOptions()"})
  public void testGetExpirationYearOptions() {
    // Arrange and Act
    List<String> actualExpirationYearOptions = BLCPaymentMethodUtils.getExpirationYearOptions();

    // Assert
    assertEquals(10, actualExpirationYearOptions.size());
  }
}

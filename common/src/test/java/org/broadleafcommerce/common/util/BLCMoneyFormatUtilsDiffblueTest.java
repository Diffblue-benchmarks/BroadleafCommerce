package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.money.Money;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BLCMoneyFormatUtilsDiffblueTest {
  /**
   * Test {@link BLCMoneyFormatUtils#formatPrice(Money, Map)} with {@code price}, {@code
   * localeToChange}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code Not Available}.
   * </ul>
   *
   * <p>Method under test: {@link BLCMoneyFormatUtils#formatPrice(Money, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String BLCMoneyFormatUtils.formatPrice(Money, Map)"})
  public void testFormatPriceWithPriceLocaleToChange_whenNull_thenReturnNotAvailable() {
    // Arrange, Act and Assert
    assertEquals("Not Available", BLCMoneyFormatUtils.formatPrice(null, new HashMap<>()));
  }

  /**
   * Test {@link BLCMoneyFormatUtils#formatPrice(Money)} with {@code price}.
   *
   * <ul>
   *   <li>When {@link Money#Money()}.
   *   <li>Then return {@code USD0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCMoneyFormatUtils#formatPrice(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String BLCMoneyFormatUtils.formatPrice(Money)"})
  public void testFormatPriceWithPrice_whenMoney_thenReturnUsd000() {
    // Arrange, Act and Assert
    assertEquals("USD0.00", BLCMoneyFormatUtils.formatPrice(new Money()));
  }

  /**
   * Test {@link BLCMoneyFormatUtils#formatPrice(Money)} with {@code price}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code Not Available}.
   * </ul>
   *
   * <p>Method under test: {@link BLCMoneyFormatUtils#formatPrice(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String BLCMoneyFormatUtils.formatPrice(Money)"})
  public void testFormatPriceWithPrice_whenNull_thenReturnNotAvailable() {
    // Arrange, Act and Assert
    assertEquals("Not Available", BLCMoneyFormatUtils.formatPrice(null));
  }
}

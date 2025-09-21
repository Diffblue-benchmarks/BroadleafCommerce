/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
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
   *   <li>Then return {@code $0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCMoneyFormatUtils#formatPrice(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String BLCMoneyFormatUtils.formatPrice(Money)"})
  public void testFormatPriceWithPrice_whenMoney_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$0.00", BLCMoneyFormatUtils.formatPrice(new Money()));
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

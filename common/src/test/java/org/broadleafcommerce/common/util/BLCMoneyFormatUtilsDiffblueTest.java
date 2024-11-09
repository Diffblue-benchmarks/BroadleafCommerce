/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.money.Money;
import org.junit.Test;

public class BLCMoneyFormatUtilsDiffblueTest {
  /**
   * Test {@link BLCMoneyFormatUtils#formatPrice(Money, Map)} with {@code price},
   * {@code localeToChange}.
   * <ul>
   *   <li>Given {@code ThreadLocalManager.notify.orphans}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCMoneyFormatUtils#formatPrice(Money, Map)}
   */
  @Test
  public void testFormatPriceWithPriceLocaleToChange_givenThreadLocalManagerNotifyOrphans() {
    // Arrange
    HashMap<String, String> localeToChange = new HashMap<>();
    localeToChange.computeIfPresent("ThreadLocalManager.notify.orphans", mock(BiFunction.class));

    // Act and Assert
    assertEquals("£0.00", BLCMoneyFormatUtils.formatPrice(Money.ZERO, localeToChange));
  }

  /**
   * Test {@link BLCMoneyFormatUtils#formatPrice(Money, Map)} with {@code price},
   * {@code localeToChange}.
   * <ul>
   *   <li>When {@link Money#Money()}.</li>
   *   <li>Then return {@code £0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCMoneyFormatUtils#formatPrice(Money, Map)}
   */
  @Test
  public void testFormatPriceWithPriceLocaleToChange_whenMoney_thenReturn000() {
    // Arrange
    Money price = new Money();

    // Act and Assert
    assertEquals("£0.00", BLCMoneyFormatUtils.formatPrice(price, new HashMap<>()));
  }

  /**
   * Test {@link BLCMoneyFormatUtils#formatPrice(Money, Map)} with {@code price},
   * {@code localeToChange}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code Not Available}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCMoneyFormatUtils#formatPrice(Money, Map)}
   */
  @Test
  public void testFormatPriceWithPriceLocaleToChange_whenNull_thenReturnNotAvailable() {
    // Arrange, Act and Assert
    assertEquals("Not Available", BLCMoneyFormatUtils.formatPrice(null, new HashMap<>()));
  }

  /**
   * Test {@link BLCMoneyFormatUtils#formatPrice(Money, Map)} with {@code price},
   * {@code localeToChange}.
   * <ul>
   *   <li>When {@link Money#ZERO}.</li>
   *   <li>Then return {@code £0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCMoneyFormatUtils#formatPrice(Money, Map)}
   */
  @Test
  public void testFormatPriceWithPriceLocaleToChange_whenZero_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("£0.00", BLCMoneyFormatUtils.formatPrice(Money.ZERO, new HashMap<>()));
  }

  /**
   * Test {@link BLCMoneyFormatUtils#formatPrice(Money)} with {@code price}.
   * <ul>
   *   <li>When {@link Money#Money()}.</li>
   *   <li>Then return {@code £0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCMoneyFormatUtils#formatPrice(Money)}
   */
  @Test
  public void testFormatPriceWithPrice_whenMoney_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("£0.00", BLCMoneyFormatUtils.formatPrice(new Money()));
  }

  /**
   * Test {@link BLCMoneyFormatUtils#formatPrice(Money)} with {@code price}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code Not Available}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCMoneyFormatUtils#formatPrice(Money)}
   */
  @Test
  public void testFormatPriceWithPrice_whenNull_thenReturnNotAvailable() {
    // Arrange, Act and Assert
    assertEquals("Not Available", BLCMoneyFormatUtils.formatPrice(null));
  }

  /**
   * Test {@link BLCMoneyFormatUtils#formatPrice(Money)} with {@code price}.
   * <ul>
   *   <li>When {@link Money#ZERO}.</li>
   *   <li>Then return {@code £0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCMoneyFormatUtils#formatPrice(Money)}
   */
  @Test
  public void testFormatPriceWithPrice_whenZero_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("£0.00", BLCMoneyFormatUtils.formatPrice(Money.ZERO));
  }
}

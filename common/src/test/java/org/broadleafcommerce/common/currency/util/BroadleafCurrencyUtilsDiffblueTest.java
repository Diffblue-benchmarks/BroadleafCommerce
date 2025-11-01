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
package org.broadleafcommerce.common.currency.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.Currency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.money.Money;
import org.junit.Test;

public class BroadleafCurrencyUtilsDiffblueTest {
  /**
   * Method under test: {@link BroadleafCurrencyUtils#getMoney(BigDecimal)}
   */
  @Test
  public void testGetMoney() {
    // Arrange, Act and Assert
    assertNull(BroadleafCurrencyUtils.getMoney((BigDecimal) null));
    assertNull(BroadleafCurrencyUtils.getMoney(null, null));
  }

  /**
   * Method under test:
   * {@link BroadleafCurrencyUtils#getCurrency(BroadleafCurrency)}
   */
  @Test
  public void testGetCurrency() {
    // Arrange
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    // Act
    Currency actualCurrency = BroadleafCurrencyUtils.getCurrency(currency);

    // Assert
    verify(currency).getCurrencyCode();
    assertEquals("British Pound", actualCurrency.getDisplayName());
    assertEquals("GBP", actualCurrency.getCurrencyCode());
    assertEquals("GBP", actualCurrency.toString());
    assertEquals("£", actualCurrency.getSymbol());
    assertEquals(2, actualCurrency.getDefaultFractionDigits());
    assertEquals(826, actualCurrency.getNumericCode());
  }

  /**
   * Method under test:
   * {@link BroadleafCurrencyUtils#calculateRemainder(Money, int)}
   */
  @Test
  public void testCalculateRemainder() {
    // Arrange, Act and Assert
    assertEquals(0, BroadleafCurrencyUtils.calculateRemainder(Money.ZERO, 1));
    assertEquals(0, BroadleafCurrencyUtils.calculateRemainder(null, 0));
    assertEquals(0, BroadleafCurrencyUtils.calculateRemainder(new Money(10.0d), 1));
  }
}

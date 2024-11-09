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
package org.broadleafcommerce.common.currency.domain;

import static org.junit.Assert.assertSame;
import org.junit.Test;

public class BroadleafRequestedCurrencyDtoDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link BroadleafRequestedCurrencyDto#BroadleafRequestedCurrencyDto(BroadleafCurrency, BroadleafCurrency)}
   *   <li>{@link BroadleafRequestedCurrencyDto#getCurrencyToUse()}
   *   <li>{@link BroadleafRequestedCurrencyDto#getRequestedCurrency()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    BroadleafCurrencyImpl currencyToUse = new BroadleafCurrencyImpl();
    BroadleafCurrencyImpl requestedCurrency = new BroadleafCurrencyImpl();

    // Act
    BroadleafRequestedCurrencyDto actualBroadleafRequestedCurrencyDto = new BroadleafRequestedCurrencyDto(currencyToUse,
        requestedCurrency);
    BroadleafCurrency actualCurrencyToUse = actualBroadleafRequestedCurrencyDto.getCurrencyToUse();

    // Assert
    assertSame(currencyToUse, actualCurrencyToUse);
    assertSame(requestedCurrency, actualBroadleafRequestedCurrencyDto.getRequestedCurrency());
  }
}

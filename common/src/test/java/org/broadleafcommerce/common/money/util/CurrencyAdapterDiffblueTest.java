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
package org.broadleafcommerce.common.money.util;

import static org.junit.Assert.assertEquals;
import java.util.Currency;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {CurrencyAdapter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CurrencyAdapterDiffblueTest {
  @Autowired
  private CurrencyAdapter currencyAdapter;

  /**
   * Test {@link CurrencyAdapter#unmarshal(String)} with {@code String}.
   * <ul>
   *   <li>When {@code GBP}.</li>
   *   <li>Then return DisplayName is {@code British Pound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CurrencyAdapter#unmarshal(String)}
   */
  @Test
  public void testUnmarshalWithString_whenGbp_thenReturnDisplayNameIsBritishPound() throws Exception {
    // Arrange and Act
    Currency actualUnmarshalResult = currencyAdapter.unmarshal("GBP");

    // Assert
    assertEquals("British Pound", actualUnmarshalResult.getDisplayName());
    assertEquals("GBP", actualUnmarshalResult.getCurrencyCode());
    assertEquals("GBP", actualUnmarshalResult.toString());
    assertEquals("£", actualUnmarshalResult.getSymbol());
    assertEquals(2, actualUnmarshalResult.getDefaultFractionDigits());
    assertEquals(826, actualUnmarshalResult.getNumericCode());
  }
}

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
package org.broadleafcommerce.common.util.xml;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import org.broadleafcommerce.common.money.BankersRounding;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BigDecimalRoundingAdapter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BigDecimalRoundingAdapterDiffblueTest {
  @Autowired
  private BigDecimalRoundingAdapter bigDecimalRoundingAdapter;

  /**
   * Test {@link BigDecimalRoundingAdapter#unmarshal(String)} with {@code String}.
   * <ul>
   *   <li>When {@code 2.3}.</li>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BigDecimalRoundingAdapter#unmarshal(String)}
   */
  @Test
  public void testUnmarshalWithString_when23_thenReturnBigDecimalWith23() throws Exception {
    // Arrange and Act
    BigDecimal actualUnmarshalResult = bigDecimalRoundingAdapter.unmarshal("2.3");

    // Assert
    assertEquals(new BigDecimal("2.3"), actualUnmarshalResult);
  }

  /**
   * Test {@link BigDecimalRoundingAdapter#marshal(BigDecimal)} with
   * {@code BigDecimal}.
   * <ul>
   *   <li>When {@link BankersRounding#ZERO}.</li>
   *   <li>Then return {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BigDecimalRoundingAdapter#marshal(BigDecimal)}
   */
  @Test
  public void testMarshalWithBigDecimal_whenZero_thenReturn000() throws Exception {
    // Arrange, Act and Assert
    assertEquals("0.00", (new BigDecimalRoundingAdapter()).marshal(BankersRounding.ZERO));
  }
}

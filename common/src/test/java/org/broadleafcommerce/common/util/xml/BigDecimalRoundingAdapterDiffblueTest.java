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
   * Method under test: {@link BigDecimalRoundingAdapter#unmarshal(String)}
   */
  @Test
  public void testUnmarshal() throws Exception {
    // Arrange and Act
    BigDecimal actualUnmarshalResult = bigDecimalRoundingAdapter.unmarshal("2.3");

    // Assert
    assertEquals(new BigDecimal("2.3"), actualUnmarshalResult);
  }

  /**
   * Method under test: {@link BigDecimalRoundingAdapter#marshal(BigDecimal)}
   */
  @Test
  public void testMarshal() throws Exception {
    // Arrange, Act and Assert
    assertEquals("0.00", (new BigDecimalRoundingAdapter()).marshal(BankersRounding.ZERO));
  }
}

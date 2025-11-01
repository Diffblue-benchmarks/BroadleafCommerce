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
package org.broadleafcommerce.common.util.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TQOrderDiffblueTest {
  /**
   * Method under test: {@link TQOrder#TQOrder(String, Boolean)}
   */
  @Test
  public void testNewTQOrder() {
    // Arrange and Act
    TQOrder actualTqOrder = new TQOrder("Expression", true);

    // Assert
    assertEquals("Expression", actualTqOrder.expression);
    assertTrue(actualTqOrder.ascending);
  }

  /**
   * Method under test: {@link TQOrder#toQl()}
   */
  @Test
  public void testToQl() {
    // Arrange, Act and Assert
    assertEquals("Expression ASC", (new TQOrder("Expression", true)).toQl());
    assertEquals("Expression DESC", (new TQOrder("Expression", false)).toQl());
    assertEquals("Expression DESC", (new TQOrder("Expression", null)).toQl());
  }
}

/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.search.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import java.math.BigDecimal;
import org.junit.Test;

public class ProductsByCategoryWithOrderDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ProductsByCategoryWithOrder#ProductsByCategoryWithOrder(Long, BigDecimal)}
   *   <li>{@link ProductsByCategoryWithOrder#setDisplayOrder(BigDecimal)}
   *   <li>{@link ProductsByCategoryWithOrder#setProductId(Long)}
   *   <li>{@link ProductsByCategoryWithOrder#getDisplayOrder()}
   *   <li>{@link ProductsByCategoryWithOrder#getProductId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ProductsByCategoryWithOrder actualProductsByCategoryWithOrder = new ProductsByCategoryWithOrder(1L,
        new BigDecimal("2.3"));
    BigDecimal displayOrder = new BigDecimal("2.3");
    actualProductsByCategoryWithOrder.setDisplayOrder(displayOrder);
    actualProductsByCategoryWithOrder.setProductId(1L);
    BigDecimal actualDisplayOrder = actualProductsByCategoryWithOrder.getDisplayOrder();

    // Assert that nothing has changed
    assertEquals(1L, actualProductsByCategoryWithOrder.getProductId().longValue());
    assertEquals(new BigDecimal("2.3"), actualDisplayOrder);
    assertSame(displayOrder, actualDisplayOrder);
  }
}

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

public class ParentCategoryByProductDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ParentCategoryByProduct#ParentCategoryByProduct(Long, Long, BigDecimal)}
   *   <li>{@link ParentCategoryByProduct#setCategory(Long)}
   *   <li>{@link ParentCategoryByProduct#setDisplayOrder(BigDecimal)}
   *   <li>{@link ParentCategoryByProduct#setProduct(Long)}
   *   <li>{@link ParentCategoryByProduct#getCategory()}
   *   <li>{@link ParentCategoryByProduct#getDisplayOrder()}
   *   <li>{@link ParentCategoryByProduct#getProduct()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ParentCategoryByProduct actualParentCategoryByProduct = new ParentCategoryByProduct(1L, 1L, new BigDecimal("2.3"));
    actualParentCategoryByProduct.setCategory(1L);
    BigDecimal displayOrder = new BigDecimal("2.3");
    actualParentCategoryByProduct.setDisplayOrder(displayOrder);
    actualParentCategoryByProduct.setProduct(1L);
    Long actualCategory = actualParentCategoryByProduct.getCategory();
    BigDecimal actualDisplayOrder = actualParentCategoryByProduct.getDisplayOrder();
    Long actualProduct = actualParentCategoryByProduct.getProduct();

    // Assert that nothing has changed
    assertEquals(1L, actualCategory.longValue());
    assertEquals(1L, actualProduct.longValue());
    assertEquals(new BigDecimal("2.3"), actualDisplayOrder);
    assertSame(displayOrder, actualDisplayOrder);
  }
}

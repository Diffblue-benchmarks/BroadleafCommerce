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
import org.junit.Test;

public class ParentCategoryByCategoryDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ParentCategoryByCategory#ParentCategoryByCategory(Long, Long, Long)}
   *   <li>{@link ParentCategoryByCategory#setChild(Long)}
   *   <li>{@link ParentCategoryByCategory#setDefaultParent(Long)}
   *   <li>{@link ParentCategoryByCategory#setParent(Long)}
   *   <li>{@link ParentCategoryByCategory#getChild()}
   *   <li>{@link ParentCategoryByCategory#getDefaultParent()}
   *   <li>{@link ParentCategoryByCategory#getParent()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ParentCategoryByCategory actualParentCategoryByCategory = new ParentCategoryByCategory(1L, 1L, 1L);
    actualParentCategoryByCategory.setChild(1L);
    actualParentCategoryByCategory.setDefaultParent(1L);
    actualParentCategoryByCategory.setParent(1L);
    Long actualChild = actualParentCategoryByCategory.getChild();
    Long actualDefaultParent = actualParentCategoryByCategory.getDefaultParent();
    Long actualParent = actualParentCategoryByCategory.getParent();

    // Assert that nothing has changed
    assertEquals(1L, actualChild.longValue());
    assertEquals(1L, actualDefaultParent.longValue());
    assertEquals(1L, actualParent.longValue());
  }
}

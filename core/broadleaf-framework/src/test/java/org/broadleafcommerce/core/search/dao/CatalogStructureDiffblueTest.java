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

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

public class CatalogStructureDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CatalogStructure}
   *   <li>{@link CatalogStructure#setDisplayOrdersByCategoryProduct(Map)}
   *   <li>{@link CatalogStructure#setParentCategoriesByCategory(Map)}
   *   <li>{@link CatalogStructure#setParentCategoriesByProduct(Map)}
   *   <li>{@link CatalogStructure#getDisplayOrdersByCategoryProduct()}
   *   <li>{@link CatalogStructure#getParentCategoriesByCategory()}
   *   <li>{@link CatalogStructure#getParentCategoriesByProduct()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CatalogStructure actualCatalogStructure = new CatalogStructure();
    HashMap<String, BigDecimal> displayOrdersByCategoryProduct = new HashMap<>();
    actualCatalogStructure.setDisplayOrdersByCategoryProduct(displayOrdersByCategoryProduct);
    HashMap<Long, Set<Long>> parentCategoriesByCategory = new HashMap<>();
    actualCatalogStructure.setParentCategoriesByCategory(parentCategoriesByCategory);
    HashMap<Long, Set<Long>> parentCategoriesByProduct = new HashMap<>();
    actualCatalogStructure.setParentCategoriesByProduct(parentCategoriesByProduct);
    Map<String, BigDecimal> actualDisplayOrdersByCategoryProduct = actualCatalogStructure
        .getDisplayOrdersByCategoryProduct();
    Map<Long, Set<Long>> actualParentCategoriesByCategory = actualCatalogStructure.getParentCategoriesByCategory();
    Map<Long, Set<Long>> actualParentCategoriesByProduct = actualCatalogStructure.getParentCategoriesByProduct();

    // Assert that nothing has changed
    assertTrue(actualDisplayOrdersByCategoryProduct.isEmpty());
    assertTrue(actualParentCategoriesByCategory.isEmpty());
    assertTrue(actualParentCategoriesByProduct.isEmpty());
    assertTrue(actualCatalogStructure.productsByCategory.isEmpty());
    assertSame(displayOrdersByCategoryProduct, actualDisplayOrdersByCategoryProduct);
    assertSame(parentCategoriesByCategory, actualParentCategoriesByCategory);
    assertSame(parentCategoriesByProduct, actualParentCategoriesByProduct);
  }
}

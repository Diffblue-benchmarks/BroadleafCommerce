/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.catalog.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ProductBundleComparatorDiffblueTest {
  /**
   * Method under test:
   * {@link ProductBundleComparator#compare(ProductBundle, ProductBundle)}
   */
  @Test
  public void testCompare() {
    // Arrange
    ProductBundleComparator productBundleComparator = new ProductBundleComparator();
    ProductBundleImpl productBundle = new ProductBundleImpl();

    // Act and Assert
    assertEquals(0, productBundleComparator.compare(productBundle, new ProductBundleImpl()));
  }

  /**
   * Method under test:
   * {@link ProductBundleComparator#compare(ProductBundle, ProductBundle)}
   */
  @Test
  public void testCompare2() {
    // Arrange, Act and Assert
    assertEquals(0, (new ProductBundleComparator()).compare(null, null));
  }

  /**
   * Method under test:
   * {@link ProductBundleComparator#compare(ProductBundle, ProductBundle)}
   */
  @Test
  public void testCompare3() {
    // Arrange
    ProductBundleComparator productBundleComparator = new ProductBundleComparator();

    // Act and Assert
    assertEquals(1, productBundleComparator.compare(null, new ProductBundleImpl()));
  }

  /**
   * Method under test:
   * {@link ProductBundleComparator#compare(ProductBundle, ProductBundle)}
   */
  @Test
  public void testCompare4() {
    // Arrange
    ProductBundleComparator productBundleComparator = new ProductBundleComparator();

    // Act and Assert
    assertEquals(-1, productBundleComparator.compare(new ProductBundleImpl(), null));
  }
}

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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ProductBundleComparatorDiffblueTest {
  /**
   * Test {@link ProductBundleComparator#compare(ProductBundle, ProductBundle)} with {@code
   * ProductBundle}, {@code ProductBundle}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleComparator#compare(ProductBundle, ProductBundle)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ProductBundleComparator.compare(ProductBundle, ProductBundle)"})
  public void testCompareWithProductBundleProductBundle_whenNull_thenReturnMinusOne() {
    // Arrange
    ProductBundleComparator productBundleComparator = new ProductBundleComparator();

    // Act and Assert
    assertEquals(-1, productBundleComparator.compare(new ProductBundleImpl(), null));
  }

  /**
   * Test {@link ProductBundleComparator#compare(ProductBundle, ProductBundle)} with {@code
   * ProductBundle}, {@code ProductBundle}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleComparator#compare(ProductBundle, ProductBundle)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ProductBundleComparator.compare(ProductBundle, ProductBundle)"})
  public void testCompareWithProductBundleProductBundle_whenNull_thenReturnOne() {
    // Arrange
    ProductBundleComparator productBundleComparator = new ProductBundleComparator();

    // Act and Assert
    assertEquals(1, productBundleComparator.compare(null, new ProductBundleImpl()));
  }

  /**
   * Test {@link ProductBundleComparator#compare(ProductBundle, ProductBundle)} with {@code
   * ProductBundle}, {@code ProductBundle}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleComparator#compare(ProductBundle, ProductBundle)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ProductBundleComparator.compare(ProductBundle, ProductBundle)"})
  public void testCompareWithProductBundleProductBundle_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new ProductBundleComparator().compare(null, null));
  }

  /**
   * Test {@link ProductBundleComparator#compare(ProductBundle, ProductBundle)} with {@code
   * ProductBundle}, {@code ProductBundle}.
   *
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleComparator#compare(ProductBundle, ProductBundle)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ProductBundleComparator.compare(ProductBundle, ProductBundle)"})
  public void testCompareWithProductBundleProductBundle_whenProductBundleImpl_thenReturnZero() {
    // Arrange
    ProductBundleComparator productBundleComparator = new ProductBundleComparator();
    ProductBundleImpl productBundle = new ProductBundleImpl();

    // Act and Assert
    assertEquals(0, productBundleComparator.compare(productBundle, new ProductBundleImpl()));
  }
}

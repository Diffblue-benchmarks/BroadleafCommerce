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

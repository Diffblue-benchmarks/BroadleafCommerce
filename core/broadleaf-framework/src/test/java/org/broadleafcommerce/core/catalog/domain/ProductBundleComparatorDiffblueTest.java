package org.broadleafcommerce.core.catalog.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ProductBundleComparatorDiffblueTest {
  /**
   * Test {@link ProductBundleComparator#compare(ProductBundle, ProductBundle)}
   * with {@code ProductBundle}, {@code ProductBundle}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductBundleComparator#compare(ProductBundle, ProductBundle)}
   */
  @Test
  public void testCompareWithProductBundleProductBundle_whenNull_thenReturnMinusOne() {
    // Arrange
    ProductBundleComparator productBundleComparator = new ProductBundleComparator();

    // Act and Assert
    assertEquals(-1, productBundleComparator.compare(new ProductBundleImpl(), null));
  }

  /**
   * Test {@link ProductBundleComparator#compare(ProductBundle, ProductBundle)}
   * with {@code ProductBundle}, {@code ProductBundle}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductBundleComparator#compare(ProductBundle, ProductBundle)}
   */
  @Test
  public void testCompareWithProductBundleProductBundle_whenNull_thenReturnOne() {
    // Arrange
    ProductBundleComparator productBundleComparator = new ProductBundleComparator();

    // Act and Assert
    assertEquals(1, productBundleComparator.compare(null, new ProductBundleImpl()));
  }

  /**
   * Test {@link ProductBundleComparator#compare(ProductBundle, ProductBundle)}
   * with {@code ProductBundle}, {@code ProductBundle}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductBundleComparator#compare(ProductBundle, ProductBundle)}
   */
  @Test
  public void testCompareWithProductBundleProductBundle_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new ProductBundleComparator()).compare(null, null));
  }

  /**
   * Test {@link ProductBundleComparator#compare(ProductBundle, ProductBundle)}
   * with {@code ProductBundle}, {@code ProductBundle}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductBundleComparator#compare(ProductBundle, ProductBundle)}
   */
  @Test
  public void testCompareWithProductBundleProductBundle_whenProductBundleImpl_thenReturnZero() {
    // Arrange
    ProductBundleComparator productBundleComparator = new ProductBundleComparator();
    ProductBundleImpl productBundle = new ProductBundleImpl();

    // Act and Assert
    assertEquals(0, productBundleComparator.compare(productBundle, new ProductBundleImpl()));
  }

  /**
   * Test new {@link ProductBundleComparator} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link ProductBundleComparator}
   */
  @Test
  public void testNewProductBundleComparator() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   There are no fields that could be asserted on.

    // Arrange and Act
    new ProductBundleComparator();
  }
}

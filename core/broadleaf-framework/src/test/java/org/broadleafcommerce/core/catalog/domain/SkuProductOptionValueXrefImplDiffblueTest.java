package org.broadleafcommerce.core.catalog.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SkuProductOptionValueXrefImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuProductOptionValueXrefImpl#SkuProductOptionValueXrefImpl()}
   *   <li>{@link SkuProductOptionValueXrefImpl#setId(Long)}
   *   <li>{@link SkuProductOptionValueXrefImpl#setProductOptionValue(ProductOptionValue)}
   *   <li>{@link SkuProductOptionValueXrefImpl#setSku(Sku)}
   *   <li>{@link SkuProductOptionValueXrefImpl#getId()}
   *   <li>{@link SkuProductOptionValueXrefImpl#getProductOptionValue()}
   *   <li>{@link SkuProductOptionValueXrefImpl#getSku()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SkuProductOptionValueXrefImpl.<init>()",
    "void SkuProductOptionValueXrefImpl.<init>(Sku, ProductOptionValue)",
    "Long SkuProductOptionValueXrefImpl.getId()",
    "ProductOptionValue SkuProductOptionValueXrefImpl.getProductOptionValue()",
    "Sku SkuProductOptionValueXrefImpl.getSku()",
    "void SkuProductOptionValueXrefImpl.setId(Long)",
    "void SkuProductOptionValueXrefImpl.setProductOptionValue(ProductOptionValue)",
    "void SkuProductOptionValueXrefImpl.setSku(Sku)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    SkuProductOptionValueXrefImpl actualSkuProductOptionValueXrefImpl =
        new SkuProductOptionValueXrefImpl();
    actualSkuProductOptionValueXrefImpl.setId(1L);
    ProductOptionValueImpl productOptionValue = new ProductOptionValueImpl();
    actualSkuProductOptionValueXrefImpl.setProductOptionValue(productOptionValue);
    SkuImpl sku = new SkuImpl();
    actualSkuProductOptionValueXrefImpl.setSku(sku);
    Long actualId = actualSkuProductOptionValueXrefImpl.getId();
    ProductOptionValue actualProductOptionValue =
        actualSkuProductOptionValueXrefImpl.getProductOptionValue();
    Sku actualSku = actualSkuProductOptionValueXrefImpl.getSku();

    // Assert
    assertEquals(1L, actualId.longValue());
    assertSame(productOptionValue, actualProductOptionValue);
    assertSame(sku, actualSku);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuProductOptionValueXrefImpl#SkuProductOptionValueXrefImpl(Sku,
   *       ProductOptionValue)}
   *   <li>{@link SkuProductOptionValueXrefImpl#setId(Long)}
   *   <li>{@link SkuProductOptionValueXrefImpl#setProductOptionValue(ProductOptionValue)}
   *   <li>{@link SkuProductOptionValueXrefImpl#setSku(Sku)}
   *   <li>{@link SkuProductOptionValueXrefImpl#getId()}
   *   <li>{@link SkuProductOptionValueXrefImpl#getProductOptionValue()}
   *   <li>{@link SkuProductOptionValueXrefImpl#getSku()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SkuProductOptionValueXrefImpl.<init>()",
    "void SkuProductOptionValueXrefImpl.<init>(Sku, ProductOptionValue)",
    "Long SkuProductOptionValueXrefImpl.getId()",
    "ProductOptionValue SkuProductOptionValueXrefImpl.getProductOptionValue()",
    "Sku SkuProductOptionValueXrefImpl.getSku()",
    "void SkuProductOptionValueXrefImpl.setId(Long)",
    "void SkuProductOptionValueXrefImpl.setProductOptionValue(ProductOptionValue)",
    "void SkuProductOptionValueXrefImpl.setSku(Sku)"
  })
  public void testGettersAndSetters_whenSkuImpl() {
    // Arrange
    SkuImpl sku = new SkuImpl();

    // Act
    SkuProductOptionValueXrefImpl actualSkuProductOptionValueXrefImpl =
        new SkuProductOptionValueXrefImpl(sku, new ProductOptionValueImpl());
    actualSkuProductOptionValueXrefImpl.setId(1L);
    ProductOptionValueImpl productOptionValue = new ProductOptionValueImpl();
    actualSkuProductOptionValueXrefImpl.setProductOptionValue(productOptionValue);
    SkuImpl sku2 = new SkuImpl();
    actualSkuProductOptionValueXrefImpl.setSku(sku2);
    Long actualId = actualSkuProductOptionValueXrefImpl.getId();
    ProductOptionValue actualProductOptionValue =
        actualSkuProductOptionValueXrefImpl.getProductOptionValue();
    Sku actualSku = actualSkuProductOptionValueXrefImpl.getSku();

    // Assert
    assertEquals(1L, actualId.longValue());
    assertSame(productOptionValue, actualProductOptionValue);
    assertSame(sku2, actualSku);
  }

  /**
   * Test {@link SkuProductOptionValueXrefImpl#equals(Object)}, and {@link
   * SkuProductOptionValueXrefImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuProductOptionValueXrefImpl#equals(Object)}
   *   <li>{@link SkuProductOptionValueXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuProductOptionValueXrefImpl.equals(Object)",
    "int SkuProductOptionValueXrefImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl =
        new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl.setId(1L);
    skuProductOptionValueXrefImpl.setProductOptionValue(new ProductOptionValueImpl());
    skuProductOptionValueXrefImpl.setSku(new SkuImpl());

    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl2 =
        new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl2.setId(1L);
    skuProductOptionValueXrefImpl2.setProductOptionValue(new ProductOptionValueImpl());
    skuProductOptionValueXrefImpl2.setSku(new SkuImpl());

    // Act and Assert
    assertEquals(skuProductOptionValueXrefImpl, skuProductOptionValueXrefImpl2);
    assertEquals(
        skuProductOptionValueXrefImpl.hashCode(), skuProductOptionValueXrefImpl2.hashCode());
  }

  /**
   * Test {@link SkuProductOptionValueXrefImpl#equals(Object)}, and {@link
   * SkuProductOptionValueXrefImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuProductOptionValueXrefImpl#equals(Object)}
   *   <li>{@link SkuProductOptionValueXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuProductOptionValueXrefImpl.equals(Object)",
    "int SkuProductOptionValueXrefImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl =
        new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl.setId(1L);
    skuProductOptionValueXrefImpl.setProductOptionValue(new ProductOptionValueImpl());
    skuProductOptionValueXrefImpl.setSku(new SkuImpl());

    // Act and Assert
    assertEquals(skuProductOptionValueXrefImpl, skuProductOptionValueXrefImpl);
    int expectedHashCodeResult = skuProductOptionValueXrefImpl.hashCode();
    assertEquals(expectedHashCodeResult, skuProductOptionValueXrefImpl.hashCode());
  }

  /**
   * Test {@link SkuProductOptionValueXrefImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuProductOptionValueXrefImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuProductOptionValueXrefImpl.equals(Object)",
    "int SkuProductOptionValueXrefImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl =
        new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl.setId(2L);
    skuProductOptionValueXrefImpl.setProductOptionValue(new ProductOptionValueImpl());
    skuProductOptionValueXrefImpl.setSku(new SkuImpl());

    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl2 =
        new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl2.setId(1L);
    skuProductOptionValueXrefImpl2.setProductOptionValue(new ProductOptionValueImpl());
    skuProductOptionValueXrefImpl2.setSku(new SkuImpl());

    // Act and Assert
    assertNotEquals(skuProductOptionValueXrefImpl, skuProductOptionValueXrefImpl2);
  }

  /**
   * Test {@link SkuProductOptionValueXrefImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuProductOptionValueXrefImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuProductOptionValueXrefImpl.equals(Object)",
    "int SkuProductOptionValueXrefImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl =
        new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl.setId(1L);
    skuProductOptionValueXrefImpl.setProductOptionValue(null);
    skuProductOptionValueXrefImpl.setSku(new SkuImpl());

    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl2 =
        new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl2.setId(1L);
    skuProductOptionValueXrefImpl2.setProductOptionValue(new ProductOptionValueImpl());
    skuProductOptionValueXrefImpl2.setSku(new SkuImpl());

    // Act and Assert
    assertNotEquals(skuProductOptionValueXrefImpl, skuProductOptionValueXrefImpl2);
  }

  /**
   * Test {@link SkuProductOptionValueXrefImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuProductOptionValueXrefImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuProductOptionValueXrefImpl.equals(Object)",
    "int SkuProductOptionValueXrefImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl =
        new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl.setId(1L);
    skuProductOptionValueXrefImpl.setProductOptionValue(new ProductOptionValueImpl());
    skuProductOptionValueXrefImpl.setSku(null);

    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl2 =
        new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl2.setId(1L);
    skuProductOptionValueXrefImpl2.setProductOptionValue(new ProductOptionValueImpl());
    skuProductOptionValueXrefImpl2.setSku(new SkuImpl());

    // Act and Assert
    assertNotEquals(skuProductOptionValueXrefImpl, skuProductOptionValueXrefImpl2);
  }

  /**
   * Test {@link SkuProductOptionValueXrefImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuProductOptionValueXrefImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuProductOptionValueXrefImpl.equals(Object)",
    "int SkuProductOptionValueXrefImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl =
        new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl.setId(1L);
    skuProductOptionValueXrefImpl.setProductOptionValue(new ProductOptionValueImpl());
    skuProductOptionValueXrefImpl.setSku(new SkuImpl());

    // Act and Assert
    assertNotEquals(skuProductOptionValueXrefImpl, null);
  }

  /**
   * Test {@link SkuProductOptionValueXrefImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuProductOptionValueXrefImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuProductOptionValueXrefImpl.equals(Object)",
    "int SkuProductOptionValueXrefImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl =
        new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl.setId(1L);
    skuProductOptionValueXrefImpl.setProductOptionValue(new ProductOptionValueImpl());
    skuProductOptionValueXrefImpl.setSku(new SkuImpl());

    // Act and Assert
    assertNotEquals(
        skuProductOptionValueXrefImpl, "Different type to SkuProductOptionValueXrefImpl");
  }
}

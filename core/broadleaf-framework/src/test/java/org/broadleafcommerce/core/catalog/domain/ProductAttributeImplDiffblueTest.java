package org.broadleafcommerce.core.catalog.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.catalog.service.type.ProductBundlePricingModelType;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ProductAttributeImplDiffblueTest {
  /**
   * Test {@link ProductAttributeImpl#equals(Object)}, and {@link ProductAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductAttributeImpl#equals(Object)}
   *   <li>{@link ProductAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductAttributeImpl.equals(Object)",
    "int ProductAttributeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(1L);
    productAttributeImpl.setName("Name");
    productAttributeImpl.setProduct(new ProductBundleImpl());
    productAttributeImpl.setValue("42");

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(1L);
    productAttributeImpl2.setName("Name");
    productAttributeImpl2.setProduct(new ProductBundleImpl());
    productAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(productAttributeImpl, productAttributeImpl2);
    assertEquals(productAttributeImpl.hashCode(), productAttributeImpl2.hashCode());
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}, and {@link ProductAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductAttributeImpl#equals(Object)}
   *   <li>{@link ProductAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductAttributeImpl.equals(Object)",
    "int ProductAttributeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(null);
    productAttributeImpl.setName("Name");
    productAttributeImpl.setProduct(new ProductBundleImpl());
    productAttributeImpl.setValue("42");

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(1L);
    productAttributeImpl2.setName("Name");
    productAttributeImpl2.setProduct(new ProductBundleImpl());
    productAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(productAttributeImpl, productAttributeImpl2);
    assertEquals(productAttributeImpl.hashCode(), productAttributeImpl2.hashCode());
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}, and {@link ProductAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductAttributeImpl#equals(Object)}
   *   <li>{@link ProductAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductAttributeImpl.equals(Object)",
    "int ProductAttributeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(1L);
    productAttributeImpl.setName("Name");
    productAttributeImpl.setProduct(new ProductBundleImpl());
    productAttributeImpl.setValue("42");

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(null);
    productAttributeImpl2.setName("Name");
    productAttributeImpl2.setProduct(new ProductBundleImpl());
    productAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(productAttributeImpl, productAttributeImpl2);
    assertEquals(productAttributeImpl.hashCode(), productAttributeImpl2.hashCode());
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}, and {@link ProductAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductAttributeImpl#equals(Object)}
   *   <li>{@link ProductAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductAttributeImpl.equals(Object)",
    "int ProductAttributeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(null);
    productAttributeImpl.setName(null);
    productAttributeImpl.setProduct(new ProductBundleImpl());
    productAttributeImpl.setValue("42");

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(1L);
    productAttributeImpl2.setName(null);
    productAttributeImpl2.setProduct(new ProductBundleImpl());
    productAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(productAttributeImpl, productAttributeImpl2);
    assertEquals(productAttributeImpl.hashCode(), productAttributeImpl2.hashCode());
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}, and {@link ProductAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductAttributeImpl#equals(Object)}
   *   <li>{@link ProductAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductAttributeImpl.equals(Object)",
    "int ProductAttributeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(null);
    productAttributeImpl.setName("Name");
    productAttributeImpl.setProduct(null);
    productAttributeImpl.setValue("42");

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(1L);
    productAttributeImpl2.setName("Name");
    productAttributeImpl2.setProduct(null);
    productAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(productAttributeImpl, productAttributeImpl2);
    assertEquals(productAttributeImpl.hashCode(), productAttributeImpl2.hashCode());
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}, and {@link ProductAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductAttributeImpl#equals(Object)}
   *   <li>{@link ProductAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductAttributeImpl.equals(Object)",
    "int ProductAttributeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(null);
    productAttributeImpl.setName("Name");
    productAttributeImpl.setProduct(new ProductBundleImpl());
    productAttributeImpl.setValue(null);

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(1L);
    productAttributeImpl2.setName("Name");
    productAttributeImpl2.setProduct(new ProductBundleImpl());
    productAttributeImpl2.setValue(null);

    // Act and Assert
    assertEquals(productAttributeImpl, productAttributeImpl2);
    assertEquals(productAttributeImpl.hashCode(), productAttributeImpl2.hashCode());
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}, and {@link ProductAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductAttributeImpl#equals(Object)}
   *   <li>{@link ProductAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductAttributeImpl.equals(Object)",
    "int ProductAttributeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(1L);
    productAttributeImpl.setName("Name");
    productAttributeImpl.setProduct(new ProductBundleImpl());
    productAttributeImpl.setValue("42");

    // Act and Assert
    assertEquals(productAttributeImpl, productAttributeImpl);
    int expectedHashCodeResult = productAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, productAttributeImpl.hashCode());
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductAttributeImpl.equals(Object)",
    "int ProductAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(2L);
    productAttributeImpl.setName("Name");
    productAttributeImpl.setProduct(new ProductBundleImpl());
    productAttributeImpl.setValue("42");

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(1L);
    productAttributeImpl2.setName("Name");
    productAttributeImpl2.setProduct(new ProductBundleImpl());
    productAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(productAttributeImpl, productAttributeImpl2);
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductAttributeImpl.equals(Object)",
    "int ProductAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(null);
    productAttributeImpl.setName("42");
    productAttributeImpl.setProduct(new ProductBundleImpl());
    productAttributeImpl.setValue("42");

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(1L);
    productAttributeImpl2.setName("Name");
    productAttributeImpl2.setProduct(new ProductBundleImpl());
    productAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(productAttributeImpl, productAttributeImpl2);
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductAttributeImpl.equals(Object)",
    "int ProductAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(null);
    productAttributeImpl.setName(null);
    productAttributeImpl.setProduct(new ProductBundleImpl());
    productAttributeImpl.setValue("42");

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(1L);
    productAttributeImpl2.setName("Name");
    productAttributeImpl2.setProduct(new ProductBundleImpl());
    productAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(productAttributeImpl, productAttributeImpl2);
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductAttributeImpl.equals(Object)",
    "int ProductAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ProductBundleImpl product = new ProductBundleImpl();
    product.setPricingModel(ProductBundlePricingModelType.BUNDLE);

    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(null);
    productAttributeImpl.setName("Name");
    productAttributeImpl.setProduct(product);
    productAttributeImpl.setValue("42");

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(1L);
    productAttributeImpl2.setName("Name");
    productAttributeImpl2.setProduct(new ProductBundleImpl());
    productAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(productAttributeImpl, productAttributeImpl2);
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductAttributeImpl.equals(Object)",
    "int ProductAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(null);
    productAttributeImpl.setName("Name");
    productAttributeImpl.setProduct(null);
    productAttributeImpl.setValue("42");

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(1L);
    productAttributeImpl2.setName("Name");
    productAttributeImpl2.setProduct(new ProductBundleImpl());
    productAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(productAttributeImpl, productAttributeImpl2);
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductAttributeImpl.equals(Object)",
    "int ProductAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(null);
    productAttributeImpl.setName("Name");
    productAttributeImpl.setProduct(new ProductBundleImpl());
    productAttributeImpl.setValue("Name");

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(1L);
    productAttributeImpl2.setName("Name");
    productAttributeImpl2.setProduct(new ProductBundleImpl());
    productAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(productAttributeImpl, productAttributeImpl2);
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductAttributeImpl.equals(Object)",
    "int ProductAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(null);
    productAttributeImpl.setName("Name");
    productAttributeImpl.setProduct(new ProductBundleImpl());
    productAttributeImpl.setValue(null);

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(1L);
    productAttributeImpl2.setName("Name");
    productAttributeImpl2.setProduct(new ProductBundleImpl());
    productAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(productAttributeImpl, productAttributeImpl2);
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductAttributeImpl.equals(Object)",
    "int ProductAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(1L);
    productAttributeImpl.setName("Name");
    productAttributeImpl.setProduct(new ProductBundleImpl());
    productAttributeImpl.setValue("42");

    // Act and Assert
    assertNotEquals(productAttributeImpl, null);
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductAttributeImpl.equals(Object)",
    "int ProductAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(1L);
    productAttributeImpl.setName("Name");
    productAttributeImpl.setProduct(new ProductBundleImpl());
    productAttributeImpl.setValue("42");

    // Act and Assert
    assertNotEquals(productAttributeImpl, "Different type to ProductAttributeImpl");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ProductAttributeImpl}
   *   <li>{@link ProductAttributeImpl#setId(Long)}
   *   <li>{@link ProductAttributeImpl#setName(String)}
   *   <li>{@link ProductAttributeImpl#setProduct(Product)}
   *   <li>{@link ProductAttributeImpl#setValue(String)}
   *   <li>{@link ProductAttributeImpl#getId()}
   *   <li>{@link ProductAttributeImpl#getProduct()}
   *   <li>{@link ProductAttributeImpl#toString()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductAttributeImpl.<init>()",
    "Long ProductAttributeImpl.getId()",
    "Product ProductAttributeImpl.getProduct()",
    "void ProductAttributeImpl.setId(Long)",
    "void ProductAttributeImpl.setName(String)",
    "void ProductAttributeImpl.setProduct(Product)",
    "void ProductAttributeImpl.setValue(String)",
    "String ProductAttributeImpl.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ProductAttributeImpl actualProductAttributeImpl = new ProductAttributeImpl();
    actualProductAttributeImpl.setId(1L);
    actualProductAttributeImpl.setName("Name");
    ProductBundleImpl product = new ProductBundleImpl();
    actualProductAttributeImpl.setProduct(product);
    actualProductAttributeImpl.setValue("42");
    Long actualId = actualProductAttributeImpl.getId();
    Product actualProduct = actualProductAttributeImpl.getProduct();

    // Assert
    assertEquals("42", actualProductAttributeImpl.toString());
    assertEquals(1L, actualId.longValue());
    assertSame(product, actualProduct);
  }
}

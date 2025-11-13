package org.broadleafcommerce.core.catalog.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.money.Money;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ProductOptionValueImplDiffblueTest {
  /**
   * Test {@link ProductOptionValueImpl#equals(Object)}, and {@link
   * ProductOptionValueImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionValueImpl#equals(Object)}
   *   <li>{@link ProductOptionValueImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValueImpl.equals(Object)",
    "int ProductOptionValueImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue("42");
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(1L);
    productOptionValueImpl.setPriceAdjustment(new Money());
    productOptionValueImpl.setProductOption(new ProductOptionImpl());

    ProductOptionValueImpl productOptionValueImpl2 = new ProductOptionValueImpl();
    productOptionValueImpl2.setAttributeValue("42");
    productOptionValueImpl2.setDisplayOrder(1L);
    productOptionValueImpl2.setId(1L);
    productOptionValueImpl2.setPriceAdjustment(new Money());
    productOptionValueImpl2.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertEquals(productOptionValueImpl, productOptionValueImpl2);
    assertEquals(productOptionValueImpl.hashCode(), productOptionValueImpl2.hashCode());
  }

  /**
   * Test {@link ProductOptionValueImpl#equals(Object)}, and {@link
   * ProductOptionValueImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionValueImpl#equals(Object)}
   *   <li>{@link ProductOptionValueImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValueImpl.equals(Object)",
    "int ProductOptionValueImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue("42");
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(null);
    productOptionValueImpl.setPriceAdjustment(new Money());
    productOptionValueImpl.setProductOption(new ProductOptionImpl());

    ProductOptionValueImpl productOptionValueImpl2 = new ProductOptionValueImpl();
    productOptionValueImpl2.setAttributeValue("42");
    productOptionValueImpl2.setDisplayOrder(1L);
    productOptionValueImpl2.setId(1L);
    productOptionValueImpl2.setPriceAdjustment(new Money());
    productOptionValueImpl2.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertEquals(productOptionValueImpl, productOptionValueImpl2);
    assertNotEquals(productOptionValueImpl.hashCode(), productOptionValueImpl2.hashCode());
  }

  /**
   * Test {@link ProductOptionValueImpl#equals(Object)}, and {@link
   * ProductOptionValueImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionValueImpl#equals(Object)}
   *   <li>{@link ProductOptionValueImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValueImpl.equals(Object)",
    "int ProductOptionValueImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue("42");
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(1L);
    productOptionValueImpl.setPriceAdjustment(new Money());
    productOptionValueImpl.setProductOption(new ProductOptionImpl());

    ProductOptionValueImpl productOptionValueImpl2 = new ProductOptionValueImpl();
    productOptionValueImpl2.setAttributeValue("42");
    productOptionValueImpl2.setDisplayOrder(1L);
    productOptionValueImpl2.setId(null);
    productOptionValueImpl2.setPriceAdjustment(new Money());
    productOptionValueImpl2.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertEquals(productOptionValueImpl, productOptionValueImpl2);
    assertNotEquals(productOptionValueImpl.hashCode(), productOptionValueImpl2.hashCode());
  }

  /**
   * Test {@link ProductOptionValueImpl#equals(Object)}, and {@link
   * ProductOptionValueImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionValueImpl#equals(Object)}
   *   <li>{@link ProductOptionValueImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValueImpl.equals(Object)",
    "int ProductOptionValueImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue(null);
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(null);
    productOptionValueImpl.setPriceAdjustment(new Money());
    productOptionValueImpl.setProductOption(new ProductOptionImpl());

    ProductOptionValueImpl productOptionValueImpl2 = new ProductOptionValueImpl();
    productOptionValueImpl2.setAttributeValue(null);
    productOptionValueImpl2.setDisplayOrder(1L);
    productOptionValueImpl2.setId(1L);
    productOptionValueImpl2.setPriceAdjustment(new Money());
    productOptionValueImpl2.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertEquals(productOptionValueImpl, productOptionValueImpl2);
    assertNotEquals(productOptionValueImpl.hashCode(), productOptionValueImpl2.hashCode());
  }

  /**
   * Test {@link ProductOptionValueImpl#equals(Object)}, and {@link
   * ProductOptionValueImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionValueImpl#equals(Object)}
   *   <li>{@link ProductOptionValueImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValueImpl.equals(Object)",
    "int ProductOptionValueImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue("42");
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(1L);
    productOptionValueImpl.setPriceAdjustment(new Money());
    productOptionValueImpl.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertEquals(productOptionValueImpl, productOptionValueImpl);
    int expectedHashCodeResult = productOptionValueImpl.hashCode();
    assertEquals(expectedHashCodeResult, productOptionValueImpl.hashCode());
  }

  /**
   * Test {@link ProductOptionValueImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValueImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValueImpl.equals(Object)",
    "int ProductOptionValueImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue("42");
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(2L);
    productOptionValueImpl.setPriceAdjustment(new Money());
    productOptionValueImpl.setProductOption(new ProductOptionImpl());

    ProductOptionValueImpl productOptionValueImpl2 = new ProductOptionValueImpl();
    productOptionValueImpl2.setAttributeValue("42");
    productOptionValueImpl2.setDisplayOrder(1L);
    productOptionValueImpl2.setId(1L);
    productOptionValueImpl2.setPriceAdjustment(new Money());
    productOptionValueImpl2.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertNotEquals(productOptionValueImpl, productOptionValueImpl2);
  }

  /**
   * Test {@link ProductOptionValueImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValueImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValueImpl.equals(Object)",
    "int ProductOptionValueImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue("Attribute Value");
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(null);
    productOptionValueImpl.setPriceAdjustment(new Money());
    productOptionValueImpl.setProductOption(new ProductOptionImpl());

    ProductOptionValueImpl productOptionValueImpl2 = new ProductOptionValueImpl();
    productOptionValueImpl2.setAttributeValue("42");
    productOptionValueImpl2.setDisplayOrder(1L);
    productOptionValueImpl2.setId(1L);
    productOptionValueImpl2.setPriceAdjustment(new Money());
    productOptionValueImpl2.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertNotEquals(productOptionValueImpl, productOptionValueImpl2);
  }

  /**
   * Test {@link ProductOptionValueImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValueImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValueImpl.equals(Object)",
    "int ProductOptionValueImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue(null);
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(null);
    productOptionValueImpl.setPriceAdjustment(new Money());
    productOptionValueImpl.setProductOption(new ProductOptionImpl());

    ProductOptionValueImpl productOptionValueImpl2 = new ProductOptionValueImpl();
    productOptionValueImpl2.setAttributeValue("42");
    productOptionValueImpl2.setDisplayOrder(1L);
    productOptionValueImpl2.setId(1L);
    productOptionValueImpl2.setPriceAdjustment(new Money());
    productOptionValueImpl2.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertNotEquals(productOptionValueImpl, productOptionValueImpl2);
  }

  /**
   * Test {@link ProductOptionValueImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValueImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValueImpl.equals(Object)",
    "int ProductOptionValueImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue("42");
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(1L);
    productOptionValueImpl.setPriceAdjustment(new Money());
    productOptionValueImpl.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertNotEquals(productOptionValueImpl, null);
  }

  /**
   * Test {@link ProductOptionValueImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValueImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValueImpl.equals(Object)",
    "int ProductOptionValueImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue("42");
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(1L);
    productOptionValueImpl.setPriceAdjustment(new Money());
    productOptionValueImpl.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertNotEquals(productOptionValueImpl, "Different type to ProductOptionValueImpl");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ProductOptionValueImpl}
   *   <li>{@link ProductOptionValueImpl#setAttributeValue(String)}
   *   <li>{@link ProductOptionValueImpl#setDisplayOrder(Long)}
   *   <li>{@link ProductOptionValueImpl#setId(Long)}
   *   <li>{@link ProductOptionValueImpl#setProductOption(ProductOption)}
   *   <li>{@link ProductOptionValueImpl#getDisplayOrder()}
   *   <li>{@link ProductOptionValueImpl#getId()}
   *   <li>{@link ProductOptionValueImpl#getProductOption()}
   *   <li>{@link ProductOptionValueImpl#getRawAttributeValue()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductOptionValueImpl.<init>()",
    "Long ProductOptionValueImpl.getDisplayOrder()",
    "Long ProductOptionValueImpl.getId()",
    "ProductOption ProductOptionValueImpl.getProductOption()",
    "String ProductOptionValueImpl.getRawAttributeValue()",
    "void ProductOptionValueImpl.setAttributeValue(String)",
    "void ProductOptionValueImpl.setDisplayOrder(Long)",
    "void ProductOptionValueImpl.setId(Long)",
    "void ProductOptionValueImpl.setProductOption(ProductOption)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ProductOptionValueImpl actualProductOptionValueImpl = new ProductOptionValueImpl();
    actualProductOptionValueImpl.setAttributeValue("42");
    actualProductOptionValueImpl.setDisplayOrder(1L);
    actualProductOptionValueImpl.setId(1L);
    ProductOptionImpl productOption = new ProductOptionImpl();
    actualProductOptionValueImpl.setProductOption(productOption);
    Long actualDisplayOrder = actualProductOptionValueImpl.getDisplayOrder();
    Long actualId = actualProductOptionValueImpl.getId();
    ProductOption actualProductOption = actualProductOptionValueImpl.getProductOption();

    // Assert
    assertEquals("42", actualProductOptionValueImpl.getRawAttributeValue());
    assertEquals(1L, actualDisplayOrder.longValue());
    assertEquals(1L, actualId.longValue());
    assertSame(productOption, actualProductOption);
  }
}

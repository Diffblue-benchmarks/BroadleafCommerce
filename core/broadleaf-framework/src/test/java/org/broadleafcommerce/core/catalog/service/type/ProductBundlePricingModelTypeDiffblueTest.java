package org.broadleafcommerce.core.catalog.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ProductBundlePricingModelTypeDiffblueTest {
  /**
   * Test {@link ProductBundlePricingModelType#getInstance(String)}.
   *
   * <p>Method under test: {@link ProductBundlePricingModelType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProductBundlePricingModelType ProductBundlePricingModelType.getInstance(String)"
  })
  public void testGetInstance() {
    // Arrange and Act
    ProductBundlePricingModelType actualInstance =
        ProductBundlePricingModelType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return FriendlyType is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductBundlePricingModelType#ProductBundlePricingModelType()}
   *   <li>{@link ProductBundlePricingModelType#getFriendlyType()}
   *   <li>{@link ProductBundlePricingModelType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductBundlePricingModelType.<init>()",
    "void ProductBundlePricingModelType.<init>(String, String)",
    "String ProductBundlePricingModelType.getFriendlyType()",
    "String ProductBundlePricingModelType.getType()"
  })
  public void testGettersAndSetters_thenReturnFriendlyTypeIsNull() {
    // Arrange and Act
    ProductBundlePricingModelType actualProductBundlePricingModelType =
        new ProductBundlePricingModelType();
    String actualFriendlyType = actualProductBundlePricingModelType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualProductBundlePricingModelType.getType());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then return {@code Friendly Type}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductBundlePricingModelType#ProductBundlePricingModelType(String, String)}
   *   <li>{@link ProductBundlePricingModelType#getFriendlyType()}
   *   <li>{@link ProductBundlePricingModelType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductBundlePricingModelType.<init>()",
    "void ProductBundlePricingModelType.<init>(String, String)",
    "String ProductBundlePricingModelType.getFriendlyType()",
    "String ProductBundlePricingModelType.getType()"
  })
  public void testGettersAndSetters_whenType_thenReturnFriendlyType() {
    // Arrange and Act
    ProductBundlePricingModelType actualProductBundlePricingModelType =
        new ProductBundlePricingModelType("Type", "Friendly Type");
    String actualFriendlyType = actualProductBundlePricingModelType.getFriendlyType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", actualProductBundlePricingModelType.getType());
  }

  /**
   * Test {@link ProductBundlePricingModelType#equals(Object)}, and {@link
   * ProductBundlePricingModelType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductBundlePricingModelType#equals(Object)}
   *   <li>{@link ProductBundlePricingModelType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductBundlePricingModelType.equals(Object)",
    "int ProductBundlePricingModelType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProductBundlePricingModelType productBundlePricingModelType =
        ProductBundlePricingModelType.BUNDLE;
    ProductBundlePricingModelType productBundlePricingModelType2 =
        ProductBundlePricingModelType.BUNDLE;

    // Act and Assert
    assertEquals(productBundlePricingModelType, productBundlePricingModelType2);
    assertEquals(
        productBundlePricingModelType.hashCode(), productBundlePricingModelType2.hashCode());
  }

  /**
   * Test {@link ProductBundlePricingModelType#equals(Object)}, and {@link
   * ProductBundlePricingModelType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductBundlePricingModelType#equals(Object)}
   *   <li>{@link ProductBundlePricingModelType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductBundlePricingModelType.equals(Object)",
    "int ProductBundlePricingModelType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ProductBundlePricingModelType productBundlePricingModelType =
        ProductBundlePricingModelType.ITEM_SUM;
    ProductBundlePricingModelType productBundlePricingModelType2 =
        new ProductBundlePricingModelType("ITEM_SUM", "ITEM_SUM");

    // Act and Assert
    assertEquals(productBundlePricingModelType, productBundlePricingModelType2);
    assertEquals(
        productBundlePricingModelType.hashCode(), productBundlePricingModelType2.hashCode());
  }

  /**
   * Test {@link ProductBundlePricingModelType#equals(Object)}, and {@link
   * ProductBundlePricingModelType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductBundlePricingModelType#equals(Object)}
   *   <li>{@link ProductBundlePricingModelType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductBundlePricingModelType.equals(Object)",
    "int ProductBundlePricingModelType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ProductBundlePricingModelType productBundlePricingModelType =
        new ProductBundlePricingModelType();
    ProductBundlePricingModelType productBundlePricingModelType2 =
        new ProductBundlePricingModelType();

    // Act and Assert
    assertEquals(productBundlePricingModelType, productBundlePricingModelType2);
    assertEquals(
        productBundlePricingModelType.hashCode(), productBundlePricingModelType2.hashCode());
  }

  /**
   * Test {@link ProductBundlePricingModelType#equals(Object)}, and {@link
   * ProductBundlePricingModelType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductBundlePricingModelType#equals(Object)}
   *   <li>{@link ProductBundlePricingModelType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductBundlePricingModelType.equals(Object)",
    "int ProductBundlePricingModelType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProductBundlePricingModelType productBundlePricingModelType =
        ProductBundlePricingModelType.BUNDLE;

    // Act and Assert
    assertEquals(productBundlePricingModelType, productBundlePricingModelType);
    int expectedHashCodeResult = productBundlePricingModelType.hashCode();
    assertEquals(expectedHashCodeResult, productBundlePricingModelType.hashCode());
  }

  /**
   * Test {@link ProductBundlePricingModelType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundlePricingModelType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductBundlePricingModelType.equals(Object)",
    "int ProductBundlePricingModelType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProductBundlePricingModelType.ITEM_SUM, ProductBundlePricingModelType.BUNDLE);
  }

  /**
   * Test {@link ProductBundlePricingModelType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundlePricingModelType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductBundlePricingModelType.equals(Object)",
    "int ProductBundlePricingModelType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new ProductBundlePricingModelType(), ProductBundlePricingModelType.BUNDLE);
  }

  /**
   * Test {@link ProductBundlePricingModelType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundlePricingModelType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductBundlePricingModelType.equals(Object)",
    "int ProductBundlePricingModelType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProductBundlePricingModelType.BUNDLE, null);
  }

  /**
   * Test {@link ProductBundlePricingModelType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundlePricingModelType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductBundlePricingModelType.equals(Object)",
    "int ProductBundlePricingModelType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ProductBundlePricingModelType.BUNDLE, "Different type to ProductBundlePricingModelType");
  }
}

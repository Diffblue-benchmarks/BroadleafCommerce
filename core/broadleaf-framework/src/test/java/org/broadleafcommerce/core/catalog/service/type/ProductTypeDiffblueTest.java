package org.broadleafcommerce.core.catalog.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ProductTypeDiffblueTest {
  /**
   * Test {@link ProductType#getInstance(String)}.
   *
   * <p>Method under test: {@link ProductType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProductType ProductType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    ProductType actualInstance = ProductType.getInstance("Type");

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
   *   <li>{@link ProductType#ProductType()}
   *   <li>{@link ProductType#getFriendlyType()}
   *   <li>{@link ProductType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductType.<init>()",
    "void ProductType.<init>(String, String)",
    "String ProductType.getFriendlyType()",
    "String ProductType.getType()"
  })
  public void testGettersAndSetters_thenReturnFriendlyTypeIsNull() {
    // Arrange and Act
    ProductType actualProductType = new ProductType();
    String actualFriendlyType = actualProductType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualProductType.getType());
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
   *   <li>{@link ProductType#ProductType(String, String)}
   *   <li>{@link ProductType#getFriendlyType()}
   *   <li>{@link ProductType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductType.<init>()",
    "void ProductType.<init>(String, String)",
    "String ProductType.getFriendlyType()",
    "String ProductType.getType()"
  })
  public void testGettersAndSetters_whenType_thenReturnFriendlyType() {
    // Arrange and Act
    ProductType actualProductType = new ProductType("Type", "Friendly Type");
    String actualFriendlyType = actualProductType.getFriendlyType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", actualProductType.getType());
  }

  /**
   * Test {@link ProductType#equals(Object)}, and {@link ProductType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductType#equals(Object)}
   *   <li>{@link ProductType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductType.equals(Object)", "int ProductType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProductType productType = ProductType.BUNDLE;
    ProductType productType2 = ProductType.BUNDLE;

    // Act and Assert
    assertEquals(productType, productType2);
    assertEquals(productType.hashCode(), productType2.hashCode());
  }

  /**
   * Test {@link ProductType#equals(Object)}, and {@link ProductType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductType#equals(Object)}
   *   <li>{@link ProductType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductType.equals(Object)", "int ProductType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ProductType productType = ProductType.PRODUCT;
    ProductType productType2 =
        new ProductType(
            "org.broadleafcommerce.core.catalog.domain.Product",
            "org.broadleafcommerce.core.catalog.domain.Product");

    // Act and Assert
    assertEquals(productType, productType2);
    assertEquals(productType.hashCode(), productType2.hashCode());
  }

  /**
   * Test {@link ProductType#equals(Object)}, and {@link ProductType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductType#equals(Object)}
   *   <li>{@link ProductType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductType.equals(Object)", "int ProductType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ProductType productType = new ProductType();
    ProductType productType2 = new ProductType();

    // Act and Assert
    assertEquals(productType, productType2);
    assertEquals(productType.hashCode(), productType2.hashCode());
  }

  /**
   * Test {@link ProductType#equals(Object)}, and {@link ProductType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductType#equals(Object)}
   *   <li>{@link ProductType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductType.equals(Object)", "int ProductType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProductType productType = ProductType.BUNDLE;

    // Act and Assert
    assertEquals(productType, productType);
    int expectedHashCodeResult = productType.hashCode();
    assertEquals(expectedHashCodeResult, productType.hashCode());
  }

  /**
   * Test {@link ProductType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductType.equals(Object)", "int ProductType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProductType.PRODUCT, ProductType.BUNDLE);
  }

  /**
   * Test {@link ProductType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductType.equals(Object)", "int ProductType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new ProductType(), ProductType.BUNDLE);
  }

  /**
   * Test {@link ProductType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductType.equals(Object)", "int ProductType.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProductType.BUNDLE, null);
  }

  /**
   * Test {@link ProductType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductType.equals(Object)", "int ProductType.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProductType.BUNDLE, "Different type to ProductType");
  }
}

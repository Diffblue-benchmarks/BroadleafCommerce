package org.broadleafcommerce.core.catalog.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ProductOptionValidationTypeDiffblueTest {
  /**
   * Test {@link ProductOptionValidationType#getInstance(String)}.
   *
   * <p>Method under test: {@link ProductOptionValidationType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProductOptionValidationType ProductOptionValidationType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    ProductOptionValidationType actualInstance = ProductOptionValidationType.getInstance("Type");

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
   *   <li>{@link ProductOptionValidationType#ProductOptionValidationType()}
   *   <li>{@link ProductOptionValidationType#getFriendlyType()}
   *   <li>{@link ProductOptionValidationType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductOptionValidationType.<init>()",
    "void ProductOptionValidationType.<init>(String, String)",
    "String ProductOptionValidationType.getFriendlyType()",
    "String ProductOptionValidationType.getType()"
  })
  public void testGettersAndSetters_thenReturnFriendlyTypeIsNull() {
    // Arrange and Act
    ProductOptionValidationType actualProductOptionValidationType =
        new ProductOptionValidationType();
    String actualFriendlyType = actualProductOptionValidationType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualProductOptionValidationType.getType());
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
   *   <li>{@link ProductOptionValidationType#ProductOptionValidationType(String, String)}
   *   <li>{@link ProductOptionValidationType#getFriendlyType()}
   *   <li>{@link ProductOptionValidationType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductOptionValidationType.<init>()",
    "void ProductOptionValidationType.<init>(String, String)",
    "String ProductOptionValidationType.getFriendlyType()",
    "String ProductOptionValidationType.getType()"
  })
  public void testGettersAndSetters_whenType_thenReturnFriendlyType() {
    // Arrange and Act
    ProductOptionValidationType actualProductOptionValidationType =
        new ProductOptionValidationType("Type", "Friendly Type");
    String actualFriendlyType = actualProductOptionValidationType.getFriendlyType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", actualProductOptionValidationType.getType());
  }

  /**
   * Test {@link ProductOptionValidationType#equals(Object)}, and {@link
   * ProductOptionValidationType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionValidationType#equals(Object)}
   *   <li>{@link ProductOptionValidationType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValidationType.equals(Object)",
    "int ProductOptionValidationType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProductOptionValidationType productOptionValidationType = ProductOptionValidationType.REGEX;
    ProductOptionValidationType productOptionValidationType2 = ProductOptionValidationType.REGEX;

    // Act and Assert
    assertEquals(productOptionValidationType, productOptionValidationType2);
    assertEquals(productOptionValidationType.hashCode(), productOptionValidationType2.hashCode());
  }

  /**
   * Test {@link ProductOptionValidationType#equals(Object)}, and {@link
   * ProductOptionValidationType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionValidationType#equals(Object)}
   *   <li>{@link ProductOptionValidationType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValidationType.equals(Object)",
    "int ProductOptionValidationType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ProductOptionValidationType productOptionValidationType =
        new ProductOptionValidationType("Type", "Friendly Type");
    ProductOptionValidationType productOptionValidationType2 =
        new ProductOptionValidationType("Type", "Type");

    // Act and Assert
    assertEquals(productOptionValidationType, productOptionValidationType2);
    assertEquals(productOptionValidationType.hashCode(), productOptionValidationType2.hashCode());
  }

  /**
   * Test {@link ProductOptionValidationType#equals(Object)}, and {@link
   * ProductOptionValidationType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionValidationType#equals(Object)}
   *   <li>{@link ProductOptionValidationType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValidationType.equals(Object)",
    "int ProductOptionValidationType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ProductOptionValidationType productOptionValidationType = new ProductOptionValidationType();
    ProductOptionValidationType productOptionValidationType2 = new ProductOptionValidationType();

    // Act and Assert
    assertEquals(productOptionValidationType, productOptionValidationType2);
    assertEquals(productOptionValidationType.hashCode(), productOptionValidationType2.hashCode());
  }

  /**
   * Test {@link ProductOptionValidationType#equals(Object)}, and {@link
   * ProductOptionValidationType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionValidationType#equals(Object)}
   *   <li>{@link ProductOptionValidationType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValidationType.equals(Object)",
    "int ProductOptionValidationType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProductOptionValidationType productOptionValidationType = ProductOptionValidationType.REGEX;

    // Act and Assert
    assertEquals(productOptionValidationType, productOptionValidationType);
    int expectedHashCodeResult = productOptionValidationType.hashCode();
    assertEquals(expectedHashCodeResult, productOptionValidationType.hashCode());
  }

  /**
   * Test {@link ProductOptionValidationType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValidationType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValidationType.equals(Object)",
    "int ProductOptionValidationType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ProductOptionValidationType("Type", "Friendly Type"),
        ProductOptionValidationType.REGEX);
  }

  /**
   * Test {@link ProductOptionValidationType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValidationType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValidationType.equals(Object)",
    "int ProductOptionValidationType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new ProductOptionValidationType(), ProductOptionValidationType.REGEX);
  }

  /**
   * Test {@link ProductOptionValidationType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValidationType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValidationType.equals(Object)",
    "int ProductOptionValidationType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProductOptionValidationType.REGEX, null);
  }

  /**
   * Test {@link ProductOptionValidationType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValidationType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValidationType.equals(Object)",
    "int ProductOptionValidationType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ProductOptionValidationType.REGEX, "Different type to ProductOptionValidationType");
  }
}

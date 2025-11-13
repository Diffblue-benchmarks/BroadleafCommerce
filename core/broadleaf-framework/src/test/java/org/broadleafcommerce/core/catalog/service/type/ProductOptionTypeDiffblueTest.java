package org.broadleafcommerce.core.catalog.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ProductOptionTypeDiffblueTest {
  /**
   * Test {@link ProductOptionType#getInstance(String)}.
   *
   * <p>Method under test: {@link ProductOptionType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProductOptionType ProductOptionType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    ProductOptionType actualInstance = ProductOptionType.getInstance("Type");

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
   *   <li>{@link ProductOptionType#ProductOptionType()}
   *   <li>{@link ProductOptionType#getFriendlyType()}
   *   <li>{@link ProductOptionType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductOptionType.<init>()",
    "void ProductOptionType.<init>(String, String)",
    "String ProductOptionType.getFriendlyType()",
    "String ProductOptionType.getType()"
  })
  public void testGettersAndSetters_thenReturnFriendlyTypeIsNull() {
    // Arrange and Act
    ProductOptionType actualProductOptionType = new ProductOptionType();
    String actualFriendlyType = actualProductOptionType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualProductOptionType.getType());
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
   *   <li>{@link ProductOptionType#ProductOptionType(String, String)}
   *   <li>{@link ProductOptionType#getFriendlyType()}
   *   <li>{@link ProductOptionType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductOptionType.<init>()",
    "void ProductOptionType.<init>(String, String)",
    "String ProductOptionType.getFriendlyType()",
    "String ProductOptionType.getType()"
  })
  public void testGettersAndSetters_whenType_thenReturnFriendlyType() {
    // Arrange and Act
    ProductOptionType actualProductOptionType = new ProductOptionType("Type", "Friendly Type");
    String actualFriendlyType = actualProductOptionType.getFriendlyType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", actualProductOptionType.getType());
  }

  /**
   * Test {@link ProductOptionType#equals(Object)}, and {@link ProductOptionType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionType#equals(Object)}
   *   <li>{@link ProductOptionType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionType.equals(Object)",
    "int ProductOptionType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProductOptionType productOptionType = ProductOptionType.BOOLEAN;
    ProductOptionType productOptionType2 = ProductOptionType.BOOLEAN;

    // Act and Assert
    assertEquals(productOptionType, productOptionType2);
    assertEquals(productOptionType.hashCode(), productOptionType2.hashCode());
  }

  /**
   * Test {@link ProductOptionType#equals(Object)}, and {@link ProductOptionType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionType#equals(Object)}
   *   <li>{@link ProductOptionType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionType.equals(Object)",
    "int ProductOptionType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ProductOptionType productOptionType = ProductOptionType.COLOR;
    ProductOptionType productOptionType2 = new ProductOptionType("COLOR", "COLOR");

    // Act and Assert
    assertEquals(productOptionType, productOptionType2);
    assertEquals(productOptionType.hashCode(), productOptionType2.hashCode());
  }

  /**
   * Test {@link ProductOptionType#equals(Object)}, and {@link ProductOptionType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionType#equals(Object)}
   *   <li>{@link ProductOptionType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionType.equals(Object)",
    "int ProductOptionType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ProductOptionType productOptionType = new ProductOptionType();
    ProductOptionType productOptionType2 = new ProductOptionType();

    // Act and Assert
    assertEquals(productOptionType, productOptionType2);
    assertEquals(productOptionType.hashCode(), productOptionType2.hashCode());
  }

  /**
   * Test {@link ProductOptionType#equals(Object)}, and {@link ProductOptionType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionType#equals(Object)}
   *   <li>{@link ProductOptionType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionType.equals(Object)",
    "int ProductOptionType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProductOptionType productOptionType = ProductOptionType.BOOLEAN;

    // Act and Assert
    assertEquals(productOptionType, productOptionType);
    int expectedHashCodeResult = productOptionType.hashCode();
    assertEquals(expectedHashCodeResult, productOptionType.hashCode());
  }

  /**
   * Test {@link ProductOptionType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionType.equals(Object)",
    "int ProductOptionType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProductOptionType.COLOR, ProductOptionType.BOOLEAN);
  }

  /**
   * Test {@link ProductOptionType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionType.equals(Object)",
    "int ProductOptionType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new ProductOptionType(), ProductOptionType.BOOLEAN);
  }

  /**
   * Test {@link ProductOptionType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionType.equals(Object)",
    "int ProductOptionType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProductOptionType.BOOLEAN, null);
  }

  /**
   * Test {@link ProductOptionType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionType.equals(Object)",
    "int ProductOptionType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProductOptionType.BOOLEAN, "Different type to ProductOptionType");
  }
}

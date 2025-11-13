package org.broadleafcommerce.core.catalog.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ProductOptionValidationStrategyTypeDiffblueTest {
  /**
   * Test {@link ProductOptionValidationStrategyType#getInstance(String)}.
   *
   * <p>Method under test: {@link ProductOptionValidationStrategyType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProductOptionValidationStrategyType ProductOptionValidationStrategyType.getInstance(String)"
  })
  public void testGetInstance() {
    // Arrange and Act
    ProductOptionValidationStrategyType actualInstance =
        ProductOptionValidationStrategyType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
    assertEquals(1, actualInstance.getRank().intValue());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return Rank is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionValidationStrategyType#ProductOptionValidationStrategyType()}
   *   <li>{@link ProductOptionValidationStrategyType#getFriendlyType()}
   *   <li>{@link ProductOptionValidationStrategyType#getRank()}
   *   <li>{@link ProductOptionValidationStrategyType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductOptionValidationStrategyType.<init>()",
    "void ProductOptionValidationStrategyType.<init>(String, Integer, String)",
    "String ProductOptionValidationStrategyType.getFriendlyType()",
    "Integer ProductOptionValidationStrategyType.getRank()",
    "String ProductOptionValidationStrategyType.getType()"
  })
  public void testGettersAndSetters_thenReturnRankIsNull() {
    // Arrange and Act
    ProductOptionValidationStrategyType actualProductOptionValidationStrategyType =
        new ProductOptionValidationStrategyType();
    String actualFriendlyType = actualProductOptionValidationStrategyType.getFriendlyType();
    Integer actualRank = actualProductOptionValidationStrategyType.getRank();

    // Assert
    assertNull(actualRank);
    assertNull(actualFriendlyType);
    assertNull(actualProductOptionValidationStrategyType.getType());
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
   *   <li>{@link ProductOptionValidationStrategyType#ProductOptionValidationStrategyType(String,
   *       Integer, String)}
   *   <li>{@link ProductOptionValidationStrategyType#getFriendlyType()}
   *   <li>{@link ProductOptionValidationStrategyType#getRank()}
   *   <li>{@link ProductOptionValidationStrategyType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductOptionValidationStrategyType.<init>()",
    "void ProductOptionValidationStrategyType.<init>(String, Integer, String)",
    "String ProductOptionValidationStrategyType.getFriendlyType()",
    "Integer ProductOptionValidationStrategyType.getRank()",
    "String ProductOptionValidationStrategyType.getType()"
  })
  public void testGettersAndSetters_whenType_thenReturnFriendlyType() {
    // Arrange and Act
    ProductOptionValidationStrategyType actualProductOptionValidationStrategyType =
        new ProductOptionValidationStrategyType("Type", 1, "Friendly Type");
    String actualFriendlyType = actualProductOptionValidationStrategyType.getFriendlyType();
    Integer actualRank = actualProductOptionValidationStrategyType.getRank();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", actualProductOptionValidationStrategyType.getType());
    assertEquals(1, actualRank.intValue());
  }

  /**
   * Test {@link ProductOptionValidationStrategyType#equals(Object)}, and {@link
   * ProductOptionValidationStrategyType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionValidationStrategyType#equals(Object)}
   *   <li>{@link ProductOptionValidationStrategyType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValidationStrategyType.equals(Object)",
    "int ProductOptionValidationStrategyType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProductOptionValidationStrategyType productOptionValidationStrategyType =
        ProductOptionValidationStrategyType.ADD_ITEM;
    ProductOptionValidationStrategyType productOptionValidationStrategyType2 =
        ProductOptionValidationStrategyType.ADD_ITEM;

    // Act and Assert
    assertEquals(productOptionValidationStrategyType, productOptionValidationStrategyType2);
    assertEquals(
        productOptionValidationStrategyType.hashCode(),
        productOptionValidationStrategyType2.hashCode());
  }

  /**
   * Test {@link ProductOptionValidationStrategyType#equals(Object)}, and {@link
   * ProductOptionValidationStrategyType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionValidationStrategyType#equals(Object)}
   *   <li>{@link ProductOptionValidationStrategyType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValidationStrategyType.equals(Object)",
    "int ProductOptionValidationStrategyType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ProductOptionValidationStrategyType productOptionValidationStrategyType =
        ProductOptionValidationStrategyType.NONE;
    ProductOptionValidationStrategyType productOptionValidationStrategyType2 =
        new ProductOptionValidationStrategyType("NONE", 1, "NONE");

    // Act and Assert
    assertEquals(productOptionValidationStrategyType, productOptionValidationStrategyType2);
    assertEquals(
        productOptionValidationStrategyType.hashCode(),
        productOptionValidationStrategyType2.hashCode());
  }

  /**
   * Test {@link ProductOptionValidationStrategyType#equals(Object)}, and {@link
   * ProductOptionValidationStrategyType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionValidationStrategyType#equals(Object)}
   *   <li>{@link ProductOptionValidationStrategyType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValidationStrategyType.equals(Object)",
    "int ProductOptionValidationStrategyType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ProductOptionValidationStrategyType productOptionValidationStrategyType =
        new ProductOptionValidationStrategyType();
    ProductOptionValidationStrategyType productOptionValidationStrategyType2 =
        new ProductOptionValidationStrategyType();

    // Act and Assert
    assertEquals(productOptionValidationStrategyType, productOptionValidationStrategyType2);
    assertEquals(
        productOptionValidationStrategyType.hashCode(),
        productOptionValidationStrategyType2.hashCode());
  }

  /**
   * Test {@link ProductOptionValidationStrategyType#equals(Object)}, and {@link
   * ProductOptionValidationStrategyType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionValidationStrategyType#equals(Object)}
   *   <li>{@link ProductOptionValidationStrategyType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValidationStrategyType.equals(Object)",
    "int ProductOptionValidationStrategyType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProductOptionValidationStrategyType productOptionValidationStrategyType =
        ProductOptionValidationStrategyType.ADD_ITEM;

    // Act and Assert
    assertEquals(productOptionValidationStrategyType, productOptionValidationStrategyType);
    int expectedHashCodeResult = productOptionValidationStrategyType.hashCode();
    assertEquals(expectedHashCodeResult, productOptionValidationStrategyType.hashCode());
  }

  /**
   * Test {@link ProductOptionValidationStrategyType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValidationStrategyType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValidationStrategyType.equals(Object)",
    "int ProductOptionValidationStrategyType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ProductOptionValidationStrategyType.NONE, ProductOptionValidationStrategyType.ADD_ITEM);
  }

  /**
   * Test {@link ProductOptionValidationStrategyType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValidationStrategyType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValidationStrategyType.equals(Object)",
    "int ProductOptionValidationStrategyType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ProductOptionValidationStrategyType(), ProductOptionValidationStrategyType.ADD_ITEM);
  }

  /**
   * Test {@link ProductOptionValidationStrategyType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValidationStrategyType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValidationStrategyType.equals(Object)",
    "int ProductOptionValidationStrategyType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProductOptionValidationStrategyType.ADD_ITEM, null);
  }

  /**
   * Test {@link ProductOptionValidationStrategyType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValidationStrategyType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValidationStrategyType.equals(Object)",
    "int ProductOptionValidationStrategyType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ProductOptionValidationStrategyType.ADD_ITEM,
        "Different type to ProductOptionValidationStrategyType");
  }
}

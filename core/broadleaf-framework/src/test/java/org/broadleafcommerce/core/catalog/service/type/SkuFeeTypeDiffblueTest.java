package org.broadleafcommerce.core.catalog.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SkuFeeTypeDiffblueTest {
  /**
   * Test {@link SkuFeeType#getInstance(String)}.
   *
   * <p>Method under test: {@link SkuFeeType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SkuFeeType SkuFeeType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    SkuFeeType actualInstance = SkuFeeType.getInstance("Type");

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
   *   <li>{@link SkuFeeType#SkuFeeType()}
   *   <li>{@link SkuFeeType#getFriendlyType()}
   *   <li>{@link SkuFeeType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SkuFeeType.<init>()",
    "void SkuFeeType.<init>(String, String)",
    "String SkuFeeType.getFriendlyType()",
    "String SkuFeeType.getType()"
  })
  public void testGettersAndSetters_thenReturnFriendlyTypeIsNull() {
    // Arrange and Act
    SkuFeeType actualSkuFeeType = new SkuFeeType();
    String actualFriendlyType = actualSkuFeeType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualSkuFeeType.getType());
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
   *   <li>{@link SkuFeeType#SkuFeeType(String, String)}
   *   <li>{@link SkuFeeType#getFriendlyType()}
   *   <li>{@link SkuFeeType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SkuFeeType.<init>()",
    "void SkuFeeType.<init>(String, String)",
    "String SkuFeeType.getFriendlyType()",
    "String SkuFeeType.getType()"
  })
  public void testGettersAndSetters_whenType_thenReturnFriendlyType() {
    // Arrange and Act
    SkuFeeType actualSkuFeeType = new SkuFeeType("Type", "Friendly Type");
    String actualFriendlyType = actualSkuFeeType.getFriendlyType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", actualSkuFeeType.getType());
  }

  /**
   * Test {@link SkuFeeType#equals(Object)}, and {@link SkuFeeType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuFeeType#equals(Object)}
   *   <li>{@link SkuFeeType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuFeeType.equals(Object)", "int SkuFeeType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SkuFeeType skuFeeType = SkuFeeType.FULFILLMENT;
    SkuFeeType skuFeeType2 = SkuFeeType.FULFILLMENT;

    // Act and Assert
    assertEquals(skuFeeType, skuFeeType2);
    assertEquals(skuFeeType.hashCode(), skuFeeType2.hashCode());
  }

  /**
   * Test {@link SkuFeeType#equals(Object)}, and {@link SkuFeeType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuFeeType#equals(Object)}
   *   <li>{@link SkuFeeType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuFeeType.equals(Object)", "int SkuFeeType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SkuFeeType skuFeeType = new SkuFeeType("Type", "Friendly Type");
    SkuFeeType skuFeeType2 = new SkuFeeType("Type", "Type");

    // Act and Assert
    assertEquals(skuFeeType, skuFeeType2);
    assertEquals(skuFeeType.hashCode(), skuFeeType2.hashCode());
  }

  /**
   * Test {@link SkuFeeType#equals(Object)}, and {@link SkuFeeType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuFeeType#equals(Object)}
   *   <li>{@link SkuFeeType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuFeeType.equals(Object)", "int SkuFeeType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    SkuFeeType skuFeeType = new SkuFeeType();
    SkuFeeType skuFeeType2 = new SkuFeeType();

    // Act and Assert
    assertEquals(skuFeeType, skuFeeType2);
    assertEquals(skuFeeType.hashCode(), skuFeeType2.hashCode());
  }

  /**
   * Test {@link SkuFeeType#equals(Object)}, and {@link SkuFeeType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuFeeType#equals(Object)}
   *   <li>{@link SkuFeeType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuFeeType.equals(Object)", "int SkuFeeType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SkuFeeType skuFeeType = SkuFeeType.FULFILLMENT;

    // Act and Assert
    assertEquals(skuFeeType, skuFeeType);
    int expectedHashCodeResult = skuFeeType.hashCode();
    assertEquals(expectedHashCodeResult, skuFeeType.hashCode());
  }

  /**
   * Test {@link SkuFeeType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuFeeType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuFeeType.equals(Object)", "int SkuFeeType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SkuFeeType("Type", "Friendly Type"), SkuFeeType.FULFILLMENT);
  }

  /**
   * Test {@link SkuFeeType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuFeeType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuFeeType.equals(Object)", "int SkuFeeType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new SkuFeeType(), SkuFeeType.FULFILLMENT);
  }

  /**
   * Test {@link SkuFeeType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuFeeType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuFeeType.equals(Object)", "int SkuFeeType.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SkuFeeType.FULFILLMENT, null);
  }

  /**
   * Test {@link SkuFeeType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuFeeType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuFeeType.equals(Object)", "int SkuFeeType.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SkuFeeType.FULFILLMENT, "Different type to SkuFeeType");
  }
}

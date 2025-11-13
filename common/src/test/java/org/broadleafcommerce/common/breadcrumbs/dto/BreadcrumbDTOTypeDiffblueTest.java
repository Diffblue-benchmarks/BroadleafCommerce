package org.broadleafcommerce.common.breadcrumbs.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BreadcrumbDTOTypeDiffblueTest {
  /**
   * Test {@link BreadcrumbDTOType#getInstance(String)}.
   *
   * <p>Method under test: {@link BreadcrumbDTOType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BreadcrumbDTOType BreadcrumbDTOType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    BreadcrumbDTOType actualInstance = BreadcrumbDTOType.getInstance("Type");

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
   *   <li>{@link BreadcrumbDTOType#BreadcrumbDTOType()}
   *   <li>{@link BreadcrumbDTOType#getFriendlyType()}
   *   <li>{@link BreadcrumbDTOType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BreadcrumbDTOType.<init>()",
    "void BreadcrumbDTOType.<init>(String, String)",
    "String BreadcrumbDTOType.getFriendlyType()",
    "String BreadcrumbDTOType.getType()"
  })
  public void testGettersAndSetters_thenReturnFriendlyTypeIsNull() {
    // Arrange and Act
    BreadcrumbDTOType actualBreadcrumbDTOType = new BreadcrumbDTOType();
    String actualFriendlyType = actualBreadcrumbDTOType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualBreadcrumbDTOType.getType());
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
   *   <li>{@link BreadcrumbDTOType#BreadcrumbDTOType(String, String)}
   *   <li>{@link BreadcrumbDTOType#getFriendlyType()}
   *   <li>{@link BreadcrumbDTOType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BreadcrumbDTOType.<init>()",
    "void BreadcrumbDTOType.<init>(String, String)",
    "String BreadcrumbDTOType.getFriendlyType()",
    "String BreadcrumbDTOType.getType()"
  })
  public void testGettersAndSetters_whenType_thenReturnFriendlyType() {
    // Arrange and Act
    BreadcrumbDTOType actualBreadcrumbDTOType = new BreadcrumbDTOType("Type", "Friendly Type");
    String actualFriendlyType = actualBreadcrumbDTOType.getFriendlyType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", actualBreadcrumbDTOType.getType());
  }

  /**
   * Test {@link BreadcrumbDTOType#equals(Object)}, and {@link BreadcrumbDTOType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BreadcrumbDTOType#equals(Object)}
   *   <li>{@link BreadcrumbDTOType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BreadcrumbDTOType.equals(Object)",
    "int BreadcrumbDTOType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BreadcrumbDTOType breadcrumbDTOType = BreadcrumbDTOType.CATEGORY;
    BreadcrumbDTOType breadcrumbDTOType2 = BreadcrumbDTOType.CATEGORY;

    // Act and Assert
    assertEquals(breadcrumbDTOType, breadcrumbDTOType2);
    assertEquals(breadcrumbDTOType.hashCode(), breadcrumbDTOType2.hashCode());
  }

  /**
   * Test {@link BreadcrumbDTOType#equals(Object)}, and {@link BreadcrumbDTOType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BreadcrumbDTOType#equals(Object)}
   *   <li>{@link BreadcrumbDTOType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BreadcrumbDTOType.equals(Object)",
    "int BreadcrumbDTOType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    BreadcrumbDTOType breadcrumbDTOType = BreadcrumbDTOType.HOME;
    BreadcrumbDTOType breadcrumbDTOType2 = new BreadcrumbDTOType("HOME", "HOME");

    // Act and Assert
    assertEquals(breadcrumbDTOType, breadcrumbDTOType2);
    assertEquals(breadcrumbDTOType.hashCode(), breadcrumbDTOType2.hashCode());
  }

  /**
   * Test {@link BreadcrumbDTOType#equals(Object)}, and {@link BreadcrumbDTOType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BreadcrumbDTOType#equals(Object)}
   *   <li>{@link BreadcrumbDTOType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BreadcrumbDTOType.equals(Object)",
    "int BreadcrumbDTOType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    BreadcrumbDTOType breadcrumbDTOType = new BreadcrumbDTOType();
    BreadcrumbDTOType breadcrumbDTOType2 = new BreadcrumbDTOType();

    // Act and Assert
    assertEquals(breadcrumbDTOType, breadcrumbDTOType2);
    assertEquals(breadcrumbDTOType.hashCode(), breadcrumbDTOType2.hashCode());
  }

  /**
   * Test {@link BreadcrumbDTOType#equals(Object)}, and {@link BreadcrumbDTOType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BreadcrumbDTOType#equals(Object)}
   *   <li>{@link BreadcrumbDTOType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BreadcrumbDTOType.equals(Object)",
    "int BreadcrumbDTOType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BreadcrumbDTOType breadcrumbDTOType = BreadcrumbDTOType.CATEGORY;

    // Act and Assert
    assertEquals(breadcrumbDTOType, breadcrumbDTOType);
    int expectedHashCodeResult = breadcrumbDTOType.hashCode();
    assertEquals(expectedHashCodeResult, breadcrumbDTOType.hashCode());
  }

  /**
   * Test {@link BreadcrumbDTOType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BreadcrumbDTOType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BreadcrumbDTOType.equals(Object)",
    "int BreadcrumbDTOType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BreadcrumbDTOType.HOME, BreadcrumbDTOType.CATEGORY);
  }

  /**
   * Test {@link BreadcrumbDTOType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BreadcrumbDTOType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BreadcrumbDTOType.equals(Object)",
    "int BreadcrumbDTOType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new BreadcrumbDTOType(), BreadcrumbDTOType.CATEGORY);
  }

  /**
   * Test {@link BreadcrumbDTOType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BreadcrumbDTOType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BreadcrumbDTOType.equals(Object)",
    "int BreadcrumbDTOType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BreadcrumbDTOType.CATEGORY, null);
  }

  /**
   * Test {@link BreadcrumbDTOType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BreadcrumbDTOType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BreadcrumbDTOType.equals(Object)",
    "int BreadcrumbDTOType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BreadcrumbDTOType.CATEGORY, "Different type to BreadcrumbDTOType");
  }
}

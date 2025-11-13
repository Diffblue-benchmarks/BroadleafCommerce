package org.broadleafcommerce.openadmin.server.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ContextTypeDiffblueTest {
  /**
   * Test {@link ContextType#getInstance(String)}.
   *
   * <p>Method under test: {@link ContextType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ContextType ContextType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    ContextType actualInstance = ContextType.getInstance("Type");

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
   *   <li>{@link ContextType#ContextType()}
   *   <li>{@link ContextType#getFriendlyType()}
   *   <li>{@link ContextType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ContextType.<init>()",
    "void ContextType.<init>(String, String)",
    "String ContextType.getFriendlyType()",
    "String ContextType.getType()"
  })
  public void testGettersAndSetters_thenReturnFriendlyTypeIsNull() {
    // Arrange and Act
    ContextType actualContextType = new ContextType();
    String actualFriendlyType = actualContextType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualContextType.getType());
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
   *   <li>{@link ContextType#ContextType(String, String)}
   *   <li>{@link ContextType#getFriendlyType()}
   *   <li>{@link ContextType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ContextType.<init>()",
    "void ContextType.<init>(String, String)",
    "String ContextType.getFriendlyType()",
    "String ContextType.getType()"
  })
  public void testGettersAndSetters_whenType_thenReturnFriendlyType() {
    // Arrange and Act
    ContextType actualContextType = new ContextType("Type", "Friendly Type");
    String actualFriendlyType = actualContextType.getFriendlyType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", actualContextType.getType());
  }

  /**
   * Test {@link ContextType#equals(Object)}, and {@link ContextType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ContextType#equals(Object)}
   *   <li>{@link ContextType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ContextType.equals(Object)", "int ContextType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ContextType contextType = ContextType.CATALOG;
    ContextType contextType2 = ContextType.CATALOG;

    // Act and Assert
    assertEquals(contextType, contextType2);
    assertEquals(contextType.hashCode(), contextType2.hashCode());
  }

  /**
   * Test {@link ContextType#equals(Object)}, and {@link ContextType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ContextType#equals(Object)}
   *   <li>{@link ContextType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ContextType.equals(Object)", "int ContextType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ContextType contextType = ContextType.GLOBAL;
    ContextType contextType2 = new ContextType("GLOBAL", "GLOBAL");

    // Act and Assert
    assertEquals(contextType, contextType2);
    assertEquals(contextType.hashCode(), contextType2.hashCode());
  }

  /**
   * Test {@link ContextType#equals(Object)}, and {@link ContextType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ContextType#equals(Object)}
   *   <li>{@link ContextType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ContextType.equals(Object)", "int ContextType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ContextType contextType = new ContextType();
    ContextType contextType2 = new ContextType();

    // Act and Assert
    assertEquals(contextType, contextType2);
    assertEquals(contextType.hashCode(), contextType2.hashCode());
  }

  /**
   * Test {@link ContextType#equals(Object)}, and {@link ContextType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ContextType#equals(Object)}
   *   <li>{@link ContextType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ContextType.equals(Object)", "int ContextType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ContextType contextType = ContextType.CATALOG;

    // Act and Assert
    assertEquals(contextType, contextType);
    int expectedHashCodeResult = contextType.hashCode();
    assertEquals(expectedHashCodeResult, contextType.hashCode());
  }

  /**
   * Test {@link ContextType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ContextType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ContextType.equals(Object)", "int ContextType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ContextType.GLOBAL, ContextType.CATALOG);
  }

  /**
   * Test {@link ContextType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ContextType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ContextType.equals(Object)", "int ContextType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new ContextType(), ContextType.CATALOG);
  }

  /**
   * Test {@link ContextType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ContextType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ContextType.equals(Object)", "int ContextType.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ContextType.CATALOG, null);
  }

  /**
   * Test {@link ContextType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ContextType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ContextType.equals(Object)", "int ContextType.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ContextType.CATALOG, "Different type to ContextType");
  }
}

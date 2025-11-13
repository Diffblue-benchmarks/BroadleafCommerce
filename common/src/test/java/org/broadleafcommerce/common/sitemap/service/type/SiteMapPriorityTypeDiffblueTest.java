package org.broadleafcommerce.common.sitemap.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SiteMapPriorityTypeDiffblueTest {
  /**
   * Test {@link SiteMapPriorityType#getInstance(String)}.
   *
   * <p>Method under test: {@link SiteMapPriorityType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SiteMapPriorityType SiteMapPriorityType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    SiteMapPriorityType actualInstance = SiteMapPriorityType.getInstance("Type");

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
   *   <li>{@link SiteMapPriorityType#SiteMapPriorityType()}
   *   <li>{@link SiteMapPriorityType#getFriendlyType()}
   *   <li>{@link SiteMapPriorityType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SiteMapPriorityType.<init>()",
    "void SiteMapPriorityType.<init>(String, String)",
    "String SiteMapPriorityType.getFriendlyType()",
    "String SiteMapPriorityType.getType()"
  })
  public void testGettersAndSetters_thenReturnFriendlyTypeIsNull() {
    // Arrange and Act
    SiteMapPriorityType actualSiteMapPriorityType = new SiteMapPriorityType();
    String actualFriendlyType = actualSiteMapPriorityType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualSiteMapPriorityType.getType());
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
   *   <li>{@link SiteMapPriorityType#SiteMapPriorityType(String, String)}
   *   <li>{@link SiteMapPriorityType#getFriendlyType()}
   *   <li>{@link SiteMapPriorityType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SiteMapPriorityType.<init>()",
    "void SiteMapPriorityType.<init>(String, String)",
    "String SiteMapPriorityType.getFriendlyType()",
    "String SiteMapPriorityType.getType()"
  })
  public void testGettersAndSetters_whenType_thenReturnFriendlyType() {
    // Arrange and Act
    SiteMapPriorityType actualSiteMapPriorityType =
        new SiteMapPriorityType("Type", "Friendly Type");
    String actualFriendlyType = actualSiteMapPriorityType.getFriendlyType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", actualSiteMapPriorityType.getType());
  }

  /**
   * Test {@link SiteMapPriorityType#equals(Object)}, and {@link SiteMapPriorityType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SiteMapPriorityType#equals(Object)}
   *   <li>{@link SiteMapPriorityType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SiteMapPriorityType.equals(Object)",
    "int SiteMapPriorityType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SiteMapPriorityType siteMapPriorityType = SiteMapPriorityType.ONE;
    SiteMapPriorityType siteMapPriorityType2 = SiteMapPriorityType.ONE;

    // Act and Assert
    assertEquals(siteMapPriorityType, siteMapPriorityType2);
    assertEquals(siteMapPriorityType.hashCode(), siteMapPriorityType2.hashCode());
  }

  /**
   * Test {@link SiteMapPriorityType#equals(Object)}, and {@link SiteMapPriorityType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SiteMapPriorityType#equals(Object)}
   *   <li>{@link SiteMapPriorityType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SiteMapPriorityType.equals(Object)",
    "int SiteMapPriorityType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SiteMapPriorityType siteMapPriorityType = SiteMapPriorityType.POINT1;
    SiteMapPriorityType siteMapPriorityType2 = new SiteMapPriorityType("0.1", "0.1");

    // Act and Assert
    assertEquals(siteMapPriorityType, siteMapPriorityType2);
    assertEquals(siteMapPriorityType.hashCode(), siteMapPriorityType2.hashCode());
  }

  /**
   * Test {@link SiteMapPriorityType#equals(Object)}, and {@link SiteMapPriorityType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SiteMapPriorityType#equals(Object)}
   *   <li>{@link SiteMapPriorityType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SiteMapPriorityType.equals(Object)",
    "int SiteMapPriorityType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    SiteMapPriorityType siteMapPriorityType = new SiteMapPriorityType();
    SiteMapPriorityType siteMapPriorityType2 = new SiteMapPriorityType();

    // Act and Assert
    assertEquals(siteMapPriorityType, siteMapPriorityType2);
    assertEquals(siteMapPriorityType.hashCode(), siteMapPriorityType2.hashCode());
  }

  /**
   * Test {@link SiteMapPriorityType#equals(Object)}, and {@link SiteMapPriorityType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SiteMapPriorityType#equals(Object)}
   *   <li>{@link SiteMapPriorityType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SiteMapPriorityType.equals(Object)",
    "int SiteMapPriorityType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SiteMapPriorityType siteMapPriorityType = SiteMapPriorityType.ONE;

    // Act and Assert
    assertEquals(siteMapPriorityType, siteMapPriorityType);
    int expectedHashCodeResult = siteMapPriorityType.hashCode();
    assertEquals(expectedHashCodeResult, siteMapPriorityType.hashCode());
  }

  /**
   * Test {@link SiteMapPriorityType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SiteMapPriorityType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SiteMapPriorityType.equals(Object)",
    "int SiteMapPriorityType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SiteMapPriorityType.POINT1, SiteMapPriorityType.ONE);
  }

  /**
   * Test {@link SiteMapPriorityType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SiteMapPriorityType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SiteMapPriorityType.equals(Object)",
    "int SiteMapPriorityType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new SiteMapPriorityType(), SiteMapPriorityType.ONE);
  }

  /**
   * Test {@link SiteMapPriorityType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SiteMapPriorityType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SiteMapPriorityType.equals(Object)",
    "int SiteMapPriorityType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SiteMapPriorityType.ONE, null);
  }

  /**
   * Test {@link SiteMapPriorityType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SiteMapPriorityType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SiteMapPriorityType.equals(Object)",
    "int SiteMapPriorityType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SiteMapPriorityType.ONE, "Different type to SiteMapPriorityType");
  }
}

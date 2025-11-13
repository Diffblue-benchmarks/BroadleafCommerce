package org.broadleafcommerce.common.sitemap.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SiteMapGeneratorTypeDiffblueTest {
  /**
   * Test {@link SiteMapGeneratorType#getInstance(String)}.
   *
   * <p>Method under test: {@link SiteMapGeneratorType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SiteMapGeneratorType SiteMapGeneratorType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    SiteMapGeneratorType actualInstance = SiteMapGeneratorType.getInstance("Type");

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
   *   <li>{@link SiteMapGeneratorType#SiteMapGeneratorType()}
   *   <li>{@link SiteMapGeneratorType#getFriendlyType()}
   *   <li>{@link SiteMapGeneratorType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SiteMapGeneratorType.<init>()",
    "void SiteMapGeneratorType.<init>(String, String)",
    "String SiteMapGeneratorType.getFriendlyType()",
    "String SiteMapGeneratorType.getType()"
  })
  public void testGettersAndSetters_thenReturnFriendlyTypeIsNull() {
    // Arrange and Act
    SiteMapGeneratorType actualSiteMapGeneratorType = new SiteMapGeneratorType();
    String actualFriendlyType = actualSiteMapGeneratorType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualSiteMapGeneratorType.getType());
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
   *   <li>{@link SiteMapGeneratorType#SiteMapGeneratorType(String, String)}
   *   <li>{@link SiteMapGeneratorType#getFriendlyType()}
   *   <li>{@link SiteMapGeneratorType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SiteMapGeneratorType.<init>()",
    "void SiteMapGeneratorType.<init>(String, String)",
    "String SiteMapGeneratorType.getFriendlyType()",
    "String SiteMapGeneratorType.getType()"
  })
  public void testGettersAndSetters_whenType_thenReturnFriendlyType() {
    // Arrange and Act
    SiteMapGeneratorType actualSiteMapGeneratorType =
        new SiteMapGeneratorType("Type", "Friendly Type");
    String actualFriendlyType = actualSiteMapGeneratorType.getFriendlyType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", actualSiteMapGeneratorType.getType());
  }

  /**
   * Test {@link SiteMapGeneratorType#equals(Object)}, and {@link SiteMapGeneratorType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SiteMapGeneratorType#equals(Object)}
   *   <li>{@link SiteMapGeneratorType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SiteMapGeneratorType.equals(Object)",
    "int SiteMapGeneratorType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SiteMapGeneratorType siteMapGeneratorType = SiteMapGeneratorType.CATEGORY;
    SiteMapGeneratorType siteMapGeneratorType2 = SiteMapGeneratorType.CATEGORY;

    // Act and Assert
    assertEquals(siteMapGeneratorType, siteMapGeneratorType2);
    assertEquals(siteMapGeneratorType.hashCode(), siteMapGeneratorType2.hashCode());
  }

  /**
   * Test {@link SiteMapGeneratorType#equals(Object)}, and {@link SiteMapGeneratorType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SiteMapGeneratorType#equals(Object)}
   *   <li>{@link SiteMapGeneratorType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SiteMapGeneratorType.equals(Object)",
    "int SiteMapGeneratorType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SiteMapGeneratorType siteMapGeneratorType = SiteMapGeneratorType.CUSTOM;
    SiteMapGeneratorType siteMapGeneratorType2 = new SiteMapGeneratorType("CUSTOM", "CUSTOM");

    // Act and Assert
    assertEquals(siteMapGeneratorType, siteMapGeneratorType2);
    assertEquals(siteMapGeneratorType.hashCode(), siteMapGeneratorType2.hashCode());
  }

  /**
   * Test {@link SiteMapGeneratorType#equals(Object)}, and {@link SiteMapGeneratorType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SiteMapGeneratorType#equals(Object)}
   *   <li>{@link SiteMapGeneratorType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SiteMapGeneratorType.equals(Object)",
    "int SiteMapGeneratorType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    SiteMapGeneratorType siteMapGeneratorType = new SiteMapGeneratorType();
    SiteMapGeneratorType siteMapGeneratorType2 = new SiteMapGeneratorType();

    // Act and Assert
    assertEquals(siteMapGeneratorType, siteMapGeneratorType2);
    assertEquals(siteMapGeneratorType.hashCode(), siteMapGeneratorType2.hashCode());
  }

  /**
   * Test {@link SiteMapGeneratorType#equals(Object)}, and {@link SiteMapGeneratorType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SiteMapGeneratorType#equals(Object)}
   *   <li>{@link SiteMapGeneratorType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SiteMapGeneratorType.equals(Object)",
    "int SiteMapGeneratorType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SiteMapGeneratorType siteMapGeneratorType = SiteMapGeneratorType.CATEGORY;

    // Act and Assert
    assertEquals(siteMapGeneratorType, siteMapGeneratorType);
    int expectedHashCodeResult = siteMapGeneratorType.hashCode();
    assertEquals(expectedHashCodeResult, siteMapGeneratorType.hashCode());
  }

  /**
   * Test {@link SiteMapGeneratorType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SiteMapGeneratorType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SiteMapGeneratorType.equals(Object)",
    "int SiteMapGeneratorType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SiteMapGeneratorType.CUSTOM, SiteMapGeneratorType.CATEGORY);
  }

  /**
   * Test {@link SiteMapGeneratorType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SiteMapGeneratorType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SiteMapGeneratorType.equals(Object)",
    "int SiteMapGeneratorType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new SiteMapGeneratorType(), SiteMapGeneratorType.CATEGORY);
  }

  /**
   * Test {@link SiteMapGeneratorType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SiteMapGeneratorType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SiteMapGeneratorType.equals(Object)",
    "int SiteMapGeneratorType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SiteMapGeneratorType.CATEGORY, null);
  }

  /**
   * Test {@link SiteMapGeneratorType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SiteMapGeneratorType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SiteMapGeneratorType.equals(Object)",
    "int SiteMapGeneratorType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SiteMapGeneratorType.CATEGORY, "Different type to SiteMapGeneratorType");
  }
}

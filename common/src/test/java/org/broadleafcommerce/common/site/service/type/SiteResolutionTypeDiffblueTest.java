package org.broadleafcommerce.common.site.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SiteResolutionTypeDiffblueTest {
  /**
   * Test {@link SiteResolutionType#getInstance(String)}.
   *
   * <p>Method under test: {@link SiteResolutionType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SiteResolutionType SiteResolutionType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    SiteResolutionType actualInstance = SiteResolutionType.getInstance("Type");

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
   *   <li>{@link SiteResolutionType#SiteResolutionType()}
   *   <li>{@link SiteResolutionType#getFriendlyType()}
   *   <li>{@link SiteResolutionType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SiteResolutionType.<init>()",
    "void SiteResolutionType.<init>(String, String)",
    "String SiteResolutionType.getFriendlyType()",
    "String SiteResolutionType.getType()"
  })
  public void testGettersAndSetters_thenReturnFriendlyTypeIsNull() {
    // Arrange and Act
    SiteResolutionType actualSiteResolutionType = new SiteResolutionType();
    String actualFriendlyType = actualSiteResolutionType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualSiteResolutionType.getType());
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
   *   <li>{@link SiteResolutionType#SiteResolutionType(String, String)}
   *   <li>{@link SiteResolutionType#getFriendlyType()}
   *   <li>{@link SiteResolutionType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SiteResolutionType.<init>()",
    "void SiteResolutionType.<init>(String, String)",
    "String SiteResolutionType.getFriendlyType()",
    "String SiteResolutionType.getType()"
  })
  public void testGettersAndSetters_whenType_thenReturnFriendlyType() {
    // Arrange and Act
    SiteResolutionType actualSiteResolutionType = new SiteResolutionType("Type", "Friendly Type");
    String actualFriendlyType = actualSiteResolutionType.getFriendlyType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", actualSiteResolutionType.getType());
  }

  /**
   * Test {@link SiteResolutionType#equals(Object)}, and {@link SiteResolutionType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SiteResolutionType#equals(Object)}
   *   <li>{@link SiteResolutionType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SiteResolutionType.equals(Object)",
    "int SiteResolutionType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SiteResolutionType siteResolutionType = SiteResolutionType.DOMAIN;
    SiteResolutionType siteResolutionType2 = SiteResolutionType.DOMAIN;

    // Act and Assert
    assertEquals(siteResolutionType, siteResolutionType2);
    assertEquals(siteResolutionType.hashCode(), siteResolutionType2.hashCode());
  }

  /**
   * Test {@link SiteResolutionType#equals(Object)}, and {@link SiteResolutionType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SiteResolutionType#equals(Object)}
   *   <li>{@link SiteResolutionType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SiteResolutionType.equals(Object)",
    "int SiteResolutionType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SiteResolutionType siteResolutionType = SiteResolutionType.DOMAIN_PREFIX;
    SiteResolutionType siteResolutionType2 =
        new SiteResolutionType("DOMAIN_PREFIX", "DOMAIN_PREFIX");

    // Act and Assert
    assertEquals(siteResolutionType, siteResolutionType2);
    assertEquals(siteResolutionType.hashCode(), siteResolutionType2.hashCode());
  }

  /**
   * Test {@link SiteResolutionType#equals(Object)}, and {@link SiteResolutionType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SiteResolutionType#equals(Object)}
   *   <li>{@link SiteResolutionType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SiteResolutionType.equals(Object)",
    "int SiteResolutionType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    SiteResolutionType siteResolutionType = new SiteResolutionType();
    SiteResolutionType siteResolutionType2 = new SiteResolutionType();

    // Act and Assert
    assertEquals(siteResolutionType, siteResolutionType2);
    assertEquals(siteResolutionType.hashCode(), siteResolutionType2.hashCode());
  }

  /**
   * Test {@link SiteResolutionType#equals(Object)}, and {@link SiteResolutionType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SiteResolutionType#equals(Object)}
   *   <li>{@link SiteResolutionType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SiteResolutionType.equals(Object)",
    "int SiteResolutionType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SiteResolutionType siteResolutionType = SiteResolutionType.DOMAIN;

    // Act and Assert
    assertEquals(siteResolutionType, siteResolutionType);
    int expectedHashCodeResult = siteResolutionType.hashCode();
    assertEquals(expectedHashCodeResult, siteResolutionType.hashCode());
  }

  /**
   * Test {@link SiteResolutionType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SiteResolutionType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SiteResolutionType.equals(Object)",
    "int SiteResolutionType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SiteResolutionType.DOMAIN_PREFIX, SiteResolutionType.DOMAIN);
  }

  /**
   * Test {@link SiteResolutionType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SiteResolutionType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SiteResolutionType.equals(Object)",
    "int SiteResolutionType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new SiteResolutionType(), SiteResolutionType.DOMAIN);
  }

  /**
   * Test {@link SiteResolutionType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SiteResolutionType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SiteResolutionType.equals(Object)",
    "int SiteResolutionType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SiteResolutionType.DOMAIN, null);
  }

  /**
   * Test {@link SiteResolutionType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SiteResolutionType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SiteResolutionType.equals(Object)",
    "int SiteResolutionType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SiteResolutionType.DOMAIN, "Different type to SiteResolutionType");
  }
}

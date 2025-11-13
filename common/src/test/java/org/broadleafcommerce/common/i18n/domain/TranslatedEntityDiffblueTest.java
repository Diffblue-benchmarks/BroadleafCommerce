package org.broadleafcommerce.common.i18n.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TranslatedEntityDiffblueTest {
  /**
   * Test {@link TranslatedEntity#getInstanceFromFriendlyType(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TranslatedEntity#getInstanceFromFriendlyType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TranslatedEntity TranslatedEntity.getInstanceFromFriendlyType(String)"})
  public void testGetInstanceFromFriendlyType_when42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(TranslatedEntity.getInstanceFromFriendlyType("42"));
  }

  /**
   * Test {@link TranslatedEntity#equals(Object)}, and {@link TranslatedEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TranslatedEntity#equals(Object)}
   *   <li>{@link TranslatedEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TranslatedEntity.equals(Object)", "int TranslatedEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TranslatedEntity translatedEntity = TranslatedEntity.CATALOG;
    TranslatedEntity translatedEntity2 = TranslatedEntity.CATALOG;

    // Act and Assert
    assertEquals(translatedEntity, translatedEntity2);
    assertEquals(translatedEntity.hashCode(), translatedEntity2.hashCode());
  }

  /**
   * Test {@link TranslatedEntity#equals(Object)}, and {@link TranslatedEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TranslatedEntity#equals(Object)}
   *   <li>{@link TranslatedEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TranslatedEntity.equals(Object)", "int TranslatedEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TranslatedEntity translatedEntity = TranslatedEntity.CATEGORY;
    TranslatedEntity translatedEntity2 =
        new TranslatedEntity(
            "org.broadleafcommerce.core.catalog.domain.Category",
            "org.broadleafcommerce.core.catalog.domain.Category");

    // Act and Assert
    assertEquals(translatedEntity, translatedEntity2);
    assertEquals(translatedEntity.hashCode(), translatedEntity2.hashCode());
  }

  /**
   * Test {@link TranslatedEntity#equals(Object)}, and {@link TranslatedEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TranslatedEntity#equals(Object)}
   *   <li>{@link TranslatedEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TranslatedEntity.equals(Object)", "int TranslatedEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TranslatedEntity translatedEntity = new TranslatedEntity();
    TranslatedEntity translatedEntity2 = new TranslatedEntity();

    // Act and Assert
    assertEquals(translatedEntity, translatedEntity2);
    assertEquals(translatedEntity.hashCode(), translatedEntity2.hashCode());
  }

  /**
   * Test {@link TranslatedEntity#equals(Object)}, and {@link TranslatedEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TranslatedEntity#equals(Object)}
   *   <li>{@link TranslatedEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TranslatedEntity.equals(Object)", "int TranslatedEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TranslatedEntity translatedEntity = TranslatedEntity.CATALOG;

    // Act and Assert
    assertEquals(translatedEntity, translatedEntity);
    int expectedHashCodeResult = translatedEntity.hashCode();
    assertEquals(expectedHashCodeResult, translatedEntity.hashCode());
  }

  /**
   * Test {@link TranslatedEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TranslatedEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TranslatedEntity.equals(Object)", "int TranslatedEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TranslatedEntity.CATEGORY, TranslatedEntity.CATALOG);
  }

  /**
   * Test {@link TranslatedEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TranslatedEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TranslatedEntity.equals(Object)", "int TranslatedEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new TranslatedEntity(), TranslatedEntity.CATALOG);
  }

  /**
   * Test {@link TranslatedEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TranslatedEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TranslatedEntity.equals(Object)", "int TranslatedEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TranslatedEntity.CATALOG, null);
  }

  /**
   * Test {@link TranslatedEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TranslatedEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TranslatedEntity.equals(Object)", "int TranslatedEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TranslatedEntity.CATALOG, "Different type to TranslatedEntity");
  }
}

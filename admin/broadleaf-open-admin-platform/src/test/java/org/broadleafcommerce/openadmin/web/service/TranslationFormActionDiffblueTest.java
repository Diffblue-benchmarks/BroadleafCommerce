package org.broadleafcommerce.openadmin.web.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TranslationFormActionDiffblueTest {
  /**
   * Test {@link TranslationFormAction#equals(Object)}, and {@link
   * TranslationFormAction#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TranslationFormAction#equals(Object)}
   *   <li>{@link TranslationFormAction#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TranslationFormAction.equals(Object)",
    "int TranslationFormAction.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TranslationFormAction translationFormAction = TranslationFormAction.ADD;
    TranslationFormAction translationFormAction2 = TranslationFormAction.ADD;

    // Act and Assert
    assertEquals(translationFormAction, translationFormAction2);
    assertEquals(translationFormAction.hashCode(), translationFormAction2.hashCode());
  }

  /**
   * Test {@link TranslationFormAction#equals(Object)}, and {@link
   * TranslationFormAction#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TranslationFormAction#equals(Object)}
   *   <li>{@link TranslationFormAction#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TranslationFormAction.equals(Object)",
    "int TranslationFormAction.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TranslationFormAction translationFormAction = new TranslationFormAction();
    TranslationFormAction translationFormAction2 = new TranslationFormAction();

    // Act and Assert
    assertEquals(translationFormAction, translationFormAction2);
    assertEquals(translationFormAction.hashCode(), translationFormAction2.hashCode());
  }

  /**
   * Test {@link TranslationFormAction#equals(Object)}, and {@link
   * TranslationFormAction#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TranslationFormAction#equals(Object)}
   *   <li>{@link TranslationFormAction#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TranslationFormAction.equals(Object)",
    "int TranslationFormAction.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TranslationFormAction translationFormAction = TranslationFormAction.ADD;

    // Act and Assert
    assertEquals(translationFormAction, translationFormAction);
    int expectedHashCodeResult = translationFormAction.hashCode();
    assertEquals(expectedHashCodeResult, translationFormAction.hashCode());
  }

  /**
   * Test {@link TranslationFormAction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TranslationFormAction#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TranslationFormAction.equals(Object)",
    "int TranslationFormAction.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TranslationFormAction.OTHER, TranslationFormAction.ADD);
  }

  /**
   * Test {@link TranslationFormAction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TranslationFormAction#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TranslationFormAction.equals(Object)",
    "int TranslationFormAction.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new TranslationFormAction(), TranslationFormAction.ADD);
  }

  /**
   * Test {@link TranslationFormAction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TranslationFormAction#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TranslationFormAction.equals(Object)",
    "int TranslationFormAction.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TranslationFormAction.ADD, null);
  }

  /**
   * Test {@link TranslationFormAction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TranslationFormAction#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TranslationFormAction.equals(Object)",
    "int TranslationFormAction.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TranslationFormAction.ADD, "Different type to TranslationFormAction");
  }
}

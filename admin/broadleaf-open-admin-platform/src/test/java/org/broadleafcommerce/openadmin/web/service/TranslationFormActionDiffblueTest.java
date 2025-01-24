package org.broadleafcommerce.openadmin.web.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {TranslationFormAction.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class TranslationFormActionDiffblueTest {
  @Autowired
  private TranslationFormAction translationFormAction;

  /**
   * Test {@link TranslationFormAction#getInstance(String)}.
   * <p>
   * Method under test: {@link TranslationFormAction#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    TranslationFormAction actualInstance = TranslationFormAction.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TranslationFormAction#TranslationFormAction()}
   *   <li>{@link TranslationFormAction#getFriendlyType()}
   *   <li>{@link TranslationFormAction#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    TranslationFormAction actualTranslationFormAction = new TranslationFormAction();
    String actualFriendlyType = actualTranslationFormAction.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualTranslationFormAction.getType());
  }

  /**
   * Test {@link TranslationFormAction#TranslationFormAction(String, String)}.
   * <ul>
   *   <li>When {@code Cannot add the type: (}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslationFormAction#TranslationFormAction(String, String)}
   */
  @Test
  public void testNewTranslationFormAction_whenCannotAddTheType() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> new TranslationFormAction("Cannot add the type: (", "Friendly Type"));

  }

  /**
   * Test {@link TranslationFormAction#TranslationFormAction(String, String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslationFormAction#TranslationFormAction(String, String)}
   */
  @Test
  public void testNewTranslationFormAction_whenType() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new TranslationFormAction("Type", "Friendly Type"));

  }

  /**
   * Test {@link TranslationFormAction#equals(Object)}, and
   * {@link TranslationFormAction#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TranslationFormAction#equals(Object)}
   *   <li>{@link TranslationFormAction#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TranslationFormAction translationFormAction = TranslationFormAction.ADD;
    TranslationFormAction translationFormAction2 = TranslationFormAction.ADD;

    // Act and Assert
    assertEquals(translationFormAction, translationFormAction2);
    int expectedHashCodeResult = translationFormAction.hashCode();
    assertEquals(expectedHashCodeResult, translationFormAction2.hashCode());
  }

  /**
   * Test {@link TranslationFormAction#equals(Object)}, and
   * {@link TranslationFormAction#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TranslationFormAction#equals(Object)}
   *   <li>{@link TranslationFormAction#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TranslationFormAction translationFormAction = new TranslationFormAction();
    TranslationFormAction translationFormAction2 = new TranslationFormAction();

    // Act and Assert
    assertEquals(translationFormAction, translationFormAction2);
    int expectedHashCodeResult = translationFormAction.hashCode();
    assertEquals(expectedHashCodeResult, translationFormAction2.hashCode());
  }

  /**
   * Test {@link TranslationFormAction#equals(Object)}, and
   * {@link TranslationFormAction#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TranslationFormAction#equals(Object)}
   *   <li>{@link TranslationFormAction#hashCode()}
   * </ul>
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationFormAction#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TranslationFormAction.OTHER, TranslationFormAction.ADD);
    assertNotEquals(new TranslationFormAction(), TranslationFormAction.ADD);
  }

  /**
   * Test {@link TranslationFormAction#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationFormAction#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TranslationFormAction.ADD, null);
  }

  /**
   * Test {@link TranslationFormAction#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationFormAction#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TranslationFormAction.ADD, "Different type to TranslationFormAction");
  }
}

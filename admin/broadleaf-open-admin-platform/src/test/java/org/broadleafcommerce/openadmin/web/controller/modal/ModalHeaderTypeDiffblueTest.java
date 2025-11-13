package org.broadleafcommerce.openadmin.web.controller.modal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ModalHeaderTypeDiffblueTest {
  /**
   * Test {@link ModalHeaderType#equals(Object)}, and {@link ModalHeaderType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ModalHeaderType#equals(Object)}
   *   <li>{@link ModalHeaderType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ModalHeaderType.equals(Object)", "int ModalHeaderType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ModalHeaderType modalHeaderType = ModalHeaderType.ADD_COLLECTION_ITEM;
    ModalHeaderType modalHeaderType2 = ModalHeaderType.ADD_COLLECTION_ITEM;

    // Act and Assert
    assertEquals(modalHeaderType, modalHeaderType2);
    assertEquals(modalHeaderType.hashCode(), modalHeaderType2.hashCode());
  }

  /**
   * Test {@link ModalHeaderType#equals(Object)}, and {@link ModalHeaderType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ModalHeaderType#equals(Object)}
   *   <li>{@link ModalHeaderType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ModalHeaderType.equals(Object)", "int ModalHeaderType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ModalHeaderType modalHeaderType = new ModalHeaderType();
    ModalHeaderType modalHeaderType2 = new ModalHeaderType();

    // Act and Assert
    assertEquals(modalHeaderType, modalHeaderType2);
    assertEquals(modalHeaderType.hashCode(), modalHeaderType2.hashCode());
  }

  /**
   * Test {@link ModalHeaderType#equals(Object)}, and {@link ModalHeaderType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ModalHeaderType#equals(Object)}
   *   <li>{@link ModalHeaderType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ModalHeaderType.equals(Object)", "int ModalHeaderType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ModalHeaderType modalHeaderType = ModalHeaderType.ADD_COLLECTION_ITEM;

    // Act and Assert
    assertEquals(modalHeaderType, modalHeaderType);
    int expectedHashCodeResult = modalHeaderType.hashCode();
    assertEquals(expectedHashCodeResult, modalHeaderType.hashCode());
  }

  /**
   * Test {@link ModalHeaderType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ModalHeaderType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ModalHeaderType.equals(Object)", "int ModalHeaderType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ModalHeaderType.ADD_ENTITY, ModalHeaderType.ADD_COLLECTION_ITEM);
  }

  /**
   * Test {@link ModalHeaderType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ModalHeaderType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ModalHeaderType.equals(Object)", "int ModalHeaderType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new ModalHeaderType(), ModalHeaderType.ADD_COLLECTION_ITEM);
  }

  /**
   * Test {@link ModalHeaderType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ModalHeaderType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ModalHeaderType.equals(Object)", "int ModalHeaderType.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ModalHeaderType.ADD_COLLECTION_ITEM, null);
  }

  /**
   * Test {@link ModalHeaderType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ModalHeaderType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ModalHeaderType.equals(Object)", "int ModalHeaderType.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ModalHeaderType.ADD_COLLECTION_ITEM, "Different type to ModalHeaderType");
  }
}

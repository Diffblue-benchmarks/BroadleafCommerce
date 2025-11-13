package org.broadleafcommerce.core.promotionMessage.domain.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {PromotionMessageType.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class PromotionMessageTypeDiffblueTest {
  @Autowired private PromotionMessageType promotionMessageType;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PromotionMessageType#PromotionMessageType()}
   *   <li>{@link PromotionMessageType#setOrder(int)}
   *   <li>{@link PromotionMessageType#getFriendlyType()}
   *   <li>{@link PromotionMessageType#getOrder()}
   *   <li>{@link PromotionMessageType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PromotionMessageType.<init>()",
    "String PromotionMessageType.getFriendlyType()",
    "int PromotionMessageType.getOrder()",
    "String PromotionMessageType.getType()",
    "void PromotionMessageType.setOrder(int)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    PromotionMessageType actualPromotionMessageType = new PromotionMessageType();
    actualPromotionMessageType.setOrder(1);
    String actualFriendlyType = actualPromotionMessageType.getFriendlyType();
    int actualOrder = actualPromotionMessageType.getOrder();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualPromotionMessageType.getType());
    assertEquals(1, actualOrder);
  }

  /**
   * Test {@link PromotionMessageType#PromotionMessageType(String, String, int)}.
   *
   * <p>Method under test: {@link PromotionMessageType#PromotionMessageType(String, String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PromotionMessageType.<init>(String, String, int)"})
  public void testNewPromotionMessageType() {
    // Arrange and Act
    PromotionMessageType actualPromotionMessageType =
        new PromotionMessageType("Type", "Friendly Type", 1);

    // Assert
    assertEquals("Friendly Type", actualPromotionMessageType.getFriendlyType());
    assertEquals("Type", actualPromotionMessageType.getType());
    assertEquals(1, actualPromotionMessageType.getOrder());
  }

  /**
   * Test {@link PromotionMessageType#setType(String)}.
   *
   * <ul>
   *   <li>When {@code TypeType}.
   *   <li>Then {@link PromotionMessageType} Type is {@code TypeType}.
   * </ul>
   *
   * <p>Method under test: {@link PromotionMessageType#setType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PromotionMessageType.setType(String)"})
  public void testSetType_whenTypeType_thenPromotionMessageTypeTypeIsTypeType() {
    // Arrange and Act
    promotionMessageType.setType("TypeType");

    // Assert
    assertEquals("TypeType", promotionMessageType.getType());
  }

  /**
   * Test {@link PromotionMessageType#setType(String)}.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then {@link PromotionMessageType} Type is {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link PromotionMessageType#setType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PromotionMessageType.setType(String)"})
  public void testSetType_whenType_thenPromotionMessageTypeTypeIsType() {
    // Arrange and Act
    promotionMessageType.setType("Type");

    // Assert
    assertEquals("Type", promotionMessageType.getType());
  }

  /**
   * Test {@link PromotionMessageType#equals(Object)}, and {@link PromotionMessageType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PromotionMessageType#equals(Object)}
   *   <li>{@link PromotionMessageType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PromotionMessageType.equals(Object)",
    "int PromotionMessageType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PromotionMessageType promotionMessageType = PromotionMessageType.QUALIFIERS;
    PromotionMessageType promotionMessageType2 = PromotionMessageType.QUALIFIERS;

    // Act and Assert
    assertEquals(promotionMessageType, promotionMessageType2);
    assertEquals(promotionMessageType.hashCode(), promotionMessageType2.hashCode());
  }

  /**
   * Test {@link PromotionMessageType#equals(Object)}, and {@link PromotionMessageType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PromotionMessageType#equals(Object)}
   *   <li>{@link PromotionMessageType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PromotionMessageType.equals(Object)",
    "int PromotionMessageType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PromotionMessageType promotionMessageType = PromotionMessageType.TARGETS;
    PromotionMessageType promotionMessageType2 = new PromotionMessageType("TARGETS", "TARGETS", 1);

    // Act and Assert
    assertEquals(promotionMessageType, promotionMessageType2);
    assertEquals(promotionMessageType.hashCode(), promotionMessageType2.hashCode());
  }

  /**
   * Test {@link PromotionMessageType#equals(Object)}, and {@link PromotionMessageType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PromotionMessageType#equals(Object)}
   *   <li>{@link PromotionMessageType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PromotionMessageType.equals(Object)",
    "int PromotionMessageType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    PromotionMessageType promotionMessageType = new PromotionMessageType();
    PromotionMessageType promotionMessageType2 = new PromotionMessageType();

    // Act and Assert
    assertEquals(promotionMessageType, promotionMessageType2);
    assertEquals(promotionMessageType.hashCode(), promotionMessageType2.hashCode());
  }

  /**
   * Test {@link PromotionMessageType#equals(Object)}, and {@link PromotionMessageType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PromotionMessageType#equals(Object)}
   *   <li>{@link PromotionMessageType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PromotionMessageType.equals(Object)",
    "int PromotionMessageType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PromotionMessageType promotionMessageType = PromotionMessageType.QUALIFIERS;

    // Act and Assert
    assertEquals(promotionMessageType, promotionMessageType);
    int expectedHashCodeResult = promotionMessageType.hashCode();
    assertEquals(expectedHashCodeResult, promotionMessageType.hashCode());
  }

  /**
   * Test {@link PromotionMessageType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PromotionMessageType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PromotionMessageType.equals(Object)",
    "int PromotionMessageType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PromotionMessageType.TARGETS, PromotionMessageType.QUALIFIERS);
  }

  /**
   * Test {@link PromotionMessageType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PromotionMessageType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PromotionMessageType.equals(Object)",
    "int PromotionMessageType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new PromotionMessageType(), PromotionMessageType.QUALIFIERS);
  }

  /**
   * Test {@link PromotionMessageType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PromotionMessageType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PromotionMessageType.equals(Object)",
    "int PromotionMessageType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PromotionMessageType.QUALIFIERS, null);
  }

  /**
   * Test {@link PromotionMessageType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PromotionMessageType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PromotionMessageType.equals(Object)",
    "int PromotionMessageType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PromotionMessageType.QUALIFIERS, "Different type to PromotionMessageType");
  }

  /**
   * Test {@link PromotionMessageType#compareTo(PromotionMessageType)} with {@code
   * PromotionMessageType}.
   *
   * <ul>
   *   <li>When {@link PromotionMessageType#QUALIFIERS}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PromotionMessageType#compareTo(PromotionMessageType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int PromotionMessageType.compareTo(PromotionMessageType)"})
  public void testCompareToWithPromotionMessageType_whenQualifiers_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, PromotionMessageType.QUALIFIERS.compareTo(PromotionMessageType.QUALIFIERS));
  }
}

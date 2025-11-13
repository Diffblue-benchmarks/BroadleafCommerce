package org.broadleafcommerce.core.order.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MessageTypeDiffblueTest {
  /**
   * Test {@link MessageType#getInstance(String)}.
   *
   * <p>Method under test: {@link MessageType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MessageType MessageType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    MessageType actualInstance = MessageType.getInstance("Type");

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
   *   <li>{@link MessageType#MessageType()}
   *   <li>{@link MessageType#getFriendlyType()}
   *   <li>{@link MessageType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MessageType.<init>()",
    "void MessageType.<init>(String, String)",
    "String MessageType.getFriendlyType()",
    "String MessageType.getType()"
  })
  public void testGettersAndSetters_thenReturnFriendlyTypeIsNull() {
    // Arrange and Act
    MessageType actualMessageType = new MessageType();
    String actualFriendlyType = actualMessageType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualMessageType.getType());
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
   *   <li>{@link MessageType#MessageType(String, String)}
   *   <li>{@link MessageType#getFriendlyType()}
   *   <li>{@link MessageType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MessageType.<init>()",
    "void MessageType.<init>(String, String)",
    "String MessageType.getFriendlyType()",
    "String MessageType.getType()"
  })
  public void testGettersAndSetters_whenType_thenReturnFriendlyType() {
    // Arrange and Act
    MessageType actualMessageType = new MessageType("Type", "Friendly Type");
    String actualFriendlyType = actualMessageType.getFriendlyType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", actualMessageType.getType());
  }

  /**
   * Test {@link MessageType#equals(Object)}, and {@link MessageType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MessageType#equals(Object)}
   *   <li>{@link MessageType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MessageType.equals(Object)", "int MessageType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MessageType messageType = MessageType.CART;
    MessageType messageType2 = MessageType.CART;

    // Act and Assert
    assertEquals(messageType, messageType2);
    assertEquals(messageType.hashCode(), messageType2.hashCode());
  }

  /**
   * Test {@link MessageType#equals(Object)}, and {@link MessageType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MessageType#equals(Object)}
   *   <li>{@link MessageType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MessageType.equals(Object)", "int MessageType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    MessageType messageType = MessageType.PRODUCT_OPTION;
    MessageType messageType2 = new MessageType("PRODUCT_OPTION", "PRODUCT_OPTION");

    // Act and Assert
    assertEquals(messageType, messageType2);
    assertEquals(messageType.hashCode(), messageType2.hashCode());
  }

  /**
   * Test {@link MessageType#equals(Object)}, and {@link MessageType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MessageType#equals(Object)}
   *   <li>{@link MessageType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MessageType.equals(Object)", "int MessageType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    MessageType messageType = new MessageType();
    MessageType messageType2 = new MessageType();

    // Act and Assert
    assertEquals(messageType, messageType2);
    assertEquals(messageType.hashCode(), messageType2.hashCode());
  }

  /**
   * Test {@link MessageType#equals(Object)}, and {@link MessageType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MessageType#equals(Object)}
   *   <li>{@link MessageType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MessageType.equals(Object)", "int MessageType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MessageType messageType = MessageType.CART;

    // Act and Assert
    assertEquals(messageType, messageType);
    int expectedHashCodeResult = messageType.hashCode();
    assertEquals(expectedHashCodeResult, messageType.hashCode());
  }

  /**
   * Test {@link MessageType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MessageType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MessageType.equals(Object)", "int MessageType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MessageType.PRODUCT_OPTION, MessageType.CART);
  }

  /**
   * Test {@link MessageType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MessageType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MessageType.equals(Object)", "int MessageType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new MessageType(), MessageType.CART);
  }

  /**
   * Test {@link MessageType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MessageType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MessageType.equals(Object)", "int MessageType.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MessageType.CART, null);
  }

  /**
   * Test {@link MessageType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MessageType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MessageType.equals(Object)", "int MessageType.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MessageType.CART, "Different type to MessageType");
  }
}

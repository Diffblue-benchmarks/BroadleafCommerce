package org.broadleafcommerce.common.notification.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class NotificationEventTypeDiffblueTest {
  /**
   * Test {@link NotificationEventType#getInstance(String)}.
   *
   * <p>Method under test: {@link NotificationEventType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationEventType NotificationEventType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    NotificationEventType actualInstance = NotificationEventType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationEventType#getFriendlyType()}
   *   <li>{@link NotificationEventType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String NotificationEventType.getFriendlyType()",
    "String NotificationEventType.getType()"
  })
  public void testGettersAndSetters() {
    // Arrange
    NotificationEventType notificationEventType =
        new NotificationEventType("Type", "Friendly Type");

    // Act
    String actualFriendlyType = notificationEventType.getFriendlyType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", notificationEventType.getType());
  }

  /**
   * Test {@link NotificationEventType#equals(Object)}, and {@link
   * NotificationEventType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationEventType#equals(Object)}
   *   <li>{@link NotificationEventType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationEventType.equals(Object)",
    "int NotificationEventType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NotificationEventType notificationEventType = NotificationEventType.ADMIN_FORGOT_PASSWORD;
    NotificationEventType notificationEventType2 = NotificationEventType.ADMIN_FORGOT_PASSWORD;

    // Act and Assert
    assertEquals(notificationEventType, notificationEventType2);
    assertEquals(notificationEventType.hashCode(), notificationEventType2.hashCode());
  }

  /**
   * Test {@link NotificationEventType#equals(Object)}, and {@link
   * NotificationEventType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationEventType#equals(Object)}
   *   <li>{@link NotificationEventType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationEventType.equals(Object)",
    "int NotificationEventType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    NotificationEventType notificationEventType = NotificationEventType.ADMIN_FORGOT_USERNAME;
    NotificationEventType notificationEventType2 =
        new NotificationEventType("ADMIN_FORGOT_USERNAME", "ADMIN_FORGOT_USERNAME");

    // Act and Assert
    assertEquals(notificationEventType, notificationEventType2);
    assertEquals(notificationEventType.hashCode(), notificationEventType2.hashCode());
  }

  /**
   * Test {@link NotificationEventType#equals(Object)}, and {@link
   * NotificationEventType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationEventType#equals(Object)}
   *   <li>{@link NotificationEventType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationEventType.equals(Object)",
    "int NotificationEventType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    NotificationEventType notificationEventType = new NotificationEventType();
    NotificationEventType notificationEventType2 = new NotificationEventType();

    // Act and Assert
    assertEquals(notificationEventType, notificationEventType2);
    assertEquals(notificationEventType.hashCode(), notificationEventType2.hashCode());
  }

  /**
   * Test {@link NotificationEventType#equals(Object)}, and {@link
   * NotificationEventType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationEventType#equals(Object)}
   *   <li>{@link NotificationEventType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationEventType.equals(Object)",
    "int NotificationEventType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationEventType notificationEventType = NotificationEventType.ADMIN_FORGOT_PASSWORD;

    // Act and Assert
    assertEquals(notificationEventType, notificationEventType);
    int expectedHashCodeResult = notificationEventType.hashCode();
    assertEquals(expectedHashCodeResult, notificationEventType.hashCode());
  }

  /**
   * Test {@link NotificationEventType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationEventType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationEventType.equals(Object)",
    "int NotificationEventType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        NotificationEventType.ADMIN_FORGOT_USERNAME, NotificationEventType.ADMIN_FORGOT_PASSWORD);
  }

  /**
   * Test {@link NotificationEventType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationEventType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationEventType.equals(Object)",
    "int NotificationEventType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationEventType(), NotificationEventType.ADMIN_FORGOT_PASSWORD);
  }

  /**
   * Test {@link NotificationEventType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationEventType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationEventType.equals(Object)",
    "int NotificationEventType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(NotificationEventType.ADMIN_FORGOT_PASSWORD, null);
  }

  /**
   * Test {@link NotificationEventType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationEventType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationEventType.equals(Object)",
    "int NotificationEventType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        NotificationEventType.ADMIN_FORGOT_PASSWORD, "Different type to NotificationEventType");
  }
}

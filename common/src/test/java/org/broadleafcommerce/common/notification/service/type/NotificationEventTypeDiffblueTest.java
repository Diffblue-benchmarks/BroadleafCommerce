/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.common.notification.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class NotificationEventTypeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationEventType#getFriendlyType()}
   *   <li>{@link NotificationEventType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    NotificationEventType notificationEventType = new NotificationEventType("Type", "Friendly Type");

    // Act
    String actualFriendlyType = notificationEventType.getFriendlyType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", notificationEventType.getType());
  }

  /**
   * Test {@link NotificationEventType#equals(Object)}, and
   * {@link NotificationEventType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationEventType#equals(Object)}
   *   <li>{@link NotificationEventType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NotificationEventType notificationEventType = NotificationEventType.ADMIN_FORGOT_PASSWORD;
    NotificationEventType notificationEventType2 = NotificationEventType.ADMIN_FORGOT_PASSWORD;

    // Act and Assert
    assertEquals(notificationEventType, notificationEventType2);
    int expectedHashCodeResult = notificationEventType.hashCode();
    assertEquals(expectedHashCodeResult, notificationEventType2.hashCode());
  }

  /**
   * Test {@link NotificationEventType#equals(Object)}, and
   * {@link NotificationEventType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationEventType#equals(Object)}
   *   <li>{@link NotificationEventType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    NotificationEventType notificationEventType = new NotificationEventType();
    NotificationEventType notificationEventType2 = new NotificationEventType();

    // Act and Assert
    assertEquals(notificationEventType, notificationEventType2);
    int expectedHashCodeResult = notificationEventType.hashCode();
    assertEquals(expectedHashCodeResult, notificationEventType2.hashCode());
  }

  /**
   * Test {@link NotificationEventType#equals(Object)}, and
   * {@link NotificationEventType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationEventType#equals(Object)}
   *   <li>{@link NotificationEventType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    NotificationEventType notificationEventType = new NotificationEventType("ADMIN_FORGOT_PASSWORD", "Friendly Type");
    NotificationEventType notificationEventType2 = NotificationEventType.ADMIN_FORGOT_PASSWORD;

    // Act and Assert
    assertEquals(notificationEventType, notificationEventType2);
    int expectedHashCodeResult = notificationEventType.hashCode();
    assertEquals(expectedHashCodeResult, notificationEventType2.hashCode());
  }

  /**
   * Test {@link NotificationEventType#equals(Object)}, and
   * {@link NotificationEventType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationEventType#equals(Object)}
   *   <li>{@link NotificationEventType#hashCode()}
   * </ul>
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationEventType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(NotificationEventType.ADMIN_FORGOT_USERNAME, NotificationEventType.ADMIN_FORGOT_PASSWORD);
    assertNotEquals(new NotificationEventType(), NotificationEventType.ADMIN_FORGOT_PASSWORD);
  }

  /**
   * Test {@link NotificationEventType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationEventType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(NotificationEventType.ADMIN_FORGOT_PASSWORD, null);
  }

  /**
   * Test {@link NotificationEventType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationEventType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(NotificationEventType.ADMIN_FORGOT_PASSWORD, "Different type to NotificationEventType");
  }
}

/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.order.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {MessageType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class MessageTypeDiffblueTest {
  @Autowired
  private MessageType messageType;

  /**
   * Test {@link MessageType#getInstance(String)}.
   * <p>
   * Method under test: {@link MessageType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    MessageType actualInstance = MessageType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MessageType#MessageType()}
   *   <li>{@link MessageType#getFriendlyType()}
   *   <li>{@link MessageType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    MessageType actualMessageType = new MessageType();
    String actualFriendlyType = actualMessageType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualMessageType.getType());
  }

  /**
   * Test {@link MessageType#MessageType(String, String)}.
   * <p>
   * Method under test: {@link MessageType#MessageType(String, String)}
   */
  @Test
  public void testNewMessageType() {
    // Arrange and Act
    MessageType actualMessageType = new MessageType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualMessageType.getFriendlyType());
    assertEquals("Type", actualMessageType.getType());
  }

  /**
   * Test {@link MessageType#equals(Object)}, and {@link MessageType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MessageType#equals(Object)}
   *   <li>{@link MessageType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MessageType messageType = MessageType.CART;
    MessageType messageType2 = MessageType.CART;

    // Act and Assert
    assertEquals(messageType, messageType2);
    int expectedHashCodeResult = messageType.hashCode();
    assertEquals(expectedHashCodeResult, messageType2.hashCode());
  }

  /**
   * Test {@link MessageType#equals(Object)}, and {@link MessageType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MessageType#equals(Object)}
   *   <li>{@link MessageType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    MessageType messageType = new MessageType();
    MessageType messageType2 = new MessageType();

    // Act and Assert
    assertEquals(messageType, messageType2);
    int expectedHashCodeResult = messageType.hashCode();
    assertEquals(expectedHashCodeResult, messageType2.hashCode());
  }

  /**
   * Test {@link MessageType#equals(Object)}, and {@link MessageType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MessageType#equals(Object)}
   *   <li>{@link MessageType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    MessageType messageType = new MessageType("CART", "Friendly Type");
    MessageType messageType2 = MessageType.CART;

    // Act and Assert
    assertEquals(messageType, messageType2);
    int expectedHashCodeResult = messageType.hashCode();
    assertEquals(expectedHashCodeResult, messageType2.hashCode());
  }

  /**
   * Test {@link MessageType#equals(Object)}, and {@link MessageType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MessageType#equals(Object)}
   *   <li>{@link MessageType#hashCode()}
   * </ul>
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MessageType.PRODUCT_OPTION, MessageType.CART);
    assertNotEquals(new MessageType(), MessageType.CART);
  }

  /**
   * Test {@link MessageType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MessageType.CART, null);
  }

  /**
   * Test {@link MessageType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MessageType.CART, "Different type to MessageType");
  }
}

/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
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
package org.broadleafcommerce.core.promotionMessage.domain.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {PromotionMessageType.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class PromotionMessageTypeDiffblueTest {
  @Autowired
  private PromotionMessageType promotionMessageType;

  /**
   * Method under test: {@link PromotionMessageType#setType(String)}
   */
  @Test
  public void testSetType() {
    // Arrange
    PromotionMessageType promotionMessageType2 = PromotionMessageType.QUALIFIERS;

    // Act
    promotionMessageType2.setType("Type");

    // Assert
    assertEquals("Type", promotionMessageType2.getType());
  }

  /**
   * Method under test: {@link PromotionMessageType#setType(String)}
   */
  @Test
  public void testSetType2() {
    // Arrange
    PromotionMessageType promotionMessageType2 = PromotionMessageType.QUALIFIERS;

    // Act
    promotionMessageType2.setType("TypeType");

    // Assert
    assertEquals("TypeType", promotionMessageType2.getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PromotionMessageType#equals(Object)}
   *   <li>{@link PromotionMessageType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PromotionMessageType promotionMessageType = PromotionMessageType.QUALIFIERS;
    PromotionMessageType promotionMessageType2 = PromotionMessageType.QUALIFIERS;

    // Act and Assert
    assertEquals(promotionMessageType, promotionMessageType2);
    int expectedHashCodeResult = promotionMessageType.hashCode();
    assertEquals(expectedHashCodeResult, promotionMessageType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PromotionMessageType#equals(Object)}
   *   <li>{@link PromotionMessageType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PromotionMessageType promotionMessageType = new PromotionMessageType();
    PromotionMessageType promotionMessageType2 = new PromotionMessageType();

    // Act and Assert
    assertEquals(promotionMessageType, promotionMessageType2);
    int expectedHashCodeResult = promotionMessageType.hashCode();
    assertEquals(expectedHashCodeResult, promotionMessageType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PromotionMessageType#equals(Object)}
   *   <li>{@link PromotionMessageType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    PromotionMessageType promotionMessageType = new PromotionMessageType("QUALIFIERS", "Friendly Type", 1);
    PromotionMessageType promotionMessageType2 = PromotionMessageType.QUALIFIERS;

    // Act and Assert
    assertEquals(promotionMessageType, promotionMessageType2);
    int expectedHashCodeResult = promotionMessageType.hashCode();
    assertEquals(expectedHashCodeResult, promotionMessageType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PromotionMessageType#equals(Object)}
   *   <li>{@link PromotionMessageType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PromotionMessageType promotionMessageType = PromotionMessageType.QUALIFIERS;

    // Act and Assert
    assertEquals(promotionMessageType, promotionMessageType);
    int expectedHashCodeResult = promotionMessageType.hashCode();
    assertEquals(expectedHashCodeResult, promotionMessageType.hashCode());
  }

  /**
   * Method under test:
   * {@link PromotionMessageType#compareTo(PromotionMessageType)}
   */
  @Test
  public void testCompareTo() {
    // Arrange, Act and Assert
    assertEquals(0, PromotionMessageType.QUALIFIERS.compareTo(PromotionMessageType.QUALIFIERS));
  }

  /**
   * Method under test: {@link PromotionMessageType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PromotionMessageType.TARGETS, PromotionMessageType.QUALIFIERS);
    assertNotEquals(new PromotionMessageType(), PromotionMessageType.QUALIFIERS);
  }

  /**
   * Method under test: {@link PromotionMessageType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PromotionMessageType.QUALIFIERS, null);
  }

  /**
   * Method under test: {@link PromotionMessageType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PromotionMessageType.QUALIFIERS, "Different type to PromotionMessageType");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PromotionMessageType#PromotionMessageType()}
   *   <li>{@link PromotionMessageType#setOrder(int)}
   *   <li>{@link PromotionMessageType#getFriendlyType()}
   *   <li>{@link PromotionMessageType#getOrder()}
   *   <li>{@link PromotionMessageType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    PromotionMessageType actualPromotionMessageType = new PromotionMessageType();
    actualPromotionMessageType.setOrder(1);
    actualPromotionMessageType.getFriendlyType();
    int actualOrder = actualPromotionMessageType.getOrder();
    actualPromotionMessageType.getType();

    // Assert that nothing has changed
    assertEquals(1, actualOrder);
  }

  /**
   * Method under test:
   * {@link PromotionMessageType#PromotionMessageType(String, String, int)}
   */
  @Test
  public void testNewPromotionMessageType() {
    // Arrange and Act
    PromotionMessageType actualPromotionMessageType = new PromotionMessageType("Type", "Friendly Type", 1);

    // Assert
    assertEquals("Friendly Type", actualPromotionMessageType.getFriendlyType());
    assertEquals("Type", actualPromotionMessageType.getType());
    assertEquals(1, actualPromotionMessageType.getOrder());
  }
}

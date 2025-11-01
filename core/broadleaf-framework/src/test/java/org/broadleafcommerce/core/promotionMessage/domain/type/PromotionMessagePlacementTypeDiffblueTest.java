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

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {PromotionMessagePlacementType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PromotionMessagePlacementTypeDiffblueTest {
  @Autowired
  private PromotionMessagePlacementType promotionMessagePlacementType;

  /**
   * Method under test: {@link PromotionMessagePlacementType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    PromotionMessagePlacementType actualInstance = PromotionMessagePlacementType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
    assertEquals(1, actualInstance.getOrder());
  }

  /**
   * Method under test: {@link PromotionMessagePlacementType#setType(String)}
   */
  @Test
  public void testSetType() {
    // Arrange
    PromotionMessagePlacementType promotionMessagePlacementType2 = PromotionMessagePlacementType.BROWSE;

    // Act
    promotionMessagePlacementType2.setType("Type");

    // Assert
    assertEquals("Type", promotionMessagePlacementType2.getType());
  }

  /**
   * Method under test: {@link PromotionMessagePlacementType#setType(String)}
   */
  @Test
  public void testSetType2() {
    // Arrange
    PromotionMessagePlacementType promotionMessagePlacementType2 = PromotionMessagePlacementType.BROWSE;

    // Act
    promotionMessagePlacementType2.setType("TypeType");

    // Assert
    assertEquals("TypeType", promotionMessagePlacementType2.getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PromotionMessagePlacementType#equals(Object)}
   *   <li>{@link PromotionMessagePlacementType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PromotionMessagePlacementType promotionMessagePlacementType = PromotionMessagePlacementType.BROWSE;
    PromotionMessagePlacementType promotionMessagePlacementType2 = PromotionMessagePlacementType.BROWSE;

    // Act and Assert
    assertEquals(promotionMessagePlacementType, promotionMessagePlacementType2);
    int expectedHashCodeResult = promotionMessagePlacementType.hashCode();
    assertEquals(expectedHashCodeResult, promotionMessagePlacementType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PromotionMessagePlacementType#equals(Object)}
   *   <li>{@link PromotionMessagePlacementType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PromotionMessagePlacementType promotionMessagePlacementType = new PromotionMessagePlacementType();
    PromotionMessagePlacementType promotionMessagePlacementType2 = new PromotionMessagePlacementType();

    // Act and Assert
    assertEquals(promotionMessagePlacementType, promotionMessagePlacementType2);
    int expectedHashCodeResult = promotionMessagePlacementType.hashCode();
    assertEquals(expectedHashCodeResult, promotionMessagePlacementType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PromotionMessagePlacementType#equals(Object)}
   *   <li>{@link PromotionMessagePlacementType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    PromotionMessagePlacementType promotionMessagePlacementType = new PromotionMessagePlacementType("BROWSE",
        "Friendly Type", 1);
    PromotionMessagePlacementType promotionMessagePlacementType2 = PromotionMessagePlacementType.BROWSE;

    // Act and Assert
    assertEquals(promotionMessagePlacementType, promotionMessagePlacementType2);
    int expectedHashCodeResult = promotionMessagePlacementType.hashCode();
    assertEquals(expectedHashCodeResult, promotionMessagePlacementType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PromotionMessagePlacementType#equals(Object)}
   *   <li>{@link PromotionMessagePlacementType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PromotionMessagePlacementType promotionMessagePlacementType = PromotionMessagePlacementType.BROWSE;

    // Act and Assert
    assertEquals(promotionMessagePlacementType, promotionMessagePlacementType);
    int expectedHashCodeResult = promotionMessagePlacementType.hashCode();
    assertEquals(expectedHashCodeResult, promotionMessagePlacementType.hashCode());
  }

  /**
   * Method under test:
   * {@link PromotionMessagePlacementType#compareTo(PromotionMessagePlacementType)}
   */
  @Test
  public void testCompareTo() {
    // Arrange, Act and Assert
    assertEquals(0, PromotionMessagePlacementType.BROWSE.compareTo(PromotionMessagePlacementType.BROWSE));
  }

  /**
   * Method under test: {@link PromotionMessagePlacementType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PromotionMessagePlacementType.CART, PromotionMessagePlacementType.BROWSE);
    assertNotEquals(new PromotionMessagePlacementType(), PromotionMessagePlacementType.BROWSE);
  }

  /**
   * Method under test: {@link PromotionMessagePlacementType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PromotionMessagePlacementType.BROWSE, null);
  }

  /**
   * Method under test: {@link PromotionMessagePlacementType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PromotionMessagePlacementType.BROWSE, "Different type to PromotionMessagePlacementType");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PromotionMessagePlacementType#PromotionMessagePlacementType()}
   *   <li>{@link PromotionMessagePlacementType#setOrder(int)}
   *   <li>{@link PromotionMessagePlacementType#getFriendlyType()}
   *   <li>{@link PromotionMessagePlacementType#getOrder()}
   *   <li>{@link PromotionMessagePlacementType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    PromotionMessagePlacementType actualPromotionMessagePlacementType = new PromotionMessagePlacementType();
    actualPromotionMessagePlacementType.setOrder(1);
    actualPromotionMessagePlacementType.getFriendlyType();
    int actualOrder = actualPromotionMessagePlacementType.getOrder();
    actualPromotionMessagePlacementType.getType();

    // Assert that nothing has changed
    assertEquals(1, actualOrder);
  }

  /**
   * Method under test:
   * {@link PromotionMessagePlacementType#PromotionMessagePlacementType(String, String, int)}
   */
  @Test
  public void testNewPromotionMessagePlacementType() {
    // Arrange and Act
    PromotionMessagePlacementType actualPromotionMessagePlacementType = new PromotionMessagePlacementType("Type",
        "Friendly Type", 1);

    // Assert
    assertEquals("Friendly Type", actualPromotionMessagePlacementType.getFriendlyType());
    assertEquals("Type", actualPromotionMessagePlacementType.getType());
    assertEquals(1, actualPromotionMessagePlacementType.getOrder());
  }
}

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
package org.broadleafcommerce.core.offer.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {OfferType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferTypeDiffblueTest {
  @Autowired
  private OfferType offerType;

  /**
   * Method under test: {@link OfferType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    OfferType actualInstance = OfferType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
    assertEquals(1, actualInstance.getOrder());
  }

  /**
   * Method under test: {@link OfferType#setType(String)}
   */
  @Test
  public void testSetType() {
    // Arrange
    OfferType offerType2 = OfferType.FULFILLMENT_GROUP;

    // Act
    offerType2.setType("Type");

    // Assert
    assertEquals("Type", offerType2.getType());
  }

  /**
   * Method under test: {@link OfferType#setType(String)}
   */
  @Test
  public void testSetType2() {
    // Arrange
    OfferType offerType2 = OfferType.FULFILLMENT_GROUP;

    // Act
    offerType2.setType("TypeType");

    // Assert
    assertEquals("TypeType", offerType2.getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OfferType#equals(Object)}
   *   <li>{@link OfferType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OfferType offerType = OfferType.FULFILLMENT_GROUP;
    OfferType offerType2 = OfferType.FULFILLMENT_GROUP;

    // Act and Assert
    assertEquals(offerType, offerType2);
    int expectedHashCodeResult = offerType.hashCode();
    assertEquals(expectedHashCodeResult, offerType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OfferType#equals(Object)}
   *   <li>{@link OfferType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OfferType offerType = new OfferType();
    OfferType offerType2 = new OfferType();

    // Act and Assert
    assertEquals(offerType, offerType2);
    int expectedHashCodeResult = offerType.hashCode();
    assertEquals(expectedHashCodeResult, offerType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OfferType#equals(Object)}
   *   <li>{@link OfferType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    OfferType offerType = new OfferType("FULFILLMENT_GROUP", "Friendly Type", 1);
    OfferType offerType2 = OfferType.FULFILLMENT_GROUP;

    // Act and Assert
    assertEquals(offerType, offerType2);
    int expectedHashCodeResult = offerType.hashCode();
    assertEquals(expectedHashCodeResult, offerType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OfferType#equals(Object)}
   *   <li>{@link OfferType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OfferType offerType = OfferType.FULFILLMENT_GROUP;

    // Act and Assert
    assertEquals(offerType, offerType);
    int expectedHashCodeResult = offerType.hashCode();
    assertEquals(expectedHashCodeResult, offerType.hashCode());
  }

  /**
   * Method under test: {@link OfferType#compareTo(OfferType)}
   */
  @Test
  public void testCompareTo() {
    // Arrange, Act and Assert
    assertEquals(0, OfferType.FULFILLMENT_GROUP.compareTo(OfferType.FULFILLMENT_GROUP));
  }

  /**
   * Method under test: {@link OfferType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferType.ORDER, OfferType.FULFILLMENT_GROUP);
    assertNotEquals(new OfferType(), OfferType.FULFILLMENT_GROUP);
  }

  /**
   * Method under test: {@link OfferType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferType.FULFILLMENT_GROUP, null);
  }

  /**
   * Method under test: {@link OfferType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferType.FULFILLMENT_GROUP, "Different type to OfferType");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OfferType#OfferType()}
   *   <li>{@link OfferType#setOrder(int)}
   *   <li>{@link OfferType#getFriendlyType()}
   *   <li>{@link OfferType#getOrder()}
   *   <li>{@link OfferType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    OfferType actualOfferType = new OfferType();
    actualOfferType.setOrder(1);
    actualOfferType.getFriendlyType();
    int actualOrder = actualOfferType.getOrder();
    actualOfferType.getType();

    // Assert that nothing has changed
    assertEquals(1, actualOrder);
  }

  /**
   * Method under test: {@link OfferType#OfferType(String, String, int)}
   */
  @Test
  public void testNewOfferType() {
    // Arrange and Act
    OfferType actualOfferType = new OfferType("Type", "Friendly Type", 1);

    // Assert
    assertEquals("Friendly Type", actualOfferType.getFriendlyType());
    assertEquals("Type", actualOfferType.getType());
    assertEquals(1, actualOfferType.getOrder());
  }
}

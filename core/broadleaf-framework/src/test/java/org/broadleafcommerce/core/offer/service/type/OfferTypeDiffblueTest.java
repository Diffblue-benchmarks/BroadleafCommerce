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
package org.broadleafcommerce.core.offer.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {OfferType.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class OfferTypeDiffblueTest {
  @Autowired
  private OfferType offerType;

  /**
   * Test {@link OfferType#getInstance(String)}.
   * <p>
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
   * Test getters and setters.
   * <p>
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
   * Test {@link OfferType#OfferType(String, String, int)}.
   * <p>
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

  /**
   * Test {@link OfferType#setType(String)}.
   * <ul>
   *   <li>When {@code TypeType}.</li>
   *   <li>Then {@link OfferType#FULFILLMENT_GROUP} Type is {@code TypeType}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferType#setType(String)}
   */
  @Test
  public void testSetType_whenTypeType_thenFulfillment_groupTypeIsTypeType() {
    // Arrange
    OfferType offerType2 = OfferType.FULFILLMENT_GROUP;

    // Act
    offerType2.setType("TypeType");

    // Assert
    assertEquals("TypeType", offerType2.getType());
  }

  /**
   * Test {@link OfferType#setType(String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then {@link OfferType#FULFILLMENT_GROUP} Type is {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferType#setType(String)}
   */
  @Test
  public void testSetType_whenType_thenFulfillment_groupTypeIsType() {
    // Arrange
    OfferType offerType2 = OfferType.FULFILLMENT_GROUP;

    // Act
    offerType2.setType("Type");

    // Assert
    assertEquals("Type", offerType2.getType());
  }

  /**
   * Test {@link OfferType#equals(Object)}, and {@link OfferType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link OfferType#equals(Object)}, and {@link OfferType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link OfferType#equals(Object)}, and {@link OfferType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link OfferType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferType.ORDER, OfferType.FULFILLMENT_GROUP);
    assertNotEquals(new OfferType(), OfferType.FULFILLMENT_GROUP);
  }

  /**
   * Test {@link OfferType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferType.FULFILLMENT_GROUP, null);
  }

  /**
   * Test {@link OfferType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferType.FULFILLMENT_GROUP, "Different type to OfferType");
  }

  /**
   * Test {@link OfferType#compareTo(OfferType)} with {@code OfferType}.
   * <ul>
   *   <li>When {@link OfferType#FULFILLMENT_GROUP}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferType#compareTo(OfferType)}
   */
  @Test
  public void testCompareToWithOfferType_whenFulfillment_group_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, OfferType.FULFILLMENT_GROUP.compareTo(OfferType.FULFILLMENT_GROUP));
  }
}

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
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {OfferDiscountType.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class OfferDiscountTypeDiffblueTest {
  @Autowired
  private OfferDiscountType offerDiscountType;

  /**
   * Test {@link OfferDiscountType#getInstance(String)}.
   * <p>
   * Method under test: {@link OfferDiscountType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    OfferDiscountType actualInstance = OfferDiscountType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferDiscountType#OfferDiscountType()}
   *   <li>{@link OfferDiscountType#getFriendlyType()}
   *   <li>{@link OfferDiscountType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    OfferDiscountType actualOfferDiscountType = new OfferDiscountType();
    String actualFriendlyType = actualOfferDiscountType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualOfferDiscountType.getType());
  }

  /**
   * Test {@link OfferDiscountType#OfferDiscountType(String, String)}.
   * <p>
   * Method under test:
   * {@link OfferDiscountType#OfferDiscountType(String, String)}
   */
  @Test
  public void testNewOfferDiscountType() {
    // Arrange and Act
    OfferDiscountType actualOfferDiscountType = new OfferDiscountType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualOfferDiscountType.getFriendlyType());
    assertEquals("Type", actualOfferDiscountType.getType());
  }

  /**
   * Test {@link OfferDiscountType#setType(String)}.
   * <ul>
   *   <li>When {@code TypeType}.</li>
   *   <li>Then {@link OfferDiscountType#AMOUNT_OFF} Type is {@code TypeType}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferDiscountType#setType(String)}
   */
  @Test
  public void testSetType_whenTypeType_thenAmount_offTypeIsTypeType() {
    // Arrange
    OfferDiscountType offerDiscountType2 = OfferDiscountType.AMOUNT_OFF;

    // Act
    offerDiscountType2.setType("TypeType");

    // Assert
    assertEquals("TypeType", offerDiscountType2.getType());
  }

  /**
   * Test {@link OfferDiscountType#setType(String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then {@link OfferDiscountType#AMOUNT_OFF} Type is {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferDiscountType#setType(String)}
   */
  @Test
  public void testSetType_whenType_thenAmount_offTypeIsType() {
    // Arrange
    OfferDiscountType offerDiscountType2 = OfferDiscountType.AMOUNT_OFF;

    // Act
    offerDiscountType2.setType("Type");

    // Assert
    assertEquals("Type", offerDiscountType2.getType());
  }

  /**
   * Test {@link OfferDiscountType#equals(Object)}, and
   * {@link OfferDiscountType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferDiscountType#equals(Object)}
   *   <li>{@link OfferDiscountType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OfferDiscountType offerDiscountType = OfferDiscountType.AMOUNT_OFF;
    OfferDiscountType offerDiscountType2 = OfferDiscountType.AMOUNT_OFF;

    // Act and Assert
    assertEquals(offerDiscountType, offerDiscountType2);
    int expectedHashCodeResult = offerDiscountType.hashCode();
    assertEquals(expectedHashCodeResult, offerDiscountType2.hashCode());
  }

  /**
   * Test {@link OfferDiscountType#equals(Object)}, and
   * {@link OfferDiscountType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferDiscountType#equals(Object)}
   *   <li>{@link OfferDiscountType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OfferDiscountType offerDiscountType = new OfferDiscountType();
    OfferDiscountType offerDiscountType2 = new OfferDiscountType();

    // Act and Assert
    assertEquals(offerDiscountType, offerDiscountType2);
    int expectedHashCodeResult = offerDiscountType.hashCode();
    assertEquals(expectedHashCodeResult, offerDiscountType2.hashCode());
  }

  /**
   * Test {@link OfferDiscountType#equals(Object)}, and
   * {@link OfferDiscountType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferDiscountType#equals(Object)}
   *   <li>{@link OfferDiscountType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OfferDiscountType offerDiscountType = OfferDiscountType.AMOUNT_OFF;

    // Act and Assert
    assertEquals(offerDiscountType, offerDiscountType);
    int expectedHashCodeResult = offerDiscountType.hashCode();
    assertEquals(expectedHashCodeResult, offerDiscountType.hashCode());
  }

  /**
   * Test {@link OfferDiscountType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferDiscountType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferDiscountType.FIX_PRICE, OfferDiscountType.AMOUNT_OFF);
    assertNotEquals(new OfferDiscountType(), OfferDiscountType.AMOUNT_OFF);
  }

  /**
   * Test {@link OfferDiscountType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferDiscountType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferDiscountType.AMOUNT_OFF, null);
  }

  /**
   * Test {@link OfferDiscountType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferDiscountType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferDiscountType.AMOUNT_OFF, "Different type to OfferDiscountType");
  }
}

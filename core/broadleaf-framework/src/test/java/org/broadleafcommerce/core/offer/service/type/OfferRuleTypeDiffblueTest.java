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

@ContextConfiguration(classes = {OfferRuleType.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class OfferRuleTypeDiffblueTest {
  @Autowired
  private OfferRuleType offerRuleType;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferRuleType#OfferRuleType()}
   *   <li>{@link OfferRuleType#getFriendlyType()}
   *   <li>{@link OfferRuleType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    OfferRuleType actualOfferRuleType = new OfferRuleType();
    String actualFriendlyType = actualOfferRuleType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualOfferRuleType.getType());
  }

  /**
   * Test {@link OfferRuleType#OfferRuleType(String, String)}.
   * <ul>
   *   <li>When {@code Order}.</li>
   *   <li>Then return Type is {@code Order}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferRuleType#OfferRuleType(String, String)}
   */
  @Test
  public void testNewOfferRuleType_whenOrder_thenReturnTypeIsOrder() {
    // Arrange and Act
    OfferRuleType actualOfferRuleType = new OfferRuleType("Order", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualOfferRuleType.getFriendlyType());
    assertEquals("Order", actualOfferRuleType.getType());
  }

  /**
   * Test {@link OfferRuleType#OfferRuleType(String, String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then return {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferRuleType#OfferRuleType(String, String)}
   */
  @Test
  public void testNewOfferRuleType_whenType_thenReturnType() {
    // Arrange and Act
    OfferRuleType actualOfferRuleType = new OfferRuleType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualOfferRuleType.getFriendlyType());
    assertEquals("Type", actualOfferRuleType.getType());
  }

  /**
   * Test {@link OfferRuleType#setType(String)}.
   * <ul>
   *   <li>When {@code TypeType}.</li>
   *   <li>Then {@link OfferRuleType#CUSTOMER} Type is {@code TypeType}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferRuleType#setType(String)}
   */
  @Test
  public void testSetType_whenTypeType_thenCustomerTypeIsTypeType() {
    // Arrange
    OfferRuleType offerRuleType2 = OfferRuleType.CUSTOMER;

    // Act
    offerRuleType2.setType("TypeType");

    // Assert
    assertEquals("TypeType", offerRuleType2.getType());
  }

  /**
   * Test {@link OfferRuleType#setType(String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then {@link OfferRuleType#CUSTOMER} Type is {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferRuleType#setType(String)}
   */
  @Test
  public void testSetType_whenType_thenCustomerTypeIsType() {
    // Arrange
    OfferRuleType offerRuleType2 = OfferRuleType.CUSTOMER;

    // Act
    offerRuleType2.setType("Type");

    // Assert
    assertEquals("Type", offerRuleType2.getType());
  }

  /**
   * Test {@link OfferRuleType#equals(Object)}, and
   * {@link OfferRuleType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferRuleType#equals(Object)}
   *   <li>{@link OfferRuleType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OfferRuleType offerRuleType = OfferRuleType.CUSTOMER;
    OfferRuleType offerRuleType2 = OfferRuleType.CUSTOMER;

    // Act and Assert
    assertEquals(offerRuleType, offerRuleType2);
    int expectedHashCodeResult = offerRuleType.hashCode();
    assertEquals(expectedHashCodeResult, offerRuleType2.hashCode());
  }

  /**
   * Test {@link OfferRuleType#equals(Object)}, and
   * {@link OfferRuleType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferRuleType#equals(Object)}
   *   <li>{@link OfferRuleType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OfferRuleType offerRuleType = new OfferRuleType();
    OfferRuleType offerRuleType2 = new OfferRuleType();

    // Act and Assert
    assertEquals(offerRuleType, offerRuleType2);
    int expectedHashCodeResult = offerRuleType.hashCode();
    assertEquals(expectedHashCodeResult, offerRuleType2.hashCode());
  }

  /**
   * Test {@link OfferRuleType#equals(Object)}, and
   * {@link OfferRuleType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferRuleType#equals(Object)}
   *   <li>{@link OfferRuleType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OfferRuleType offerRuleType = OfferRuleType.CUSTOMER;

    // Act and Assert
    assertEquals(offerRuleType, offerRuleType);
    int expectedHashCodeResult = offerRuleType.hashCode();
    assertEquals(expectedHashCodeResult, offerRuleType.hashCode());
  }

  /**
   * Test {@link OfferRuleType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferRuleType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferRuleType.FULFILLMENT_GROUP, OfferRuleType.CUSTOMER);
    assertNotEquals(new OfferRuleType(), OfferRuleType.CUSTOMER);
  }

  /**
   * Test {@link OfferRuleType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferRuleType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferRuleType.CUSTOMER, null);
  }

  /**
   * Test {@link OfferRuleType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferRuleType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferRuleType.CUSTOMER, "Different type to OfferRuleType");
  }
}

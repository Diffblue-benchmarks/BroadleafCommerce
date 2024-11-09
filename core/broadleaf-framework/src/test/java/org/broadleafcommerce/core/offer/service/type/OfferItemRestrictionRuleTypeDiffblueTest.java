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

@ContextConfiguration(classes = {OfferItemRestrictionRuleType.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class OfferItemRestrictionRuleTypeDiffblueTest {
  @Autowired
  private OfferItemRestrictionRuleType offerItemRestrictionRuleType;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferItemRestrictionRuleType#OfferItemRestrictionRuleType()}
   *   <li>{@link OfferItemRestrictionRuleType#getFriendlyType()}
   *   <li>{@link OfferItemRestrictionRuleType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    OfferItemRestrictionRuleType actualOfferItemRestrictionRuleType = new OfferItemRestrictionRuleType();
    String actualFriendlyType = actualOfferItemRestrictionRuleType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualOfferItemRestrictionRuleType.getType());
  }

  /**
   * Test
   * {@link OfferItemRestrictionRuleType#OfferItemRestrictionRuleType(String, String)}.
   * <p>
   * Method under test:
   * {@link OfferItemRestrictionRuleType#OfferItemRestrictionRuleType(String, String)}
   */
  @Test
  public void testNewOfferItemRestrictionRuleType() {
    // Arrange and Act
    OfferItemRestrictionRuleType actualOfferItemRestrictionRuleType = new OfferItemRestrictionRuleType("Type",
        "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualOfferItemRestrictionRuleType.getFriendlyType());
    assertEquals("Type", actualOfferItemRestrictionRuleType.getType());
  }

  /**
   * Test {@link OfferItemRestrictionRuleType#setType(String)}.
   * <ul>
   *   <li>When {@code TypeType}.</li>
   *   <li>Then {@link OfferItemRestrictionRuleType#NONE} Type is
   * {@code TypeType}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferItemRestrictionRuleType#setType(String)}
   */
  @Test
  public void testSetType_whenTypeType_thenNoneTypeIsTypeType() {
    // Arrange
    OfferItemRestrictionRuleType offerItemRestrictionRuleType2 = OfferItemRestrictionRuleType.NONE;

    // Act
    offerItemRestrictionRuleType2.setType("TypeType");

    // Assert
    assertEquals("TypeType", offerItemRestrictionRuleType2.getType());
  }

  /**
   * Test {@link OfferItemRestrictionRuleType#setType(String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then {@link OfferItemRestrictionRuleType#NONE} Type is {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferItemRestrictionRuleType#setType(String)}
   */
  @Test
  public void testSetType_whenType_thenNoneTypeIsType() {
    // Arrange
    OfferItemRestrictionRuleType offerItemRestrictionRuleType2 = OfferItemRestrictionRuleType.NONE;

    // Act
    offerItemRestrictionRuleType2.setType("Type");

    // Assert
    assertEquals("Type", offerItemRestrictionRuleType2.getType());
  }

  /**
   * Test {@link OfferItemRestrictionRuleType#equals(Object)}, and
   * {@link OfferItemRestrictionRuleType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferItemRestrictionRuleType#equals(Object)}
   *   <li>{@link OfferItemRestrictionRuleType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OfferItemRestrictionRuleType offerItemRestrictionRuleType = OfferItemRestrictionRuleType.NONE;
    OfferItemRestrictionRuleType offerItemRestrictionRuleType2 = OfferItemRestrictionRuleType.NONE;

    // Act and Assert
    assertEquals(offerItemRestrictionRuleType, offerItemRestrictionRuleType2);
    int expectedHashCodeResult = offerItemRestrictionRuleType.hashCode();
    assertEquals(expectedHashCodeResult, offerItemRestrictionRuleType2.hashCode());
  }

  /**
   * Test {@link OfferItemRestrictionRuleType#equals(Object)}, and
   * {@link OfferItemRestrictionRuleType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferItemRestrictionRuleType#equals(Object)}
   *   <li>{@link OfferItemRestrictionRuleType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OfferItemRestrictionRuleType offerItemRestrictionRuleType = new OfferItemRestrictionRuleType();
    OfferItemRestrictionRuleType offerItemRestrictionRuleType2 = new OfferItemRestrictionRuleType();

    // Act and Assert
    assertEquals(offerItemRestrictionRuleType, offerItemRestrictionRuleType2);
    int expectedHashCodeResult = offerItemRestrictionRuleType.hashCode();
    assertEquals(expectedHashCodeResult, offerItemRestrictionRuleType2.hashCode());
  }

  /**
   * Test {@link OfferItemRestrictionRuleType#equals(Object)}, and
   * {@link OfferItemRestrictionRuleType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferItemRestrictionRuleType#equals(Object)}
   *   <li>{@link OfferItemRestrictionRuleType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OfferItemRestrictionRuleType offerItemRestrictionRuleType = OfferItemRestrictionRuleType.NONE;

    // Act and Assert
    assertEquals(offerItemRestrictionRuleType, offerItemRestrictionRuleType);
    int expectedHashCodeResult = offerItemRestrictionRuleType.hashCode();
    assertEquals(expectedHashCodeResult, offerItemRestrictionRuleType.hashCode());
  }

  /**
   * Test {@link OfferItemRestrictionRuleType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferItemRestrictionRuleType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferItemRestrictionRuleType.QUALIFIER, OfferItemRestrictionRuleType.NONE);
    assertNotEquals(new OfferItemRestrictionRuleType(), OfferItemRestrictionRuleType.NONE);
  }

  /**
   * Test {@link OfferItemRestrictionRuleType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferItemRestrictionRuleType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferItemRestrictionRuleType.NONE, null);
  }

  /**
   * Test {@link OfferItemRestrictionRuleType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferItemRestrictionRuleType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferItemRestrictionRuleType.NONE, "Different type to OfferItemRestrictionRuleType");
  }
}

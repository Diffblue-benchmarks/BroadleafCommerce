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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {OfferTimeZoneType.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class OfferTimeZoneTypeDiffblueTest {
  @Autowired
  private OfferTimeZoneType offerTimeZoneType;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferTimeZoneType#OfferTimeZoneType()}
   *   <li>{@link OfferTimeZoneType#setJavaStandardTimeZone(Boolean)}
   *   <li>{@link OfferTimeZoneType#getFriendlyType()}
   *   <li>{@link OfferTimeZoneType#getJavaStandardTimeZone()}
   *   <li>{@link OfferTimeZoneType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    OfferTimeZoneType actualOfferTimeZoneType = new OfferTimeZoneType();
    actualOfferTimeZoneType.setJavaStandardTimeZone(true);
    actualOfferTimeZoneType.getFriendlyType();
    Boolean actualJavaStandardTimeZone = actualOfferTimeZoneType.getJavaStandardTimeZone();
    actualOfferTimeZoneType.getType();

    // Assert that nothing has changed
    assertTrue(actualJavaStandardTimeZone);
  }

  /**
   * Test {@link OfferTimeZoneType#OfferTimeZoneType(String, String)}.
   * <p>
   * Method under test:
   * {@link OfferTimeZoneType#OfferTimeZoneType(String, String)}
   */
  @Test
  public void testNewOfferTimeZoneType() {
    // Arrange and Act
    OfferTimeZoneType actualOfferTimeZoneType = new OfferTimeZoneType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualOfferTimeZoneType.getFriendlyType());
    assertEquals("Type", actualOfferTimeZoneType.getType());
    assertFalse(actualOfferTimeZoneType.getJavaStandardTimeZone());
  }

  /**
   * Test {@link OfferTimeZoneType#OfferTimeZoneType(String, String, Boolean)}.
   * <p>
   * Method under test:
   * {@link OfferTimeZoneType#OfferTimeZoneType(String, String, Boolean)}
   */
  @Test
  public void testNewOfferTimeZoneType2() {
    // Arrange and Act
    OfferTimeZoneType actualOfferTimeZoneType = new OfferTimeZoneType("Type", "Friendly Type", true);

    // Assert
    assertEquals("Friendly Type", actualOfferTimeZoneType.getFriendlyType());
    assertEquals("Type", actualOfferTimeZoneType.getType());
    assertTrue(actualOfferTimeZoneType.getJavaStandardTimeZone());
  }

  /**
   * Test {@link OfferTimeZoneType#setType(String)}.
   * <ul>
   *   <li>When {@code TypeType}.</li>
   *   <li>Then {@link OfferTimeZoneType#APPLICATION} Type is {@code TypeType}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferTimeZoneType#setType(String)}
   */
  @Test
  public void testSetType_whenTypeType_thenApplicationTypeIsTypeType() {
    // Arrange
    OfferTimeZoneType offerTimeZoneType2 = OfferTimeZoneType.APPLICATION;

    // Act
    offerTimeZoneType2.setType("TypeType");

    // Assert
    assertEquals("TypeType", offerTimeZoneType2.getType());
  }

  /**
   * Test {@link OfferTimeZoneType#setType(String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then {@link OfferTimeZoneType#APPLICATION} Type is {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferTimeZoneType#setType(String)}
   */
  @Test
  public void testSetType_whenType_thenApplicationTypeIsType() {
    // Arrange
    OfferTimeZoneType offerTimeZoneType2 = OfferTimeZoneType.APPLICATION;

    // Act
    offerTimeZoneType2.setType("Type");

    // Assert
    assertEquals("Type", offerTimeZoneType2.getType());
  }

  /**
   * Test {@link OfferTimeZoneType#equals(Object)}, and
   * {@link OfferTimeZoneType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferTimeZoneType#equals(Object)}
   *   <li>{@link OfferTimeZoneType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OfferTimeZoneType offerTimeZoneType = OfferTimeZoneType.APPLICATION;
    OfferTimeZoneType offerTimeZoneType2 = OfferTimeZoneType.APPLICATION;

    // Act and Assert
    assertEquals(offerTimeZoneType, offerTimeZoneType2);
    int expectedHashCodeResult = offerTimeZoneType.hashCode();
    assertEquals(expectedHashCodeResult, offerTimeZoneType2.hashCode());
  }

  /**
   * Test {@link OfferTimeZoneType#equals(Object)}, and
   * {@link OfferTimeZoneType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferTimeZoneType#equals(Object)}
   *   <li>{@link OfferTimeZoneType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OfferTimeZoneType offerTimeZoneType = OfferTimeZoneType.CST;
    OfferTimeZoneType offerTimeZoneType2 = new OfferTimeZoneType("CST", "CST", true);

    // Act and Assert
    assertEquals(offerTimeZoneType, offerTimeZoneType2);
    int expectedHashCodeResult = offerTimeZoneType.hashCode();
    assertEquals(expectedHashCodeResult, offerTimeZoneType2.hashCode());
  }

  /**
   * Test {@link OfferTimeZoneType#equals(Object)}, and
   * {@link OfferTimeZoneType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferTimeZoneType#equals(Object)}
   *   <li>{@link OfferTimeZoneType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    OfferTimeZoneType offerTimeZoneType = new OfferTimeZoneType();
    OfferTimeZoneType offerTimeZoneType2 = new OfferTimeZoneType();

    // Act and Assert
    assertEquals(offerTimeZoneType, offerTimeZoneType2);
    int expectedHashCodeResult = offerTimeZoneType.hashCode();
    assertEquals(expectedHashCodeResult, offerTimeZoneType2.hashCode());
  }

  /**
   * Test {@link OfferTimeZoneType#equals(Object)}, and
   * {@link OfferTimeZoneType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferTimeZoneType#equals(Object)}
   *   <li>{@link OfferTimeZoneType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OfferTimeZoneType offerTimeZoneType = OfferTimeZoneType.APPLICATION;

    // Act and Assert
    assertEquals(offerTimeZoneType, offerTimeZoneType);
    int expectedHashCodeResult = offerTimeZoneType.hashCode();
    assertEquals(expectedHashCodeResult, offerTimeZoneType.hashCode());
  }

  /**
   * Test {@link OfferTimeZoneType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferTimeZoneType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferTimeZoneType.CST, OfferTimeZoneType.APPLICATION);
    assertNotEquals(new OfferTimeZoneType(), OfferTimeZoneType.APPLICATION);
  }

  /**
   * Test {@link OfferTimeZoneType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferTimeZoneType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferTimeZoneType.APPLICATION, null);
  }

  /**
   * Test {@link OfferTimeZoneType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferTimeZoneType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferTimeZoneType.APPLICATION, "Different type to OfferTimeZoneType");
  }
}

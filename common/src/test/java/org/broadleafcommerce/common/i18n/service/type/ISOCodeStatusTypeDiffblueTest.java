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
package org.broadleafcommerce.common.i18n.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ISOCodeStatusType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ISOCodeStatusTypeDiffblueTest {
  @Autowired
  private ISOCodeStatusType iSOCodeStatusType;

  /**
   * Test {@link ISOCodeStatusType#getInstance(String)}.
   * <p>
   * Method under test: {@link ISOCodeStatusType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    ISOCodeStatusType actualInstance = ISOCodeStatusType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ISOCodeStatusType#ISOCodeStatusType()}
   *   <li>{@link ISOCodeStatusType#getFriendlyType()}
   *   <li>{@link ISOCodeStatusType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ISOCodeStatusType actualIsoCodeStatusType = new ISOCodeStatusType();
    String actualFriendlyType = actualIsoCodeStatusType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualIsoCodeStatusType.getType());
  }

  /**
   * Test {@link ISOCodeStatusType#ISOCodeStatusType(String, String)}.
   * <p>
   * Method under test:
   * {@link ISOCodeStatusType#ISOCodeStatusType(String, String)}
   */
  @Test
  public void testNewISOCodeStatusType() {
    // Arrange and Act
    ISOCodeStatusType actualIsoCodeStatusType = new ISOCodeStatusType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualIsoCodeStatusType.getFriendlyType());
    assertEquals("Type", actualIsoCodeStatusType.getType());
  }

  /**
   * Test {@link ISOCodeStatusType#equals(Object)}, and
   * {@link ISOCodeStatusType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ISOCodeStatusType#equals(Object)}
   *   <li>{@link ISOCodeStatusType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ISOCodeStatusType isoCodeStatusType = ISOCodeStatusType.EXCEPTIONALLY_RESERVED;
    ISOCodeStatusType isoCodeStatusType2 = ISOCodeStatusType.EXCEPTIONALLY_RESERVED;

    // Act and Assert
    assertEquals(isoCodeStatusType, isoCodeStatusType2);
    int expectedHashCodeResult = isoCodeStatusType.hashCode();
    assertEquals(expectedHashCodeResult, isoCodeStatusType2.hashCode());
  }

  /**
   * Test {@link ISOCodeStatusType#equals(Object)}, and
   * {@link ISOCodeStatusType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ISOCodeStatusType#equals(Object)}
   *   <li>{@link ISOCodeStatusType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ISOCodeStatusType isoCodeStatusType = new ISOCodeStatusType();
    ISOCodeStatusType isoCodeStatusType2 = new ISOCodeStatusType();

    // Act and Assert
    assertEquals(isoCodeStatusType, isoCodeStatusType2);
    int expectedHashCodeResult = isoCodeStatusType.hashCode();
    assertEquals(expectedHashCodeResult, isoCodeStatusType2.hashCode());
  }

  /**
   * Test {@link ISOCodeStatusType#equals(Object)}, and
   * {@link ISOCodeStatusType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ISOCodeStatusType#equals(Object)}
   *   <li>{@link ISOCodeStatusType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ISOCodeStatusType isoCodeStatusType = new ISOCodeStatusType("EXCEPTIONALLY_RESERVED", "Friendly Type");
    ISOCodeStatusType isoCodeStatusType2 = ISOCodeStatusType.EXCEPTIONALLY_RESERVED;

    // Act and Assert
    assertEquals(isoCodeStatusType, isoCodeStatusType2);
    int expectedHashCodeResult = isoCodeStatusType.hashCode();
    assertEquals(expectedHashCodeResult, isoCodeStatusType2.hashCode());
  }

  /**
   * Test {@link ISOCodeStatusType#equals(Object)}, and
   * {@link ISOCodeStatusType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ISOCodeStatusType#equals(Object)}
   *   <li>{@link ISOCodeStatusType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ISOCodeStatusType isoCodeStatusType = ISOCodeStatusType.EXCEPTIONALLY_RESERVED;

    // Act and Assert
    assertEquals(isoCodeStatusType, isoCodeStatusType);
    int expectedHashCodeResult = isoCodeStatusType.hashCode();
    assertEquals(expectedHashCodeResult, isoCodeStatusType.hashCode());
  }

  /**
   * Test {@link ISOCodeStatusType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCodeStatusType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ISOCodeStatusType.INDETERMINATELY_RESERVED, ISOCodeStatusType.EXCEPTIONALLY_RESERVED);
    assertNotEquals(new ISOCodeStatusType(), ISOCodeStatusType.EXCEPTIONALLY_RESERVED);
  }

  /**
   * Test {@link ISOCodeStatusType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCodeStatusType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ISOCodeStatusType.EXCEPTIONALLY_RESERVED, null);
  }

  /**
   * Test {@link ISOCodeStatusType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCodeStatusType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ISOCodeStatusType.EXCEPTIONALLY_RESERVED, "Different type to ISOCodeStatusType");
  }
}

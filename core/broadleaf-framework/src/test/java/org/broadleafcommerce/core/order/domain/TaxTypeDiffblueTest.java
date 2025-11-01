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
package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {TaxType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class TaxTypeDiffblueTest {
  @Autowired
  private TaxType taxType;

  /**
   * Method under test: {@link TaxType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    TaxType actualInstance = TaxType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TaxType#equals(Object)}
   *   <li>{@link TaxType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TaxType taxType = TaxType.CITY;
    TaxType taxType2 = TaxType.CITY;

    // Act and Assert
    assertEquals(taxType, taxType2);
    int expectedHashCodeResult = taxType.hashCode();
    assertEquals(expectedHashCodeResult, taxType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TaxType#equals(Object)}
   *   <li>{@link TaxType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TaxType taxType = new TaxType();
    TaxType taxType2 = new TaxType();

    // Act and Assert
    assertEquals(taxType, taxType2);
    int expectedHashCodeResult = taxType.hashCode();
    assertEquals(expectedHashCodeResult, taxType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TaxType#equals(Object)}
   *   <li>{@link TaxType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TaxType taxType = new TaxType("CITY", "Friendly Type");
    TaxType taxType2 = TaxType.CITY;

    // Act and Assert
    assertEquals(taxType, taxType2);
    int expectedHashCodeResult = taxType.hashCode();
    assertEquals(expectedHashCodeResult, taxType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TaxType#equals(Object)}
   *   <li>{@link TaxType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TaxType taxType = TaxType.CITY;

    // Act and Assert
    assertEquals(taxType, taxType);
    int expectedHashCodeResult = taxType.hashCode();
    assertEquals(expectedHashCodeResult, taxType.hashCode());
  }

  /**
   * Method under test: {@link TaxType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TaxType.COMBINED, TaxType.CITY);
    assertNotEquals(new TaxType(), TaxType.CITY);
  }

  /**
   * Method under test: {@link TaxType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TaxType.CITY, null);
  }

  /**
   * Method under test: {@link TaxType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TaxType.CITY, "Different type to TaxType");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TaxType#TaxType()}
   *   <li>{@link TaxType#getFriendlyType()}
   *   <li>{@link TaxType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    TaxType actualTaxType = new TaxType();
    String actualFriendlyType = actualTaxType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualTaxType.getType());
  }

  /**
   * Method under test: {@link TaxType#TaxType(String, String)}
   */
  @Test
  public void testNewTaxType() {
    // Arrange and Act
    TaxType actualTaxType = new TaxType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualTaxType.getFriendlyType());
    assertEquals("Type", actualTaxType.getType());
  }

  /**
   * Method under test: {@link TaxType#TaxType(String, String)}
   */
  @Test
  public void testNewTaxType2() {
    // Arrange and Act
    TaxType actualTaxType = new TaxType("City", "Friendly Type");

    // Assert
    assertEquals("City", actualTaxType.getType());
    assertEquals("Friendly Type", actualTaxType.getFriendlyType());
  }
}

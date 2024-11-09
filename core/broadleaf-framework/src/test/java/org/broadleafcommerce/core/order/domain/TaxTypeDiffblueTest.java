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
   * Test {@link TaxType#getInstance(String)}.
   * <p>
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
   * Test getters and setters.
   * <p>
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
   * Test {@link TaxType#TaxType(String, String)}.
   * <ul>
   *   <li>When {@code City}.</li>
   *   <li>Then return Type is {@code City}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxType#TaxType(String, String)}
   */
  @Test
  public void testNewTaxType_whenCity_thenReturnTypeIsCity() {
    // Arrange and Act
    TaxType actualTaxType = new TaxType("City", "Friendly Type");

    // Assert
    assertEquals("City", actualTaxType.getType());
    assertEquals("Friendly Type", actualTaxType.getFriendlyType());
  }

  /**
   * Test {@link TaxType#TaxType(String, String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then return {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxType#TaxType(String, String)}
   */
  @Test
  public void testNewTaxType_whenType_thenReturnType() {
    // Arrange and Act
    TaxType actualTaxType = new TaxType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualTaxType.getFriendlyType());
    assertEquals("Type", actualTaxType.getType());
  }

  /**
   * Test {@link TaxType#equals(Object)}, and {@link TaxType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link TaxType#equals(Object)}, and {@link TaxType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link TaxType#equals(Object)}, and {@link TaxType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link TaxType#equals(Object)}, and {@link TaxType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link TaxType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TaxType.COMBINED, TaxType.CITY);
    assertNotEquals(new TaxType(), TaxType.CITY);
  }

  /**
   * Test {@link TaxType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TaxType.CITY, null);
  }

  /**
   * Test {@link TaxType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TaxType.CITY, "Different type to TaxType");
  }
}

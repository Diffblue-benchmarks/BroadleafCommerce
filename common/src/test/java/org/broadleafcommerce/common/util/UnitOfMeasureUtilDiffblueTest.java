/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import org.broadleafcommerce.common.money.BankersRounding;
import org.junit.Test;

public class UnitOfMeasureUtilDiffblueTest {
  /**
   * Method under test:
   * {@link UnitOfMeasureUtil#convertKilogramsToPounds(BigDecimal)}
   */
  @Test
  public void testConvertKilogramsToPounds() {
    // Arrange and Act
    BigDecimal actualConvertKilogramsToPoundsResult = UnitOfMeasureUtil.convertKilogramsToPounds(BankersRounding.ZERO);

    // Assert
    assertEquals(new BigDecimal("0E-10"), actualConvertKilogramsToPoundsResult);
  }

  /**
   * Method under test:
   * {@link UnitOfMeasureUtil#convertPoundsToKilograms(BigDecimal)}
   */
  @Test
  public void testConvertPoundsToKilograms() {
    // Arrange and Act
    BigDecimal actualConvertPoundsToKilogramsResult = UnitOfMeasureUtil.convertPoundsToKilograms(BankersRounding.ZERO);

    // Assert
    assertEquals(new BigDecimal("0E-13"), actualConvertPoundsToKilogramsResult);
  }

  /**
   * Method under test:
   * {@link UnitOfMeasureUtil#convertPoundsToOunces(BigDecimal)}
   */
  @Test
  public void testConvertPoundsToOunces() {
    // Arrange and Act
    BigDecimal actualConvertPoundsToOuncesResult = UnitOfMeasureUtil.convertPoundsToOunces(BankersRounding.ZERO);

    // Assert
    assertEquals(new BigDecimal("0.00"), actualConvertPoundsToOuncesResult);
  }

  /**
   * Method under test:
   * {@link UnitOfMeasureUtil#convertOuncesToPounds(BigDecimal)}
   */
  @Test
  public void testConvertOuncesToPounds() {
    // Arrange and Act
    BigDecimal actualConvertOuncesToPoundsResult = UnitOfMeasureUtil.convertOuncesToPounds(BankersRounding.ZERO);

    // Assert
    assertEquals(new BigDecimal("0.000000"), actualConvertOuncesToPoundsResult);
  }

  /**
   * Method under test: {@link UnitOfMeasureUtil#convertFeetToMeters(BigDecimal)}
   */
  @Test
  public void testConvertFeetToMeters() {
    // Arrange and Act
    BigDecimal actualConvertFeetToMetersResult = UnitOfMeasureUtil.convertFeetToMeters(BankersRounding.ZERO);

    // Assert
    assertEquals(new BigDecimal("0.000000"), actualConvertFeetToMetersResult);
  }

  /**
   * Method under test: {@link UnitOfMeasureUtil#convertMetersToFeet(BigDecimal)}
   */
  @Test
  public void testConvertMetersToFeet() {
    // Arrange and Act
    BigDecimal actualConvertMetersToFeetResult = UnitOfMeasureUtil.convertMetersToFeet(BankersRounding.ZERO);

    // Assert
    assertEquals(new BigDecimal("0E-7"), actualConvertMetersToFeetResult);
  }

  /**
   * Method under test: {@link UnitOfMeasureUtil#convertInchesToFeet(BigDecimal)}
   */
  @Test
  public void testConvertInchesToFeet() {
    // Arrange and Act
    BigDecimal actualConvertInchesToFeetResult = UnitOfMeasureUtil.convertInchesToFeet(BankersRounding.ZERO);

    // Assert
    assertEquals(new BigDecimal("0E-8"), actualConvertInchesToFeetResult);
  }

  /**
   * Method under test: {@link UnitOfMeasureUtil#convertFeetToInches(BigDecimal)}
   */
  @Test
  public void testConvertFeetToInches() {
    // Arrange and Act
    BigDecimal actualConvertFeetToInchesResult = UnitOfMeasureUtil.convertFeetToInches(BankersRounding.ZERO);

    // Assert
    assertEquals(new BigDecimal("0.00"), actualConvertFeetToInchesResult);
  }

  /**
   * Method under test:
   * {@link UnitOfMeasureUtil#findWholePounds(BigDecimal, WeightUnitOfMeasureType)}
   */
  @Test
  public void testFindWholePounds() {
    // Arrange, Act and Assert
    assertEquals(0, UnitOfMeasureUtil.findWholePounds(BankersRounding.ZERO, WeightUnitOfMeasureType.KILOGRAMS));
    assertEquals(0, UnitOfMeasureUtil.findWholePounds(BankersRounding.ZERO, WeightUnitOfMeasureType.POUNDS));
    assertEquals(0, UnitOfMeasureUtil.findWholePounds(BankersRounding.ZERO, new WeightUnitOfMeasureType()));
    assertEquals(0, UnitOfMeasureUtil.findWholePounds(BankersRounding.ZERO,
        new WeightUnitOfMeasureType("KILOGRAMS", "Friendly Type")));
  }

  /**
   * Method under test:
   * {@link UnitOfMeasureUtil#findPounds(BigDecimal, WeightUnitOfMeasureType)}
   */
  @Test
  public void testFindPounds() {
    // Arrange and Act
    BigDecimal actualFindPoundsResult = UnitOfMeasureUtil.findPounds(BankersRounding.ZERO,
        WeightUnitOfMeasureType.KILOGRAMS);

    // Assert
    assertEquals(new BigDecimal("0E-10"), actualFindPoundsResult);
  }

  /**
   * Method under test:
   * {@link UnitOfMeasureUtil#findPounds(BigDecimal, WeightUnitOfMeasureType)}
   */
  @Test
  public void testFindPounds2() {
    // Arrange and Act
    BigDecimal actualFindPoundsResult = UnitOfMeasureUtil.findPounds(BankersRounding.ZERO,
        WeightUnitOfMeasureType.POUNDS);

    // Assert
    assertEquals(new BigDecimal("0.00"), actualFindPoundsResult);
  }

  /**
   * Method under test:
   * {@link UnitOfMeasureUtil#findPounds(BigDecimal, WeightUnitOfMeasureType)}
   */
  @Test
  public void testFindPounds3() {
    // Arrange and Act
    BigDecimal actualFindPoundsResult = UnitOfMeasureUtil.findPounds(BankersRounding.ZERO,
        new WeightUnitOfMeasureType());

    // Assert
    assertEquals(new BigDecimal("0.00"), actualFindPoundsResult);
  }

  /**
   * Method under test:
   * {@link UnitOfMeasureUtil#findPounds(BigDecimal, WeightUnitOfMeasureType)}
   */
  @Test
  public void testFindPounds4() {
    // Arrange and Act
    BigDecimal actualFindPoundsResult = UnitOfMeasureUtil.findPounds(BankersRounding.ZERO,
        new WeightUnitOfMeasureType("KILOGRAMS", "Friendly Type"));

    // Assert
    assertEquals(new BigDecimal("0E-10"), actualFindPoundsResult);
  }

  /**
   * Method under test:
   * {@link UnitOfMeasureUtil#findRemainingOunces(BigDecimal, WeightUnitOfMeasureType)}
   */
  @Test
  public void testFindRemainingOunces() {
    // Arrange and Act
    BigDecimal actualFindRemainingOuncesResult = UnitOfMeasureUtil.findRemainingOunces(BankersRounding.ZERO,
        WeightUnitOfMeasureType.KILOGRAMS);

    // Assert
    assertEquals(new BigDecimal("0.0"), actualFindRemainingOuncesResult);
  }

  /**
   * Method under test:
   * {@link UnitOfMeasureUtil#findRemainingOunces(BigDecimal, WeightUnitOfMeasureType)}
   */
  @Test
  public void testFindRemainingOunces2() {
    // Arrange and Act
    BigDecimal actualFindRemainingOuncesResult = UnitOfMeasureUtil.findRemainingOunces(BankersRounding.ZERO,
        WeightUnitOfMeasureType.POUNDS);

    // Assert
    assertEquals(new BigDecimal("0.0"), actualFindRemainingOuncesResult);
  }

  /**
   * Method under test:
   * {@link UnitOfMeasureUtil#findRemainingOunces(BigDecimal, WeightUnitOfMeasureType)}
   */
  @Test
  public void testFindRemainingOunces3() {
    // Arrange and Act
    BigDecimal actualFindRemainingOuncesResult = UnitOfMeasureUtil.findRemainingOunces(BankersRounding.ZERO,
        new WeightUnitOfMeasureType());

    // Assert
    assertEquals(new BigDecimal("0.0"), actualFindRemainingOuncesResult);
  }

  /**
   * Method under test:
   * {@link UnitOfMeasureUtil#findRemainingOunces(BigDecimal, WeightUnitOfMeasureType)}
   */
  @Test
  public void testFindRemainingOunces4() {
    // Arrange and Act
    BigDecimal actualFindRemainingOuncesResult = UnitOfMeasureUtil.findRemainingOunces(BankersRounding.ZERO,
        new WeightUnitOfMeasureType("KILOGRAMS", "Friendly Type"));

    // Assert
    assertEquals(new BigDecimal("0.0"), actualFindRemainingOuncesResult);
  }

  /**
   * Method under test:
   * {@link UnitOfMeasureUtil#findOunces(BigDecimal, WeightUnitOfMeasureType)}
   */
  @Test
  public void testFindOunces() {
    // Arrange and Act
    BigDecimal actualFindOuncesResult = UnitOfMeasureUtil.findOunces(BankersRounding.ZERO,
        WeightUnitOfMeasureType.KILOGRAMS);

    // Assert
    assertEquals(new BigDecimal("0E-10"), actualFindOuncesResult);
  }

  /**
   * Method under test:
   * {@link UnitOfMeasureUtil#findOunces(BigDecimal, WeightUnitOfMeasureType)}
   */
  @Test
  public void testFindOunces2() {
    // Arrange and Act
    BigDecimal actualFindOuncesResult = UnitOfMeasureUtil.findOunces(BankersRounding.ZERO,
        WeightUnitOfMeasureType.POUNDS);

    // Assert
    assertEquals(new BigDecimal("0.00"), actualFindOuncesResult);
  }

  /**
   * Method under test:
   * {@link UnitOfMeasureUtil#findOunces(BigDecimal, WeightUnitOfMeasureType)}
   */
  @Test
  public void testFindOunces3() {
    // Arrange and Act
    BigDecimal actualFindOuncesResult = UnitOfMeasureUtil.findOunces(BankersRounding.ZERO,
        new WeightUnitOfMeasureType());

    // Assert
    assertEquals(new BigDecimal("0.00"), actualFindOuncesResult);
  }

  /**
   * Method under test:
   * {@link UnitOfMeasureUtil#findOunces(BigDecimal, WeightUnitOfMeasureType)}
   */
  @Test
  public void testFindOunces4() {
    // Arrange and Act
    BigDecimal actualFindOuncesResult = UnitOfMeasureUtil.findOunces(BankersRounding.ZERO,
        new WeightUnitOfMeasureType("KILOGRAMS", "Friendly Type"));

    // Assert
    assertEquals(new BigDecimal("0E-10"), actualFindOuncesResult);
  }

  /**
   * Method under test:
   * {@link UnitOfMeasureUtil#findInches(BigDecimal, DimensionUnitOfMeasureType)}
   */
  @Test
  public void testFindInches() {
    // Arrange and Act
    BigDecimal actualFindInchesResult = UnitOfMeasureUtil.findInches(BankersRounding.ZERO,
        DimensionUnitOfMeasureType.CENTIMETERS);

    // Assert
    assertEquals(new BigDecimal("0E-9"), actualFindInchesResult);
  }

  /**
   * Method under test:
   * {@link UnitOfMeasureUtil#findInches(BigDecimal, DimensionUnitOfMeasureType)}
   */
  @Test
  public void testFindInches2() {
    // Arrange and Act
    BigDecimal actualFindInchesResult = UnitOfMeasureUtil.findInches(BankersRounding.ZERO,
        DimensionUnitOfMeasureType.FEET);

    // Assert
    assertEquals(new BigDecimal("0.00"), actualFindInchesResult);
  }

  /**
   * Method under test:
   * {@link UnitOfMeasureUtil#findInches(BigDecimal, DimensionUnitOfMeasureType)}
   */
  @Test
  public void testFindInches3() {
    // Arrange and Act
    BigDecimal actualFindInchesResult = UnitOfMeasureUtil.findInches(BankersRounding.ZERO,
        DimensionUnitOfMeasureType.METERS);

    // Assert
    assertEquals(new BigDecimal("0E-7"), actualFindInchesResult);
  }

  /**
   * Method under test:
   * {@link UnitOfMeasureUtil#findInches(BigDecimal, DimensionUnitOfMeasureType)}
   */
  @Test
  public void testFindInches4() {
    // Arrange and Act
    BigDecimal actualFindInchesResult = UnitOfMeasureUtil.findInches(BankersRounding.ZERO,
        new DimensionUnitOfMeasureType("CENTIMETERS", "CENTIMETERS"));

    // Assert
    assertEquals(new BigDecimal("0E-9"), actualFindInchesResult);
  }

  /**
   * Method under test:
   * {@link UnitOfMeasureUtil#findInches(BigDecimal, DimensionUnitOfMeasureType)}
   */
  @Test
  public void testFindInches5() {
    // Arrange and Act
    BigDecimal actualFindInchesResult = UnitOfMeasureUtil.findInches(BankersRounding.ZERO,
        new DimensionUnitOfMeasureType());

    // Assert
    assertEquals(new BigDecimal("0.00"), actualFindInchesResult);
  }
}

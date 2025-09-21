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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.broadleafcommerce.common.money.BankersRounding;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class UnitOfMeasureUtilDiffblueTest {
  /**
   * Test {@link UnitOfMeasureUtil#convertKilogramsToPounds(BigDecimal)}.
   *
   * <ul>
   *   <li>When {@link BankersRounding#ZERO}.
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0E-10}.
   * </ul>
   *
   * <p>Method under test: {@link UnitOfMeasureUtil#convertKilogramsToPounds(BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal UnitOfMeasureUtil.convertKilogramsToPounds(BigDecimal)"})
  public void testConvertKilogramsToPounds_whenZero_thenReturnBigDecimalWith0e10() {
    // Arrange and Act
    BigDecimal actualConvertKilogramsToPoundsResult =
        UnitOfMeasureUtil.convertKilogramsToPounds(BankersRounding.ZERO);

    // Assert
    assertEquals(new BigDecimal("0E-10"), actualConvertKilogramsToPoundsResult);
  }

  /**
   * Test {@link UnitOfMeasureUtil#convertPoundsToKilograms(BigDecimal)}.
   *
   * <ul>
   *   <li>When {@link BankersRounding#ZERO}.
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0E-13}.
   * </ul>
   *
   * <p>Method under test: {@link UnitOfMeasureUtil#convertPoundsToKilograms(BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal UnitOfMeasureUtil.convertPoundsToKilograms(BigDecimal)"})
  public void testConvertPoundsToKilograms_whenZero_thenReturnBigDecimalWith0e13() {
    // Arrange and Act
    BigDecimal actualConvertPoundsToKilogramsResult =
        UnitOfMeasureUtil.convertPoundsToKilograms(BankersRounding.ZERO);

    // Assert
    assertEquals(new BigDecimal("0E-13"), actualConvertPoundsToKilogramsResult);
  }

  /**
   * Test {@link UnitOfMeasureUtil#convertPoundsToOunces(BigDecimal)}.
   *
   * <ul>
   *   <li>When {@link BankersRounding#ZERO}.
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link UnitOfMeasureUtil#convertPoundsToOunces(BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal UnitOfMeasureUtil.convertPoundsToOunces(BigDecimal)"})
  public void testConvertPoundsToOunces_whenZero_thenReturnBigDecimalWith000() {
    // Arrange and Act
    BigDecimal actualConvertPoundsToOuncesResult =
        UnitOfMeasureUtil.convertPoundsToOunces(BankersRounding.ZERO);

    // Assert
    assertEquals(new BigDecimal("0.00"), actualConvertPoundsToOuncesResult);
  }

  /**
   * Test {@link UnitOfMeasureUtil#convertOuncesToPounds(BigDecimal)}.
   *
   * <ul>
   *   <li>When {@link BankersRounding#ZERO}.
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0.000000}.
   * </ul>
   *
   * <p>Method under test: {@link UnitOfMeasureUtil#convertOuncesToPounds(BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal UnitOfMeasureUtil.convertOuncesToPounds(BigDecimal)"})
  public void testConvertOuncesToPounds_whenZero_thenReturnBigDecimalWith0000000() {
    // Arrange and Act
    BigDecimal actualConvertOuncesToPoundsResult =
        UnitOfMeasureUtil.convertOuncesToPounds(BankersRounding.ZERO);

    // Assert
    assertEquals(new BigDecimal("0.000000"), actualConvertOuncesToPoundsResult);
  }

  /**
   * Test {@link UnitOfMeasureUtil#convertFeetToMeters(BigDecimal)}.
   *
   * <ul>
   *   <li>When {@link BankersRounding#ZERO}.
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0.000000}.
   * </ul>
   *
   * <p>Method under test: {@link UnitOfMeasureUtil#convertFeetToMeters(BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal UnitOfMeasureUtil.convertFeetToMeters(BigDecimal)"})
  public void testConvertFeetToMeters_whenZero_thenReturnBigDecimalWith0000000() {
    // Arrange and Act
    BigDecimal actualConvertFeetToMetersResult =
        UnitOfMeasureUtil.convertFeetToMeters(BankersRounding.ZERO);

    // Assert
    assertEquals(new BigDecimal("0.000000"), actualConvertFeetToMetersResult);
  }

  /**
   * Test {@link UnitOfMeasureUtil#convertMetersToFeet(BigDecimal)}.
   *
   * <ul>
   *   <li>When {@link BankersRounding#ZERO}.
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0E-7}.
   * </ul>
   *
   * <p>Method under test: {@link UnitOfMeasureUtil#convertMetersToFeet(BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal UnitOfMeasureUtil.convertMetersToFeet(BigDecimal)"})
  public void testConvertMetersToFeet_whenZero_thenReturnBigDecimalWith0e7() {
    // Arrange and Act
    BigDecimal actualConvertMetersToFeetResult =
        UnitOfMeasureUtil.convertMetersToFeet(BankersRounding.ZERO);

    // Assert
    assertEquals(new BigDecimal("0E-7"), actualConvertMetersToFeetResult);
  }

  /**
   * Test {@link UnitOfMeasureUtil#convertInchesToFeet(BigDecimal)}.
   *
   * <ul>
   *   <li>When {@link BankersRounding#ZERO}.
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0E-8}.
   * </ul>
   *
   * <p>Method under test: {@link UnitOfMeasureUtil#convertInchesToFeet(BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal UnitOfMeasureUtil.convertInchesToFeet(BigDecimal)"})
  public void testConvertInchesToFeet_whenZero_thenReturnBigDecimalWith0e8() {
    // Arrange and Act
    BigDecimal actualConvertInchesToFeetResult =
        UnitOfMeasureUtil.convertInchesToFeet(BankersRounding.ZERO);

    // Assert
    assertEquals(new BigDecimal("0E-8"), actualConvertInchesToFeetResult);
  }

  /**
   * Test {@link UnitOfMeasureUtil#convertFeetToInches(BigDecimal)}.
   *
   * <ul>
   *   <li>When {@link BankersRounding#ZERO}.
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link UnitOfMeasureUtil#convertFeetToInches(BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal UnitOfMeasureUtil.convertFeetToInches(BigDecimal)"})
  public void testConvertFeetToInches_whenZero_thenReturnBigDecimalWith000() {
    // Arrange and Act
    BigDecimal actualConvertFeetToInchesResult =
        UnitOfMeasureUtil.convertFeetToInches(BankersRounding.ZERO);

    // Assert
    assertEquals(new BigDecimal("0.00"), actualConvertFeetToInchesResult);
  }

  /**
   * Test {@link UnitOfMeasureUtil#findWholePounds(BigDecimal, WeightUnitOfMeasureType)}.
   *
   * <p>Method under test: {@link UnitOfMeasureUtil#findWholePounds(BigDecimal,
   * WeightUnitOfMeasureType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int UnitOfMeasureUtil.findWholePounds(BigDecimal, WeightUnitOfMeasureType)"})
  public void testFindWholePounds() {
    // Arrange and Act
    int actualFindWholePoundsResult =
        UnitOfMeasureUtil.findWholePounds(
            BankersRounding.ZERO, new WeightUnitOfMeasureType("KILOGRAMS", "Friendly Type"));

    // Assert
    assertEquals(0, actualFindWholePoundsResult);
  }

  /**
   * Test {@link UnitOfMeasureUtil#findWholePounds(BigDecimal, WeightUnitOfMeasureType)}.
   *
   * <ul>
   *   <li>When {@link WeightUnitOfMeasureType#KILOGRAMS}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link UnitOfMeasureUtil#findWholePounds(BigDecimal,
   * WeightUnitOfMeasureType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int UnitOfMeasureUtil.findWholePounds(BigDecimal, WeightUnitOfMeasureType)"})
  public void testFindWholePounds_whenKilograms_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        UnitOfMeasureUtil.findWholePounds(BankersRounding.ZERO, WeightUnitOfMeasureType.KILOGRAMS));
  }

  /**
   * Test {@link UnitOfMeasureUtil#findWholePounds(BigDecimal, WeightUnitOfMeasureType)}.
   *
   * <ul>
   *   <li>When {@link WeightUnitOfMeasureType#POUNDS}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link UnitOfMeasureUtil#findWholePounds(BigDecimal,
   * WeightUnitOfMeasureType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int UnitOfMeasureUtil.findWholePounds(BigDecimal, WeightUnitOfMeasureType)"})
  public void testFindWholePounds_whenPounds_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0, UnitOfMeasureUtil.findWholePounds(BankersRounding.ZERO, WeightUnitOfMeasureType.POUNDS));
  }

  /**
   * Test {@link UnitOfMeasureUtil#findWholePounds(BigDecimal, WeightUnitOfMeasureType)}.
   *
   * <ul>
   *   <li>When {@link WeightUnitOfMeasureType#WeightUnitOfMeasureType()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link UnitOfMeasureUtil#findWholePounds(BigDecimal,
   * WeightUnitOfMeasureType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int UnitOfMeasureUtil.findWholePounds(BigDecimal, WeightUnitOfMeasureType)"})
  public void testFindWholePounds_whenWeightUnitOfMeasureType_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0, UnitOfMeasureUtil.findWholePounds(BankersRounding.ZERO, new WeightUnitOfMeasureType()));
  }

  /**
   * Test {@link UnitOfMeasureUtil#findPounds(BigDecimal, WeightUnitOfMeasureType)}.
   *
   * <ul>
   *   <li>When {@link WeightUnitOfMeasureType#KILOGRAMS}.
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0E-10}.
   * </ul>
   *
   * <p>Method under test: {@link UnitOfMeasureUtil#findPounds(BigDecimal, WeightUnitOfMeasureType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal UnitOfMeasureUtil.findPounds(BigDecimal, WeightUnitOfMeasureType)"
  })
  public void testFindPounds_whenKilograms_thenReturnBigDecimalWith0e10() {
    // Arrange and Act
    BigDecimal actualFindPoundsResult =
        UnitOfMeasureUtil.findPounds(BankersRounding.ZERO, WeightUnitOfMeasureType.KILOGRAMS);

    // Assert
    assertEquals(new BigDecimal("0E-10"), actualFindPoundsResult);
  }

  /**
   * Test {@link UnitOfMeasureUtil#findPounds(BigDecimal, WeightUnitOfMeasureType)}.
   *
   * <ul>
   *   <li>When {@link WeightUnitOfMeasureType#POUNDS}.
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link UnitOfMeasureUtil#findPounds(BigDecimal, WeightUnitOfMeasureType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal UnitOfMeasureUtil.findPounds(BigDecimal, WeightUnitOfMeasureType)"
  })
  public void testFindPounds_whenPounds_thenReturnBigDecimalWith000() {
    // Arrange and Act
    BigDecimal actualFindPoundsResult =
        UnitOfMeasureUtil.findPounds(BankersRounding.ZERO, WeightUnitOfMeasureType.POUNDS);

    // Assert
    assertEquals(new BigDecimal("0.00"), actualFindPoundsResult);
  }

  /**
   * Test {@link UnitOfMeasureUtil#findPounds(BigDecimal, WeightUnitOfMeasureType)}.
   *
   * <ul>
   *   <li>When {@link WeightUnitOfMeasureType#WeightUnitOfMeasureType(String, String)} with type is
   *       {@code KILOGRAMS} and {@code Friendly Type}.
   * </ul>
   *
   * <p>Method under test: {@link UnitOfMeasureUtil#findPounds(BigDecimal, WeightUnitOfMeasureType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal UnitOfMeasureUtil.findPounds(BigDecimal, WeightUnitOfMeasureType)"
  })
  public void testFindPounds_whenWeightUnitOfMeasureTypeWithTypeIsKilogramsAndFriendlyType() {
    // Arrange and Act
    BigDecimal actualFindPoundsResult =
        UnitOfMeasureUtil.findPounds(
            BankersRounding.ZERO, new WeightUnitOfMeasureType("KILOGRAMS", "Friendly Type"));

    // Assert
    assertEquals(new BigDecimal("0E-10"), actualFindPoundsResult);
  }

  /**
   * Test {@link UnitOfMeasureUtil#findPounds(BigDecimal, WeightUnitOfMeasureType)}.
   *
   * <ul>
   *   <li>When {@link WeightUnitOfMeasureType#WeightUnitOfMeasureType()}.
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link UnitOfMeasureUtil#findPounds(BigDecimal, WeightUnitOfMeasureType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal UnitOfMeasureUtil.findPounds(BigDecimal, WeightUnitOfMeasureType)"
  })
  public void testFindPounds_whenWeightUnitOfMeasureType_thenReturnBigDecimalWith000() {
    // Arrange and Act
    BigDecimal actualFindPoundsResult =
        UnitOfMeasureUtil.findPounds(BankersRounding.ZERO, new WeightUnitOfMeasureType());

    // Assert
    assertEquals(new BigDecimal("0.00"), actualFindPoundsResult);
  }

  /**
   * Test {@link UnitOfMeasureUtil#findRemainingOunces(BigDecimal, WeightUnitOfMeasureType)}.
   *
   * <p>Method under test: {@link UnitOfMeasureUtil#findRemainingOunces(BigDecimal,
   * WeightUnitOfMeasureType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal UnitOfMeasureUtil.findRemainingOunces(BigDecimal, WeightUnitOfMeasureType)"
  })
  public void testFindRemainingOunces() {
    // Arrange and Act
    BigDecimal actualFindRemainingOuncesResult =
        UnitOfMeasureUtil.findRemainingOunces(
            BankersRounding.ZERO, new WeightUnitOfMeasureType("KILOGRAMS", "Friendly Type"));

    // Assert
    assertEquals(new BigDecimal("0.0"), actualFindRemainingOuncesResult);
  }

  /**
   * Test {@link UnitOfMeasureUtil#findRemainingOunces(BigDecimal, WeightUnitOfMeasureType)}.
   *
   * <ul>
   *   <li>When {@link WeightUnitOfMeasureType#KILOGRAMS}.
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0.0}.
   * </ul>
   *
   * <p>Method under test: {@link UnitOfMeasureUtil#findRemainingOunces(BigDecimal,
   * WeightUnitOfMeasureType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal UnitOfMeasureUtil.findRemainingOunces(BigDecimal, WeightUnitOfMeasureType)"
  })
  public void testFindRemainingOunces_whenKilograms_thenReturnBigDecimalWith00() {
    // Arrange and Act
    BigDecimal actualFindRemainingOuncesResult =
        UnitOfMeasureUtil.findRemainingOunces(
            BankersRounding.ZERO, WeightUnitOfMeasureType.KILOGRAMS);

    // Assert
    assertEquals(new BigDecimal("0.0"), actualFindRemainingOuncesResult);
  }

  /**
   * Test {@link UnitOfMeasureUtil#findRemainingOunces(BigDecimal, WeightUnitOfMeasureType)}.
   *
   * <ul>
   *   <li>When {@link WeightUnitOfMeasureType#POUNDS}.
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0.0}.
   * </ul>
   *
   * <p>Method under test: {@link UnitOfMeasureUtil#findRemainingOunces(BigDecimal,
   * WeightUnitOfMeasureType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal UnitOfMeasureUtil.findRemainingOunces(BigDecimal, WeightUnitOfMeasureType)"
  })
  public void testFindRemainingOunces_whenPounds_thenReturnBigDecimalWith00() {
    // Arrange and Act
    BigDecimal actualFindRemainingOuncesResult =
        UnitOfMeasureUtil.findRemainingOunces(BankersRounding.ZERO, WeightUnitOfMeasureType.POUNDS);

    // Assert
    assertEquals(new BigDecimal("0.0"), actualFindRemainingOuncesResult);
  }

  /**
   * Test {@link UnitOfMeasureUtil#findRemainingOunces(BigDecimal, WeightUnitOfMeasureType)}.
   *
   * <ul>
   *   <li>When {@link WeightUnitOfMeasureType#WeightUnitOfMeasureType()}.
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0.0}.
   * </ul>
   *
   * <p>Method under test: {@link UnitOfMeasureUtil#findRemainingOunces(BigDecimal,
   * WeightUnitOfMeasureType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal UnitOfMeasureUtil.findRemainingOunces(BigDecimal, WeightUnitOfMeasureType)"
  })
  public void testFindRemainingOunces_whenWeightUnitOfMeasureType_thenReturnBigDecimalWith00() {
    // Arrange and Act
    BigDecimal actualFindRemainingOuncesResult =
        UnitOfMeasureUtil.findRemainingOunces(BankersRounding.ZERO, new WeightUnitOfMeasureType());

    // Assert
    assertEquals(new BigDecimal("0.0"), actualFindRemainingOuncesResult);
  }

  /**
   * Test {@link UnitOfMeasureUtil#findOunces(BigDecimal, WeightUnitOfMeasureType)}.
   *
   * <ul>
   *   <li>When {@link WeightUnitOfMeasureType#KILOGRAMS}.
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0E-10}.
   * </ul>
   *
   * <p>Method under test: {@link UnitOfMeasureUtil#findOunces(BigDecimal, WeightUnitOfMeasureType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal UnitOfMeasureUtil.findOunces(BigDecimal, WeightUnitOfMeasureType)"
  })
  public void testFindOunces_whenKilograms_thenReturnBigDecimalWith0e10() {
    // Arrange and Act
    BigDecimal actualFindOuncesResult =
        UnitOfMeasureUtil.findOunces(BankersRounding.ZERO, WeightUnitOfMeasureType.KILOGRAMS);

    // Assert
    assertEquals(new BigDecimal("0E-10"), actualFindOuncesResult);
  }

  /**
   * Test {@link UnitOfMeasureUtil#findOunces(BigDecimal, WeightUnitOfMeasureType)}.
   *
   * <ul>
   *   <li>When {@link WeightUnitOfMeasureType#POUNDS}.
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link UnitOfMeasureUtil#findOunces(BigDecimal, WeightUnitOfMeasureType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal UnitOfMeasureUtil.findOunces(BigDecimal, WeightUnitOfMeasureType)"
  })
  public void testFindOunces_whenPounds_thenReturnBigDecimalWith000() {
    // Arrange and Act
    BigDecimal actualFindOuncesResult =
        UnitOfMeasureUtil.findOunces(BankersRounding.ZERO, WeightUnitOfMeasureType.POUNDS);

    // Assert
    assertEquals(new BigDecimal("0.00"), actualFindOuncesResult);
  }

  /**
   * Test {@link UnitOfMeasureUtil#findOunces(BigDecimal, WeightUnitOfMeasureType)}.
   *
   * <ul>
   *   <li>When {@link WeightUnitOfMeasureType#WeightUnitOfMeasureType(String, String)} with type is
   *       {@code KILOGRAMS} and {@code Friendly Type}.
   * </ul>
   *
   * <p>Method under test: {@link UnitOfMeasureUtil#findOunces(BigDecimal, WeightUnitOfMeasureType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal UnitOfMeasureUtil.findOunces(BigDecimal, WeightUnitOfMeasureType)"
  })
  public void testFindOunces_whenWeightUnitOfMeasureTypeWithTypeIsKilogramsAndFriendlyType() {
    // Arrange and Act
    BigDecimal actualFindOuncesResult =
        UnitOfMeasureUtil.findOunces(
            BankersRounding.ZERO, new WeightUnitOfMeasureType("KILOGRAMS", "Friendly Type"));

    // Assert
    assertEquals(new BigDecimal("0E-10"), actualFindOuncesResult);
  }

  /**
   * Test {@link UnitOfMeasureUtil#findOunces(BigDecimal, WeightUnitOfMeasureType)}.
   *
   * <ul>
   *   <li>When {@link WeightUnitOfMeasureType#WeightUnitOfMeasureType()}.
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link UnitOfMeasureUtil#findOunces(BigDecimal, WeightUnitOfMeasureType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal UnitOfMeasureUtil.findOunces(BigDecimal, WeightUnitOfMeasureType)"
  })
  public void testFindOunces_whenWeightUnitOfMeasureType_thenReturnBigDecimalWith000() {
    // Arrange and Act
    BigDecimal actualFindOuncesResult =
        UnitOfMeasureUtil.findOunces(BankersRounding.ZERO, new WeightUnitOfMeasureType());

    // Assert
    assertEquals(new BigDecimal("0.00"), actualFindOuncesResult);
  }

  /**
   * Test {@link UnitOfMeasureUtil#findInches(BigDecimal, DimensionUnitOfMeasureType)}.
   *
   * <p>Method under test: {@link UnitOfMeasureUtil#findInches(BigDecimal,
   * DimensionUnitOfMeasureType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal UnitOfMeasureUtil.findInches(BigDecimal, DimensionUnitOfMeasureType)"
  })
  public void testFindInches() {
    // Arrange and Act
    BigDecimal actualFindInchesResult =
        UnitOfMeasureUtil.findInches(
            BankersRounding.ZERO, new DimensionUnitOfMeasureType("CENTIMETERS", "CENTIMETERS"));

    // Assert
    assertEquals(new BigDecimal("0E-9"), actualFindInchesResult);
  }

  /**
   * Test {@link UnitOfMeasureUtil#findInches(BigDecimal, DimensionUnitOfMeasureType)}.
   *
   * <ul>
   *   <li>When {@link DimensionUnitOfMeasureType#CENTIMETERS}.
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0E-9}.
   * </ul>
   *
   * <p>Method under test: {@link UnitOfMeasureUtil#findInches(BigDecimal,
   * DimensionUnitOfMeasureType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal UnitOfMeasureUtil.findInches(BigDecimal, DimensionUnitOfMeasureType)"
  })
  public void testFindInches_whenCentimeters_thenReturnBigDecimalWith0e9() {
    // Arrange and Act
    BigDecimal actualFindInchesResult =
        UnitOfMeasureUtil.findInches(BankersRounding.ZERO, DimensionUnitOfMeasureType.CENTIMETERS);

    // Assert
    assertEquals(new BigDecimal("0E-9"), actualFindInchesResult);
  }

  /**
   * Test {@link UnitOfMeasureUtil#findInches(BigDecimal, DimensionUnitOfMeasureType)}.
   *
   * <ul>
   *   <li>When {@link DimensionUnitOfMeasureType#DimensionUnitOfMeasureType()}.
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link UnitOfMeasureUtil#findInches(BigDecimal,
   * DimensionUnitOfMeasureType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal UnitOfMeasureUtil.findInches(BigDecimal, DimensionUnitOfMeasureType)"
  })
  public void testFindInches_whenDimensionUnitOfMeasureType_thenReturnBigDecimalWith000() {
    // Arrange and Act
    BigDecimal actualFindInchesResult =
        UnitOfMeasureUtil.findInches(BankersRounding.ZERO, new DimensionUnitOfMeasureType());

    // Assert
    assertEquals(new BigDecimal("0.00"), actualFindInchesResult);
  }

  /**
   * Test {@link UnitOfMeasureUtil#findInches(BigDecimal, DimensionUnitOfMeasureType)}.
   *
   * <ul>
   *   <li>When {@link DimensionUnitOfMeasureType#FEET}.
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link UnitOfMeasureUtil#findInches(BigDecimal,
   * DimensionUnitOfMeasureType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal UnitOfMeasureUtil.findInches(BigDecimal, DimensionUnitOfMeasureType)"
  })
  public void testFindInches_whenFeet_thenReturnBigDecimalWith000() {
    // Arrange and Act
    BigDecimal actualFindInchesResult =
        UnitOfMeasureUtil.findInches(BankersRounding.ZERO, DimensionUnitOfMeasureType.FEET);

    // Assert
    assertEquals(new BigDecimal("0.00"), actualFindInchesResult);
  }

  /**
   * Test {@link UnitOfMeasureUtil#findInches(BigDecimal, DimensionUnitOfMeasureType)}.
   *
   * <ul>
   *   <li>When {@link DimensionUnitOfMeasureType#METERS}.
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0E-7}.
   * </ul>
   *
   * <p>Method under test: {@link UnitOfMeasureUtil#findInches(BigDecimal,
   * DimensionUnitOfMeasureType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal UnitOfMeasureUtil.findInches(BigDecimal, DimensionUnitOfMeasureType)"
  })
  public void testFindInches_whenMeters_thenReturnBigDecimalWith0e7() {
    // Arrange and Act
    BigDecimal actualFindInchesResult =
        UnitOfMeasureUtil.findInches(BankersRounding.ZERO, DimensionUnitOfMeasureType.METERS);

    // Assert
    assertEquals(new BigDecimal("0E-7"), actualFindInchesResult);
  }
}

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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {TaxType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class TaxTypeDiffblueTest {
  @Autowired private TaxType taxType;

  /**
   * Test {@link TaxType#getInstance(String)}.
   *
   * <p>Method under test: {@link TaxType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TaxType TaxType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    TaxType actualInstance = TaxType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TaxType#TaxType()}
   *   <li>{@link TaxType#getFriendlyType()}
   *   <li>{@link TaxType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxType.<init>()",
    "String TaxType.getFriendlyType()",
    "String TaxType.getType()"
  })
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
   *
   * <p>Method under test: {@link TaxType#TaxType(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TaxType.<init>(String, String)"})
  public void testNewTaxType() {
    // Arrange and Act
    TaxType actualTaxType = new TaxType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualTaxType.getFriendlyType());
    assertEquals("Type", actualTaxType.getType());
  }

  /**
   * Test {@link TaxType#equals(Object)}, and {@link TaxType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TaxType#equals(Object)}
   *   <li>{@link TaxType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TaxType.equals(Object)", "int TaxType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TaxType taxType = TaxType.CITY;
    TaxType taxType2 = TaxType.CITY;

    // Act and Assert
    assertEquals(taxType, taxType2);
    assertEquals(taxType.hashCode(), taxType2.hashCode());
  }

  /**
   * Test {@link TaxType#equals(Object)}, and {@link TaxType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TaxType#equals(Object)}
   *   <li>{@link TaxType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TaxType.equals(Object)", "int TaxType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TaxType taxType = TaxType.COMBINED;
    TaxType taxType2 = new TaxType("COMBINED", "COMBINED");

    // Act and Assert
    assertEquals(taxType, taxType2);
    assertEquals(taxType.hashCode(), taxType2.hashCode());
  }

  /**
   * Test {@link TaxType#equals(Object)}, and {@link TaxType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TaxType#equals(Object)}
   *   <li>{@link TaxType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TaxType.equals(Object)", "int TaxType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TaxType taxType = new TaxType();
    TaxType taxType2 = new TaxType();

    // Act and Assert
    assertEquals(taxType, taxType2);
    assertEquals(taxType.hashCode(), taxType2.hashCode());
  }

  /**
   * Test {@link TaxType#equals(Object)}, and {@link TaxType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TaxType#equals(Object)}
   *   <li>{@link TaxType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TaxType.equals(Object)", "int TaxType.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TaxType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TaxType.equals(Object)", "int TaxType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TaxType.COMBINED, TaxType.CITY);
  }

  /**
   * Test {@link TaxType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TaxType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TaxType.equals(Object)", "int TaxType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new TaxType(), TaxType.CITY);
  }

  /**
   * Test {@link TaxType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TaxType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TaxType.equals(Object)", "int TaxType.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TaxType.CITY, null);
  }

  /**
   * Test {@link TaxType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TaxType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TaxType.equals(Object)", "int TaxType.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TaxType.CITY, "Different type to TaxType");
  }
}

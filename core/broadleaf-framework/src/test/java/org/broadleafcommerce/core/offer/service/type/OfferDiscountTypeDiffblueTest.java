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
package org.broadleafcommerce.core.offer.service.type;

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
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {OfferDiscountType.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferDiscountTypeDiffblueTest {
  @Autowired private OfferDiscountType offerDiscountType;

  /**
   * Test {@link OfferDiscountType#getInstance(String)}.
   *
   * <p>Method under test: {@link OfferDiscountType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OfferDiscountType OfferDiscountType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    OfferDiscountType actualInstance = OfferDiscountType.getInstance("Type");

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
   *   <li>{@link OfferDiscountType#OfferDiscountType()}
   *   <li>{@link OfferDiscountType#getFriendlyType()}
   *   <li>{@link OfferDiscountType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OfferDiscountType.<init>()",
    "String OfferDiscountType.getFriendlyType()",
    "String OfferDiscountType.getType()"
  })
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
   *
   * <p>Method under test: {@link OfferDiscountType#OfferDiscountType(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferDiscountType.<init>(String, String)"})
  public void testNewOfferDiscountType() {
    // Arrange and Act
    OfferDiscountType actualOfferDiscountType = new OfferDiscountType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualOfferDiscountType.getFriendlyType());
    assertEquals("Type", actualOfferDiscountType.getType());
  }

  /**
   * Test {@link OfferDiscountType#setType(String)}.
   *
   * <ul>
   *   <li>When {@code TypePERCENT_OFF}.
   *   <li>Then {@link OfferDiscountType} Type is {@code TypePERCENT_OFF}.
   * </ul>
   *
   * <p>Method under test: {@link OfferDiscountType#setType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferDiscountType.setType(String)"})
  public void testSetType_whenTypePERCENTOff_thenOfferDiscountTypeTypeIsTypePERCENTOff() {
    // Arrange and Act
    offerDiscountType.setType("TypePERCENT_OFF");

    // Assert
    assertEquals("TypePERCENT_OFF", offerDiscountType.getType());
  }

  /**
   * Test {@link OfferDiscountType#setType(String)}.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then {@link OfferDiscountType} Type is {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link OfferDiscountType#setType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferDiscountType.setType(String)"})
  public void testSetType_whenType_thenOfferDiscountTypeTypeIsType() {
    // Arrange and Act
    offerDiscountType.setType("Type");

    // Assert
    assertEquals("Type", offerDiscountType.getType());
  }

  /**
   * Test {@link OfferDiscountType#equals(Object)}, and {@link OfferDiscountType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferDiscountType#equals(Object)}
   *   <li>{@link OfferDiscountType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferDiscountType.equals(Object)",
    "int OfferDiscountType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OfferDiscountType offerDiscountType = OfferDiscountType.AMOUNT_OFF;
    OfferDiscountType offerDiscountType2 = OfferDiscountType.AMOUNT_OFF;

    // Act and Assert
    assertEquals(offerDiscountType, offerDiscountType2);
    assertEquals(offerDiscountType.hashCode(), offerDiscountType2.hashCode());
  }

  /**
   * Test {@link OfferDiscountType#equals(Object)}, and {@link OfferDiscountType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferDiscountType#equals(Object)}
   *   <li>{@link OfferDiscountType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferDiscountType.equals(Object)",
    "int OfferDiscountType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OfferDiscountType offerDiscountType = OfferDiscountType.FIX_PRICE;
    OfferDiscountType offerDiscountType2 = new OfferDiscountType("FIX_PRICE", "FIX_PRICE");

    // Act and Assert
    assertEquals(offerDiscountType, offerDiscountType2);
    assertEquals(offerDiscountType.hashCode(), offerDiscountType2.hashCode());
  }

  /**
   * Test {@link OfferDiscountType#equals(Object)}, and {@link OfferDiscountType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferDiscountType#equals(Object)}
   *   <li>{@link OfferDiscountType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferDiscountType.equals(Object)",
    "int OfferDiscountType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    OfferDiscountType offerDiscountType = new OfferDiscountType();
    OfferDiscountType offerDiscountType2 = new OfferDiscountType();

    // Act and Assert
    assertEquals(offerDiscountType, offerDiscountType2);
    assertEquals(offerDiscountType.hashCode(), offerDiscountType2.hashCode());
  }

  /**
   * Test {@link OfferDiscountType#equals(Object)}, and {@link OfferDiscountType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferDiscountType#equals(Object)}
   *   <li>{@link OfferDiscountType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferDiscountType.equals(Object)",
    "int OfferDiscountType.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferDiscountType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferDiscountType.equals(Object)",
    "int OfferDiscountType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferDiscountType.FIX_PRICE, OfferDiscountType.AMOUNT_OFF);
  }

  /**
   * Test {@link OfferDiscountType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferDiscountType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferDiscountType.equals(Object)",
    "int OfferDiscountType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new OfferDiscountType(), OfferDiscountType.AMOUNT_OFF);
  }

  /**
   * Test {@link OfferDiscountType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferDiscountType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferDiscountType.equals(Object)",
    "int OfferDiscountType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferDiscountType.AMOUNT_OFF, null);
  }

  /**
   * Test {@link OfferDiscountType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferDiscountType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferDiscountType.equals(Object)",
    "int OfferDiscountType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferDiscountType.AMOUNT_OFF, "Different type to OfferDiscountType");
  }
}

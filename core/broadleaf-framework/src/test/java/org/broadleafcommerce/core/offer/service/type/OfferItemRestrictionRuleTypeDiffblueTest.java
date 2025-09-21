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

@ContextConfiguration(classes = {OfferItemRestrictionRuleType.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferItemRestrictionRuleTypeDiffblueTest {
  @Autowired private OfferItemRestrictionRuleType offerItemRestrictionRuleType;

  /**
   * Test {@link OfferItemRestrictionRuleType#getInstance(String)}.
   *
   * <p>Method under test: {@link OfferItemRestrictionRuleType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OfferItemRestrictionRuleType OfferItemRestrictionRuleType.getInstance(String)"
  })
  public void testGetInstance() {
    // Arrange and Act
    OfferItemRestrictionRuleType actualInstance = OfferItemRestrictionRuleType.getInstance("Type");

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
   *   <li>{@link OfferItemRestrictionRuleType#OfferItemRestrictionRuleType()}
   *   <li>{@link OfferItemRestrictionRuleType#getFriendlyType()}
   *   <li>{@link OfferItemRestrictionRuleType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OfferItemRestrictionRuleType.<init>()",
    "String OfferItemRestrictionRuleType.getFriendlyType()",
    "String OfferItemRestrictionRuleType.getType()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    OfferItemRestrictionRuleType actualOfferItemRestrictionRuleType =
        new OfferItemRestrictionRuleType();
    String actualFriendlyType = actualOfferItemRestrictionRuleType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualOfferItemRestrictionRuleType.getType());
  }

  /**
   * Test {@link OfferItemRestrictionRuleType#OfferItemRestrictionRuleType(String, String)}.
   *
   * <p>Method under test: {@link OfferItemRestrictionRuleType#OfferItemRestrictionRuleType(String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferItemRestrictionRuleType.<init>(String, String)"})
  public void testNewOfferItemRestrictionRuleType() {
    // Arrange and Act
    OfferItemRestrictionRuleType actualOfferItemRestrictionRuleType =
        new OfferItemRestrictionRuleType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualOfferItemRestrictionRuleType.getFriendlyType());
    assertEquals("Type", actualOfferItemRestrictionRuleType.getType());
  }

  /**
   * Test {@link OfferItemRestrictionRuleType#setType(String)}.
   *
   * <ul>
   *   <li>When {@code TypeType}.
   *   <li>Then {@link OfferItemRestrictionRuleType} Type is {@code TypeType}.
   * </ul>
   *
   * <p>Method under test: {@link OfferItemRestrictionRuleType#setType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferItemRestrictionRuleType.setType(String)"})
  public void testSetType_whenTypeType_thenOfferItemRestrictionRuleTypeTypeIsTypeType() {
    // Arrange and Act
    offerItemRestrictionRuleType.setType("TypeType");

    // Assert
    assertEquals("TypeType", offerItemRestrictionRuleType.getType());
  }

  /**
   * Test {@link OfferItemRestrictionRuleType#setType(String)}.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then {@link OfferItemRestrictionRuleType} Type is {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link OfferItemRestrictionRuleType#setType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferItemRestrictionRuleType.setType(String)"})
  public void testSetType_whenType_thenOfferItemRestrictionRuleTypeTypeIsType() {
    // Arrange and Act
    offerItemRestrictionRuleType.setType("Type");

    // Assert
    assertEquals("Type", offerItemRestrictionRuleType.getType());
  }

  /**
   * Test {@link OfferItemRestrictionRuleType#equals(Object)}, and {@link
   * OfferItemRestrictionRuleType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferItemRestrictionRuleType#equals(Object)}
   *   <li>{@link OfferItemRestrictionRuleType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferItemRestrictionRuleType.equals(Object)",
    "int OfferItemRestrictionRuleType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OfferItemRestrictionRuleType offerItemRestrictionRuleType = OfferItemRestrictionRuleType.NONE;
    OfferItemRestrictionRuleType offerItemRestrictionRuleType2 = OfferItemRestrictionRuleType.NONE;

    // Act and Assert
    assertEquals(offerItemRestrictionRuleType, offerItemRestrictionRuleType2);
    assertEquals(offerItemRestrictionRuleType.hashCode(), offerItemRestrictionRuleType2.hashCode());
  }

  /**
   * Test {@link OfferItemRestrictionRuleType#equals(Object)}, and {@link
   * OfferItemRestrictionRuleType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferItemRestrictionRuleType#equals(Object)}
   *   <li>{@link OfferItemRestrictionRuleType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferItemRestrictionRuleType.equals(Object)",
    "int OfferItemRestrictionRuleType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OfferItemRestrictionRuleType offerItemRestrictionRuleType =
        OfferItemRestrictionRuleType.QUALIFIER;
    OfferItemRestrictionRuleType offerItemRestrictionRuleType2 =
        new OfferItemRestrictionRuleType("QUALIFIER", "QUALIFIER");

    // Act and Assert
    assertEquals(offerItemRestrictionRuleType, offerItemRestrictionRuleType2);
    assertEquals(offerItemRestrictionRuleType.hashCode(), offerItemRestrictionRuleType2.hashCode());
  }

  /**
   * Test {@link OfferItemRestrictionRuleType#equals(Object)}, and {@link
   * OfferItemRestrictionRuleType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferItemRestrictionRuleType#equals(Object)}
   *   <li>{@link OfferItemRestrictionRuleType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferItemRestrictionRuleType.equals(Object)",
    "int OfferItemRestrictionRuleType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    OfferItemRestrictionRuleType offerItemRestrictionRuleType = new OfferItemRestrictionRuleType();
    OfferItemRestrictionRuleType offerItemRestrictionRuleType2 = new OfferItemRestrictionRuleType();

    // Act and Assert
    assertEquals(offerItemRestrictionRuleType, offerItemRestrictionRuleType2);
    assertEquals(offerItemRestrictionRuleType.hashCode(), offerItemRestrictionRuleType2.hashCode());
  }

  /**
   * Test {@link OfferItemRestrictionRuleType#equals(Object)}, and {@link
   * OfferItemRestrictionRuleType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferItemRestrictionRuleType#equals(Object)}
   *   <li>{@link OfferItemRestrictionRuleType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferItemRestrictionRuleType.equals(Object)",
    "int OfferItemRestrictionRuleType.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferItemRestrictionRuleType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferItemRestrictionRuleType.equals(Object)",
    "int OfferItemRestrictionRuleType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferItemRestrictionRuleType.QUALIFIER, OfferItemRestrictionRuleType.NONE);
  }

  /**
   * Test {@link OfferItemRestrictionRuleType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferItemRestrictionRuleType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferItemRestrictionRuleType.equals(Object)",
    "int OfferItemRestrictionRuleType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new OfferItemRestrictionRuleType(), OfferItemRestrictionRuleType.NONE);
  }

  /**
   * Test {@link OfferItemRestrictionRuleType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferItemRestrictionRuleType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferItemRestrictionRuleType.equals(Object)",
    "int OfferItemRestrictionRuleType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferItemRestrictionRuleType.NONE, null);
  }

  /**
   * Test {@link OfferItemRestrictionRuleType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferItemRestrictionRuleType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferItemRestrictionRuleType.equals(Object)",
    "int OfferItemRestrictionRuleType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        OfferItemRestrictionRuleType.NONE, "Different type to OfferItemRestrictionRuleType");
  }
}

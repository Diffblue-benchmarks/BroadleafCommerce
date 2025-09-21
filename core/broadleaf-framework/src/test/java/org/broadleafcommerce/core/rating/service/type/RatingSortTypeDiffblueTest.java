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
package org.broadleafcommerce.core.rating.service.type;

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

@ContextConfiguration(classes = {RatingSortType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class RatingSortTypeDiffblueTest {
  @Autowired private RatingSortType ratingSortType;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RatingSortType#RatingSortType()}
   *   <li>{@link RatingSortType#getFriendlyType()}
   *   <li>{@link RatingSortType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RatingSortType.<init>()",
    "String RatingSortType.getFriendlyType()",
    "String RatingSortType.getType()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    RatingSortType actualRatingSortType = new RatingSortType();
    String actualFriendlyType = actualRatingSortType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualRatingSortType.getType());
  }

  /**
   * Test {@link RatingSortType#RatingSortType(String, String)}.
   *
   * <p>Method under test: {@link RatingSortType#RatingSortType(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RatingSortType.<init>(String, String)"})
  public void testNewRatingSortType() {
    // Arrange and Act
    RatingSortType actualRatingSortType = new RatingSortType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualRatingSortType.getFriendlyType());
    assertEquals("Type", actualRatingSortType.getType());
  }

  /**
   * Test {@link RatingSortType#RatingSortType(String)}.
   *
   * <ul>
   *   <li>When {@code DEFAULTType}.
   *   <li>Then return FriendlyType is {@code DEFAULTType}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSortType#RatingSortType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RatingSortType.<init>(String)"})
  public void testNewRatingSortType_whenDEFAULTType_thenReturnFriendlyTypeIsDEFAULTType() {
    // Arrange and Act
    RatingSortType actualRatingSortType = new RatingSortType("DEFAULTType");

    // Assert
    assertEquals("DEFAULTType", actualRatingSortType.getFriendlyType());
    assertEquals("DEFAULTType", actualRatingSortType.getType());
  }

  /**
   * Test {@link RatingSortType#RatingSortType(String)}.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then return FriendlyType is {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSortType#RatingSortType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RatingSortType.<init>(String)"})
  public void testNewRatingSortType_whenType_thenReturnFriendlyTypeIsType() {
    // Arrange and Act
    RatingSortType actualRatingSortType = new RatingSortType("Type");

    // Assert
    assertEquals("Type", actualRatingSortType.getFriendlyType());
    assertEquals("Type", actualRatingSortType.getType());
  }

  /**
   * Test {@link RatingSortType#equals(Object)}, and {@link RatingSortType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RatingSortType#equals(Object)}
   *   <li>{@link RatingSortType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RatingSortType.equals(Object)", "int RatingSortType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RatingSortType ratingSortType = RatingSortType.DEFAULT;
    RatingSortType ratingSortType2 = RatingSortType.DEFAULT;

    // Act and Assert
    assertEquals(ratingSortType, ratingSortType2);
    assertEquals(ratingSortType.hashCode(), ratingSortType2.hashCode());
  }

  /**
   * Test {@link RatingSortType#equals(Object)}, and {@link RatingSortType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RatingSortType#equals(Object)}
   *   <li>{@link RatingSortType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RatingSortType.equals(Object)", "int RatingSortType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RatingSortType ratingSortType = RatingSortType.MOST_HELPFUL;
    RatingSortType ratingSortType2 = new RatingSortType("MOST_HELPFUL");

    // Act and Assert
    assertEquals(ratingSortType, ratingSortType2);
    assertEquals(ratingSortType.hashCode(), ratingSortType2.hashCode());
  }

  /**
   * Test {@link RatingSortType#equals(Object)}, and {@link RatingSortType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RatingSortType#equals(Object)}
   *   <li>{@link RatingSortType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RatingSortType.equals(Object)", "int RatingSortType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    RatingSortType ratingSortType = new RatingSortType();
    RatingSortType ratingSortType2 = new RatingSortType();

    // Act and Assert
    assertEquals(ratingSortType, ratingSortType2);
    assertEquals(ratingSortType.hashCode(), ratingSortType2.hashCode());
  }

  /**
   * Test {@link RatingSortType#equals(Object)}, and {@link RatingSortType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RatingSortType#equals(Object)}
   *   <li>{@link RatingSortType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RatingSortType.equals(Object)", "int RatingSortType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RatingSortType ratingSortType = RatingSortType.DEFAULT;

    // Act and Assert
    assertEquals(ratingSortType, ratingSortType);
    int expectedHashCodeResult = ratingSortType.hashCode();
    assertEquals(expectedHashCodeResult, ratingSortType.hashCode());
  }

  /**
   * Test {@link RatingSortType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RatingSortType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RatingSortType.equals(Object)", "int RatingSortType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RatingSortType.MOST_HELPFUL, RatingSortType.DEFAULT);
  }

  /**
   * Test {@link RatingSortType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RatingSortType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RatingSortType.equals(Object)", "int RatingSortType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new RatingSortType(), RatingSortType.DEFAULT);
  }

  /**
   * Test {@link RatingSortType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RatingSortType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RatingSortType.equals(Object)", "int RatingSortType.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RatingSortType.DEFAULT, null);
  }

  /**
   * Test {@link RatingSortType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RatingSortType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RatingSortType.equals(Object)", "int RatingSortType.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RatingSortType.DEFAULT, "Different type to RatingSortType");
  }
}

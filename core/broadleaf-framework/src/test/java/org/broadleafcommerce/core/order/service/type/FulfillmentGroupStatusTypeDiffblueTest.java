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
package org.broadleafcommerce.core.order.service.type;

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

@ContextConfiguration(classes = {FulfillmentGroupStatusType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FulfillmentGroupStatusTypeDiffblueTest {
  @Autowired private FulfillmentGroupStatusType fulfillmentGroupStatusType;

  /**
   * Test {@link FulfillmentGroupStatusType#getInstance(String)}.
   *
   * <p>Method under test: {@link FulfillmentGroupStatusType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FulfillmentGroupStatusType FulfillmentGroupStatusType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    FulfillmentGroupStatusType actualInstance = FulfillmentGroupStatusType.getInstance("Type");

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
   *   <li>{@link FulfillmentGroupStatusType#FulfillmentGroupStatusType()}
   *   <li>{@link FulfillmentGroupStatusType#getFriendlyType()}
   *   <li>{@link FulfillmentGroupStatusType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FulfillmentGroupStatusType.<init>()",
    "String FulfillmentGroupStatusType.getFriendlyType()",
    "String FulfillmentGroupStatusType.getType()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    FulfillmentGroupStatusType actualFulfillmentGroupStatusType = new FulfillmentGroupStatusType();
    String actualFriendlyType = actualFulfillmentGroupStatusType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualFulfillmentGroupStatusType.getType());
  }

  /**
   * Test {@link FulfillmentGroupStatusType#FulfillmentGroupStatusType(String, String)}.
   *
   * <p>Method under test: {@link FulfillmentGroupStatusType#FulfillmentGroupStatusType(String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupStatusType.<init>(String, String)"})
  public void testNewFulfillmentGroupStatusType() {
    // Arrange and Act
    FulfillmentGroupStatusType actualFulfillmentGroupStatusType =
        new FulfillmentGroupStatusType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualFulfillmentGroupStatusType.getFriendlyType());
    assertEquals("Type", actualFulfillmentGroupStatusType.getType());
  }

  /**
   * Test {@link FulfillmentGroupStatusType#equals(Object)}, and {@link
   * FulfillmentGroupStatusType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupStatusType#equals(Object)}
   *   <li>{@link FulfillmentGroupStatusType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupStatusType.equals(Object)",
    "int FulfillmentGroupStatusType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FulfillmentGroupStatusType fulfillmentGroupStatusType = FulfillmentGroupStatusType.CANCELLED;
    FulfillmentGroupStatusType fulfillmentGroupStatusType2 = FulfillmentGroupStatusType.CANCELLED;

    // Act and Assert
    assertEquals(fulfillmentGroupStatusType, fulfillmentGroupStatusType2);
    assertEquals(fulfillmentGroupStatusType.hashCode(), fulfillmentGroupStatusType2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupStatusType#equals(Object)}, and {@link
   * FulfillmentGroupStatusType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupStatusType#equals(Object)}
   *   <li>{@link FulfillmentGroupStatusType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupStatusType.equals(Object)",
    "int FulfillmentGroupStatusType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    FulfillmentGroupStatusType fulfillmentGroupStatusType = FulfillmentGroupStatusType.DELIVERED;
    FulfillmentGroupStatusType fulfillmentGroupStatusType2 =
        new FulfillmentGroupStatusType("DELIVERED", "DELIVERED");

    // Act and Assert
    assertEquals(fulfillmentGroupStatusType, fulfillmentGroupStatusType2);
    assertEquals(fulfillmentGroupStatusType.hashCode(), fulfillmentGroupStatusType2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupStatusType#equals(Object)}, and {@link
   * FulfillmentGroupStatusType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupStatusType#equals(Object)}
   *   <li>{@link FulfillmentGroupStatusType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupStatusType.equals(Object)",
    "int FulfillmentGroupStatusType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    FulfillmentGroupStatusType fulfillmentGroupStatusType = new FulfillmentGroupStatusType();
    FulfillmentGroupStatusType fulfillmentGroupStatusType2 = new FulfillmentGroupStatusType();

    // Act and Assert
    assertEquals(fulfillmentGroupStatusType, fulfillmentGroupStatusType2);
    assertEquals(fulfillmentGroupStatusType.hashCode(), fulfillmentGroupStatusType2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupStatusType#equals(Object)}, and {@link
   * FulfillmentGroupStatusType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupStatusType#equals(Object)}
   *   <li>{@link FulfillmentGroupStatusType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupStatusType.equals(Object)",
    "int FulfillmentGroupStatusType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FulfillmentGroupStatusType fulfillmentGroupStatusType = FulfillmentGroupStatusType.CANCELLED;

    // Act and Assert
    assertEquals(fulfillmentGroupStatusType, fulfillmentGroupStatusType);
    int expectedHashCodeResult = fulfillmentGroupStatusType.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentGroupStatusType.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupStatusType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupStatusType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupStatusType.equals(Object)",
    "int FulfillmentGroupStatusType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FulfillmentGroupStatusType.DELIVERED, FulfillmentGroupStatusType.CANCELLED);
  }

  /**
   * Test {@link FulfillmentGroupStatusType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupStatusType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupStatusType.equals(Object)",
    "int FulfillmentGroupStatusType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new FulfillmentGroupStatusType(), FulfillmentGroupStatusType.CANCELLED);
  }

  /**
   * Test {@link FulfillmentGroupStatusType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupStatusType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupStatusType.equals(Object)",
    "int FulfillmentGroupStatusType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FulfillmentGroupStatusType.CANCELLED, null);
  }

  /**
   * Test {@link FulfillmentGroupStatusType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupStatusType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupStatusType.equals(Object)",
    "int FulfillmentGroupStatusType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        FulfillmentGroupStatusType.CANCELLED, "Different type to FulfillmentGroupStatusType");
  }
}

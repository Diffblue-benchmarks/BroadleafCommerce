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
package org.broadleafcommerce.core.inventory.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AvailabilityStatusTypeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AvailabilityStatusType#AvailabilityStatusType()}
   *   <li>{@link AvailabilityStatusType#getFriendlyType()}
   *   <li>{@link AvailabilityStatusType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AvailabilityStatusType.<init>()",
    "String AvailabilityStatusType.getFriendlyType()",
    "String AvailabilityStatusType.getType()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    AvailabilityStatusType actualAvailabilityStatusType = new AvailabilityStatusType();
    String actualFriendlyType = actualAvailabilityStatusType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualAvailabilityStatusType.getType());
  }

  /**
   * Test {@link AvailabilityStatusType#equals(Object)}, and {@link
   * AvailabilityStatusType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AvailabilityStatusType#equals(Object)}
   *   <li>{@link AvailabilityStatusType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AvailabilityStatusType.equals(Object)",
    "int AvailabilityStatusType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AvailabilityStatusType availabilityStatusType = AvailabilityStatusType.AVAILABLE;
    AvailabilityStatusType availabilityStatusType2 = AvailabilityStatusType.AVAILABLE;

    // Act and Assert
    assertEquals(availabilityStatusType, availabilityStatusType2);
    assertEquals(availabilityStatusType.hashCode(), availabilityStatusType2.hashCode());
  }

  /**
   * Test {@link AvailabilityStatusType#equals(Object)}, and {@link
   * AvailabilityStatusType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AvailabilityStatusType#equals(Object)}
   *   <li>{@link AvailabilityStatusType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AvailabilityStatusType.equals(Object)",
    "int AvailabilityStatusType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AvailabilityStatusType availabilityStatusType = new AvailabilityStatusType();
    AvailabilityStatusType availabilityStatusType2 = new AvailabilityStatusType();

    // Act and Assert
    assertEquals(availabilityStatusType, availabilityStatusType2);
    assertEquals(availabilityStatusType.hashCode(), availabilityStatusType2.hashCode());
  }

  /**
   * Test {@link AvailabilityStatusType#equals(Object)}, and {@link
   * AvailabilityStatusType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AvailabilityStatusType#equals(Object)}
   *   <li>{@link AvailabilityStatusType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AvailabilityStatusType.equals(Object)",
    "int AvailabilityStatusType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AvailabilityStatusType availabilityStatusType = AvailabilityStatusType.AVAILABLE;

    // Act and Assert
    assertEquals(availabilityStatusType, availabilityStatusType);
    int expectedHashCodeResult = availabilityStatusType.hashCode();
    assertEquals(expectedHashCodeResult, availabilityStatusType.hashCode());
  }

  /**
   * Test {@link AvailabilityStatusType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AvailabilityStatusType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AvailabilityStatusType.equals(Object)",
    "int AvailabilityStatusType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AvailabilityStatusType.BACKORDERED, AvailabilityStatusType.AVAILABLE);
  }

  /**
   * Test {@link AvailabilityStatusType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AvailabilityStatusType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AvailabilityStatusType.equals(Object)",
    "int AvailabilityStatusType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new AvailabilityStatusType(), AvailabilityStatusType.AVAILABLE);
  }

  /**
   * Test {@link AvailabilityStatusType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AvailabilityStatusType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AvailabilityStatusType.equals(Object)",
    "int AvailabilityStatusType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AvailabilityStatusType.AVAILABLE, null);
  }

  /**
   * Test {@link AvailabilityStatusType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AvailabilityStatusType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AvailabilityStatusType.equals(Object)",
    "int AvailabilityStatusType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AvailabilityStatusType.AVAILABLE, "Different type to AvailabilityStatusType");
  }
}

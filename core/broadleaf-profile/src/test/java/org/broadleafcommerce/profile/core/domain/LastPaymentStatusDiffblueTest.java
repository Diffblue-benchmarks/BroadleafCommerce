/*-
 * #%L
 * BroadleafCommerce Profile
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
package org.broadleafcommerce.profile.core.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class LastPaymentStatusDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LastPaymentStatus#LastPaymentStatus()}
   *   <li>{@link LastPaymentStatus#getFriendlyType()}
   *   <li>{@link LastPaymentStatus#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    LastPaymentStatus actualLastPaymentStatus = new LastPaymentStatus();
    String actualFriendlyType = actualLastPaymentStatus.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualLastPaymentStatus.getType());
  }

  /**
   * Test {@link LastPaymentStatus#equals(Object)}, and
   * {@link LastPaymentStatus#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LastPaymentStatus#equals(Object)}
   *   <li>{@link LastPaymentStatus#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LastPaymentStatus lastPaymentStatus = LastPaymentStatus.ERROR;
    LastPaymentStatus lastPaymentStatus2 = LastPaymentStatus.ERROR;

    // Act and Assert
    assertEquals(lastPaymentStatus, lastPaymentStatus2);
    int expectedHashCodeResult = lastPaymentStatus.hashCode();
    assertEquals(expectedHashCodeResult, lastPaymentStatus2.hashCode());
  }

  /**
   * Test {@link LastPaymentStatus#equals(Object)}, and
   * {@link LastPaymentStatus#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LastPaymentStatus#equals(Object)}
   *   <li>{@link LastPaymentStatus#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    LastPaymentStatus lastPaymentStatus = new LastPaymentStatus();
    LastPaymentStatus lastPaymentStatus2 = new LastPaymentStatus();

    // Act and Assert
    assertEquals(lastPaymentStatus, lastPaymentStatus2);
    int expectedHashCodeResult = lastPaymentStatus.hashCode();
    assertEquals(expectedHashCodeResult, lastPaymentStatus2.hashCode());
  }

  /**
   * Test {@link LastPaymentStatus#equals(Object)}, and
   * {@link LastPaymentStatus#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LastPaymentStatus#equals(Object)}
   *   <li>{@link LastPaymentStatus#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LastPaymentStatus lastPaymentStatus = LastPaymentStatus.ERROR;

    // Act and Assert
    assertEquals(lastPaymentStatus, lastPaymentStatus);
    int expectedHashCodeResult = lastPaymentStatus.hashCode();
    assertEquals(expectedHashCodeResult, lastPaymentStatus.hashCode());
  }

  /**
   * Test {@link LastPaymentStatus#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LastPaymentStatus#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(LastPaymentStatus.OK, LastPaymentStatus.ERROR);
    assertNotEquals(new LastPaymentStatus(), LastPaymentStatus.ERROR);
  }

  /**
   * Test {@link LastPaymentStatus#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LastPaymentStatus#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(LastPaymentStatus.ERROR, null);
  }

  /**
   * Test {@link LastPaymentStatus#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LastPaymentStatus#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(LastPaymentStatus.ERROR, "Different type to LastPaymentStatus");
  }
}

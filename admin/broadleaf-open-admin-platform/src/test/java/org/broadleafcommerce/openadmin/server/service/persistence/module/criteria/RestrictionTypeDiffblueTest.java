/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class RestrictionTypeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RestrictionType#RestrictionType()}
   *   <li>{@link RestrictionType#getFriendlyType()}
   *   <li>{@link RestrictionType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    RestrictionType actualRestrictionType = new RestrictionType();
    String actualFriendlyType = actualRestrictionType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualRestrictionType.getType());
  }

  /**
   * Test {@link RestrictionType#equals(Object)}, and
   * {@link RestrictionType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RestrictionType#equals(Object)}
   *   <li>{@link RestrictionType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RestrictionType restrictionType = RestrictionType.BOOLEAN;
    RestrictionType restrictionType2 = RestrictionType.BOOLEAN;

    // Act and Assert
    assertEquals(restrictionType, restrictionType2);
    int expectedHashCodeResult = restrictionType.hashCode();
    assertEquals(expectedHashCodeResult, restrictionType2.hashCode());
  }

  /**
   * Test {@link RestrictionType#equals(Object)}, and
   * {@link RestrictionType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RestrictionType#equals(Object)}
   *   <li>{@link RestrictionType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RestrictionType restrictionType = new RestrictionType();
    RestrictionType restrictionType2 = new RestrictionType();

    // Act and Assert
    assertEquals(restrictionType, restrictionType2);
    int expectedHashCodeResult = restrictionType.hashCode();
    assertEquals(expectedHashCodeResult, restrictionType2.hashCode());
  }

  /**
   * Test {@link RestrictionType#equals(Object)}, and
   * {@link RestrictionType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RestrictionType#equals(Object)}
   *   <li>{@link RestrictionType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RestrictionType restrictionType = RestrictionType.BOOLEAN;

    // Act and Assert
    assertEquals(restrictionType, restrictionType);
    int expectedHashCodeResult = restrictionType.hashCode();
    assertEquals(expectedHashCodeResult, restrictionType.hashCode());
  }

  /**
   * Test {@link RestrictionType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestrictionType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RestrictionType.CHARACTER, RestrictionType.BOOLEAN);
    assertNotEquals(new RestrictionType(), RestrictionType.BOOLEAN);
  }

  /**
   * Test {@link RestrictionType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestrictionType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RestrictionType.BOOLEAN, null);
  }

  /**
   * Test {@link RestrictionType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestrictionType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RestrictionType.BOOLEAN, "Different type to RestrictionType");
  }
}

/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.vendor.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class ServiceStatusTypeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ServiceStatusType#ServiceStatusType()}
   *   <li>{@link ServiceStatusType#getFriendlyType()}
   *   <li>{@link ServiceStatusType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ServiceStatusType actualServiceStatusType = new ServiceStatusType();
    String actualFriendlyType = actualServiceStatusType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualServiceStatusType.getType());
  }

  /**
   * Test {@link ServiceStatusType#equals(Object)}, and
   * {@link ServiceStatusType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ServiceStatusType#equals(Object)}
   *   <li>{@link ServiceStatusType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ServiceStatusType serviceStatusType = ServiceStatusType.DOWN;
    ServiceStatusType serviceStatusType2 = ServiceStatusType.DOWN;

    // Act and Assert
    assertEquals(serviceStatusType, serviceStatusType2);
    int expectedHashCodeResult = serviceStatusType.hashCode();
    assertEquals(expectedHashCodeResult, serviceStatusType2.hashCode());
  }

  /**
   * Test {@link ServiceStatusType#equals(Object)}, and
   * {@link ServiceStatusType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ServiceStatusType#equals(Object)}
   *   <li>{@link ServiceStatusType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ServiceStatusType serviceStatusType = new ServiceStatusType();
    ServiceStatusType serviceStatusType2 = new ServiceStatusType();

    // Act and Assert
    assertEquals(serviceStatusType, serviceStatusType2);
    int expectedHashCodeResult = serviceStatusType.hashCode();
    assertEquals(expectedHashCodeResult, serviceStatusType2.hashCode());
  }

  /**
   * Test {@link ServiceStatusType#equals(Object)}, and
   * {@link ServiceStatusType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ServiceStatusType#equals(Object)}
   *   <li>{@link ServiceStatusType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ServiceStatusType serviceStatusType = ServiceStatusType.DOWN;

    // Act and Assert
    assertEquals(serviceStatusType, serviceStatusType);
    int expectedHashCodeResult = serviceStatusType.hashCode();
    assertEquals(expectedHashCodeResult, serviceStatusType.hashCode());
  }

  /**
   * Test {@link ServiceStatusType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServiceStatusType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ServiceStatusType.PAUSED, ServiceStatusType.DOWN);
    assertNotEquals(new ServiceStatusType(), ServiceStatusType.DOWN);
  }

  /**
   * Test {@link ServiceStatusType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServiceStatusType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ServiceStatusType.DOWN, null);
  }

  /**
   * Test {@link ServiceStatusType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServiceStatusType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ServiceStatusType.DOWN, "Different type to ServiceStatusType");
  }
}

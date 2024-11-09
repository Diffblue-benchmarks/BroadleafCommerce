/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.payment.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {OrderPaymentStatus.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderPaymentStatusDiffblueTest {
  @Autowired
  private OrderPaymentStatus orderPaymentStatus;

  /**
   * Test {@link OrderPaymentStatus#getInstance(String)}.
   * <p>
   * Method under test: {@link OrderPaymentStatus#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    OrderPaymentStatus actualInstance = OrderPaymentStatus.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderPaymentStatus#OrderPaymentStatus()}
   *   <li>{@link OrderPaymentStatus#getFriendlyType()}
   *   <li>{@link OrderPaymentStatus#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    OrderPaymentStatus actualOrderPaymentStatus = new OrderPaymentStatus();
    String actualFriendlyType = actualOrderPaymentStatus.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualOrderPaymentStatus.getType());
  }

  /**
   * Test {@link OrderPaymentStatus#OrderPaymentStatus(String, String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then return {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatus#OrderPaymentStatus(String, String)}
   */
  @Test
  public void testNewOrderPaymentStatus_whenType_thenReturnType() {
    // Arrange and Act
    OrderPaymentStatus actualOrderPaymentStatus = new OrderPaymentStatus("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualOrderPaymentStatus.getFriendlyType());
    assertEquals("Type", actualOrderPaymentStatus.getType());
  }

  /**
   * Test {@link OrderPaymentStatus#OrderPaymentStatus(String, String)}.
   * <ul>
   *   <li>When {@code Undetermined}.</li>
   *   <li>Then return Type is {@code Undetermined}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatus#OrderPaymentStatus(String, String)}
   */
  @Test
  public void testNewOrderPaymentStatus_whenUndetermined_thenReturnTypeIsUndetermined() {
    // Arrange and Act
    OrderPaymentStatus actualOrderPaymentStatus = new OrderPaymentStatus("Undetermined", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualOrderPaymentStatus.getFriendlyType());
    assertEquals("Undetermined", actualOrderPaymentStatus.getType());
  }

  /**
   * Test {@link OrderPaymentStatus#equals(Object)}, and
   * {@link OrderPaymentStatus#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderPaymentStatus#equals(Object)}
   *   <li>{@link OrderPaymentStatus#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OrderPaymentStatus orderPaymentStatus = OrderPaymentStatus.AUTHORIZED;
    OrderPaymentStatus orderPaymentStatus2 = OrderPaymentStatus.AUTHORIZED;

    // Act and Assert
    assertEquals(orderPaymentStatus, orderPaymentStatus2);
    int expectedHashCodeResult = orderPaymentStatus.hashCode();
    assertEquals(expectedHashCodeResult, orderPaymentStatus2.hashCode());
  }

  /**
   * Test {@link OrderPaymentStatus#equals(Object)}, and
   * {@link OrderPaymentStatus#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderPaymentStatus#equals(Object)}
   *   <li>{@link OrderPaymentStatus#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OrderPaymentStatus orderPaymentStatus = new OrderPaymentStatus();
    OrderPaymentStatus orderPaymentStatus2 = new OrderPaymentStatus();

    // Act and Assert
    assertEquals(orderPaymentStatus, orderPaymentStatus2);
    int expectedHashCodeResult = orderPaymentStatus.hashCode();
    assertEquals(expectedHashCodeResult, orderPaymentStatus2.hashCode());
  }

  /**
   * Test {@link OrderPaymentStatus#equals(Object)}, and
   * {@link OrderPaymentStatus#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderPaymentStatus#equals(Object)}
   *   <li>{@link OrderPaymentStatus#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    OrderPaymentStatus orderPaymentStatus = new OrderPaymentStatus("AUTHORIZED", "Friendly Type");
    OrderPaymentStatus orderPaymentStatus2 = OrderPaymentStatus.AUTHORIZED;

    // Act and Assert
    assertEquals(orderPaymentStatus, orderPaymentStatus2);
    int expectedHashCodeResult = orderPaymentStatus.hashCode();
    assertEquals(expectedHashCodeResult, orderPaymentStatus2.hashCode());
  }

  /**
   * Test {@link OrderPaymentStatus#equals(Object)}, and
   * {@link OrderPaymentStatus#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderPaymentStatus#equals(Object)}
   *   <li>{@link OrderPaymentStatus#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OrderPaymentStatus orderPaymentStatus = OrderPaymentStatus.AUTHORIZED;

    // Act and Assert
    assertEquals(orderPaymentStatus, orderPaymentStatus);
    int expectedHashCodeResult = orderPaymentStatus.hashCode();
    assertEquals(expectedHashCodeResult, orderPaymentStatus.hashCode());
  }

  /**
   * Test {@link OrderPaymentStatus#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatus#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OrderPaymentStatus.COMPLETE, OrderPaymentStatus.AUTHORIZED);
    assertNotEquals(new OrderPaymentStatus(), OrderPaymentStatus.AUTHORIZED);
  }

  /**
   * Test {@link OrderPaymentStatus#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatus#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OrderPaymentStatus.AUTHORIZED, null);
  }

  /**
   * Test {@link OrderPaymentStatus#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatus#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OrderPaymentStatus.AUTHORIZED, "Different type to OrderPaymentStatus");
  }
}

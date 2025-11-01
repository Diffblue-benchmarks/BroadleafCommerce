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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {CustomerMaxUsesStrategyType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerMaxUsesStrategyTypeDiffblueTest {
  @Autowired
  private CustomerMaxUsesStrategyType customerMaxUsesStrategyType;

  /**
   * Method under test: {@link CustomerMaxUsesStrategyType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    CustomerMaxUsesStrategyType actualInstance = CustomerMaxUsesStrategyType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Method under test: {@link CustomerMaxUsesStrategyType#setType(String)}
   */
  @Test
  public void testSetType() {
    // Arrange
    CustomerMaxUsesStrategyType customerMaxUsesStrategyType2 = CustomerMaxUsesStrategyType.ACCOUNT;

    // Act
    customerMaxUsesStrategyType2.setType("Type");

    // Assert
    assertEquals("Type", customerMaxUsesStrategyType2.getType());
  }

  /**
   * Method under test: {@link CustomerMaxUsesStrategyType#setType(String)}
   */
  @Test
  public void testSetType2() {
    // Arrange
    CustomerMaxUsesStrategyType customerMaxUsesStrategyType2 = CustomerMaxUsesStrategyType.ACCOUNT;

    // Act
    customerMaxUsesStrategyType2.setType("TypeType");

    // Assert
    assertEquals("TypeType", customerMaxUsesStrategyType2.getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerMaxUsesStrategyType#equals(Object)}
   *   <li>{@link CustomerMaxUsesStrategyType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CustomerMaxUsesStrategyType customerMaxUsesStrategyType = CustomerMaxUsesStrategyType.ACCOUNT;
    CustomerMaxUsesStrategyType customerMaxUsesStrategyType2 = CustomerMaxUsesStrategyType.ACCOUNT;

    // Act and Assert
    assertEquals(customerMaxUsesStrategyType, customerMaxUsesStrategyType2);
    int expectedHashCodeResult = customerMaxUsesStrategyType.hashCode();
    assertEquals(expectedHashCodeResult, customerMaxUsesStrategyType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerMaxUsesStrategyType#equals(Object)}
   *   <li>{@link CustomerMaxUsesStrategyType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CustomerMaxUsesStrategyType customerMaxUsesStrategyType = new CustomerMaxUsesStrategyType();
    CustomerMaxUsesStrategyType customerMaxUsesStrategyType2 = new CustomerMaxUsesStrategyType();

    // Act and Assert
    assertEquals(customerMaxUsesStrategyType, customerMaxUsesStrategyType2);
    int expectedHashCodeResult = customerMaxUsesStrategyType.hashCode();
    assertEquals(expectedHashCodeResult, customerMaxUsesStrategyType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerMaxUsesStrategyType#equals(Object)}
   *   <li>{@link CustomerMaxUsesStrategyType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CustomerMaxUsesStrategyType customerMaxUsesStrategyType = new CustomerMaxUsesStrategyType("ACCOUNT",
        "Friendly Type");
    CustomerMaxUsesStrategyType customerMaxUsesStrategyType2 = CustomerMaxUsesStrategyType.ACCOUNT;

    // Act and Assert
    assertEquals(customerMaxUsesStrategyType, customerMaxUsesStrategyType2);
    int expectedHashCodeResult = customerMaxUsesStrategyType.hashCode();
    assertEquals(expectedHashCodeResult, customerMaxUsesStrategyType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerMaxUsesStrategyType#equals(Object)}
   *   <li>{@link CustomerMaxUsesStrategyType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CustomerMaxUsesStrategyType customerMaxUsesStrategyType = CustomerMaxUsesStrategyType.ACCOUNT;

    // Act and Assert
    assertEquals(customerMaxUsesStrategyType, customerMaxUsesStrategyType);
    int expectedHashCodeResult = customerMaxUsesStrategyType.hashCode();
    assertEquals(expectedHashCodeResult, customerMaxUsesStrategyType.hashCode());
  }

  /**
   * Method under test: {@link CustomerMaxUsesStrategyType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CustomerMaxUsesStrategyType.CUSTOMER, CustomerMaxUsesStrategyType.ACCOUNT);
    assertNotEquals(new CustomerMaxUsesStrategyType(), CustomerMaxUsesStrategyType.ACCOUNT);
  }

  /**
   * Method under test: {@link CustomerMaxUsesStrategyType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CustomerMaxUsesStrategyType.ACCOUNT, null);
  }

  /**
   * Method under test: {@link CustomerMaxUsesStrategyType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CustomerMaxUsesStrategyType.ACCOUNT, "Different type to CustomerMaxUsesStrategyType");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerMaxUsesStrategyType#CustomerMaxUsesStrategyType()}
   *   <li>{@link CustomerMaxUsesStrategyType#getFriendlyType()}
   *   <li>{@link CustomerMaxUsesStrategyType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CustomerMaxUsesStrategyType actualCustomerMaxUsesStrategyType = new CustomerMaxUsesStrategyType();
    String actualFriendlyType = actualCustomerMaxUsesStrategyType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualCustomerMaxUsesStrategyType.getType());
  }

  /**
   * Method under test:
   * {@link CustomerMaxUsesStrategyType#CustomerMaxUsesStrategyType(String, String)}
   */
  @Test
  public void testNewCustomerMaxUsesStrategyType() {
    // Arrange and Act
    CustomerMaxUsesStrategyType actualCustomerMaxUsesStrategyType = new CustomerMaxUsesStrategyType("Type",
        "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualCustomerMaxUsesStrategyType.getFriendlyType());
    assertEquals("Type", actualCustomerMaxUsesStrategyType.getType());
  }

  /**
   * Method under test:
   * {@link CustomerMaxUsesStrategyType#CustomerMaxUsesStrategyType(String, String)}
   */
  @Test
  public void testNewCustomerMaxUsesStrategyType2() {
    // Arrange and Act
    CustomerMaxUsesStrategyType actualCustomerMaxUsesStrategyType = new CustomerMaxUsesStrategyType("Customer",
        "Friendly Type");

    // Assert
    assertEquals("Customer", actualCustomerMaxUsesStrategyType.getType());
    assertEquals("Friendly Type", actualCustomerMaxUsesStrategyType.getFriendlyType());
  }
}

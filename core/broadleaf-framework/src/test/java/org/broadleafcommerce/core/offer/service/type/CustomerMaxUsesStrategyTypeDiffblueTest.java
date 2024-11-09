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

@ContextConfiguration(classes = {CustomerMaxUsesStrategyType.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CustomerMaxUsesStrategyTypeDiffblueTest {
  @Autowired
  private CustomerMaxUsesStrategyType customerMaxUsesStrategyType;

  /**
   * Test {@link CustomerMaxUsesStrategyType#getInstance(String)}.
   * <p>
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
   * Test getters and setters.
   * <p>
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
   * Test
   * {@link CustomerMaxUsesStrategyType#CustomerMaxUsesStrategyType(String, String)}.
   * <ul>
   *   <li>When {@code Customer}.</li>
   *   <li>Then return Type is {@code Customer}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerMaxUsesStrategyType#CustomerMaxUsesStrategyType(String, String)}
   */
  @Test
  public void testNewCustomerMaxUsesStrategyType_whenCustomer_thenReturnTypeIsCustomer() {
    // Arrange and Act
    CustomerMaxUsesStrategyType actualCustomerMaxUsesStrategyType = new CustomerMaxUsesStrategyType("Customer",
        "Friendly Type");

    // Assert
    assertEquals("Customer", actualCustomerMaxUsesStrategyType.getType());
    assertEquals("Friendly Type", actualCustomerMaxUsesStrategyType.getFriendlyType());
  }

  /**
   * Test
   * {@link CustomerMaxUsesStrategyType#CustomerMaxUsesStrategyType(String, String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then return {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerMaxUsesStrategyType#CustomerMaxUsesStrategyType(String, String)}
   */
  @Test
  public void testNewCustomerMaxUsesStrategyType_whenType_thenReturnType() {
    // Arrange and Act
    CustomerMaxUsesStrategyType actualCustomerMaxUsesStrategyType = new CustomerMaxUsesStrategyType("Type",
        "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualCustomerMaxUsesStrategyType.getFriendlyType());
    assertEquals("Type", actualCustomerMaxUsesStrategyType.getType());
  }

  /**
   * Test {@link CustomerMaxUsesStrategyType#setType(String)}.
   * <ul>
   *   <li>When {@code TypeType}.</li>
   *   <li>Then {@link CustomerMaxUsesStrategyType#ACCOUNT} Type is
   * {@code TypeType}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerMaxUsesStrategyType#setType(String)}
   */
  @Test
  public void testSetType_whenTypeType_thenAccountTypeIsTypeType() {
    // Arrange
    CustomerMaxUsesStrategyType customerMaxUsesStrategyType2 = CustomerMaxUsesStrategyType.ACCOUNT;

    // Act
    customerMaxUsesStrategyType2.setType("TypeType");

    // Assert
    assertEquals("TypeType", customerMaxUsesStrategyType2.getType());
  }

  /**
   * Test {@link CustomerMaxUsesStrategyType#setType(String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then {@link CustomerMaxUsesStrategyType#ACCOUNT} Type is
   * {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerMaxUsesStrategyType#setType(String)}
   */
  @Test
  public void testSetType_whenType_thenAccountTypeIsType() {
    // Arrange
    CustomerMaxUsesStrategyType customerMaxUsesStrategyType2 = CustomerMaxUsesStrategyType.ACCOUNT;

    // Act
    customerMaxUsesStrategyType2.setType("Type");

    // Assert
    assertEquals("Type", customerMaxUsesStrategyType2.getType());
  }

  /**
   * Test {@link CustomerMaxUsesStrategyType#equals(Object)}, and
   * {@link CustomerMaxUsesStrategyType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link CustomerMaxUsesStrategyType#equals(Object)}, and
   * {@link CustomerMaxUsesStrategyType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link CustomerMaxUsesStrategyType#equals(Object)}, and
   * {@link CustomerMaxUsesStrategyType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link CustomerMaxUsesStrategyType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerMaxUsesStrategyType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CustomerMaxUsesStrategyType.CUSTOMER, CustomerMaxUsesStrategyType.ACCOUNT);
    assertNotEquals(new CustomerMaxUsesStrategyType(), CustomerMaxUsesStrategyType.ACCOUNT);
  }

  /**
   * Test {@link CustomerMaxUsesStrategyType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerMaxUsesStrategyType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CustomerMaxUsesStrategyType.ACCOUNT, null);
  }

  /**
   * Test {@link CustomerMaxUsesStrategyType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerMaxUsesStrategyType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CustomerMaxUsesStrategyType.ACCOUNT, "Different type to CustomerMaxUsesStrategyType");
  }
}

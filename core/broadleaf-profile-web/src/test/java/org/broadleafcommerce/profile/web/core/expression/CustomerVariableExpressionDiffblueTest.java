/*-
 * #%L
 * BroadleafCommerce Profile Web
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
package org.broadleafcommerce.profile.web.core.expression;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.profile.core.domain.CustomerPayment;
import org.broadleafcommerce.profile.core.domain.CustomerPaymentImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerVariableExpressionDiffblueTest {
  /**
   * Test {@link CustomerVariableExpression#getName()}.
   * <p>
   * Method under test: {@link CustomerVariableExpression#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("customer", (new CustomerVariableExpression()).getName());
  }

  /**
   * Test {@link CustomerVariableExpression#getCurrent()}.
   * <p>
   * Method under test: {@link CustomerVariableExpression#getCurrent()}
   */
  @Test
  @DisplayName("Test getCurrent()")
  void testGetCurrent() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CustomerVariableExpression()).getCurrent());
  }

  /**
   * Test {@link CustomerVariableExpression#sortCustomerPaymentsByDefault(List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerVariableExpression#sortCustomerPaymentsByDefault(List)}
   */
  @Test
  @DisplayName("Test sortCustomerPaymentsByDefault(List); then ArrayList() size is three")
  void testSortCustomerPaymentsByDefault_thenArrayListSizeIsThree() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerVariableExpression customerVariableExpression = new CustomerVariableExpression();

    ArrayList<CustomerPayment> savedPayments = new ArrayList<>();
    savedPayments.add(new CustomerPaymentImpl());
    CustomerPaymentImpl customerPaymentImpl = new CustomerPaymentImpl();
    savedPayments.add(customerPaymentImpl);
    savedPayments.add(new CustomerPaymentImpl());

    // Act
    customerVariableExpression.sortCustomerPaymentsByDefault(savedPayments);

    // Assert
    assertEquals(3, savedPayments.size());
    assertSame(customerPaymentImpl, savedPayments.get(1));
  }

  /**
   * Test {@link CustomerVariableExpression#sortCustomerPaymentsByDefault(List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerVariableExpression#sortCustomerPaymentsByDefault(List)}
   */
  @Test
  @DisplayName("Test sortCustomerPaymentsByDefault(List); then ArrayList() size is three")
  void testSortCustomerPaymentsByDefault_thenArrayListSizeIsThree2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerVariableExpression customerVariableExpression = new CustomerVariableExpression();
    CustomerPaymentImpl customerPaymentImpl = mock(CustomerPaymentImpl.class);
    when(customerPaymentImpl.isDefault()).thenReturn(true);

    ArrayList<CustomerPayment> savedPayments = new ArrayList<>();
    CustomerPaymentImpl customerPaymentImpl2 = new CustomerPaymentImpl();
    savedPayments.add(customerPaymentImpl2);
    savedPayments.add(customerPaymentImpl);
    savedPayments.add(new CustomerPaymentImpl());

    // Act
    customerVariableExpression.sortCustomerPaymentsByDefault(savedPayments);

    // Assert
    verify(customerPaymentImpl, atLeast(1)).isDefault();
    assertEquals(3, savedPayments.size());
    assertSame(customerPaymentImpl2, savedPayments.get(1));
  }

  /**
   * Test {@link CustomerVariableExpression#sortCustomerPaymentsByDefault(List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerVariableExpression#sortCustomerPaymentsByDefault(List)}
   */
  @Test
  @DisplayName("Test sortCustomerPaymentsByDefault(List); then ArrayList() size is two")
  void testSortCustomerPaymentsByDefault_thenArrayListSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerVariableExpression customerVariableExpression = new CustomerVariableExpression();

    ArrayList<CustomerPayment> savedPayments = new ArrayList<>();
    savedPayments.add(new CustomerPaymentImpl());
    CustomerPaymentImpl customerPaymentImpl = new CustomerPaymentImpl();
    savedPayments.add(customerPaymentImpl);

    // Act
    customerVariableExpression.sortCustomerPaymentsByDefault(savedPayments);

    // Assert
    assertEquals(2, savedPayments.size());
    assertSame(customerPaymentImpl, savedPayments.get(1));
  }

  /**
   * Test {@link CustomerVariableExpression#sortCustomerPaymentsByDefault(List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerVariableExpression#sortCustomerPaymentsByDefault(List)}
   */
  @Test
  @DisplayName("Test sortCustomerPaymentsByDefault(List); then ArrayList() size is two")
  void testSortCustomerPaymentsByDefault_thenArrayListSizeIsTwo2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerVariableExpression customerVariableExpression = new CustomerVariableExpression();
    CustomerPaymentImpl customerPaymentImpl = mock(CustomerPaymentImpl.class);
    when(customerPaymentImpl.isDefault()).thenReturn(true);

    ArrayList<CustomerPayment> savedPayments = new ArrayList<>();
    savedPayments.add(customerPaymentImpl);
    CustomerPaymentImpl customerPaymentImpl2 = new CustomerPaymentImpl();
    savedPayments.add(customerPaymentImpl2);

    // Act
    customerVariableExpression.sortCustomerPaymentsByDefault(savedPayments);

    // Assert
    verify(customerPaymentImpl).isDefault();
    assertEquals(2, savedPayments.size());
    assertSame(customerPaymentImpl2, savedPayments.get(1));
  }
}

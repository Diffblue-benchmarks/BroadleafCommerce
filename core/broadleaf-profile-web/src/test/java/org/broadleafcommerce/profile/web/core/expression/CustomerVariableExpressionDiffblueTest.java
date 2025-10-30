/*-
 * #%L
 * BroadleafCommerce Profile Web
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
package org.broadleafcommerce.profile.web.core.expression;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.profile.core.domain.CustomerPayment;
import org.broadleafcommerce.profile.core.domain.CustomerPaymentImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertyResolver;

@ExtendWith(MockitoExtension.class)
class CustomerVariableExpressionDiffblueTest {
  @InjectMocks
  private CustomerVariableExpression customerVariableExpression;

  @Mock
  private Environment environment;

  /**
   * Test {@link CustomerVariableExpression#getName()}.
   * <p>
   * Method under test: {@link CustomerVariableExpression#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CustomerVariableExpression.getName()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.broadleafcommerce.profile.core.domain.Customer CustomerVariableExpression.getCurrent()"})
  void testGetCurrent() {
    // Arrange, Act and Assert
    assertNull(customerVariableExpression.getCurrent());
  }

  /**
   * Test {@link CustomerVariableExpression#savedPaymentsAreEnabled()}.
   * <ul>
   *   <li>Given {@link Environment} {@link PropertyResolver#getProperty(String, Class, Object)} return {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerVariableExpression#savedPaymentsAreEnabled()}
   */
  @Test
  @DisplayName("Test savedPaymentsAreEnabled(); given Environment getProperty(String, Class, Object) return 'true'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CustomerVariableExpression.savedPaymentsAreEnabled()"})
  void testSavedPaymentsAreEnabled_givenEnvironmentGetPropertyReturnTrue_thenReturnTrue() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);

    // Act
    boolean actualSavedPaymentsAreEnabledResult = customerVariableExpression.savedPaymentsAreEnabled();

    // Assert
    verify(environment).getProperty(eq("saved.customer.payments.enabled"), isA(Class.class), isA(Object.class));
    assertTrue(actualSavedPaymentsAreEnabledResult);
  }

  /**
   * Test {@link CustomerVariableExpression#savedPaymentsAreEnabled()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerVariableExpression#savedPaymentsAreEnabled()}
   */
  @Test
  @DisplayName("Test savedPaymentsAreEnabled(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CustomerVariableExpression.savedPaymentsAreEnabled()"})
  void testSavedPaymentsAreEnabled_thenReturnFalse() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(false);

    // Act
    boolean actualSavedPaymentsAreEnabledResult = customerVariableExpression.savedPaymentsAreEnabled();

    // Assert
    verify(environment).getProperty(eq("saved.customer.payments.enabled"), isA(Class.class), isA(Object.class));
    assertFalse(actualSavedPaymentsAreEnabledResult);
  }

  /**
   * Test {@link CustomerVariableExpression#getCustomerPayments()}.
   * <ul>
   *   <li>Given {@link Environment} {@link PropertyResolver#getProperty(String, Class, Object)} return {@code false}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerVariableExpression#getCustomerPayments()}
   */
  @Test
  @DisplayName("Test getCustomerPayments(); given Environment getProperty(String, Class, Object) return 'false'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List CustomerVariableExpression.getCustomerPayments()"})
  void testGetCustomerPayments_givenEnvironmentGetPropertyReturnFalse_thenReturnEmpty() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(false);

    // Act
    List<CustomerPayment> actualCustomerPayments = customerVariableExpression.getCustomerPayments();

    // Assert
    verify(environment).getProperty(eq("saved.customer.payments.enabled"), isA(Class.class), isA(Object.class));
    assertTrue(actualCustomerPayments.isEmpty());
  }

  /**
   * Test {@link CustomerVariableExpression#sortCustomerPaymentsByDefault(List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerVariableExpression#sortCustomerPaymentsByDefault(List)}
   */
  @Test
  @DisplayName("Test sortCustomerPaymentsByDefault(List); then ArrayList() size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CustomerVariableExpression.sortCustomerPaymentsByDefault(List)"})
  void testSortCustomerPaymentsByDefault_thenArrayListSizeIsThree() {
    // Arrange
    ArrayList<CustomerPayment> savedPayments = new ArrayList<>();
    savedPayments.add(new CustomerPaymentImpl());
    CustomerPaymentImpl customerPaymentImpl = new CustomerPaymentImpl();
    savedPayments.add(customerPaymentImpl);
    savedPayments.add(new CustomerPaymentImpl());

    // Act
    customerVariableExpression.sortCustomerPaymentsByDefault(savedPayments);

    // Assert that nothing has changed
    assertEquals(3, savedPayments.size());
    assertSame(customerPaymentImpl, savedPayments.get(1));
  }

  /**
   * Test {@link CustomerVariableExpression#sortCustomerPaymentsByDefault(List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerVariableExpression#sortCustomerPaymentsByDefault(List)}
   */
  @Test
  @DisplayName("Test sortCustomerPaymentsByDefault(List); then ArrayList() size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CustomerVariableExpression.sortCustomerPaymentsByDefault(List)"})
  void testSortCustomerPaymentsByDefault_thenArrayListSizeIsThree2() {
    // Arrange
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
   * Method under test: {@link CustomerVariableExpression#sortCustomerPaymentsByDefault(List)}
   */
  @Test
  @DisplayName("Test sortCustomerPaymentsByDefault(List); then ArrayList() size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CustomerVariableExpression.sortCustomerPaymentsByDefault(List)"})
  void testSortCustomerPaymentsByDefault_thenArrayListSizeIsTwo() {
    // Arrange
    ArrayList<CustomerPayment> savedPayments = new ArrayList<>();
    savedPayments.add(new CustomerPaymentImpl());
    CustomerPaymentImpl customerPaymentImpl = new CustomerPaymentImpl();
    savedPayments.add(customerPaymentImpl);

    // Act
    customerVariableExpression.sortCustomerPaymentsByDefault(savedPayments);

    // Assert that nothing has changed
    assertEquals(2, savedPayments.size());
    assertSame(customerPaymentImpl, savedPayments.get(1));
  }

  /**
   * Test {@link CustomerVariableExpression#sortCustomerPaymentsByDefault(List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerVariableExpression#sortCustomerPaymentsByDefault(List)}
   */
  @Test
  @DisplayName("Test sortCustomerPaymentsByDefault(List); then ArrayList() size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CustomerVariableExpression.sortCustomerPaymentsByDefault(List)"})
  void testSortCustomerPaymentsByDefault_thenArrayListSizeIsTwo2() {
    // Arrange
    CustomerPaymentImpl customerPaymentImpl = mock(CustomerPaymentImpl.class);
    when(customerPaymentImpl.isDefault()).thenReturn(true);

    ArrayList<CustomerPayment> savedPayments = new ArrayList<>();
    savedPayments.add(customerPaymentImpl);
    CustomerPaymentImpl customerPaymentImpl2 = new CustomerPaymentImpl();
    savedPayments.add(customerPaymentImpl2);

    // Act
    customerVariableExpression.sortCustomerPaymentsByDefault(savedPayments);

    // Assert that nothing has changed
    verify(customerPaymentImpl).isDefault();
    assertEquals(2, savedPayments.size());
    assertSame(customerPaymentImpl2, savedPayments.get(1));
  }
}

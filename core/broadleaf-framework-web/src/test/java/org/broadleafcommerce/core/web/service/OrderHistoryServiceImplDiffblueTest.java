/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;

@ExtendWith(MockitoExtension.class)
class OrderHistoryServiceImplDiffblueTest {
  @Mock private Environment environment;

  @InjectMocks private OrderHistoryServiceImpl orderHistoryServiceImpl;

  @Mock private OrderService orderService;

  /**
   * Test {@link OrderHistoryServiceImpl#getOrderDetails(String)}.
   *
   * <p>Method under test: {@link OrderHistoryServiceImpl#getOrderDetails(String)}
   */
  @Test
  @DisplayName("Test getOrderDetails(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderHistoryServiceImpl.getOrderDetails(String)"})
  void testGetOrderDetails() {
    // Arrange
    when(orderService.findOrderByOrderNumber(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> orderHistoryServiceImpl.getOrderDetails("42"));
    verify(orderService).findOrderByOrderNumber("42");
  }

  /**
   * Test {@link OrderHistoryServiceImpl#getOrderDetails(String)}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, Class, Object)} return
   *       {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderHistoryServiceImpl#getOrderDetails(String)}
   */
  @Test
  @DisplayName(
      "Test getOrderDetails(String); given Environment getProperty(String, Class, Object) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderHistoryServiceImpl.getOrderDetails(String)"})
  void testGetOrderDetails_givenEnvironmentGetPropertyReturnFalse() {
    // Arrange
    when(environment.getProperty(
            Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(false);
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderService.findOrderByOrderNumber(Mockito.<String>any())).thenReturn(nullOrderImpl);

    // Act
    Order actualOrderDetails = orderHistoryServiceImpl.getOrderDetails("42");

    // Assert
    verify(orderService).findOrderByOrderNumber("42");
    verify(environment)
        .getProperty(eq("validate.customer.owned.data"), isA(Class.class), isA(Object.class));
    assertSame(nullOrderImpl, actualOrderDetails);
  }

  /**
   * Test {@link OrderHistoryServiceImpl#getOrderDetails(String)}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, Class, Object)} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderHistoryServiceImpl#getOrderDetails(String)}
   */
  @Test
  @DisplayName(
      "Test getOrderDetails(String); given Environment getProperty(String, Class, Object) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderHistoryServiceImpl.getOrderDetails(String)"})
  void testGetOrderDetails_givenEnvironmentGetPropertyThrowIllegalArgumentException() {
    // Arrange
    when(environment.getProperty(
            Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException());
    when(orderService.findOrderByOrderNumber(Mockito.<String>any()))
        .thenReturn(new NullOrderImpl());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> orderHistoryServiceImpl.getOrderDetails("42"));
    verify(orderService).findOrderByOrderNumber("42");
    verify(environment)
        .getProperty(eq("validate.customer.owned.data"), isA(Class.class), isA(Object.class));
  }

  /**
   * Test {@link OrderHistoryServiceImpl#getOrderDetails(String)}.
   *
   * <ul>
   *   <li>Given {@link NullOrderImpl} {@link NullOrderImpl#getCustomer()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderHistoryServiceImpl#getOrderDetails(String)}
   */
  @Test
  @DisplayName(
      "Test getOrderDetails(String); given NullOrderImpl getCustomer() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderHistoryServiceImpl.getOrderDetails(String)"})
  void testGetOrderDetails_givenNullOrderImplGetCustomerThrowIllegalArgumentException() {
    // Arrange
    when(environment.getProperty(
            Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);

    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getCustomer()).thenThrow(new IllegalArgumentException());
    doNothing().when(nullOrderImpl).addOrderItem(Mockito.<OrderItem>any());
    nullOrderImpl.addOrderItem(new BundleOrderItemImpl());
    when(orderService.findOrderByOrderNumber(Mockito.<String>any())).thenReturn(nullOrderImpl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> orderHistoryServiceImpl.getOrderDetails("42"));
    verify(nullOrderImpl).addOrderItem(isA(OrderItem.class));
    verify(nullOrderImpl).getCustomer();
    verify(orderService).findOrderByOrderNumber("42");
    verify(environment)
        .getProperty(eq("validate.customer.owned.data"), isA(Class.class), isA(Object.class));
  }

  /**
   * Test {@link OrderHistoryServiceImpl#getOrderDetails(String)}.
   *
   * <ul>
   *   <li>Given {@link OrderService} {@link OrderService#findOrderByOrderNumber(String)} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderHistoryServiceImpl#getOrderDetails(String)}
   */
  @Test
  @DisplayName(
      "Test getOrderDetails(String); given OrderService findOrderByOrderNumber(String) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderHistoryServiceImpl.getOrderDetails(String)"})
  void testGetOrderDetails_givenOrderServiceFindOrderByOrderNumberReturnNull() {
    // Arrange
    when(orderService.findOrderByOrderNumber(Mockito.<String>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> orderHistoryServiceImpl.getOrderDetails("42"));
    verify(orderService).findOrderByOrderNumber("42");
  }

  /**
   * Test {@link OrderHistoryServiceImpl#getOrderDetails(String)}.
   *
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderHistoryServiceImpl#getOrderDetails(String)}
   */
  @Test
  @DisplayName("Test getOrderDetails(String); then return NullOrderImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderHistoryServiceImpl.getOrderDetails(String)"})
  void testGetOrderDetails_thenReturnNullOrderImpl() {
    // Arrange
    when(environment.getProperty(
            Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderService.findOrderByOrderNumber(Mockito.<String>any())).thenReturn(nullOrderImpl);

    // Act
    Order actualOrderDetails = orderHistoryServiceImpl.getOrderDetails("42");

    // Assert
    verify(orderService).findOrderByOrderNumber("42");
    verify(environment)
        .getProperty(eq("validate.customer.owned.data"), isA(Class.class), isA(Object.class));
    assertSame(nullOrderImpl, actualOrderDetails);
  }

  /**
   * Test {@link OrderHistoryServiceImpl#getOrderDetails(String)}.
   *
   * <ul>
   *   <li>Then throw {@link SecurityException}.
   * </ul>
   *
   * <p>Method under test: {@link OrderHistoryServiceImpl#getOrderDetails(String)}
   */
  @Test
  @DisplayName("Test getOrderDetails(String); then throw SecurityException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderHistoryServiceImpl.getOrderDetails(String)"})
  void testGetOrderDetails_thenThrowSecurityException() {
    // Arrange
    when(environment.getProperty(
            Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);

    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getCustomer()).thenReturn(new CustomerImpl());
    doNothing().when(nullOrderImpl).addOrderItem(Mockito.<OrderItem>any());
    nullOrderImpl.addOrderItem(new BundleOrderItemImpl());
    when(orderService.findOrderByOrderNumber(Mockito.<String>any())).thenReturn(nullOrderImpl);

    // Act and Assert
    assertThrows(SecurityException.class, () -> orderHistoryServiceImpl.getOrderDetails("42"));
    verify(nullOrderImpl).addOrderItem(isA(OrderItem.class));
    verify(nullOrderImpl).getCustomer();
    verify(orderService).findOrderByOrderNumber("42");
    verify(environment)
        .getProperty(eq("validate.customer.owned.data"), isA(Class.class), isA(Object.class));
  }

  /**
   * Test {@link OrderHistoryServiceImpl#shouldValidateCustomerOwnedData()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderHistoryServiceImpl#shouldValidateCustomerOwnedData()}
   */
  @Test
  @DisplayName("Test shouldValidateCustomerOwnedData(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderHistoryServiceImpl.shouldValidateCustomerOwnedData()"})
  void testShouldValidateCustomerOwnedData_thenReturnFalse() {
    // Arrange
    when(environment.getProperty(
            Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(false);

    // Act
    boolean actualShouldValidateCustomerOwnedDataResult =
        orderHistoryServiceImpl.shouldValidateCustomerOwnedData();

    // Assert
    verify(environment)
        .getProperty(eq("validate.customer.owned.data"), isA(Class.class), isA(Object.class));
    assertFalse(actualShouldValidateCustomerOwnedDataResult);
  }

  /**
   * Test {@link OrderHistoryServiceImpl#shouldValidateCustomerOwnedData()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OrderHistoryServiceImpl#shouldValidateCustomerOwnedData()}
   */
  @Test
  @DisplayName("Test shouldValidateCustomerOwnedData(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderHistoryServiceImpl.shouldValidateCustomerOwnedData()"})
  void testShouldValidateCustomerOwnedData_thenReturnTrue() {
    // Arrange
    when(environment.getProperty(
            Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);

    // Act
    boolean actualShouldValidateCustomerOwnedDataResult =
        orderHistoryServiceImpl.shouldValidateCustomerOwnedData();

    // Assert
    verify(environment)
        .getProperty(eq("validate.customer.owned.data"), isA(Class.class), isA(Object.class));
    assertTrue(actualShouldValidateCustomerOwnedDataResult);
  }

  /**
   * Test {@link OrderHistoryServiceImpl#shouldValidateCustomerOwnedData()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link OrderHistoryServiceImpl#shouldValidateCustomerOwnedData()}
   */
  @Test
  @DisplayName("Test shouldValidateCustomerOwnedData(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderHistoryServiceImpl.shouldValidateCustomerOwnedData()"})
  void testShouldValidateCustomerOwnedData_thenThrowIllegalArgumentException() {
    // Arrange
    when(environment.getProperty(
            Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> orderHistoryServiceImpl.shouldValidateCustomerOwnedData());
    verify(environment)
        .getProperty(eq("validate.customer.owned.data"), isA(Class.class), isA(Object.class));
  }
}

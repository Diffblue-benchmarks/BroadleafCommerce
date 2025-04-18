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
package org.broadleafcommerce.core.web.order;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DatabaseOrderLockManagerDiffblueTest {
  @InjectMocks
  private DatabaseOrderLockManager databaseOrderLockManager;

  @Mock
  private OrderService orderService;

  /**
   * Test {@link DatabaseOrderLockManager#acquireLock(Order)}.
   * <ul>
   *   <li>Given {@link OrderService} {@link OrderService#acquireLock(Order)} return {@code true}.</li>
   *   <li>Then return {@link OrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseOrderLockManager#acquireLock(Order)}
   */
  @Test
  @DisplayName("Test acquireLock(Order); given OrderService acquireLock(Order) return 'true'; then return OrderImpl (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object DatabaseOrderLockManager.acquireLock(Order)"})
  void testAcquireLock_givenOrderServiceAcquireLockReturnTrue_thenReturnOrderImpl() {
    // Arrange
    when(orderService.acquireLock(Mockito.<Order>any())).thenReturn(true);
    OrderImpl order = new OrderImpl();

    // Act
    Object actualAcquireLockResult = databaseOrderLockManager.acquireLock(order);

    // Assert
    verify(orderService).acquireLock(isA(Order.class));
    assertSame(order, actualAcquireLockResult);
  }

  /**
   * Test {@link DatabaseOrderLockManager#acquireLock(Order)}.
   * <ul>
   *   <li>Given {@link OrderService}.</li>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseOrderLockManager#acquireLock(Order)}
   */
  @Test
  @DisplayName("Test acquireLock(Order); given OrderService; when NullOrderImpl (default constructor); then return NullOrderImpl (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object DatabaseOrderLockManager.acquireLock(Order)"})
  void testAcquireLock_givenOrderService_whenNullOrderImpl_thenReturnNullOrderImpl() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertSame(order, databaseOrderLockManager.acquireLock(order));
  }

  /**
   * Test {@link DatabaseOrderLockManager#acquireLock(Order)}.
   * <ul>
   *   <li>Given {@link OrderService}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseOrderLockManager#acquireLock(Order)}
   */
  @Test
  @DisplayName("Test acquireLock(Order); given OrderService; when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object DatabaseOrderLockManager.acquireLock(Order)"})
  void testAcquireLock_givenOrderService_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(databaseOrderLockManager.acquireLock(null));
  }

  /**
   * Test {@link DatabaseOrderLockManager#acquireLockIfAvailable(Order)}.
   * <ul>
   *   <li>Given {@link OrderService} {@link OrderService#acquireLock(Order)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseOrderLockManager#acquireLockIfAvailable(Order)}
   */
  @Test
  @DisplayName("Test acquireLockIfAvailable(Order); given OrderService acquireLock(Order) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object DatabaseOrderLockManager.acquireLockIfAvailable(Order)"})
  void testAcquireLockIfAvailable_givenOrderServiceAcquireLockReturnFalse() {
    // Arrange
    when(orderService.acquireLock(Mockito.<Order>any())).thenReturn(false);

    // Act
    Object actualAcquireLockIfAvailableResult = databaseOrderLockManager.acquireLockIfAvailable(new OrderImpl());

    // Assert
    verify(orderService).acquireLock(isA(Order.class));
    assertNull(actualAcquireLockIfAvailableResult);
  }

  /**
   * Test {@link DatabaseOrderLockManager#acquireLockIfAvailable(Order)}.
   * <ul>
   *   <li>Given {@link OrderService}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseOrderLockManager#acquireLockIfAvailable(Order)}
   */
  @Test
  @DisplayName("Test acquireLockIfAvailable(Order); given OrderService; when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object DatabaseOrderLockManager.acquireLockIfAvailable(Order)"})
  void testAcquireLockIfAvailable_givenOrderService_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(databaseOrderLockManager.acquireLockIfAvailable(null));
  }

  /**
   * Test {@link DatabaseOrderLockManager#acquireLockIfAvailable(Order)}.
   * <ul>
   *   <li>Then return {@link OrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseOrderLockManager#acquireLockIfAvailable(Order)}
   */
  @Test
  @DisplayName("Test acquireLockIfAvailable(Order); then return OrderImpl (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object DatabaseOrderLockManager.acquireLockIfAvailable(Order)"})
  void testAcquireLockIfAvailable_thenReturnOrderImpl() {
    // Arrange
    when(orderService.acquireLock(Mockito.<Order>any())).thenReturn(true);
    OrderImpl order = new OrderImpl();

    // Act
    Object actualAcquireLockIfAvailableResult = databaseOrderLockManager.acquireLockIfAvailable(order);

    // Assert
    verify(orderService).acquireLock(isA(Order.class));
    assertSame(order, actualAcquireLockIfAvailableResult);
  }

  /**
   * Test {@link DatabaseOrderLockManager#acquireLockIfAvailable(Order)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseOrderLockManager#acquireLockIfAvailable(Order)}
   */
  @Test
  @DisplayName("Test acquireLockIfAvailable(Order); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object DatabaseOrderLockManager.acquireLockIfAvailable(Order)"})
  void testAcquireLockIfAvailable_thenThrowRuntimeException() {
    // Arrange
    when(orderService.acquireLock(Mockito.<Order>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> databaseOrderLockManager.acquireLockIfAvailable(new OrderImpl()));
    verify(orderService).acquireLock(isA(Order.class));
  }

  /**
   * Test {@link DatabaseOrderLockManager#acquireLockIfAvailable(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseOrderLockManager#acquireLockIfAvailable(Order)}
   */
  @Test
  @DisplayName("Test acquireLockIfAvailable(Order); when NullOrderImpl (default constructor); then return NullOrderImpl (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object DatabaseOrderLockManager.acquireLockIfAvailable(Order)"})
  void testAcquireLockIfAvailable_whenNullOrderImpl_thenReturnNullOrderImpl() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertSame(order, databaseOrderLockManager.acquireLockIfAvailable(order));
  }

  /**
   * Test {@link DatabaseOrderLockManager#releaseLock(Object)}.
   * <ul>
   *   <li>Given {@link OrderService} {@link OrderService#releaseLock(Order)} return {@code true}.</li>
   *   <li>Then calls {@link OrderService#releaseLock(Order)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseOrderLockManager#releaseLock(Object)}
   */
  @Test
  @DisplayName("Test releaseLock(Object); given OrderService releaseLock(Order) return 'true'; then calls releaseLock(Order)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DatabaseOrderLockManager.releaseLock(Object)"})
  void testReleaseLock_givenOrderServiceReleaseLockReturnTrue_thenCallsReleaseLock() {
    // Arrange
    when(orderService.releaseLock(Mockito.<Order>any())).thenReturn(true);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(new OrderStatus("Type", "Friendly Type"));
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());

    // Act
    databaseOrderLockManager.releaseLock(orderImpl);

    // Assert
    verify(orderService).releaseLock(isA(Order.class));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DatabaseOrderLockManager}
   *   <li>{@link DatabaseOrderLockManager#isActive()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DatabaseOrderLockManager.<init>()", "boolean DatabaseOrderLockManager.isActive()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue((new DatabaseOrderLockManager()).isActive());
  }
}

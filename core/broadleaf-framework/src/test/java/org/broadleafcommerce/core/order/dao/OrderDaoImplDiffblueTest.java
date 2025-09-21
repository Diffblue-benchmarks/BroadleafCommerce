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
package org.broadleafcommerce.core.order.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.persistence.NoResultException;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.util.StreamCapableTransactionalOperation;
import org.broadleafcommerce.common.util.StreamingTransactionCapableUtil;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OrderDaoImplDiffblueTest {
  @Mock private EntityConfiguration entityConfiguration;

  @Mock private OrderDaoExtensionManager orderDaoExtensionManager;

  @InjectMocks private OrderDaoImpl orderDaoImpl;

  @Mock private StreamingTransactionCapableUtil streamingTransactionCapableUtil;

  /**
   * Test {@link OrderDaoImpl#readOrdersByIds(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderDaoImpl#readOrdersByIds(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderDaoImpl.readOrdersByIds(List)"})
  public void testReadOrdersByIds_whenArrayList_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(orderDaoImpl.readOrdersByIds(new ArrayList<>()));
  }

  /**
   * Test {@link OrderDaoImpl#readOrdersByIds(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderDaoImpl#readOrdersByIds(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderDaoImpl.readOrdersByIds(List)"})
  public void testReadOrdersByIds_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(orderDaoImpl.readOrdersByIds(null));
  }

  /**
   * Test {@link OrderDaoImpl#createNewCartForCustomer(Customer)}.
   *
   * <p>Method under test: {@link OrderDaoImpl#createNewCartForCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderDaoImpl.createNewCartForCustomer(Customer)"})
  public void testCreateNewCartForCustomer() {
    // Arrange
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenThrow(new NoResultException("An error occurred"));

    // Act and Assert
    assertThrows(
        NoResultException.class, () -> orderDaoImpl.createNewCartForCustomer(new CustomerImpl()));
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.core.order.domain.Order");
  }

  /**
   * Test {@link OrderDaoImpl#createNewCartForCustomer(Customer)}.
   *
   * <ul>
   *   <li>Then calls {@link OrderDaoExtensionManager#getProxy()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderDaoImpl#createNewCartForCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderDaoImpl.createNewCartForCustomer(Customer)"})
  public void testCreateNewCartForCustomer_thenCallsGetProxy() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    orderImpl.setName("org.broadleafcommerce.core.order.domain.Order");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    when(entityConfiguration.createEntityInstance(Mockito.<String>any())).thenReturn(orderImpl);
    when(orderDaoExtensionManager.getProxy()).thenThrow(new NoResultException("An error occurred"));

    // Act and Assert
    assertThrows(
        NoResultException.class, () -> orderDaoImpl.createNewCartForCustomer(new CustomerImpl()));
    verify(orderDaoExtensionManager).getProxy();
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.core.order.domain.Order");
  }

  /**
   * Test {@link OrderDaoImpl#create()}.
   *
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.
   *   <li>Then return {@link OrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderDaoImpl#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderDaoImpl.create()"})
  public void testCreate_givenAuditableCreatedByIsOne_thenReturnOrderImpl() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    orderImpl.setName("org.broadleafcommerce.core.order.domain.Order");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    when(entityConfiguration.createEntityInstance(Mockito.<String>any())).thenReturn(orderImpl);

    // Act
    Order actualCreateResult = orderDaoImpl.create();

    // Assert
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.core.order.domain.Order");
    assertSame(orderImpl, actualCreateResult);
  }

  /**
   * Test {@link OrderDaoImpl#create()}.
   *
   * <ul>
   *   <li>Then throw {@link NoResultException}.
   * </ul>
   *
   * <p>Method under test: {@link OrderDaoImpl#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderDaoImpl.create()"})
  public void testCreate_thenThrowNoResultException() {
    // Arrange
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenThrow(new NoResultException("An error occurred"));

    // Act and Assert
    assertThrows(NoResultException.class, () -> orderDaoImpl.create());
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.core.order.domain.Order");
  }

  /**
   * Test {@link OrderDaoImpl#readOrderByOrderNumber(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderDaoImpl#readOrderByOrderNumber(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderDaoImpl.readOrderByOrderNumber(String)"})
  public void testReadOrderByOrderNumber_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(orderDaoImpl.readOrderByOrderNumber(""));
  }

  /**
   * Test {@link OrderDaoImpl#readOrderByOrderNumber(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderDaoImpl#readOrderByOrderNumber(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderDaoImpl.readOrderByOrderNumber(String)"})
  public void testReadOrderByOrderNumber_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(orderDaoImpl.readOrderByOrderNumber(null));
  }

  /**
   * Test {@link OrderDaoImpl#releaseLock(Order)}.
   *
   * <p>Method under test: {@link OrderDaoImpl#releaseLock(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderDaoImpl.releaseLock(Order)"})
  public void testReleaseLock() throws Throwable {
    // Arrange
    doNothing()
        .when(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());

    // Act
    boolean actualReleaseLockResult = orderDaoImpl.releaseLock(new NullOrderImpl());

    // Assert
    verify(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            isA(StreamCapableTransactionalOperation.class), isA(Class.class));
    assertFalse(actualReleaseLockResult);
  }

  /**
   * Test {@link OrderDaoImpl#releaseLock(Order)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderDaoImpl#releaseLock(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderDaoImpl.releaseLock(Order)"})
  public void testReleaseLock_thenReturnFalse() throws Throwable {
    // Arrange
    doThrow(new NoResultException("An error occurred"))
        .when(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());

    // Act
    boolean actualReleaseLockResult = orderDaoImpl.releaseLock(new NullOrderImpl());

    // Assert
    verify(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            isA(StreamCapableTransactionalOperation.class), isA(Class.class));
    assertFalse(actualReleaseLockResult);
  }

  /**
   * Test {@link OrderDaoImpl#releaseLock(Order)}.
   *
   * <ul>
   *   <li>Then throw {@link Exception}.
   * </ul>
   *
   * <p>Method under test: {@link OrderDaoImpl#releaseLock(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderDaoImpl.releaseLock(Order)"})
  public void testReleaseLock_thenThrowException() throws Throwable {
    // Arrange
    doThrow(new Exception())
        .when(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());

    // Act and Assert
    assertThrows(Exception.class, () -> orderDaoImpl.releaseLock(new NullOrderImpl()));
    verify(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            isA(StreamCapableTransactionalOperation.class), isA(Class.class));
  }

  /**
   * Test {@link OrderDaoImpl#readOrdersByEmail(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link OrderDaoImpl#readOrdersByEmail(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderDaoImpl.readOrdersByEmail(String)"})
  public void testReadOrdersByEmail_whenEmptyString_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(orderDaoImpl.readOrdersByEmail("").isEmpty());
  }

  /**
   * Test {@link OrderDaoImpl#readOrdersByEmail(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link OrderDaoImpl#readOrdersByEmail(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderDaoImpl.readOrdersByEmail(String)"})
  public void testReadOrdersByEmail_whenNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(orderDaoImpl.readOrdersByEmail(null).isEmpty());
  }
}

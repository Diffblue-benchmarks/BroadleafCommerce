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
package org.broadleafcommerce.core.util.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
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
import java.util.Map;
import java.util.Set;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.notification.service.NotificationDispatcher;
import org.broadleafcommerce.common.notification.service.type.Notification;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.util.dao.ResourcePurgeDao;
import org.broadleafcommerce.core.util.service.DeleteStatementGeneratorImpl.PathElement;
import org.broadleafcommerce.core.util.service.ResourcePurgeServiceImpl.CartPurgeParams;
import org.broadleafcommerce.core.util.service.ResourcePurgeServiceImpl.CustomerPurgeParams;
import org.broadleafcommerce.core.util.service.ResourcePurgeServiceImpl.PurgeErrorCache;
import org.broadleafcommerce.profile.core.domain.ChallengeQuestionImpl;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.service.CustomerService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.env.Environment;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.SimpleTransactionStatus;

@RunWith(MockitoJUnitRunner.class)
public class ResourcePurgeServiceImplDiffblueTest {
  @Mock private CustomerService customerService;

  @Mock private Environment environment;

  @Mock private NotificationDispatcher notificationDispatcher;

  @Mock private OrderService orderService;

  @Mock private PlatformTransactionManager platformTransactionManager;

  @Mock private ResourcePurgeDao resourcePurgeDao;

  @InjectMocks private ResourcePurgeServiceImpl resourcePurgeServiceImpl;

  /**
   * Test CartPurgeParams getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CartPurgeParams#CartPurgeParams(ResourcePurgeServiceImpl, Map)}
   *   <li>{@link CartPurgeParams#getBatchSize()}
   *   <li>{@link CartPurgeParams#getDateCreatedMinThreshold()}
   *   <li>{@link CartPurgeParams#getFailedRetryTime()}
   *   <li>{@link CartPurgeParams#getIsPreview()}
   *   <li>{@link CartPurgeParams#getNameArray()}
   *   <li>{@link CartPurgeParams#getStatusArray()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CartPurgeParams.<init>(ResourcePurgeServiceImpl, Map)",
    "Long CartPurgeParams.getBatchSize()",
    "Date CartPurgeParams.getDateCreatedMinThreshold()",
    "Long CartPurgeParams.getFailedRetryTime()",
    "Boolean CartPurgeParams.getIsPreview()",
    "String[] CartPurgeParams.getNameArray()",
    "OrderStatus[] CartPurgeParams.getStatusArray()"
  })
  public void testCartPurgeParamsGettersAndSetters() {
    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl = new ResourcePurgeServiceImpl();

    // Act
    CartPurgeParams actualCartPurgeParams =
        resourcePurgeServiceImpl.new CartPurgeParams(new HashMap<>());
    Long actualBatchSize = actualCartPurgeParams.getBatchSize();
    Date actualDateCreatedMinThreshold = actualCartPurgeParams.getDateCreatedMinThreshold();
    Long actualFailedRetryTime = actualCartPurgeParams.getFailedRetryTime();
    Boolean actualIsPreview = actualCartPurgeParams.getIsPreview();
    String[] actualNameArray = actualCartPurgeParams.getNameArray();

    // Assert
    assertNull(actualIsPreview);
    assertNull(actualBatchSize);
    assertNull(actualFailedRetryTime);
    assertNull(actualNameArray);
    assertNull(actualDateCreatedMinThreshold);
    assertNull(actualCartPurgeParams.getStatusArray());
  }

  /**
   * Test CustomerPurgeParams getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerPurgeParams#CustomerPurgeParams(ResourcePurgeServiceImpl, Map)}
   *   <li>{@link CustomerPurgeParams#getBatchSize()}
   *   <li>{@link CustomerPurgeParams#getDateCreatedMinThreshold()}
   *   <li>{@link CustomerPurgeParams#getFailedRetryTime()}
   *   <li>{@link CustomerPurgeParams#getIsDeactivated()}
   *   <li>{@link CustomerPurgeParams#getIsPreview()}
   *   <li>{@link CustomerPurgeParams#getIsRegistered()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CustomerPurgeParams.<init>(ResourcePurgeServiceImpl, Map)",
    "Long CustomerPurgeParams.getBatchSize()",
    "Date CustomerPurgeParams.getDateCreatedMinThreshold()",
    "Long CustomerPurgeParams.getFailedRetryTime()",
    "Boolean CustomerPurgeParams.getIsDeactivated()",
    "Boolean CustomerPurgeParams.getIsPreview()",
    "Boolean CustomerPurgeParams.getIsRegistered()"
  })
  public void testCustomerPurgeParamsGettersAndSetters() {
    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl = new ResourcePurgeServiceImpl();

    // Act
    CustomerPurgeParams actualCustomerPurgeParams =
        resourcePurgeServiceImpl.new CustomerPurgeParams(new HashMap<>());
    Long actualBatchSize = actualCustomerPurgeParams.getBatchSize();
    Date actualDateCreatedMinThreshold = actualCustomerPurgeParams.getDateCreatedMinThreshold();
    Long actualFailedRetryTime = actualCustomerPurgeParams.getFailedRetryTime();
    Boolean actualIsDeactivated = actualCustomerPurgeParams.getIsDeactivated();
    Boolean actualIsPreview = actualCustomerPurgeParams.getIsPreview();

    // Assert
    assertNull(actualIsDeactivated);
    assertNull(actualIsPreview);
    assertNull(actualCustomerPurgeParams.getIsRegistered());
    assertNull(actualBatchSize);
    assertNull(actualFailedRetryTime);
    assertNull(actualDateCreatedMinThreshold);
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeCarts(Map)}.
   *
   * <ul>
   *   <li>Given {@code BATCH_SIZE}.
   *   <li>When {@link HashMap#HashMap()} {@code BATCH_SIZE} is {@code 42}.
   *   <li>Then calls {@link TransactionStatus#isRollbackOnly()}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#purgeCarts(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.purgeCarts(Map)"})
  public void testPurgeCarts_givenBatchSize_whenHashMapBatchSizeIs42_thenCallsIsRollbackOnly()
      throws TransactionException {
    // Arrange
    doNothing().when(orderService).deleteOrder(Mockito.<Order>any());

    ArrayList<Order> orderList = new ArrayList<>();
    orderList.add(new NullOrderImpl());
    when(resourcePurgeDao.findCartsCount(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);
    when(resourcePurgeDao.findCarts(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(orderList);

    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    HashMap<String, String> config = new HashMap<>();
    config.put("BATCH_SIZE", "42");

    // Act
    resourcePurgeServiceImpl.purgeCarts(config);

    // Assert that nothing has changed
    verify(orderService).deleteOrder(isA(Order.class));
    verify(resourcePurgeDao)
        .findCarts(isNull(), isNull(), isNull(), isNull(), eq(0), eq(3), isA(List.class));
    verify(resourcePurgeDao)
        .findCartsCount(isNull(), isNull(), isNull(), isNull(), isA(List.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
    assertEquals(0, resourcePurgeServiceImpl.cartPurgeErrors.size());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeCarts(Map)}.
   *
   * <ul>
   *   <li>Given {@code IS_PREVIEW}.
   *   <li>When {@link HashMap#HashMap()} {@code IS_PREVIEW} is a string.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#purgeCarts(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.purgeCarts(Map)"})
  public void testPurgeCarts_givenIsPreview_whenHashMapIsPreviewIsAString()
      throws TransactionException {
    // Arrange
    doNothing().when(orderService).deleteOrder(Mockito.<Order>any());

    ArrayList<Order> orderList = new ArrayList<>();
    orderList.add(new NullOrderImpl());
    when(resourcePurgeDao.findCartsCount(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);
    when(resourcePurgeDao.findCarts(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(orderList);

    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    HashMap<String, String> config = new HashMap<>();
    config.put(
        "IS_PREVIEW",
        "Cannot purge carts since there was no configuration provided. In the absence of config params, all"
            + " carts would be candidates for deletion.");

    // Act
    resourcePurgeServiceImpl.purgeCarts(config);

    // Assert that nothing has changed
    verify(orderService).deleteOrder(isA(Order.class));
    verify(resourcePurgeDao)
        .findCarts(isNull(), isNull(), isNull(), eq(false), eq(0), eq(3), isA(List.class));
    verify(resourcePurgeDao)
        .findCartsCount(isNull(), isNull(), isNull(), eq(false), isA(List.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
    assertEquals(0, resourcePurgeServiceImpl.cartPurgeErrors.size());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeCarts(Map)}.
   *
   * <ul>
   *   <li>Given {@code NAME}.
   *   <li>When {@link HashMap#HashMap()} {@code NAME} is {@code NAME}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#purgeCarts(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.purgeCarts(Map)"})
  public void testPurgeCarts_givenName_whenHashMapNameIsName() throws TransactionException {
    // Arrange
    doNothing().when(orderService).deleteOrder(Mockito.<Order>any());

    ArrayList<Order> orderList = new ArrayList<>();
    orderList.add(new NullOrderImpl());
    when(resourcePurgeDao.findCartsCount(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);
    when(resourcePurgeDao.findCarts(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(orderList);
    doThrow(new IllegalArgumentException())
        .when(platformTransactionManager)
        .commit(Mockito.<TransactionStatus>any());
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(new SimpleTransactionStatus(true));
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    HashMap<String, String> config = new HashMap<>();
    config.put("NAME", "NAME");
    config.put(
        "Cannot purge carts since there was no configuration provided. In the absence of config params, all"
            + " carts would be candidates for deletion.",
        "Cannot purge carts since there was no configuration provided. In the absence of config params, all"
            + " carts would be candidates for deletion.");

    // Act
    resourcePurgeServiceImpl.purgeCarts(config);

    // Assert
    verify(orderService).deleteOrder(isA(Order.class));
    verify(resourcePurgeDao)
        .findCarts(
            isA(String[].class), isNull(), isNull(), isNull(), eq(0), eq(3), isA(List.class));
    verify(resourcePurgeDao)
        .findCartsCount(isA(String[].class), isNull(), isNull(), isNull(), isA(List.class));
    verify(platformTransactionManager).commit(isA(TransactionStatus.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    assertEquals(1, resourcePurgeServiceImpl.cartPurgeErrors.size());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeCarts(Map)}.
   *
   * <ul>
   *   <li>Given {@link PlatformTransactionManager} {@link
   *       PlatformTransactionManager#getTransaction(TransactionDefinition)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#purgeCarts(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.purgeCarts(Map)"})
  public void testPurgeCarts_givenPlatformTransactionManagerGetTransactionReturnNull()
      throws TransactionException {
    // Arrange
    doNothing().when(orderService).deleteOrder(Mockito.<Order>any());

    ArrayList<Order> orderList = new ArrayList<>();
    orderList.add(new NullOrderImpl());
    when(resourcePurgeDao.findCartsCount(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);
    when(resourcePurgeDao.findCarts(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(orderList);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(null);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    HashMap<String, String> config = new HashMap<>();
    config.put(
        "Cannot purge carts since there was no configuration provided. In the absence of config params, all"
            + " carts would be candidates for deletion.",
        "Cannot purge carts since there was no configuration provided. In the absence of config params, all"
            + " carts would be candidates for deletion.");

    // Act
    resourcePurgeServiceImpl.purgeCarts(config);

    // Assert that nothing has changed
    verify(orderService).deleteOrder(isA(Order.class));
    verify(resourcePurgeDao)
        .findCarts(isNull(), isNull(), isNull(), isNull(), eq(0), eq(3), isA(List.class));
    verify(resourcePurgeDao)
        .findCartsCount(isNull(), isNull(), isNull(), isNull(), isA(List.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isNull());
    assertEquals(0, resourcePurgeServiceImpl.cartPurgeErrors.size());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeCarts(Map)}.
   *
   * <ul>
   *   <li>Given {@link ResourcePurgeDao} {@link ResourcePurgeDao#findCartsCount(String[],
   *       OrderStatus[], Date, Boolean, List)} return {@link Long#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#purgeCarts(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.purgeCarts(Map)"})
  public void testPurgeCarts_givenResourcePurgeDaoFindCartsCountReturnMax_value()
      throws TransactionException {
    // Arrange
    doNothing().when(orderService).deleteOrder(Mockito.<Order>any());

    ArrayList<Order> orderList = new ArrayList<>();
    orderList.add(new NullOrderImpl());
    when(resourcePurgeDao.findCartsCount(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(Long.MAX_VALUE);
    when(resourcePurgeDao.findCarts(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(orderList);

    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    HashMap<String, String> config = new HashMap<>();
    config.put(
        "Cannot purge carts since there was no configuration provided. In the absence of config params, all"
            + " carts would be candidates for deletion.",
        "Cannot purge carts since there was no configuration provided. In the absence of config params, all"
            + " carts would be candidates for deletion.");

    // Act
    resourcePurgeServiceImpl.purgeCarts(config);

    // Assert that nothing has changed
    verify(orderService).deleteOrder(isA(Order.class));
    verify(resourcePurgeDao)
        .findCarts(isNull(), isNull(), isNull(), isNull(), eq(0), eq(50), isA(List.class));
    verify(resourcePurgeDao)
        .findCartsCount(isNull(), isNull(), isNull(), isNull(), isA(List.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
    assertEquals(0, resourcePurgeServiceImpl.cartPurgeErrors.size());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeCarts(Map)}.
   *
   * <ul>
   *   <li>Given {@link ResourcePurgeDao} {@link ResourcePurgeDao#findCartsCount(String[],
   *       OrderStatus[], Date, Boolean, List)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#purgeCarts(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.purgeCarts(Map)"})
  public void testPurgeCarts_givenResourcePurgeDaoFindCartsCountThrowIllegalArgumentException() {
    // Arrange
    when(resourcePurgeDao.findCartsCount(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenThrow(new IllegalArgumentException());

    HashMap<String, String> config = new HashMap<>();
    config.put(
        "Cannot purge carts since there was no configuration provided. In the absence of config params, all"
            + " carts would be candidates for deletion.",
        "Cannot purge carts since there was no configuration provided. In the absence of config params, all"
            + " carts would be candidates for deletion.");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> resourcePurgeServiceImpl.purgeCarts(config));
    verify(resourcePurgeDao)
        .findCartsCount(isNull(), isNull(), isNull(), isNull(), isA(List.class));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeCarts(Map)}.
   *
   * <ul>
   *   <li>Given {@code RETRY_FAILED_SECONDS}.
   *   <li>When {@link HashMap#HashMap()} {@code RETRY_FAILED_SECONDS} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#purgeCarts(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.purgeCarts(Map)"})
  public void testPurgeCarts_givenRetryFailedSeconds_whenHashMapRetryFailedSecondsIs42()
      throws TransactionException {
    // Arrange
    doNothing().when(orderService).deleteOrder(Mockito.<Order>any());

    ArrayList<Order> orderList = new ArrayList<>();
    orderList.add(new NullOrderImpl());
    when(resourcePurgeDao.findCartsCount(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);
    when(resourcePurgeDao.findCarts(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(orderList);

    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    HashMap<String, String> config = new HashMap<>();
    config.put("RETRY_FAILED_SECONDS", "42");

    // Act
    resourcePurgeServiceImpl.purgeCarts(config);

    // Assert that nothing has changed
    verify(orderService).deleteOrder(isA(Order.class));
    verify(resourcePurgeDao)
        .findCarts(isNull(), isNull(), isNull(), isNull(), eq(0), eq(3), isA(List.class));
    verify(resourcePurgeDao)
        .findCartsCount(isNull(), isNull(), isNull(), isNull(), isA(List.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
    assertEquals(0, resourcePurgeServiceImpl.cartPurgeErrors.size());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeCarts(Map)}.
   *
   * <ul>
   *   <li>Given {@code SECONDS_OLD}.
   *   <li>When {@link HashMap#HashMap()} {@code SECONDS_OLD} is {@code 42}.
   *   <li>Then calls {@link TransactionStatus#isRollbackOnly()}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#purgeCarts(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.purgeCarts(Map)"})
  public void testPurgeCarts_givenSecondsOld_whenHashMapSecondsOldIs42_thenCallsIsRollbackOnly()
      throws TransactionException {
    // Arrange
    doNothing().when(orderService).deleteOrder(Mockito.<Order>any());

    ArrayList<Order> orderList = new ArrayList<>();
    orderList.add(new NullOrderImpl());
    when(resourcePurgeDao.findCartsCount(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);
    when(resourcePurgeDao.findCarts(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(orderList);

    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    HashMap<String, String> config = new HashMap<>();
    config.put("SECONDS_OLD", "42");

    // Act
    resourcePurgeServiceImpl.purgeCarts(config);

    // Assert that nothing has changed
    verify(orderService).deleteOrder(isA(Order.class));
    verify(resourcePurgeDao)
        .findCarts(isNull(), isNull(), isA(Date.class), isNull(), eq(0), eq(3), isA(List.class));
    verify(resourcePurgeDao)
        .findCartsCount(isNull(), isNull(), isA(Date.class), isNull(), isA(List.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
    assertEquals(0, resourcePurgeServiceImpl.cartPurgeErrors.size());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeCarts(Map)}.
   *
   * <ul>
   *   <li>Given {@code STATUS}.
   *   <li>When {@link HashMap#HashMap()} {@code STATUS} is a string.
   *   <li>Then calls {@link TransactionStatus#isRollbackOnly()}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#purgeCarts(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.purgeCarts(Map)"})
  public void testPurgeCarts_givenStatus_whenHashMapStatusIsAString_thenCallsIsRollbackOnly()
      throws TransactionException {
    // Arrange
    doNothing().when(orderService).deleteOrder(Mockito.<Order>any());

    ArrayList<Order> orderList = new ArrayList<>();
    orderList.add(new NullOrderImpl());
    when(resourcePurgeDao.findCartsCount(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);
    when(resourcePurgeDao.findCarts(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(orderList);

    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    HashMap<String, String> config = new HashMap<>();
    config.put(
        "STATUS",
        "Cannot purge carts since there was no configuration provided. In the absence of config params, all"
            + " carts would be candidates for deletion.");

    // Act
    resourcePurgeServiceImpl.purgeCarts(config);

    // Assert that nothing has changed
    verify(orderService).deleteOrder(isA(Order.class));
    verify(resourcePurgeDao)
        .findCarts(
            isNull(), isA(OrderStatus[].class), isNull(), isNull(), eq(0), eq(3), isA(List.class));
    verify(resourcePurgeDao)
        .findCartsCount(isNull(), isA(OrderStatus[].class), isNull(), isNull(), isA(List.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
    assertEquals(0, resourcePurgeServiceImpl.cartPurgeErrors.size());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeCarts(Map)}.
   *
   * <ul>
   *   <li>Then calls {@link PlatformTransactionManager#commit(TransactionStatus)}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#purgeCarts(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.purgeCarts(Map)"})
  public void testPurgeCarts_thenCallsCommit() throws TransactionException {
    // Arrange
    doNothing().when(orderService).deleteOrder(Mockito.<Order>any());

    ArrayList<Order> orderList = new ArrayList<>();
    orderList.add(new NullOrderImpl());
    when(resourcePurgeDao.findCartsCount(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);
    when(resourcePurgeDao.findCarts(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(orderList);
    doNothing().when(platformTransactionManager).commit(Mockito.<TransactionStatus>any());
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(new SimpleTransactionStatus(true));

    HashMap<String, String> config = new HashMap<>();
    config.put(
        "Cannot purge carts since there was no configuration provided. In the absence of config params, all"
            + " carts would be candidates for deletion.",
        "Cannot purge carts since there was no configuration provided. In the absence of config params, all"
            + " carts would be candidates for deletion.");

    // Act
    resourcePurgeServiceImpl.purgeCarts(config);

    // Assert that nothing has changed
    verify(orderService).deleteOrder(isA(Order.class));
    verify(resourcePurgeDao)
        .findCarts(isNull(), isNull(), isNull(), isNull(), eq(0), eq(3), isA(List.class));
    verify(resourcePurgeDao)
        .findCartsCount(isNull(), isNull(), isNull(), isNull(), isA(List.class));
    verify(platformTransactionManager).commit(isA(TransactionStatus.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    assertEquals(0, resourcePurgeServiceImpl.cartPurgeErrors.size());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeCarts(Map)}.
   *
   * <ul>
   *   <li>Then {@link ResourcePurgeServiceImpl} {@link ResourcePurgeServiceImpl#cartPurgeErrors}
   *       size is one.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#purgeCarts(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.purgeCarts(Map)"})
  public void testPurgeCarts_thenResourcePurgeServiceImplCartPurgeErrorsSizeIsOne()
      throws TransactionException {
    // Arrange
    doNothing().when(orderService).deleteOrder(Mockito.<Order>any());

    ArrayList<Order> orderList = new ArrayList<>();
    orderList.add(new NullOrderImpl());
    when(resourcePurgeDao.findCartsCount(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);
    when(resourcePurgeDao.findCarts(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(orderList);
    doThrow(new IllegalArgumentException())
        .when(platformTransactionManager)
        .commit(Mockito.<TransactionStatus>any());
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(new SimpleTransactionStatus(true));
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    HashMap<String, String> config = new HashMap<>();
    config.put(
        "Cannot purge carts since there was no configuration provided. In the absence of config params, all"
            + " carts would be candidates for deletion.",
        "Cannot purge carts since there was no configuration provided. In the absence of config params, all"
            + " carts would be candidates for deletion.");

    // Act
    resourcePurgeServiceImpl.purgeCarts(config);

    // Assert
    verify(orderService).deleteOrder(isA(Order.class));
    verify(resourcePurgeDao)
        .findCarts(isNull(), isNull(), isNull(), isNull(), eq(0), eq(3), isA(List.class));
    verify(resourcePurgeDao)
        .findCartsCount(isNull(), isNull(), isNull(), isNull(), isA(List.class));
    verify(platformTransactionManager).commit(isA(TransactionStatus.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    assertEquals(1, resourcePurgeServiceImpl.cartPurgeErrors.size());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeCarts(Map)}.
   *
   * <ul>
   *   <li>Then {@link ResourcePurgeServiceImpl} {@link ResourcePurgeServiceImpl#cartPurgeErrors}
   *       size is one.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#purgeCarts(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.purgeCarts(Map)"})
  public void testPurgeCarts_thenResourcePurgeServiceImplCartPurgeErrorsSizeIsOne2()
      throws TransactionException {
    // Arrange
    doNothing().when(orderService).deleteOrder(Mockito.<Order>any());

    ArrayList<Order> orderList = new ArrayList<>();
    orderList.add(new NullOrderImpl());
    orderList.add(new NullOrderImpl());
    when(resourcePurgeDao.findCartsCount(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);
    when(resourcePurgeDao.findCarts(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(orderList);
    doThrow(new IllegalArgumentException())
        .when(platformTransactionManager)
        .commit(Mockito.<TransactionStatus>any());
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(new SimpleTransactionStatus(true));
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    HashMap<String, String> config = new HashMap<>();
    config.put(
        "Cannot purge carts since there was no configuration provided. In the absence of config params, all"
            + " carts would be candidates for deletion.",
        "Cannot purge carts since there was no configuration provided. In the absence of config params, all"
            + " carts would be candidates for deletion.");

    // Act
    resourcePurgeServiceImpl.purgeCarts(config);

    // Assert
    verify(orderService, atLeast(1)).deleteOrder(Mockito.<Order>any());
    verify(resourcePurgeDao)
        .findCarts(isNull(), isNull(), isNull(), isNull(), eq(0), eq(3), isA(List.class));
    verify(resourcePurgeDao)
        .findCartsCount(isNull(), isNull(), isNull(), isNull(), isA(List.class));
    verify(platformTransactionManager, atLeast(1)).commit(isA(TransactionStatus.class));
    verify(platformTransactionManager, atLeast(1)).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager, atLeast(1)).rollback(isA(TransactionStatus.class));
    assertEquals(1, resourcePurgeServiceImpl.cartPurgeErrors.size());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeCarts(Map)}.
   *
   * <ul>
   *   <li>Then {@link ResourcePurgeServiceImpl} {@link ResourcePurgeServiceImpl#cartPurgeErrors}
   *       size is zero.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#purgeCarts(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.purgeCarts(Map)"})
  public void testPurgeCarts_thenResourcePurgeServiceImplCartPurgeErrorsSizeIsZero() {
    // Arrange
    when(resourcePurgeDao.findCartsCount(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);
    when(resourcePurgeDao.findCarts(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(new ArrayList<>());

    HashMap<String, String> config = new HashMap<>();
    config.put(
        "Cannot purge carts since there was no configuration provided. In the absence of config params, all"
            + " carts would be candidates for deletion.",
        "Cannot purge carts since there was no configuration provided. In the absence of config params, all"
            + " carts would be candidates for deletion.");

    // Act
    resourcePurgeServiceImpl.purgeCarts(config);

    // Assert that nothing has changed
    verify(resourcePurgeDao)
        .findCarts(isNull(), isNull(), isNull(), isNull(), eq(0), eq(3), isA(List.class));
    verify(resourcePurgeDao)
        .findCartsCount(isNull(), isNull(), isNull(), isNull(), isA(List.class));
    assertEquals(0, resourcePurgeServiceImpl.cartPurgeErrors.size());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeCarts(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()} a string is a string.
   *   <li>Then calls {@link TransactionStatus#isRollbackOnly()}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#purgeCarts(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.purgeCarts(Map)"})
  public void testPurgeCarts_whenHashMapAStringIsAString_thenCallsIsRollbackOnly()
      throws TransactionException {
    // Arrange
    doNothing().when(orderService).deleteOrder(Mockito.<Order>any());

    ArrayList<Order> orderList = new ArrayList<>();
    orderList.add(new NullOrderImpl());
    when(resourcePurgeDao.findCartsCount(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);
    when(resourcePurgeDao.findCarts(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(orderList);

    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    HashMap<String, String> config = new HashMap<>();
    config.put(
        "Cannot purge carts since there was no configuration provided. In the absence of config params, all"
            + " carts would be candidates for deletion.",
        "Cannot purge carts since there was no configuration provided. In the absence of config params, all"
            + " carts would be candidates for deletion.");

    // Act
    resourcePurgeServiceImpl.purgeCarts(config);

    // Assert that nothing has changed
    verify(orderService).deleteOrder(isA(Order.class));
    verify(resourcePurgeDao)
        .findCarts(isNull(), isNull(), isNull(), isNull(), eq(0), eq(3), isA(List.class));
    verify(resourcePurgeDao)
        .findCartsCount(isNull(), isNull(), isNull(), isNull(), isA(List.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
    assertEquals(0, resourcePurgeServiceImpl.cartPurgeErrors.size());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeCarts(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#purgeCarts(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.purgeCarts(Map)"})
  public void testPurgeCarts_whenHashMap_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> resourcePurgeServiceImpl.purgeCarts(new HashMap<>()));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeCarts(Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#purgeCarts(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.purgeCarts(Map)"})
  public void testPurgeCarts_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> resourcePurgeServiceImpl.purgeCarts(null));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#notifyCarts(Map)}.
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#notifyCarts(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.notifyCarts(Map)"})
  public void testNotifyCarts() throws ServiceException {
    // Arrange
    doNothing().when(notificationDispatcher).dispatchNotification(Mockito.<Notification>any());

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
    orderImpl.setName("STATUS");
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

    ArrayList<Order> orderList = new ArrayList<>();
    orderList.add(orderImpl);
    when(resourcePurgeDao.findCartsCount(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);
    when(resourcePurgeDao.findCarts(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(orderList);

    HashMap<String, String> config = new HashMap<>();
    config.put(
        "Cannot notify carts of purge since there was no configuration provided. In the absence of config params,"
            + " all carts would be candidates for deletion.",
        "Cannot notify carts of purge since there was no configuration provided. In the absence of config params,"
            + " all carts would be candidates for deletion.");

    // Act
    resourcePurgeServiceImpl.notifyCarts(config);

    // Assert
    verify(notificationDispatcher).dispatchNotification(isA(Notification.class));
    verify(resourcePurgeDao)
        .findCarts(isNull(), isNull(), isNull(), isNull(), eq(0), eq(3), isA(List.class));
    verify(resourcePurgeDao)
        .findCartsCount(isNull(), isNull(), isNull(), isNull(), isA(List.class));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#notifyCarts(Map)}.
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#notifyCarts(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.notifyCarts(Map)"})
  public void testNotifyCarts2() throws ServiceException {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(notificationDispatcher)
        .dispatchNotification(Mockito.<Notification>any());

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
    orderImpl.setName("STATUS");
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

    ArrayList<Order> orderList = new ArrayList<>();
    orderList.add(orderImpl);
    when(resourcePurgeDao.findCartsCount(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);
    when(resourcePurgeDao.findCarts(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(orderList);

    HashMap<String, String> config = new HashMap<>();
    config.put(
        "Cannot notify carts of purge since there was no configuration provided. In the absence of config params,"
            + " all carts would be candidates for deletion.",
        "Cannot notify carts of purge since there was no configuration provided. In the absence of config params,"
            + " all carts would be candidates for deletion.");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> resourcePurgeServiceImpl.notifyCarts(config));
    verify(notificationDispatcher).dispatchNotification(isA(Notification.class));
    verify(resourcePurgeDao)
        .findCarts(isNull(), isNull(), isNull(), isNull(), eq(0), eq(3), isA(List.class));
    verify(resourcePurgeDao)
        .findCartsCount(isNull(), isNull(), isNull(), isNull(), isA(List.class));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#notifyCarts(Map)}.
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#notifyCarts(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.notifyCarts(Map)"})
  public void testNotifyCarts3() throws ServiceException {
    // Arrange
    doThrow(new ServiceException("An error occurred"))
        .when(notificationDispatcher)
        .dispatchNotification(Mockito.<Notification>any());

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
    orderImpl.setName("STATUS");
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

    ArrayList<Order> orderList = new ArrayList<>();
    orderList.add(orderImpl);
    when(resourcePurgeDao.findCartsCount(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);
    when(resourcePurgeDao.findCarts(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(orderList);

    HashMap<String, String> config = new HashMap<>();
    config.put(
        "Cannot notify carts of purge since there was no configuration provided. In the absence of config params,"
            + " all carts would be candidates for deletion.",
        "Cannot notify carts of purge since there was no configuration provided. In the absence of config params,"
            + " all carts would be candidates for deletion.");

    // Act
    resourcePurgeServiceImpl.notifyCarts(config);

    // Assert
    verify(notificationDispatcher).dispatchNotification(isA(Notification.class));
    verify(resourcePurgeDao)
        .findCarts(isNull(), isNull(), isNull(), isNull(), eq(0), eq(3), isA(List.class));
    verify(resourcePurgeDao)
        .findCartsCount(isNull(), isNull(), isNull(), isNull(), isA(List.class));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#notifyCarts(Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link NullOrderImpl} (default constructor).
   *   <li>Then calls {@link ResourcePurgeDao#findCarts(String[], OrderStatus[], Date, Boolean, int,
   *       int, List)}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#notifyCarts(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.notifyCarts(Map)"})
  public void testNotifyCarts_givenArrayListAddNullOrderImpl_thenCallsFindCarts() {
    // Arrange
    ArrayList<Order> orderList = new ArrayList<>();
    orderList.add(new NullOrderImpl());
    when(resourcePurgeDao.findCartsCount(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);
    when(resourcePurgeDao.findCarts(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(orderList);

    HashMap<String, String> config = new HashMap<>();
    config.put(
        "Cannot notify carts of purge since there was no configuration provided. In the absence of config params,"
            + " all carts would be candidates for deletion.",
        "Cannot notify carts of purge since there was no configuration provided. In the absence of config params,"
            + " all carts would be candidates for deletion.");

    // Act
    resourcePurgeServiceImpl.notifyCarts(config);

    // Assert
    verify(resourcePurgeDao)
        .findCarts(isNull(), isNull(), isNull(), isNull(), eq(0), eq(3), isA(List.class));
    verify(resourcePurgeDao)
        .findCartsCount(isNull(), isNull(), isNull(), isNull(), isA(List.class));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#notifyCarts(Map)}.
   *
   * <ul>
   *   <li>Given {@code IS_PREVIEW}.
   *   <li>When {@link HashMap#HashMap()} {@code IS_PREVIEW} is a string.
   *   <li>Then calls {@link ResourcePurgeDao#findCarts(String[], OrderStatus[], Date, Boolean, int,
   *       int, List)}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#notifyCarts(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.notifyCarts(Map)"})
  public void testNotifyCarts_givenIsPreview_whenHashMapIsPreviewIsAString_thenCallsFindCarts() {
    // Arrange
    when(resourcePurgeDao.findCartsCount(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);
    when(resourcePurgeDao.findCarts(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(new ArrayList<>());

    HashMap<String, String> config = new HashMap<>();
    config.put(
        "IS_PREVIEW",
        "Cannot notify carts of purge since there was no configuration provided. In the absence of config params,"
            + " all carts would be candidates for deletion.");

    // Act
    resourcePurgeServiceImpl.notifyCarts(config);

    // Assert
    verify(resourcePurgeDao)
        .findCarts(isNull(), isNull(), isNull(), eq(false), eq(0), eq(3), isA(List.class));
    verify(resourcePurgeDao)
        .findCartsCount(isNull(), isNull(), isNull(), eq(false), isA(List.class));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#notifyCarts(Map)}.
   *
   * <ul>
   *   <li>Given {@code NAME}.
   *   <li>When {@link HashMap#HashMap()} {@code NAME} is {@code NAME}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#notifyCarts(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.notifyCarts(Map)"})
  public void testNotifyCarts_givenName_whenHashMapNameIsName() {
    // Arrange
    when(resourcePurgeDao.findCartsCount(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenThrow(new IllegalArgumentException());

    HashMap<String, String> config = new HashMap<>();
    config.put("NAME", "NAME");
    config.put(
        "Cannot notify carts of purge since there was no configuration provided. In the absence of config params,"
            + " all carts would be candidates for deletion.",
        "Cannot notify carts of purge since there was no configuration provided. In the absence of config params,"
            + " all carts would be candidates for deletion.");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> resourcePurgeServiceImpl.notifyCarts(config));
    verify(resourcePurgeDao)
        .findCartsCount(isA(String[].class), isNull(), isNull(), isNull(), isA(List.class));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#notifyCarts(Map)}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) EmailAddress is {@code null}.
   *   <li>Then calls {@link ResourcePurgeDao#findCarts(String[], OrderStatus[], Date, Boolean, int,
   *       int, List)}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#notifyCarts(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.notifyCarts(Map)"})
  public void testNotifyCarts_givenOrderImplEmailAddressIsNull_thenCallsFindCarts() {
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
    orderImpl.setEmailAddress(null);
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("STATUS");
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

    ArrayList<Order> orderList = new ArrayList<>();
    orderList.add(orderImpl);
    when(resourcePurgeDao.findCartsCount(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);
    when(resourcePurgeDao.findCarts(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(orderList);

    HashMap<String, String> config = new HashMap<>();
    config.put(
        "Cannot notify carts of purge since there was no configuration provided. In the absence of config params,"
            + " all carts would be candidates for deletion.",
        "Cannot notify carts of purge since there was no configuration provided. In the absence of config params,"
            + " all carts would be candidates for deletion.");

    // Act
    resourcePurgeServiceImpl.notifyCarts(config);

    // Assert
    verify(resourcePurgeDao)
        .findCarts(isNull(), isNull(), isNull(), isNull(), eq(0), eq(3), isA(List.class));
    verify(resourcePurgeDao)
        .findCartsCount(isNull(), isNull(), isNull(), isNull(), isA(List.class));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#notifyCarts(Map)}.
   *
   * <ul>
   *   <li>Given {@link ResourcePurgeDao} {@link ResourcePurgeDao#findCartsCount(String[],
   *       OrderStatus[], Date, Boolean, List)} return {@link Long#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#notifyCarts(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.notifyCarts(Map)"})
  public void testNotifyCarts_givenResourcePurgeDaoFindCartsCountReturnMax_value() {
    // Arrange
    when(resourcePurgeDao.findCartsCount(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(Long.MAX_VALUE);
    when(resourcePurgeDao.findCarts(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(new ArrayList<>());

    HashMap<String, String> config = new HashMap<>();
    config.put(
        "Cannot notify carts of purge since there was no configuration provided. In the absence of config params,"
            + " all carts would be candidates for deletion.",
        "Cannot notify carts of purge since there was no configuration provided. In the absence of config params,"
            + " all carts would be candidates for deletion.");

    // Act
    resourcePurgeServiceImpl.notifyCarts(config);

    // Assert
    verify(resourcePurgeDao)
        .findCarts(isNull(), isNull(), isNull(), isNull(), eq(0), eq(50), isA(List.class));
    verify(resourcePurgeDao)
        .findCartsCount(isNull(), isNull(), isNull(), isNull(), isA(List.class));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#notifyCarts(Map)}.
   *
   * <ul>
   *   <li>Given {@link ResourcePurgeDao} {@link ResourcePurgeDao#findCartsCount(String[],
   *       OrderStatus[], Date, Boolean, List)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#notifyCarts(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.notifyCarts(Map)"})
  public void testNotifyCarts_givenResourcePurgeDaoFindCartsCountThrowIllegalArgumentException() {
    // Arrange
    when(resourcePurgeDao.findCartsCount(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenThrow(new IllegalArgumentException());

    HashMap<String, String> config = new HashMap<>();
    config.put(
        "Cannot notify carts of purge since there was no configuration provided. In the absence of config params,"
            + " all carts would be candidates for deletion.",
        "Cannot notify carts of purge since there was no configuration provided. In the absence of config params,"
            + " all carts would be candidates for deletion.");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> resourcePurgeServiceImpl.notifyCarts(config));
    verify(resourcePurgeDao)
        .findCartsCount(isNull(), isNull(), isNull(), isNull(), isA(List.class));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#notifyCarts(Map)}.
   *
   * <ul>
   *   <li>Given {@code STATUS}.
   *   <li>When {@link HashMap#HashMap()} {@code STATUS} is a string.
   *   <li>Then calls {@link ResourcePurgeDao#findCarts(String[], OrderStatus[], Date, Boolean, int,
   *       int, List)}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#notifyCarts(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.notifyCarts(Map)"})
  public void testNotifyCarts_givenStatus_whenHashMapStatusIsAString_thenCallsFindCarts() {
    // Arrange
    when(resourcePurgeDao.findCartsCount(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);
    when(resourcePurgeDao.findCarts(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(new ArrayList<>());

    HashMap<String, String> config = new HashMap<>();
    config.put(
        "STATUS",
        "Cannot notify carts of purge since there was no configuration provided. In the absence of config params,"
            + " all carts would be candidates for deletion.");

    // Act
    resourcePurgeServiceImpl.notifyCarts(config);

    // Assert
    verify(resourcePurgeDao)
        .findCarts(
            isNull(), isA(OrderStatus[].class), isNull(), isNull(), eq(0), eq(3), isA(List.class));
    verify(resourcePurgeDao)
        .findCartsCount(isNull(), isA(OrderStatus[].class), isNull(), isNull(), isA(List.class));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#notifyCarts(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()} a string is a string.
   *   <li>Then calls {@link ResourcePurgeDao#findCarts(String[], OrderStatus[], Date, Boolean, int,
   *       int, List)}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#notifyCarts(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.notifyCarts(Map)"})
  public void testNotifyCarts_whenHashMapAStringIsAString_thenCallsFindCarts() {
    // Arrange
    when(resourcePurgeDao.findCartsCount(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);
    when(resourcePurgeDao.findCarts(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(new ArrayList<>());

    HashMap<String, String> config = new HashMap<>();
    config.put(
        "Cannot notify carts of purge since there was no configuration provided. In the absence of config params,"
            + " all carts would be candidates for deletion.",
        "Cannot notify carts of purge since there was no configuration provided. In the absence of config params,"
            + " all carts would be candidates for deletion.");

    // Act
    resourcePurgeServiceImpl.notifyCarts(config);

    // Assert
    verify(resourcePurgeDao)
        .findCarts(isNull(), isNull(), isNull(), isNull(), eq(0), eq(3), isA(List.class));
    verify(resourcePurgeDao)
        .findCartsCount(isNull(), isNull(), isNull(), isNull(), isA(List.class));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#notifyCarts(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#notifyCarts(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.notifyCarts(Map)"})
  public void testNotifyCarts_whenHashMap_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourcePurgeServiceImpl.notifyCarts(new HashMap<>()));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#notifyCarts(Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#notifyCarts(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.notifyCarts(Map)"})
  public void testNotifyCarts_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> resourcePurgeServiceImpl.notifyCarts(null));
  }

  /**
   * Test PurgeErrorCache {@link PurgeErrorCache#add(Long)}.
   *
   * <p>Method under test: {@link PurgeErrorCache#add(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long PurgeErrorCache.add(Long)"})
  public void testPurgeErrorCacheAdd() {
    // Arrange
    PurgeErrorCache purgeErrorCache = new ResourcePurgeServiceImpl().new PurgeErrorCache();
    purgeErrorCache.add(1L);

    // Act and Assert
    assertNull(purgeErrorCache.add(1L));
    assertEquals(1, purgeErrorCache.size());
  }

  /**
   * Test PurgeErrorCache {@link PurgeErrorCache#add(Long)}.
   *
   * <ul>
   *   <li>Given {@link PurgeErrorCache#PurgeErrorCache(ResourcePurgeServiceImpl)} with this$0 is
   *       {@link ResourcePurgeServiceImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link PurgeErrorCache#add(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long PurgeErrorCache.add(Long)"})
  public void testPurgeErrorCacheAdd_givenPurgeErrorCacheWithThis$0IsResourcePurgeServiceImpl() {
    // Arrange
    PurgeErrorCache purgeErrorCache = new ResourcePurgeServiceImpl().new PurgeErrorCache();

    // Act and Assert
    assertNull(purgeErrorCache.add(1L));
    assertEquals(1, purgeErrorCache.size());
  }

  /**
   * Test PurgeErrorCache {@link PurgeErrorCache#getEntriesSince(long)}.
   *
   * <p>Method under test: {@link PurgeErrorCache#getEntriesSince(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PurgeErrorCache.getEntriesSince(long)"})
  public void testPurgeErrorCacheGetEntriesSince() {
    // Arrange
    PurgeErrorCache purgeErrorCache = new ResourcePurgeServiceImpl().new PurgeErrorCache();

    // Act
    Set<Long> actualEntriesSince = purgeErrorCache.getEntriesSince(1L);

    // Assert
    assertEquals(0, purgeErrorCache.size());
    assertTrue(actualEntriesSince.isEmpty());
  }

  /**
   * Test PurgeErrorCache {@link PurgeErrorCache#getEntriesSince(long)}.
   *
   * <ul>
   *   <li>When {@link Long#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PurgeErrorCache#getEntriesSince(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PurgeErrorCache.getEntriesSince(long)"})
  public void testPurgeErrorCacheGetEntriesSince_whenMax_value() {
    // Arrange
    PurgeErrorCache purgeErrorCache = new ResourcePurgeServiceImpl().new PurgeErrorCache();
    purgeErrorCache.add(1L);

    // Act
    Set<Long> actualEntriesSince = purgeErrorCache.getEntriesSince(Long.MAX_VALUE);

    // Assert
    assertEquals(0, purgeErrorCache.size());
    assertTrue(actualEntriesSince.isEmpty());
  }

  /**
   * Test PurgeErrorCache {@link PurgeErrorCache#PurgeErrorCache(ResourcePurgeServiceImpl)}.
   *
   * <p>Method under test: {@link PurgeErrorCache#PurgeErrorCache(ResourcePurgeServiceImpl)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PurgeErrorCache.<init>(ResourcePurgeServiceImpl)"})
  public void testPurgeErrorCacheNewPurgeErrorCache() {
    // Arrange, Act and Assert
    assertEquals(0, new ResourcePurgeServiceImpl().new PurgeErrorCache().size());
  }

  /**
   * Test PurgeErrorCache {@link PurgeErrorCache#size()}.
   *
   * <p>Method under test: {@link PurgeErrorCache#size()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int PurgeErrorCache.size()"})
  public void testPurgeErrorCacheSize() {
    // Arrange, Act and Assert
    assertEquals(0, new ResourcePurgeServiceImpl().new PurgeErrorCache().size());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeOrderHistory(Class, String, Map, Map)}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String)} return {@code
   *       Property}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#purgeOrderHistory(Class, String, Map,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.purgeOrderHistory(Class, String, Map, Map)"})
  public void testPurgeOrderHistory_givenEnvironmentGetPropertyReturnProperty() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    Class<Object> rootType = Object.class;
    HashMap<String, List<PathElement>> depends = new HashMap<>();

    // Act
    resourcePurgeServiceImpl.purgeOrderHistory(rootType, "42", depends, new HashMap<>());

    // Assert
    verify(environment).getProperty("enable.purge.order.history");
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeOrderHistory(Class, String, Map, Map)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#purgeOrderHistory(Class, String, Map,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.purgeOrderHistory(Class, String, Map, Map)"})
  public void testPurgeOrderHistory_thenThrowIllegalArgumentException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
    Class<Object> rootType = Object.class;
    HashMap<String, List<PathElement>> depends = new HashMap<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourcePurgeServiceImpl.purgeOrderHistory(rootType, "42", depends, new HashMap<>()));
    verify(environment).getProperty("enable.purge.order.history");
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeCustomers(Map)}.
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#purgeCustomers(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.purgeCustomers(Map)"})
  public void testPurgeCustomers() {
    // Arrange
    when(resourcePurgeDao.findCustomersCount(
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenThrow(new IllegalArgumentException());

    HashMap<String, String> config = new HashMap<>();
    config.put(
        "Cannot purge customers since there was no configuration provided. In the absence of config params, all"
            + " customers would be candidates for deletion.",
        "Cannot purge customers since there was no configuration provided. In the absence of config params, all"
            + " customers would be candidates for deletion.");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> resourcePurgeServiceImpl.purgeCustomers(config));
    verify(resourcePurgeDao)
        .findCustomersCount(isNull(), isNull(), isNull(), isNull(), isA(List.class));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeCustomers(Map)}.
   *
   * <ul>
   *   <li>Given {@code BATCH_SIZE}.
   *   <li>When {@link HashMap#HashMap()} {@code BATCH_SIZE} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#purgeCustomers(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.purgeCustomers(Map)"})
  public void testPurgeCustomers_givenBatchSize_whenHashMapBatchSizeIs42()
      throws TransactionException {
    // Arrange
    doNothing().when(customerService).deleteCustomer(Mockito.<Customer>any());

    ArrayList<Customer> customerList = new ArrayList<>();
    customerList.add(new CustomerImpl());
    when(resourcePurgeDao.findCustomersCount(
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);
    when(resourcePurgeDao.findCustomers(
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(customerList);

    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    HashMap<String, String> config = new HashMap<>();
    config.put("BATCH_SIZE", "42");

    // Act
    resourcePurgeServiceImpl.purgeCustomers(config);

    // Assert that nothing has changed
    verify(resourcePurgeDao)
        .findCustomers(isNull(), isNull(), isNull(), isNull(), eq(0), eq(3), isA(List.class));
    verify(resourcePurgeDao)
        .findCustomersCount(isNull(), isNull(), isNull(), isNull(), isA(List.class));
    verify(customerService).deleteCustomer(isA(Customer.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
    assertEquals(0, resourcePurgeServiceImpl.customerPurgeErrors.size());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeCustomers(Map)}.
   *
   * <ul>
   *   <li>Given {@code IS_DEACTIVATED}.
   *   <li>When {@link HashMap#HashMap()} {@code IS_DEACTIVATED} is a string.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#purgeCustomers(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.purgeCustomers(Map)"})
  public void testPurgeCustomers_givenIsDeactivated_whenHashMapIsDeactivatedIsAString()
      throws TransactionException {
    // Arrange
    doNothing().when(customerService).deleteCustomer(Mockito.<Customer>any());

    ArrayList<Customer> customerList = new ArrayList<>();
    customerList.add(new CustomerImpl());
    when(resourcePurgeDao.findCustomersCount(
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);
    when(resourcePurgeDao.findCustomers(
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(customerList);

    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    HashMap<String, String> config = new HashMap<>();
    config.put(
        "IS_DEACTIVATED",
        "Cannot purge customers since there was no configuration provided. In the absence of config params, all"
            + " customers would be candidates for deletion.");

    // Act
    resourcePurgeServiceImpl.purgeCustomers(config);

    // Assert that nothing has changed
    verify(resourcePurgeDao)
        .findCustomers(isNull(), isNull(), eq(false), isNull(), eq(0), eq(3), isA(List.class));
    verify(resourcePurgeDao)
        .findCustomersCount(isNull(), isNull(), eq(false), isNull(), isA(List.class));
    verify(customerService).deleteCustomer(isA(Customer.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
    assertEquals(0, resourcePurgeServiceImpl.customerPurgeErrors.size());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeCustomers(Map)}.
   *
   * <ul>
   *   <li>Given {@code IS_PREVIEW}.
   *   <li>When {@link HashMap#HashMap()} {@code IS_PREVIEW} is a string.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#purgeCustomers(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.purgeCustomers(Map)"})
  public void testPurgeCustomers_givenIsPreview_whenHashMapIsPreviewIsAString()
      throws TransactionException {
    // Arrange
    doNothing().when(customerService).deleteCustomer(Mockito.<Customer>any());

    ArrayList<Customer> customerList = new ArrayList<>();
    customerList.add(new CustomerImpl());
    when(resourcePurgeDao.findCustomersCount(
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);
    when(resourcePurgeDao.findCustomers(
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(customerList);

    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    HashMap<String, String> config = new HashMap<>();
    config.put(
        "IS_PREVIEW",
        "Cannot purge customers since there was no configuration provided. In the absence of config params, all"
            + " customers would be candidates for deletion.");

    // Act
    resourcePurgeServiceImpl.purgeCustomers(config);

    // Assert that nothing has changed
    verify(resourcePurgeDao)
        .findCustomers(isNull(), isNull(), isNull(), eq(false), eq(0), eq(3), isA(List.class));
    verify(resourcePurgeDao)
        .findCustomersCount(isNull(), isNull(), isNull(), eq(false), isA(List.class));
    verify(customerService).deleteCustomer(isA(Customer.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
    assertEquals(0, resourcePurgeServiceImpl.customerPurgeErrors.size());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeCustomers(Map)}.
   *
   * <ul>
   *   <li>Given {@code IS_REGISTERED}.
   *   <li>When {@link HashMap#HashMap()} {@code IS_REGISTERED} is {@code IS_REGISTERED}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#purgeCustomers(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.purgeCustomers(Map)"})
  public void testPurgeCustomers_givenIsRegistered_whenHashMapIsRegisteredIsIsRegistered()
      throws TransactionException {
    // Arrange
    doNothing().when(customerService).deleteCustomer(Mockito.<Customer>any());

    ArrayList<Customer> customerList = new ArrayList<>();
    customerList.add(new CustomerImpl());
    when(resourcePurgeDao.findCustomersCount(
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);
    when(resourcePurgeDao.findCustomers(
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(customerList);
    doThrow(new IllegalArgumentException())
        .when(platformTransactionManager)
        .commit(Mockito.<TransactionStatus>any());
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(new SimpleTransactionStatus(true));
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    HashMap<String, String> config = new HashMap<>();
    config.put("IS_REGISTERED", "IS_REGISTERED");
    config.put(
        "Cannot purge customers since there was no configuration provided. In the absence of config params, all"
            + " customers would be candidates for deletion.",
        "Cannot purge customers since there was no configuration provided. In the absence of config params, all"
            + " customers would be candidates for deletion.");

    // Act
    resourcePurgeServiceImpl.purgeCustomers(config);

    // Assert
    verify(resourcePurgeDao)
        .findCustomers(isNull(), eq(false), isNull(), isNull(), eq(0), eq(3), isA(List.class));
    verify(resourcePurgeDao)
        .findCustomersCount(isNull(), eq(false), isNull(), isNull(), isA(List.class));
    verify(customerService).deleteCustomer(isA(Customer.class));
    verify(platformTransactionManager).commit(isA(TransactionStatus.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    assertEquals(1, resourcePurgeServiceImpl.customerPurgeErrors.size());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeCustomers(Map)}.
   *
   * <ul>
   *   <li>Given {@link PlatformTransactionManager} {@link
   *       PlatformTransactionManager#getTransaction(TransactionDefinition)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#purgeCustomers(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.purgeCustomers(Map)"})
  public void testPurgeCustomers_givenPlatformTransactionManagerGetTransactionReturnNull()
      throws TransactionException {
    // Arrange
    doNothing().when(customerService).deleteCustomer(Mockito.<Customer>any());

    ArrayList<Customer> customerList = new ArrayList<>();
    customerList.add(new CustomerImpl());
    when(resourcePurgeDao.findCustomersCount(
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);
    when(resourcePurgeDao.findCustomers(
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(customerList);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(null);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    HashMap<String, String> config = new HashMap<>();
    config.put(
        "Cannot purge customers since there was no configuration provided. In the absence of config params, all"
            + " customers would be candidates for deletion.",
        "Cannot purge customers since there was no configuration provided. In the absence of config params, all"
            + " customers would be candidates for deletion.");

    // Act
    resourcePurgeServiceImpl.purgeCustomers(config);

    // Assert that nothing has changed
    verify(resourcePurgeDao)
        .findCustomers(isNull(), isNull(), isNull(), isNull(), eq(0), eq(3), isA(List.class));
    verify(resourcePurgeDao)
        .findCustomersCount(isNull(), isNull(), isNull(), isNull(), isA(List.class));
    verify(customerService).deleteCustomer(isA(Customer.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isNull());
    assertEquals(0, resourcePurgeServiceImpl.customerPurgeErrors.size());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeCustomers(Map)}.
   *
   * <ul>
   *   <li>Given {@link ResourcePurgeDao} {@link ResourcePurgeDao#findCustomersCount(Date, Boolean,
   *       Boolean, Boolean, List)} return {@link Long#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#purgeCustomers(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.purgeCustomers(Map)"})
  public void testPurgeCustomers_givenResourcePurgeDaoFindCustomersCountReturnMax_value()
      throws TransactionException {
    // Arrange
    doNothing().when(customerService).deleteCustomer(Mockito.<Customer>any());

    ArrayList<Customer> customerList = new ArrayList<>();
    customerList.add(new CustomerImpl());
    when(resourcePurgeDao.findCustomersCount(
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(Long.MAX_VALUE);
    when(resourcePurgeDao.findCustomers(
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(customerList);

    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    HashMap<String, String> config = new HashMap<>();
    config.put(
        "Cannot purge customers since there was no configuration provided. In the absence of config params, all"
            + " customers would be candidates for deletion.",
        "Cannot purge customers since there was no configuration provided. In the absence of config params, all"
            + " customers would be candidates for deletion.");

    // Act
    resourcePurgeServiceImpl.purgeCustomers(config);

    // Assert that nothing has changed
    verify(resourcePurgeDao)
        .findCustomers(isNull(), isNull(), isNull(), isNull(), eq(0), eq(50), isA(List.class));
    verify(resourcePurgeDao)
        .findCustomersCount(isNull(), isNull(), isNull(), isNull(), isA(List.class));
    verify(customerService).deleteCustomer(isA(Customer.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
    assertEquals(0, resourcePurgeServiceImpl.customerPurgeErrors.size());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeCustomers(Map)}.
   *
   * <ul>
   *   <li>Given {@code RETRY_FAILED_SECONDS}.
   *   <li>When {@link HashMap#HashMap()} {@code RETRY_FAILED_SECONDS} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#purgeCustomers(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.purgeCustomers(Map)"})
  public void testPurgeCustomers_givenRetryFailedSeconds_whenHashMapRetryFailedSecondsIs42()
      throws TransactionException {
    // Arrange
    doNothing().when(customerService).deleteCustomer(Mockito.<Customer>any());

    ArrayList<Customer> customerList = new ArrayList<>();
    customerList.add(new CustomerImpl());
    when(resourcePurgeDao.findCustomersCount(
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);
    when(resourcePurgeDao.findCustomers(
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(customerList);

    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    HashMap<String, String> config = new HashMap<>();
    config.put("RETRY_FAILED_SECONDS", "42");

    // Act
    resourcePurgeServiceImpl.purgeCustomers(config);

    // Assert that nothing has changed
    verify(resourcePurgeDao)
        .findCustomers(isNull(), isNull(), isNull(), isNull(), eq(0), eq(3), isA(List.class));
    verify(resourcePurgeDao)
        .findCustomersCount(isNull(), isNull(), isNull(), isNull(), isA(List.class));
    verify(customerService).deleteCustomer(isA(Customer.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
    assertEquals(0, resourcePurgeServiceImpl.customerPurgeErrors.size());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeCustomers(Map)}.
   *
   * <ul>
   *   <li>Given {@code SECONDS_OLD}.
   *   <li>When {@link HashMap#HashMap()} {@code SECONDS_OLD} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#purgeCustomers(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.purgeCustomers(Map)"})
  public void testPurgeCustomers_givenSecondsOld_whenHashMapSecondsOldIs42()
      throws TransactionException {
    // Arrange
    doNothing().when(customerService).deleteCustomer(Mockito.<Customer>any());

    ArrayList<Customer> customerList = new ArrayList<>();
    customerList.add(new CustomerImpl());
    when(resourcePurgeDao.findCustomersCount(
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);
    when(resourcePurgeDao.findCustomers(
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(customerList);

    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    HashMap<String, String> config = new HashMap<>();
    config.put("SECONDS_OLD", "42");

    // Act
    resourcePurgeServiceImpl.purgeCustomers(config);

    // Assert that nothing has changed
    verify(resourcePurgeDao)
        .findCustomers(
            isA(Date.class), isNull(), isNull(), isNull(), eq(0), eq(3), isA(List.class));
    verify(resourcePurgeDao)
        .findCustomersCount(isA(Date.class), isNull(), isNull(), isNull(), isA(List.class));
    verify(customerService).deleteCustomer(isA(Customer.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
    assertEquals(0, resourcePurgeServiceImpl.customerPurgeErrors.size());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeCustomers(Map)}.
   *
   * <ul>
   *   <li>Then calls {@link PlatformTransactionManager#commit(TransactionStatus)}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#purgeCustomers(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.purgeCustomers(Map)"})
  public void testPurgeCustomers_thenCallsCommit() throws TransactionException {
    // Arrange
    doNothing().when(customerService).deleteCustomer(Mockito.<Customer>any());

    ArrayList<Customer> customerList = new ArrayList<>();
    customerList.add(new CustomerImpl());
    when(resourcePurgeDao.findCustomersCount(
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);
    when(resourcePurgeDao.findCustomers(
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(customerList);
    doNothing().when(platformTransactionManager).commit(Mockito.<TransactionStatus>any());
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(new SimpleTransactionStatus(true));

    HashMap<String, String> config = new HashMap<>();
    config.put(
        "Cannot purge customers since there was no configuration provided. In the absence of config params, all"
            + " customers would be candidates for deletion.",
        "Cannot purge customers since there was no configuration provided. In the absence of config params, all"
            + " customers would be candidates for deletion.");

    // Act
    resourcePurgeServiceImpl.purgeCustomers(config);

    // Assert that nothing has changed
    verify(resourcePurgeDao)
        .findCustomers(isNull(), isNull(), isNull(), isNull(), eq(0), eq(3), isA(List.class));
    verify(resourcePurgeDao)
        .findCustomersCount(isNull(), isNull(), isNull(), isNull(), isA(List.class));
    verify(customerService).deleteCustomer(isA(Customer.class));
    verify(platformTransactionManager).commit(isA(TransactionStatus.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    assertEquals(0, resourcePurgeServiceImpl.customerPurgeErrors.size());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeCustomers(Map)}.
   *
   * <ul>
   *   <li>Then calls {@link TransactionStatus#isRollbackOnly()}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#purgeCustomers(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.purgeCustomers(Map)"})
  public void testPurgeCustomers_thenCallsIsRollbackOnly() throws TransactionException {
    // Arrange
    doNothing().when(customerService).deleteCustomer(Mockito.<Customer>any());

    ArrayList<Customer> customerList = new ArrayList<>();
    customerList.add(new CustomerImpl());
    when(resourcePurgeDao.findCustomersCount(
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);
    when(resourcePurgeDao.findCustomers(
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(customerList);

    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    HashMap<String, String> config = new HashMap<>();
    config.put(
        "Cannot purge customers since there was no configuration provided. In the absence of config params, all"
            + " customers would be candidates for deletion.",
        "Cannot purge customers since there was no configuration provided. In the absence of config params, all"
            + " customers would be candidates for deletion.");

    // Act
    resourcePurgeServiceImpl.purgeCustomers(config);

    // Assert that nothing has changed
    verify(resourcePurgeDao)
        .findCustomers(isNull(), isNull(), isNull(), isNull(), eq(0), eq(3), isA(List.class));
    verify(resourcePurgeDao)
        .findCustomersCount(isNull(), isNull(), isNull(), isNull(), isA(List.class));
    verify(customerService).deleteCustomer(isA(Customer.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
    assertEquals(0, resourcePurgeServiceImpl.customerPurgeErrors.size());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeCustomers(Map)}.
   *
   * <ul>
   *   <li>Then {@link ResourcePurgeServiceImpl} {@link
   *       ResourcePurgeServiceImpl#customerPurgeErrors} size is one.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#purgeCustomers(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.purgeCustomers(Map)"})
  public void testPurgeCustomers_thenResourcePurgeServiceImplCustomerPurgeErrorsSizeIsOne()
      throws TransactionException {
    // Arrange
    doNothing().when(customerService).deleteCustomer(Mockito.<Customer>any());

    ArrayList<Customer> customerList = new ArrayList<>();
    customerList.add(new CustomerImpl());
    when(resourcePurgeDao.findCustomersCount(
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);
    when(resourcePurgeDao.findCustomers(
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(customerList);
    doThrow(new IllegalArgumentException())
        .when(platformTransactionManager)
        .commit(Mockito.<TransactionStatus>any());
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(new SimpleTransactionStatus(true));
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    HashMap<String, String> config = new HashMap<>();
    config.put(
        "Cannot purge customers since there was no configuration provided. In the absence of config params, all"
            + " customers would be candidates for deletion.",
        "Cannot purge customers since there was no configuration provided. In the absence of config params, all"
            + " customers would be candidates for deletion.");

    // Act
    resourcePurgeServiceImpl.purgeCustomers(config);

    // Assert
    verify(resourcePurgeDao)
        .findCustomers(isNull(), isNull(), isNull(), isNull(), eq(0), eq(3), isA(List.class));
    verify(resourcePurgeDao)
        .findCustomersCount(isNull(), isNull(), isNull(), isNull(), isA(List.class));
    verify(customerService).deleteCustomer(isA(Customer.class));
    verify(platformTransactionManager).commit(isA(TransactionStatus.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    assertEquals(1, resourcePurgeServiceImpl.customerPurgeErrors.size());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeCustomers(Map)}.
   *
   * <ul>
   *   <li>Then {@link ResourcePurgeServiceImpl} {@link
   *       ResourcePurgeServiceImpl#customerPurgeErrors} size is one.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#purgeCustomers(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.purgeCustomers(Map)"})
  public void testPurgeCustomers_thenResourcePurgeServiceImplCustomerPurgeErrorsSizeIsOne2()
      throws TransactionException {
    // Arrange
    doNothing().when(customerService).deleteCustomer(Mockito.<Customer>any());

    ArrayList<Customer> customerList = new ArrayList<>();
    customerList.add(new CustomerImpl());
    customerList.add(new CustomerImpl());
    when(resourcePurgeDao.findCustomersCount(
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);
    when(resourcePurgeDao.findCustomers(
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(customerList);
    doThrow(new IllegalArgumentException())
        .when(platformTransactionManager)
        .commit(Mockito.<TransactionStatus>any());
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(new SimpleTransactionStatus(true));
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    HashMap<String, String> config = new HashMap<>();
    config.put(
        "Cannot purge customers since there was no configuration provided. In the absence of config params, all"
            + " customers would be candidates for deletion.",
        "Cannot purge customers since there was no configuration provided. In the absence of config params, all"
            + " customers would be candidates for deletion.");

    // Act
    resourcePurgeServiceImpl.purgeCustomers(config);

    // Assert
    verify(resourcePurgeDao)
        .findCustomers(isNull(), isNull(), isNull(), isNull(), eq(0), eq(3), isA(List.class));
    verify(resourcePurgeDao)
        .findCustomersCount(isNull(), isNull(), isNull(), isNull(), isA(List.class));
    verify(customerService, atLeast(1)).deleteCustomer(isA(Customer.class));
    verify(platformTransactionManager, atLeast(1)).commit(isA(TransactionStatus.class));
    verify(platformTransactionManager, atLeast(1)).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager, atLeast(1)).rollback(isA(TransactionStatus.class));
    assertEquals(1, resourcePurgeServiceImpl.customerPurgeErrors.size());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeCustomers(Map)}.
   *
   * <ul>
   *   <li>Then {@link ResourcePurgeServiceImpl} {@link
   *       ResourcePurgeServiceImpl#customerPurgeErrors} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#purgeCustomers(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.purgeCustomers(Map)"})
  public void testPurgeCustomers_thenResourcePurgeServiceImplCustomerPurgeErrorsSizeIsZero() {
    // Arrange
    when(resourcePurgeDao.findCustomersCount(
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);
    when(resourcePurgeDao.findCustomers(
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(new ArrayList<>());

    HashMap<String, String> config = new HashMap<>();
    config.put(
        "Cannot purge customers since there was no configuration provided. In the absence of config params, all"
            + " customers would be candidates for deletion.",
        "Cannot purge customers since there was no configuration provided. In the absence of config params, all"
            + " customers would be candidates for deletion.");

    // Act
    resourcePurgeServiceImpl.purgeCustomers(config);

    // Assert that nothing has changed
    verify(resourcePurgeDao)
        .findCustomers(isNull(), isNull(), isNull(), isNull(), eq(0), eq(3), isA(List.class));
    verify(resourcePurgeDao)
        .findCustomersCount(isNull(), isNull(), isNull(), isNull(), isA(List.class));
    assertEquals(0, resourcePurgeServiceImpl.customerPurgeErrors.size());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeCustomers(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#purgeCustomers(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.purgeCustomers(Map)"})
  public void testPurgeCustomers_whenHashMap_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourcePurgeServiceImpl.purgeCustomers(new HashMap<>()));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeCustomers(Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#purgeCustomers(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.purgeCustomers(Map)"})
  public void testPurgeCustomers_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> resourcePurgeServiceImpl.purgeCustomers(null));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getCartsInErrorToIgnore(CartPurgeParams)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#getCartsInErrorToIgnore(CartPurgeParams)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ResourcePurgeServiceImpl.getCartsInErrorToIgnore(CartPurgeParams)"})
  public void testGetCartsInErrorToIgnore_givenOne_thenReturnEmpty() {
    // Arrange
    CartPurgeParams purgeParams = mock(CartPurgeParams.class);
    when(purgeParams.getFailedRetryTime()).thenReturn(1L);

    // Act
    Set<Long> actualCartsInErrorToIgnore =
        resourcePurgeServiceImpl.getCartsInErrorToIgnore(purgeParams);

    // Assert
    verify(purgeParams).getFailedRetryTime();
    assertTrue(actualCartsInErrorToIgnore.isEmpty());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getCartsToPurge(CartPurgeParams, int, int, List)}.
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#getCartsToPurge(CartPurgeParams, int,
   * int, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ResourcePurgeServiceImpl.getCartsToPurge(CartPurgeParams, int, int, List)"
  })
  public void testGetCartsToPurge() {
    // Arrange
    when(resourcePurgeDao.findCarts(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(new ArrayList<>());
    CartPurgeParams purgeParams = resourcePurgeServiceImpl.new CartPurgeParams(new HashMap<>());

    // Act
    List<Order> actualCartsToPurge =
        resourcePurgeServiceImpl.getCartsToPurge(purgeParams, 1, 3, new ArrayList<>());

    // Assert
    verify(resourcePurgeDao)
        .findCarts(isNull(), isNull(), isNull(), isNull(), eq(1), eq(3), isA(List.class));
    assertTrue(actualCartsToPurge.isEmpty());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getCartsToPurge(CartPurgeParams, int, int, List)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#getCartsToPurge(CartPurgeParams, int,
   * int, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ResourcePurgeServiceImpl.getCartsToPurge(CartPurgeParams, int, int, List)"
  })
  public void testGetCartsToPurge_givenOne_whenArrayListAddOne() {
    // Arrange
    when(resourcePurgeDao.findCarts(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(new ArrayList<>());

    CartPurgeParams purgeParams = mock(CartPurgeParams.class);
    when(purgeParams.getIsPreview()).thenReturn(true);
    when(purgeParams.getNameArray()).thenReturn(new String[] {"Name Array"});
    when(purgeParams.getDateCreatedMinThreshold())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(purgeParams.getStatusArray()).thenReturn(new OrderStatus[] {OrderStatus.ARCHIVED});

    ArrayList<Long> cartsInError = new ArrayList<>();
    cartsInError.add(1L);

    // Act
    List<Order> actualCartsToPurge =
        resourcePurgeServiceImpl.getCartsToPurge(purgeParams, 1, 3, cartsInError);

    // Assert
    verify(resourcePurgeDao)
        .findCarts(
            isA(String[].class),
            isA(OrderStatus[].class),
            isA(Date.class),
            eq(true),
            eq(1),
            eq(3),
            isA(List.class));
    verify(purgeParams).getDateCreatedMinThreshold();
    verify(purgeParams).getIsPreview();
    verify(purgeParams).getNameArray();
    verify(purgeParams).getStatusArray();
    assertTrue(actualCartsToPurge.isEmpty());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getCartsToPurge(CartPurgeParams, int, int, List)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then calls {@link CartPurgeParams#getDateCreatedMinThreshold()}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#getCartsToPurge(CartPurgeParams, int,
   * int, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ResourcePurgeServiceImpl.getCartsToPurge(CartPurgeParams, int, int, List)"
  })
  public void testGetCartsToPurge_givenTrue_thenCallsGetDateCreatedMinThreshold() {
    // Arrange
    when(resourcePurgeDao.findCarts(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(new ArrayList<>());

    CartPurgeParams purgeParams = mock(CartPurgeParams.class);
    when(purgeParams.getIsPreview()).thenReturn(true);
    when(purgeParams.getNameArray()).thenReturn(new String[] {"Name Array"});
    when(purgeParams.getDateCreatedMinThreshold())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(purgeParams.getStatusArray()).thenReturn(new OrderStatus[] {OrderStatus.ARCHIVED});

    // Act
    List<Order> actualCartsToPurge =
        resourcePurgeServiceImpl.getCartsToPurge(purgeParams, 1, 3, new ArrayList<>());

    // Assert
    verify(resourcePurgeDao)
        .findCarts(
            isA(String[].class),
            isA(OrderStatus[].class),
            isA(Date.class),
            eq(true),
            eq(1),
            eq(3),
            isA(List.class));
    verify(purgeParams).getDateCreatedMinThreshold();
    verify(purgeParams).getIsPreview();
    verify(purgeParams).getNameArray();
    verify(purgeParams).getStatusArray();
    assertTrue(actualCartsToPurge.isEmpty());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getCartsToPurge(CartPurgeParams, int, int, List)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#getCartsToPurge(CartPurgeParams, int,
   * int, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ResourcePurgeServiceImpl.getCartsToPurge(CartPurgeParams, int, int, List)"
  })
  public void testGetCartsToPurge_givenZero_whenArrayListAddZero() {
    // Arrange
    when(resourcePurgeDao.findCarts(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(new ArrayList<>());

    CartPurgeParams purgeParams = mock(CartPurgeParams.class);
    when(purgeParams.getIsPreview()).thenReturn(true);
    when(purgeParams.getNameArray()).thenReturn(new String[] {"Name Array"});
    when(purgeParams.getDateCreatedMinThreshold())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(purgeParams.getStatusArray()).thenReturn(new OrderStatus[] {OrderStatus.ARCHIVED});

    ArrayList<Long> cartsInError = new ArrayList<>();
    cartsInError.add(0L);
    cartsInError.add(1L);

    // Act
    List<Order> actualCartsToPurge =
        resourcePurgeServiceImpl.getCartsToPurge(purgeParams, 1, 3, cartsInError);

    // Assert
    verify(resourcePurgeDao)
        .findCarts(
            isA(String[].class),
            isA(OrderStatus[].class),
            isA(Date.class),
            eq(true),
            eq(1),
            eq(3),
            isA(List.class));
    verify(purgeParams).getDateCreatedMinThreshold();
    verify(purgeParams).getIsPreview();
    verify(purgeParams).getNameArray();
    verify(purgeParams).getStatusArray();
    assertTrue(actualCartsToPurge.isEmpty());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getCartsToPurge(CartPurgeParams, int, int, List)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#getCartsToPurge(CartPurgeParams, int,
   * int, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ResourcePurgeServiceImpl.getCartsToPurge(CartPurgeParams, int, int, List)"
  })
  public void testGetCartsToPurge_thenThrowIllegalArgumentException() {
    // Arrange
    when(resourcePurgeDao.findCarts(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenThrow(new IllegalArgumentException());
    CartPurgeParams purgeParams = resourcePurgeServiceImpl.new CartPurgeParams(new HashMap<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourcePurgeServiceImpl.getCartsToPurge(purgeParams, 1, 3, new ArrayList<>()));
    verify(resourcePurgeDao)
        .findCarts(isNull(), isNull(), isNull(), isNull(), eq(1), eq(3), isA(List.class));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getCartsToPurgeLength(CartPurgeParams, List)}.
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#getCartsToPurgeLength(CartPurgeParams,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long ResourcePurgeServiceImpl.getCartsToPurgeLength(CartPurgeParams, List)"})
  public void testGetCartsToPurgeLength() {
    // Arrange
    when(resourcePurgeDao.findCartsCount(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);
    CartPurgeParams purgeParams = resourcePurgeServiceImpl.new CartPurgeParams(new HashMap<>());

    // Act
    Long actualCartsToPurgeLength =
        resourcePurgeServiceImpl.getCartsToPurgeLength(purgeParams, new ArrayList<>());

    // Assert
    verify(resourcePurgeDao)
        .findCartsCount(isNull(), isNull(), isNull(), isNull(), isA(List.class));
    assertEquals(3L, actualCartsToPurgeLength.longValue());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getCartsToPurgeLength(CartPurgeParams, List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#getCartsToPurgeLength(CartPurgeParams,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long ResourcePurgeServiceImpl.getCartsToPurgeLength(CartPurgeParams, List)"})
  public void testGetCartsToPurgeLength_givenNull_whenArrayListAddOne() {
    // Arrange
    when(resourcePurgeDao.findCartsCount(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);

    CartPurgeParams purgeParams = mock(CartPurgeParams.class);
    when(purgeParams.getBatchSize()).thenReturn(null);
    when(purgeParams.getIsPreview()).thenReturn(true);
    when(purgeParams.getNameArray()).thenReturn(new String[] {"Name Array"});
    when(purgeParams.getDateCreatedMinThreshold())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(purgeParams.getStatusArray()).thenReturn(new OrderStatus[] {OrderStatus.ARCHIVED});

    ArrayList<Long> cartsInError = new ArrayList<>();
    cartsInError.add(1L);

    // Act
    Long actualCartsToPurgeLength =
        resourcePurgeServiceImpl.getCartsToPurgeLength(purgeParams, cartsInError);

    // Assert
    verify(resourcePurgeDao)
        .findCartsCount(
            isA(String[].class),
            isA(OrderStatus[].class),
            isA(Date.class),
            eq(true),
            isA(List.class));
    verify(purgeParams).getBatchSize();
    verify(purgeParams).getDateCreatedMinThreshold();
    verify(purgeParams).getIsPreview();
    verify(purgeParams).getNameArray();
    verify(purgeParams).getStatusArray();
    assertEquals(3L, actualCartsToPurgeLength.longValue());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getCartsToPurgeLength(CartPurgeParams, List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link CartPurgeParams} {@link CartPurgeParams#getBatchSize()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#getCartsToPurgeLength(CartPurgeParams,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long ResourcePurgeServiceImpl.getCartsToPurgeLength(CartPurgeParams, List)"})
  public void testGetCartsToPurgeLength_givenNull_whenCartPurgeParamsGetBatchSizeReturnNull() {
    // Arrange
    when(resourcePurgeDao.findCartsCount(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);

    CartPurgeParams purgeParams = mock(CartPurgeParams.class);
    when(purgeParams.getBatchSize()).thenReturn(null);
    when(purgeParams.getIsPreview()).thenReturn(true);
    when(purgeParams.getNameArray()).thenReturn(new String[] {"Name Array"});
    when(purgeParams.getDateCreatedMinThreshold())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(purgeParams.getStatusArray()).thenReturn(new OrderStatus[] {OrderStatus.ARCHIVED});

    // Act
    Long actualCartsToPurgeLength =
        resourcePurgeServiceImpl.getCartsToPurgeLength(purgeParams, new ArrayList<>());

    // Assert
    verify(resourcePurgeDao)
        .findCartsCount(
            isA(String[].class),
            isA(OrderStatus[].class),
            isA(Date.class),
            eq(true),
            isA(List.class));
    verify(purgeParams).getBatchSize();
    verify(purgeParams).getDateCreatedMinThreshold();
    verify(purgeParams).getIsPreview();
    verify(purgeParams).getNameArray();
    verify(purgeParams).getStatusArray();
    assertEquals(3L, actualCartsToPurgeLength.longValue());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getCartsToPurgeLength(CartPurgeParams, List)}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>When {@link CartPurgeParams} {@link CartPurgeParams#getBatchSize()} return three.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#getCartsToPurgeLength(CartPurgeParams,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long ResourcePurgeServiceImpl.getCartsToPurgeLength(CartPurgeParams, List)"})
  public void testGetCartsToPurgeLength_givenThree_whenCartPurgeParamsGetBatchSizeReturnThree() {
    // Arrange
    when(resourcePurgeDao.findCartsCount(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);

    CartPurgeParams purgeParams = mock(CartPurgeParams.class);
    when(purgeParams.getIsPreview()).thenReturn(true);
    when(purgeParams.getBatchSize()).thenReturn(3L);
    when(purgeParams.getNameArray()).thenReturn(new String[] {"Name Array"});
    when(purgeParams.getDateCreatedMinThreshold())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(purgeParams.getStatusArray()).thenReturn(new OrderStatus[] {OrderStatus.ARCHIVED});

    // Act
    Long actualCartsToPurgeLength =
        resourcePurgeServiceImpl.getCartsToPurgeLength(purgeParams, new ArrayList<>());

    // Assert
    verify(resourcePurgeDao)
        .findCartsCount(
            isA(String[].class),
            isA(OrderStatus[].class),
            isA(Date.class),
            eq(true),
            isA(List.class));
    verify(purgeParams).getBatchSize();
    verify(purgeParams).getDateCreatedMinThreshold();
    verify(purgeParams).getIsPreview();
    verify(purgeParams).getNameArray();
    verify(purgeParams).getStatusArray();
    assertEquals(3L, actualCartsToPurgeLength.longValue());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getCartsToPurgeLength(CartPurgeParams, List)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#getCartsToPurgeLength(CartPurgeParams,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long ResourcePurgeServiceImpl.getCartsToPurgeLength(CartPurgeParams, List)"})
  public void testGetCartsToPurgeLength_givenZero_whenArrayListAddZero() {
    // Arrange
    when(resourcePurgeDao.findCartsCount(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);

    CartPurgeParams purgeParams = mock(CartPurgeParams.class);
    when(purgeParams.getBatchSize()).thenReturn(null);
    when(purgeParams.getIsPreview()).thenReturn(true);
    when(purgeParams.getNameArray()).thenReturn(new String[] {"Name Array"});
    when(purgeParams.getDateCreatedMinThreshold())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(purgeParams.getStatusArray()).thenReturn(new OrderStatus[] {OrderStatus.ARCHIVED});

    ArrayList<Long> cartsInError = new ArrayList<>();
    cartsInError.add(0L);
    cartsInError.add(1L);

    // Act
    Long actualCartsToPurgeLength =
        resourcePurgeServiceImpl.getCartsToPurgeLength(purgeParams, cartsInError);

    // Assert
    verify(resourcePurgeDao)
        .findCartsCount(
            isA(String[].class),
            isA(OrderStatus[].class),
            isA(Date.class),
            eq(true),
            isA(List.class));
    verify(purgeParams).getBatchSize();
    verify(purgeParams).getDateCreatedMinThreshold();
    verify(purgeParams).getIsPreview();
    verify(purgeParams).getNameArray();
    verify(purgeParams).getStatusArray();
    assertEquals(3L, actualCartsToPurgeLength.longValue());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getCartsToPurgeLength(CartPurgeParams, List)}.
   *
   * <ul>
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#getCartsToPurgeLength(CartPurgeParams,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long ResourcePurgeServiceImpl.getCartsToPurgeLength(CartPurgeParams, List)"})
  public void testGetCartsToPurgeLength_thenReturnLongValueIsOne() {
    // Arrange
    when(resourcePurgeDao.findCartsCount(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);

    CartPurgeParams purgeParams = mock(CartPurgeParams.class);
    when(purgeParams.getBatchSize()).thenReturn(1L);
    when(purgeParams.getIsPreview()).thenReturn(true);
    when(purgeParams.getNameArray()).thenReturn(new String[] {"Name Array"});
    when(purgeParams.getDateCreatedMinThreshold())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(purgeParams.getStatusArray()).thenReturn(new OrderStatus[] {OrderStatus.ARCHIVED});

    // Act
    Long actualCartsToPurgeLength =
        resourcePurgeServiceImpl.getCartsToPurgeLength(purgeParams, new ArrayList<>());

    // Assert
    verify(resourcePurgeDao)
        .findCartsCount(
            isA(String[].class),
            isA(OrderStatus[].class),
            isA(Date.class),
            eq(true),
            isA(List.class));
    verify(purgeParams).getBatchSize();
    verify(purgeParams).getDateCreatedMinThreshold();
    verify(purgeParams).getIsPreview();
    verify(purgeParams).getNameArray();
    verify(purgeParams).getStatusArray();
    assertEquals(1L, actualCartsToPurgeLength.longValue());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getCartsToPurgeLength(CartPurgeParams, List)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#getCartsToPurgeLength(CartPurgeParams,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long ResourcePurgeServiceImpl.getCartsToPurgeLength(CartPurgeParams, List)"})
  public void testGetCartsToPurgeLength_thenThrowIllegalArgumentException() {
    // Arrange
    when(resourcePurgeDao.findCartsCount(
            Mockito.<String[]>any(),
            Mockito.<OrderStatus[]>any(),
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenThrow(new IllegalArgumentException());
    CartPurgeParams purgeParams = resourcePurgeServiceImpl.new CartPurgeParams(new HashMap<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourcePurgeServiceImpl.getCartsToPurgeLength(purgeParams, new ArrayList<>()));
    verify(resourcePurgeDao)
        .findCartsCount(isNull(), isNull(), isNull(), isNull(), isA(List.class));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#notifyCart(Order)}.
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#notifyCart(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.notifyCart(Order)"})
  public void testNotifyCart() throws ServiceException {
    // Arrange
    doNothing().when(notificationDispatcher).dispatchNotification(Mockito.<Notification>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    CustomerImpl customer = new CustomerImpl();
    customer.setAuditable(auditable2);
    customer.setChallengeAnswer("Challenge Answer");
    customer.setChallengeQuestion(new ChallengeQuestionImpl());
    customer.setCustomerAddresses(new ArrayList<>());
    customer.setCustomerAttributes(new HashMap<>());
    customer.setCustomerLocale(new LocaleImpl());
    customer.setCustomerPayments(new ArrayList<>());
    customer.setCustomerPhones(new ArrayList<>());
    customer.setDeactivated(true);
    customer.setExternalId("42");
    customer.setFirstName("Jane");
    customer.setId(1L);
    customer.setLastName("Doe");
    customer.setPassword("iloveyou");
    customer.setPasswordChangeRequired(true);
    customer.setReceiveEmail(true);
    customer.setRegistered(true);
    customer.setUnencodedChallengeAnswer("secret");
    customer.setUnencodedPassword("secret");
    customer.setUsername("janedoe");
    customer.setEmailAddress(null);

    OrderImpl cart = new OrderImpl();
    cart.setAdditionalOfferInformation(new HashMap<>());
    cart.setAuditable(auditable);
    cart.setCandidateOrderOffers(new ArrayList<>());
    cart.setCurrency(new BroadleafCurrencyImpl());
    cart.setFulfillmentGroups(new ArrayList<>());
    cart.setId(1L);
    cart.setLocale(new LocaleImpl());
    cart.setName("Name");
    cart.setOrderAttributes(new HashMap<>());
    cart.setOrderItems(new ArrayList<>());
    cart.setOrderMessages(new ArrayList<>());
    cart.setOrderNumber("42");
    cart.setPayments(new ArrayList<>());
    cart.setStatus(OrderStatus.ARCHIVED);
    cart.setSubTotal(new Money());
    cart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    cart.setTaxOverride(true);
    cart.setTotal(new Money());
    cart.setTotalFulfillmentCharges(new Money());
    cart.setTotalTax(new Money());
    cart.setCustomer(customer);
    cart.setEmailAddress("Cart");

    // Act
    resourcePurgeServiceImpl.notifyCart(cart);

    // Assert
    verify(notificationDispatcher).dispatchNotification(isA(Notification.class));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#notifyCart(Order)}.
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#notifyCart(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.notifyCart(Order)"})
  public void testNotifyCart2() throws ServiceException {
    // Arrange
    doThrow(new ServiceException("An error occurred"))
        .when(notificationDispatcher)
        .dispatchNotification(Mockito.<Notification>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    CustomerImpl customer = new CustomerImpl();
    customer.setAuditable(auditable2);
    customer.setChallengeAnswer("Challenge Answer");
    customer.setChallengeQuestion(new ChallengeQuestionImpl());
    customer.setCustomerAddresses(new ArrayList<>());
    customer.setCustomerAttributes(new HashMap<>());
    customer.setCustomerLocale(new LocaleImpl());
    customer.setCustomerPayments(new ArrayList<>());
    customer.setCustomerPhones(new ArrayList<>());
    customer.setDeactivated(true);
    customer.setExternalId("42");
    customer.setFirstName("Jane");
    customer.setId(1L);
    customer.setLastName("Doe");
    customer.setPassword("iloveyou");
    customer.setPasswordChangeRequired(true);
    customer.setReceiveEmail(true);
    customer.setRegistered(true);
    customer.setUnencodedChallengeAnswer("secret");
    customer.setUnencodedPassword("secret");
    customer.setUsername("janedoe");
    customer.setEmailAddress(null);

    OrderImpl cart = new OrderImpl();
    cart.setAdditionalOfferInformation(new HashMap<>());
    cart.setAuditable(auditable);
    cart.setCandidateOrderOffers(new ArrayList<>());
    cart.setCurrency(new BroadleafCurrencyImpl());
    cart.setFulfillmentGroups(new ArrayList<>());
    cart.setId(1L);
    cart.setLocale(new LocaleImpl());
    cart.setName("Name");
    cart.setOrderAttributes(new HashMap<>());
    cart.setOrderItems(new ArrayList<>());
    cart.setOrderMessages(new ArrayList<>());
    cart.setOrderNumber("42");
    cart.setPayments(new ArrayList<>());
    cart.setStatus(OrderStatus.ARCHIVED);
    cart.setSubTotal(new Money());
    cart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    cart.setTaxOverride(true);
    cart.setTotal(new Money());
    cart.setTotalFulfillmentCharges(new Money());
    cart.setTotalTax(new Money());
    cart.setCustomer(customer);
    cart.setEmailAddress("Cart");

    // Act
    resourcePurgeServiceImpl.notifyCart(cart);

    // Assert
    verify(notificationDispatcher).dispatchNotification(isA(Notification.class));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#notifyCart(Order)}.
   *
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor) EmailAddress is {@code Cart}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#notifyCart(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.notifyCart(Order)"})
  public void testNotifyCart_givenCustomerImplEmailAddressIsCart() throws ServiceException {
    // Arrange
    doNothing().when(notificationDispatcher).dispatchNotification(Mockito.<Notification>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    CustomerImpl customer = new CustomerImpl();
    customer.setAuditable(auditable2);
    customer.setChallengeAnswer("Challenge Answer");
    customer.setChallengeQuestion(new ChallengeQuestionImpl());
    customer.setCustomerAddresses(new ArrayList<>());
    customer.setCustomerAttributes(new HashMap<>());
    customer.setCustomerLocale(new LocaleImpl());
    customer.setCustomerPayments(new ArrayList<>());
    customer.setCustomerPhones(new ArrayList<>());
    customer.setDeactivated(true);
    customer.setExternalId("42");
    customer.setFirstName("Jane");
    customer.setId(1L);
    customer.setLastName("Doe");
    customer.setPassword("iloveyou");
    customer.setPasswordChangeRequired(true);
    customer.setReceiveEmail(true);
    customer.setRegistered(true);
    customer.setUnencodedChallengeAnswer("secret");
    customer.setUnencodedPassword("secret");
    customer.setUsername("janedoe");
    customer.setEmailAddress("Cart");

    OrderImpl cart = new OrderImpl();
    cart.setAdditionalOfferInformation(new HashMap<>());
    cart.setAuditable(auditable);
    cart.setCandidateOrderOffers(new ArrayList<>());
    cart.setCurrency(new BroadleafCurrencyImpl());
    cart.setFulfillmentGroups(new ArrayList<>());
    cart.setId(1L);
    cart.setLocale(new LocaleImpl());
    cart.setName("Name");
    cart.setOrderAttributes(new HashMap<>());
    cart.setOrderItems(new ArrayList<>());
    cart.setOrderMessages(new ArrayList<>());
    cart.setOrderNumber("42");
    cart.setPayments(new ArrayList<>());
    cart.setStatus(OrderStatus.ARCHIVED);
    cart.setSubTotal(new Money());
    cart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    cart.setTaxOverride(true);
    cart.setTotal(new Money());
    cart.setTotalFulfillmentCharges(new Money());
    cart.setTotalTax(new Money());
    cart.setCustomer(customer);
    cart.setEmailAddress(null);

    // Act
    resourcePurgeServiceImpl.notifyCart(cart);

    // Assert
    verify(notificationDispatcher).dispatchNotification(isA(Notification.class));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#notifyCart(Order)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#notifyCart(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.notifyCart(Order)"})
  public void testNotifyCart_thenThrowIllegalArgumentException() throws ServiceException {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(notificationDispatcher)
        .dispatchNotification(Mockito.<Notification>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    CustomerImpl customer = new CustomerImpl();
    customer.setAuditable(auditable2);
    customer.setChallengeAnswer("Challenge Answer");
    customer.setChallengeQuestion(new ChallengeQuestionImpl());
    customer.setCustomerAddresses(new ArrayList<>());
    customer.setCustomerAttributes(new HashMap<>());
    customer.setCustomerLocale(new LocaleImpl());
    customer.setCustomerPayments(new ArrayList<>());
    customer.setCustomerPhones(new ArrayList<>());
    customer.setDeactivated(true);
    customer.setExternalId("42");
    customer.setFirstName("Jane");
    customer.setId(1L);
    customer.setLastName("Doe");
    customer.setPassword("iloveyou");
    customer.setPasswordChangeRequired(true);
    customer.setReceiveEmail(true);
    customer.setRegistered(true);
    customer.setUnencodedChallengeAnswer("secret");
    customer.setUnencodedPassword("secret");
    customer.setUsername("janedoe");
    customer.setEmailAddress(null);

    OrderImpl cart = new OrderImpl();
    cart.setAdditionalOfferInformation(new HashMap<>());
    cart.setAuditable(auditable);
    cart.setCandidateOrderOffers(new ArrayList<>());
    cart.setCurrency(new BroadleafCurrencyImpl());
    cart.setFulfillmentGroups(new ArrayList<>());
    cart.setId(1L);
    cart.setLocale(new LocaleImpl());
    cart.setName("Name");
    cart.setOrderAttributes(new HashMap<>());
    cart.setOrderItems(new ArrayList<>());
    cart.setOrderMessages(new ArrayList<>());
    cart.setOrderNumber("42");
    cart.setPayments(new ArrayList<>());
    cart.setStatus(OrderStatus.ARCHIVED);
    cart.setSubTotal(new Money());
    cart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    cart.setTaxOverride(true);
    cart.setTotal(new Money());
    cart.setTotalFulfillmentCharges(new Money());
    cart.setTotalTax(new Money());
    cart.setCustomer(customer);
    cart.setEmailAddress("Cart");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> resourcePurgeServiceImpl.notifyCart(cart));
    verify(notificationDispatcher).dispatchNotification(isA(Notification.class));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getEmailForCart(Order)}.
   *
   * <ul>
   *   <li>Given {@code Cart}.
   *   <li>When {@link OrderImpl} (default constructor) EmailAddress is {@code Cart}.
   *   <li>Then return {@code Cart}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#getEmailForCart(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourcePurgeServiceImpl.getEmailForCart(Order)"})
  public void testGetEmailForCart_givenCart_whenOrderImplEmailAddressIsCart_thenReturnCart() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl cart = new OrderImpl();
    cart.setAdditionalOfferInformation(new HashMap<>());
    cart.setAuditable(auditable);
    cart.setCandidateOrderOffers(new ArrayList<>());
    cart.setCurrency(new BroadleafCurrencyImpl());
    cart.setFulfillmentGroups(new ArrayList<>());
    cart.setId(1L);
    cart.setLocale(new LocaleImpl());
    cart.setName("Name");
    cart.setOrderAttributes(new HashMap<>());
    cart.setOrderItems(new ArrayList<>());
    cart.setOrderMessages(new ArrayList<>());
    cart.setOrderNumber("42");
    cart.setPayments(new ArrayList<>());
    cart.setStatus(OrderStatus.ARCHIVED);
    cart.setSubTotal(new Money());
    cart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    cart.setTaxOverride(true);
    cart.setTotal(new Money());
    cart.setTotalFulfillmentCharges(new Money());
    cart.setTotalTax(new Money());
    cart.setEmailAddress("Cart");
    cart.setCustomer(null);

    // Act and Assert
    assertEquals("Cart", resourcePurgeServiceImpl.getEmailForCart(cart));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getEmailForCart(Order)}.
   *
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor) Auditable is {@link Auditable} (default
   *       constructor).
   *   <li>Then return {@code Cart}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#getEmailForCart(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourcePurgeServiceImpl.getEmailForCart(Order)"})
  public void testGetEmailForCart_givenCustomerImplAuditableIsAuditable_thenReturnCart() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    CustomerImpl customer = new CustomerImpl();
    customer.setAuditable(auditable2);
    customer.setChallengeAnswer("Challenge Answer");
    customer.setChallengeQuestion(new ChallengeQuestionImpl());
    customer.setCustomerAddresses(new ArrayList<>());
    customer.setCustomerAttributes(new HashMap<>());
    customer.setCustomerLocale(new LocaleImpl());
    customer.setCustomerPayments(new ArrayList<>());
    customer.setCustomerPhones(new ArrayList<>());
    customer.setDeactivated(true);
    customer.setExternalId("42");
    customer.setFirstName("Jane");
    customer.setId(1L);
    customer.setLastName("Doe");
    customer.setPassword("iloveyou");
    customer.setPasswordChangeRequired(true);
    customer.setReceiveEmail(true);
    customer.setRegistered(true);
    customer.setUnencodedChallengeAnswer("secret");
    customer.setUnencodedPassword("secret");
    customer.setUsername("janedoe");
    customer.setEmailAddress("Cart");

    OrderImpl cart = new OrderImpl();
    cart.setAdditionalOfferInformation(new HashMap<>());
    cart.setAuditable(auditable);
    cart.setCandidateOrderOffers(new ArrayList<>());
    cart.setCurrency(new BroadleafCurrencyImpl());
    cart.setFulfillmentGroups(new ArrayList<>());
    cart.setId(1L);
    cart.setLocale(new LocaleImpl());
    cart.setName("Name");
    cart.setOrderAttributes(new HashMap<>());
    cart.setOrderItems(new ArrayList<>());
    cart.setOrderMessages(new ArrayList<>());
    cart.setOrderNumber("42");
    cart.setPayments(new ArrayList<>());
    cart.setStatus(OrderStatus.ARCHIVED);
    cart.setSubTotal(new Money());
    cart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    cart.setTaxOverride(true);
    cart.setTotal(new Money());
    cart.setTotalFulfillmentCharges(new Money());
    cart.setTotalTax(new Money());
    cart.setEmailAddress(null);
    cart.setCustomer(customer);

    // Act and Assert
    assertEquals("Cart", resourcePurgeServiceImpl.getEmailForCart(cart));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getEmailForCart(Order)}.
   *
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#getEmailForCart(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourcePurgeServiceImpl.getEmailForCart(Order)"})
  public void testGetEmailForCart_givenCustomerImpl_thenReturnNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl cart = new OrderImpl();
    cart.setAdditionalOfferInformation(new HashMap<>());
    cart.setAuditable(auditable);
    cart.setCandidateOrderOffers(new ArrayList<>());
    cart.setCurrency(new BroadleafCurrencyImpl());
    cart.setFulfillmentGroups(new ArrayList<>());
    cart.setId(1L);
    cart.setLocale(new LocaleImpl());
    cart.setName("Name");
    cart.setOrderAttributes(new HashMap<>());
    cart.setOrderItems(new ArrayList<>());
    cart.setOrderMessages(new ArrayList<>());
    cart.setOrderNumber("42");
    cart.setPayments(new ArrayList<>());
    cart.setStatus(OrderStatus.ARCHIVED);
    cart.setSubTotal(new Money());
    cart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    cart.setTaxOverride(true);
    cart.setTotal(new Money());
    cart.setTotalFulfillmentCharges(new Money());
    cart.setTotalTax(new Money());
    cart.setEmailAddress(null);
    cart.setCustomer(new CustomerImpl());

    // Act and Assert
    assertNull(resourcePurgeServiceImpl.getEmailForCart(cart));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getEmailForCart(Order)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#getEmailForCart(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourcePurgeServiceImpl.getEmailForCart(Order)"})
  public void testGetEmailForCart_thenThrowIllegalArgumentException() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getEmailAddress()).thenThrow(new IllegalArgumentException());

    OrderImpl cart = new OrderImpl();
    cart.setAdditionalOfferInformation(new HashMap<>());
    cart.setAuditable(auditable);
    cart.setCandidateOrderOffers(new ArrayList<>());
    cart.setCurrency(new BroadleafCurrencyImpl());
    cart.setFulfillmentGroups(new ArrayList<>());
    cart.setId(1L);
    cart.setLocale(new LocaleImpl());
    cart.setName("Name");
    cart.setOrderAttributes(new HashMap<>());
    cart.setOrderItems(new ArrayList<>());
    cart.setOrderMessages(new ArrayList<>());
    cart.setOrderNumber("42");
    cart.setPayments(new ArrayList<>());
    cart.setStatus(OrderStatus.ARCHIVED);
    cart.setSubTotal(new Money());
    cart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    cart.setTaxOverride(true);
    cart.setTotal(new Money());
    cart.setTotalFulfillmentCharges(new Money());
    cart.setTotalTax(new Money());
    cart.setEmailAddress(null);
    cart.setCustomer(customer);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> resourcePurgeServiceImpl.getEmailForCart(cart));
    verify(customer).getEmailAddress();
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getEmailForCart(Order)}.
   *
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#getEmailForCart(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourcePurgeServiceImpl.getEmailForCart(Order)"})
  public void testGetEmailForCart_whenNullOrderImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(resourcePurgeServiceImpl.getEmailForCart(new NullOrderImpl()));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#deleteCart(Order)}.
   *
   * <ul>
   *   <li>Given {@link OrderService} {@link OrderService#deleteOrder(Order)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#deleteCart(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.deleteCart(Order)"})
  public void testDeleteCart_givenOrderServiceDeleteOrderDoesNothing() {
    // Arrange
    doNothing().when(orderService).deleteOrder(Mockito.<Order>any());

    // Act
    resourcePurgeServiceImpl.deleteCart(new NullOrderImpl());

    // Assert
    verify(orderService).deleteOrder(isA(Order.class));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#deleteCart(Order)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#deleteCart(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.deleteCart(Order)"})
  public void testDeleteCart_thenThrowIllegalArgumentException() {
    // Arrange
    doThrow(new IllegalArgumentException()).when(orderService).deleteOrder(Mockito.<Order>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourcePurgeServiceImpl.deleteCart(new NullOrderImpl()));
    verify(orderService).deleteOrder(isA(Order.class));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getCustomersInErrorToIgnore(CustomerPurgeParams)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourcePurgeServiceImpl#getCustomersInErrorToIgnore(CustomerPurgeParams)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ResourcePurgeServiceImpl.getCustomersInErrorToIgnore(CustomerPurgeParams)"
  })
  public void testGetCustomersInErrorToIgnore_givenOne_thenReturnEmpty() {
    // Arrange
    CustomerPurgeParams purgeParams = mock(CustomerPurgeParams.class);
    when(purgeParams.getFailedRetryTime()).thenReturn(1L);

    // Act
    Set<Long> actualCustomersInErrorToIgnore =
        resourcePurgeServiceImpl.getCustomersInErrorToIgnore(purgeParams);

    // Assert
    verify(purgeParams).getFailedRetryTime();
    assertTrue(actualCustomersInErrorToIgnore.isEmpty());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getCustomersToPurge(CustomerPurgeParams, int, int, List)}.
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#getCustomersToPurge(CustomerPurgeParams,
   * int, int, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ResourcePurgeServiceImpl.getCustomersToPurge(CustomerPurgeParams, int, int, List)"
  })
  public void testGetCustomersToPurge() {
    // Arrange
    when(resourcePurgeDao.findCustomers(
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(new ArrayList<>());
    CustomerPurgeParams purgeParams =
        resourcePurgeServiceImpl.new CustomerPurgeParams(new HashMap<>());

    // Act
    List<Customer> actualCustomersToPurge =
        resourcePurgeServiceImpl.getCustomersToPurge(purgeParams, 1, 3, new ArrayList<>());

    // Assert
    verify(resourcePurgeDao)
        .findCustomers(isNull(), isNull(), isNull(), isNull(), eq(1), eq(3), isA(List.class));
    assertTrue(actualCustomersToPurge.isEmpty());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getCustomersToPurge(CustomerPurgeParams, int, int, List)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#getCustomersToPurge(CustomerPurgeParams,
   * int, int, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ResourcePurgeServiceImpl.getCustomersToPurge(CustomerPurgeParams, int, int, List)"
  })
  public void testGetCustomersToPurge_givenOne_whenArrayListAddOne() {
    // Arrange
    when(resourcePurgeDao.findCustomers(
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(new ArrayList<>());

    CustomerPurgeParams purgeParams = mock(CustomerPurgeParams.class);
    when(purgeParams.getIsDeactivated()).thenReturn(true);
    when(purgeParams.getIsPreview()).thenReturn(true);
    when(purgeParams.getIsRegistered()).thenReturn(true);
    when(purgeParams.getDateCreatedMinThreshold())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    ArrayList<Long> customersInError = new ArrayList<>();
    customersInError.add(1L);

    // Act
    List<Customer> actualCustomersToPurge =
        resourcePurgeServiceImpl.getCustomersToPurge(purgeParams, 1, 3, customersInError);

    // Assert
    verify(resourcePurgeDao)
        .findCustomers(
            isA(Date.class), eq(true), eq(true), eq(true), eq(1), eq(3), isA(List.class));
    verify(purgeParams).getDateCreatedMinThreshold();
    verify(purgeParams).getIsDeactivated();
    verify(purgeParams).getIsPreview();
    verify(purgeParams).getIsRegistered();
    assertTrue(actualCustomersToPurge.isEmpty());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getCustomersToPurge(CustomerPurgeParams, int, int, List)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then calls {@link CustomerPurgeParams#getDateCreatedMinThreshold()}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#getCustomersToPurge(CustomerPurgeParams,
   * int, int, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ResourcePurgeServiceImpl.getCustomersToPurge(CustomerPurgeParams, int, int, List)"
  })
  public void testGetCustomersToPurge_givenTrue_thenCallsGetDateCreatedMinThreshold() {
    // Arrange
    when(resourcePurgeDao.findCustomers(
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(new ArrayList<>());

    CustomerPurgeParams purgeParams = mock(CustomerPurgeParams.class);
    when(purgeParams.getIsDeactivated()).thenReturn(true);
    when(purgeParams.getIsPreview()).thenReturn(true);
    when(purgeParams.getIsRegistered()).thenReturn(true);
    when(purgeParams.getDateCreatedMinThreshold())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    List<Customer> actualCustomersToPurge =
        resourcePurgeServiceImpl.getCustomersToPurge(purgeParams, 1, 3, new ArrayList<>());

    // Assert
    verify(resourcePurgeDao)
        .findCustomers(
            isA(Date.class), eq(true), eq(true), eq(true), eq(1), eq(3), isA(List.class));
    verify(purgeParams).getDateCreatedMinThreshold();
    verify(purgeParams).getIsDeactivated();
    verify(purgeParams).getIsPreview();
    verify(purgeParams).getIsRegistered();
    assertTrue(actualCustomersToPurge.isEmpty());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getCustomersToPurge(CustomerPurgeParams, int, int, List)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#getCustomersToPurge(CustomerPurgeParams,
   * int, int, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ResourcePurgeServiceImpl.getCustomersToPurge(CustomerPurgeParams, int, int, List)"
  })
  public void testGetCustomersToPurge_givenZero_whenArrayListAddZero() {
    // Arrange
    when(resourcePurgeDao.findCustomers(
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenReturn(new ArrayList<>());

    CustomerPurgeParams purgeParams = mock(CustomerPurgeParams.class);
    when(purgeParams.getIsDeactivated()).thenReturn(true);
    when(purgeParams.getIsPreview()).thenReturn(true);
    when(purgeParams.getIsRegistered()).thenReturn(true);
    when(purgeParams.getDateCreatedMinThreshold())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    ArrayList<Long> customersInError = new ArrayList<>();
    customersInError.add(0L);
    customersInError.add(1L);

    // Act
    List<Customer> actualCustomersToPurge =
        resourcePurgeServiceImpl.getCustomersToPurge(purgeParams, 1, 3, customersInError);

    // Assert
    verify(resourcePurgeDao)
        .findCustomers(
            isA(Date.class), eq(true), eq(true), eq(true), eq(1), eq(3), isA(List.class));
    verify(purgeParams).getDateCreatedMinThreshold();
    verify(purgeParams).getIsDeactivated();
    verify(purgeParams).getIsPreview();
    verify(purgeParams).getIsRegistered();
    assertTrue(actualCustomersToPurge.isEmpty());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getCustomersToPurge(CustomerPurgeParams, int, int, List)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#getCustomersToPurge(CustomerPurgeParams,
   * int, int, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ResourcePurgeServiceImpl.getCustomersToPurge(CustomerPurgeParams, int, int, List)"
  })
  public void testGetCustomersToPurge_thenThrowIllegalArgumentException() {
    // Arrange
    when(resourcePurgeDao.findCustomers(
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            anyInt(),
            anyInt(),
            Mockito.<List<Long>>any()))
        .thenThrow(new IllegalArgumentException());
    CustomerPurgeParams purgeParams =
        resourcePurgeServiceImpl.new CustomerPurgeParams(new HashMap<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourcePurgeServiceImpl.getCustomersToPurge(purgeParams, 1, 3, new ArrayList<>()));
    verify(resourcePurgeDao)
        .findCustomers(isNull(), isNull(), isNull(), isNull(), eq(1), eq(3), isA(List.class));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getCustomersToPurgeLength(CustomerPurgeParams, List)}.
   *
   * <p>Method under test: {@link
   * ResourcePurgeServiceImpl#getCustomersToPurgeLength(CustomerPurgeParams, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long ResourcePurgeServiceImpl.getCustomersToPurgeLength(CustomerPurgeParams, List)"
  })
  public void testGetCustomersToPurgeLength() {
    // Arrange
    when(resourcePurgeDao.findCustomersCount(
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);
    CustomerPurgeParams purgeParams =
        resourcePurgeServiceImpl.new CustomerPurgeParams(new HashMap<>());

    // Act
    Long actualCustomersToPurgeLength =
        resourcePurgeServiceImpl.getCustomersToPurgeLength(purgeParams, new ArrayList<>());

    // Assert
    verify(resourcePurgeDao)
        .findCustomersCount(isNull(), isNull(), isNull(), isNull(), isA(List.class));
    assertEquals(3L, actualCustomersToPurgeLength.longValue());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getCustomersToPurgeLength(CustomerPurgeParams, List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourcePurgeServiceImpl#getCustomersToPurgeLength(CustomerPurgeParams, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long ResourcePurgeServiceImpl.getCustomersToPurgeLength(CustomerPurgeParams, List)"
  })
  public void testGetCustomersToPurgeLength_givenNull() {
    // Arrange
    when(resourcePurgeDao.findCustomersCount(
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);

    CustomerPurgeParams purgeParams = mock(CustomerPurgeParams.class);
    when(purgeParams.getBatchSize()).thenReturn(null);
    when(purgeParams.getIsDeactivated()).thenReturn(true);
    when(purgeParams.getIsPreview()).thenReturn(true);
    when(purgeParams.getIsRegistered()).thenReturn(true);
    when(purgeParams.getDateCreatedMinThreshold())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    Long actualCustomersToPurgeLength =
        resourcePurgeServiceImpl.getCustomersToPurgeLength(purgeParams, new ArrayList<>());

    // Assert
    verify(resourcePurgeDao)
        .findCustomersCount(isA(Date.class), eq(true), eq(true), eq(true), isA(List.class));
    verify(purgeParams).getBatchSize();
    verify(purgeParams).getDateCreatedMinThreshold();
    verify(purgeParams).getIsDeactivated();
    verify(purgeParams).getIsPreview();
    verify(purgeParams).getIsRegistered();
    assertEquals(3L, actualCustomersToPurgeLength.longValue());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getCustomersToPurgeLength(CustomerPurgeParams, List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourcePurgeServiceImpl#getCustomersToPurgeLength(CustomerPurgeParams, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long ResourcePurgeServiceImpl.getCustomersToPurgeLength(CustomerPurgeParams, List)"
  })
  public void testGetCustomersToPurgeLength_givenNull_whenArrayListAddOne() {
    // Arrange
    when(resourcePurgeDao.findCustomersCount(
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);

    CustomerPurgeParams purgeParams = mock(CustomerPurgeParams.class);
    when(purgeParams.getBatchSize()).thenReturn(null);
    when(purgeParams.getIsDeactivated()).thenReturn(true);
    when(purgeParams.getIsPreview()).thenReturn(true);
    when(purgeParams.getIsRegistered()).thenReturn(true);
    when(purgeParams.getDateCreatedMinThreshold())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    ArrayList<Long> customersInError = new ArrayList<>();
    customersInError.add(1L);

    // Act
    Long actualCustomersToPurgeLength =
        resourcePurgeServiceImpl.getCustomersToPurgeLength(purgeParams, customersInError);

    // Assert
    verify(resourcePurgeDao)
        .findCustomersCount(isA(Date.class), eq(true), eq(true), eq(true), isA(List.class));
    verify(purgeParams).getBatchSize();
    verify(purgeParams).getDateCreatedMinThreshold();
    verify(purgeParams).getIsDeactivated();
    verify(purgeParams).getIsPreview();
    verify(purgeParams).getIsRegistered();
    assertEquals(3L, actualCustomersToPurgeLength.longValue());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getCustomersToPurgeLength(CustomerPurgeParams, List)}.
   *
   * <ul>
   *   <li>Given three.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourcePurgeServiceImpl#getCustomersToPurgeLength(CustomerPurgeParams, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long ResourcePurgeServiceImpl.getCustomersToPurgeLength(CustomerPurgeParams, List)"
  })
  public void testGetCustomersToPurgeLength_givenThree() {
    // Arrange
    when(resourcePurgeDao.findCustomersCount(
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);

    CustomerPurgeParams purgeParams = mock(CustomerPurgeParams.class);
    when(purgeParams.getIsDeactivated()).thenReturn(true);
    when(purgeParams.getIsPreview()).thenReturn(true);
    when(purgeParams.getIsRegistered()).thenReturn(true);
    when(purgeParams.getBatchSize()).thenReturn(3L);
    when(purgeParams.getDateCreatedMinThreshold())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    Long actualCustomersToPurgeLength =
        resourcePurgeServiceImpl.getCustomersToPurgeLength(purgeParams, new ArrayList<>());

    // Assert
    verify(resourcePurgeDao)
        .findCustomersCount(isA(Date.class), eq(true), eq(true), eq(true), isA(List.class));
    verify(purgeParams).getBatchSize();
    verify(purgeParams).getDateCreatedMinThreshold();
    verify(purgeParams).getIsDeactivated();
    verify(purgeParams).getIsPreview();
    verify(purgeParams).getIsRegistered();
    assertEquals(3L, actualCustomersToPurgeLength.longValue());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getCustomersToPurgeLength(CustomerPurgeParams, List)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourcePurgeServiceImpl#getCustomersToPurgeLength(CustomerPurgeParams, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long ResourcePurgeServiceImpl.getCustomersToPurgeLength(CustomerPurgeParams, List)"
  })
  public void testGetCustomersToPurgeLength_givenZero_whenArrayListAddZero() {
    // Arrange
    when(resourcePurgeDao.findCustomersCount(
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);

    CustomerPurgeParams purgeParams = mock(CustomerPurgeParams.class);
    when(purgeParams.getBatchSize()).thenReturn(null);
    when(purgeParams.getIsDeactivated()).thenReturn(true);
    when(purgeParams.getIsPreview()).thenReturn(true);
    when(purgeParams.getIsRegistered()).thenReturn(true);
    when(purgeParams.getDateCreatedMinThreshold())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    ArrayList<Long> customersInError = new ArrayList<>();
    customersInError.add(0L);
    customersInError.add(1L);

    // Act
    Long actualCustomersToPurgeLength =
        resourcePurgeServiceImpl.getCustomersToPurgeLength(purgeParams, customersInError);

    // Assert
    verify(resourcePurgeDao)
        .findCustomersCount(isA(Date.class), eq(true), eq(true), eq(true), isA(List.class));
    verify(purgeParams).getBatchSize();
    verify(purgeParams).getDateCreatedMinThreshold();
    verify(purgeParams).getIsDeactivated();
    verify(purgeParams).getIsPreview();
    verify(purgeParams).getIsRegistered();
    assertEquals(3L, actualCustomersToPurgeLength.longValue());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getCustomersToPurgeLength(CustomerPurgeParams, List)}.
   *
   * <ul>
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourcePurgeServiceImpl#getCustomersToPurgeLength(CustomerPurgeParams, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long ResourcePurgeServiceImpl.getCustomersToPurgeLength(CustomerPurgeParams, List)"
  })
  public void testGetCustomersToPurgeLength_thenReturnLongValueIsOne() {
    // Arrange
    when(resourcePurgeDao.findCustomersCount(
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(3L);

    CustomerPurgeParams purgeParams = mock(CustomerPurgeParams.class);
    when(purgeParams.getBatchSize()).thenReturn(1L);
    when(purgeParams.getIsDeactivated()).thenReturn(true);
    when(purgeParams.getIsPreview()).thenReturn(true);
    when(purgeParams.getIsRegistered()).thenReturn(true);
    when(purgeParams.getDateCreatedMinThreshold())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    Long actualCustomersToPurgeLength =
        resourcePurgeServiceImpl.getCustomersToPurgeLength(purgeParams, new ArrayList<>());

    // Assert
    verify(resourcePurgeDao)
        .findCustomersCount(isA(Date.class), eq(true), eq(true), eq(true), isA(List.class));
    verify(purgeParams).getBatchSize();
    verify(purgeParams).getDateCreatedMinThreshold();
    verify(purgeParams).getIsDeactivated();
    verify(purgeParams).getIsPreview();
    verify(purgeParams).getIsRegistered();
    assertEquals(1L, actualCustomersToPurgeLength.longValue());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getCustomersToPurgeLength(CustomerPurgeParams, List)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourcePurgeServiceImpl#getCustomersToPurgeLength(CustomerPurgeParams, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long ResourcePurgeServiceImpl.getCustomersToPurgeLength(CustomerPurgeParams, List)"
  })
  public void testGetCustomersToPurgeLength_thenThrowIllegalArgumentException() {
    // Arrange
    when(resourcePurgeDao.findCustomersCount(
            Mockito.<Date>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<Boolean>any(),
            Mockito.<List<Long>>any()))
        .thenThrow(new IllegalArgumentException());
    CustomerPurgeParams purgeParams =
        resourcePurgeServiceImpl.new CustomerPurgeParams(new HashMap<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourcePurgeServiceImpl.getCustomersToPurgeLength(purgeParams, new ArrayList<>()));
    verify(resourcePurgeDao)
        .findCustomersCount(isNull(), isNull(), isNull(), isNull(), isA(List.class));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#deleteCustomer(Customer)}.
   *
   * <ul>
   *   <li>Given {@link CustomerService} {@link CustomerService#deleteCustomer(Customer)} does
   *       nothing.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#deleteCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.deleteCustomer(Customer)"})
  public void testDeleteCustomer_givenCustomerServiceDeleteCustomerDoesNothing() {
    // Arrange
    doNothing().when(customerService).deleteCustomer(Mockito.<Customer>any());

    // Act
    resourcePurgeServiceImpl.deleteCustomer(new CustomerImpl());

    // Assert
    verify(customerService).deleteCustomer(isA(Customer.class));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#deleteCustomer(Customer)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ResourcePurgeServiceImpl#deleteCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourcePurgeServiceImpl.deleteCustomer(Customer)"})
  public void testDeleteCustomer_thenThrowIllegalArgumentException() {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(customerService)
        .deleteCustomer(Mockito.<Customer>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> resourcePurgeServiceImpl.deleteCustomer(new CustomerImpl()));
    verify(customerService).deleteCustomer(isA(Customer.class));
  }
}

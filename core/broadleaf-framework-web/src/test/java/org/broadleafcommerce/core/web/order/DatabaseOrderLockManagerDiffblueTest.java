package org.broadleafcommerce.core.web.order;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
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
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DatabaseOrderLockManagerDiffblueTest {
  @InjectMocks private DatabaseOrderLockManager databaseOrderLockManager;

  @Mock private OrderService orderService;

  /**
   * Test {@link DatabaseOrderLockManager#acquireLock(Order)}.
   *
   * <ul>
   *   <li>Given {@link DatabaseOrderLockManager} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseOrderLockManager#acquireLock(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DatabaseOrderLockManager.acquireLock(Order)"})
  public void testAcquireLock_givenDatabaseOrderLockManager_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new DatabaseOrderLockManager().acquireLock(null));
  }

  /**
   * Test {@link DatabaseOrderLockManager#acquireLock(Order)}.
   *
   * <ul>
   *   <li>Given {@link OrderService} {@link OrderService#acquireLock(Order)} return {@code true}.
   *   <li>Then return {@link OrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DatabaseOrderLockManager#acquireLock(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DatabaseOrderLockManager.acquireLock(Order)"})
  public void testAcquireLock_givenOrderServiceAcquireLockReturnTrue_thenReturnOrderImpl() {
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
   *
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).
   *   <li>Then return {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DatabaseOrderLockManager#acquireLock(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DatabaseOrderLockManager.acquireLock(Order)"})
  public void testAcquireLock_whenNullOrderImpl_thenReturnNullOrderImpl() {
    // Arrange
    DatabaseOrderLockManager databaseOrderLockManager = new DatabaseOrderLockManager();
    NullOrderImpl order = new NullOrderImpl();

    // Act
    Object actualAcquireLockResult = databaseOrderLockManager.acquireLock(order);

    // Assert
    assertSame(order, actualAcquireLockResult);
  }

  /**
   * Test {@link DatabaseOrderLockManager#acquireLockIfAvailable(Order)}.
   *
   * <ul>
   *   <li>Given {@link DatabaseOrderLockManager} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseOrderLockManager#acquireLockIfAvailable(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DatabaseOrderLockManager.acquireLockIfAvailable(Order)"})
  public void testAcquireLockIfAvailable_givenDatabaseOrderLockManager_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new DatabaseOrderLockManager().acquireLockIfAvailable(null));
  }

  /**
   * Test {@link DatabaseOrderLockManager#acquireLockIfAvailable(Order)}.
   *
   * <ul>
   *   <li>Given {@link OrderService} {@link OrderService#acquireLock(Order)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseOrderLockManager#acquireLockIfAvailable(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DatabaseOrderLockManager.acquireLockIfAvailable(Order)"})
  public void testAcquireLockIfAvailable_givenOrderServiceAcquireLockReturnFalse() {
    // Arrange
    when(orderService.acquireLock(Mockito.<Order>any())).thenReturn(false);

    // Act
    Object actualAcquireLockIfAvailableResult =
        databaseOrderLockManager.acquireLockIfAvailable(new OrderImpl());

    // Assert
    verify(orderService).acquireLock(isA(Order.class));
    assertNull(actualAcquireLockIfAvailableResult);
  }

  /**
   * Test {@link DatabaseOrderLockManager#acquireLockIfAvailable(Order)}.
   *
   * <ul>
   *   <li>Then return {@link OrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DatabaseOrderLockManager#acquireLockIfAvailable(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DatabaseOrderLockManager.acquireLockIfAvailable(Order)"})
  public void testAcquireLockIfAvailable_thenReturnOrderImpl() {
    // Arrange
    when(orderService.acquireLock(Mockito.<Order>any())).thenReturn(true);
    OrderImpl order = new OrderImpl();

    // Act
    Object actualAcquireLockIfAvailableResult =
        databaseOrderLockManager.acquireLockIfAvailable(order);

    // Assert
    verify(orderService).acquireLock(isA(Order.class));
    assertSame(order, actualAcquireLockIfAvailableResult);
  }

  /**
   * Test {@link DatabaseOrderLockManager#acquireLockIfAvailable(Order)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseOrderLockManager#acquireLockIfAvailable(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DatabaseOrderLockManager.acquireLockIfAvailable(Order)"})
  public void testAcquireLockIfAvailable_thenThrowRuntimeException() {
    // Arrange
    when(orderService.acquireLock(Mockito.<Order>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> databaseOrderLockManager.acquireLockIfAvailable(new OrderImpl()));
    verify(orderService).acquireLock(isA(Order.class));
  }

  /**
   * Test {@link DatabaseOrderLockManager#acquireLockIfAvailable(Order)}.
   *
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).
   *   <li>Then return {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DatabaseOrderLockManager#acquireLockIfAvailable(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DatabaseOrderLockManager.acquireLockIfAvailable(Order)"})
  public void testAcquireLockIfAvailable_whenNullOrderImpl_thenReturnNullOrderImpl() {
    // Arrange
    DatabaseOrderLockManager databaseOrderLockManager = new DatabaseOrderLockManager();
    NullOrderImpl order = new NullOrderImpl();

    // Act
    Object actualAcquireLockIfAvailableResult =
        databaseOrderLockManager.acquireLockIfAvailable(order);

    // Assert
    assertSame(order, actualAcquireLockIfAvailableResult);
  }

  /**
   * Test {@link DatabaseOrderLockManager#releaseLock(Object)}.
   *
   * <ul>
   *   <li>Given {@link OrderService} {@link OrderService#releaseLock(Order)} return {@code true}.
   *   <li>Then calls {@link OrderService#releaseLock(Order)}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseOrderLockManager#releaseLock(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DatabaseOrderLockManager.releaseLock(Object)"})
  public void testReleaseLock_givenOrderServiceReleaseLockReturnTrue_thenCallsReleaseLock() {
    // Arrange
    when(orderService.releaseLock(Mockito.<Order>any())).thenReturn(true);

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
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(new OrderStatus());
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
   * Test {@link DatabaseOrderLockManager#releaseLock(Object)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseOrderLockManager#releaseLock(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DatabaseOrderLockManager.releaseLock(Object)"})
  public void testReleaseLock_thenThrowRuntimeException() {
    // Arrange
    when(orderService.releaseLock(Mockito.<Order>any())).thenThrow(new RuntimeException());

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
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(new OrderStatus());
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> databaseOrderLockManager.releaseLock(orderImpl));
    verify(orderService).releaseLock(isA(Order.class));
  }

  /**
   * Test {@link DatabaseOrderLockManager#releaseLock(Object)}.
   *
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseOrderLockManager#releaseLock(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DatabaseOrderLockManager.releaseLock(Object)"})
  public void testReleaseLock_whenNullOrderImpl_thenDoesNotThrow() {
    // Arrange, Act and Assert
    databaseOrderLockManager.releaseLock(new NullOrderImpl());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DatabaseOrderLockManager}
   *   <li>{@link DatabaseOrderLockManager#isActive()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DatabaseOrderLockManager.<init>()",
    "boolean DatabaseOrderLockManager.isActive()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue(new DatabaseOrderLockManager().isActive());
  }
}

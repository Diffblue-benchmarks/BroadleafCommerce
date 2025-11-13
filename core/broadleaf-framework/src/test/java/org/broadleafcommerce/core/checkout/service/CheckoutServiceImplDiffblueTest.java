package org.broadleafcommerce.core.checkout.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CheckoutServiceImplDiffblueTest {
  @InjectMocks private CheckoutServiceImpl checkoutServiceImpl;

  /**
   * Test {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}.
   *
   * <ul>
   *   <li>Given {@link OrderStatus#ARCHIVED}.
   *   <li>When {@link OrderImpl} (default constructor) Status is {@link OrderStatus#ARCHIVED}.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CheckoutServiceImpl.hasOrderBeenCompleted(Order)"})
  public void testHasOrderBeenCompleted_givenArchived_whenOrderImplStatusIsArchived() {
    // Arrange
    CheckoutServiceImpl checkoutServiceImpl = new CheckoutServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertFalse(checkoutServiceImpl.hasOrderBeenCompleted(order));
  }

  /**
   * Test {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}.
   *
   * <ul>
   *   <li>Given {@link OrderStatus#CANCELLED}.
   *   <li>When {@link OrderImpl} (default constructor) Status is {@link OrderStatus#CANCELLED}.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CheckoutServiceImpl.hasOrderBeenCompleted(Order)"})
  public void testHasOrderBeenCompleted_givenCancelled_whenOrderImplStatusIsCancelled() {
    // Arrange
    CheckoutServiceImpl checkoutServiceImpl = new CheckoutServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.CANCELLED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertTrue(checkoutServiceImpl.hasOrderBeenCompleted(order));
  }

  /**
   * Test {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}.
   *
   * <ul>
   *   <li>Given {@link OrderStatus#SUBMITTED}.
   *   <li>When {@link OrderImpl} (default constructor) Status is {@link OrderStatus#SUBMITTED}.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CheckoutServiceImpl.hasOrderBeenCompleted(Order)"})
  public void testHasOrderBeenCompleted_givenSubmitted_whenOrderImplStatusIsSubmitted() {
    // Arrange
    CheckoutServiceImpl checkoutServiceImpl = new CheckoutServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.SUBMITTED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertTrue(checkoutServiceImpl.hasOrderBeenCompleted(order));
  }

  /**
   * Test {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}.
   *
   * <ul>
   *   <li>Then calls {@link NullOrderImpl#getStatus()}.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CheckoutServiceImpl.hasOrderBeenCompleted(Order)"})
  public void testHasOrderBeenCompleted_thenCallsGetStatus() {
    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getStatus()).thenReturn(new OrderStatus("SUBMITTED", "SUBMITTED"));

    // Act
    boolean actualHasOrderBeenCompletedResult = checkoutServiceImpl.hasOrderBeenCompleted(order);

    // Assert
    verify(order).getStatus();
    assertTrue(actualHasOrderBeenCompletedResult);
  }

  /**
   * Test {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}.
   *
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CheckoutServiceImpl.hasOrderBeenCompleted(Order)"})
  public void testHasOrderBeenCompleted_whenNullOrderImpl_thenReturnFalse() {
    // Arrange
    CheckoutServiceImpl checkoutServiceImpl = new CheckoutServiceImpl();

    // Act and Assert
    assertFalse(checkoutServiceImpl.hasOrderBeenCompleted(new NullOrderImpl()));
  }
}

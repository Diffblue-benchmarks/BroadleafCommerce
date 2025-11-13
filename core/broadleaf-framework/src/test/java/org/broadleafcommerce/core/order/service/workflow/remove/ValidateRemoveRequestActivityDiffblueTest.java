package org.broadleafcommerce.core.order.service.workflow.remove;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
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
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.service.call.NonDiscreteOrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.order.service.workflow.CartOperationRequest;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class ValidateRemoveRequestActivityDiffblueTest {
  /**
   * Test {@link ValidateRemoveRequestActivity#execute(ProcessContext)}.
   *
   * <p>Method under test: {@link ValidateRemoveRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateRemoveRequestActivity.execute(ProcessContext)"})
  public void testExecute() throws Exception {
    // Arrange
    ValidateRemoveRequestActivity validateRemoveRequestActivity =
        new ValidateRemoveRequestActivity();

    NonDiscreteOrderItemRequestDTO itemRequest =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    itemRequest.setOrderItemId(1L);
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    cartOperationRequest.setItemRequest(itemRequest);
    cartOperationRequest.setOrder(null);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> validateRemoveRequestActivity.execute(context));
  }

  /**
   * Test {@link ValidateRemoveRequestActivity#execute(ProcessContext)}.
   *
   * <p>Method under test: {@link ValidateRemoveRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateRemoveRequestActivity.execute(ProcessContext)"})
  public void testExecute2() throws Exception {
    // Arrange
    ValidateRemoveRequestActivity validateRemoveRequestActivity =
        new ValidateRemoveRequestActivity();

    NonDiscreteOrderItemRequestDTO itemRequest =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    itemRequest.setOrderItemId(null);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

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
    order.setOrderItems(orderItems);
    NullOrderImpl order2 = new NullOrderImpl();

    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(order2, new OrderItemRequestDTO(), true);
    cartOperationRequest.setItemRequest(itemRequest);
    cartOperationRequest.setOrder(order);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> validateRemoveRequestActivity.execute(context));
  }

  /**
   * Test {@link ValidateRemoveRequestActivity#execute(ProcessContext)}.
   *
   * <p>Method under test: {@link ValidateRemoveRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateRemoveRequestActivity.execute(ProcessContext)"})
  public void testExecute3() throws Exception {
    // Arrange
    ValidateRemoveRequestActivity validateRemoveRequestActivity =
        new ValidateRemoveRequestActivity();

    NonDiscreteOrderItemRequestDTO itemRequest =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    itemRequest.setOrderItemId(1L);
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    cartOperationRequest.setItemRequest(itemRequest);
    cartOperationRequest.setOrder(new OrderImpl());

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> validateRemoveRequestActivity.execute(context));
  }

  /**
   * Test {@link ValidateRemoveRequestActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then calls {@link CartOperationRequest#getItemRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateRemoveRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateRemoveRequestActivity.execute(ProcessContext)"})
  public void testExecute_thenCallsGetItemRequest() throws Exception {
    // Arrange
    ValidateRemoveRequestActivity validateRemoveRequestActivity =
        new ValidateRemoveRequestActivity();

    NonDiscreteOrderItemRequestDTO itemRequest =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    itemRequest.setOrderItemId(1L);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

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
    order.setOrderItems(orderItems);

    NonDiscreteOrderItemRequestDTO nonDiscreteOrderItemRequestDTO =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    nonDiscreteOrderItemRequestDTO.setOrderItemId(42L);

    CartOperationRequest cartOperationRequest = mock(CartOperationRequest.class);
    when(cartOperationRequest.getOrder()).thenThrow(new IllegalArgumentException());
    when(cartOperationRequest.getItemRequest()).thenReturn(nonDiscreteOrderItemRequestDTO);
    doNothing().when(cartOperationRequest).setItemRequest(Mockito.<OrderItemRequestDTO>any());
    doNothing().when(cartOperationRequest).setOrder(Mockito.<Order>any());
    cartOperationRequest.setItemRequest(itemRequest);
    cartOperationRequest.setOrder(order);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> validateRemoveRequestActivity.execute(context));
    verify(cartOperationRequest).getItemRequest();
    verify(cartOperationRequest).getOrder();
    verify(cartOperationRequest).setItemRequest(isA(OrderItemRequestDTO.class));
    verify(cartOperationRequest).setOrder(isA(Order.class));
  }

  /**
   * Test {@link ValidateRemoveRequestActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then calls {@link Order#getOrderItems()}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateRemoveRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateRemoveRequestActivity.execute(ProcessContext)"})
  public void testExecute_thenCallsGetOrderItems() throws Exception {
    // Arrange
    ValidateRemoveRequestActivity validateRemoveRequestActivity =
        new ValidateRemoveRequestActivity();

    NonDiscreteOrderItemRequestDTO itemRequest =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    itemRequest.setOrderItemId(1L);

    Order order = mock(Order.class);
    when(order.getOrderItems()).thenThrow(new IllegalArgumentException());
    NullOrderImpl order2 = new NullOrderImpl();

    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(order2, new OrderItemRequestDTO(), true);
    cartOperationRequest.setItemRequest(itemRequest);
    cartOperationRequest.setOrder(order);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> validateRemoveRequestActivity.execute(context));
    verify(order).getOrderItems();
  }
}

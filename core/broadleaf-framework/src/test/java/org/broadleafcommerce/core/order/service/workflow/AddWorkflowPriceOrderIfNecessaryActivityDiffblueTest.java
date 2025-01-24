package org.broadleafcommerce.core.order.service.workflow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItem;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AddWorkflowPriceOrderIfNecessaryActivityDiffblueTest {
  @Autowired
  private AddWorkflowPriceOrderIfNecessaryActivity addWorkflowPriceOrderIfNecessaryActivity;

  /**
   * Test
   * {@link AddWorkflowPriceOrderIfNecessaryActivity#execute(ProcessContext)}.
   * <p>
   * Method under test:
   * {@link AddWorkflowPriceOrderIfNecessaryActivity#execute(ProcessContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExecute() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.workflow;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3564 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.workflow.AddWorkflowPriceOrderIfNecessaryActivity addWorkflowPriceOrderIfNecessaryActivity;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AddWorkflowPriceOrderIfNecessaryActivity addWorkflowPriceOrderIfNecessaryActivity2 = new AddWorkflowPriceOrderIfNecessaryActivity();

    // Act
    addWorkflowPriceOrderIfNecessaryActivity2
        .execute((ProcessContext<CartOperationRequest>) new DefaultProcessContextImpl<>());
  }

  /**
   * Test
   * {@link AddWorkflowPriceOrderIfNecessaryActivity#updateChildOrderItem(CartOperationRequest, Order)}.
   * <p>
   * Method under test:
   * {@link AddWorkflowPriceOrderIfNecessaryActivity#updateChildOrderItem(CartOperationRequest, Order)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUpdateChildOrderItem() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.workflow;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3610 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.workflow.AddWorkflowPriceOrderIfNecessaryActivity addWorkflowPriceOrderIfNecessaryActivity;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AddWorkflowPriceOrderIfNecessaryActivity addWorkflowPriceOrderIfNecessaryActivity2 = new AddWorkflowPriceOrderIfNecessaryActivity();
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act
    addWorkflowPriceOrderIfNecessaryActivity2.updateChildOrderItem(request, new NullOrderImpl());
  }

  /**
   * Test
   * {@link AddWorkflowPriceOrderIfNecessaryActivity#updateChildOrderItem(CartOperationRequest, Order)}.
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Auditable is
   * {@link Auditable} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AddWorkflowPriceOrderIfNecessaryActivity#updateChildOrderItem(CartOperationRequest, Order)}
   */
  @Test
  public void testUpdateChildOrderItem_givenOrderItemImplAuditableIsAuditable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AddWorkflowPriceOrderIfNecessaryActivity addWorkflowPriceOrderIfNecessaryActivity = new AddWorkflowPriceOrderIfNecessaryActivity();
    CartOperationRequest request = mock(CartOperationRequest.class);
    when(request.getItemRequest()).thenReturn(new OrderItemRequestDTO());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable2);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(1L);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(new NullOrderImpl());
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(orderItemImpl);

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
    order.setOrderItems(orderItems);
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act
    addWorkflowPriceOrderIfNecessaryActivity.updateChildOrderItem(request, order);

    // Assert
    verify(request).getItemRequest();
  }

  /**
   * Test
   * {@link AddWorkflowPriceOrderIfNecessaryActivity#updateChildOrderItem(CartOperationRequest, Order)}.
   * <ul>
   *   <li>Then calls {@link BundleOrderItemImpl#getDiscreteOrderItems()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AddWorkflowPriceOrderIfNecessaryActivity#updateChildOrderItem(CartOperationRequest, Order)}
   */
  @Test
  public void testUpdateChildOrderItem_thenCallsGetDiscreteOrderItems() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AddWorkflowPriceOrderIfNecessaryActivity addWorkflowPriceOrderIfNecessaryActivity = new AddWorkflowPriceOrderIfNecessaryActivity();
    CartOperationRequest request = mock(CartOperationRequest.class);
    when(request.getItemRequest()).thenReturn(new OrderItemRequestDTO());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getId()).thenReturn(1L);
    when(bundleOrderItemImpl.getDiscreteOrderItems()).thenReturn(new ArrayList<>());
    when(bundleOrderItemImpl.getChildOrderItems()).thenReturn(new ArrayList<>());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setOrderItems(orderItems);
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act
    addWorkflowPriceOrderIfNecessaryActivity.updateChildOrderItem(request, order);

    // Assert
    verify(bundleOrderItemImpl).getDiscreteOrderItems();
    verify(bundleOrderItemImpl).getChildOrderItems();
    verify(bundleOrderItemImpl).getId();
    verify(request).getItemRequest();
  }

  /**
   * Test
   * {@link AddWorkflowPriceOrderIfNecessaryActivity#updateChildOrderItem(CartOperationRequest, Order)}.
   * <ul>
   *   <li>Then calls {@link CartOperationRequest#getOrderItem()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AddWorkflowPriceOrderIfNecessaryActivity#updateChildOrderItem(CartOperationRequest, Order)}
   */
  @Test
  public void testUpdateChildOrderItem_thenCallsGetOrderItem() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AddWorkflowPriceOrderIfNecessaryActivity addWorkflowPriceOrderIfNecessaryActivity = new AddWorkflowPriceOrderIfNecessaryActivity();

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    orderItemRequestDTO.setParentOrderItemId(1L);
    CartOperationRequest request = mock(CartOperationRequest.class);
    when(request.getOrderItem()).thenReturn(new BundleOrderItemImpl());
    when(request.getItemRequest()).thenReturn(orderItemRequestDTO);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getId()).thenReturn(1L);
    when(bundleOrderItemImpl.getChildOrderItems()).thenReturn(new ArrayList<>());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setOrderItems(orderItems);
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act
    addWorkflowPriceOrderIfNecessaryActivity.updateChildOrderItem(request, order);

    // Assert
    verify(bundleOrderItemImpl).getChildOrderItems();
    verify(bundleOrderItemImpl).getId();
    verify(request).getItemRequest();
    verify(request).getOrderItem();
  }

  /**
   * Test
   * {@link AddWorkflowPriceOrderIfNecessaryActivity#checkAndUpdateChildren(CartOperationRequest, OrderItem)}.
   * <p>
   * Method under test:
   * {@link AddWorkflowPriceOrderIfNecessaryActivity#checkAndUpdateChildren(CartOperationRequest, OrderItem)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCheckAndUpdateChildren() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.workflow;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3534 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.workflow.AddWorkflowPriceOrderIfNecessaryActivity addWorkflowPriceOrderIfNecessaryActivity;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AddWorkflowPriceOrderIfNecessaryActivity addWorkflowPriceOrderIfNecessaryActivity2 = new AddWorkflowPriceOrderIfNecessaryActivity();
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act
    addWorkflowPriceOrderIfNecessaryActivity2.checkAndUpdateChildren(request, new BundleOrderItemImpl());
  }

  /**
   * Test
   * {@link AddWorkflowPriceOrderIfNecessaryActivity#checkAndUpdateChildren(CartOperationRequest, OrderItem)}.
   * <ul>
   *   <li>Then {@link OrderItemImpl} (default constructor) ParentOrderItem
   * {@link BundleOrderItemImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AddWorkflowPriceOrderIfNecessaryActivity#checkAndUpdateChildren(CartOperationRequest, OrderItem)}
   */
  @Test
  public void testCheckAndUpdateChildren_thenOrderItemImplParentOrderItemBundleOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AddWorkflowPriceOrderIfNecessaryActivity addWorkflowPriceOrderIfNecessaryActivity = new AddWorkflowPriceOrderIfNecessaryActivity();
    CartOperationRequest request = mock(CartOperationRequest.class);
    when(request.getItemRequest()).thenReturn(new OrderItemRequestDTO());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(1L);
    orderItem.setName("Name");
    orderItem.setOrder(new NullOrderImpl());
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    BundleOrderItemImpl parentOrderItem = new BundleOrderItemImpl();
    orderItem.setParentOrderItem(parentOrderItem);
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    // Act
    boolean actualCheckAndUpdateChildrenResult = addWorkflowPriceOrderIfNecessaryActivity
        .checkAndUpdateChildren(request, orderItem);

    // Assert
    verify(request).getItemRequest();
    OrderItem parentOrderItem2 = orderItem.getParentOrderItem();
    assertTrue(parentOrderItem2 instanceof BundleOrderItemImpl);
    assertFalse(actualCheckAndUpdateChildrenResult);
    assertTrue(orderItem.getChildOrderItems().isEmpty());
    assertSame(parentOrderItem, parentOrderItem2);
  }

  /**
   * Test
   * {@link AddWorkflowPriceOrderIfNecessaryActivity#checkAndUpdateChildren(CartOperationRequest, OrderItem)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AddWorkflowPriceOrderIfNecessaryActivity#checkAndUpdateChildren(CartOperationRequest, OrderItem)}
   */
  @Test
  public void testCheckAndUpdateChildren_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AddWorkflowPriceOrderIfNecessaryActivity addWorkflowPriceOrderIfNecessaryActivity = new AddWorkflowPriceOrderIfNecessaryActivity();

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    orderItemRequestDTO.setParentOrderItemId(1L);
    CartOperationRequest request = mock(CartOperationRequest.class);
    when(request.getOrderItem()).thenReturn(new BundleOrderItemImpl());
    when(request.getItemRequest()).thenReturn(orderItemRequestDTO);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    ArrayList<OrderItem> childOrderItems = new ArrayList<>();
    orderItem.setChildOrderItems(childOrderItems);
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(1L);
    orderItem.setName("Name");
    orderItem.setOrder(new NullOrderImpl());
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    BundleOrderItemImpl parentOrderItem = new BundleOrderItemImpl();
    orderItem.setParentOrderItem(parentOrderItem);
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    // Act
    boolean actualCheckAndUpdateChildrenResult = addWorkflowPriceOrderIfNecessaryActivity
        .checkAndUpdateChildren(request, orderItem);

    // Assert
    verify(request).getItemRequest();
    verify(request).getOrderItem();
    assertTrue(actualCheckAndUpdateChildrenResult);
    assertSame(childOrderItems, orderItem.getChildOrderItems());
    assertSame(parentOrderItem, orderItem.getParentOrderItem());
  }

  /**
   * Test
   * {@link AddWorkflowPriceOrderIfNecessaryActivity#getOiFgiMap(Order, Map, OrderItem)}.
   * <p>
   * Method under test:
   * {@link AddWorkflowPriceOrderIfNecessaryActivity#getOiFgiMap(Order, Map, OrderItem)}
   */
  @Test
  public void testGetOiFgiMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AddWorkflowPriceOrderIfNecessaryActivity addWorkflowPriceOrderIfNecessaryActivity = new AddWorkflowPriceOrderIfNecessaryActivity();
    FulfillmentGroupItemImpl fulfillmentGroupItem = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItem.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.addFulfillmentGroupItem(fulfillmentGroupItem);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    HashMap<OrderItem, List<FulfillmentGroupItem>> oiFgiMap = new HashMap<>();

    // Act
    addWorkflowPriceOrderIfNecessaryActivity.getOiFgiMap(order, oiFgiMap, new BundleOrderItemImpl());

    // Assert
    verify(fulfillmentGroupItem).getOrderItem();
    verify(order).getFulfillmentGroups();
    assertEquals(1, oiFgiMap.size());
  }

  /**
   * Test
   * {@link AddWorkflowPriceOrderIfNecessaryActivity#getOiFgiMap(Order, Map, OrderItem)}.
   * <p>
   * Method under test:
   * {@link AddWorkflowPriceOrderIfNecessaryActivity#getOiFgiMap(Order, Map, OrderItem)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetOiFgiMap2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.workflow;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3580 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.workflow.AddWorkflowPriceOrderIfNecessaryActivity addWorkflowPriceOrderIfNecessaryActivity;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AddWorkflowPriceOrderIfNecessaryActivity addWorkflowPriceOrderIfNecessaryActivity2 = new AddWorkflowPriceOrderIfNecessaryActivity();
    NullOrderImpl order = new NullOrderImpl();
    HashMap<OrderItem, List<FulfillmentGroupItem>> oiFgiMap = new HashMap<>();

    // Act
    addWorkflowPriceOrderIfNecessaryActivity2.getOiFgiMap(order, oiFgiMap, new BundleOrderItemImpl());
  }

  /**
   * Test
   * {@link AddWorkflowPriceOrderIfNecessaryActivity#getOiFgiMap(Order, Map, OrderItem)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link NullOrderImpl#getFulfillmentGroups()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AddWorkflowPriceOrderIfNecessaryActivity#getOiFgiMap(Order, Map, OrderItem)}
   */
  @Test
  public void testGetOiFgiMap_givenArrayList_thenCallsGetFulfillmentGroups() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AddWorkflowPriceOrderIfNecessaryActivity addWorkflowPriceOrderIfNecessaryActivity = new AddWorkflowPriceOrderIfNecessaryActivity();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    HashMap<OrderItem, List<FulfillmentGroupItem>> oiFgiMap = new HashMap<>();

    // Act
    addWorkflowPriceOrderIfNecessaryActivity.getOiFgiMap(order, oiFgiMap, new BundleOrderItemImpl());

    // Assert
    verify(order).getFulfillmentGroups();
    assertEquals(1, oiFgiMap.size());
  }

  /**
   * Test
   * {@link AddWorkflowPriceOrderIfNecessaryActivity#getOiFgiMap(Order, Map, OrderItem)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>When {@link OrderImpl} (default constructor) AdditionalOfferInformation
   * is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AddWorkflowPriceOrderIfNecessaryActivity#getOiFgiMap(Order, Map, OrderItem)}
   */
  @Test
  public void testGetOiFgiMap_givenHashMap_whenOrderImplAdditionalOfferInformationIsHashMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AddWorkflowPriceOrderIfNecessaryActivity addWorkflowPriceOrderIfNecessaryActivity = new AddWorkflowPriceOrderIfNecessaryActivity();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    HashMap<OrderItem, List<FulfillmentGroupItem>> oiFgiMap = new HashMap<>();

    // Act
    addWorkflowPriceOrderIfNecessaryActivity.getOiFgiMap(order, oiFgiMap, new BundleOrderItemImpl());

    // Assert
    assertEquals(1, oiFgiMap.size());
  }

  /**
   * Test
   * {@link AddWorkflowPriceOrderIfNecessaryActivity#getOiFgiMap(Order, Map, OrderItem)}.
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Auditable is
   * {@link Auditable} (default constructor).</li>
   *   <li>Then calls {@link FulfillmentGroupItemImpl#getOrderItem()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AddWorkflowPriceOrderIfNecessaryActivity#getOiFgiMap(Order, Map, OrderItem)}
   */
  @Test
  public void testGetOiFgiMap_givenOrderItemImplAuditableIsAuditable_thenCallsGetOrderItem() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AddWorkflowPriceOrderIfNecessaryActivity addWorkflowPriceOrderIfNecessaryActivity = new AddWorkflowPriceOrderIfNecessaryActivity();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(1L);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(new NullOrderImpl());
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();
    FulfillmentGroupItemImpl fulfillmentGroupItem = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItem.getOrderItem()).thenReturn(orderItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.addFulfillmentGroupItem(fulfillmentGroupItem);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    HashMap<OrderItem, List<FulfillmentGroupItem>> oiFgiMap = new HashMap<>();

    // Act
    addWorkflowPriceOrderIfNecessaryActivity.getOiFgiMap(order, oiFgiMap, new BundleOrderItemImpl());

    // Assert
    verify(fulfillmentGroupItem).getOrderItem();
    verify(order).getFulfillmentGroups();
    assertEquals(1, oiFgiMap.size());
  }

  /**
   * Test
   * {@link AddWorkflowPriceOrderIfNecessaryActivity#getOiFgiMap(Order, Map, OrderItem)}.
   * <ul>
   *   <li>Then calls {@link NullOrderImpl#getFulfillmentGroups()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AddWorkflowPriceOrderIfNecessaryActivity#getOiFgiMap(Order, Map, OrderItem)}
   */
  @Test
  public void testGetOiFgiMap_thenCallsGetFulfillmentGroups() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AddWorkflowPriceOrderIfNecessaryActivity addWorkflowPriceOrderIfNecessaryActivity = new AddWorkflowPriceOrderIfNecessaryActivity();

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(new FulfillmentGroupImpl());
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    HashMap<OrderItem, List<FulfillmentGroupItem>> oiFgiMap = new HashMap<>();

    // Act
    addWorkflowPriceOrderIfNecessaryActivity.getOiFgiMap(order, oiFgiMap, new BundleOrderItemImpl());

    // Assert
    verify(order).getFulfillmentGroups();
    assertEquals(1, oiFgiMap.size());
  }

  /**
   * Test
   * {@link AddWorkflowPriceOrderIfNecessaryActivity#preSaveOperation(CartOperationRequest)}.
   * <p>
   * Method under test:
   * {@link AddWorkflowPriceOrderIfNecessaryActivity#preSaveOperation(CartOperationRequest)}
   */
  @Test
  public void testPreSaveOperation() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     AddWorkflowPriceOrderIfNecessaryActivity.fgItemDao
    //     AddWorkflowPriceOrderIfNecessaryActivity.orderItemService
    //     AddWorkflowPriceOrderIfNecessaryActivity.orderMultishipOptionService
    //     AddWorkflowPriceOrderIfNecessaryActivity.orderService
    //     BaseActivity.automaticallyRegisterRollbackHandler
    //     BaseActivity.beanName
    //     BaseActivity.errorHandler
    //     BaseActivity.order
    //     BaseActivity.rollbackHandler
    //     BaseActivity.rollbackRegion
    //     BaseActivity.stateConfiguration

    // Arrange
    AddWorkflowPriceOrderIfNecessaryActivity addWorkflowPriceOrderIfNecessaryActivity = new AddWorkflowPriceOrderIfNecessaryActivity();
    NullOrderImpl order = new NullOrderImpl();

    // Act
    addWorkflowPriceOrderIfNecessaryActivity
        .preSaveOperation(new CartOperationRequest(order, new OrderItemRequestDTO(), true));
  }
}

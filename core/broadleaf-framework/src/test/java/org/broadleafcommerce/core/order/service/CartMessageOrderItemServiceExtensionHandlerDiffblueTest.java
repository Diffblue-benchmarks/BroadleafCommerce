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
package org.broadleafcommerce.core.order.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.extension.ExtensionManager;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.promotionMessage.domain.PromotionMessageImpl;
import org.broadleafcommerce.core.promotionMessage.dto.PromotionMessageDTO;
import org.broadleafcommerce.core.promotionMessage.service.PromotionMessageGenerator;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class CartMessageOrderItemServiceExtensionHandlerDiffblueTest {
  @InjectMocks
  private CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler;

  @Mock
  private List<PromotionMessageGenerator> list;

  @Mock
  private OrderItemService orderItemService;

  @Mock
  private OrderServiceExtensionManager orderServiceExtensionManager;

  /**
   * Test {@link CartMessageOrderItemServiceExtensionHandler#init()}.
   * <ul>
   *   <li>Then calls {@link ExtensionManager#registerHandler(ExtensionHandler)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CartMessageOrderItemServiceExtensionHandler#init()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CartMessageOrderItemServiceExtensionHandler.init()"})
  public void testInit_thenCallsRegisterHandler() {
    // Arrange
    when(orderServiceExtensionManager.registerHandler(Mockito.<OrderServiceExtensionHandler>any())).thenReturn(true);

    // Act
    cartMessageOrderItemServiceExtensionHandler.init();

    // Assert
    verify(orderServiceExtensionManager).registerHandler(isA(OrderServiceExtensionHandler.class));
  }

  /**
   * Test {@link CartMessageOrderItemServiceExtensionHandler#attachAdditionalDataToOrder(Order, boolean)}.
   * <p>
   * Method under test: {@link CartMessageOrderItemServiceExtensionHandler#attachAdditionalDataToOrder(Order, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType CartMessageOrderItemServiceExtensionHandler.attachAdditionalDataToOrder(Order, boolean)"})
  public void testAttachAdditionalDataToOrder() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    PromotionMessageGenerator promotionMessageGenerator = mock(PromotionMessageGenerator.class);
    when(promotionMessageGenerator.generatePromotionMessages(Mockito.<OrderItem>any())).thenReturn(stringList);

    ArrayList<PromotionMessageGenerator> promotionMessageGeneratorList = new ArrayList<>();
    promotionMessageGeneratorList.add(promotionMessageGenerator);
    when(list.iterator()).thenReturn(promotionMessageGeneratorList.iterator());
    when(orderItemService.saveOrderItem(Mockito.<OrderItem>any())).thenReturn(new BundleOrderItemImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    ExtensionResultStatusType actualAttachAdditionalDataToOrderResult = cartMessageOrderItemServiceExtensionHandler
        .attachAdditionalDataToOrder(order, true);

    // Assert
    verify(list).iterator();
    verify(orderItemService).saveOrderItem(isA(OrderItem.class));
    verify(promotionMessageGenerator).generatePromotionMessages(isA(OrderItem.class));
    List<OrderItem> orderItems2 = order.getOrderItems();
    assertEquals(1, orderItems2.size());
    OrderItem getResult = orderItems2.get(0);
    assertTrue(getResult instanceof BundleOrderItemImpl);
    List<String> cartMessages = getResult.getCartMessages();
    assertEquals(1, cartMessages.size());
    assertEquals("foo", cartMessages.get(0));
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE, actualAttachAdditionalDataToOrderResult);
  }

  /**
   * Test {@link CartMessageOrderItemServiceExtensionHandler#attachAdditionalDataToOrder(Order, boolean)}.
   * <ul>
   *   <li>Then {@link OrderImpl} (default constructor) OrderItems first CartMessages Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CartMessageOrderItemServiceExtensionHandler#attachAdditionalDataToOrder(Order, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType CartMessageOrderItemServiceExtensionHandler.attachAdditionalDataToOrder(Order, boolean)"})
  public void testAttachAdditionalDataToOrder_thenOrderImplOrderItemsFirstCartMessagesEmpty() {
    // Arrange
    ArrayList<PromotionMessageGenerator> promotionMessageGeneratorList = new ArrayList<>();
    when(list.iterator()).thenReturn(promotionMessageGeneratorList.iterator());
    when(orderItemService.saveOrderItem(Mockito.<OrderItem>any())).thenReturn(new BundleOrderItemImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    ExtensionResultStatusType actualAttachAdditionalDataToOrderResult = cartMessageOrderItemServiceExtensionHandler
        .attachAdditionalDataToOrder(order, true);

    // Assert
    verify(list).iterator();
    verify(orderItemService).saveOrderItem(isA(OrderItem.class));
    List<OrderItem> orderItems2 = order.getOrderItems();
    assertEquals(1, orderItems2.size());
    OrderItem getResult = orderItems2.get(0);
    assertTrue(getResult instanceof BundleOrderItemImpl);
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE, actualAttachAdditionalDataToOrderResult);
    assertTrue(getResult.getCartMessages().isEmpty());
  }

  /**
   * Test {@link CartMessageOrderItemServiceExtensionHandler#attachAdditionalDataToOrder(Order, boolean)}.
   * <ul>
   *   <li>Then {@link OrderImpl} (default constructor) OrderItems first CartMessages Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CartMessageOrderItemServiceExtensionHandler#attachAdditionalDataToOrder(Order, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType CartMessageOrderItemServiceExtensionHandler.attachAdditionalDataToOrder(Order, boolean)"})
  public void testAttachAdditionalDataToOrder_thenOrderImplOrderItemsFirstCartMessagesEmpty2() {
    // Arrange
    PromotionMessageGenerator promotionMessageGenerator = mock(PromotionMessageGenerator.class);
    when(promotionMessageGenerator.generatePromotionMessages(Mockito.<OrderItem>any())).thenReturn(new ArrayList<>());

    ArrayList<PromotionMessageGenerator> promotionMessageGeneratorList = new ArrayList<>();
    promotionMessageGeneratorList.add(promotionMessageGenerator);
    when(list.iterator()).thenReturn(promotionMessageGeneratorList.iterator());
    when(orderItemService.saveOrderItem(Mockito.<OrderItem>any())).thenReturn(new BundleOrderItemImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    ExtensionResultStatusType actualAttachAdditionalDataToOrderResult = cartMessageOrderItemServiceExtensionHandler
        .attachAdditionalDataToOrder(order, true);

    // Assert
    verify(list).iterator();
    verify(orderItemService).saveOrderItem(isA(OrderItem.class));
    verify(promotionMessageGenerator).generatePromotionMessages(isA(OrderItem.class));
    List<OrderItem> orderItems2 = order.getOrderItems();
    assertEquals(1, orderItems2.size());
    OrderItem getResult = orderItems2.get(0);
    assertTrue(getResult instanceof BundleOrderItemImpl);
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE, actualAttachAdditionalDataToOrderResult);
    assertTrue(getResult.getCartMessages().isEmpty());
  }

  /**
   * Test {@link CartMessageOrderItemServiceExtensionHandler#attachAdditionalDataToOrder(Order, boolean)}.
   * <ul>
   *   <li>Then return {@code HANDLED_CONTINUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CartMessageOrderItemServiceExtensionHandler#attachAdditionalDataToOrder(Order, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType CartMessageOrderItemServiceExtensionHandler.attachAdditionalDataToOrder(Order, boolean)"})
  public void testAttachAdditionalDataToOrder_thenReturnHandledContinue() {
    // Arrange
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

    // Act and Assert
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE,
        cartMessageOrderItemServiceExtensionHandler.attachAdditionalDataToOrder(order, true));
  }

  /**
   * Test {@link CartMessageOrderItemServiceExtensionHandler#updateOrderItemCartMessages(OrderItem)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CartMessageOrderItemServiceExtensionHandler#updateOrderItemCartMessages(OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CartMessageOrderItemServiceExtensionHandler.updateOrderItemCartMessages(OrderItem)"})
  public void testUpdateOrderItemCartMessages_givenArrayListAddFoo() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    PromotionMessageGenerator promotionMessageGenerator = mock(PromotionMessageGenerator.class);
    when(promotionMessageGenerator.generatePromotionMessages(Mockito.<OrderItem>any())).thenReturn(stringList);

    ArrayList<PromotionMessageGenerator> promotionMessageGeneratorList = new ArrayList<>();
    promotionMessageGeneratorList.add(promotionMessageGenerator);
    when(list.iterator()).thenReturn(promotionMessageGeneratorList.iterator());
    when(orderItemService.saveOrderItem(Mockito.<OrderItem>any())).thenReturn(new BundleOrderItemImpl());

    // Act
    cartMessageOrderItemServiceExtensionHandler.updateOrderItemCartMessages(new BundleOrderItemImpl());

    // Assert
    verify(list).iterator();
    verify(orderItemService).saveOrderItem(isA(OrderItem.class));
    verify(promotionMessageGenerator).generatePromotionMessages(isA(OrderItem.class));
  }

  /**
   * Test {@link CartMessageOrderItemServiceExtensionHandler#updateOrderItemCartMessages(OrderItem)}.
   * <ul>
   *   <li>Then calls {@link PromotionMessageGenerator#generatePromotionMessages(OrderItem)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CartMessageOrderItemServiceExtensionHandler#updateOrderItemCartMessages(OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CartMessageOrderItemServiceExtensionHandler.updateOrderItemCartMessages(OrderItem)"})
  public void testUpdateOrderItemCartMessages_thenCallsGeneratePromotionMessages() {
    // Arrange
    PromotionMessageGenerator promotionMessageGenerator = mock(PromotionMessageGenerator.class);
    when(promotionMessageGenerator.generatePromotionMessages(Mockito.<OrderItem>any())).thenReturn(new ArrayList<>());

    ArrayList<PromotionMessageGenerator> promotionMessageGeneratorList = new ArrayList<>();
    promotionMessageGeneratorList.add(promotionMessageGenerator);
    when(list.iterator()).thenReturn(promotionMessageGeneratorList.iterator());
    when(orderItemService.saveOrderItem(Mockito.<OrderItem>any())).thenReturn(new BundleOrderItemImpl());

    // Act
    cartMessageOrderItemServiceExtensionHandler.updateOrderItemCartMessages(new BundleOrderItemImpl());

    // Assert
    verify(list).iterator();
    verify(orderItemService).saveOrderItem(isA(OrderItem.class));
    verify(promotionMessageGenerator).generatePromotionMessages(isA(OrderItem.class));
  }

  /**
   * Test {@link CartMessageOrderItemServiceExtensionHandler#updateOrderItemCartMessages(OrderItem)}.
   * <ul>
   *   <li>Then {@link DiscreteOrderItemImpl} (default constructor) CartMessages Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CartMessageOrderItemServiceExtensionHandler#updateOrderItemCartMessages(OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CartMessageOrderItemServiceExtensionHandler.updateOrderItemCartMessages(OrderItem)"})
  public void testUpdateOrderItemCartMessages_thenDiscreteOrderItemImplCartMessagesEmpty() {
    // Arrange
    PromotionMessageGenerator promotionMessageGenerator = mock(PromotionMessageGenerator.class);
    when(promotionMessageGenerator.generatePromotionMessages(Mockito.<OrderItem>any())).thenReturn(new ArrayList<>());

    ArrayList<PromotionMessageGenerator> promotionMessageGeneratorList = new ArrayList<>();
    promotionMessageGeneratorList.add(promotionMessageGenerator);
    when(list.iterator()).thenReturn(promotionMessageGeneratorList.iterator());
    when(orderItemService.saveOrderItem(Mockito.<OrderItem>any())).thenReturn(new BundleOrderItemImpl());
    DiscreteOrderItemImpl orderItem = new DiscreteOrderItemImpl();

    // Act
    cartMessageOrderItemServiceExtensionHandler.updateOrderItemCartMessages(orderItem);

    // Assert
    verify(list, atLeast(1)).iterator();
    verify(orderItemService).saveOrderItem(isA(OrderItem.class));
    verify(promotionMessageGenerator).generatePromotionMessages(isA(OrderItem.class));
    assertTrue(orderItem.getCartMessages().isEmpty());
  }

  /**
   * Test {@link CartMessageOrderItemServiceExtensionHandler#updateOrderItemCartMessages(OrderItem)}.
   * <ul>
   *   <li>When {@link BundleOrderItemImpl} (default constructor).</li>
   *   <li>Then calls {@link List#iterator()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CartMessageOrderItemServiceExtensionHandler#updateOrderItemCartMessages(OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CartMessageOrderItemServiceExtensionHandler.updateOrderItemCartMessages(OrderItem)"})
  public void testUpdateOrderItemCartMessages_whenBundleOrderItemImpl_thenCallsIterator() {
    // Arrange
    ArrayList<PromotionMessageGenerator> promotionMessageGeneratorList = new ArrayList<>();
    when(list.iterator()).thenReturn(promotionMessageGeneratorList.iterator());
    when(orderItemService.saveOrderItem(Mockito.<OrderItem>any())).thenReturn(new BundleOrderItemImpl());

    // Act
    cartMessageOrderItemServiceExtensionHandler.updateOrderItemCartMessages(new BundleOrderItemImpl());

    // Assert
    verify(list).iterator();
    verify(orderItemService).saveOrderItem(isA(OrderItem.class));
  }

  /**
   * Test {@link CartMessageOrderItemServiceExtensionHandler#gatherOrderItemCartMessages(OrderItem)}.
   * <p>
   * Method under test: {@link CartMessageOrderItemServiceExtensionHandler#gatherOrderItemCartMessages(OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CartMessageOrderItemServiceExtensionHandler.gatherOrderItemCartMessages(OrderItem)"})
  public void testGatherOrderItemCartMessages() {
    // Arrange
    ArrayList<PromotionMessageGenerator> promotionMessageGeneratorList = new ArrayList<>();
    when(list.iterator()).thenReturn(promotionMessageGeneratorList.iterator());

    // Act
    List<String> actualGatherOrderItemCartMessagesResult = cartMessageOrderItemServiceExtensionHandler
        .gatherOrderItemCartMessages(new BundleOrderItemImpl());

    // Assert
    verify(list).iterator();
    assertTrue(actualGatherOrderItemCartMessagesResult.isEmpty());
  }

  /**
   * Test {@link CartMessageOrderItemServiceExtensionHandler#gatherOrderItemCartMessages(OrderItem)}.
   * <ul>
   *   <li>Then calls {@link PromotionMessageGenerator#generatePromotionMessages(OrderItem)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CartMessageOrderItemServiceExtensionHandler#gatherOrderItemCartMessages(OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CartMessageOrderItemServiceExtensionHandler.gatherOrderItemCartMessages(OrderItem)"})
  public void testGatherOrderItemCartMessages_thenCallsGeneratePromotionMessages() {
    // Arrange
    PromotionMessageGenerator promotionMessageGenerator = mock(PromotionMessageGenerator.class);
    when(promotionMessageGenerator.generatePromotionMessages(Mockito.<OrderItem>any())).thenReturn(new ArrayList<>());

    ArrayList<PromotionMessageGenerator> promotionMessageGeneratorList = new ArrayList<>();
    promotionMessageGeneratorList.add(promotionMessageGenerator);
    when(list.iterator()).thenReturn(promotionMessageGeneratorList.iterator());

    // Act
    List<String> actualGatherOrderItemCartMessagesResult = cartMessageOrderItemServiceExtensionHandler
        .gatherOrderItemCartMessages(new BundleOrderItemImpl());

    // Assert
    verify(list).iterator();
    verify(promotionMessageGenerator).generatePromotionMessages(isA(OrderItem.class));
    assertTrue(actualGatherOrderItemCartMessagesResult.isEmpty());
  }

  /**
   * Test {@link CartMessageOrderItemServiceExtensionHandler#gatherProductCartMessages(OrderItem)}.
   * <ul>
   *   <li>Then calls {@link PromotionMessageGenerator#generatePromotionMessages(Product)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CartMessageOrderItemServiceExtensionHandler#gatherProductCartMessages(OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CartMessageOrderItemServiceExtensionHandler.gatherProductCartMessages(OrderItem)"})
  public void testGatherProductCartMessages_thenCallsGeneratePromotionMessages() {
    // Arrange
    PromotionMessageGenerator promotionMessageGenerator = mock(PromotionMessageGenerator.class);
    when(promotionMessageGenerator.generatePromotionMessages(Mockito.<Product>any())).thenReturn(new HashMap<>());

    ArrayList<PromotionMessageGenerator> promotionMessageGeneratorList = new ArrayList<>();
    promotionMessageGeneratorList.add(promotionMessageGenerator);
    when(list.iterator()).thenReturn(promotionMessageGeneratorList.iterator());
    DiscreteOrderItemImpl orderItem = mock(DiscreteOrderItemImpl.class);
    when(orderItem.getProduct()).thenReturn(new ProductBundleImpl());

    // Act
    List<String> actualGatherProductCartMessagesResult = cartMessageOrderItemServiceExtensionHandler
        .gatherProductCartMessages(orderItem);

    // Assert
    verify(list).iterator();
    verify(orderItem).getProduct();
    verify(promotionMessageGenerator).generatePromotionMessages(isA(Product.class));
    assertTrue(actualGatherProductCartMessagesResult.isEmpty());
  }

  /**
   * Test {@link CartMessageOrderItemServiceExtensionHandler#gatherProductCartMessages(OrderItem)}.
   * <ul>
   *   <li>Then calls {@link List#iterator()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CartMessageOrderItemServiceExtensionHandler#gatherProductCartMessages(OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CartMessageOrderItemServiceExtensionHandler.gatherProductCartMessages(OrderItem)"})
  public void testGatherProductCartMessages_thenCallsIterator() {
    // Arrange
    ArrayList<PromotionMessageGenerator> promotionMessageGeneratorList = new ArrayList<>();
    when(list.iterator()).thenReturn(promotionMessageGeneratorList.iterator());
    DiscreteOrderItemImpl orderItem = mock(DiscreteOrderItemImpl.class);
    when(orderItem.getProduct()).thenReturn(new ProductBundleImpl());

    // Act
    List<String> actualGatherProductCartMessagesResult = cartMessageOrderItemServiceExtensionHandler
        .gatherProductCartMessages(orderItem);

    // Assert
    verify(list).iterator();
    verify(orderItem).getProduct();
    assertTrue(actualGatherProductCartMessagesResult.isEmpty());
  }

  /**
   * Test {@link CartMessageOrderItemServiceExtensionHandler#gatherProductCartMessages(OrderItem)}.
   * <ul>
   *   <li>When {@link BundleOrderItemImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CartMessageOrderItemServiceExtensionHandler#gatherProductCartMessages(OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CartMessageOrderItemServiceExtensionHandler.gatherProductCartMessages(OrderItem)"})
  public void testGatherProductCartMessages_whenBundleOrderItemImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        cartMessageOrderItemServiceExtensionHandler.gatherProductCartMessages(new BundleOrderItemImpl()).isEmpty());
  }

  /**
   * Test {@link CartMessageOrderItemServiceExtensionHandler#addPromotionMessagesForType(List, List)}.
   * <p>
   * Method under test: {@link CartMessageOrderItemServiceExtensionHandler#addPromotionMessagesForType(List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CartMessageOrderItemServiceExtensionHandler.addPromotionMessagesForType(List, List)"})
  public void testAddPromotionMessagesForType() {
    // Arrange
    ArrayList<PromotionMessageDTO> messageDTOs = new ArrayList<>();

    ArrayList<PromotionMessageDTO> messages = new ArrayList<>();
    messages.add(new PromotionMessageDTO(new PromotionMessageImpl()));
    PromotionMessageDTO promotionMessageDTO = new PromotionMessageDTO(new PromotionMessageImpl());
    messages.add(promotionMessageDTO);

    // Act
    cartMessageOrderItemServiceExtensionHandler.addPromotionMessagesForType(messageDTOs, messages);

    // Assert
    assertEquals(2, messageDTOs.size());
    assertSame(promotionMessageDTO, messageDTOs.get(1));
  }

  /**
   * Test {@link CartMessageOrderItemServiceExtensionHandler#addPromotionMessagesForType(List, List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CartMessageOrderItemServiceExtensionHandler#addPromotionMessagesForType(List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CartMessageOrderItemServiceExtensionHandler.addPromotionMessagesForType(List, List)"})
  public void testAddPromotionMessagesForType_thenArrayListSizeIsOne() {
    // Arrange
    ArrayList<PromotionMessageDTO> messageDTOs = new ArrayList<>();
    PromotionMessageDTO promotionMessageDTO = new PromotionMessageDTO(new PromotionMessageImpl());
    messageDTOs.add(promotionMessageDTO);

    // Act
    cartMessageOrderItemServiceExtensionHandler.addPromotionMessagesForType(messageDTOs, new ArrayList<>());

    // Assert that nothing has changed
    assertEquals(1, messageDTOs.size());
    assertSame(promotionMessageDTO, messageDTOs.get(0));
  }

  /**
   * Test {@link CartMessageOrderItemServiceExtensionHandler#addPromotionMessagesForType(List, List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CartMessageOrderItemServiceExtensionHandler#addPromotionMessagesForType(List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CartMessageOrderItemServiceExtensionHandler.addPromotionMessagesForType(List, List)"})
  public void testAddPromotionMessagesForType_thenArrayListSizeIsOne2() {
    // Arrange
    ArrayList<PromotionMessageDTO> messageDTOs = new ArrayList<>();

    ArrayList<PromotionMessageDTO> messages = new ArrayList<>();
    PromotionMessageDTO promotionMessageDTO = new PromotionMessageDTO(new PromotionMessageImpl());
    messages.add(promotionMessageDTO);

    // Act
    cartMessageOrderItemServiceExtensionHandler.addPromotionMessagesForType(messageDTOs, messages);

    // Assert
    assertEquals(1, messageDTOs.size());
    assertSame(promotionMessageDTO, messageDTOs.get(0));
  }

  /**
   * Test {@link CartMessageOrderItemServiceExtensionHandler#addPromotionMessagesForType(List, List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link CartMessageOrderItemServiceExtensionHandler#addPromotionMessagesForType(List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CartMessageOrderItemServiceExtensionHandler.addPromotionMessagesForType(List, List)"})
  public void testAddPromotionMessagesForType_thenArrayListSizeIsTwo() {
    // Arrange
    ArrayList<PromotionMessageDTO> messageDTOs = new ArrayList<>();
    PromotionMessageDTO promotionMessageDTO = new PromotionMessageDTO(new PromotionMessageImpl());
    messageDTOs.add(promotionMessageDTO);
    messageDTOs.add(new PromotionMessageDTO(new PromotionMessageImpl()));

    // Act
    cartMessageOrderItemServiceExtensionHandler.addPromotionMessagesForType(messageDTOs, new ArrayList<>());

    // Assert that nothing has changed
    assertEquals(2, messageDTOs.size());
    assertSame(promotionMessageDTO, messageDTOs.get(0));
  }

  /**
   * Test {@link CartMessageOrderItemServiceExtensionHandler#addPromotionMessagesForType(List, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CartMessageOrderItemServiceExtensionHandler#addPromotionMessagesForType(List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CartMessageOrderItemServiceExtensionHandler.addPromotionMessagesForType(List, List)"})
  public void testAddPromotionMessagesForType_whenArrayList_thenArrayListEmpty() {
    // Arrange
    ArrayList<PromotionMessageDTO> messageDTOs = new ArrayList<>();

    // Act
    cartMessageOrderItemServiceExtensionHandler.addPromotionMessagesForType(messageDTOs, new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(messageDTOs.isEmpty());
  }

  /**
   * Test {@link CartMessageOrderItemServiceExtensionHandler#addPromotionMessagesForType(List, List)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CartMessageOrderItemServiceExtensionHandler#addPromotionMessagesForType(List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CartMessageOrderItemServiceExtensionHandler.addPromotionMessagesForType(List, List)"})
  public void testAddPromotionMessagesForType_whenNull_thenArrayListEmpty() {
    // Arrange
    ArrayList<PromotionMessageDTO> messageDTOs = new ArrayList<>();

    // Act
    cartMessageOrderItemServiceExtensionHandler.addPromotionMessagesForType(messageDTOs, null);

    // Assert that nothing has changed
    assertTrue(messageDTOs.isEmpty());
  }

  /**
   * Test {@link CartMessageOrderItemServiceExtensionHandler#getPriority()}.
   * <p>
   * Method under test: {@link CartMessageOrderItemServiceExtensionHandler#getPriority()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int CartMessageOrderItemServiceExtensionHandler.getPriority()"})
  public void testGetPriority() {
    // Arrange, Act and Assert
    assertEquals(Integer.MAX_VALUE, (new CartMessageOrderItemServiceExtensionHandler()).getPriority());
  }
}

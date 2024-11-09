/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
package org.broadleafcommerce.core.checkout.service.workflow;

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
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.service.type.ProductOptionValidationStrategyType;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItem;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.core.workflow.state.RollbackHandler;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;

public class ValidateProductOptionsActivityDiffblueTest {
  /**
   * Test {@link ValidateProductOptionsActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then return SeedData Order DiscreteOrderItems Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateProductOptionsActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_thenReturnSeedDataOrderDiscreteOrderItemsEmpty() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateProductOptionsActivity validateProductOptionsActivity = new ValidateProductOptionsActivity();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
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
    order.setOrderItems(orderItems);
    NullOrderImpl order2 = new NullOrderImpl();

    CheckoutSeed checkoutSeed = new CheckoutSeed(order2, new HashMap<>());
    checkoutSeed.setOrder(order);

    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();
    context.setSeedData(checkoutSeed);

    // Act
    ProcessContext<CheckoutSeed> actualExecuteResult = validateProductOptionsActivity
        .execute((ProcessContext<CheckoutSeed>) context);

    // Assert
    Order order3 = actualExecuteResult.getSeedData().getOrder();
    assertTrue(order3 instanceof OrderImpl);
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    List<OrderItem> orderItems2 = order3.getOrderItems();
    assertEquals(1, orderItems2.size());
    assertTrue(order3.getDiscreteOrderItems().isEmpty());
    assertSame(bundleOrderItemImpl, orderItems2.get(0));
  }

  /**
   * Test {@link ValidateProductOptionsActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then return SeedData Order DiscreteOrderItems is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateProductOptionsActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_thenReturnSeedDataOrderDiscreteOrderItemsIsArrayList() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateProductOptionsActivity validateProductOptionsActivity = new ValidateProductOptionsActivity();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    orderItems.add(discreteOrderItemImpl);

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
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);
    NullOrderImpl order2 = new NullOrderImpl();

    CheckoutSeed checkoutSeed = new CheckoutSeed(order2, new HashMap<>());
    checkoutSeed.setOrder(order);

    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();
    context.setSeedData(checkoutSeed);

    // Act
    ProcessContext<CheckoutSeed> actualExecuteResult = validateProductOptionsActivity
        .execute((ProcessContext<CheckoutSeed>) context);

    // Assert
    Order order3 = actualExecuteResult.getSeedData().getOrder();
    assertTrue(order3 instanceof OrderImpl);
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    List<OrderItem> orderItems2 = order3.getOrderItems();
    assertEquals(1, orderItems2.size());
    assertEquals(orderItems, order3.getDiscreteOrderItems());
    assertSame(discreteOrderItemImpl, orderItems2.get(0));
  }

  /**
   * Test {@link ValidateProductOptionsActivity#getOrderItems(Order)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BundleOrderItemImpl}
   * (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateProductOptionsActivity#getOrderItems(Order)}
   */
  @Test
  public void testGetOrderItems_givenArrayListAddBundleOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateProductOptionsActivity validateProductOptionsActivity = new ValidateProductOptionsActivity();

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
    order.setOrderItems(orderItems);

    // Act and Assert
    assertTrue(validateProductOptionsActivity.getOrderItems(order).isEmpty());
  }

  /**
   * Test {@link ValidateProductOptionsActivity#getOrderItems(Order)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link DiscreteOrderItemImpl}
   * (default constructor).</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateProductOptionsActivity#getOrderItems(Order)}
   */
  @Test
  public void testGetOrderItems_givenArrayListAddDiscreteOrderItemImpl_thenReturnArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateProductOptionsActivity validateProductOptionsActivity = new ValidateProductOptionsActivity();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new DiscreteOrderItemImpl());

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
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    // Act and Assert
    assertEquals(orderItems, validateProductOptionsActivity.getOrderItems(order));
  }

  /**
   * Test {@link ValidateProductOptionsActivity#getOrderItems(Order)}.
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Auditable is
   * {@link Auditable} (default constructor).</li>
   *   <li>Then calls {@link NullOrderImpl#getOrderItems()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateProductOptionsActivity#getOrderItems(Order)}
   */
  @Test
  public void testGetOrderItems_givenOrderItemImplAuditableIsAuditable_thenCallsGetOrderItems() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateProductOptionsActivity validateProductOptionsActivity = new ValidateProductOptionsActivity();

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

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(orderItemImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(orderItemList);

    // Act
    List<DiscreteOrderItem> actualOrderItems = validateProductOptionsActivity.getOrderItems(order);

    // Assert
    verify(order).getOrderItems();
    assertTrue(actualOrderItems.isEmpty());
  }

  /**
   * Test {@link ValidateProductOptionsActivity#getOrderItems(Order)}.
   * <ul>
   *   <li>Then calls {@link NullOrderImpl#getOrderItems()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateProductOptionsActivity#getOrderItems(Order)}
   */
  @Test
  public void testGetOrderItems_thenCallsGetOrderItems() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateProductOptionsActivity validateProductOptionsActivity = new ValidateProductOptionsActivity();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());

    // Act
    List<DiscreteOrderItem> actualOrderItems = validateProductOptionsActivity.getOrderItems(order);

    // Assert
    verify(order).getOrderItems();
    assertTrue(actualOrderItems.isEmpty());
  }

  /**
   * Test
   * {@link ValidateProductOptionsActivity#shouldValidateWithException(boolean, boolean, boolean, boolean)}.
   * <p>
   * Method under test:
   * {@link ValidateProductOptionsActivity#shouldValidateWithException(boolean, boolean, boolean, boolean)}
   */
  @Test
  public void testShouldValidateWithException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateProductOptionsActivity validateProductOptionsActivity = new ValidateProductOptionsActivity();
    validateProductOptionsActivity.setRollbackHandler(mock(RollbackHandler.class));

    // Act and Assert
    assertTrue(validateProductOptionsActivity.shouldValidateWithException(true, true, true, true));
  }

  /**
   * Test
   * {@link ValidateProductOptionsActivity#shouldValidateWithException(boolean, boolean, boolean, boolean)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateProductOptionsActivity#shouldValidateWithException(boolean, boolean, boolean, boolean)}
   */
  @Test
  public void testShouldValidateWithException_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ValidateProductOptionsActivity()).shouldValidateWithException(true, true, true, true));
  }

  /**
   * Test
   * {@link ValidateProductOptionsActivity#shouldValidateWithException(boolean, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateProductOptionsActivity#shouldValidateWithException(boolean, boolean, boolean, boolean)}
   */
  @Test
  public void testShouldValidateWithException_whenFalse_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ValidateProductOptionsActivity()).shouldValidateWithException(false, false, false, false));
    assertFalse((new ValidateProductOptionsActivity()).shouldValidateWithException(true, true, false, false));
  }

  /**
   * Test
   * {@link ValidateProductOptionsActivity#shouldValidateWithException(boolean, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateProductOptionsActivity#shouldValidateWithException(boolean, boolean, boolean, boolean)}
   */
  @Test
  public void testShouldValidateWithException_whenFalse_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ValidateProductOptionsActivity()).shouldValidateWithException(true, true, false, true));
  }

  /**
   * Test
   * {@link ValidateProductOptionsActivity#isMissingRequiredAttribute(boolean, boolean, boolean, boolean, String)}.
   * <p>
   * Method under test:
   * {@link ValidateProductOptionsActivity#isMissingRequiredAttribute(boolean, boolean, boolean, boolean, String)}
   */
  @Test
  public void testIsMissingRequiredAttribute() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateProductOptionsActivity validateProductOptionsActivity = new ValidateProductOptionsActivity();
    validateProductOptionsActivity.setRollbackHandler(mock(RollbackHandler.class));

    // Act and Assert
    assertFalse(validateProductOptionsActivity.isMissingRequiredAttribute(true, true, true, true, "42"));
  }

  /**
   * Test
   * {@link ValidateProductOptionsActivity#isMissingRequiredAttribute(boolean, boolean, boolean, boolean, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateProductOptionsActivity#isMissingRequiredAttribute(boolean, boolean, boolean, boolean, String)}
   */
  @Test
  public void testIsMissingRequiredAttribute_when42_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ValidateProductOptionsActivity()).isMissingRequiredAttribute(true, true, true, true, "42"));
  }

  /**
   * Test
   * {@link ValidateProductOptionsActivity#isMissingRequiredAttribute(boolean, boolean, boolean, boolean, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateProductOptionsActivity#isMissingRequiredAttribute(boolean, boolean, boolean, boolean, String)}
   */
  @Test
  public void testIsMissingRequiredAttribute_whenEmptyString_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ValidateProductOptionsActivity()).isMissingRequiredAttribute(true, true, true, true, ""));
  }

  /**
   * Test
   * {@link ValidateProductOptionsActivity#isMissingRequiredAttribute(boolean, boolean, boolean, boolean, String)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateProductOptionsActivity#isMissingRequiredAttribute(boolean, boolean, boolean, boolean, String)}
   */
  @Test
  public void testIsMissingRequiredAttribute_whenFalse_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ValidateProductOptionsActivity()).isMissingRequiredAttribute(true, true, false, true, "42"));
    assertFalse((new ValidateProductOptionsActivity()).isMissingRequiredAttribute(true, true, false, false, "42"));
  }

  /**
   * Test
   * {@link ValidateProductOptionsActivity#isMissingRequiredAttribute(boolean, boolean, boolean, boolean, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateProductOptionsActivity#isMissingRequiredAttribute(boolean, boolean, boolean, boolean, String)}
   */
  @Test
  public void testIsMissingRequiredAttribute_whenNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ValidateProductOptionsActivity()).isMissingRequiredAttribute(false, false, false, false, null));
  }

  /**
   * Test
   * {@link ValidateProductOptionsActivity#isMissingRequiredAttribute(boolean, boolean, boolean, boolean, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateProductOptionsActivity#isMissingRequiredAttribute(boolean, boolean, boolean, boolean, String)}
   */
  @Test
  public void testIsMissingRequiredAttribute_whenNull_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ValidateProductOptionsActivity()).isMissingRequiredAttribute(true, false, false, false, null));
  }

  /**
   * Test
   * {@link ValidateProductOptionsActivity#getProductOptionValidationStrategyType()}.
   * <p>
   * Method under test:
   * {@link ValidateProductOptionsActivity#getProductOptionValidationStrategyType()}
   */
  @Test
  public void testGetProductOptionValidationStrategyType() {
    // Arrange and Act
    ProductOptionValidationStrategyType actualProductOptionValidationStrategyType = (new ValidateProductOptionsActivity())
        .getProductOptionValidationStrategyType();

    // Assert
    assertSame(actualProductOptionValidationStrategyType.SUBMIT_ORDER, actualProductOptionValidationStrategyType);
  }
}

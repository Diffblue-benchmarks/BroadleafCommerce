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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
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
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.dao.FulfillmentGroupDao;
import org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupFee;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupFeeImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItem;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentOption;
import org.broadleafcommerce.core.order.domain.FulfillmentOptionImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.service.call.FulfillmentGroupItemRequest;
import org.broadleafcommerce.core.order.service.call.FulfillmentGroupRequest;
import org.broadleafcommerce.core.order.service.type.FulfillmentGroupStatusType;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FulfillmentGroupServiceImplDiffblueTest {
  @Mock
  private FulfillmentGroupDao fulfillmentGroupDao;

  @Mock
  private FulfillmentGroupItemDao fulfillmentGroupItemDao;

  @InjectMocks
  private FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl;

  @Mock
  private OrderMultishipOptionService orderMultishipOptionService;

  @Mock
  private OrderService orderService;

  /**
   * Test {@link FulfillmentGroupServiceImpl#save(FulfillmentGroup)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link FulfillmentGroupImpl} {@link FulfillmentGroupImpl#getSequence()} return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#save(FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentGroup FulfillmentGroupServiceImpl.save(FulfillmentGroup)"})
  public void testSave_givenOne_whenFulfillmentGroupImplGetSequenceReturnOne() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    when(fulfillmentGroupDao.save(Mockito.<FulfillmentGroup>any())).thenReturn(fulfillmentGroupImpl);
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getSequence()).thenReturn(1);

    // Act
    FulfillmentGroup actualSaveResult = fulfillmentGroupServiceImpl.save(fulfillmentGroup);

    // Assert
    verify(fulfillmentGroupDao).save(isA(FulfillmentGroup.class));
    verify(fulfillmentGroup).getSequence();
    assertSame(fulfillmentGroupImpl, actualSaveResult);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#save(FulfillmentGroup)}.
   * <ul>
   *   <li>Then calls {@link FulfillmentGroupDao#readNextFulfillmentGroupSequnceForOrder(Order)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#save(FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentGroup FulfillmentGroupServiceImpl.save(FulfillmentGroup)"})
  public void testSave_thenCallsReadNextFulfillmentGroupSequnceForOrder() {
    // Arrange
    when(fulfillmentGroupDao.readNextFulfillmentGroupSequnceForOrder(Mockito.<Order>any())).thenReturn(1);
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    when(fulfillmentGroupDao.save(Mockito.<FulfillmentGroup>any())).thenReturn(fulfillmentGroupImpl);

    // Act
    FulfillmentGroup actualSaveResult = fulfillmentGroupServiceImpl.save(new FulfillmentGroupImpl());

    // Assert
    verify(fulfillmentGroupDao).readNextFulfillmentGroupSequnceForOrder(isNull());
    verify(fulfillmentGroupDao).save(isA(FulfillmentGroup.class));
    assertSame(fulfillmentGroupImpl, actualSaveResult);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#createEmptyFulfillmentGroup()}.
   * <ul>
   *   <li>Then return {@link FulfillmentGroupImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#createEmptyFulfillmentGroup()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentGroup FulfillmentGroupServiceImpl.createEmptyFulfillmentGroup()"})
  public void testCreateEmptyFulfillmentGroup_thenReturnFulfillmentGroupImpl() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    when(fulfillmentGroupDao.create()).thenReturn(fulfillmentGroupImpl);

    // Act
    FulfillmentGroup actualCreateEmptyFulfillmentGroupResult = fulfillmentGroupServiceImpl
        .createEmptyFulfillmentGroup();

    // Assert
    verify(fulfillmentGroupDao).create();
    assertSame(fulfillmentGroupImpl, actualCreateEmptyFulfillmentGroupResult);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#createEmptyFulfillmentGroup()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#createEmptyFulfillmentGroup()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentGroup FulfillmentGroupServiceImpl.createEmptyFulfillmentGroup()"})
  public void testCreateEmptyFulfillmentGroup_thenThrowIllegalArgumentException() {
    // Arrange
    when(fulfillmentGroupDao.create()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> fulfillmentGroupServiceImpl.createEmptyFulfillmentGroup());
    verify(fulfillmentGroupDao).create();
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#findFulfillmentGroupById(Long)}.
   * <ul>
   *   <li>Then return {@link FulfillmentGroupImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#findFulfillmentGroupById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentGroup FulfillmentGroupServiceImpl.findFulfillmentGroupById(Long)"})
  public void testFindFulfillmentGroupById_thenReturnFulfillmentGroupImpl() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    when(fulfillmentGroupDao.readFulfillmentGroupById(Mockito.<Long>any())).thenReturn(fulfillmentGroupImpl);

    // Act
    FulfillmentGroup actualFindFulfillmentGroupByIdResult = fulfillmentGroupServiceImpl.findFulfillmentGroupById(1L);

    // Assert
    verify(fulfillmentGroupDao).readFulfillmentGroupById(eq(1L));
    assertSame(fulfillmentGroupImpl, actualFindFulfillmentGroupByIdResult);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#findFulfillmentGroupById(Long)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#findFulfillmentGroupById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentGroup FulfillmentGroupServiceImpl.findFulfillmentGroupById(Long)"})
  public void testFindFulfillmentGroupById_thenThrowIllegalArgumentException() {
    // Arrange
    when(fulfillmentGroupDao.readFulfillmentGroupById(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> fulfillmentGroupServiceImpl.findFulfillmentGroupById(1L));
    verify(fulfillmentGroupDao).readFulfillmentGroupById(eq(1L));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#delete(FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupDao} {@link FulfillmentGroupDao#delete(FulfillmentGroup)} does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#delete(FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupServiceImpl.delete(FulfillmentGroup)"})
  public void testDelete_givenFulfillmentGroupDaoDeleteDoesNothing() {
    // Arrange
    doNothing().when(fulfillmentGroupDao).delete(Mockito.<FulfillmentGroup>any());

    // Act
    fulfillmentGroupServiceImpl.delete(new FulfillmentGroupImpl());

    // Assert
    verify(fulfillmentGroupDao).delete(isA(FulfillmentGroup.class));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#delete(FulfillmentGroup)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#delete(FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupServiceImpl.delete(FulfillmentGroup)"})
  public void testDelete_thenThrowIllegalArgumentException() {
    // Arrange
    doThrow(new IllegalArgumentException("foo")).when(fulfillmentGroupDao).delete(Mockito.<FulfillmentGroup>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> fulfillmentGroupServiceImpl.delete(new FulfillmentGroupImpl()));
    verify(fulfillmentGroupDao).delete(isA(FulfillmentGroup.class));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)}.
   * <ul>
   *   <li>Then calls {@link FulfillmentGroupImpl#setAddress(Address)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup FulfillmentGroupServiceImpl.addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)"})
  public void testAddFulfillmentGroupToOrder_thenCallsSetAddress() throws PricingException {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    doNothing().when(fulfillmentGroupImpl).setAddress(Mockito.<Address>any());
    doNothing().when(fulfillmentGroupImpl).setFulfillmentOption(Mockito.<FulfillmentOption>any());
    doNothing().when(fulfillmentGroupImpl).setOrder(Mockito.<Order>any());
    doNothing().when(fulfillmentGroupImpl).setPhone(Mockito.<Phone>any());
    doNothing().when(fulfillmentGroupImpl).setType(Mockito.<FulfillmentType>any());
    when(fulfillmentGroupDao.create()).thenReturn(fulfillmentGroupImpl);

    FulfillmentGroupRequest fulfillmentGroupRequest = new FulfillmentGroupRequest();
    fulfillmentGroupRequest.setAddress(new AddressImpl());
    fulfillmentGroupRequest.setFulfillmentGroupItemRequests(new ArrayList<>());
    fulfillmentGroupRequest.setFulfillmentType(FulfillmentType.DIGITAL);
    fulfillmentGroupRequest.setMethod("Method");
    fulfillmentGroupRequest.setOption(new FulfillmentOptionImpl());
    fulfillmentGroupRequest.setOrder(new NullOrderImpl());
    fulfillmentGroupRequest.setPhone(new PhoneImpl());
    fulfillmentGroupRequest.setService("Service");

    // Act
    fulfillmentGroupServiceImpl.addFulfillmentGroupToOrder(fulfillmentGroupRequest, true);

    // Assert
    verify(fulfillmentGroupDao).create();
    verify(fulfillmentGroupImpl).setAddress(isA(Address.class));
    verify(fulfillmentGroupImpl).setFulfillmentOption(isA(FulfillmentOption.class));
    verify(fulfillmentGroupImpl).setOrder(isA(Order.class));
    verify(fulfillmentGroupImpl).setPhone(isA(Phone.class));
    verify(fulfillmentGroupImpl).setType(isA(FulfillmentType.class));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)}.
   * <ul>
   *   <li>Then return {@link FulfillmentGroupImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup FulfillmentGroupServiceImpl.addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)"})
  public void testAddFulfillmentGroupToOrder_thenReturnFulfillmentGroupImpl() throws PricingException {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    when(fulfillmentGroupDao.create()).thenReturn(fulfillmentGroupImpl);

    FulfillmentGroupRequest fulfillmentGroupRequest = new FulfillmentGroupRequest();
    fulfillmentGroupRequest.setAddress(new AddressImpl());
    fulfillmentGroupRequest.setFulfillmentGroupItemRequests(new ArrayList<>());
    fulfillmentGroupRequest.setFulfillmentType(FulfillmentType.DIGITAL);
    fulfillmentGroupRequest.setMethod("Method");
    fulfillmentGroupRequest.setOption(new FulfillmentOptionImpl());
    fulfillmentGroupRequest.setOrder(new NullOrderImpl());
    fulfillmentGroupRequest.setPhone(new PhoneImpl());
    fulfillmentGroupRequest.setService("Service");

    // Act
    FulfillmentGroup actualAddFulfillmentGroupToOrderResult = fulfillmentGroupServiceImpl
        .addFulfillmentGroupToOrder(fulfillmentGroupRequest, true);

    // Assert
    verify(fulfillmentGroupDao).create();
    assertSame(fulfillmentGroupImpl, actualAddFulfillmentGroupToOrderResult);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean)} with {@code fulfillmentGroupItemRequest}, {@code priceOrder}.
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup FulfillmentGroupServiceImpl.addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean)"})
  public void testAddItemToFulfillmentGroupWithFulfillmentGroupItemRequestPriceOrder() throws PricingException {
    // Arrange
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any())).thenReturn(new FulfillmentGroupItemImpl());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(new NullOrderImpl());

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
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = mock(FulfillmentGroupItemRequest.class);
    when(fulfillmentGroupItemRequest.getQuantity()).thenReturn(1);
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    when(fulfillmentGroupItemRequest.getFulfillmentGroup()).thenReturn(fulfillmentGroupImpl);
    when(fulfillmentGroupItemRequest.getOrder()).thenReturn(orderImpl);
    when(fulfillmentGroupItemRequest.getOrderItem()).thenReturn(new BundleOrderItemImpl());
    doNothing().when(fulfillmentGroupItemRequest).setFulfillmentGroup(Mockito.<FulfillmentGroup>any());
    doNothing().when(fulfillmentGroupItemRequest).setOrder(Mockito.<Order>any());
    doNothing().when(fulfillmentGroupItemRequest).setOrderItem(Mockito.<OrderItem>any());
    doNothing().when(fulfillmentGroupItemRequest).setQuantity(anyInt());
    fulfillmentGroupItemRequest.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest.setQuantity(1);

    // Act
    FulfillmentGroup actualAddItemToFulfillmentGroupResult = fulfillmentGroupServiceImpl
        .addItemToFulfillmentGroup(fulfillmentGroupItemRequest, true);

    // Assert
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupItemDao).save(isA(FulfillmentGroupItem.class));
    verify(orderService).save(isA(Order.class), eq(true));
    verify(fulfillmentGroupItemRequest).getFulfillmentGroup();
    verify(fulfillmentGroupItemRequest).getOrder();
    verify(fulfillmentGroupItemRequest).getOrderItem();
    verify(fulfillmentGroupItemRequest).getQuantity();
    verify(fulfillmentGroupItemRequest).setFulfillmentGroup(isA(FulfillmentGroup.class));
    verify(fulfillmentGroupItemRequest).setOrder(isA(Order.class));
    verify(fulfillmentGroupItemRequest).setOrderItem(isA(OrderItem.class));
    verify(fulfillmentGroupItemRequest).setQuantity(eq(1));
    assertSame(fulfillmentGroupImpl, actualAddItemToFulfillmentGroupResult);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean)} with {@code fulfillmentGroupItemRequest}, {@code priceOrder}.
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup FulfillmentGroupServiceImpl.addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean)"})
  public void testAddItemToFulfillmentGroupWithFulfillmentGroupItemRequestPriceOrder2() throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.readNextFulfillmentGroupSequnceForOrder(Mockito.<Order>any())).thenReturn(1);
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    when(fulfillmentGroupDao.save(Mockito.<FulfillmentGroup>any())).thenReturn(fulfillmentGroupImpl);
    when(fulfillmentGroupDao.create()).thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any())).thenReturn(new FulfillmentGroupItemImpl());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(new NullOrderImpl());

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
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = mock(FulfillmentGroupItemRequest.class);
    when(fulfillmentGroupItemRequest.getQuantity()).thenReturn(1);
    when(fulfillmentGroupItemRequest.getFulfillmentGroup()).thenReturn(null);
    when(fulfillmentGroupItemRequest.getOrder()).thenReturn(orderImpl);
    when(fulfillmentGroupItemRequest.getOrderItem()).thenReturn(new BundleOrderItemImpl());
    doNothing().when(fulfillmentGroupItemRequest).setFulfillmentGroup(Mockito.<FulfillmentGroup>any());
    doNothing().when(fulfillmentGroupItemRequest).setOrder(Mockito.<Order>any());
    doNothing().when(fulfillmentGroupItemRequest).setOrderItem(Mockito.<OrderItem>any());
    doNothing().when(fulfillmentGroupItemRequest).setQuantity(anyInt());
    fulfillmentGroupItemRequest.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest.setQuantity(1);

    // Act
    FulfillmentGroup actualAddItemToFulfillmentGroupResult = fulfillmentGroupServiceImpl
        .addItemToFulfillmentGroup(fulfillmentGroupItemRequest, true);

    // Assert
    verify(fulfillmentGroupDao, atLeast(1)).create();
    verify(fulfillmentGroupDao).readNextFulfillmentGroupSequnceForOrder(isA(Order.class));
    verify(fulfillmentGroupDao).save(isA(FulfillmentGroup.class));
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupItemDao).save(isA(FulfillmentGroupItem.class));
    verify(orderService).save(isA(Order.class), eq(true));
    verify(fulfillmentGroupItemRequest).getFulfillmentGroup();
    verify(fulfillmentGroupItemRequest).getOrder();
    verify(fulfillmentGroupItemRequest).getOrderItem();
    verify(fulfillmentGroupItemRequest).getQuantity();
    verify(fulfillmentGroupItemRequest).setFulfillmentGroup(isA(FulfillmentGroup.class));
    verify(fulfillmentGroupItemRequest).setOrder(isA(Order.class));
    verify(fulfillmentGroupItemRequest).setOrderItem(isA(OrderItem.class));
    verify(fulfillmentGroupItemRequest).setQuantity(eq(1));
    assertSame(fulfillmentGroupImpl, actualAddItemToFulfillmentGroupResult);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean)} with {@code fulfillmentGroupItemRequest}, {@code priceOrder}.
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup FulfillmentGroupServiceImpl.addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean)"})
  public void testAddItemToFulfillmentGroupWithFulfillmentGroupItemRequestPriceOrder3() throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.readNextFulfillmentGroupSequnceForOrder(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    when(fulfillmentGroupDao.create()).thenReturn(new FulfillmentGroupImpl());

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
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = mock(FulfillmentGroupItemRequest.class);
    when(fulfillmentGroupItemRequest.getFulfillmentGroup()).thenReturn(null);
    when(fulfillmentGroupItemRequest.getOrder()).thenReturn(orderImpl);
    when(fulfillmentGroupItemRequest.getOrderItem()).thenReturn(new BundleOrderItemImpl());
    doNothing().when(fulfillmentGroupItemRequest).setFulfillmentGroup(Mockito.<FulfillmentGroup>any());
    doNothing().when(fulfillmentGroupItemRequest).setOrder(Mockito.<Order>any());
    doNothing().when(fulfillmentGroupItemRequest).setOrderItem(Mockito.<OrderItem>any());
    doNothing().when(fulfillmentGroupItemRequest).setQuantity(anyInt());
    fulfillmentGroupItemRequest.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest.setQuantity(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> fulfillmentGroupServiceImpl.addItemToFulfillmentGroup(fulfillmentGroupItemRequest, true));
    verify(fulfillmentGroupDao, atLeast(1)).create();
    verify(fulfillmentGroupDao).readNextFulfillmentGroupSequnceForOrder(isA(Order.class));
    verify(fulfillmentGroupItemRequest).getFulfillmentGroup();
    verify(fulfillmentGroupItemRequest).getOrder();
    verify(fulfillmentGroupItemRequest).getOrderItem();
    verify(fulfillmentGroupItemRequest).setFulfillmentGroup(isA(FulfillmentGroup.class));
    verify(fulfillmentGroupItemRequest).setOrder(isA(Order.class));
    verify(fulfillmentGroupItemRequest).setOrderItem(isA(OrderItem.class));
    verify(fulfillmentGroupItemRequest).setQuantity(eq(1));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean)} with {@code fulfillmentGroupItemRequest}, {@code priceOrder}.
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup FulfillmentGroupServiceImpl.addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean)"})
  public void testAddItemToFulfillmentGroupWithFulfillmentGroupItemRequestPriceOrder4() throws PricingException {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getSequence()).thenReturn(1);
    doNothing().when(fulfillmentGroupImpl).setAddress(Mockito.<Address>any());
    doNothing().when(fulfillmentGroupImpl).setFulfillmentOption(Mockito.<FulfillmentOption>any());
    doNothing().when(fulfillmentGroupImpl).setOrder(Mockito.<Order>any());
    doNothing().when(fulfillmentGroupImpl).setPhone(Mockito.<Phone>any());
    doNothing().when(fulfillmentGroupImpl).setType(Mockito.<FulfillmentType>any());
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    when(fulfillmentGroupDao.save(Mockito.<FulfillmentGroup>any())).thenReturn(fulfillmentGroupImpl2);
    when(fulfillmentGroupDao.create()).thenReturn(fulfillmentGroupImpl);
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any())).thenReturn(new FulfillmentGroupItemImpl());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(new NullOrderImpl());

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
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = mock(FulfillmentGroupItemRequest.class);
    when(fulfillmentGroupItemRequest.getQuantity()).thenReturn(1);
    when(fulfillmentGroupItemRequest.getFulfillmentGroup()).thenReturn(null);
    when(fulfillmentGroupItemRequest.getOrder()).thenReturn(orderImpl);
    when(fulfillmentGroupItemRequest.getOrderItem()).thenReturn(new BundleOrderItemImpl());
    doNothing().when(fulfillmentGroupItemRequest).setFulfillmentGroup(Mockito.<FulfillmentGroup>any());
    doNothing().when(fulfillmentGroupItemRequest).setOrder(Mockito.<Order>any());
    doNothing().when(fulfillmentGroupItemRequest).setOrderItem(Mockito.<OrderItem>any());
    doNothing().when(fulfillmentGroupItemRequest).setQuantity(anyInt());
    fulfillmentGroupItemRequest.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest.setQuantity(1);

    // Act
    FulfillmentGroup actualAddItemToFulfillmentGroupResult = fulfillmentGroupServiceImpl
        .addItemToFulfillmentGroup(fulfillmentGroupItemRequest, true);

    // Assert
    verify(fulfillmentGroupDao, atLeast(1)).create();
    verify(fulfillmentGroupDao).save(isA(FulfillmentGroup.class));
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupItemDao).save(isA(FulfillmentGroupItem.class));
    verify(fulfillmentGroupImpl).getSequence();
    verify(fulfillmentGroupImpl).setAddress(isNull());
    verify(fulfillmentGroupImpl).setFulfillmentOption(isNull());
    verify(fulfillmentGroupImpl).setOrder(isA(Order.class));
    verify(fulfillmentGroupImpl).setPhone(isNull());
    verify(fulfillmentGroupImpl).setType(isNull());
    verify(orderService).save(isA(Order.class), eq(true));
    verify(fulfillmentGroupItemRequest).getFulfillmentGroup();
    verify(fulfillmentGroupItemRequest).getOrder();
    verify(fulfillmentGroupItemRequest).getOrderItem();
    verify(fulfillmentGroupItemRequest).getQuantity();
    verify(fulfillmentGroupItemRequest).setFulfillmentGroup(isA(FulfillmentGroup.class));
    verify(fulfillmentGroupItemRequest).setOrder(isA(Order.class));
    verify(fulfillmentGroupItemRequest).setOrderItem(isA(OrderItem.class));
    verify(fulfillmentGroupItemRequest).setQuantity(eq(1));
    assertSame(fulfillmentGroupImpl2, actualAddItemToFulfillmentGroupResult);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean)} with {@code fulfillmentGroupItemRequest}, {@code priceOrder}.
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup FulfillmentGroupServiceImpl.addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean)"})
  public void testAddItemToFulfillmentGroupWithFulfillmentGroupItemRequestPriceOrder5() throws PricingException {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getSequence()).thenReturn(1);
    doNothing().when(fulfillmentGroupImpl).setAddress(Mockito.<Address>any());
    doNothing().when(fulfillmentGroupImpl).setFulfillmentOption(Mockito.<FulfillmentOption>any());
    doNothing().when(fulfillmentGroupImpl).setOrder(Mockito.<Order>any());
    doNothing().when(fulfillmentGroupImpl).setPhone(Mockito.<Phone>any());
    doNothing().when(fulfillmentGroupImpl).setType(Mockito.<FulfillmentType>any());
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    when(fulfillmentGroupDao.save(Mockito.<FulfillmentGroup>any())).thenReturn(fulfillmentGroupImpl2);
    when(fulfillmentGroupDao.create()).thenReturn(fulfillmentGroupImpl);
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any())).thenReturn(new FulfillmentGroupItemImpl());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(new NullOrderImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(fulfillmentGroups);
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = mock(FulfillmentGroupItemRequest.class);
    when(fulfillmentGroupItemRequest.getQuantity()).thenReturn(1);
    when(fulfillmentGroupItemRequest.getFulfillmentGroup()).thenReturn(null);
    when(fulfillmentGroupItemRequest.getOrder()).thenReturn(orderImpl);
    when(fulfillmentGroupItemRequest.getOrderItem()).thenReturn(new BundleOrderItemImpl());
    doNothing().when(fulfillmentGroupItemRequest).setFulfillmentGroup(Mockito.<FulfillmentGroup>any());
    doNothing().when(fulfillmentGroupItemRequest).setOrder(Mockito.<Order>any());
    doNothing().when(fulfillmentGroupItemRequest).setOrderItem(Mockito.<OrderItem>any());
    doNothing().when(fulfillmentGroupItemRequest).setQuantity(anyInt());
    fulfillmentGroupItemRequest.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest.setQuantity(1);

    // Act
    FulfillmentGroup actualAddItemToFulfillmentGroupResult = fulfillmentGroupServiceImpl
        .addItemToFulfillmentGroup(fulfillmentGroupItemRequest, true);

    // Assert
    verify(fulfillmentGroupDao, atLeast(1)).create();
    verify(fulfillmentGroupDao).save(isA(FulfillmentGroup.class));
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupItemDao).save(isA(FulfillmentGroupItem.class));
    verify(fulfillmentGroupImpl).getSequence();
    verify(fulfillmentGroupImpl).setAddress(isNull());
    verify(fulfillmentGroupImpl).setFulfillmentOption(isNull());
    verify(fulfillmentGroupImpl).setOrder(isA(Order.class));
    verify(fulfillmentGroupImpl).setPhone(isNull());
    verify(fulfillmentGroupImpl).setType(isNull());
    verify(orderService).save(isA(Order.class), eq(true));
    verify(fulfillmentGroupItemRequest).getFulfillmentGroup();
    verify(fulfillmentGroupItemRequest).getOrder();
    verify(fulfillmentGroupItemRequest).getOrderItem();
    verify(fulfillmentGroupItemRequest).getQuantity();
    verify(fulfillmentGroupItemRequest).setFulfillmentGroup(isA(FulfillmentGroup.class));
    verify(fulfillmentGroupItemRequest).setOrder(isA(Order.class));
    verify(fulfillmentGroupItemRequest).setOrderItem(isA(OrderItem.class));
    verify(fulfillmentGroupItemRequest).setQuantity(eq(1));
    assertSame(fulfillmentGroupImpl2, actualAddItemToFulfillmentGroupResult);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean, boolean)} with {@code fulfillmentGroupItemRequest}, {@code priceOrder}, {@code save}.
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup FulfillmentGroupServiceImpl.addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean, boolean)"})
  public void testAddItemToFulfillmentGroupWithFulfillmentGroupItemRequestPriceOrderSave() throws PricingException {
    // Arrange
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any())).thenReturn(new FulfillmentGroupItemImpl());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(new NullOrderImpl());

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
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = mock(FulfillmentGroupItemRequest.class);
    when(fulfillmentGroupItemRequest.getQuantity()).thenReturn(1);
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    when(fulfillmentGroupItemRequest.getFulfillmentGroup()).thenReturn(fulfillmentGroupImpl);
    when(fulfillmentGroupItemRequest.getOrder()).thenReturn(orderImpl);
    when(fulfillmentGroupItemRequest.getOrderItem()).thenReturn(new BundleOrderItemImpl());
    doNothing().when(fulfillmentGroupItemRequest).setFulfillmentGroup(Mockito.<FulfillmentGroup>any());
    doNothing().when(fulfillmentGroupItemRequest).setOrder(Mockito.<Order>any());
    doNothing().when(fulfillmentGroupItemRequest).setOrderItem(Mockito.<OrderItem>any());
    doNothing().when(fulfillmentGroupItemRequest).setQuantity(anyInt());
    fulfillmentGroupItemRequest.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest.setQuantity(1);

    // Act
    FulfillmentGroup actualAddItemToFulfillmentGroupResult = fulfillmentGroupServiceImpl
        .addItemToFulfillmentGroup(fulfillmentGroupItemRequest, true, true);

    // Assert
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupItemDao).save(isA(FulfillmentGroupItem.class));
    verify(orderService).save(isA(Order.class), eq(true));
    verify(fulfillmentGroupItemRequest).getFulfillmentGroup();
    verify(fulfillmentGroupItemRequest).getOrder();
    verify(fulfillmentGroupItemRequest).getOrderItem();
    verify(fulfillmentGroupItemRequest).getQuantity();
    verify(fulfillmentGroupItemRequest).setFulfillmentGroup(isA(FulfillmentGroup.class));
    verify(fulfillmentGroupItemRequest).setOrder(isA(Order.class));
    verify(fulfillmentGroupItemRequest).setOrderItem(isA(OrderItem.class));
    verify(fulfillmentGroupItemRequest).setQuantity(eq(1));
    assertSame(fulfillmentGroupImpl, actualAddItemToFulfillmentGroupResult);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean, boolean)} with {@code fulfillmentGroupItemRequest}, {@code priceOrder}, {@code save}.
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup FulfillmentGroupServiceImpl.addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean, boolean)"})
  public void testAddItemToFulfillmentGroupWithFulfillmentGroupItemRequestPriceOrderSave2() throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.readNextFulfillmentGroupSequnceForOrder(Mockito.<Order>any())).thenReturn(1);
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    when(fulfillmentGroupDao.save(Mockito.<FulfillmentGroup>any())).thenReturn(fulfillmentGroupImpl);
    when(fulfillmentGroupDao.create()).thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any())).thenReturn(new FulfillmentGroupItemImpl());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(new NullOrderImpl());

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
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = mock(FulfillmentGroupItemRequest.class);
    when(fulfillmentGroupItemRequest.getQuantity()).thenReturn(1);
    when(fulfillmentGroupItemRequest.getFulfillmentGroup()).thenReturn(null);
    when(fulfillmentGroupItemRequest.getOrder()).thenReturn(orderImpl);
    when(fulfillmentGroupItemRequest.getOrderItem()).thenReturn(new BundleOrderItemImpl());
    doNothing().when(fulfillmentGroupItemRequest).setFulfillmentGroup(Mockito.<FulfillmentGroup>any());
    doNothing().when(fulfillmentGroupItemRequest).setOrder(Mockito.<Order>any());
    doNothing().when(fulfillmentGroupItemRequest).setOrderItem(Mockito.<OrderItem>any());
    doNothing().when(fulfillmentGroupItemRequest).setQuantity(anyInt());
    fulfillmentGroupItemRequest.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest.setQuantity(1);

    // Act
    FulfillmentGroup actualAddItemToFulfillmentGroupResult = fulfillmentGroupServiceImpl
        .addItemToFulfillmentGroup(fulfillmentGroupItemRequest, true, true);

    // Assert
    verify(fulfillmentGroupDao, atLeast(1)).create();
    verify(fulfillmentGroupDao).readNextFulfillmentGroupSequnceForOrder(isA(Order.class));
    verify(fulfillmentGroupDao).save(isA(FulfillmentGroup.class));
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupItemDao).save(isA(FulfillmentGroupItem.class));
    verify(orderService).save(isA(Order.class), eq(true));
    verify(fulfillmentGroupItemRequest).getFulfillmentGroup();
    verify(fulfillmentGroupItemRequest).getOrder();
    verify(fulfillmentGroupItemRequest).getOrderItem();
    verify(fulfillmentGroupItemRequest).getQuantity();
    verify(fulfillmentGroupItemRequest).setFulfillmentGroup(isA(FulfillmentGroup.class));
    verify(fulfillmentGroupItemRequest).setOrder(isA(Order.class));
    verify(fulfillmentGroupItemRequest).setOrderItem(isA(OrderItem.class));
    verify(fulfillmentGroupItemRequest).setQuantity(eq(1));
    assertSame(fulfillmentGroupImpl, actualAddItemToFulfillmentGroupResult);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean, boolean)} with {@code fulfillmentGroupItemRequest}, {@code priceOrder}, {@code save}.
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup FulfillmentGroupServiceImpl.addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean, boolean)"})
  public void testAddItemToFulfillmentGroupWithFulfillmentGroupItemRequestPriceOrderSave3() throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.readNextFulfillmentGroupSequnceForOrder(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    when(fulfillmentGroupDao.create()).thenReturn(new FulfillmentGroupImpl());

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
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = mock(FulfillmentGroupItemRequest.class);
    when(fulfillmentGroupItemRequest.getFulfillmentGroup()).thenReturn(null);
    when(fulfillmentGroupItemRequest.getOrder()).thenReturn(orderImpl);
    when(fulfillmentGroupItemRequest.getOrderItem()).thenReturn(new BundleOrderItemImpl());
    doNothing().when(fulfillmentGroupItemRequest).setFulfillmentGroup(Mockito.<FulfillmentGroup>any());
    doNothing().when(fulfillmentGroupItemRequest).setOrder(Mockito.<Order>any());
    doNothing().when(fulfillmentGroupItemRequest).setOrderItem(Mockito.<OrderItem>any());
    doNothing().when(fulfillmentGroupItemRequest).setQuantity(anyInt());
    fulfillmentGroupItemRequest.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest.setQuantity(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> fulfillmentGroupServiceImpl.addItemToFulfillmentGroup(fulfillmentGroupItemRequest, true, true));
    verify(fulfillmentGroupDao, atLeast(1)).create();
    verify(fulfillmentGroupDao).readNextFulfillmentGroupSequnceForOrder(isA(Order.class));
    verify(fulfillmentGroupItemRequest).getFulfillmentGroup();
    verify(fulfillmentGroupItemRequest).getOrder();
    verify(fulfillmentGroupItemRequest).getOrderItem();
    verify(fulfillmentGroupItemRequest).setFulfillmentGroup(isA(FulfillmentGroup.class));
    verify(fulfillmentGroupItemRequest).setOrder(isA(Order.class));
    verify(fulfillmentGroupItemRequest).setOrderItem(isA(OrderItem.class));
    verify(fulfillmentGroupItemRequest).setQuantity(eq(1));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean, boolean)} with {@code fulfillmentGroupItemRequest}, {@code priceOrder}, {@code save}.
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup FulfillmentGroupServiceImpl.addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean, boolean)"})
  public void testAddItemToFulfillmentGroupWithFulfillmentGroupItemRequestPriceOrderSave4() throws PricingException {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getSequence()).thenReturn(1);
    doNothing().when(fulfillmentGroupImpl).setAddress(Mockito.<Address>any());
    doNothing().when(fulfillmentGroupImpl).setFulfillmentOption(Mockito.<FulfillmentOption>any());
    doNothing().when(fulfillmentGroupImpl).setOrder(Mockito.<Order>any());
    doNothing().when(fulfillmentGroupImpl).setPhone(Mockito.<Phone>any());
    doNothing().when(fulfillmentGroupImpl).setType(Mockito.<FulfillmentType>any());
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    when(fulfillmentGroupDao.save(Mockito.<FulfillmentGroup>any())).thenReturn(fulfillmentGroupImpl2);
    when(fulfillmentGroupDao.create()).thenReturn(fulfillmentGroupImpl);
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any())).thenReturn(new FulfillmentGroupItemImpl());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(new NullOrderImpl());

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
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = mock(FulfillmentGroupItemRequest.class);
    when(fulfillmentGroupItemRequest.getQuantity()).thenReturn(1);
    when(fulfillmentGroupItemRequest.getFulfillmentGroup()).thenReturn(null);
    when(fulfillmentGroupItemRequest.getOrder()).thenReturn(orderImpl);
    when(fulfillmentGroupItemRequest.getOrderItem()).thenReturn(new BundleOrderItemImpl());
    doNothing().when(fulfillmentGroupItemRequest).setFulfillmentGroup(Mockito.<FulfillmentGroup>any());
    doNothing().when(fulfillmentGroupItemRequest).setOrder(Mockito.<Order>any());
    doNothing().when(fulfillmentGroupItemRequest).setOrderItem(Mockito.<OrderItem>any());
    doNothing().when(fulfillmentGroupItemRequest).setQuantity(anyInt());
    fulfillmentGroupItemRequest.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest.setQuantity(1);

    // Act
    FulfillmentGroup actualAddItemToFulfillmentGroupResult = fulfillmentGroupServiceImpl
        .addItemToFulfillmentGroup(fulfillmentGroupItemRequest, true, true);

    // Assert
    verify(fulfillmentGroupDao, atLeast(1)).create();
    verify(fulfillmentGroupDao).save(isA(FulfillmentGroup.class));
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupItemDao).save(isA(FulfillmentGroupItem.class));
    verify(fulfillmentGroupImpl).getSequence();
    verify(fulfillmentGroupImpl).setAddress(isNull());
    verify(fulfillmentGroupImpl).setFulfillmentOption(isNull());
    verify(fulfillmentGroupImpl).setOrder(isA(Order.class));
    verify(fulfillmentGroupImpl).setPhone(isNull());
    verify(fulfillmentGroupImpl).setType(isNull());
    verify(orderService).save(isA(Order.class), eq(true));
    verify(fulfillmentGroupItemRequest).getFulfillmentGroup();
    verify(fulfillmentGroupItemRequest).getOrder();
    verify(fulfillmentGroupItemRequest).getOrderItem();
    verify(fulfillmentGroupItemRequest).getQuantity();
    verify(fulfillmentGroupItemRequest).setFulfillmentGroup(isA(FulfillmentGroup.class));
    verify(fulfillmentGroupItemRequest).setOrder(isA(Order.class));
    verify(fulfillmentGroupItemRequest).setOrderItem(isA(OrderItem.class));
    verify(fulfillmentGroupItemRequest).setQuantity(eq(1));
    assertSame(fulfillmentGroupImpl2, actualAddItemToFulfillmentGroupResult);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean, boolean)} with {@code fulfillmentGroupItemRequest}, {@code priceOrder}, {@code save}.
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup FulfillmentGroupServiceImpl.addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean, boolean)"})
  public void testAddItemToFulfillmentGroupWithFulfillmentGroupItemRequestPriceOrderSave5() throws PricingException {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getSequence()).thenReturn(1);
    doNothing().when(fulfillmentGroupImpl).setAddress(Mockito.<Address>any());
    doNothing().when(fulfillmentGroupImpl).setFulfillmentOption(Mockito.<FulfillmentOption>any());
    doNothing().when(fulfillmentGroupImpl).setOrder(Mockito.<Order>any());
    doNothing().when(fulfillmentGroupImpl).setPhone(Mockito.<Phone>any());
    doNothing().when(fulfillmentGroupImpl).setType(Mockito.<FulfillmentType>any());
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    when(fulfillmentGroupDao.save(Mockito.<FulfillmentGroup>any())).thenReturn(fulfillmentGroupImpl2);
    when(fulfillmentGroupDao.create()).thenReturn(fulfillmentGroupImpl);
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any())).thenReturn(new FulfillmentGroupItemImpl());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(new NullOrderImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(fulfillmentGroups);
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = mock(FulfillmentGroupItemRequest.class);
    when(fulfillmentGroupItemRequest.getQuantity()).thenReturn(1);
    when(fulfillmentGroupItemRequest.getFulfillmentGroup()).thenReturn(null);
    when(fulfillmentGroupItemRequest.getOrder()).thenReturn(orderImpl);
    when(fulfillmentGroupItemRequest.getOrderItem()).thenReturn(new BundleOrderItemImpl());
    doNothing().when(fulfillmentGroupItemRequest).setFulfillmentGroup(Mockito.<FulfillmentGroup>any());
    doNothing().when(fulfillmentGroupItemRequest).setOrder(Mockito.<Order>any());
    doNothing().when(fulfillmentGroupItemRequest).setOrderItem(Mockito.<OrderItem>any());
    doNothing().when(fulfillmentGroupItemRequest).setQuantity(anyInt());
    fulfillmentGroupItemRequest.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest.setQuantity(1);

    // Act
    FulfillmentGroup actualAddItemToFulfillmentGroupResult = fulfillmentGroupServiceImpl
        .addItemToFulfillmentGroup(fulfillmentGroupItemRequest, true, true);

    // Assert
    verify(fulfillmentGroupDao, atLeast(1)).create();
    verify(fulfillmentGroupDao).save(isA(FulfillmentGroup.class));
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupItemDao).save(isA(FulfillmentGroupItem.class));
    verify(fulfillmentGroupImpl).getSequence();
    verify(fulfillmentGroupImpl).setAddress(isNull());
    verify(fulfillmentGroupImpl).setFulfillmentOption(isNull());
    verify(fulfillmentGroupImpl).setOrder(isA(Order.class));
    verify(fulfillmentGroupImpl).setPhone(isNull());
    verify(fulfillmentGroupImpl).setType(isNull());
    verify(orderService).save(isA(Order.class), eq(true));
    verify(fulfillmentGroupItemRequest).getFulfillmentGroup();
    verify(fulfillmentGroupItemRequest).getOrder();
    verify(fulfillmentGroupItemRequest).getOrderItem();
    verify(fulfillmentGroupItemRequest).getQuantity();
    verify(fulfillmentGroupItemRequest).setFulfillmentGroup(isA(FulfillmentGroup.class));
    verify(fulfillmentGroupItemRequest).setOrder(isA(Order.class));
    verify(fulfillmentGroupItemRequest).setOrderItem(isA(OrderItem.class));
    verify(fulfillmentGroupItemRequest).setQuantity(eq(1));
    assertSame(fulfillmentGroupImpl2, actualAddItemToFulfillmentGroupResult);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#getFulfillmentGroupItemsForOrderItem(Order, OrderItem)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FulfillmentGroupImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#getFulfillmentGroupItemsForOrderItem(Order, OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List FulfillmentGroupServiceImpl.getFulfillmentGroupItemsForOrderItem(Order, OrderItem)"})
  public void testGetFulfillmentGroupItemsForOrderItem_givenArrayListAddFulfillmentGroupImpl() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(fulfillmentGroups);
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
    order.setTotalTax(new Money());

    // Act and Assert
    assertTrue(
        fulfillmentGroupServiceImpl.getFulfillmentGroupItemsForOrderItem(order, new BundleOrderItemImpl()).isEmpty());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#getFulfillmentGroupItemsForOrderItem(Order, OrderItem)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#getFulfillmentGroupItemsForOrderItem(Order, OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List FulfillmentGroupServiceImpl.getFulfillmentGroupItemsForOrderItem(Order, OrderItem)"})
  public void testGetFulfillmentGroupItemsForOrderItem_thenReturnEmpty() {
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
    order.setTotalTax(new Money());

    // Act and Assert
    assertTrue(
        fulfillmentGroupServiceImpl.getFulfillmentGroupItemsForOrderItem(order, new BundleOrderItemImpl()).isEmpty());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#collapseToOneShippableFulfillmentGroup(Order, boolean)}.
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#collapseToOneShippableFulfillmentGroup(Order, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order FulfillmentGroupServiceImpl.collapseToOneShippableFulfillmentGroup(Order, boolean)"})
  public void testCollapseToOneShippableFulfillmentGroup_thenReturnNullOrderImpl() throws PricingException {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertSame(order, fulfillmentGroupServiceImpl.collapseToOneShippableFulfillmentGroup(order, true));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#collapseToOneShippableFulfillmentGroup(Order, boolean)}.
   * <ul>
   *   <li>Then return {@link OrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#collapseToOneShippableFulfillmentGroup(Order, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order FulfillmentGroupServiceImpl.collapseToOneShippableFulfillmentGroup(Order, boolean)"})
  public void testCollapseToOneShippableFulfillmentGroup_thenReturnOrderImpl() throws PricingException {
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
    order.setTotalTax(new Money());

    // Act and Assert
    assertSame(order, fulfillmentGroupServiceImpl.collapseToOneShippableFulfillmentGroup(order, true));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#matchFulfillmentGroupsToMultishipOptions(Order, boolean)}.
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#matchFulfillmentGroupsToMultishipOptions(Order, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order FulfillmentGroupServiceImpl.matchFulfillmentGroupsToMultishipOptions(Order, boolean)"})
  public void testMatchFulfillmentGroupsToMultishipOptions() throws PricingException {
    // Arrange
    when(orderMultishipOptionService.findOrderMultishipOptions(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(nullOrderImpl);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(fulfillmentGroups);
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
    order.setTotalTax(new Money());

    // Act
    Order actualMatchFulfillmentGroupsToMultishipOptionsResult = fulfillmentGroupServiceImpl
        .matchFulfillmentGroupsToMultishipOptions(order, true);

    // Assert
    verify(orderMultishipOptionService).findOrderMultishipOptions(eq(1L));
    verify(orderService).save(isA(Order.class), eq(true));
    assertSame(nullOrderImpl, actualMatchFulfillmentGroupsToMultishipOptionsResult);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#matchFulfillmentGroupsToMultishipOptions(Order, boolean)}.
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#matchFulfillmentGroupsToMultishipOptions(Order, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order FulfillmentGroupServiceImpl.matchFulfillmentGroupsToMultishipOptions(Order, boolean)"})
  public void testMatchFulfillmentGroupsToMultishipOptions_thenReturnNullOrderImpl() throws PricingException {
    // Arrange
    when(orderMultishipOptionService.findOrderMultishipOptions(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(nullOrderImpl);

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
    order.setTotalTax(new Money());

    // Act
    Order actualMatchFulfillmentGroupsToMultishipOptionsResult = fulfillmentGroupServiceImpl
        .matchFulfillmentGroupsToMultishipOptions(order, true);

    // Assert
    verify(orderMultishipOptionService).findOrderMultishipOptions(eq(1L));
    verify(orderService).save(isA(Order.class), eq(true));
    assertSame(nullOrderImpl, actualMatchFulfillmentGroupsToMultishipOptionsResult);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#matchFulfillmentGroupsToMultishipOptions(Order, boolean)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#matchFulfillmentGroupsToMultishipOptions(Order, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order FulfillmentGroupServiceImpl.matchFulfillmentGroupsToMultishipOptions(Order, boolean)"})
  public void testMatchFulfillmentGroupsToMultishipOptions_thenThrowIllegalArgumentException() throws PricingException {
    // Arrange
    when(orderMultishipOptionService.findOrderMultishipOptions(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any()))
        .thenThrow(new IllegalArgumentException("foo"));

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
    order.setTotalTax(new Money());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> fulfillmentGroupServiceImpl.matchFulfillmentGroupsToMultishipOptions(order, true));
    verify(orderMultishipOptionService).findOrderMultishipOptions(eq(1L));
    verify(orderService).save(isA(Order.class), eq(true));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#getKey(Address, FulfillmentOption, FulfillmentType)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link FulfillmentOption} {@link FulfillmentOption#getId()} return one.</li>
   *   <li>Then return {@code 1:1:DIGITAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#getKey(Address, FulfillmentOption, FulfillmentType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FulfillmentGroupServiceImpl.getKey(Address, FulfillmentOption, FulfillmentType)"})
  public void testGetKey_givenOne_whenFulfillmentOptionGetIdReturnOne_thenReturn11Digital() {
    // Arrange
    AddressImpl address = mock(AddressImpl.class);
    when(address.getId()).thenReturn(1L);
    FulfillmentOption option = mock(FulfillmentOption.class);
    when(option.getId()).thenReturn(1L);

    // Act
    String actualKey = fulfillmentGroupServiceImpl.getKey(address, option, FulfillmentType.DIGITAL);

    // Assert
    verify(option).getId();
    verify(address).getId();
    assertEquals("1:1:DIGITAL", actualKey);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#getKey(Address, FulfillmentOption, FulfillmentType)}.
   * <ul>
   *   <li>Given {@code Type}.</li>
   *   <li>When {@link FulfillmentType} {@link FulfillmentType#getType()} return {@code Type}.</li>
   *   <li>Then return {@code 1:1:Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#getKey(Address, FulfillmentOption, FulfillmentType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FulfillmentGroupServiceImpl.getKey(Address, FulfillmentOption, FulfillmentType)"})
  public void testGetKey_givenType_whenFulfillmentTypeGetTypeReturnType_thenReturn11Type() {
    // Arrange
    AddressImpl address = mock(AddressImpl.class);
    when(address.getId()).thenReturn(1L);
    FulfillmentOption option = mock(FulfillmentOption.class);
    when(option.getId()).thenReturn(1L);
    FulfillmentType fulfillmentType = mock(FulfillmentType.class);
    when(fulfillmentType.getType()).thenReturn("Type");

    // Act
    String actualKey = fulfillmentGroupServiceImpl.getKey(address, option, fulfillmentType);

    // Assert
    verify(option).getId();
    verify(fulfillmentType).getType();
    verify(address).getId();
    assertEquals("1:1:Type", actualKey);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#getKey(Address, FulfillmentOption, FulfillmentType)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code -1:-1:DIGITAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#getKey(Address, FulfillmentOption, FulfillmentType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FulfillmentGroupServiceImpl.getKey(Address, FulfillmentOption, FulfillmentType)"})
  public void testGetKey_whenNull_thenReturn11Digital() {
    // Arrange, Act and Assert
    assertEquals("-1:-1:DIGITAL", fulfillmentGroupServiceImpl.getKey(null, null, FulfillmentType.DIGITAL));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#getKey(Address, FulfillmentOption, FulfillmentType)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code -1:-1:-1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#getKey(Address, FulfillmentOption, FulfillmentType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FulfillmentGroupServiceImpl.getKey(Address, FulfillmentOption, FulfillmentType)"})
  public void testGetKey_whenNull_thenReturn111() {
    // Arrange, Act and Assert
    assertEquals("-1:-1:-1", fulfillmentGroupServiceImpl.getKey(null, null, null));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#createFulfillmentGroupItemFromOrderItem(OrderItem, FulfillmentGroup, int)}.
   * <ul>
   *   <li>Then return {@link FulfillmentGroupItemImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#createFulfillmentGroupItemFromOrderItem(OrderItem, FulfillmentGroup, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroupItem FulfillmentGroupServiceImpl.createFulfillmentGroupItemFromOrderItem(OrderItem, FulfillmentGroup, int)"})
  public void testCreateFulfillmentGroupItemFromOrderItem_thenReturnFulfillmentGroupItemImpl() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    when(fulfillmentGroupItemDao.create()).thenReturn(fulfillmentGroupItemImpl);
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();

    // Act
    FulfillmentGroupItem actualCreateFulfillmentGroupItemFromOrderItemResult = fulfillmentGroupServiceImpl
        .createFulfillmentGroupItemFromOrderItem(orderItem, new FulfillmentGroupImpl(), 1);

    // Assert
    verify(fulfillmentGroupItemDao).create();
    assertSame(fulfillmentGroupItemImpl, actualCreateFulfillmentGroupItemFromOrderItemResult);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#createFulfillmentGroupItemFromOrderItem(OrderItem, FulfillmentGroup, int)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#createFulfillmentGroupItemFromOrderItem(OrderItem, FulfillmentGroup, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroupItem FulfillmentGroupServiceImpl.createFulfillmentGroupItemFromOrderItem(OrderItem, FulfillmentGroup, int)"})
  public void testCreateFulfillmentGroupItemFromOrderItem_thenThrowIllegalArgumentException() {
    // Arrange
    when(fulfillmentGroupItemDao.create()).thenThrow(new IllegalArgumentException("foo"));
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> fulfillmentGroupServiceImpl
        .createFulfillmentGroupItemFromOrderItem(orderItem, new FulfillmentGroupImpl(), 1));
    verify(fulfillmentGroupItemDao).create();
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#removeAllFulfillmentGroupsFromOrder(Order, boolean)}.
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#removeAllFulfillmentGroupsFromOrder(Order, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order FulfillmentGroupServiceImpl.removeAllFulfillmentGroupsFromOrder(Order, boolean)"})
  public void testRemoveAllFulfillmentGroupsFromOrder() throws PricingException {
    // Arrange and Act
    Order actualRemoveAllFulfillmentGroupsFromOrderResult = fulfillmentGroupServiceImpl
        .removeAllFulfillmentGroupsFromOrder(new NullOrderImpl(), true);

    // Assert
    assertTrue(actualRemoveAllFulfillmentGroupsFromOrderResult instanceof NullOrderImpl);
    Money orderAdjustmentsValue = actualRemoveAllFulfillmentGroupsFromOrderResult.getOrderAdjustmentsValue();
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.abs());
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.zero());
    assertEquals(orderAdjustmentsValue, actualRemoveAllFulfillmentGroupsFromOrderResult.getSubTotal());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#removeAllFulfillmentGroupsFromOrder(Order, boolean)}.
   * <ul>
   *   <li>Then return SubTotal is {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#removeAllFulfillmentGroupsFromOrder(Order, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order FulfillmentGroupServiceImpl.removeAllFulfillmentGroupsFromOrder(Order, boolean)"})
  public void testRemoveAllFulfillmentGroupsFromOrder_thenReturnSubTotalIsMoney() throws PricingException {
    // Arrange
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(new NullOrderImpl());

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
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    Money subTotal = new Money();
    order.setSubTotal(subTotal);
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    Money totalTax = new Money();
    order.setTotalTax(totalTax);
    order.setFulfillmentGroups(new ArrayList<>());

    // Act
    Order actualRemoveAllFulfillmentGroupsFromOrderResult = fulfillmentGroupServiceImpl
        .removeAllFulfillmentGroupsFromOrder(order, true);

    // Assert
    verify(orderService).save(isA(Order.class), eq(true));
    assertTrue(actualRemoveAllFulfillmentGroupsFromOrderResult instanceof NullOrderImpl);
    assertEquals(subTotal, actualRemoveAllFulfillmentGroupsFromOrderResult.getSubTotal());
    Money expectedOrderAdjustmentsValue = totalTax.ZERO;
    assertSame(expectedOrderAdjustmentsValue,
        actualRemoveAllFulfillmentGroupsFromOrderResult.getOrderAdjustmentsValue());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#removeAllFulfillmentGroupsFromOrder(Order, boolean)}.
   * <ul>
   *   <li>Then return SubTotal is {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#removeAllFulfillmentGroupsFromOrder(Order, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order FulfillmentGroupServiceImpl.removeAllFulfillmentGroupsFromOrder(Order, boolean)"})
  public void testRemoveAllFulfillmentGroupsFromOrder_thenReturnSubTotalIsMoney2() throws PricingException {
    // Arrange
    doNothing().when(fulfillmentGroupDao).delete(Mockito.<FulfillmentGroup>any());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(new NullOrderImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    Money subTotal = new Money();
    order.setSubTotal(subTotal);
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    Money totalTax = new Money();
    order.setTotalTax(totalTax);
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act
    Order actualRemoveAllFulfillmentGroupsFromOrderResult = fulfillmentGroupServiceImpl
        .removeAllFulfillmentGroupsFromOrder(order, true);

    // Assert
    verify(fulfillmentGroupDao).delete(isA(FulfillmentGroup.class));
    verify(orderService).save(isA(Order.class), eq(true));
    assertTrue(actualRemoveAllFulfillmentGroupsFromOrderResult instanceof NullOrderImpl);
    assertEquals(subTotal, actualRemoveAllFulfillmentGroupsFromOrderResult.getSubTotal());
    Money expectedOrderAdjustmentsValue = totalTax.ZERO;
    assertSame(expectedOrderAdjustmentsValue,
        actualRemoveAllFulfillmentGroupsFromOrderResult.getOrderAdjustmentsValue());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#removeAllFulfillmentGroupsFromOrder(Order, boolean)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#removeAllFulfillmentGroupsFromOrder(Order, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order FulfillmentGroupServiceImpl.removeAllFulfillmentGroupsFromOrder(Order, boolean)"})
  public void testRemoveAllFulfillmentGroupsFromOrder_thenThrowIllegalArgumentException() throws PricingException {
    // Arrange
    doNothing().when(fulfillmentGroupDao).delete(Mockito.<FulfillmentGroup>any());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
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
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> fulfillmentGroupServiceImpl.removeAllFulfillmentGroupsFromOrder(order, true));
    verify(fulfillmentGroupDao).delete(isA(FulfillmentGroup.class));
    verify(orderService).save(isA(Order.class), eq(true));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#createFulfillmentGroupFee()}.
   * <ul>
   *   <li>Then return {@link FulfillmentGroupFeeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#createFulfillmentGroupFee()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentGroupFee FulfillmentGroupServiceImpl.createFulfillmentGroupFee()"})
  public void testCreateFulfillmentGroupFee_thenReturnFulfillmentGroupFeeImpl() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    when(fulfillmentGroupDao.createFulfillmentGroupFee()).thenReturn(fulfillmentGroupFeeImpl);

    // Act
    FulfillmentGroupFee actualCreateFulfillmentGroupFeeResult = fulfillmentGroupServiceImpl.createFulfillmentGroupFee();

    // Assert
    verify(fulfillmentGroupDao).createFulfillmentGroupFee();
    assertSame(fulfillmentGroupFeeImpl, actualCreateFulfillmentGroupFeeResult);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#createFulfillmentGroupFee()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#createFulfillmentGroupFee()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentGroupFee FulfillmentGroupServiceImpl.createFulfillmentGroupFee()"})
  public void testCreateFulfillmentGroupFee_thenThrowIllegalArgumentException() {
    // Arrange
    when(fulfillmentGroupDao.createFulfillmentGroupFee()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> fulfillmentGroupServiceImpl.createFulfillmentGroupFee());
    verify(fulfillmentGroupDao).createFulfillmentGroupFee();
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#findUnfulfilledFulfillmentGroups(int, int)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#findUnfulfilledFulfillmentGroups(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List FulfillmentGroupServiceImpl.findUnfulfilledFulfillmentGroups(int, int)"})
  public void testFindUnfulfilledFulfillmentGroups_thenReturnEmpty() {
    // Arrange
    when(fulfillmentGroupDao.readUnfulfilledFulfillmentGroups(anyInt(), anyInt())).thenReturn(new ArrayList<>());

    // Act
    List<FulfillmentGroup> actualFindUnfulfilledFulfillmentGroupsResult = fulfillmentGroupServiceImpl
        .findUnfulfilledFulfillmentGroups(1, 3);

    // Assert
    verify(fulfillmentGroupDao).readUnfulfilledFulfillmentGroups(eq(1), eq(3));
    assertTrue(actualFindUnfulfilledFulfillmentGroupsResult.isEmpty());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#findUnfulfilledFulfillmentGroups(int, int)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#findUnfulfilledFulfillmentGroups(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List FulfillmentGroupServiceImpl.findUnfulfilledFulfillmentGroups(int, int)"})
  public void testFindUnfulfilledFulfillmentGroups_thenThrowIllegalArgumentException() {
    // Arrange
    when(fulfillmentGroupDao.readUnfulfilledFulfillmentGroups(anyInt(), anyInt()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> fulfillmentGroupServiceImpl.findUnfulfilledFulfillmentGroups(1, 3));
    verify(fulfillmentGroupDao).readUnfulfilledFulfillmentGroups(eq(1), eq(3));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#findPartiallyFulfilledFulfillmentGroups(int, int)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#findPartiallyFulfilledFulfillmentGroups(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List FulfillmentGroupServiceImpl.findPartiallyFulfilledFulfillmentGroups(int, int)"})
  public void testFindPartiallyFulfilledFulfillmentGroups_thenReturnEmpty() {
    // Arrange
    when(fulfillmentGroupDao.readPartiallyFulfilledFulfillmentGroups(anyInt(), anyInt())).thenReturn(new ArrayList<>());

    // Act
    List<FulfillmentGroup> actualFindPartiallyFulfilledFulfillmentGroupsResult = fulfillmentGroupServiceImpl
        .findPartiallyFulfilledFulfillmentGroups(1, 3);

    // Assert
    verify(fulfillmentGroupDao).readPartiallyFulfilledFulfillmentGroups(eq(1), eq(3));
    assertTrue(actualFindPartiallyFulfilledFulfillmentGroupsResult.isEmpty());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#findPartiallyFulfilledFulfillmentGroups(int, int)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#findPartiallyFulfilledFulfillmentGroups(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List FulfillmentGroupServiceImpl.findPartiallyFulfilledFulfillmentGroups(int, int)"})
  public void testFindPartiallyFulfilledFulfillmentGroups_thenThrowIllegalArgumentException() {
    // Arrange
    when(fulfillmentGroupDao.readPartiallyFulfilledFulfillmentGroups(anyInt(), anyInt()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> fulfillmentGroupServiceImpl.findPartiallyFulfilledFulfillmentGroups(1, 3));
    verify(fulfillmentGroupDao).readPartiallyFulfilledFulfillmentGroups(eq(1), eq(3));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#findUnprocessedFulfillmentGroups(int, int)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#findUnprocessedFulfillmentGroups(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List FulfillmentGroupServiceImpl.findUnprocessedFulfillmentGroups(int, int)"})
  public void testFindUnprocessedFulfillmentGroups_thenReturnEmpty() {
    // Arrange
    when(fulfillmentGroupDao.readUnprocessedFulfillmentGroups(anyInt(), anyInt())).thenReturn(new ArrayList<>());

    // Act
    List<FulfillmentGroup> actualFindUnprocessedFulfillmentGroupsResult = fulfillmentGroupServiceImpl
        .findUnprocessedFulfillmentGroups(1, 3);

    // Assert
    verify(fulfillmentGroupDao).readUnprocessedFulfillmentGroups(eq(1), eq(3));
    assertTrue(actualFindUnprocessedFulfillmentGroupsResult.isEmpty());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#findUnprocessedFulfillmentGroups(int, int)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#findUnprocessedFulfillmentGroups(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List FulfillmentGroupServiceImpl.findUnprocessedFulfillmentGroups(int, int)"})
  public void testFindUnprocessedFulfillmentGroups_thenThrowIllegalArgumentException() {
    // Arrange
    when(fulfillmentGroupDao.readUnprocessedFulfillmentGroups(anyInt(), anyInt()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> fulfillmentGroupServiceImpl.findUnprocessedFulfillmentGroups(1, 3));
    verify(fulfillmentGroupDao).readUnprocessedFulfillmentGroups(eq(1), eq(3));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#findFulfillmentGroupsByStatus(FulfillmentGroupStatusType, int, int)} with {@code status}, {@code start}, {@code maxResults}.
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#findFulfillmentGroupsByStatus(FulfillmentGroupStatusType, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List FulfillmentGroupServiceImpl.findFulfillmentGroupsByStatus(FulfillmentGroupStatusType, int, int)"})
  public void testFindFulfillmentGroupsByStatusWithStatusStartMaxResults() {
    // Arrange
    when(fulfillmentGroupDao.readFulfillmentGroupsByStatus(Mockito.<FulfillmentGroupStatusType>any(), anyInt(),
        anyInt())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> fulfillmentGroupServiceImpl.findFulfillmentGroupsByStatus(FulfillmentGroupStatusType.CANCELLED, 1, 3));
    verify(fulfillmentGroupDao).readFulfillmentGroupsByStatus(isA(FulfillmentGroupStatusType.class), eq(1), eq(3));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#findFulfillmentGroupsByStatus(FulfillmentGroupStatusType, int, int, boolean)} with {@code status}, {@code start}, {@code maxResults}, {@code ascending}.
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#findFulfillmentGroupsByStatus(FulfillmentGroupStatusType, int, int, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List FulfillmentGroupServiceImpl.findFulfillmentGroupsByStatus(FulfillmentGroupStatusType, int, int, boolean)"})
  public void testFindFulfillmentGroupsByStatusWithStatusStartMaxResultsAscending() {
    // Arrange
    when(fulfillmentGroupDao.readFulfillmentGroupsByStatus(Mockito.<FulfillmentGroupStatusType>any(), anyInt(),
        anyInt(), anyBoolean())).thenReturn(new ArrayList<>());

    // Act
    List<FulfillmentGroup> actualFindFulfillmentGroupsByStatusResult = fulfillmentGroupServiceImpl
        .findFulfillmentGroupsByStatus(FulfillmentGroupStatusType.CANCELLED, 1, 3, true);

    // Assert
    verify(fulfillmentGroupDao).readFulfillmentGroupsByStatus(isA(FulfillmentGroupStatusType.class), eq(1), eq(3),
        eq(true));
    assertTrue(actualFindFulfillmentGroupsByStatusResult.isEmpty());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#findFulfillmentGroupsByStatus(FulfillmentGroupStatusType, int, int, boolean)} with {@code status}, {@code start}, {@code maxResults}, {@code ascending}.
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#findFulfillmentGroupsByStatus(FulfillmentGroupStatusType, int, int, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List FulfillmentGroupServiceImpl.findFulfillmentGroupsByStatus(FulfillmentGroupStatusType, int, int, boolean)"})
  public void testFindFulfillmentGroupsByStatusWithStatusStartMaxResultsAscending2() {
    // Arrange
    when(fulfillmentGroupDao.readFulfillmentGroupsByStatus(Mockito.<FulfillmentGroupStatusType>any(), anyInt(),
        anyInt(), anyBoolean())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> fulfillmentGroupServiceImpl
        .findFulfillmentGroupsByStatus(FulfillmentGroupStatusType.CANCELLED, 1, 3, true));
    verify(fulfillmentGroupDao).readFulfillmentGroupsByStatus(isA(FulfillmentGroupStatusType.class), eq(1), eq(3),
        eq(true));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#findFulfillmentGroupsByStatus(FulfillmentGroupStatusType, int, int)} with {@code status}, {@code start}, {@code maxResults}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#findFulfillmentGroupsByStatus(FulfillmentGroupStatusType, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List FulfillmentGroupServiceImpl.findFulfillmentGroupsByStatus(FulfillmentGroupStatusType, int, int)"})
  public void testFindFulfillmentGroupsByStatusWithStatusStartMaxResults_thenReturnEmpty() {
    // Arrange
    when(fulfillmentGroupDao.readFulfillmentGroupsByStatus(Mockito.<FulfillmentGroupStatusType>any(), anyInt(),
        anyInt())).thenReturn(new ArrayList<>());

    // Act
    List<FulfillmentGroup> actualFindFulfillmentGroupsByStatusResult = fulfillmentGroupServiceImpl
        .findFulfillmentGroupsByStatus(FulfillmentGroupStatusType.CANCELLED, 1, 3);

    // Assert
    verify(fulfillmentGroupDao).readFulfillmentGroupsByStatus(isA(FulfillmentGroupStatusType.class), eq(1), eq(3));
    assertTrue(actualFindFulfillmentGroupsByStatusResult.isEmpty());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#isShippable(FulfillmentType)}.
   * <ul>
   *   <li>When {@link FulfillmentType#DIGITAL}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#isShippable(FulfillmentType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupServiceImpl.isShippable(FulfillmentType)"})
  public void testIsShippable_whenDigital_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(fulfillmentGroupServiceImpl.isShippable(FulfillmentType.DIGITAL));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#isShippable(FulfillmentType)}.
   * <ul>
   *   <li>When {@link FulfillmentType#FulfillmentType(String, String)} with type is {@code GIFT_CARD} and friendlyType is {@code GIFT_CARD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#isShippable(FulfillmentType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupServiceImpl.isShippable(FulfillmentType)"})
  public void testIsShippable_whenFulfillmentTypeWithTypeIsGiftCardAndFriendlyTypeIsGiftCard() {
    // Arrange, Act and Assert
    assertFalse(fulfillmentGroupServiceImpl.isShippable(new FulfillmentType("GIFT_CARD", "GIFT_CARD")));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#isShippable(FulfillmentType)}.
   * <ul>
   *   <li>When {@link FulfillmentType#GIFT_CARD}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#isShippable(FulfillmentType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupServiceImpl.isShippable(FulfillmentType)"})
  public void testIsShippable_whenGift_card_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(fulfillmentGroupServiceImpl.isShippable(FulfillmentType.GIFT_CARD));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#isShippable(FulfillmentType)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#isShippable(FulfillmentType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupServiceImpl.isShippable(FulfillmentType)"})
  public void testIsShippable_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(fulfillmentGroupServiceImpl.isShippable(null));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#isShippable(FulfillmentType)}.
   * <ul>
   *   <li>When {@link FulfillmentType#PHYSICAL_PICKUP_OR_SHIP}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#isShippable(FulfillmentType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupServiceImpl.isShippable(FulfillmentType)"})
  public void testIsShippable_whenPhysical_pickup_or_ship_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(fulfillmentGroupServiceImpl.isShippable(FulfillmentType.PHYSICAL_PICKUP_OR_SHIP));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#isShippable(FulfillmentType)}.
   * <ul>
   *   <li>When {@link FulfillmentType#PHYSICAL_PICKUP}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#isShippable(FulfillmentType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupServiceImpl.isShippable(FulfillmentType)"})
  public void testIsShippable_whenPhysical_pickup_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(fulfillmentGroupServiceImpl.isShippable(FulfillmentType.PHYSICAL_PICKUP));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#getFirstShippableFulfillmentGroup(Order)}.
   * <ul>
   *   <li>Then return {@link FulfillmentGroupImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#getFirstShippableFulfillmentGroup(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentGroup FulfillmentGroupServiceImpl.getFirstShippableFulfillmentGroup(Order)"})
  public void testGetFirstShippableFulfillmentGroup_thenReturnFulfillmentGroupImpl() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(fulfillmentGroups);
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
    order.setTotalTax(new Money());

    // Act and Assert
    assertSame(fulfillmentGroupImpl, fulfillmentGroupServiceImpl.getFirstShippableFulfillmentGroup(order));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#getFirstShippableFulfillmentGroup(Order)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#getFirstShippableFulfillmentGroup(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentGroup FulfillmentGroupServiceImpl.getFirstShippableFulfillmentGroup(Order)"})
  public void testGetFirstShippableFulfillmentGroup_thenReturnNull() {
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
    order.setTotalTax(new Money());

    // Act and Assert
    assertNull(fulfillmentGroupServiceImpl.getFirstShippableFulfillmentGroup(order));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#getFirstShippableFulfillmentGroup(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#getFirstShippableFulfillmentGroup(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentGroup FulfillmentGroupServiceImpl.getFirstShippableFulfillmentGroup(Order)"})
  public void testGetFirstShippableFulfillmentGroup_whenNullOrderImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(fulfillmentGroupServiceImpl.getFirstShippableFulfillmentGroup(new NullOrderImpl()));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#getAllShippableFulfillmentGroups(Order)}.
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#getAllShippableFulfillmentGroups(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List FulfillmentGroupServiceImpl.getAllShippableFulfillmentGroups(Order)"})
  public void testGetAllShippableFulfillmentGroups_thenReturnArrayList() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(fulfillmentGroups);
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
    order.setTotalTax(new Money());

    // Act and Assert
    assertEquals(fulfillmentGroups, fulfillmentGroupServiceImpl.getAllShippableFulfillmentGroups(order));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#getAllShippableFulfillmentGroups(Order)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#getAllShippableFulfillmentGroups(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List FulfillmentGroupServiceImpl.getAllShippableFulfillmentGroups(Order)"})
  public void testGetAllShippableFulfillmentGroups_thenReturnEmpty() {
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
    order.setTotalTax(new Money());

    // Act and Assert
    assertTrue(fulfillmentGroupServiceImpl.getAllShippableFulfillmentGroups(order).isEmpty());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#getAllShippableFulfillmentGroups(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#getAllShippableFulfillmentGroups(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List FulfillmentGroupServiceImpl.getAllShippableFulfillmentGroups(Order)"})
  public void testGetAllShippableFulfillmentGroups_whenNullOrderImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(fulfillmentGroupServiceImpl.getAllShippableFulfillmentGroups(new NullOrderImpl()).isEmpty());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#calculateNumShippableFulfillmentGroups(Order)}.
   * <ul>
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#calculateNumShippableFulfillmentGroups(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Integer FulfillmentGroupServiceImpl.calculateNumShippableFulfillmentGroups(Order)"})
  public void testCalculateNumShippableFulfillmentGroups_thenReturnIntValueIsOne() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(fulfillmentGroups);
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
    order.setTotalTax(new Money());

    // Act and Assert
    assertEquals(1, fulfillmentGroupServiceImpl.calculateNumShippableFulfillmentGroups(order).intValue());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#calculateNumShippableFulfillmentGroups(Order)}.
   * <ul>
   *   <li>Then return intValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#calculateNumShippableFulfillmentGroups(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Integer FulfillmentGroupServiceImpl.calculateNumShippableFulfillmentGroups(Order)"})
  public void testCalculateNumShippableFulfillmentGroups_thenReturnIntValueIsZero() {
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
    order.setTotalTax(new Money());

    // Act and Assert
    assertEquals(0, fulfillmentGroupServiceImpl.calculateNumShippableFulfillmentGroups(order).intValue());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#calculateNumShippableFulfillmentGroups(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupServiceImpl#calculateNumShippableFulfillmentGroups(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Integer FulfillmentGroupServiceImpl.calculateNumShippableFulfillmentGroups(Order)"})
  public void testCalculateNumShippableFulfillmentGroups_whenNullOrderImpl() {
    // Arrange, Act and Assert
    assertEquals(0, fulfillmentGroupServiceImpl.calculateNumShippableFulfillmentGroups(new NullOrderImpl()).intValue());
  }
}

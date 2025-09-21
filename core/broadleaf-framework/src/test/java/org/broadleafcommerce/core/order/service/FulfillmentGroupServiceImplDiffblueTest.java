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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import org.broadleafcommerce.core.order.domain.DiscreteOrderItem;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupFee;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupFeeImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItem;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentOption;
import org.broadleafcommerce.core.order.domain.FulfillmentOptionImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.call.FulfillmentGroupItemRequest;
import org.broadleafcommerce.core.order.service.call.FulfillmentGroupRequest;
import org.broadleafcommerce.core.order.service.type.FulfillmentGroupStatusType;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
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
  @Mock private FulfillmentGroupDao fulfillmentGroupDao;

  @Mock private FulfillmentGroupItemDao fulfillmentGroupItemDao;

  @InjectMocks private FulfillmentGroupServiceImpl fulfillmentGroupServiceImpl;

  @Mock private OrderMultishipOptionService orderMultishipOptionService;

  @Mock private OrderService orderService;

  /**
   * Test {@link FulfillmentGroupServiceImpl#save(FulfillmentGroup)}.
   *
   * <p>Method under test: {@link FulfillmentGroupServiceImpl#save(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FulfillmentGroup FulfillmentGroupServiceImpl.save(FulfillmentGroup)"})
  public void testSave() {
    // Arrange
    when(fulfillmentGroupDao.readNextFulfillmentGroupSequnceForOrder(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fulfillmentGroupServiceImpl.save(new FulfillmentGroupImpl()));
    verify(fulfillmentGroupDao).readNextFulfillmentGroupSequnceForOrder(isNull());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#save(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupDao} {@link FulfillmentGroupDao#save(FulfillmentGroup)}
   *       throw {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupServiceImpl#save(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FulfillmentGroup FulfillmentGroupServiceImpl.save(FulfillmentGroup)"})
  public void testSave_givenFulfillmentGroupDaoSaveThrowIllegalArgumentException() {
    // Arrange
    when(fulfillmentGroupDao.save(Mockito.<FulfillmentGroup>any()))
        .thenThrow(new IllegalArgumentException());

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setAddress(new AddressImpl());
    fulfillmentGroup.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroup.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroup.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroup.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroup.setFulfillmentPrice(new Money());
    fulfillmentGroup.setId(1L);
    fulfillmentGroup.setIsShippingPriceTaxable(true);
    fulfillmentGroup.setMerchandiseTotal(new Money());
    fulfillmentGroup.setMethod("Fulfillment Method");
    fulfillmentGroup.setOrder(new NullOrderImpl());
    fulfillmentGroup.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroup.setPhone(new PhoneImpl());
    fulfillmentGroup.setPrimary(true);
    fulfillmentGroup.setReferenceNumber("42");
    fulfillmentGroup.setRetailFulfillmentPrice(new Money());
    fulfillmentGroup.setSaleFulfillmentPrice(new Money());
    fulfillmentGroup.setService("Service");
    fulfillmentGroup.setShippingOverride(true);
    fulfillmentGroup.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroup.setTaxes(new ArrayList<>());
    fulfillmentGroup.setTotal(new Money());
    fulfillmentGroup.setTotalFeeTax(new Money());
    fulfillmentGroup.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroup.setTotalItemTax(new Money());
    fulfillmentGroup.setTotalTax(new Money());
    fulfillmentGroup.setType(FulfillmentType.DIGITAL);
    fulfillmentGroup.setSequence(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> fulfillmentGroupServiceImpl.save(fulfillmentGroup));
    verify(fulfillmentGroupDao).save(isA(FulfillmentGroup.class));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#save(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Then return {@link FulfillmentGroupImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupServiceImpl#save(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FulfillmentGroup FulfillmentGroupServiceImpl.save(FulfillmentGroup)"})
  public void testSave_thenReturnFulfillmentGroupImpl() {
    // Arrange
    when(fulfillmentGroupDao.readNextFulfillmentGroupSequnceForOrder(Mockito.<Order>any()))
        .thenReturn(1);
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    when(fulfillmentGroupDao.save(Mockito.<FulfillmentGroup>any()))
        .thenReturn(fulfillmentGroupImpl);

    // Act
    FulfillmentGroup actualSaveResult =
        fulfillmentGroupServiceImpl.save(new FulfillmentGroupImpl());

    // Assert
    verify(fulfillmentGroupDao).readNextFulfillmentGroupSequnceForOrder(isNull());
    verify(fulfillmentGroupDao).save(isA(FulfillmentGroup.class));
    assertSame(fulfillmentGroupImpl, actualSaveResult);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#save(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>When {@link FulfillmentGroupImpl} {@link FulfillmentGroupImpl#getSequence()} return one.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupServiceImpl#save(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FulfillmentGroup FulfillmentGroupServiceImpl.save(FulfillmentGroup)"})
  public void testSave_whenFulfillmentGroupImplGetSequenceReturnOne() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    when(fulfillmentGroupDao.save(Mockito.<FulfillmentGroup>any()))
        .thenReturn(fulfillmentGroupImpl);

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
   * Test {@link FulfillmentGroupServiceImpl#createEmptyFulfillmentGroup()}.
   *
   * <ul>
   *   <li>Then return {@link FulfillmentGroupImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupServiceImpl#createEmptyFulfillmentGroup()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FulfillmentGroup FulfillmentGroupServiceImpl.createEmptyFulfillmentGroup()"})
  public void testCreateEmptyFulfillmentGroup_thenReturnFulfillmentGroupImpl() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    when(fulfillmentGroupDao.create()).thenReturn(fulfillmentGroupImpl);

    // Act
    FulfillmentGroup actualCreateEmptyFulfillmentGroupResult =
        fulfillmentGroupServiceImpl.createEmptyFulfillmentGroup();

    // Assert
    verify(fulfillmentGroupDao).create();
    assertSame(fulfillmentGroupImpl, actualCreateEmptyFulfillmentGroupResult);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#createEmptyFulfillmentGroup()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupServiceImpl#createEmptyFulfillmentGroup()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FulfillmentGroup FulfillmentGroupServiceImpl.createEmptyFulfillmentGroup()"})
  public void testCreateEmptyFulfillmentGroup_thenThrowIllegalArgumentException() {
    // Arrange
    when(fulfillmentGroupDao.create()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fulfillmentGroupServiceImpl.createEmptyFulfillmentGroup());
    verify(fulfillmentGroupDao).create();
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#findFulfillmentGroupById(Long)}.
   *
   * <ul>
   *   <li>Then return {@link FulfillmentGroupImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupServiceImpl#findFulfillmentGroupById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FulfillmentGroup FulfillmentGroupServiceImpl.findFulfillmentGroupById(Long)"})
  public void testFindFulfillmentGroupById_thenReturnFulfillmentGroupImpl() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    when(fulfillmentGroupDao.readFulfillmentGroupById(Mockito.<Long>any()))
        .thenReturn(fulfillmentGroupImpl);

    // Act
    FulfillmentGroup actualFindFulfillmentGroupByIdResult =
        fulfillmentGroupServiceImpl.findFulfillmentGroupById(1L);

    // Assert
    verify(fulfillmentGroupDao).readFulfillmentGroupById(1L);
    assertSame(fulfillmentGroupImpl, actualFindFulfillmentGroupByIdResult);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#findFulfillmentGroupById(Long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupServiceImpl#findFulfillmentGroupById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FulfillmentGroup FulfillmentGroupServiceImpl.findFulfillmentGroupById(Long)"})
  public void testFindFulfillmentGroupById_thenThrowIllegalArgumentException() {
    // Arrange
    when(fulfillmentGroupDao.readFulfillmentGroupById(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fulfillmentGroupServiceImpl.findFulfillmentGroupById(1L));
    verify(fulfillmentGroupDao).readFulfillmentGroupById(1L);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#delete(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupDao} {@link FulfillmentGroupDao#delete(FulfillmentGroup)}
   *       does nothing.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupServiceImpl#delete(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupServiceImpl#delete(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupServiceImpl.delete(FulfillmentGroup)"})
  public void testDelete_thenThrowIllegalArgumentException() {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(fulfillmentGroupDao)
        .delete(Mockito.<FulfillmentGroup>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fulfillmentGroupServiceImpl.delete(new FulfillmentGroupImpl()));
    verify(fulfillmentGroupDao).delete(isA(FulfillmentGroup.class));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest,
   * boolean)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupServiceImpl.addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)"
  })
  public void testAddFulfillmentGroupToOrder() throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.create()).thenThrow(new IllegalArgumentException());

    FulfillmentGroupRequest fulfillmentGroupRequest = new FulfillmentGroupRequest();
    fulfillmentGroupRequest.setAddress(new AddressImpl());
    fulfillmentGroupRequest.setFulfillmentGroupItemRequests(new ArrayList<>());
    fulfillmentGroupRequest.setFulfillmentType(FulfillmentType.DIGITAL);
    fulfillmentGroupRequest.setMethod("Method");
    fulfillmentGroupRequest.setOption(new FulfillmentOptionImpl());
    fulfillmentGroupRequest.setOrder(new NullOrderImpl());
    fulfillmentGroupRequest.setPhone(new PhoneImpl());
    fulfillmentGroupRequest.setService("Service");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            fulfillmentGroupServiceImpl.addFulfillmentGroupToOrder(fulfillmentGroupRequest, true));
    verify(fulfillmentGroupDao).create();
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest,
   * boolean)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupServiceImpl.addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)"
  })
  public void testAddFulfillmentGroupToOrder2() throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.create()).thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupItemDao.create()).thenThrow(new IllegalArgumentException());

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest2 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest2.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest2.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest2.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest3 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest3.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest3.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest3.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest3.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest4 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest4.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest4.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest4.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest4.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest5 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest5.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest5.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest5.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest5.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest6 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest6.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest6.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest6.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest6.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest7 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest7.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest7.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest7.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest7.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest8 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest8.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest8.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest8.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest8.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest9 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest9.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest9.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest9.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest9.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest10 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest10.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest10.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest10.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest10.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest11 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest11.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest11.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest11.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest11.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest12 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest12.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest12.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest12.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest12.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest13 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest13.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest13.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest13.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest13.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest14 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest14.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest14.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest14.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest14.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest15 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest15.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest15.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest15.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest15.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest16 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest16.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest16.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest16.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest16.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest17 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest17.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest17.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest17.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest17.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest18 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest18.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest18.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest18.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest18.setQuantity(1);

    ArrayList<FulfillmentGroupItemRequest> fulfillmentGroupItemRequests = new ArrayList<>();
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest2);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest3);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest4);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest5);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest6);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest7);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest8);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest9);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest10);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest11);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest12);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest13);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest14);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest15);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest16);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest17);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest18);

    FulfillmentGroupRequest fulfillmentGroupRequest = new FulfillmentGroupRequest();
    fulfillmentGroupRequest.setAddress(new AddressImpl());
    fulfillmentGroupRequest.setFulfillmentType(FulfillmentType.DIGITAL);
    fulfillmentGroupRequest.setMethod("Method");
    fulfillmentGroupRequest.setOption(new FulfillmentOptionImpl());
    fulfillmentGroupRequest.setOrder(new OrderImpl());
    fulfillmentGroupRequest.setPhone(new PhoneImpl());
    fulfillmentGroupRequest.setService("Service");
    fulfillmentGroupRequest.setFulfillmentGroupItemRequests(fulfillmentGroupItemRequests);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            fulfillmentGroupServiceImpl.addFulfillmentGroupToOrder(fulfillmentGroupRequest, false));
    verify(fulfillmentGroupDao).create();
    verify(fulfillmentGroupItemDao).create();
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest,
   * boolean)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupServiceImpl.addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)"
  })
  public void testAddFulfillmentGroupToOrder3() throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.create()).thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any()))
        .thenThrow(new IllegalArgumentException());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest2 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest2.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest2.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest2.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest3 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest3.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest3.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest3.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest3.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest4 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest4.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest4.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest4.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest4.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest5 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest5.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest5.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest5.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest5.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest6 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest6.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest6.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest6.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest6.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest7 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest7.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest7.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest7.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest7.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest8 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest8.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest8.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest8.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest8.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest9 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest9.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest9.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest9.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest9.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest10 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest10.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest10.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest10.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest10.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest11 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest11.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest11.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest11.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest11.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest12 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest12.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest12.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest12.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest12.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest13 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest13.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest13.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest13.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest13.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest14 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest14.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest14.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest14.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest14.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest15 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest15.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest15.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest15.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest15.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest16 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest16.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest16.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest16.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest16.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest17 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest17.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest17.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest17.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest17.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest18 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest18.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest18.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest18.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest18.setQuantity(1);

    ArrayList<FulfillmentGroupItemRequest> fulfillmentGroupItemRequests = new ArrayList<>();
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest2);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest3);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest4);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest5);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest6);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest7);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest8);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest9);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest10);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest11);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest12);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest13);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest14);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest15);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest16);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest17);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest18);

    FulfillmentGroupRequest fulfillmentGroupRequest = new FulfillmentGroupRequest();
    fulfillmentGroupRequest.setAddress(new AddressImpl());
    fulfillmentGroupRequest.setFulfillmentType(FulfillmentType.DIGITAL);
    fulfillmentGroupRequest.setMethod("Method");
    fulfillmentGroupRequest.setOption(new FulfillmentOptionImpl());
    fulfillmentGroupRequest.setOrder(new OrderImpl());
    fulfillmentGroupRequest.setPhone(new PhoneImpl());
    fulfillmentGroupRequest.setService("Service");
    fulfillmentGroupRequest.setFulfillmentGroupItemRequests(fulfillmentGroupItemRequests);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            fulfillmentGroupServiceImpl.addFulfillmentGroupToOrder(fulfillmentGroupRequest, false));
    verify(fulfillmentGroupDao).create();
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupItemDao).save(isA(FulfillmentGroupItem.class));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest,
   * boolean)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupServiceImpl.addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)"
  })
  public void testAddFulfillmentGroupToOrder4() throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.create()).thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any()))
        .thenReturn(new FulfillmentGroupItemImpl());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any()))
        .thenThrow(new IllegalArgumentException());

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest2 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest2.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest2.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest2.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest3 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest3.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest3.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest3.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest3.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest4 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest4.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest4.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest4.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest4.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest5 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest5.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest5.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest5.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest5.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest6 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest6.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest6.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest6.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest6.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest7 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest7.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest7.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest7.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest7.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest8 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest8.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest8.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest8.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest8.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest9 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest9.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest9.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest9.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest9.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest10 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest10.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest10.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest10.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest10.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest11 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest11.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest11.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest11.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest11.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest12 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest12.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest12.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest12.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest12.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest13 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest13.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest13.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest13.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest13.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest14 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest14.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest14.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest14.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest14.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest15 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest15.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest15.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest15.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest15.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest16 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest16.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest16.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest16.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest16.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest17 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest17.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest17.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest17.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest17.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest18 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest18.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest18.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest18.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest18.setQuantity(1);

    ArrayList<FulfillmentGroupItemRequest> fulfillmentGroupItemRequests = new ArrayList<>();
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest2);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest3);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest4);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest5);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest6);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest7);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest8);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest9);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest10);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest11);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest12);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest13);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest14);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest15);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest16);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest17);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest18);

    FulfillmentGroupRequest fulfillmentGroupRequest = new FulfillmentGroupRequest();
    fulfillmentGroupRequest.setAddress(new AddressImpl());
    fulfillmentGroupRequest.setFulfillmentType(FulfillmentType.DIGITAL);
    fulfillmentGroupRequest.setMethod("Method");
    fulfillmentGroupRequest.setOption(new FulfillmentOptionImpl());
    fulfillmentGroupRequest.setOrder(new OrderImpl());
    fulfillmentGroupRequest.setPhone(new PhoneImpl());
    fulfillmentGroupRequest.setService("Service");
    fulfillmentGroupRequest.setFulfillmentGroupItemRequests(fulfillmentGroupItemRequests);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            fulfillmentGroupServiceImpl.addFulfillmentGroupToOrder(fulfillmentGroupRequest, false));
    verify(fulfillmentGroupDao).create();
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupItemDao).save(isA(FulfillmentGroupItem.class));
    verify(orderService).save(isA(Order.class), eq(false));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest,
   * boolean)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then Order return {@link NullOrderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupServiceImpl.addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)"
  })
  public void testAddFulfillmentGroupToOrder_givenArrayList_thenOrderReturnNullOrderImpl()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.create()).thenReturn(new FulfillmentGroupImpl());

    FulfillmentGroupRequest fulfillmentGroupRequest = new FulfillmentGroupRequest();
    fulfillmentGroupRequest.setAddress(new AddressImpl());
    fulfillmentGroupRequest.setFulfillmentGroupItemRequests(new ArrayList<>());
    fulfillmentGroupRequest.setFulfillmentType(FulfillmentType.DIGITAL);
    fulfillmentGroupRequest.setMethod("Method");
    fulfillmentGroupRequest.setOption(new FulfillmentOptionImpl());
    NullOrderImpl order = new NullOrderImpl();
    fulfillmentGroupRequest.setOrder(order);
    fulfillmentGroupRequest.setPhone(new PhoneImpl());
    fulfillmentGroupRequest.setService("Service");

    // Act
    FulfillmentGroup actualAddFulfillmentGroupToOrderResult =
        fulfillmentGroupServiceImpl.addFulfillmentGroupToOrder(fulfillmentGroupRequest, true);

    // Assert
    verify(fulfillmentGroupDao).create();
    assertTrue(actualAddFulfillmentGroupToOrderResult instanceof FulfillmentGroupImpl);
    Order order2 = actualAddFulfillmentGroupToOrderResult.getOrder();
    assertTrue(order2 instanceof NullOrderImpl);
    assertTrue(actualAddFulfillmentGroupToOrderResult.getFulfillmentGroupItems().isEmpty());
    assertSame(order, order2);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest,
   * boolean)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link FulfillmentGroupRequest} (default constructor) Order is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupServiceImpl.addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)"
  })
  public void testAddFulfillmentGroupToOrder_givenNull_whenFulfillmentGroupRequestOrderIsNull()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.create()).thenReturn(new FulfillmentGroupImpl());

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest2 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest2.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest2.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest2.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest3 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest3.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest3.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest3.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest3.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest4 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest4.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest4.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest4.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest4.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest5 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest5.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest5.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest5.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest5.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest6 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest6.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest6.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest6.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest6.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest7 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest7.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest7.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest7.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest7.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest8 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest8.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest8.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest8.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest8.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest9 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest9.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest9.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest9.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest9.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest10 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest10.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest10.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest10.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest10.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest11 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest11.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest11.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest11.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest11.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest12 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest12.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest12.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest12.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest12.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest13 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest13.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest13.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest13.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest13.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest14 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest14.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest14.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest14.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest14.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest15 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest15.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest15.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest15.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest15.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest16 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest16.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest16.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest16.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest16.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest17 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest17.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest17.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest17.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest17.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest18 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest18.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest18.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest18.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest18.setQuantity(1);

    ArrayList<FulfillmentGroupItemRequest> fulfillmentGroupItemRequests = new ArrayList<>();
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest2);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest3);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest4);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest5);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest6);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest7);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest8);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest9);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest10);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest11);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest12);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest13);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest14);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest15);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest16);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest17);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest18);

    FulfillmentGroupRequest fulfillmentGroupRequest = new FulfillmentGroupRequest();
    fulfillmentGroupRequest.setAddress(new AddressImpl());
    fulfillmentGroupRequest.setFulfillmentType(FulfillmentType.DIGITAL);
    fulfillmentGroupRequest.setMethod("Method");
    fulfillmentGroupRequest.setOption(new FulfillmentOptionImpl());
    fulfillmentGroupRequest.setOrder(null);
    fulfillmentGroupRequest.setPhone(new PhoneImpl());
    fulfillmentGroupRequest.setService("Service");
    fulfillmentGroupRequest.setFulfillmentGroupItemRequests(fulfillmentGroupItemRequests);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            fulfillmentGroupServiceImpl.addFulfillmentGroupToOrder(fulfillmentGroupRequest, false));
    verify(fulfillmentGroupDao).create();
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest,
   * boolean)}.
   *
   * <ul>
   *   <li>Then Order return {@link OrderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupServiceImpl.addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)"
  })
  public void testAddFulfillmentGroupToOrder_thenOrderReturnOrderImpl() throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.create()).thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any()))
        .thenReturn(new FulfillmentGroupItemImpl());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any()))
        .thenReturn(new NullOrderImpl());

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest2 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest2.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest2.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest2.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest3 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest3.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest3.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest3.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest3.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest4 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest4.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest4.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest4.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest4.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest5 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest5.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest5.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest5.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest5.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest6 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest6.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest6.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest6.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest6.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest7 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest7.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest7.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest7.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest7.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest8 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest8.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest8.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest8.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest8.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest9 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest9.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest9.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest9.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest9.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest10 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest10.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest10.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest10.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest10.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest11 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest11.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest11.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest11.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest11.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest12 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest12.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest12.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest12.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest12.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest13 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest13.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest13.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest13.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest13.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest14 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest14.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest14.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest14.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest14.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest15 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest15.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest15.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest15.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest15.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest16 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest16.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest16.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest16.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest16.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest17 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest17.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest17.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest17.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest17.setQuantity(1);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest18 = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest18.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest18.setOrder(new NullOrderImpl());
    fulfillmentGroupItemRequest18.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest18.setQuantity(1);

    ArrayList<FulfillmentGroupItemRequest> fulfillmentGroupItemRequests = new ArrayList<>();
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest2);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest3);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest4);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest5);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest6);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest7);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest8);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest9);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest10);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest11);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest12);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest13);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest14);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest15);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest16);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest17);
    fulfillmentGroupItemRequests.add(fulfillmentGroupItemRequest18);

    FulfillmentGroupRequest fulfillmentGroupRequest = new FulfillmentGroupRequest();
    fulfillmentGroupRequest.setAddress(new AddressImpl());
    fulfillmentGroupRequest.setFulfillmentType(FulfillmentType.DIGITAL);
    fulfillmentGroupRequest.setMethod("Method");
    fulfillmentGroupRequest.setOption(new FulfillmentOptionImpl());
    OrderImpl order = new OrderImpl();
    fulfillmentGroupRequest.setOrder(order);
    fulfillmentGroupRequest.setPhone(new PhoneImpl());
    fulfillmentGroupRequest.setService("Service");
    fulfillmentGroupRequest.setFulfillmentGroupItemRequests(fulfillmentGroupItemRequests);

    // Act
    FulfillmentGroup actualAddFulfillmentGroupToOrderResult =
        fulfillmentGroupServiceImpl.addFulfillmentGroupToOrder(fulfillmentGroupRequest, false);

    // Assert
    verify(fulfillmentGroupDao).create();
    verify(fulfillmentGroupItemDao, atLeast(1)).create();
    verify(fulfillmentGroupItemDao, atLeast(1)).save(isA(FulfillmentGroupItem.class));
    verify(orderService, atLeast(1)).save(isA(Order.class), eq(false));
    assertTrue(actualAddFulfillmentGroupToOrderResult instanceof FulfillmentGroupImpl);
    Order order2 = actualAddFulfillmentGroupToOrderResult.getOrder();
    assertTrue(order2 instanceof OrderImpl);
    assertEquals(18, actualAddFulfillmentGroupToOrderResult.getFulfillmentGroupItems().size());
    assertSame(order, order2);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest,
   * boolean)}.
   *
   * <ul>
   *   <li>Then return Type is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupServiceImpl.addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)"
  })
  public void testAddFulfillmentGroupToOrder_thenReturnTypeIsNull() throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.create()).thenReturn(new FulfillmentGroupImpl());

    FulfillmentGroupRequest fulfillmentGroupRequest = new FulfillmentGroupRequest();
    fulfillmentGroupRequest.setAddress(new AddressImpl());
    fulfillmentGroupRequest.setFulfillmentGroupItemRequests(new ArrayList<>());
    fulfillmentGroupRequest.setFulfillmentType(null);
    fulfillmentGroupRequest.setMethod("Method");
    fulfillmentGroupRequest.setOption(new FulfillmentOptionImpl());
    NullOrderImpl order = new NullOrderImpl();
    fulfillmentGroupRequest.setOrder(order);
    fulfillmentGroupRequest.setPhone(new PhoneImpl());
    fulfillmentGroupRequest.setService("Service");

    // Act
    FulfillmentGroup actualAddFulfillmentGroupToOrderResult =
        fulfillmentGroupServiceImpl.addFulfillmentGroupToOrder(fulfillmentGroupRequest, true);

    // Assert
    verify(fulfillmentGroupDao).create();
    assertTrue(actualAddFulfillmentGroupToOrderResult instanceof FulfillmentGroupImpl);
    Order order2 = actualAddFulfillmentGroupToOrderResult.getOrder();
    assertTrue(order2 instanceof NullOrderImpl);
    assertNull(actualAddFulfillmentGroupToOrderResult.getType());
    assertTrue(actualAddFulfillmentGroupToOrderResult.getFulfillmentGroupItems().isEmpty());
    assertSame(order, order2);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest,
   * boolean)} with {@code fulfillmentGroupItemRequest}, {@code priceOrder}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupServiceImpl.addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithFulfillmentGroupItemRequestPriceOrder()
      throws PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(1L);
    orderItem.setName("Name");
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setPrice(new Money());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setOrder(null);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest.setQuantity(1);
    fulfillmentGroupItemRequest.setOrder(null);
    fulfillmentGroupItemRequest.setOrderItem(orderItem);
    fulfillmentGroupItemRequest.setFulfillmentGroup(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            fulfillmentGroupServiceImpl.addItemToFulfillmentGroup(
                fulfillmentGroupItemRequest, false));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest,
   * boolean)} with {@code fulfillmentGroupItemRequest}, {@code priceOrder}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupServiceImpl.addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithFulfillmentGroupItemRequestPriceOrder2()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupItemDao.create()).thenThrow(new IllegalArgumentException());

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

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest.setOrder(order);
    fulfillmentGroupItemRequest.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest.setQuantity(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            fulfillmentGroupServiceImpl.addItemToFulfillmentGroup(
                fulfillmentGroupItemRequest, true));
    verify(fulfillmentGroupItemDao).create();
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest,
   * boolean)} with {@code fulfillmentGroupItemRequest}, {@code priceOrder}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupServiceImpl.addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithFulfillmentGroupItemRequestPriceOrder3()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any()))
        .thenThrow(new IllegalArgumentException());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());

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

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest.setOrder(order);
    fulfillmentGroupItemRequest.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest.setQuantity(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            fulfillmentGroupServiceImpl.addItemToFulfillmentGroup(
                fulfillmentGroupItemRequest, true));
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupItemDao).save(isA(FulfillmentGroupItem.class));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest,
   * boolean)} with {@code fulfillmentGroupItemRequest}, {@code priceOrder}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupServiceImpl.addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithFulfillmentGroupItemRequestPriceOrder4()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any()))
        .thenReturn(new FulfillmentGroupItemImpl());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any()))
        .thenReturn(new NullOrderImpl());

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

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = new FulfillmentGroupItemRequest();
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroupItemRequest.setFulfillmentGroup(fulfillmentGroup);
    fulfillmentGroupItemRequest.setOrder(order);
    fulfillmentGroupItemRequest.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest.setQuantity(1);

    // Act
    FulfillmentGroup actualAddItemToFulfillmentGroupResult =
        fulfillmentGroupServiceImpl.addItemToFulfillmentGroup(fulfillmentGroupItemRequest, true);

    // Assert
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupItemDao).save(isA(FulfillmentGroupItem.class));
    verify(orderService).save(isA(Order.class), eq(true));
    assertSame(fulfillmentGroup, actualAddItemToFulfillmentGroupResult);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest,
   * boolean)} with {@code fulfillmentGroupItemRequest}, {@code priceOrder}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupServiceImpl.addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithFulfillmentGroupItemRequestPriceOrder5()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any()))
        .thenReturn(new FulfillmentGroupItemImpl());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any()))
        .thenThrow(new IllegalArgumentException());

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

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest.setOrder(order);
    fulfillmentGroupItemRequest.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest.setQuantity(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            fulfillmentGroupServiceImpl.addItemToFulfillmentGroup(
                fulfillmentGroupItemRequest, true));
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupItemDao).save(isA(FulfillmentGroupItem.class));
    verify(orderService).save(isA(Order.class), eq(true));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest,
   * boolean)} with {@code fulfillmentGroupItemRequest}, {@code priceOrder}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupServiceImpl.addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithFulfillmentGroupItemRequestPriceOrder6()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.create()).thenThrow(new IllegalArgumentException());

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

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest.setFulfillmentGroup(null);
    fulfillmentGroupItemRequest.setOrder(order);
    fulfillmentGroupItemRequest.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest.setQuantity(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            fulfillmentGroupServiceImpl.addItemToFulfillmentGroup(
                fulfillmentGroupItemRequest, true));
    verify(fulfillmentGroupDao).create();
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest,
   * boolean)} with {@code fulfillmentGroupItemRequest}, {@code priceOrder}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupServiceImpl.addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithFulfillmentGroupItemRequestPriceOrder7()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.readNextFulfillmentGroupSequnceForOrder(Mockito.<Order>any()))
        .thenReturn(1);
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    when(fulfillmentGroupDao.save(Mockito.<FulfillmentGroup>any()))
        .thenReturn(fulfillmentGroupImpl);
    when(fulfillmentGroupDao.create()).thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any()))
        .thenReturn(new FulfillmentGroupItemImpl());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any()))
        .thenReturn(new NullOrderImpl());

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

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest.setFulfillmentGroup(null);
    fulfillmentGroupItemRequest.setOrder(order);
    fulfillmentGroupItemRequest.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest.setQuantity(1);

    // Act
    FulfillmentGroup actualAddItemToFulfillmentGroupResult =
        fulfillmentGroupServiceImpl.addItemToFulfillmentGroup(fulfillmentGroupItemRequest, true);

    // Assert
    verify(fulfillmentGroupDao, atLeast(1)).create();
    verify(fulfillmentGroupDao).readNextFulfillmentGroupSequnceForOrder(isA(Order.class));
    verify(fulfillmentGroupDao).save(isA(FulfillmentGroup.class));
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupItemDao).save(isA(FulfillmentGroupItem.class));
    verify(orderService).save(isA(Order.class), eq(true));
    assertSame(fulfillmentGroupImpl, actualAddItemToFulfillmentGroupResult);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest,
   * boolean)} with {@code fulfillmentGroupItemRequest}, {@code priceOrder}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupServiceImpl.addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithFulfillmentGroupItemRequestPriceOrder8()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.readNextFulfillmentGroupSequnceForOrder(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException());
    when(fulfillmentGroupDao.create()).thenReturn(new FulfillmentGroupImpl());

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

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest.setFulfillmentGroup(null);
    fulfillmentGroupItemRequest.setOrder(order);
    fulfillmentGroupItemRequest.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest.setQuantity(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            fulfillmentGroupServiceImpl.addItemToFulfillmentGroup(
                fulfillmentGroupItemRequest, true));
    verify(fulfillmentGroupDao, atLeast(1)).create();
    verify(fulfillmentGroupDao).readNextFulfillmentGroupSequnceForOrder(isA(Order.class));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest,
   * boolean)} with {@code fulfillmentGroupItemRequest}, {@code priceOrder}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupServiceImpl.addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithFulfillmentGroupItemRequestPriceOrder9()
      throws PricingException {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getSequence()).thenReturn(1);
    doNothing().when(fulfillmentGroupImpl).setAddress(Mockito.<Address>any());
    doNothing().when(fulfillmentGroupImpl).setFulfillmentOption(Mockito.<FulfillmentOption>any());
    doNothing().when(fulfillmentGroupImpl).setOrder(Mockito.<Order>any());
    doNothing().when(fulfillmentGroupImpl).setPhone(Mockito.<Phone>any());
    doNothing().when(fulfillmentGroupImpl).setType(Mockito.<FulfillmentType>any());
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    when(fulfillmentGroupDao.save(Mockito.<FulfillmentGroup>any()))
        .thenReturn(fulfillmentGroupImpl2);
    when(fulfillmentGroupDao.create()).thenReturn(fulfillmentGroupImpl);
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any()))
        .thenReturn(new FulfillmentGroupItemImpl());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any()))
        .thenReturn(new NullOrderImpl());

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

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest.setFulfillmentGroup(null);
    fulfillmentGroupItemRequest.setOrder(order);
    fulfillmentGroupItemRequest.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest.setQuantity(1);

    // Act
    FulfillmentGroup actualAddItemToFulfillmentGroupResult =
        fulfillmentGroupServiceImpl.addItemToFulfillmentGroup(fulfillmentGroupItemRequest, true);

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
    assertSame(fulfillmentGroupImpl2, actualAddItemToFulfillmentGroupResult);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest,
   * boolean)} with {@code fulfillmentGroupItemRequest}, {@code priceOrder}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupServiceImpl.addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithFulfillmentGroupItemRequestPriceOrder10()
      throws PricingException {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getSequence()).thenReturn(1);
    doNothing().when(fulfillmentGroupImpl).setAddress(Mockito.<Address>any());
    doNothing().when(fulfillmentGroupImpl).setFulfillmentOption(Mockito.<FulfillmentOption>any());
    doNothing().when(fulfillmentGroupImpl).setOrder(Mockito.<Order>any());
    doNothing().when(fulfillmentGroupImpl).setPhone(Mockito.<Phone>any());
    doNothing().when(fulfillmentGroupImpl).setType(Mockito.<FulfillmentType>any());
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    when(fulfillmentGroupDao.save(Mockito.<FulfillmentGroup>any()))
        .thenReturn(fulfillmentGroupImpl2);
    when(fulfillmentGroupDao.create()).thenReturn(fulfillmentGroupImpl);
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any()))
        .thenReturn(new FulfillmentGroupItemImpl());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any()))
        .thenReturn(new NullOrderImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest.setFulfillmentGroup(null);
    fulfillmentGroupItemRequest.setOrder(order);
    fulfillmentGroupItemRequest.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest.setQuantity(1);

    // Act
    FulfillmentGroup actualAddItemToFulfillmentGroupResult =
        fulfillmentGroupServiceImpl.addItemToFulfillmentGroup(fulfillmentGroupItemRequest, true);

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
    assertSame(fulfillmentGroupImpl2, actualAddItemToFulfillmentGroupResult);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest,
   * boolean)} with {@code fulfillmentGroupItemRequest}, {@code priceOrder}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupServiceImpl.addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithFulfillmentGroupItemRequestPriceOrder11()
      throws PricingException {
    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenThrow(new IllegalArgumentException());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(1L);
    orderItem.setName("Name");
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setPrice(new Money());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setOrder(null);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest.setQuantity(1);
    fulfillmentGroupItemRequest.setOrder(order);
    fulfillmentGroupItemRequest.setOrderItem(orderItem);
    fulfillmentGroupItemRequest.setFulfillmentGroup(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            fulfillmentGroupServiceImpl.addItemToFulfillmentGroup(
                fulfillmentGroupItemRequest, false));
    verify(order).getFulfillmentGroups();
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest,
   * boolean)} with {@code fulfillmentGroupItemRequest}, {@code priceOrder}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupServiceImpl.addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithFulfillmentGroupItemRequestPriceOrder12()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.create()).thenThrow(new IllegalArgumentException());

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

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupItems.add(fulfillmentGroupItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(1L);
    orderItem.setName("Name");
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setPrice(new Money());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setOrder(order);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest.setQuantity(1);
    fulfillmentGroupItemRequest.setOrder(null);
    fulfillmentGroupItemRequest.setOrderItem(orderItem);
    fulfillmentGroupItemRequest.setFulfillmentGroup(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            fulfillmentGroupServiceImpl.addItemToFulfillmentGroup(
                fulfillmentGroupItemRequest, false));
    verify(fulfillmentGroupDao).create();
    verify(fulfillmentGroupItemImpl).getOrderItem();
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest,
   * boolean, boolean)} with {@code fulfillmentGroupItemRequest}, {@code priceOrder}, {@code save}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupServiceImpl.addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithFulfillmentGroupItemRequestPriceOrderSave()
      throws PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(1L);
    orderItem.setName("Name");
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setPrice(new Money());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setOrder(null);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest.setQuantity(1);
    fulfillmentGroupItemRequest.setOrder(null);
    fulfillmentGroupItemRequest.setOrderItem(orderItem);
    fulfillmentGroupItemRequest.setFulfillmentGroup(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            fulfillmentGroupServiceImpl.addItemToFulfillmentGroup(
                fulfillmentGroupItemRequest, false, false));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest,
   * boolean, boolean)} with {@code fulfillmentGroupItemRequest}, {@code priceOrder}, {@code save}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupServiceImpl.addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithFulfillmentGroupItemRequestPriceOrderSave2()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupItemDao.create()).thenThrow(new IllegalArgumentException());

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

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest.setOrder(order);
    fulfillmentGroupItemRequest.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest.setQuantity(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            fulfillmentGroupServiceImpl.addItemToFulfillmentGroup(
                fulfillmentGroupItemRequest, true, true));
    verify(fulfillmentGroupItemDao).create();
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest,
   * boolean, boolean)} with {@code fulfillmentGroupItemRequest}, {@code priceOrder}, {@code save}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupServiceImpl.addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithFulfillmentGroupItemRequestPriceOrderSave3()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any()))
        .thenThrow(new IllegalArgumentException());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());

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

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest.setOrder(order);
    fulfillmentGroupItemRequest.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest.setQuantity(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            fulfillmentGroupServiceImpl.addItemToFulfillmentGroup(
                fulfillmentGroupItemRequest, true, true));
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupItemDao).save(isA(FulfillmentGroupItem.class));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest,
   * boolean, boolean)} with {@code fulfillmentGroupItemRequest}, {@code priceOrder}, {@code save}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupServiceImpl.addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithFulfillmentGroupItemRequestPriceOrderSave4()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any()))
        .thenReturn(new FulfillmentGroupItemImpl());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any()))
        .thenReturn(new NullOrderImpl());

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

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = new FulfillmentGroupItemRequest();
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroupItemRequest.setFulfillmentGroup(fulfillmentGroup);
    fulfillmentGroupItemRequest.setOrder(order);
    fulfillmentGroupItemRequest.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest.setQuantity(1);

    // Act
    FulfillmentGroup actualAddItemToFulfillmentGroupResult =
        fulfillmentGroupServiceImpl.addItemToFulfillmentGroup(
            fulfillmentGroupItemRequest, true, true);

    // Assert
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupItemDao).save(isA(FulfillmentGroupItem.class));
    verify(orderService).save(isA(Order.class), eq(true));
    assertSame(fulfillmentGroup, actualAddItemToFulfillmentGroupResult);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest,
   * boolean, boolean)} with {@code fulfillmentGroupItemRequest}, {@code priceOrder}, {@code save}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupServiceImpl.addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithFulfillmentGroupItemRequestPriceOrderSave5()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any()))
        .thenReturn(new FulfillmentGroupItemImpl());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any()))
        .thenThrow(new IllegalArgumentException());

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

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemRequest.setOrder(order);
    fulfillmentGroupItemRequest.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest.setQuantity(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            fulfillmentGroupServiceImpl.addItemToFulfillmentGroup(
                fulfillmentGroupItemRequest, true, true));
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupItemDao).save(isA(FulfillmentGroupItem.class));
    verify(orderService).save(isA(Order.class), eq(true));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest,
   * boolean, boolean)} with {@code fulfillmentGroupItemRequest}, {@code priceOrder}, {@code save}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupServiceImpl.addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithFulfillmentGroupItemRequestPriceOrderSave6()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.create()).thenThrow(new IllegalArgumentException());

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

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest.setFulfillmentGroup(null);
    fulfillmentGroupItemRequest.setOrder(order);
    fulfillmentGroupItemRequest.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest.setQuantity(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            fulfillmentGroupServiceImpl.addItemToFulfillmentGroup(
                fulfillmentGroupItemRequest, true, true));
    verify(fulfillmentGroupDao).create();
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest,
   * boolean, boolean)} with {@code fulfillmentGroupItemRequest}, {@code priceOrder}, {@code save}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupServiceImpl.addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithFulfillmentGroupItemRequestPriceOrderSave7()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.readNextFulfillmentGroupSequnceForOrder(Mockito.<Order>any()))
        .thenReturn(1);
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    when(fulfillmentGroupDao.save(Mockito.<FulfillmentGroup>any()))
        .thenReturn(fulfillmentGroupImpl);
    when(fulfillmentGroupDao.create()).thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any()))
        .thenReturn(new FulfillmentGroupItemImpl());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any()))
        .thenReturn(new NullOrderImpl());

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

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest.setFulfillmentGroup(null);
    fulfillmentGroupItemRequest.setOrder(order);
    fulfillmentGroupItemRequest.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest.setQuantity(1);

    // Act
    FulfillmentGroup actualAddItemToFulfillmentGroupResult =
        fulfillmentGroupServiceImpl.addItemToFulfillmentGroup(
            fulfillmentGroupItemRequest, true, true);

    // Assert
    verify(fulfillmentGroupDao, atLeast(1)).create();
    verify(fulfillmentGroupDao).readNextFulfillmentGroupSequnceForOrder(isA(Order.class));
    verify(fulfillmentGroupDao).save(isA(FulfillmentGroup.class));
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupItemDao).save(isA(FulfillmentGroupItem.class));
    verify(orderService).save(isA(Order.class), eq(true));
    assertSame(fulfillmentGroupImpl, actualAddItemToFulfillmentGroupResult);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest,
   * boolean, boolean)} with {@code fulfillmentGroupItemRequest}, {@code priceOrder}, {@code save}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupServiceImpl.addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithFulfillmentGroupItemRequestPriceOrderSave8()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.readNextFulfillmentGroupSequnceForOrder(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException());
    when(fulfillmentGroupDao.create()).thenReturn(new FulfillmentGroupImpl());

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

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest.setFulfillmentGroup(null);
    fulfillmentGroupItemRequest.setOrder(order);
    fulfillmentGroupItemRequest.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest.setQuantity(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            fulfillmentGroupServiceImpl.addItemToFulfillmentGroup(
                fulfillmentGroupItemRequest, true, true));
    verify(fulfillmentGroupDao, atLeast(1)).create();
    verify(fulfillmentGroupDao).readNextFulfillmentGroupSequnceForOrder(isA(Order.class));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest,
   * boolean, boolean)} with {@code fulfillmentGroupItemRequest}, {@code priceOrder}, {@code save}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupServiceImpl.addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithFulfillmentGroupItemRequestPriceOrderSave9()
      throws PricingException {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getSequence()).thenReturn(1);
    doNothing().when(fulfillmentGroupImpl).setAddress(Mockito.<Address>any());
    doNothing().when(fulfillmentGroupImpl).setFulfillmentOption(Mockito.<FulfillmentOption>any());
    doNothing().when(fulfillmentGroupImpl).setOrder(Mockito.<Order>any());
    doNothing().when(fulfillmentGroupImpl).setPhone(Mockito.<Phone>any());
    doNothing().when(fulfillmentGroupImpl).setType(Mockito.<FulfillmentType>any());
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    when(fulfillmentGroupDao.save(Mockito.<FulfillmentGroup>any()))
        .thenReturn(fulfillmentGroupImpl2);
    when(fulfillmentGroupDao.create()).thenReturn(fulfillmentGroupImpl);
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any()))
        .thenReturn(new FulfillmentGroupItemImpl());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any()))
        .thenReturn(new NullOrderImpl());

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

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest.setFulfillmentGroup(null);
    fulfillmentGroupItemRequest.setOrder(order);
    fulfillmentGroupItemRequest.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest.setQuantity(1);

    // Act
    FulfillmentGroup actualAddItemToFulfillmentGroupResult =
        fulfillmentGroupServiceImpl.addItemToFulfillmentGroup(
            fulfillmentGroupItemRequest, true, true);

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
    assertSame(fulfillmentGroupImpl2, actualAddItemToFulfillmentGroupResult);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest,
   * boolean, boolean)} with {@code fulfillmentGroupItemRequest}, {@code priceOrder}, {@code save}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupServiceImpl.addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithFulfillmentGroupItemRequestPriceOrderSave10()
      throws PricingException {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getSequence()).thenReturn(1);
    doNothing().when(fulfillmentGroupImpl).setAddress(Mockito.<Address>any());
    doNothing().when(fulfillmentGroupImpl).setFulfillmentOption(Mockito.<FulfillmentOption>any());
    doNothing().when(fulfillmentGroupImpl).setOrder(Mockito.<Order>any());
    doNothing().when(fulfillmentGroupImpl).setPhone(Mockito.<Phone>any());
    doNothing().when(fulfillmentGroupImpl).setType(Mockito.<FulfillmentType>any());
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    when(fulfillmentGroupDao.save(Mockito.<FulfillmentGroup>any()))
        .thenReturn(fulfillmentGroupImpl2);
    when(fulfillmentGroupDao.create()).thenReturn(fulfillmentGroupImpl);
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any()))
        .thenReturn(new FulfillmentGroupItemImpl());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any()))
        .thenReturn(new NullOrderImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest.setFulfillmentGroup(null);
    fulfillmentGroupItemRequest.setOrder(order);
    fulfillmentGroupItemRequest.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest.setQuantity(1);

    // Act
    FulfillmentGroup actualAddItemToFulfillmentGroupResult =
        fulfillmentGroupServiceImpl.addItemToFulfillmentGroup(
            fulfillmentGroupItemRequest, true, true);

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
    assertSame(fulfillmentGroupImpl2, actualAddItemToFulfillmentGroupResult);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest,
   * boolean, boolean)} with {@code fulfillmentGroupItemRequest}, {@code priceOrder}, {@code save}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupServiceImpl.addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithFulfillmentGroupItemRequestPriceOrderSave11()
      throws PricingException {
    // Arrange
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

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest.setFulfillmentGroup(null);
    fulfillmentGroupItemRequest.setOrder(order);
    fulfillmentGroupItemRequest.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemRequest.setQuantity(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            fulfillmentGroupServiceImpl.addItemToFulfillmentGroup(
                fulfillmentGroupItemRequest, true, false));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest,
   * boolean, boolean)} with {@code fulfillmentGroupItemRequest}, {@code priceOrder}, {@code save}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupServiceImpl.addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean, boolean)"
  })
  public void testAddItemToFulfillmentGroupWithFulfillmentGroupItemRequestPriceOrderSave12()
      throws PricingException {
    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenThrow(new IllegalArgumentException());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(1L);
    orderItem.setName("Name");
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setPrice(new Money());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setOrder(null);

    FulfillmentGroupItemRequest fulfillmentGroupItemRequest = new FulfillmentGroupItemRequest();
    fulfillmentGroupItemRequest.setQuantity(1);
    fulfillmentGroupItemRequest.setOrder(order);
    fulfillmentGroupItemRequest.setOrderItem(orderItem);
    fulfillmentGroupItemRequest.setFulfillmentGroup(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            fulfillmentGroupServiceImpl.addItemToFulfillmentGroup(
                fulfillmentGroupItemRequest, false, false));
    verify(order).getFulfillmentGroups();
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#getFulfillmentGroupItemsForOrderItem(Order,
   * OrderItem)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#getFulfillmentGroupItemsForOrderItem(Order, OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FulfillmentGroupServiceImpl.getFulfillmentGroupItemsForOrderItem(Order, OrderItem)"
  })
  public void testGetFulfillmentGroupItemsForOrderItem() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(new DiscreteOrderItemImpl());

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupItems.add(fulfillmentGroupItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(new DiscreteOrderItemImpl());

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable2);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
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
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setPrice(new Money());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setDiscreteOrderItems(discreteOrderItems);

    // Act
    List<FulfillmentGroupItem> actualFulfillmentGroupItemsForOrderItem =
        fulfillmentGroupServiceImpl.getFulfillmentGroupItemsForOrderItem(order, orderItem);

    // Assert
    verify(fulfillmentGroupItemImpl, atLeast(1)).getOrderItem();
    assertEquals(1, actualFulfillmentGroupItemsForOrderItem.size());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#getFulfillmentGroupItemsForOrderItem(Order,
   * OrderItem)}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Auditable is {@link Auditable} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#getFulfillmentGroupItemsForOrderItem(Order, OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FulfillmentGroupServiceImpl.getFulfillmentGroupItemsForOrderItem(Order, OrderItem)"
  })
  public void testGetFulfillmentGroupItemsForOrderItem_givenOrderItemImplAuditableIsAuditable() {
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
    orderItemImpl.setPrice(new Money());
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(orderItemImpl);

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupItems.add(fulfillmentGroupItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    Auditable auditable3 = new Auditable();
    auditable3.setCreatedBy(1L);
    auditable3.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setUpdatedBy(1L);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(new DiscreteOrderItemImpl());

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable3);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
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
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setPrice(new Money());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setDiscreteOrderItems(discreteOrderItems);

    // Act
    List<FulfillmentGroupItem> actualFulfillmentGroupItemsForOrderItem =
        fulfillmentGroupServiceImpl.getFulfillmentGroupItemsForOrderItem(order, orderItem);

    // Assert
    verify(fulfillmentGroupItemImpl).getOrderItem();
    assertEquals(1, actualFulfillmentGroupItemsForOrderItem.size());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#getFulfillmentGroupItemsForOrderItem(Order,
   * OrderItem)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#getFulfillmentGroupItemsForOrderItem(Order, OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FulfillmentGroupServiceImpl.getFulfillmentGroupItemsForOrderItem(Order, OrderItem)"
  })
  public void testGetFulfillmentGroupItemsForOrderItem_thenReturnEmpty() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupItems.add(fulfillmentGroupItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(new DiscreteOrderItemImpl());

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable2);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
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
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setPrice(new Money());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setDiscreteOrderItems(discreteOrderItems);

    // Act
    List<FulfillmentGroupItem> actualFulfillmentGroupItemsForOrderItem =
        fulfillmentGroupServiceImpl.getFulfillmentGroupItemsForOrderItem(order, orderItem);

    // Assert
    verify(fulfillmentGroupItemImpl, atLeast(1)).getOrderItem();
    assertTrue(actualFulfillmentGroupItemsForOrderItem.isEmpty());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#removeOrderItemFromFullfillmentGroups(Order,
   * OrderItem)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#removeOrderItemFromFullfillmentGroups(Order, OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FulfillmentGroupServiceImpl.removeOrderItemFromFullfillmentGroups(Order, OrderItem)"
  })
  public void testRemoveOrderItemFromFullfillmentGroups() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupItems.add(fulfillmentGroupItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(new DiscreteOrderItemImpl());

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable2);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
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
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setPrice(new Money());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setDiscreteOrderItems(discreteOrderItems);

    // Act
    fulfillmentGroupServiceImpl.removeOrderItemFromFullfillmentGroups(order, orderItem);

    // Assert that nothing has changed
    verify(fulfillmentGroupItemImpl, atLeast(1)).getOrderItem();
    List<FulfillmentGroup> fulfillmentGroups2 = order.getFulfillmentGroups();
    assertEquals(1, fulfillmentGroups2.size());
    FulfillmentGroup getResult = fulfillmentGroups2.get(0);
    assertTrue(getResult instanceof FulfillmentGroupImpl);
    List<FulfillmentGroupItem> fulfillmentGroupItems2 = getResult.getFulfillmentGroupItems();
    assertEquals(1, fulfillmentGroupItems2.size());
    assertTrue(getResult.getDiscreteOrderItems().isEmpty());
    assertSame(fulfillmentGroupItems, fulfillmentGroupItems2);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#removeOrderItemFromFullfillmentGroups(Order,
   * OrderItem)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#removeOrderItemFromFullfillmentGroups(Order, OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FulfillmentGroupServiceImpl.removeOrderItemFromFullfillmentGroups(Order, OrderItem)"
  })
  public void testRemoveOrderItemFromFullfillmentGroups2() {
    // Arrange
    doNothing().when(fulfillmentGroupItemDao).delete(Mockito.<FulfillmentGroupItem>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(new DiscreteOrderItemImpl());

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupItems.add(fulfillmentGroupItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(new DiscreteOrderItemImpl());

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable2);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
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
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setPrice(new Money());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setDiscreteOrderItems(discreteOrderItems);

    // Act
    fulfillmentGroupServiceImpl.removeOrderItemFromFullfillmentGroups(order, orderItem);

    // Assert
    verify(fulfillmentGroupItemDao).delete(isA(FulfillmentGroupItem.class));
    verify(fulfillmentGroupItemImpl, atLeast(1)).getOrderItem();
    List<FulfillmentGroup> fulfillmentGroups2 = order.getFulfillmentGroups();
    assertEquals(1, fulfillmentGroups2.size());
    FulfillmentGroup getResult = fulfillmentGroups2.get(0);
    assertTrue(getResult instanceof FulfillmentGroupImpl);
    assertTrue(getResult.getDiscreteOrderItems().isEmpty());
    assertTrue(getResult.getFulfillmentGroupItems().isEmpty());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#removeOrderItemFromFullfillmentGroups(Order,
   * OrderItem)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#removeOrderItemFromFullfillmentGroups(Order, OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FulfillmentGroupServiceImpl.removeOrderItemFromFullfillmentGroups(Order, OrderItem)"
  })
  public void testRemoveOrderItemFromFullfillmentGroups_thenThrowIllegalArgumentException() {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(fulfillmentGroupItemDao)
        .delete(Mockito.<FulfillmentGroupItem>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(new DiscreteOrderItemImpl());

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupItems.add(fulfillmentGroupItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(new DiscreteOrderItemImpl());

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable2);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
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
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setPrice(new Money());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setDiscreteOrderItems(discreteOrderItems);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fulfillmentGroupServiceImpl.removeOrderItemFromFullfillmentGroups(order, orderItem));
    verify(fulfillmentGroupItemDao).delete(isA(FulfillmentGroupItem.class));
    verify(fulfillmentGroupItemImpl, atLeast(1)).getOrderItem();
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#collapseToOneShippableFulfillmentGroup(Order,
   * boolean)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#collapseToOneShippableFulfillmentGroup(Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order FulfillmentGroupServiceImpl.collapseToOneShippableFulfillmentGroup(Order, boolean)"
  })
  public void testCollapseToOneShippableFulfillmentGroup() throws PricingException {
    // Arrange and Act
    Order actualCollapseToOneShippableFulfillmentGroupResult =
        fulfillmentGroupServiceImpl.collapseToOneShippableFulfillmentGroup(
            new NullOrderImpl(), true);

    // Assert
    assertTrue(actualCollapseToOneShippableFulfillmentGroupResult instanceof NullOrderImpl);
    Money orderAdjustmentsValue =
        actualCollapseToOneShippableFulfillmentGroupResult.getOrderAdjustmentsValue();
    Money actualAbsResult = orderAdjustmentsValue.abs();
    assertEquals(orderAdjustmentsValue, actualAbsResult);
    Money actualZeroResult = orderAdjustmentsValue.zero();
    assertEquals(orderAdjustmentsValue, actualZeroResult);
    assertEquals(
        orderAdjustmentsValue, actualCollapseToOneShippableFulfillmentGroupResult.getSubTotal());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#collapseToOneShippableFulfillmentGroup(Order,
   * boolean)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#collapseToOneShippableFulfillmentGroup(Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order FulfillmentGroupServiceImpl.collapseToOneShippableFulfillmentGroup(Order, boolean)"
  })
  public void testCollapseToOneShippableFulfillmentGroup2() throws PricingException {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(fulfillmentGroupDao)
        .delete(Mockito.<FulfillmentGroup>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fulfillmentGroupServiceImpl.collapseToOneShippableFulfillmentGroup(order, true));
    verify(fulfillmentGroupDao).delete(isA(FulfillmentGroup.class));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#collapseToOneShippableFulfillmentGroup(Order,
   * boolean)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#collapseToOneShippableFulfillmentGroup(Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order FulfillmentGroupServiceImpl.collapseToOneShippableFulfillmentGroup(Order, boolean)"
  })
  public void testCollapseToOneShippableFulfillmentGroup3() throws PricingException {
    // Arrange
    doNothing().when(fulfillmentGroupDao).delete(Mockito.<FulfillmentGroup>any());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any()))
        .thenThrow(new IllegalArgumentException());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fulfillmentGroupServiceImpl.collapseToOneShippableFulfillmentGroup(order, true));
    verify(fulfillmentGroupDao).delete(isA(FulfillmentGroup.class));
    verify(orderService).save(isA(Order.class), eq(true));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#collapseToOneShippableFulfillmentGroup(Order,
   * boolean)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#collapseToOneShippableFulfillmentGroup(Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order FulfillmentGroupServiceImpl.collapseToOneShippableFulfillmentGroup(Order, boolean)"
  })
  public void testCollapseToOneShippableFulfillmentGroup4() throws PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getType()).thenReturn(FulfillmentType.DIGITAL);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act
    Order actualCollapseToOneShippableFulfillmentGroupResult =
        fulfillmentGroupServiceImpl.collapseToOneShippableFulfillmentGroup(order, true);

    // Assert
    verify(fulfillmentGroupImpl).getType();
    assertTrue(actualCollapseToOneShippableFulfillmentGroupResult instanceof OrderImpl);
    assertSame(
        fulfillmentGroups,
        actualCollapseToOneShippableFulfillmentGroupResult.getFulfillmentGroups());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#collapseToOneShippableFulfillmentGroup(Order,
   * boolean)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#collapseToOneShippableFulfillmentGroup(Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order FulfillmentGroupServiceImpl.collapseToOneShippableFulfillmentGroup(Order, boolean)"
  })
  public void testCollapseToOneShippableFulfillmentGroup5() throws PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getType()).thenReturn(FulfillmentType.GIFT_CARD);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act
    Order actualCollapseToOneShippableFulfillmentGroupResult =
        fulfillmentGroupServiceImpl.collapseToOneShippableFulfillmentGroup(order, true);

    // Assert
    verify(fulfillmentGroupImpl).getType();
    assertTrue(actualCollapseToOneShippableFulfillmentGroupResult instanceof OrderImpl);
    assertSame(
        fulfillmentGroups,
        actualCollapseToOneShippableFulfillmentGroupResult.getFulfillmentGroups());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#collapseToOneShippableFulfillmentGroup(Order,
   * boolean)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#collapseToOneShippableFulfillmentGroup(Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order FulfillmentGroupServiceImpl.collapseToOneShippableFulfillmentGroup(Order, boolean)"
  })
  public void testCollapseToOneShippableFulfillmentGroup6() throws PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getType()).thenReturn(FulfillmentType.PHYSICAL_PICKUP);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act
    Order actualCollapseToOneShippableFulfillmentGroupResult =
        fulfillmentGroupServiceImpl.collapseToOneShippableFulfillmentGroup(order, true);

    // Assert
    verify(fulfillmentGroupImpl).getType();
    assertTrue(actualCollapseToOneShippableFulfillmentGroupResult instanceof OrderImpl);
    assertSame(
        fulfillmentGroups,
        actualCollapseToOneShippableFulfillmentGroupResult.getFulfillmentGroups());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#collapseToOneShippableFulfillmentGroup(Order,
   * boolean)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#collapseToOneShippableFulfillmentGroup(Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order FulfillmentGroupServiceImpl.collapseToOneShippableFulfillmentGroup(Order, boolean)"
  })
  public void testCollapseToOneShippableFulfillmentGroup7() throws PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getType()).thenReturn(new FulfillmentType("GIFT_CARD", "GIFT_CARD"));

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act
    Order actualCollapseToOneShippableFulfillmentGroupResult =
        fulfillmentGroupServiceImpl.collapseToOneShippableFulfillmentGroup(order, true);

    // Assert
    verify(fulfillmentGroupImpl).getType();
    assertTrue(actualCollapseToOneShippableFulfillmentGroupResult instanceof OrderImpl);
    assertSame(
        fulfillmentGroups,
        actualCollapseToOneShippableFulfillmentGroupResult.getFulfillmentGroups());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#collapseToOneShippableFulfillmentGroup(Order,
   * boolean)}.
   *
   * <ul>
   *   <li>Then return {@link OrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#collapseToOneShippableFulfillmentGroup(Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order FulfillmentGroupServiceImpl.collapseToOneShippableFulfillmentGroup(Order, boolean)"
  })
  public void testCollapseToOneShippableFulfillmentGroup_thenReturnOrderImpl()
      throws PricingException {
    // Arrange
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
    order.setFulfillmentGroups(new ArrayList<>());

    // Act
    Order actualCollapseToOneShippableFulfillmentGroupResult =
        fulfillmentGroupServiceImpl.collapseToOneShippableFulfillmentGroup(order, true);

    // Assert
    assertSame(order, actualCollapseToOneShippableFulfillmentGroupResult);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#collapseToOneShippableFulfillmentGroup(Order,
   * boolean)}.
   *
   * <ul>
   *   <li>Then return SubTotal is {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#collapseToOneShippableFulfillmentGroup(Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order FulfillmentGroupServiceImpl.collapseToOneShippableFulfillmentGroup(Order, boolean)"
  })
  public void testCollapseToOneShippableFulfillmentGroup_thenReturnSubTotalIsMoney()
      throws PricingException {
    // Arrange
    doNothing().when(fulfillmentGroupDao).delete(Mockito.<FulfillmentGroup>any());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any()))
        .thenReturn(new NullOrderImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act
    Order actualCollapseToOneShippableFulfillmentGroupResult =
        fulfillmentGroupServiceImpl.collapseToOneShippableFulfillmentGroup(order, true);

    // Assert
    verify(fulfillmentGroupDao).delete(isA(FulfillmentGroup.class));
    verify(orderService).save(isA(Order.class), eq(true));
    assertTrue(actualCollapseToOneShippableFulfillmentGroupResult instanceof NullOrderImpl);
    assertEquals(subTotal, actualCollapseToOneShippableFulfillmentGroupResult.getSubTotal());
    assertSame(
        Money.ZERO, actualCollapseToOneShippableFulfillmentGroupResult.getOrderAdjustmentsValue());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#matchFulfillmentGroupsToMultishipOptions(Order,
   * boolean)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#matchFulfillmentGroupsToMultishipOptions(Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order FulfillmentGroupServiceImpl.matchFulfillmentGroupsToMultishipOptions(Order, boolean)"
  })
  public void testMatchFulfillmentGroupsToMultishipOptions() throws PricingException {
    // Arrange
    when(orderMultishipOptionService.findOrderMultishipOptions(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            fulfillmentGroupServiceImpl.matchFulfillmentGroupsToMultishipOptions(
                new NullOrderImpl(), true));
    verify(orderMultishipOptionService).findOrderMultishipOptions(isNull());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#matchFulfillmentGroupsToMultishipOptions(Order,
   * boolean)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#matchFulfillmentGroupsToMultishipOptions(Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order FulfillmentGroupServiceImpl.matchFulfillmentGroupsToMultishipOptions(Order, boolean)"
  })
  public void testMatchFulfillmentGroupsToMultishipOptions2() throws PricingException {
    // Arrange
    when(orderMultishipOptionService.findOrderMultishipOptions(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any()))
        .thenThrow(new IllegalArgumentException());

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
    assertThrows(
        IllegalArgumentException.class,
        () -> fulfillmentGroupServiceImpl.matchFulfillmentGroupsToMultishipOptions(order, true));
    verify(orderMultishipOptionService).findOrderMultishipOptions(1L);
    verify(orderService).save(isA(Order.class), eq(true));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#matchFulfillmentGroupsToMultishipOptions(Order,
   * boolean)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#matchFulfillmentGroupsToMultishipOptions(Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order FulfillmentGroupServiceImpl.matchFulfillmentGroupsToMultishipOptions(Order, boolean)"
  })
  public void testMatchFulfillmentGroupsToMultishipOptions3() throws PricingException {
    // Arrange
    when(orderMultishipOptionService.findOrderMultishipOptions(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(nullOrderImpl);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act
    Order actualMatchFulfillmentGroupsToMultishipOptionsResult =
        fulfillmentGroupServiceImpl.matchFulfillmentGroupsToMultishipOptions(order, true);

    // Assert
    verify(orderMultishipOptionService).findOrderMultishipOptions(1L);
    verify(orderService).save(isA(Order.class), eq(true));
    assertSame(nullOrderImpl, actualMatchFulfillmentGroupsToMultishipOptionsResult);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#matchFulfillmentGroupsToMultishipOptions(Order,
   * boolean)}.
   *
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#matchFulfillmentGroupsToMultishipOptions(Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order FulfillmentGroupServiceImpl.matchFulfillmentGroupsToMultishipOptions(Order, boolean)"
  })
  public void testMatchFulfillmentGroupsToMultishipOptions_thenReturnNullOrderImpl()
      throws PricingException {
    // Arrange
    when(orderMultishipOptionService.findOrderMultishipOptions(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(nullOrderImpl);

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

    // Act
    Order actualMatchFulfillmentGroupsToMultishipOptionsResult =
        fulfillmentGroupServiceImpl.matchFulfillmentGroupsToMultishipOptions(order, true);

    // Assert
    verify(orderMultishipOptionService).findOrderMultishipOptions(1L);
    verify(orderService).save(isA(Order.class), eq(true));
    assertSame(nullOrderImpl, actualMatchFulfillmentGroupsToMultishipOptionsResult);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#getKey(Address, FulfillmentOption, FulfillmentType)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link AddressImpl} {@link AddressImpl#getId()} return one.
   *   <li>Then return {@code 1:-1:DIGITAL}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupServiceImpl#getKey(Address, FulfillmentOption,
   * FulfillmentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FulfillmentGroupServiceImpl.getKey(Address, FulfillmentOption, FulfillmentType)"
  })
  public void testGetKey_givenOne_whenAddressImplGetIdReturnOne_thenReturn11Digital() {
    // Arrange
    AddressImpl address = mock(AddressImpl.class);
    when(address.getId()).thenReturn(1L);

    // Act
    String actualKey = fulfillmentGroupServiceImpl.getKey(address, null, FulfillmentType.DIGITAL);

    // Assert
    verify(address).getId();
    assertEquals("1:-1:DIGITAL", actualKey);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#getKey(Address, FulfillmentOption, FulfillmentType)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link FulfillmentOptionImpl} (default constructor) Id is one.
   *   <li>Then return {@code 1:1:DIGITAL}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupServiceImpl#getKey(Address, FulfillmentOption,
   * FulfillmentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FulfillmentGroupServiceImpl.getKey(Address, FulfillmentOption, FulfillmentType)"
  })
  public void testGetKey_givenOne_whenFulfillmentOptionImplIdIsOne_thenReturn11Digital() {
    // Arrange
    AddressImpl address = mock(AddressImpl.class);
    when(address.getId()).thenReturn(1L);

    FulfillmentOptionImpl option = new FulfillmentOptionImpl();
    option.setId(1L);

    // Act
    String actualKey = fulfillmentGroupServiceImpl.getKey(address, option, FulfillmentType.DIGITAL);

    // Assert
    verify(address).getId();
    assertEquals("1:1:DIGITAL", actualKey);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#getKey(Address, FulfillmentOption, FulfillmentType)}.
   *
   * <ul>
   *   <li>Given {@code Type}.
   *   <li>When {@link FulfillmentType} {@link FulfillmentType#getType()} return {@code Type}.
   *   <li>Then return {@code 1:-1:Type}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupServiceImpl#getKey(Address, FulfillmentOption,
   * FulfillmentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FulfillmentGroupServiceImpl.getKey(Address, FulfillmentOption, FulfillmentType)"
  })
  public void testGetKey_givenType_whenFulfillmentTypeGetTypeReturnType_thenReturn11Type() {
    // Arrange
    AddressImpl address = mock(AddressImpl.class);
    when(address.getId()).thenReturn(1L);

    FulfillmentType fulfillmentType = mock(FulfillmentType.class);
    when(fulfillmentType.getType()).thenReturn("Type");

    // Act
    String actualKey = fulfillmentGroupServiceImpl.getKey(address, null, fulfillmentType);

    // Assert
    verify(fulfillmentType).getType();
    verify(address).getId();
    assertEquals("1:-1:Type", actualKey);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#getKey(Address, FulfillmentOption, FulfillmentType)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupServiceImpl#getKey(Address, FulfillmentOption,
   * FulfillmentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FulfillmentGroupServiceImpl.getKey(Address, FulfillmentOption, FulfillmentType)"
  })
  public void testGetKey_thenThrowIllegalArgumentException() {
    // Arrange
    AddressImpl address = mock(AddressImpl.class);
    when(address.getId()).thenReturn(1L);

    FulfillmentOption option = mock(FulfillmentOption.class);
    when(option.getId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fulfillmentGroupServiceImpl.getKey(address, option, FulfillmentType.DIGITAL));
    verify(option).getId();
    verify(address).getId();
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#getKey(Address, FulfillmentOption, FulfillmentType)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code -1:-1:DIGITAL}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupServiceImpl#getKey(Address, FulfillmentOption,
   * FulfillmentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FulfillmentGroupServiceImpl.getKey(Address, FulfillmentOption, FulfillmentType)"
  })
  public void testGetKey_whenNull_thenReturn11Digital() {
    // Arrange, Act and Assert
    assertEquals(
        "-1:-1:DIGITAL", fulfillmentGroupServiceImpl.getKey(null, null, FulfillmentType.DIGITAL));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#getKey(Address, FulfillmentOption, FulfillmentType)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code -1:-1:-1}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupServiceImpl#getKey(Address, FulfillmentOption,
   * FulfillmentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FulfillmentGroupServiceImpl.getKey(Address, FulfillmentOption, FulfillmentType)"
  })
  public void testGetKey_whenNull_thenReturn111() {
    // Arrange, Act and Assert
    assertEquals("-1:-1:-1", fulfillmentGroupServiceImpl.getKey(null, null, null));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#createFulfillmentGroupItemFromOrderItem(OrderItem,
   * FulfillmentGroup, int)}.
   *
   * <ul>
   *   <li>Then return {@link FulfillmentGroupItemImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#createFulfillmentGroupItemFromOrderItem(OrderItem,
   * FulfillmentGroup, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroupItem FulfillmentGroupServiceImpl.createFulfillmentGroupItemFromOrderItem(OrderItem, FulfillmentGroup, int)"
  })
  public void testCreateFulfillmentGroupItemFromOrderItem_thenReturnFulfillmentGroupItemImpl() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    when(fulfillmentGroupItemDao.create()).thenReturn(fulfillmentGroupItemImpl);
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();

    // Act
    FulfillmentGroupItem actualCreateFulfillmentGroupItemFromOrderItemResult =
        fulfillmentGroupServiceImpl.createFulfillmentGroupItemFromOrderItem(
            orderItem, new FulfillmentGroupImpl(), 1);

    // Assert
    verify(fulfillmentGroupItemDao).create();
    assertSame(fulfillmentGroupItemImpl, actualCreateFulfillmentGroupItemFromOrderItemResult);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#createFulfillmentGroupItemFromOrderItem(OrderItem,
   * FulfillmentGroup, int)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#createFulfillmentGroupItemFromOrderItem(OrderItem,
   * FulfillmentGroup, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroupItem FulfillmentGroupServiceImpl.createFulfillmentGroupItemFromOrderItem(OrderItem, FulfillmentGroup, int)"
  })
  public void testCreateFulfillmentGroupItemFromOrderItem_thenThrowIllegalArgumentException() {
    // Arrange
    when(fulfillmentGroupItemDao.create()).thenThrow(new IllegalArgumentException());
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            fulfillmentGroupServiceImpl.createFulfillmentGroupItemFromOrderItem(
                orderItem, new FulfillmentGroupImpl(), 1));
    verify(fulfillmentGroupItemDao).create();
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#removeAllFulfillmentGroupsFromOrder(Order, boolean)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#removeAllFulfillmentGroupsFromOrder(Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order FulfillmentGroupServiceImpl.removeAllFulfillmentGroupsFromOrder(Order, boolean)"
  })
  public void testRemoveAllFulfillmentGroupsFromOrder() throws PricingException {
    // Arrange and Act
    Order actualRemoveAllFulfillmentGroupsFromOrderResult =
        fulfillmentGroupServiceImpl.removeAllFulfillmentGroupsFromOrder(new NullOrderImpl(), true);

    // Assert
    assertTrue(actualRemoveAllFulfillmentGroupsFromOrderResult instanceof NullOrderImpl);
    Money orderAdjustmentsValue =
        actualRemoveAllFulfillmentGroupsFromOrderResult.getOrderAdjustmentsValue();
    Money actualAbsResult = orderAdjustmentsValue.abs();
    assertEquals(orderAdjustmentsValue, actualAbsResult);
    Money actualZeroResult = orderAdjustmentsValue.zero();
    assertEquals(orderAdjustmentsValue, actualZeroResult);
    assertEquals(
        orderAdjustmentsValue, actualRemoveAllFulfillmentGroupsFromOrderResult.getSubTotal());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#removeAllFulfillmentGroupsFromOrder(Order, boolean)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#removeAllFulfillmentGroupsFromOrder(Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order FulfillmentGroupServiceImpl.removeAllFulfillmentGroupsFromOrder(Order, boolean)"
  })
  public void testRemoveAllFulfillmentGroupsFromOrder2() throws PricingException {
    // Arrange
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any()))
        .thenThrow(new IllegalArgumentException());

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
    order.setFulfillmentGroups(new ArrayList<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fulfillmentGroupServiceImpl.removeAllFulfillmentGroupsFromOrder(order, true));
    verify(orderService).save(isA(Order.class), eq(true));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#removeAllFulfillmentGroupsFromOrder(Order, boolean)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#removeAllFulfillmentGroupsFromOrder(Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order FulfillmentGroupServiceImpl.removeAllFulfillmentGroupsFromOrder(Order, boolean)"
  })
  public void testRemoveAllFulfillmentGroupsFromOrder3() throws PricingException {
    // Arrange
    doNothing().when(fulfillmentGroupDao).delete(Mockito.<FulfillmentGroup>any());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any()))
        .thenReturn(new NullOrderImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act
    Order actualRemoveAllFulfillmentGroupsFromOrderResult =
        fulfillmentGroupServiceImpl.removeAllFulfillmentGroupsFromOrder(order, true);

    // Assert
    verify(fulfillmentGroupDao).delete(isA(FulfillmentGroup.class));
    verify(orderService).save(isA(Order.class), eq(true));
    assertTrue(actualRemoveAllFulfillmentGroupsFromOrderResult instanceof NullOrderImpl);
    assertEquals(subTotal, actualRemoveAllFulfillmentGroupsFromOrderResult.getSubTotal());
    assertSame(
        Money.ZERO, actualRemoveAllFulfillmentGroupsFromOrderResult.getOrderAdjustmentsValue());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#removeAllFulfillmentGroupsFromOrder(Order, boolean)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#removeAllFulfillmentGroupsFromOrder(Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order FulfillmentGroupServiceImpl.removeAllFulfillmentGroupsFromOrder(Order, boolean)"
  })
  public void testRemoveAllFulfillmentGroupsFromOrder4() throws PricingException {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(fulfillmentGroupDao)
        .delete(Mockito.<FulfillmentGroup>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fulfillmentGroupServiceImpl.removeAllFulfillmentGroupsFromOrder(order, true));
    verify(fulfillmentGroupDao).delete(isA(FulfillmentGroup.class));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#removeAllFulfillmentGroupsFromOrder(Order, boolean)}.
   *
   * <ul>
   *   <li>Then return SubTotal is {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#removeAllFulfillmentGroupsFromOrder(Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order FulfillmentGroupServiceImpl.removeAllFulfillmentGroupsFromOrder(Order, boolean)"
  })
  public void testRemoveAllFulfillmentGroupsFromOrder_thenReturnSubTotalIsMoney()
      throws PricingException {
    // Arrange
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any()))
        .thenReturn(new NullOrderImpl());

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(new ArrayList<>());

    // Act
    Order actualRemoveAllFulfillmentGroupsFromOrderResult =
        fulfillmentGroupServiceImpl.removeAllFulfillmentGroupsFromOrder(order, true);

    // Assert
    verify(orderService).save(isA(Order.class), eq(true));
    assertTrue(actualRemoveAllFulfillmentGroupsFromOrderResult instanceof NullOrderImpl);
    assertEquals(subTotal, actualRemoveAllFulfillmentGroupsFromOrderResult.getSubTotal());
    assertSame(
        Money.ZERO, actualRemoveAllFulfillmentGroupsFromOrderResult.getOrderAdjustmentsValue());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#createFulfillmentGroupFee()}.
   *
   * <ul>
   *   <li>Then return {@link FulfillmentGroupFeeImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupServiceImpl#createFulfillmentGroupFee()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FulfillmentGroupFee FulfillmentGroupServiceImpl.createFulfillmentGroupFee()"})
  public void testCreateFulfillmentGroupFee_thenReturnFulfillmentGroupFeeImpl() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    when(fulfillmentGroupDao.createFulfillmentGroupFee()).thenReturn(fulfillmentGroupFeeImpl);

    // Act
    FulfillmentGroupFee actualCreateFulfillmentGroupFeeResult =
        fulfillmentGroupServiceImpl.createFulfillmentGroupFee();

    // Assert
    verify(fulfillmentGroupDao).createFulfillmentGroupFee();
    assertSame(fulfillmentGroupFeeImpl, actualCreateFulfillmentGroupFeeResult);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#createFulfillmentGroupFee()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupServiceImpl#createFulfillmentGroupFee()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FulfillmentGroupFee FulfillmentGroupServiceImpl.createFulfillmentGroupFee()"})
  public void testCreateFulfillmentGroupFee_thenThrowIllegalArgumentException() {
    // Arrange
    when(fulfillmentGroupDao.createFulfillmentGroupFee()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fulfillmentGroupServiceImpl.createFulfillmentGroupFee());
    verify(fulfillmentGroupDao).createFulfillmentGroupFee();
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#findUnfulfilledFulfillmentGroups(int, int)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupServiceImpl#findUnfulfilledFulfillmentGroups(int,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List FulfillmentGroupServiceImpl.findUnfulfilledFulfillmentGroups(int, int)"})
  public void testFindUnfulfilledFulfillmentGroups_thenReturnEmpty() {
    // Arrange
    when(fulfillmentGroupDao.readUnfulfilledFulfillmentGroups(anyInt(), anyInt()))
        .thenReturn(new ArrayList<>());

    // Act
    List<FulfillmentGroup> actualFindUnfulfilledFulfillmentGroupsResult =
        fulfillmentGroupServiceImpl.findUnfulfilledFulfillmentGroups(1, 3);

    // Assert
    verify(fulfillmentGroupDao).readUnfulfilledFulfillmentGroups(1, 3);
    assertTrue(actualFindUnfulfilledFulfillmentGroupsResult.isEmpty());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#findUnfulfilledFulfillmentGroups(int, int)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupServiceImpl#findUnfulfilledFulfillmentGroups(int,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List FulfillmentGroupServiceImpl.findUnfulfilledFulfillmentGroups(int, int)"})
  public void testFindUnfulfilledFulfillmentGroups_thenThrowIllegalArgumentException() {
    // Arrange
    when(fulfillmentGroupDao.readUnfulfilledFulfillmentGroups(anyInt(), anyInt()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fulfillmentGroupServiceImpl.findUnfulfilledFulfillmentGroups(1, 3));
    verify(fulfillmentGroupDao).readUnfulfilledFulfillmentGroups(1, 3);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#findPartiallyFulfilledFulfillmentGroups(int, int)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#findPartiallyFulfilledFulfillmentGroups(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FulfillmentGroupServiceImpl.findPartiallyFulfilledFulfillmentGroups(int, int)"
  })
  public void testFindPartiallyFulfilledFulfillmentGroups_thenReturnEmpty() {
    // Arrange
    when(fulfillmentGroupDao.readPartiallyFulfilledFulfillmentGroups(anyInt(), anyInt()))
        .thenReturn(new ArrayList<>());

    // Act
    List<FulfillmentGroup> actualFindPartiallyFulfilledFulfillmentGroupsResult =
        fulfillmentGroupServiceImpl.findPartiallyFulfilledFulfillmentGroups(1, 3);

    // Assert
    verify(fulfillmentGroupDao).readPartiallyFulfilledFulfillmentGroups(1, 3);
    assertTrue(actualFindPartiallyFulfilledFulfillmentGroupsResult.isEmpty());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#findPartiallyFulfilledFulfillmentGroups(int, int)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#findPartiallyFulfilledFulfillmentGroups(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FulfillmentGroupServiceImpl.findPartiallyFulfilledFulfillmentGroups(int, int)"
  })
  public void testFindPartiallyFulfilledFulfillmentGroups_thenThrowIllegalArgumentException() {
    // Arrange
    when(fulfillmentGroupDao.readPartiallyFulfilledFulfillmentGroups(anyInt(), anyInt()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fulfillmentGroupServiceImpl.findPartiallyFulfilledFulfillmentGroups(1, 3));
    verify(fulfillmentGroupDao).readPartiallyFulfilledFulfillmentGroups(1, 3);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#findUnprocessedFulfillmentGroups(int, int)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupServiceImpl#findUnprocessedFulfillmentGroups(int,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List FulfillmentGroupServiceImpl.findUnprocessedFulfillmentGroups(int, int)"})
  public void testFindUnprocessedFulfillmentGroups_thenReturnEmpty() {
    // Arrange
    when(fulfillmentGroupDao.readUnprocessedFulfillmentGroups(anyInt(), anyInt()))
        .thenReturn(new ArrayList<>());

    // Act
    List<FulfillmentGroup> actualFindUnprocessedFulfillmentGroupsResult =
        fulfillmentGroupServiceImpl.findUnprocessedFulfillmentGroups(1, 3);

    // Assert
    verify(fulfillmentGroupDao).readUnprocessedFulfillmentGroups(1, 3);
    assertTrue(actualFindUnprocessedFulfillmentGroupsResult.isEmpty());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#findUnprocessedFulfillmentGroups(int, int)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupServiceImpl#findUnprocessedFulfillmentGroups(int,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List FulfillmentGroupServiceImpl.findUnprocessedFulfillmentGroups(int, int)"})
  public void testFindUnprocessedFulfillmentGroups_thenThrowIllegalArgumentException() {
    // Arrange
    when(fulfillmentGroupDao.readUnprocessedFulfillmentGroups(anyInt(), anyInt()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fulfillmentGroupServiceImpl.findUnprocessedFulfillmentGroups(1, 3));
    verify(fulfillmentGroupDao).readUnprocessedFulfillmentGroups(1, 3);
  }

  /**
   * Test {@link
   * FulfillmentGroupServiceImpl#findFulfillmentGroupsByStatus(FulfillmentGroupStatusType, int,
   * int)} with {@code status}, {@code start}, {@code maxResults}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#findFulfillmentGroupsByStatus(FulfillmentGroupStatusType, int,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FulfillmentGroupServiceImpl.findFulfillmentGroupsByStatus(FulfillmentGroupStatusType, int, int)"
  })
  public void testFindFulfillmentGroupsByStatusWithStatusStartMaxResults() {
    // Arrange
    when(fulfillmentGroupDao.readFulfillmentGroupsByStatus(
            Mockito.<FulfillmentGroupStatusType>any(), anyInt(), anyInt()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            fulfillmentGroupServiceImpl.findFulfillmentGroupsByStatus(
                FulfillmentGroupStatusType.CANCELLED, 1, 3));
    verify(fulfillmentGroupDao)
        .readFulfillmentGroupsByStatus(isA(FulfillmentGroupStatusType.class), eq(1), eq(3));
  }

  /**
   * Test {@link
   * FulfillmentGroupServiceImpl#findFulfillmentGroupsByStatus(FulfillmentGroupStatusType, int, int,
   * boolean)} with {@code status}, {@code start}, {@code maxResults}, {@code ascending}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#findFulfillmentGroupsByStatus(FulfillmentGroupStatusType, int, int,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FulfillmentGroupServiceImpl.findFulfillmentGroupsByStatus(FulfillmentGroupStatusType, int, int, boolean)"
  })
  public void testFindFulfillmentGroupsByStatusWithStatusStartMaxResultsAscending() {
    // Arrange
    when(fulfillmentGroupDao.readFulfillmentGroupsByStatus(
            Mockito.<FulfillmentGroupStatusType>any(), anyInt(), anyInt(), anyBoolean()))
        .thenReturn(new ArrayList<>());

    // Act
    List<FulfillmentGroup> actualFindFulfillmentGroupsByStatusResult =
        fulfillmentGroupServiceImpl.findFulfillmentGroupsByStatus(
            FulfillmentGroupStatusType.CANCELLED, 1, 3, true);

    // Assert
    verify(fulfillmentGroupDao)
        .readFulfillmentGroupsByStatus(
            isA(FulfillmentGroupStatusType.class), eq(1), eq(3), eq(true));
    assertTrue(actualFindFulfillmentGroupsByStatusResult.isEmpty());
  }

  /**
   * Test {@link
   * FulfillmentGroupServiceImpl#findFulfillmentGroupsByStatus(FulfillmentGroupStatusType, int, int,
   * boolean)} with {@code status}, {@code start}, {@code maxResults}, {@code ascending}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#findFulfillmentGroupsByStatus(FulfillmentGroupStatusType, int, int,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FulfillmentGroupServiceImpl.findFulfillmentGroupsByStatus(FulfillmentGroupStatusType, int, int, boolean)"
  })
  public void testFindFulfillmentGroupsByStatusWithStatusStartMaxResultsAscending2() {
    // Arrange
    when(fulfillmentGroupDao.readFulfillmentGroupsByStatus(
            Mockito.<FulfillmentGroupStatusType>any(), anyInt(), anyInt(), anyBoolean()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            fulfillmentGroupServiceImpl.findFulfillmentGroupsByStatus(
                FulfillmentGroupStatusType.CANCELLED, 1, 3, true));
    verify(fulfillmentGroupDao)
        .readFulfillmentGroupsByStatus(
            isA(FulfillmentGroupStatusType.class), eq(1), eq(3), eq(true));
  }

  /**
   * Test {@link
   * FulfillmentGroupServiceImpl#findFulfillmentGroupsByStatus(FulfillmentGroupStatusType, int,
   * int)} with {@code status}, {@code start}, {@code maxResults}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#findFulfillmentGroupsByStatus(FulfillmentGroupStatusType, int,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FulfillmentGroupServiceImpl.findFulfillmentGroupsByStatus(FulfillmentGroupStatusType, int, int)"
  })
  public void testFindFulfillmentGroupsByStatusWithStatusStartMaxResults_thenReturnEmpty() {
    // Arrange
    when(fulfillmentGroupDao.readFulfillmentGroupsByStatus(
            Mockito.<FulfillmentGroupStatusType>any(), anyInt(), anyInt()))
        .thenReturn(new ArrayList<>());

    // Act
    List<FulfillmentGroup> actualFindFulfillmentGroupsByStatusResult =
        fulfillmentGroupServiceImpl.findFulfillmentGroupsByStatus(
            FulfillmentGroupStatusType.CANCELLED, 1, 3);

    // Assert
    verify(fulfillmentGroupDao)
        .readFulfillmentGroupsByStatus(isA(FulfillmentGroupStatusType.class), eq(1), eq(3));
    assertTrue(actualFindFulfillmentGroupsByStatusResult.isEmpty());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#isShippable(FulfillmentType)}.
   *
   * <ul>
   *   <li>When {@link FulfillmentType#DIGITAL}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupServiceImpl#isShippable(FulfillmentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FulfillmentGroupServiceImpl.isShippable(FulfillmentType)"})
  public void testIsShippable_whenDigital_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(fulfillmentGroupServiceImpl.isShippable(FulfillmentType.DIGITAL));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#isShippable(FulfillmentType)}.
   *
   * <ul>
   *   <li>When {@link FulfillmentType#FulfillmentType(String, String)} with type is {@code
   *       GIFT_CARD} and friendlyType is {@code GIFT_CARD}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupServiceImpl#isShippable(FulfillmentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FulfillmentGroupServiceImpl.isShippable(FulfillmentType)"})
  public void testIsShippable_whenFulfillmentTypeWithTypeIsGiftCardAndFriendlyTypeIsGiftCard() {
    // Arrange, Act and Assert
    assertFalse(
        fulfillmentGroupServiceImpl.isShippable(new FulfillmentType("GIFT_CARD", "GIFT_CARD")));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#isShippable(FulfillmentType)}.
   *
   * <ul>
   *   <li>When {@link FulfillmentType#GIFT_CARD}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupServiceImpl#isShippable(FulfillmentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FulfillmentGroupServiceImpl.isShippable(FulfillmentType)"})
  public void testIsShippable_whenGift_card_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(fulfillmentGroupServiceImpl.isShippable(FulfillmentType.GIFT_CARD));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#isShippable(FulfillmentType)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupServiceImpl#isShippable(FulfillmentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FulfillmentGroupServiceImpl.isShippable(FulfillmentType)"})
  public void testIsShippable_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(fulfillmentGroupServiceImpl.isShippable(null));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#isShippable(FulfillmentType)}.
   *
   * <ul>
   *   <li>When {@link FulfillmentType#PHYSICAL_PICKUP}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupServiceImpl#isShippable(FulfillmentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FulfillmentGroupServiceImpl.isShippable(FulfillmentType)"})
  public void testIsShippable_whenPhysical_pickup_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(fulfillmentGroupServiceImpl.isShippable(FulfillmentType.PHYSICAL_PICKUP));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#getFirstShippableFulfillmentGroup(Order)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#getFirstShippableFulfillmentGroup(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupServiceImpl.getFirstShippableFulfillmentGroup(Order)"
  })
  public void testGetFirstShippableFulfillmentGroup() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getType()).thenReturn(FulfillmentType.DIGITAL);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act
    FulfillmentGroup actualFirstShippableFulfillmentGroup =
        fulfillmentGroupServiceImpl.getFirstShippableFulfillmentGroup(order);

    // Assert
    verify(fulfillmentGroupImpl).getType();
    assertNull(actualFirstShippableFulfillmentGroup);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#getFirstShippableFulfillmentGroup(Order)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#getFirstShippableFulfillmentGroup(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupServiceImpl.getFirstShippableFulfillmentGroup(Order)"
  })
  public void testGetFirstShippableFulfillmentGroup2() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getType()).thenReturn(FulfillmentType.GIFT_CARD);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act
    FulfillmentGroup actualFirstShippableFulfillmentGroup =
        fulfillmentGroupServiceImpl.getFirstShippableFulfillmentGroup(order);

    // Assert
    verify(fulfillmentGroupImpl).getType();
    assertNull(actualFirstShippableFulfillmentGroup);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#getFirstShippableFulfillmentGroup(Order)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#getFirstShippableFulfillmentGroup(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupServiceImpl.getFirstShippableFulfillmentGroup(Order)"
  })
  public void testGetFirstShippableFulfillmentGroup3() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getType()).thenReturn(FulfillmentType.PHYSICAL_PICKUP);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act
    FulfillmentGroup actualFirstShippableFulfillmentGroup =
        fulfillmentGroupServiceImpl.getFirstShippableFulfillmentGroup(order);

    // Assert
    verify(fulfillmentGroupImpl).getType();
    assertNull(actualFirstShippableFulfillmentGroup);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#getFirstShippableFulfillmentGroup(Order)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#getFirstShippableFulfillmentGroup(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupServiceImpl.getFirstShippableFulfillmentGroup(Order)"
  })
  public void testGetFirstShippableFulfillmentGroup4() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getType()).thenReturn(new FulfillmentType("GIFT_CARD", "GIFT_CARD"));

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act
    FulfillmentGroup actualFirstShippableFulfillmentGroup =
        fulfillmentGroupServiceImpl.getFirstShippableFulfillmentGroup(order);

    // Assert
    verify(fulfillmentGroupImpl).getType();
    assertNull(actualFirstShippableFulfillmentGroup);
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#getFirstShippableFulfillmentGroup(Order)}.
   *
   * <ul>
   *   <li>Then return {@link FulfillmentGroupImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#getFirstShippableFulfillmentGroup(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupServiceImpl.getFirstShippableFulfillmentGroup(Order)"
  })
  public void testGetFirstShippableFulfillmentGroup_thenReturnFulfillmentGroupImpl() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act and Assert
    assertSame(
        fulfillmentGroupImpl, fulfillmentGroupServiceImpl.getFirstShippableFulfillmentGroup(order));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#getFirstShippableFulfillmentGroup(Order)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#getFirstShippableFulfillmentGroup(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupServiceImpl.getFirstShippableFulfillmentGroup(Order)"
  })
  public void testGetFirstShippableFulfillmentGroup_thenReturnNull() {
    // Arrange
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
    order.setFulfillmentGroups(new ArrayList<>());

    // Act and Assert
    assertNull(fulfillmentGroupServiceImpl.getFirstShippableFulfillmentGroup(order));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#getFirstShippableFulfillmentGroup(Order)}.
   *
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#getFirstShippableFulfillmentGroup(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupServiceImpl.getFirstShippableFulfillmentGroup(Order)"
  })
  public void testGetFirstShippableFulfillmentGroup_whenNullOrderImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(fulfillmentGroupServiceImpl.getFirstShippableFulfillmentGroup(new NullOrderImpl()));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#getAllShippableFulfillmentGroups(Order)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#getAllShippableFulfillmentGroups(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List FulfillmentGroupServiceImpl.getAllShippableFulfillmentGroups(Order)"})
  public void testGetAllShippableFulfillmentGroups() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getType()).thenReturn(FulfillmentType.DIGITAL);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act
    List<FulfillmentGroup> actualAllShippableFulfillmentGroups =
        fulfillmentGroupServiceImpl.getAllShippableFulfillmentGroups(order);

    // Assert
    verify(fulfillmentGroupImpl).getType();
    assertTrue(actualAllShippableFulfillmentGroups.isEmpty());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#getAllShippableFulfillmentGroups(Order)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#getAllShippableFulfillmentGroups(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List FulfillmentGroupServiceImpl.getAllShippableFulfillmentGroups(Order)"})
  public void testGetAllShippableFulfillmentGroups2() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getType()).thenReturn(FulfillmentType.GIFT_CARD);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act
    List<FulfillmentGroup> actualAllShippableFulfillmentGroups =
        fulfillmentGroupServiceImpl.getAllShippableFulfillmentGroups(order);

    // Assert
    verify(fulfillmentGroupImpl).getType();
    assertTrue(actualAllShippableFulfillmentGroups.isEmpty());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#getAllShippableFulfillmentGroups(Order)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#getAllShippableFulfillmentGroups(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List FulfillmentGroupServiceImpl.getAllShippableFulfillmentGroups(Order)"})
  public void testGetAllShippableFulfillmentGroups3() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getType()).thenReturn(FulfillmentType.PHYSICAL_PICKUP);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act
    List<FulfillmentGroup> actualAllShippableFulfillmentGroups =
        fulfillmentGroupServiceImpl.getAllShippableFulfillmentGroups(order);

    // Assert
    verify(fulfillmentGroupImpl).getType();
    assertTrue(actualAllShippableFulfillmentGroups.isEmpty());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#getAllShippableFulfillmentGroups(Order)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#getAllShippableFulfillmentGroups(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List FulfillmentGroupServiceImpl.getAllShippableFulfillmentGroups(Order)"})
  public void testGetAllShippableFulfillmentGroups4() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getType()).thenReturn(new FulfillmentType("GIFT_CARD", "GIFT_CARD"));

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act
    List<FulfillmentGroup> actualAllShippableFulfillmentGroups =
        fulfillmentGroupServiceImpl.getAllShippableFulfillmentGroups(order);

    // Assert
    verify(fulfillmentGroupImpl).getType();
    assertTrue(actualAllShippableFulfillmentGroups.isEmpty());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#getAllShippableFulfillmentGroups(Order)}.
   *
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#getAllShippableFulfillmentGroups(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List FulfillmentGroupServiceImpl.getAllShippableFulfillmentGroups(Order)"})
  public void testGetAllShippableFulfillmentGroups_thenReturnArrayList() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act and Assert
    assertEquals(
        fulfillmentGroups, fulfillmentGroupServiceImpl.getAllShippableFulfillmentGroups(order));
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#getAllShippableFulfillmentGroups(Order)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#getAllShippableFulfillmentGroups(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List FulfillmentGroupServiceImpl.getAllShippableFulfillmentGroups(Order)"})
  public void testGetAllShippableFulfillmentGroups_thenReturnEmpty() {
    // Arrange
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
    order.setFulfillmentGroups(new ArrayList<>());

    // Act and Assert
    assertTrue(fulfillmentGroupServiceImpl.getAllShippableFulfillmentGroups(order).isEmpty());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#getAllShippableFulfillmentGroups(Order)}.
   *
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#getAllShippableFulfillmentGroups(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List FulfillmentGroupServiceImpl.getAllShippableFulfillmentGroups(Order)"})
  public void testGetAllShippableFulfillmentGroups_whenNullOrderImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        fulfillmentGroupServiceImpl
            .getAllShippableFulfillmentGroups(new NullOrderImpl())
            .isEmpty());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#calculateNumShippableFulfillmentGroups(Order)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#calculateNumShippableFulfillmentGroups(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Integer FulfillmentGroupServiceImpl.calculateNumShippableFulfillmentGroups(Order)"
  })
  public void testCalculateNumShippableFulfillmentGroups() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getType()).thenReturn(FulfillmentType.DIGITAL);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act
    Integer actualCalculateNumShippableFulfillmentGroupsResult =
        fulfillmentGroupServiceImpl.calculateNumShippableFulfillmentGroups(order);

    // Assert
    verify(fulfillmentGroupImpl).getType();
    assertEquals(0, actualCalculateNumShippableFulfillmentGroupsResult.intValue());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#calculateNumShippableFulfillmentGroups(Order)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#calculateNumShippableFulfillmentGroups(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Integer FulfillmentGroupServiceImpl.calculateNumShippableFulfillmentGroups(Order)"
  })
  public void testCalculateNumShippableFulfillmentGroups2() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getType()).thenReturn(FulfillmentType.GIFT_CARD);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act
    Integer actualCalculateNumShippableFulfillmentGroupsResult =
        fulfillmentGroupServiceImpl.calculateNumShippableFulfillmentGroups(order);

    // Assert
    verify(fulfillmentGroupImpl).getType();
    assertEquals(0, actualCalculateNumShippableFulfillmentGroupsResult.intValue());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#calculateNumShippableFulfillmentGroups(Order)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#calculateNumShippableFulfillmentGroups(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Integer FulfillmentGroupServiceImpl.calculateNumShippableFulfillmentGroups(Order)"
  })
  public void testCalculateNumShippableFulfillmentGroups3() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getType()).thenReturn(FulfillmentType.PHYSICAL_PICKUP);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act
    Integer actualCalculateNumShippableFulfillmentGroupsResult =
        fulfillmentGroupServiceImpl.calculateNumShippableFulfillmentGroups(order);

    // Assert
    verify(fulfillmentGroupImpl).getType();
    assertEquals(0, actualCalculateNumShippableFulfillmentGroupsResult.intValue());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#calculateNumShippableFulfillmentGroups(Order)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#calculateNumShippableFulfillmentGroups(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Integer FulfillmentGroupServiceImpl.calculateNumShippableFulfillmentGroups(Order)"
  })
  public void testCalculateNumShippableFulfillmentGroups4() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getType()).thenReturn(new FulfillmentType("GIFT_CARD", "GIFT_CARD"));

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act
    Integer actualCalculateNumShippableFulfillmentGroupsResult =
        fulfillmentGroupServiceImpl.calculateNumShippableFulfillmentGroups(order);

    // Assert
    verify(fulfillmentGroupImpl).getType();
    assertEquals(0, actualCalculateNumShippableFulfillmentGroupsResult.intValue());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#calculateNumShippableFulfillmentGroups(Order)}.
   *
   * <ul>
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#calculateNumShippableFulfillmentGroups(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Integer FulfillmentGroupServiceImpl.calculateNumShippableFulfillmentGroups(Order)"
  })
  public void testCalculateNumShippableFulfillmentGroups_thenReturnIntValueIsOne() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertEquals(
        1, fulfillmentGroupServiceImpl.calculateNumShippableFulfillmentGroups(order).intValue());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#calculateNumShippableFulfillmentGroups(Order)}.
   *
   * <ul>
   *   <li>Then return intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#calculateNumShippableFulfillmentGroups(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Integer FulfillmentGroupServiceImpl.calculateNumShippableFulfillmentGroups(Order)"
  })
  public void testCalculateNumShippableFulfillmentGroups_thenReturnIntValueIsZero() {
    // Arrange
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
    assertEquals(
        0, fulfillmentGroupServiceImpl.calculateNumShippableFulfillmentGroups(order).intValue());
  }

  /**
   * Test {@link FulfillmentGroupServiceImpl#calculateNumShippableFulfillmentGroups(Order)}.
   *
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupServiceImpl#calculateNumShippableFulfillmentGroups(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Integer FulfillmentGroupServiceImpl.calculateNumShippableFulfillmentGroups(Order)"
  })
  public void testCalculateNumShippableFulfillmentGroups_whenNullOrderImpl() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        fulfillmentGroupServiceImpl
            .calculateNumShippableFulfillmentGroups(new NullOrderImpl())
            .intValue());
  }
}

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
package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.service.GenericEntityServiceImpl;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.core.offer.domain.CandidateFulfillmentGroupOffer;
import org.broadleafcommerce.core.offer.domain.CandidateFulfillmentGroupOfferImpl;
import org.broadleafcommerce.core.offer.domain.FulfillmentGroupAdjustment;
import org.broadleafcommerce.core.offer.domain.FulfillmentGroupAdjustmentImpl;
import org.broadleafcommerce.core.order.service.type.FulfillmentGroupStatusType;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class FulfillmentGroupImplDiffblueTest {
  /**
   * Method under test: {@link FulfillmentGroupImpl#getDiscreteOrderItems()}
   */
  @Test
  public void testGetDiscreteOrderItems() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new FulfillmentGroupImpl()).getDiscreteOrderItems().isEmpty());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getDiscreteOrderItems()}
   */
  @Test
  public void testGetDiscreteOrderItems2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(new DiscreteOrderItemImpl());

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItem.setName("Name");
    orderItem.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setDiscreteOrderItems(discreteOrderItems);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());
    fulfillmentGroupItemImpl.setOrderItem(orderItem);

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
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);

    // Act and Assert
    assertEquals(discreteOrderItems, fulfillmentGroupImpl.getDiscreteOrderItems());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getDiscreteOrderItems()}
   */
  @Test
  public void testGetDiscreteOrderItems3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.addFulfillmentGroupItem(new FulfillmentGroupItemImpl());

    // Act and Assert
    assertTrue(fulfillmentGroupImpl.getDiscreteOrderItems().isEmpty());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getDiscreteOrderItems()}
   */
  @Test
  public void testGetDiscreteOrderItems4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItem = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItem.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.addFulfillmentGroupItem(fulfillmentGroupItem);

    // Act
    List<DiscreteOrderItem> actualDiscreteOrderItems = fulfillmentGroupImpl.getDiscreteOrderItems();

    // Assert
    verify(fulfillmentGroupItem).getOrderItem();
    assertTrue(actualDiscreteOrderItems.isEmpty());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getDiscreteOrderItems()}
   */
  @Test
  public void testGetDiscreteOrderItems5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItem = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItem.getOrderItem()).thenReturn(mock(DiscreteOrderItemImpl.class));

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.addFulfillmentGroupItem(fulfillmentGroupItem);

    // Act
    List<DiscreteOrderItem> actualDiscreteOrderItems = fulfillmentGroupImpl.getDiscreteOrderItems();

    // Assert
    verify(fulfillmentGroupItem).getOrderItem();
    assertEquals(1, actualDiscreteOrderItems.size());
  }

  /**
   * Method under test:
   * {@link FulfillmentGroupImpl#addFulfillmentGroupItem(FulfillmentGroupItem)}
   */
  @Test
  public void testAddFulfillmentGroupItem() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    FulfillmentGroupItemImpl fulfillmentGroupItem = new FulfillmentGroupItemImpl();

    // Act
    fulfillmentGroupImpl.addFulfillmentGroupItem(fulfillmentGroupItem);

    // Assert
    List<FulfillmentGroupItem> fulfillmentGroupItems = fulfillmentGroupImpl.getFulfillmentGroupItems();
    assertEquals(1, fulfillmentGroupItems.size());
    assertTrue(fulfillmentGroupImpl.getDiscreteOrderItems().isEmpty());
    assertSame(fulfillmentGroupItem, fulfillmentGroupItems.get(0));
  }

  /**
   * Method under test:
   * {@link FulfillmentGroupImpl#addFulfillmentGroupItem(FulfillmentGroupItem)}
   */
  @Test
  public void testAddFulfillmentGroupItem2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupItems(null);
    FulfillmentGroupItemImpl fulfillmentGroupItem = new FulfillmentGroupItemImpl();

    // Act
    fulfillmentGroupImpl.addFulfillmentGroupItem(fulfillmentGroupItem);

    // Assert
    List<FulfillmentGroupItem> fulfillmentGroupItems = fulfillmentGroupImpl.getFulfillmentGroupItems();
    assertEquals(1, fulfillmentGroupItems.size());
    assertTrue(fulfillmentGroupImpl.getDiscreteOrderItems().isEmpty());
    assertSame(fulfillmentGroupItem, fulfillmentGroupItems.get(0));
  }

  /**
   * Method under test:
   * {@link FulfillmentGroupImpl#addFulfillmentGroupItem(FulfillmentGroupItem)}
   */
  @Test
  public void testAddFulfillmentGroupItem3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    FulfillmentGroupItemImpl fulfillmentGroupItem = mock(FulfillmentGroupItemImpl.class);

    // Act
    fulfillmentGroupImpl.addFulfillmentGroupItem(fulfillmentGroupItem);

    // Assert
    List<FulfillmentGroupItem> fulfillmentGroupItems = fulfillmentGroupImpl.getFulfillmentGroupItems();
    assertEquals(1, fulfillmentGroupItems.size());
    assertTrue(fulfillmentGroupImpl.getDiscreteOrderItems().isEmpty());
    assertSame(fulfillmentGroupItem, fulfillmentGroupItems.get(0));
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getRetailFulfillmentPrice()}
   */
  @Test
  public void testGetRetailFulfillmentPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FulfillmentGroupImpl()).getRetailFulfillmentPrice());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getRetailFulfillmentPrice()}
   */
  @Test
  public void testGetRetailFulfillmentPrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemQualifierImpl.serialVersionUID);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAdjustments(new ArrayList<>());
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
    order.setCurrency(null);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setOrder(order);

    // Act and Assert
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getRetailFulfillmentPrice());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getRetailFulfillmentPrice()}
   */
  @Test
  public void testGetRetailFulfillmentPrice3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setRetailFulfillmentPrice(mock(Money.class));

    // Act and Assert
    assertNull(fulfillmentGroupImpl.getRetailFulfillmentPrice());
  }

  /**
   * Method under test:
   * {@link FulfillmentGroupImpl#setRetailFulfillmentPrice(Money)}
   */
  @Test
  public void testSetRetailFulfillmentPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    Money retailFulfillmentPrice = new Money();

    // Act
    fulfillmentGroupImpl.setRetailFulfillmentPrice(retailFulfillmentPrice);

    // Assert
    BigDecimal expectedAmount = new BigDecimal("0.00");
    BigDecimal amount = retailFulfillmentPrice.getAmount();
    assertEquals(expectedAmount, amount);
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupImpl.retailFulfillmentPrice);
    assertEquals(retailFulfillmentPrice, retailFulfillmentPrice.abs());
    assertEquals(retailFulfillmentPrice, retailFulfillmentPrice.zero());
    assertSame(fulfillmentGroupImpl.retailFulfillmentPrice, amount);
  }

  /**
   * Method under test:
   * {@link FulfillmentGroupImpl#setRetailFulfillmentPrice(Money)}
   */
  @Test
  public void testSetRetailFulfillmentPrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);

    // Act
    fulfillmentGroupImpl.setRetailFulfillmentPrice(null);

    // Assert
    assertNull(fulfillmentGroupImpl.retailFulfillmentPrice);
    assertNull(fulfillmentGroupImpl.getRetailFulfillmentPrice());
    assertNull(fulfillmentGroupImpl.getRetailShippingPrice());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getFulfillmentGroupAdjustmentsValue());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getFulfillmentPrice());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getTotalTax());
  }

  /**
   * Method under test:
   * {@link FulfillmentGroupImpl#setRetailFulfillmentPrice(Money)}
   */
  @Test
  public void testSetRetailFulfillmentPrice3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();

    // Act
    fulfillmentGroupImpl.setRetailFulfillmentPrice(mock(Money.class));

    // Assert
    assertNull(fulfillmentGroupImpl.retailFulfillmentPrice);
    assertNull(fulfillmentGroupImpl.getFulfillmentPrice());
    assertNull(fulfillmentGroupImpl.getRetailFulfillmentPrice());
    assertNull(fulfillmentGroupImpl.getRetailShippingPrice());
    assertNull(fulfillmentGroupImpl.getTotalTax());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getRetailShippingPrice()}
   */
  @Test
  public void testGetRetailShippingPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FulfillmentGroupImpl()).getRetailShippingPrice());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getRetailShippingPrice()}
   */
  @Test
  public void testGetRetailShippingPrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemQualifierImpl.serialVersionUID);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAdjustments(new ArrayList<>());
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
    order.setCurrency(null);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setOrder(order);

    // Act and Assert
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getRetailShippingPrice());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getRetailShippingPrice()}
   */
  @Test
  public void testGetRetailShippingPrice3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setRetailFulfillmentPrice(mock(Money.class));

    // Act and Assert
    assertNull(fulfillmentGroupImpl.getRetailShippingPrice());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#setRetailShippingPrice(Money)}
   */
  @Test
  public void testSetRetailShippingPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    Money retailShippingPrice = new Money();

    // Act
    fulfillmentGroupImpl.setRetailShippingPrice(retailShippingPrice);

    // Assert
    BigDecimal expectedAmount = new BigDecimal("0.00");
    BigDecimal amount = retailShippingPrice.getAmount();
    assertEquals(expectedAmount, amount);
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupImpl.retailFulfillmentPrice);
    assertEquals(retailShippingPrice, retailShippingPrice.abs());
    assertEquals(retailShippingPrice, retailShippingPrice.zero());
    assertSame(fulfillmentGroupImpl.retailFulfillmentPrice, amount);
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#setRetailShippingPrice(Money)}
   */
  @Test
  public void testSetRetailShippingPrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);

    // Act
    fulfillmentGroupImpl.setRetailShippingPrice(null);

    // Assert
    assertNull(fulfillmentGroupImpl.retailFulfillmentPrice);
    assertNull(fulfillmentGroupImpl.getRetailFulfillmentPrice());
    assertNull(fulfillmentGroupImpl.getRetailShippingPrice());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getFulfillmentGroupAdjustmentsValue());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getFulfillmentPrice());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getTotalTax());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#setRetailShippingPrice(Money)}
   */
  @Test
  public void testSetRetailShippingPrice3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();

    // Act
    fulfillmentGroupImpl.setRetailShippingPrice(mock(Money.class));

    // Assert
    assertNull(fulfillmentGroupImpl.retailFulfillmentPrice);
    assertNull(fulfillmentGroupImpl.getFulfillmentPrice());
    assertNull(fulfillmentGroupImpl.getRetailFulfillmentPrice());
    assertNull(fulfillmentGroupImpl.getRetailShippingPrice());
    assertNull(fulfillmentGroupImpl.getTotalTax());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getType()}
   */
  @Test
  public void testGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FulfillmentGroupImpl()).getType());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getType()}
   */
  @Test
  public void testGetType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.addFulfillmentGroupItem(mock(FulfillmentGroupItemImpl.class));

    // Act and Assert
    assertNull(fulfillmentGroupImpl.getType());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#setType(FulfillmentType)}
   */
  @Test
  public void testSetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    FulfillmentType type = FulfillmentType.DIGITAL;

    // Act
    fulfillmentGroupImpl.setType(type);

    // Assert
    assertEquals("DIGITAL", fulfillmentGroupImpl.type);
    assertNull(fulfillmentGroupImpl.getTotalTax());
    FulfillmentType expectedType = type.DIGITAL;
    assertSame(expectedType, fulfillmentGroupImpl.getType());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#setType(FulfillmentType)}
   */
  @Test
  public void testSetType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);

    // Act
    fulfillmentGroupImpl.setType(null);

    // Assert
    assertNull(fulfillmentGroupImpl.type);
    assertNull(fulfillmentGroupImpl.getType());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getTotalTax());
  }

  /**
   * Method under test:
   * {@link FulfillmentGroupImpl#addCandidateFulfillmentGroupOffer(CandidateFulfillmentGroupOffer)}
   */
  @Test
  public void testAddCandidateFulfillmentGroupOffer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    CandidateFulfillmentGroupOfferImpl candidateOffer = new CandidateFulfillmentGroupOfferImpl();

    // Act
    fulfillmentGroupImpl.addCandidateFulfillmentGroupOffer(candidateOffer);

    // Assert
    List<CandidateFulfillmentGroupOffer> candidateFulfillmentGroupOffers = fulfillmentGroupImpl
        .getCandidateFulfillmentGroupOffers();
    assertEquals(1, candidateFulfillmentGroupOffers.size());
    assertTrue(fulfillmentGroupImpl.getFulfillmentGroupAdjustments().isEmpty());
    assertTrue(fulfillmentGroupImpl.getFulfillmentGroupFees().isEmpty());
    assertTrue(fulfillmentGroupImpl.getFulfillmentGroupItems().isEmpty());
    assertTrue(fulfillmentGroupImpl.getFutureCreditFulfillmentGroupAdjustments().isEmpty());
    assertTrue(fulfillmentGroupImpl.getTaxes().isEmpty());
    assertSame(candidateOffer, candidateFulfillmentGroupOffers.get(0));
  }

  /**
   * Method under test:
   * {@link FulfillmentGroupImpl#addCandidateFulfillmentGroupOffer(CandidateFulfillmentGroupOffer)}
   */
  @Test
  public void testAddCandidateFulfillmentGroupOffer2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    CandidateFulfillmentGroupOfferImpl candidateOffer = mock(CandidateFulfillmentGroupOfferImpl.class);

    // Act
    fulfillmentGroupImpl.addCandidateFulfillmentGroupOffer(candidateOffer);

    // Assert
    List<CandidateFulfillmentGroupOffer> candidateFulfillmentGroupOffers = fulfillmentGroupImpl
        .getCandidateFulfillmentGroupOffers();
    assertEquals(1, candidateFulfillmentGroupOffers.size());
    assertTrue(fulfillmentGroupImpl.getFulfillmentGroupAdjustments().isEmpty());
    assertTrue(fulfillmentGroupImpl.getFulfillmentGroupFees().isEmpty());
    assertTrue(fulfillmentGroupImpl.getFulfillmentGroupItems().isEmpty());
    assertTrue(fulfillmentGroupImpl.getFutureCreditFulfillmentGroupAdjustments().isEmpty());
    assertTrue(fulfillmentGroupImpl.getTaxes().isEmpty());
    assertSame(candidateOffer, candidateFulfillmentGroupOffers.get(0));
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#removeAllCandidateOffers()}
   */
  @Test
  public void testRemoveAllCandidateOffers() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();

    // Act
    fulfillmentGroupImpl.removeAllCandidateOffers();

    // Assert
    assertNull(fulfillmentGroupImpl.getTotalTax());
    assertTrue(fulfillmentGroupImpl.getCandidateFulfillmentGroupOffers().isEmpty());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#removeAllCandidateOffers()}
   */
  @Test
  public void testRemoveAllCandidateOffers2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(null);

    // Act
    fulfillmentGroupImpl.removeAllCandidateOffers();

    // Assert that nothing has changed
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getTotalTax());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#removeAllCandidateOffers()}
   */
  @Test
  public void testRemoveAllCandidateOffers3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<CandidateFulfillmentGroupOffer> candidateOffers = new ArrayList<>();
    candidateOffers.add(new CandidateFulfillmentGroupOfferImpl());

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(candidateOffers);

    // Act
    fulfillmentGroupImpl.removeAllCandidateOffers();

    // Assert
    List<CandidateFulfillmentGroupOffer> candidateFulfillmentGroupOffers = fulfillmentGroupImpl
        .getCandidateFulfillmentGroupOffers();
    assertTrue(candidateFulfillmentGroupOffers.isEmpty());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getTotalTax());
    assertSame(candidateOffers, candidateFulfillmentGroupOffers);
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#removeAllCandidateOffers()}
   */
  @Test
  public void testRemoveAllCandidateOffers4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(mock(AddressImpl.class));
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(null);

    // Act
    fulfillmentGroupImpl.removeAllCandidateOffers();

    // Assert that nothing has changed
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getTotalTax());
  }

  /**
   * Method under test:
   * {@link FulfillmentGroupImpl#getFutureCreditFulfillmentGroupAdjustments()}
   */
  @Test
  public void testGetFutureCreditFulfillmentGroupAdjustments() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new FulfillmentGroupImpl()).getFutureCreditFulfillmentGroupAdjustments().isEmpty());
  }

  /**
   * Method under test:
   * {@link FulfillmentGroupImpl#getFutureCreditFulfillmentGroupAdjustments()}
   */
  @Test
  public void testGetFutureCreditFulfillmentGroupAdjustments2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<FulfillmentGroupAdjustment> fulfillmentGroupAdjustments = new ArrayList<>();
    fulfillmentGroupAdjustments.add(new FulfillmentGroupAdjustmentImpl());

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(fulfillmentGroupAdjustments);

    // Act and Assert
    assertTrue(fulfillmentGroupImpl.getFutureCreditFulfillmentGroupAdjustments().isEmpty());
  }

  /**
   * Method under test:
   * {@link FulfillmentGroupImpl#getFutureCreditFulfillmentGroupAdjustments()}
   */
  @Test
  public void testGetFutureCreditFulfillmentGroupAdjustments3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<FulfillmentGroupAdjustment> fulfillmentGroupAdjustments = new ArrayList<>();
    fulfillmentGroupAdjustments.add(new FulfillmentGroupAdjustmentImpl());

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(mock(Address.class));
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(fulfillmentGroupAdjustments);

    // Act and Assert
    assertTrue(fulfillmentGroupImpl.getFutureCreditFulfillmentGroupAdjustments().isEmpty());
  }

  /**
   * Method under test:
   * {@link FulfillmentGroupImpl#getFutureCreditFulfillmentGroupAdjustments()}
   */
  @Test
  public void testGetFutureCreditFulfillmentGroupAdjustments4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl = mock(FulfillmentGroupAdjustmentImpl.class);
    when(fulfillmentGroupAdjustmentImpl.isFutureCredit()).thenReturn(true);

    ArrayList<FulfillmentGroupAdjustment> fulfillmentGroupAdjustments = new ArrayList<>();
    fulfillmentGroupAdjustments.add(fulfillmentGroupAdjustmentImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(fulfillmentGroupAdjustments);

    // Act
    List<FulfillmentGroupAdjustment> actualFutureCreditFulfillmentGroupAdjustments = fulfillmentGroupImpl
        .getFutureCreditFulfillmentGroupAdjustments();

    // Assert
    verify(fulfillmentGroupAdjustmentImpl).isFutureCredit();
    assertEquals(1, actualFutureCreditFulfillmentGroupAdjustments.size());
  }

  /**
   * Method under test:
   * {@link FulfillmentGroupImpl#getFulfillmentGroupAdjustmentsValue()}
   */
  @Test
  public void testGetFulfillmentGroupAdjustmentsValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);

    // Act
    Money actualFulfillmentGroupAdjustmentsValue = fulfillmentGroupImpl.getFulfillmentGroupAdjustmentsValue();

    // Assert
    assertEquals(actualFulfillmentGroupAdjustmentsValue.ZERO, actualFulfillmentGroupAdjustmentsValue);
  }

  /**
   * Method under test:
   * {@link FulfillmentGroupImpl#getFulfillmentGroupAdjustmentsValue()}
   */
  @Test
  public void testGetFulfillmentGroupAdjustmentsValue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setOrder(order);

    // Act
    Money actualFulfillmentGroupAdjustmentsValue = fulfillmentGroupImpl.getFulfillmentGroupAdjustmentsValue();

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    Currency currency = actualFulfillmentGroupAdjustmentsValue.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, actualFulfillmentGroupAdjustmentsValue.getAmount());
    assertEquals(actualFulfillmentGroupAdjustmentsValue, actualFulfillmentGroupAdjustmentsValue.abs());
    assertEquals(actualFulfillmentGroupAdjustmentsValue, actualFulfillmentGroupAdjustmentsValue.zero());
  }

  /**
   * Method under test:
   * {@link FulfillmentGroupImpl#getFulfillmentGroupAdjustmentsValue()}
   */
  @Test
  public void testGetFulfillmentGroupAdjustmentsValue3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl = mock(FulfillmentGroupAdjustmentImpl.class);
    when(fulfillmentGroupAdjustmentImpl.isFutureCredit()).thenReturn(true);
    doNothing().when(fulfillmentGroupAdjustmentImpl).setFulfillmentGroup(Mockito.<FulfillmentGroup>any());
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(mock(FulfillmentGroup.class));

    ArrayList<FulfillmentGroupAdjustment> fulfillmentGroupAdjustments = new ArrayList<>();
    fulfillmentGroupAdjustments.add(fulfillmentGroupAdjustmentImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(fulfillmentGroupAdjustments);
    fulfillmentGroupImpl.setOrder(order);

    // Act
    Money actualFulfillmentGroupAdjustmentsValue = fulfillmentGroupImpl.getFulfillmentGroupAdjustmentsValue();

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(fulfillmentGroupAdjustmentImpl).isFutureCredit();
    verify(fulfillmentGroupAdjustmentImpl).setFulfillmentGroup(isA(FulfillmentGroup.class));
    verify(order).getCurrency();
    Currency currency = actualFulfillmentGroupAdjustmentsValue.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, actualFulfillmentGroupAdjustmentsValue.getAmount());
    assertEquals(actualFulfillmentGroupAdjustmentsValue, actualFulfillmentGroupAdjustmentsValue.abs());
    assertEquals(actualFulfillmentGroupAdjustmentsValue, actualFulfillmentGroupAdjustmentsValue.zero());
  }

  /**
   * Method under test:
   * {@link FulfillmentGroupImpl#getFutureCreditFulfillmentGroupAdjustmentsValue()}
   */
  @Test
  public void testGetFutureCreditFulfillmentGroupAdjustmentsValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);

    // Act
    Money actualFutureCreditFulfillmentGroupAdjustmentsValue = fulfillmentGroupImpl
        .getFutureCreditFulfillmentGroupAdjustmentsValue();

    // Assert
    assertEquals(actualFutureCreditFulfillmentGroupAdjustmentsValue.ZERO,
        actualFutureCreditFulfillmentGroupAdjustmentsValue);
  }

  /**
   * Method under test:
   * {@link FulfillmentGroupImpl#getFutureCreditFulfillmentGroupAdjustmentsValue()}
   */
  @Test
  public void testGetFutureCreditFulfillmentGroupAdjustmentsValue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setOrder(order);

    // Act
    Money actualFutureCreditFulfillmentGroupAdjustmentsValue = fulfillmentGroupImpl
        .getFutureCreditFulfillmentGroupAdjustmentsValue();

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    Currency currency = actualFutureCreditFulfillmentGroupAdjustmentsValue.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, actualFutureCreditFulfillmentGroupAdjustmentsValue.getAmount());
    assertEquals(actualFutureCreditFulfillmentGroupAdjustmentsValue,
        actualFutureCreditFulfillmentGroupAdjustmentsValue.abs());
    assertEquals(actualFutureCreditFulfillmentGroupAdjustmentsValue,
        actualFutureCreditFulfillmentGroupAdjustmentsValue.zero());
  }

  /**
   * Method under test:
   * {@link FulfillmentGroupImpl#getFutureCreditFulfillmentGroupAdjustmentsValue()}
   */
  @Test
  public void testGetFutureCreditFulfillmentGroupAdjustmentsValue3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    ArrayList<FulfillmentGroupAdjustment> fulfillmentGroupAdjustments = new ArrayList<>();
    fulfillmentGroupAdjustments.add(new FulfillmentGroupAdjustmentImpl());

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(fulfillmentGroupAdjustments);
    fulfillmentGroupImpl.setOrder(order);

    // Act
    Money actualFutureCreditFulfillmentGroupAdjustmentsValue = fulfillmentGroupImpl
        .getFutureCreditFulfillmentGroupAdjustmentsValue();

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    Currency currency = actualFutureCreditFulfillmentGroupAdjustmentsValue.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, actualFutureCreditFulfillmentGroupAdjustmentsValue.getAmount());
    assertEquals(actualFutureCreditFulfillmentGroupAdjustmentsValue,
        actualFutureCreditFulfillmentGroupAdjustmentsValue.abs());
    assertEquals(actualFutureCreditFulfillmentGroupAdjustmentsValue,
        actualFutureCreditFulfillmentGroupAdjustmentsValue.zero());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#removeAllAdjustments()}
   */
  @Test
  public void testRemoveAllAdjustments() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();

    // Act
    fulfillmentGroupImpl.removeAllAdjustments();

    // Assert
    assertNull(fulfillmentGroupImpl.getFulfillmentPrice());
    assertNull(fulfillmentGroupImpl.getMerchandiseTotal());
    assertNull(fulfillmentGroupImpl.getRetailFulfillmentPrice());
    assertNull(fulfillmentGroupImpl.getRetailShippingPrice());
    assertNull(fulfillmentGroupImpl.getSaleFulfillmentPrice());
    assertNull(fulfillmentGroupImpl.getSaleShippingPrice());
    assertNull(fulfillmentGroupImpl.getShippingPrice());
    assertNull(fulfillmentGroupImpl.getTotal());
    assertNull(fulfillmentGroupImpl.getTotalFeeTax());
    assertNull(fulfillmentGroupImpl.getTotalFulfillmentGroupTax());
    assertNull(fulfillmentGroupImpl.getTotalItemTax());
    assertNull(fulfillmentGroupImpl.getTotalTax());
    assertNull(fulfillmentGroupImpl.getOrder());
    assertTrue(fulfillmentGroupImpl.getFulfillmentGroupAdjustments().isEmpty());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#removeAllAdjustments()}
   */
  @Test
  public void testRemoveAllAdjustments2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    Money totalTax = new Money();
    fulfillmentGroupImpl.setTotalTax(totalTax);
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(null);

    // Act
    fulfillmentGroupImpl.removeAllAdjustments();

    // Assert that nothing has changed
    Order order = fulfillmentGroupImpl.getOrder();
    assertTrue(order instanceof NullOrderImpl);
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getFulfillmentPrice());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getMerchandiseTotal());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getRetailFulfillmentPrice());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getRetailShippingPrice());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getSaleFulfillmentPrice());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getSaleShippingPrice());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getShippingPrice());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getTotal());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getTotalFeeTax());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getTotalFulfillmentGroupTax());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getTotalItemTax());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getTotalTax());
    assertEquals(fulfillmentPrice, order.getSubTotal());
    Money expectedOrderAdjustmentsValue = totalTax.ZERO;
    assertSame(expectedOrderAdjustmentsValue, order.getOrderAdjustmentsValue());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#removeAllAdjustments()}
   */
  @Test
  public void testRemoveAllAdjustments3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<FulfillmentGroupAdjustment> fulfillmentGroupAdjustments = new ArrayList<>();
    fulfillmentGroupAdjustments.add(new FulfillmentGroupAdjustmentImpl());

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    Money totalTax = new Money();
    fulfillmentGroupImpl.setTotalTax(totalTax);
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(fulfillmentGroupAdjustments);

    // Act
    fulfillmentGroupImpl.removeAllAdjustments();

    // Assert
    Order order = fulfillmentGroupImpl.getOrder();
    assertTrue(order instanceof NullOrderImpl);
    List<FulfillmentGroupAdjustment> fulfillmentGroupAdjustments2 = fulfillmentGroupImpl
        .getFulfillmentGroupAdjustments();
    assertTrue(fulfillmentGroupAdjustments2.isEmpty());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getFulfillmentGroupAdjustmentsValue());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getFulfillmentPrice());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getFutureCreditFulfillmentGroupAdjustmentsValue());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getMerchandiseTotal());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getRetailFulfillmentPrice());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getRetailShippingPrice());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getSaleFulfillmentPrice());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getSaleShippingPrice());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getShippingPrice());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getTotal());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getTotalFeeTax());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getTotalFulfillmentGroupTax());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getTotalItemTax());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getTotalTax());
    assertEquals(fulfillmentPrice, order.getSubTotal());
    assertSame(fulfillmentGroupAdjustments, fulfillmentGroupAdjustments2);
    Money expectedOrderAdjustmentsValue = totalTax.ZERO;
    assertSame(expectedOrderAdjustmentsValue, order.getOrderAdjustmentsValue());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#removeAllAdjustments()}
   */
  @Test
  public void testRemoveAllAdjustments4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(mock(AddressImpl.class));
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    Money totalTax = new Money();
    fulfillmentGroupImpl.setTotalTax(totalTax);
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(null);

    // Act
    fulfillmentGroupImpl.removeAllAdjustments();

    // Assert that nothing has changed
    Order order = fulfillmentGroupImpl.getOrder();
    assertTrue(order instanceof NullOrderImpl);
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getFulfillmentPrice());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getMerchandiseTotal());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getRetailFulfillmentPrice());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getRetailShippingPrice());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getSaleFulfillmentPrice());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getSaleShippingPrice());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getShippingPrice());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getTotal());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getTotalFeeTax());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getTotalFulfillmentGroupTax());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getTotalItemTax());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getTotalTax());
    assertEquals(fulfillmentPrice, order.getSubTotal());
    Money expectedOrderAdjustmentsValue = totalTax.ZERO;
    assertSame(expectedOrderAdjustmentsValue, order.getOrderAdjustmentsValue());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getSaleFulfillmentPrice()}
   */
  @Test
  public void testGetSaleFulfillmentPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FulfillmentGroupImpl()).getSaleFulfillmentPrice());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getSaleFulfillmentPrice()}
   */
  @Test
  public void testGetSaleFulfillmentPrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemQualifierImpl.serialVersionUID);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAdjustments(new ArrayList<>());
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
    order.setCurrency(null);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setOrder(order);

    // Act and Assert
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getSaleFulfillmentPrice());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getSaleFulfillmentPrice()}
   */
  @Test
  public void testGetSaleFulfillmentPrice3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setSaleFulfillmentPrice(mock(Money.class));

    // Act and Assert
    assertNull(fulfillmentGroupImpl.getSaleFulfillmentPrice());
  }

  /**
   * Method under test:
   * {@link FulfillmentGroupImpl#setSaleFulfillmentPrice(Money)}
   */
  @Test
  public void testSetSaleFulfillmentPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    Money saleFulfillmentPrice = new Money();

    // Act
    fulfillmentGroupImpl.setSaleFulfillmentPrice(saleFulfillmentPrice);

    // Assert
    BigDecimal expectedAmount = new BigDecimal("0.00");
    BigDecimal amount = saleFulfillmentPrice.getAmount();
    assertEquals(expectedAmount, amount);
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupImpl.saleFulfillmentPrice);
    assertEquals(saleFulfillmentPrice, saleFulfillmentPrice.abs());
    assertEquals(saleFulfillmentPrice, saleFulfillmentPrice.zero());
    assertSame(fulfillmentGroupImpl.saleFulfillmentPrice, amount);
  }

  /**
   * Method under test:
   * {@link FulfillmentGroupImpl#setSaleFulfillmentPrice(Money)}
   */
  @Test
  public void testSetSaleFulfillmentPrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);

    // Act
    fulfillmentGroupImpl.setSaleFulfillmentPrice(null);

    // Assert
    assertNull(fulfillmentGroupImpl.saleFulfillmentPrice);
    assertNull(fulfillmentGroupImpl.getSaleFulfillmentPrice());
    assertNull(fulfillmentGroupImpl.getSaleShippingPrice());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getFulfillmentGroupAdjustmentsValue());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getFulfillmentPrice());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getTotalTax());
  }

  /**
   * Method under test:
   * {@link FulfillmentGroupImpl#setSaleFulfillmentPrice(Money)}
   */
  @Test
  public void testSetSaleFulfillmentPrice3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();

    // Act
    fulfillmentGroupImpl.setSaleFulfillmentPrice(mock(Money.class));

    // Assert
    assertNull(fulfillmentGroupImpl.saleFulfillmentPrice);
    assertNull(fulfillmentGroupImpl.getFulfillmentPrice());
    assertNull(fulfillmentGroupImpl.getSaleFulfillmentPrice());
    assertNull(fulfillmentGroupImpl.getSaleShippingPrice());
    assertNull(fulfillmentGroupImpl.getTotalTax());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getSaleShippingPrice()}
   */
  @Test
  public void testGetSaleShippingPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FulfillmentGroupImpl()).getSaleShippingPrice());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getSaleShippingPrice()}
   */
  @Test
  public void testGetSaleShippingPrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemQualifierImpl.serialVersionUID);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAdjustments(new ArrayList<>());
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
    order.setCurrency(null);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setOrder(order);

    // Act and Assert
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getSaleShippingPrice());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getSaleShippingPrice()}
   */
  @Test
  public void testGetSaleShippingPrice3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setSaleFulfillmentPrice(mock(Money.class));

    // Act and Assert
    assertNull(fulfillmentGroupImpl.getSaleShippingPrice());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#setSaleShippingPrice(Money)}
   */
  @Test
  public void testSetSaleShippingPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    Money saleShippingPrice = new Money();

    // Act
    fulfillmentGroupImpl.setSaleShippingPrice(saleShippingPrice);

    // Assert
    BigDecimal expectedAmount = new BigDecimal("0.00");
    BigDecimal amount = saleShippingPrice.getAmount();
    assertEquals(expectedAmount, amount);
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupImpl.saleFulfillmentPrice);
    assertEquals(saleShippingPrice, saleShippingPrice.abs());
    assertEquals(saleShippingPrice, saleShippingPrice.zero());
    assertSame(fulfillmentGroupImpl.saleFulfillmentPrice, amount);
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#setSaleShippingPrice(Money)}
   */
  @Test
  public void testSetSaleShippingPrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);

    // Act
    fulfillmentGroupImpl.setSaleShippingPrice(null);

    // Assert
    assertNull(fulfillmentGroupImpl.saleFulfillmentPrice);
    assertNull(fulfillmentGroupImpl.getSaleFulfillmentPrice());
    assertNull(fulfillmentGroupImpl.getSaleShippingPrice());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getFulfillmentGroupAdjustmentsValue());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getFulfillmentPrice());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getTotalTax());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#setSaleShippingPrice(Money)}
   */
  @Test
  public void testSetSaleShippingPrice3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();

    // Act
    fulfillmentGroupImpl.setSaleShippingPrice(mock(Money.class));

    // Assert
    assertNull(fulfillmentGroupImpl.saleFulfillmentPrice);
    assertNull(fulfillmentGroupImpl.getFulfillmentPrice());
    assertNull(fulfillmentGroupImpl.getSaleFulfillmentPrice());
    assertNull(fulfillmentGroupImpl.getSaleShippingPrice());
    assertNull(fulfillmentGroupImpl.getTotalTax());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getFulfillmentPrice()}
   */
  @Test
  public void testGetFulfillmentPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FulfillmentGroupImpl()).getFulfillmentPrice());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getFulfillmentPrice()}
   */
  @Test
  public void testGetFulfillmentPrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemQualifierImpl.serialVersionUID);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAdjustments(new ArrayList<>());
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
    order.setCurrency(null);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    Money merchandiseTotal = new Money();
    fulfillmentGroupImpl.setMerchandiseTotal(merchandiseTotal);
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setOrder(order);

    // Act and Assert
    assertEquals(merchandiseTotal, fulfillmentGroupImpl.getFulfillmentPrice());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getFulfillmentPrice()}
   */
  @Test
  public void testGetFulfillmentPrice3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setFulfillmentPrice(mock(Money.class));

    // Act and Assert
    assertNull(fulfillmentGroupImpl.getFulfillmentPrice());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#setFulfillmentPrice(Money)}
   */
  @Test
  public void testSetFulfillmentPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    Money fulfillmentPrice = new Money();

    // Act
    fulfillmentGroupImpl.setFulfillmentPrice(fulfillmentPrice);

    // Assert
    BigDecimal expectedAmount = new BigDecimal("0.00");
    BigDecimal amount = fulfillmentPrice.getAmount();
    assertEquals(expectedAmount, amount);
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupImpl.fulfillmentPrice);
    assertEquals(fulfillmentPrice, fulfillmentPrice.abs());
    assertEquals(fulfillmentPrice, fulfillmentPrice.zero());
    assertSame(fulfillmentGroupImpl.fulfillmentPrice, amount);
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#setFulfillmentPrice(Money)}
   */
  @Test
  public void testSetFulfillmentPrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);

    // Act
    fulfillmentGroupImpl.setFulfillmentPrice(null);

    // Assert
    assertNull(fulfillmentGroupImpl.fulfillmentPrice);
    assertNull(fulfillmentGroupImpl.getFulfillmentPrice());
    assertNull(fulfillmentGroupImpl.getShippingPrice());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getFulfillmentGroupAdjustmentsValue());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getFutureCreditFulfillmentGroupAdjustmentsValue());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getTotalTax());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#setFulfillmentPrice(Money)}
   */
  @Test
  public void testSetFulfillmentPrice3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();

    // Act
    fulfillmentGroupImpl.setFulfillmentPrice(mock(Money.class));

    // Assert
    assertNull(fulfillmentGroupImpl.fulfillmentPrice);
    assertNull(fulfillmentGroupImpl.getFulfillmentPrice());
    assertNull(fulfillmentGroupImpl.getShippingPrice());
    assertNull(fulfillmentGroupImpl.getTotalTax());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getShippingPrice()}
   */
  @Test
  public void testGetShippingPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FulfillmentGroupImpl()).getShippingPrice());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getShippingPrice()}
   */
  @Test
  public void testGetShippingPrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemQualifierImpl.serialVersionUID);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAdjustments(new ArrayList<>());
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
    order.setCurrency(null);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    Money merchandiseTotal = new Money();
    fulfillmentGroupImpl.setMerchandiseTotal(merchandiseTotal);
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setOrder(order);

    // Act and Assert
    assertEquals(merchandiseTotal, fulfillmentGroupImpl.getShippingPrice());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getShippingPrice()}
   */
  @Test
  public void testGetShippingPrice3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setFulfillmentPrice(mock(Money.class));

    // Act and Assert
    assertNull(fulfillmentGroupImpl.getShippingPrice());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#setShippingPrice(Money)}
   */
  @Test
  public void testSetShippingPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    Money shippingPrice = new Money();

    // Act
    fulfillmentGroupImpl.setShippingPrice(shippingPrice);

    // Assert
    BigDecimal expectedAmount = new BigDecimal("0.00");
    BigDecimal amount = shippingPrice.getAmount();
    assertEquals(expectedAmount, amount);
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupImpl.fulfillmentPrice);
    assertEquals(shippingPrice, shippingPrice.abs());
    assertEquals(shippingPrice, shippingPrice.zero());
    assertSame(fulfillmentGroupImpl.fulfillmentPrice, amount);
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#setShippingPrice(Money)}
   */
  @Test
  public void testSetShippingPrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);

    // Act
    fulfillmentGroupImpl.setShippingPrice(null);

    // Assert
    assertNull(fulfillmentGroupImpl.fulfillmentPrice);
    assertNull(fulfillmentGroupImpl.getFulfillmentPrice());
    assertNull(fulfillmentGroupImpl.getShippingPrice());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getFulfillmentGroupAdjustmentsValue());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getFutureCreditFulfillmentGroupAdjustmentsValue());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getTotalTax());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#setShippingPrice(Money)}
   */
  @Test
  public void testSetShippingPrice3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();

    // Act
    fulfillmentGroupImpl.setShippingPrice(mock(Money.class));

    // Assert
    assertNull(fulfillmentGroupImpl.fulfillmentPrice);
    assertNull(fulfillmentGroupImpl.getFulfillmentPrice());
    assertNull(fulfillmentGroupImpl.getShippingPrice());
    assertNull(fulfillmentGroupImpl.getTotalTax());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getTotalTax()}
   */
  @Test
  public void testGetTotalTax() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FulfillmentGroupImpl()).getTotalTax());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getTotalTax()}
   */
  @Test
  public void testGetTotalTax2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemQualifierImpl.serialVersionUID);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAdjustments(new ArrayList<>());
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
    order.setCurrency(null);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setOrder(order);

    // Act and Assert
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getTotalTax());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getTotalTax()}
   */
  @Test
  public void testGetTotalTax3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setTotalTax(mock(Money.class));

    // Act and Assert
    assertNull(fulfillmentGroupImpl.getTotalTax());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#setTotalTax(Money)}
   */
  @Test
  public void testSetTotalTax() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    Money totalTax = new Money();

    // Act
    fulfillmentGroupImpl.setTotalTax(totalTax);

    // Assert
    BigDecimal expectedAmount = new BigDecimal("0.00");
    BigDecimal amount = totalTax.getAmount();
    assertEquals(expectedAmount, amount);
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupImpl.totalTax);
    assertEquals(totalTax, totalTax.abs());
    assertEquals(totalTax, totalTax.zero());
    assertSame(fulfillmentGroupImpl.totalTax, amount);
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#setTotalTax(Money)}
   */
  @Test
  public void testSetTotalTax2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);

    // Act
    fulfillmentGroupImpl.setTotalTax(null);

    // Assert
    assertNull(fulfillmentGroupImpl.totalTax);
    assertNull(fulfillmentGroupImpl.getTotalTax());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getFulfillmentGroupAdjustmentsValue());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#setTotalTax(Money)}
   */
  @Test
  public void testSetTotalTax3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();

    // Act
    fulfillmentGroupImpl.setTotalTax(mock(Money.class));

    // Assert
    assertNull(fulfillmentGroupImpl.totalTax);
    assertNull(fulfillmentGroupImpl.getTotalTax());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getTotalItemTax()}
   */
  @Test
  public void testGetTotalItemTax() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FulfillmentGroupImpl()).getTotalItemTax());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getTotalItemTax()}
   */
  @Test
  public void testGetTotalItemTax2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemQualifierImpl.serialVersionUID);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAdjustments(new ArrayList<>());
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
    order.setCurrency(null);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setOrder(order);

    // Act and Assert
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getTotalItemTax());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getTotalItemTax()}
   */
  @Test
  public void testGetTotalItemTax3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setTotalItemTax(mock(Money.class));

    // Act and Assert
    assertNull(fulfillmentGroupImpl.getTotalItemTax());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#setTotalItemTax(Money)}
   */
  @Test
  public void testSetTotalItemTax() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    Money totalItemTax = new Money();

    // Act
    fulfillmentGroupImpl.setTotalItemTax(totalItemTax);

    // Assert
    BigDecimal expectedAmount = new BigDecimal("0.00");
    BigDecimal amount = totalItemTax.getAmount();
    assertEquals(expectedAmount, amount);
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupImpl.totalItemTax);
    assertEquals(totalItemTax, totalItemTax.abs());
    assertEquals(totalItemTax, totalItemTax.zero());
    assertSame(fulfillmentGroupImpl.totalItemTax, amount);
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#setTotalItemTax(Money)}
   */
  @Test
  public void testSetTotalItemTax2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);

    // Act
    fulfillmentGroupImpl.setTotalItemTax(null);

    // Assert
    assertNull(fulfillmentGroupImpl.totalItemTax);
    assertNull(fulfillmentGroupImpl.getTotalItemTax());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getFulfillmentGroupAdjustmentsValue());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getTotalTax());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#setTotalItemTax(Money)}
   */
  @Test
  public void testSetTotalItemTax3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();

    // Act
    fulfillmentGroupImpl.setTotalItemTax(mock(Money.class));

    // Assert
    assertNull(fulfillmentGroupImpl.totalItemTax);
    assertNull(fulfillmentGroupImpl.getTotalItemTax());
    assertNull(fulfillmentGroupImpl.getTotalTax());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getTotalFeeTax()}
   */
  @Test
  public void testGetTotalFeeTax() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FulfillmentGroupImpl()).getTotalFeeTax());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getTotalFeeTax()}
   */
  @Test
  public void testGetTotalFeeTax2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemQualifierImpl.serialVersionUID);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAdjustments(new ArrayList<>());
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
    order.setCurrency(null);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setOrder(order);

    // Act and Assert
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getTotalFeeTax());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getTotalFeeTax()}
   */
  @Test
  public void testGetTotalFeeTax3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setTotalFeeTax(mock(Money.class));

    // Act and Assert
    assertNull(fulfillmentGroupImpl.getTotalFeeTax());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#setTotalFeeTax(Money)}
   */
  @Test
  public void testSetTotalFeeTax() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    Money totalFeeTax = new Money();

    // Act
    fulfillmentGroupImpl.setTotalFeeTax(totalFeeTax);

    // Assert
    BigDecimal expectedAmount = new BigDecimal("0.00");
    BigDecimal amount = totalFeeTax.getAmount();
    assertEquals(expectedAmount, amount);
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupImpl.totalFeeTax);
    assertEquals(totalFeeTax, totalFeeTax.abs());
    assertEquals(totalFeeTax, totalFeeTax.zero());
    assertSame(fulfillmentGroupImpl.totalFeeTax, amount);
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#setTotalFeeTax(Money)}
   */
  @Test
  public void testSetTotalFeeTax2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);

    // Act
    fulfillmentGroupImpl.setTotalFeeTax(null);

    // Assert
    assertNull(fulfillmentGroupImpl.totalFeeTax);
    assertNull(fulfillmentGroupImpl.getTotalFeeTax());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getFulfillmentGroupAdjustmentsValue());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getTotalTax());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#setTotalFeeTax(Money)}
   */
  @Test
  public void testSetTotalFeeTax3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();

    // Act
    fulfillmentGroupImpl.setTotalFeeTax(mock(Money.class));

    // Assert
    assertNull(fulfillmentGroupImpl.totalFeeTax);
    assertNull(fulfillmentGroupImpl.getTotalFeeTax());
    assertNull(fulfillmentGroupImpl.getTotalTax());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getTotalFulfillmentGroupTax()}
   */
  @Test
  public void testGetTotalFulfillmentGroupTax() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FulfillmentGroupImpl()).getTotalFulfillmentGroupTax());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getTotalFulfillmentGroupTax()}
   */
  @Test
  public void testGetTotalFulfillmentGroupTax2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemQualifierImpl.serialVersionUID);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAdjustments(new ArrayList<>());
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
    order.setCurrency(null);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setOrder(order);

    // Act and Assert
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getTotalFulfillmentGroupTax());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getTotalFulfillmentGroupTax()}
   */
  @Test
  public void testGetTotalFulfillmentGroupTax3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(mock(Money.class));

    // Act and Assert
    assertNull(fulfillmentGroupImpl.getTotalFulfillmentGroupTax());
  }

  /**
   * Method under test:
   * {@link FulfillmentGroupImpl#setTotalFulfillmentGroupTax(Money)}
   */
  @Test
  public void testSetTotalFulfillmentGroupTax() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    Money totalFulfillmentGroupTax = new Money();

    // Act
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(totalFulfillmentGroupTax);

    // Assert
    BigDecimal expectedAmount = new BigDecimal("0.00");
    BigDecimal amount = totalFulfillmentGroupTax.getAmount();
    assertEquals(expectedAmount, amount);
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupImpl.totalFulfillmentGroupTax);
    assertEquals(totalFulfillmentGroupTax, totalFulfillmentGroupTax.abs());
    assertEquals(totalFulfillmentGroupTax, totalFulfillmentGroupTax.zero());
    assertSame(fulfillmentGroupImpl.totalFulfillmentGroupTax, amount);
  }

  /**
   * Method under test:
   * {@link FulfillmentGroupImpl#setTotalFulfillmentGroupTax(Money)}
   */
  @Test
  public void testSetTotalFulfillmentGroupTax2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);

    // Act
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(null);

    // Assert
    assertNull(fulfillmentGroupImpl.totalFulfillmentGroupTax);
    assertNull(fulfillmentGroupImpl.getTotalFulfillmentGroupTax());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getFulfillmentGroupAdjustmentsValue());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getTotalTax());
  }

  /**
   * Method under test:
   * {@link FulfillmentGroupImpl#setTotalFulfillmentGroupTax(Money)}
   */
  @Test
  public void testSetTotalFulfillmentGroupTax3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();

    // Act
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(mock(Money.class));

    // Assert
    assertNull(fulfillmentGroupImpl.totalFulfillmentGroupTax);
    assertNull(fulfillmentGroupImpl.getTotalFulfillmentGroupTax());
    assertNull(fulfillmentGroupImpl.getTotalTax());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getMerchandiseTotal()}
   */
  @Test
  public void testGetMerchandiseTotal() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FulfillmentGroupImpl()).getMerchandiseTotal());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getMerchandiseTotal()}
   */
  @Test
  public void testGetMerchandiseTotal2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemQualifierImpl.serialVersionUID);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAdjustments(new ArrayList<>());
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
    order.setCurrency(null);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setOrder(order);

    // Act and Assert
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getMerchandiseTotal());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getMerchandiseTotal()}
   */
  @Test
  public void testGetMerchandiseTotal3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setMerchandiseTotal(mock(Money.class));

    // Act and Assert
    assertNull(fulfillmentGroupImpl.getMerchandiseTotal());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#setMerchandiseTotal(Money)}
   */
  @Test
  public void testSetMerchandiseTotal() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    Money merchandiseTotal = new Money();

    // Act
    fulfillmentGroupImpl.setMerchandiseTotal(merchandiseTotal);

    // Assert
    BigDecimal expectedAmount = new BigDecimal("0.00");
    BigDecimal amount = merchandiseTotal.getAmount();
    assertEquals(expectedAmount, amount);
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupImpl.merchandiseTotal);
    assertEquals(merchandiseTotal, merchandiseTotal.abs());
    assertEquals(merchandiseTotal, merchandiseTotal.zero());
    assertSame(fulfillmentGroupImpl.merchandiseTotal, amount);
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#setMerchandiseTotal(Money)}
   */
  @Test
  public void testSetMerchandiseTotal2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);

    // Act
    fulfillmentGroupImpl.setMerchandiseTotal(null);

    // Assert
    assertNull(fulfillmentGroupImpl.merchandiseTotal);
    assertNull(fulfillmentGroupImpl.getMerchandiseTotal());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getFulfillmentGroupAdjustmentsValue());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getTotalTax());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#setMerchandiseTotal(Money)}
   */
  @Test
  public void testSetMerchandiseTotal3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();

    // Act
    fulfillmentGroupImpl.setMerchandiseTotal(mock(Money.class));

    // Assert
    assertNull(fulfillmentGroupImpl.merchandiseTotal);
    assertNull(fulfillmentGroupImpl.getMerchandiseTotal());
    assertNull(fulfillmentGroupImpl.getTotalTax());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getTotal()}
   */
  @Test
  public void testGetTotal() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FulfillmentGroupImpl()).getTotal());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getTotal()}
   */
  @Test
  public void testGetTotal2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemQualifierImpl.serialVersionUID);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAdjustments(new ArrayList<>());
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
    order.setCurrency(null);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setOrder(order);

    // Act and Assert
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getTotal());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getTotal()}
   */
  @Test
  public void testGetTotal3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setTotal(mock(Money.class));

    // Act and Assert
    assertNull(fulfillmentGroupImpl.getTotal());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#setTotal(Money)}
   */
  @Test
  public void testSetTotal() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    Money orderTotal = new Money();

    // Act
    fulfillmentGroupImpl.setTotal(orderTotal);

    // Assert
    BigDecimal expectedAmount = new BigDecimal("0.00");
    BigDecimal amount = orderTotal.getAmount();
    assertEquals(expectedAmount, amount);
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupImpl.total);
    assertEquals(orderTotal, orderTotal.abs());
    assertEquals(orderTotal, orderTotal.zero());
    assertSame(fulfillmentGroupImpl.total, amount);
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#setTotal(Money)}
   */
  @Test
  public void testSetTotal2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);

    // Act
    fulfillmentGroupImpl.setTotal(null);

    // Assert
    assertNull(fulfillmentGroupImpl.total);
    assertNull(fulfillmentGroupImpl.getTotal());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getFulfillmentGroupAdjustmentsValue());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getTotalTax());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#setTotal(Money)}
   */
  @Test
  public void testSetTotal3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();

    // Act
    fulfillmentGroupImpl.setTotal(mock(Money.class));

    // Assert
    assertNull(fulfillmentGroupImpl.total);
    assertNull(fulfillmentGroupImpl.getTotal());
    assertNull(fulfillmentGroupImpl.getTotalTax());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getStatus()}
   */
  @Test
  public void testGetStatus() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FulfillmentGroupImpl()).getStatus());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getStatus()}
   */
  @Test
  public void testGetStatus2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.addFulfillmentGroupItem(mock(FulfillmentGroupItemImpl.class));

    // Act and Assert
    assertNull(fulfillmentGroupImpl.getStatus());
  }

  /**
   * Method under test:
   * {@link FulfillmentGroupImpl#setStatus(FulfillmentGroupStatusType)}
   */
  @Test
  public void testSetStatus() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    FulfillmentGroupStatusType status = FulfillmentGroupStatusType.CANCELLED;

    // Act
    fulfillmentGroupImpl.setStatus(status);

    // Assert
    assertEquals("CANCELLED", fulfillmentGroupImpl.status);
    FulfillmentGroupStatusType expectedStatus = status.CANCELLED;
    assertSame(expectedStatus, fulfillmentGroupImpl.getStatus());
  }

  /**
   * Method under test:
   * {@link FulfillmentGroupImpl#addFulfillmentGroupFee(FulfillmentGroupFee)}
   */
  @Test
  public void testAddFulfillmentGroupFee() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    FulfillmentGroupFeeImpl fulfillmentGroupFee = new FulfillmentGroupFeeImpl();

    // Act
    fulfillmentGroupImpl.addFulfillmentGroupFee(fulfillmentGroupFee);

    // Assert
    List<FulfillmentGroupFee> fulfillmentGroupFees = fulfillmentGroupImpl.getFulfillmentGroupFees();
    assertEquals(1, fulfillmentGroupFees.size());
    assertSame(fulfillmentGroupFee, fulfillmentGroupFees.get(0));
  }

  /**
   * Method under test:
   * {@link FulfillmentGroupImpl#addFulfillmentGroupFee(FulfillmentGroupFee)}
   */
  @Test
  public void testAddFulfillmentGroupFee2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupFees(null);
    FulfillmentGroupFeeImpl fulfillmentGroupFee = new FulfillmentGroupFeeImpl();

    // Act
    fulfillmentGroupImpl.addFulfillmentGroupFee(fulfillmentGroupFee);

    // Assert
    List<FulfillmentGroupFee> fulfillmentGroupFees = fulfillmentGroupImpl.getFulfillmentGroupFees();
    assertEquals(1, fulfillmentGroupFees.size());
    assertSame(fulfillmentGroupFee, fulfillmentGroupFees.get(0));
  }

  /**
   * Method under test:
   * {@link FulfillmentGroupImpl#addFulfillmentGroupFee(FulfillmentGroupFee)}
   */
  @Test
  public void testAddFulfillmentGroupFee3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    FulfillmentGroupFeeImpl fulfillmentGroupFee = mock(FulfillmentGroupFeeImpl.class);

    // Act
    fulfillmentGroupImpl.addFulfillmentGroupFee(fulfillmentGroupFee);

    // Assert
    List<FulfillmentGroupFee> fulfillmentGroupFees = fulfillmentGroupImpl.getFulfillmentGroupFees();
    assertEquals(1, fulfillmentGroupFees.size());
    assertSame(fulfillmentGroupFee, fulfillmentGroupFees.get(0));
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getCurrencyCode()}
   */
  @Test
  public void testGetCurrencyCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemQualifierImpl.serialVersionUID);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAdjustments(new ArrayList<>());
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
    order.setCurrency(null);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setOrder(order);

    // Act and Assert
    assertNull(fulfillmentGroupImpl.getCurrencyCode());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getCurrencyCode()}
   */
  @Test
  public void testGetCurrencyCode2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemQualifierImpl.serialVersionUID);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAdjustments(new ArrayList<>());
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
    order.setCurrency(new BroadleafCurrencyImpl());

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setOrder(order);

    // Act and Assert
    assertNull(fulfillmentGroupImpl.getCurrencyCode());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getCurrencyCode()}
   */
  @Test
  public void testGetCurrencyCode3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemQualifierImpl.serialVersionUID);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAdjustments(new ArrayList<>());
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
    order.setCurrency(null);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(mock(AddressImpl.class));
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setOrder(order);

    // Act and Assert
    assertNull(fulfillmentGroupImpl.getCurrencyCode());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getShippingOverride()}
   */
  @Test
  public void testGetShippingOverride() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new FulfillmentGroupImpl()).getShippingOverride());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getShippingOverride()}
   */
  @Test
  public void testGetShippingOverride2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setShippingOverride(true);

    // Act and Assert
    assertTrue(fulfillmentGroupImpl.getShippingOverride());
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#getShippingOverride()}
   */
  @Test
  public void testGetShippingOverride3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(mock(AddressImpl.class));
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setShippingOverride(true);

    // Act and Assert
    assertTrue(fulfillmentGroupImpl.getShippingOverride());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentGroupImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);

    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl2.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl2.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl2.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl2.setMethod("Fulfillment Method");
    fulfillmentGroupImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl2.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl2.setPhone(new PhoneImpl());
    fulfillmentGroupImpl2.setPrimary(true);
    fulfillmentGroupImpl2.setReferenceNumber("42");
    fulfillmentGroupImpl2.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl2.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl2.setSequence(1);
    fulfillmentGroupImpl2.setService("Service");
    fulfillmentGroupImpl2.setShippingOverride(true);
    fulfillmentGroupImpl2.setShippingPrice(new Money());
    fulfillmentGroupImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl2.setTotal(new Money());
    fulfillmentGroupImpl2.setTotalFeeTax(new Money());
    fulfillmentGroupImpl2.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl2.setTotalItemTax(new Money());
    fulfillmentGroupImpl2.setTotalTax(new Money());
    fulfillmentGroupImpl2.setType(FulfillmentType.DIGITAL);

    // Act and Assert
    assertEquals(fulfillmentGroupImpl, fulfillmentGroupImpl2);
    int expectedHashCodeResult = fulfillmentGroupImpl.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentGroupImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentGroupImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(mock(Address.class));
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);

    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl2.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl2.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl2.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl2.setMethod("Fulfillment Method");
    fulfillmentGroupImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl2.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl2.setPhone(new PhoneImpl());
    fulfillmentGroupImpl2.setPrimary(true);
    fulfillmentGroupImpl2.setReferenceNumber("42");
    fulfillmentGroupImpl2.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl2.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl2.setSequence(1);
    fulfillmentGroupImpl2.setService("Service");
    fulfillmentGroupImpl2.setShippingOverride(true);
    fulfillmentGroupImpl2.setShippingPrice(new Money());
    fulfillmentGroupImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl2.setTotal(new Money());
    fulfillmentGroupImpl2.setTotalFeeTax(new Money());
    fulfillmentGroupImpl2.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl2.setTotalItemTax(new Money());
    fulfillmentGroupImpl2.setTotalTax(new Money());
    fulfillmentGroupImpl2.setType(FulfillmentType.DIGITAL);

    // Act and Assert
    assertEquals(fulfillmentGroupImpl, fulfillmentGroupImpl2);
    int notExpectedHashCodeResult = fulfillmentGroupImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, fulfillmentGroupImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentGroupImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(null);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);

    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl2.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl2.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl2.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl2.setMethod("Fulfillment Method");
    fulfillmentGroupImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl2.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl2.setPhone(new PhoneImpl());
    fulfillmentGroupImpl2.setPrimary(true);
    fulfillmentGroupImpl2.setReferenceNumber("42");
    fulfillmentGroupImpl2.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl2.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl2.setSequence(1);
    fulfillmentGroupImpl2.setService("Service");
    fulfillmentGroupImpl2.setShippingOverride(true);
    fulfillmentGroupImpl2.setShippingPrice(new Money());
    fulfillmentGroupImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl2.setTotal(new Money());
    fulfillmentGroupImpl2.setTotalFeeTax(new Money());
    fulfillmentGroupImpl2.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl2.setTotalItemTax(new Money());
    fulfillmentGroupImpl2.setTotalTax(new Money());
    fulfillmentGroupImpl2.setType(FulfillmentType.DIGITAL);

    // Act and Assert
    assertEquals(fulfillmentGroupImpl, fulfillmentGroupImpl2);
    int expectedHashCodeResult = fulfillmentGroupImpl.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentGroupImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentGroupImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);

    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl2.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setId(null);
    fulfillmentGroupImpl2.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl2.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl2.setMethod("Fulfillment Method");
    fulfillmentGroupImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl2.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl2.setPhone(new PhoneImpl());
    fulfillmentGroupImpl2.setPrimary(true);
    fulfillmentGroupImpl2.setReferenceNumber("42");
    fulfillmentGroupImpl2.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl2.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl2.setSequence(1);
    fulfillmentGroupImpl2.setService("Service");
    fulfillmentGroupImpl2.setShippingOverride(true);
    fulfillmentGroupImpl2.setShippingPrice(new Money());
    fulfillmentGroupImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl2.setTotal(new Money());
    fulfillmentGroupImpl2.setTotalFeeTax(new Money());
    fulfillmentGroupImpl2.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl2.setTotalItemTax(new Money());
    fulfillmentGroupImpl2.setTotalTax(new Money());
    fulfillmentGroupImpl2.setType(FulfillmentType.DIGITAL);

    // Act and Assert
    assertEquals(fulfillmentGroupImpl, fulfillmentGroupImpl2);
    int expectedHashCodeResult = fulfillmentGroupImpl.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentGroupImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentGroupImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);

    // Act and Assert
    assertEquals(fulfillmentGroupImpl, fulfillmentGroupImpl);
    int expectedHashCodeResult = fulfillmentGroupImpl.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentGroupImpl.hashCode());
  }

  /**
   * Method under test:
   * {@link FulfillmentGroupImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<FulfillmentGroup> actualCreateOrRetrieveCopyInstanceResult = fulfillmentGroupImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService)
        .getCeilingImplClass(eq("org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    FulfillmentGroup clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof FulfillmentGroupImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(fulfillmentGroupImpl, clone);
  }

  /**
   * Method under test:
   * {@link FulfillmentGroupImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<FulfillmentGroup> actualCreateOrRetrieveCopyInstanceResult = fulfillmentGroupImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Method under test:
   * {@link FulfillmentGroupImpl#cloneTaxDetails(MultiTenantCopyContext, FulfillmentGroup)}
   */
  @Test
  public void testCloneTaxDetails() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    MultiTenantCopyContext context = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());

    FulfillmentGroupImpl cloned = new FulfillmentGroupImpl();

    // Act
    fulfillmentGroupImpl.cloneTaxDetails(context, cloned);

    // Assert that nothing has changed
    assertEquals(fulfillmentGroupImpl, cloned);
  }

  /**
   * Method under test:
   * {@link FulfillmentGroupImpl#cloneTaxDetails(MultiTenantCopyContext, FulfillmentGroup)}
   */
  @Test
  public void testCloneTaxDetails2() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    CatalogImpl fromCatalog = mock(CatalogImpl.class);
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    MultiTenantCopyContext context = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());

    FulfillmentGroupImpl cloned = new FulfillmentGroupImpl();

    // Act
    fulfillmentGroupImpl.cloneTaxDetails(context, cloned);

    // Assert that nothing has changed
    assertEquals(fulfillmentGroupImpl, cloned);
  }

  /**
   * Method under test:
   * {@link FulfillmentGroupImpl#cloneTaxDetails(MultiTenantCopyContext, FulfillmentGroup)}
   */
  @Test
  public void testCloneTaxDetails3() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TaxDetailImpl taxDetailImpl = mock(TaxDetailImpl.class);
    TaxDetailImpl taxDetailImpl2 = new TaxDetailImpl();
    when(taxDetailImpl.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(taxDetailImpl2, true));

    ArrayList<TaxDetail> taxes = new ArrayList<>();
    taxes.add(taxDetailImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setTaxes(taxes);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    MultiTenantCopyContext context = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());

    FulfillmentGroupImpl cloned = new FulfillmentGroupImpl();

    // Act
    fulfillmentGroupImpl.cloneTaxDetails(context, cloned);

    // Assert
    verify(taxDetailImpl).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    List<TaxDetail> taxes2 = cloned.getTaxes();
    assertEquals(1, taxes2.size());
    assertSame(taxDetailImpl2, taxes2.get(0));
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(2L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);

    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl2.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl2.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl2.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl2.setMethod("Fulfillment Method");
    fulfillmentGroupImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl2.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl2.setPhone(new PhoneImpl());
    fulfillmentGroupImpl2.setPrimary(true);
    fulfillmentGroupImpl2.setReferenceNumber("42");
    fulfillmentGroupImpl2.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl2.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl2.setSequence(1);
    fulfillmentGroupImpl2.setService("Service");
    fulfillmentGroupImpl2.setShippingOverride(true);
    fulfillmentGroupImpl2.setShippingPrice(new Money());
    fulfillmentGroupImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl2.setTotal(new Money());
    fulfillmentGroupImpl2.setTotalFeeTax(new Money());
    fulfillmentGroupImpl2.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl2.setTotalItemTax(new Money());
    fulfillmentGroupImpl2.setTotalTax(new Money());
    fulfillmentGroupImpl2.setType(FulfillmentType.DIGITAL);

    // Act and Assert
    assertNotEquals(fulfillmentGroupImpl, fulfillmentGroupImpl2);
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(mock(Address.class));
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(null);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);

    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl2.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl2.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl2.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl2.setMethod("Fulfillment Method");
    fulfillmentGroupImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl2.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl2.setPhone(new PhoneImpl());
    fulfillmentGroupImpl2.setPrimary(true);
    fulfillmentGroupImpl2.setReferenceNumber("42");
    fulfillmentGroupImpl2.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl2.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl2.setSequence(1);
    fulfillmentGroupImpl2.setService("Service");
    fulfillmentGroupImpl2.setShippingOverride(true);
    fulfillmentGroupImpl2.setShippingPrice(new Money());
    fulfillmentGroupImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl2.setTotal(new Money());
    fulfillmentGroupImpl2.setTotalFeeTax(new Money());
    fulfillmentGroupImpl2.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl2.setTotalItemTax(new Money());
    fulfillmentGroupImpl2.setTotalTax(new Money());
    fulfillmentGroupImpl2.setType(FulfillmentType.DIGITAL);

    // Act and Assert
    assertNotEquals(fulfillmentGroupImpl, fulfillmentGroupImpl2);
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);

    // Act and Assert
    assertNotEquals(fulfillmentGroupImpl, null);
  }

  /**
   * Method under test: {@link FulfillmentGroupImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);

    // Act and Assert
    assertNotEquals(fulfillmentGroupImpl, "Different type to FulfillmentGroupImpl");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentGroupImpl#setAddress(Address)}
   *   <li>{@link FulfillmentGroupImpl#setCandidateFulfillmentGroupOffer(List)}
   *   <li>{@link FulfillmentGroupImpl#setDeliveryInstruction(String)}
   *   <li>{@link FulfillmentGroupImpl#setFulfillmentGroupAdjustments(List)}
   *   <li>{@link FulfillmentGroupImpl#setFulfillmentGroupFees(List)}
   *   <li>{@link FulfillmentGroupImpl#setFulfillmentGroupItems(List)}
   *   <li>{@link FulfillmentGroupImpl#setFulfillmentOption(FulfillmentOption)}
   *   <li>{@link FulfillmentGroupImpl#setId(Long)}
   *   <li>{@link FulfillmentGroupImpl#setIsShippingPriceTaxable(Boolean)}
   *   <li>{@link FulfillmentGroupImpl#setMethod(String)}
   *   <li>{@link FulfillmentGroupImpl#setOrder(Order)}
   *   <li>{@link FulfillmentGroupImpl#setPersonalMessage(PersonalMessage)}
   *   <li>{@link FulfillmentGroupImpl#setPhone(Phone)}
   *   <li>{@link FulfillmentGroupImpl#setPrimary(boolean)}
   *   <li>{@link FulfillmentGroupImpl#setReferenceNumber(String)}
   *   <li>{@link FulfillmentGroupImpl#setSequence(Integer)}
   *   <li>{@link FulfillmentGroupImpl#setService(String)}
   *   <li>{@link FulfillmentGroupImpl#setShippingOverride(Boolean)}
   *   <li>{@link FulfillmentGroupImpl#setTaxes(List)}
   *   <li>{@link FulfillmentGroupImpl#getAddress()}
   *   <li>{@link FulfillmentGroupImpl#getCandidateFulfillmentGroupOffers()}
   *   <li>{@link FulfillmentGroupImpl#getDeliveryInstruction()}
   *   <li>{@link FulfillmentGroupImpl#getFulfillmentGroupAdjustments()}
   *   <li>{@link FulfillmentGroupImpl#getFulfillmentGroupFees()}
   *   <li>{@link FulfillmentGroupImpl#getFulfillmentGroupItems()}
   *   <li>{@link FulfillmentGroupImpl#getFulfillmentOption()}
   *   <li>{@link FulfillmentGroupImpl#getId()}
   *   <li>{@link FulfillmentGroupImpl#getMethod()}
   *   <li>{@link FulfillmentGroupImpl#getOrder()}
   *   <li>{@link FulfillmentGroupImpl#getPersonalMessage()}
   *   <li>{@link FulfillmentGroupImpl#getPhone()}
   *   <li>{@link FulfillmentGroupImpl#getReferenceNumber()}
   *   <li>{@link FulfillmentGroupImpl#getSequence()}
   *   <li>{@link FulfillmentGroupImpl#getService()}
   *   <li>{@link FulfillmentGroupImpl#getTaxes()}
   *   <li>{@link FulfillmentGroupImpl#isPrimary()}
   *   <li>{@link FulfillmentGroupImpl#isShippingPriceTaxable()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    AddressImpl address = new AddressImpl();

    // Act
    fulfillmentGroupImpl.setAddress(address);
    ArrayList<CandidateFulfillmentGroupOffer> candidateOffers = new ArrayList<>();
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(candidateOffers);
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    ArrayList<FulfillmentGroupAdjustment> fulfillmentGroupAdjustments = new ArrayList<>();
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(fulfillmentGroupAdjustments);
    ArrayList<FulfillmentGroupFee> fulfillmentGroupFees = new ArrayList<>();
    fulfillmentGroupImpl.setFulfillmentGroupFees(fulfillmentGroupFees);
    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);
    FulfillmentOptionImpl fulfillmentOption = new FulfillmentOptionImpl();
    fulfillmentGroupImpl.setFulfillmentOption(fulfillmentOption);
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    Order order = NullOrderFactoryImpl.NULL_ORDER;
    fulfillmentGroupImpl.setOrder(order);
    PersonalMessageImpl personalMessage = new PersonalMessageImpl();
    fulfillmentGroupImpl.setPersonalMessage(personalMessage);
    PhoneImpl phone = new PhoneImpl();
    fulfillmentGroupImpl.setPhone(phone);
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    ArrayList<TaxDetail> taxes = new ArrayList<>();
    fulfillmentGroupImpl.setTaxes(taxes);
    Address actualAddress = fulfillmentGroupImpl.getAddress();
    List<CandidateFulfillmentGroupOffer> actualCandidateFulfillmentGroupOffers = fulfillmentGroupImpl
        .getCandidateFulfillmentGroupOffers();
    String actualDeliveryInstruction = fulfillmentGroupImpl.getDeliveryInstruction();
    List<FulfillmentGroupAdjustment> actualFulfillmentGroupAdjustments = fulfillmentGroupImpl
        .getFulfillmentGroupAdjustments();
    List<FulfillmentGroupFee> actualFulfillmentGroupFees = fulfillmentGroupImpl.getFulfillmentGroupFees();
    List<FulfillmentGroupItem> actualFulfillmentGroupItems = fulfillmentGroupImpl.getFulfillmentGroupItems();
    FulfillmentOption actualFulfillmentOption = fulfillmentGroupImpl.getFulfillmentOption();
    Long actualId = fulfillmentGroupImpl.getId();
    String actualMethod = fulfillmentGroupImpl.getMethod();
    Order actualOrder = fulfillmentGroupImpl.getOrder();
    PersonalMessage actualPersonalMessage = fulfillmentGroupImpl.getPersonalMessage();
    Phone actualPhone = fulfillmentGroupImpl.getPhone();
    String actualReferenceNumber = fulfillmentGroupImpl.getReferenceNumber();
    Integer actualSequence = fulfillmentGroupImpl.getSequence();
    String actualService = fulfillmentGroupImpl.getService();
    List<TaxDetail> actualTaxes = fulfillmentGroupImpl.getTaxes();
    boolean actualIsPrimaryResult = fulfillmentGroupImpl.isPrimary();
    Boolean actualIsShippingPriceTaxableResult = fulfillmentGroupImpl.isShippingPriceTaxable();

    // Assert that nothing has changed
    assertTrue(actualPersonalMessage instanceof PersonalMessageImpl);
    assertTrue(actualPhone instanceof PhoneImpl);
    assertEquals("42", actualReferenceNumber);
    assertEquals("Delivery Instruction", actualDeliveryInstruction);
    assertEquals("Fulfillment Method", actualMethod);
    assertEquals("Service", actualService);
    assertEquals(1, actualSequence.intValue());
    assertTrue(actualCandidateFulfillmentGroupOffers.isEmpty());
    assertTrue(actualFulfillmentGroupAdjustments.isEmpty());
    assertTrue(actualFulfillmentGroupFees.isEmpty());
    assertTrue(actualFulfillmentGroupItems.isEmpty());
    assertTrue(actualIsPrimaryResult);
    assertTrue(actualIsShippingPriceTaxableResult);
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualId.longValue());
    assertSame(candidateOffers, actualCandidateFulfillmentGroupOffers);
    assertSame(fulfillmentGroupAdjustments, actualFulfillmentGroupAdjustments);
    assertSame(fulfillmentGroupFees, actualFulfillmentGroupFees);
    assertSame(fulfillmentGroupItems, actualFulfillmentGroupItems);
    assertSame(taxes, actualTaxes);
    assertSame(fulfillmentOption, actualFulfillmentOption);
    assertSame(personalMessage, actualPersonalMessage);
    assertSame(address, actualAddress);
    assertSame(phone, actualPhone);
    assertSame(order, actualOrder);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link FulfillmentGroupImpl}
   */
  @Test
  public void testNewFulfillmentGroupImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    FulfillmentGroupImpl actualFulfillmentGroupImpl = new FulfillmentGroupImpl();

    // Assert
    assertNull(actualFulfillmentGroupImpl.shippingOverride);
    assertNull(actualFulfillmentGroupImpl.getSequence());
    assertNull(actualFulfillmentGroupImpl.getId());
    assertNull(actualFulfillmentGroupImpl.getDeliveryInstruction());
    assertNull(actualFulfillmentGroupImpl.getMethod());
    assertNull(actualFulfillmentGroupImpl.getReferenceNumber());
    assertNull(actualFulfillmentGroupImpl.getService());
    assertNull(actualFulfillmentGroupImpl.status);
    assertNull(actualFulfillmentGroupImpl.type);
    assertNull(actualFulfillmentGroupImpl.fulfillmentPrice);
    assertNull(actualFulfillmentGroupImpl.merchandiseTotal);
    assertNull(actualFulfillmentGroupImpl.retailFulfillmentPrice);
    assertNull(actualFulfillmentGroupImpl.saleFulfillmentPrice);
    assertNull(actualFulfillmentGroupImpl.total);
    assertNull(actualFulfillmentGroupImpl.totalFeeTax);
    assertNull(actualFulfillmentGroupImpl.totalFulfillmentGroupTax);
    assertNull(actualFulfillmentGroupImpl.totalItemTax);
    assertNull(actualFulfillmentGroupImpl.totalTax);
    assertNull(actualFulfillmentGroupImpl.getFulfillmentPrice());
    assertNull(actualFulfillmentGroupImpl.getMerchandiseTotal());
    assertNull(actualFulfillmentGroupImpl.getRetailFulfillmentPrice());
    assertNull(actualFulfillmentGroupImpl.getRetailShippingPrice());
    assertNull(actualFulfillmentGroupImpl.getSaleFulfillmentPrice());
    assertNull(actualFulfillmentGroupImpl.getSaleShippingPrice());
    assertNull(actualFulfillmentGroupImpl.getShippingPrice());
    assertNull(actualFulfillmentGroupImpl.getTotal());
    assertNull(actualFulfillmentGroupImpl.getTotalFeeTax());
    assertNull(actualFulfillmentGroupImpl.getTotalFulfillmentGroupTax());
    assertNull(actualFulfillmentGroupImpl.getTotalItemTax());
    assertNull(actualFulfillmentGroupImpl.getTotalTax());
    assertNull(actualFulfillmentGroupImpl.getFulfillmentOption());
    assertNull(actualFulfillmentGroupImpl.getOrder());
    assertNull(actualFulfillmentGroupImpl.getPersonalMessage());
    assertNull(actualFulfillmentGroupImpl.getStatus());
    assertNull(actualFulfillmentGroupImpl.getType());
    assertNull(actualFulfillmentGroupImpl.getAddress());
    assertNull(actualFulfillmentGroupImpl.getPhone());
    assertFalse(actualFulfillmentGroupImpl.getShippingOverride());
    assertFalse(actualFulfillmentGroupImpl.isPrimary());
    assertFalse(actualFulfillmentGroupImpl.isShippingPriceTaxable());
    assertTrue(actualFulfillmentGroupImpl.getCandidateFulfillmentGroupOffers().isEmpty());
    assertTrue(actualFulfillmentGroupImpl.getDiscreteOrderItems().isEmpty());
    assertTrue(actualFulfillmentGroupImpl.getFulfillmentGroupAdjustments().isEmpty());
    assertTrue(actualFulfillmentGroupImpl.getFulfillmentGroupFees().isEmpty());
    assertTrue(actualFulfillmentGroupImpl.getFulfillmentGroupItems().isEmpty());
    assertTrue(actualFulfillmentGroupImpl.getFutureCreditFulfillmentGroupAdjustments().isEmpty());
    assertTrue(actualFulfillmentGroupImpl.getTaxes().isEmpty());
  }
}
